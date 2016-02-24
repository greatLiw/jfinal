package demo.controller;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;

import demo.interceptor.classes.AuthInterceptor;
import demo.interceptor.global.GlobalActionInterceptor;
import demo.interceptor.method.MethodInterceptor;
import demo.service.UserService;

//login方法需要移除该权限拦截器才能正常登录
@Before(AuthInterceptor.class)
public class UserController extends Controller {
	// AuthInterceptor 已被Clear清除掉，不会被其拦截
	@Clear
	@Before(MethodInterceptor.class)
	public void login() {
		// Global、 Class级别的拦截器将被清除，但本方法上声明的MethodInterceptor不受影响
		renderText("login");
	}

	@Clear({ GlobalActionInterceptor.class, AuthInterceptor.class })
	// 清除指定的拦截器GlobalActionInterceptor与AuthInterceptor
	@Before(AuthInterceptor.class)
	public void show() {
		// 虽然Clear注解中指定清除AuthInterceptor，但她无法被清除，因为Method级的拦截器无法被清除
		renderText("show");
	}
	
	public void toRegister(){
		render("/register.jsp");
	}
	
	public void register(){
		UserService userService = enhance(UserService.class);
		userService.createUser(getPara("name"), getParaToInt("age"));
		renderText("register success!");
	}
}
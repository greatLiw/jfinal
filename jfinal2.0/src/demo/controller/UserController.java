package demo.controller;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;

import demo.interceptor.classes.AuthInterceptor;
import demo.interceptor.global.GlobalActionInterceptor;
import demo.interceptor.method.MethodInterceptor;
import demo.service.UserService;

//login������Ҫ�Ƴ���Ȩ������������������¼
@Before(AuthInterceptor.class)
public class UserController extends Controller {
	// AuthInterceptor �ѱ�Clear����������ᱻ������
	@Clear
	@Before(MethodInterceptor.class)
	public void login() {
		// Global�� Class������������������������������������MethodInterceptor����Ӱ��
		renderText("login");
	}

	@Clear({ GlobalActionInterceptor.class, AuthInterceptor.class })
	// ���ָ����������GlobalActionInterceptor��AuthInterceptor
	@Before(AuthInterceptor.class)
	public void show() {
		// ��ȻClearע����ָ�����AuthInterceptor�������޷����������ΪMethod�����������޷������
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
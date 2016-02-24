package demo.controller;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.ehcache.CacheInterceptor;
import com.jfinal.plugin.ehcache.CacheName;

import demo.interceptor.classes.ClassInterceptor;
import demo.interceptor.method.Method2Interceptor;
import demo.interceptor.method.MethodInterceptor;
import demo.model.Blog;
import demo.model.User;

//配置一个Class级别的拦截器，她将拦截本类中的所有方法
@Before(ClassInterceptor.class)
public class BlogController extends Controller {
	public void save() {
		// 页面的modelName正好是Blog类名的首字母小写
		Blog blog = getModel(Blog.class);
		
		// 如果表单域的名称为 "otherName.title"可加上一个参数来获取
		//blog = getModel(Blog.class, "otherName");
		
		renderText("blog title="+blog.getStr("title")+", content="+blog.getStr("content"));
	}
	
	// 配置多个Method级别的拦截器， 仅拦截本方法
	@Before({MethodInterceptor.class, Method2Interceptor.class})
	public void index() {
		renderJsp("/blog/index.jsp");
	}
	// 未配置Method级别拦截器， 但会被Class级别拦截器AaaInter所拦截
	public void show() {
	}
	
//	@Before(CacheInterceptor.class)
//	@CacheName("blogList")
	public void list() {
	List<Blog> blogList = Blog.dao.find("select * from blog");
	User user = User.dao.findById(1);
	setAttr("blogList", blogList);
	setAttr("user", user);
	render("/blog.jsp");
	}
}
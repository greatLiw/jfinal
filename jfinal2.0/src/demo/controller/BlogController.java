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

//����һ��Class��������������������ر����е����з���
@Before(ClassInterceptor.class)
public class BlogController extends Controller {
	public void save() {
		// ҳ���modelName������Blog����������ĸСд
		Blog blog = getModel(Blog.class);
		
		// ������������Ϊ "otherName.title"�ɼ���һ����������ȡ
		//blog = getModel(Blog.class, "otherName");
		
		renderText("blog title="+blog.getStr("title")+", content="+blog.getStr("content"));
	}
	
	// ���ö��Method������������� �����ر�����
	@Before({MethodInterceptor.class, Method2Interceptor.class})
	public void index() {
		renderJsp("/blog/index.jsp");
	}
	// δ����Method������������ ���ᱻClass����������AaaInter������
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
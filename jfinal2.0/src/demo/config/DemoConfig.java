package demo.config;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;

import demo.controller.BlogController;
import demo.controller.HelloController;
import demo.controller.OrderController;
import demo.controller.UserController;
import demo.interceptor.global.GlobalActionInterceptor;
import demo.interceptor.global.GlobalServiceInterceptor;
import demo.model.User;

public class DemoConfig extends JFinalConfig {

	public void configConstant(Constants me) {
		System.out.println("config constant");
		// me.setDevMode(true);
		PropKit.use("config.txt");
		me.setDevMode(PropKit.getBoolean("devMode"));
		me.setViewType(ViewType.JSP);
	}

	public void configRoute(Routes me) {
		System.out.println("config route...");
		me.add("/hello", HelloController.class);
		me.add("/blog", BlogController.class);
		me.add("/user", UserController.class);
		me.add("/order", OrderController.class);
	}

	public void configPlugin(Plugins me) {
		System.out.println("config plugin ...");
		C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://localhost/test",
				"root", "123456");
		me.add(cp);
		 ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		 me.add(arp);
		 arp.addMapping("user", User.class);
		//表的主键名为默认为“id”
		// arp.addMapping("article", "article_id", Article.class);
		 
		 //EhCachePlugin 是 JFinal 集成的缓存插件，
		 //通过使用 EhCachePlugin 可以提高系统的并发 访问速度。
		 me.add(new EhCachePlugin());
	}

	public void configInterceptor(Interceptors me) {
		System.out.println("config interceptor ...");
		// 添加控制层全局拦截器
		me.addGlobalActionInterceptor(new GlobalActionInterceptor());
		// 添加业务层全局拦截器
		me.addGlobalServiceInterceptor(new GlobalServiceInterceptor());
		// 为兼容老版本保留的方法，功能与addGlobalActionInterceptor完全一样
		// me.add(new GlobalActionInterceptor());
	}

	public void configHandler(Handlers me) {
		System.out.println("config handler...");
	}

	@Override
	public void afterJFinalStart() {
		super.afterJFinalStart();
		System.out.println("after jfinal start ...");
	}

	@Override
	public void beforeJFinalStop() {
		// TODO Auto-generated method stub
		super.beforeJFinalStop();
		System.out.println("before jfinal end ...");
	}
}

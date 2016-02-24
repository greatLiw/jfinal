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
		//���������ΪĬ��Ϊ��id��
		// arp.addMapping("article", "article_id", Article.class);
		 
		 //EhCachePlugin �� JFinal ���ɵĻ�������
		 //ͨ��ʹ�� EhCachePlugin �������ϵͳ�Ĳ��� �����ٶȡ�
		 me.add(new EhCachePlugin());
	}

	public void configInterceptor(Interceptors me) {
		System.out.println("config interceptor ...");
		// ��ӿ��Ʋ�ȫ��������
		me.addGlobalActionInterceptor(new GlobalActionInterceptor());
		// ���ҵ���ȫ��������
		me.addGlobalServiceInterceptor(new GlobalServiceInterceptor());
		// Ϊ�����ϰ汾�����ķ�����������addGlobalActionInterceptor��ȫһ��
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

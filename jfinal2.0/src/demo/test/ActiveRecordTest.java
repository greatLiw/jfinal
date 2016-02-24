package demo.test;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;

import demo.model.Blog;

public class ActiveRecordTest {
	public static void main(String[] args) {
		DruidPlugin dp = new DruidPlugin("localhost", "userName", "password");
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		arp.addMapping("blog", Blog.class);
		// ��web����Ψһ�Ĳ�ͬ��Ҫ�ֶ�����һ����ز����start()����
		dp.start();
		arp.start();
		// ͨ������򵥵ļ��д��룬����������ʼʹ��
		new Blog().set("title", "title").set("content", "cxt text").save();
		Blog.dao.findById(123);
	}
}
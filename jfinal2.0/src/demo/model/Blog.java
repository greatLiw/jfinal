package demo.model;

import com.jfinal.plugin.activerecord.Model;

//����Model���ڴ�ΪBlog
public class Blog extends Model<Blog> {
	public static final Blog dao = new Blog();
}
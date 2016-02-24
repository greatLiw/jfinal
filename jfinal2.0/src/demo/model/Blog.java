package demo.model;

import com.jfinal.plugin.activerecord.Model;

//定义Model，在此为Blog
public class Blog extends Model<Blog> {
	public static final Blog dao = new Blog();
}
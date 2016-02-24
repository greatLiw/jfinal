package demo.model;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User> {
	//声明的 dao 静态对象是为了方便查询操作而定义的，该对象并不是必须的
	public static final User dao = new User();
}
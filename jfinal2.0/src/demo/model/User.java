package demo.model;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User> {
	//������ dao ��̬������Ϊ�˷����ѯ����������ģ��ö��󲢲��Ǳ����
	public static final User dao = new User();
}
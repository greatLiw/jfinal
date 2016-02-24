package demo.service;

import demo.model.User;

public class UserService {
	public void createUser(String name,int age) {
		new User().set("name", name).set("age", age).save();
	}
}

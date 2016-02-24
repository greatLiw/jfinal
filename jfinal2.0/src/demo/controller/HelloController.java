package demo.controller;

import com.jfinal.core.Controller;

public class HelloController extends Controller {
	public void index() {
		renderText("Hello JFinal World.");
	}
	public void test(){
		System.out.println("this is a test");
		int num = getParaToInt(1);
		renderText("num =" +num);
	}
}
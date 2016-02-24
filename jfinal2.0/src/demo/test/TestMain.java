package demo.test;

import com.jfinal.aop.Duang;
import com.jfinal.aop.Enhancer;

import demo.service.OrderService;

public class TestMain {
	public void main(String[] args) {
		// 使用Duang.duang方法在任何地方对目标进行增强
		OrderService service = Duang.duang(OrderService.class);
		// 调用payment方法时将会触发拦截器
		service.payment(1, 1);
		// 使用Enhancer.enhance方法在任何地方对目标进行增强
//		OrderService service2 = Enhancer.enhance(OrderService.class);
	}
}
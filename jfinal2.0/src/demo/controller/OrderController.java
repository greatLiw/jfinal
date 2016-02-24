package demo.controller;

import com.jfinal.core.Controller;
import demo.service.OrderService;

//定义控制器，控制器提供了enhance系列方法可对目标进行AOP增强
public class OrderController extends Controller {
	public void payment() {
		// 使用 enhance方法对业务层进行增强，使其具有AOP能力
		OrderService service = enhance(OrderService.class);
		// 调用payment方法时将会触发拦截器
//		service.payment(getParaToInt("orderId"), getParaToInt("userId"));
		service.payment(1, 1);
		renderText("payment");
	}
}
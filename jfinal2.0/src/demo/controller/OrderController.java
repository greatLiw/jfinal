package demo.controller;

import com.jfinal.core.Controller;
import demo.service.OrderService;

//������������������ṩ��enhanceϵ�з����ɶ�Ŀ�����AOP��ǿ
public class OrderController extends Controller {
	public void payment() {
		// ʹ�� enhance������ҵ��������ǿ��ʹ�����AOP����
		OrderService service = enhance(OrderService.class);
		// ����payment����ʱ���ᴥ��������
//		service.payment(getParaToInt("orderId"), getParaToInt("userId"));
		service.payment(1, 1);
		renderText("payment");
	}
}
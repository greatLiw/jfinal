package demo.test;

import com.jfinal.aop.Duang;
import com.jfinal.aop.Enhancer;

import demo.service.OrderService;

public class TestMain {
	public void main(String[] args) {
		// ʹ��Duang.duang�������κεط���Ŀ�������ǿ
		OrderService service = Duang.duang(OrderService.class);
		// ����payment����ʱ���ᴥ��������
		service.payment(1, 1);
		// ʹ��Enhancer.enhance�������κεط���Ŀ�������ǿ
//		OrderService service2 = Enhancer.enhance(OrderService.class);
	}
}
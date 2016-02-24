package demo.service;

import com.jfinal.aop.Before;
import com.jfinal.aop.Enhancer;

import demo.interceptor.aop.TransactionInterceptor;

//������Ҫʹ��AOP��ҵ�����
public class OrderService {
	// ��������������
	@Before(TransactionInterceptor.class)
	public void payment(int orderId, int userId) {
		System.out.println("payment service...");
	}

	public void injectDemo() {
		// Ϊenhance�����������������ΪInject����������������е�TransactionInterceptor��ΪInject������
		// Inject ���Զ�Ŀ����ȫ�������Ӧ�� AOP��������Ҫ��ǿ��Ŀ���� jar ��֮�У��޷�ʹ�� Before
		// ע�������������������ʱʹ�� Inject���������Զ� jar ���е�Ŀ�������ǿ��
		OrderService service = Enhancer.enhance(OrderService.class,
				TransactionInterceptor.class);
		service.payment(1, 1);
	}
}

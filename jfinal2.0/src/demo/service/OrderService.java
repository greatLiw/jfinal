package demo.service;

import com.jfinal.aop.Before;
import com.jfinal.aop.Enhancer;

import demo.interceptor.aop.TransactionInterceptor;

//定义需要使用AOP的业务层类
public class OrderService {
	// 配置事务拦截器
	@Before(TransactionInterceptor.class)
	public void payment(int orderId, int userId) {
		System.out.println("payment service...");
	}

	public void injectDemo() {
		// 为enhance方法传入的拦截器称为Inject拦截器，下面代码中的TransactionInterceptor称为Inject拦截器
		// Inject 可以对目标完全无侵入地应用 AOP。假如需要增强的目标在 jar 包之中，无法使用 Before
		// 注解对其配置拦截器，此时使用 Inject拦截器可以对 jar 包中的目标进行增强。
		OrderService service = Enhancer.enhance(OrderService.class,
				TransactionInterceptor.class);
		service.payment(1, 1);
	}
}

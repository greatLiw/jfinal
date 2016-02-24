package demo.interceptor.aop;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class TransactionInterceptor implements Interceptor{

	@Override
	public void intercept(Invocation inv) {
		System.out.println("Before transaction interceptor...");
		inv.invoke();
		System.out.println("After transaction interceptor...");
	}

}

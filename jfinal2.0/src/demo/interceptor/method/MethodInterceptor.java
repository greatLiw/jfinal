package demo.interceptor.method;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class MethodInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		System.out.println("Before method interceptor...");
		inv.invoke();
		System.out.println("After method interceptor...");
	}

}

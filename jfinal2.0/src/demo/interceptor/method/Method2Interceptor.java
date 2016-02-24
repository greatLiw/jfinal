package demo.interceptor.method;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class Method2Interceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		System.out.println("Before method2 interceptor...");
		inv.invoke();
		System.out.println("After method2 interceptor...");
	}

}

package demo.interceptor.global;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class GlobalActionInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		System.out.println("Before global action interceptor...");
		inv.invoke();
		System.out.println("After global action interceptor...");
		
	}

}

package demo.interceptor.classes;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class ClassInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		System.out.println("Before class interceptor...");
		inv.invoke();
		System.out.println("After class interceptor...");
	}

}

package demo.interceptor.classes;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class AuthInterceptor implements Interceptor{

	@Override
	public void intercept(Invocation inv) {
		System.out.println("Before auth class interceptor...");
		inv.invoke();
		System.out.println("After auth class interceptor...");
	}

}

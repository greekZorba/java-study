package com.zorba.study.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * 인터페이스가 아닌 클래스로 프록시를 만들고 싶을 때,
 * 그러나 상속 불가한 클래스에는 적용 안됨
 * */
public class ClassProxyTest {

    @Test
    public void proxy() {
        MethodInterceptor handler = new MethodInterceptor() {
            DeskService deskService = new DeskService();
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                if (method.getName().equals("announce")) {
                    System.out.println("aaaaa");
                    Object invoke = method.invoke(deskService, args);
                    System.out.println("bbbbb");
                    return invoke;
                }

                return method.invoke(deskService, args);
            }
        };
        DeskService deskService = (DeskService) Enhancer.create(DeskService.class, handler);

        deskService.announce();
    }
}

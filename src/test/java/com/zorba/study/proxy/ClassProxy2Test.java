package com.zorba.study.proxy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class ClassProxy2Test {

    @Test
    public void proxy() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<? extends DeskService> proxyClass = new ByteBuddy().subclass(DeskService.class)
                .method(named("announce")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    DeskService deskService = new DeskService();
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        System.out.println("aaaaa");
                        Object invoke = method.invoke(deskService, objects);
                        System.out.println("bbbb ");
                        return invoke;
                    }
                }))
                .make().load(DeskService.class.getClassLoader()).getLoaded();

        DeskService deskService = proxyClass.getConstructor(null).newInstance();

        deskService.announce();
    }
}

package com.star.tank.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        final Tank tank = new Tank();
        Moveable m = (Moveable)Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Moveable.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("[log]-"+method.getName()+" start.");
                Object o = method.invoke(tank,args);
                System.out.println("[log]-"+method.getName()+" end.");
                return o;
            }
        });

        m.move();

    }
}

interface Moveable{
    public void move();
}

class Tank implements Moveable{

    @Override
    public void move() {
        System.out.println("tank move tongtongtongtogn......");
    }
}



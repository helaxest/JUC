package com.hyy.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/22  9:21
 * @since
 */
public class Singleton_ {
    private static Singleton_ singleton=new Singleton_();
    private  Singleton_(){

    }

    public Singleton_ getSingleton(){
        return singleton;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton_ singleton = Singleton_.singleton;
        System.out.println(singleton);
        Singleton_ singleton1 = Singleton_.singleton;
        System.out.println(singleton1);
//        Constructor<Singleton_> declaredConstructors = Singleton_.class.getConstructor(null);
//        declaredConstructors.setAccessible(true);
//        Singleton_ singleton_ = declaredConstructors.newInstance();
//        System.out.println(singleton_);

    }
}

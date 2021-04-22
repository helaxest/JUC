package com.hyy.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  17:59
 * @since
 */
public class Stream_ {
    public static void main(String[] args) {
        User u1 = new User("1","2",10);
        User u2 = new User("2","2",9);
        User u3 = new User("3","2",8);
        User u4 = new User("4","2",6);
        User u5 = new User("5","2",5);
        User u6 = new User("6","2",3);
        List<User> list= Arrays.asList(u1,u2,u3,u4,u5,u6);
        Stream<User> stream = list.stream();
       stream.filter(u -> u.getAge() % 2 == 0)
               .map(u->u.getName().toLowerCase(Locale.ROOT))
               .forEach(System.out::println);


    }
}

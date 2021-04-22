package com.hyy.function;

import java.nio.charset.StandardCharsets;
import java.util.function.Function;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  17:36
 * @since
 */
public class FunctionInterface_ {
    //java.util.function*
    public static void main(String[] args) {
//        Function<Integer,String> function=new Function<Integer,String>() {
//            @Override
//            public String apply(Integer o) {
//                if(o==1){
//                    return  "o.toString()";
//                }
//                return  o.toString();
//            }
//        };

        Function<Integer,String> function= o -> {
            if(o==1){
                return  "o.toString()";
            }
            return  o.toString();
        };
        System.out.println(function.apply(1));
    }

}

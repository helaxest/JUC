package com.hyy.unsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  12:57
 * @since
 */
public class Collections_ {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Object> arrayList = new CopyOnWriteArrayList<>();
        List<String> list = Collections.synchronizedList(new LinkedList<>());

        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        CopyOnWriteArraySet<Object> set1 = new CopyOnWriteArraySet<>();

        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();



    }
}

package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.sampleArrayList();
        main.sampleHashSet();
        main.sampleHashMap();
    }

    public void sampleArrayList(){
        //will store the values like array
        ArrayList<String> list =new ArrayList<>();
        list.add("test");
        list.add("testasdfadf");
        System.out.println(list);

    }

    public void sampleHashSet(){
        //will not allow the duplicates
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("test");
        hashSet.add("testasdf");
        hashSet.add("test");//will not allow for the duplicates
        System.out.println(hashSet);
    }

    public void sampleHashMap(){
        //need to store the values with key and value
        HashMap<Integer,String> mapObj = new HashMap<>();
        mapObj.put(1,"adsfadsf");
        mapObj.put(2,"adsfadsasdff");
        mapObj.put(2,"adsfadsf");
        System.out.println(mapObj);
    }
}
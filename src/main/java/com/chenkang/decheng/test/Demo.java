package com.chenkang.decheng.test;

import java.util.ArrayList;
import java.util.List;

public class Demo {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(43);
        System.out.println(isConsecutiveThree(list));
    }


    //判断是否三个连续得
    public static  Boolean isConsecutiveThree(List<Integer> numArr){
        Integer init=numArr.get(0);
        Integer count=0;
        for (int i = 0; i <numArr.size() ; i++) {
            if(numArr.get(i)==init){
                count++;
                if(count>=2){
                    return Boolean.TRUE;
                }
            }else {
                count=0;
                init=numArr.get(i);
            }
        }
        return Boolean.FALSE;
    }
}

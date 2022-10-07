package cn.com.pzliu.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全排列
 */
public class FullArrangement {


    public List<List<Integer>> cal(List<Integer> list){
        ArrayList<List<Integer>> result = new ArrayList<>();

        if (list.size() == 1){
            return Arrays.asList(list);
        }


        for (Integer num : list) {
            List<Integer> collect = list.stream().filter(x -> !x.equals(num)).collect(Collectors.toList());
            if (!collect.isEmpty()){
                List<List<Integer>> subArrangement = cal(collect);
                subArrangement.forEach(l->{
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(num);
                    subResult.addAll(l);
                    result.add(subResult);
                });
            }
        }

        return result;
    }


    public static void main(String[] args) {
        FullArrangement fullArrangement = new FullArrangement();
        System.out.println(fullArrangement.cal(Arrays.asList(1, 2)));
        System.out.println(fullArrangement.cal(Arrays.asList(1, 2,3)));
        System.out.println(fullArrangement.cal(Arrays.asList(1, 2,3,4)));
    }

}

package com.anoshsulg.java.stringman;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Combinations {


    public static void main(String[] args) {

        String target = "abc";
        System.out.println(mixItUp(target));

    }


    private static List<String> mixItUp(String tar) {
        return allCombinations(tar.charAt(0), tar.substring(1), new ArrayList<>());
    }

    private static List<String> allCombinations(char add, String tar, List<String> accumulator) {

        System.out.println(" CHAR : " + add + " , STRING : " + tar + " , LIST : " + accumulator);
        if (tar == null || tar.isEmpty()) {
            accumulator.add(String.valueOf(add));
            return Arrays.asList(String.valueOf(add));
        }

        List<String> result = allCombinations(tar.charAt(0), tar.substring(1), accumulator);
        // get the add and inserted it at all indexes to form a list

        List<String> posarr = result.stream().map( a -> multiInsert(add, a )).flatMap(a -> a.stream()).collect(Collectors.toList());
        System.out.println(" after merging with each  " + posarr) ;
        //accumulator.addAll(posarr);

        return posarr;
    }

    private static List<String> multiInsert(char add, String tar) {
        System.out.println(" add " + add + " " + tar);
        List<String> result = new ArrayList<>();
        int len = tar.length();

        String in = String.valueOf(add);

        // insert at -1


        for (int i = 0; i < len; i++) {
            System.out.println(" creating  " + i + " : " + tar.substring(0, i) + in + tar.substring(i));
            result.add(tar.substring(0, i) + in + tar.substring(i));
        }
        result.add(tar + in);

        System.out.println(" result : " + result);
        return result;
    }

}

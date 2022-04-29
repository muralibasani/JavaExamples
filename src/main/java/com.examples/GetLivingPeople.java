package com.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GetLivingPeople {
    public static void main(String[] args) {
        int[][] peopleList = { {1901, 1935}, {1922, 1947}, {1974, 2015}, {1935, 2020}, { 2000, 2020}};

        HashMap<Integer, Integer> peopleMap = new HashMap<>();

        int tempMin, tempMax;

        for (int i = 0; i < peopleList.length; i++) {
            for (int j = 0; j < peopleList[i].length; j++) {
                peopleMap.put(peopleList[i][j], peopleList[i][j+1]);
                break;
            }
        }

        System.out.println(peopleMap);
        int birth, death, birthNew, deathNew;
        int countLives = 0;
        ArrayList<Integer> countList = new ArrayList<>();
        HashMap<String, Integer> finalMap = new HashMap<>();

        for (Map.Entry<Integer, Integer> integerIntegerEntry : peopleMap.entrySet()) {
            birth = integerIntegerEntry.getKey();
            death = integerIntegerEntry.getValue();
            finalMap.put("birth"+birth, 0);
            for (Map.Entry<Integer, Integer> integerEntry : peopleMap.entrySet()) {
                birthNew = integerEntry.getKey();
                deathNew = integerEntry.getValue();

                if(birth == birthNew && death == deathNew){
                    // ignore
                }else{
                    if((birthNew >= birth && birthNew <= death) || ((deathNew > birth && deathNew < death))) {
                        int count = finalMap.get("birth" + birth);
                        ++count;
                        finalMap.put("birth" + birth, count);
                    }
                }
            }
        }

        System.out.println(finalMap);
        Collection<Integer> values = finalMap.values();
        Integer max = Collections.max(values);
        System.out.println(max);
    }

}

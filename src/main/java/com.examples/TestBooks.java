package com.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class TestBooks {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> userBooks = new HashMap<>();
        HashMap<String, ArrayList<String>> genreBooks = new HashMap<>();

        HashMap<String, ArrayList<String>> finalListMap = new HashMap<>();

        getData(userBooks, genreBooks);

        Set<String> userKeySet = userBooks.keySet();
        Set<String> genreKeySet = genreBooks.keySet();

        for (String userKey : userKeySet) {
            ArrayList<String> userListLocal = userBooks.get(userKey);
            ArrayList<String> a = new ArrayList<>();
            for (String genreKey : genreKeySet) {
                ArrayList<String> genreListLocal = genreBooks.get(genreKey);
                if(userListLocal.stream().anyMatch(genreListLocal::contains)){
                    a.add(genreKey);
                }
            }
            finalListMap.put(userKey, a);
        }

        System.out.println(finalListMap);

    }

    private static void getData(HashMap<String, ArrayList<String>> userBooks, HashMap<String, ArrayList<String>> genreBooks) {
        ArrayList<String> userList= new ArrayList<>();
        userList.add("book1");
        userList.add("book12");
        userList.add("book3");
        userList.add("book14");
        userList.add("book15");

        ArrayList<String> userList1= new ArrayList<>();
        userList1.add("book6");
        userList1.add("book7");

        userBooks.put("Skylar", userList);
        userBooks.put("Lily", userList1);

        ArrayList<String> genreList= new ArrayList<>();

        genreList.add("book3");
        genreList.add("book4");
        genreList.add("book5");

        ArrayList<String> genreList1= new ArrayList<>();
        genreList1.add("book7");

        genreBooks.put("Classics", genreList);
        genreBooks.put("Winy", genreList1);
    }
}

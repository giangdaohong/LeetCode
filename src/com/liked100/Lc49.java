package com.liked100;

import java.util.*;

public class Lc49 {
    public static void main(String[] args) {
        String[] strs = {"abc", "bca", "acb", "abc", "abc", "abc"};
        new Lc49().groupAnagrams(strs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String st : strs) {
            char[] ch = st.toCharArray();
            Arrays.sort(ch);
            String key =  new String(ch);
            List<String> val = map.getOrDefault(key, new ArrayList<>());
            val.add(st);
            map.put(key, val);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> ls: map.values()) {
            res.add(ls);
        }
        return res;
    }
}

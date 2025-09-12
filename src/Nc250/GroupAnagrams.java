package Nc250;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> groupedStringsMap = new HashMap<>();

        for(String str : strs) {
            char[] wordArray = str.toCharArray();
            Arrays.sort(wordArray);
            String sortedString = new String(wordArray);
            List<String> stringList = groupedStringsMap.getOrDefault(sortedString, new ArrayList<>());
            stringList.add(str);
            groupedStringsMap.put(sortedString, stringList);
        }

        /*List<List<String>> groupAnagramsList = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : groupedStringsMap.entrySet()) {
            groupAnagramsList.add(entry.getValue());
        }*/

        return new ArrayList<>(groupedStringsMap.values());
    }
}

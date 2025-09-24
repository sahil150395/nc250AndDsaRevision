package Nc250.TwoPointers;

public class MergeStringsAlternately {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab", "abbxxc"));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        int p1 = 0, p2 = 0;

        while (p1 < word1.length() && p2 < word2.length()) {
            result.append(word1.charAt(p1)).append(word2.charAt(p2));
            p1++;
            p2++;
        }


        result.append(word1.substring(p1));

        result.append(word2.substring(p2));


        return result.toString();
    }
}

package Nc250.ArraysAndHashing;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;

            while (j < Math.min(prefix.length(), strs[i].length())) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                j++;
            }
            prefix = prefix.substring(0, j);
        }

        return prefix;
    }
}

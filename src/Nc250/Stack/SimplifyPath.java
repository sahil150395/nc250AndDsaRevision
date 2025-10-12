package Nc250.Stack;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/neetcode/practice//...///../courses"));
        System.out.println(simplifyPath("/..//"));
        System.out.println(simplifyPath("/..//_home/a/b/..///"));
    }

    public static String simplifyPath(String path) {

        Stack<String> fileNames = new Stack<>();
        StringBuilder current = new StringBuilder();


        /*
         * So why add a "/" to the end?Because it ensures that the last segment gets processed.
         * Without that extra slash, the algorithm wouldn’t process the last folder unless the input already ended with /.
         * */
        for (char c : (path + "/").toCharArray()) {

            if (c == '/') {
                /*
                 * 1. when we encounter a /, means a new file name has started
                 * 2. when we encounter a '..', menas we need to move a directory up i.e. out
                 * of the current directory, and if the fileNames stack is not empty we pop
                 * the name of the last file present
                 * */
                if (current.toString().equals("..")) {
                    if (!fileNames.isEmpty()) fileNames.pop();
                } else if (!current.toString().equals("") && !current.toString().equals(".")) {
                    // means the current stringbuilder object is not empty or a sigle '.' charcater that can be ignored
                    // in other words it is a legit file name
                    fileNames.push(current.toString());
                }

                /*
                 * The setLength() method in a StringBuilder is used to modify the
                 * length of the character sequence it contains.
                 * */
                current.setLength(0);
            } else {
                current.append(c); // this builds the name of the file character by character
            }


        }

        /*
         * The String.join() method in Java, introduced in Java 8, provides a convenient way to
         * concatenate multiple strings with a specified delimiter. It is a static method of the String class.
         * */
        return "/" + String.join("/", fileNames);
    }
}

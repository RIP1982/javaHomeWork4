/* Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического
выражения.

5*6+2-9 -> 56*29-+
 */

import java.util.*;
import java.util.logging.Logger;

public class Task4 {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        System.out.printf("Input infix example: ");
        String infixExp = (new Scanner(System.in)).nextLine();
        logger.info(infixExp);
        logger.info((postfixExp(infixExp)));
    }

    public static String postfixExp(String exp) {
        char[] charsInfixExp = exp.toCharArray();
        Stack<Character> stackSign = new Stack<>();
        Map<String, Integer> dict = new HashMap<>();
        dict.put("*", 2);
        dict.put("/", 2);
        dict.put("+", 1);
        dict.put("-", 1);
        String postfix = "";
        int count = 0;
        for (int i = 0; i < charsInfixExp.length; i++) {
            if (!isNumber(charsInfixExp[i])) {
                if (dict.get(String.valueOf(charsInfixExp[i])) == 2) {
                    if (stackSign.size() > 1) {
                        postfix += stackSign.pop().toString();
                        stackSign.push(charsInfixExp[i]);
                    } else {
                        stackSign.push(charsInfixExp[i]);
                    }

                } else {
                    if (stackSign.size() > 0) {
                        postfix += stackSign.pop().toString();
                        stackSign.push(charsInfixExp[i]);
                    } else {
                        stackSign.push(charsInfixExp[i]);
                    }
                }
            } else {
                postfix += charsInfixExp[i];
            }
        }
        for (int i = 0; i < stackSign.size(); i++) {
            postfix += stackSign.pop().toString();
        }
        return postfix;
    }

    public static Boolean isNumber(Character string) {
        try {
            Integer num = Integer.parseInt(String.valueOf(string));
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}

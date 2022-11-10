/* Пусть дан LinkedList с несколькими элементами. Реализуйте метод,
который вернет “перевернутый” список.
*/

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Task1 {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        Boolean trigger = true;
        List<String> someLst = new LinkedList<>();
        while (trigger == true) {
            System.out.printf("Input eelement: ");
            String words = (new Scanner(System.in).nextLine());
            if (words.equals("exit")) {
                trigger = false;
                logger.info(someLst.toString());
                Collections.reverse(someLst);
                logger.info(someLst.toString());
            } else {
                someLst.add(words);
            }
        }
    }
}
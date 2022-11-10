/* Реализуйте очередь с помощью LinkedList со следующими методами:enqueue() - помещает элемент
в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его, first() -
возвращает первый элемент из очереди, не удаляя.
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Logger;

public class Task2 {
    public static void main(String[] args) {
        Deque<String> linkedList = new LinkedList<>();
        Logger logger = Logger.getAnonymousLogger();
        Boolean trigger = true;
        System.out.println("Input  element or command(enqueue, dequeue, first or exit): ");
        while (trigger == true) {
            String words = (new Scanner(System.in)).nextLine();
            if (words.equals("exit")) {
                trigger = false;
            } else if (words.equals("enqueue")) {
                logger.info(linkedList.toString());
                System.out.printf("Input  element: ");
                logger.info(Enqueue(linkedList).toString());
            } else if (words.equals("dequeue")) {
                logger.info(linkedList.toString());
                logger.info(Dequeue(linkedList).toString());
            } else if (words.equals("first")) {
                logger.info(linkedList.toString());
                logger.info(First(linkedList).toString());
            } else {
                linkedList.add(words);
            }
        }
    }
    static Deque<String> Enqueue(Deque<String> someLst) {
        String words = (new Scanner(System.in)).nextLine();
        someLst.addFirst(words);
        return someLst;
    }
    static Deque<String> Dequeue(Deque<String> someLst) {
        someLst.removeLast();
        return someLst;
    }
    static String First(Deque<String> someLst) {
        return someLst.peekLast();
    }
}

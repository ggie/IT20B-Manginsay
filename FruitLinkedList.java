package midterm;

import java.util.LinkedList;

public class FruitLinkedList {

    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();

        fruits.add("Banana");
        fruits.addFirst("Apple");
        fruits.addLast("Mango");
        fruits.add(1, "Orange");

        System.out.println("Linked List Original: " + fruits);
        System.out.println("Size of Linked List: " + fruits.size());

        if (fruits.contains("Orange")) {
            System.out.println("Orange is in the list.");
        } else {
            System.out.println("Orange is not in the list.");
        }

        boolean containsGrapes = fruits.contains("Grapes");
        System.out.println("Contains Grapes: " + containsGrapes);

        fruits.remove(); 
        fruits.removeFirst(); 
        fruits.removeLast(); 
        fruits.remove(0); 

        System.out.println("Linked List After Deletion: " + fruits);
        System.out.println("Size of Linked List After Deletion: " + fruits.size());
    }
}

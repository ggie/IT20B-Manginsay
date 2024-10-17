package midterm;

import java.util.Stack;

public class StringStackExample {

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.push("Java");

        System.out.println("Stack: " + stringStack);

        String topElement = stringStack.pop();
        System.out.println("Popped: " + topElement);
        
        String peekedElement = stringStack.peek();
        System.out.println("Peeked: " + peekedElement);

        boolean isEmpty = stringStack.isEmpty();
        System.out.println("Is Stack Empty? " + isEmpty);

        int stackSize = stringStack.size();
        System.out.println("Stack Size: " + stackSize);

        stringStack.clear();
        System.out.println("Stack after clearing: " + stringStack);
    }
}

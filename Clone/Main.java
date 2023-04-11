import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();

    stack.add(1);
    stack.add(2);
    stack.add(3);
    stack.add(4);
    stack.add(5);

    System.out.println(stack);
    Stack<Integer> newStack = clone(stack);
    System.out.println(newStack);
  }
  private static Stack<Integer> clone(Stack<Integer> stack) {
    Stack<Integer> newStack = new Stack<Integer>();  
    Stack<Integer> temp = new Stack<Integer>();  
    
    while (!stack.isEmpty()) temp.push(stack.pop());
    while (!temp.isEmpty()) {
      int element = temp.pop();

      stack.push(element);
      newStack.push(element);
    }

    return newStack;
  }
}

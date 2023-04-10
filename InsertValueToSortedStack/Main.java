import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(6);
  
    System.out.println("Stack Before Changes: \n" + stack.toString());
    insertValueToSortedStack(stack, 5);
    System.out.println("Stack After Changes: \n" + stack.toString());
  }
  private static void insertValueToSortedStack(Stack<Integer> stack, int value) {
    Stack<Integer> temp = new Stack<Integer>();

    while (stack.peek() > value) temp.push(stack.pop());
    stack.push(value);

    while (!temp.isEmpty()) stack.push(temp.pop());
  }
}

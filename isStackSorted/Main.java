import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();

    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(3);
    stack.push(5);
    stack.push(9);

    System.out.println("The stack before any operation: \n" + stack.toString());
    System.out.printf("The stack is sorted: %b\n", isStackSorted(stack));
    System.out.println("The stack after isStackSorted: \n" + stack.toString());
    stack.push(1);
    System.out.println("The stack after inserting another value: \n" + stack.toString());
    System.out.printf("The stack is sorted: %b\n", isStackSorted(stack));
  }
  private static boolean isStackSorted(Stack<Integer> stack) {
    Stack<Integer> temp = new Stack<Integer>();
    boolean flag = true;

    while (stack.size() > 1) {
      int element = stack.pop();
      if (element < stack.peek()) flag = false;
      temp.push(element);
    }
    while (!temp.isEmpty()) stack.push(temp.pop());
    
    return flag;
  }
}

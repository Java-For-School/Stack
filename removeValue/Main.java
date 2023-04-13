import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    stack.push(7);

    System.out.println(stack);
    removeValue(stack, 2);
    removeValue(stack, 6);
    System.out.println(stack);
  }
  private static void removeValue(Stack<Integer> stack, int value) {
    if (stack.size() == 0) return;
    int element = stack.pop();

    if (element == value) return;

    removeValue(stack, value);

    stack.push(element);
  }
}

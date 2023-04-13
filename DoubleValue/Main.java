import java.util.Stack;

class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    stack.push(7);
    
    System.out.println(stack);
    doubleValue(stack);
    System.out.println(stack);
  }
  private static void doubleValue(Stack<Integer> stack) {
    
    if (stack.size() == 1) {
      stack.push(2 * stack.pop());
      return;
    }
    int element = stack.pop();
    doubleValue(stack);
    stack.push(2 * element);
  }
}

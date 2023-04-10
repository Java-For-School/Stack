import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();

    stack.push(14);
    stack.push(15);
    stack.push(5);
    stack.push(5);
    stack.push(0);
    stack.push(0);
    stack.push(0);
    stack.push(5);
    stack.push(3);
    stack.push(-4);
    stack.push(-4);
    stack.push(15);
    
    System.out.println(stack);
    System.out.println(noBlockStack(stack));
  }
  private static Stack<Integer> noBlockStack(Stack<Integer> stack) {
    Stack<Integer> newStack = new Stack<Integer>();

    while (stack.size() > 1) {
      int element = stack.pop();

      if (element == stack.peek()) {
        while (element == stack.peek()) stack.pop();
        continue;
      }
      
      newStack.push(element);
    }
    newStack.push(stack.pop());
    return newStack;
  }
}

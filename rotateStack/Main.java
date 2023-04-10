import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();

    stack.push(2);
    stack.push(6);
    stack.push(3);
    stack.push(8);
  
    System.out.println(stack);
    rotateStack(stack);
    System.out.println(stack);
  }
  private static void rotateStack(Stack<Integer> stack) { 
    Stack<Integer> temp = new Stack<Integer>();
    int element = stack.pop();

    while (!stack.isEmpty()) temp.push(stack.pop());
    stack.push(element);
    while (!temp.isEmpty()) stack.push(temp.pop());

  }
}

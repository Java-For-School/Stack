import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();

    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    stack.push(7);
    stack.push(8);

    System.out.println(stack);
    System.out.println(lastAndRemove(stack));
    System.out.println(stack);
  }
  private static int lastAndRemove(Stack<Integer> stack) {
    Stack<Integer> temp = new Stack<Integer>();
    
    if (stack.size() == 0) return -1;
    while (stack.size() > 1) {
      temp.push(stack.pop()); 
    }

    int element = stack.pop();
    while (!temp.isEmpty()) stack.push(temp.pop());
    
    return element;
  }
}

package lastAndRemove;

import java.util.Stack;
import lastAndRemove.TwoItems;
public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();

    stack.push(1);
    stack.push(6);
    stack.push(32);
    stack.push(5);
    stack.push(7);
    stack.push(4);
    stack.push(9);

    System.out.println(stackTwoItems(stack));
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
  private static Stack<TwoItems> stackTwoItems(Stack<Integer> stack) {
    Stack<TwoItems> newStack = new Stack<TwoItems>();
    Stack<TwoItems> temp = new Stack<TwoItems>();
    
    while (!stack.isEmpty()) {
      newStack.push(new TwoItems(stack.pop(), lastAndRemove(stack)));
    }
    while (!newStack.isEmpty()) temp.push(newStack.pop());

    return temp;
  }
}

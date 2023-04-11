import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> newStack = new Stack<Integer>();
  
    stack.push(7);
    stack.push(28);
    stack.push(12334);
    stack.push(565);
    stack.push(251);
    stack.push(122);
  
    System.out.println(stack);
    System.out.println(allExist(stack));
    System.out.println(stack);

    
    newStack.push(12334);
    newStack.push(521);
    newStack.push(245);
    newStack.push(1223);
  

    System.out.println(newStack);
    System.out.println(allExist(newStack));
    System.out.println(newStack);
  }
  private static Stack<Integer> cloneStack(Stack<Integer> stack) {
    Stack<Integer> newStack = new Stack<Integer>();
    Stack<Integer> temp = new Stack<Integer>();
  
    while(!stack.isEmpty()) temp.push(stack.pop());
    while(!temp.isEmpty()) {
      int element = temp.pop();

      stack.push(element);
      newStack.push(element);
    }

    return newStack;
  }
  private static boolean isExist(Stack<Integer> stack, int target) {
    Stack<Integer> temp = new Stack<Integer>();
    boolean flag = false;

    while (!stack.isEmpty()) {
      int element = stack.pop();

      if (element % 10 == target) flag = true;
      temp.push(element);
    }

    while (!temp.isEmpty()) stack.push(temp.pop());
    return flag;
  }
  private static int getMostSignificantDigit(int number) {
    while (number / 10 != 0) number /= 10;
    return number;
  }
  private static boolean allExist(Stack<Integer> stack) {
    Stack<Integer> newStack = cloneStack(stack);
    Stack<Integer> temp = new Stack<Integer>();
    boolean flag = true;

    while (!stack.isEmpty()) temp.push(stack.pop());
    while (!temp.isEmpty()) {
      int element = temp.pop();
      
      if (!isExist(newStack, getMostSignificantDigit(element))) flag = false;
      stack.push(element);
    }

    return flag;
  }
}

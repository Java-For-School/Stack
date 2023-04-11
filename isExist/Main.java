import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    int target = 8;
    
    stack.push(77);
    stack.push(568);
    stack.push(251);
    stack.push(162);
  
    System.out.println(stack);
    System.out.println(isExist(stack, 8));
    System.out.println(stack);
    System.out.println(isExist(stack, 9));
    System.out.println(stack);
  }
  private static boolean isExist(Stack<Integer> stack, int target) {
    Stack<Integer> newStack = new Stack<Integer>(); 
    boolean flag = false;

    while (!stack.isEmpty()) {
      int element = stack.pop();

      if (element % 10 == target) flag = true;
      newStack.push(element);
    }
    while (!newStack.isEmpty()) stack.push(newStack.pop());

    return flag;
  }
}

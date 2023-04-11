import java.util.Stack;

public class Main {
  public static void main (String[] args) {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    stack1.push(7);
    stack1.push(6);
    stack1.push(14);
    stack1.push(8);
    stack1.push(12);
    stack1.push(9);
    stack1.push(7);

    stack2.push(11);
    stack2.push(9);
    stack2.push(1);
    stack2.push(4);
    stack2.push(13);
    stack2.push(4);
    stack2.push(8);
    stack2.push(2);

    System.out.println(MaxNearestCouple(stack1, stack2));
  }
  private static boolean doesGreaterSumExist(Stack<Integer> stack, int number) {
    Stack<Integer> temp = new Stack<Integer>(); 
    boolean flag = false;

    while (!stack.isEmpty()) temp.push(stack.pop());
    while (temp.size() > 1) {
      int element = temp.pop();
      int nextElement = temp.peek();
      int sum = element + nextElement; 
      if (sum >= number) flag = true; 
      stack.push(element);
    }
    stack.push(temp.pop());
    return flag;
  }
  private static int MaxNearestCouple(Stack<Integer> stack1, Stack<Integer> stack2) {
    Stack<Integer> temp = new Stack<Integer>(); 
    
    int maxNearestCouple = -1;
    
    while (stack1.size() > 1) {
      int element = stack1.pop();
      temp.push(element);
      if (maxNearestCouple == -1) {
        int nextElement = stack1.peek();
        int sum = element + nextElement;
        if (!doesGreaterSumExist(stack2, sum)) maxNearestCouple = sum;
      } 
    }
    while (!temp.isEmpty()) stack1.push(temp.pop());
    return maxNearestCouple;
  }
}

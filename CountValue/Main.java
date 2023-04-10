import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();

    stack.push(5);
    stack.push(4);
    stack.push(3);
    stack.push(2);
    stack.push(1);
    stack.push(1);
    stack.push(1);
    stack.push(1);

    int element = 1;
    
    System.out.printf("Element: %d appears: %d times.\n", element, countValue(stack, element));
    System.out.println(stack);
  }
  private static int countValue(Stack<Integer> stack, int target) {
    Stack<Integer> temp = new Stack<Integer>();
    int count = 0;

    for (int i = 0; i < stack.size(); i++) {
      int element = stack.pop();

      if (element == target) ++count;
      temp.push(element);
    }

    while (!temp.isEmpty()) stack.push(temp.pop());
  
    return count;
  }
}

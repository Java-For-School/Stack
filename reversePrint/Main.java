import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Character> stack = new Stack<Character>();

    stack.push('@');
    stack.push('v');
    stack.push('e');
    stack.push('n');
    stack.push('@');
    stack.push('@');
    stack.push('i');
    stack.push('m');
    stack.push(' ');
    stack.push('r');
    stack.push('e');
    stack.push('@');
    stack.push('n');
    stack.push('d');
    
    System.out.println(reverse(stack));
  }
  private static String reverseString(String string) {
    String newString = "";
    for (int i = 0; i < string.length(); i++) newString += string.charAt(string.length() - i - 1);
    return newString;
  }
  private static String reverse(Stack<Character> stack) {
    Stack<Character> newStack = new Stack<Character>();
    boolean direction = true;
    String newString = "";
    String temp = "";

    while (!stack.isEmpty()) newStack.push(stack.pop());
    while (!newStack.isEmpty()) {
      while (newStack.size() > 0 && newStack.peek() != '@' && newStack.peek() != 'f') {
        temp += newStack.pop();
      }
      newString += direction ? temp : reverseString(temp);
      direction = !direction;
      temp = "";
      if (newStack.size() > 0) newStack.pop();
    }

    return newString;
  }
}

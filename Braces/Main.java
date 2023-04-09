import java.util.Stack;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {
    String expression = args[0];


    System.out.printf("The expression %s is valid: %b\n", expression, isExpressionValid(expression));
  }
  
  private static boolean doBracesMatch(char open, char close) {
    System.out.printf("Open + Close: %c%c\n", open, close);
    System.out.printf("Open == '(': %b, Close == ')': %b\n", open == '(', close == ')');
    System.out.printf("Open == '[': %b, Close == ']': %b\n", open == '[', close == ']');
    System.out.printf("Open == '{': %b, Close == '}': %b\n", open == '{', close == '}');
    if (open == '(' && close == ')') return true; 
    if (open == '[' && close == ']') return true;
    if (open == '{' && close == '}') return true;

    return false;
  }

  private static boolean isCloseBrace(char brace) {
    return (brace == ')' || brace == ']' || brace == '}');
  }

  private static boolean isOpenBrace(char brace) {
    return (brace == '(' || brace == '[' || brace == '{');
  }
  
  private static boolean isExpressionValid(String expression) {
    Stack<Character> stack = new Stack<Character>();
    
    for (int i = 0; i < expression.length(); i++) {
      char character = expression.charAt(i);
      if (isOpenBrace(character)) stack.push(character);
      if (isCloseBrace(character)) {
        if (stack.isEmpty()) return false;
        if (doBracesMatch(stack.peek(), character)) stack.pop();
        else return false;
      }
    }

    if (stack.isEmpty()) return true;
    return false;
  }
}

import java.util.Stack;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {
    String expression = args[0];
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < expression.length(); i++) {
      char character = expression.charAt(i);
      if (isOpenBrace(character) || isCloseBrace(character)) stack.push(character);
    }

    System.out.printf("The expression %s is valid: %b\n", expression, isExpressionValid(stack));
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

  private static char getLastOpenBrace(Stack<Character> stack) {
    Stack<Character> temp = new Stack<Character>();
    char brace = 'E';
    
    while (!stack.isEmpty()) {
      char currentChar = stack.pop();

      if (isOpenBrace(currentChar) && brace == 'E') { 
        brace = currentChar; 
        continue;
      };
      temp.push(currentChar);
    }
    
    while (!temp.isEmpty()) stack.push(temp.pop());

    return brace;
  }
  private static boolean isExpressionValid(Stack<Character> stack) {
    Stack<Character> temp = new Stack<Character>();

    
    while (!stack.isEmpty()) {
      char element = stack.pop();
      if (isOpenBrace(element)) {
        System.out.println("Failed due to more open brackets");
        return false;
      }
      char lastOpenBrace = getLastOpenBrace(stack);
      if (!doBracesMatch(lastOpenBrace, element)) {
        System.out.println("Last open braces are incorrect");
        return false;
      }
    }

    return true;
  }
}

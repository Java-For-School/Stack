import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    Stack<Integer> stack3 = new Stack<Integer>();
    
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(2);
    stack.push(1);
    stack.push(2);
    
    stack2.push(3);
    stack2.push(7);
    stack2.push(3);
    stack2.push(7);
    stack2.push(3);

    stack3.push(4);
    stack3.push(5);
    stack3.push(6);
    stack3.push(9);
    
    System.out.println("FIRST TEST:");
    System.out.println(stack);
    System.out.println(changeDirectionNumber(stack));
  
    System.out.println("SECOND TEST:");
    System.out.println(stack2);
    System.out.println(changeDirectionNumber(stack2));
    
    System.out.println("THIRD TEST:");
    System.out.println(stack3);
    System.out.println(changeDirectionNumber(stack3));
  }
  private static Stack<Integer> changeDirectionNumber(Stack<Integer> stack) {
    Stack<Integer> newStack = new Stack<Integer>();
    Stack<Integer> temp = new Stack<Integer>();
    
    boolean direction = false;
    int last = 0;
    
    boolean isDirectionInitialised = false;
    boolean isLastInitialised = false;

    while (!stack.isEmpty()) temp.push(stack.pop());
    System.out.println(temp);
    while (!temp.isEmpty()) {
      System.out.println(newStack);
      int element = temp.pop();
      stack.push(element);
      
      if (!isLastInitialised) {
        System.out.println("Initialised last");
        isLastInitialised = true;
        last = element;
        newStack.push(last);
      } 
      else {
        if (!isDirectionInitialised) {
          System.out.println("Initialised direction");
          isDirectionInitialised = true;
          direction = last < element;
          last = element;
          newStack.push(element);
        }
        else {
          System.out.printf("last: %d element: %d\n", last, element);
          if ((direction && last < element) || (!direction && last > element)) newStack.push(element);
          else {
            System.out.printf("The element: %d is a direction changer\n", last);
            direction = !direction;
            newStack.push(last);
            newStack.push(element);
          }

          last = element;
        }
      }
    }

    return newStack;
  }
  //private static Stack<Integer> changeDirectionNumber(Stack<Integer> stack) {
  //  Stack<Integer> newStack = new Stack<Integer>();
  //  Stack<Integer> temp = new Stack<Integer>();
  //  
  //  int lastElement = stack.pop();
  //  int currentElement = stack.peek();
  //  
  //  newStack.push(lastElement);
  //  temp.push(lastElement);
  //  boolean direction = lastElement < currentElement;
  //  
  //  while (stack.size() > 1) {
  //    lastElement = stack.pop();
  //    currentElement = stack.peek();
  //       
  //    temp.push(lastElement);
  //    
  //    if ((lastElement < currentElement && direction) || (lastElement > currentElement && !direction)) {
  //      newStack.push(lastElement);
  //    }
  //    else {
  //      direction = !direction;
  //      newStack.push(lastElement);
  //      newStack.push(lastElement);
  //    }
  //  }
  //  temp.push(stack.pop());
  //  while (!temp.isEmpty()) stack.push(temp.pop());
  //  while (!newStack.isEmpty()) temp.push(newStack.pop());
  //  

  //  return temp;
  //}
}

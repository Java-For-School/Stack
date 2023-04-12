package lastAndRemove;

public class TwoItems {
  
  private int num1;
  private int num2;

  TwoItems(int num1, int num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  public String toString() {
    return String.format("num1: %d, num2: %d", this.num1, this.num2);
  }
} 

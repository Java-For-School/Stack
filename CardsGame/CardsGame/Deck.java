package CardsGame;

import java.util.Random;
import java.util.Stack;

class Deck {
  private Random random = new Random();
  private Stack<Card>[] heaps;
  private int sum;

  public Deck() {
    heaps = new Stack[5];
    sum = 0;

    for (int i = 0; i < heaps.length; i++) {
      heaps[i] = new Stack<Card>();
    }
  }
  public void insert(Card card) {
    heaps[card.getShape()].push(card);
  }

  public boolean move() {
    int shape = 1 + random.nextInt(4);
    
    if (heaps[shape - 1].isEmpty()) return false;
    
    Card card = heaps[shape - 1].pop();
    heaps[5].push(card);

    return true;
  }

  public int sum() {
    Stack<Card> temp = new Stack<Card>();
    int sum = 0;
    while (!heaps[5].isEmpty()) {
      Card element = heaps[5].pop();
      sum += element.getValue();

      temp.push(element);
    }
    while (!temp.isEmpty()) heaps[5].push(temp.pop());

    return sum;
  }

}

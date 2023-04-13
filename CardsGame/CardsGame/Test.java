package CardsGame;

class Test {
  Deck deck;
  public boolean Game(Card[] cards) {
    while (deck.move()) {}
    return (deck.sum() % 100 == 0); 
  }
}

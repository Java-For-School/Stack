package CardsGame;

class Card {
  private int value;
  private int shape;

  public Card(int value, int shape) {
    this.value = value;
    this.shape = shape;
  }

  public int getValue() { return this.value; }
  public int getShape() { return this.shape; }
  public void setValue(int value) { this.value = value; }
  public void setShape(int shape) { this.shape = shape; }
}

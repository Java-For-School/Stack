package Browser.BrowsingHistory;

import java.util.Stack;

class BrowsingHistory {
  private Stack history = new Stack();
  private Stack forward = new Stack();

  public String getCurrentUrl() {
    if (history.isEmpty()) return "History unavailable.";
    return history.peek().getUrl();
  }
  
  public void visit(BrowsingEvent event) { history.push(event); }

  public void goBack() {
    if (history.isEmpty()) return;
    forward.push(history.pop());
  }

  public void goForward() {
    if (forward.isEmpty()) return;
    history.push(forward.pop());
  }

  public override String toString() {
    return "Last Pages: " + history.toString() + "\nNext pages: " + forward.toString();
  }
}

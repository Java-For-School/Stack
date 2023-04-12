package Browser.BrowsingEvent;

class BrowsingEvent {
  private String url;
  private boolean isSecure;
  
  public BrowsingEvent(String url, boolean isSecure) {
    this.url = url;
    this.isSecure = isSecure;
  }

  public String getUrl() { return this.url; }
  public override String toString() {
    String result = url;
    return res + isSecure ? "" : "(URL not secured)";
  }
}

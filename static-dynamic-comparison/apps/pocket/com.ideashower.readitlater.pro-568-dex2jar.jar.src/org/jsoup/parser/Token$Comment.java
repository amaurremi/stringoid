package org.jsoup.parser;

class Token$Comment
  extends Token
{
  boolean bogus = false;
  final StringBuilder data = new StringBuilder();
  
  Token$Comment()
  {
    super(null);
    this.type = Token.TokenType.Comment;
  }
  
  String getData()
  {
    return this.data.toString();
  }
  
  public String toString()
  {
    return "<!--" + getData() + "-->";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/parser/Token$Comment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
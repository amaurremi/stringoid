package org.jsoup.parser;

class Token$Character
  extends Token
{
  private final String data;
  
  Token$Character(String paramString)
  {
    super(null);
    this.type = Token.TokenType.Character;
    this.data = paramString;
  }
  
  String getData()
  {
    return this.data;
  }
  
  public String toString()
  {
    return getData();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/parser/Token$Character.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
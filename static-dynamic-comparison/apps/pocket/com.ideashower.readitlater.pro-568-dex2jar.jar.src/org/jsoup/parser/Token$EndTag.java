package org.jsoup.parser;

class Token$EndTag
  extends Token.Tag
{
  Token$EndTag()
  {
    this.type = Token.TokenType.EndTag;
  }
  
  Token$EndTag(String paramString)
  {
    this();
    this.tagName = paramString;
  }
  
  public String toString()
  {
    return "</" + name() + ">";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/parser/Token$EndTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
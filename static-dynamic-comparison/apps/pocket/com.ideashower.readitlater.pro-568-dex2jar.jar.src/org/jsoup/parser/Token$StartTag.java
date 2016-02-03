package org.jsoup.parser;

import org.jsoup.nodes.Attributes;

class Token$StartTag
  extends Token.Tag
{
  Token$StartTag()
  {
    this.attributes = new Attributes();
    this.type = Token.TokenType.StartTag;
  }
  
  Token$StartTag(String paramString)
  {
    this();
    this.tagName = paramString;
  }
  
  Token$StartTag(String paramString, Attributes paramAttributes)
  {
    this();
    this.tagName = paramString;
    this.attributes = paramAttributes;
  }
  
  public String toString()
  {
    if ((this.attributes != null) && (this.attributes.size() > 0)) {
      return "<" + name() + " " + this.attributes.toString() + ">";
    }
    return "<" + name() + ">";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/parser/Token$StartTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
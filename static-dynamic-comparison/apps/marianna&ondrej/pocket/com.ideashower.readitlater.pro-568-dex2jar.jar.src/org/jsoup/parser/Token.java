package org.jsoup.parser;

abstract class Token
{
  Token.TokenType type;
  
  Token.Character asCharacter()
  {
    return (Token.Character)this;
  }
  
  Token.Comment asComment()
  {
    return (Token.Comment)this;
  }
  
  Token.Doctype asDoctype()
  {
    return (Token.Doctype)this;
  }
  
  Token.EndTag asEndTag()
  {
    return (Token.EndTag)this;
  }
  
  Token.StartTag asStartTag()
  {
    return (Token.StartTag)this;
  }
  
  boolean isCharacter()
  {
    return this.type == Token.TokenType.Character;
  }
  
  boolean isComment()
  {
    return this.type == Token.TokenType.Comment;
  }
  
  boolean isDoctype()
  {
    return this.type == Token.TokenType.Doctype;
  }
  
  boolean isEOF()
  {
    return this.type == Token.TokenType.EOF;
  }
  
  boolean isEndTag()
  {
    return this.type == Token.TokenType.EndTag;
  }
  
  boolean isStartTag()
  {
    return this.type == Token.TokenType.StartTag;
  }
  
  String tokenType()
  {
    return getClass().getSimpleName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/parser/Token.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
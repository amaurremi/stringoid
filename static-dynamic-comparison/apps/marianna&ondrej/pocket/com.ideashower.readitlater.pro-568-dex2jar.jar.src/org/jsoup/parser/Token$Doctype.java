package org.jsoup.parser;

class Token$Doctype
  extends Token
{
  boolean forceQuirks = false;
  final StringBuilder name = new StringBuilder();
  final StringBuilder publicIdentifier = new StringBuilder();
  final StringBuilder systemIdentifier = new StringBuilder();
  
  Token$Doctype()
  {
    super(null);
    this.type = Token.TokenType.Doctype;
  }
  
  String getName()
  {
    return this.name.toString();
  }
  
  String getPublicIdentifier()
  {
    return this.publicIdentifier.toString();
  }
  
  public String getSystemIdentifier()
  {
    return this.systemIdentifier.toString();
  }
  
  public boolean isForceQuirks()
  {
    return this.forceQuirks;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/parser/Token$Doctype.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
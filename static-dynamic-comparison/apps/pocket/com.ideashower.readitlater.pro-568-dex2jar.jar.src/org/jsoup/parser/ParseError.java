package org.jsoup.parser;

public class ParseError
{
  private String errorMsg;
  private int pos;
  
  ParseError(int paramInt, String paramString)
  {
    this.pos = paramInt;
    this.errorMsg = paramString;
  }
  
  ParseError(int paramInt, String paramString, Object... paramVarArgs)
  {
    this.errorMsg = String.format(paramString, paramVarArgs);
    this.pos = paramInt;
  }
  
  public String getErrorMessage()
  {
    return this.errorMsg;
  }
  
  public int getPosition()
  {
    return this.pos;
  }
  
  public String toString()
  {
    return this.pos + ": " + this.errorMsg;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/parser/ParseError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
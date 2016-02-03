package com.fasterxml.jackson.databind.type;

import java.util.StringTokenizer;

final class TypeParser$MyTokenizer
  extends StringTokenizer
{
  protected int _index;
  protected final String _input;
  protected String _pushbackToken;
  
  public TypeParser$MyTokenizer(String paramString)
  {
    super(paramString, "<,>", true);
    this._input = paramString;
  }
  
  public String getAllInput()
  {
    return this._input;
  }
  
  public String getRemainingInput()
  {
    return this._input.substring(this._index);
  }
  
  public boolean hasMoreTokens()
  {
    return (this._pushbackToken != null) || (super.hasMoreTokens());
  }
  
  public String nextToken()
  {
    String str;
    if (this._pushbackToken != null)
    {
      str = this._pushbackToken;
      this._pushbackToken = null;
    }
    for (;;)
    {
      this._index += str.length();
      return str;
      str = super.nextToken();
    }
  }
  
  public void pushBack(String paramString)
  {
    this._pushbackToken = paramString;
    this._index -= paramString.length();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/type/TypeParser$MyTokenizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
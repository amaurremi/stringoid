package org.bson.types;

import java.io.Serializable;

public class Symbol
  implements Serializable
{
  private static final long serialVersionUID = 1326269319883146072L;
  private final String _symbol;
  
  public Symbol(String paramString)
  {
    this._symbol = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    label28:
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof Symbol)) {
        break;
      }
      paramObject = ((Symbol)paramObject)._symbol;
      if (this._symbol == null) {
        break label65;
      }
    } while (this._symbol.equals(paramObject));
    for (;;)
    {
      return false;
      if ((paramObject instanceof String))
      {
        paramObject = (String)paramObject;
        break label28;
      }
      return false;
      label65:
      if (paramObject == null) {
        break;
      }
    }
  }
  
  public String getSymbol()
  {
    return this._symbol;
  }
  
  public int hashCode()
  {
    if (this._symbol != null) {
      return this._symbol.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return this._symbol;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/types/Symbol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
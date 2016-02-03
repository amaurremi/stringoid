package org.bson.types;

import java.io.Serializable;

public class Code
  implements Serializable
{
  private static final long serialVersionUID = 475535263314046697L;
  final String _code;
  
  public Code(String paramString)
  {
    this._code = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Code)) {
      return false;
    }
    paramObject = (Code)paramObject;
    return this._code.equals(((Code)paramObject)._code);
  }
  
  public String getCode()
  {
    return this._code;
  }
  
  public int hashCode()
  {
    return this._code.hashCode();
  }
  
  public String toString()
  {
    return getCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/types/Code.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
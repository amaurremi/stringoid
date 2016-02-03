package org.bson.types;

import java.io.Serializable;

public class MinKey
  implements Serializable
{
  private static final long serialVersionUID = 4075901136671855684L;
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof MinKey;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    return "MinKey";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/types/MinKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
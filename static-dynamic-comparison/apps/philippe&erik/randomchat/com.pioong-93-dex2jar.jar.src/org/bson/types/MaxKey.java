package org.bson.types;

import java.io.Serializable;

public class MaxKey
  implements Serializable
{
  private static final long serialVersionUID = 5123414776151687185L;
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof MaxKey;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    return "MaxKey";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/types/MaxKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
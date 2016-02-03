package com.greystripe.sdk;

import java.util.Enumeration;
import java.util.Hashtable;

final class v
  extends Hashtable
{
  private v(c paramc) {}
  
  public final String a()
  {
    if (isEmpty()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Enumeration localEnumeration = keys();
    while (localEnumeration.hasMoreElements())
    {
      String str1 = (String)localEnumeration.nextElement();
      String str2 = (String)get(str1);
      localStringBuilder.append('&').append(str1).append('=').append(str2);
    }
    localStringBuilder.deleteCharAt(0);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
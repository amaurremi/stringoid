package com.greystripe.sdk;

import java.util.HashMap;

final class q
  extends HashMap
{
  private q(c paramc) {}
  
  public final String a(String paramString)
  {
    String str = (String)super.get(paramString);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
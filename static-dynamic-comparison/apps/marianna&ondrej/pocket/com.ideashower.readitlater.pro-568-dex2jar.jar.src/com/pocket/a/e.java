package com.pocket.a;

import android.os.Bundle;

 enum e
{
  public static e a(String paramString, Bundle paramBundle)
  {
    paramString = paramBundle.getString(paramString);
    if (paramString == null) {
      return null;
    }
    return valueOf(paramString);
  }
  
  public static void a(String paramString, e parame, Bundle paramBundle)
  {
    if (parame == null) {}
    for (parame = null;; parame = parame.name())
    {
      paramBundle.putString(paramString, parame);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
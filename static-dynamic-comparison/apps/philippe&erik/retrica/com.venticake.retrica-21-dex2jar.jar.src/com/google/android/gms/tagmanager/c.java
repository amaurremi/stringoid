package com.google.android.gms.tagmanager;

import java.util.Map;

class c
  implements s.a
{
  private c(Container paramContainer) {}
  
  public Object b(String paramString, Map<String, Object> paramMap)
  {
    Container.FunctionCallTagCallback localFunctionCallTagCallback = this.a.bG(paramString);
    if (localFunctionCallTagCallback != null) {
      localFunctionCallTagCallback.execute(paramString, paramMap);
    }
    return de.f();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
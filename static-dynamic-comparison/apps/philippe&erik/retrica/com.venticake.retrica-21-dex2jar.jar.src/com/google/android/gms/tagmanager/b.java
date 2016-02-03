package com.google.android.gms.tagmanager;

import java.util.Map;

class b
  implements s.a
{
  private b(Container paramContainer) {}
  
  public Object b(String paramString, Map<String, Object> paramMap)
  {
    Container.FunctionCallMacroCallback localFunctionCallMacroCallback = this.a.bF(paramString);
    if (localFunctionCallMacroCallback == null) {
      return null;
    }
    return localFunctionCallMacroCallback.getValue(paramString, paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
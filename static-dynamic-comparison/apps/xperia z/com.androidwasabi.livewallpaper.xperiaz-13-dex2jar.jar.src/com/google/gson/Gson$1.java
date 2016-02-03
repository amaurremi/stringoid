package com.google.gson;

import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;

class Gson$1
  extends ThreadLocal<Map<TypeToken<?>, Gson.FutureTypeAdapter<?>>>
{
  Gson$1(Gson paramGson) {}
  
  protected Map<TypeToken<?>, Gson.FutureTypeAdapter<?>> initialValue()
  {
    return new HashMap();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/Gson$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
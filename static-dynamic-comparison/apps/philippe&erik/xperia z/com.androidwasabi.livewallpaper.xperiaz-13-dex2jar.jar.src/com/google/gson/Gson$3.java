package com.google.gson;

import java.lang.reflect.Type;

class Gson$3
  implements JsonSerializationContext
{
  Gson$3(Gson paramGson) {}
  
  public JsonElement serialize(Object paramObject)
  {
    return this.this$0.toJsonTree(paramObject);
  }
  
  public JsonElement serialize(Object paramObject, Type paramType)
  {
    return this.this$0.toJsonTree(paramObject, paramType);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/Gson$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
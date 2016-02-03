package com.google.gson;

import java.lang.reflect.Type;

class Gson$2
  implements JsonDeserializationContext
{
  Gson$2(Gson paramGson) {}
  
  public <T> T deserialize(JsonElement paramJsonElement, Type paramType)
  {
    return (T)this.this$0.fromJson(paramJsonElement, paramType);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/Gson$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
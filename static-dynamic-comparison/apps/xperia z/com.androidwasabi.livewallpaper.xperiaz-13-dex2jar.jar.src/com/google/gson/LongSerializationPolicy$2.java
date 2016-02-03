package com.google.gson;

 enum LongSerializationPolicy$2
{
  LongSerializationPolicy$2()
  {
    super(paramString, paramInt, null);
  }
  
  public JsonElement serialize(Long paramLong)
  {
    return new JsonPrimitive(String.valueOf(paramLong));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/LongSerializationPolicy$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
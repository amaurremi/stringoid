package com.google.gson.internal;

class StringMap$Values$1
  extends StringMap<V>.LinkedHashIterator<V>
{
  StringMap$Values$1(StringMap.Values paramValues)
  {
    super(paramValues.this$0, null);
  }
  
  public final V next()
  {
    return (V)nextEntry().value;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/StringMap$Values$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
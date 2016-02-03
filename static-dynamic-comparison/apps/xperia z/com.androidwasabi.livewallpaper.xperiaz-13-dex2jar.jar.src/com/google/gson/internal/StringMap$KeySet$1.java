package com.google.gson.internal;

class StringMap$KeySet$1
  extends StringMap<V>.LinkedHashIterator<String>
{
  StringMap$KeySet$1(StringMap.KeySet paramKeySet)
  {
    super(paramKeySet.this$0, null);
  }
  
  public final String next()
  {
    return nextEntry().key;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/StringMap$KeySet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
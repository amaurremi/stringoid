package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class TypeAdapters$28
  implements TypeAdapterFactory
{
  TypeAdapters$28(Class paramClass, TypeAdapter paramTypeAdapter) {}
  
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    if (paramTypeToken.getRawType() == this.val$type) {
      return this.val$typeAdapter;
    }
    return null;
  }
  
  public String toString()
  {
    return "Factory[type=" + this.val$type.getName() + ",adapter=" + this.val$typeAdapter + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/bind/TypeAdapters$28.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
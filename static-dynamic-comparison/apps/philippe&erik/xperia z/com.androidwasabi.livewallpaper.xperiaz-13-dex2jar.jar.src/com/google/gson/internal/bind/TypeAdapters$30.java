package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class TypeAdapters$30
  implements TypeAdapterFactory
{
  TypeAdapters$30(Class paramClass1, Class paramClass2, TypeAdapter paramTypeAdapter) {}
  
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    paramGson = paramTypeToken.getRawType();
    if ((paramGson == this.val$base) || (paramGson == this.val$sub)) {
      return this.val$typeAdapter;
    }
    return null;
  }
  
  public String toString()
  {
    return "Factory[type=" + this.val$base.getName() + "+" + this.val$sub.getName() + ",adapter=" + this.val$typeAdapter + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/bind/TypeAdapters$30.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
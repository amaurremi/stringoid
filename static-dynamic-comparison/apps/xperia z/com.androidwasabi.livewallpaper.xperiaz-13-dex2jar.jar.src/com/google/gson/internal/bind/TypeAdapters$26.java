package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class TypeAdapters$26
  implements TypeAdapterFactory
{
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    paramTypeToken = paramTypeToken.getRawType();
    if ((!Enum.class.isAssignableFrom(paramTypeToken)) || (paramTypeToken == Enum.class)) {
      return null;
    }
    paramGson = paramTypeToken;
    if (!paramTypeToken.isEnum()) {
      paramGson = paramTypeToken.getSuperclass();
    }
    return new TypeAdapters.EnumTypeAdapter(paramGson);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/bind/TypeAdapters$26.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
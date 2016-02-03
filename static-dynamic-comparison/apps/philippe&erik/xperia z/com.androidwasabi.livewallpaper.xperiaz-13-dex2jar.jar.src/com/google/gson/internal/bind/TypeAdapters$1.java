package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

final class TypeAdapters$1
  extends TypeAdapter<Class>
{
  public Class read(JsonReader paramJsonReader)
  {
    throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
  }
  
  public void write(JsonWriter paramJsonWriter, Class paramClass)
  {
    throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + paramClass.getName() + ". Forgot to register a type adapter?");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/bind/TypeAdapters$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
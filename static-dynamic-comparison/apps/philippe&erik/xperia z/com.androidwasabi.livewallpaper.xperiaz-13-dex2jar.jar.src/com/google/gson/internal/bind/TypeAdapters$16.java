package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class TypeAdapters$16
  extends TypeAdapter<StringBuilder>
{
  public StringBuilder read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return new StringBuilder(paramJsonReader.nextString());
  }
  
  public void write(JsonWriter paramJsonWriter, StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder == null) {}
    for (paramStringBuilder = null;; paramStringBuilder = paramStringBuilder.toString())
    {
      paramJsonWriter.value(paramStringBuilder);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/bind/TypeAdapters$16.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
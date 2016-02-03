package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class TypeAdapters$11
  extends TypeAdapter<Number>
{
  public Number read(JsonReader paramJsonReader)
  {
    JsonToken localJsonToken = paramJsonReader.peek();
    switch (TypeAdapters.32.$SwitchMap$com$google$gson$stream$JsonToken[localJsonToken.ordinal()])
    {
    case 2: 
    case 3: 
    default: 
      throw new JsonSyntaxException("Expecting number, got: " + localJsonToken);
    case 4: 
      paramJsonReader.nextNull();
      return null;
    }
    return new LazilyParsedNumber(paramJsonReader.nextString());
  }
  
  public void write(JsonWriter paramJsonWriter, Number paramNumber)
  {
    paramJsonWriter.value(paramNumber);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/bind/TypeAdapters$11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
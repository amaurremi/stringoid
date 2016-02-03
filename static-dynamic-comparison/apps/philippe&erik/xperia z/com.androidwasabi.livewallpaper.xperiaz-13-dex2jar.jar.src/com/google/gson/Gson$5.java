package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

class Gson$5
  extends TypeAdapter<Number>
{
  Gson$5(Gson paramGson) {}
  
  public Float read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return Float.valueOf((float)paramJsonReader.nextDouble());
  }
  
  public void write(JsonWriter paramJsonWriter, Number paramNumber)
  {
    if (paramNumber == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    float f = paramNumber.floatValue();
    Gson.access$000(this.this$0, f);
    paramJsonWriter.value(paramNumber);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/Gson$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
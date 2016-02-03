package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;

final class JsonReader$1
  extends JsonReaderInternalAccess
{
  public void promoteNameToValue(JsonReader paramJsonReader)
  {
    if ((paramJsonReader instanceof JsonTreeReader))
    {
      ((JsonTreeReader)paramJsonReader).promoteNameToValue();
      return;
    }
    paramJsonReader.peek();
    if (JsonReader.access$000(paramJsonReader) != JsonToken.NAME) {
      throw new IllegalStateException("Expected a name but was " + paramJsonReader.peek() + " " + " at line " + JsonReader.access$100(paramJsonReader) + " column " + JsonReader.access$200(paramJsonReader));
    }
    JsonReader.access$302(paramJsonReader, JsonReader.access$400(paramJsonReader));
    JsonReader.access$402(paramJsonReader, null);
    JsonReader.access$002(paramJsonReader, JsonToken.STRING);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/stream/JsonReader$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
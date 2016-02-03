package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.sql.Timestamp;
import java.util.Date;

class TypeAdapters$22$1
  extends TypeAdapter<Timestamp>
{
  TypeAdapters$22$1(TypeAdapters.22 param22, TypeAdapter paramTypeAdapter) {}
  
  public Timestamp read(JsonReader paramJsonReader)
  {
    paramJsonReader = (Date)this.val$dateTypeAdapter.read(paramJsonReader);
    if (paramJsonReader != null) {
      return new Timestamp(paramJsonReader.getTime());
    }
    return null;
  }
  
  public void write(JsonWriter paramJsonWriter, Timestamp paramTimestamp)
  {
    this.val$dateTypeAdapter.write(paramJsonWriter, paramTimestamp);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/bind/TypeAdapters$22$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
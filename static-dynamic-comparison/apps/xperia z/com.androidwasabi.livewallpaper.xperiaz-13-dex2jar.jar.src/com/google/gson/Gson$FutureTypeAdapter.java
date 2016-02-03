package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

class Gson$FutureTypeAdapter<T>
  extends TypeAdapter<T>
{
  private TypeAdapter<T> delegate;
  
  public T read(JsonReader paramJsonReader)
  {
    if (this.delegate == null) {
      throw new IllegalStateException();
    }
    return (T)this.delegate.read(paramJsonReader);
  }
  
  public void setDelegate(TypeAdapter<T> paramTypeAdapter)
  {
    if (this.delegate != null) {
      throw new AssertionError();
    }
    this.delegate = paramTypeAdapter;
  }
  
  public void write(JsonWriter paramJsonWriter, T paramT)
  {
    if (this.delegate == null) {
      throw new IllegalStateException();
    }
    this.delegate.write(paramJsonWriter, paramT);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/Gson$FutureTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
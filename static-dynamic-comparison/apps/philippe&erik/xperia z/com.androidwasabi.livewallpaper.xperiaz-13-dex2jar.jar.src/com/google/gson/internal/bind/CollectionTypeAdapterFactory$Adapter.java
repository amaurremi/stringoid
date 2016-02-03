package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

final class CollectionTypeAdapterFactory$Adapter<E>
  extends TypeAdapter<Collection<E>>
{
  private final ObjectConstructor<? extends Collection<E>> constructor;
  private final TypeAdapter<E> elementTypeAdapter;
  
  public CollectionTypeAdapterFactory$Adapter(Gson paramGson, Type paramType, TypeAdapter<E> paramTypeAdapter, ObjectConstructor<? extends Collection<E>> paramObjectConstructor)
  {
    this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper(paramType, paramObjectConstructor, paramTypeAdapter);
    ObjectConstructor localObjectConstructor;
    this.constructor = localObjectConstructor;
  }
  
  public Collection<E> read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    Collection localCollection = (Collection)this.constructor.construct();
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext()) {
      localCollection.add(this.elementTypeAdapter.read(paramJsonReader));
    }
    paramJsonReader.endArray();
    return localCollection;
  }
  
  public void write(JsonWriter paramJsonWriter, Collection<E> paramCollection)
  {
    if (paramCollection == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    paramJsonWriter.beginArray();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      this.elementTypeAdapter.write(paramJsonWriter, localObject);
    }
    paramJsonWriter.endArray();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/bind/CollectionTypeAdapterFactory$Adapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
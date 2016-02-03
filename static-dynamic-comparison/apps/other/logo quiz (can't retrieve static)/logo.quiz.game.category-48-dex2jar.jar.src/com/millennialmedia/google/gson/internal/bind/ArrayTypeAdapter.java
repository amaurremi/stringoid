package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.Gson;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.TypeAdapterFactory;
import com.millennialmedia.google.gson.internal..Gson.Types;
import com.millennialmedia.google.gson.reflect.TypeToken;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public final class ArrayTypeAdapter<E>
  extends TypeAdapter<Object>
{
  public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory()
  {
    public <T> TypeAdapter<T> create(Gson paramAnonymousGson, TypeToken<T> paramAnonymousTypeToken)
    {
      paramAnonymousTypeToken = paramAnonymousTypeToken.getType();
      if ((!(paramAnonymousTypeToken instanceof GenericArrayType)) && ((!(paramAnonymousTypeToken instanceof Class)) || (!((Class)paramAnonymousTypeToken).isArray()))) {
        return null;
      }
      paramAnonymousTypeToken = .Gson.Types.getArrayComponentType(paramAnonymousTypeToken);
      return new ArrayTypeAdapter(paramAnonymousGson, paramAnonymousGson.getAdapter(TypeToken.get(paramAnonymousTypeToken)), .Gson.Types.getRawType(paramAnonymousTypeToken));
    }
  };
  private final Class<E> componentType;
  private final TypeAdapter<E> componentTypeAdapter;
  
  public ArrayTypeAdapter(Gson paramGson, TypeAdapter<E> paramTypeAdapter, Class<E> paramClass)
  {
    this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(paramGson, paramTypeAdapter, paramClass);
    this.componentType = paramClass;
  }
  
  public Object read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      paramJsonReader = null;
      return paramJsonReader;
    }
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext()) {
      localArrayList.add(this.componentTypeAdapter.read(paramJsonReader));
    }
    paramJsonReader.endArray();
    Object localObject = Array.newInstance(this.componentType, localArrayList.size());
    int i = 0;
    for (;;)
    {
      paramJsonReader = (JsonReader)localObject;
      if (i >= localArrayList.size()) {
        break;
      }
      Array.set(localObject, i, localArrayList.get(i));
      i += 1;
    }
  }
  
  public void write(JsonWriter paramJsonWriter, Object paramObject)
    throws IOException
  {
    if (paramObject == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    paramJsonWriter.beginArray();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      this.componentTypeAdapter.write(paramJsonWriter, localObject);
      i += 1;
    }
    paramJsonWriter.endArray();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/google/gson/internal/bind/ArrayTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
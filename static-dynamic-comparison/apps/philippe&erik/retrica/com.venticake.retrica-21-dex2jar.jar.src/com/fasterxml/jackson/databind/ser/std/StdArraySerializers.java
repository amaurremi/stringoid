package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.JsonSerializer;
import java.util.HashMap;

public class StdArraySerializers
{
  protected static final HashMap<String, JsonSerializer<?>> _arraySerializers = new HashMap();
  
  static
  {
    _arraySerializers.put(boolean[].class.getName(), new StdArraySerializers.BooleanArraySerializer());
    _arraySerializers.put(byte[].class.getName(), new StdArraySerializers.ByteArraySerializer());
    _arraySerializers.put(char[].class.getName(), new StdArraySerializers.CharArraySerializer());
    _arraySerializers.put(short[].class.getName(), new StdArraySerializers.ShortArraySerializer());
    _arraySerializers.put(int[].class.getName(), new StdArraySerializers.IntArraySerializer());
    _arraySerializers.put(long[].class.getName(), new StdArraySerializers.LongArraySerializer());
    _arraySerializers.put(float[].class.getName(), new StdArraySerializers.FloatArraySerializer());
    _arraySerializers.put(double[].class.getName(), new StdArraySerializers.DoubleArraySerializer());
  }
  
  public static JsonSerializer<?> findStandardImpl(Class<?> paramClass)
  {
    return (JsonSerializer)_arraySerializers.get(paramClass.getName());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/StdArraySerializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
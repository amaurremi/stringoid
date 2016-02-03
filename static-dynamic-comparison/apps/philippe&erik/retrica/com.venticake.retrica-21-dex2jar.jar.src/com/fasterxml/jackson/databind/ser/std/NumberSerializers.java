package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.JsonSerializer;
import java.util.Map;

public class NumberSerializers
{
  public static void addAll(Map<String, JsonSerializer<?>> paramMap)
  {
    NumberSerializers.IntegerSerializer localIntegerSerializer = new NumberSerializers.IntegerSerializer();
    paramMap.put(Integer.class.getName(), localIntegerSerializer);
    paramMap.put(Integer.TYPE.getName(), localIntegerSerializer);
    paramMap.put(Long.class.getName(), NumberSerializers.LongSerializer.instance);
    paramMap.put(Long.TYPE.getName(), NumberSerializers.LongSerializer.instance);
    paramMap.put(Byte.class.getName(), NumberSerializers.IntLikeSerializer.instance);
    paramMap.put(Byte.TYPE.getName(), NumberSerializers.IntLikeSerializer.instance);
    paramMap.put(Short.class.getName(), NumberSerializers.IntLikeSerializer.instance);
    paramMap.put(Short.TYPE.getName(), NumberSerializers.IntLikeSerializer.instance);
    paramMap.put(Float.class.getName(), NumberSerializers.FloatSerializer.instance);
    paramMap.put(Float.TYPE.getName(), NumberSerializers.FloatSerializer.instance);
    paramMap.put(Double.class.getName(), NumberSerializers.DoubleSerializer.instance);
    paramMap.put(Double.TYPE.getName(), NumberSerializers.DoubleSerializer.instance);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/NumberSerializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.fasterxml.jackson.databind.deser.std;

public class NumberDeserializers
{
  public static StdDeserializer<?>[] all()
  {
    return new StdDeserializer[] { new NumberDeserializers.BooleanDeserializer(Boolean.class, null), new NumberDeserializers.ByteDeserializer(Byte.class, null), new NumberDeserializers.ShortDeserializer(Short.class, null), new NumberDeserializers.CharacterDeserializer(Character.class, null), new NumberDeserializers.IntegerDeserializer(Integer.class, null), new NumberDeserializers.LongDeserializer(Long.class, null), new NumberDeserializers.FloatDeserializer(Float.class, null), new NumberDeserializers.DoubleDeserializer(Double.class, null), new NumberDeserializers.BooleanDeserializer(Boolean.TYPE, Boolean.FALSE), new NumberDeserializers.ByteDeserializer(Byte.TYPE, Byte.valueOf(0)), new NumberDeserializers.ShortDeserializer(Short.TYPE, Short.valueOf(0)), new NumberDeserializers.CharacterDeserializer(Character.TYPE, Character.valueOf('\000')), new NumberDeserializers.IntegerDeserializer(Integer.TYPE, Integer.valueOf(0)), new NumberDeserializers.LongDeserializer(Long.TYPE, Long.valueOf(0L)), new NumberDeserializers.FloatDeserializer(Float.TYPE, Float.valueOf(0.0F)), new NumberDeserializers.DoubleDeserializer(Double.TYPE, Double.valueOf(0.0D)), new NumberDeserializers.NumberDeserializer(), new NumberDeserializers.BigDecimalDeserializer(), new NumberDeserializers.BigIntegerDeserializer() };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/NumberDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
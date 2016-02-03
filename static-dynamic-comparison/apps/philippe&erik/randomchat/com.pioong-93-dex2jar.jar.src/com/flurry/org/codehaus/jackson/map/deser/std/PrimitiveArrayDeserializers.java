package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.Base64Variant;
import com.flurry.org.codehaus.jackson.Base64Variants;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig.Feature;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.map.annotate.JacksonStdImpl;
import com.flurry.org.codehaus.jackson.map.type.TypeFactory;
import com.flurry.org.codehaus.jackson.map.util.ArrayBuilders;
import com.flurry.org.codehaus.jackson.map.util.ArrayBuilders.BooleanBuilder;
import com.flurry.org.codehaus.jackson.map.util.ArrayBuilders.ByteBuilder;
import com.flurry.org.codehaus.jackson.map.util.ArrayBuilders.DoubleBuilder;
import com.flurry.org.codehaus.jackson.map.util.ArrayBuilders.FloatBuilder;
import com.flurry.org.codehaus.jackson.map.util.ArrayBuilders.IntBuilder;
import com.flurry.org.codehaus.jackson.map.util.ArrayBuilders.LongBuilder;
import com.flurry.org.codehaus.jackson.map.util.ArrayBuilders.ShortBuilder;
import com.flurry.org.codehaus.jackson.map.util.ObjectBuffer;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;
import java.util.HashMap;

public class PrimitiveArrayDeserializers
{
  static final PrimitiveArrayDeserializers instance = new PrimitiveArrayDeserializers();
  HashMap<JavaType, JsonDeserializer<Object>> _allDeserializers = new HashMap();
  
  protected PrimitiveArrayDeserializers()
  {
    add(Boolean.TYPE, new BooleanDeser());
    add(Byte.TYPE, new ByteDeser());
    add(Short.TYPE, new ShortDeser());
    add(Integer.TYPE, new IntDeser());
    add(Long.TYPE, new LongDeser());
    add(Float.TYPE, new FloatDeser());
    add(Double.TYPE, new DoubleDeser());
    add(String.class, new StringDeser());
    add(Character.TYPE, new CharDeser());
  }
  
  private void add(Class<?> paramClass, JsonDeserializer<?> paramJsonDeserializer)
  {
    this._allDeserializers.put(TypeFactory.defaultInstance().constructType(paramClass), paramJsonDeserializer);
  }
  
  public static HashMap<JavaType, JsonDeserializer<Object>> getAll()
  {
    return instance._allDeserializers;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    return paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
  }
  
  static abstract class Base<T>
    extends StdDeserializer<T>
  {
    protected Base(Class<T> paramClass)
    {
      super();
    }
    
    public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
      throws IOException, JsonProcessingException
    {
      return paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
    }
  }
  
  @JacksonStdImpl
  static final class BooleanDeser
    extends PrimitiveArrayDeserializers.Base<boolean[]>
  {
    public BooleanDeser()
    {
      super();
    }
    
    private final boolean[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
        return null;
      }
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      return new boolean[] { _parseBooleanPrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public boolean[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        return handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      ArrayBuilders.BooleanBuilder localBooleanBuilder = paramDeserializationContext.getArrayBuilders().getBooleanBuilder();
      Object localObject1 = (boolean[])localBooleanBuilder.resetAndStart();
      int i = 0;
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
      {
        boolean bool = _parseBooleanPrimitive(paramJsonParser, paramDeserializationContext);
        Object localObject2 = localObject1;
        int j = i;
        if (i >= localObject1.length)
        {
          localObject2 = (boolean[])localBooleanBuilder.appendCompletedChunk(localObject1, i);
          j = 0;
        }
        localObject2[j] = bool;
        i = j + 1;
        localObject1 = localObject2;
      }
      return (boolean[])localBooleanBuilder.completeAndClearBuffer(localObject1, i);
    }
  }
  
  @JacksonStdImpl
  static final class ByteDeser
    extends PrimitiveArrayDeserializers.Base<byte[]>
  {
    public ByteDeser()
    {
      super();
    }
    
    private final byte[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
        return null;
      }
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {}
      for (int i = paramJsonParser.getByteValue();; i = 0)
      {
        return new byte[] { i };
        if (localJsonToken != JsonToken.VALUE_NULL) {
          throw paramDeserializationContext.mappingException(this._valueClass.getComponentType());
        }
      }
    }
    
    public byte[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      Object localObject1 = paramJsonParser.getCurrentToken();
      if (localObject1 == JsonToken.VALUE_STRING) {
        return paramJsonParser.getBinaryValue(paramDeserializationContext.getBase64Variant());
      }
      if (localObject1 == JsonToken.VALUE_EMBEDDED_OBJECT)
      {
        localObject1 = paramJsonParser.getEmbeddedObject();
        if (localObject1 == null) {
          return null;
        }
        if ((localObject1 instanceof byte[])) {
          return (byte[])localObject1;
        }
      }
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        return handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      ArrayBuilders.ByteBuilder localByteBuilder = paramDeserializationContext.getArrayBuilders().getByteBuilder();
      localObject1 = (byte[])localByteBuilder.resetAndStart();
      int j = 0;
      Object localObject2 = paramJsonParser.nextToken();
      if (localObject2 != JsonToken.END_ARRAY)
      {
        if ((localObject2 == JsonToken.VALUE_NUMBER_INT) || (localObject2 == JsonToken.VALUE_NUMBER_FLOAT)) {}
        for (int i = paramJsonParser.getByteValue();; i = 0)
        {
          localObject2 = localObject1;
          int k = j;
          if (j >= localObject1.length)
          {
            localObject2 = (byte[])localByteBuilder.appendCompletedChunk(localObject1, j);
            k = 0;
          }
          localObject2[k] = i;
          j = k + 1;
          localObject1 = localObject2;
          break;
          if (localObject2 != JsonToken.VALUE_NULL) {
            throw paramDeserializationContext.mappingException(this._valueClass.getComponentType());
          }
        }
      }
      return (byte[])localByteBuilder.completeAndClearBuffer(localObject1, j);
    }
  }
  
  @JacksonStdImpl
  static final class CharDeser
    extends PrimitiveArrayDeserializers.Base<char[]>
  {
    public CharDeser()
    {
      super();
    }
    
    public char[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      Object localObject1 = paramJsonParser.getCurrentToken();
      if (localObject1 == JsonToken.VALUE_STRING)
      {
        paramDeserializationContext = paramJsonParser.getTextCharacters();
        int i = paramJsonParser.getTextOffset();
        int j = paramJsonParser.getTextLength();
        paramJsonParser = new char[j];
        System.arraycopy(paramDeserializationContext, i, paramJsonParser, 0, j);
        return paramJsonParser;
      }
      if (paramJsonParser.isExpectedStartArrayToken())
      {
        localObject1 = new StringBuilder(64);
        for (;;)
        {
          Object localObject2 = paramJsonParser.nextToken();
          if (localObject2 == JsonToken.END_ARRAY) {
            break;
          }
          if (localObject2 != JsonToken.VALUE_STRING) {
            throw paramDeserializationContext.mappingException(Character.TYPE);
          }
          localObject2 = paramJsonParser.getText();
          if (((String)localObject2).length() != 1) {
            throw JsonMappingException.from(paramJsonParser, "Can not convert a JSON String of length " + ((String)localObject2).length() + " into a char element of char array");
          }
          ((StringBuilder)localObject1).append(((String)localObject2).charAt(0));
        }
        return ((StringBuilder)localObject1).toString().toCharArray();
      }
      if (localObject1 == JsonToken.VALUE_EMBEDDED_OBJECT)
      {
        paramJsonParser = paramJsonParser.getEmbeddedObject();
        if (paramJsonParser == null) {
          return null;
        }
        if ((paramJsonParser instanceof char[])) {
          return (char[])paramJsonParser;
        }
        if ((paramJsonParser instanceof String)) {
          return ((String)paramJsonParser).toCharArray();
        }
        if ((paramJsonParser instanceof byte[])) {
          return Base64Variants.getDefaultVariant().encode((byte[])paramJsonParser, false).toCharArray();
        }
      }
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
  }
  
  @JacksonStdImpl
  static final class DoubleDeser
    extends PrimitiveArrayDeserializers.Base<double[]>
  {
    public DoubleDeser()
    {
      super();
    }
    
    private final double[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
        return null;
      }
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      return new double[] { _parseDoublePrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public double[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        return handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      ArrayBuilders.DoubleBuilder localDoubleBuilder = paramDeserializationContext.getArrayBuilders().getDoubleBuilder();
      Object localObject1 = (double[])localDoubleBuilder.resetAndStart();
      int i = 0;
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
      {
        double d = _parseDoublePrimitive(paramJsonParser, paramDeserializationContext);
        Object localObject2 = localObject1;
        int j = i;
        if (i >= localObject1.length)
        {
          localObject2 = (double[])localDoubleBuilder.appendCompletedChunk(localObject1, i);
          j = 0;
        }
        localObject2[j] = d;
        i = j + 1;
        localObject1 = localObject2;
      }
      return (double[])localDoubleBuilder.completeAndClearBuffer(localObject1, i);
    }
  }
  
  @JacksonStdImpl
  static final class FloatDeser
    extends PrimitiveArrayDeserializers.Base<float[]>
  {
    public FloatDeser()
    {
      super();
    }
    
    private final float[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
        return null;
      }
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      return new float[] { _parseFloatPrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public float[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        return handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      ArrayBuilders.FloatBuilder localFloatBuilder = paramDeserializationContext.getArrayBuilders().getFloatBuilder();
      Object localObject1 = (float[])localFloatBuilder.resetAndStart();
      int i = 0;
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
      {
        float f = _parseFloatPrimitive(paramJsonParser, paramDeserializationContext);
        Object localObject2 = localObject1;
        int j = i;
        if (i >= localObject1.length)
        {
          localObject2 = (float[])localFloatBuilder.appendCompletedChunk(localObject1, i);
          j = 0;
        }
        localObject2[j] = f;
        i = j + 1;
        localObject1 = localObject2;
      }
      return (float[])localFloatBuilder.completeAndClearBuffer(localObject1, i);
    }
  }
  
  @JacksonStdImpl
  static final class IntDeser
    extends PrimitiveArrayDeserializers.Base<int[]>
  {
    public IntDeser()
    {
      super();
    }
    
    private final int[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
        return null;
      }
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      return new int[] { _parseIntPrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public int[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        return handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      ArrayBuilders.IntBuilder localIntBuilder = paramDeserializationContext.getArrayBuilders().getIntBuilder();
      Object localObject1 = (int[])localIntBuilder.resetAndStart();
      int i = 0;
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
      {
        int k = _parseIntPrimitive(paramJsonParser, paramDeserializationContext);
        Object localObject2 = localObject1;
        int j = i;
        if (i >= localObject1.length)
        {
          localObject2 = (int[])localIntBuilder.appendCompletedChunk(localObject1, i);
          j = 0;
        }
        localObject2[j] = k;
        i = j + 1;
        localObject1 = localObject2;
      }
      return (int[])localIntBuilder.completeAndClearBuffer(localObject1, i);
    }
  }
  
  @JacksonStdImpl
  static final class LongDeser
    extends PrimitiveArrayDeserializers.Base<long[]>
  {
    public LongDeser()
    {
      super();
    }
    
    private final long[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
        return null;
      }
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      return new long[] { _parseLongPrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public long[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        return handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      ArrayBuilders.LongBuilder localLongBuilder = paramDeserializationContext.getArrayBuilders().getLongBuilder();
      Object localObject1 = (long[])localLongBuilder.resetAndStart();
      int i = 0;
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
      {
        long l = _parseLongPrimitive(paramJsonParser, paramDeserializationContext);
        Object localObject2 = localObject1;
        int j = i;
        if (i >= localObject1.length)
        {
          localObject2 = (long[])localLongBuilder.appendCompletedChunk(localObject1, i);
          j = 0;
        }
        localObject2[j] = l;
        i = j + 1;
        localObject1 = localObject2;
      }
      return (long[])localLongBuilder.completeAndClearBuffer(localObject1, i);
    }
  }
  
  @JacksonStdImpl
  static final class ShortDeser
    extends PrimitiveArrayDeserializers.Base<short[]>
  {
    public ShortDeser()
    {
      super();
    }
    
    private final short[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
        return null;
      }
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      return new short[] { _parseShortPrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public short[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        return handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      ArrayBuilders.ShortBuilder localShortBuilder = paramDeserializationContext.getArrayBuilders().getShortBuilder();
      Object localObject1 = (short[])localShortBuilder.resetAndStart();
      int j = 0;
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
      {
        int i = _parseShortPrimitive(paramJsonParser, paramDeserializationContext);
        Object localObject2 = localObject1;
        int k = j;
        if (j >= localObject1.length)
        {
          localObject2 = (short[])localShortBuilder.appendCompletedChunk(localObject1, j);
          k = 0;
        }
        localObject2[k] = i;
        j = k + 1;
        localObject1 = localObject2;
      }
      return (short[])localShortBuilder.completeAndClearBuffer(localObject1, j);
    }
  }
  
  @JacksonStdImpl
  static final class StringDeser
    extends PrimitiveArrayDeserializers.Base<String[]>
  {
    public StringDeser()
    {
      super();
    }
    
    private final String[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      Object localObject = null;
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY))
      {
        if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
          return null;
        }
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {}
      for (paramJsonParser = (JsonParser)localObject;; paramJsonParser = paramJsonParser.getText()) {
        return new String[] { paramJsonParser };
      }
    }
    
    public String[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        return handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      ObjectBuffer localObjectBuffer = paramDeserializationContext.leaseObjectBuffer();
      Object localObject1 = localObjectBuffer.resetAndStart();
      int i = 0;
      Object localObject2 = paramJsonParser.nextToken();
      if (localObject2 != JsonToken.END_ARRAY)
      {
        if (localObject2 == JsonToken.VALUE_NULL) {}
        for (localObject2 = null;; localObject2 = paramJsonParser.getText())
        {
          Object localObject3 = localObject1;
          int j = i;
          if (i >= localObject1.length)
          {
            localObject3 = localObjectBuffer.appendCompletedChunk((Object[])localObject1);
            j = 0;
          }
          localObject3[j] = localObject2;
          i = j + 1;
          localObject1 = localObject3;
          break;
        }
      }
      paramJsonParser = (String[])localObjectBuffer.completeAndClearBuffer((Object[])localObject1, i, String.class);
      paramDeserializationContext.returnObjectBuffer(localObjectBuffer);
      return paramJsonParser;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/std/PrimitiveArrayDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
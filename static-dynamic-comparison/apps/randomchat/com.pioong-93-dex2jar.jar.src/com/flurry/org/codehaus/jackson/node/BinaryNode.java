package com.flurry.org.codehaus.jackson.node;

import com.flurry.org.codehaus.jackson.Base64Variant;
import com.flurry.org.codehaus.jackson.Base64Variants;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import java.io.IOException;
import java.util.Arrays;

public final class BinaryNode
  extends ValueNode
{
  static final BinaryNode EMPTY_BINARY_NODE = new BinaryNode(new byte[0]);
  final byte[] _data;
  
  public BinaryNode(byte[] paramArrayOfByte)
  {
    this._data = paramArrayOfByte;
  }
  
  public BinaryNode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == paramArrayOfByte.length))
    {
      this._data = paramArrayOfByte;
      return;
    }
    this._data = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this._data, 0, paramInt2);
  }
  
  public static BinaryNode valueOf(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramArrayOfByte.length == 0) {
      return EMPTY_BINARY_NODE;
    }
    return new BinaryNode(paramArrayOfByte);
  }
  
  public static BinaryNode valueOf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramInt2 == 0) {
      return EMPTY_BINARY_NODE;
    }
    return new BinaryNode(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public String asText()
  {
    return Base64Variants.getDefaultVariant().encode(this._data, false);
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_EMBEDDED_OBJECT;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (paramObject.getClass() != getClass());
    return Arrays.equals(((BinaryNode)paramObject)._data, this._data);
  }
  
  public byte[] getBinaryValue()
  {
    return this._data;
  }
  
  public int hashCode()
  {
    if (this._data == null) {
      return -1;
    }
    return this._data.length;
  }
  
  public boolean isBinary()
  {
    return true;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeBinary(this._data);
  }
  
  public String toString()
  {
    return Base64Variants.getDefaultVariant().encode(this._data, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/node/BinaryNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
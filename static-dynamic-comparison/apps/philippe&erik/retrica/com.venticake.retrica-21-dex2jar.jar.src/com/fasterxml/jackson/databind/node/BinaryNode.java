package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
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
  
  public String asText()
  {
    return Base64Variants.getDefaultVariant().encode(this._data, false);
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
  
  public int hashCode()
  {
    if (this._data == null) {
      return -1;
    }
    return this._data.length;
  }
  
  public String toString()
  {
    return Base64Variants.getDefaultVariant().encode(this._data, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/node/BinaryNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
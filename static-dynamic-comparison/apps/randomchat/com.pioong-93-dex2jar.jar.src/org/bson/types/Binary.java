package org.bson.types;

import java.io.Serializable;
import java.util.Arrays;

public class Binary
  implements Serializable
{
  private static final long serialVersionUID = 7902997490338209467L;
  final byte[] _data;
  final byte _type;
  
  public Binary(byte paramByte, byte[] paramArrayOfByte)
  {
    this._type = paramByte;
    this._data = paramArrayOfByte;
  }
  
  public Binary(byte[] paramArrayOfByte)
  {
    this((byte)0, paramArrayOfByte);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Binary)) {
        return false;
      }
      paramObject = (Binary)paramObject;
      if (this._type != ((Binary)paramObject)._type) {
        return false;
      }
    } while (Arrays.equals(this._data, ((Binary)paramObject)._data));
    return false;
  }
  
  public byte[] getData()
  {
    return this._data;
  }
  
  public byte getType()
  {
    return this._type;
  }
  
  public int hashCode()
  {
    int j = this._type;
    if (this._data != null) {}
    for (int i = Arrays.hashCode(this._data);; i = 0) {
      return j * 31 + i;
    }
  }
  
  public int length()
  {
    return this._data.length;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/types/Binary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
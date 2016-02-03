package com.google.tagmanager.protobuf.nano;

import java.util.Arrays;

public final class UnknownFieldData
{
  final byte[] bytes;
  final int tag;
  
  UnknownFieldData(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.bytes = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof UnknownFieldData)) {
        return false;
      }
      paramObject = (UnknownFieldData)paramObject;
    } while ((this.tag == ((UnknownFieldData)paramObject).tag) && (Arrays.equals(this.bytes, ((UnknownFieldData)paramObject).bytes)));
    return false;
  }
  
  public int hashCode()
  {
    int j = this.tag + 527;
    int i = 0;
    while (i < this.bytes.length)
    {
      j = j * 31 + this.bytes[i];
      i += 1;
    }
    return j;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/protobuf/nano/UnknownFieldData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
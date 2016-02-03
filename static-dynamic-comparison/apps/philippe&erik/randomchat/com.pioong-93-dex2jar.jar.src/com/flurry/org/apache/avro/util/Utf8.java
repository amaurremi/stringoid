package com.flurry.org.apache.avro.util;

import com.flurry.org.apache.avro.io.BinaryData;
import java.io.UnsupportedEncodingException;

public class Utf8
  implements Comparable<Utf8>, CharSequence
{
  private static final byte[] EMPTY = new byte[0];
  private byte[] bytes = EMPTY;
  private int length;
  private String string;
  
  public Utf8() {}
  
  public Utf8(Utf8 paramUtf8)
  {
    this.length = paramUtf8.length;
    this.bytes = new byte[paramUtf8.length];
    System.arraycopy(paramUtf8.bytes, 0, this.bytes, 0, this.length);
    this.string = paramUtf8.string;
  }
  
  public Utf8(String paramString)
  {
    this.bytes = getBytesFor(paramString);
    this.length = this.bytes.length;
    this.string = paramString;
  }
  
  public Utf8(byte[] paramArrayOfByte)
  {
    this.bytes = paramArrayOfByte;
    this.length = paramArrayOfByte.length;
  }
  
  public static final byte[] getBytesFor(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return new byte[0];
  }
  
  public char charAt(int paramInt)
  {
    return toString().charAt(paramInt);
  }
  
  public int compareTo(Utf8 paramUtf8)
  {
    return BinaryData.compareBytes(this.bytes, 0, this.length, paramUtf8.bytes, 0, paramUtf8.length);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof Utf8)) {
        return false;
      }
      paramObject = (Utf8)paramObject;
      if (this.length != ((Utf8)paramObject).length) {
        return false;
      }
      paramObject = ((Utf8)paramObject).bytes;
      int i = 0;
      while (i < this.length)
      {
        if (this.bytes[i] != paramObject[i]) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public int getByteLength()
  {
    return this.length;
  }
  
  public byte[] getBytes()
  {
    return this.bytes;
  }
  
  public int getLength()
  {
    return this.length;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i >= this.length) {
        return j;
      }
      j = j * 31 + this.bytes[i];
      i += 1;
    }
  }
  
  public int length()
  {
    return toString().length();
  }
  
  public Utf8 setByteLength(int paramInt)
  {
    if (this.length < paramInt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.bytes, 0, arrayOfByte, 0, this.length);
      this.bytes = arrayOfByte;
    }
    this.length = paramInt;
    this.string = null;
    return this;
  }
  
  public Utf8 setLength(int paramInt)
  {
    return setByteLength(paramInt);
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return toString().subSequence(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    if (this.string == null) {}
    try
    {
      this.string = new String(this.bytes, 0, this.length, "UTF-8");
      return this.string;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/util/Utf8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
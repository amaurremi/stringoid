package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Internal
{
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  public static final ByteBuffer EMPTY_BYTE_BUFFER = ByteBuffer.wrap(EMPTY_BYTE_ARRAY);
  
  public static byte[] byteArrayDefaultValue(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ISO-8859-1");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException("Java VM does not support a standard character set.", paramString);
    }
  }
  
  public static ByteBuffer byteBufferDefaultValue(String paramString)
  {
    return ByteBuffer.wrap(byteArrayDefaultValue(paramString));
  }
  
  public static ByteString bytesDefaultValue(String paramString)
  {
    try
    {
      paramString = ByteString.copyFrom(paramString.getBytes("ISO-8859-1"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException("Java VM does not support a standard character set.", paramString);
    }
  }
  
  public static ByteBuffer copyByteBuffer(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = paramByteBuffer.duplicate();
    paramByteBuffer.clear();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.capacity());
    localByteBuffer.put(paramByteBuffer);
    localByteBuffer.clear();
    return localByteBuffer;
  }
  
  public static boolean equals(List<byte[]> paramList1, List<byte[]> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int i = 0;
    while (i < paramList1.size())
    {
      if (!Arrays.equals((byte[])paramList1.get(i), (byte[])paramList2.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean equalsByteBuffer(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    if (paramByteBuffer1.capacity() != paramByteBuffer2.capacity()) {
      return false;
    }
    return paramByteBuffer1.duplicate().clear().equals(paramByteBuffer2.duplicate().clear());
  }
  
  public static boolean equalsByteBuffer(List<ByteBuffer> paramList1, List<ByteBuffer> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int i = 0;
    while (i < paramList1.size())
    {
      if (!equalsByteBuffer((ByteBuffer)paramList1.get(i), (ByteBuffer)paramList2.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static int hashBoolean(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  public static int hashCode(List<byte[]> paramList)
  {
    int i = 1;
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      i = i * 31 + hashCode((byte[])paramList.next());
    }
    return i;
  }
  
  public static int hashCode(byte[] paramArrayOfByte)
  {
    return LiteralByteString.hashCode(paramArrayOfByte);
  }
  
  public static int hashCodeByteBuffer(ByteBuffer paramByteBuffer)
  {
    int i = 4096;
    int m = 1;
    int j;
    if (paramByteBuffer.hasArray())
    {
      j = LiteralByteString.hashCode(paramByteBuffer.capacity(), paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.capacity());
      i = j;
      if (j == 0) {
        i = 1;
      }
      return i;
    }
    byte[] arrayOfByte;
    ByteBuffer localByteBuffer;
    if (paramByteBuffer.capacity() > 4096)
    {
      arrayOfByte = new byte[i];
      localByteBuffer = paramByteBuffer.duplicate();
      localByteBuffer.clear();
      j = paramByteBuffer.capacity();
      label76:
      if (localByteBuffer.remaining() <= 0) {
        break label134;
      }
      if (localByteBuffer.remaining() > i) {
        break label129;
      }
    }
    label129:
    for (int k = localByteBuffer.remaining();; k = i)
    {
      localByteBuffer.get(arrayOfByte, 0, k);
      j = LiteralByteString.hashCode(j, arrayOfByte, 0, k);
      break label76;
      i = paramByteBuffer.capacity();
      break;
    }
    label134:
    if (j == 0) {}
    for (i = m;; i = j) {
      return i;
    }
  }
  
  public static int hashCodeByteBuffer(List<ByteBuffer> paramList)
  {
    int i = 1;
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      i = i * 31 + hashCodeByteBuffer((ByteBuffer)paramList.next());
    }
    return i;
  }
  
  public static int hashEnum(EnumLite paramEnumLite)
  {
    return paramEnumLite.getNumber();
  }
  
  public static int hashEnumList(List<? extends EnumLite> paramList)
  {
    int i = 1;
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      i = i * 31 + hashEnum((EnumLite)paramList.next());
    }
    return i;
  }
  
  public static int hashLong(long paramLong)
  {
    return (int)(paramLong >>> 32 ^ paramLong);
  }
  
  static boolean isProto1Group(MessageLite paramMessageLite)
  {
    return ((paramMessageLite instanceof AbstractMutableMessageLite)) && (((AbstractMutableMessageLite)paramMessageLite).isProto1Group());
  }
  
  public static boolean isValidUtf8(ByteString paramByteString)
  {
    return paramByteString.isValidUtf8();
  }
  
  public static boolean isValidUtf8(byte[] paramArrayOfByte)
  {
    return Utf8.isValidUtf8(paramArrayOfByte);
  }
  
  public static <T extends MutableMessageLite> T mergeFrom(T paramT, CodedInputStream paramCodedInputStream)
    throws IOException
  {
    if (!paramT.mergeFrom(paramCodedInputStream)) {
      throw InvalidProtocolBufferException.parseFailure();
    }
    return paramT;
  }
  
  public static <T extends MutableMessageLite> T mergeFrom(T paramT, CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    if (!paramT.mergeFrom(paramCodedInputStream, paramExtensionRegistryLite)) {
      throw InvalidProtocolBufferException.parseFailure();
    }
    return paramT;
  }
  
  public static <T extends MutableMessageLite> T mergeFrom(T paramT, byte[] paramArrayOfByte)
    throws IOException
  {
    if (!paramT.mergeFrom(paramArrayOfByte)) {
      throw InvalidProtocolBufferException.parseFailure();
    }
    return paramT;
  }
  
  public static String stringDefaultValue(String paramString)
  {
    try
    {
      paramString = new String(paramString.getBytes("ISO-8859-1"), "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException("Java VM does not support a standard character set.", paramString);
    }
  }
  
  public static byte[] toByteArray(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported?", paramString);
    }
  }
  
  public static String toStringUtf8(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new RuntimeException("UTF-8 not supported?", paramArrayOfByte);
    }
  }
  
  public static abstract interface EnumLite
  {
    public abstract int getNumber();
  }
  
  public static abstract interface EnumLiteMap<T extends Internal.EnumLite>
  {
    public abstract T findValueByNumber(int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/protobuf/Internal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.tagmanager.protobuf;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public class i
{
  public static final ByteBuffer ajT = ByteBuffer.wrap(ajg);
  public static final byte[] ajg = new byte[0];
  
  public static int T(long paramLong)
  {
    return (int)(paramLong >>> 32 ^ paramLong);
  }
  
  public static int a(a parama)
  {
    return parama.ga();
  }
  
  public static int aK(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  static boolean g(n paramn)
  {
    return ((paramn instanceof b)) && (((b)paramn).AG());
  }
  
  public static int j(List<? extends a> paramList)
  {
    paramList = paramList.iterator();
    for (int i = 1; paramList.hasNext(); i = a((a)paramList.next()) + i * 31) {}
    return i;
  }
  
  public static boolean q(byte[] paramArrayOfByte)
  {
    return u.q(paramArrayOfByte);
  }
  
  public static String r(byte[] paramArrayOfByte)
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
  
  public static abstract interface a
  {
    public abstract int ga();
  }
  
  public static abstract interface b<T extends i.a>
  {
    public abstract T aE(int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
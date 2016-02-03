package com.google.ads;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class b
{
  private static b c = null;
  private final BigInteger a = d();
  private BigInteger b = BigInteger.ONE;
  
  public static b a()
  {
    try
    {
      if (c == null) {
        c = new b();
      }
      b localb = c;
      return localb;
    }
    finally {}
  }
  
  private static byte[] a(long paramLong)
  {
    return BigInteger.valueOf(paramLong).toByteArray();
  }
  
  private static BigInteger d()
  {
    try
    {
      Object localObject1 = MessageDigest.getInstance("MD5");
      Object localObject2 = UUID.randomUUID();
      ((MessageDigest)localObject1).update(a(((UUID)localObject2).getLeastSignificantBits()));
      ((MessageDigest)localObject1).update(a(((UUID)localObject2).getMostSignificantBits()));
      localObject2 = new byte[9];
      localObject2[0] = 0;
      System.arraycopy(((MessageDigest)localObject1).digest(), 0, localObject2, 1, 8);
      localObject1 = new BigInteger((byte[])localObject2);
      return (BigInteger)localObject1;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException("Cannot find MD5 message digest algorithm.");
    }
  }
  
  public BigInteger b()
  {
    try
    {
      BigInteger localBigInteger = this.a;
      return localBigInteger;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public BigInteger c()
  {
    try
    {
      BigInteger localBigInteger = this.b;
      this.b = this.b.add(BigInteger.ONE);
      return localBigInteger;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/ads/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
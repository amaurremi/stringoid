package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public final class bk
{
  private static final Object DS = new Object();
  public static final String EX;
  private static bl EY = new bl(EX);
  private static BigInteger EZ = BigInteger.ONE;
  private static HashSet<bj> Fa = new HashSet();
  private static HashMap<String, bm> Fb = new HashMap();
  
  static
  {
    Object localObject1 = UUID.randomUUID();
    byte[] arrayOfByte1 = BigInteger.valueOf(((UUID)localObject1).getLeastSignificantBits()).toByteArray();
    byte[] arrayOfByte2 = BigInteger.valueOf(((UUID)localObject1).getMostSignificantBits()).toByteArray();
    localObject1 = new BigInteger(1, arrayOfByte1).toString();
    int i = 0;
    while (i < 2)
    {
      try
      {
        Object localObject2 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject2).update(arrayOfByte1);
        ((MessageDigest)localObject2).update(arrayOfByte2);
        byte[] arrayOfByte3 = new byte[8];
        System.arraycopy(((MessageDigest)localObject2).digest(), 0, arrayOfByte3, 0, 8);
        localObject2 = new BigInteger(1, arrayOfByte3).toString();
        localObject1 = localObject2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
      i += 1;
    }
    EX = (String)localObject1;
  }
  
  public static Bundle a(gv.a parama, String paramString, Context paramContext)
  {
    Bundle localBundle;
    synchronized (DS)
    {
      localBundle = new Bundle();
      localBundle.putBundle("app", EY.a(paramString, paramContext));
      paramString = new Bundle();
      paramContext = Fb.keySet().iterator();
      if (paramContext.hasNext())
      {
        String str = (String)paramContext.next();
        paramString.putBundle(str, ((bm)Fb.get(str)).toBundle());
      }
    }
    localBundle.putBundle("slots", paramString);
    paramString = new ArrayList();
    paramContext = Fa.iterator();
    while (paramContext.hasNext()) {
      paramString.add(((bj)paramContext.next()).toBundle());
    }
    localBundle.putParcelableArrayList("ads", paramString);
    parama.a(Fa);
    Fa = new HashSet();
    return localBundle;
  }
  
  public static void a(bj parambj)
  {
    synchronized (DS)
    {
      Fa.add(parambj);
      return;
    }
  }
  
  public static void a(gv.a parama)
  {
    synchronized (DS)
    {
      Fa.addAll(parama.tW());
      return;
    }
  }
  
  public static void a(String paramString, bm parambm)
  {
    synchronized (DS)
    {
      Fb.put(paramString, parambm);
      return;
    }
  }
  
  public static String pJ()
  {
    synchronized (DS)
    {
      String str = EZ.toString();
      EZ = EZ.add(BigInteger.ONE);
      return str;
    }
  }
  
  public static bl pK()
  {
    synchronized (DS)
    {
      bl localbl = EY;
      return localbl;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
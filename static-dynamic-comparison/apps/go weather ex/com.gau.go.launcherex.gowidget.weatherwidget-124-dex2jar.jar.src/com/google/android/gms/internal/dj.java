package com.google.android.gms.internal;

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

public class dj
{
  private static final dj qJ = new dj();
  public static final String qK = qJ.qL;
  private final Object li = new Object();
  public final String qL = br();
  private final dk qM = new dk(this.qL);
  private BigInteger qN = BigInteger.ONE;
  private final HashSet<di> qO = new HashSet();
  private final HashMap<String, dm> qP = new HashMap();
  
  public static Bundle a(dl paramdl, String paramString)
  {
    return qJ.b(paramdl, paramString);
  }
  
  public static void b(HashSet<di> paramHashSet)
  {
    qJ.c(paramHashSet);
  }
  
  public static dj bq()
  {
    return qJ;
  }
  
  private static String br()
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
    return (String)localObject1;
  }
  
  public static String bs()
  {
    return qJ.bt();
  }
  
  public static dk bu()
  {
    return qJ.bv();
  }
  
  public void a(di paramdi)
  {
    synchronized (this.li)
    {
      this.qO.add(paramdi);
      return;
    }
  }
  
  public void a(String paramString, dm paramdm)
  {
    synchronized (this.li)
    {
      this.qP.put(paramString, paramdm);
      return;
    }
  }
  
  public Bundle b(dl paramdl, String paramString)
  {
    Bundle localBundle;
    synchronized (this.li)
    {
      localBundle = new Bundle();
      localBundle.putBundle("app", this.qM.q(paramString));
      paramString = new Bundle();
      localIterator = this.qP.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramString.putBundle(str, ((dm)this.qP.get(str)).toBundle());
      }
    }
    localBundle.putBundle("slots", paramString);
    paramString = new ArrayList();
    Iterator localIterator = this.qO.iterator();
    while (localIterator.hasNext()) {
      paramString.add(((di)localIterator.next()).toBundle());
    }
    localBundle.putParcelableArrayList("ads", paramString);
    paramdl.a(this.qO);
    this.qO.clear();
    return localBundle;
  }
  
  public String bt()
  {
    synchronized (this.li)
    {
      String str = this.qN.toString();
      this.qN = this.qN.add(BigInteger.ONE);
      return str;
    }
  }
  
  public dk bv()
  {
    synchronized (this.li)
    {
      dk localdk = this.qM;
      return localdk;
    }
  }
  
  public void c(HashSet<di> paramHashSet)
  {
    synchronized (this.li)
    {
      this.qO.addAll(paramHashSet);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
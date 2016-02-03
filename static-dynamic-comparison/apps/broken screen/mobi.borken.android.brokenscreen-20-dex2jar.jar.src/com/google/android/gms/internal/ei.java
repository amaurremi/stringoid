package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ei
{
  private static final ei rM = new ei();
  public static final String rN = rM.rO;
  private final Object lq = new Object();
  public final String rO = ep.bO();
  private final ej rP = new ej(this.rO);
  private BigInteger rQ = BigInteger.ONE;
  private final HashSet<eh> rR = new HashSet();
  private final HashMap<String, el> rS = new HashMap();
  private boolean rT = false;
  
  public static Bundle a(Context paramContext, ek paramek, String paramString)
  {
    return rM.b(paramContext, paramek, paramString);
  }
  
  public static void b(HashSet<eh> paramHashSet)
  {
    rM.c(paramHashSet);
  }
  
  public static ei bC()
  {
    return rM;
  }
  
  public static String bD()
  {
    return rM.bE();
  }
  
  public static ej bF()
  {
    return rM.bG();
  }
  
  public static boolean bH()
  {
    return rM.bI();
  }
  
  public void a(eh parameh)
  {
    synchronized (this.lq)
    {
      this.rR.add(parameh);
      return;
    }
  }
  
  public void a(String paramString, el paramel)
  {
    synchronized (this.lq)
    {
      this.rS.put(paramString, paramel);
      return;
    }
  }
  
  public Bundle b(Context paramContext, ek paramek, String paramString)
  {
    Bundle localBundle;
    synchronized (this.lq)
    {
      localBundle = new Bundle();
      localBundle.putBundle("app", this.rP.b(paramContext, paramString));
      paramContext = new Bundle();
      paramString = this.rS.keySet().iterator();
      if (paramString.hasNext())
      {
        String str = (String)paramString.next();
        paramContext.putBundle(str, ((el)this.rS.get(str)).toBundle());
      }
    }
    localBundle.putBundle("slots", paramContext);
    paramContext = new ArrayList();
    paramString = this.rR.iterator();
    while (paramString.hasNext()) {
      paramContext.add(((eh)paramString.next()).toBundle());
    }
    localBundle.putParcelableArrayList("ads", paramContext);
    paramek.a(this.rR);
    this.rR.clear();
    return localBundle;
  }
  
  public String bE()
  {
    synchronized (this.lq)
    {
      String str = this.rQ.toString();
      this.rQ = this.rQ.add(BigInteger.ONE);
      return str;
    }
  }
  
  public ej bG()
  {
    synchronized (this.lq)
    {
      ej localej = this.rP;
      return localej;
    }
  }
  
  public boolean bI()
  {
    synchronized (this.lq)
    {
      boolean bool = this.rT;
      this.rT = true;
      return bool;
    }
  }
  
  public void c(HashSet<eh> paramHashSet)
  {
    synchronized (this.lq)
    {
      this.rR.addAll(paramHashSet);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
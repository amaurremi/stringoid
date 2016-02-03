package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class eh
{
  private static final eh rP = new eh();
  public static final String rQ = rP.rR;
  private final Object ls = new Object();
  public final String rR = eo.bT();
  private final ei rS = new ei(this.rR);
  private BigInteger rT = BigInteger.ONE;
  private final HashSet<eg> rU = new HashSet();
  private final HashMap<String, ek> rV = new HashMap();
  private boolean rW = false;
  
  public static Bundle a(Context paramContext, ej paramej, String paramString)
  {
    return rP.b(paramContext, paramej, paramString);
  }
  
  public static void b(HashSet<eg> paramHashSet)
  {
    rP.c(paramHashSet);
  }
  
  public static eh bH()
  {
    return rP;
  }
  
  public static String bI()
  {
    return rP.bJ();
  }
  
  public static ei bK()
  {
    return rP.bL();
  }
  
  public static boolean bM()
  {
    return rP.bN();
  }
  
  public void a(eg parameg)
  {
    synchronized (this.ls)
    {
      this.rU.add(parameg);
      return;
    }
  }
  
  public void a(String paramString, ek paramek)
  {
    synchronized (this.ls)
    {
      this.rV.put(paramString, paramek);
      return;
    }
  }
  
  public Bundle b(Context paramContext, ej paramej, String paramString)
  {
    Bundle localBundle;
    synchronized (this.ls)
    {
      localBundle = new Bundle();
      localBundle.putBundle("app", this.rS.b(paramContext, paramString));
      paramContext = new Bundle();
      paramString = this.rV.keySet().iterator();
      if (paramString.hasNext())
      {
        String str = (String)paramString.next();
        paramContext.putBundle(str, ((ek)this.rV.get(str)).toBundle());
      }
    }
    localBundle.putBundle("slots", paramContext);
    paramContext = new ArrayList();
    paramString = this.rU.iterator();
    while (paramString.hasNext()) {
      paramContext.add(((eg)paramString.next()).toBundle());
    }
    localBundle.putParcelableArrayList("ads", paramContext);
    paramej.a(this.rU);
    this.rU.clear();
    return localBundle;
  }
  
  public String bJ()
  {
    synchronized (this.ls)
    {
      String str = this.rT.toString();
      this.rT = this.rT.add(BigInteger.ONE);
      return str;
    }
  }
  
  public ei bL()
  {
    synchronized (this.ls)
    {
      ei localei = this.rS;
      return localei;
    }
  }
  
  public boolean bN()
  {
    synchronized (this.ls)
    {
      boolean bool = this.rW;
      this.rW = true;
      return bool;
    }
  }
  
  public void c(HashSet<eg> paramHashSet)
  {
    synchronized (this.ls)
    {
      this.rU.addAll(paramHashSet);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/eh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
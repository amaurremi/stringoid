package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.i;
import com.google.android.gms.internal.c.j;
import com.google.android.gms.internal.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container
{
  private final String aet;
  private final DataLayer aeu;
  private cj aev;
  private Map<String, Container.FunctionCallMacroCallback> aew = new HashMap();
  private Map<String, Container.FunctionCallTagCallback> aex = new HashMap();
  private volatile long aey;
  private volatile String aez = "";
  private final Context mContext;
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, c.j paramj)
  {
    this.mContext = paramContext;
    this.aeu = paramDataLayer;
    this.aet = paramString;
    this.aey = paramLong;
    a(paramj.fK);
    if (paramj.fJ != null) {
      a(paramj.fJ);
    }
  }
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, cq.c paramc)
  {
    this.mContext = paramContext;
    this.aeu = paramDataLayer;
    this.aet = paramString;
    this.aey = paramLong;
    a(paramc);
  }
  
  private void a(c.f paramf)
  {
    if (paramf == null) {
      throw new NullPointerException();
    }
    try
    {
      cq.c localc = cq.a(paramf);
      a(localc);
      return;
    }
    catch (cq.g localg)
    {
      as.a("Not loading resource: " + paramf + " because it is invalid: " + localg.toString());
    }
  }
  
  private void a(cj paramcj)
  {
    try
    {
      this.aev = paramcj;
      return;
    }
    finally
    {
      paramcj = finally;
      throw paramcj;
    }
  }
  
  private void a(cq.c paramc)
  {
    this.aez = paramc.getVersion();
    p localp = bI(this.aez);
    a(new cj(this.mContext, paramc, this.aeu, new b(this, null), new c(this, null), localp));
  }
  
  private void a(c.i[] paramArrayOfi)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfi.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfi[i]);
      i += 1;
    }
    ln().a(localArrayList);
  }
  
  private cj ln()
  {
    try
    {
      cj localcj = this.aev;
      return localcj;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  Container.FunctionCallMacroCallback bF(String paramString)
  {
    synchronized (this.aew)
    {
      paramString = (Container.FunctionCallMacroCallback)this.aew.get(paramString);
      return paramString;
    }
  }
  
  Container.FunctionCallTagCallback bG(String paramString)
  {
    synchronized (this.aex)
    {
      paramString = (Container.FunctionCallTagCallback)this.aex.get(paramString);
      return paramString;
    }
  }
  
  void bH(String paramString)
  {
    ln().a(paramString);
  }
  
  p bI(String paramString)
  {
    if (br.a().b().equals(bs.c)) {}
    return new bb();
  }
  
  public boolean getBoolean(String paramString)
  {
    cj localcj = ln();
    if (localcj == null)
    {
      as.a("getBoolean called for closed container.");
      return de.d().booleanValue();
    }
    try
    {
      boolean bool = de.e((d.a)localcj.b(paramString).a()).booleanValue();
      return bool;
    }
    catch (Exception paramString)
    {
      as.a("Calling getBoolean() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return de.d().booleanValue();
  }
  
  public String getContainerId()
  {
    return this.aet;
  }
  
  public double getDouble(String paramString)
  {
    cj localcj = ln();
    if (localcj == null)
    {
      as.a("getDouble called for closed container.");
      return de.c().doubleValue();
    }
    try
    {
      double d = de.d((d.a)localcj.b(paramString).a()).doubleValue();
      return d;
    }
    catch (Exception paramString)
    {
      as.a("Calling getDouble() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return de.c().doubleValue();
  }
  
  public long getLastRefreshTime()
  {
    return this.aey;
  }
  
  public long getLong(String paramString)
  {
    cj localcj = ln();
    if (localcj == null)
    {
      as.a("getLong called for closed container.");
      return de.b().longValue();
    }
    try
    {
      long l = de.c((d.a)localcj.b(paramString).a()).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      as.a("Calling getLong() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return de.b().longValue();
  }
  
  public String getString(String paramString)
  {
    cj localcj = ln();
    if (localcj == null)
    {
      as.a("getString called for closed container.");
      return de.f();
    }
    try
    {
      paramString = de.a((d.a)localcj.b(paramString).a());
      return paramString;
    }
    catch (Exception paramString)
    {
      as.a("Calling getString() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return de.f();
  }
  
  public boolean isDefault()
  {
    return getLastRefreshTime() == 0L;
  }
  
  String lm()
  {
    return this.aez;
  }
  
  public void registerFunctionCallMacroCallback(String paramString, Container.FunctionCallMacroCallback paramFunctionCallMacroCallback)
  {
    if (paramFunctionCallMacroCallback == null) {
      throw new NullPointerException("Macro handler must be non-null");
    }
    synchronized (this.aew)
    {
      this.aew.put(paramString, paramFunctionCallMacroCallback);
      return;
    }
  }
  
  public void registerFunctionCallTagCallback(String paramString, Container.FunctionCallTagCallback paramFunctionCallTagCallback)
  {
    if (paramFunctionCallTagCallback == null) {
      throw new NullPointerException("Tag callback must be non-null");
    }
    synchronized (this.aex)
    {
      this.aex.put(paramString, paramFunctionCallTagCallback);
      return;
    }
  }
  
  void release()
  {
    this.aev = null;
  }
  
  public void unregisterFunctionCallMacroCallback(String paramString)
  {
    synchronized (this.aew)
    {
      this.aew.remove(paramString);
      return;
    }
  }
  
  public void unregisterFunctionCallTagCallback(String paramString)
  {
    synchronized (this.aex)
    {
      this.aex.remove(paramString);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/Container.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
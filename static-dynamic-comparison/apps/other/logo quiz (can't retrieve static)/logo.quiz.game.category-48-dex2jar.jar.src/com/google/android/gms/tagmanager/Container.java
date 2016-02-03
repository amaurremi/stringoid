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
  private final String anR;
  private final DataLayer anS;
  private ct anT;
  private Map<String, FunctionCallMacroCallback> anU = new HashMap();
  private Map<String, FunctionCallTagCallback> anV = new HashMap();
  private volatile long anW;
  private volatile String anX = "";
  private final Context mContext;
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, c.j paramj)
  {
    this.mContext = paramContext;
    this.anS = paramDataLayer;
    this.anR = paramString;
    this.anW = paramLong;
    a(paramj.gs);
    if (paramj.gr != null) {
      a(paramj.gr);
    }
  }
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, cr.c paramc)
  {
    this.mContext = paramContext;
    this.anS = paramDataLayer;
    this.anR = paramString;
    this.anW = paramLong;
    a(paramc);
  }
  
  private void a(c.f paramf)
  {
    if (paramf == null) {
      throw new NullPointerException();
    }
    try
    {
      cr.c localc = cr.b(paramf);
      a(localc);
      return;
    }
    catch (cr.g localg)
    {
      bh.T("Not loading resource: " + paramf + " because it is invalid: " + localg.toString());
    }
  }
  
  private void a(cr.c paramc)
  {
    this.anX = paramc.getVersion();
    ag localag = cn(this.anX);
    a(new ct(this.mContext, paramc, this.anS, new a(null), new b(null), localag));
  }
  
  private void a(ct paramct)
  {
    try
    {
      this.anT = paramct;
      return;
    }
    finally
    {
      paramct = finally;
      throw paramct;
    }
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
    nR().k(localArrayList);
  }
  
  private ct nR()
  {
    try
    {
      ct localct = this.anT;
      return localct;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  FunctionCallMacroCallback ck(String paramString)
  {
    synchronized (this.anU)
    {
      paramString = (FunctionCallMacroCallback)this.anU.get(paramString);
      return paramString;
    }
  }
  
  FunctionCallTagCallback cl(String paramString)
  {
    synchronized (this.anV)
    {
      paramString = (FunctionCallTagCallback)this.anV.get(paramString);
      return paramString;
    }
  }
  
  void cm(String paramString)
  {
    nR().cm(paramString);
  }
  
  ag cn(String paramString)
  {
    if (ce.oH().oI().equals(ce.a.apY)) {}
    return new br();
  }
  
  public boolean getBoolean(String paramString)
  {
    ct localct = nR();
    if (localct == null)
    {
      bh.T("getBoolean called for closed container.");
      return di.pF().booleanValue();
    }
    try
    {
      boolean bool = di.n((d.a)localct.cO(paramString).getObject()).booleanValue();
      return bool;
    }
    catch (Exception paramString)
    {
      bh.T("Calling getBoolean() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return di.pF().booleanValue();
  }
  
  public String getContainerId()
  {
    return this.anR;
  }
  
  public double getDouble(String paramString)
  {
    ct localct = nR();
    if (localct == null)
    {
      bh.T("getDouble called for closed container.");
      return di.pE().doubleValue();
    }
    try
    {
      double d = di.m((d.a)localct.cO(paramString).getObject()).doubleValue();
      return d;
    }
    catch (Exception paramString)
    {
      bh.T("Calling getDouble() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return di.pE().doubleValue();
  }
  
  public long getLastRefreshTime()
  {
    return this.anW;
  }
  
  public long getLong(String paramString)
  {
    ct localct = nR();
    if (localct == null)
    {
      bh.T("getLong called for closed container.");
      return di.pD().longValue();
    }
    try
    {
      long l = di.l((d.a)localct.cO(paramString).getObject()).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      bh.T("Calling getLong() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return di.pD().longValue();
  }
  
  public String getString(String paramString)
  {
    ct localct = nR();
    if (localct == null)
    {
      bh.T("getString called for closed container.");
      return di.pH();
    }
    try
    {
      paramString = di.j((d.a)localct.cO(paramString).getObject());
      return paramString;
    }
    catch (Exception paramString)
    {
      bh.T("Calling getString() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return di.pH();
  }
  
  public boolean isDefault()
  {
    return getLastRefreshTime() == 0L;
  }
  
  String nQ()
  {
    return this.anX;
  }
  
  public void registerFunctionCallMacroCallback(String paramString, FunctionCallMacroCallback paramFunctionCallMacroCallback)
  {
    if (paramFunctionCallMacroCallback == null) {
      throw new NullPointerException("Macro handler must be non-null");
    }
    synchronized (this.anU)
    {
      this.anU.put(paramString, paramFunctionCallMacroCallback);
      return;
    }
  }
  
  public void registerFunctionCallTagCallback(String paramString, FunctionCallTagCallback paramFunctionCallTagCallback)
  {
    if (paramFunctionCallTagCallback == null) {
      throw new NullPointerException("Tag callback must be non-null");
    }
    synchronized (this.anV)
    {
      this.anV.put(paramString, paramFunctionCallTagCallback);
      return;
    }
  }
  
  void release()
  {
    this.anT = null;
  }
  
  public void unregisterFunctionCallMacroCallback(String paramString)
  {
    synchronized (this.anU)
    {
      this.anU.remove(paramString);
      return;
    }
  }
  
  public void unregisterFunctionCallTagCallback(String paramString)
  {
    synchronized (this.anV)
    {
      this.anV.remove(paramString);
      return;
    }
  }
  
  public static abstract interface FunctionCallMacroCallback
  {
    public abstract Object getValue(String paramString, Map<String, Object> paramMap);
  }
  
  public static abstract interface FunctionCallTagCallback
  {
    public abstract void execute(String paramString, Map<String, Object> paramMap);
  }
  
  private class a
    implements s.a
  {
    private a() {}
    
    public Object b(String paramString, Map<String, Object> paramMap)
    {
      Container.FunctionCallMacroCallback localFunctionCallMacroCallback = Container.this.ck(paramString);
      if (localFunctionCallMacroCallback == null) {
        return null;
      }
      return localFunctionCallMacroCallback.getValue(paramString, paramMap);
    }
  }
  
  private class b
    implements s.a
  {
    private b() {}
    
    public Object b(String paramString, Map<String, Object> paramMap)
    {
      Container.FunctionCallTagCallback localFunctionCallTagCallback = Container.this.cl(paramString);
      if (localFunctionCallTagCallback != null) {
        localFunctionCallTagCallback.execute(paramString, paramMap);
      }
      return di.pH();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/Container.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
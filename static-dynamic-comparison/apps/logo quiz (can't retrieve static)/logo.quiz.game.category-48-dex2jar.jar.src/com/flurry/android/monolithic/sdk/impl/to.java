package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.HashMap;

public class to
{
  private final tq[] a;
  private final HashMap<String, Integer> b;
  private final String[] c;
  private final afz[] d;
  
  protected to(to paramto)
  {
    this.a = paramto.a;
    this.b = paramto.b;
    int i = this.a.length;
    this.c = new String[i];
    this.d = new afz[i];
  }
  
  protected to(tq[] paramArrayOftq, HashMap<String, Integer> paramHashMap, String[] paramArrayOfString, afz[] paramArrayOfafz)
  {
    this.a = paramArrayOftq;
    this.b = paramHashMap;
    this.c = paramArrayOfString;
    this.d = paramArrayOfafz;
  }
  
  public to a()
  {
    return new to(this);
  }
  
  public Object a(ow paramow, qm paramqm, Object paramObject)
    throws IOException, oz
  {
    int i = 0;
    int j = this.a.length;
    if (i < j)
    {
      if (this.c[i] == null) {
        if (this.d[i] != null) {}
      }
      for (;;)
      {
        i += 1;
        break;
        throw paramqm.b("Missing external type id property '" + this.a[i].a());
        if (this.d[i] == null)
        {
          paramow = this.a[i].b();
          throw paramqm.b("Missing property '" + paramow.c() + "' for external type id '" + this.a[i].a());
        }
        a(paramow, paramqm, paramObject, i);
      }
    }
    return paramObject;
  }
  
  protected final void a(ow paramow, qm paramqm, Object paramObject, int paramInt)
    throws IOException, oz
  {
    afz localafz = new afz(paramow.a());
    localafz.b();
    localafz.b(this.c[paramInt]);
    ow localow = this.d[paramInt].a(paramow);
    localow.b();
    localafz.c(localow);
    localafz.c();
    paramow = localafz.a(paramow);
    paramow.b();
    this.a[paramInt].b().a(paramow, paramqm, paramObject);
  }
  
  public boolean a(ow paramow, qm paramqm, String paramString, Object paramObject)
    throws IOException, oz
  {
    int j = 0;
    Integer localInteger = (Integer)this.b.get(paramString);
    if (localInteger == null) {
      return false;
    }
    int k = localInteger.intValue();
    int i;
    if (this.a[k].a(paramString))
    {
      this.c[k] = paramow.k();
      paramow.d();
      if ((paramObject != null) && (this.d[k] != null)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        a(paramow, paramqm, paramObject, k);
        this.c[k] = null;
        this.d[k] = null;
      }
      return true;
      i = 0;
      continue;
      paramString = new afz(paramow.a());
      paramString.c(paramow);
      this.d[k] = paramString;
      i = j;
      if (paramObject != null)
      {
        i = j;
        if (this.c[k] != null) {
          i = 1;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/to.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
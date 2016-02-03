package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public final class xm
  implements Iterable<xl>
{
  protected LinkedHashMap<xy, xl> a;
  
  public xl a(String paramString, Class<?>[] paramArrayOfClass)
  {
    if (this.a == null) {
      return null;
    }
    return (xl)this.a.get(new xy(paramString, paramArrayOfClass));
  }
  
  public xl a(Method paramMethod)
  {
    if (this.a != null) {
      return (xl)this.a.remove(new xy(paramMethod));
    }
    return null;
  }
  
  public void a(xl paramxl)
  {
    if (this.a == null) {
      this.a = new LinkedHashMap();
    }
    this.a.put(new xy(paramxl.e()), paramxl);
  }
  
  public boolean a()
  {
    return (this.a == null) || (this.a.size() == 0);
  }
  
  public xl b(Method paramMethod)
  {
    if (this.a == null) {
      return null;
    }
    return (xl)this.a.get(new xy(paramMethod));
  }
  
  public Iterator<xl> iterator()
  {
    if (this.a != null) {
      return this.a.values().iterator();
    }
    return Collections.emptyList().iterator();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
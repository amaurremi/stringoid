package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Constructor;
import java.util.HashMap;

public class wu
{
  protected final HashMap<afm, rc> a = new HashMap();
  
  protected wu()
  {
    a(new wf());
    a(new wg());
    a(new wi());
    a(new wp());
    a(new wn());
    a(new wo());
    a(new wm());
    a(new wk());
    a(new wj());
    a(new wh());
    a(new wt());
  }
  
  public static rc a(aed<?> paramaed)
  {
    return new wl(paramaed, null);
  }
  
  public static rc a(aed<?> paramaed, xl paramxl)
  {
    return new wl(paramaed, paramxl);
  }
  
  public static rc a(qk paramqk, afm paramafm)
  {
    return ws.a(paramafm.getClass());
  }
  
  public static HashMap<afm, rc> a()
  {
    return new wu().a;
  }
  
  private void a(we paramwe)
  {
    Class localClass = paramwe.a();
    this.a.put(adk.a().a(localClass), paramwe);
  }
  
  public static rc b(qk paramqk, afm paramafm)
  {
    paramafm = (xq)paramqk.b(paramafm);
    Constructor localConstructor = paramafm.a(new Class[] { String.class });
    if (localConstructor != null)
    {
      if (paramqk.a(ql.f)) {
        adz.a(localConstructor);
      }
      return new wq(localConstructor);
    }
    paramafm = paramafm.b(new Class[] { String.class });
    if (paramafm != null)
    {
      if (paramqk.a(ql.f)) {
        adz.a(paramafm);
      }
      return new wr(paramafm);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/wu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
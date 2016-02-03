package com.flurry.android.monolithic.sdk.impl;

import java.util.HashMap;

public class vd
{
  static final vd b = new vd();
  HashMap<afm, qu<Object>> a = new HashMap();
  
  protected vd()
  {
    a(Boolean.TYPE, new vf());
    a(Byte.TYPE, new vg());
    a(Short.TYPE, new vm());
    a(Integer.TYPE, new vk());
    a(Long.TYPE, new vl());
    a(Float.TYPE, new vj());
    a(Double.TYPE, new vi());
    a(String.class, new vn());
    a(Character.TYPE, new vh());
  }
  
  public static HashMap<afm, qu<Object>> a()
  {
    return b.a;
  }
  
  private void a(Class<?> paramClass, qu<?> paramqu)
  {
    this.a.put(adk.a().a(paramClass), paramqu);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
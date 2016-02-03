package com.flurry.android.monolithic.sdk.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class hd
{
  private static HashMap<String, gz> a = new HashMap();
  
  public int a()
  {
    return a.size();
  }
  
  public void a(String paramString1, String paramString2, fz paramfz)
  {
    if (a.containsKey(paramString1))
    {
      ((gz)a.get(paramString1)).a(paramString2, paramfz);
      return;
    }
    gz localgz = new gz(paramString1);
    localgz.a(paramString2, paramfz);
    a.put(paramString1, localgz);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (!a.containsKey(paramString1)) {
      return;
    }
    ((gz)a.get(paramString1)).a(paramString2, paramString3);
  }
  
  public boolean a(String paramString)
  {
    if (!a.containsKey(paramString)) {
      return false;
    }
    a.remove(paramString);
    return true;
  }
  
  public boolean a(String paramString, fz paramfz)
  {
    if (!a.containsKey(paramString)) {
      return false;
    }
    gz localgz = (gz)a.get(paramString);
    boolean bool = localgz.a(paramfz);
    if (localgz.a() == 0) {
      a.remove(paramString);
    }
    return bool;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (!a.containsKey(paramString1)) {
      return false;
    }
    gz localgz = (gz)a.get(paramString1);
    boolean bool = localgz.a(paramString2);
    if (localgz.a() == 0) {
      a.remove(paramString1);
    }
    return bool;
  }
  
  public void b()
  {
    if (a() > 0)
    {
      Iterator localIterator = a.values().iterator();
      while (localIterator.hasNext()) {
        ((gz)localIterator.next()).c();
      }
    }
  }
  
  public boolean b(String paramString)
  {
    if (!a.containsKey(paramString))
    {
      gz localgz = new gz(paramString);
      a.put(paramString, localgz);
    }
    ((gz)a.get(paramString)).b();
    return true;
  }
  
  public void c()
  {
    if (a() > 0)
    {
      Iterator localIterator = a.values().iterator();
      while (localIterator.hasNext()) {
        ((gz)localIterator.next()).d();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/hd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
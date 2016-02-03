package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

final class kf
  extends LinkedHashMap<String, String>
{
  private Set<String> a;
  
  public kf(Set<String> paramSet)
  {
    super(1);
    this.a = paramSet;
  }
  
  public void a(or paramor)
    throws IOException
  {
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramor.a((String)localEntry.getKey(), (String)localEntry.getValue());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.a.contains(paramString1)) {
      throw new jg("Can't set reserved property: " + paramString1);
    }
    if (paramString2 == null) {
      throw new jg("Can't set a property to null: " + paramString1);
    }
    String str = (String)get(paramString1);
    if (str == null) {
      put(paramString1, paramString2);
    }
    while (str.equals(paramString2)) {
      return;
    }
    throw new jg("Can't overwrite property: " + paramString1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/kf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
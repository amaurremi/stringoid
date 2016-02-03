package com.flurry.android.monolithic.sdk.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ob
  implements Iterable<og>
{
  private final List<og> a = new LinkedList();
  private final Map<String, List<og>> b = new HashMap();
  
  public og a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.toLowerCase(Locale.US);
    paramString = (List)this.b.get(paramString);
    if ((paramString != null) && (!paramString.isEmpty())) {
      return (og)paramString.get(0);
    }
    return null;
  }
  
  public void a(og paramog)
  {
    if (paramog == null) {
      return;
    }
    String str = paramog.a().toLowerCase(Locale.US);
    List localList = (List)this.b.get(str);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.b.put(str, localObject);
    }
    ((List)localObject).add(paramog);
    this.a.add(paramog);
  }
  
  public Iterator<og> iterator()
  {
    return Collections.unmodifiableList(this.a).iterator();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
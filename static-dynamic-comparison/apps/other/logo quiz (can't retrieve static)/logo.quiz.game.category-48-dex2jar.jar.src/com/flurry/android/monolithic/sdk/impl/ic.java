package com.flurry.android.monolithic.sdk.impl;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ic
{
  private Map<String, Object> a = new HashMap();
  private Map<String, List<id>> b = new HashMap();
  
  private boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  private void b(String paramString, Object paramObject)
  {
    if (this.b.get(paramString) != null)
    {
      Iterator localIterator = ((List)this.b.get(paramString)).iterator();
      while (localIterator.hasNext()) {
        ((id)localIterator.next()).a(paramString, paramObject);
      }
    }
  }
  
  public Object a(String paramString)
  {
    try
    {
      paramString = this.a.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, id paramid)
  {
    if (paramid == null) {}
    for (;;)
    {
      return;
      try
      {
        List localList = (List)this.b.get(paramString);
        Object localObject = localList;
        if (localList == null) {
          localObject = new LinkedList();
        }
        ((List)localObject).add(paramid);
        this.b.put(paramString, localObject);
      }
      finally {}
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        if (!a(paramObject, this.a.get(paramString))) {
          if (paramObject == null)
          {
            this.a.remove(paramString);
            b(paramString, paramObject);
          }
          else
          {
            this.a.put(paramString, paramObject);
          }
        }
      }
      finally {}
    }
  }
  
  public boolean b(String paramString, id paramid)
  {
    boolean bool;
    if (paramid == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        paramString = (List)this.b.get(paramString);
        if (paramString == null)
        {
          bool = false;
          continue;
        }
        bool = paramString.remove(paramid);
      }
      finally {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.pocket.list.adapter.data;

import com.pocket.n.e;
import org.apache.a.c.k;

public class l
{
  private final ItemQuery a;
  private final ItemQuery b;
  
  private l(ItemQuery paramItemQuery)
  {
    if (paramItemQuery != null) {}
    for (this.a = new ItemQuery(paramItemQuery, null);; this.a = new ItemQuery())
    {
      this.b = paramItemQuery;
      return;
    }
  }
  
  public l a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new RuntimeException("invalid: " + paramInt);
    }
    ItemQuery.a(this.a, paramInt);
    return this;
  }
  
  public l a(ItemQuery paramItemQuery)
  {
    ItemQuery.a(this.a, paramItemQuery);
    return this;
  }
  
  public l a(e parame)
  {
    if (parame != null) {
      parame.a(this);
    }
    return this;
  }
  
  public l a(Boolean paramBoolean)
  {
    ItemQuery.a(this.a, paramBoolean);
    return this;
  }
  
  public l a(Integer paramInteger)
  {
    if (paramInteger != null) {
      switch (paramInteger.intValue())
      {
      default: 
        throw new RuntimeException("invalid: " + paramInteger.intValue());
      }
    }
    ItemQuery.a(this.a, paramInteger);
    return this;
  }
  
  public l a(String paramString)
  {
    ItemQuery.a(this.a, ItemQuery.a(paramString));
    return b("new");
  }
  
  public l a(boolean paramBoolean)
  {
    ItemQuery.a(this.a, paramBoolean);
    return this;
  }
  
  public boolean a()
  {
    if (ItemQuery.a(this.b, this.a))
    {
      ItemQuery.a(this.b, null);
      ItemQuery.a(this.b, null);
      if (ItemQuery.a(this.b) != null) {
        ItemQuery.a(this.b).a(this.b);
      }
      return true;
    }
    return false;
  }
  
  public l b()
  {
    ItemQuery.b(this.a, false);
    ItemQuery.c(this.a, false);
    return this;
  }
  
  public l b(int paramInt)
  {
    ItemQuery.b(this.a, paramInt);
    return this;
  }
  
  public l b(Integer paramInteger)
  {
    if (paramInteger != null) {
      switch (paramInteger.intValue())
      {
      default: 
        throw new RuntimeException("invalid: " + paramInteger.intValue());
      }
    }
    ItemQuery.b(this.a, paramInteger);
    return this;
  }
  
  public l b(String paramString)
  {
    ItemQuery.b(this.a, paramString);
    return this;
  }
  
  public l b(boolean paramBoolean)
  {
    ItemQuery.b(this.a, true);
    ItemQuery.c(this.a, paramBoolean);
    return this;
  }
  
  public l c()
  {
    ItemQuery.e(this.a, null);
    return this;
  }
  
  public l c(Integer paramInteger)
  {
    ItemQuery.c(this.a, paramInteger);
    return this;
  }
  
  public l c(String paramString)
  {
    ItemQuery.c(this.a, ItemQuery.a(paramString));
    return this;
  }
  
  public l d(Integer paramInteger)
  {
    ItemQuery.d(this.a, paramInteger);
    return this;
  }
  
  public l d(String paramString)
  {
    ItemQuery.d(this.a, paramString);
    return this;
  }
  
  public l e(Integer paramInteger)
  {
    if (paramInteger != null) {
      switch (paramInteger.intValue())
      {
      default: 
        throw new RuntimeException("invalid: " + paramInteger.intValue());
      case 0: 
        if (ItemQuery.b(this.a) == null) {
          return this;
        }
        break;
      }
    }
    ItemQuery.e(this.a, paramInteger);
    return this;
  }
  
  public l e(String paramString)
  {
    paramString = " (" + paramString + ") ";
    if (k.c(ItemQuery.c(this.a)))
    {
      ItemQuery.e(this.a, paramString);
      return this;
    }
    ItemQuery.a(this.a, " AND " + paramString);
    return this;
  }
  
  public l f(Integer paramInteger)
  {
    ItemQuery.f(this.a, paramInteger);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/data/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
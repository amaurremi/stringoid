package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class aeo
  extends aet
{
  protected ArrayList<ou> c;
  
  public aeo(aez paramaez)
  {
    super(paramaez);
  }
  
  private boolean a(ArrayList<ou> paramArrayList)
  {
    int j = paramArrayList.size();
    if (o() != j) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (!((ou)this.c.get(i)).equals(paramArrayList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void b(ou paramou)
  {
    if (this.c == null) {
      this.c = new ArrayList();
    }
    this.c.add(paramou);
  }
  
  public ou a(String paramString)
  {
    return null;
  }
  
  public final void a(or paramor, ru paramru)
    throws IOException, oz
  {
    paramor.b();
    if (this.c != null)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((aep)localIterator.next()).a(paramor, paramru);
      }
    }
    paramor.c();
  }
  
  public void a(or paramor, ru paramru, rx paramrx)
    throws IOException, oz
  {
    paramrx.c(this, paramor);
    if (this.c != null)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((aep)localIterator.next()).a(paramor, paramru);
      }
    }
    paramrx.f(this, paramor);
  }
  
  public void a(ou paramou)
  {
    Object localObject = paramou;
    if (paramou == null) {
      localObject = r();
    }
    b((ou)localObject);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (paramObject.getClass() != getClass()) {
        return false;
      }
      paramObject = (aeo)paramObject;
      if ((this.c != null) && (this.c.size() != 0)) {
        break;
      }
    } while (((aeo)paramObject).o() == 0);
    return false;
    return ((aeo)paramObject).a(this.c);
  }
  
  public int hashCode()
  {
    int j;
    if (this.c == null) {
      j = 1;
    }
    int i;
    Iterator localIterator;
    do
    {
      return j;
      i = this.c.size();
      localIterator = this.c.iterator();
      j = i;
    } while (!localIterator.hasNext());
    ou localou = (ou)localIterator.next();
    if (localou != null) {
      i = localou.hashCode() ^ i;
    }
    for (;;)
    {
      break;
    }
  }
  
  public int o()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
  }
  
  public Iterator<ou> p()
  {
    if (this.c == null) {
      return aeu.a();
    }
    return this.c.iterator();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder((o() << 4) + 16);
    localStringBuilder.append('[');
    if (this.c != null)
    {
      int j = this.c.size();
      int i = 0;
      while (i < j)
      {
        if (i > 0) {
          localStringBuilder.append(',');
        }
        localStringBuilder.append(((ou)this.c.get(i)).toString());
        i += 1;
      }
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aeo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
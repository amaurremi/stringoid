package com.android.ex.chips;

import android.database.Cursor;
import android.text.TextUtils;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.ArrayList;
import java.util.Iterator;

final class g
  extends Filter
{
  private final i b;
  private int c;
  
  public g(c paramc, i parami)
  {
    this.b = parami;
  }
  
  public int a()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.c = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    CharSequence localCharSequence = null;
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    localFilterResults.values = null;
    localFilterResults.count = 0;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        paramCharSequence = c.a(this.a, paramCharSequence, a(), Long.valueOf(this.b.a));
        if (paramCharSequence != null) {
          for (;;)
          {
            localCharSequence = paramCharSequence;
            if (!paramCharSequence.moveToNext()) {
              break;
            }
            localCharSequence = paramCharSequence;
            localArrayList.add(new m(paramCharSequence, c.d(this.a)));
          }
        }
        if (paramCharSequence == null) {
          break label123;
        }
      }
      finally
      {
        if (localCharSequence != null) {
          localCharSequence.close();
        }
      }
      paramCharSequence.close();
      label123:
      if (!localArrayList.isEmpty())
      {
        localFilterResults.values = localArrayList;
        localFilterResults.count = 1;
      }
    }
    return localFilterResults;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    c.f(this.a).b();
    if (TextUtils.equals(paramCharSequence, c.g(this.a)))
    {
      if (paramFilterResults.count > 0)
      {
        paramCharSequence = ((ArrayList)paramFilterResults.values).iterator();
        if (paramCharSequence.hasNext())
        {
          paramFilterResults = (m)paramCharSequence.next();
          c localc = this.a;
          if (this.b.a == 0L) {}
          for (boolean bool = true;; bool = false)
          {
            localc.a(paramFilterResults, bool, c.h(this.a), c.i(this.a), c.j(this.a));
            break;
          }
        }
      }
      c.k(this.a);
      if (c.l(this.a) > 0) {
        c.f(this.a).a();
      }
    }
    c.b(this.a, this.a.a(false, c.h(this.a), c.i(this.a), c.j(this.a)));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
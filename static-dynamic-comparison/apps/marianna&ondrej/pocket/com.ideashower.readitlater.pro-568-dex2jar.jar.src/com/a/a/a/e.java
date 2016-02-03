package com.a.a.a;

import android.view.View;
import android.widget.ListAdapter;
import com.a.a.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class e
{
  protected ArrayList a = new ArrayList();
  protected ArrayList b = null;
  
  List a()
  {
    return this.a;
  }
  
  void a(View paramView, boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (((locald.a instanceof a)) && (((a)locald.a).a(paramView)))
      {
        locald.b = paramBoolean;
        this.b = null;
      }
    }
  }
  
  void a(ListAdapter paramListAdapter)
  {
    this.a.add(new d(paramListAdapter, true));
  }
  
  void a(ListAdapter paramListAdapter, boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.a == paramListAdapter)
      {
        locald.b = paramBoolean;
        this.b = null;
      }
    }
  }
  
  List b()
  {
    if (this.b == null)
    {
      this.b = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald.b) {
          this.b.add(locald.a);
        }
      }
    }
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/a/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.a.a.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.SectionIndexer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class a
  extends BaseAdapter
  implements SectionIndexer
{
  protected e a = new e(null);
  
  public ListAdapter a(int paramInt)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ListAdapter localListAdapter = (ListAdapter)localIterator.next();
      int i = localListAdapter.getCount();
      if (paramInt < i) {
        return localListAdapter;
      }
      paramInt -= i;
    }
    return null;
  }
  
  protected List a()
  {
    return this.a.b();
  }
  
  public void a(View paramView)
  {
    a(paramView, false);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramView);
    a(localArrayList, paramBoolean);
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    this.a.a(paramListAdapter);
    paramListAdapter.registerDataSetObserver(new b(this, null));
  }
  
  public void a(ListAdapter paramListAdapter, boolean paramBoolean)
  {
    this.a.a(paramListAdapter, paramBoolean);
    notifyDataSetChanged();
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(new c(paramList));
      return;
    }
    a(new com.a.a.b.a(paramList));
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public void b(View paramView, boolean paramBoolean)
  {
    this.a.a(paramView, paramBoolean);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    Iterator localIterator = a().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((ListAdapter)localIterator.next()).getCount() + i) {}
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ListAdapter localListAdapter = (ListAdapter)localIterator.next();
      int i = localListAdapter.getCount();
      if (paramInt < i) {
        return localListAdapter.getItem(paramInt);
      }
      paramInt -= i;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ListAdapter localListAdapter = (ListAdapter)localIterator.next();
      int i = localListAdapter.getCount();
      if (paramInt < i) {
        return localListAdapter.getItemId(paramInt);
      }
      paramInt -= i;
    }
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    Iterator localIterator = this.a.a().iterator();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      j = i;
      if (locald.b)
      {
        j = locald.a.getCount();
        if (i < j) {
          return locald.a.getItemViewType(i) + paramInt;
        }
        j = i - j;
      }
      paramInt = locald.a.getViewTypeCount() + paramInt;
      i = j;
    }
    return -1;
  }
  
  public int getPositionForSection(int paramInt)
  {
    int m = 0;
    Iterator localIterator = a().iterator();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    j = m;
    ListAdapter localListAdapter;
    Object[] arrayOfObject;
    if (localIterator.hasNext())
    {
      localListAdapter = (ListAdapter)localIterator.next();
      j = i;
      if (!(localListAdapter instanceof SectionIndexer)) {
        break label111;
      }
      arrayOfObject = ((SectionIndexer)localListAdapter).getSections();
      if (arrayOfObject == null) {
        break label126;
      }
    }
    label111:
    label126:
    for (int k = arrayOfObject.length;; k = 0)
    {
      if (i < k)
      {
        j = paramInt + ((SectionIndexer)localListAdapter).getPositionForSection(i);
        return j;
      }
      j = i;
      if (arrayOfObject != null) {
        j = i - k;
      }
      paramInt = localListAdapter.getCount() + paramInt;
      i = j;
      break;
    }
  }
  
  public int getSectionForPosition(int paramInt)
  {
    int k = 0;
    Iterator localIterator = a().iterator();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    j = k;
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = (ListAdapter)localIterator.next();
      j = ((ListAdapter)localObject).getCount();
      if (i >= j) {
        break label85;
      }
      j = k;
      if ((localObject instanceof SectionIndexer)) {
        j = paramInt + ((SectionIndexer)localObject).getSectionForPosition(i);
      }
    }
    return j;
    label85:
    if ((localObject instanceof SectionIndexer))
    {
      localObject = ((SectionIndexer)localObject).getSections();
      if (localObject != null) {
        paramInt += localObject.length;
      }
    }
    for (;;)
    {
      i -= j;
      break;
    }
  }
  
  public Object[] getSections()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ListAdapter)localIterator.next();
      if ((localObject instanceof SectionIndexer))
      {
        localObject = ((SectionIndexer)localObject).getSections();
        if (localObject != null) {
          Collections.addAll(localArrayList, (Object[])localObject);
        }
      }
    }
    if (localArrayList.size() == 0) {
      return new String[0];
    }
    return localArrayList.toArray(new Object[0]);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ListAdapter localListAdapter = (ListAdapter)localIterator.next();
      int i = localListAdapter.getCount();
      if (paramInt < i) {
        return localListAdapter.getView(paramInt, paramView, paramViewGroup);
      }
      paramInt -= i;
    }
    return null;
  }
  
  public int getViewTypeCount()
  {
    Iterator localIterator = this.a.a().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((d)localIterator.next()).a.getViewTypeCount() + i) {}
    return Math.max(i, 1);
  }
  
  public boolean isEnabled(int paramInt)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ListAdapter localListAdapter = (ListAdapter)localIterator.next();
      int i = localListAdapter.getCount();
      if (paramInt < i) {
        return localListAdapter.isEnabled(paramInt);
      }
      paramInt -= i;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.pocket.o.a;

import android.text.TextUtils;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.a.c.k;

class h
  extends Filter
{
  private h(f paramf) {}
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject = new ArrayList(f.c(this.a));
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      int i;
      if (paramCharSequence.length() >= 2)
      {
        i = 1;
        localObject = ((ArrayList)localObject).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label139;
        }
        String str = (String)((Iterator)localObject).next();
        if (k.h(str, paramCharSequence))
        {
          localArrayList2.add(str);
          continue;
          i = 0;
          break;
        }
        if ((i != 0) && (k.c(str, paramCharSequence))) {
          localArrayList3.add(str);
        }
      }
      label139:
      localArrayList1.addAll(localArrayList2);
      localArrayList1.addAll(localArrayList3);
    }
    for (;;)
    {
      localArrayList1.removeAll(this.a.f().d());
      paramCharSequence = new Filter.FilterResults();
      paramCharSequence.values = localArrayList1;
      paramCharSequence.count = localArrayList1.size();
      return paramCharSequence;
      localArrayList1.addAll(f.c(this.a));
    }
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    paramCharSequence = (ArrayList)paramFilterResults.values;
    f.a(this.a).clear();
    f.a(this.a).addAll(paramCharSequence);
    f.b(this.a).notifyDataSetChanged();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/o/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
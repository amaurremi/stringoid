package com.go.weatherex.b.a;

import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class b
  implements e
{
  b(a parama) {}
  
  public void a()
  {
    Iterator localIterator = a.a(this.a).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      ViewGroup localViewGroup = (ViewGroup)((Map.Entry)localObject).getKey();
      localObject = (c)((Map.Entry)localObject).getValue();
      if ((localViewGroup != null) && (localObject != null))
      {
        int i = 0;
        while (i < localViewGroup.getChildCount())
        {
          localViewGroup.getChildAt(i).setOnClickListener(null);
          i += 1;
        }
        localViewGroup.removeAllViews();
        localViewGroup.addView((View)localObject);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
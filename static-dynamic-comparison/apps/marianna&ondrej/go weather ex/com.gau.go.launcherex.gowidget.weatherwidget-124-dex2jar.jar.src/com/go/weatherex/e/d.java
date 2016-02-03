package com.go.weatherex.e;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

class d
  extends AsyncQueryHandler
{
  public d(a parama, ContentResolver paramContentResolver)
  {
    super(paramContentResolver);
  }
  
  protected void onUpdateComplete(int paramInt1, Object paramObject, int paramInt2)
  {
    super.onUpdateComplete(paramInt1, paramObject, paramInt2);
    if (paramInt2 > 0)
    {
      paramObject = new ArrayList();
      Iterator localIterator = a.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        com.gau.go.launcherex.gowidget.messagecenter.a.d locald = (com.gau.go.launcherex.gowidget.messagecenter.a.d)localIterator.next();
        if (locald.y) {
          ((ArrayList)paramObject).add(locald);
        }
      }
      if (!((ArrayList)paramObject).isEmpty()) {
        a.a(this.a).removeAll((Collection)paramObject);
      }
      a.d(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
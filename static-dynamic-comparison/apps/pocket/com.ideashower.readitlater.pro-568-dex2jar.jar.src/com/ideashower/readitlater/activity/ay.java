package com.ideashower.readitlater.activity;

import com.ideashower.readitlater.util.e;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.adapter.data.l;
import com.pocket.list.widget.PocketView;
import com.pocket.widget.a;

public class ay
  extends a
{
  public boolean a = false;
  
  public ay(SearchActivity paramSearchActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, -1, -1);
    this.a = paramBoolean;
  }
  
  public void a()
  {
    int i;
    switch (this.g)
    {
    default: 
      e.c("unexpected sort value " + this.g);
      return;
    case 0: 
      i = 6;
    }
    for (;;)
    {
      SearchActivity.b(this.b).getQuery().a().a(i).a();
      return;
      i = 0;
      continue;
      i = 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.flurry.android;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class w
  extends LinearLayout
{
  private View a;
  private List b = new ArrayList();
  private boolean c = true;
  
  public w(CatalogActivity paramCatalogActivity, Context paramContext)
  {
    super(paramContext);
    setOrientation(1);
    setGravity(48);
    this.a = new s(paramCatalogActivity, paramContext);
    this.a.setId(10002);
    this.a.setOnClickListener(paramCatalogActivity);
    a(a(paramContext), this.c);
  }
  
  private void a(List paramList, boolean paramBoolean)
  {
    removeAllViews();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(0, 0, 0, 0);
    addView(this.a, localLayoutParams);
    if (paramList != null)
    {
      this.b.clear();
      this.b.addAll(paramList);
    }
    if (paramBoolean)
    {
      paramList = this.b.iterator();
      while (paramList.hasNext())
      {
        y localy = (y)paramList.next();
        addView(localy, localLayoutParams);
        localy.a().a(new f((byte)3, CatalogActivity.b(this.d)));
      }
    }
    refreshDrawableState();
  }
  
  final List a(Context paramContext)
  {
    Object localObject2 = null;
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    while (i <= 3)
    {
      localArrayList.add("Flurry_Canvas_Hook_" + i);
      i += 1;
    }
    if (CatalogActivity.a(this.d) == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label138;
      }
    }
    label138:
    for (Object localObject1 = localObject2;; localObject1 = Long.valueOf(((v)localObject1).a))
    {
      paramContext = CatalogActivity.c(this.d).a(paramContext, localArrayList, (Long)localObject1, 1, true);
      localObject1 = paramContext.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((y)((Iterator)localObject1).next()).setOnClickListener(this.d);
      }
      localObject1 = CatalogActivity.a(this.d).b;
      break;
    }
    return paramContext;
  }
  
  final void a()
  {
    if (!this.c) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      a(null, this.c);
      return;
    }
  }
  
  final void a(List paramList)
  {
    a(paramList, this.c);
  }
  
  final List b()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
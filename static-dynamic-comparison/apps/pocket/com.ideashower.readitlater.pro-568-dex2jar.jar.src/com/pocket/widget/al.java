package com.pocket.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.d;
import android.support.v4.app.f;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.ThemedListView;
import com.pocket.p.k;
import java.util.ArrayList;

public class al
{
  private static final boolean a = ;
  private int b;
  private boolean c;
  private LayoutInflater d;
  private an e;
  private PopupWindow f;
  private ArrayList g = new ArrayList();
  private am h;
  private ThemedListView i;
  private Context j;
  
  public al(Context paramContext, ArrayList paramArrayList, boolean paramBoolean, View paramView)
  {
    this.f = new PopupWindow(paramContext);
    this.j = paramContext;
    this.d = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    View localView = this.d.inflate(2130903155, null);
    this.i = ((ThemedListView)localView.findViewById(2131231075));
    this.i.setWrapWidth(true);
    this.e = new an(this, paramContext);
    this.c = paramBoolean;
    if (this.c)
    {
      this.b = 2130903130;
      ArrayList localArrayList = paramArrayList;
      if (paramArrayList == null) {
        localArrayList = new ArrayList();
      }
      this.g = localArrayList;
      this.e.a = new ArrayList(this.g);
      if (paramView == null) {
        break label313;
      }
      paramArrayList = new com.a.a.a.a();
      paramArrayList.a(paramView);
      paramArrayList.a(this.e);
      this.i.setAdapter(paramArrayList);
    }
    for (;;)
    {
      this.i.setBackgroundDrawable(paramContext.getResources().getDrawable(2130837718));
      this.i.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = (a)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
          al.a(al.this).dismiss();
          paramAnonymousAdapterView.a();
        }
      });
      this.i.setDivider(paramContext.getResources().getDrawable(2130837719));
      this.i.setDividerHeight(1);
      this.i.setMinWidth(j.a(200.0F));
      this.f.setBackgroundDrawable(paramContext.getResources().getDrawable(2130837736));
      this.f.setFocusable(true);
      this.f.setContentView(localView);
      this.f.setWidth(-2);
      this.f.setHeight(-2);
      return;
      this.b = 2130903170;
      break;
      label313:
      this.i.setAdapter(this.e);
    }
  }
  
  public static void a(d paramd, final Context paramContext)
  {
    if (!a)
    {
      k.a(paramd, (f)paramContext);
      return;
    }
    g.o().postDelayed(new Runnable()
    {
      public void run()
      {
        k.a(al.this, (f)paramContext);
      }
    }, 300L);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int n = 0;
    int k = 0;
    int m;
    for (;;)
    {
      m = n;
      if (k >= this.g.size()) {
        break;
      }
      if (((a)this.g.get(k)).g == paramInt1) {
        ((a)this.g.get(k)).c = paramInt2;
      }
      k += 1;
    }
    while (m < this.e.a.size())
    {
      if (((a)this.e.a.get(m)).g == paramInt1) {
        ((a)this.e.a.get(m)).c = paramInt2;
      }
      m += 1;
    }
    this.e.notifyDataSetChanged();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (this.e.a(paramInt)) {}
    }
    for (;;)
    {
      return;
      int k = 0;
      while (k < this.e.a.size())
      {
        if (((a)this.e.a.get(k)).g == paramInt)
        {
          this.e.a.remove(k);
          this.e.notifyDataSetChanged();
          return;
        }
        k += 1;
      }
      continue;
      if (!this.e.a(paramInt))
      {
        k = 0;
        while (k < this.g.size())
        {
          if (((a)this.g.get(k)).g == paramInt)
          {
            this.e.a.add(k, this.g.get(k));
            this.e.notifyDataSetChanged();
            return;
          }
          k += 1;
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    if (this.h != null) {
      this.h.a(this.e.a, this.i);
    }
    this.f.showAsDropDown(paramView, j.a(-15.0F), j.a(-9.0F));
  }
  
  public void a(am paramam)
  {
    this.h = paramam;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
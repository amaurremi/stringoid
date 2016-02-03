package com.gau.go.launcherex.gowidget.weather.globalview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class t
  extends f
  implements DialogInterface.OnDismissListener, View.OnClickListener, AdapterView.OnItemClickListener
{
  private TextView b;
  private TextView c;
  private ListView d;
  private final ArrayList e = new ArrayList();
  private x f;
  private int g;
  private int h;
  private int i;
  private w j;
  private boolean k;
  private LinearLayout l;
  
  public t(Activity paramActivity)
  {
    super(paramActivity);
    setCanceledOnTouchOutside(true);
    setContentView(2130903119);
    this.b = ((TextView)findViewById(2131230797));
    this.c = ((TextView)findViewById(2131231260));
    this.l = ((LinearLayout)findViewById(2131231274));
    this.c.setOnClickListener(this);
    this.d = ((ListView)findViewById(2131231269));
    this.f = new x(this, null);
    this.d.setAdapter(this.f);
    this.d.setOnItemClickListener(this);
    paramActivity = this.a.getResources().getDisplayMetrics();
    this.g = ((int)(Math.min(paramActivity.widthPixels, paramActivity.heightPixels) - paramActivity.density * 40.0F));
    this.h = this.a.getResources().getDimensionPixelSize(2131427831);
    setOnDismissListener(this);
    c(0);
    a(findViewById(2131230828), 2, true);
    a(this.b, 4, true);
  }
  
  private boolean b(ArrayList paramArrayList)
  {
    boolean bool2 = false;
    paramArrayList = paramArrayList.iterator();
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramArrayList.hasNext())
      {
        if (((a)paramArrayList.next()).b)
        {
          int n = m + 1;
          m = n;
          if (n > 1) {
            bool1 = true;
          }
        }
      }
      else {
        return bool1;
      }
    }
  }
  
  private String d(int paramInt)
  {
    return this.a.getString(paramInt);
  }
  
  public void a()
  {
    this.k = false;
    a(17, 0, 0, this.g, -2);
  }
  
  public void a(int paramInt)
  {
    this.l.setVisibility(paramInt);
  }
  
  public void a(w paramw)
  {
    this.j = paramw;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.b.setText(paramCharSequence);
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.e.clear();
    if (paramArrayList != null)
    {
      if (b(paramArrayList)) {
        throw new IllegalArgumentException("choiceItemDatas have more than one be set to check!");
      }
      this.e.addAll(paramArrayList);
    }
    this.f.notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    a(d(paramInt));
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
    ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
    if (this.i > 0)
    {
      paramInt = this.h * this.i;
      if (localLayoutParams != null) {
        break label66;
      }
      localLayoutParams = new ViewGroup.LayoutParams(-1, paramInt);
    }
    for (;;)
    {
      this.d.setLayoutParams(localLayoutParams);
      this.d.requestLayout();
      return;
      paramInt = -2;
      break;
      label66:
      localLayoutParams.height = paramInt;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.c))
    {
      this.k = false;
      dismiss();
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.j != null)
    {
      Iterator localIterator = this.e.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramDialogInterface = (a)localIterator.next();
      } while (!paramDialogInterface.b);
    }
    for (;;)
    {
      this.j.a(this, this.k, paramDialogInterface);
      return;
      paramDialogInterface = null;
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((v)paramView.getTag()).a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globalview/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
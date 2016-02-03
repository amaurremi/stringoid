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
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class i
  extends f
  implements DialogInterface.OnDismissListener, View.OnClickListener, AdapterView.OnItemClickListener
{
  private TextView b;
  private TextView c;
  private TextView d;
  private ListView e;
  private final ArrayList f = new ArrayList();
  private l g;
  private int h;
  private int i;
  private int j;
  private m k;
  private boolean l;
  
  public i(Activity paramActivity)
  {
    super(paramActivity);
    setCanceledOnTouchOutside(true);
    setContentView(2130903114);
    this.b = ((TextView)findViewById(2131230797));
    this.c = ((TextView)findViewById(2131231261));
    this.c.setOnClickListener(this);
    this.d = ((TextView)findViewById(2131231260));
    this.d.setOnClickListener(this);
    this.e = ((ListView)findViewById(2131231269));
    this.g = new l(this, null);
    this.e.setAdapter(this.g);
    this.e.setOnItemClickListener(this);
    paramActivity = this.a.getResources().getDisplayMetrics();
    this.h = ((int)(Math.min(paramActivity.widthPixels, paramActivity.heightPixels) - paramActivity.density * 40.0F));
    this.i = this.a.getResources().getDimensionPixelSize(2131427831);
    setOnDismissListener(this);
    b(0);
    a(findViewById(2131230828), 2, true);
    a(this.b, 4, true);
  }
  
  private String c(int paramInt)
  {
    return this.a.getString(paramInt);
  }
  
  public void a()
  {
    this.l = false;
    a(17, 0, 0, this.h, -2);
  }
  
  public void a(int paramInt)
  {
    a(c(paramInt));
  }
  
  public void a(m paramm)
  {
    this.k = paramm;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.b.setText(paramCharSequence);
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.f.clear();
    if (paramArrayList != null) {
      this.f.addAll(paramArrayList);
    }
    this.g.notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
    ViewGroup.LayoutParams localLayoutParams = this.e.getLayoutParams();
    if (this.j > 0)
    {
      paramInt = this.i * this.j;
      if (localLayoutParams != null) {
        break label66;
      }
      localLayoutParams = new ViewGroup.LayoutParams(-1, paramInt);
    }
    for (;;)
    {
      this.e.setLayoutParams(localLayoutParams);
      this.e.requestLayout();
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
      this.l = true;
      dismiss();
    }
    while (!paramView.equals(this.d)) {
      return;
    }
    this.l = false;
    dismiss();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.k != null)
    {
      paramDialogInterface = new ArrayList();
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.b) {
          paramDialogInterface.add(locala);
        }
      }
      this.k.a(this, this.l, paramDialogInterface);
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((k)paramView.getTag()).a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globalview/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.gau.go.launcherex.gowidget.weather.globalview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class g
  extends f
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private boolean b = false;
  private h c;
  private TextView d;
  private ImageView e;
  private TextView f;
  private View g;
  private View h;
  private TextView i;
  private TextView j;
  private ImageView k;
  private ImageView l;
  private int m;
  
  public g(Activity paramActivity)
  {
    super(paramActivity);
    setContentView(2130903112);
    paramActivity = this.a.getResources().getDisplayMetrics();
    this.m = ((int)(Math.min(paramActivity.widthPixels, paramActivity.heightPixels) - paramActivity.density * 40.0F));
    paramActivity = getWindow().getAttributes();
    paramActivity.width = this.m;
    paramActivity.height = -2;
    this.d = ((TextView)findViewById(2131230797));
    this.e = ((ImageView)findViewById(2131231262));
    this.f = ((TextView)findViewById(2131231257));
    this.g = findViewById(2131231261);
    this.i = ((TextView)findViewById(2131231266));
    this.k = ((ImageView)findViewById(2131231265));
    this.h = findViewById(2131231260);
    this.j = ((TextView)findViewById(2131231264));
    this.l = ((ImageView)findViewById(2131231263));
    setOnDismissListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
  }
  
  private String e(int paramInt)
  {
    return this.a.getString(paramInt);
  }
  
  public void a()
  {
    a(17, 0, 0, this.m, -2);
  }
  
  public void a(int paramInt)
  {
    this.d.setText(e(paramInt));
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.e.setImageBitmap(paramBitmap);
  }
  
  public void a(h paramh)
  {
    this.c = paramh;
  }
  
  public void b(int paramInt)
  {
    this.f.setText(e(paramInt));
  }
  
  public void b(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      this.k.setVisibility(8);
    }
    do
    {
      return;
      this.k.setImageBitmap(paramBitmap);
    } while (this.k.getVisibility() == 0);
    this.k.setVisibility(0);
  }
  
  public void c(int paramInt)
  {
    this.i.setText(e(paramInt));
  }
  
  public void c(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      this.l.setVisibility(8);
    }
    do
    {
      return;
      this.l.setImageBitmap(paramBitmap);
    } while (this.l.getVisibility() == 0);
    this.l.setVisibility(0);
  }
  
  public void d(int paramInt)
  {
    this.j.setText(e(paramInt));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.g))
    {
      this.b = true;
      dismiss();
    }
    while (!paramView.equals(this.h)) {
      return;
    }
    this.b = false;
    dismiss();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.c != null) {
      this.c.a(this.b);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globalview/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
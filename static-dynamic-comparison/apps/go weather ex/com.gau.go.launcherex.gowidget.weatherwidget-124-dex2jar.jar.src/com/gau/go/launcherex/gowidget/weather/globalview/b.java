package com.gau.go.launcherex.gowidget.weather.globalview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class b
  extends f
  implements DialogInterface.OnDismissListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private e b = e.a;
  private boolean c = false;
  private c d;
  private d e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private View j;
  private CheckBox k;
  private TextView l;
  private boolean m = false;
  private boolean n = false;
  private int o;
  
  public b(Activity paramActivity)
  {
    this(paramActivity, e.a);
  }
  
  public b(Activity paramActivity, e parame)
  {
    super(paramActivity);
    this.b = parame;
    if (this.b == e.b) {
      setContentView(2130903110);
    }
    for (;;)
    {
      paramActivity = this.a.getResources().getDisplayMetrics();
      this.o = ((int)(Math.min(paramActivity.widthPixels, paramActivity.heightPixels) - paramActivity.density * 40.0F));
      paramActivity = getWindow().getAttributes();
      paramActivity.width = this.o;
      paramActivity.height = -2;
      this.f = ((TextView)findViewById(2131230797));
      this.g = ((TextView)findViewById(2131231257));
      this.h = ((TextView)findViewById(2131231261));
      this.i = ((TextView)findViewById(2131231260));
      this.j = findViewById(2131231258);
      this.j.setVisibility(8);
      this.k = ((CheckBox)findViewById(2131231256));
      this.k.setChecked(false);
      this.l = ((TextView)findViewById(2131231259));
      setOnDismissListener(this);
      this.h.setOnClickListener(this);
      this.i.setOnClickListener(this);
      this.k.setOnCheckedChangeListener(this);
      this.j.setOnClickListener(this);
      a(findViewById(2131230828), 2, true);
      a(this.f, 4, true);
      return;
      if (this.b == e.c) {
        setContentView(2130903111);
      } else {
        setContentView(2130903109);
      }
    }
  }
  
  private String f(int paramInt)
  {
    return this.a.getString(paramInt);
  }
  
  public void a()
  {
    this.i.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    this.f.setBackgroundColor(paramInt);
  }
  
  public void a(c paramc)
  {
    this.d = paramc;
  }
  
  public void a(d paramd)
  {
    this.e = paramd;
  }
  
  public void a(String paramString)
  {
    this.f.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
    if (this.m)
    {
      this.j.setVisibility(0);
      return;
    }
    this.j.setVisibility(8);
  }
  
  public void b()
  {
    a(17, 0, 0, this.o, -2);
  }
  
  public void b(int paramInt)
  {
    this.f.setText(f(paramInt));
  }
  
  public void b(String paramString)
  {
    this.g.setText(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.n = paramBoolean;
    this.k.setChecked(this.n);
  }
  
  public void c(int paramInt)
  {
    this.g.setText(f(paramInt));
  }
  
  public void c(String paramString)
  {
    this.h.setText(paramString);
  }
  
  public void d(int paramInt)
  {
    this.h.setText(f(paramInt));
  }
  
  public void d(String paramString)
  {
    this.i.setText(paramString);
  }
  
  public void e(int paramInt)
  {
    this.i.setText(f(paramInt));
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.equals(this.k)) {
      this.n = paramBoolean;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.h))
    {
      this.c = true;
      dismiss();
    }
    do
    {
      return;
      if (paramView.equals(this.i))
      {
        this.c = false;
        dismiss();
        return;
      }
    } while (!paramView.equals(this.j));
    this.k.toggle();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.d != null) {
      this.d.a(this.c);
    }
    if (this.e != null) {
      this.e.a(this.c, this.n);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globalview/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
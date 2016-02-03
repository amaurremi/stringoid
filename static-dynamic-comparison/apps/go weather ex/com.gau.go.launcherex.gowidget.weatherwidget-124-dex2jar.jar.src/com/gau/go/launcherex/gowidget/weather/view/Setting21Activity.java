package com.gau.go.launcherex.gowidget.weather.view;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.language.b;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.f;
import java.util.ArrayList;

public class Setting21Activity
  extends GoWeatherEXActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static int u;
  private static int v;
  public int a;
  public int b;
  public int c;
  public int d;
  private View e;
  private TextView f;
  private View g;
  private CheckBox h;
  private View i;
  private CheckBox j;
  private View k;
  private TextView l;
  private TextView m;
  private ImageView n;
  private VerticalStretchLayout o;
  private View p;
  private String[] q;
  private int[] r;
  private String[] s = null;
  private ap t;
  private e w;
  private f x;
  private t y;
  
  private t a()
  {
    if (this.y == null) {
      this.y = new t(this);
    }
    return this.y;
  }
  
  private void a(int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence)
  {
    int i2 = 0;
    ArrayList localArrayList = new ArrayList();
    int i3 = paramArrayOfCharSequence.length;
    int i1 = 0;
    if (i1 < i3)
    {
      localObject = new a();
      ((a)localObject).a = paramArrayOfCharSequence[i1].toString();
      ((a)localObject).c = Integer.valueOf(i1);
      if (paramInt2 == i1) {}
      for (boolean bool = true;; bool = false)
      {
        ((a)localObject).b = bool;
        localArrayList.add(localObject);
        i1 += 1;
        break;
      }
    }
    Object localObject = a();
    ((t)localObject).b(paramInt1);
    ((t)localObject).a(localArrayList);
    paramInt1 = i2;
    if (i3 > 4) {
      paramInt1 = 4;
    }
    ((t)localObject).c(paramInt1);
    ((t)localObject).a(new an(this, paramArrayOfCharSequence));
    ((t)localObject).a();
  }
  
  private void a(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    int i2 = 0;
    ArrayList localArrayList = new ArrayList();
    int i3 = paramArrayOfString.length;
    int i1 = 0;
    if (i1 < i3)
    {
      a locala = new a();
      locala.a = paramArrayOfString[i1].toString();
      locala.c = Integer.valueOf(i1);
      if (paramInt2 == i1) {}
      for (boolean bool = true;; bool = false)
      {
        locala.b = bool;
        localArrayList.add(locala);
        i1 += 1;
        break;
      }
    }
    paramArrayOfString = a();
    paramArrayOfString.b(paramInt1);
    paramArrayOfString.a(localArrayList);
    paramInt1 = i2;
    if (i3 > 4) {
      paramInt1 = 4;
    }
    paramArrayOfString.c(paramInt1);
    paramArrayOfString.a(new ao(this, paramInt2));
    paramArrayOfString.a();
  }
  
  private void a(boolean paramBoolean)
  {
    this.k.setClickable(paramBoolean);
    if (paramBoolean)
    {
      this.l.setTextColor(u);
      this.m.setTextColor(u);
      this.n.setImageResource(2130838483);
      this.p.setVisibility(0);
      return;
    }
    this.l.setTextColor(v);
    this.m.setTextColor(v);
    this.n.setImageResource(2130838484);
    this.p.setVisibility(8);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i2 = 1;
    int i1 = 1;
    if (paramCompoundButton.equals(this.j)) {
      if (paramBoolean) {
        if (this.c != i1)
        {
          this.c = i1;
          a(paramBoolean);
          this.w.a(WeatherContentProvider.g, "setting_key", "autoUpdate", "setting_value", this.c);
          if (!paramBoolean) {
            break label75;
          }
          this.o.d();
        }
      }
    }
    for (;;)
    {
      return;
      i1 = 0;
      break;
      label75:
      this.o.c();
      return;
      if (paramCompoundButton.equals(this.h))
      {
        if (paramBoolean) {}
        for (i1 = i2; this.a != i1; i1 = 0)
        {
          this.a = i1;
          this.w.a(WeatherContentProvider.g, "setting_key", "isCycle", "setting_value", this.a);
          return;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.e)) {
      a(2131166110, this.d - 1, this.s);
    }
    for (;;)
    {
      return;
      if (paramView.equals(this.g))
      {
        this.h.toggle();
        return;
      }
      if (paramView.equals(this.i))
      {
        this.j.toggle();
        return;
      }
      if (paramView.equals(this.k))
      {
        int i2 = this.r.length;
        int i1 = 0;
        while (i1 < i2)
        {
          if (this.b == this.r[i1])
          {
            a(2131166138, i1, this.q);
            return;
          }
          i1 += 1;
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903356);
    getWindow().clearFlags(134217728);
    paramBundle = com.gau.go.launcherex.gowidget.weather.c.c.a(getApplicationContext());
    this.w = paramBundle.f();
    this.x = paramBundle.h();
    u = e().getColor(2131361866);
    v = e().getColor(2131361821);
    this.s = com.gau.go.launcherex.gowidget.weather.util.c.e(this);
    this.e = findViewById(2131231417);
    this.e.setOnClickListener(this);
    this.f = ((TextView)findViewById(2131231419));
    this.g = findViewById(2131231505);
    this.g.setOnClickListener(this);
    this.h = ((CheckBox)findViewById(2131231506));
    this.h.setOnCheckedChangeListener(this);
    this.i = findViewById(2131231439);
    this.i.setOnClickListener(this);
    this.j = ((CheckBox)findViewById(2131232106));
    this.j.setOnCheckedChangeListener(this);
    this.q = com.gau.go.launcherex.gowidget.weather.util.c.a(this);
    this.r = e().getIntArray(2131558438);
    this.k = findViewById(2131231442);
    this.k.setOnClickListener(this);
    this.l = ((TextView)findViewById(2131231444));
    this.m = ((TextView)findViewById(2131231443));
    this.n = ((ImageView)findViewById(2131232107));
    this.o = ((VerticalStretchLayout)findViewById(2131231441));
    this.p = findViewById(2131232108);
    this.t = new ap(this, null);
    paramBundle = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
    registerReceiver(this.t, paramBundle);
  }
  
  protected void onDestroy()
  {
    unregisterReceiver(this.t);
    super.onDestroy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/Setting21Activity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
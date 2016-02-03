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
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.util.ArrayList;

public class Setting41Activity
  extends GoWeatherEXActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static int y;
  private static int z;
  private e A;
  private f B;
  private t C;
  public int a;
  public int b;
  public int c;
  public int d;
  private View e;
  private TextView f;
  private View g;
  private TextView h;
  private View i;
  private CheckBox j;
  private View k;
  private CheckBox l;
  private View m;
  private TextView n;
  private TextView o;
  private ImageView p;
  private VerticalStretchLayout q;
  private View r;
  private int s;
  private int[] t = { 1, 2, 3 };
  private String[] u;
  private int[] v;
  private String[] w = null;
  private at x;
  
  private t a()
  {
    if (this.C == null) {
      this.C = new t(this);
    }
    return this.C;
  }
  
  private void a(int paramInt)
  {
    switch (this.t[paramInt])
    {
    default: 
      return;
    case 1: 
      this.h.setText(r.a(1));
      return;
    case 2: 
      this.h.setText(r.a(2));
      return;
    }
    this.h.setText(r.a(3));
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
    ((t)localObject).a(new aq(this, paramArrayOfCharSequence));
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
    paramArrayOfString.a(new as(this, paramInt2));
    paramArrayOfString.a();
  }
  
  private void a(boolean paramBoolean)
  {
    this.m.setClickable(paramBoolean);
    if (paramBoolean)
    {
      this.n.setTextColor(y);
      this.o.setTextColor(y);
      this.p.setImageResource(2130838483);
      this.r.setVisibility(0);
      return;
    }
    this.n.setTextColor(z);
    this.o.setTextColor(z);
    this.p.setImageResource(2130838484);
    this.r.setVisibility(8);
  }
  
  private void b(int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence)
  {
    int i2 = 0;
    ArrayList localArrayList = new ArrayList();
    int i3 = paramArrayOfCharSequence.length;
    int i1 = 0;
    if (i1 < i3)
    {
      a locala = new a();
      locala.a = paramArrayOfCharSequence[i1].toString();
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
    paramArrayOfCharSequence = a();
    paramArrayOfCharSequence.b(paramInt1);
    paramArrayOfCharSequence.a(localArrayList);
    paramInt1 = i2;
    if (i3 > 4) {
      paramInt1 = 4;
    }
    paramArrayOfCharSequence.c(paramInt1);
    paramArrayOfCharSequence.a(new ar(this));
    paramArrayOfCharSequence.a();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i2 = 1;
    int i1 = 1;
    if (paramCompoundButton.equals(this.l)) {
      if (paramBoolean) {
        if (this.c != i1)
        {
          this.c = i1;
          a(paramBoolean);
          this.A.a(WeatherContentProvider.g, "setting_key", "autoUpdate", "setting_value", this.c);
          if (!paramBoolean) {
            break label75;
          }
          this.q.d();
        }
      }
    }
    for (;;)
    {
      return;
      i1 = 0;
      break;
      label75:
      this.q.c();
      return;
      if (paramCompoundButton.equals(this.j))
      {
        if (paramBoolean) {}
        for (i1 = i2; this.a != i1; i1 = 0)
        {
          this.a = i1;
          this.A.a(WeatherContentProvider.g, "setting_key", "isCycle", "setting_value", this.a);
          return;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i2 = 0;
    int i1 = 0;
    if (paramView.equals(this.e)) {
      a(2131166110, this.d - 1, this.w);
    }
    for (;;)
    {
      return;
      if (paramView.equals(this.g))
      {
        i2 = this.t.length;
        paramView = new CharSequence[i2];
        while (i1 < i2)
        {
          paramView[i1] = r.a(this.t[i1]);
          i1 += 1;
        }
        b(2131166120, this.s, paramView);
        return;
      }
      if (paramView.equals(this.i))
      {
        this.j.toggle();
        return;
      }
      if (paramView.equals(this.k))
      {
        this.l.toggle();
        return;
      }
      if (paramView.equals(this.m))
      {
        int i3 = this.v.length;
        i1 = i2;
        while (i1 < i3)
        {
          if (this.b == this.v[i1])
          {
            a(2131166138, i1, this.u);
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
    setContentView(2130903357);
    getWindow().clearFlags(134217728);
    paramBundle = com.gau.go.launcherex.gowidget.weather.c.c.a(getApplicationContext());
    this.A = paramBundle.f();
    this.B = paramBundle.h();
    y = e().getColor(2131361866);
    z = e().getColor(2131361821);
    this.w = com.gau.go.launcherex.gowidget.weather.util.c.e(this);
    this.e = findViewById(2131231417);
    this.e.setOnClickListener(this);
    this.f = ((TextView)findViewById(2131231419));
    this.g = findViewById(2131231426);
    this.g.setOnClickListener(this);
    this.h = ((TextView)findViewById(2131231427));
    this.i = findViewById(2131231505);
    this.i.setOnClickListener(this);
    this.j = ((CheckBox)findViewById(2131231506));
    this.j.setOnCheckedChangeListener(this);
    this.k = findViewById(2131231439);
    this.k.setOnClickListener(this);
    this.l = ((CheckBox)findViewById(2131232106));
    this.l.setOnCheckedChangeListener(this);
    this.u = com.gau.go.launcherex.gowidget.weather.util.c.a(this);
    this.v = e().getIntArray(2131558438);
    this.m = findViewById(2131231442);
    this.m.setOnClickListener(this);
    this.n = ((TextView)findViewById(2131231444));
    this.o = ((TextView)findViewById(2131231443));
    this.p = ((ImageView)findViewById(2131232107));
    this.q = ((VerticalStretchLayout)findViewById(2131231441));
    this.r = findViewById(2131232108);
    this.x = new at(this, null);
    paramBundle = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
    registerReceiver(this.x, paramBundle);
  }
  
  protected void onDestroy()
  {
    unregisterReceiver(this.x);
    super.onDestroy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/Setting41Activity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
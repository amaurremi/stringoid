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
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.util.ArrayList;

public class Setting42Activity
  extends GoWeatherEXActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static int G;
  private static int H;
  private CheckBox A;
  private String[] B = null;
  private View C;
  private CheckBox D;
  private View E;
  private CheckBox F;
  private e I;
  private t J;
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  private ay f;
  private View g;
  private TextView h;
  private View i;
  private TextView j;
  private int k;
  private int[] l = { 1, 2, 3 };
  private View m;
  private TextView n;
  private int o;
  private String[] p;
  private int[] q;
  private String[] r;
  private int[] s;
  private View t;
  private TextView u;
  private TextView v;
  private ImageView w;
  private VerticalStretchLayout x;
  private View y;
  private View z;
  
  private t a()
  {
    if (this.J == null) {
      this.J = new t(this);
    }
    return this.J;
  }
  
  private void a(int paramInt)
  {
    switch (this.l[paramInt])
    {
    default: 
      return;
    case 1: 
      this.j.setText(r.a(1));
      return;
    case 2: 
      this.j.setText(r.a(2));
      return;
    }
    this.j.setText(r.a(3));
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
    ((t)localObject).a(new au(this, paramArrayOfCharSequence));
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
    paramArrayOfString.a(new aw(this, paramInt2));
    paramArrayOfString.a();
  }
  
  private void a(boolean paramBoolean)
  {
    this.t.setClickable(paramBoolean);
    if (paramBoolean)
    {
      this.u.setTextColor(G);
      this.v.setTextColor(G);
      this.w.setImageResource(2130838483);
      this.y.setVisibility(0);
      return;
    }
    this.u.setTextColor(H);
    this.v.setTextColor(H);
    this.w.setImageResource(2130838484);
    this.y.setVisibility(8);
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
    paramArrayOfCharSequence.a(new av(this));
    paramArrayOfCharSequence.a();
  }
  
  private void c(int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence)
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
    paramArrayOfCharSequence.a(new ax(this, paramInt2));
    paramArrayOfCharSequence.a();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i2 = 1;
    int i3 = 1;
    int i1 = 1;
    if (paramCompoundButton.equals(this.D)) {
      if (paramBoolean) {
        if (this.d != i1)
        {
          this.d = i1;
          this.I.k(this.d);
          this.I.a(WeatherContentProvider.g, "setting_key", "calendarType", "setting_value", this.d);
        }
      }
    }
    for (;;)
    {
      return;
      i1 = 0;
      break;
      if (paramCompoundButton.equals(this.A))
      {
        if (paramBoolean) {}
        for (i1 = i2; this.b != i1; i1 = 0)
        {
          this.b = i1;
          a(paramBoolean);
          this.I.a(WeatherContentProvider.g, "setting_key", "autoUpdate", "setting_value", this.b);
          if (!paramBoolean) {
            break label146;
          }
          this.x.d();
          return;
        }
        continue;
        label146:
        this.x.c();
      }
      else if (paramCompoundButton.equals(this.F))
      {
        if (paramBoolean) {}
        for (i1 = i3; this.e != i1; i1 = 0)
        {
          this.e = i1;
          this.I.a(WeatherContentProvider.g, "setting_key", "isCycle", "setting_value", this.e);
          return;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i2 = 0;
    int i3 = 0;
    int i1 = 0;
    if (paramView.equals(this.z)) {
      this.A.toggle();
    }
    do
    {
      for (;;)
      {
        return;
        if (paramView.equals(this.t))
        {
          i2 = this.s.length;
          while (i1 < i2)
          {
            if (this.a == this.s[i1])
            {
              a(2131166138, i1, this.r);
              return;
            }
            i1 += 1;
          }
        }
        else
        {
          if (paramView.equals(this.g))
          {
            a(2131166110, this.c - 1, this.B);
            return;
          }
          if (paramView.equals(this.i))
          {
            i3 = this.l.length;
            paramView = new CharSequence[i3];
            i1 = i2;
            while (i1 < i3)
            {
              paramView[i1] = r.a(this.l[i1]);
              i1 += 1;
            }
            b(2131166120, this.k, paramView);
            return;
          }
          if (!paramView.equals(this.m)) {
            break;
          }
          i2 = this.q.length;
          i1 = i3;
          while (i1 < i2)
          {
            if (this.o == this.q[i1])
            {
              c(2131166166, i1, this.p);
              return;
            }
            i1 += 1;
          }
        }
      }
      if (paramView.equals(this.C))
      {
        this.D.toggle();
        return;
      }
    } while (!paramView.equals(this.E));
    this.F.toggle();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903358);
    getWindow().clearFlags(134217728);
    this.I = com.gau.go.launcherex.gowidget.weather.c.c.a(getApplicationContext()).f();
    G = e().getColor(2131361866);
    H = e().getColor(2131361821);
    this.z = findViewById(2131231439);
    this.z.setOnClickListener(this);
    this.A = ((CheckBox)findViewById(2131232106));
    this.A.setOnCheckedChangeListener(this);
    this.r = com.gau.go.launcherex.gowidget.weather.util.c.a(this);
    this.s = e().getIntArray(2131558438);
    this.t = findViewById(2131231442);
    this.t.setOnClickListener(this);
    this.u = ((TextView)findViewById(2131231444));
    this.v = ((TextView)findViewById(2131231443));
    this.w = ((ImageView)findViewById(2131232107));
    this.x = ((VerticalStretchLayout)findViewById(2131231441));
    this.y = findViewById(2131232108);
    this.B = com.gau.go.launcherex.gowidget.weather.util.c.e(this);
    this.g = findViewById(2131231417);
    this.g.setOnClickListener(this);
    this.h = ((TextView)findViewById(2131231419));
    this.i = findViewById(2131231426);
    this.i.setOnClickListener(this);
    this.j = ((TextView)findViewById(2131231427));
    this.m = findViewById(2131231076);
    this.m.setOnClickListener(this);
    this.n = ((TextView)findViewById(2131231077));
    this.p = com.gau.go.launcherex.gowidget.weather.util.c.b(this);
    this.q = e().getIntArray(2131558440);
    this.C = findViewById(2131231074);
    this.C.setOnClickListener(this);
    this.D = ((CheckBox)findViewById(2131231075));
    this.D.setOnCheckedChangeListener(this);
    this.E = findViewById(2131231505);
    this.E.setOnClickListener(this);
    this.F = ((CheckBox)findViewById(2131231506));
    this.F.setOnCheckedChangeListener(this);
    this.f = new ay(this, null);
    paramBundle = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
    registerReceiver(this.f, paramBundle);
  }
  
  protected void onDestroy()
  {
    unregisterReceiver(this.f);
    super.onDestroy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/Setting42Activity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
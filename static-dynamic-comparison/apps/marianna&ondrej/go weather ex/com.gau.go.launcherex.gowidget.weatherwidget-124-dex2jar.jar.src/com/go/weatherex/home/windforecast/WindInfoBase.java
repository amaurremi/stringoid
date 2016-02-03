package com.go.weatherex.home.windforecast;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.b;
import com.a.a.s;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;

public class WindInfoBase
  extends RelativeLayout
  implements b
{
  private static final int[] y = { 2130839040, 2130839038, 2130839037, 2130839039, 2130839042, 2130839045, 2130839043, 2130839044, 2130839041 };
  private Context a = null;
  private String b = "";
  private com.gau.go.launcherex.gowidget.weather.util.f c;
  private e d;
  private WeatherBean e;
  private String f = "°C";
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private ImageView k;
  private View l;
  private View m;
  private com.a.a.d n = new com.a.a.d();
  private long o = 0L;
  private long p = 0L;
  private float q = 0.0F;
  private com.a.a.d r = new com.a.a.d();
  private boolean s = false;
  private float t;
  private float u;
  private float v;
  private AccelerateInterpolator w = new AccelerateInterpolator();
  private final Handler x = new f(this);
  
  public WindInfoBase(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WindInfoBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WindInfoBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private Matrix b(int paramInt)
  {
    Object localObject2 = new Matrix();
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = new DisplayMetrics();
        ((Activity)this.a).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
        float f1 = 133.3F * ((DisplayMetrics)localObject2).density / 2.0F;
        ((Matrix)localObject1).preTranslate(-f1, -f1);
        ((Matrix)localObject1).postTranslate(f1, f1);
      }
      return (Matrix)localObject1;
      localObject1 = null;
      continue;
      ((Matrix)localObject2).postRotate(180.0F);
      localObject1 = localObject2;
      continue;
      ((Matrix)localObject2).postRotate(225.0F);
      localObject1 = localObject2;
      continue;
      ((Matrix)localObject2).postRotate(270.0F);
      localObject1 = localObject2;
      continue;
      ((Matrix)localObject2).postRotate(315.0F);
      localObject1 = localObject2;
      continue;
      ((Matrix)localObject2).postRotate(45.0F);
      localObject1 = localObject2;
      continue;
      ((Matrix)localObject2).postRotate(90.0F);
      localObject1 = localObject2;
      continue;
      ((Matrix)localObject2).postRotate(135.0F);
      localObject1 = localObject2;
    }
  }
  
  private String b(float paramFloat)
  {
    if (paramFloat < 10.0F) {
      return paramFloat + "";
    }
    return Math.round(paramFloat) + "";
  }
  
  private void b()
  {
    s locals1 = s.a(this, "translationY", new float[] { this.q, 0.0F });
    s locals2 = s.a(this, "alpha", new float[] { 0.0F, 1.0F });
    this.n.a(new s[] { locals1, locals2 });
    this.n.b(this.o);
    this.n.c(this.p);
    this.n.a();
    this.n.a(this);
  }
  
  private float c(float paramFloat)
  {
    return (720.0F + paramFloat) % 360.0F;
  }
  
  private int c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return y[8];
    case 1: 
    case 2: 
      return y[8];
    case 3: 
      return y[4];
    case 4: 
    case 5: 
    case 6: 
      return y[5];
    case 7: 
      return y[6];
    case 8: 
    case 9: 
    case 10: 
      return y[7];
    case 11: 
      return y[0];
    case 12: 
    case 13: 
    case 14: 
      return y[1];
    case 15: 
      return y[2];
    }
    return y[3];
  }
  
  private void c()
  {
    float f1;
    float f3;
    label74:
    float f4;
    AccelerateInterpolator localAccelerateInterpolator;
    if ((this.l != null) && (this.t != this.v) && (this.s))
    {
      f2 = this.v;
      if (f2 - this.t <= 180.0F) {
        break label136;
      }
      f1 = f2 - 360.0F;
      f3 = f1 - this.t;
      f2 = f3;
      if (Math.abs(f3) > 1.0F)
      {
        if (f3 <= 0.0F) {
          break label158;
        }
        f2 = 1.0F;
      }
      f3 = this.t;
      f4 = this.t;
      localAccelerateInterpolator = this.w;
      if (Math.abs(f2) <= 1.0F) {
        break label164;
      }
    }
    label136:
    label158:
    label164:
    for (float f2 = 0.35F;; f2 = 0.3F)
    {
      this.t = c(localAccelerateInterpolator.getInterpolation(f2) * (f1 - f4) + f3);
      com.a.c.a.b(this.l, this.t);
      return;
      f1 = f2;
      if (f2 - this.t >= -180.0F) {
        break;
      }
      f1 = f2 + 360.0F;
      break;
      f2 = -1.0F;
      break label74;
    }
  }
  
  private void d()
  {
    if (this.u < -180.0F) {}
    for (float f1 = this.u + 360.0F;; f1 = this.u)
    {
      s locals = s.a(this, "rotation", new float[] { 0.0F, f1 });
      this.t = f1;
      this.r.a(new com.a.a.a[] { locals });
      this.r.b(10L);
      this.r.c(500L);
      this.r.a(this);
      this.r.a(this.l);
      this.r.a();
      return;
    }
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    this.u = (-paramFloat);
    this.v = c(this.u);
    if (!this.x.hasMessages(1)) {
      this.x.sendEmptyMessageDelayed(1, 10L);
    }
  }
  
  public void a(int paramInt)
  {
    this.m.setVisibility(paramInt);
  }
  
  public void a(com.a.a.a parama) {}
  
  public void a(com.go.weatherex.framework.fragment.a parama)
  {
    if (parama == null) {
      return;
    }
    parama.a(this.j, 4, true);
    parama.a(this.i, 3, true);
    parama.a(this.g, 3, true);
    parama.a(this.h, 4, true);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.c == null)
    {
      localObject = com.gau.go.launcherex.gowidget.weather.util.f.a(this.a.getApplicationContext());
      this.c = ((com.gau.go.launcherex.gowidget.weather.util.f)localObject);
      if (this.d != null) {
        break label146;
      }
    }
    label146:
    for (Object localObject = e.a(this.a.getApplicationContext());; localObject = this.d)
    {
      this.d = ((e)localObject);
      if (!paramString.equals(this.b))
      {
        this.b = paramString;
        this.e = this.c.a(this.b);
      }
      if (this.e != null) {
        break label155;
      }
      this.j.setText("--");
      this.g.setText("--");
      this.k.setImageResource(2130838282);
      this.k.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      return;
      localObject = this.c;
      break;
    }
    label155:
    paramString = this.e.k;
    float f1;
    int i1;
    if (paramString != null)
    {
      f1 = paramString.a();
      i1 = paramString.m();
    }
    for (;;)
    {
      this.h.setVisibility(0);
      switch (this.d.a().q)
      {
      default: 
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        this.f = this.a.getString(2131165334);
        if (f1 == -10000.0F)
        {
          paramString = "--";
          this.j.setText(this.e.k.b());
          this.j.setCompoundDrawablesWithIntrinsicBounds(0, 0, c(this.e.k.m()), 0);
          if (this.h.getVisibility() == 8) {
            break label833;
          }
          this.h.setText(this.f);
        }
        break;
      }
      for (;;)
      {
        this.g.setText(paramString);
        paramString = b(i1);
        if (paramString == null) {
          break label847;
        }
        this.k.setImageResource(2130838464);
        this.k.setScaleType(ImageView.ScaleType.MATRIX);
        this.k.setImageMatrix(paramString);
        return;
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        this.f = this.a.getString(2131165333);
        if (f1 == -10000.0F)
        {
          paramString = "--";
          break;
        }
        paramString = b(com.gau.go.launcherex.gowidget.weather.util.q.c(f1, 1));
        break;
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        this.f = this.a.getString(2131165334);
        if (f1 == -10000.0F)
        {
          paramString = "--";
          break;
        }
        paramString = b(com.gau.go.launcherex.gowidget.weather.util.q.b(f1));
        break;
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        this.f = this.a.getString(2131165335);
        if (f1 == -10000.0F)
        {
          paramString = "--";
          break;
        }
        paramString = b(com.gau.go.launcherex.gowidget.weather.util.q.d(f1, 1));
        break;
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        this.f = this.a.getString(2131165336);
        if (f1 == -10000.0F)
        {
          paramString = "--";
          break;
        }
        paramString = b(com.gau.go.launcherex.gowidget.weather.util.q.e(f1, 1));
        break;
        if (f1 == -10000.0F) {}
        for (paramString = "--";; paramString = b(com.gau.go.launcherex.gowidget.weather.util.q.a(f1)))
        {
          if ((com.gau.go.launcherex.gowidget.language.d.a(this.a).b().equals("zh")) || (com.gau.go.launcherex.gowidget.language.d.a(this.a).b().equals("ko"))) {
            break label728;
          }
          this.h.setVisibility(8);
          this.i.setVisibility(0);
          this.f = this.a.getString(2131165813, new Object[] { "" });
          break;
        }
        label728:
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        this.f = this.a.getString(2131165337);
        break;
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        this.f = this.a.getString(2131165338);
        if (f1 == -10000.0F)
        {
          paramString = "--";
          break;
        }
        paramString = b(com.gau.go.launcherex.gowidget.weather.util.q.f(f1, 1));
        break;
        paramString = b(com.gau.go.launcherex.gowidget.weather.util.q.b(f1));
        break;
        label833:
        this.i.setText(this.f);
      }
      label847:
      this.k.setImageResource(2130838282);
      this.k.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      return;
      i1 = 1;
      f1 = -10000.0F;
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, float paramFloat)
  {
    com.a.c.a.a(this, 0.0F);
    this.o = paramLong1;
    this.p = paramLong2;
    this.q = paramFloat;
    b();
  }
  
  public void b(com.a.a.a parama) {}
  
  public void c(com.a.a.a parama)
  {
    if (parama == this.n) {
      d();
    }
    while (parama != this.r) {
      return;
    }
    this.s = true;
  }
  
  public void d(com.a.a.a parama) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.j = ((TextView)findViewById(2131232115));
    this.i = ((TextView)findViewById(2131232112));
    this.g = ((TextView)findViewById(2131232113));
    this.h = ((TextView)findViewById(2131232114));
    this.l = findViewById(2131232109);
    this.k = ((ImageView)findViewById(2131232110));
    this.m = findViewById(2131232116);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/windforecast/WindInfoBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.gau.go.launcherex.gowidget.weather.systemwidget.configure;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.a.a.an;
import com.a.a.s;

public class i
{
  final ThemeConfigureView a;
  String b;
  private Activity c;
  private e d;
  private a e;
  private View f;
  
  public i(ThemeConfigureView paramThemeConfigureView)
  {
    this.a = paramThemeConfigureView;
  }
  
  private void a()
  {
    if (this.e.b())
    {
      this.e.a(this.a.c.getWidth(), this.a.c.getHeight());
      this.e.a(this.b);
    }
  }
  
  private void a(View paramView)
  {
    if (this.e.b()) {
      this.e.a(this.a.c.getWidth(), this.a.c.getHeight());
    }
    d locald = (d)paramView.getTag();
    an localan = an.b(new int[] { this.e.c, 1 });
    localan.a(new o(this, paramView, locald));
    localan.a(new p(this, paramView));
    localan.a(new DecelerateInterpolator());
    localan.c(400L);
    localan.a();
  }
  
  private void a(View paramView1, View paramView2)
  {
    h localh = (h)paramView1.getTag();
    int i = (this.d.c + this.d.e) * localh.g - this.d.a.getScrollX();
    int j = this.d.c + i;
    if (i < 0) {}
    for (;;)
    {
      if (j > this.d.a.getWidth()) {
        j -= this.d.a.getWidth();
      }
      for (;;)
      {
        int k = this.d.a.getScrollX();
        Object localObject = (d)paramView2.getTag();
        i = this.e.c;
        int m = this.e.e;
        i = ((d)localObject).f * (i + m) - this.e.a.getScrollX();
        m = this.e.c + i;
        if (i < 0) {}
        for (;;)
        {
          if (m > this.e.a.getWidth()) {
            i = m - this.e.a.getWidth();
          }
          for (;;)
          {
            m = this.e.a.getScrollX();
            localObject = an.b(new int[] { 1, this.d.c });
            ((an)localObject).a(new j(this, paramView1, localh, j, k, i, m));
            ((an)localObject).a(new k(this, paramView1, paramView2));
            ((an)localObject).a(new DecelerateInterpolator());
            ((an)localObject).c(600L);
            ((an)localObject).a();
            paramView1.setVisibility(4);
            a(true);
            return;
          }
          i = 0;
        }
        j = i;
      }
      i = 0;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.c.getWindow().getDecorView();
    if (paramBoolean)
    {
      if (this.f == null)
      {
        this.f = new View(this.c);
        this.f.setClickable(true);
      }
      localViewGroup.addView(this.f, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    localViewGroup.removeView(this.f);
  }
  
  private View b()
  {
    LinearLayout localLinearLayout = this.e.b;
    int j = localLinearLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = localLinearLayout.getChildAt(i);
      if (((d)localView.getTag()).e.x().equals(this.b)) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  private void b(View paramView1, View paramView2)
  {
    paramView2.destroyDrawingCache();
    paramView2.setDrawingCacheEnabled(true);
    Object localObject1 = paramView2.getDrawingCache();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = this.a.a;
    ImageView localImageView = new ImageView(this.c);
    localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localImageView.setImageBitmap((Bitmap)localObject1);
    ((ViewGroup)localObject2).addView(localImageView, new ViewGroup.LayoutParams(-2, -2));
    int i = this.a.getScrollY();
    localObject1 = null;
    if (i != 0)
    {
      localObject1 = an.b(new int[] { i, 0 });
      ((an)localObject1).a(new l(this));
    }
    Object localObject3 = new int[2];
    Object localObject4 = new int[2];
    int[] arrayOfInt = new int[2];
    paramView1.getLocationInWindow((int[])localObject4);
    paramView2.getLocationInWindow((int[])localObject3);
    ((ViewGroup)localObject2).getLocationInWindow(arrayOfInt);
    localObject2 = s.a(localImageView, "translationX", new float[] { localObject3[0] - arrayOfInt[0], localObject4[0] - arrayOfInt[0] });
    localObject3 = s.a(localImageView, "translationY", new float[] { localObject3[1] - arrayOfInt[1], localObject4[1] - arrayOfInt[1] });
    localObject4 = new com.a.a.d();
    ((com.a.a.d)localObject4).a(new m(this, paramView1, localImageView, paramView2));
    ((com.a.a.d)localObject4).a(new AccelerateDecelerateInterpolator());
    ((com.a.a.d)localObject4).a(new com.a.a.a[] { localObject2, localObject3 });
    if (localObject1 != null) {
      ((com.a.a.d)localObject4).a(new com.a.a.a[] { localObject1 });
    }
    ((com.a.a.d)localObject4).c(600L);
    ((com.a.a.d)localObject4).a();
    paramView2.setVisibility(4);
  }
  
  private View c()
  {
    LinearLayout localLinearLayout = this.d.b;
    int j = localLinearLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = localLinearLayout.getChildAt(i);
      if (((h)localView.getTag()).f.x().equals(this.b)) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  private void c(View paramView1, View paramView2)
  {
    FrameLayout localFrameLayout = this.a.a;
    s locals1 = s.a(paramView2, "alpha", new float[] { 1.0F, 0.0F });
    s locals2 = s.a(paramView1, "alpha", new float[] { 0.0F, 1.0F });
    com.a.a.d locald = new com.a.a.d();
    locald.a(new n(this, paramView1, localFrameLayout, paramView2));
    locald.a(new AccelerateDecelerateInterpolator());
    locald.a(new com.a.a.a[] { locals1, locals2 });
    locald.c(400L);
    locald.a();
  }
  
  public void a(Activity paramActivity)
  {
    this.c = paramActivity;
  }
  
  public void a(a parama)
  {
    this.e = parama;
  }
  
  public void a(e parame)
  {
    this.d = parame;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      localObject = this.a.d.a(paramString);
    } while ((localObject == null) || (!((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject).D()));
    this.b = paramString;
    if (this.d.c())
    {
      this.d.a(this.a.b.getWidth(), this.a.b.getHeight());
      this.d.b((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject);
    }
    paramString = b();
    Object localObject = c();
    if ((paramString != null) && (localObject != null))
    {
      a((View)localObject, paramString);
      return;
    }
    a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/configure/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
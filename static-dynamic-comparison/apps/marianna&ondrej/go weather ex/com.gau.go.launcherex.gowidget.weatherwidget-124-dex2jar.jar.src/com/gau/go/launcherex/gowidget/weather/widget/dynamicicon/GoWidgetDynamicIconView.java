package com.gau.go.launcherex.gowidget.weather.widget.dynamicicon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.gtp.a.a.b.c;
import com.jiubang.core.a.l;
import java.lang.ref.WeakReference;

public class GoWidgetDynamicIconView
  extends View
{
  private e a;
  private f b;
  
  public GoWidgetDynamicIconView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public GoWidgetDynamicIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.a = new e(new WeakReference(this));
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    g localg = new g(getContext());
    localg.b();
    localg.a(paramBitmap, paramBoolean, getWidth(), getHeight());
    this.b = localg;
    if (paramBoolean)
    {
      this.a.a();
      return;
    }
    invalidate();
  }
  
  public void a(l paraml, boolean paramBoolean)
  {
    h localh = new h(getContext());
    localh.a(paramBoolean);
    localh.a(paraml);
    localh.a(this);
    this.b = localh;
    this.a.a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.b != null)
    {
      this.b.a(paramCanvas, this);
      c.a("LJL", "mWeatherDynamic.drawFrame(canvas, this);");
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.b != null) {
      this.b.a(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/widget/dynamicicon/GoWidgetDynamicIconView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
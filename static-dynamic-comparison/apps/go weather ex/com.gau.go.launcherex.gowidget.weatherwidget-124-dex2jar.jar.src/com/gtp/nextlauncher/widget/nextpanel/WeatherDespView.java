package com.gtp.nextlauncher.widget.nextpanel;

import android.content.Context;
import android.util.AttributeSet;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.view.GLContentView;
import com.go.gl.view.GLRelativeLayout;
import com.go.gl.widget.GLTextView;

public class WeatherDespView
  extends GLRelativeLayout
{
  private float a = 1.0F;
  private float b = 0.0F;
  private GLTextView c;
  private GLTextView d;
  private GLTextView e;
  private GLTextView f;
  private GLTextView g;
  private GLTextView h;
  private GLTextView i;
  private GLTextView j;
  private boolean k = false;
  
  public WeatherDespView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WeatherDespView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.mContext = paramContext;
    setPadding(10, 0, 10, 0);
  }
  
  public void cleanup()
  {
    this.k = false;
    super.cleanup();
  }
  
  protected void dispatchDraw(GLCanvas paramGLCanvas)
  {
    if (!this.k) {
      return;
    }
    paramGLCanvas.translate(0.0F, 0.0F, this.b);
    super.dispatchDraw(paramGLCanvas);
    paramGLCanvas.translate(0.0F, 0.0F, -this.b);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = ((GLTextView)findViewById(2131231205));
    this.d = ((GLTextView)findViewById(2131231749));
    this.e = ((GLTextView)findViewById(2131231750));
    this.f = ((GLTextView)findViewById(2131231752));
    this.g = ((GLTextView)findViewById(2131231751));
    this.j = ((GLTextView)findViewById(2131231754));
    this.h = ((GLTextView)findViewById(2131231753));
    this.i = ((GLTextView)findViewById(2131231755));
    this.k = true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    GLContentView localGLContentView = getGLRootView();
    if (localGLContentView != null) {
      this.b = localGLContentView.getDepthForProjectScale(this.a);
    }
  }
  
  public void setCityName(String paramString)
  {
    if (!this.k) {
      return;
    }
    this.c.setText(paramString);
  }
  
  public void setDrawingCacheEnabled(boolean paramBoolean)
  {
    super.setDrawingCacheEnabled(paramBoolean);
  }
  
  public void setHTempDesp(String paramString)
  {
    if (!this.k) {
      return;
    }
    this.f.setText(paramString);
  }
  
  public void setHumidity(String paramString)
  {
    if (!this.k) {
      return;
    }
    this.i.setText(paramString);
  }
  
  public void setLTempDesp(String paramString)
  {
    if (!this.k) {
      return;
    }
    this.g.setText(paramString);
  }
  
  public void setNight(boolean paramBoolean)
  {
    if (!this.k) {
      return;
    }
    int m;
    if (paramBoolean)
    {
      m = -2629660;
      this.c.showTextShadow();
      this.d.showTextShadow();
      this.e.showTextShadow();
      this.f.showTextShadow();
      this.g.showTextShadow();
      this.j.showTextShadow();
      this.h.showTextShadow();
      this.i.showTextShadow();
    }
    for (;;)
    {
      this.c.setTextColor(m);
      this.d.setTextColor(m);
      this.e.setTextColor(m);
      this.f.setTextColor(m);
      this.g.setTextColor(m);
      this.j.setTextColor(m);
      this.h.setTextColor(m);
      this.i.setTextColor(m);
      return;
      this.h.hideTextShadow();
      this.c.hideTextShadow();
      this.d.hideTextShadow();
      this.e.hideTextShadow();
      this.f.hideTextShadow();
      this.g.hideTextShadow();
      this.j.hideTextShadow();
      this.i.hideTextShadow();
      m = -13552052;
    }
  }
  
  public void setNowTemp(String paramString)
  {
    if (!this.k) {
      return;
    }
    this.d.setText(paramString);
  }
  
  public void setNowTempUnit(String paramString)
  {
    if (!this.k) {
      return;
    }
    this.e.setText(paramString);
  }
  
  public void setWeatherDesp(String paramString)
  {
    if (!this.k) {
      return;
    }
    this.h.setText(paramString);
  }
  
  public void setWindDesp(String paramString)
  {
    if (!this.k) {
      return;
    }
    this.j.setText(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/WeatherDespView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
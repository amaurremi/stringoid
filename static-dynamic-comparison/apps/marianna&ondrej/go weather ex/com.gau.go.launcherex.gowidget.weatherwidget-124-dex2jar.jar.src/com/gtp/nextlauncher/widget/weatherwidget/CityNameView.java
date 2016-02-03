package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.view.GLLinearLayout;
import com.go.gl.widget.GLImageView;
import com.go.gl.widget.GLTextViewWrapper;

public class CityNameView
  extends GLLinearLayout
{
  private GLTextViewWrapper a;
  private GLImageView b;
  private String c;
  private Rect d;
  private boolean e = false;
  private boolean f = false;
  private Handler g = new b(this);
  private boolean h = false;
  private long i = 0L;
  private int j = 1000;
  private boolean k = false;
  private float l = 0.0F;
  private float m = 0.0F;
  private float[] n = { 0.5F, 0.1F };
  private double o = 12.566370614359172D;
  
  public CityNameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.f = true;
    this.g.removeMessages(0);
    this.g.sendEmptyMessageDelayed(0, 500L);
  }
  
  private void a(float paramFloat)
  {
    if (paramFloat < 0.3D) {
      this.m = ((float)(paramFloat / 0.3D * this.l));
    }
    for (;;)
    {
      if (paramFloat == 1.0F) {
        c();
      }
      invalidate();
      return;
      if (!this.k)
      {
        this.k = true;
        setCityName(this.c);
      }
      if (paramFloat < 0.5D)
      {
        this.m = ((float)((1.0D - (paramFloat - 0.3D) / 0.2D) * this.l));
      }
      else
      {
        float f1 = (paramFloat - 0.5F) / 0.5F;
        this.m = ((float)(Math.sin(this.o * (1.0F - f1)) * this.l * 0.30000001192092896D * (1.0F - f1)));
      }
    }
  }
  
  private void b()
  {
    if ((!this.h) && (!this.f))
    {
      this.h = true;
      this.i = -1L;
    }
    this.k = false;
    invalidate();
  }
  
  private void c()
  {
    this.h = false;
    invalidate();
  }
  
  public void changeCity(String paramString)
  {
    this.c = paramString;
    b();
    a();
  }
  
  public void draw(GLCanvas paramGLCanvas)
  {
    if (!this.e) {
      return;
    }
    int i1 = paramGLCanvas.save();
    if (this.i == -1L) {
      this.i = getDrawingTime();
    }
    if (this.h) {
      a(Math.max(0.0F, Math.min((float)(getDrawingTime() - this.i) / this.j, 1.0F)));
    }
    paramGLCanvas.clipRect(this.d);
    paramGLCanvas.translate(0.0F, this.m, 0.0F);
    super.draw(paramGLCanvas);
    paramGLCanvas.restoreToCount(i1);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((GLTextViewWrapper)findViewById(2131231208));
    this.a.showTextShadow();
    this.b = ((GLImageView)findViewById(2131231748));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.l = (-paramInt2);
    this.d = new Rect(0, -paramInt2, paramInt1, paramInt2);
    this.e = true;
  }
  
  public void setCityName(String paramString)
  {
    this.a.setText(paramString);
    requestLayout();
    invalidate();
  }
  
  public void setCityNum(int paramInt)
  {
    if (paramInt > 1)
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(4);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/CityNameView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
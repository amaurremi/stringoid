package com.gtp.nextlauncher.widget.nextpanel;

import android.content.Context;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.graphics.geometry.ColorGLObjectRender;
import com.go.gl.graphics.geometry.GLPath;
import com.go.gl.view.GLRelativeLayout;

public class Floor
  extends GLRelativeLayout
{
  private float a = 1000.0F;
  private ColorGLObjectRender b = new ColorGLObjectRender();
  private GLPath c;
  private GLPath d;
  private GLPath e;
  private int f = 200;
  private int g = 30;
  
  public Floor(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setBackgroundColor(16777215);
    this.b.setColor(1157627903);
    this.c = new GLPath();
    this.c.setStrokeWidth(8.0F, 8.0F);
    this.d = new GLPath();
    this.d.setStrokeWidth(8.0F, 8.0F);
    this.d.setDrawMode(false);
    this.e = new GLPath();
    this.e.setStrokeWidth(8.0F, 8.0F);
    this.e.setDrawMode(false);
  }
  
  private void a(GLCanvas paramGLCanvas)
  {
    int k = 0;
    this.c.update(paramGLCanvas);
    this.c.setDrawMode(false);
    int i = 1;
    int j;
    while (i < 9)
    {
      j = paramGLCanvas.save();
      paramGLCanvas.translate(0.0F, -this.mHeight, -this.a * i);
      this.b.draw(paramGLCanvas, this.c);
      paramGLCanvas.restoreToCount(j);
      i += 1;
    }
    this.d.update(paramGLCanvas);
    this.e.update(paramGLCanvas);
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= this.g / 2 - 1) {
        break;
      }
      j = paramGLCanvas.save();
      paramGLCanvas.translate(this.f * i, 0.0F, 0.0F);
      this.b.draw(paramGLCanvas, this.d);
      paramGLCanvas.restoreToCount(j);
      i += 1;
    }
    while (j > -(this.g / 2 - 1))
    {
      i = paramGLCanvas.save();
      paramGLCanvas.translate(this.f * j, 0.0F, 0.0F);
      this.b.draw(paramGLCanvas, this.e);
      paramGLCanvas.restoreToCount(i);
      j -= 1;
    }
  }
  
  public void draw(GLCanvas paramGLCanvas)
  {
    a(paramGLCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c.reset();
    this.d.reset();
    this.e.reset();
    this.c.lineTo(paramInt1 / 2 + this.f / 2 - (this.g / 2 - 1) * this.f, 0.0F);
    this.c.lineTo(paramInt1 / 2 + this.f / 2 + (this.g / 2 - 2) * this.f, 0.0F);
    this.d.lineTo(paramInt1 / 2 + 100, -paramInt2, 0.0F);
    this.d.lineTo(paramInt1 / 2 + 100, -paramInt2, -this.a * 10.0F);
    this.e.lineTo(paramInt1 / 2 - 100, -paramInt2, 0.0F);
    this.e.lineTo(paramInt1 / 2 - 100, -paramInt2, -this.a * 10.0F);
    this.c.setFixedViewVector(0.0F, 1.0F, 1.0F);
    this.d.setFixedViewVector(-1.0F, 1.0F, 0.0F);
    this.e.setFixedViewVector(1.0F, 1.0F, 0.0F);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/Floor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.Context;
import android.util.AttributeSet;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.widget.GLImageView;

public class ProgressBar
  extends GLImageView
{
  private boolean a = false;
  private float b = 0.0F;
  private int c;
  private int d;
  
  public ProgressBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void dispatchDraw(GLCanvas paramGLCanvas)
  {
    super.dispatchDraw(paramGLCanvas);
  }
  
  public void end()
  {
    this.a = false;
    this.b = 0.0F;
    invalidate();
  }
  
  protected void onDraw(GLCanvas paramGLCanvas)
  {
    int i = paramGLCanvas.save();
    paramGLCanvas.translate(this.c, this.d, 0.0F);
    paramGLCanvas.rotate(this.b);
    paramGLCanvas.translate(-this.c, -this.d, 0.0F);
    super.onDraw(paramGLCanvas);
    paramGLCanvas.restoreToCount(i);
    if (this.a)
    {
      this.b += 5.0F;
      invalidate();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c = ((this.mWidth - this.mPaddingLeft - this.mPaddingRight) / 2 + this.mPaddingLeft);
    this.d = (-(this.mHeight - this.mPaddingTop - this.mPaddingBottom) / 2 - this.mPaddingTop);
  }
  
  public void start()
  {
    this.a = true;
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/ProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
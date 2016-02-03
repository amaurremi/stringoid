package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.ideashower.readitlater.a.g;
import com.pocket.i.a.i;
import com.pocket.widget.ThemedView;

public class RainbowBar
  extends ThemedView
{
  public static final int a = g.c().getResources().getDimensionPixelSize(2131296376);
  private i b;
  
  public RainbowBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RainbowBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RainbowBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.b = new i(this);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.b.setState(getDrawableState());
    invalidate();
  }
  
  public i getRainbow()
  {
    return this.b;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.b.draw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b.setBounds(0, 0, paramInt1, paramInt2);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable == this.b) && (this.b != null)) {
      return true;
    }
    return super.verifyDrawable(paramDrawable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/RainbowBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.pocket.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.ThemedTextView;

public class TextBubbleDividerView
  extends ThemedTextView
{
  private static final int a = j.a(19.5F);
  private static final int b = j.a(2.7F);
  private static final int c = j.a(7.0F);
  private static final float d = j.a(0.75F);
  private static final int e = (int)Math.ceil(a + d * 2.0F);
  private static final Rect f = new Rect();
  private ak g;
  
  public TextBubbleDividerView(Context paramContext)
  {
    super(paramContext);
    g();
  }
  
  public TextBubbleDividerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g();
  }
  
  public TextBubbleDividerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private void g()
  {
    this.g = new ak(this);
    setBackgroundDrawable(this.g);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.g.a();
  }
  
  public int getMinimumHeight()
  {
    return e;
  }
  
  public int getMinimumWidth()
  {
    return e;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setTextColor(int paramInt)
  {
    super.setTextColor(paramInt);
    this.g.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/TextBubbleDividerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
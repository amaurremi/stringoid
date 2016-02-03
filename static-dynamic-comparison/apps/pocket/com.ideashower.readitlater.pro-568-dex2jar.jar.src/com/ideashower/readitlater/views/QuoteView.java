package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.util.AttributeSet;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;

public class QuoteView
  extends ThemedTextView
{
  private int a;
  private Paint b;
  private ColorStateList c;
  private int d;
  
  public QuoteView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QuoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QuoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.c = getResources().getColorStateList(2131165785);
    b();
    this.d = j.a(17.0F);
    z.c(this, this.d + getPaddingLeft());
    this.a = j.a(1.5F);
  }
  
  private void b()
  {
    this.b.setColor(this.c.getColorForState(getDrawableState(), 0));
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    b();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Layout localLayout = getLayout();
    if (localLayout != null)
    {
      int i = i.a(localLayout, 0);
      int j = localLayout.getLineBaseline(localLayout.getLineCount() - 1);
      paramCanvas.drawRect(getPaddingLeft() - this.d, i, getPaddingLeft() + this.a - this.d, j, this.b);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/QuoteView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
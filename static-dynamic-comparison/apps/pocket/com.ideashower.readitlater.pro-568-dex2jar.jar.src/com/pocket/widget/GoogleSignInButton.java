package com.pocket.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.p;

public class GoogleSignInButton
  extends RilButton
{
  private float j;
  
  public GoogleSignInButton(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public GoogleSignInButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public GoogleSignInButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setCompoundDrawablePadding(0);
    z.c(this, 0);
    z.d(this, 0);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    RectF localRectF = getFillRect();
    float f = localRectF.left + this.j;
    paramCanvas.drawLine(f, localRectF.top, f, localRectF.bottom, getStrokePaint());
  }
  
  public void setStyle(int paramInt)
  {
    super.setStyle(paramInt);
    if ((paramInt == b) || (paramInt == h) || (paramInt == i)) {}
    for (Object localObject = getResources().getDrawable(2130837605);; localObject = new p(2130837605, getContext(), getTextColors()))
    {
      setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      this.j = ((Drawable)localObject).getIntrinsicWidth();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/GoogleSignInButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
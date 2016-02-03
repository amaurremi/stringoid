package com.pocket.widget.premium;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.ideashower.readitlater.b;
import com.pocket.widget.y;

public class PremiumIconView
  extends ImageView
  implements y
{
  private float a = 1.0F;
  private float b = 1.0F;
  
  public PremiumIconView(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public PremiumIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public PremiumIconView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.PremiumIcon);
      this.a = paramAttributeSet.getFloat(0, 1.0F);
      this.b = paramAttributeSet.getFloat(1, this.a);
      paramAttributeSet.recycle();
    }
  }
  
  public float getDepthX()
  {
    return this.a;
  }
  
  public float getDepthY()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/PremiumIconView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
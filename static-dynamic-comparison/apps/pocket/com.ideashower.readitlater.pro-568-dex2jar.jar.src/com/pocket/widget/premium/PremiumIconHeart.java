package com.pocket.widget.premium;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class PremiumIconHeart
  extends b
{
  private final float[] a = { 0.0F, 0.0F };
  private View b;
  private View c;
  
  public PremiumIconHeart(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public PremiumIconHeart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public PremiumIconHeart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(getContext()).inflate(2130903162, this, true);
    this.b = findViewById(2131231090);
    this.c = findViewById(2131231089);
    ((ImageView)findViewById(2131231088)).setImageDrawable(new a());
  }
  
  @TargetApi(14)
  public void a(float paramFloat1, float paramFloat2)
  {
    super.a(paramFloat1, paramFloat2);
    a(paramFloat1, paramFloat2, this.c);
  }
  
  @TargetApi(14)
  public void a(d paramd)
  {
    paramd.a();
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.a[0] = (-paramArrayOfFloat[0]);
    this.a[1] = 0.0F;
    super.a(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/PremiumIconHeart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
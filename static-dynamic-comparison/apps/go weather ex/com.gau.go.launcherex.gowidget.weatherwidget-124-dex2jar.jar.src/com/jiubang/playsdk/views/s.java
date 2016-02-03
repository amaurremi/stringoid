package com.jiubang.playsdk.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.k;
import com.jiubang.playsdk.main.c;

public class s
{
  private View a;
  private Drawable b;
  
  public s(View paramView)
  {
    this.a = paramView;
    paramView.setClickable(true);
  }
  
  public void a()
  {
    this.a.invalidate();
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, k.e);
    this.b = paramContext.getResources().getDrawable(aa.a().b().l());
    if ((this.b instanceof StateListDrawable))
    {
      paramContext = (StateListDrawable)this.b;
      paramContext.setState(new int[] { 16842919 });
      this.b = paramContext;
    }
    paramAttributeSet.recycle();
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((this.b != null) && (this.a.isPressed()) && (this.a.isEnabled()))
    {
      this.b.setBounds(this.a.getPaddingRight(), this.a.getPaddingTop(), this.a.getMeasuredWidth() - this.a.getPaddingRight(), this.a.getMeasuredHeight() - this.a.getPaddingBottom());
      this.b.draw(paramCanvas);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
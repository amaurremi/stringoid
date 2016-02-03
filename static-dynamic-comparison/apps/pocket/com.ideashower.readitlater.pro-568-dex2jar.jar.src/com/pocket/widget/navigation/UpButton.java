package com.pocket.widget.navigation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout.LayoutParams;
import com.ideashower.readitlater.views.p;
import com.pocket.widget.ai;

public class UpButton
  extends ai
{
  private o a;
  
  public UpButton(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public UpButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    setOrientation(0);
    this.a = new o(getContext());
    this.a.setId(1000);
    this.a.a(r.a);
    this.a.setClickable(false);
    this.a.a(new p(2130837637, getContext()));
    this.a.b(new p(2130837697, getContext()));
    addView(this.a, new LinearLayout.LayoutParams(-2, -1));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/navigation/UpButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
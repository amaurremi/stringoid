package com.gau.go.launcherex.gowidget.weather.globalview;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.go.weatherex.framework.a.a;

public abstract class f
  extends Dialog
  implements a
{
  protected Activity a;
  private a b;
  
  public f(Activity paramActivity)
  {
    this(paramActivity, 2131492887);
  }
  
  public f(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    this.a = paramActivity;
    if ((paramActivity instanceof a)) {
      this.b = ((a)paramActivity);
    }
    setCanceledOnTouchOutside(false);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localWindow.setGravity(paramInt1);
    localLayoutParams.x = paramInt2;
    localLayoutParams.y = paramInt3;
    localLayoutParams.width = paramInt4;
    localLayoutParams.height = paramInt5;
    localWindow.setAttributes(localLayoutParams);
    show();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.b != null) {
      this.b.a(paramView, paramInt1, paramInt2);
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.a(paramView, paramInt, paramBoolean);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globalview/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.go.weatherex.themestore.detail;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.jiubang.playsdk.d.e;

public class a
  extends com.jiubang.playsdk.d.a
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(View paramView)
  {
    if (this.b.a()) {
      return;
    }
    Rect localRect = new Rect();
    ((Activity)this.c).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    int j = this.c.getResources().getDimensionPixelSize(2131427421);
    int k = this.c.getResources().getDimensionPixelSize(2131427420);
    a(paramView, 0, this.c.getResources().getDimensionPixelSize(2131427422) + (i + k), j, -2);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramView == this.a) && (paramInt == 82) && (paramKeyEvent.getAction() == 1) && (b()))
    {
      a();
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/detail/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
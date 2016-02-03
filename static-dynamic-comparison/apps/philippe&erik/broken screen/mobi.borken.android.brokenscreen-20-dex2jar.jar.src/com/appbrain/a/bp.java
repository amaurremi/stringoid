package com.appbrain.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.appbrain.AppBrainBanner;
import com.appbrain.BannerListener;

final class bp
  implements View.OnClickListener
{
  bp(bl parambl, int paramInt, String paramString) {}
  
  public final void onClick(View paramView)
  {
    a.a(bl.a(this.c).getContext(), this.a, this.b);
    if (bl.c(this.c) != null) {}
    try
    {
      bl.c(this.c).onClick();
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
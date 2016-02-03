package com.appbrain.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.appbrain.AppBrainBanner;
import com.appbrain.BannerListener;
import com.appbrain.e.j.b;

final class bo
  implements View.OnClickListener
{
  bo(bl parambl, String paramString1, j.b paramb, String paramString2, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    cg.a(bl.a(this.e).getContext(), this.a);
    if (this.b.k()) {
      cg.a(bl.a(this.e).getContext(), this.c, bl.b(this.e), this.b.f(this.d));
    }
    if (bl.c(this.e) != null) {}
    try
    {
      bl.c(this.e).onClick();
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
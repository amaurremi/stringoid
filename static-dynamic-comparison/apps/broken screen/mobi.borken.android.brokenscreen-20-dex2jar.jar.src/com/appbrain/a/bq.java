package com.appbrain.a;

import com.appbrain.AppBrainBanner;
import com.appbrain.BannerListener;
import java.util.concurrent.atomic.AtomicBoolean;

final class bq
  implements BannerListener
{
  bq(bl parambl) {}
  
  public final void onAdRequestDone(boolean paramBoolean)
  {
    this.a.b.set(paramBoolean);
    if ((paramBoolean) && (bl.a(this.a).hasWindowFocus())) {
      this.a.b();
    }
    if (bl.c(this.a) != null) {
      bl.c(this.a).onAdRequestDone(this.a.b.get());
    }
    bl.d(this.a).set(false);
  }
  
  public final void onClick() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
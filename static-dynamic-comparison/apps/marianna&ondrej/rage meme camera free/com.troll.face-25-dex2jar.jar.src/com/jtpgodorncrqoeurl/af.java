package com.jtpgodorncrqoeurl;

import android.app.ProgressDialog;

final class af
  implements AdListener
{
  af(ReEngagementActivity paramReEngagementActivity) {}
  
  public final void onAdAlreadyCompleted()
  {
    ReEngagementActivity.a(this.a).dismiss();
    ReEngagementActivity.b(this.a);
  }
  
  public final void onAdClicked() {}
  
  public final void onAdClosed()
  {
    ReEngagementActivity.a(this.a).dismiss();
    ReEngagementActivity.b(this.a);
  }
  
  public final void onAdCompleted()
  {
    ReEngagementActivity.a(this.a).dismiss();
    ReEngagementActivity.b(this.a);
  }
  
  public final void onAdFailed()
  {
    ReEngagementActivity.a(this.a).dismiss();
    ReEngagementActivity.b(this.a);
  }
  
  public final void onAdLoaded()
  {
    ReEngagementActivity.a(this.a).dismiss();
  }
  
  public final void onAdPaused()
  {
    ReEngagementActivity.a(this.a).dismiss();
    ReEngagementActivity.b(this.a);
  }
  
  public final void onAdProgress() {}
  
  public final void onAdResumed() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.jtpgodorncrqoeurl;

import android.app.ProgressDialog;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

final class k
  implements View.OnClickListener
{
  k(AdController paramAdController) {}
  
  public final void onClick(View paramView)
  {
    AdController.a(this.a, ProgressDialog.show(AdController.l(this.a), "", "Checking....Please Wait!", true));
    if (AdController.m(this.a) == null) {
      AdController.a(this.a, new E(this.a));
    }
    AdController.a(this.a, new Handler());
    try
    {
      AdLog.i("LBAdController", "Manually Polling");
      AdController.n(this.a).post(AdController.m(this.a));
      return;
    }
    catch (Exception paramView)
    {
      AdLog.e("LBAdController", "Error in manual polling - " + paramView.getMessage());
      AdLog.printStackTrace("LBAdController", paramView);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
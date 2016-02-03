package com.go.weatherex.managegood.a;

import android.app.Activity;
import com.getjar.sdk.GetjarVoucherRedeemedResult;
import com.getjar.sdk.OnGetjarVoucherRedeemedListener;

class g
  implements OnGetjarVoucherRedeemedListener
{
  g(a parama) {}
  
  public void onVoucherRedeemed(int paramInt, GetjarVoucherRedeemedResult paramGetjarVoucherRedeemedResult)
  {
    a.a(this.a, "onVoucherRedeemed");
    a.g(this.a).runOnUiThread(new h(this, paramInt, paramGetjarVoucherRedeemedResult));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/managegood/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
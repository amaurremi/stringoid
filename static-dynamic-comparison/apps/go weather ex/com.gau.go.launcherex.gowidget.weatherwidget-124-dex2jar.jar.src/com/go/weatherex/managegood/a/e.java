package com.go.weatherex.managegood.a;

import android.app.Activity;
import com.getjar.sdk.GetjarLicense;
import com.getjar.sdk.GetjarLicense.State;
import com.getjar.sdk.OnGetjarLicensesReceivedListener;
import com.gtp.a.a.b.c;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class e
  implements OnGetjarLicensesReceivedListener
{
  e(a parama) {}
  
  public void onLicensesReceived(int paramInt, List paramList)
  {
    a.a(this.a, "onLicensesReceived");
    c.a("ManageGoodGetjarHelper", "getjar->onLicensesReceived");
    if ((paramInt == 0) && (paramList != null) && (!paramList.isEmpty())) {
      paramList = (GetjarLicense)paramList.get(0);
    }
    for (;;)
    {
      try
      {
        paramList = paramList.getSignedLicenseData();
        c.a("ManageGoodGetjarHelper", "signedLicenseData: " + paramList);
        paramList = new JSONObject(paramList).getString("license_state");
        boolean bool = GetjarLicense.State.ACQUIRED.name().equals(paramList);
        if (bool)
        {
          paramInt = 1;
          if (paramInt != 0) {
            break;
          }
          a.b(this.a, a.d(this.a));
          return;
        }
      }
      catch (JSONException paramList)
      {
        if (c.a()) {
          paramList.printStackTrace();
        }
      }
      paramInt = 0;
    }
    c.a("ManageGoodGetjarHelper", "getjar->alreadyLicensed");
    a.b(this.a, false);
    a.g(this.a).runOnUiThread(new f(this));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/managegood/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.getjar.sdk.utilities;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

public class GetJarDialog
  extends Dialog
  implements View.OnClickListener
{
  public GetJarDialog(Context paramContext, View paramView)
  {
    super(paramContext, 16973840);
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be null");
    }
    if (paramView == null) {
      throw new IllegalArgumentException("'v' can not be null");
    }
    requestWindowFeature(1);
    setContentView(paramView);
  }
  
  public void onClick(View paramView) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/GetJarDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
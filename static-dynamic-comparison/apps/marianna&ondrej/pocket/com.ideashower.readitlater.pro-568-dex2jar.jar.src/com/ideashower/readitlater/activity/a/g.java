package com.ideashower.readitlater.activity.a;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.ideashower.readitlater.activity.a;
import com.ideashower.readitlater.objects.ErrorReport;

public class g
  extends d
{
  public static g a(ErrorReport paramErrorReport, int paramInt, String paramString1, String paramString2)
  {
    g localg = new g();
    localg.a(paramInt, paramErrorReport, true);
    localg.a(paramString1, paramString2);
    return localg;
  }
  
  protected boolean O()
  {
    return false;
  }
  
  public AlertDialog.Builder a(AlertDialog.Builder paramBuilder)
  {
    paramBuilder = super.a(paramBuilder);
    paramBuilder.setIcon(17301543).setNeutralButton(c(2131492880), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    return paramBuilder;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    paramDialogInterface = (a)m();
    if (paramDialogInterface == null)
    {
      if (com.ideashower.readitlater.a.g.n() != null) {
        a(this.Y, this.Z, l().getString("title"), l().getString("message")).N();
      }
      return;
    }
    paramDialogInterface.b(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
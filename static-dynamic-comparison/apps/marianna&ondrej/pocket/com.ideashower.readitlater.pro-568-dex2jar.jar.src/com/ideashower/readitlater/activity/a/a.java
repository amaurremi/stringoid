package com.ideashower.readitlater.activity.a;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.ideashower.readitlater.activity.ak;

public class a
  extends b
{
  public static a K()
  {
    a locala = new a();
    locala.c(2131493065, 2131493041);
    return locala;
  }
  
  public AlertDialog.Builder a(AlertDialog.Builder paramBuilder)
  {
    paramBuilder = super.a(paramBuilder);
    paramBuilder.setIcon(17301543).setNegativeButton(c(2131492942), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (a.this.m() != null) {
          ak.a(a.this.m());
        }
      }
    });
    return paramBuilder;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
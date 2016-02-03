package com.ideashower.readitlater.activity.a;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.ideashower.readitlater.d.f;

public class s
  extends b
{
  DialogInterface.OnClickListener Y;
  
  public static s M()
  {
    s locals = new s();
    locals.c(2131493174, 2131493173);
    return locals;
  }
  
  protected boolean O()
  {
    return false;
  }
  
  public AlertDialog.Builder a(AlertDialog.Builder paramBuilder)
  {
    paramBuilder = super.a(paramBuilder);
    this.Y = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        i.a(0, new f()
        {
          public void a(boolean paramAnonymous2Boolean)
          {
            if (paramAnonymous2Boolean) {
              s.this.b();
            }
          }
        }, s.this.m());
      }
    };
    paramBuilder.setNeutralButton(c(2131492876), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).setPositiveButton(c(2131492875), this.Y);
    return paramBuilder;
  }
  
  protected Bundle l(Bundle paramBundle)
  {
    return paramBundle;
  }
  
  public void w()
  {
    super.w();
    final AlertDialog localAlertDialog = (AlertDialog)c();
    if (localAlertDialog == null) {
      return;
    }
    localAlertDialog.getButton(-1).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        s.this.Y.onClick(localAlertDialog, -1);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
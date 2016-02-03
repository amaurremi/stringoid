package com.ideashower.readitlater.activity.a;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.support.v4.app.d;
import android.view.KeyEvent;
import com.ideashower.readitlater.a.g;

public abstract class o
  extends d
{
  private p Y;
  private boolean Z = false;
  protected boolean ab = false;
  protected boolean ac = true;
  
  protected static Dialog a(d paramd, Dialog paramDialog, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      paramd.b(false);
      paramDialog.setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return paramAnonymousInt == 84;
        }
      });
      return paramDialog;
    }
    paramDialog.setCanceledOnTouchOutside(true);
    return paramDialog;
  }
  
  public void a(p paramp)
  {
    this.Y = paramp;
  }
  
  public void b()
  {
    if ((o() == null) || (r())) {
      return;
    }
    onDismiss(null);
  }
  
  public String c(int paramInt)
  {
    return g.a(paramInt);
  }
  
  public void e(Bundle paramBundle)
  {
    paramBundle.putBoolean("stateShouldPersist", this.ac);
  }
  
  protected void f(boolean paramBoolean)
  {
    if (this.Y != null)
    {
      if (!paramBoolean) {
        break label22;
      }
      this.Y.b(this);
    }
    label22:
    while (this.Z) {
      return;
    }
    this.Z = true;
    this.Y.a(this);
  }
  
  public void h(boolean paramBoolean)
  {
    this.ac = paramBoolean;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    f(true);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    f(false);
  }
  
  public void y()
  {
    super.y();
    f(false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
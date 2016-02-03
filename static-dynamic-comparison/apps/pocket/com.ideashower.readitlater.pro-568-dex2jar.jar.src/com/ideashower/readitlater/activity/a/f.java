package com.ideashower.readitlater.activity.a;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.ideashower.readitlater.activity.a;
import com.pocket.c.e;

public class f
  extends b
{
  private static boolean Y = false;
  
  public static f M()
  {
    f localf = new f();
    localf.c(2131493095, 2131493094);
    return localf;
  }
  
  protected boolean L()
  {
    return Y;
  }
  
  public AlertDialog.Builder a(AlertDialog.Builder paramBuilder)
  {
    paramBuilder = super.a(paramBuilder);
    paramBuilder.setNeutralButton(c(2131492880), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ((a)f.this.m()).b(false);
      }
    }).setPositiveButton(c(2131492932), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        e.l();
      }
    });
    return paramBuilder;
  }
  
  protected boolean b_()
  {
    return true;
  }
  
  protected void e(boolean paramBoolean)
  {
    Y = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.ideashower.readitlater.activity.a;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.a;

public class j
  extends b
{
  protected boolean Y;
  
  public static j a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    j localj = new j();
    localj.g(paramBoolean);
    localj.c(2131493069, 2131493145);
    return localj;
  }
  
  public AlertDialog.Builder a(AlertDialog.Builder paramBuilder)
  {
    this.Y = l().getBoolean("toSD");
    paramBuilder.setPositiveButton(c(2131492924), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        g.a(j.this.Y, (a)j.this.m());
      }
    }).setNegativeButton(c(2131492871), null);
    return paramBuilder;
  }
  
  public void g(boolean paramBoolean)
  {
    this.Y = paramBoolean;
  }
  
  protected Bundle l(Bundle paramBundle)
  {
    paramBundle.putBoolean("toSD", this.Y);
    return super.l(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
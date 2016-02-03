package com.ideashower.readitlater.activity.a;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.a;

public class r
  extends b
{
  private static boolean Y = false;
  private int Z;
  
  public static boolean M()
  {
    return Y;
  }
  
  public static r b(int paramInt)
  {
    r localr = new r();
    localr.d(paramInt);
    localr.c(2131493069, 2131493066);
    return localr;
  }
  
  protected boolean L()
  {
    return Y;
  }
  
  protected boolean O()
  {
    return false;
  }
  
  public AlertDialog.Builder a(AlertDialog.Builder paramBuilder)
  {
    paramBuilder = super.a(paramBuilder);
    final int i = l().getInt("type");
    paramBuilder.setIcon(17301543).setNeutralButton(c(2131492871), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        q.b(i).a((a)r.this.m());
      }
    }).setPositiveButton(c(2131492964), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        g.a(false, (a)r.this.m());
      }
    });
    return paramBuilder;
  }
  
  protected boolean b_()
  {
    return true;
  }
  
  public void d(int paramInt)
  {
    this.Z = paramInt;
  }
  
  protected void e(boolean paramBoolean)
  {
    Y = paramBoolean;
  }
  
  protected Bundle l(Bundle paramBundle)
  {
    paramBundle.putInt("type", this.Z);
    return super.l(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
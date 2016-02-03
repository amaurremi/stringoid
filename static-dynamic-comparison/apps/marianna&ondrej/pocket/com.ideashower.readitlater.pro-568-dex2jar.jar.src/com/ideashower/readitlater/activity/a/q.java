package com.ideashower.readitlater.activity.a;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.ideashower.readitlater.activity.a;
import com.pocket.m.a.l;

public class q
  extends b
{
  private static boolean Y = false;
  private int Z;
  
  public static q a(int paramInt1, int paramInt2, int paramInt3)
  {
    q localq = new q();
    localq.d(paramInt3);
    localq.c(paramInt1, paramInt2);
    return localq;
  }
  
  public static q b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return a(2131493150, 2131493148, paramInt);
    }
    return a(2131493147, 2131493146, paramInt);
  }
  
  protected boolean L()
  {
    return (Y) || (r.M());
  }
  
  protected boolean O()
  {
    return false;
  }
  
  public AlertDialog.Builder a(AlertDialog.Builder paramBuilder)
  {
    paramBuilder = super.a(paramBuilder);
    final int i = l().getInt("type");
    paramBuilder.setIcon(17301543).setNeutralButton(c(2131492932), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        l.a(i);
      }
    }).setPositiveButton(c(2131492886), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        r.b(i).a((a)q.this.m());
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
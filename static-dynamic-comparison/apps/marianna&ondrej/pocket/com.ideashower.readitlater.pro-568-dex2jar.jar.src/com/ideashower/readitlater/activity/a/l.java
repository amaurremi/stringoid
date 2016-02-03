package com.ideashower.readitlater.activity.a;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

public class l
  extends e
{
  private static boolean Y = false;
  private boolean Z;
  
  public static l a(int paramInt, String paramString, boolean paramBoolean)
  {
    paramString = new l();
    paramString.a(null, paramInt);
    return paramString;
  }
  
  public static l a(int paramInt, boolean paramBoolean)
  {
    return a(paramInt, null, paramBoolean);
  }
  
  public static l a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = new l();
    paramString2.a(null, paramString1);
    return paramString2;
  }
  
  public static l b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return a(0, true);
    case 1: 
      return a(2131493065, false);
    }
    return a(2131493062, false);
  }
  
  protected boolean L()
  {
    return Y;
  }
  
  public Dialog c(Bundle paramBundle)
  {
    paramBundle = l().getString("message");
    boolean bool = l().getBoolean("cancelable");
    ProgressDialog localProgressDialog = new ProgressDialog(m());
    localProgressDialog.setMessage(paramBundle);
    localProgressDialog.setIndeterminate(true);
    a(this, localProgressDialog, bool);
    return localProgressDialog;
  }
  
  protected void e(boolean paramBoolean)
  {
    Y = paramBoolean;
  }
  
  protected Bundle l(Bundle paramBundle)
  {
    paramBundle.putBoolean("cancelable", this.Z);
    return super.l(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.ideashower.readitlater.activity.a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class b
  extends e
{
  private static boolean Y = false;
  
  public static b a(int paramInt, String paramString)
  {
    b localb = new b();
    localb.b(paramInt, paramString);
    return localb;
  }
  
  public static b b(int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.c(paramInt1, paramInt2);
    return localb;
  }
  
  protected boolean L()
  {
    return Y;
  }
  
  protected AlertDialog.Builder a(AlertDialog.Builder paramBuilder)
  {
    paramBuilder.setNeutralButton(c(2131492924), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    return paramBuilder;
  }
  
  public Dialog c(Bundle paramBundle)
  {
    paramBundle = l().getString("title");
    String str = l().getString("message");
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(m());
    if (paramBundle != null) {
      localBuilder.setTitle(paramBundle);
    }
    if (str != null) {
      localBuilder.setMessage(str);
    }
    a(localBuilder);
    paramBundle = localBuilder.create();
    a(this, paramBundle, O());
    return paramBundle;
  }
  
  protected void e(boolean paramBoolean)
  {
    Y = paramBoolean;
  }
  
  protected Bundle l(Bundle paramBundle)
  {
    return paramBundle;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
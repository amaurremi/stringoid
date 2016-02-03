package com.skplanet.tad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import com.skplanet.tad.common.a;
import com.skplanet.tad.common.b;

public class AdDialog
{
  private Context a;
  private AdDialogListener b;
  private final Handler c = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      a.c("in AdDialog.handleMessage() msg : " + paramAnonymousMessage.what);
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
        a.a("AdDialog.onAdClosed() will be called.");
      } while (AdDialog.a(AdDialog.this) == null);
      AdDialog.a(AdDialog.this).onDialogClosed();
    }
  };
  
  public AdDialog(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public boolean canShowAdDialog(DialogType paramDialogType)
  {
    a.a("AdDialog.canShowAdDialog() is called.");
    switch (a()[paramDialogType.ordinal()])
    {
    }
    long l1;
    long l2;
    do
    {
      return false;
      if (b.a(this.a).b(15))
      {
        a.c("AdDialog.canShowAdDialog(), already approver");
        return false;
      }
      paramDialogType = PreferenceManager.getDefaultSharedPreferences(this.a);
      l1 = System.currentTimeMillis();
      l2 = paramDialogType.getLong("TAD_DIALOG_SHOWED", l1);
      a.c("AdDialog.canShowAdDialog(), nowDate:" + l1);
      a.c("AdDialog.canShowAdDialog(), lastShowDate:" + l2);
    } while ((l1 - l2 != 0L) && (l1 - l2 <= 1296000000L));
    return true;
  }
  
  public void setListener(AdDialogListener paramAdDialogListener)
  {
    this.b = paramAdDialogListener;
  }
  
  public void showAdDialog(DialogType paramDialogType)
  {
    a.a("AdDialog.showAdDialog() is called.");
    switch (a()[paramDialogType.ordinal()])
    {
    default: 
      return;
    }
    paramDialogType = new Bundle();
    paramDialogType.putString("action", AdActivity.a.f.toString());
    paramDialogType.putInt("dialog.type", 1);
    Intent localIntent = new Intent(this.a, AdActivity.class);
    localIntent.putExtras(paramDialogType);
    AdActivity.b(this.c.obtainMessage(0));
    ((Activity)this.a).startActivity(localIntent);
  }
  
  public static enum DialogType {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/AdDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
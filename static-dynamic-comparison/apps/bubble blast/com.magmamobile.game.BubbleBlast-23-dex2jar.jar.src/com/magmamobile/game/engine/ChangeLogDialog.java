package com.magmamobile.game.engine;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;

@Deprecated
public final class ChangeLogDialog
  implements DialogInterface.OnClickListener
{
  private String mClose;
  private Context mContext;
  private int mLayout;
  private String mTitle;
  private String mVersion;
  
  public ChangeLogDialog(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mVersion = Utils.getAppVersion(paramContext);
    this.mContext = paramContext;
    this.mLayout = paramInt1;
    this.mClose = paramContext.getString(paramInt2);
    this.mTitle = paramContext.getString(paramInt3);
  }
  
  public ChangeLogDialog(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    this.mVersion = Utils.getAppVersion(paramContext);
    this.mContext = paramContext;
    this.mLayout = paramInt;
    this.mClose = paramString1;
    this.mTitle = paramString2;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    paramDialogInterface = PreferenceManager.getDefaultSharedPreferences(this.mContext).edit();
    paramDialogInterface.putString("lastversion", this.mVersion);
    paramDialogInterface.commit();
  }
  
  public void show()
  {
    show(false);
  }
  
  public void show(boolean paramBoolean)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.mContext).getString("lastversion", "");
    if (!paramBoolean)
    {
      if (this.mVersion.equals("1.0.0")) {}
      while (this.mVersion.equals(localObject)) {
        return;
      }
    }
    localObject = new AlertDialog.Builder(this.mContext);
    ((AlertDialog.Builder)localObject).setView(LayoutInflater.from(this.mContext).inflate(this.mLayout, null));
    ((AlertDialog.Builder)localObject).setIcon(17301659);
    ((AlertDialog.Builder)localObject).setPositiveButton(this.mClose, this);
    ((AlertDialog.Builder)localObject).setCancelable(true);
    ((AlertDialog.Builder)localObject).setTitle(this.mTitle);
    ((AlertDialog.Builder)localObject).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/ChangeLogDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
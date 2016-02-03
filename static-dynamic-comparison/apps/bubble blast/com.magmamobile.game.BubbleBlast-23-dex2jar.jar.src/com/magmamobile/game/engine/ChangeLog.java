package com.magmamobile.game.engine;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import java.lang.reflect.Field;

public final class ChangeLog
  implements DialogInterface.OnClickListener
{
  protected Context context;
  protected int resClose;
  protected int resLayout;
  protected int resLog;
  protected int resTitle;
  protected String version;
  
  public ChangeLog(Context paramContext, int paramInt)
  {
    this.version = Utils.getAppVersion(paramContext);
    this.context = paramContext;
    this.resLog = paramInt;
  }
  
  private String loadVersionPref()
  {
    return PreferenceManager.getDefaultSharedPreferences(this.context).getString("lastversion", "");
  }
  
  private void saveVersionPref()
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
    localEditor.putString("lastversion", this.version);
    localEditor.commit();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1) {
      saveVersionPref();
    }
  }
  
  public void show()
  {
    show(false);
  }
  
  public void show(boolean paramBoolean)
  {
    Object localObject1 = loadVersionPref();
    if ((!paramBoolean) && ((this.version.equals("1.0.0")) || (this.version.equals(localObject1)) || (Game.isFirstUse())))
    {
      saveVersionPref();
      return;
    }
    try
    {
      localObject1 = Class.forName(this.context.getPackageName().concat(".R$layout"));
      Object localObject2 = Class.forName(this.context.getPackageName().concat(".R$string"));
      this.resLayout = ((Integer)((Class)localObject1).getField("changelog").get(localObject1)).intValue();
      this.resClose = ((Integer)((Class)localObject2).getField("res_close").get(localObject2)).intValue();
      this.resTitle = ((Integer)((Class)localObject2).getField("res_changelog").get(localObject2)).intValue();
      localObject1 = new AlertDialog.Builder(this.context);
      localObject2 = LayoutInflater.from(this.context).inflate(this.resLayout, null);
      TextView localTextView = (TextView)((View)localObject2).findViewById(16908308);
      localTextView.setText(Html.fromHtml(GamePak.getText(this.resLog).replace("\n", "<br/>")));
      localTextView.setMovementMethod(LinkMovementMethod.getInstance());
      ((AlertDialog.Builder)localObject1).setIcon(17301659);
      ((AlertDialog.Builder)localObject1).setPositiveButton(this.resClose, this);
      ((AlertDialog.Builder)localObject1).setTitle(this.resTitle);
      ((AlertDialog.Builder)localObject1).setCancelable(true);
      ((AlertDialog.Builder)localObject1).setView((View)localObject2);
      ((AlertDialog.Builder)localObject1).show().getWindow().setLayout(-1, -2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/ChangeLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.magmamobile.game.engine;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.webkit.WebView;
import java.lang.reflect.Field;

public final class AboutDialog
{
  private static int getResAbout;
  private static int getResChangeLog;
  private static int getResClose;
  private static int getResIcon32;
  private static int getResName;
  private static int getResTitle;
  private static String html;
  private static boolean loaded;
  private static boolean visible;
  
  private static void doShow(boolean paramBoolean)
  {
    GameActivity localGameActivity = Game.getContext();
    final String str1 = Utils.getAppVersion(localGameActivity);
    if (!loaded)
    {
      initRessources(localGameActivity);
      loaded = true;
    }
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(localGameActivity);
    WebView localWebView = new WebView(localGameActivity);
    String str2 = String.format(localGameActivity.getString(getResTitle), new Object[] { localGameActivity.getString(getResName) });
    localWebView.loadDataWithBaseURL(null, html, "text/html", "utf-8", "about:blank");
    localBuilder.setView(localWebView);
    localBuilder.setTitle(str2);
    localBuilder.setIcon(getResIcon32);
    localBuilder.setCancelable(true);
    localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AboutDialog.visible = false;
      }
    });
    localBuilder.setPositiveButton(localGameActivity.getString(getResClose), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (paramAnonymousInt == -1)
        {
          paramAnonymousDialogInterface = PreferenceManager.getDefaultSharedPreferences(AboutDialog.this).edit();
          paramAnonymousDialogInterface.putString("lastversion", str1);
          paramAnonymousDialogInterface.commit();
        }
        AboutDialog.visible = false;
      }
    });
    localBuilder.show();
  }
  
  private static void initRessources(Context paramContext)
  {
    Object localObject = Game.getParameters();
    getResTitle = ((AppParameters)localObject).CHANGELOG_TITLE;
    getResName = ((AppParameters)localObject).CHANGELOG_NAME;
    getResAbout = ((AppParameters)localObject).CHANGELOG_ABOUT;
    getResIcon32 = ((AppParameters)localObject).CHANGELOG_ICON32;
    getResClose = ((AppParameters)localObject).CHANGELOG_CLOSE;
    getResChangeLog = ((AppParameters)localObject).CHANGELOG_LOG;
    if (getResChangeLog == 0) {}
    try
    {
      localObject = Class.forName(paramContext.getPackageName().concat(".R$string"));
      Class localClass = Class.forName(paramContext.getPackageName().concat(".R$drawable"));
      getResTitle = ((Integer)((Class)localObject).getField("about_title").get(localObject)).intValue();
      getResClose = ((Integer)((Class)localObject).getField("close").get(localObject)).intValue();
      getResName = ((Integer)((Class)localObject).getField("app_name").get(localObject)).intValue();
      getResAbout = ((Integer)((Class)localObject).getField("about").get(localObject)).intValue();
      getResIcon32 = ((Integer)localClass.getField("icon32").get(localClass)).intValue();
      getResChangeLog = GamePak.getKvalue("LOG_CHANGELOG");
      html = paramContext.getString(getResAbout).replace("¤1¤", Utils.getAppVersion(paramContext)).replace("¤2¤", GamePak.getText(getResChangeLog).replace("\n", "<br/>")).replace("¤3¤", Game.getMarket().getCurrentGameUrl()).replace("¤4¤", Game.getMarket().getPublisherUrl());
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      throw new RuntimeException("Missing changelog res cf:AboutDialog.java");
    }
  }
  
  public static void show(boolean paramBoolean)
  {
    if (visible) {
      return;
    }
    Object localObject = Game.getContext();
    String str1 = Utils.getAppVersion((Context)localObject);
    localObject = PreferenceManager.getDefaultSharedPreferences((Context)localObject);
    String str2 = ((SharedPreferences)localObject).getString("lastversion", "");
    if ((!paramBoolean) && ((str1.equals("1.0.0")) || (str1.equals(str2)) || (Game.isFirstUse())))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("lastversion", str1);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    visible = true;
    if (Game.isMainThread())
    {
      doShow(paramBoolean);
      return;
    }
    Game.postRunnable(new Runnable()
    {
      public void run()
      {
        AboutDialog.doShow(this.val$force);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/AboutDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
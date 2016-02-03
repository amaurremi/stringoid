package com.magmamobile.mmusia.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.magmamobile.mmusia.MCommon;
import com.magmamobile.mmusia.MMUSIA;
import com.magmamobile.mmusia.adapters.MoreGamesGridViewAdapterEx;
import com.magmamobile.mmusia.data.LanguageBase;
import com.magmamobile.mmusia.parser.data.ApiBase;
import com.magmamobile.mmusia.parser.data.ItemMoreGames;
import com.magmamobile.mmusia.utils.MMUtils;
import com.magmamobile.mmusia.views.BeforeExitView;

public class MMUSIABeforeExitActivity
  extends Activity
{
  private final int MENU_MMUSIA_QUIT = 3;
  private final int MENU_MMUSIA_REFRESH = 2;
  private final int MSG_CHANGE_MESSAGE = 2;
  private final int MSG_CLOSE = 1;
  private final int MSG_LOADJSONFINISH = 5;
  private final int MSG_OPEN = 0;
  private final int MSG_TOAST = 4;
  private Button btnClose;
  private ProgressDialog mDialog;
  private GridView mListMoreGamesList;
  Handler messageHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 0: 
        MMUSIABeforeExitActivity.this.mDialog = ProgressDialog.show(MMUSIABeforeExitActivity.this, LanguageBase.DIALOG_LOADING, LanguageBase.DIALOG_PLEASEWAIT, true, true);
        return;
      case 1: 
        try
        {
          MMUSIABeforeExitActivity.this.mDialog.dismiss();
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          paramAnonymousMessage.printStackTrace();
          return;
        }
      case 2: 
        MMUSIABeforeExitActivity.this.mDialog.setMessage((String)paramAnonymousMessage.obj);
        return;
      case 4: 
        Toast.makeText(MMUSIABeforeExitActivity.this, (String)paramAnonymousMessage.obj, 1).show();
        return;
      case 5: 
        MMUSIABeforeExitActivity.this.displayMoreGames();
        return;
      }
      MMUSIABeforeExitActivity.this.finish();
    }
  };
  
  public void displayMoreGames()
  {
    try
    {
      if (MMUSIA.api.moregames == null) {
        MMUSIA.api.moregames = new ItemMoreGames[0];
      }
      MoreGamesGridViewAdapterEx localMoreGamesGridViewAdapterEx = new MoreGamesGridViewAdapterEx(this);
      localMoreGamesGridViewAdapterEx.setData(MMUtils.getMoreGamesForExit(this, MMUSIA.api.moregames));
      this.mListMoreGamesList.setAdapter(localMoreGamesGridViewAdapterEx);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void lClickBeforeExitApp(final Context paramContext, final String paramString)
  {
    new Thread()
    {
      public void run()
      {
        MMUSIA.lClickBeforeExit(paramContext, paramString);
      }
    }.start();
  }
  
  public void loadNews(final Context paramContext)
  {
    new Thread()
    {
      public void run()
      {
        MMUSIABeforeExitActivity.this.loadNewsThread(paramContext);
      }
    }.start();
  }
  
  public void loadNewsThread(Context paramContext)
  {
    this.messageHandler.sendMessage(Message.obtain(this.messageHandler, 0));
    MMUSIA.getLatestNews(paramContext, false, true);
    this.messageHandler.sendMessage(Message.obtain(this.messageHandler, 1));
    this.messageHandler.sendMessage(Message.obtain(this.messageHandler, 5));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (MCommon.getBeforeExitDontShow(this))
    {
      finish();
      return;
    }
    LanguageBase.reloadIfNeeded();
    try
    {
      if (MMUSIA.appIconID == 0) {
        MMUSIA.appIconID = getResources().getIdentifier(MCommon.iconFileName, "drawable", getPackageName());
      }
      MCommon.useDpi(this);
      MCommon.Log_d(MCommon.getDensity(this));
      setContentView(new BeforeExitView(this));
      this.mListMoreGamesList = ((GridView)findViewById(MMUSIA.RES_ID_LISTVIEW_MOREGAMES));
      this.btnClose = ((Button)findViewById(MMUSIA.RES_ID_BEFOREEXIT_BTN_CLOSE));
    }
    catch (Exception paramBundle)
    {
      try
      {
        MCommon.Log_e("MMUSIA.RES_DRAWABLE_ICONAPP : " + MMUSIA.appIconID);
        if (MMUSIA.appIconID != 0) {
          ((ImageView)findViewById(MMUSIA.RES_ID_IMG_MOREGAMES_HEAD)).setImageDrawable(MCommon.getAssetDrawableResize(getResources().getDrawable(MMUSIA.appIconID), MCommon.dpiImage(48), MCommon.dpiImage(48)));
        }
        ((TextView)findViewById(MMUSIA.RES_ID_TITLE_MOREGAMES_HEAD)).setText(LanguageBase.DIALOG_MOREGAMES_TITLE);
        this.btnClose.setText(LanguageBase.BEFOREEXIT_BTNCLOSE);
        this.btnClose.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            MMUSIABeforeExitActivity.this.finish();
          }
        });
        if (MMUSIA.api != null) {
          if (MMUSIA.api.moregames.length == 0)
          {
            loadNews(this);
            this.mListMoreGamesList.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                paramAnonymousAdapterView = ((MoreGamesGridViewAdapterEx)MMUSIABeforeExitActivity.this.mListMoreGamesList.getAdapter()).getItem(paramAnonymousInt);
                if (paramAnonymousAdapterView.isLocal) {
                  try
                  {
                    paramAnonymousView = new Intent("android.intent.action.MAIN", null);
                    paramAnonymousView.addCategory("android.intent.category.LAUNCHER");
                    paramAnonymousView.setComponent(new ComponentName(paramAnonymousAdapterView.pname, paramAnonymousAdapterView.cname));
                    paramAnonymousView.setFlags(268435456);
                    MMUSIABeforeExitActivity.this.startActivity(paramAnonymousView);
                    return;
                  }
                  catch (Exception paramAnonymousView)
                  {
                    do
                    {
                      paramAnonymousView.printStackTrace();
                    } while (paramAnonymousAdapterView.urlMarket.equals(""));
                    if ((paramAnonymousAdapterView.urlMarket.startsWith("http://")) || (paramAnonymousAdapterView.urlMarket.startsWith("https://")))
                    {
                      MCommon.openUrlPage(MMUSIABeforeExitActivity.this, paramAnonymousAdapterView.urlMarket);
                      return;
                    }
                    MCommon.openMarketLink(MMUSIABeforeExitActivity.this, paramAnonymousAdapterView.urlMarket);
                    return;
                  }
                }
                if (!paramAnonymousAdapterView.urlMarket.equals(""))
                {
                  if (!paramAnonymousAdapterView.urlMarket.startsWith("http://")) {
                    break label195;
                  }
                  MCommon.openUrlPage(MMUSIABeforeExitActivity.this, paramAnonymousAdapterView.urlMarket);
                }
                for (;;)
                {
                  MMUSIABeforeExitActivity.this.lClickBeforeExitApp(MMUSIABeforeExitActivity.this, paramAnonymousAdapterView.pname);
                  return;
                  label195:
                  MCommon.openMarketLink(MMUSIABeforeExitActivity.this, paramAnonymousAdapterView.urlMarket);
                }
              }
            });
            return;
            paramBundle = paramBundle;
            MCommon.Log_e("TRIED TO RELOAD ICON APP ID WITHOUT SUCCESS !!!");
            paramBundle.printStackTrace();
          }
        }
      }
      catch (Resources.NotFoundException paramBundle)
      {
        for (;;)
        {
          MCommon.Log_e("OULALA ICON INTROUVABLE !!!");
          MCommon.Log_e("MMUSIA.RES_DRAWABLE_ICONAPP : " + MMUSIA.appIconID);
          MCommon.Log_e("LanguageBase.TAB_UPDATES : " + LanguageBase.TAB_UPDATES);
          MCommon.Log_e("MMUSIA.RES_ID_TAB_UPDATE : " + MMUSIA.RES_ID_TAB_UPDATE);
          paramBundle.printStackTrace();
          continue;
          displayMoreGames();
          continue;
          loadNews(this);
        }
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 2, 0, LanguageBase.MENU_REFRESH).setIcon(MCommon.getAssetDrawable(this, "mmusiarefresh.png"));
    paramMenu.add(0, 3, 0, LanguageBase.MENU_QUIT).setIcon(MCommon.getAssetDrawable(this, "mmusiaexit.png"));
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return true;
      loadNews(this);
      continue;
      finish();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/activities/MMUSIABeforeExitActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.magmamobile.mmusia.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.magmamobile.mmusia.MCommon;
import com.magmamobile.mmusia.MMUSIA;
import com.magmamobile.mmusia.adapters.MoreGamesListAdapterEx;
import com.magmamobile.mmusia.data.LanguageBase;
import com.magmamobile.mmusia.parser.data.ApiBase;
import com.magmamobile.mmusia.parser.data.ItemMoreGames;
import com.magmamobile.mmusia.views.MoreGamesView;

public class MMUSIAMoreGamesActivity
  extends Activity
{
  private final int MENU_MMUSIA_QUIT = 3;
  private final int MENU_MMUSIA_REFRESH = 2;
  private final int MSG_CHANGE_MESSAGE = 2;
  private final int MSG_CLOSE = 1;
  private final int MSG_LOADJSONFINISH = 5;
  private final int MSG_OPEN = 0;
  private final int MSG_TOAST = 4;
  private ProgressDialog mDialog;
  private ListView mListMoreGamesList;
  Handler messageHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 0: 
        MMUSIAMoreGamesActivity.this.mDialog = ProgressDialog.show(MMUSIAMoreGamesActivity.this, LanguageBase.DIALOG_LOADING, LanguageBase.DIALOG_PLEASEWAIT, true, true);
        return;
      case 1: 
        try
        {
          MMUSIAMoreGamesActivity.this.mDialog.dismiss();
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          paramAnonymousMessage.printStackTrace();
          return;
        }
      case 2: 
        try
        {
          MMUSIAMoreGamesActivity.this.mDialog.setMessage((String)paramAnonymousMessage.obj);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          paramAnonymousMessage.printStackTrace();
          return;
        }
      case 4: 
        Toast.makeText(MMUSIAMoreGamesActivity.this, (String)paramAnonymousMessage.obj, 1).show();
        return;
      case 5: 
        MMUSIAMoreGamesActivity.this.displayMoreGames();
        return;
      }
      MMUSIAMoreGamesActivity.this.finish();
    }
  };
  
  public void displayMoreGames()
  {
    try
    {
      if (MMUSIA.api.moregames == null) {
        MMUSIA.api.moregames = new ItemMoreGames[0];
      }
      MoreGamesListAdapterEx localMoreGamesListAdapterEx = new MoreGamesListAdapterEx(this);
      localMoreGamesListAdapterEx.setData(MMUSIA.api.moregames);
      this.mListMoreGamesList.setAdapter(localMoreGamesListAdapterEx);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void lClickMoreApp(final Context paramContext, final String paramString)
  {
    new Thread()
    {
      public void run()
      {
        MMUSIA.lClickMoreApp(paramContext, paramString);
      }
    }.start();
  }
  
  public void loadNews(final Context paramContext)
  {
    new Thread()
    {
      public void run()
      {
        MMUSIAMoreGamesActivity.this.loadNewsThread(paramContext);
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
    LanguageBase.reloadIfNeeded();
    try
    {
      if (MMUSIA.appIconID == 0) {
        MMUSIA.appIconID = getResources().getIdentifier(MCommon.iconFileName, "drawable", getPackageName());
      }
      MCommon.useDpi(this);
      MCommon.Log_d(MCommon.getDensity(this));
      setContentView(new MoreGamesView(this));
      this.mListMoreGamesList = ((ListView)findViewById(MMUSIA.RES_ID_LISTVIEW_MOREGAMES));
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
        if (MMUSIA.api != null) {
          if (MMUSIA.api.moregames.length == 0)
          {
            loadNews(this);
            this.mListMoreGamesList.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                paramAnonymousAdapterView = ((MoreGamesListAdapterEx)MMUSIAMoreGamesActivity.this.mListMoreGamesList.getAdapter()).getItem(paramAnonymousInt);
                if (!paramAnonymousAdapterView.urlMarket.equals(""))
                {
                  if ((!paramAnonymousAdapterView.urlMarket.startsWith("http://")) && (!paramAnonymousAdapterView.urlMarket.startsWith("https://"))) {
                    break label81;
                  }
                  MCommon.openUrlPage(MMUSIAMoreGamesActivity.this, paramAnonymousAdapterView.urlMarket);
                }
                for (;;)
                {
                  MMUSIAMoreGamesActivity.this.lClickMoreApp(MMUSIAMoreGamesActivity.this, paramAnonymousAdapterView.pname);
                  return;
                  label81:
                  MCommon.openMarketLink(MMUSIAMoreGamesActivity.this, paramAnonymousAdapterView.urlMarket);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/activities/MMUSIAMoreGamesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
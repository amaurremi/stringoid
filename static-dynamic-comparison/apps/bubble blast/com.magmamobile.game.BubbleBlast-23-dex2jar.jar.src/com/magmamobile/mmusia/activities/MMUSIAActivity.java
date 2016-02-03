package com.magmamobile.mmusia.activities;

import android.app.Activity;
import android.app.ProgressDialog;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;
import com.magmamobile.mmusia.MCommon;
import com.magmamobile.mmusia.MMUSIA;
import com.magmamobile.mmusia.adapters.NewsListAdapterEx;
import com.magmamobile.mmusia.adapters.UpdatesListAdapterEx;
import com.magmamobile.mmusia.data.LanguageBase;
import com.magmamobile.mmusia.parser.data.ApiBase;
import com.magmamobile.mmusia.parser.data.ItemAppUpdate;
import com.magmamobile.mmusia.parser.data.ItemNews;
import com.magmamobile.mmusia.views.MainView;

public class MMUSIAActivity
  extends Activity
{
  private final int MENU_MMUSIA_QUIT = 3;
  private final int MENU_MMUSIA_REFRESH = 2;
  private final int MENU_MMUSIA_SETTINGS = 1;
  private final int MSG_CHANGE_MESSAGE = 2;
  private final int MSG_CLOSE = 1;
  private final int MSG_LOADJSONFINISH = 5;
  private final int MSG_OPEN = 0;
  private final int MSG_TOAST = 4;
  private ProgressDialog mDialog;
  private ListView mListAppUpdate;
  private ListView mListNewsList;
  private TabHost mTabs;
  Handler messageHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 0: 
        MMUSIAActivity.this.mDialog = ProgressDialog.show(MMUSIAActivity.this, LanguageBase.DIALOG_LOADING, LanguageBase.DIALOG_PLEASEWAIT, true, true);
        return;
      case 1: 
        try
        {
          MMUSIAActivity.this.mDialog.dismiss();
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          paramAnonymousMessage.printStackTrace();
          return;
        }
      case 2: 
        MMUSIAActivity.this.mDialog.setMessage((String)paramAnonymousMessage.obj);
        return;
      case 4: 
        Toast.makeText(MMUSIAActivity.this, (String)paramAnonymousMessage.obj, 1).show();
        return;
      case 5: 
        MMUSIAActivity.this.displayNews();
        return;
      }
      MMUSIAActivity.this.finish();
    }
  };
  
  public void displayNews()
  {
    try
    {
      if (MMUSIA.api.news == null) {
        MMUSIA.api.news = new ItemNews[0];
      }
      Object localObject = new NewsListAdapterEx(this);
      ((NewsListAdapterEx)localObject).setData(MMUSIA.api.news);
      this.mListNewsList.setAdapter((ListAdapter)localObject);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          if (MMUSIA.api.updates == null) {
            MMUSIA.api.updates = new ItemAppUpdate[0];
          }
          localObject = new UpdatesListAdapterEx(this);
          ((UpdatesListAdapterEx)localObject).setData(MMUSIA.api.updates);
          this.mListAppUpdate.setAdapter((ListAdapter)localObject);
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
        }
        try
        {
          if (MMUSIA.api.updates.length == 0) {
            this.mTabs.setCurrentTab(1);
          }
          return;
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
        }
        localException1 = localException1;
        localException1.printStackTrace();
      }
    }
  }
  
  public void lNews(final Context paramContext, final int paramInt)
  {
    new Thread()
    {
      public void run()
      {
        MMUSIA.LNews(paramContext, paramInt);
      }
    }.start();
  }
  
  public void lUpdate(final Context paramContext, final String paramString)
  {
    new Thread()
    {
      public void run()
      {
        MMUSIA.LUpdate(paramContext, paramString);
      }
    }.start();
  }
  
  public void lUpdateDialog(final Context paramContext, final String paramString)
  {
    new Thread()
    {
      public void run()
      {
        MMUSIA.LUpdateDialog(paramContext, paramString);
      }
    }.start();
  }
  
  public void loadNews(final Context paramContext)
  {
    new Thread()
    {
      public void run()
      {
        MMUSIAActivity.this.loadNewsThread(paramContext);
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
      paramBundle = getIntent().getExtras();
      MCommon.useDpi(this);
      MCommon.Log_d(MCommon.getDensity(this));
      setContentView(new MainView(this));
      this.mListAppUpdate = ((ListView)findViewById(MMUSIA.RES_ID_LISTVIEW_APPUPDATE));
      this.mListNewsList = ((ListView)findViewById(MMUSIA.RES_ID_LISTVIEW_NEWSLIST));
      this.mTabs = ((TabHost)findViewById(MMUSIA.RES_ID_LISTVIEW_MAINTAB));
      this.mTabs.setVisibility(0);
      this.mTabs.setup();
    }
    catch (Exception paramBundle)
    {
      try
      {
        MCommon.Log_e("MMUSIA.RES_DRAWABLE_ICONAPP : " + MMUSIA.appIconID);
        if (MMUSIA.appIconID == 0) {
          this.mTabs.addTab(this.mTabs.newTabSpec("tab_main_channel").setIndicator(LanguageBase.TAB_UPDATES).setContent(MMUSIA.RES_ID_TAB_UPDATE));
        }
        for (;;)
        {
          this.mTabs.addTab(this.mTabs.newTabSpec("tab_main_last").setIndicator(LanguageBase.TAB_NEWS, MCommon.getAssetDrawableResize(MCommon.getAssetDrawable(this, "mmusiaicon.png"), MCommon.dpiImage(75), MCommon.dpiImage(24))).setContent(MMUSIA.RES_ID_TAB_NEWS));
          if (paramBundle != null)
          {
            if (!paramBundle.getString("tab").equals("news")) {
              break label500;
            }
            this.mTabs.setCurrentTab(1);
          }
          if (MMUSIA.api == null) {
            break label518;
          }
          if (MMUSIA.api.news.length != 0) {
            break label511;
          }
          loadNews(this);
          this.mListNewsList.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              paramAnonymousAdapterView = ((NewsListAdapterEx)MMUSIAActivity.this.mListNewsList.getAdapter()).getItem(paramAnonymousInt);
              if (!paramAnonymousAdapterView.NewsUrlMarket.equals("")) {
                MCommon.openMarketLink(MMUSIAActivity.this, paramAnonymousAdapterView.NewsUrlMarket);
              }
              for (;;)
              {
                MMUSIAActivity.this.lNews(MMUSIAActivity.this, paramAnonymousAdapterView.NewsID);
                return;
                MCommon.openUrlPage(MMUSIAActivity.this, paramAnonymousAdapterView.NewsUrlLink);
              }
            }
          });
          this.mListAppUpdate.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              paramAnonymousAdapterView = ((UpdatesListAdapterEx)MMUSIAActivity.this.mListAppUpdate.getAdapter()).getItem(paramAnonymousInt);
              MCommon.openMarketLink(MMUSIAActivity.this, paramAnonymousAdapterView.MarketLink);
              MMUSIAActivity.this.lUpdate(MMUSIAActivity.this, paramAnonymousAdapterView.PackageName);
            }
          });
          return;
          paramBundle = paramBundle;
          MCommon.Log_e("TRIED TO RELOAD ICON APP ID WITHOUT SUCCESS !!!");
          paramBundle.printStackTrace();
          break;
          this.mTabs.addTab(this.mTabs.newTabSpec("tab_main_channel").setIndicator(LanguageBase.TAB_UPDATES, MCommon.getAssetDrawableResize(getResources().getDrawable(MMUSIA.appIconID), MCommon.dpiImage(24), MCommon.dpiImage(24))).setContent(MMUSIA.RES_ID_TAB_UPDATE));
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        for (;;)
        {
          MCommon.Log_e("OULALA ICON INTROUVABLE !!!");
          MCommon.Log_e("MMUSIA.RES_DRAWABLE_ICONAPP : " + MMUSIA.appIconID);
          MCommon.Log_e("LanguageBase.TAB_UPDATES : " + LanguageBase.TAB_UPDATES);
          MCommon.Log_e("MMUSIA.RES_ID_TAB_UPDATE : " + MMUSIA.RES_ID_TAB_UPDATE);
          TabHost.TabSpec localTabSpec = this.mTabs.newTabSpec("tab_main_channel").setIndicator(LanguageBase.TAB_UPDATES).setContent(MMUSIA.RES_ID_TAB_UPDATE);
          this.mTabs.addTab(localTabSpec);
          localNotFoundException.printStackTrace();
          continue;
          label500:
          this.mTabs.setCurrentTab(0);
          continue;
          label511:
          displayNews();
          continue;
          label518:
          loadNews(this);
        }
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 1, 0, LanguageBase.MENU_SETTINGS).setIcon(MCommon.getAssetDrawable(this, "mmusiasettings.png"));
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
      MCommon.showPrefs(this);
      continue;
      loadNews(this);
      continue;
      finish();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/activities/MMUSIAActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
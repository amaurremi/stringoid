package com.magmamobile.game.BubbleBlast.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;
import com.magmamobile.game.BubbleBlast.modCommon;
import com.magmamobile.game.BubbleBlast.modPreferences;
import com.magmamobile.game.BubbleBlast.utils.GoogleAnalytics;
import com.magmamobile.game.BubbleBlast.utils.ScoreloopManager;
import com.magmamobile.mmusia.MMUSIA;
import com.magmamobile.mmusia.activities.MMUSIAActivity;
import com.magmamobile.mmusia.activities.MMUSIAMoreGamesActivity;

public class MainActivity
  extends Activity
{
  private final int MENU_ABOUT = 0;
  private final int MENU_MMUSIA = 1;
  private final int MENU_QUIT = 2;
  private ImageButton imgBtnBB2;
  private ImageButton imgBtnBBH;
  private ImageButton imgBtnBBH2;
  private ImageButton imgBtnBBV;
  private ImageButton imgBtnFB;
  private ImageButton imgBtnMoreApps;
  private ImageButton imgBtnOptions;
  private ImageButton imgBtnPlay;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903046);
    modPreferences.LoadPreferences(this);
    modPreferences.prefStartCount += 1;
    modPreferences.savePreferences(this);
    this.imgBtnPlay = ((ImageButton)findViewById(2131099685));
    this.imgBtnPlay.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(MainActivity.this, GameModeActivity.class);
        MainActivity.this.startActivityForResult(paramAnonymousView, 1000);
      }
    });
    this.imgBtnOptions = ((ImageButton)findViewById(2131099686));
    this.imgBtnOptions.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(MainActivity.this, PreferencesActivity.class);
        MainActivity.this.startActivityForResult(paramAnonymousView, 1001);
      }
    });
    this.imgBtnMoreApps = ((ImageButton)findViewById(2131099687));
    this.imgBtnMoreApps.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          paramAnonymousView = new Intent(MainActivity.this, MMUSIAMoreGamesActivity.class);
          MainActivity.this.startActivityForResult(paramAnonymousView, 2001);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          Toast.makeText(MainActivity.this, MainActivity.this.getString(2131034133), 2000).show();
        }
      }
    });
    this.imgBtnBB2 = ((ImageButton)findViewById(2131099690));
    this.imgBtnBB2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        modCommon.openMarket(MainActivity.this, "com.magmamobile.game.BubbleBlast2&referrer=utm_source%3DBubbleBlast%26utm_medium%3DHomePage%26utm_campaign%3DBubbleBlast1");
      }
    });
    this.imgBtnBBH = ((ImageButton)findViewById(2131099691));
    this.imgBtnBBH.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        modCommon.openMarket(MainActivity.this, "com.magmamobile.game.BubbleBlastHalloween&referrer=utm_source%3DBubbleBlast%26utm_medium%3DHomePage%26utm_campaign%3DBubbleBlast1");
      }
    });
    this.imgBtnBBH2 = ((ImageButton)findViewById(2131099689));
    this.imgBtnBBH2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        modCommon.openMarket(MainActivity.this, "com.magmamobile.game.BubbleBlastHoliday&referrer=utm_source%3DBubbleBlast%26utm_medium%3DHomePage%26utm_campaign%3DBubbleBlast1");
      }
    });
    this.imgBtnBBV = ((ImageButton)findViewById(2131099688));
    this.imgBtnBBV.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        modCommon.openMarket(MainActivity.this, "com.magmamobile.game.BubbleBlastValentine&referrer=utm_source%3DBubbleBlast%26utm_medium%3DHomePage%26utm_campaign%3DBubbleBlast1");
      }
    });
    this.imgBtnFB = ((ImageButton)findViewById(2131099692));
    this.imgBtnFB.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        modCommon.openUrl(MainActivity.this, "http://www.facebook.com/MagmaMobile");
      }
    });
    ScoreloopManager.start(this);
    if ((modPreferences.prefGameCount / 10 != modPreferences.prefAskedMarketCount) && (!modPreferences.prefAsk4RateNeverAskAgain) && (modPreferences.prefGameCount / 10 > 0))
    {
      modPreferences.prefAskedMarketCount = modPreferences.prefGameCount / 10;
      modCommon.showAsk4Rate(this);
      modPreferences.savePreferences(this);
    }
    if (!modCommon.getAppVersion(this).equals(modPreferences.prefLastVersion))
    {
      modCommon.showAbout(this);
      paramBundle = PreferenceManager.getDefaultSharedPreferences(this).edit();
      paramBundle.putString("LastVersion", modCommon.getAppVersion(this));
      paramBundle.commit();
    }
    GoogleAnalytics.start(this, "/" + modCommon.getAppVersion(this) + "/");
    new MMUSIA().Init(this, getString(2131034248), "BubbleBlast1");
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 0, getString(2131034130)).setIcon(2130837519);
    paramMenu.add(0, 1, 0, "Magma Mobile News").setIcon(2130837523);
    paramMenu.add(0, 2, 0, "Quit").setIcon(2130837514);
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
      startActivityForResult(new Intent(this, MMUSIAActivity.class), 1001);
      continue;
      finish();
      continue;
      modCommon.showAbout(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/activities/MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
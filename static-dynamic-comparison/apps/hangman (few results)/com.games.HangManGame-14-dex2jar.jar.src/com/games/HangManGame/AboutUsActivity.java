package com.games.HangManGame;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class AboutUsActivity
  extends Activity
{
  public static final int BACK_MENU_ID = 1;
  ImageView slideMe;
  ImageView speedTester;
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setContentView(2130903040);
    this.slideMe = ((ImageView)findViewById(2131296256));
    this.speedTester = ((ImageView)findViewById(2131296257));
    this.slideMe.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AboutUsActivity.this.openBrowser("http://market.android.com/details?id=com.caprusIT.games");
      }
    });
    this.speedTester.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AboutUsActivity.this.openBrowser("http://market.android.com/details?id=com.games.speedtester");
      }
    });
    super.onCreate(paramBundle);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    paramMenu.add(0, 1, 0, "Back");
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      finish();
    }
  }
  
  public void openBrowser(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString));
    startActivity(localIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/games/HangManGame/AboutUsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
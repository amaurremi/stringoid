package com.games.HangManGame;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.Menu;
import android.view.MenuItem;

public class GamePreferences
  extends PreferenceActivity
{
  public static final int BACK_MENU_ID = 1;
  public static final String WORD_CATEGORY = "pref_key_category";
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2130968576);
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/games/HangManGame/GamePreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
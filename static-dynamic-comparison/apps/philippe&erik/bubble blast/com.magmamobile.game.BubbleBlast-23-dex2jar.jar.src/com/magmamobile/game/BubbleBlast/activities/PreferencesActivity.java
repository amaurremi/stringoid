package com.magmamobile.game.BubbleBlast.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.ListView;
import android.widget.Toast;
import com.magmamobile.game.BubbleBlast.modCommon;
import com.magmamobile.game.BubbleBlast.modPreferences;
import com.magmamobile.game.BubbleBlast.utils.GoogleAnalytics;
import com.magmamobile.game.BubbleBlast.utils.ScoreloopManager;
import com.scoreloop.client.android.core.controller.RequestController;
import com.scoreloop.client.android.core.controller.UserController;
import com.scoreloop.client.android.core.controller.UserControllerObserver;
import com.scoreloop.client.android.core.model.Client;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.User;

public class PreferencesActivity
  extends PreferenceActivity
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private SharedPreferences sharedPreferences;
  private UserController userController;
  
  private void updateSummaries() {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      findPreference("prefUserName").setSummary(getString(2131034118));
      this.userController = new UserController(new UserUpdateObserver(null));
      this.userController.submitUser();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2130968576);
    this.sharedPreferences = getPreferenceManager().getSharedPreferences();
    this.sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    findPreference("prefUserName").setSummary(getString(2131034118));
    this.userController = new UserController(new UserUpdateObserver(null));
    this.userController.submitUser();
    findPreference("prefUserName").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
    {
      public boolean onPreferenceClick(Preference paramAnonymousPreference)
      {
        paramAnonymousPreference = new Intent(PreferencesActivity.this, ScoreloopActivity.class);
        PreferencesActivity.this.startActivityForResult(paramAnonymousPreference, 1010);
        return false;
      }
    });
    findPreference("market").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
    {
      public boolean onPreferenceClick(Preference paramAnonymousPreference)
      {
        try
        {
          PreferencesActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://market.android.com/search?q=pub:%22Magma%20Mobile%22&referrer=utm_source%3DBubbleBlast%26utm_medium%3DInGamePref%26utm_campaign%3DPreferenceLink")));
          return false;
        }
        catch (Exception paramAnonymousPreference)
        {
          for (;;)
          {
            Toast.makeText(PreferencesActivity.this, PreferencesActivity.this.getString(2131034133), 2000).show();
          }
        }
      }
    });
    findPreference("changelog").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
    {
      public boolean onPreferenceClick(Preference paramAnonymousPreference)
      {
        modCommon.showAbout(PreferencesActivity.this);
        return false;
      }
    });
    ((ListView)findViewById(16908298)).setBackgroundColor(17170444);
    updateSummaries();
    GoogleAnalytics.trackAndDispatch("Preferences");
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    updateSummaries();
    modCommon.Log_i("Updated summaries.");
  }
  
  protected void onStop()
  {
    modPreferences.LoadPreferences(this);
    super.onStop();
  }
  
  public void updateScoreloopUserName(String paramString)
  {
    findPreference("prefUserName").setSummary(paramString);
  }
  
  private class UserUpdateObserver
    implements UserControllerObserver
  {
    private UserUpdateObserver() {}
    
    public void onEmailAlreadyTaken(UserController paramUserController) {}
    
    public void onEmailInvalidFormat(UserController paramUserController) {}
    
    public void onUsernameAlreadyTaken(UserController paramUserController) {}
    
    public void requestControllerDidFail(RequestController paramRequestController, Exception paramException)
    {
      PreferencesActivity.this.updateScoreloopUserName("Error occured to retreive Username");
    }
    
    public void requestControllerDidReceiveResponse(RequestController paramRequestController)
    {
      PreferencesActivity.this.updateScoreloopUserName(ScoreloopManager.client.getSession().getUser().getDisplayName());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/activities/PreferencesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
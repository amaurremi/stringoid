package mobi.borken.android.brokenscreen;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import java.util.Map;
import mobi.borken.android.common.ApplicationMetaDataHelper;
import mobi.borken.android.util.GoogleEventTracker;

public class EffectPreferenceActivity
  extends PreferenceActivity
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private ApplicationMetaDataHelper metaDataHelper;
  private GoogleEventTracker tracker;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.tracker = new GoogleEventTracker(this);
    this.metaDataHelper = new ApplicationMetaDataHelper(this);
    setVolumeControlStream(3);
    addPreferencesFromResource(2130968576);
  }
  
  protected void onPause()
  {
    super.onPause();
    getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences.getAll().get(paramString);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.tracker.activityStart(this);
    this.tracker.screenView(this.metaDataHelper.property("variation"), "Settings Screen");
  }
  
  protected void onStop()
  {
    super.onStop();
    this.tracker.activityStop(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/mobi/borken/android/brokenscreen/EffectPreferenceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
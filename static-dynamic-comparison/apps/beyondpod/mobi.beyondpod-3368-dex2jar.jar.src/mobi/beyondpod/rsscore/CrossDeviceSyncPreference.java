package mobi.beyondpod.rsscore;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import java.util.Date;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.sync.ChangeTracker;
import mobi.beyondpod.ui.dialogs.CrossDeviceSyncSetupActivity;

public class CrossDeviceSyncPreference
  extends Preference
{
  public static final CharSequence PREFERENCE_KEY = "CrossDeviceSync";
  
  public CrossDeviceSyncPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    RefreshLastSync();
  }
  
  private void RefreshLastSync()
  {
    if (!ChangeTracker.IsTrackingEnabled()) {
      setSummary(getContext().getString(2131297208));
    }
    while (!ChangeTracker.IsSyncLicenseValid())
    {
      setEnabled(false);
      setSummary(getContext().getString(2131297210));
      return;
      if (Configuration.LastSyncTimeStamp() > 0L) {
        setSummary(getContext().getString(2131297209, new Object[] { DateTime.FormatDateTime(new Date(Configuration.LastSyncTimeStamp())) }));
      } else {
        setSummary("");
      }
    }
    setEnabled(true);
  }
  
  public void Refresh()
  {
    RefreshLastSync();
  }
  
  protected void onBindView(View paramView)
  {
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), CrossDeviceSyncSetupActivity.class);
    localIntent.setFlags(524288);
    setIntent(localIntent);
    RefreshLastSync();
    super.onBindView(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/CrossDeviceSyncPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package mobi.beyondpod.rsscore;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import java.io.File;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.ui.dialogs.BackupRestoreActivity;

public class BackupRestorePreference
  extends Preference
{
  public BackupRestorePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    RefreshLatestBackup();
  }
  
  private void RefreshLatestBackup()
  {
    File[] arrayOfFile = BackupRestore.EnumerateRestoreZipFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      setSummary("");
      return;
    }
    setSummary(getContext().getString(2131297188, new Object[] { arrayOfFile[0].getName() }));
  }
  
  public void Refresh()
  {
    RefreshLatestBackup();
  }
  
  protected void onBindView(View paramView)
  {
    RefreshLatestBackup();
    super.onBindView(paramView);
  }
  
  protected void onClick()
  {
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), BackupRestoreActivity.class);
    localIntent.setFlags(524288);
    getContext().startActivity(localIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/BackupRestorePreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
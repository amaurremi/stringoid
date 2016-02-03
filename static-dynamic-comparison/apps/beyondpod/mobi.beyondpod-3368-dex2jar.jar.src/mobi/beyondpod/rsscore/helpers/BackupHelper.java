package mobi.beyondpod.rsscore.helpers;

import android.annotation.SuppressLint;
import android.app.backup.BackupManager;
import mobi.beyondpod.rsscore.Configuration;

public abstract class BackupHelper
{
  public static BackupHelper getInstance()
  {
    if (CoreHelper.ApiLevel() < 8) {
      return BackupHelper.OldStyle.Holder.sInstance;
    }
    return BackupHelper.NewStyle.Holder.sInstance;
  }
  
  public abstract void RequestBackup();
  
  public abstract void RequestRestore();
  
  private static class NewStyle
    extends BackupHelper
  {
    private static String TAG = NewStyle.class.getSimpleName();
    
    @SuppressLint({"NewApi"})
    public void RequestBackup()
    {
      CoreHelper.WriteTraceEntry(TAG, "## NEW STYLE ## RequestBackup() - Calling the Android Backup Manager...");
      BackupManager.dataChanged(Configuration.PackageName());
    }
    
    public void RequestRestore()
    {
      CoreHelper.WriteTraceEntry(TAG, "## NEW STYLE ## RequestRestore() - Calling the Android Backup Manager...");
    }
    
    private static class Holder
    {
      private static final BackupHelper.NewStyle sInstance = new BackupHelper.NewStyle(null);
    }
  }
  
  private static class OldStyle
    extends BackupHelper
  {
    private static String TAG = OldStyle.class.getSimpleName();
    
    public void RequestBackup()
    {
      CoreHelper.WriteTraceEntry(TAG, "## OLD STYLE ## RequestBackup() - backup not supported on pre 2.2 devices");
    }
    
    public void RequestRestore()
    {
      CoreHelper.WriteTraceEntry(TAG, "## OLD STYLE ## RequestRestore() - restore not supported on pre 2.2 devices");
    }
    
    private static class Holder
    {
      private static final BackupHelper.OldStyle sInstance = new BackupHelper.OldStyle(null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/BackupHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
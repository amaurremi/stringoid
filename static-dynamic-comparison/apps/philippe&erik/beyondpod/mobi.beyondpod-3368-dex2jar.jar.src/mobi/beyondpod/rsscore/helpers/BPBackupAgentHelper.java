package mobi.beyondpod.rsscore.helpers;

import android.annotation.SuppressLint;
import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.SharedPreferencesBackupHelper;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import mobi.beyondpod.BeyondPodApplication;

@SuppressLint({"NewApi"})
public class BPBackupAgentHelper
  extends BackupAgentHelper
{
  static final String PREFS = "Settings";
  static final String PREFS_BACKUP_KEY = "BPPreferences";
  private static final String TAG = BPBackupAgentHelper.class.getSimpleName();
  
  public void onBackup(ParcelFileDescriptor paramParcelFileDescriptor1, BackupDataOutput paramBackupDataOutput, ParcelFileDescriptor paramParcelFileDescriptor2)
    throws IOException
  {
    super.onBackup(paramParcelFileDescriptor1, paramBackupDataOutput, paramParcelFileDescriptor2);
    CoreHelper.WriteLogEntryInProduction(TAG, "*** Preferences backed up!");
  }
  
  public void onCreate()
  {
    addHelper("BPPreferences", new SharedPreferencesBackupHelper(this, new String[] { "Settings" }));
  }
  
  public void onRestore(BackupDataInput paramBackupDataInput, int paramInt, ParcelFileDescriptor paramParcelFileDescriptor)
    throws IOException
  {
    super.onRestore(paramBackupDataInput, paramInt, paramParcelFileDescriptor);
    CoreHelper.WriteTraceEntry(TAG, "*** Preferences restored for version: " + paramInt + "! Exiting...");
    BeyondPodApplication.GetInstance().shutdown();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/BPBackupAgentHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
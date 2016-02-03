package mobi.beyondpod.rsscore;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Environment;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import java.io.File;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.dialogs.MoveFilesDialog;

public class PodcastStorageFolderPreference
  extends Preference
{
  public PodcastStorageFolderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    RefreshLatestBackup();
  }
  
  private void RefreshLatestBackup()
  {
    if (GetAlternativePath() == null)
    {
      setSummary(Configuration.EnclosureDownloadRoot());
      setEnabled(false);
      return;
    }
    setSummary(getContext().getResources().getString(2131297201, new Object[] { Configuration.EnclosureDownloadRoot(), GetAlternativePath().getAbsolutePath() }));
    setEnabled(true);
  }
  
  public static void ShowMoveInstructionsDialog(Context paramContext, File paramFile, int paramInt)
  {
    new AlertDialog.Builder(paramContext).setTitle(paramInt).setMessage(paramContext.getResources().getString(2131297196, new Object[] { paramFile.getAbsolutePath() })).setPositiveButton(2131296752, null).setNegativeButton(2131296315, null).setPositiveButton(2131297279, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        CommandManager.StartActivity(new Intent(BeyondPodApplication.GetInstance(), MoveFilesDialog.class));
      }
    }).show();
  }
  
  public File GetAlternativePath()
  {
    File localFile2 = Environment.getExternalStorageDirectory();
    File localFile3 = CoreHelper.GetOptionalStorageMount();
    File localFile1 = localFile2;
    if (StringUtils.EqualsIgnoreCase(CoreHelper.ExternalStorageDirectory().getAbsolutePath(), localFile2.getAbsolutePath())) {
      localFile1 = localFile3;
    }
    if ((localFile1 != null) && (localFile1.exists()) && (localFile1.canWrite())) {
      return localFile1;
    }
    return null;
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
    if (GetAlternativePath() != null) {
      ShowMoveInstructionsDialog(getContext(), GetAlternativePath(), 2131297198);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/PodcastStorageFolderPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
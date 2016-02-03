package mobi.beyondpod.rsscore;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.preference.Preference;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class DownloadFolderPreference
  extends Preference
{
  public static final String PREFERENCE_KEY = "CustomSDCardLocation";
  
  public DownloadFolderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    RefreshLatestBackup();
  }
  
  private void RefreshLatestBackup()
  {
    if (StringUtils.IsNullOrEmpty(Configuration.CustomSDCardLocation()))
    {
      setSummary(getContext().getString(2131296599));
      return;
    }
    Resources localResources = getContext().getResources();
    if (StringUtils.EqualsIgnoreCase(CoreHelper.ExternalStorageDirectory().getAbsolutePath(), Configuration.CustomSDCardLocation())) {}
    for (int i = 2131297199;; i = 2131297200)
    {
      setSummary(localResources.getString(i, new Object[] { Configuration.CustomSDCardLocation() }));
      return;
    }
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
    final EditText localEditText = new EditText(getContext());
    localEditText.setInputType(16);
    localEditText.setText(Configuration.CustomSDCardLocation());
    new AlertDialog.Builder(getContext()).setTitle(2131296598).setMessage(2131296599).setView(localEditText).setPositiveButton(2131296752, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = localEditText.getText().toString();
        if (!StringUtils.IsNullOrEmpty(paramAnonymousDialogInterface))
        {
          File localFile = new File(paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = localFile;
          if (StringUtils.EqualsIgnoreCase(localFile.getName(), "BeyondPod")) {
            paramAnonymousDialogInterface = localFile.getParentFile();
          }
          if ((!paramAnonymousDialogInterface.exists()) || (!paramAnonymousDialogInterface.canWrite())) {
            Toast.makeText(DownloadFolderPreference.this.getContext(), DownloadFolderPreference.this.getContext().getResources().getString(2131297202, new Object[] { paramAnonymousDialogInterface.getAbsolutePath() }), 1).show();
          }
          do
          {
            return;
            Configuration.setCustomSDCardLocation(paramAnonymousDialogInterface.getAbsolutePath());
          } while (StringUtils.EqualsIgnoreCase(CoreHelper.ExternalStorageDirectory().getAbsolutePath(), paramAnonymousDialogInterface.getAbsolutePath()));
          PodcastStorageFolderPreference.ShowMoveInstructionsDialog(DownloadFolderPreference.this.getContext(), paramAnonymousDialogInterface, 2131297197);
          return;
        }
        Configuration.setCustomSDCardLocation(paramAnonymousDialogInterface);
      }
    }).setNegativeButton(2131296315, null).setCancelable(true).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/DownloadFolderPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
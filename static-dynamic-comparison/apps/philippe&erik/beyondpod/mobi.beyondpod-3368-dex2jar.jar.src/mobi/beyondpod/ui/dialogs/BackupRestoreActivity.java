package mobi.beyondpod.ui.dialogs;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.BackupManifest;
import mobi.beyondpod.rsscore.BackupRestore;
import mobi.beyondpod.rsscore.BackupRestore.BackupRestoreOperationResult;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.StartupContentBuilder;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.views.FolderBrowserDialog;
import mobi.beyondpod.ui.views.MasterView;

public class BackupRestoreActivity
  extends ActionBarActivityBase
{
  private static final String BEYOND_POD_HELP = CoreHelper.LoadResourceString(2131297061);
  private static final int MENU_HELP = 0;
  private View.OnClickListener _BackupListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      int i = 0;
      paramAnonymousView = FeedRepository.getRootFeed().SubFeeds().iterator();
      for (;;)
      {
        if (!paramAnonymousView.hasNext())
        {
          if (i <= 0) {
            break;
          }
          new AlertDialog.Builder(BackupRestoreActivity.this).setTitle(2131296714).setMessage(BackupRestoreActivity.this.getString(2131297194, new Object[] { Integer.valueOf(i) })).setNegativeButton(2131296315, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          }).setPositiveButton(2131296759, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              BackupRestoreActivity.this.CreateBackup();
            }
          }).create().show();
          return;
        }
        if (!StringUtils.IsNullOrEmpty(((Feed)paramAnonymousView.next()).getPassword())) {
          i += 1;
        }
      }
      paramAnonymousView = Configuration.findAndroidReportedExternalStorage();
      if ((paramAnonymousView != null) && (Configuration.DefaultBackupPath().startsWith(paramAnonymousView.getAbsolutePath())))
      {
        new AlertDialog.Builder(BackupRestoreActivity.this).setTitle(2131296714).setMessage(BackupRestoreActivity.this.getString(2131297195)).setNegativeButton(2131296315, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        }).setPositiveButton(2131296759, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            BackupRestoreActivity.this.CreateBackup();
          }
        }).create().show();
        return;
      }
      BackupRestoreActivity.this.CreateBackup();
    }
  };
  ProgressBar _BackupProgress;
  Context _Context;
  boolean _ExitOnFinish = false;
  View _RestoreCmd;
  private View.OnClickListener _RestoreListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      BackupRestoreActivity.this.SelectBackupFile(2131297186, new BackupRestoreActivity.BackupSelectedListener()
      {
        public void onBackupSelected(String paramAnonymous2String, File paramAnonymous2File)
        {
          BackupRestoreActivity.this.PrepareForRestore(paramAnonymous2File);
        }
      });
    }
  };
  ProgressBar _RestoreProgress;
  TextView _RestoreSummary;
  TextView _SettingsSummary;
  View _ShareCmd;
  private View.OnClickListener _ShareListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      BackupRestoreActivity.this.SelectBackupFile(2131297187, new BackupRestoreActivity.BackupSelectedListener()
      {
        public void onBackupSelected(String paramAnonymous2String, File paramAnonymous2File)
        {
          paramAnonymous2String = new Intent("android.intent.action.SEND");
          paramAnonymous2String.putExtra("android.intent.extra.STREAM", Uri.fromFile(paramAnonymous2File));
          paramAnonymous2String.setType("application/zip");
          try
          {
            BackupRestoreActivity.this.startActivity(Intent.createChooser(paramAnonymous2String, BackupRestoreActivity.this.getString(2131297190)));
            return;
          }
          catch (ActivityNotFoundException paramAnonymous2String) {}
        }
      });
    }
  };
  
  private void FinishAndRestart()
  {
    PendingIntent localPendingIntent = PendingIntent.getActivity(BeyondPodApplication.GetInstance().getBaseContext(), 0, new Intent("mobi.beyondpod.action.VIEW_MASTER"), 268435456);
    ((AlarmManager)getSystemService("alarm")).set(1, System.currentTimeMillis() + 2000L, localPendingIntent);
    this._ExitOnFinish = true;
    finish();
  }
  
  private void PrepareForRestore(final File paramFile)
  {
    this._RestoreProgress.setVisibility(0);
    BackupRestore.UnzipBackup(paramFile, new BackupRestore.BackupRestoreOperationResult()
    {
      public void OperationCompleted(int paramAnonymousInt, String paramAnonymousString, final BackupManifest paramAnonymousBackupManifest)
      {
        BackupRestoreActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            BackupRestoreActivity.this.RestoreFromSnapshot(paramAnonymousBackupManifest);
            BackupRestoreActivity.this._RestoreProgress.setVisibility(8);
          }
        });
      }
      
      public void OperationFailed(int paramAnonymousInt, final String paramAnonymousString)
      {
        BackupRestoreActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if (this.val$backupFile.getName().toLowerCase().endsWith("opml"))
            {
              Intent localIntent = new Intent("android.intent.action.PICK", Uri.fromFile(this.val$backupFile), BackupRestoreActivity.this, MasterView.class);
              BackupRestoreActivity.this.startActivity(localIntent);
              BackupRestoreActivity.this.finish();
              return;
            }
            Toast.makeText(BackupRestoreActivity.this, BackupRestoreActivity.this.getString(2131297189, new Object[] { paramAnonymousString }), 0).show();
            BackupRestoreActivity.this._RestoreProgress.setVisibility(8);
          }
        });
      }
    });
  }
  
  private void RefreshBackupRestoreFolder()
  {
    this._SettingsSummary.setText(getString(2131297182, new Object[] { Configuration.DefaultBackupPath() }));
    File[] arrayOfFile = BackupRestore.EnumerateRestoreZipFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      this._ShareCmd.setVisibility(8);
      this._RestoreSummary.setText(getString(2131297185, new Object[] { Configuration.DefaultBackupPath() }));
      return;
    }
    this._ShareCmd.setVisibility(0);
    this._RestoreSummary.setText(getString(2131297188, new Object[] { arrayOfFile[0].getName() }));
  }
  
  private void RestoreFromSnapshot(BackupManifest paramBackupManifest)
  {
    new AlertDialog.Builder(this).setTitle(2131297192).setMessage(getString(2131297193, new Object[] { paramBackupManifest.VersionCode, paramBackupManifest.Device, DateUtils.formatDateTime(this, paramBackupManifest.BackupTime.getTime(), 17) })).setNegativeButton(2131296315, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).setPositiveButton(2131296759, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        BackupRestoreActivity.this._RestoreProgress.setVisibility(0);
        BackupRestore.RestoreBackup(new BackupRestore.BackupRestoreOperationResult()
        {
          public void OperationCompleted(int paramAnonymous2Int, String paramAnonymous2String, BackupManifest paramAnonymous2BackupManifest)
          {
            StartupContentBuilder.DeleteDatabase();
            BackupRestoreActivity.this.runOnUiThread(new Runnable()
            {
              public void run()
              {
                BackupRestoreActivity.this._RestoreProgress.setVisibility(8);
                Toast.makeText(BackupRestoreActivity.this, 2131297191, 0).show();
                BackupRestoreActivity.this._RestoreCmd.postDelayed(new Runnable()
                {
                  public void run()
                  {
                    BackupRestoreActivity.this.FinishAndRestart();
                  }
                }, 2000L);
              }
            });
          }
          
          public void OperationFailed(int paramAnonymous2Int, final String paramAnonymous2String)
          {
            BackupRestoreActivity.this.runOnUiThread(new Runnable()
            {
              public void run()
              {
                Toast.makeText(BackupRestoreActivity.this, BackupRestoreActivity.this.getString(2131297189, new Object[] { paramAnonymous2String }), 0).show();
                BackupRestoreActivity.this._RestoreProgress.setVisibility(8);
              }
            });
          }
        });
      }
    }).create().show();
  }
  
  private void SelectBackupFile(int paramInt, final BackupSelectedListener paramBackupSelectedListener)
  {
    final File[] arrayOfFile = BackupRestore.EnumerateRestoreZipFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      new AlertDialog.Builder(this._Context).setMessage(getString(2131297185, new Object[] { "\n\n" + Configuration.DefaultBackupPath() })).setNeutralButton(2131296752, null).create().show();
      return;
    }
    final Object localObject = BackupRestore.ExtractReastoreFileNames(arrayOfFile);
    localObject = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]);
    new AlertDialog.Builder(this).setItems((CharSequence[])localObject, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (paramBackupSelectedListener != null) {
          paramBackupSelectedListener.onBackupSelected(localObject[paramAnonymousInt], arrayOfFile[paramAnonymousInt]);
        }
      }
    }).setTitle(paramInt).setCancelable(true).setNegativeButton(2131296315, null).create().show();
  }
  
  private void StartRestoreIfNeeded(Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {
      return;
    }
    Object localObject2 = null;
    Object localObject1;
    if ("android.intent.action.SEND".equals(paramIntent.getAction()))
    {
      paramIntent = paramIntent.getCharSequenceExtra("android.intent.extra.TEXT");
      localObject1 = localObject2;
      if (paramIntent != null) {
        localObject1 = Uri.parse(paramIntent.toString());
      }
    }
    for (;;)
    {
      paramIntent = new File(((Uri)localObject1).getPath());
      if (!paramIntent.exists()) {
        break;
      }
      PrepareForRestore(paramIntent);
      return;
      localObject1 = localObject2;
      if (paramIntent.getData() != null)
      {
        paramIntent = "http:" + paramIntent.getData().getEncodedSchemeSpecificPart();
        localObject1 = localObject2;
        if (!StringUtils.IsNullOrEmpty(paramIntent)) {
          localObject1 = Uri.parse(CoreHelper.SafeDecodeUrl(paramIntent.replaceAll("\\\\x", "%")));
        }
      }
    }
  }
  
  void CreateBackup()
  {
    this._BackupProgress.setVisibility(0);
    BackupRestore.CreateZippedBackup(new BackupRestore.BackupRestoreOperationResult()
    {
      public void OperationCompleted(int paramAnonymousInt, final String paramAnonymousString, BackupManifest paramAnonymousBackupManifest)
      {
        BackupRestoreActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            Toast.makeText(BackupRestoreActivity.this._Context, BackupRestoreActivity.this.getString(2131297184, new Object[] { paramAnonymousString }), 1).show();
            BackupRestoreActivity.this._BackupProgress.setVisibility(8);
            BackupRestoreActivity.this.RefreshBackupRestoreFolder();
          }
        });
      }
      
      public void OperationFailed(int paramAnonymousInt, final String paramAnonymousString)
      {
        BackupRestoreActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            Toast.makeText(BackupRestoreActivity.this._Context, BackupRestoreActivity.this.getString(2131297183, new Object[] { paramAnonymousString }), 1).show();
            BackupRestoreActivity.this._BackupProgress.setVisibility(8);
          }
        });
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      Configuration.setDefaultBackupPath(paramIntent.getData().getPath().replace("file://", ""));
      RefreshBackupRestoreFolder();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this._Context = this;
    setContentView(2130903071);
    findViewById(2131230828).setOnClickListener(this._BackupListener);
    this._BackupProgress = ((ProgressBar)findViewById(2131230830));
    this._RestoreCmd = findViewById(2131230832);
    this._RestoreCmd.setOnClickListener(this._RestoreListener);
    this._RestoreSummary = ((TextView)findViewById(2131230835));
    this._RestoreProgress = ((ProgressBar)findViewById(2131230834));
    findViewById(2131230839).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(BackupRestoreActivity.this, FolderBrowserDialog.class);
        BackupRestoreActivity.this.startActivityForResult(paramAnonymousView, 102);
      }
    });
    findViewById(2131230842).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView) {}
    });
    this._ShareCmd = findViewById(2131230836);
    this._ShareCmd.setOnClickListener(this._ShareListener);
    this._SettingsSummary = ((TextView)findViewById(2131230841));
    getActionBarHelper().setDisplayOptions(4, 4);
    setTitle(2131297173);
    StartRestoreIfNeeded(getIntent());
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 0, 2131296681);
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this._ExitOnFinish) {
      System.exit(0);
    }
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    case 16908332: 
      finish();
      return true;
    }
    CommandManager.CmdStartHtmlViewActivity(Configuration.BackupRestoreFileURL(), BEYOND_POD_HELP, false);
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
    RefreshBackupRestoreFolder();
  }
  
  public static abstract interface BackupSelectedListener
  {
    public abstract void onBackupSelected(String paramString, File paramFile);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/BackupRestoreActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package mobi.beyondpod.ui.dialogs;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class MoveFilesDialog
  extends Activity
{
  private static final int COPY_ERROR = -8;
  private static final int DEST_CLEANUP_ERROR = -4;
  private static final int DEST_FOLDER_READONLY = -9;
  private static final int DEST_UNAVAILABLE = -6;
  private static final int FATAL_ERROR = -2;
  private static final int FOLDER_TYPE_DESTINATION = 1;
  private static final int FOLDER_TYPE_SOURCE = 0;
  private static final int MOVE_CANCELLED = -1;
  private static final int MOVE_COMPLETED = 0;
  private static final int MOVE_PROGRESS_STATUS = 1;
  private static final int NOTHING_TO_DO = -5;
  private static final int SOURCE_CLEANUP_ERROR = -3;
  private static final int SOURCE_FOLDER_READONLY = -10;
  private static final String TAG = "MoveFilesDialog";
  private static final int UPDATE_AND_DOWNLOAD_IN_PROGRESS = -7;
  public static boolean _isRunning = false;
  private final String MESSAGE_TAG = "message";
  private final String PROGRESS_TAG = "progress";
  private boolean _ExitOnFinish;
  private long _availableSize;
  private Button _cancelBtn;
  private Context _context;
  private File _destinationFolder;
  private ArrayList<File> _internalFileList = new ArrayList();
  private MoveThread _moveThread = null;
  private ProgressBar _progressBar;
  private ProgressBar _resultProgressBar;
  private TextView _resultsTV;
  private File _sourceFolder;
  private long _totalFileSize;
  Handler handler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      int i = 0;
      switch (paramAnonymousMessage.what)
      {
      case -2: 
      default: 
        Toast.makeText(MoveFilesDialog.this, "Move Failed!\n\n" + paramAnonymousMessage.what + " - " + paramAnonymousMessage.getData().getString("message"), 1).show();
        MoveFilesDialog.this.finish();
      }
      for (;;)
      {
        paramAnonymousMessage = MoveFilesDialog.this._resultProgressBar;
        if (MoveFilesDialog.this._progressBar.getProgress() <= 0) {
          i = 8;
        }
        paramAnonymousMessage.setVisibility(i);
        return;
        MoveFilesDialog.this.finish();
        continue;
        MoveFilesDialog.this.onMoveCompleted();
        continue;
        MoveFilesDialog.this.onMoveCompleted();
        continue;
        MoveFilesDialog.this._resultsTV.setText(paramAnonymousMessage.getData().getString("message"));
        int j = paramAnonymousMessage.getData().getInt("progress");
        if (j >= 0)
        {
          MoveFilesDialog.this._progressBar.setIndeterminate(false);
          MoveFilesDialog.this._progressBar.setProgress(j);
        }
        else if (j == -2)
        {
          MoveFilesDialog.this._progressBar.setIndeterminate(true);
          continue;
          Toast.makeText(MoveFilesDialog.this, 2131297273, 1).show();
          MoveFilesDialog.this.finish();
          continue;
          Toast.makeText(MoveFilesDialog.this, 2131297281, 1).show();
          MoveFilesDialog.this.finish();
          continue;
          Toast.makeText(MoveFilesDialog.this, 2131297269, 1).show();
          MoveFilesDialog.this.finish();
          continue;
          Toast.makeText(MoveFilesDialog.this, MoveFilesDialog.this.getString(2131297276, new Object[] { MoveFilesDialog.this._destinationFolder.getAbsolutePath() }), 1).show();
          MoveFilesDialog.this.finish();
          continue;
          Toast.makeText(MoveFilesDialog.this, paramAnonymousMessage.getData().getString("message"), 1).show();
          continue;
          MoveFilesDialog.this.askToMoveToAppStorageFolder();
          continue;
          MoveFilesDialog.this.askToMoveToInternalStorageOrAppStorageFolder();
        }
      }
    }
  };
  
  private void askToMoveToAppStorageFolder()
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        final File localFile = Configuration.findAndroidReportedExternalStorage();
        if (localFile == null) {
          MoveFilesDialog.this.sendMessage(null, 0, -6);
        }
        new AlertDialog.Builder(MoveFilesDialog.this._context).setMessage(2131297282).setCancelable(true).setPositiveButton(MoveFilesDialog.this.getString(2131296759), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            if (!CoreHelper.isFolderReallyWritable(localFile))
            {
              MoveFilesDialog.this.sendMessage(null, 0, -6);
              return;
            }
            MoveFilesDialog.this._destinationFolder = new File(localFile, MoveFilesDialog.this._sourceFolder.getName());
            new Thread(new Runnable()
            {
              public void run()
              {
                MoveFilesDialog.this.checkFiles();
              }
            }).start();
          }
        }).setNegativeButton(MoveFilesDialog.this.getString(2131296315), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            MoveFilesDialog.this.sendMessage(null, 0, -5);
          }
        }).show();
      }
    });
  }
  
  private void askToMoveToInternalStorageOrAppStorageFolder()
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        final File localFile = Configuration.findAndroidReportedExternalStorage();
        if (localFile == null)
        {
          MoveFilesDialog.this.sendMessage(null, 0, -6);
          return;
        }
        final View localView = MoveFilesDialog.this.getLayoutInflater().inflate(2130903134, null);
        new AlertDialog.Builder(MoveFilesDialog.this._context).setView(localView).setCancelable(true).setPositiveButton(MoveFilesDialog.this.getString(2131296759), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            if (((RadioGroup)localView.findViewById(2131231095)).getCheckedRadioButtonId() == 2131231097)
            {
              if (!CoreHelper.isFolderReallyWritable(localFile))
              {
                MoveFilesDialog.this.sendMessage(null, 0, -6);
                return;
              }
              MoveFilesDialog.this._destinationFolder = new File(localFile, MoveFilesDialog.this._sourceFolder.getName());
            }
            new Thread(new Runnable()
            {
              public void run()
              {
                MoveFilesDialog.this.checkFiles();
              }
            }).start();
          }
        }).setNegativeButton(MoveFilesDialog.this.getString(2131296315), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            MoveFilesDialog.this.sendMessage(null, 0, -5);
          }
        }).show();
      }
    });
  }
  
  private void buildFileList(File paramFile, boolean paramBoolean)
  {
    int j;
    int i;
    try
    {
      arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        j = arrayOfFile.length;
        i = 0;
        break label98;
      }
      if (!paramBoolean) {
        break label107;
      }
      this._internalFileList.add(paramFile);
      return;
    }
    catch (Throwable paramFile)
    {
      File[] arrayOfFile;
      label35:
      File localFile;
      CoreHelper.WriteLogEntry("MoveFilesDialog", "Error loading feeds! " + paramFile.getMessage());
      return;
    }
    localFile = arrayOfFile[i];
    if (localFile.isDirectory()) {
      buildFileList(localFile, paramBoolean);
    } else {
      this._internalFileList.add(localFile);
    }
    for (;;)
    {
      label98:
      if (i < j) {
        break label35;
      }
      break;
      label107:
      return;
      i += 1;
    }
  }
  
  private void cancelMove()
  {
    new AlertDialog.Builder(this).setTitle(getString(2131296315)).setMessage(getString(2131297268)).setCancelable(false).setPositiveButton(getString(2131296753), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        MoveFilesDialog.this.sendMessage(MoveFilesDialog.this.getString(2131297274), -2, 1);
        MoveFilesDialog.this._moveThread.cancel();
        MoveFilesDialog.this._cancelBtn.setEnabled(false);
      }
    }).setNegativeButton(getString(2131296754), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).show();
  }
  
  private void checkFiles()
  {
    File localFile1 = this._destinationFolder.getParentFile();
    if (UpdateAndDownloadManager.IsWorking())
    {
      sendMessage(null, 0, -7);
      return;
    }
    if ((!isExternalStorageAvailable()) || (isExternalStorageReadOnly()) || (!localFile1.exists()))
    {
      sendMessage(null, 0, -6);
      return;
    }
    if (!CoreHelper.isFolderReallyWritable(new File(this._destinationFolder.getParent())))
    {
      sendMessage(null, 0, -9);
      return;
    }
    Iterator localIterator;
    try
    {
      sendMessage(getString(2131297270), -2, 1);
      this._totalFileSize = 0L;
      this._internalFileList.clear();
      buildFileList(this._sourceFolder, true);
      localIterator = this._internalFileList.iterator();
      if (!localIterator.hasNext())
      {
        this._availableSize = localFile1.getUsableSpace();
        if (this._totalFileSize != 0L) {
          break label224;
        }
        sendMessage(null, 0, -5);
        return;
      }
    }
    catch (Exception localException)
    {
      sendMessage(localException.getMessage(), 0, -2);
      return;
    }
    File localFile2 = (File)localIterator.next();
    long l2 = this._totalFileSize;
    if (localFile2.isDirectory()) {}
    for (long l1 = 0L;; l1 = localFile2.length())
    {
      this._totalFileSize = (l1 + l2);
      break;
    }
    label224:
    if (this._availableSize <= this._totalFileSize)
    {
      warnInsufficientSpace();
      return;
    }
    if (this._destinationFolder.exists())
    {
      warnDestFolderExists();
      return;
    }
    checkProceedMove();
  }
  
  private void checkProceedMove()
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        new AlertDialog.Builder(MoveFilesDialog.this._context).setTitle(MoveFilesDialog.this.getString(2131297266)).setMessage(MoveFilesDialog.this.getString(2131297267, new Object[] { CoreHelper.GetFileLengthAsString(Long.valueOf(MoveFilesDialog.this._totalFileSize)), MoveFilesDialog.this._sourceFolder.getAbsolutePath(), MoveFilesDialog.this._destinationFolder.getAbsoluteFile() })).setCancelable(false).setPositiveButton(MoveFilesDialog.this.getString(2131296753), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            if (UpdateAndDownloadManager.IsWorking())
            {
              MoveFilesDialog.this.sendMessage(null, 0, -7);
              return;
            }
            MoveFilesDialog.this._cancelBtn.setEnabled(true);
            MoveFilesDialog.this._moveThread = new MoveFilesDialog.MoveThread(MoveFilesDialog.this);
            MoveFilesDialog.this._moveThread.start();
          }
        }).setNegativeButton(MoveFilesDialog.this.getString(2131296754), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            MoveFilesDialog.this.sendMessage(null, 0, -5);
          }
        }).show();
      }
    });
  }
  
  private void deleteFolderInternal(int paramInt)
  {
    File localFile;
    Object localObject2;
    Object localObject1;
    label61:
    int i;
    if (paramInt == 0)
    {
      localFile = this._sourceFolder;
      this._internalFileList.clear();
      buildFileList(localFile, true);
      localObject2 = new StringBuilder("Cleaning up ").append(this._internalFileList.size()).append(" files from ");
      if (paramInt != 0) {
        break label298;
      }
      localObject1 = "source";
      CoreHelper.WriteTraceEntry("MoveFilesDialog", (String)localObject1 + " folder " + localFile.getAbsolutePath());
      i = 0;
      localObject1 = this._internalFileList.iterator();
      label101:
      if (((Iterator)localObject1).hasNext()) {
        break label306;
      }
      CoreHelper.WriteTraceEntry("MoveFilesDialog", "Deleted " + i + " files!");
      localObject1 = this._internalFileList.iterator();
      label148:
      if (((Iterator)localObject1).hasNext()) {
        break label408;
      }
      sendMessage(getString(2131297272), (int)Math.ceil(i / this._internalFileList.size() * 100.0F), 1);
      CoreHelper.WriteTraceEntry("MoveFilesDialog", "Deleted " + i + " folders!");
      if (!localFile.exists()) {
        break label481;
      }
      this._internalFileList.clear();
      buildFileList(localFile, true);
      CoreHelper.WriteTraceEntry("MoveFilesDialog", "Failed to clean " + this._internalFileList.size() + " files!");
      if (paramInt != 0) {
        break label475;
      }
    }
    label298:
    label306:
    label408:
    label475:
    for (paramInt = -3;; paramInt = -4)
    {
      sendMessage(null, 0, paramInt);
      return;
      localFile = this._destinationFolder;
      break;
      localObject1 = "destination";
      break label61;
      localObject2 = (File)((Iterator)localObject1).next();
      if (((File)localObject2).isDirectory()) {
        break label101;
      }
      int j = i;
      if (((File)localObject2).delete()) {
        j = i + 1;
      }
      i = j;
      if (this._internalFileList.size() <= 20) {
        break label101;
      }
      i = j;
      if (j % (this._internalFileList.size() / 20) != 0) {
        break label101;
      }
      sendMessage(getString(2131297272), (int)Math.ceil(j / this._internalFileList.size() * 100.0F), 1);
      i = j;
      break label101;
      localObject2 = (File)((Iterator)localObject1).next();
      if (!((File)localObject2).isDirectory()) {
        break label148;
      }
      CoreHelper.WriteTraceEntry("MoveFilesDialog", "   Deleting folder " + ((File)localObject2).getAbsolutePath() + "...");
      if (!((File)localObject2).delete()) {
        break label148;
      }
      i += 1;
      break label148;
    }
    label481:
    CoreHelper.WriteTraceEntry("MoveFilesDialog", "Cleanup completed!");
    if (paramInt == 0) {}
    for (paramInt = 0;; paramInt = -1)
    {
      sendMessage(null, 1, paramInt);
      return;
    }
  }
  
  private static File getAlternativePath()
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
  
  private static boolean isExternalStorageAvailable()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  private static boolean isExternalStorageReadOnly()
  {
    return "mounted_ro".equals(Environment.getExternalStorageState());
  }
  
  private boolean isOutOfBounds(Activity paramActivity, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = ViewConfiguration.get(paramActivity).getScaledWindowTouchSlop();
    paramActivity = paramActivity.getWindow().getDecorView();
    return (i < -k) || (j < -k) || (i > paramActivity.getWidth() + k) || (j > paramActivity.getHeight() + k);
  }
  
  private void notifyAndRestart()
  {
    Toast.makeText(this, getString(2131297278, new Object[] { "" }), 1).show();
    this._resultsTV.postDelayed(new Runnable()
    {
      public void run()
      {
        PendingIntent localPendingIntent = PendingIntent.getActivity(BeyondPodApplication.GetInstance().getBaseContext(), 0, new Intent("mobi.beyondpod.action.VIEW_MASTER"), 268435456);
        ((AlarmManager)MoveFilesDialog.this.getSystemService("alarm")).set(1, System.currentTimeMillis() + 2000L, localPendingIntent);
        MoveFilesDialog.this._ExitOnFinish = true;
        MoveFilesDialog.this.finish();
      }
    }, 2000L);
  }
  
  private void onMoveCompleted()
  {
    if (!this._destinationFolder.exists())
    {
      Toast.makeText(this, 2131297278, 0).show();
      CoreHelper.WriteTraceEntry("MoveFilesDialog", "Move Failed! Destinstion Folder does not exist!");
      finish();
    }
    Object localObject = this._destinationFolder.getParentFile().getAbsolutePath();
    File localFile = Configuration.findAndroidReportedExternalStorage();
    if ((localFile != null) && (this._destinationFolder.getAbsolutePath().startsWith(localFile.getAbsolutePath())))
    {
      CoreHelper.WriteTraceEntry("MoveFilesDialog", "Setting CustomSDCardLocation to: " + (String)localObject);
      Configuration.setCustomSDCardLocation((String)localObject);
    }
    Configuration.setRepoMovedPath((String)localObject);
    CoreHelper.WriteTraceEntry("MoveFilesDialog", "Switching LastSDCardRootPath root folder to: " + (String)localObject);
    Configuration.setLastSDCardRootPath((String)localObject);
    Configuration.setPreferLastSDCardRoot(true);
    if (this._sourceFolder.exists())
    {
      localObject = new AlertDialog.Builder(this._context).setTitle(getString(2131297272));
      if (!CoreHelper.isFolderReallyWritable(this._sourceFolder)) {}
      for (int i = 2131297275;; i = 2131297276)
      {
        ((AlertDialog.Builder)localObject).setMessage(getString(i, new Object[] { this._sourceFolder.getAbsoluteFile() })).setCancelable(false).setPositiveButton(getString(2131296759), null).setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            MoveFilesDialog.this.notifyAndRestart();
          }
        }).show();
        return;
      }
    }
    notifyAndRestart();
  }
  
  private void sendMessage(String paramString, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("message", paramString);
    localBundle.putInt("progress", paramInt1);
    paramString = this.handler.obtainMessage();
    paramString.what = paramInt2;
    paramString.setData(localBundle);
    this.handler.sendMessage(paramString);
  }
  
  private void warnDestFolderExists()
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        new AlertDialog.Builder(MoveFilesDialog.this._context).setTitle(MoveFilesDialog.this.getString(2131297266)).setMessage(MoveFilesDialog.this.getString(2131297280, new Object[] { MoveFilesDialog.this._destinationFolder.getAbsoluteFile() })).setCancelable(false).setPositiveButton(MoveFilesDialog.this.getString(2131296753), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            MoveFilesDialog.this.checkProceedMove();
          }
        }).setNegativeButton(MoveFilesDialog.this.getString(2131296754), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            MoveFilesDialog.this.sendMessage(null, 0, -5);
          }
        }).show();
      }
    });
  }
  
  private void warnInsufficientSpace()
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        new AlertDialog.Builder(MoveFilesDialog.this._context).setMessage(MoveFilesDialog.this.getString(2131297277, new Object[] { CoreHelper.GetFileLengthAsString(Long.valueOf(MoveFilesDialog.this._totalFileSize)), CoreHelper.GetFileLengthAsString(Long.valueOf(MoveFilesDialog.this._availableSize)) })).setCancelable(false).setPositiveButton(MoveFilesDialog.this.getString(2131296315), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            MoveFilesDialog.this.sendMessage(null, 0, -5);
          }
        }).show();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this._context = this;
    setContentView(2130903135);
    this._sourceFolder = new File(Configuration.BeyondPodPublicStorageRootPath());
    this._destinationFolder = new File(getAlternativePath(), this._sourceFolder.getName());
    CoreHelper.WriteLogEntry("MoveFilesDialog", "About to move BeyondPod folder from: " + this._sourceFolder.getAbsolutePath() + " to " + this._destinationFolder.getAbsolutePath());
    findViewById(2131230928).setVisibility(8);
    this._cancelBtn = ((Button)findViewById(2131230929));
    this._cancelBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MoveFilesDialog.this.cancelMove();
      }
    });
    this._cancelBtn.setEnabled(false);
    this._resultProgressBar = ((ProgressBar)findViewById(2131231098));
    this._resultsTV = ((TextView)findViewById(2131231099));
    this._progressBar = ((ProgressBar)findViewById(2131231100));
    this._progressBar.setMax(100);
    this._progressBar.setProgress(0);
    if ((_isRunning) && (this._moveThread != null)) {
      this._moveThread.start();
    }
    if (!CoreHelper.isFolderReallyWritable(this._sourceFolder))
    {
      sendMessage(null, 0, -10);
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        MoveFilesDialog.this.checkFiles();
      }
    }).start();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    _isRunning = false;
    if (this._ExitOnFinish)
    {
      CoreHelper.WriteTraceEntry("MoveFilesDialog", "BeyondPod is exiting to switch to the new storage root...");
      System.exit(0);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      cancelMove();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (isOutOfBounds(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  class MoveThread
    extends Thread
  {
    volatile boolean _Cancel;
    
    MoveThread() {}
    
    private File buildDestinationFile(File paramFile)
    {
      return new File(MoveFilesDialog.this._destinationFolder, paramFile.getAbsolutePath().substring(MoveFilesDialog.this._sourceFolder.getAbsolutePath().length()));
    }
    
    /* Error */
    public boolean CopyFile(File paramFile1, File paramFile2)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 9
      //   3: aconst_null
      //   4: astore 20
      //   6: aconst_null
      //   7: astore 23
      //   9: aconst_null
      //   10: astore 21
      //   12: aconst_null
      //   13: astore 13
      //   15: aconst_null
      //   16: astore 10
      //   18: aconst_null
      //   19: astore 19
      //   21: aconst_null
      //   22: astore 17
      //   24: aconst_null
      //   25: astore 18
      //   27: aconst_null
      //   28: astore 14
      //   30: aconst_null
      //   31: astore 11
      //   33: aconst_null
      //   34: astore 22
      //   36: aconst_null
      //   37: astore 12
      //   39: aconst_null
      //   40: astore 15
      //   42: aconst_null
      //   43: astore 16
      //   45: aload_1
      //   46: invokevirtual 57	java/io/File:isDirectory	()Z
      //   49: ifeq +58 -> 107
      //   52: aload_2
      //   53: invokevirtual 60	java/io/File:mkdirs	()Z
      //   56: ifne +10 -> 66
      //   59: aload_1
      //   60: invokevirtual 57	java/io/File:isDirectory	()Z
      //   63: ifeq +5 -> 68
      //   66: iconst_1
      //   67: ireturn
      //   68: new 62	java/lang/StringBuilder
      //   71: dup
      //   72: ldc 64
      //   74: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   77: aload_2
      //   78: invokevirtual 31	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   81: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   84: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   87: astore_1
      //   88: ldc 76
      //   90: aload_1
      //   91: invokestatic 82	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntry	(Ljava/lang/String;Ljava/lang/String;)V
      //   94: aload_0
      //   95: getfield 15	mobi/beyondpod/ui/dialogs/MoveFilesDialog$MoveThread:this$0	Lmobi/beyondpod/ui/dialogs/MoveFilesDialog;
      //   98: aload_1
      //   99: iconst_1
      //   100: bipush -8
      //   102: invokestatic 86	mobi/beyondpod/ui/dialogs/MoveFilesDialog:access$9	(Lmobi/beyondpod/ui/dialogs/MoveFilesDialog;Ljava/lang/String;II)V
      //   105: iconst_0
      //   106: ireturn
      //   107: aload_2
      //   108: invokevirtual 90	java/io/File:getParentFile	()Ljava/io/File;
      //   111: invokevirtual 60	java/io/File:mkdirs	()Z
      //   114: pop
      //   115: new 92	java/io/FileInputStream
      //   118: dup
      //   119: aload_1
      //   120: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   123: astore 8
      //   125: new 97	java/io/FileOutputStream
      //   128: dup
      //   129: aload_2
      //   130: invokespecial 98	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   133: astore 11
      //   135: aload 23
      //   137: astore 10
      //   139: aload 17
      //   141: astore 9
      //   143: aload 21
      //   145: astore 13
      //   147: aload 18
      //   149: astore 14
      //   151: aload 8
      //   153: invokevirtual 102	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
      //   156: astore 12
      //   158: aload 12
      //   160: astore 10
      //   162: aload 17
      //   164: astore 9
      //   166: aload 12
      //   168: astore 13
      //   170: aload 18
      //   172: astore 14
      //   174: aload 11
      //   176: invokevirtual 103	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
      //   179: astore 15
      //   181: aload 12
      //   183: astore 10
      //   185: aload 15
      //   187: astore 9
      //   189: aload 12
      //   191: astore 13
      //   193: aload 15
      //   195: astore 14
      //   197: aload 12
      //   199: lconst_0
      //   200: aload 12
      //   202: invokevirtual 109	java/nio/channels/FileChannel:size	()J
      //   205: aload 15
      //   207: invokevirtual 113	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
      //   210: lstore_3
      //   211: aload 12
      //   213: astore 10
      //   215: aload 15
      //   217: astore 9
      //   219: aload 12
      //   221: astore 13
      //   223: aload 15
      //   225: astore 14
      //   227: aload_1
      //   228: invokevirtual 115	java/io/File:length	()J
      //   231: lstore 5
      //   233: lload_3
      //   234: lload 5
      //   236: lcmp
      //   237: ifne +49 -> 286
      //   240: iconst_1
      //   241: istore 7
      //   243: aload 12
      //   245: ifnull +8 -> 253
      //   248: aload 12
      //   250: invokevirtual 118	java/nio/channels/FileChannel:close	()V
      //   253: aload 8
      //   255: ifnull +8 -> 263
      //   258: aload 8
      //   260: invokevirtual 119	java/io/FileInputStream:close	()V
      //   263: aload 15
      //   265: ifnull +8 -> 273
      //   268: aload 15
      //   270: invokevirtual 118	java/nio/channels/FileChannel:close	()V
      //   273: aload 11
      //   275: ifnull +8 -> 283
      //   278: aload 11
      //   280: invokevirtual 120	java/io/FileOutputStream:close	()V
      //   283: iload 7
      //   285: ireturn
      //   286: iconst_0
      //   287: istore 7
      //   289: goto -46 -> 243
      //   292: astore 15
      //   294: aload 22
      //   296: astore 8
      //   298: aload 13
      //   300: astore 9
      //   302: aload 14
      //   304: astore 10
      //   306: aload 8
      //   308: astore 11
      //   310: aload 16
      //   312: astore 12
      //   314: new 62	java/lang/StringBuilder
      //   317: dup
      //   318: ldc 122
      //   320: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   323: aload_1
      //   324: invokevirtual 115	java/io/File:length	()J
      //   327: invokestatic 128	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   330: invokestatic 132	mobi/beyondpod/rsscore/helpers/CoreHelper:GetFileLengthAsString	(Ljava/lang/Long;)Ljava/lang/String;
      //   333: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   336: ldc -122
      //   338: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   341: aload_1
      //   342: invokevirtual 31	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   345: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   348: ldc -120
      //   350: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   353: aload_2
      //   354: invokevirtual 31	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   357: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   360: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   363: astore_1
      //   364: aload 13
      //   366: astore 9
      //   368: aload 14
      //   370: astore 10
      //   372: aload 8
      //   374: astore 11
      //   376: aload 16
      //   378: astore 12
      //   380: ldc 76
      //   382: aload_1
      //   383: aload 15
      //   385: invokestatic 140	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   388: aload 13
      //   390: astore 9
      //   392: aload 14
      //   394: astore 10
      //   396: aload 8
      //   398: astore 11
      //   400: aload 16
      //   402: astore 12
      //   404: aload_0
      //   405: getfield 15	mobi/beyondpod/ui/dialogs/MoveFilesDialog$MoveThread:this$0	Lmobi/beyondpod/ui/dialogs/MoveFilesDialog;
      //   408: new 62	java/lang/StringBuilder
      //   411: dup
      //   412: aload_1
      //   413: invokestatic 143	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   416: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   419: ldc -111
      //   421: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   424: aload 15
      //   426: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   429: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   432: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   435: iconst_1
      //   436: bipush -8
      //   438: invokestatic 86	mobi/beyondpod/ui/dialogs/MoveFilesDialog:access$9	(Lmobi/beyondpod/ui/dialogs/MoveFilesDialog;Ljava/lang/String;II)V
      //   441: aload 13
      //   443: ifnull +8 -> 451
      //   446: aload 13
      //   448: invokevirtual 118	java/nio/channels/FileChannel:close	()V
      //   451: aload 8
      //   453: ifnull +8 -> 461
      //   456: aload 8
      //   458: invokevirtual 119	java/io/FileInputStream:close	()V
      //   461: aload 14
      //   463: ifnull +8 -> 471
      //   466: aload 14
      //   468: invokevirtual 118	java/nio/channels/FileChannel:close	()V
      //   471: aload 16
      //   473: ifnull +8 -> 481
      //   476: aload 16
      //   478: invokevirtual 120	java/io/FileOutputStream:close	()V
      //   481: iconst_0
      //   482: ireturn
      //   483: astore_1
      //   484: aload 10
      //   486: astore_2
      //   487: aload 9
      //   489: astore 10
      //   491: aload 10
      //   493: ifnull +8 -> 501
      //   496: aload 10
      //   498: invokevirtual 118	java/nio/channels/FileChannel:close	()V
      //   501: aload 11
      //   503: ifnull +8 -> 511
      //   506: aload 11
      //   508: invokevirtual 119	java/io/FileInputStream:close	()V
      //   511: aload_2
      //   512: ifnull +7 -> 519
      //   515: aload_2
      //   516: invokevirtual 118	java/nio/channels/FileChannel:close	()V
      //   519: aload 12
      //   521: ifnull +8 -> 529
      //   524: aload 12
      //   526: invokevirtual 120	java/io/FileOutputStream:close	()V
      //   529: aload_1
      //   530: athrow
      //   531: astore_2
      //   532: goto -3 -> 529
      //   535: astore 8
      //   537: goto -26 -> 511
      //   540: astore_1
      //   541: aload 20
      //   543: astore 10
      //   545: aload 19
      //   547: astore_2
      //   548: aload 8
      //   550: astore 11
      //   552: aload 15
      //   554: astore 12
      //   556: goto -65 -> 491
      //   559: astore_1
      //   560: aload 11
      //   562: astore 12
      //   564: aload 9
      //   566: astore_2
      //   567: aload 8
      //   569: astore 11
      //   571: goto -80 -> 491
      //   574: astore_1
      //   575: goto -94 -> 481
      //   578: astore_1
      //   579: goto -118 -> 461
      //   582: astore 15
      //   584: goto -286 -> 298
      //   587: astore 15
      //   589: aload 11
      //   591: astore 16
      //   593: goto -295 -> 298
      //   596: astore_1
      //   597: goto -314 -> 283
      //   600: astore_1
      //   601: goto -338 -> 263
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	604	0	this	MoveThread
      //   0	604	1	paramFile1	File
      //   0	604	2	paramFile2	File
      //   210	24	3	l1	long
      //   231	4	5	l2	long
      //   241	47	7	bool	boolean
      //   123	334	8	localObject1	Object
      //   535	33	8	localIOException	java.io.IOException
      //   1	564	9	localObject2	Object
      //   16	528	10	localObject3	Object
      //   31	559	11	localObject4	Object
      //   37	526	12	localObject5	Object
      //   13	434	13	localObject6	Object
      //   28	439	14	localObject7	Object
      //   40	229	15	localFileChannel	java.nio.channels.FileChannel
      //   292	261	15	localException1	Exception
      //   582	1	15	localException2	Exception
      //   587	1	15	localException3	Exception
      //   43	549	16	localObject8	Object
      //   22	141	17	localObject9	Object
      //   25	146	18	localObject10	Object
      //   19	527	19	localObject11	Object
      //   4	538	20	localObject12	Object
      //   10	134	21	localObject13	Object
      //   34	261	22	localObject14	Object
      //   7	129	23	localObject15	Object
      // Exception table:
      //   from	to	target	type
      //   115	125	292	java/lang/Exception
      //   115	125	483	finally
      //   314	364	483	finally
      //   380	388	483	finally
      //   404	441	483	finally
      //   515	519	531	java/io/IOException
      //   524	529	531	java/io/IOException
      //   496	501	535	java/io/IOException
      //   506	511	535	java/io/IOException
      //   125	135	540	finally
      //   151	158	559	finally
      //   174	181	559	finally
      //   197	211	559	finally
      //   227	233	559	finally
      //   466	471	574	java/io/IOException
      //   476	481	574	java/io/IOException
      //   446	451	578	java/io/IOException
      //   456	461	578	java/io/IOException
      //   125	135	582	java/lang/Exception
      //   151	158	587	java/lang/Exception
      //   174	181	587	java/lang/Exception
      //   197	211	587	java/lang/Exception
      //   227	233	587	java/lang/Exception
      //   268	273	596	java/io/IOException
      //   278	283	596	java/io/IOException
      //   248	253	600	java/io/IOException
      //   258	263	600	java/io/IOException
    }
    
    void MoveFiles()
    {
      long l2 = 0L;
      long l1 = 0L;
      try
      {
        CoreHelper.WriteTraceEntry("MoveFilesDialog", "Copying " + MoveFilesDialog.this._internalFileList.size() + " files..." + " (" + CoreHelper.GetFileLengthAsString(Long.valueOf(MoveFilesDialog.this._totalFileSize)) + ")");
        Iterator localIterator = MoveFilesDialog.this._internalFileList.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {}
          File localFile1;
          long l4;
          do
          {
            if (!this._Cancel) {
              break;
            }
            CoreHelper.WriteTraceEntry("MoveFilesDialog", "Copy canceled!");
            MoveFilesDialog.this.deleteFolderInternal(1);
            return;
            localFile1 = (File)localIterator.next();
            File localFile2 = buildDestinationFile(localFile1);
            l4 = l1 + localFile1.length();
            if (!CopyFile(localFile1, localFile2)) {
              this._Cancel = true;
            }
          } while (this._Cancel);
          long l3 = l2 + localFile1.length();
          l2 = l3;
          l1 = l4;
          if (l4 > 1024000L)
          {
            l1 = 0L;
            MoveFilesDialog.this.sendMessage(MoveFilesDialog.this.getString(2131297271, new Object[] { CoreHelper.GetFileLengthAsString(Long.valueOf(l3)), CoreHelper.GetFileLengthAsString(Long.valueOf(MoveFilesDialog.this._totalFileSize)) }), (int)Math.ceil((float)l3 / (float)MoveFilesDialog.this._totalFileSize * 100.0F), 1);
            l2 = l3;
          }
        }
        CoreHelper.WriteTraceEntry("MoveFilesDialog", "Copy completed!");
      }
      catch (Exception localException)
      {
        MoveFilesDialog.this.sendMessage(localException.getMessage(), 0, -2);
        return;
      }
      MoveFilesDialog.this.deleteFolderInternal(0);
    }
    
    public void cancel()
    {
      this._Cancel = true;
    }
    
    public void run()
    {
      this._Cancel = false;
      MoveFilesDialog._isRunning = true;
      MoveFiles();
      MoveFilesDialog._isRunning = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/MoveFilesDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
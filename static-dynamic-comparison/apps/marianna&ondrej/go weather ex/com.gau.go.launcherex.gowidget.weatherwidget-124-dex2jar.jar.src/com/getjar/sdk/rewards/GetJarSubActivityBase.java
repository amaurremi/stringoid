package com.getjar.sdk.rewards;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import com.getjar.sdk.utilities.Utility;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class GetJarSubActivityBase
  implements GetJarSubActivity
{
  private static final Object dialogLock = new Object();
  private Dialog _accountPickerDialog = null;
  protected boolean _allowWaitDialog = true;
  protected volatile Object _dialogsToManageLock = new Object();
  protected boolean _isForeground = false;
  private AlertDialog _unableToDownloadDialog = null;
  private boolean _unableToDownloadDialogWasShowing = false;
  protected boolean _waitDialogWasShowing = false;
  private final LinkedBlockingQueue<DialogQueueMetadata> dialogQueue;
  protected GetJarActivity getJarActivity;
  private ProgressDialog pleaseWaitDialog = null;
  
  public GetJarSubActivityBase(GetJarActivity paramGetJarActivity)
  {
    this.getJarActivity = paramGetJarActivity;
    this.dialogQueue = new LinkedBlockingQueue();
  }
  
  private void createPleaseWaitProgressDialog()
  {
    if (getPleaseWaitDialog() != null)
    {
      Logger.d(Area.UI.value(), "Please wait dialog not null. Creation cancelled", new Object[0]);
      return;
    }
    Logger.d(Area.UI.value(), "Creating please wait dialog", new Object[0]);
    ProgressDialog localProgressDialog = new ProgressDialog(this.getJarActivity);
    localProgressDialog.setProgressStyle(0);
    localProgressDialog.setMessage("Please wait...");
    localProgressDialog.setIndeterminate(true);
    localProgressDialog.setCancelable(false);
    localProgressDialog.setButton(-2, "Cancel", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Logger.d(Area.UI.value(), "User clicked CANCEL", new Object[0]);
        GetJarSubActivityBase.this.close();
      }
    });
    setPleaseWaitDialog(localProgressDialog);
  }
  
  private void createUnableToDownloadDialog()
  {
    if (this._unableToDownloadDialog != null) {
      return;
    }
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.getJarActivity);
    localBuilder.setMessage("Unable to download at this time. Please try again later.").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    });
    this._unableToDownloadDialog = localBuilder.create();
    Logger.d(Area.UI.value(), "createUnableToDownloadDialog() finished", new Object[0]);
  }
  
  private void dialogHide()
  {
    try
    {
      Logger.d(Area.UI.value(), "dialogHide start", new Object[0]);
      if (!Utility.isCurrentThreadTheUIThread())
      {
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            try
            {
              GetJarSubActivityBase.this.processWaitDialogQueue();
              return;
            }
            catch (Exception localException)
            {
              Logger.e(Area.UI.value(), localException, "dialogHide() failed", new Object[0]);
            }
          }
        });
        return;
      }
      processWaitDialogQueue();
      return;
    }
    catch (Exception localException)
    {
      Logger.e(Area.UI.value(), localException, "dialogHide() failed", new Object[0]);
    }
  }
  
  private void dialogHideInternal(GetJarWebViewSubActivity.DialogType paramDialogType)
  {
    try
    {
      if (getPleaseWaitDialog() != null)
      {
        Logger.d(Area.UI.value(), "dialogType is WAIT and isShowing:" + getPleaseWaitDialog().isShowing(), new Object[0]);
        if (paramDialogType != null) {
          break label77;
        }
        throw new IllegalArgumentException("'dialogType' can not be NULL");
      }
    }
    catch (Exception paramDialogType)
    {
      Logger.e(Area.UI.value(), paramDialogType, "dialogHideInternal() failed", new Object[0]);
    }
    label77:
    do
    {
      do
      {
        return;
        if (!GetJarWebViewSubActivity.DialogType.WAIT.equals(paramDialogType)) {
          break;
        }
      } while ((getPleaseWaitDialog() == null) || (!getPleaseWaitDialog().isShowing()));
      getPleaseWaitDialog().dismiss();
      return;
      if (!GetJarWebViewSubActivity.DialogType.UNABLE_TO_DOWNLOAD.equals(paramDialogType)) {
        break;
      }
    } while ((this._unableToDownloadDialog == null) || (!this._unableToDownloadDialog.isShowing()));
    this._unableToDownloadDialog.dismiss();
    return;
    throw new IllegalStateException(String.format(Locale.US, "Unrecognized dilaog type requested: %1$s", new Object[] { paramDialogType.name() }));
  }
  
  private void dialogShow()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          if (!GetJarSubActivityBase.this.iHaveWindowFocus()) {
            Thread.sleep(200L);
          }
          if (GetJarSubActivityBase.this.iHaveWindowFocus())
          {
            new Handler(Looper.getMainLooper()).post(new Runnable()
            {
              public void run()
              {
                try
                {
                  GetJarSubActivityBase.this.processWaitDialogQueue();
                  return;
                }
                catch (Exception localException)
                {
                  Logger.e(Area.UI.value(), localException, "dialogShow() failed", new Object[0]);
                }
              }
            });
            return;
          }
          Logger.d(Area.UI.value(), "Skipping dialog show because Activity is not in the foreground", new Object[0]);
          return;
        }
        catch (Exception localException)
        {
          Logger.e(Area.UI.value(), localException, "dialogShow() failed", new Object[0]);
        }
      }
    }, "dialogShow() thread").start();
  }
  
  private void dialogShowInternal(GetJarWebViewSubActivity.DialogType paramDialogType)
  {
    if (paramDialogType == null) {
      try
      {
        throw new IllegalArgumentException("'dialogType' can not be NULL");
      }
      catch (Exception paramDialogType)
      {
        Logger.e(Area.UI.value(), paramDialogType, "dialogShowInternal() failed", new Object[0]);
      }
    }
    do
    {
      do
      {
        return;
        if (!GetJarWebViewSubActivity.DialogType.WAIT.equals(paramDialogType)) {
          break;
        }
        createPleaseWaitProgressDialog();
      } while ((getPleaseWaitDialog() == null) || (getPleaseWaitDialog().isShowing()) || ((this._accountPickerDialog != null) && (this._accountPickerDialog.isShowing())));
      getPleaseWaitDialog().show();
      return;
      if (!GetJarWebViewSubActivity.DialogType.UNABLE_TO_DOWNLOAD.equals(paramDialogType)) {
        break;
      }
      createUnableToDownloadDialog();
    } while ((this._unableToDownloadDialog == null) || (this._unableToDownloadDialog.isShowing()));
    this._unableToDownloadDialog.show();
    return;
    throw new IllegalStateException(String.format(Locale.US, "Unrecognized dilaog type requested: %1$s", new Object[] { paramDialogType.name() }));
  }
  
  private ProgressDialog getPleaseWaitDialog()
  {
    boolean bool = true;
    long l1 = Area.UI.value();
    long l2 = Thread.currentThread().getId();
    String str = Thread.currentThread().getStackTrace()[3].getMethodName();
    if (this.pleaseWaitDialog == null) {}
    for (;;)
    {
      Logger.d(l1, "get please wait dialog() isNull: %3$s [thread:%1$d] [called-from:%2$s()]", new Object[] { Long.valueOf(l2), str, String.valueOf(bool) });
      return this.pleaseWaitDialog;
      bool = false;
    }
  }
  
  private boolean iHaveWindowFocus()
  {
    try
    {
      boolean bool = this.getJarActivity.hasWindowFocus();
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      Logger.d(Area.UI.value(), "iHaveWindowFocus() failed", new Object[0]);
      try
      {
        Thread.sleep(200L);
        return true;
      }
      catch (Exception localException) {}
    }
    return true;
  }
  
  private void processWaitDialogQueue()
  {
    Logger.d(Area.UI.value(), "process wait dialog called: [thread:%1$d] [called-from:%2$s()]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getStackTrace()[3].getMethodName() });
    for (;;)
    {
      synchronized (dialogLock)
      {
        if (this.dialogQueue.isEmpty()) {
          break;
        }
        DialogQueueMetadata localDialogQueueMetadata = (DialogQueueMetadata)this.dialogQueue.remove();
        if (localDialogQueueMetadata.showDialog) {
          dialogShowInternal(localDialogQueueMetadata.dialogType);
        }
      }
      dialogHideInternal(((DialogQueueMetadata)localObject2).dialogType);
    }
  }
  
  private void setPleaseWaitDialog(ProgressDialog paramProgressDialog)
  {
    boolean bool = true;
    long l1 = Area.UI.value();
    long l2 = Thread.currentThread().getId();
    String str = Thread.currentThread().getStackTrace()[3].getMethodName();
    if (paramProgressDialog == null) {}
    for (;;)
    {
      Logger.d(l1, "set please wait dialog() isNull: %3$s [thread:%1$d] [called-from:%2$s()]", new Object[] { Long.valueOf(l2), str, String.valueOf(bool) });
      this.pleaseWaitDialog = paramProgressDialog;
      return;
      bool = false;
    }
  }
  
  public void close() {}
  
  public Activity getParentActivity()
  {
    return this.getJarActivity;
  }
  
  public String getTheTitle()
  {
    Object localObject = getParentActivity().getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getStringExtra("theTitle");
      if (!StringUtility.isNullOrEmpty((String)localObject)) {
        return (String)localObject;
      }
    }
    return "Please select an account to use with Getjar.";
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onBackPressed() {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void relinquishUI()
  {
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        try
        {
          Logger.v(Area.UI.value(), "AuthFlow: relinquishUI() BEFORE waitDialogWasShowing:%1$s, unableToDownloadDialogWasShowing:%2$s", new Object[] { Boolean.valueOf(GetJarSubActivityBase.this._waitDialogWasShowing), Boolean.valueOf(GetJarSubActivityBase.this._unableToDownloadDialogWasShowing) });
          if (GetJarSubActivityBase.this._waitDialogWasShowing) {
            GetJarSubActivityBase.this.waitDialogShow();
          }
          for (;;)
          {
            GetJarSubActivityBase.this._waitDialogWasShowing = false;
            GetJarSubActivityBase.access$102(GetJarSubActivityBase.this, false);
            Logger.v(Area.UI.value(), "AuthFlow: relinquishUI() AFTER waitDialogWasShowing:%1$s, unableToDownloadDialogWasShowing:%2$s", new Object[] { Boolean.valueOf(GetJarSubActivityBase.this._waitDialogWasShowing), Boolean.valueOf(GetJarSubActivityBase.this._unableToDownloadDialogWasShowing) });
            return;
            if (GetJarSubActivityBase.this._unableToDownloadDialogWasShowing) {
              GetJarSubActivityBase.this.unableToDownloadDialogShow();
            }
          }
          return;
        }
        catch (Exception localException)
        {
          Logger.e(Area.UI.value(), localException, "AuthFlow: relinquishUI() failed", new Object[0]);
        }
      }
    });
  }
  
  public void takeoverUI(final List<Dialog> paramList)
  {
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        for (;;)
        {
          try
          {
            if ((paramList != null) && (!paramList.isEmpty()))
            {
              GetJarSubActivityBase.access$002(GetJarSubActivityBase.this, (Dialog)paramList.get(0));
              Logger.v(Area.UI.value(), "AuthFlow: takeoverUI() BEFORE waitDialogWasShowing:%1$s, unableToDownloadDialogWasShowing:%2$s", new Object[] { Boolean.valueOf(GetJarSubActivityBase.this._waitDialogWasShowing), Boolean.valueOf(GetJarSubActivityBase.this._unableToDownloadDialogWasShowing) });
              if ((GetJarSubActivityBase.this.getPleaseWaitDialog() != null) && (GetJarSubActivityBase.this.getPleaseWaitDialog().isShowing()))
              {
                GetJarSubActivityBase.this.waitDialogHide();
                GetJarSubActivityBase.this._waitDialogWasShowing = true;
                Logger.v(Area.UI.value(), "AuthFlow: takeoverUI() AFTER waitDialogWasShowing:%1$s, unableToDownloadDialogWasShowing:%2$s", new Object[] { Boolean.valueOf(GetJarSubActivityBase.this._waitDialogWasShowing), Boolean.valueOf(GetJarSubActivityBase.this._unableToDownloadDialogWasShowing) });
              }
            }
            else
            {
              GetJarSubActivityBase.access$002(GetJarSubActivityBase.this, null);
              continue;
            }
            if (GetJarSubActivityBase.this._unableToDownloadDialog == null) {
              continue;
            }
          }
          catch (Exception localException)
          {
            Logger.e(Area.UI.value(), localException, "AuthFlow: takeoverUI() failed", new Object[0]);
            return;
          }
          if (GetJarSubActivityBase.this._unableToDownloadDialog.isShowing())
          {
            GetJarSubActivityBase.this.unableToDownloadDialogHide();
            GetJarSubActivityBase.access$102(GetJarSubActivityBase.this, true);
          }
        }
      }
    });
  }
  
  protected void unableToDownloadDialogHide()
  {
    Logger.d(Area.UI.value(), "Hiding 'unable to download' dialog [thread:%1$d] [called-from:%2$s()]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getStackTrace()[3].getMethodName() });
    synchronized (dialogLock)
    {
      this.dialogQueue.add(new DialogQueueMetadata(false, GetJarWebViewSubActivity.DialogType.UNABLE_TO_DOWNLOAD));
      this._unableToDownloadDialogWasShowing = false;
      dialogHide();
      return;
    }
  }
  
  protected void unableToDownloadDialogShow()
  {
    Logger.d(Area.UI.value(), "Showing 'unable to download' dialog [thread:%1$d] [called-from:%2$s()]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getStackTrace()[3].getMethodName() });
    synchronized (dialogLock)
    {
      this.dialogQueue.add(new DialogQueueMetadata(true, GetJarWebViewSubActivity.DialogType.UNABLE_TO_DOWNLOAD));
      dialogShow();
      return;
    }
  }
  
  protected void waitDialogHide()
  {
    Logger.d(Area.UI.value(), "Hiding 'please wait' dialog [thread:%1$d] [called-from:%2$s()]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getStackTrace()[3].getMethodName() });
    synchronized (dialogLock)
    {
      this.dialogQueue.add(new DialogQueueMetadata(false, GetJarWebViewSubActivity.DialogType.WAIT));
      this._waitDialogWasShowing = false;
      dialogHide();
      return;
    }
  }
  
  protected void waitDialogShow()
  {
    if (!this._allowWaitDialog)
    {
      Logger.d(Area.UI.value(), "'_allowWaitDialog' is false, skipping the 'please wait' dialog [thread:%1$d] [called-from:%2$s()]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getStackTrace()[3].getMethodName() });
      return;
    }
    Logger.d(Area.UI.value(), "Showing 'please wait' dialog [thread:%1$d] [called-from:%2$s()]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getStackTrace()[3].getMethodName() });
    synchronized (dialogLock)
    {
      this.dialogQueue.add(new DialogQueueMetadata(true, GetJarWebViewSubActivity.DialogType.WAIT));
      dialogShow();
      return;
    }
  }
  
  private class DialogQueueMetadata
  {
    GetJarWebViewSubActivity.DialogType dialogType;
    boolean showDialog;
    
    public DialogQueueMetadata(boolean paramBoolean, GetJarWebViewSubActivity.DialogType paramDialogType)
    {
      this.showDialog = paramBoolean;
      this.dialogType = paramDialogType;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/GetJarSubActivityBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
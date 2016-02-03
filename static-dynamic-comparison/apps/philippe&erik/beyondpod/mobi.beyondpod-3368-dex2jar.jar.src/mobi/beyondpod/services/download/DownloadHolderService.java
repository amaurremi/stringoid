package mobi.beyondpod.services.download;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.string;
import mobi.beyondpod.downloadengine.DownloadEngineNotificationManager;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.NotificationHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;

public class DownloadHolderService
  extends Service
{
  private static final long IDLE_DELAY = 1800000L;
  private static final String PREPARING_FOR_DOWNLOAD = CoreHelper.LoadResourceString(R.string.download_holder_preparing_for_download);
  private static String TAG = DownloadHolderService.class.getSimpleName();
  private Handler _DelayedStopHandler = new Handler()
  {
    @SuppressLint({"HandlerLeak"})
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (UpdateAndDownloadManager.IsWorking())
      {
        CoreHelper.WriteLogEntry(DownloadHolderService.TAG, "DownloadService IDLE handler found that the download is still in progress! Starting a new wait cycle...");
        DownloadHolderService.this._DelayedStopHandler.sendMessageDelayed(DownloadHolderService.this._DelayedStopHandler.obtainMessage(), 1800000L);
        return;
      }
      CoreHelper.WriteLogEntry(DownloadHolderService.TAG, "Terminating an IDLE Download Holder service...");
      DownloadHolderService.this.stopSelf();
    }
  };
  Thread _DownloadResumeThread;
  long _LoadDataStartTime;
  private final IBinder mBinder = new Binder()
  {
    protected boolean onTransact(int paramAnonymousInt1, Parcel paramAnonymousParcel1, Parcel paramAnonymousParcel2, int paramAnonymousInt2)
      throws RemoteException
    {
      return super.onTransact(paramAnonymousInt1, paramAnonymousParcel1, paramAnonymousParcel2, paramAnonymousInt2);
    }
  };
  
  private boolean ResumeDownloadIfRepositoryIsLoaded()
  {
    if (FeedRepository.RepositoryLoadState() == 2)
    {
      if (!UpdateAndDownloadManager.ResumeUpdateAndDownloads())
      {
        CoreHelper.WriteTraceEntry(TAG, "No Downloads to resume! Stoping the holder service...");
        stopSelf();
      }
      return true;
    }
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    this._DelayedStopHandler.removeCallbacksAndMessages(null);
    return this.mBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    CoreHelper.WriteTraceEntry(TAG, "========================= Download Service Holder is Created! =======================");
    AnalyticsTracker.StartSession(this);
    this._DelayedStopHandler.removeCallbacksAndMessages(null);
    Message localMessage = this._DelayedStopHandler.obtainMessage();
    this._DelayedStopHandler.sendMessageDelayed(localMessage, 1800000L);
    this._DownloadResumeThread = new Thread(null, new Runnable()
    {
      public void run()
      {
        Process.setThreadPriority(10);
        try
        {
          DownloadHolderService.this._LoadDataStartTime = System.currentTimeMillis();
          if (FeedRepository.RepositoryLoadState() == -1)
          {
            DownloadEngineNotificationManager.ClearNotification();
            CoreHelper.WriteTraceEntry(DownloadHolderService.TAG, "******* DownloadHolderService OnCreate found that repository is not loaded! (repo state is: " + FeedRepository.RepositoryLoadState() + ") Loading repository...");
            if (!FeedRepository.InitializeAndLoadRepository())
            {
              CoreHelper.WriteLogEntry(DownloadHolderService.TAG, "Download Service - the repository failed to load! Giving Up!");
              DownloadHolderService.this.stopSelf();
              return;
            }
            while (!DownloadHolderService.this.ResumeDownloadIfRepositoryIsLoaded())
            {
              CoreHelper.WriteTraceEntry(DownloadHolderService.TAG, "Download Service Holder is waiting for Repository to load...");
              Thread.sleep(1000L);
              if (System.currentTimeMillis() - DownloadHolderService.this._LoadDataStartTime >= 20000L)
              {
                CoreHelper.WriteLogEntry(DownloadHolderService.TAG, "Repository is taking too long to load! Giving Up!");
                DownloadHolderService.this.stopSelf();
                return;
              }
            }
          }
        }
        catch (Exception localException)
        {
          CoreHelper.LogException(DownloadHolderService.TAG, "Failed to resume download!", localException);
        }
      }
    }, "DownloadHolderService execution thread");
    this._DownloadResumeThread.start();
  }
  
  public void onDestroy()
  {
    this._DelayedStopHandler.removeCallbacksAndMessages(null);
    NotificationHelper.getInstance().StopForeground(this, 128);
    CoreHelper.WriteTraceEntry(TAG, "============================ Download Service Holder is Destoryed! =======================");
    AnalyticsTracker.EndSession(this);
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    if ((paramIntent == null) || (!NotificationHelper.IsNotificationIntent(paramIntent)))
    {
      CoreHelper.WriteTraceEntry(TAG, "========= Download Service Holder Started!");
      paramIntent = BeyondPodApplication.GetInstance().GetDefaultNotificationForService(this, PREPARING_FOR_DOWNLOAD);
      NotificationHelper.getInstance().StartForegroundAndShowNotification(this, 128, paramIntent);
      return;
    }
    BeyondPodApplication.GetInstance().SetNotification(this, paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/download/DownloadHolderService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
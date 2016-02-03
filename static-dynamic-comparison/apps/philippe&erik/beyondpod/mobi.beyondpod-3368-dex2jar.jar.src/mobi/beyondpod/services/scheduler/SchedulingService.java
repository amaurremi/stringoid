package mobi.beyondpod.services.scheduler;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.text.format.DateUtils;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.GenericQueue;
import mobi.beyondpod.rsscore.helpers.NotificationHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import mobi.beyondpod.schedulercore.OperationBase.OperationCompletedCallback;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;

public class SchedulingService
  extends Service
{
  private static final long IDLE_DELAY = 1800000L;
  private static String TAG = SchedulingService.class.getSimpleName();
  private Handler _DelayedStopHandler = new Handler()
  {
    @SuppressLint({"HandlerLeak"})
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (UpdateAndDownloadManager.IsWorking())
      {
        CoreHelper.WriteLogEntry(SchedulingService.TAG, "SchedulingService IDLE handler found that the download is still in progress! Starting a new wait cycle...");
        SchedulingService.this._DelayedStopHandler.sendMessageDelayed(SchedulingService.this._DelayedStopHandler.obtainMessage(), 1800000L);
        return;
      }
      CoreHelper.WriteLogEntry(SchedulingService.TAG, "Terminating an IDLE scheduling service...");
      SchedulingService.this.stopSelf();
    }
  };
  long _LoadDataStartTime;
  OperationBase.OperationCompletedCallback _OnTaskCompleted = new OperationBase.OperationCompletedCallback()
  {
    public void OnOperationComplete()
    {
      if (SchedulingService.this._TaskQueue.hasItems())
      {
        CoreHelper.WriteTraceEntry(SchedulingService.TAG, "Scheduled task " + (String)SchedulingService.this._TaskQueue.peek() + " completed!");
        SchedulingService.this._TaskQueue.dequeue();
        if (SchedulingService.this._TaskQueue.hasItems())
        {
          String str = (String)SchedulingService.this._TaskQueue.peek();
          CoreHelper.WriteLogEntryInProduction(SchedulingService.TAG, "Found a waiting task (" + str + ") in the scheduling queue!");
          if (FeedRepository.RepositoryLoadState() == 2)
          {
            SchedulingService.this.StartScheduledTaskIfRepositoryIsLoaded();
            return;
          }
          CoreHelper.WriteLogEntryInProduction(SchedulingService.TAG, "Unable to execute the task from the scheduling queue, because the Repository is uninitilizad. Exiting...");
        }
      }
      CoreHelper.WriteTraceEntry(SchedulingService.TAG, "Terminating the scheduling service service...");
      BeyondPodApplication.ReleaseWakeLocks();
      SchedulingService.this.stopSelf();
    }
  };
  Thread _TaskExecutorThread;
  private final GenericQueue<String> _TaskQueue = new GenericQueue();
  private final IBinder mBinder = new Binder()
  {
    protected boolean onTransact(int paramAnonymousInt1, Parcel paramAnonymousParcel1, Parcel paramAnonymousParcel2, int paramAnonymousInt2)
      throws RemoteException
    {
      return super.onTransact(paramAnonymousInt1, paramAnonymousParcel1, paramAnonymousParcel2, paramAnonymousInt2);
    }
  };
  
  private boolean EnqueueTask(String paramString)
  {
    if (this._TaskQueue.contains(paramString)) {
      return false;
    }
    this._TaskQueue.enqueue(paramString);
    return true;
  }
  
  private boolean StartScheduledTaskIfRepositoryIsLoaded()
  {
    if (FeedRepository.RepositoryLoadState() == 2)
    {
      if (!this._TaskQueue.hasItems())
      {
        CoreHelper.WriteLogEntry(TAG, "Attempting to execute scheduled task when the scheduling task Queue is empty!");
        this._OnTaskCompleted.OnOperationComplete();
      }
      String str;
      do
      {
        int i;
        do
        {
          return true;
          str = (String)this._TaskQueue.peek();
          if (LicenseManager.IfInRestrictedMode())
          {
            CoreHelper.WriteTraceEntry(TAG, "Application is running in restricted mode! (Expired on: " + DateTime.FormatDate(LicenseManager.TrialExpirationDate()) + ") Scheduled Updates are disabled!");
            this._OnTaskCompleted.OnOperationComplete();
            return true;
          }
          if ((!"android.intent.action.BOOT_COMPLETED".equals(str)) && (!"android.intent.action.TIMEZONE_CHANGED".equals(str)) && (!"android.intent.action.TIME_SET".equals(str))) {
            break;
          }
          AnalyticsTracker.OnSystemScheduledTaskStarted(str);
          i = ScheduledTasksManager.RescheduleAllActiveTasks();
          ScheduledTasksManager.ScheduleGoogleSynUpdateIfNeeded();
          ScheduledTasksManager.ScheduleSyncTaskIfSyncIsEnabled(20, TimeSpan.fromMinutes(1.0D), true);
          this._OnTaskCompleted.OnOperationComplete();
        } while (!"android.intent.action.BOOT_COMPLETED".equals(str));
        CoreHelper.WriteTraceEntry(TAG, "Restored " + i + " scheduled tasks on BOOT! Exiting...");
        System.exit(0);
        return true;
      } while (ScheduledTasksManager.ExecuteTaskFor(str, this._OnTaskCompleted));
      this._OnTaskCompleted.OnOperationComplete();
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
    CoreHelper.WriteTraceEntry(TAG, "--------------------------- Scheduling Service is Created!---------------------------");
    AnalyticsTracker.StartSession(this);
    this._DelayedStopHandler.removeCallbacksAndMessages(null);
    Message localMessage = this._DelayedStopHandler.obtainMessage();
    this._DelayedStopHandler.sendMessageDelayed(localMessage, 1800000L);
  }
  
  public void onDestroy()
  {
    this._TaskQueue.clear();
    this._DelayedStopHandler.removeCallbacksAndMessages(null);
    NotificationHelper.getInstance().StopForeground(this, 128);
    CoreHelper.WriteTraceEntry(TAG, "--------------------------- Scheduling service is Destroyed! ---------------------------");
    AnalyticsTracker.EndSession(this);
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    if (paramIntent == null)
    {
      CoreHelper.WriteLogEntry(TAG, "Scheduling service was started without an intent! Exiting...");
      stopSelf();
      return;
    }
    String str1 = paramIntent.getAction();
    String str2 = TAG;
    paramInt = BeyondPodApplication.BatteryLevel;
    if (CoreHelper.IsDevicePlugged()) {}
    for (paramIntent = "Yes";; paramIntent = "No")
    {
      CoreHelper.WriteLogEntryInProduction(str2, String.format("SchedulingService was started for task: %s. Battery Level: %d%%, Charging: %s", new Object[] { str1, Integer.valueOf(paramInt), paramIntent }));
      if (!this._TaskQueue.hasItems()) {
        break label249;
      }
      long l = System.currentTimeMillis() - this._LoadDataStartTime;
      CoreHelper.WriteLogEntryInProduction(TAG, String.format("Found that another scheduled task (%s) is already running! The task has been running for: %s", new Object[] { this._TaskQueue.peek(), DateUtils.formatElapsedTime(l / 1000L) }));
      if (l >= 600000L) {
        break label188;
      }
      CoreHelper.WriteLogEntryInProduction(TAG, "Last task has been running for less than 10 minutes.");
      if (!EnqueueTask(str1)) {
        break;
      }
      CoreHelper.WriteLogEntryInProduction(TAG, "Queing the new task...");
      return;
    }
    CoreHelper.WriteLogEntryInProduction(TAG, "Task with the same ID already exists - Exiting...");
    return;
    label188:
    if (UpdateAndDownloadManager.IsWorking())
    {
      CoreHelper.WriteLogEntryInProduction(TAG, "Last task's Update & Download Manager is still working.");
      if (EnqueueTask(str1))
      {
        CoreHelper.WriteLogEntryInProduction(TAG, "Queing the new task...");
        return;
      }
      CoreHelper.WriteLogEntryInProduction(TAG, "Task with the same ID already exists - Exiting...");
      return;
    }
    CoreHelper.WriteLogEntry(TAG, "The last task appears to be stuck! Starting the execution of the new task");
    this._TaskQueue.dequeue();
    label249:
    if (StringUtils.IsNullOrEmpty(str1))
    {
      CoreHelper.WriteLogEntry(TAG, "SchedulingService was started with invalid task ID");
      stopSelf();
      return;
    }
    EnqueueTask(str1);
    this._TaskExecutorThread = new Thread(null, new Runnable()
    {
      public void run()
      {
        Process.setThreadPriority(10);
        for (;;)
        {
          long l1;
          try
          {
            SchedulingService.this._LoadDataStartTime = System.currentTimeMillis();
            if (FeedRepository.RepositoryLoadState() != -1) {
              break label208;
            }
            Notification localNotification = BeyondPodApplication.GetInstance().GetDefaultNotificationForService(SchedulingService.this, "Loading feeds...");
            NotificationHelper.getInstance().StartForegroundAndShowNotification(SchedulingService.this, 128, localNotification);
            l1 = System.currentTimeMillis();
            if (System.currentTimeMillis() - l1 >= 30000L)
            {
              CoreHelper.WriteTraceEntry(SchedulingService.TAG, "******* SchedulingService OnStart found that repository is not loaded! (repo state is: " + FeedRepository.RepositoryLoadState() + ") Loading repository...");
              if (FeedRepository.InitializeAndLoadRepository()) {
                break label208;
              }
              CoreHelper.WriteLogEntry(SchedulingService.TAG, "Scheduling Service - the repository failed to load! (Possibly no Storage Card) Exiting...!");
              SchedulingService.this.stopSelf();
              System.exit(0);
              return;
            }
            if (FeedRepository.CanRepositoryBeLoaded())
            {
              CoreHelper.WriteTraceEntry(SchedulingService.TAG, "Storage card found...");
              continue;
            }
            CoreHelper.WriteTraceEntry(SchedulingService.TAG, "Waiting for the Storage Card to get mounted...");
          }
          catch (Exception localException)
          {
            CoreHelper.LogException(SchedulingService.TAG, "Failed to start scheduled task!", localException);
            CoreHelper.WriteLogEntry(SchedulingService.TAG, "Repository is taking too long to load! Giving Up!");
            SchedulingService.this.stopSelf();
            return;
          }
          Thread.sleep(1000L);
          continue;
          label208:
          long l2;
          do
          {
            if (SchedulingService.this.StartScheduledTaskIfRepositoryIsLoaded()) {
              break;
            }
            CoreHelper.WriteTraceEntry(SchedulingService.TAG, "Repository is still loading...");
            Thread.sleep(1000L);
            l1 = System.currentTimeMillis();
            l2 = SchedulingService.this._LoadDataStartTime;
          } while (l1 - l2 < 50000L);
        }
      }
    }, "SchedulingService task executing thread");
    this._TaskExecutorThread.start();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/scheduler/SchedulingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
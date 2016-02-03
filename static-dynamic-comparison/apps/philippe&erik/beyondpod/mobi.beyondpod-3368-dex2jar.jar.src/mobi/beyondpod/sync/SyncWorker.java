package mobi.beyondpod.sync;

import android.os.Process;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Date;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.DeviceNetworkConnection;
import mobi.beyondpod.rsscore.helpers.CoreHelper.UnableToEstablishNetworkConnectionException;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.sync.trackers.ITracker;
import mobi.beyondpod.sync.trackers.bp.AuthenticationException;
import mobi.beyondpod.sync.trackers.bp.BPTracker;
import mobi.beyondpod.sync.trackers.bp.InvalidTokenException;
import mobi.beyondpod.sync.trackers.bp.ServiceException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.HttpHostConnectException;

public class SyncWorker
  implements Runnable
{
  public static final int PROGRESS_TYPE_SYNCING_APPLYING_CHANGES = 2;
  public static final int PROGRESS_TYPE_SYNCING_DOWN = 1;
  public static final int PROGRESS_TYPE_SYNCING_UP = 0;
  private static final String TAG = SyncWorker.class.getSimpleName();
  private Thread _CallerThread = null;
  QueueListener _QueueListener;
  int _RetryCount;
  private volatile boolean _SyncingThreadIsDownloading;
  ITracker _Tracker;
  
  public SyncWorker(QueueListener paramQueueListener)
  {
    this._QueueListener = paramQueueListener;
    this._Tracker = new BPTracker();
  }
  
  public static boolean CanRetry(Throwable paramThrowable)
  {
    return (paramThrowable != null) && (((paramThrowable instanceof SocketTimeoutException)) || ((paramThrowable instanceof UnknownHostException)) || ((paramThrowable instanceof SocketException)) || ((paramThrowable instanceof HttpHostConnectException)) || ((paramThrowable instanceof ConnectTimeoutException)) || ((paramThrowable instanceof ConnectionPoolTimeoutException)));
  }
  
  private void DoSync()
    throws Throwable
  {
    String str4;
    StringBuilder localStringBuilder;
    try
    {
      FeedRepository.SaveRepositorySync();
      this._Tracker.Initialize();
      OnQueueProgress(0);
      if (Configuration.LastRemoteChangeTimeStamp() < 0L)
      {
        Date localDate = new Date();
        TrackedChangeBase.LogSyncEvent(TAG, " --- Detected Inital Sync! Setting the last remote change timestamp to: " + localDate, null);
        Configuration.setLastRemoteChangeTimeStamp(localDate.getTime());
      }
      if (IsUnAuthorizedMobileDataConnection()) {
        throw new CoreHelper.UnableToEstablishNetworkConnectionException("");
      }
    }
    catch (CoreHelper.UnableToEstablishNetworkConnectionException localUnableToEstablishNetworkConnectionException)
    {
      TrackedChangeBase.LogSyncEvent(TAG, " --- Sync failed! Mobile connections are not allowed and WiFi is not connected!", null);
      return;
      CoreHelper.KeepDeviceAwake();
      ChangeTracker.AddPendingRemoteChanges(this._Tracker.SyncPushPull(ChangeTracker.PendingUploadChanges(), Configuration.LastRemoteChangeTimeStamp()));
      OnQueueProgress(2);
      ChangeTracker.ApplyPendingRemoteChangesSync();
      Configuration.setLastSyncTimeStamp(new Date().getTime());
      return;
    }
    catch (InvalidTokenException localInvalidTokenException)
    {
      str4 = TAG;
      localStringBuilder = new StringBuilder(" --- Sync failed! Invalid token: ");
      if (localInvalidTokenException.getCause() != null) {}
      for (String str1 = localInvalidTokenException.getCause().getMessage();; str1 = str1.getMessage())
      {
        TrackedChangeBase.LogSyncEvent(str4, str1, null);
        return;
      }
    }
    catch (AuthenticationException localAuthenticationException)
    {
      str4 = TAG;
      localStringBuilder = new StringBuilder(" --- Sync failed! Authentication error: ");
      if (localAuthenticationException.getCause() != null) {}
      for (String str2 = localAuthenticationException.getCause().getMessage();; str2 = str2.getMessage())
      {
        TrackedChangeBase.LogSyncEvent(str4, str2, null);
        return;
      }
    }
    catch (ServiceException localServiceException)
    {
      if (ShouldRetry(localServiceException.getCause()))
      {
        TrackedChangeBase.LogSyncEvent(TAG, " --- Potentially recoverable service error occured! (Error: " + localServiceException.getCause().getMessage() + ")", null);
        throw localServiceException.getCause();
      }
      str4 = TAG;
      localStringBuilder = new StringBuilder(" --- Sync failed! Service error: ").append(localServiceException.getStatusCode()).append(", ");
      if (localServiceException.getCause() == null) {}
    }
    for (String str3 = localServiceException.getCause().getMessage();; str3 = str3.getMessage())
    {
      TrackedChangeBase.LogSyncEvent(str4, str3, null);
      return;
    }
  }
  
  private boolean IsUnAuthorizedMobileDataConnection()
  {
    if (Configuration.IsCellularConnectionAllowed()) {
      return false;
    }
    return CoreHelper.GetDeviceNetworkConnection().IsConnectionCellular();
  }
  
  private void OnQueueCompleted(boolean paramBoolean)
  {
    this._SyncingThreadIsDownloading = false;
    if (this._QueueListener != null) {
      this._QueueListener.OnQueueCompleted(paramBoolean);
    }
    this._Tracker.Close();
  }
  
  private void OnQueueProgress(int paramInt)
  {
    if (this._QueueListener != null) {
      this._QueueListener.OnQueueProgress(paramInt);
    }
  }
  
  private void OnQueueStarted()
  {
    this._SyncingThreadIsDownloading = true;
    this._RetryCount = 1;
    if (this._QueueListener != null) {
      this._QueueListener.OnQueueStarted();
    }
  }
  
  private boolean ShouldRetry(Throwable paramThrowable)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (CanRetry(paramThrowable))
    {
      bool1 = bool2;
      if (this._RetryCount > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void ExecuteQueuedRequests()
    throws Exception
  {
    if (this._CallerThread != null) {
      throw new Exception("You must use a new instance of this class for each new download!");
    }
    if (this._SyncingThreadIsDownloading) {
      throw new Exception("Downlod is already in progress!");
    }
    this._SyncingThreadIsDownloading = true;
    this._CallerThread = new Thread(this);
    this._CallerThread.setName("ChangeSyncer Caller thread");
    this._CallerThread.setPriority(4);
    this._CallerThread.start();
  }
  
  public boolean IsWorking()
  {
    return this._SyncingThreadIsDownloading;
  }
  
  public void Stop()
  {
    if ((this._CallerThread != null) && (!this._CallerThread.isInterrupted())) {
      this._CallerThread.interrupt();
    }
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    OnQueueStarted();
    try
    {
      DoSync();
      OnQueueCompleted(Thread.interrupted());
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this._RetryCount -= 1;
        if (ShouldRetry(localThrowable))
        {
          TrackedChangeBase.LogSyncEvent(TAG, " ----- Sleeping before sync retry...", null);
          BeyondPodApplication.PokeWiFiIfNeeded(localThrowable);
          CoreHelper.KeepDeviceAwake();
          CoreHelper.nap(10);
          if (this._RetryCount <= 0) {}
        }
        else
        {
          TrackedChangeBase.LogSyncEvent(TAG, " --- Sync failed! " + localThrowable.getMessage(), null);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TrackedChangeBase.LogSyncEvent(TAG, " --- Sync retry failed! " + localException.getMessage(), null);
      }
    }
  }
  
  public static abstract interface QueueListener
  {
    public abstract void OnQueueCompleted(boolean paramBoolean);
    
    public abstract void OnQueueProgress(int paramInt);
    
    public abstract void OnQueueStarted();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/sync/SyncWorker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
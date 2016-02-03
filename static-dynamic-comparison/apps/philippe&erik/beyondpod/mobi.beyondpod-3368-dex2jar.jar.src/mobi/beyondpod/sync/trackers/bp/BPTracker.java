package mobi.beyondpod.sync.trackers.bp;

import android.content.Context;
import com.google.android.gcm.GCMRegistrar;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.events.ApplicationEvents.ApplicationErrorEvent;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.UnableToEstablishNetworkConnectionException;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.sync.ChangeTracker;
import mobi.beyondpod.sync.SyncWorker;
import mobi.beyondpod.sync.TrackedChangeBase;
import mobi.beyondpod.sync.TrackedChangeEnclosure;
import mobi.beyondpod.sync.TrackedChangeEpisode;
import mobi.beyondpod.sync.TrackedChangeFeed;
import mobi.beyondpod.sync.TrackedChangePost;
import mobi.beyondpod.sync.trackers.ITracker;

public class BPTracker
  implements ITracker
{
  private static final int BACKOFF_MILLI_SECONDS = 2000;
  private static final int MAX_ATTEMPTS = 5;
  private static final String TAG = BPTracker.class.getSimpleName();
  private static final Random random = new Random();
  
  private List<TrackedChangeBase> LoadRemoteChanges(List<DeviceActivity> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    Iterator localIterator = paramList.iterator();
    label24:
    label124:
    label237:
    for (;;)
    {
      long l;
      int i;
      String str;
      if (localIterator.hasNext())
      {
        paramList = (DeviceActivity)localIterator.next();
        l = paramList.getDateTime().getTime();
        i = StringUtils.SafeParseInt(paramList.getType(), -1);
        str = paramList.getData();
        paramList = null;
        if ((i != 1) && (i != 2) && (i != 3) && (i != 14)) {
          break label124;
        }
        paramList = new TrackedChangeFeed(null, l, i, 3, str);
      }
      for (;;)
      {
        if (paramList == null) {
          break label237;
        }
        paramList.SetIsModified(false);
        localArrayList.add(paramList);
        break label24;
        break;
        if ((i == 4) || (i == 5) || (i == 6)) {
          paramList = new TrackedChangeEnclosure(null, l, i, 3, str);
        } else if ((i == 12) || (i == 13) || (i == 10) || (i == 11)) {
          paramList = new TrackedChangePost(null, l, i, 3, str);
        } else if ((i == 9) || (i == 7) || (i == 8) || (i == 15)) {
          paramList = new TrackedChangeEpisode(null, l, i, 3, str);
        }
      }
    }
  }
  
  public static void Logout()
  {
    Configuration.setCDSUserName("");
    Configuration.setCDSPassword("");
    Configuration.setCDSToken("");
    Configuration.setLastSyncTimeStamp(-1L);
    Configuration.setLastRemoteChangeTimeStamp(-1L);
    Configuration.setCDSDeviceID("");
    ChangeTracker.CleanAllRecords();
  }
  
  private String RefreshToken(BeyondPodServiceClientV1 paramBeyondPodServiceClientV1, boolean paramBoolean)
    throws Exception
  {
    boolean bool = Configuration.CDSDeviceID().equals(ChangeTracker.DeviceID());
    if ((StringUtils.IsNullOrEmpty(Configuration.CDSUserName())) || (StringUtils.IsNullOrEmpty(Configuration.CDSPassword()))) {
      throw new AuthenticationException(-1, "Empty user name or password", null);
    }
    if ((!bool) || (paramBoolean) || (StringUtils.IsNullOrEmpty(Configuration.CDSToken())) || (new Date().after(Configuration.CDSTokenExpiration())))
    {
      TrackedChangeBase.LogSyncEvent(TAG, " --- Requesting fresh token...", null);
      try
      {
        paramBeyondPodServiceClientV1 = paramBeyondPodServiceClientV1.authenticateUser(Configuration.CDSUserName(), Configuration.CDSPassword(), BeyondPodServiceClientV1.AuthType.BeyondPod, ChangeTracker.DeviceID(), true);
        if (paramBeyondPodServiceClientV1.isWaitingForEmailVerification()) {
          throw new Exception("Account is awaiting verification!");
        }
      }
      catch (AuthenticationException paramBeyondPodServiceClientV1)
      {
        if (paramBeyondPodServiceClientV1.getStatusCode() == AuthenticationResult.AUTH_RESULT_AUTHENTICATION_FAILED)
        {
          TrackedChangeBase.LogSyncEvent(TAG, " --- Your password has changed! Please login again!", null);
          Logout();
          throw paramBeyondPodServiceClientV1;
          Configuration.setCDSToken(paramBeyondPodServiceClientV1.getToken());
          Configuration.setCDSTokenExpiration(paramBeyondPodServiceClientV1.getTokenExpires());
        }
      }
    }
    if (!bool) {
      Configuration.setCDSDeviceID(ChangeTracker.DeviceID());
    }
    return Configuration.CDSToken();
  }
  
  public void Close() {}
  
  public List<TrackedChangeBase> GetRemoteChangesSince(long paramLong)
    throws Exception
  {
    throw new Exception("Not Implemented");
  }
  
  public void Initialize()
    throws Exception
  {
    if ((StringUtils.IsNullOrEmpty(Configuration.CDSUserName())) || (StringUtils.IsNullOrEmpty(ChangeTracker.DeviceID()))) {
      throw new Exception("Invalid User or Device Id");
    }
  }
  
  public void SyncChangesUp(List<TrackedChangeBase> paramList)
    throws Exception
  {
    throw new Exception("Not Implemented");
  }
  
  public List<TrackedChangeBase> SyncPushPull(List<TrackedChangeBase> paramList, long paramLong)
    throws Exception
  {
    int i = paramList.size();
    if (i == 0) {
      TrackedChangeBase.LogSyncEvent(TAG, " --- Nothing to upload! Checking for remote changes...", null);
    }
    for (;;)
    {
      Object localObject2 = new ArrayList();
      Object localObject1 = paramList.iterator();
      label49:
      Object localObject3;
      if (!((Iterator)localObject1).hasNext())
      {
        localObject3 = new BeyondPodServiceClientV1();
        localObject1 = RefreshToken((BeyondPodServiceClientV1)localObject3, false);
      }
      try
      {
        long l = System.currentTimeMillis();
        TrackedChangeBase.LogSyncEvent(TAG, " --- [", null);
        localObject1 = ((BeyondPodServiceClientV1)localObject3).storeAndRetrieveActivities((String)localObject1, (List)localObject2, true, new Date(paramLong));
        float f = (float)(System.currentTimeMillis() - l) / 1000.0F;
        TrackedChangeBase.LogSyncEvent(TAG, " --- " + String.format(" %.2f s.", new Object[] { Float.valueOf(f) }) + "]", null);
        paramList = paramList.iterator();
        if (!paramList.hasNext())
        {
          if (((RemoteActivities)localObject1).hasRemoteActivities()) {
            break label553;
          }
          TrackedChangeBase.LogSyncEvent(TAG, " --- No remote changes since: " + new Date(paramLong), null);
          if (!ChangeTracker.IsDeviceTimeCorrect(((RemoteActivities)localObject1).getRemoteDate()))
          {
            BeyondPodApplication.MessageBus.PublishEventAsync(new ApplicationEvents.ApplicationErrorEvent(new Exception("Device time is incorrect!"), 6));
            TrackedChangeBase.LogSyncEvent(TAG, " --- Device time is incorrect by: " + CoreHelper.FormatTimeAsString(Math.abs(new Date().getTime() - ((RemoteActivities)localObject1).getRemoteDate().getTime()) / 1000L) + " (it could miss some remote changes)", null);
          }
          return LoadRemoteChanges(((RemoteActivities)localObject1).getActivities());
          TrackedChangeBase.LogSyncEvent(TAG, " --- Starting the execution of " + i + " upload syncing requests!", null);
          continue;
          localObject3 = (TrackedChangeBase)((Iterator)localObject1).next();
          if (Thread.interrupted())
          {
            TrackedChangeBase.LogSyncEvent(TAG, " --- Request Queue processing was interrupted.", null);
            break label49;
          }
          DeviceActivity localDeviceActivity = new DeviceActivity();
          localDeviceActivity.setType(String.valueOf(((TrackedChangeBase)localObject3).ChangeType()));
          localDeviceActivity.setDateTime(new Date(((TrackedChangeBase)localObject3).TimeStamp()));
          localDeviceActivity.setDevice(ChangeTracker.DeviceID());
          ((TrackedChangeBase)localObject3).PrepareForSave();
          localDeviceActivity.setData(((TrackedChangeBase)localObject3).Blob());
          ((List)localObject2).add(localDeviceActivity);
        }
      }
      catch (InvalidTokenException localInvalidTokenException)
      {
        for (;;)
        {
          RemoteActivities localRemoteActivities = ((BeyondPodServiceClientV1)localObject3).storeAndRetrieveActivities(RefreshToken((BeyondPodServiceClientV1)localObject3, true), (List)localObject2, true, new Date(paramLong));
          continue;
          localObject2 = (TrackedChangeBase)paramList.next();
          ((TrackedChangeBase)localObject2).setSyncStatus(1);
          TrackedChangeBase.LogSyncEvent(TAG, " ------> Synced:" + ((TrackedChangeBase)localObject2).ChangeName() + " => " + ((TrackedChangeBase)localObject2).FriendlyName(), null);
          continue;
          label553:
          TrackedChangeBase.LogSyncEvent(TAG, " --- Found " + localRemoteActivities.getActivities().size() + " remote changes since: " + new Date(paramLong), null);
        }
      }
    }
  }
  
  public boolean UpdateServerCDMRegistration(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject = new BeyondPodServiceClientV1();
    long l = random.nextInt(1000) + 2000;
    int i;
    if (paramBoolean)
    {
      TrackedChangeBase.LogSyncEvent(TAG, "\n--- Registering device with CDS Server...", null);
      i = 1;
    }
    for (;;)
    {
      if (i > 5)
      {
        label48:
        return false;
        TrackedChangeBase.LogSyncEvent(TAG, "\n--- Unregistering device from CDS Server...", null);
        break;
      }
      if (paramBoolean) {}
      try
      {
        String str = RefreshToken((BeyondPodServiceClientV1)localObject, false);
        try
        {
          ((BeyondPodServiceClientV1)localObject).gcmRegister(str, paramString);
          GCMRegistrar.setRegisteredOnServer(paramContext, paramBoolean);
          if (paramBoolean) {
            TrackedChangeBase.LogSyncEvent(TAG, "--- Device Registered!", null);
          }
        }
        catch (InvalidTokenException localInvalidTokenException)
        {
          for (;;)
          {
            ((BeyondPodServiceClientV1)localObject).gcmRegister(RefreshToken((BeyondPodServiceClientV1)localObject, true), paramString);
          }
        }
      }
      catch (CoreHelper.UnableToEstablishNetworkConnectionException localUnableToEstablishNetworkConnectionException)
      {
        for (;;)
        {
          TrackedChangeBase.LogSyncEvent(TAG, "--- Registration failed! Mobile connections are not allowed and WiFi is not connected!", null);
          i += 1;
          break;
          ((BeyondPodServiceClientV1)localObject).gcmUnregister(paramString);
        }
      }
      catch (InvalidTokenException paramContext)
      {
        TrackedChangeBase.LogSyncEvent(TAG, "--- Registration failed! Invalid token!", null);
        break label48;
        TrackedChangeBase.LogSyncEvent(TAG, "--- Device Unregistered!", null);
      }
      catch (AuthenticationException paramContext)
      {
        paramString = TAG;
        localObject = new StringBuilder("--- Registration failed! Authentication error: ");
        if (paramContext.getCause() != null) {}
        for (paramContext = paramContext.getCause().getMessage();; paramContext = paramContext.getMessage())
        {
          TrackedChangeBase.LogSyncEvent(paramString, paramContext, null);
          break;
        }
      }
      catch (ServiceException localServiceException)
      {
        for (;;)
        {
          if (SyncWorker.CanRetry(localServiceException))
          {
            TrackedChangeBase.LogSyncEvent(TAG, "--- Registering device with Sync Server...", null);
            if (i == 5) {
              break;
            }
            try
            {
              CoreHelper.WriteTraceEntry(TAG, "--- Sleeping for " + l + " ms. before retry");
              Thread.sleep(l);
              l *= 2L;
            }
            catch (InterruptedException paramContext)
            {
              CoreHelper.WriteTraceEntry(TAG, "--- Thread interrupted: abort remaining retries!");
              Thread.currentThread().interrupt();
              return false;
            }
          }
        }
        TrackedChangeBase.LogSyncEvent(TAG, "--- Registeration failed! Reason:" + localServiceException.getMessage(), null);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          TrackedChangeBase.LogSyncEvent(TAG, "--- Registeration failed! Reason:" + localException.getMessage(), null);
        }
      }
    }
    return true;
  }
  
  public static class RemoteActivities
  {
    private List<DeviceActivity> _Activities;
    public Date _RemoteDateTime;
    
    public RemoteActivities(List<DeviceActivity> paramList, Date paramDate)
    {
      this._Activities = paramList;
      this._RemoteDateTime = paramDate;
    }
    
    List<DeviceActivity> getActivities()
    {
      return this._Activities;
    }
    
    Date getRemoteDate()
    {
      if (this._RemoteDateTime == null) {
        return new Date();
      }
      return this._RemoteDateTime;
    }
    
    boolean hasRemoteActivities()
    {
      return (this._Activities != null) && (this._Activities.size() > 0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/sync/trackers/bp/BPTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
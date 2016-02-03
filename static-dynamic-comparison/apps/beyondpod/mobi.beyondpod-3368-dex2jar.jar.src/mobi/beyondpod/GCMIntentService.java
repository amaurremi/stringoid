package mobi.beyondpod;

import android.content.Context;
import android.content.Intent;
import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMRegistrar;
import java.util.Date;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;
import mobi.beyondpod.sync.TrackedChangeBase;
import mobi.beyondpod.sync.trackers.bp.BPTracker;

public class GCMIntentService
  extends GCMBaseIntentService
{
  private static final String TAG = GCMIntentService.class.getSimpleName();
  
  public GCMIntentService()
  {
    super(new String[] { Configuration.GCMSenderID() });
  }
  
  protected void onDeletedMessages(Context paramContext, int paramInt)
  {
    TrackedChangeBase.LogSyncEvent(TAG, "\n### " + new Date() + ": " + paramInt + " CDS sync requests were deleted as old!", null);
  }
  
  public void onError(Context paramContext, String paramString)
  {
    TrackedChangeBase.LogSyncEvent(TAG, "\n### " + new Date() + ": Error registering with CDS! Reason: " + paramString, null);
  }
  
  protected void onMessage(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    Object localObject = paramIntent.getStringExtra("device");
    paramContext = paramIntent.getStringExtra("from");
    boolean bool = StringUtils.Equals(Configuration.GCMSenderID(), paramContext);
    if ((!bool) || (StringUtils.IsNullOrEmpty((String)localObject)))
    {
      paramIntent = TAG;
      localObject = new StringBuilder("\n### ").append(new Date()).append(": Received CDS sync request from an invalid device!");
      if (bool) {}
      for (paramContext = "";; paramContext = " Sender: " + paramContext)
      {
        TrackedChangeBase.LogSyncEvent(paramIntent, paramContext, null);
        return;
      }
    }
    paramIntent = TAG;
    StringBuilder localStringBuilder = new StringBuilder("\n### ").append(new Date()).append(": Received CDS sync request from ").append((String)localObject);
    if (bool) {}
    for (paramContext = "";; paramContext = ". Sender: " + paramContext)
    {
      TrackedChangeBase.LogSyncEvent(paramIntent, paramContext, null);
      if (!StringUtils.Equals((String)localObject, Configuration.CDSDeviceID())) {
        break;
      }
      TrackedChangeBase.LogSyncEvent(TAG, "### Sync request is from this device! Ignoring...", null);
      return;
    }
    ScheduledTasksManager.ScheduleSyncTaskIfSyncIsEnabled(5, TimeSpan.fromSeconds(1.0D), true);
  }
  
  protected boolean onRecoverableError(Context paramContext, String paramString)
  {
    TrackedChangeBase.LogSyncEvent(TAG, "\n### " + new Date() + ": Recoverable error registering with CDS! Reason: " + paramString, null);
    return super.onRecoverableError(paramContext, paramString);
  }
  
  protected void onRegistered(Context paramContext, String paramString)
  {
    CoreHelper.WriteTraceEntry(TAG, "### Device registered: regId = " + paramString);
    try
    {
      BPTracker localBPTracker = new BPTracker();
      localBPTracker.Initialize();
      localBPTracker.UpdateServerCDMRegistration(paramContext, paramString, true);
      return;
    }
    catch (Exception paramContext)
    {
      TrackedChangeBase.LogSyncEvent(TAG, "### Failed to add CDS registration! Reason: " + paramContext.getMessage(), null);
    }
  }
  
  protected void onUnregistered(Context paramContext, String paramString)
  {
    CoreHelper.WriteTraceEntry(TAG, "### Device unregistered! Token: " + paramString);
    if (GCMRegistrar.isRegisteredOnServer(paramContext)) {
      try
      {
        new BPTracker().UpdateServerCDMRegistration(paramContext, paramString, false);
        return;
      }
      catch (Exception paramContext)
      {
        TrackedChangeBase.LogSyncEvent(TAG, "### Failed to remove CDS registration! Reason: " + paramContext.getMessage(), null);
        return;
      }
    }
    CoreHelper.WriteTraceEntry(TAG, "### No need to unregister");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/GCMIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package mobi.beyondpod.services.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import mobi.beyondpod.rsscore.Configuration;

public class EnvironmentChangeReceiver
  extends BroadcastReceiver
{
  private PowerManager.WakeLock _BPReceiverWakeLock;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (paramContext.getContentResolver() == null) {
      return;
    }
    this._BPReceiverWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(Configuration.DefaultDeviceWakeLock(), getClass().getName());
    this._BPReceiverWakeLock.setReferenceCounted(false);
    this._BPReceiverWakeLock.acquire(10000L);
    Log.v("BeyondPod", "Environment Change Receiver received intent: " + paramIntent);
    Intent localIntent = new Intent(paramContext, SchedulingService.class);
    localIntent.setAction(paramIntent);
    paramContext.startService(localIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/scheduler/EnvironmentChangeReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
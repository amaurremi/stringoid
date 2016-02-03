package mobi.beyondpod.services.player;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class PlayerUtils
{
  private static final String TAG = PlayerUtils.class.getSimpleName();
  private static ServiceBinder _ServiceBinder;
  public static IMediaPlaybackService sService = null;
  
  public static boolean bindToService(Context paramContext, ServiceConnection paramServiceConnection)
  {
    if (_ServiceBinder != null) {
      return true;
    }
    paramContext.startService(new Intent(paramContext, MediaPlaybackService.class));
    _ServiceBinder = new ServiceBinder(paramServiceConnection);
    return paramContext.bindService(new Intent(paramContext, MediaPlaybackService.class), _ServiceBinder, 0);
  }
  
  public static void stopService(Context paramContext)
  {
    unbindFromService(paramContext);
    paramContext.stopService(new Intent(paramContext, MediaPlaybackService.class));
  }
  
  public static void unbindFromService(Context paramContext)
  {
    if (_ServiceBinder == null) {
      return;
    }
    try
    {
      paramContext.unbindService(_ServiceBinder);
      _ServiceBinder = null;
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        CoreHelper.LogException(TAG, "Failed to unbind from the player service", paramContext);
      }
    }
  }
  
  private static class ServiceBinder
    implements ServiceConnection
  {
    ServiceConnection _Callback;
    
    ServiceBinder(ServiceConnection paramServiceConnection)
    {
      this._Callback = paramServiceConnection;
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      PlayerUtils.sService = IMediaPlaybackService.Stub.asInterface(paramIBinder);
      if (this._Callback != null) {
        this._Callback.onServiceConnected(paramComponentName, paramIBinder);
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (this._Callback != null) {
        this._Callback.onServiceDisconnected(paramComponentName);
      }
      PlayerUtils.sService = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/PlayerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
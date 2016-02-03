package android.support.v7.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class RemotePlaybackClient
{
  private static final boolean DEBUG = Log.isLoggable("RemotePlaybackClient", 3);
  private static final String TAG = "RemotePlaybackClient";
  private final Context mContext;
  private final PendingIntent mItemStatusPendingIntent;
  private final MediaRouter.RouteInfo mRoute;
  private boolean mRouteSupportsQueuing;
  private boolean mRouteSupportsRemotePlayback;
  private boolean mRouteSupportsSessionManagement;
  private String mSessionId;
  private final PendingIntent mSessionStatusPendingIntent;
  private StatusCallback mStatusCallback;
  private final StatusReceiver mStatusReceiver;
  
  public RemotePlaybackClient(Context paramContext, MediaRouter.RouteInfo paramRouteInfo)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context must not be null");
    }
    if (paramRouteInfo == null) {
      throw new IllegalArgumentException("route must not be null");
    }
    this.mContext = paramContext;
    this.mRoute = paramRouteInfo;
    paramRouteInfo = new IntentFilter();
    paramRouteInfo.addAction("android.support.v7.media.actions.ACTION_ITEM_STATUS_CHANGED");
    paramRouteInfo.addAction("android.support.v7.media.actions.ACTION_SESSION_STATUS_CHANGED");
    this.mStatusReceiver = new StatusReceiver(null);
    paramContext.registerReceiver(this.mStatusReceiver, paramRouteInfo);
    paramRouteInfo = new Intent("android.support.v7.media.actions.ACTION_ITEM_STATUS_CHANGED");
    paramRouteInfo.setPackage(paramContext.getPackageName());
    this.mItemStatusPendingIntent = PendingIntent.getBroadcast(paramContext, 0, paramRouteInfo, 0);
    paramRouteInfo = new Intent("android.support.v7.media.actions.ACTION_SESSION_STATUS_CHANGED");
    paramRouteInfo.setPackage(paramContext.getPackageName());
    this.mSessionStatusPendingIntent = PendingIntent.getBroadcast(paramContext, 0, paramRouteInfo, 0);
    detectFeatures();
  }
  
  private void adoptSession(String paramString)
  {
    if (paramString != null) {
      setSessionId(paramString);
    }
  }
  
  private static String bundleToString(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.size();
      return paramBundle.toString();
    }
    return "null";
  }
  
  private void detectFeatures()
  {
    boolean bool2 = true;
    if ((routeSupportsAction("android.media.intent.action.PLAY")) && (routeSupportsAction("android.media.intent.action.SEEK")) && (routeSupportsAction("android.media.intent.action.GET_STATUS")) && (routeSupportsAction("android.media.intent.action.PAUSE")) && (routeSupportsAction("android.media.intent.action.RESUME")) && (routeSupportsAction("android.media.intent.action.STOP")))
    {
      bool1 = true;
      this.mRouteSupportsRemotePlayback = bool1;
      if ((!this.mRouteSupportsRemotePlayback) || (!routeSupportsAction("android.media.intent.action.ENQUEUE")) || (!routeSupportsAction("android.media.intent.action.REMOVE"))) {
        break label142;
      }
      bool1 = true;
      label90:
      this.mRouteSupportsQueuing = bool1;
      if ((!this.mRouteSupportsRemotePlayback) || (!routeSupportsAction("android.media.intent.action.START_SESSION")) || (!routeSupportsAction("android.media.intent.action.GET_SESSION_STATUS")) || (!routeSupportsAction("android.media.intent.action.END_SESSION"))) {
        break label147;
      }
    }
    label142:
    label147:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mRouteSupportsSessionManagement = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label90;
    }
  }
  
  private void handleError(Intent paramIntent, ActionCallback paramActionCallback, String paramString, Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("android.media.intent.extra.ERROR_CODE", 0);; i = 0)
    {
      if (DEBUG) {
        Log.w("RemotePlaybackClient", "Received error from " + paramIntent.getAction() + ": error=" + paramString + ", code=" + i + ", data=" + bundleToString(paramBundle));
      }
      paramActionCallback.onError(paramString, i, paramBundle);
      return;
    }
  }
  
  private void handleInvalidResult(Intent paramIntent, ActionCallback paramActionCallback, Bundle paramBundle)
  {
    Log.w("RemotePlaybackClient", "Received invalid result data from " + paramIntent.getAction() + ": data=" + bundleToString(paramBundle));
    paramActionCallback.onError(null, 0, paramBundle);
  }
  
  private static String inferMissingResult(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return paramString1;
    }
    if ((paramString1 == null) || (paramString1.equals(paramString2))) {
      return paramString2;
    }
    return null;
  }
  
  private static void logRequest(Intent paramIntent)
  {
    if (DEBUG) {
      Log.d("RemotePlaybackClient", "Sending request: " + paramIntent);
    }
  }
  
  private void performItemAction(final Intent paramIntent, final String paramString1, final String paramString2, Bundle paramBundle, final ItemActionCallback paramItemActionCallback)
  {
    paramIntent.addCategory("android.media.intent.category.REMOTE_PLAYBACK");
    if (paramString1 != null) {
      paramIntent.putExtra("android.media.intent.extra.SESSION_ID", paramString1);
    }
    if (paramString2 != null) {
      paramIntent.putExtra("android.media.intent.extra.ITEM_ID", paramString2);
    }
    if (paramBundle != null) {
      paramIntent.putExtras(paramBundle);
    }
    logRequest(paramIntent);
    this.mRoute.sendControlRequest(paramIntent, new MediaRouter.ControlRequestCallback()
    {
      public void onError(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        RemotePlaybackClient.this.handleError(paramIntent, paramItemActionCallback, paramAnonymousString, paramAnonymousBundle);
      }
      
      public void onResult(Bundle paramAnonymousBundle)
      {
        if (paramAnonymousBundle != null)
        {
          String str1 = RemotePlaybackClient.inferMissingResult(paramString1, paramAnonymousBundle.getString("android.media.intent.extra.SESSION_ID"));
          MediaSessionStatus localMediaSessionStatus = MediaSessionStatus.fromBundle(paramAnonymousBundle.getBundle("android.media.intent.extra.SESSION_STATUS"));
          String str2 = RemotePlaybackClient.inferMissingResult(paramString2, paramAnonymousBundle.getString("android.media.intent.extra.ITEM_ID"));
          MediaItemStatus localMediaItemStatus = MediaItemStatus.fromBundle(paramAnonymousBundle.getBundle("android.media.intent.extra.ITEM_STATUS"));
          RemotePlaybackClient.this.adoptSession(str1);
          if ((str1 != null) && (str2 != null) && (localMediaItemStatus != null))
          {
            if (RemotePlaybackClient.DEBUG) {
              Log.d("RemotePlaybackClient", "Received result from " + paramIntent.getAction() + ": data=" + RemotePlaybackClient.bundleToString(paramAnonymousBundle) + ", sessionId=" + str1 + ", sessionStatus=" + localMediaSessionStatus + ", itemId=" + str2 + ", itemStatus=" + localMediaItemStatus);
            }
            paramItemActionCallback.onResult(paramAnonymousBundle, str1, localMediaSessionStatus, str2, localMediaItemStatus);
            return;
          }
        }
        RemotePlaybackClient.this.handleInvalidResult(paramIntent, paramItemActionCallback, paramAnonymousBundle);
      }
    });
  }
  
  private void performSessionAction(final Intent paramIntent, final String paramString, Bundle paramBundle, final SessionActionCallback paramSessionActionCallback)
  {
    paramIntent.addCategory("android.media.intent.category.REMOTE_PLAYBACK");
    if (paramString != null) {
      paramIntent.putExtra("android.media.intent.extra.SESSION_ID", paramString);
    }
    if (paramBundle != null) {
      paramIntent.putExtras(paramBundle);
    }
    logRequest(paramIntent);
    this.mRoute.sendControlRequest(paramIntent, new MediaRouter.ControlRequestCallback()
    {
      public void onError(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        RemotePlaybackClient.this.handleError(paramIntent, paramSessionActionCallback, paramAnonymousString, paramAnonymousBundle);
      }
      
      public void onResult(Bundle paramAnonymousBundle)
      {
        if (paramAnonymousBundle != null)
        {
          String str = RemotePlaybackClient.inferMissingResult(paramString, paramAnonymousBundle.getString("android.media.intent.extra.SESSION_ID"));
          MediaSessionStatus localMediaSessionStatus = MediaSessionStatus.fromBundle(paramAnonymousBundle.getBundle("android.media.intent.extra.SESSION_STATUS"));
          RemotePlaybackClient.this.adoptSession(str);
          if (str != null)
          {
            if (RemotePlaybackClient.DEBUG) {
              Log.d("RemotePlaybackClient", "Received result from " + paramIntent.getAction() + ": data=" + RemotePlaybackClient.bundleToString(paramAnonymousBundle) + ", sessionId=" + str + ", sessionStatus=" + localMediaSessionStatus);
            }
            try
            {
              paramSessionActionCallback.onResult(paramAnonymousBundle, str, localMediaSessionStatus);
              return;
            }
            finally
            {
              if ((paramIntent.getAction().equals("android.media.intent.action.END_SESSION")) && (str.equals(RemotePlaybackClient.this.mSessionId))) {
                RemotePlaybackClient.this.setSessionId(null);
              }
            }
          }
        }
        RemotePlaybackClient.this.handleInvalidResult(paramIntent, paramSessionActionCallback, paramAnonymousBundle);
      }
    });
  }
  
  private void playOrEnqueue(Uri paramUri, String paramString1, Bundle paramBundle1, long paramLong, Bundle paramBundle2, ItemActionCallback paramItemActionCallback, String paramString2)
  {
    if (paramUri == null) {
      throw new IllegalArgumentException("contentUri must not be null");
    }
    throwIfRemotePlaybackNotSupported();
    if (paramString2.equals("android.media.intent.action.ENQUEUE")) {
      throwIfQueuingNotSupported();
    }
    paramString2 = new Intent(paramString2);
    paramString2.setDataAndType(paramUri, paramString1);
    paramString2.putExtra("android.media.intent.extra.ITEM_STATUS_UPDATE_RECEIVER", this.mItemStatusPendingIntent);
    if (paramBundle1 != null) {
      paramString2.putExtra("android.media.intent.extra.ITEM_METADATA", paramBundle1);
    }
    if (paramLong != 0L) {
      paramString2.putExtra("android.media.intent.extra.ITEM_POSITION", paramLong);
    }
    performItemAction(paramString2, this.mSessionId, null, paramBundle2, paramItemActionCallback);
  }
  
  private boolean routeSupportsAction(String paramString)
  {
    return this.mRoute.supportsControlAction("android.media.intent.category.REMOTE_PLAYBACK", paramString);
  }
  
  private void throwIfNoCurrentSession()
  {
    if (this.mSessionId == null) {
      throw new IllegalStateException("There is no current session.");
    }
  }
  
  private void throwIfQueuingNotSupported()
  {
    if (!this.mRouteSupportsQueuing) {
      throw new UnsupportedOperationException("The route does not support queuing.");
    }
  }
  
  private void throwIfRemotePlaybackNotSupported()
  {
    if (!this.mRouteSupportsRemotePlayback) {
      throw new UnsupportedOperationException("The route does not support remote playback.");
    }
  }
  
  private void throwIfSessionManagementNotSupported()
  {
    if (!this.mRouteSupportsSessionManagement) {
      throw new UnsupportedOperationException("The route does not support session management.");
    }
  }
  
  public void endSession(Bundle paramBundle, SessionActionCallback paramSessionActionCallback)
  {
    throwIfSessionManagementNotSupported();
    throwIfNoCurrentSession();
    performSessionAction(new Intent("android.media.intent.action.END_SESSION"), this.mSessionId, paramBundle, paramSessionActionCallback);
  }
  
  public void enqueue(Uri paramUri, String paramString, Bundle paramBundle1, long paramLong, Bundle paramBundle2, ItemActionCallback paramItemActionCallback)
  {
    playOrEnqueue(paramUri, paramString, paramBundle1, paramLong, paramBundle2, paramItemActionCallback, "android.media.intent.action.ENQUEUE");
  }
  
  public String getSessionId()
  {
    return this.mSessionId;
  }
  
  public void getSessionStatus(Bundle paramBundle, SessionActionCallback paramSessionActionCallback)
  {
    throwIfSessionManagementNotSupported();
    throwIfNoCurrentSession();
    performSessionAction(new Intent("android.media.intent.action.GET_SESSION_STATUS"), this.mSessionId, paramBundle, paramSessionActionCallback);
  }
  
  public void getStatus(String paramString, Bundle paramBundle, ItemActionCallback paramItemActionCallback)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("itemId must not be null");
    }
    throwIfNoCurrentSession();
    performItemAction(new Intent("android.media.intent.action.GET_STATUS"), this.mSessionId, paramString, paramBundle, paramItemActionCallback);
  }
  
  public boolean hasSession()
  {
    return this.mSessionId != null;
  }
  
  public boolean isQueuingSupported()
  {
    return this.mRouteSupportsQueuing;
  }
  
  public boolean isRemotePlaybackSupported()
  {
    return this.mRouteSupportsRemotePlayback;
  }
  
  public boolean isSessionManagementSupported()
  {
    return this.mRouteSupportsSessionManagement;
  }
  
  public void pause(Bundle paramBundle, SessionActionCallback paramSessionActionCallback)
  {
    throwIfNoCurrentSession();
    performSessionAction(new Intent("android.media.intent.action.PAUSE"), this.mSessionId, paramBundle, paramSessionActionCallback);
  }
  
  public void play(Uri paramUri, String paramString, Bundle paramBundle1, long paramLong, Bundle paramBundle2, ItemActionCallback paramItemActionCallback)
  {
    playOrEnqueue(paramUri, paramString, paramBundle1, paramLong, paramBundle2, paramItemActionCallback, "android.media.intent.action.PLAY");
  }
  
  public void release()
  {
    this.mContext.unregisterReceiver(this.mStatusReceiver);
  }
  
  public void remove(String paramString, Bundle paramBundle, ItemActionCallback paramItemActionCallback)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("itemId must not be null");
    }
    throwIfQueuingNotSupported();
    throwIfNoCurrentSession();
    performItemAction(new Intent("android.media.intent.action.REMOVE"), this.mSessionId, paramString, paramBundle, paramItemActionCallback);
  }
  
  public void resume(Bundle paramBundle, SessionActionCallback paramSessionActionCallback)
  {
    throwIfNoCurrentSession();
    performSessionAction(new Intent("android.media.intent.action.RESUME"), this.mSessionId, paramBundle, paramSessionActionCallback);
  }
  
  public void seek(String paramString, long paramLong, Bundle paramBundle, ItemActionCallback paramItemActionCallback)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("itemId must not be null");
    }
    throwIfNoCurrentSession();
    Intent localIntent = new Intent("android.media.intent.action.SEEK");
    localIntent.putExtra("android.media.intent.extra.ITEM_POSITION", paramLong);
    performItemAction(localIntent, this.mSessionId, paramString, paramBundle, paramItemActionCallback);
  }
  
  public void setSessionId(String paramString)
  {
    if ((this.mSessionId != paramString) && ((this.mSessionId == null) || (!this.mSessionId.equals(paramString))))
    {
      if (DEBUG) {
        Log.d("RemotePlaybackClient", "Session id is now: " + paramString);
      }
      this.mSessionId = paramString;
      if (this.mStatusCallback != null) {
        this.mStatusCallback.onSessionChanged(paramString);
      }
    }
  }
  
  public void setStatusCallback(StatusCallback paramStatusCallback)
  {
    this.mStatusCallback = paramStatusCallback;
  }
  
  public void startSession(Bundle paramBundle, SessionActionCallback paramSessionActionCallback)
  {
    throwIfSessionManagementNotSupported();
    Intent localIntent = new Intent("android.media.intent.action.START_SESSION");
    localIntent.putExtra("android.media.intent.extra.SESSION_STATUS_UPDATE_RECEIVER", this.mSessionStatusPendingIntent);
    performSessionAction(localIntent, null, paramBundle, paramSessionActionCallback);
  }
  
  public void stop(Bundle paramBundle, SessionActionCallback paramSessionActionCallback)
  {
    throwIfNoCurrentSession();
    performSessionAction(new Intent("android.media.intent.action.STOP"), this.mSessionId, paramBundle, paramSessionActionCallback);
  }
  
  public static abstract class ActionCallback
  {
    public void onError(String paramString, int paramInt, Bundle paramBundle) {}
  }
  
  public static abstract class ItemActionCallback
    extends RemotePlaybackClient.ActionCallback
  {
    public void onResult(Bundle paramBundle, String paramString1, MediaSessionStatus paramMediaSessionStatus, String paramString2, MediaItemStatus paramMediaItemStatus) {}
  }
  
  public static abstract class SessionActionCallback
    extends RemotePlaybackClient.ActionCallback
  {
    public void onResult(Bundle paramBundle, String paramString, MediaSessionStatus paramMediaSessionStatus) {}
  }
  
  public static abstract class StatusCallback
  {
    public void onItemStatusChanged(Bundle paramBundle, String paramString1, MediaSessionStatus paramMediaSessionStatus, String paramString2, MediaItemStatus paramMediaItemStatus) {}
    
    public void onSessionChanged(String paramString) {}
    
    public void onSessionStatusChanged(Bundle paramBundle, String paramString, MediaSessionStatus paramMediaSessionStatus) {}
  }
  
  private final class StatusReceiver
    extends BroadcastReceiver
  {
    public static final String ACTION_ITEM_STATUS_CHANGED = "android.support.v7.media.actions.ACTION_ITEM_STATUS_CHANGED";
    public static final String ACTION_SESSION_STATUS_CHANGED = "android.support.v7.media.actions.ACTION_SESSION_STATUS_CHANGED";
    
    private StatusReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getStringExtra("android.media.intent.extra.SESSION_ID");
      if ((paramContext == null) || (!paramContext.equals(RemotePlaybackClient.this.mSessionId))) {
        Log.w("RemotePlaybackClient", "Discarding spurious status callback with missing or invalid session id: sessionId=" + paramContext);
      }
      MediaSessionStatus localMediaSessionStatus;
      do
      {
        String str;
        do
        {
          MediaItemStatus localMediaItemStatus;
          do
          {
            return;
            localMediaSessionStatus = MediaSessionStatus.fromBundle(paramIntent.getBundleExtra("android.media.intent.extra.SESSION_STATUS"));
            str = paramIntent.getAction();
            if (!str.equals("android.support.v7.media.actions.ACTION_ITEM_STATUS_CHANGED")) {
              break;
            }
            str = paramIntent.getStringExtra("android.media.intent.extra.ITEM_ID");
            if (str == null)
            {
              Log.w("RemotePlaybackClient", "Discarding spurious status callback with missing item id.");
              return;
            }
            localMediaItemStatus = MediaItemStatus.fromBundle(paramIntent.getBundleExtra("android.media.intent.extra.ITEM_STATUS"));
            if (localMediaItemStatus == null)
            {
              Log.w("RemotePlaybackClient", "Discarding spurious status callback with missing item status.");
              return;
            }
            if (RemotePlaybackClient.DEBUG) {
              Log.d("RemotePlaybackClient", "Received item status callback: sessionId=" + paramContext + ", sessionStatus=" + localMediaSessionStatus + ", itemId=" + str + ", itemStatus=" + localMediaItemStatus);
            }
          } while (RemotePlaybackClient.this.mStatusCallback == null);
          RemotePlaybackClient.this.mStatusCallback.onItemStatusChanged(paramIntent.getExtras(), paramContext, localMediaSessionStatus, str, localMediaItemStatus);
          return;
        } while (!str.equals("android.support.v7.media.actions.ACTION_SESSION_STATUS_CHANGED"));
        if (localMediaSessionStatus == null)
        {
          Log.w("RemotePlaybackClient", "Discarding spurious media status callback with missing session status.");
          return;
        }
        if (RemotePlaybackClient.DEBUG) {
          Log.d("RemotePlaybackClient", "Received session status callback: sessionId=" + paramContext + ", sessionStatus=" + localMediaSessionStatus);
        }
      } while (RemotePlaybackClient.this.mStatusCallback == null);
      RemotePlaybackClient.this.mStatusCallback.onSessionStatusChanged(paramIntent.getExtras(), paramContext, localMediaSessionStatus);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/media/RemotePlaybackClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
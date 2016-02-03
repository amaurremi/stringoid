package mobi.beyondpod.services.player.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouteSelector.Builder;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.util.Log;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.CastApi;
import com.google.android.gms.cast.Cast.CastOptions;
import com.google.android.gms.cast.Cast.CastOptions.Builder;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult;
import com.google.android.gms.cast.RemoteMediaPlayer.OnStatusUpdatedListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import mobi.beyondpod.ui.commands.CommandManagerBase;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(16)
public class ChromecastDevice
{
  public static final String APPLICATION_ID_DEV = "BBC4E9EF";
  public static final String APPLICATION_ID_PROD = "D1B83C8C";
  public static final String APPLICATION_ID_TEST = "6F001398";
  public static final int CC_SDK_LEVEL = 3;
  private static final String TAG = "ChromecastDevice";
  private static final double VOLUME_INCREMENT = 0.05D;
  private ApplicationMetadata _AppMetadata;
  private GoogleApiClient _CastClient;
  private Cast.Listener _CastDeviceControllerListener;
  private ConnectionCallbacks _ConnectionCallbacks;
  private ConnectionFailedListener _ConnectionFailedListener;
  private MediaControlChannel _MediaControlChannel;
  private MediaFeedbackChannel _MediaFeedbackChannel;
  private MediaRouteSelector _MediaRouteSelector;
  private MediaRouter _MediaRouter;
  private CastMediaRouterCallback _MediaRouterCallback;
  private CastDevice _SelectedDevice;
  
  public ChromecastDevice(Context paramContext)
  {
    this._MediaRouter = MediaRouter.getInstance(paramContext);
    this._ConnectionCallbacks = new ConnectionCallbacks(null);
    this._ConnectionFailedListener = new ConnectionFailedListener(null);
    this._CastDeviceControllerListener = new CastDeviceControllerListener(null);
    paramContext = new MediaRouteSelector.Builder();
    paramContext.addControlCategory(CastMediaControlIntent.categoryForCast(AppId()));
    this._MediaRouteSelector = paramContext.build();
    this._MediaRouterCallback = new CastMediaRouterCallback(null);
    this._MediaRouter.addCallback(this._MediaRouteSelector, this._MediaRouterCallback, 1);
  }
  
  private static String AppId()
  {
    if (Configuration.DBGChromecastEnvironment() == 0) {
      return "D1B83C8C";
    }
    return "BBC4E9EF";
  }
  
  public static String CastControlCategory()
  {
    return CastMediaControlIntent.categoryForCast(AppId());
  }
  
  public static boolean IsConnected()
  {
    return BeyondPodApplication.GetInstance().ChromecastDevice().hasDeviceConnection();
  }
  
  public static boolean checkGooglePlaySevices(Activity paramActivity, boolean paramBoolean)
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramActivity);
    switch (i)
    {
    }
    do
    {
      return false;
      return true;
    } while (!paramBoolean);
    paramActivity = GooglePlayServicesUtil.getErrorDialog(i, paramActivity, 0);
    paramActivity.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    paramActivity.show();
    return false;
  }
  
  private void connectToDeviceInternal(CastDevice paramCastDevice)
  {
    if (LicenseManager.IfInRestrictedMode())
    {
      CoreHelper.WriteTraceEntry("ChromecastDevice", "Found cast device, but we are in Restricted mode. Ignoring...");
      return;
    }
    this._SelectedDevice = paramCastDevice;
    CoreHelper.WriteTraceEntry("ChromecastDevice", "Found cast device: " + this._SelectedDevice);
    CoreHelper.WriteTraceEntry("ChromecastDevice", "Acquiring controller for it...");
    try
    {
      paramCastDevice = Cast.CastOptions.builder(this._SelectedDevice, this._CastDeviceControllerListener);
      this._CastClient = new GoogleApiClient.Builder(BeyondPodApplication.GetInstance().getApplicationContext()).addApi(Cast.API, paramCastDevice.build()).addConnectionCallbacks(this._ConnectionCallbacks).addOnConnectionFailedListener(this._ConnectionFailedListener).build();
      this._CastClient.connect();
      return;
    }
    catch (IllegalStateException paramCastDevice)
    {
      CoreHelper.WriteTraceEntry("ChromecastDevice", "Error while creating a device controller: " + paramCastDevice.getMessage());
    }
  }
  
  private void detachFeedbackChannel()
  {
    if ((this._MediaFeedbackChannel == null) || (this._CastClient != null)) {}
    try
    {
      Cast.CastApi.removeMessageReceivedCallbacks(this._CastClient, this._MediaFeedbackChannel.getNamespace());
      this._MediaFeedbackChannel = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        CoreHelper.WriteTraceEntry("ChromecastDevice", "Unabe to remove Media Feedback Channel callbacks");
      }
    }
  }
  
  private void detachMediaChannel()
  {
    if ((this._MediaControlChannel == null) || (this._CastClient != null)) {}
    try
    {
      Cast.CastApi.removeMessageReceivedCallbacks(this._CastClient, this._MediaControlChannel.getNamespace());
      this._MediaControlChannel.release();
      this._MediaControlChannel = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        CoreHelper.WriteTraceEntry("ChromecastDevice", "Unabe to remove Media Control Channel callbacks");
      }
    }
  }
  
  private void disconnectFromDeviceInternal()
  {
    boolean bool;
    if ((!hasDeviceConnection()) && (this._CastClient == null))
    {
      bool = false;
      CoreHelper.WriteTraceEntry("ChromecastDevice", "Trying to disconnect from Chromecast device... (was connected: " + bool + ")");
    }
    for (;;)
    {
      try
      {
        if (this._CastClient == null) {
          continue;
        }
        if (this._CastClient.isConnected()) {
          Cast.CastApi.stopApplication(this._CastClient);
        }
        detachMediaChannel();
        detachFeedbackChannel();
        if ((this._CastClient != null) && (this._CastClient.isConnected())) {
          this._CastClient.disconnect();
        }
      }
      catch (Exception localException)
      {
        CoreHelper.WriteTraceErrorInDebug("ChromecastDevice", "Failed to disconnect from device! " + localException.getMessage());
        continue;
      }
      this._MediaFeedbackChannel = null;
      this._MediaControlChannel = null;
      this._CastClient = null;
      this._SelectedDevice = null;
      this._AppMetadata = null;
      if (bool) {
        CommandManagerBase.CmdSwitchPlayerForCurrentTrack(false);
      }
      return;
      bool = true;
      break;
      CoreHelper.WriteTraceEntry("ChromecastDevice", "Device appears to be already disconnected...");
    }
  }
  
  private boolean hasDeviceConnection()
  {
    return (this._SelectedDevice != null) && (this._CastClient != null) && (this._CastClient.isConnected());
  }
  
  private void onSetVolume(double paramDouble)
  {
    try
    {
      if (this._CastClient != null) {
        Cast.CastApi.setVolume(this._CastClient, paramDouble);
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      CoreHelper.LogException("ChromecastDevice", "Problem sending Set Volume", localIllegalStateException);
      return;
    }
    catch (IOException localIOException)
    {
      CoreHelper.LogException("ChromecastDevice", "Problem sending Set Volume", localIOException);
    }
  }
  
  public String ConnectedDeviceName()
  {
    if (!hasDeviceConnection()) {
      return "";
    }
    MediaRouter.RouteInfo localRouteInfo = this._MediaRouter.getSelectedRoute();
    if (localRouteInfo != null) {
      return localRouteInfo.getName();
    }
    return "";
  }
  
  public boolean adjustVolume(int paramInt)
  {
    if (hasDeviceConnection())
    {
      double d1 = Cast.CastApi.getVolume(this._CastClient);
      double d2 = d1 + paramInt * 0.05D;
      CoreHelper.WriteTraceEntry("ChromecastDevice", "Setting volume from " + d1 + " to " + d2);
      onSetVolume(d2);
      return true;
    }
    return false;
  }
  
  public boolean connectToDevice(String paramString)
    throws IllegalAccessException
  {
    if (LicenseManager.IfInRestrictedMode()) {
      throw new IllegalAccessException();
    }
    return true;
  }
  
  public boolean disconnectFromDevice()
  {
    return true;
  }
  
  MediaControlChannel getMediaControlChannel()
  {
    return this._MediaControlChannel;
  }
  
  MediaFeedbackChannel getMediaFeedbackChannel()
  {
    return this._MediaFeedbackChannel;
  }
  
  public MediaRouteSelector getRouteSelector()
  {
    return this._MediaRouteSelector;
  }
  
  public void onUpdateVolume(double paramDouble) {}
  
  public void switchToDefaultRoute()
  {
    CoreHelper.WriteTraceEntry("ChromecastDevice", "Switching to default route...");
    this._MediaRouter.getDefaultRoute().select();
    CommandManagerBase.CmdSwitchPlayerForCurrentTrack(false);
  }
  
  private class CastDeviceControllerListener
    extends Cast.Listener
  {
    private CastDeviceControllerListener() {}
    
    public void onApplicationDisconnected(int paramInt)
    {
      CoreHelper.WriteTraceEntry("ChromecastDevice", "Application has stopped");
      ChromecastDevice.this._AppMetadata = null;
      ChromecastDevice.this.detachMediaChannel();
      ChromecastDevice.this.detachFeedbackChannel();
      ChromecastDevice.this.switchToDefaultRoute();
    }
    
    public void onApplicationStatusChanged()
    {
      CoreHelper.WriteTraceEntry("ChromecastDevice", "Application Status Changed");
    }
    
    public void onVolumeChanged()
    {
      if (ChromecastDevice.this._CastClient == null) {
        return;
      }
      CoreHelper.WriteTraceEntry("ChromecastDevice", "Application Volume Changed: " + Cast.CastApi.getVolume(ChromecastDevice.this._CastClient) + ", Mute:" + Cast.CastApi.isMute(ChromecastDevice.this._CastClient));
      ChromecastDevice.this.onUpdateVolume(Cast.CastApi.getVolume(ChromecastDevice.this._CastClient));
    }
  }
  
  private class CastMediaRouterCallback
    extends MediaRouter.Callback
  {
    private CastMediaRouterCallback() {}
    
    public void onRouteSelected(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
    {
      paramMediaRouter = CastDevice.getFromBundle(paramRouteInfo.getExtras());
      ChromecastDevice.this.connectToDeviceInternal(paramMediaRouter);
    }
    
    public void onRouteUnselected(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
    {
      ChromecastDevice.this.disconnectFromDeviceInternal();
    }
  }
  
  private class ConnectionCallbacks
    implements GoogleApiClient.ConnectionCallbacks
  {
    private ConnectionCallbacks() {}
    
    public void onConnected(Bundle paramBundle)
    {
      try
      {
        Cast.CastApi.requestStatus(ChromecastDevice.this._CastClient);
        if (Configuration.DBGChromecastEnvironment() == 0) {}
        for (paramBundle = "D1B83C8C";; paramBundle = "BBC4E9EF")
        {
          CoreHelper.WriteTraceEntry("ChromecastDevice", "Device controller connected! Launching receiver application..." + paramBundle);
          Cast.CastApi.launchApplication(ChromecastDevice.this._CastClient, paramBundle, true).setResultCallback(new ResultCallback()
          {
            public void onResult(Cast.ApplicationConnectionResult paramAnonymousApplicationConnectionResult)
            {
              if (paramAnonymousApplicationConnectionResult.getStatus().isSuccess())
              {
                CoreHelper.WriteTraceEntry("ChromecastDevice", "Receiver application launched: " + paramAnonymousApplicationConnectionResult.getApplicationStatus());
                ChromecastDevice.this.detachMediaChannel();
                ChromecastDevice.this.detachFeedbackChannel();
                try
                {
                  ChromecastDevice.this._AppMetadata = paramAnonymousApplicationConnectionResult.getApplicationMetadata();
                  ChromecastDevice.this._MediaControlChannel = new ChromecastDevice.MediaControlChannel(ChromecastDevice.this._CastClient);
                  Cast.CastApi.setMessageReceivedCallbacks(ChromecastDevice.this._CastClient, ChromecastDevice.this._MediaControlChannel.getNamespace(), ChromecastDevice.this._MediaControlChannel);
                  ChromecastDevice.this._MediaFeedbackChannel = new ChromecastDevice.MediaFeedbackChannel();
                  Cast.CastApi.setMessageReceivedCallbacks(ChromecastDevice.this._CastClient, ChromecastDevice.this._MediaFeedbackChannel.getNamespace(), ChromecastDevice.this._MediaFeedbackChannel);
                  ChromecastDevice.this._MediaControlChannel.requestStatus(ChromecastDevice.this._CastClient);
                  CommandManagerBase.CmdSwitchPlayerForCurrentTrack(false);
                  return;
                }
                catch (IOException paramAnonymousApplicationConnectionResult)
                {
                  Log.w("ChromecastDevice", "Unable to request status", paramAnonymousApplicationConnectionResult);
                  return;
                }
              }
              CoreHelper.WriteTraceEntry("ChromecastDevice", "Receiver application launch failed! " + paramAnonymousApplicationConnectionResult);
            }
          });
          return;
        }
        return;
      }
      catch (IOException paramBundle)
      {
        CoreHelper.LogException("ChromecastDevice", "Error requesting status!", paramBundle);
      }
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      CoreHelper.WriteTraceEntry("ChromecastDevice", "Device controller disconnected!");
      ChromecastDevice.this.detachMediaChannel();
      ChromecastDevice.this.detachFeedbackChannel();
    }
  }
  
  private class ConnectionFailedListener
    implements GoogleApiClient.OnConnectionFailedListener
  {
    private ConnectionFailedListener() {}
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      CoreHelper.WriteTraceEntry("ChromecastDevice", "Connection Failed!");
      ChromecastDevice.this.switchToDefaultRoute();
    }
  }
  
  public static class MediaControlChannel
    extends RemoteMediaPlayer
  {
    StreamNotificationListener _NotificationListener;
    Runnable _StatusUpdateRunnable = new Runnable()
    {
      public void run()
      {
        try
        {
          ChromecastDevice.MediaControlChannel.this.mEventHandler.removeCallbacks(ChromecastDevice.MediaControlChannel.this._StatusUpdateRunnable);
          ChromecastDevice.MediaControlChannel.this.requestStatus(ChromecastDevice.MediaControlChannel.this.mCastClient);
          return;
        }
        catch (Exception localException)
        {
          CoreHelper.WriteTraceErrorInDebug("ChromecastDevice", "Failed to update status! " + localException.getMessage());
        }
      }
    };
    RemoteMediaPlayer.OnStatusUpdatedListener _StatusUpdatedListener = new RemoteMediaPlayer.OnStatusUpdatedListener()
    {
      public void onStatusUpdated()
      {
        if (ChromecastDevice.MediaControlChannel.this.getMediaStatus() == null) {
          return;
        }
        ChromecastDevice.MediaControlChannel.this.ScheduleNextStatusUpdateIfNeeded();
      }
    };
    private GoogleApiClient mCastClient;
    private Handler mEventHandler;
    
    public MediaControlChannel(GoogleApiClient paramGoogleApiClient)
    {
      this.mCastClient = paramGoogleApiClient;
      paramGoogleApiClient = Looper.myLooper();
      if (paramGoogleApiClient != null)
      {
        this.mEventHandler = new Handler(paramGoogleApiClient);
        return;
      }
      paramGoogleApiClient = Looper.getMainLooper();
      if (paramGoogleApiClient != null)
      {
        this.mEventHandler = new Handler(paramGoogleApiClient);
        return;
      }
      this.mEventHandler = null;
    }
    
    private void seekWithLoad(MediaInfo paramMediaInfo, long paramLong)
      throws IOException
    {
      if (this.mCastClient == null)
      {
        CoreHelper.WriteTraceEntry("ChromecastDevice", "Failed to load-for-seek remote contentent - No active session!");
        if (this._NotificationListener != null) {
          this._NotificationListener.onLoadFailed();
        }
        return;
      }
      CoreHelper.WriteTraceEntry("ChromecastDevice", "Seeking (with load) to position: " + paramLong + " content: " + paramMediaInfo.getContentId());
      load(this.mCastClient, paramMediaInfo, false, paramLong).setResultCallback(new ResultCallback()
      {
        public void onResult(RemoteMediaPlayer.MediaChannelResult paramAnonymousMediaChannelResult)
        {
          CoreHelper.WriteTraceEntry("ChromecastDevice", "####---- On Load-For-Seek Completed! Status: " + paramAnonymousMediaChannelResult);
          if (paramAnonymousMediaChannelResult.getStatus().isSuccess()) {
            if (ChromecastDevice.MediaControlChannel.this._NotificationListener != null) {
              ChromecastDevice.MediaControlChannel.this._NotificationListener.onSeekCompleted();
            }
          }
          while (ChromecastDevice.MediaControlChannel.this._NotificationListener == null) {
            return;
          }
          ChromecastDevice.MediaControlChannel.this._NotificationListener.onSeekFailed();
        }
      });
    }
    
    void ScheduleNextStatusUpdateIfNeeded()
    {
      this.mEventHandler.removeCallbacks(this._StatusUpdateRunnable);
      MediaStatus localMediaStatus = getMediaStatus();
      if ((localMediaStatus != null) && (localMediaStatus.getPlayerState() == 2)) {
        this.mEventHandler.postDelayed(this._StatusUpdateRunnable, 1000L);
      }
    }
    
    public boolean hasRemotePlayerLoadedMedia()
    {
      MediaStatus localMediaStatus = getMediaStatus();
      return (localMediaStatus != null) && ((localMediaStatus.getPlayerState() == 4) || (localMediaStatus.getPlayerState() == 3) || (localMediaStatus.getPlayerState() == 2));
    }
    
    void load(MediaInfo paramMediaInfo)
      throws IOException
    {
      if (this.mCastClient == null)
      {
        CoreHelper.WriteTraceEntry("ChromecastDevice", "Failed to load remote contentent - No active session!");
        if (this._NotificationListener != null) {
          this._NotificationListener.onLoadFailed();
        }
        return;
      }
      load(this.mCastClient, paramMediaInfo, false).setResultCallback(new ResultCallback()
      {
        public void onResult(RemoteMediaPlayer.MediaChannelResult paramAnonymousMediaChannelResult)
        {
          CoreHelper.WriteTraceEntry("ChromecastDevice", "####---- On LoadCompleted! Status: " + paramAnonymousMediaChannelResult);
          if (paramAnonymousMediaChannelResult.getStatus().isSuccess()) {
            if (ChromecastDevice.MediaControlChannel.this._NotificationListener != null) {
              ChromecastDevice.MediaControlChannel.this._NotificationListener.onLoadCompleted();
            }
          }
          while (ChromecastDevice.MediaControlChannel.this._NotificationListener == null) {
            return;
          }
          ChromecastDevice.MediaControlChannel.this._NotificationListener.onLoadFailed();
        }
      });
    }
    
    public void onSessionEnded(int paramInt1, int paramInt2)
    {
      if (this._NotificationListener != null) {
        this._NotificationListener.onSessionInterrupted(paramInt1, paramInt2);
      }
    }
    
    void pause()
      throws IOException
    {
      pause(this.mCastClient);
    }
    
    void play()
      throws IllegalStateException, IOException
    {
      play(this.mCastClient);
    }
    
    public void release()
    {
      if (this.mEventHandler != null) {
        this.mEventHandler.removeCallbacksAndMessages(null);
      }
    }
    
    void seek(MediaInfo paramMediaInfo, long paramLong)
      throws IllegalStateException, IOException
    {
      if (!hasRemotePlayerLoadedMedia())
      {
        seekWithLoad(paramMediaInfo, paramLong);
        return;
      }
      CoreHelper.WriteTraceEntry("ChromecastDevice", "Seeking to position: " + paramLong + " content: " + paramMediaInfo.getContentId());
      seek(this.mCastClient, paramLong, 0).setResultCallback(new ResultCallback()
      {
        public void onResult(RemoteMediaPlayer.MediaChannelResult paramAnonymousMediaChannelResult)
        {
          if (paramAnonymousMediaChannelResult.getStatus().isSuccess()) {
            if (ChromecastDevice.MediaControlChannel.this._NotificationListener != null) {
              ChromecastDevice.MediaControlChannel.this._NotificationListener.onSeekCompleted();
            }
          }
          while (ChromecastDevice.MediaControlChannel.this._NotificationListener == null) {
            return;
          }
          ChromecastDevice.MediaControlChannel.this._NotificationListener.onSeekFailed();
        }
      });
    }
    
    void setNotificationListener(StreamNotificationListener paramStreamNotificationListener)
    {
      this._NotificationListener = paramStreamNotificationListener;
    }
    
    static abstract interface StreamNotificationListener
    {
      public abstract void onLoadCompleted();
      
      public abstract void onLoadFailed();
      
      public abstract void onSeekCompleted();
      
      public abstract void onSeekFailed();
      
      public abstract void onSessionInterrupted(int paramInt1, int paramInt2);
    }
  }
  
  public static class MediaFeedbackChannel
    implements Cast.MessageReceivedCallback
  {
    private static final String BP_FEEDBACK_CHANNEL_NAMESPACE = "urn:x-cast:mobi.beyondpod.feedbackchannel";
    private static final String KEY_CONTENT_ID = "contentId";
    private static final String KEY_EVENT = "event";
    private static final String KEY_MEDIA_END = "mediaEnded";
    private static final String KEY_PLAYBACK_ERROR_ID = "playbackError";
    private static final String KEY_SEEK_COMPLETED = "seekCompleted";
    private static final String KEY_VIDEO_FOCUS_GAIN = "videoFocusGain";
    private static final String KEY_VIDEO_FOCUS_LOST = "videoFocusLost";
    FeedbackNotificationListener _NotificationListener;
    
    String getNamespace()
    {
      return "urn:x-cast:mobi.beyondpod.feedbackchannel";
    }
    
    public void onMessageReceived(CastDevice paramCastDevice, String paramString1, String paramString2)
    {
      if (!"urn:x-cast:mobi.beyondpod.feedbackchannel".equals(paramString1)) {}
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                try
                {
                  paramCastDevice = new JSONObject(paramString2);
                  if (!paramCastDevice.has("event")) {
                    break label227;
                  }
                  paramString1 = paramCastDevice.getString("event");
                  if ("seekCompleted".equals(paramString1))
                  {
                    CoreHelper.WriteTraceEntry("ChromecastDevice", "####FB ---- On Seek Completed!");
                    return;
                  }
                }
                catch (JSONException paramCastDevice)
                {
                  CoreHelper.WriteTraceEntry("ChromecastDevice", "Message doesn't contain an expected key:" + paramCastDevice.getMessage() + ", Message: " + paramString2);
                  return;
                }
                if (!"mediaEnded".equals(paramString1)) {
                  break;
                }
                CoreHelper.WriteTraceEntry("ChromecastDevice", "####FB ---- On Playback Completed!");
                paramCastDevice = paramCastDevice.getString("contentId");
              } while (this._NotificationListener == null);
              this._NotificationListener.onPlaybackComplete(paramCastDevice);
              return;
              if (!"videoFocusLost".equals(paramString1)) {
                break;
              }
              CoreHelper.WriteTraceEntry("ChromecastDevice", "####FB ---- On Video Focus Lost");
            } while (this._NotificationListener == null);
            this._NotificationListener.onVideoFocusLost();
            return;
            if (!"videoFocusGain".equals(paramString1)) {
              break;
            }
            CoreHelper.WriteTraceEntry("ChromecastDevice", "####FB ---- On Video Focus Gain");
          } while (this._NotificationListener == null);
          this._NotificationListener.onVideoFocusGain();
          return;
        } while (!"playbackError".equals(paramString1));
        CoreHelper.WriteTraceEntry("ChromecastDevice", "####FB ---- On Playback Error");
      } while (this._NotificationListener == null);
      this._NotificationListener.onPlaybackError();
      return;
      label227:
      CoreHelper.WriteTraceEntry("ChromecastDevice", "Unknown payload: " + paramCastDevice);
    }
    
    void setNotificationListener(FeedbackNotificationListener paramFeedbackNotificationListener)
    {
      this._NotificationListener = paramFeedbackNotificationListener;
    }
    
    static abstract interface FeedbackNotificationListener
    {
      public abstract void onPlaybackComplete(String paramString);
      
      public abstract void onPlaybackError();
      
      public abstract void onVideoFocusGain();
      
      public abstract void onVideoFocusLost();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/impl/ChromecastDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package mobi.beyondpod.services.player;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.MetadataEditor;
import android.media.RemoteControlClient.OnGetPlaybackPositionListener;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.services.player.impl.ChromecastDevice;

public abstract class RemoteControlClientHelper2
{
  public static RemoteControlClientHelper2 getInstance(PendingIntent paramPendingIntent)
  {
    if (CoreHelper.ApiLevel() < 14) {
      return RemoteControlClientHelper2.NoOp.Holder.getInstance(paramPendingIntent);
    }
    if (CoreHelper.ApiLevel() < 18) {
      return RemoteControlClientHelper2.ICS.Holder.getInstance(paramPendingIntent);
    }
    return RemoteControlClientHelper2.JB.Holder.getInstance(paramPendingIntent);
  }
  
  abstract void editMetadata(Track paramTrack, Bitmap paramBitmap);
  
  abstract void registerRemoteControlClient(AudioManager paramAudioManager);
  
  abstract void setPlaybackState(int paramInt, long paramLong, float paramFloat);
  
  abstract void setTransportControlFlags(int paramInt);
  
  abstract void unregisterRemoteControlClient(AudioManager paramAudioManager);
  
  @TargetApi(14)
  private static class ICS
    extends RemoteControlClientHelper2
  {
    protected RemoteControlClient _Client;
    
    public ICS(PendingIntent paramPendingIntent)
    {
      this._Client = new RemoteControlClient(paramPendingIntent);
    }
    
    @TargetApi(14)
    void editMetadata(Track paramTrack, Bitmap paramBitmap)
    {
      String str2 = DateTime.FormatDateTimeToday(paramTrack.getLastModifiedDate());
      if (!paramTrack.getParentFeed().HasUrl())
      {
        str1 = paramTrack.getParentFeed().getName();
        localObject = paramTrack.getParentFeed().getName();
        if (ChromecastDevice.IsConnected())
        {
          str1 = ChromecastUtils.buildCastingToTitle(null);
          localObject = null;
        }
        paramTrack = this._Client.editMetadata(true).putString(13, str1).putString(2, str1).putString(7, paramTrack.DisplayName()).putString(5, str2).putLong(9, paramTrack.getTotalTime() * 1000L);
        if (paramBitmap != null) {
          paramTrack.putBitmap(100, paramBitmap);
        }
        if (!StringUtils.IsNullOrEmpty((String)localObject)) {
          paramTrack.putString(1, (String)localObject);
        }
        paramTrack.apply();
        return;
      }
      Object localObject = new StringBuilder(String.valueOf(str2));
      if (paramTrack.getTotalTime() > 0L) {}
      for (String str1 = " - " + paramTrack.TotalTimeAsMinuteString();; str1 = "")
      {
        str1 = str1;
        break;
      }
    }
    
    void registerRemoteControlClient(AudioManager paramAudioManager)
    {
      paramAudioManager.registerRemoteControlClient(this._Client);
    }
    
    void setPlaybackState(int paramInt, long paramLong, float paramFloat)
    {
      this._Client.setPlaybackState(paramInt);
    }
    
    void setTransportControlFlags(int paramInt)
    {
      this._Client.setTransportControlFlags(paramInt);
    }
    
    void unregisterRemoteControlClient(AudioManager paramAudioManager)
    {
      paramAudioManager.unregisterRemoteControlClient(this._Client);
    }
    
    private static class Holder
    {
      private static final RemoteControlClientHelper2.ICS getInstance(PendingIntent paramPendingIntent)
      {
        return new RemoteControlClientHelper2.ICS(paramPendingIntent);
      }
    }
  }
  
  @TargetApi(18)
  private static class JB
    extends RemoteControlClientHelper2.ICS
  {
    private static String TAG = JB.class.getSimpleName();
    RemoteControlClient.OnGetPlaybackPositionListener getPositionListener = new RemoteControlClient.OnGetPlaybackPositionListener()
    {
      public long onGetPlaybackPosition()
      {
        Track localTrack = BeyondPodApplication.GetInstance().PlayList().CurrentTrack();
        if (localTrack != null)
        {
          CoreHelper.WriteTraceEntryInDebug(RemoteControlClientHelper2.JB.TAG, " ### Get Played time =>" + CoreHelper.FormatTimeAsString(localTrack.getPlayedTime(), true));
          return localTrack.getPlayedTime() * 1000L;
        }
        return -1L;
      }
    };
    RemoteControlClient.OnPlaybackPositionUpdateListener seekToListener = new RemoteControlClient.OnPlaybackPositionUpdateListener()
    {
      public void onPlaybackPositionUpdate(long paramAnonymousLong)
      {
        CoreHelper.WriteTraceEntry(RemoteControlClientHelper2.JB.TAG, "***========> Remote Control received seek command to " + paramAnonymousLong);
        Intent localIntent = new Intent(BeyondPodApplication.GetInstance().getApplicationContext(), MediaPlaybackService.class);
        localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
        localIntent.putExtra("command", "seekToLocation");
        localIntent.putExtra("seekToLocation", paramAnonymousLong);
        if (!BeyondPodApplication.GetInstance().SendCommandToVideoPlayer(localIntent)) {
          BeyondPodApplication.GetInstance().getApplicationContext().startService(localIntent);
        }
      }
    };
    
    public JB(PendingIntent paramPendingIntent)
    {
      super();
      this._Client.setPlaybackPositionUpdateListener(this.seekToListener);
      this._Client.setOnGetPlaybackPositionListener(this.getPositionListener);
    }
    
    void setPlaybackState(int paramInt, long paramLong, float paramFloat)
    {
      this._Client.setPlaybackState(paramInt, paramLong, paramFloat);
    }
    
    @TargetApi(18)
    void setTransportControlFlags(int paramInt)
    {
      this._Client.setTransportControlFlags(paramInt | 0x100);
    }
    
    private static class Holder
    {
      private static final RemoteControlClientHelper2.JB getInstance(PendingIntent paramPendingIntent)
      {
        return new RemoteControlClientHelper2.JB(paramPendingIntent);
      }
    }
  }
  
  private static class NoOp
    extends RemoteControlClientHelper2
  {
    public NoOp(PendingIntent paramPendingIntent) {}
    
    void editMetadata(Track paramTrack, Bitmap paramBitmap) {}
    
    void registerRemoteControlClient(AudioManager paramAudioManager) {}
    
    void setPlaybackState(int paramInt, long paramLong, float paramFloat) {}
    
    void setTransportControlFlags(int paramInt) {}
    
    void unregisterRemoteControlClient(AudioManager paramAudioManager) {}
    
    private static class Holder
    {
      private static final RemoteControlClientHelper2.NoOp getInstance(PendingIntent paramPendingIntent)
      {
        return new RemoteControlClientHelper2.NoOp(paramPendingIntent);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/RemoteControlClientHelper2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
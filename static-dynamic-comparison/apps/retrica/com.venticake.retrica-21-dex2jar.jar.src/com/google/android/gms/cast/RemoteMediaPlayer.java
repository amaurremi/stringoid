package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gh;
import com.google.android.gms.internal.go;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer
  implements Cast.MessageReceivedCallback
{
  public static final int RESUME_STATE_PAUSE = 2;
  public static final int RESUME_STATE_PLAY = 1;
  public static final int RESUME_STATE_UNCHANGED = 0;
  public static final int STATUS_CANCELED = 2;
  public static final int STATUS_FAILED = 1;
  public static final int STATUS_REPLACED = 4;
  public static final int STATUS_SUCCEEDED = 0;
  public static final int STATUS_TIMED_OUT = 3;
  private final go AW = new go()
  {
    protected void onMetadataUpdated()
    {
      RemoteMediaPlayer.b(RemoteMediaPlayer.this);
    }
    
    protected void onStatusUpdated()
    {
      RemoteMediaPlayer.a(RemoteMediaPlayer.this);
    }
  };
  private final g AX = new g(this);
  private RemoteMediaPlayer.OnMetadataUpdatedListener AY;
  private RemoteMediaPlayer.OnStatusUpdatedListener AZ;
  private final Object ls = new Object();
  
  public RemoteMediaPlayer()
  {
    this.AW.a(this.AX);
  }
  
  private void onMetadataUpdated()
  {
    if (this.AY != null) {
      this.AY.onMetadataUpdated();
    }
  }
  
  private void onStatusUpdated()
  {
    if (this.AZ != null) {
      this.AZ.onStatusUpdated();
    }
  }
  
  public long getApproximateStreamPosition()
  {
    synchronized (this.ls)
    {
      long l = this.AW.getApproximateStreamPosition();
      return l;
    }
  }
  
  public MediaInfo getMediaInfo()
  {
    synchronized (this.ls)
    {
      MediaInfo localMediaInfo = this.AW.getMediaInfo();
      return localMediaInfo;
    }
  }
  
  public MediaStatus getMediaStatus()
  {
    synchronized (this.ls)
    {
      MediaStatus localMediaStatus = this.AW.getMediaStatus();
      return localMediaStatus;
    }
  }
  
  public String getNamespace()
  {
    return this.AW.getNamespace();
  }
  
  public long getStreamDuration()
  {
    synchronized (this.ls)
    {
      long l = this.AW.getStreamDuration();
      return l;
    }
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(GoogleApiClient paramGoogleApiClient, MediaInfo paramMediaInfo)
  {
    return load(paramGoogleApiClient, paramMediaInfo, true, 0L, null);
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(GoogleApiClient paramGoogleApiClient, MediaInfo paramMediaInfo, boolean paramBoolean)
  {
    return load(paramGoogleApiClient, paramMediaInfo, paramBoolean, 0L, null);
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(GoogleApiClient paramGoogleApiClient, MediaInfo paramMediaInfo, boolean paramBoolean, long paramLong)
  {
    return load(paramGoogleApiClient, paramMediaInfo, paramBoolean, paramLong, null);
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(final GoogleApiClient paramGoogleApiClient, final MediaInfo paramMediaInfo, final boolean paramBoolean, final long paramLong, JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new i()
    {
      protected void a(gh arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.g, paramMediaInfo, paramBoolean, paramLong, this.e);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(a(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
          }
          return;
        }
      }
    });
  }
  
  public void onMessageReceived(CastDevice paramCastDevice, String paramString1, String paramString2)
  {
    this.AW.ai(paramString2);
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> pause(GoogleApiClient paramGoogleApiClient)
  {
    return pause(paramGoogleApiClient, null);
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> pause(final GoogleApiClient paramGoogleApiClient, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new i()
    {
      protected void a(gh arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.g, paramJSONObject);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(a(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> play(GoogleApiClient paramGoogleApiClient)
  {
    return play(paramGoogleApiClient, null);
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> play(final GoogleApiClient paramGoogleApiClient, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new i()
    {
      protected void a(gh arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).c(this.g, paramJSONObject);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(a(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> requestStatus(final GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.b(new i()
    {
      protected void a(gh arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.g);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(a(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> seek(GoogleApiClient paramGoogleApiClient, long paramLong)
  {
    return seek(paramGoogleApiClient, paramLong, 0, null);
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> seek(GoogleApiClient paramGoogleApiClient, long paramLong, int paramInt)
  {
    return seek(paramGoogleApiClient, paramLong, paramInt, null);
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> seek(final GoogleApiClient paramGoogleApiClient, final long paramLong, int paramInt, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new i()
    {
      protected void a(gh arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.g, paramLong, paramJSONObject, this.d);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(a(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> setActiveMediaTracks(final GoogleApiClient paramGoogleApiClient, final long[] paramArrayOfLong)
  {
    paramGoogleApiClient.b(new i()
    {
      protected void a(gh arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.g, paramArrayOfLong);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(a(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
          }
          return;
        }
      }
    });
  }
  
  public void setOnMetadataUpdatedListener(RemoteMediaPlayer.OnMetadataUpdatedListener paramOnMetadataUpdatedListener)
  {
    this.AY = paramOnMetadataUpdatedListener;
  }
  
  public void setOnStatusUpdatedListener(RemoteMediaPlayer.OnStatusUpdatedListener paramOnStatusUpdatedListener)
  {
    this.AZ = paramOnStatusUpdatedListener;
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamMute(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    return setStreamMute(paramGoogleApiClient, paramBoolean, null);
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamMute(final GoogleApiClient paramGoogleApiClient, final boolean paramBoolean, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new i()
    {
      protected void a(gh arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.g, paramBoolean, paramJSONObject);
          }
          catch (IllegalStateException localIllegalStateException)
          {
            for (;;)
            {
              b(a(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(a(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
            }
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamVolume(GoogleApiClient paramGoogleApiClient, double paramDouble)
  {
    return setStreamVolume(paramGoogleApiClient, paramDouble, null);
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamVolume(final GoogleApiClient paramGoogleApiClient, final double paramDouble, JSONObject paramJSONObject)
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    paramGoogleApiClient.b(new i()
    {
      protected void a(gh arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.g, paramDouble, this.c);
          }
          catch (IllegalStateException localIllegalStateException)
          {
            for (;;)
            {
              b(a(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;)
            {
              b(a(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(a(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
            }
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> setTextTrackStyle(final GoogleApiClient paramGoogleApiClient, final TextTrackStyle paramTextTrackStyle)
  {
    paramGoogleApiClient.b(new i()
    {
      protected void a(gh arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.g, paramTextTrackStyle);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(a(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> stop(GoogleApiClient paramGoogleApiClient)
  {
    return stop(paramGoogleApiClient, null);
  }
  
  public PendingResult<RemoteMediaPlayer.MediaChannelResult> stop(final GoogleApiClient paramGoogleApiClient, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new i()
    {
      protected void a(gh arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).b(this.g, paramJSONObject);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(a(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).a(null);
          }
          return;
        }
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/RemoteMediaPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
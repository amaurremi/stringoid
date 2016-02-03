package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.es;
import com.google.android.gms.internal.et;
import com.google.android.gms.internal.eu;
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
  private final Object li = new Object();
  private final es yE = new es()
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
  private final a yF = new a();
  private OnMetadataUpdatedListener yG;
  private OnStatusUpdatedListener yH;
  
  public RemoteMediaPlayer()
  {
    this.yE.a(this.yF);
  }
  
  private void onMetadataUpdated()
  {
    if (this.yG != null) {
      this.yG.onMetadataUpdated();
    }
  }
  
  private void onStatusUpdated()
  {
    if (this.yH != null) {
      this.yH.onStatusUpdated();
    }
  }
  
  public long getApproximateStreamPosition()
  {
    synchronized (this.li)
    {
      long l = this.yE.getApproximateStreamPosition();
      return l;
    }
  }
  
  public MediaInfo getMediaInfo()
  {
    synchronized (this.li)
    {
      MediaInfo localMediaInfo = this.yE.getMediaInfo();
      return localMediaInfo;
    }
  }
  
  public MediaStatus getMediaStatus()
  {
    synchronized (this.li)
    {
      MediaStatus localMediaStatus = this.yE.getMediaStatus();
      return localMediaStatus;
    }
  }
  
  public String getNamespace()
  {
    return this.yE.getNamespace();
  }
  
  public long getStreamDuration()
  {
    synchronized (this.li)
    {
      long l = this.yE.getStreamDuration();
      return l;
    }
  }
  
  public PendingResult<MediaChannelResult> load(GoogleApiClient paramGoogleApiClient, MediaInfo paramMediaInfo)
  {
    return load(paramGoogleApiClient, paramMediaInfo, true, 0L, null);
  }
  
  public PendingResult<MediaChannelResult> load(GoogleApiClient paramGoogleApiClient, MediaInfo paramMediaInfo, boolean paramBoolean)
  {
    return load(paramGoogleApiClient, paramMediaInfo, paramBoolean, 0L, null);
  }
  
  public PendingResult<MediaChannelResult> load(GoogleApiClient paramGoogleApiClient, MediaInfo paramMediaInfo, boolean paramBoolean, long paramLong)
  {
    return load(paramGoogleApiClient, paramMediaInfo, paramBoolean, paramLong, null);
  }
  
  public PendingResult<MediaChannelResult> load(final GoogleApiClient paramGoogleApiClient, final MediaInfo paramMediaInfo, final boolean paramBoolean, final long paramLong, JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(en arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.yW, paramMediaInfo, paramBoolean, paramLong, this.yN);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              a(j(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public void onMessageReceived(CastDevice paramCastDevice, String paramString1, String paramString2)
  {
    this.yE.U(paramString2);
  }
  
  public PendingResult<MediaChannelResult> pause(GoogleApiClient paramGoogleApiClient)
  {
    return pause(paramGoogleApiClient, null);
  }
  
  public PendingResult<MediaChannelResult> pause(final GoogleApiClient paramGoogleApiClient, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(en arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.yW, paramJSONObject);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              a(j(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<MediaChannelResult> play(GoogleApiClient paramGoogleApiClient)
  {
    return play(paramGoogleApiClient, null);
  }
  
  public PendingResult<MediaChannelResult> play(final GoogleApiClient paramGoogleApiClient, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(en arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).c(this.yW, paramJSONObject);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              a(j(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(en arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.yW);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              a(j(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<MediaChannelResult> seek(GoogleApiClient paramGoogleApiClient, long paramLong)
  {
    return seek(paramGoogleApiClient, paramLong, 0, null);
  }
  
  public PendingResult<MediaChannelResult> seek(GoogleApiClient paramGoogleApiClient, long paramLong, int paramInt)
  {
    return seek(paramGoogleApiClient, paramLong, paramInt, null);
  }
  
  public PendingResult<MediaChannelResult> seek(final GoogleApiClient paramGoogleApiClient, final long paramLong, int paramInt, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(en arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.yW, paramLong, paramJSONObject, this.yN);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              a(j(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener paramOnMetadataUpdatedListener)
  {
    this.yG = paramOnMetadataUpdatedListener;
  }
  
  public void setOnStatusUpdatedListener(OnStatusUpdatedListener paramOnStatusUpdatedListener)
  {
    this.yH = paramOnStatusUpdatedListener;
  }
  
  public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    return setStreamMute(paramGoogleApiClient, paramBoolean, null);
  }
  
  public PendingResult<MediaChannelResult> setStreamMute(final GoogleApiClient paramGoogleApiClient, final boolean paramBoolean, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(en arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.yW, paramBoolean, paramJSONObject);
          }
          catch (IllegalStateException localIllegalStateException)
          {
            for (;;)
            {
              a(j(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              a(j(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient paramGoogleApiClient, double paramDouble)
    throws IllegalArgumentException
  {
    return setStreamVolume(paramGoogleApiClient, paramDouble, null);
  }
  
  public PendingResult<MediaChannelResult> setStreamVolume(final GoogleApiClient paramGoogleApiClient, final double paramDouble, JSONObject paramJSONObject)
    throws IllegalArgumentException
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    paramGoogleApiClient.b(new b()
    {
      protected void a(en arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.yW, paramDouble, this.yN);
          }
          catch (IllegalStateException localIllegalStateException)
          {
            for (;;)
            {
              a(j(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;)
            {
              a(j(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              a(j(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<MediaChannelResult> stop(GoogleApiClient paramGoogleApiClient)
  {
    return stop(paramGoogleApiClient, null);
  }
  
  public PendingResult<MediaChannelResult> stop(final GoogleApiClient paramGoogleApiClient, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(en arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).b(this.yW, paramJSONObject);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              a(j(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public static abstract interface MediaChannelResult
    extends Result
  {}
  
  public static abstract interface OnMetadataUpdatedListener
  {
    public abstract void onMetadataUpdated();
  }
  
  public static abstract interface OnStatusUpdatedListener
  {
    public abstract void onStatusUpdated();
  }
  
  private class a
    implements et
  {
    private GoogleApiClient yS;
    private long yT = 0L;
    
    public a() {}
    
    public void a(String paramString1, String paramString2, long paramLong, String paramString3)
      throws IOException
    {
      if (this.yS == null) {
        throw new IOException("No GoogleApiClient available");
      }
      Cast.CastApi.sendMessage(this.yS, paramString1, paramString2).setResultCallback(new a(paramLong));
    }
    
    public void b(GoogleApiClient paramGoogleApiClient)
    {
      this.yS = paramGoogleApiClient;
    }
    
    public long dD()
    {
      long l = this.yT + 1L;
      this.yT = l;
      return l;
    }
    
    private final class a
      implements ResultCallback<Status>
    {
      private final long yU;
      
      a(long paramLong)
      {
        this.yU = paramLong;
      }
      
      public void i(Status paramStatus)
      {
        if (!paramStatus.isSuccess()) {
          RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.yU, paramStatus.getStatusCode());
        }
      }
    }
  }
  
  private static abstract class b
    extends Cast.a<RemoteMediaPlayer.MediaChannelResult>
  {
    eu yW = new eu()
    {
      public void a(long paramAnonymousLong, int paramAnonymousInt, JSONObject paramAnonymousJSONObject)
      {
        RemoteMediaPlayer.b.this.a(new RemoteMediaPlayer.c(new Status(paramAnonymousInt), paramAnonymousJSONObject));
      }
      
      public void l(long paramAnonymousLong)
      {
        RemoteMediaPlayer.b.this.a(RemoteMediaPlayer.b.this.j(new Status(4)));
      }
    };
    
    public RemoteMediaPlayer.MediaChannelResult j(final Status paramStatus)
    {
      new RemoteMediaPlayer.MediaChannelResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static final class c
    implements RemoteMediaPlayer.MediaChannelResult
  {
    private final Status wJ;
    private final JSONObject yn;
    
    c(Status paramStatus, JSONObject paramJSONObject)
    {
      this.wJ = paramStatus;
      this.yn = paramJSONObject;
    }
    
    public Status getStatus()
    {
      return this.wJ;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/cast/RemoteMediaPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gp;
import com.google.android.gms.internal.gq;
import com.google.android.gms.internal.gr;
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
  private final gp AT = new gp()
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
  private final a AU = new a();
  private OnMetadataUpdatedListener AV;
  private OnStatusUpdatedListener AW;
  private final Object lq = new Object();
  
  public RemoteMediaPlayer()
  {
    this.AT.a(this.AU);
  }
  
  private void onMetadataUpdated()
  {
    if (this.AV != null) {
      this.AV.onMetadataUpdated();
    }
  }
  
  private void onStatusUpdated()
  {
    if (this.AW != null) {
      this.AW.onStatusUpdated();
    }
  }
  
  public long getApproximateStreamPosition()
  {
    synchronized (this.lq)
    {
      long l = this.AT.getApproximateStreamPosition();
      return l;
    }
  }
  
  public MediaInfo getMediaInfo()
  {
    synchronized (this.lq)
    {
      MediaInfo localMediaInfo = this.AT.getMediaInfo();
      return localMediaInfo;
    }
  }
  
  public MediaStatus getMediaStatus()
  {
    synchronized (this.lq)
    {
      MediaStatus localMediaStatus = this.AT.getMediaStatus();
      return localMediaStatus;
    }
  }
  
  public String getNamespace()
  {
    return this.AT.getNamespace();
  }
  
  public long getStreamDuration()
  {
    synchronized (this.lq)
    {
      long l = this.AT.getStreamDuration();
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
      protected void a(gi arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.Bn, paramMediaInfo, paramBoolean, paramLong, this.Be);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(l(new Status(1)));
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
    this.AT.ai(paramString2);
  }
  
  public PendingResult<MediaChannelResult> pause(GoogleApiClient paramGoogleApiClient)
  {
    return pause(paramGoogleApiClient, null);
  }
  
  public PendingResult<MediaChannelResult> pause(final GoogleApiClient paramGoogleApiClient, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(gi arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.Bn, paramJSONObject);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(l(new Status(1)));
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
      protected void a(gi arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).c(this.Bn, paramJSONObject);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(l(new Status(1)));
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
      protected void a(gi arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.Bn);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(l(new Status(1)));
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
      protected void a(gi arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.Bn, paramLong, paramJSONObject, this.Be);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(l(new Status(1)));
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
  
  public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient paramGoogleApiClient, final long[] paramArrayOfLong)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(gi arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.Bn, paramArrayOfLong);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(l(new Status(1)));
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
    this.AV = paramOnMetadataUpdatedListener;
  }
  
  public void setOnStatusUpdatedListener(OnStatusUpdatedListener paramOnStatusUpdatedListener)
  {
    this.AW = paramOnStatusUpdatedListener;
  }
  
  public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    return setStreamMute(paramGoogleApiClient, paramBoolean, null);
  }
  
  public PendingResult<MediaChannelResult> setStreamMute(final GoogleApiClient paramGoogleApiClient, final boolean paramBoolean, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(gi arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.Bn, paramBoolean, paramJSONObject);
          }
          catch (IllegalStateException localIllegalStateException)
          {
            for (;;)
            {
              b(l(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(l(new Status(1)));
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
      protected void a(gi arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.Bn, paramDouble, this.Be);
          }
          catch (IllegalStateException localIllegalStateException)
          {
            for (;;)
            {
              b(l(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;)
            {
              b(l(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(l(new Status(1)));
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
  
  public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient paramGoogleApiClient, final TextTrackStyle paramTextTrackStyle)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(gi arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.Bn, paramTextTrackStyle);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(l(new Status(1)));
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
  
  public PendingResult<MediaChannelResult> stop(GoogleApiClient paramGoogleApiClient)
  {
    return stop(paramGoogleApiClient, null);
  }
  
  public PendingResult<MediaChannelResult> stop(final GoogleApiClient paramGoogleApiClient, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(gi arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).b(this.Bn, paramJSONObject);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(l(new Status(1)));
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
  {
    public abstract JSONObject getCustomData();
  }
  
  public static abstract interface OnMetadataUpdatedListener
  {
    public abstract void onMetadataUpdated();
  }
  
  public static abstract interface OnStatusUpdatedListener
  {
    public abstract void onStatusUpdated();
  }
  
  private class a
    implements gq
  {
    private GoogleApiClient Bj;
    private long Bk = 0L;
    
    public a() {}
    
    public void a(String paramString1, String paramString2, long paramLong, String paramString3)
      throws IOException
    {
      if (this.Bj == null) {
        throw new IOException("No GoogleApiClient available");
      }
      Cast.CastApi.sendMessage(this.Bj, paramString1, paramString2).setResultCallback(new a(paramLong));
    }
    
    public void b(GoogleApiClient paramGoogleApiClient)
    {
      this.Bj = paramGoogleApiClient;
    }
    
    public long dW()
    {
      long l = this.Bk + 1L;
      this.Bk = l;
      return l;
    }
    
    private final class a
      implements ResultCallback<Status>
    {
      private final long Bl;
      
      a(long paramLong)
      {
        this.Bl = paramLong;
      }
      
      public void k(Status paramStatus)
      {
        if (!paramStatus.isSuccess()) {
          RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.Bl, paramStatus.getStatusCode());
        }
      }
    }
  }
  
  private static abstract class b
    extends Cast.a<RemoteMediaPlayer.MediaChannelResult>
  {
    gr Bn = new gr()
    {
      public void a(long paramAnonymousLong, int paramAnonymousInt, JSONObject paramAnonymousJSONObject)
      {
        RemoteMediaPlayer.b.this.b(new RemoteMediaPlayer.c(new Status(paramAnonymousInt), paramAnonymousJSONObject));
      }
      
      public void n(long paramAnonymousLong)
      {
        RemoteMediaPlayer.b.this.b(RemoteMediaPlayer.b.this.l(new Status(4)));
      }
    };
    
    public RemoteMediaPlayer.MediaChannelResult l(final Status paramStatus)
    {
      new RemoteMediaPlayer.MediaChannelResult()
      {
        public JSONObject getCustomData()
        {
          return null;
        }
        
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
    private final JSONObject Ax;
    private final Status yw;
    
    c(Status paramStatus, JSONObject paramJSONObject)
    {
      this.yw = paramStatus;
      this.Ax = paramJSONObject;
    }
    
    public JSONObject getCustomData()
    {
      return this.Ax;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/cast/RemoteMediaPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
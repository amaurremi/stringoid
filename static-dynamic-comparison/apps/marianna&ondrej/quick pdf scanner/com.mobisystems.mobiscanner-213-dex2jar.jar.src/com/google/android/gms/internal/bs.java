package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class bs
  extends FrameLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private final dd CB;
  private final MediaController CZ;
  private final a Da;
  private final VideoView Db;
  private long Dc;
  private String Dd;
  
  public bs(Context paramContext, dd paramdd)
  {
    super(paramContext);
    this.CB = paramdd;
    this.Db = new VideoView(paramContext);
    paramdd = new FrameLayout.LayoutParams(-1, -1, 17);
    addView(this.Db, paramdd);
    this.CZ = new MediaController(paramContext);
    this.Da = new a(this);
    this.Da.pw();
    this.Db.setOnCompletionListener(this);
    this.Db.setOnPreparedListener(this);
    this.Db.setOnErrorListener(this);
  }
  
  private static void a(dd paramdd, String paramString)
  {
    a(paramdd, paramString, new HashMap(1));
  }
  
  public static void a(dd paramdd, String paramString1, String paramString2)
  {
    int i;
    if (paramString2 == null)
    {
      i = 1;
      if (i == 0) {
        break label60;
      }
    }
    label60:
    for (int j = 2;; j = 3)
    {
      HashMap localHashMap = new HashMap(j);
      localHashMap.put("what", paramString1);
      if (i == 0) {
        localHashMap.put("extra", paramString2);
      }
      a(paramdd, "error", localHashMap);
      return;
      i = 0;
      break;
    }
  }
  
  private static void a(dd paramdd, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put(paramString2, paramString3);
    a(paramdd, paramString1, localHashMap);
  }
  
  private static void a(dd paramdd, String paramString, Map<String, String> paramMap)
  {
    paramMap.put("event", paramString);
    paramdd.a("onVideoEvent", paramMap);
  }
  
  public void aC(String paramString)
  {
    this.Dd = paramString;
  }
  
  public void destroy()
  {
    this.Da.cancel();
    this.Db.stopPlayback();
  }
  
  public void h(MotionEvent paramMotionEvent)
  {
    this.Db.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    a(this.CB, "ended");
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    a(this.CB, String.valueOf(paramInt1), String.valueOf(paramInt2));
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    float f = this.Db.getDuration() / 1000.0F;
    a(this.CB, "canplaythrough", "duration", String.valueOf(f));
  }
  
  public void pause()
  {
    this.Db.pause();
  }
  
  public void play()
  {
    this.Db.start();
  }
  
  public void pu()
  {
    if (!TextUtils.isEmpty(this.Dd))
    {
      this.Db.setVideoPath(this.Dd);
      return;
    }
    a(this.CB, "no_src", null);
  }
  
  public void pv()
  {
    long l = this.Db.getCurrentPosition();
    if (this.Dc != l)
    {
      float f = (float)l / 1000.0F;
      a(this.CB, "timeupdate", "time", String.valueOf(f));
      this.Dc = l;
    }
  }
  
  public void seekTo(int paramInt)
  {
    this.Db.seekTo(paramInt);
  }
  
  public void z(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.Db.setMediaController(this.CZ);
      return;
    }
    this.CZ.hide();
    this.Db.setMediaController(null);
  }
  
  private static final class a
  {
    private final Runnable De;
    private volatile boolean Df = false;
    
    public a(final bs parambs)
    {
      this.De = new Runnable()
      {
        private final WeakReference<bs> Dg = new WeakReference(parambs);
        
        public void run()
        {
          bs localbs = (bs)this.Dg.get();
          if ((!bs.a.a(bs.a.this)) && (localbs != null))
          {
            localbs.pv();
            bs.a.this.pw();
          }
        }
      };
    }
    
    public void cancel()
    {
      this.Df = true;
      cb.Fw.removeCallbacks(this.De);
    }
    
    public void pw()
    {
      cb.Fw.postDelayed(this.De, 250L);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
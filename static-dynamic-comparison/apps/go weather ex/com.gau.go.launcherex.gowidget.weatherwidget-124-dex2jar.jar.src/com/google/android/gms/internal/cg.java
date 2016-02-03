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

public final class cg
  extends FrameLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private final dz lC;
  private final MediaController os;
  private final a ot;
  private final VideoView ou;
  private long ov;
  private String ow;
  
  public cg(Context paramContext, dz paramdz)
  {
    super(paramContext);
    this.lC = paramdz;
    this.ou = new VideoView(paramContext);
    paramdz = new FrameLayout.LayoutParams(-1, -1, 17);
    addView(this.ou, paramdz);
    this.os = new MediaController(paramContext);
    this.ot = new a(this);
    this.ot.aW();
    this.ou.setOnCompletionListener(this);
    this.ou.setOnPreparedListener(this);
    this.ou.setOnErrorListener(this);
  }
  
  private static void a(dz paramdz, String paramString)
  {
    a(paramdz, paramString, new HashMap(1));
  }
  
  public static void a(dz paramdz, String paramString1, String paramString2)
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
      a(paramdz, "error", localHashMap);
      return;
      i = 0;
      break;
    }
  }
  
  private static void a(dz paramdz, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put(paramString2, paramString3);
    a(paramdz, paramString1, localHashMap);
  }
  
  private static void a(dz paramdz, String paramString, Map<String, String> paramMap)
  {
    paramMap.put("event", paramString);
    paramdz.a("onVideoEvent", paramMap);
  }
  
  public void aU()
  {
    if (!TextUtils.isEmpty(this.ow))
    {
      this.ou.setVideoPath(this.ow);
      return;
    }
    a(this.lC, "no_src", null);
  }
  
  public void aV()
  {
    long l = this.ou.getCurrentPosition();
    if (this.ov != l)
    {
      float f = (float)l / 1000.0F;
      a(this.lC, "timeupdate", "time", String.valueOf(f));
      this.ov = l;
    }
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    this.ou.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void destroy()
  {
    this.ot.cancel();
    this.ou.stopPlayback();
  }
  
  public void k(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ou.setMediaController(this.os);
      return;
    }
    this.os.hide();
    this.ou.setMediaController(null);
  }
  
  public void o(String paramString)
  {
    this.ow = paramString;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    a(this.lC, "ended");
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    a(this.lC, String.valueOf(paramInt1), String.valueOf(paramInt2));
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    float f = this.ou.getDuration() / 1000.0F;
    a(this.lC, "canplaythrough", "duration", String.valueOf(f));
  }
  
  public void pause()
  {
    this.ou.pause();
  }
  
  public void play()
  {
    this.ou.start();
  }
  
  public void seekTo(int paramInt)
  {
    this.ou.seekTo(paramInt);
  }
  
  private static final class a
  {
    private final Runnable kW;
    private volatile boolean ox = false;
    
    public a(final cg paramcg)
    {
      this.kW = new Runnable()
      {
        private final WeakReference<cg> oy = new WeakReference(paramcg);
        
        public void run()
        {
          cg localcg = (cg)this.oy.get();
          if ((!cg.a.a(cg.a.this)) && (localcg != null))
          {
            localcg.aV();
            cg.a.this.aW();
          }
        }
      };
    }
    
    public void aW()
    {
      dv.rp.postDelayed(this.kW, 250L);
    }
    
    public void cancel()
    {
      this.ox = true;
      dv.rp.removeCallbacks(this.kW);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
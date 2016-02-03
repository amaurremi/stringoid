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

public final class bo
  extends FrameLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private final MediaController gQ;
  private final a gR;
  private final VideoView gS;
  private long gT;
  private String gU;
  private final cw gv;
  
  public bo(Context paramContext, cw paramcw)
  {
    super(paramContext);
    this.gv = paramcw;
    this.gS = new VideoView(paramContext);
    paramcw = new FrameLayout.LayoutParams(-1, -1, 17);
    addView(this.gS, paramcw);
    this.gQ = new MediaController(paramContext);
    this.gR = new a(this);
    this.gR.ah();
    this.gS.setOnCompletionListener(this);
    this.gS.setOnPreparedListener(this);
    this.gS.setOnErrorListener(this);
  }
  
  private static void a(cw paramcw, String paramString)
  {
    a(paramcw, paramString, new HashMap(1));
  }
  
  public static void a(cw paramcw, String paramString1, String paramString2)
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
      a(paramcw, "error", localHashMap);
      return;
      i = 0;
      break;
    }
  }
  
  private static void a(cw paramcw, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put(paramString2, paramString3);
    a(paramcw, paramString1, localHashMap);
  }
  
  private static void a(cw paramcw, String paramString, Map<String, String> paramMap)
  {
    paramMap.put("event", paramString);
    paramcw.a("onVideoEvent", paramMap);
  }
  
  public void af()
  {
    if (!TextUtils.isEmpty(this.gU))
    {
      this.gS.setVideoPath(this.gU);
      return;
    }
    a(this.gv, "no_src", null);
  }
  
  public void ag()
  {
    long l = this.gS.getCurrentPosition();
    if (this.gT != l)
    {
      float f = (float)l / 1000.0F;
      a(this.gv, "timeupdate", "time", String.valueOf(f));
      this.gT = l;
    }
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    this.gS.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void destroy()
  {
    this.gR.cancel();
    this.gS.stopPlayback();
  }
  
  public void i(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.gS.setMediaController(this.gQ);
      return;
    }
    this.gQ.hide();
    this.gS.setMediaController(null);
  }
  
  public void n(String paramString)
  {
    this.gU = paramString;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    a(this.gv, "ended");
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    a(this.gv, String.valueOf(paramInt1), String.valueOf(paramInt2));
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    float f = this.gS.getDuration() / 1000.0F;
    a(this.gv, "canplaythrough", "duration", String.valueOf(f));
  }
  
  public void pause()
  {
    this.gS.pause();
  }
  
  public void play()
  {
    this.gS.start();
  }
  
  public void seekTo(int paramInt)
  {
    this.gS.seekTo(paramInt);
  }
  
  private static final class a
  {
    private final Runnable ep;
    private volatile boolean gV = false;
    
    public a(final bo parambo)
    {
      this.ep = new Runnable()
      {
        private final WeakReference<bo> gW = new WeakReference(parambo);
        
        public void run()
        {
          bo localbo = (bo)this.gW.get();
          if ((!bo.a.a(bo.a.this)) && (localbo != null))
          {
            localbo.ag();
            bo.a.this.ah();
          }
        }
      };
    }
    
    public void ah()
    {
      cs.iI.postDelayed(this.ep, 250L);
    }
    
    public void cancel()
    {
      this.gV = true;
      cs.iI.removeCallbacks(this.ep);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
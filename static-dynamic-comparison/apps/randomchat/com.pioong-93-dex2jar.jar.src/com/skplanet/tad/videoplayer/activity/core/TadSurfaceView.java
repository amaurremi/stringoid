package com.skplanet.tad.videoplayer.activity.core;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.skplanet.tad.videoplayer.util.b;

public class TadSurfaceView
  extends SurfaceView
{
  public MediaPlayer a = null;
  public int b = -1;
  public int c = -1;
  
  public TadSurfaceView(Context paramContext)
  {
    super(paramContext);
    setWillNotCacheDrawing(true);
    setWillNotDraw(false);
  }
  
  public TadSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotCacheDrawing(true);
    setWillNotDraw(false);
  }
  
  public TadSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotCacheDrawing(true);
    setWillNotDraw(false);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    b.a("onSizeChanged");
    b.a("w : " + paramInt1 + "/ h : " + paramInt2 + "/ oldw : " + paramInt3 + "/ oldh : " + paramInt4);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    SurfaceHolder localSurfaceHolder = getHolder();
    if (paramInt2 > 160) {
      localSurfaceHolder.setSizeFromLayout();
    }
    for (;;)
    {
      invalidate();
      return;
      localSurfaceHolder.setFixedSize(paramInt1 / 2, paramInt2 / 2);
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    b.a("setBackgroundColor(int color = " + paramInt);
    if (this.c == paramInt) {
      return;
    }
    this.c = paramInt;
    if (paramInt == 0)
    {
      super.setBackgroundDrawable(null);
      return;
    }
    super.setBackgroundColor(paramInt);
  }
  
  public void setMediaPlayer(MediaPlayer paramMediaPlayer)
  {
    b.a("TadSurfaceView--setMediaPlayer");
    if ((this.b == 0) || (this.b == -16777216))
    {
      Log.d("xxxxx", "TadSurfaceView--setMediaPlayer_");
      setBackgroundColor(0);
      this.b = 0;
      invalidate();
    }
    this.a = paramMediaPlayer;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/videoplayer/activity/core/TadSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
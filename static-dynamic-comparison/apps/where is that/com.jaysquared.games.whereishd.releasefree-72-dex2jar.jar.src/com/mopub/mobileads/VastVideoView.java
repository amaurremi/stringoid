package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.common.MoPubBrowser;
import com.mopub.mobileads.util.HttpUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class VastVideoView
  extends BaseVideoView
{
  public static final int DEFAULT_VIDEO_DURATION_FOR_CLOSE_BUTTON = 5000;
  private static final float FIRST_QUARTER_MARKER = 0.25F;
  public static final int MAX_VIDEO_DURATION_FOR_CLOSE_BUTTON = 16000;
  private static final float MID_POINT_MARKER = 0.5F;
  private static final float THIRD_QUARTER_MARKER = 0.75F;
  static final String VIDEO_CLICK_THROUGH_TRACKERS = "video_click_through_trackers";
  static final String VIDEO_CLICK_THROUGH_URL = "video_click_through_url";
  static final String VIDEO_COMPLETE_TRACKERS = "video_complete_trackers";
  static final String VIDEO_FIRST_QUARTER_TRACKERS = "video_first_quarter_trackers";
  static final String VIDEO_IMPRESSION_TRACKERS = "video_impression_trackers";
  static final String VIDEO_MID_POINT_TRACKERS = "video_mid_point_trackers";
  private static final long VIDEO_PROGRESS_TIMER_CHECKER_DELAY = 50L;
  static final String VIDEO_START_TRACKERS = "video_start_trackers";
  static final String VIDEO_THIRD_QUARTER_TRACKERS = "video_third_quarter_trackers";
  private static final ThreadPoolExecutor sThreadPoolExecutor = new ThreadPoolExecutor(10, 50, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final BaseVideoView.BaseVideoViewListener mBaseVideoViewListener;
  private ArrayList<String> mClickThroughTrackers;
  private String mClickThroughUrl;
  private ArrayList<String> mCompletionTrackers;
  private ArrayList<String> mFirstQuarterTrackers;
  private Handler mHandler;
  private ArrayList<String> mImpressionTrackers;
  private boolean mIsFirstMarkHit;
  private boolean mIsSecondMarkHit;
  private boolean mIsThirdMarkHit;
  private boolean mIsVideoFinishedPlaying;
  private boolean mIsVideoProgressShouldBeChecked;
  private ArrayList<String> mMidPointTrackers;
  private int mSeekerPositionOnPause;
  private int mShowCloseButtonDelay = 5000;
  private boolean mShowCloseButtonEventFired;
  private ArrayList<String> mThirdQuarterTrackers;
  private Runnable mVideoProgressCheckerRunnable;
  private ArrayList<String> mVideoStartTrackers;
  private String mVideoUrl;
  
  public VastVideoView(final Context paramContext, Intent paramIntent, final BaseVideoView.BaseVideoViewListener paramBaseVideoViewListener)
  {
    super(paramContext);
    this.mBaseVideoViewListener = paramBaseVideoViewListener;
    this.mHandler = new Handler();
    this.mIsVideoProgressShouldBeChecked = true;
    this.mSeekerPositionOnPause = -1;
    this.mVideoUrl = paramIntent.getStringExtra("video_url");
    this.mVideoStartTrackers = paramIntent.getStringArrayListExtra("video_start_trackers");
    this.mFirstQuarterTrackers = paramIntent.getStringArrayListExtra("video_first_quarter_trackers");
    this.mMidPointTrackers = paramIntent.getStringArrayListExtra("video_mid_point_trackers");
    this.mThirdQuarterTrackers = paramIntent.getStringArrayListExtra("video_third_quarter_trackers");
    this.mCompletionTrackers = paramIntent.getStringArrayListExtra("video_complete_trackers");
    this.mImpressionTrackers = paramIntent.getStringArrayListExtra("video_impression_trackers");
    this.mClickThroughUrl = paramIntent.getStringExtra("video_click_through_url");
    this.mClickThroughTrackers = paramIntent.getStringArrayListExtra("video_click_through_trackers");
    setOnPreparedListener(new MediaPlayer.OnPreparedListener()
    {
      public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        if (VastVideoView.this.getDuration() < 16000) {
          VastVideoView.access$002(VastVideoView.this, VastVideoView.this.getDuration());
        }
      }
    });
    setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if ((paramAnonymousMotionEvent.getAction() == 1) && (VastVideoView.this.shouldAllowClickThrough()))
        {
          VastVideoView.this.pingOnBackgroundThread(VastVideoView.this.mClickThroughTrackers);
          if (VastVideoView.this.mBaseVideoViewListener != null) {
            VastVideoView.this.mBaseVideoViewListener.videoClicked();
          }
          paramAnonymousView = new Intent(paramContext, MoPubBrowser.class);
          paramAnonymousView.addFlags(268435456);
          paramAnonymousView.putExtra("URL", VastVideoView.this.mClickThroughUrl);
          paramContext.startActivity(paramAnonymousView);
        }
        return true;
      }
    });
    setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        VastVideoView.this.stopProgressChecker();
        VastVideoView.this.fireShowCloseButtonEvent();
        if (VastVideoView.this.mBaseVideoViewListener != null) {
          VastVideoView.this.mBaseVideoViewListener.videoCompleted(false);
        }
        VastVideoView.this.pingOnBackgroundThread(VastVideoView.this.mCompletionTrackers);
        VastVideoView.access$902(VastVideoView.this, true);
      }
    });
    setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        VastVideoView.this.stopProgressChecker();
        if (paramBaseVideoViewListener != null) {
          paramBaseVideoViewListener.videoError(false);
        }
        return false;
      }
    });
    this.mVideoProgressCheckerRunnable = new Runnable()
    {
      public void run()
      {
        float f = VastVideoView.this.getDuration();
        if (f > 0.0F)
        {
          f = VastVideoView.this.getCurrentPosition() / f;
          if ((f > 0.25F) && (!VastVideoView.this.mIsFirstMarkHit))
          {
            VastVideoView.access$1002(VastVideoView.this, true);
            VastVideoView.this.pingOnBackgroundThread(VastVideoView.this.mFirstQuarterTrackers);
          }
          if ((f > 0.5F) && (!VastVideoView.this.mIsSecondMarkHit))
          {
            VastVideoView.access$1202(VastVideoView.this, true);
            VastVideoView.this.pingOnBackgroundThread(VastVideoView.this.mMidPointTrackers);
          }
          if ((f > 0.75F) && (!VastVideoView.this.mIsThirdMarkHit))
          {
            VastVideoView.access$1402(VastVideoView.this, true);
            VastVideoView.this.pingOnBackgroundThread(VastVideoView.this.mThirdQuarterTrackers);
          }
          if (VastVideoView.this.shouldShowCloseButton()) {
            VastVideoView.this.fireShowCloseButtonEvent();
          }
        }
        if (VastVideoView.this.mIsVideoProgressShouldBeChecked) {
          VastVideoView.this.mHandler.postDelayed(VastVideoView.this.mVideoProgressCheckerRunnable, 50L);
        }
      }
    };
    setVideoPath(this.mVideoUrl);
    requestFocus();
    pingOnBackgroundThread(this.mVideoStartTrackers);
    pingOnBackgroundThread(this.mImpressionTrackers);
    this.mHandler.post(this.mVideoProgressCheckerRunnable);
  }
  
  private void fireShowCloseButtonEvent()
  {
    this.mShowCloseButtonEventFired = true;
    if (this.mBaseVideoViewListener != null) {
      this.mBaseVideoViewListener.showCloseButton();
    }
  }
  
  private void pingOnBackgroundThread(List<String> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        final String str = (String)paramList.next();
        sThreadPoolExecutor.execute(new Runnable()
        {
          public void run()
          {
            try
            {
              HttpUtils.ping(str);
              return;
            }
            catch (Exception localException)
            {
              Log.d("MoPub", "Unable to track video impression url: " + str);
            }
          }
        });
      }
    }
  }
  
  private boolean shouldAllowClickThrough()
  {
    return this.mShowCloseButtonEventFired;
  }
  
  private boolean shouldShowCloseButton()
  {
    return (!this.mShowCloseButtonEventFired) && (getCurrentPosition() > this.mShowCloseButtonDelay);
  }
  
  private void stopProgressChecker()
  {
    this.mIsVideoProgressShouldBeChecked = false;
    this.mHandler.removeCallbacks(this.mVideoProgressCheckerRunnable);
  }
  
  @Deprecated
  int getShowCloseButtonDelay()
  {
    return this.mShowCloseButtonDelay;
  }
  
  protected void onPause()
  {
    super.onPause();
    stopProgressChecker();
    this.mSeekerPositionOnPause = getCurrentPosition();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mIsVideoProgressShouldBeChecked = true;
    this.mHandler.post(this.mVideoProgressCheckerRunnable);
    seekTo(this.mSeekerPositionOnPause);
    if (!this.mIsVideoFinishedPlaying) {
      start();
    }
  }
  
  @Deprecated
  void setCloseButtonVisible(boolean paramBoolean)
  {
    this.mShowCloseButtonEventFired = paramBoolean;
  }
  
  @Deprecated
  void setIsVideoProgressShouldBeChecked(boolean paramBoolean)
  {
    this.mIsVideoProgressShouldBeChecked = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/VastVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tapjoy;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.VideoView;
import java.util.Timer;
import java.util.TimerTask;

public class TapjoyVideoView
  extends Activity
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static final String BUNDLE_DIALOG_SHOWING = "dialog_showing";
  private static final String BUNDLE_SEEK_TIME = "seek_time";
  private static final int DIALOG_WARNING_ID = 0;
  private static final String TAG = "VideoView";
  private static boolean streamingVideo = false;
  static int textSize = 16;
  private static TapjoyVideoObject videoData;
  private static boolean videoError = false;
  private static final String videoSecondsText = " seconds";
  private static final String videoWillResumeText = "";
  private boolean allowBackKey = false;
  private String cancelMessage = "Currency will not be awarded, are you sure you want to cancel the video?";
  private boolean clickRequestSuccess = false;
  Dialog dialog;
  private boolean dialogShowing = false;
  final Handler mHandler = new Handler();
  final Runnable mUpdateResults = new Runnable()
  {
    public void run()
    {
      TapjoyVideoView.this.overlayText.setText("" + TapjoyVideoView.this.getRemainingVideoTime() + " seconds");
    }
  };
  private TextView overlayText = null;
  private RelativeLayout relativeLayout;
  private int seekTime = 0;
  private boolean sendClick = false;
  private boolean shouldDismiss = false;
  private ImageView tapjoyImage;
  private int timeRemaining = 0;
  Timer timer = null;
  private String videoURL = null;
  private VideoView videoView = null;
  private Bitmap watermark;
  private String webviewURL = null;
  
  private void finishWithResult(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("result", paramBoolean);
    localIntent.putExtra("callback_id", getIntent().getStringExtra("callback_id"));
    setResult(-1, localIntent);
    finish();
  }
  
  private int getRemainingVideoTime()
  {
    int j = (this.videoView.getDuration() - this.videoView.getCurrentPosition()) / 1000;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return i;
  }
  
  private void initVideoView()
  {
    this.relativeLayout.removeAllViews();
    this.relativeLayout.setBackgroundColor(-16777216);
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.videoView == null) && (this.overlayText == null))
    {
      this.tapjoyImage = new ImageView(this);
      this.watermark = TapjoyVideo.getWatermarkImage();
      if (this.watermark != null) {
        this.tapjoyImage.setImageBitmap(this.watermark);
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(11);
      this.tapjoyImage.setLayoutParams(localLayoutParams);
      this.videoView = new VideoView(this);
      this.videoView.setOnCompletionListener(this);
      this.videoView.setOnErrorListener(this);
      this.videoView.setOnPreparedListener(this);
      if (!streamingVideo) {
        break label384;
      }
      TapjoyLog.i("VideoView", "streaming video: " + this.videoURL);
      this.videoView.setVideoURI(Uri.parse(this.videoURL));
    }
    for (;;)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      this.videoView.setLayoutParams(localLayoutParams);
      this.timeRemaining = (this.videoView.getDuration() / 1000);
      TapjoyLog.i("VideoView", "videoView.getDuration(): " + this.videoView.getDuration());
      TapjoyLog.i("VideoView", "timeRemaining: " + this.timeRemaining);
      this.overlayText = new TextView(this);
      this.overlayText.setTextSize(textSize);
      this.overlayText.setTypeface(Typeface.create("default", 1), 1);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(12);
      this.overlayText.setLayoutParams(localLayoutParams);
      startVideo();
      this.relativeLayout.addView(this.videoView);
      this.relativeLayout.addView(this.tapjoyImage);
      this.relativeLayout.addView(this.overlayText);
      return;
      label384:
      TapjoyLog.i("VideoView", "cached video: " + this.videoURL);
      this.videoView.setVideoPath(this.videoURL);
    }
  }
  
  private void showVideoCompletionScreen()
  {
    if (this.shouldDismiss)
    {
      finishWithResult(true);
      return;
    }
    Intent localIntent = new Intent(this, TJAdUnitView.class);
    localIntent.putExtra("view_type", 4);
    localIntent.putExtra("url", this.webviewURL);
    localIntent.putExtra("legacy_view", true);
    startActivityForResult(localIntent, 0);
  }
  
  private void startVideo()
  {
    this.videoView.requestFocus();
    if (this.dialogShowing)
    {
      this.videoView.seekTo(this.seekTime);
      TapjoyLog.i("VideoView", "dialog is showing -- don't start");
    }
    for (;;)
    {
      if (this.timer != null) {
        this.timer.cancel();
      }
      this.timer = new Timer();
      this.timer.schedule(new RemainingTime(null), 500L, 100L);
      this.clickRequestSuccess = false;
      if (this.sendClick)
      {
        new Thread(new Runnable()
        {
          public void run()
          {
            TapjoyLog.i("VideoView", "SENDING CLICK...");
            TapjoyHttpURLResponse localTapjoyHttpURLResponse = new TapjoyURLConnection().getResponseFromURL(TapjoyVideoView.videoData.clickURL);
            if ((localTapjoyHttpURLResponse.response != null) && (localTapjoyHttpURLResponse.response.contains("OK")))
            {
              TapjoyLog.i("VideoView", "CLICK REQUEST SUCCESS!");
              TapjoyVideoView.access$202(TapjoyVideoView.this, true);
            }
          }
        }).start();
        this.sendClick = false;
      }
      return;
      TapjoyLog.i("VideoView", "start");
      this.videoView.seekTo(0);
      this.videoView.start();
      TapjoyVideo.videoNotifierStart();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    TapjoyLog.i("VideoView", "onActivityResult requestCode:" + paramInt1 + ", resultCode: " + paramInt2);
    Bundle localBundle = null;
    if (paramIntent != null) {
      localBundle = paramIntent.getExtras();
    }
    if (localBundle != null)
    {
      paramIntent = localBundle.getString("result");
      if ((paramIntent != null) && (paramIntent.length() != 0) && (!paramIntent.equals("offer_wall"))) {
        break label100;
      }
      finishWithResult(true);
    }
    label100:
    while (!paramIntent.equals("tjvideo"))
    {
      return;
      paramIntent = null;
      break;
    }
    initVideoView();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    TapjoyLog.i("VideoView", "onCompletion");
    if (this.timer != null) {
      this.timer.cancel();
    }
    showVideoCompletionScreen();
    if (!videoError)
    {
      TapjoyVideo.videoNotifierComplete();
      new Thread(new Runnable()
      {
        public void run()
        {
          if (TapjoyVideoView.this.clickRequestSuccess) {
            TapjoyConnectCore.getInstance().actionComplete(TapjoyVideoView.videoData.offerID);
          }
        }
      }).start();
    }
    videoError = false;
    this.allowBackKey = true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    TapjoyLog.i("VideoView", "onCreate");
    super.onCreate(paramBundle);
    TapjoyConnectCore.viewWillOpen(3);
    if (paramBundle != null)
    {
      TapjoyLog.i("VideoView", "*** Loading saved data from bundle ***");
      this.seekTime = paramBundle.getInt("seek_time");
      this.dialogShowing = paramBundle.getBoolean("dialog_showing");
    }
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      videoData = (TapjoyVideoObject)paramBundle.getSerializable("VIDEO_DATA");
      this.videoURL = paramBundle.getString("VIDEO_URL");
      if (paramBundle.containsKey("VIDEO_CANCEL_MESSAGE")) {
        this.cancelMessage = paramBundle.getString("VIDEO_CANCEL_MESSAGE");
      }
      if (paramBundle.containsKey("VIDEO_SHOULD_DISMISS")) {
        this.shouldDismiss = paramBundle.getBoolean("VIDEO_SHOULD_DISMISS");
      }
    }
    TapjoyLog.i("VideoView", "dialogShowing: " + this.dialogShowing + ", seekTime: " + this.seekTime);
    if (videoData != null)
    {
      this.sendClick = true;
      streamingVideo = false;
      if (TapjoyVideo.getInstance() == null)
      {
        TapjoyLog.i("VideoView", "null video");
        finishWithResult(false);
        return;
      }
      this.videoURL = videoData.dataLocation;
      this.webviewURL = videoData.webviewURL;
      if ((this.videoURL == null) || (this.videoURL.length() == 0))
      {
        TapjoyLog.i("VideoView", "no cached video, try streaming video at location: " + videoData.videoURL);
        this.videoURL = videoData.videoURL;
        streamingVideo = true;
      }
      TapjoyLog.i("VideoView", "videoPath: " + this.videoURL);
    }
    for (;;)
    {
      requestWindowFeature(1);
      this.relativeLayout = new RelativeLayout(this);
      paramBundle = new RelativeLayout.LayoutParams(-1, -1);
      this.relativeLayout.setLayoutParams(paramBundle);
      setContentView(this.relativeLayout);
      if (Build.VERSION.SDK_INT > 3)
      {
        int i = new TapjoyDisplayMetricsUtil(this).getScreenLayoutSize();
        TapjoyLog.i("VideoView", "deviceScreenLayoutSize: " + i);
        if (i == 4) {
          textSize = 32;
        }
      }
      initVideoView();
      TapjoyLog.i("VideoView", "onCreate DONE");
      TapjoyConnectCore.viewDidOpen(3);
      return;
      if (this.videoURL != null)
      {
        streamingVideo = true;
        this.sendClick = false;
        TapjoyLog.i("VideoView", "playing video only: " + this.videoURL);
      }
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    TapjoyLog.i("VideoView", "dialog onCreateDialog");
    if (!this.dialogShowing) {
      return this.dialog;
    }
    switch (paramInt)
    {
    default: 
      this.dialog = null;
    }
    for (;;)
    {
      return this.dialog;
      this.dialog = new AlertDialog.Builder(this).setTitle("Cancel Video?").setMessage(this.cancelMessage).setNegativeButton("End", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          TapjoyVideoView.this.finishWithResult(false);
        }
      }).setPositiveButton("Resume", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.dismiss();
          TapjoyVideoView.this.videoView.seekTo(TapjoyVideoView.this.seekTime);
          TapjoyVideoView.this.videoView.start();
          TapjoyVideoView.access$702(TapjoyVideoView.this, false);
          TapjoyLog.i("VideoView", "RESUME VIDEO time: " + TapjoyVideoView.this.seekTime);
          TapjoyLog.i("VideoView", "currentPosition: " + TapjoyVideoView.this.videoView.getCurrentPosition());
          TapjoyLog.i("VideoView", "duration: " + TapjoyVideoView.this.videoView.getDuration() + ", elapsed: " + (TapjoyVideoView.this.videoView.getDuration() - TapjoyVideoView.this.videoView.getCurrentPosition()));
        }
      }).create();
      this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          TapjoyLog.i("VideoView", "dialog onCancel");
          paramAnonymousDialogInterface.dismiss();
          TapjoyVideoView.this.videoView.seekTo(TapjoyVideoView.this.seekTime);
          TapjoyVideoView.this.videoView.start();
          TapjoyVideoView.access$702(TapjoyVideoView.this, false);
        }
      });
      this.dialog.show();
      this.dialogShowing = true;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (isFinishing())
    {
      TapjoyConnectCore.viewWillClose(3);
      TapjoyConnectCore.viewDidClose(3);
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    videoError = true;
    TapjoyLog.i("VideoView", "onError");
    TapjoyVideo.videoNotifierError(3);
    this.allowBackKey = true;
    if (this.timer != null) {
      this.timer.cancel();
    }
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((!this.allowBackKey) && (this.cancelMessage != null) && (this.cancelMessage.length() > 0))
      {
        this.seekTime = this.videoView.getCurrentPosition();
        this.videoView.pause();
        this.dialogShowing = true;
        showDialog(0);
        TapjoyLog.i("VideoView", "PAUSE VIDEO time: " + this.seekTime);
        TapjoyLog.i("VideoView", "currentPosition: " + this.videoView.getCurrentPosition());
        TapjoyLog.i("VideoView", "duration: " + this.videoView.getDuration() + ", elapsed: " + (this.videoView.getDuration() - this.videoView.getCurrentPosition()));
      }
      do
      {
        return true;
        if (!this.videoView.isPlaying()) {
          break;
        }
        this.videoView.stopPlayback();
        showVideoCompletionScreen();
      } while (this.timer == null);
      this.timer.cancel();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.videoView.isPlaying())
    {
      TapjoyLog.i("VideoView", "onPause");
      this.seekTime = this.videoView.getCurrentPosition();
      TapjoyLog.i("VideoView", "seekTime: " + this.seekTime);
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    TapjoyLog.i("VideoView", "onPrepared");
  }
  
  protected void onResume()
  {
    TapjoyLog.i("VideoView", "onResume");
    super.onResume();
    setRequestedOrientation(0);
    if (this.seekTime > 0)
    {
      TapjoyLog.i("VideoView", "seekTime: " + this.seekTime);
      this.videoView.seekTo(this.seekTime);
      if ((!this.dialogShowing) || (this.dialog == null) || (!this.dialog.isShowing())) {
        this.videoView.start();
      }
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    TapjoyLog.i("VideoView", "*** onSaveInstanceState ***");
    TapjoyLog.i("VideoView", "dialogShowing: " + this.dialogShowing + ", seekTime: " + this.seekTime);
    paramBundle.putBoolean("dialog_showing", this.dialogShowing);
    paramBundle.putInt("seek_time", this.seekTime);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    TapjoyLog.i("VideoView", "onWindowFocusChanged");
    super.onWindowFocusChanged(paramBoolean);
  }
  
  private class RemainingTime
    extends TimerTask
  {
    private RemainingTime() {}
    
    public void run()
    {
      TapjoyVideoView.this.mHandler.post(TapjoyVideoView.this.mUpdateResults);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TapjoyVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
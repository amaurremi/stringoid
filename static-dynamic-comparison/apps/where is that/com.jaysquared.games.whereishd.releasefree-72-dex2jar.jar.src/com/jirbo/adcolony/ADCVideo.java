package com.jirbo.adcolony;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import java.io.FileInputStream;
import java.io.IOException;

public abstract class ADCVideo
  extends Activity
{
  static Activity ctx;
  static boolean html5_video_playing;
  static int html5_video_seek_to_ms;
  static boolean is_replay;
  static boolean mraid_ready;
  static boolean unfocused;
  static boolean video_finished;
  static int video_seek_to_ms;
  static boolean visible;
  int actual_video_height;
  int actual_video_width;
  int bg_color;
  Rect bounds = new Rect();
  ADCImage browser_icon;
  int display_height;
  int display_width;
  boolean endcard_dissolved;
  long endcard_time_pause;
  long endcard_time_resume;
  double endcard_time_spent;
  boolean first_play = true;
  boolean first_resume = true;
  boolean html5_endcard_loading_finished;
  boolean html5_endcard_loading_started;
  double html5_endcard_loading_time;
  boolean html5_endcard_loading_timeout;
  FrameLayout html5_video_layout;
  VideoView html5_video_view;
  ADCVideoHUD hud;
  FileInputStream infile;
  FrameLayout layout;
  LoadingView loading_view;
  boolean rewarded;
  String video_url = "";
  ADCCustomVideoView video_view;
  int view_height;
  int view_width;
  FrameLayout web_layout;
  
  static void reset()
  {
    video_seek_to_ms = 0;
    video_finished = false;
    is_replay = false;
  }
  
  boolean calculate_layout()
  {
    boolean bool = false;
    Display localDisplay = getWindowManager().getDefaultDisplay();
    this.display_width = localDisplay.getWidth();
    this.display_height = localDisplay.getHeight();
    this.bg_color = -16777216;
    getWindow().setBackgroundDrawable(new ColorDrawable(this.bg_color));
    int i = this.display_width;
    int j = this.display_height;
    this.view_width = i;
    this.view_height = j;
    if (ADC.layout_changed)
    {
      ADC.layout_changed = false;
      bool = true;
    }
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ctx = this;
    boolean bool;
    if (!ADC.get_Logical("video_enabled"))
    {
      bool = true;
      ADC.video_disabled = bool;
      if (ADC.get_Logical("end_card_enabled")) {
        break label197;
      }
      bool = true;
      label36:
      ADC.companion_ad_disabled = bool;
      ADC.graceful_fail = ADC.get_Logical("load_timeout_enabled");
      ADC.load_timeout = ADC.get_Integer("load_timeout");
      requestWindowFeature(1);
      getWindow().setFlags(1024, 1024);
      if (ADC.is_tablet) {
        break label211;
      }
      if (Build.VERSION.SDK_INT < 10) {
        break label203;
      }
      setRequestedOrientation(6);
    }
    for (;;)
    {
      setVolumeControlStream(3);
      this.video_view = new ADCCustomVideoView(this);
      this.layout = new FrameLayout(this);
      this.hud = new ADCVideoHUD(this);
      this.html5_video_layout = new FrameLayout(this);
      this.loading_view = new LoadingView(this);
      this.browser_icon = new ADCImage(ADC.get_String("browser_icon"));
      AdColonyBrowser.should_recycle = false;
      ADC.current_video = this;
      ADC.latest_video = this;
      return;
      bool = false;
      break;
      label197:
      bool = false;
      break label36;
      label203:
      setRequestedOrientation(0);
    }
    label211:
    int j = getResources().getConfiguration().orientation;
    if ((j == 0) || (j == 6) || (j == 2)) {}
    for (int i = 6;; i = 7)
    {
      ADC.orientation = i;
      if ((Build.VERSION.SDK_INT < 10) || (Build.MODEL.equals("Kindle Fire"))) {
        break label280;
      }
      setRequestedOrientation(ADC.orientation);
      break;
    }
    label280:
    i = j;
    if (Build.MODEL.equals("Kindle Fire"))
    {
      getRequestedOrientation();
      switch (((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation())
      {
      default: 
        i = 8;
      }
    }
    for (;;)
    {
      ADC.orientation = i;
      setRequestedOrientation(i);
      break;
      i = 1;
      continue;
      i = 0;
      continue;
      i = 9;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AdColonyBrowser.should_recycle = true;
    ADC.show = true;
    ADC.current_video = null;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((ADCSkipVideoDialog.current != null) && (ADCSkipVideoDialog.current.onKeyDown(paramInt, paramKeyEvent))) {}
    label126:
    do
    {
      do
      {
        do
        {
          return true;
          if (paramInt != 4) {
            break label126;
          }
          if (!video_finished) {
            break;
          }
          if (html5_video_playing)
          {
            this.html5_video_view.stopPlayback();
            html5_video_playing = false;
            this.html5_video_layout.removeAllViews();
            setContentView(this.layout);
            return true;
          }
        } while ((this.hud == null) || (this.hud.selected_button != 0));
        this.hud.handle_continue();
        return true;
      } while ((this.hud == null) || (!this.hud.skippable) || (!this.hud.skip_delay_met));
      this.hud.handle_cancel();
      return true;
    } while (paramInt == 82);
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    visible = false;
    if (html5_video_playing)
    {
      html5_video_seek_to_ms = this.html5_video_view.getCurrentPosition();
      this.html5_video_view.stopPlayback();
      if (video_finished)
      {
        View localView = new View(this);
        localView.setBackgroundColor(-16777216);
        setContentView(localView);
        this.endcard_time_pause = System.currentTimeMillis();
        if (!isFinishing()) {
          this.endcard_time_spent += (this.endcard_time_pause - this.endcard_time_resume) / 1000.0D;
        }
      }
      if (this.video_view == null) {
        break label200;
      }
      if (this.video_view.getCurrentPosition() != 0) {
        video_seek_to_ms = this.video_view.getCurrentPosition();
      }
      this.video_view.stopPlayback();
      this.video_view.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      this.hud.up_state = true;
      this.hud.reload_pressed = false;
      this.hud.close_pressed = false;
      this.hud.engagement_pressed = false;
      this.hud.recent_selected_button = 0;
      this.hud.selected_button = 0;
      this.hud.invalidate();
      super.onPause();
      return;
      html5_video_seek_to_ms = 0;
      break;
      label200:
      video_seek_to_ms = 0;
    }
  }
  
  public void onResume()
  {
    visible = true;
    super.onResume();
    calculate_layout();
    if (this.first_resume)
    {
      this.first_resume = false;
      if (!video_finished)
      {
        if (this.hud.is_html5) {
          this.web_layout.addView(this.hud.end_card_web_view);
        }
        if (this.hud.is_html5) {
          this.web_layout.setVisibility(4);
        }
        if (Build.MODEL.equals("Kindle Fire")) {
          this.hud.offset = 20;
        }
        if (Build.MODEL.equals("SCH-I800")) {
          this.hud.offset = 25;
        }
        this.layout.addView(this.video_view, new FrameLayout.LayoutParams(this.view_width, this.view_height, 17));
        if (this.hud.is_html5) {
          this.layout.addView(this.web_layout, new FrameLayout.LayoutParams(this.display_width, this.display_height - this.hud.offset, 17));
        }
        this.layout.addView(this.hud, new FrameLayout.LayoutParams(this.display_width, this.display_height, 17));
      }
    }
    if (html5_video_playing)
    {
      this.html5_video_layout.addView(this.loading_view);
      setContentView(this.html5_video_layout);
    }
    for (;;)
    {
      this.video_view.setOnCompletionListener(this.hud);
      this.video_view.setOnErrorListener(this.hud);
      try
      {
        this.infile = new FileInputStream(ADC.get_String("video_filepath"));
        this.video_view.setVideoPath(this.infile.getFD());
        if (!unfocused) {
          onWindowFocusChanged(true);
        }
        if (ADC.video_disabled)
        {
          this.hud.adjust_size();
          this.hud.complete();
        }
        return;
      }
      catch (IOException localIOException)
      {
        ADC.log_error("Unable to play video: " + ADC.get_String("video_filepath"));
        finish();
      }
      setContentView(this.layout);
      if (video_finished) {
        this.endcard_time_resume = System.currentTimeMillis();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      unfocused = false;
      if ((!video_finished) && (visible)) {
        if (this.video_view != null)
        {
          this.video_view.seekTo(video_seek_to_ms);
          if (!ADC.is_tablet) {
            break label107;
          }
          Handler localHandler = new Handler();
          Runnable local1 = new Runnable()
          {
            public void run()
            {
              ADCVideo.this.video_view.setBackgroundColor(0);
            }
          };
          this.video_view.setBackgroundColor(-16777216);
          localHandler.postDelayed(local1, 900L);
          if (!ADCSkipVideoDialog.skip_dialog) {
            this.video_view.start();
          }
          this.hud.requestFocus();
          this.hud.invalidate();
        }
      }
      label107:
      do
      {
        return;
        this.video_view.setBackgroundColor(0);
        break;
        if (html5_video_playing)
        {
          this.html5_video_view.seekTo(html5_video_seek_to_ms);
          this.html5_video_view.start();
          return;
        }
      } while (!video_finished);
      this.hud.invalidate();
      return;
    }
    if (visible)
    {
      video_seek_to_ms = this.video_view.getCurrentPosition();
      this.video_view.pause();
    }
    unfocused = true;
  }
  
  void playVideo(String paramString)
  {
    this.video_url = paramString;
    html5_video_playing = true;
    this.html5_video_view = new VideoView(this);
    paramString = Uri.parse(paramString);
    this.html5_video_view.setVideoURI(paramString);
    new MediaController(this).setMediaPlayer(this.html5_video_view);
    this.html5_video_view.setLayoutParams(new FrameLayout.LayoutParams(this.display_width, this.display_height, 17));
    this.html5_video_layout.addView(this.html5_video_view);
    this.html5_video_layout.addView(this.loading_view);
    setContentView(this.html5_video_layout);
    this.html5_video_view.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        ADCVideo.this.setContentView(ADCVideo.this.layout);
        ADCVideo.this.html5_video_layout.removeAllViews();
        ADCVideo.html5_video_playing = false;
      }
    });
    this.html5_video_view.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
    {
      public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        ADCVideo.this.html5_video_layout.removeViewAt(1);
      }
    });
    this.html5_video_view.start();
  }
  
  class LoadingView
    extends View
  {
    Rect bounds = new Rect();
    
    public LoadingView(Activity paramActivity)
    {
      super();
    }
    
    public void onDraw(Canvas paramCanvas)
    {
      paramCanvas.drawARGB(255, 0, 0, 0);
      getDrawingRect(this.bounds);
      ADCVideo.this.browser_icon.draw(paramCanvas, (this.bounds.width() - ADCVideo.this.browser_icon.width) / 2, (this.bounds.height() - ADCVideo.this.browser_icon.height) / 2);
      invalidate();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.lang.reflect.Method;

class ADCVideoHUD
  extends View
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  static float[] widths = new float[80];
  ADCImage[] active_buttons = new ADCImage[4];
  ADCVideo activity;
  float angle_per_sec;
  ADCImage background;
  Rect bounds = new Rect();
  ADCImage browser_icon;
  String[] button_labels = new String[4];
  Paint button_text_paint = new Paint(1);
  boolean can_press = true;
  Canvas canvas;
  float center_x;
  float center_y;
  Paint circle_paint = new Paint(1);
  boolean close_pressed;
  int close_xpos;
  int close_ypos;
  float cur_angle;
  ADCUtil.Timer dissolve_timer;
  long end_card_loading_finish;
  long end_card_loading_start;
  WebView end_card_web_view;
  boolean engagement;
  boolean engagement_delay_met;
  int engagement_delay_ms;
  boolean engagement_pressed;
  String engagement_text;
  String engagement_url;
  boolean error;
  boolean first_resize = true;
  boolean first_update = true;
  boolean graceful_fail = true;
  float height;
  double hud_scale = 1.0D;
  double image_scale = 1.0D;
  ADCImage img_close_button;
  ADCImage img_close_button_down;
  ADCImage img_engagement_button_down;
  ADCImage img_engagement_button_normal;
  ADCImage img_reload_button;
  ADCImage img_reload_button_down;
  ADCImage img_skip_button;
  ADCImage img_skip_button_down;
  boolean is_html5;
  boolean is_static;
  int keyboard_offset = 0;
  int left_margin = 99;
  View loading_view;
  ADCMRAIDHandler mraid_handler;
  ADCImage[] normal_buttons = new ADCImage[4];
  int offset;
  Handler on_button_press_handler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (ADCVideoHUD.this.activity.isFinishing()) {}
      while (ADCVideoHUD.this.activity.video_view == null) {
        return;
      }
      ADCVideoHUD.this.onButton(paramAnonymousMessage.what);
    }
  };
  int original_bg_height;
  int original_bg_width;
  RectF oval = new RectF();
  Paint paint = new Paint();
  float radius;
  int recent_selected_button;
  boolean reload_pressed;
  int reload_xpos;
  int reload_ypos;
  boolean resize_images = true;
  int selected_button;
  boolean show_version;
  boolean skip_delay_met;
  int skip_delay_ms;
  boolean skippable;
  Paint text_paint = new Paint(1);
  boolean up_state = true;
  UpdateHandler update_handler = new UpdateHandler();
  String version_number = ADC.controller.configuration.sdk_version;
  Paint version_paint = new Paint(1);
  int video_duration_ms;
  boolean web_layout_offset;
  float width;
  
  ADCVideoHUD(ADCVideo paramADCVideo)
  {
    super(paramADCVideo);
    this.activity = paramADCVideo;
    this.skippable = ADC.controller.configuration.skippable;
    if (ADC.current_ad != null) {
      this.skippable |= ADC.current_ad.ad_info.video.skip_video.enabled;
    }
    this.is_html5 = ADC.end_card_is_html5;
    if (ADC.force_dec_url != null) {
      ADC.end_card_url = ADC.force_dec_url;
    }
    boolean bool;
    if ((ADC.current_ad != null) && (ADC.current_ad.ad_info.companion_ad.enabled))
    {
      if (!this.is_html5)
      {
        bool = true;
        this.is_static = bool;
      }
    }
    else
    {
      if (!this.is_static) {
        break label978;
      }
      this.background = new ADCImage(ADC.get_String("end_card_filepath"));
      this.original_bg_width = this.background.width;
      this.original_bg_height = this.background.height;
      if (this.original_bg_width == 0) {
        this.original_bg_width = 480;
      }
      if (this.original_bg_height == 0) {
        this.original_bg_height = 320;
      }
      this.normal_buttons[0] = new ADCImage(ADC.get_String("info_image_normal"));
      this.normal_buttons[1] = new ADCImage(ADC.get_String("download_image_normal"));
      this.normal_buttons[2] = new ADCImage(ADC.get_String("replay_image_normal"));
      this.normal_buttons[3] = new ADCImage(ADC.get_String("continue_image_normal"));
      this.active_buttons[0] = new ADCImage(ADC.get_String("info_image_down"), true);
      this.active_buttons[1] = new ADCImage(ADC.get_String("download_image_down"), true);
      this.active_buttons[2] = new ADCImage(ADC.get_String("replay_image_down"), true);
      this.active_buttons[3] = new ADCImage(ADC.get_String("continue_image_down"), true);
      this.button_labels[0] = "Info";
      this.button_labels[1] = "Download";
      this.button_labels[2] = "Replay";
      this.button_labels[3] = "Continue";
    }
    for (;;)
    {
      if (this.skippable)
      {
        this.img_skip_button = new ADCImage(ADC.get_String("skip_video_image_normal"));
        this.img_skip_button_down = new ADCImage(ADC.get_String("skip_video_image_down"));
        this.skip_delay_ms = (ADC.get_Integer("skip_delay") * 1000);
      }
      this.circle_paint.setStyle(Paint.Style.STROKE);
      float f2 = 2.0F * paramADCVideo.getResources().getDisplayMetrics().density;
      float f1 = f2;
      if (f2 > 6.0F) {
        f1 = 6.0F;
      }
      if (f1 < 4.0F) {}
      this.circle_paint.setStrokeWidth(2.0F * paramADCVideo.getResources().getDisplayMetrics().density);
      this.circle_paint.setColor(-3355444);
      this.engagement = false;
      if (ADC.current_ad != null) {
        this.engagement = ADC.current_ad.ad_info.video.in_video_engagement.enabled;
      }
      if (this.engagement)
      {
        this.img_engagement_button_normal = new ADCImage(ADC.get_String("engagement_image_normal"));
        this.img_engagement_button_down = new ADCImage(ADC.get_String("engagement_image_down"));
        this.engagement_url = ADC.current_ad.ad_info.video.in_video_engagement.click_action;
        this.engagement_text = ADC.current_ad.ad_info.video.in_video_engagement.label;
        this.engagement_delay_ms = (ADC.get_Integer("engagement_delay") * 1000);
        if (this.engagement_text.equals("")) {
          this.engagement_text = "Learn More";
        }
      }
      if (ADCVideo.video_finished) {
        on_video_finish();
      }
      this.paint.setColor(-1);
      this.button_text_paint.setTextSize(24.0F);
      this.button_text_paint.setColor(-16777216);
      this.text_paint.setColor(-3355444);
      this.text_paint.setTextSize(20.0F);
      this.text_paint.setTextAlign(Paint.Align.CENTER);
      this.version_paint.setTextSize(20.0F);
      this.version_paint.setColor(-1);
      label978:
      try
      {
        getClass().getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(this, new Object[] { Integer.valueOf(1), null });
        return;
      }
      catch (Exception paramADCVideo) {}
      bool = false;
      break;
      if (this.is_html5)
      {
        this.img_reload_button = new ADCImage(ADC.get_String("reload_image_normal"));
        this.img_close_button = new ADCImage(ADC.get_String("close_image_normal"));
        this.img_close_button_down = new ADCImage(ADC.get_String("close_image_down"));
        this.img_reload_button_down = new ADCImage(ADC.get_String("reload_image_down"));
        this.browser_icon = new ADCImage(ADC.get_String("browser_icon"));
        this.loading_view = new LoadingView(paramADCVideo);
        set_up_web_view();
      }
    }
  }
  
  public void adjust_size()
  {
    boolean bool = this.activity.calculate_layout();
    this.resize_images |= bool;
    if (this.activity.video_view != null)
    {
      if (this.video_duration_ms <= 0) {
        this.video_duration_ms = this.activity.video_view.getDuration();
      }
      if (bool)
      {
        setLayoutParams(new FrameLayout.LayoutParams(this.activity.display_width, this.activity.display_height, 17));
        this.activity.video_view.setLayoutParams(new FrameLayout.LayoutParams(this.activity.view_width, this.activity.view_height, 17));
        this.resize_images = true;
      }
    }
    float f1;
    float f2;
    label266:
    label286:
    int i;
    label440:
    label522:
    double d2;
    if (this.resize_images)
    {
      this.resize_images = false;
      if (this.first_resize)
      {
        DisplayMetrics localDisplayMetrics = AdColony.activity().getResources().getDisplayMetrics();
        f1 = localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi;
        f2 = localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi;
        d1 = Math.sqrt(f1 * f1 + f2 * f2);
        d1 = Math.sqrt(localDisplayMetrics.widthPixels * localDisplayMetrics.widthPixels + localDisplayMetrics.heightPixels * localDisplayMetrics.heightPixels) / d1;
        if (d1 / 280.0D >= 0.7D) {
          break label820;
        }
        d1 = 0.7D;
        this.hud_scale = d1;
        if (20.0D * this.hud_scale >= 18.0D) {
          break label829;
        }
        f1 = 18.0F;
        if (20.0D * this.hud_scale >= 18.0D) {
          break label843;
        }
        f2 = 18.0F;
        this.text_paint.setTextSize(f1);
        this.version_paint.setTextSize(f1);
        this.button_text_paint.setTextSize(f2);
        if (this.engagement)
        {
          this.img_engagement_button_normal.ninePatch(textWidthOf(this.engagement_text + this.img_engagement_button_normal.width * 2), this.img_engagement_button_normal.height);
          this.img_engagement_button_down.ninePatch(textWidthOf(this.engagement_text + this.img_engagement_button_down.width * 2), this.img_engagement_button_down.height);
        }
        if (this.activity.display_width <= this.activity.display_height) {
          break label857;
        }
        i = this.activity.display_height;
        this.first_resize = false;
      }
      if (this.is_html5)
      {
        if ((bool) && (this.end_card_web_view != null)) {
          this.end_card_web_view.setLayoutParams(new FrameLayout.LayoutParams(this.activity.display_width, this.activity.display_height - this.offset, 17));
        }
        if (this.activity.view_height / 640.0D >= 0.9D) {
          break label869;
        }
        d1 = 0.9D;
        this.image_scale = d1;
      }
      if (this.is_static)
      {
        d2 = this.original_bg_width / this.original_bg_height;
        if (this.activity.display_width / d2 <= this.activity.display_height / 1.0D) {
          break label885;
        }
        d1 = this.activity.display_height / 1.0D;
        label580:
        this.activity.view_width = ((int)(d2 * d1));
        this.activity.view_height = ((int)(1.0D * d1));
        if (this.activity.display_width <= this.activity.display_height) {
          break label899;
        }
        d1 = this.activity.view_height / 640.0D;
        label632:
        this.image_scale = d1;
        if (this.activity.display_width / this.original_bg_width <= this.activity.display_height / this.original_bg_height) {
          break label915;
        }
      }
    }
    label820:
    label829:
    label843:
    label857:
    label869:
    label885:
    label899:
    label915:
    for (double d1 = this.activity.display_height / this.original_bg_height;; d1 = this.activity.display_width / this.original_bg_width)
    {
      this.background.resize(d1);
      this.background.center_within(this.activity.display_width, this.activity.display_height);
      if (this.engagement)
      {
        i = (int)(this.img_engagement_button_normal.original_bitmap.getHeight() * this.hud_scale);
        int j = (int)(this.img_engagement_button_down.original_bitmap.getHeight() * this.hud_scale);
        this.img_engagement_button_normal.resize(this.img_engagement_button_normal.width, i);
        this.img_engagement_button_down.resize(this.img_engagement_button_down.width, j);
      }
      if (this.skippable)
      {
        this.img_skip_button.resize(this.hud_scale);
        this.img_skip_button_down.resize(this.hud_scale);
      }
      return;
      d1 /= 280.0D;
      break;
      f1 = (float)(20.0D * this.hud_scale);
      break label266;
      f2 = (float)(20.0D * this.hud_scale);
      break label286;
      i = this.activity.display_width;
      break label440;
      d1 = this.activity.view_height / 640.0D;
      break label522;
      d1 = this.activity.display_width / d2;
      break label580;
      d1 = this.activity.view_height / 960.0D;
      break label632;
    }
  }
  
  public boolean clicked(ADCImage paramADCImage, int paramInt1, int paramInt2)
  {
    return (paramInt1 < paramADCImage.x() + paramADCImage.width + 8) && (paramInt1 > paramADCImage.x() - 8) && (paramInt2 < paramADCImage.y() + paramADCImage.height + 8) && (paramInt2 > paramADCImage.y() - 8);
  }
  
  public void complete()
  {
    ??? = ADC.controller;
    final Object localObject2 = this.activity;
    ((ADCController)???).on_video_finish(ADCVideo.is_replay);
    if ((this.is_html5) && (this.graceful_fail) && (ADC.graceful_fail))
    {
      this.activity.layout.addView(this.loading_view);
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          if ((ADCVideoHUD.this.graceful_fail) && (ADCVideoHUD.this.activity != null) && (ADCVideoHUD.this.is_html5) && (ADCVideoHUD.this.end_card_web_view != null))
          {
            ADCVideoHUD.this.activity.html5_endcard_loading_timeout = true;
            ADCVideoHUD.this.handle_continue();
          }
        }
      }, ADC.load_timeout * 1000);
    }
    if (ADC.companion_ad_disabled) {
      handle_continue();
    }
    ADC.track_ad_event("card_shown");
    synchronized (this.update_handler)
    {
      this.dissolve_timer = null;
      if (ADC.current_ad.ad_info.companion_ad.dissolve) {
        this.dissolve_timer = new ADCUtil.Timer(ADC.current_ad.ad_info.companion_ad.dissolve_delay);
      }
      if (this.is_html5)
      {
        ??? = new Handler();
        localObject2 = new View(this.activity);
        Runnable local6 = new Runnable()
        {
          public void run()
          {
            ADCVideoHUD.this.activity.layout.removeView(localObject2);
            ADCVideoHUD.this.dec_fire_viewable_change(true);
            ADCVideoHUD.this.activity.endcard_time_resume = System.currentTimeMillis();
          }
        };
        ((View)localObject2).setBackgroundColor(-16777216);
        this.activity.layout.addView((View)localObject2);
        ((Handler)???).postDelayed(local6, 500L);
        this.activity.web_layout.setVisibility(0);
      }
      on_video_finish();
      return;
    }
  }
  
  void dec_fire_keyboard_viewable_change(final boolean paramBoolean)
  {
    if (this.is_static) {}
    while (this.end_card_web_view == null) {
      return;
    }
    this.end_card_web_view.addJavascriptInterface(new Object()
    {
      public String toString()
      {
        if (paramBoolean) {
          return "keyboard_opened";
        }
        return "keyboard_closed";
      }
    }, "keyboard_listener");
  }
  
  void dec_fire_viewable_change(boolean paramBoolean)
  {
    if (this.is_static) {
      return;
    }
    if (paramBoolean)
    {
      execute_javascript("adc_bridge.fireChangeEvent({viewable:true});");
      return;
    }
    execute_javascript("adc_bridge.fireChangeEvent({viewable:false});");
  }
  
  void execute_javascript(String paramString)
  {
    if (this.is_static) {}
    while (this.end_card_web_view == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.end_card_web_view.evaluateJavascript(paramString, null);
      return;
    }
    this.end_card_web_view.loadUrl("javascript:" + paramString);
  }
  
  int get_button_index(int paramInt1, int paramInt2)
  {
    int j = 0;
    int i;
    if ((paramInt1 >= this.left_margin) && (paramInt1 < this.left_margin + 62)) {
      i = 1;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            if ((paramInt1 >= this.left_margin + 78) && (paramInt1 < this.left_margin + 78 + 62)) {
              return 2;
            }
            if ((paramInt1 >= this.left_margin + 78 + 78) && (paramInt1 < this.left_margin + 78 + 78 + 62)) {
              return 3;
            }
            if ((paramInt1 >= this.left_margin + 78 + 78 + 78) && (paramInt1 < this.left_margin + 78 + 78 + 78 + 62)) {
              return 4;
            }
            i = j;
          } while (this.activity.video_view == null);
          i = j;
        } while (!this.skippable);
        i = j;
      } while (paramInt1 < this.activity.video_view.getWidth() - this.img_skip_button.width);
      i = j;
    } while (paramInt2 > this.img_skip_button.height);
    return 10;
  }
  
  void handle_cancel()
  {
    if (ADC.current_ad.is_v4vc())
    {
      ADCVideo localADCVideo = this.activity;
      ADCVideo.video_seek_to_ms = this.activity.video_view.getCurrentPosition();
      ADCSkipVideoDialog.current = new ADCSkipVideoDialog(this.activity, (AdColonyV4VCAd)ADC.current_ad);
      return;
    }
    this.activity.finish();
    ADC.end_card_finished_handler.notify_canceled();
  }
  
  void handle_continue()
  {
    if ((this.activity == null) || ((this.is_html5) && ((this.end_card_web_view == null) || (this.activity.web_layout == null) || (this.activity.layout == null)))) {
      return;
    }
    this.activity.endcard_time_pause = System.currentTimeMillis();
    ADCVideo localADCVideo = this.activity;
    localADCVideo.endcard_time_spent += (this.activity.endcard_time_pause - this.activity.endcard_time_resume) / 1000.0D;
    this.activity.finish();
    this.dissolve_timer = null;
    if (this.is_html5)
    {
      this.activity.layout.removeView(this.activity.web_layout);
      this.end_card_web_view.destroy();
      this.end_card_web_view = null;
    }
    ADC.end_card_finished_handler.notify_continuation();
  }
  
  void handle_replay()
  {
    ADC.track_ad_event("replay");
    final Object localObject = this.activity;
    ADCVideo.is_replay = true;
    localObject = this.activity;
    ADCVideo.video_finished = false;
    localObject = this.activity;
    ADCVideo.video_seek_to_ms = 0;
    localObject = new View(this.activity);
    ((View)localObject).setBackgroundColor(-16777216);
    this.activity.layout.addView((View)localObject, new FrameLayout.LayoutParams(this.activity.display_width, this.activity.display_height, 17));
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        if (ADCVideoHUD.this.is_html5) {
          ADCVideoHUD.this.activity.web_layout.setVisibility(4);
        }
        ADCVideoHUD.this.activity.layout.removeView(localObject);
      }
    }, 900L);
    this.activity.video_view.start();
    ADC.controller.on_video_start();
    this.activity.video_view.requestFocus();
    this.activity.video_view.setBackgroundColor(0);
    this.activity.video_view.setVisibility(0);
    dec_fire_viewable_change(false);
  }
  
  void keyboardCheck()
  {
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        Rect localRect = new Rect();
        jdField_this.getWindowVisibleDisplayFrame(localRect);
        if (ADCVideoHUD.this.end_card_web_view != null) {
          ADCVideoHUD.this.set_offset(jdField_this.getRootView().getHeight() - (localRect.bottom - localRect.top) - (ADCVideoHUD.this.activity.display_height - ADCVideoHUD.this.end_card_web_view.getHeight()) / 2);
        }
        ADCVideoHUD.this.open_or_closed();
      }
    });
  }
  
  void load_dec_url()
  {
    this.end_card_web_view.loadUrl(ADC.end_card_url);
    ADCLog.dev.print("Loading - end card url = ").println(ADC.end_card_url);
  }
  
  void onButton(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((!this.can_press) && (paramInt != 10)) {
          break;
        }
        this.can_press = false;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
          this.selected_button = 0;
          new Handler().postDelayed(new Runnable()
          {
            public void run()
            {
              ADCVideoHUD.this.can_press = true;
            }
          }, 1500L);
          return;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        String str1;
        this.can_press = true;
        return;
      }
      this.selected_button = 0;
      ADC.track_ad_event("info", "{\"ad_slot\":" + ADC.current_ad.zone_info.state.play_order_index + "}");
      str1 = ADC.get_String("info_url");
      ADCLog.debug.print("INFO ").println(str1);
      if ((str1.startsWith("market:")) || (str1.startsWith("amzn:")))
      {
        this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str1)));
      }
      else
      {
        AdColonyBrowser.url = localRuntimeException;
        this.activity.startActivity(new Intent(this.activity, AdColonyBrowser.class));
        continue;
        this.selected_button = 0;
        ADC.track_ad_event("download", "{\"ad_slot\":" + ADC.current_ad.zone_info.state.play_order_index + "}");
        String str2 = ADC.get_String("download_url");
        ADCLog.debug.print("DOWNLOAD ").println(str2);
        if ((str2.startsWith("market:")) || (str2.startsWith("amzn:")))
        {
          this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
        }
        else
        {
          AdColonyBrowser.url = str2;
          this.activity.startActivity(new Intent(this.activity, AdColonyBrowser.class));
          continue;
          this.selected_button = 0;
          handle_replay();
          invalidate();
          continue;
          this.selected_button = 0;
          this.activity.video_view.stopPlayback();
          handle_continue();
          continue;
          this.selected_button = 0;
          handle_cancel();
        }
      }
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    complete();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.error) {
      return;
    }
    adjust_size();
    this.canvas = paramCanvas;
    boolean bool;
    label51:
    label91:
    int k;
    int m;
    int j;
    label219:
    int i;
    if ((!this.skip_delay_met) && (this.skippable))
    {
      if (this.activity.video_view.getCurrentPosition() > this.skip_delay_ms)
      {
        bool = true;
        this.skip_delay_met = bool;
      }
    }
    else
    {
      if ((!this.engagement_delay_met) && (this.engagement))
      {
        if (this.activity.video_view.getCurrentPosition() <= this.engagement_delay_ms) {
          break label392;
        }
        bool = true;
        this.engagement_delay_met = bool;
      }
      localObject = this.activity;
      if ((!ADCVideo.video_finished) || (!this.is_static)) {
        break label463;
      }
      paramCanvas.drawARGB(this.activity.bg_color >> 24 & 0xFF, 0, 0, 0);
      this.background.draw(paramCanvas, (this.activity.display_width - this.background.width) / 2, (this.activity.display_height - this.background.height) / 2);
      k = (int)(186.0D * this.image_scale) + this.background.x();
      m = (int)(470.0D * this.image_scale) + this.background.y();
      j = 0;
      if (j < this.normal_buttons.length)
      {
        if ((this.selected_button != j + 1) && ((this.recent_selected_button != j + 1) || (this.up_state) || (this.recent_selected_button == 0))) {
          break label398;
        }
        this.active_buttons[j].resize(this.image_scale);
        this.active_buttons[j].draw(paramCanvas, k, m);
        i = (int)(k + 157.0F * this.image_scale);
      }
    }
    for (;;)
    {
      this.text_paint.setColor(-1);
      this.text_paint.clearShadowLayer();
      paramCanvas.drawText(this.button_labels[j], this.normal_buttons[j].x() + this.normal_buttons[j].width / 2, this.normal_buttons[j].y() + this.normal_buttons[j].height, this.text_paint);
      j += 1;
      k = i;
      break label219;
      break;
      bool = false;
      break label51;
      label392:
      bool = false;
      break label91;
      label398:
      if (!this.up_state)
      {
        i = k;
        if (j + 1 == this.recent_selected_button) {}
      }
      else
      {
        this.normal_buttons[j].resize(this.image_scale);
        this.normal_buttons[j].draw(paramCanvas, k, m);
        i = (int)(k + 157.0F * this.image_scale);
      }
    }
    label463:
    Object localObject = this.activity;
    if ((ADCVideo.video_finished) && (this.is_html5))
    {
      this.img_close_button.resize(this.hud_scale);
      this.img_close_button_down.resize(this.hud_scale);
      this.img_reload_button.resize(this.hud_scale);
      this.img_reload_button_down.resize(this.hud_scale);
      if ((!ADC.is_tablet) && (this.close_xpos != 0))
      {
        i = this.close_xpos;
        this.close_xpos = i;
        this.close_ypos = 0;
        this.reload_xpos = 0;
        this.reload_ypos = 0;
        if (this.close_pressed) {
          break label634;
        }
        this.img_close_button.draw(paramCanvas, this.close_xpos, this.close_ypos);
        label587:
        if (this.reload_pressed) {
          break label653;
        }
        this.img_reload_button.draw(paramCanvas, this.reload_xpos, this.reload_ypos);
      }
      for (;;)
      {
        keyboardCheck();
        return;
        i = this.activity.display_width - this.img_close_button.width;
        break;
        label634:
        this.img_close_button_down.draw(paramCanvas, this.close_xpos, this.close_ypos);
        break label587;
        label653:
        this.img_reload_button_down.draw(paramCanvas, this.reload_xpos, this.reload_ypos);
      }
    }
    if (this.activity.video_view != null)
    {
      ADC.controller.on_video_progress(this.activity.video_view.getCurrentPosition() / this.activity.video_view.getDuration());
      i = this.activity.video_view.getCurrentPosition();
      j = (this.video_duration_ms - i + 999) / 1000;
      if (i >= 500)
      {
        if (this.first_update)
        {
          this.angle_per_sec = ((float)(360.0D / (this.video_duration_ms / 1000.0D)));
          this.first_update = false;
          localObject = new Rect();
          this.text_paint.getTextBounds("0123456789", 0, 9, (Rect)localObject);
          this.radius = ((Rect)localObject).height();
        }
        this.width = getWidth();
        this.height = getHeight();
        this.center_x = this.radius;
        this.center_y = (this.activity.display_height - this.radius - this.offset);
        this.oval.set(this.center_x - this.radius / 2.0F, this.center_y - 2.0F * this.radius, this.center_x + 2.0F * this.radius, this.center_y + this.radius / 2.0F);
        this.circle_paint.setShadowLayer((int)(4.0D * this.image_scale), 0.0F, 0.0F, -16777216);
        this.cur_angle = ((float)(this.angle_per_sec * (this.video_duration_ms / 1000.0D - i / 1000.0D)));
        paramCanvas.drawArc(this.oval, 270.0F, this.cur_angle, false, this.circle_paint);
        localObject = this.activity;
        if (!ADCVideo.video_finished)
        {
          this.text_paint.setColor(-3355444);
          this.text_paint.setShadowLayer((int)(2.0D * this.image_scale), 0.0F, 0.0F, -16777216);
          this.text_paint.setTextAlign(Paint.Align.CENTER);
          this.text_paint.setLinearText(true);
          paramCanvas.drawText("" + j, this.oval.centerX(), (float)(this.oval.centerY() + this.text_paint.getFontMetrics().bottom * 1.35D), this.text_paint);
        }
        if (this.skippable)
        {
          localObject = this.activity;
          if ((!ADCVideo.video_finished) && (this.skip_delay_met))
          {
            if (this.selected_button != 10) {
              break label1344;
            }
            this.img_skip_button_down.draw(paramCanvas, this.activity.display_width - this.img_skip_button_down.width, (int)(this.image_scale * 4.0D));
          }
        }
        label1166:
        if ((this.engagement) && (this.engagement_delay_met))
        {
          if (!this.engagement_pressed) {
            break label1379;
          }
          this.img_engagement_button_down.set_position((int)(this.activity.display_width - this.img_engagement_button_down.width - this.radius / 2.0F), this.activity.display_height - this.img_engagement_button_down.height - this.offset - (int)(this.radius / 2.0F));
          this.img_engagement_button_down.draw(paramCanvas);
        }
      }
    }
    for (;;)
    {
      this.button_text_paint.setTextAlign(Paint.Align.CENTER);
      paramCanvas.drawText(this.engagement_text, this.img_engagement_button_normal.dest_rect.centerX(), (float)(this.img_engagement_button_normal.dest_rect.centerY() + this.button_text_paint.getFontMetrics().bottom * 1.35D), this.button_text_paint);
      if (ADCSkipVideoDialog.current != null) {
        ADCSkipVideoDialog.current.onDraw(paramCanvas);
      }
      paramCanvas = this.activity;
      if (!ADCVideo.visible) {
        break;
      }
      invalidate();
      return;
      label1344:
      this.img_skip_button.draw(paramCanvas, this.activity.display_width - this.img_skip_button.width, (int)(this.image_scale * 4.0D));
      break label1166;
      label1379:
      this.img_engagement_button_normal.set_position((int)(this.activity.display_width - this.img_engagement_button_normal.width - this.radius / 2.0F), this.activity.display_height - this.img_engagement_button_normal.height - this.offset - (int)(this.radius / 2.0F));
      this.img_engagement_button_normal.draw(paramCanvas);
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    handle_cancel();
    return true;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.offset = (this.activity.display_height - paramInt2);
    if (Build.MODEL.equals("Kindle Fire")) {
      this.offset = 20;
    }
    if (Build.MODEL.equals("SCH-I800")) {
      this.offset = 25;
    }
    if ((Build.MODEL.equals("SHW-M380K")) || (Build.MODEL.equals("SHW-M380S")) || (Build.MODEL.equals("SHW-M380W"))) {
      this.offset = 40;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    if (ADCSkipVideoDialog.current != null) {
      ADCSkipVideoDialog.current.onTouchEvent(paramMotionEvent);
    }
    do
    {
      int i;
      int j;
      ADCVideo localADCVideo;
      int m;
      do
      {
        return true;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if (k != 0) {
          break;
        }
        localADCVideo = this.activity;
        if ((ADCVideo.video_finished) && (this.is_html5))
        {
          if (clicked(this.img_close_button, i, j))
          {
            this.close_pressed = true;
            invalidate();
            return true;
          }
          if (clicked(this.img_reload_button, i, j))
          {
            this.reload_pressed = true;
            invalidate();
            return true;
          }
          return false;
        }
        localADCVideo = this.activity;
        k = i;
        m = j;
        if (ADCVideo.video_finished)
        {
          k = i;
          m = j;
          if (this.is_static)
          {
            i = (int)((paramMotionEvent.getX() - this.background.x()) / (this.image_scale * 2.0D));
            j = (int)((paramMotionEvent.getY() - this.background.y()) / (this.image_scale * 2.0D));
            k = i;
            m = j;
            if (this.selected_button == 0)
            {
              k = i;
              m = j;
              if (j >= 235)
              {
                k = i;
                m = j;
                if (j < 305)
                {
                  k = get_button_index(i, j);
                  this.selected_button = k;
                  this.recent_selected_button = k;
                  this.up_state = false;
                  invalidate();
                  m = j;
                  k = i;
                }
              }
            }
          }
        }
        if ((this.skippable) && (this.skip_delay_met) && (this.activity.video_view != null) && (clicked(this.img_skip_button, k, m)))
        {
          this.selected_button = 10;
          this.recent_selected_button = this.selected_button;
          this.up_state = false;
          invalidate();
          return true;
        }
      } while ((!this.engagement) || (!this.engagement_delay_met) || (!clicked(this.img_engagement_button_normal, k, m)));
      this.engagement_pressed = true;
      invalidate();
      return true;
      if (k == 1)
      {
        localADCVideo = this.activity;
        if ((ADCVideo.video_finished) && (this.is_html5))
        {
          if ((clicked(this.img_close_button, i, j)) && (this.close_pressed))
          {
            this.selected_button = 4;
            this.end_card_web_view.clearCache(true);
            this.on_button_press_handler.sendMessageDelayed(this.on_button_press_handler.obtainMessage(this.selected_button), 250L);
            return true;
          }
          if ((clicked(this.img_reload_button, i, j)) && (this.reload_pressed))
          {
            this.selected_button = 3;
            this.end_card_web_view.clearCache(true);
            this.on_button_press_handler.sendMessageDelayed(this.on_button_press_handler.obtainMessage(this.selected_button), 250L);
            return true;
          }
        }
        localADCVideo = this.activity;
        k = i;
        m = j;
        if (ADCVideo.video_finished)
        {
          k = i;
          m = j;
          if (this.is_static)
          {
            i = (int)((paramMotionEvent.getX() - this.background.x()) / (this.image_scale * 2.0D));
            j = (int)((paramMotionEvent.getY() - this.background.y()) / (this.image_scale * 2.0D));
            k = i;
            m = j;
            if (!this.up_state)
            {
              k = i;
              m = j;
              if (j >= 235)
              {
                k = i;
                m = j;
                if (j < 305)
                {
                  int n = get_button_index(i, j);
                  k = i;
                  m = j;
                  if (n > 0)
                  {
                    k = i;
                    m = j;
                    if (n == this.recent_selected_button)
                    {
                      this.on_button_press_handler.sendMessageDelayed(this.on_button_press_handler.obtainMessage(n), 250L);
                      m = j;
                      k = i;
                    }
                  }
                }
              }
            }
          }
        }
        if ((this.skippable) && (this.skip_delay_met) && (this.activity.video_view != null) && (clicked(this.img_skip_button, k, m)))
        {
          this.selected_button = 10;
          this.up_state = true;
          this.recent_selected_button = this.selected_button;
          this.on_button_press_handler.sendMessageDelayed(this.on_button_press_handler.obtainMessage(this.selected_button), 250L);
          return true;
        }
        if ((this.engagement) && (this.engagement_delay_met) && (clicked(this.img_engagement_button_normal, k, m)))
        {
          this.engagement_pressed = false;
          if ((this.engagement_url.startsWith("market:")) || (this.engagement_url.startsWith("amzn:"))) {
            this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.engagement_url)));
          }
          for (;;)
          {
            ADC.track_ad_event("in_video_engagement", "{\"ad_slot\":" + ADC.current_ad.zone_info.state.play_order_index + "}");
            return true;
            AdColonyBrowser.url = this.engagement_url;
            this.activity.startActivity(new Intent(this.activity, AdColonyBrowser.class));
          }
        }
        this.close_pressed = false;
        this.reload_pressed = false;
        this.engagement_pressed = false;
        this.up_state = true;
        this.selected_button = 0;
        invalidate();
        return true;
      }
    } while (k != 3);
    this.close_pressed = false;
    this.reload_pressed = false;
    this.engagement_pressed = false;
    this.up_state = true;
    this.selected_button = 0;
    invalidate();
    return true;
  }
  
  void on_video_finish()
  {
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        if (ADCVideoHUD.this.activity.video_view != null) {
          ADCVideoHUD.this.activity.video_view.setVisibility(8);
        }
      }
    }, 300L);
    ADCVideo localADCVideo = this.activity;
    ADCVideo.video_finished = true;
    if (this.activity.video_view != null) {
      this.activity.video_view.stopPlayback();
    }
    ADCSkipVideoDialog.current = null;
    invalidate();
    this.reload_pressed = false;
    invalidate();
  }
  
  void open_or_closed()
  {
    if ((this.keyboard_offset >= 70) && (!this.web_layout_offset))
    {
      this.web_layout_offset = true;
      dec_fire_keyboard_viewable_change(true);
    }
    while ((!this.web_layout_offset) || (this.keyboard_offset != 0)) {
      return;
    }
    this.web_layout_offset = false;
    dec_fire_keyboard_viewable_change(false);
  }
  
  void set_offset(int paramInt)
  {
    this.keyboard_offset = paramInt;
    if (paramInt < 0) {
      this.keyboard_offset = 0;
    }
  }
  
  void set_up_web_view()
  {
    this.end_card_web_view = new WebView(this.activity);
    this.end_card_web_view.setFocusable(true);
    this.end_card_web_view.setHorizontalScrollBarEnabled(false);
    this.end_card_web_view.setVerticalScrollBarEnabled(false);
    Object localObject = this.end_card_web_view.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setPluginState(WebSettings.PluginState.ON_DEMAND);
    ((WebSettings)localObject).setBuiltInZoomControls(true);
    ((WebSettings)localObject).setGeolocationEnabled(true);
    this.end_card_web_view.setWebChromeClient(new WebChromeClient()
    {
      public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        String str2 = paramAnonymousConsoleMessage.sourceId();
        String str1;
        if (str2 == null) {
          str1 = "Internal";
        }
        for (;;)
        {
          ADCLog.debug.print(paramAnonymousConsoleMessage.message()).print(" [").print(str1).print(" line ").print(paramAnonymousConsoleMessage.lineNumber()).println("]");
          return true;
          int i = str2.lastIndexOf('/');
          str1 = str2;
          if (i != -1) {
            str1 = str2.substring(i + 1);
          }
        }
      }
      
      public void onGeolocationPermissionsShowPrompt(String paramAnonymousString, GeolocationPermissions.Callback paramAnonymousCallback)
      {
        paramAnonymousCallback.invoke(paramAnonymousString, true, false);
      }
    });
    this.activity.web_layout = new FrameLayout(this.activity);
    if (ADC.get_Logical("hardware_acceleration_disabled")) {}
    try
    {
      this.activity.web_layout.getClass().getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(this.end_card_web_view, new Object[] { Integer.valueOf(1), null });
      this.mraid_handler = new ADCMRAIDHandler(this.activity, this.end_card_web_view, this.activity);
      localObject = new WebViewClient()
      {
        String end_card_url = ADC.end_card_url;
        
        public void onLoadResource(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          ADCLog.dev.print("DEC onLoad: ").println(paramAnonymousString);
          if (paramAnonymousString.equals(this.end_card_url))
          {
            ADCLog.dev.println("DEC disabling mouse events");
            ADCVideoHUD.this.execute_javascript("if (typeof(CN) != 'undefined' && CN.div) {\n  if (typeof(cn_dispatch_on_touch_begin) != 'undefined') CN.div.removeEventListener('mousedown',  cn_dispatch_on_touch_begin, true);\n  if (typeof(cn_dispatch_on_touch_end) != 'undefined')   CN.div.removeEventListener('mouseup',  cn_dispatch_on_touch_end, true);\n  if (typeof(cn_dispatch_on_touch_move) != 'undefined')  CN.div.removeEventListener('mousemove',  cn_dispatch_on_touch_move, true);\n}\n");
          }
        }
        
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          if (paramAnonymousString.equals(this.end_card_url))
          {
            ADCVideoHUD.this.graceful_fail = false;
            ADCVideoHUD.this.activity.html5_endcard_loading_finished = true;
            ADCVideoHUD.this.end_card_loading_finish = System.currentTimeMillis();
            ADCVideoHUD.this.activity.html5_endcard_loading_time = ((ADCVideoHUD.this.end_card_loading_finish - ADCVideoHUD.this.end_card_loading_start) / 1000.0D);
          }
          ADCVideoHUD.this.activity.layout.removeView(ADCVideoHUD.this.loading_view);
        }
        
        public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          if (paramAnonymousString.equals(this.end_card_url))
          {
            ADCVideoHUD.this.activity.html5_endcard_loading_started = true;
            ADCVideoHUD.this.end_card_loading_start = System.currentTimeMillis();
          }
        }
        
        public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          ADCLog.dev.print("DEC request: ").println(paramAnonymousString);
          if (paramAnonymousString.contains("mraid:")) {
            ADCVideoHUD.this.mraid_handler.handleMRAIDCommand(paramAnonymousString);
          }
          do
          {
            return true;
            if (paramAnonymousString.contains("youtube"))
            {
              paramAnonymousWebView = new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:" + paramAnonymousString));
              paramAnonymousWebView.putExtra("VIDEO_ID", paramAnonymousString);
              ADCVideoHUD.this.activity.startActivity(paramAnonymousWebView);
              return true;
            }
          } while (paramAnonymousString.contains("mraid.js"));
          return false;
        }
      };
      this.end_card_web_view.setWebViewClient((WebViewClient)localObject);
      if (Build.VERSION.SDK_INT >= 19) {
        this.end_card_web_view.loadUrl(ADC.end_card_url);
      }
      localObject = ADCUtil.load_file(ADC.end_card_mraid_filepath, "");
      ADCLog.dev.println("Injecting mraid");
      execute_javascript((String)localObject);
      if (ADC.is_tablet)
      {
        localObject = "true";
        execute_javascript("var is_tablet=" + (String)localObject + ";");
        if (!ADC.is_tablet) {
          break label439;
        }
      }
      label439:
      for (localObject = "tablet";; localObject = "phone")
      {
        execute_javascript("adc_bridge.adc_version='" + ADC.sdk_version + "'");
        execute_javascript("adc_bridge.os_version='" + ADC.os_version + "'");
        execute_javascript("adc_bridge.os_name='android'");
        execute_javascript("adc_bridge.device_type='" + (String)localObject + "'");
        execute_javascript("adc_bridge.fireChangeEvent({state:'default'});");
        execute_javascript("adc_bridge.fireReadyEvent()");
        if (Build.VERSION.SDK_INT < 19) {
          this.end_card_web_view.loadUrl(ADC.end_card_url);
        }
        return;
        localObject = "false";
        break;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  int textWidthOf(String paramString)
  {
    this.button_text_paint.getTextWidths(paramString, widths);
    float f = 0.0F;
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      f += widths[i];
      i += 1;
    }
    return (int)f;
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
      ADCVideoHUD.this.browser_icon.draw(paramCanvas, (this.bounds.width() - ADCVideoHUD.this.browser_icon.width) / 2, (this.bounds.height() - ADCVideoHUD.this.browser_icon.height) / 2);
      invalidate();
    }
  }
  
  class UpdateHandler
    extends Handler
  {
    UpdateHandler()
    {
      check_back_later();
    }
    
    void check_back_later()
    {
      sendMessageDelayed(obtainMessage(), 500L);
    }
    
    public void handleMessage(Message paramMessage)
    {
      check_back_later();
      if (ADCVideoHUD.this.activity.isFinishing()) {}
      while (ADCVideoHUD.this.activity.video_view == null) {
        return;
      }
      try
      {
        if ((ADCVideoHUD.this.dissolve_timer != null) && (ADCVideoHUD.this.dissolve_timer.expired()) && (!ADCVideoHUD.this.activity.video_view.isPlaying()))
        {
          ADCVideoHUD.this.dissolve_timer = null;
          ADCVideoHUD.this.selected_button = 0;
          if (ADCVideoHUD.this.activity.video_view != null) {
            ADCVideoHUD.this.activity.video_view.stopPlayback();
          }
          ADCVideoHUD.this.activity.endcard_dissolved = true;
          ADCVideoHUD.this.handle_continue();
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCVideoHUD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
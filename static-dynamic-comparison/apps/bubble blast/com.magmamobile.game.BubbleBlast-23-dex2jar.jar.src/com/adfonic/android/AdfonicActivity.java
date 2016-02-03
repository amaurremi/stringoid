package com.adfonic.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.adfonic.android.utils.Base64;
import com.adfonic.android.utils.HtmlFormatter;
import com.adfonic.android.utils.Log;

public class AdfonicActivity
  extends Activity
{
  private static final String AUDIO_TYPE = "audio";
  private static final String ENCODED_IMAGE = "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBNYWNpbnRvc2giIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6RUMxNUFDNkIzMDg2MTFFMTk2MDBBQUZDMDU2MEMzRDciIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6RUMxNUFDNkMzMDg2MTFFMTk2MDBBQUZDMDU2MEMzRDciPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDpFQzE1QUM2OTMwODYxMUUxOTYwMEFBRkMwNTYwQzNENyIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDpFQzE1QUM2QTMwODYxMUUxOTYwMEFBRkMwNTYwQzNENyIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/Pk0EGf8AAAaKSURBVHjavFhpSFVb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";
  private static final String INTENT_EXTRA_ACTIVITY_START_TYPE = "activityStartType";
  private static final String INTENT_EXTRA_AFTER_MEDIA_URL = "afterMediaUrl";
  private static final String INTENT_EXTRA_MEDIA_TYPE = "mediaType";
  private static final String INTENT_EXTRA_MEDIA_URL = "mediaUrl";
  private static final String INTENT_EXTRA_URL = "url";
  private static final String INTENT_INTERSTITIAL_AD = "interstitialAd";
  private static final int INTERSTITIAL_TIMEOUT = 3000;
  private static final String MEDIA_PLAYER = "MEDIA_PLAYER";
  private static final String VIDEO_TYPE = "video";
  private String activityStartType = "";
  private String afterMediaUrl;
  private Handler mainHandler;
  private MediaController mediaController;
  private VideoView mediaPlayerView;
  private String mediaUrl;
  private Uri uri;
  
  private LinearLayout buildLayoutContainer()
  {
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localLinearLayout.setGravity(17);
    return localLinearLayout;
  }
  
  private void createLayout(Uri paramUri, String paramString, ViewGroup paramViewGroup)
  {
    WebView localWebView = new WebView(this);
    localWebView.getSettings().setJavaScriptEnabled(true);
    localWebView.getSettings().setBuiltInZoomControls(true);
    if (paramUri != null) {
      localWebView.loadUrl(paramUri.toString());
    }
    for (;;)
    {
      keepAllWebContentInsideWebView(localWebView);
      paramViewGroup.addView(localWebView);
      return;
      localWebView.loadDataWithBaseURL(null, new HtmlFormatter().applyHtmlFormatting(paramString), "text/html", "utf-8", null);
    }
  }
  
  private void disableWindowTitle()
  {
    requestWindowFeature(1);
  }
  
  private void getIntentParameters()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      this.mediaUrl = localBundle.getString("mediaUrl");
      this.afterMediaUrl = localBundle.getString("afterMediaUrl");
      this.activityStartType = localBundle.getString("activityStartType");
    }
    this.uri = getUri(getIntent());
  }
  
  public static Intent getOpenUrlIntent(String paramString, Context paramContext)
  {
    paramContext = new Intent(paramContext, AdfonicActivity.class);
    paramContext.setFlags(524288);
    paramContext.setFlags(536870912);
    paramContext.setFlags(8388608);
    paramContext.putExtra("url", paramString);
    return paramContext;
  }
  
  public static Intent getPlayAudioIntent(String paramString, Context paramContext)
  {
    return getPlayMediaIntent(paramString, "audio", paramContext);
  }
  
  private static Intent getPlayMediaIntent(String paramString1, String paramString2, Context paramContext)
  {
    paramString2 = new Intent(paramContext, AdfonicActivity.class);
    paramString2.putExtra("mediaUrl", paramString1);
    paramString2.putExtra("mediaType", "video");
    paramString2.putExtra("activityStartType", "MEDIA_PLAYER");
    return paramString2;
  }
  
  public static Intent getPlayVideoIntent(String paramString, Context paramContext)
  {
    return getPlayMediaIntent(paramString, "video", paramContext);
  }
  
  public static Intent getStartInterstitialIntent(String paramString, Context paramContext)
  {
    paramContext = new Intent(paramContext, AdfonicActivity.class);
    paramContext.putExtra("interstitialAd", paramString);
    return paramContext;
  }
  
  private Uri getUri(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("url");
    if (TextUtils.isEmpty(paramIntent)) {
      return null;
    }
    try
    {
      paramIntent = Uri.parse(paramIntent);
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  private boolean hasVideoFinishedPlaying()
  {
    return (this.mediaPlayerView == null) || (!this.mediaPlayerView.isPlaying());
  }
  
  private boolean isInterstitial()
  {
    Intent localIntent = getIntent();
    if (localIntent == null) {}
    while (!localIntent.hasExtra("interstitialAd")) {
      return false;
    }
    return true;
  }
  
  private boolean isMediaPlayer()
  {
    return "MEDIA_PLAYER".equals(this.activityStartType);
  }
  
  private void keepAllWebContentInsideWebView(WebView paramWebView)
  {
    paramWebView.setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (paramAnonymousString.startsWith("market://")) {}
        try
        {
          paramAnonymousWebView = new Intent();
          paramAnonymousWebView.setAction("android.intent.action.VIEW");
          paramAnonymousWebView.setData(Uri.parse(paramAnonymousString));
          AdfonicActivity.this.startActivity(paramAnonymousWebView);
          AdfonicActivity.this.finish();
          for (;;)
          {
            return false;
            paramAnonymousWebView.loadUrl(paramAnonymousString);
          }
        }
        catch (Exception paramAnonymousWebView)
        {
          for (;;) {}
        }
      }
    });
  }
  
  private void prepareVideo(final MediaController paramMediaController)
  {
    this.mediaPlayerView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
    {
      public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AdfonicActivity.this.mainHandler.post(new Runnable()
        {
          public void run()
          {
            try
            {
              AdfonicActivity.this.mediaPlayerView.start();
              AdfonicActivity.5.this.val$mediaController.show(0);
              AdfonicActivity.this.mediaPlayerView.invalidate();
              return;
            }
            catch (Exception localException)
            {
              while (!Log.errorLoggingEnabled()) {}
              Log.e("Handler Exception " + localException.getMessage());
            }
          }
        });
      }
    });
  }
  
  private void restartVideo()
  {
    if (!this.mediaPlayerView.isPlaying()) {
      this.mediaPlayerView.start();
    }
  }
  
  private void setCloseButtonImageBitmap(ImageView paramImageView)
  {
    try
    {
      byte[] arrayOfByte = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBNYWNpbnRvc2giIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6RUMxNUFDNkIzMDg2MTFFMTk2MDBBQUZDMDU2MEMzRDciIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6RUMxNUFDNkMzMDg2MTFFMTk2MDBBQUZDMDU2MEMzRDciPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDpFQzE1QUM2OTMwODYxMUUxOTYwMEFBRkMwNTYwQzNENyIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDpFQzE1QUM2QTMwODYxMUUxOTYwMEFBRkMwNTYwQzNENyIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/Pk0EGf8AAAaKSURBVHjavFhpSFVb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".getBytes(), 0);
      paramImageView.setImageBitmap(BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
      return;
    }
    catch (Exception paramImageView) {}
  }
  
  private void setCompletionListener()
  {
    this.mediaPlayerView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AdfonicActivity.this.startBrowserIfNecessary();
      }
    });
  }
  
  private void setErrorListener()
  {
    this.mediaPlayerView.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public boolean onError(MediaPlayer paramAnonymousMediaPlayer, final int paramAnonymousInt1, final int paramAnonymousInt2)
      {
        AdfonicActivity.this.mainHandler.post(new Runnable()
        {
          public void run()
          {
            if (Log.errorLoggingEnabled()) {
              Log.e("Error playing ad media. What=" + paramAnonymousInt1 + " extra=" + paramAnonymousInt2);
            }
          }
        });
        return true;
      }
    });
  }
  
  private void setInterstitialTimeout()
  {
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        try
        {
          AdfonicActivity.this.finish();
          return;
        }
        catch (Exception localException) {}
      }
    }, 3000L);
  }
  
  private void setNoTitleAndFullScreen()
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
  
  private void setupMediaPlayer()
  {
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localLinearLayout.setKeepScreenOn(true);
    localLinearLayout.setOrientation(1);
    FrameLayout localFrameLayout = new FrameLayout(this);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localFrameLayout.setForegroundGravity(17);
    this.mediaPlayerView = new VideoView(this);
    this.mediaPlayerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
    this.mediaController = new MediaController(this);
    this.mediaController.setAnchorView(localFrameLayout);
    this.mediaController.setMediaPlayer(this.mediaPlayerView);
    this.mediaPlayerView.setMediaController(this.mediaController);
    localLinearLayout.addView(localFrameLayout);
    localFrameLayout.addView(this.mediaPlayerView);
    setContentView(localLinearLayout);
    prepareVideo(this.mediaController);
    setErrorListener();
    setCompletionListener();
  }
  
  private void showInterstitialContent()
  {
    Object localObject = getIntent().getStringExtra("interstitialAd");
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LinearLayout localLinearLayout = buildLayoutContainer();
    createLayout(null, (String)localObject, localLinearLayout);
    localObject = new ImageView(this);
    setCloseButtonImageBitmap((ImageView)localObject);
    ((ImageView)localObject).setPadding(15, 15, 15, 15);
    ((ImageView)localObject).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AdfonicActivity.this.finish();
      }
    });
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(10, -1);
    ((ImageView)localObject).setLayoutParams(localLayoutParams);
    localRelativeLayout.addView(localLinearLayout);
    localRelativeLayout.addView((View)localObject);
    setContentView(localRelativeLayout);
  }
  
  private void startBrowser()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.afterMediaUrl));
    try
    {
      startActivity(localIntent);
      finish();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (Log.errorLoggingEnabled()) {
          Log.e("IntentBrowser Activity not found " + localException.getMessage());
        }
      }
    }
  }
  
  private void startBrowserIfNecessary()
  {
    if (this.afterMediaUrl != null) {
      startBrowser();
    }
  }
  
  private void startMedia()
  {
    Uri localUri = Uri.parse(this.mediaUrl);
    this.mediaPlayerView.setVideoURI(localUri);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    disableWindowTitle();
    this.mainHandler = new Handler();
    getIntentParameters();
    setNoTitleAndFullScreen();
    if (isMediaPlayer())
    {
      setupMediaPlayer();
      startMedia();
      return;
    }
    if (isInterstitial())
    {
      showInterstitialContent();
      setInterstitialTimeout();
      return;
    }
    if (this.uri == null)
    {
      finish();
      return;
    }
    paramBundle = buildLayoutContainer();
    createLayout(this.uri, null, paramBundle);
    setContentView(paramBundle);
  }
  
  public void onDestroy()
  {
    if (isMediaPlayer()) {
      this.mainHandler.post(new Runnable()
      {
        public void run()
        {
          try
          {
            if (AdfonicActivity.this.hasVideoFinishedPlaying()) {
              return;
            }
            AdfonicActivity.this.mediaPlayerView.stopPlayback();
            return;
          }
          catch (Exception localException)
          {
            if (Log.errorLoggingEnabled()) {
              Log.e("Stop playback error " + localException);
            }
          }
        }
      });
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!isMediaPlayer()) {}
    while (hasVideoFinishedPlaying()) {
      return;
    }
    this.mediaPlayerView.pause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (isMediaPlayer()) {
      restartVideo();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/AdfonicActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
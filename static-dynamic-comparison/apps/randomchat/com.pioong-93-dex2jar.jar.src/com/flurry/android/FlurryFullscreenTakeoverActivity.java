package com.flurry.android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.MimeTypeMap;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import java.util.Collections;

public final class FlurryFullscreenTakeoverActivity
  extends Activity
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  public static final String EXTRA_KEY_ADSPACENAME = "adSpaceName";
  public static final String EXTRA_KEY_FRAMEINDEX = "frameIndex";
  public static final String EXTRA_KEY_TARGETINTENT = "targetIntent";
  public static final String EXTRA_KEY_URL = "url";
  private static final String d = FlurryFullscreenTakeoverActivity.class.getSimpleName();
  private cl A;
  private ProgressDialog B;
  private VideoView C;
  private boolean D;
  private MediaController E;
  private boolean F;
  private Intent G;
  private String H;
  private bn y;
  private FrameLayout z;
  
  private static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(paramString));
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.startsWith("video/")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.C == null) || (this.z == null)) {}
    do
    {
      return;
      this.E = new MediaController(this);
      this.C.setOnPreparedListener(this);
      this.C.setOnCompletionListener(this);
      this.C.setOnErrorListener(this);
      this.C.setMediaController(this.E);
      this.C.setVideoURI(Uri.parse(paramString));
      this.z.addView(this.C, new FrameLayout.LayoutParams(-1, -1, 17));
      this.B = new ProgressDialog(this);
      this.B.setProgressStyle(0);
      this.B.setMessage("Loading...");
      this.B.setCancelable(true);
      this.B.show();
    } while (this.A == null);
    this.A.setVisibility(8);
  }
  
  private void e()
  {
    if (this.B != null)
    {
      if (this.B.isShowing()) {
        this.B.dismiss();
      }
      this.B = null;
    }
    if (this.A != null) {
      this.A.setVisibility(0);
    }
    if (this.C != null)
    {
      if (this.C.isPlaying()) {
        this.C.stopPlayback();
      }
      if (this.z != null) {
        this.z.removeView(this.C);
      }
      this.C = null;
    }
    this.D = false;
    this.E = null;
  }
  
  public final void onCompletion(MediaPlayer paramMediaPlayer) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int i = -1;
    setTheme(16973831);
    super.onCreate(paramBundle);
    x.a(getWindow());
    Object localObject = getIntent();
    this.G = ((Intent)((Intent)localObject).getParcelableExtra("targetIntent"));
    this.H = ((Intent)localObject).getStringExtra("adSpaceName");
    if (this.G != null) {}
    for (;;)
    {
      boolean bool;
      try
      {
        startActivity(this.G);
        if (this.H != null)
        {
          paramBundle = FlurryAds.getInstance();
          localObject = this.H;
          if (this.G == null) {
            break label359;
          }
          bool = true;
          paramBundle.b((String)localObject, bool);
        }
        return;
      }
      catch (ActivityNotFoundException paramBundle)
      {
        db.b(d, "Cannot launch Activity", paramBundle);
        this.G = null;
        finish();
        continue;
      }
      String str = ((Intent)localObject).getStringExtra("url");
      if (str == null)
      {
        if (paramBundle == null) {}
        for (;;)
        {
          int j = i;
          if (i < 0) {
            j = ((Intent)localObject).getIntExtra("frameIndex", 0);
          }
          paramBundle = FlurryAds.getInstance();
          if (paramBundle.X() == null) {
            break;
          }
          this.y = new bn(this, paramBundle, paramBundle.W(), paramBundle.X(), j);
          this.y.initLayout(this);
          if (j == 0) {
            this.y.a("rendered", Collections.emptyMap());
          }
          setContentView(this.y);
          break;
          i = paramBundle.getInt("frameIndex", -1);
        }
      }
      this.z = new FrameLayout(this);
      setContentView(this.z);
      if (a(str))
      {
        this.C = new ce(this);
        b(str);
      }
      else
      {
        this.A = new cl(this, str);
        this.A.a(new f(this));
        this.A.a(new y(this));
        this.A.a(new bh(this));
        this.z.addView(this.A);
        continue;
        label359:
        bool = false;
      }
    }
  }
  
  protected final void onDestroy()
  {
    e();
    if (this.A != null) {
      this.A.destroy();
    }
    if (this.y != null) {
      this.y.stop();
    }
    if ((isFinishing()) && (this.H != null)) {
      FlurryAds.getInstance().j(this.H);
    }
    super.onDestroy();
  }
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    db.d(d, "error occurs during video playback");
    if (this.A != null) {
      if (this.D) {
        if (this.A.canGoBack())
        {
          this.A.goBack();
          e();
        }
      }
    }
    for (;;)
    {
      return true;
      finish();
      continue;
      e();
      continue;
      finish();
    }
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.y != null)
      {
        this.y.a("adWillClose", Collections.emptyMap(), this.y.M, this.y.L, this.y.N, 0);
        return true;
      }
      if (this.C != null)
      {
        if (this.A != null) {
          if (this.D)
          {
            if (this.A.canGoBack())
            {
              this.A.goBack();
              e();
              return true;
            }
          }
          else
          {
            e();
            return true;
          }
        }
      }
      else if ((this.A != null) && (this.A.canGoBack()))
      {
        this.A.goBack();
        return true;
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected final void onPause()
  {
    super.onPause();
    this.F = false;
    if ((this.C != null) && (this.C.isPlaying())) {
      this.C.pause();
    }
  }
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if ((this.B != null) && (this.B.isShowing())) {
      this.B.dismiss();
    }
    if ((this.C != null) && (this.F)) {
      this.C.start();
    }
  }
  
  protected final void onRestart()
  {
    super.onRestart();
  }
  
  protected final void onResume()
  {
    super.onResume();
    this.F = true;
    if (this.E != null) {
      this.E.show(0);
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.y != null) {
      paramBundle.putInt("frameIndex", this.y.N);
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    if (FlurryAgent.w() != null)
    {
      FlurryAgent.onStartSession(this, FlurryAgent.w());
      return;
    }
    finish();
  }
  
  public final void onStop()
  {
    FlurryAgent.onEndSession(this);
    super.onStop();
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    new StringBuilder().append("onWindowFocusChanged hasFocus = ").append(paramBoolean).toString();
    if ((this.F) && (paramBoolean) && (this.G != null)) {
      finish();
    }
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/FlurryFullscreenTakeoverActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
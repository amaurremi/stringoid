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
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.MimeTypeMap;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import com.flurry.android.monolithic.sdk.impl.ar;
import com.flurry.android.monolithic.sdk.impl.ay;
import com.flurry.android.monolithic.sdk.impl.b;
import com.flurry.android.monolithic.sdk.impl.c;
import com.flurry.android.monolithic.sdk.impl.cq;
import com.flurry.android.monolithic.sdk.impl.d;
import com.flurry.android.monolithic.sdk.impl.ja;
import com.flurry.android.monolithic.sdk.impl.n;
import com.flurry.android.monolithic.sdk.impl.o;
import java.util.Collections;

public final class FlurryFullscreenTakeoverActivity
  extends Activity
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  public static final String EXTRA_KEY_ADSPACENAME = "adSpaceName";
  public static final String EXTRA_KEY_FRAMEINDEX = "frameIndex";
  public static final String EXTRA_KEY_TARGETINTENT = "targetIntent";
  public static final String EXTRA_KEY_URL = "url";
  private static final String a = FlurryFullscreenTakeoverActivity.class.getSimpleName();
  private o b;
  private AdUnit c;
  private ViewGroup d;
  private ar e;
  private ProgressDialog f;
  private VideoView g;
  private boolean h;
  private MediaController i;
  private boolean j;
  private Intent k;
  private long l;
  private String m;
  private ay n = ay.a;
  
  private void a()
  {
    if (this.f != null)
    {
      if (this.f.isShowing()) {
        this.f.dismiss();
      }
      this.f = null;
    }
    if (this.e != null) {
      this.e.setVisibility(0);
    }
    if (this.g != null)
    {
      if (this.g.isPlaying()) {
        this.g.stopPlayback();
      }
      if (this.d != null) {
        this.d.removeView(this.g);
      }
      this.g = null;
    }
    this.h = false;
    this.i = null;
  }
  
  private boolean a(String paramString)
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
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      paramString2 = Uri.parse(paramString2).getQueryParameter("link");
    } while ((TextUtils.isEmpty(paramString2)) || (!paramString2.equalsIgnoreCase(paramString1)));
    return true;
  }
  
  private boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      bool1 = bool2;
      if (paramString.getScheme() != null)
      {
        bool1 = bool2;
        if (paramString.getScheme().equals("market")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.g == null) || (this.d == null)) {}
    do
    {
      return;
      this.i = new MediaController(this);
      this.g.setOnPreparedListener(this);
      this.g.setOnCompletionListener(this);
      this.g.setOnErrorListener(this);
      this.g.setMediaController(this.i);
      this.g.setVideoURI(Uri.parse(paramString));
      this.d.addView(this.g, new FrameLayout.LayoutParams(-1, -1, 17));
      this.f = new ProgressDialog(this);
      this.f.setProgressStyle(0);
      this.f.setMessage("Loading...");
      this.f.setCancelable(true);
      this.f.show();
    } while (this.e == null);
    this.e.setVisibility(8);
  }
  
  public AdUnit getAdUnit()
  {
    return this.c;
  }
  
  public o getAdUnityView()
  {
    return this.b;
  }
  
  public ay getResult()
  {
    return this.n;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    ja.a(3, a, "onCompletion");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    ja.a(3, a, "onConfigurationChange");
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i1 = -1;
    ja.a(3, a, "onCreate");
    setTheme(16973831);
    super.onCreate(paramBundle);
    cq.a(getWindow());
    Intent localIntent = getIntent();
    this.k = ((Intent)localIntent.getParcelableExtra("targetIntent"));
    this.m = localIntent.getStringExtra("adSpaceName");
    if (this.k != null) {}
    for (;;)
    {
      try
      {
        startActivity(this.k);
        this.l = SystemClock.elapsedRealtime();
        FlurryAdModule.getInstance().a(this, paramBundle);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        ja.b(a, "Cannot launch Activity", localActivityNotFoundException);
        this.k = null;
        finish();
        continue;
      }
      String str = localActivityNotFoundException.getStringExtra("url");
      if (str == null)
      {
        this.d = new RelativeLayout(this);
        if (paramBundle == null) {}
        for (;;)
        {
          int i2 = i1;
          if (i1 < 0) {
            i2 = localActivityNotFoundException.getIntExtra("frameIndex", 0);
          }
          Object localObject = FlurryAdModule.getInstance();
          this.c = ((FlurryAdModule)localObject).H();
          if (this.c == null) {
            break label270;
          }
          this.b = new o(this, (FlurryAdModule)localObject, ((FlurryAdModule)localObject).G(), this.c, i2);
          this.b.initLayout();
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(13);
          this.d.addView(this.b, (ViewGroup.LayoutParams)localObject);
          setContentView(this.d);
          break;
          i1 = paramBundle.getInt("frameIndex", -1);
        }
        label270:
        ja.a(3, a, "appSpotModule.getTakeoverAdUnit() IS null ");
      }
      else
      {
        this.d = new FrameLayout(this);
        setContentView(this.d);
        if (a(str))
        {
          this.g = new n(this);
          c(str);
        }
        else
        {
          this.e = new ar(this, str);
          this.e.setBasicWebViewUrlLoadingHandler(new d(this, null));
          this.e.setBasicWebViewClosingHandler(new b(this, null));
          this.e.setBasicWebViewFullScreenTransitionHandler(new c(this, null));
          this.d.addView(this.e);
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    ja.a(3, a, "onDestroy");
    a();
    if (this.e != null) {
      this.e.c();
    }
    if (this.b != null) {
      this.b.stop();
    }
    FlurryAdModule.getInstance().b(this);
    super.onDestroy();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    ja.a(3, a, "onError");
    ja.b(a, "Error occurs during video playback");
    if (this.e != null) {
      if (this.h) {
        if (this.e.a())
        {
          this.e.b();
          a();
        }
      }
    }
    for (;;)
    {
      return true;
      finish();
      continue;
      a();
      continue;
      finish();
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.b != null)
      {
        this.b.a("adWillClose", Collections.emptyMap(), this.b.getAdUnit(), this.b.getAdLog(), this.b.getAdFrameIndex(), 0);
        return true;
      }
      if (this.g != null)
      {
        if (this.e != null) {
          if (this.h)
          {
            if (this.e.a())
            {
              this.e.b();
              a();
              return true;
            }
          }
          else
          {
            a();
            return true;
          }
        }
      }
      else if (this.e != null)
      {
        if (this.e.a()) {
          this.e.b();
        }
        for (;;)
        {
          return true;
          this.n = ay.b;
          finish();
        }
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    ja.a(3, a, "onPause");
    super.onPause();
    this.j = false;
    if ((this.g != null) && (this.g.isPlaying())) {
      this.g.pause();
    }
    if (this.b != null) {
      this.b.c();
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    ja.a(3, a, "onPrepared");
    if ((this.f != null) && (this.f.isShowing())) {
      this.f.dismiss();
    }
    if ((this.g != null) && (this.j)) {
      this.g.start();
    }
  }
  
  protected void onRestart()
  {
    ja.a(3, a, "onRestart");
    super.onRestart();
  }
  
  protected void onResume()
  {
    ja.a(3, a, "onResume");
    super.onResume();
    this.j = true;
    if (this.i != null) {
      this.i.show(0);
    }
    if (this.b != null) {
      this.b.b();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.b != null) {
      paramBundle.putInt("frameIndex", this.b.getAdFrameIndex());
    }
  }
  
  public void onStart()
  {
    ja.a(3, a, "onStart");
    super.onStart();
    if (FlurryAdModule.getInstance().f() != null)
    {
      FlurryAgent.onStartSession(this, FlurryAdModule.getInstance().f());
      return;
    }
    finish();
  }
  
  public void onStop()
  {
    ja.a(3, a, "onStop");
    FlurryAgent.onEndSession(this);
    super.onStop();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    ja.a(3, a, "onWindowFocusChanged hasFocus = " + paramBoolean);
    if ((this.j) && (paramBoolean) && (this.k != null) && (SystemClock.elapsedRealtime() - this.l > 250L))
    {
      ja.a(3, a, "terminate this launcher activity because launched activity was terminated or wasn't launched");
      finish();
    }
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/FlurryFullscreenTakeoverActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
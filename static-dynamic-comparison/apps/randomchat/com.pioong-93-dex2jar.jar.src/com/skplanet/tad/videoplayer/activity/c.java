package com.skplanet.tad.videoplayer.activity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.skplanet.tad.videoplayer.activity.core.TadSurfaceView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class c
  extends com.skplanet.tad.videoplayer.activity.core.d
  implements a
{
  public static boolean o = false;
  public boolean A = false;
  public int B = 0;
  public final String C = "HTC Raider X710e";
  BroadcastReceiver D = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getAction();
      if (paramAnonymousContext.equals("com.sktelecom.tad.vodplayer.util.ACTION_TAD_ALARM"))
      {
        com.skplanet.tad.videoplayer.util.b.a("onReceive: " + paramAnonymousContext.toString());
        com.skplanet.tad.videoplayer.util.b.a("isOnpause: " + c.this.A);
        if (c.this.A) {
          c.this.M.finish();
        }
      }
    }
  };
  public View.OnClickListener E = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      com.skplanet.tad.videoplayer.util.b.a("OnClickListener clickListener = new OnClickListener()->onClick(View v)");
      try
      {
        c.this.X = c.a(c.this, paramAnonymousView.getId());
        switch (paramAnonymousView.getId())
        {
        case 1: 
          com.skplanet.tad.videoplayer.util.b.a("case ConstVideo.CLICK_AD :");
          if (c.this.X) {
            return;
          }
          c.this.X = true;
          c.this.K.removeMessages(2);
          c.this.b(Integer.valueOf(paramAnonymousView.getTag().toString()).intValue());
          return;
        }
      }
      catch (Exception paramAnonymousView)
      {
        paramAnonymousView.printStackTrace();
        return;
      }
      com.skplanet.tad.videoplayer.util.b.a("ConstVideo.CLICK_REPLAY :");
      if (!c.this.X)
      {
        c.this.X = true;
        c.this.k();
        c.this.e.b(false);
        c.a(c.this);
        c.this.e.q.setProgress(0);
        c.this.e.o.setText(c.a(c.this, 0, true));
        c.this.K.sendEmptyMessageDelayed(2, 500L);
        c.this.e.b(false);
        if (!c.this.n)
        {
          c.this.g.a(new com.skplanet.tad.videoplayer.data.d("R"));
          return;
          if (!c.this.X)
          {
            com.skplanet.tad.videoplayer.util.b.a("이전동영상버튼 클릭");
            c.this.K.removeMessages(2);
            c.this.X = true;
            c.this.V = false;
            c.this.z = 0;
            c.this.e.a(false);
            c.this.e.n.setText(c.this.f.e);
            c.this.a(false);
            if (c.this.e(c.this.z)) {
              c.o = true;
            }
            c.b(c.this);
            c.this.a(c.this.f.d);
            return;
            c.this.M.finish();
            return;
            c.this.a(1);
            return;
            c.this.k();
            c.this.a(false);
            if (Build.MODEL.contains("HTC Raider X710e"))
            {
              com.skplanet.tad.videoplayer.util.b.a("++++surfaceView.setBackgroundColor(Color.TRANSPARENT)");
              c.this.P.setBackgroundColor(0);
            }
            c.this.u();
            c.this.K.sendEmptyMessageDelayed(2, 500L);
            return;
          }
        }
      }
    }
  };
  View.OnTouchListener F = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      boolean bool = true;
      com.skplanet.tad.videoplayer.util.b.a("mVideoTouchListener-mIsShowToolBar:" + c.this.l);
      try
      {
        if ((c.this.O != null) && (!c.this.O.isPlaying())) {
          return false;
        }
        if (2 == c.this.N.getConfiguration().orientation)
        {
          if (c.this.k < 0)
          {
            paramAnonymousView = c.this.M.getWindowManager().getDefaultDisplay();
            c.this.k = paramAnonymousView.getHeight();
          }
          com.skplanet.tad.videoplayer.util.b.a("landHeight:" + c.this.k);
          if ((!c.this.l) || ((paramAnonymousMotionEvent.getY() > com.skplanet.tad.videoplayer.activity.core.a.b) && (paramAnonymousMotionEvent.getY() <= c.this.k - com.skplanet.tad.videoplayer.activity.core.a.c)))
          {
            if (c.this.l) {
              c.this.K.removeMessages(1);
            }
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              paramAnonymousView = c.this;
              if (c.this.l) {
                bool = false;
              }
              paramAnonymousView.b(bool);
              return false;
            }
          }
        }
      }
      catch (Exception paramAnonymousView)
      {
        paramAnonymousView.printStackTrace();
      }
      return false;
    }
  };
  Animation.AnimationListener G = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      c.this.e.j.setVisibility(0);
    }
    
    public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  Animation.AnimationListener H = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      com.skplanet.tad.videoplayer.util.b.a("onAnimationEnd-mIsShowToolBar:" + c.this.l);
      try
      {
        if (c.this.l)
        {
          c.this.e.g.setVisibility(0);
          if ((c.this.V) || (c.this.e.G) || (c.this.e(c.this.z)))
          {
            if (c.this.e.G) {
              c.this.e.h.setVisibility(0);
            }
            if (c.this.e(c.this.z)) {
              c.this.e.k.setVisibility(0);
            }
          }
          if ((c.this.O != null) && (c.this.O.isPlaying())) {
            c.this.k();
          }
        }
        else
        {
          c.this.e.g.setVisibility(4);
          if ((c.this.V) || (c.this.e.G) || (c.this.e(c.this.z)))
          {
            if (c.this.e.G) {
              c.this.e.h.setVisibility(4);
            }
            if (c.this.e(c.this.z)) {
              c.this.e.k.setVisibility(4);
            }
          }
          c.this.K.removeMessages(1);
          return;
        }
      }
      catch (Exception paramAnonymousAnimation)
      {
        paramAnonymousAnimation.printStackTrace();
      }
    }
    
    public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  SeekBar.OnSeekBarChangeListener I = new SeekBar.OnSeekBarChangeListener()
  {
    public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      c.this.e.b(false);
    }
    
    public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
    
    public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
    {
      com.skplanet.tad.videoplayer.util.b.a("onAnimationEnd-onStopTrackingTouch:");
      if (c.this.e != null)
      {
        com.skplanet.tad.videoplayer.util.b.a("lm.replayLayout(false);// 다시보기 버튼 숨김.");
        c.this.e.c(false);
      }
      try
      {
        if ((c.this.O != null) && (!c.this.O.isPlaying()))
        {
          c.this.k();
          c.this.K.sendEmptyMessageDelayed(2, 500L);
        }
        c.b(c.this, paramAnonymousSeekBar.getProgress());
        if ((c.this.m) && (c.this.O != null))
        {
          c.this.m = false;
          c.this.i = new com.skplanet.tad.videoplayer.data.d("P", c.c(c.this, c.this.O.getCurrentPosition()), "");
        }
        return;
      }
      catch (Exception paramAnonymousSeekBar)
      {
        paramAnonymousSeekBar.printStackTrace();
      }
    }
  };
  BroadcastReceiver J = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      com.skplanet.tad.videoplayer.util.b.a("screenReceiver");
    }
  };
  Handler K = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      for (boolean bool = false;; bool = true) {
        try
        {
          switch (paramAnonymousMessage.what)
          {
          case 1: 
            if (2 != c.this.N.getConfiguration().orientation) {
              break label168;
            }
            c.this.K.sendEmptyMessageDelayed(1, 1000L);
            com.skplanet.tad.videoplayer.util.b.a("mInputDetectHandler-interval:" + (System.currentTimeMillis() - c.this.j));
            if (System.currentTimeMillis() - c.this.j <= 3000L) {
              return;
            }
            c.this.K.removeMessages(1);
            if (c.this.O == null) {
              return;
            }
            paramAnonymousMessage = c.this;
            if (c.this.l)
            {
              paramAnonymousMessage.b(bool);
              return;
            }
            break;
          }
        }
        catch (Exception paramAnonymousMessage)
        {
          paramAnonymousMessage.printStackTrace();
          return;
        }
      }
      label168:
      c.this.K.removeMessages(1);
      return;
      c.this.K.sendEmptyMessageDelayed(2, 500L);
      if ((c.this.e.o != null) && (c.this.O != null))
      {
        if ((c.this.O.getCurrentPosition() >= 0) && (c.this.O.getCurrentPosition() < 3600000))
        {
          c.this.e.o.setText(c.a(c.this, c.this.O.getCurrentPosition(), true));
          c.this.e.q.setProgress(c.this.O.getCurrentPosition());
          return;
        }
        c.this.e.o.setText(c.a(c.this, 0, true));
        c.this.e.q.setProgress(0);
        return;
        Toast.makeText(c.this.M, "네트워크에 문제가 발생하였습니다.", 0).show();
        return;
        if (c.this.O == null) {
          c.this.M.finish();
        }
        try
        {
          if (c.this.O != null)
          {
            com.skplanet.tad.videoplayer.util.b.a("PLAY_TIMEOUT-mediaPlayer.isPlaying():" + c.this.O.isPlaying());
            if (!c.this.O.isPlaying())
            {
              c.this.M.finish();
              return;
            }
          }
        }
        catch (Exception paramAnonymousMessage)
        {
          paramAnonymousMessage.printStackTrace();
          return;
        }
      }
    }
  };
  public ProgressDialog a;
  public Animation b;
  public Animation c;
  public Animation d;
  public com.skplanet.tad.videoplayer.activity.core.c e;
  public com.skplanet.tad.videoplayer.data.b f;
  public com.skplanet.tad.videoplayer.manager.c g;
  public com.skplanet.tad.videoplayer.data.d h;
  public com.skplanet.tad.videoplayer.data.d i;
  public long j;
  public int k = -1;
  public boolean l = true;
  public boolean m = true;
  public boolean n = false;
  public int p;
  public c q;
  public boolean r = false;
  public int s = -1;
  public long t = -1L;
  public boolean u = false;
  public boolean v = false;
  public boolean w = false;
  public boolean x = false;
  public boolean y = false;
  public int z = 0;
  
  public c(Activity paramActivity)
  {
    this.M = paramActivity;
    this.N = this.M.getResources();
  }
  
  private String b(int paramInt, boolean paramBoolean)
  {
    int i2 = paramInt / 1000;
    paramInt = i2 / 3600;
    int i1 = i2 % 3600 / 60;
    i2 = i2 % 3600 % 60;
    if (paramInt > 0) {
      return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(i2) });
    }
    if ((i1 > 0) || (paramBoolean)) {
      return String.format("%02d:%02d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) });
    }
    return String.format("%02d", new Object[] { Integer.valueOf(i2) });
  }
  
  private void c(boolean paramBoolean)
  {
    com.skplanet.tad.videoplayer.util.b.a("VodVideoPlayer--vpLogSend");
    try
    {
      if ((this.h != null) && (!this.n))
      {
        com.skplanet.tad.videoplayer.util.b.a(paramBoolean + ",vpLogSend-playTime:" + this.S + "/" + this.T);
        this.h.e = (this.S / 1000);
        if (this.h.e >= 3) {
          this.g.a(this.h);
        }
        if (paramBoolean) {
          this.h = null;
        }
      }
      if ((!this.m) && (this.i != null) && (!this.n))
      {
        this.i.g = h(this.S);
        this.g.a(this.i);
        if (paramBoolean) {
          this.i = null;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean g(int paramInt)
  {
    if ((this.s == paramInt) && (this.t != -1L) && (System.currentTimeMillis() - this.t < 500L)) {}
    for (boolean bool = true;; bool = false)
    {
      this.r = false;
      this.s = paramInt;
      this.t = System.currentTimeMillis();
      return bool;
    }
  }
  
  private String h(int paramInt)
  {
    com.skplanet.tad.videoplayer.util.b.a("VodVideoPlayer--calcTime");
    return b(paramInt, false);
  }
  
  private String i(int paramInt)
  {
    return Integer.toString(paramInt / 1000);
  }
  
  public static boolean n()
  {
    return o;
  }
  
  private void v()
  {
    com.skplanet.tad.videoplayer.util.b.a("VodVideoPlayer--createLayout");
    try
    {
      this.e = new com.skplanet.tad.videoplayer.activity.core.c(this);
      p();
      this.P.setOnTouchListener(this.F);
      com.skplanet.tad.videoplayer.util.b.a("act.getWindowManager().getDefaultDisplay().getWidth()= " + this.M.getWindowManager().getDefaultDisplay().getWidth());
      com.skplanet.tad.videoplayer.util.b.a("act.getWindowManager().getDefaultDisplay().getHeight()= " + this.M.getWindowManager().getDefaultDisplay().getHeight());
      this.e.a(this.P);
      w();
      this.b = new AlphaAnimation(0.0F, 1.0F);
      this.b.setDuration(400L);
      this.b.setAnimationListener(this.H);
      this.c = new AlphaAnimation(1.0F, 0.0F);
      this.c.setDuration(400L);
      this.c.setAnimationListener(this.H);
      this.d = new AlphaAnimation(0.99F, 1.0F);
      this.d.setDuration(100L);
      this.d.setAnimationListener(this.G);
      a(4);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void w()
  {
    com.skplanet.tad.videoplayer.util.b.a("VodVideoPlayer--changeLayout");
    for (;;)
    {
      try
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.P.getLayoutParams();
        if (2 != this.N.getConfiguration().orientation) {
          continue;
        }
        com.skplanet.tad.videoplayer.util.b.a("ORIENTATION_LANDSCAPE");
        localLayoutParams.height = -1;
        localLayoutParams.width = -1;
        this.P.setLayoutParams(localLayoutParams);
        com.skplanet.tad.videoplayer.util.b.a("surfaceView.setLayoutParams(svLP) svLP.height = " + localLayoutParams.height + " / svLP.width= " + localLayoutParams.width);
        this.e.a(this.N.getConfiguration().orientation);
      }
      catch (Exception localException)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        localException.printStackTrace();
        continue;
      }
      this.p = this.N.getConfiguration().orientation;
      return;
      com.skplanet.tad.videoplayer.util.b.a("ORIENTATION_PORTRAIT");
      localLayoutParams.height = com.skplanet.tad.videoplayer.activity.core.a.a;
      localLayoutParams.width = -1;
      this.P.setLayoutParams(localLayoutParams);
      com.skplanet.tad.videoplayer.util.b.a("surfaceView.setLayoutParams(svLP) svLP.height = " + localLayoutParams.height + " / svLP.width= " + localLayoutParams.width);
    }
  }
  
  public void a()
  {
    a(true);
    this.A = false;
    b(this.M.getApplicationContext());
    b(true);
    if (Build.MODEL.contains("HTC Raider X710e")) {
      this.P.setBackgroundColor(-16777216);
    }
  }
  
  public void a(int paramInt)
  {
    com.skplanet.tad.videoplayer.util.b.a("soundMute" + paramInt);
    com.skplanet.tad.videoplayer.util.b.a("soundMute: getMuteStatus()= " + com.skplanet.tad.videoplayer.activity.core.a.a());
    if (paramInt == 1) {
      if (!com.skplanet.tad.videoplayer.activity.core.a.a())
      {
        this.O.setVolume(0.0F, 0.0F);
        com.skplanet.tad.videoplayer.activity.core.a.a(true);
        this.e.a();
      }
    }
    label122:
    do
    {
      do
      {
        return;
        this.O.setVolume(1.0F, 1.0F);
        com.skplanet.tad.videoplayer.activity.core.a.a(false);
        break;
        if (paramInt != 2) {
          break label122;
        }
      } while (!com.skplanet.tad.videoplayer.activity.core.a.a());
      this.O.setVolume(1.0F, 1.0F);
      com.skplanet.tad.videoplayer.activity.core.a.a(false);
      this.e.a();
      return;
    } while (paramInt != 4);
    this.O.setVolume(0.0F, 0.0F);
    com.skplanet.tad.videoplayer.activity.core.a.a(true);
    this.e.a();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      if (this.e.q != null)
      {
        this.e.q.setMax(paramInt);
        this.e.q.setOnSeekBarChangeListener(this.I);
        Object localObject = this.e.q;
        if (paramBoolean)
        {
          i1 = paramInt;
          ((SeekBar)localObject).setProgress(i1);
          if ((this.e.o == null) || (this.e.p == null)) {
            return;
          }
          localObject = this.e.o;
          if (!paramBoolean) {
            break label130;
          }
        }
        label130:
        for (int i1 = paramInt;; i1 = this.O.getCurrentPosition())
        {
          ((TextView)localObject).setText(b(i1, true));
          this.e.p.setText(b(paramInt, true));
          return;
          i1 = this.O.getCurrentPosition();
          break;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(Context paramContext)
  {
    com.skplanet.tad.videoplayer.util.b.a("setAlarm()");
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    paramContext = PendingIntent.getBroadcast(paramContext, 0, new Intent("com.sktelecom.tad.vodplayer.util.ACTION_TAD_ALARM"), 0);
    localAlarmManager.set(1, System.currentTimeMillis() + 10000L, paramContext);
  }
  
  public void a(Configuration paramConfiguration)
  {
    com.skplanet.tad.videoplayer.util.b.a("onConfigurationChanged-isShowToolBar:" + this.l);
    com.skplanet.tad.videoplayer.util.b.a("isComplete:" + this.V);
    if (e(this.z)) {
      o = true;
    }
    for (;;)
    {
      try
      {
        if (2 != this.N.getConfiguration().orientation) {
          continue;
        }
        if ((this.l) && (this.O != null) && (this.O.isPlaying())) {
          k();
        }
        if (e(this.z)) {
          this.e.k.setVisibility(0);
        }
        w();
      }
      catch (Exception paramConfiguration)
      {
        paramConfiguration.printStackTrace();
        continue;
        com.skplanet.tad.videoplayer.util.b.a("+++++surfaceView.setBackgroundColor(Color.BLACK)2");
        this.P.setBackgroundColor(-16777216);
        continue;
      }
      if (this.V) {
        continue;
      }
      com.skplanet.tad.videoplayer.util.b.a("surfaceView.setBackgroundColor(Color.TRANSPARENT)4");
      if (!Build.MODEL.contains("HTC Raider X710e"))
      {
        com.skplanet.tad.videoplayer.util.b.a("surfaceView.setBackgroundColor(Color.TRANSPARENT)5");
        this.P.setBackgroundColor(0);
      }
      this.B = 0;
      return;
      o = false;
      continue;
      this.K.removeMessages(1);
      this.l = true;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    com.skplanet.tad.videoplayer.util.b.a("VodVideoPlayer--onCreate");
    this.M.requestWindowFeature(1);
    this.M.getWindow().setFlags(1024, 1024);
    try
    {
      paramBundle = com.skplanet.tad.videoplayer.util.a.a(this.M, this.M.getIntent());
      if (paramBundle == null)
      {
        this.M.finish();
        return;
      }
      this.f = com.skplanet.tad.videoplayer.util.a.a(this.M.getIntent());
      if (this.f == null)
      {
        this.M.finish();
        return;
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    for (;;)
    {
      this.q = this;
      ((TelephonyManager)this.M.getSystemService("phone")).listen(new PhoneStateListener()
      {
        public void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
        {
          switch (paramAnonymousInt)
          {
          case 0: 
          default: 
            return;
          }
          c.this.M.finish();
        }
      }, 32);
      paramBundle = new IntentFilter("com.sktelecom.tad.vodplayer.util.ACTION_TAD_ALARM");
      this.M.registerReceiver(this.D, paramBundle);
      return;
      com.skplanet.tad.videoplayer.util.b.a("VodStreamingPlayer:" + this.f.toString());
      if ((this.f.d == null) || ("".equals(this.f.d)))
      {
        com.skplanet.tad.videoplayer.util.c.a(this.M, "해당 URL정보가 없습니다.");
        this.M.finish();
        return;
      }
      this.R = this.f.d;
      this.a = new ProgressDialog(this.M);
      this.a.setMessage("동영상 광고 로딩중...");
      this.a.setCancelable(true);
      this.a.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          if (c.this.q != null) {
            c.this.q.M.finish();
          }
        }
      });
      com.skplanet.tad.videoplayer.activity.core.a.a(true);
      v();
      this.M.getWindow().addFlags(128);
      IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
      this.M.registerReceiver(this.J, localIntentFilter);
      this.g = new com.skplanet.tad.videoplayer.manager.c(paramBundle, this.f.b);
      this.h = new com.skplanet.tad.videoplayer.data.d();
      this.h.a = this.f.a;
      this.h.b = "V";
      this.h.c = "P";
      com.skplanet.tad.videoplayer.util.b.a("onCreate-statsV:" + this.h.a());
    }
  }
  
  public void a(String paramString)
  {
    com.skplanet.tad.videoplayer.util.b.a("VodVideoPlayer--playAd");
    if (this.e.o != null) {
      this.e.o.setText("00:00");
    }
    if (e(l())) {
      if (!this.e.k.equals(null))
      {
        this.e.k.setVisibility(0);
        this.K.sendEmptyMessageDelayed(2, 500L);
      }
    }
    for (;;)
    {
      if (this.P != null)
      {
        com.skplanet.tad.videoplayer.util.b.a("surfaceView.setBackgroundColor(Color.TRANSPARENT)6");
        this.P.setBackgroundColor(0);
      }
      try
      {
        super.a(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      if (!this.e.k.equals(null)) {
        this.e.k.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.e != null) {
      this.e.c(this.A);
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 24) || (paramInt == 25)) {
      a(2);
    }
    if (paramKeyEvent.getKeyCode() == 4)
    {
      com.skplanet.tad.videoplayer.util.b.a("onKeyDown push and VodVideoplayer act.finish()~~~~~~~~~~~~~~~");
      this.M.finish();
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b()
  {
    com.skplanet.tad.videoplayer.util.b.a("onPause - 다시보기");
    if (this.O != null)
    {
      this.S = this.O.getCurrentPosition();
      t();
      com.skplanet.tad.videoplayer.util.b.a("onPause-pause:" + this.S);
    }
    this.A = true;
    this.K.removeMessages(1);
    this.K.removeMessages(2);
    this.K.removeMessages(4);
    a(this.M.getApplicationContext());
  }
  
  public void b(int paramInt)
  {
    int i1 = 0;
    com.skplanet.tad.videoplayer.util.b.a("VodVideoPlayer--clickAd");
    for (;;)
    {
      try
      {
        if (i1 >= this.f.f.length) {
          return;
        }
        com.skplanet.tad.videoplayer.data.a locala = this.f.f[i1];
        if (paramInt == locala.a)
        {
          if ("C2PLAYER".contains(locala.c))
          {
            this.V = false;
            this.z = paramInt;
            if (!this.n)
            {
              if (this.O != null) {
                this.S = this.O.getCurrentPosition();
              }
              com.skplanet.tad.videoplayer.util.b.a("LANDING_C2PLAYER-lastPlayTime:" + this.S);
              c(false);
              this.n = true;
            }
            this.e.a(true);
            this.e.n.setText(locala.e);
            this.e.n.postInvalidate();
            a(false);
          }
          com.skplanet.tad.videoplayer.manager.b.a(this.M, this, locala.c, locala.d);
          this.g.a(new com.skplanet.tad.videoplayer.data.d("C", paramInt));
          com.skplanet.tad.videoplayer.util.b.a("Click:" + paramInt);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      i1 += 1;
    }
  }
  
  public void b(Context paramContext)
  {
    com.skplanet.tad.videoplayer.util.b.a("clearAlarm()");
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(paramContext, 0, new Intent("com.sktelecom.tad.vodplayer.util.ACTION_TAD_ALARM"), 0));
  }
  
  public void b(boolean paramBoolean)
  {
    com.skplanet.tad.videoplayer.util.b.a("VodVideoPlayer--showToolbar");
    com.skplanet.tad.videoplayer.util.b.a("showToolbar-isShow:" + paramBoolean);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (!this.l)
        {
          this.e.g.startAnimation(this.b);
          if ((this.V) || (this.e.G) || (e(this.z)))
          {
            if (this.e.G) {
              this.e.h.startAnimation(this.b);
            }
            if (e(this.z)) {
              this.e.k.startAnimation(this.b);
            }
          }
          com.skplanet.tad.videoplayer.util.b.a("showToolbar-aniShowToolbar");
        }
        this.l = paramBoolean;
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.e.g.startAnimation(this.c);
      if ((this.V) || (this.e.G) || (e(this.z)))
      {
        if (this.e.G) {
          this.e.h.startAnimation(this.c);
        }
        if (e(this.z)) {
          this.e.k.startAnimation(this.c);
        }
      }
      com.skplanet.tad.videoplayer.util.b.a("showToolbar-aniHideToolbar");
    }
  }
  
  public boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    if (this.a != null) {
      this.a.setMessage("동영상 광고 로딩중...(" + paramInt + "/100)");
    }
  }
  
  public void d()
  {
    c(false);
    com.skplanet.tad.videoplayer.util.b.a("onDestroy()");
    if (this.D != null) {
      this.M.unregisterReceiver(this.D);
    }
    if (this.J != null) {
      this.M.unregisterReceiver(this.J);
    }
    if (this.a != null) {
      this.a.dismiss();
    }
  }
  
  public void d(int paramInt)
  {
    this.K.sendEmptyMessage(3);
  }
  
  public void e()
  {
    this.j = System.currentTimeMillis();
  }
  
  public boolean e(int paramInt)
  {
    if (paramInt == 0) {
      return this.u;
    }
    if (paramInt == 1) {
      return this.v;
    }
    if (paramInt == 2) {
      return this.w;
    }
    if (paramInt == 3) {
      return this.x;
    }
    if (paramInt == 4) {
      return this.y;
    }
    return false;
  }
  
  public void f()
  {
    if (this.a != null) {
      this.a.show();
    }
    this.K.sendEmptyMessageDelayed(4, 20000L);
  }
  
  public void g()
  {
    if (this.a != null) {
      this.a.hide();
    }
  }
  
  public void h()
  {
    com.skplanet.tad.videoplayer.util.b.a("VodVideoPlayer--starttimeSave");
    try
    {
      this.e.b(false);
      this.K.removeMessages(4);
      if (this.V) {
        this.K.sendEmptyMessageDelayed(2, 500L);
      }
      if (this.h != null)
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        this.h.d = localSimpleDateFormat.format(new Date());
        com.skplanet.tad.videoplayer.util.b.a("statsV.v_startTime:" + this.h.d);
      }
      if (this.O != null) {
        a(this.O.getDuration(), false);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void i()
  {
    this.g.a(new com.skplanet.tad.videoplayer.data.d("F", 104));
  }
  
  public void j()
  {
    com.skplanet.tad.videoplayer.util.b.a("VodVideoPlayer--setComplete");
    try
    {
      if (this.h != null) {
        this.h.c = "C";
      }
      this.S = this.T;
      o = true;
      c(true);
      m();
      w();
      this.K.removeMessages(1);
      this.K.removeMessages(2);
      if (this.O != null) {
        a(this.O.getDuration(), true);
      }
      this.e.b(true);
      if (2 == this.N.getConfiguration().orientation) {
        b(true);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void k()
  {
    this.j = System.currentTimeMillis();
    this.K.sendEmptyMessageDelayed(1, 1000L);
  }
  
  public int l()
  {
    return this.z;
  }
  
  public void m()
  {
    if (l() == 0) {
      this.u = true;
    }
    do
    {
      return;
      if (l() == 1)
      {
        this.v = true;
        return;
      }
      if (l() == 2)
      {
        this.w = true;
        return;
      }
      if (l() == 3)
      {
        this.x = true;
        return;
      }
    } while (l() != 4);
    this.y = true;
  }
  
  public void o()
  {
    com.skplanet.tad.videoplayer.util.b.a("#####VodVideoPlayer --->uiUpdateProcess(){");
    this.e.j.startAnimation(this.d);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/videoplayer/activity/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
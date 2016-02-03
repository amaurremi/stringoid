package com.venticake.retrica;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.venticake.retrica.editor.EditorActivity;
import com.venticake.retrica.engine.RetricaEngine;
import com.venticake.retrica.setting.PurchaseActivity;
import com.venticake.retrica.setting.PurchaseActivityForAmazon;
import com.venticake.retrica.setting.SettingActivity;
import com.venticake.retrica.util.CommonUtil;
import com.venticake.retrica.util.UserInterfaceUtil;
import com.venticake.retrica.view.ArcProgressView;
import com.venticake.retrica.view.LensIntensityControlView;
import com.venticake.retrica.view.LensSelector;
import com.venticake.retrica.view.LensSelector.LensSelectorListner;
import com.venticake.retrica.view.RetricaBlurTouchEventDispatcher;
import com.venticake.retrica.view.RetricaBlurTouchEventListener;
import com.venticake.retrica.view.RetricaGLSurfaceView;
import com.venticake.retrica.view.RetricaToolbarBodyLayout;
import com.venticake.retrica.view.album.QuickViewActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MainActivity
  extends e
  implements j, LensSelector.LensSelectorListner, RetricaBlurTouchEventListener
{
  public static Context a;
  public static boolean b = false;
  public static int c = 0;
  private SurfaceView A = null;
  private TextView B;
  private TextView C;
  private TextView D;
  private ArcProgressView E;
  private View F;
  private ProgressBar G;
  private ProgressBar H;
  private Handler I;
  private ImageButton J;
  private ImageButton K;
  private ImageButton L;
  private ImageButton M;
  private ImageButton N;
  private ImageButton O;
  private ImageButton P;
  private ImageButton Q;
  private ImageButton R;
  private ImageButton S;
  private ImageButton T;
  private TextView U;
  private TextView V;
  private SeekBar W;
  private SeekBar X;
  private LinearLayout Y;
  private RetricaToolbarBodyLayout Z;
  private LinearLayout aa;
  private LinearLayout ab;
  private OrientationEventListener ac;
  private int ad = 0;
  private float ae = 0.0F;
  private i af;
  private g ag;
  private f ah;
  private CountDownTimer ai;
  private int aj = 0;
  private boolean ak;
  private h al;
  private boolean am = false;
  private boolean an = true;
  private boolean ao = false;
  private final int ap = 200;
  private final int aq = 80;
  private TextView ar = null;
  private LocationListener as = new LocationListener()
  {
    public void onLocationChanged(Location paramAnonymousLocation)
    {
      Log.d("location", "onLocationChanged: " + paramAnonymousLocation);
      l.b(paramAnonymousLocation);
    }
    
    public void onProviderDisabled(String paramAnonymousString)
    {
      Log.d("location", "onProviderDisabled: " + paramAnonymousString);
    }
    
    public void onProviderEnabled(String paramAnonymousString)
    {
      Log.d("location", "onProviderEnabled: " + paramAnonymousString);
    }
    
    public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      Log.d("location", "onStatusChanged(" + paramAnonymousInt + "): " + paramAnonymousString);
    }
  };
  private Runnable at = null;
  private Runnable au = null;
  private int av = 0;
  private int aw = 0;
  private int ax = 0;
  public Uri d = null;
  public LensSelector e = null;
  public int f;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  public int k = 0;
  public List<Bitmap> l;
  public List<Uri> m;
  public RetricaEngine n;
  public LocationManager o;
  public String p;
  public boolean q;
  private boolean r = false;
  private long s = 0L;
  private Camera t;
  private boolean u = false;
  private boolean v = false;
  private boolean w = true;
  private String x;
  private FrameLayout y;
  private RetricaGLSurfaceView z;
  
  private void B()
  {
    if (com.venticake.retrica.setting.a.a().w())
    {
      E();
      return;
    }
    if (!n.d())
    {
      D();
      return;
    }
    if (this.an)
    {
      G();
      return;
    }
    C();
  }
  
  private void C()
  {
    if (f.d(this.f))
    {
      this.n.getCurrentBuffer(this.af.a);
      ai();
      c.a("Take Picture", c.k());
      return;
    }
    this.ah.a(this.L, this.f, ad() + 1);
    aj();
    p.a().b();
    this.n.getCurrentBuffer(this.af.b);
  }
  
  private void D()
  {
    S();
    s();
    ai();
    this.af.a(new k()
    {
      public void a(float paramAnonymousFloat)
      {
        MainActivity.this.e((int)(100.0F * paramAnonymousFloat));
      }
    });
    this.n.getCurrentBuffer(this.af.a);
    c.a("Take Picture", c.k());
  }
  
  private void E()
  {
    final boolean bool2 = p();
    if ((bool2) && (com.venticake.retrica.setting.a.a().r())) {}
    for (final boolean bool1 = true;; bool1 = false)
    {
      final int i1 = this.g;
      final Location localLocation = z();
      final int i2 = this.f;
      aj();
      this.t.takePicture(null, null, new Camera.PictureCallback()
      {
        public void onPictureTaken(final byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
        {
          paramAnonymousCamera = MainActivity.d(MainActivity.this).a(MainActivity.a);
          Log.d("retrica", "NoEffect Single tmpFile: " + paramAnonymousCamera);
          if (paramAnonymousCamera == null)
          {
            UserInterfaceUtil.displayError(MainActivity.a, MainActivity.a.getResources().getString(2131165288));
            MainActivity.g(MainActivity.this);
            return;
          }
          paramAnonymousArrayOfByte = g.a(paramAnonymousCamera, paramAnonymousArrayOfByte, i1, bool2, bool1, localLocation);
          Log.d("retrica", "imageUri: " + paramAnonymousArrayOfByte);
          Log.d("retrica", "pictureLocation: " + localLocation);
          MainActivity.this.s();
          MainActivity.h(MainActivity.this).post(new Runnable()
          {
            public void run()
            {
              Intent localIntent = new Intent(MainActivity.a, EditorActivity.class);
              localIntent.putExtra("URI", paramAnonymousArrayOfByte.toString());
              localIntent.putExtra("ORIENTATION", this.c);
              localIntent.putExtra("IS_FRONT_CAMERA", this.d);
              localIntent.putExtra("SAVE_AS_PREVIEW", this.e);
              localIntent.putExtra("COLLAGE_STATUS", this.f);
              MainActivity.this.startActivity(localIntent);
              MainActivity.i(MainActivity.this);
            }
          });
        }
      });
      return;
    }
  }
  
  private void F()
  {
    final int i1 = 0;
    if (f.d(this.f)) {
      Log.e("take", "ERROR: invalid collageStatus : " + this.f);
    }
    final boolean bool2 = p();
    if ((bool2) && (com.venticake.retrica.setting.a.a().r())) {}
    for (final boolean bool1 = true;; bool1 = false)
    {
      if (f.e(this.f)) {
        i1 = this.g;
      }
      this.ah.a(this.L, this.f, ad() + 1);
      aj();
      this.t.takePicture(null, null, new Camera.PictureCallback()
      {
        public void onPictureTaken(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
        {
          paramAnonymousCamera = MainActivity.d(MainActivity.this).a(MainActivity.a);
          Log.d("retrica", "NoEffect Collage tmpFile: " + paramAnonymousCamera);
          if (paramAnonymousCamera == null)
          {
            UserInterfaceUtil.displayError(MainActivity.a, MainActivity.a.getResources().getString(2131165288));
            Log.e("take", "NoEffect Collage NO tmpFile: " + paramAnonymousCamera);
          }
          MainActivity.j(MainActivity.this).a(paramAnonymousCamera, paramAnonymousArrayOfByte, i1, bool2, bool1);
          MainActivity.k(MainActivity.this).startPreview();
        }
      });
      return;
    }
  }
  
  private void G()
  {
    final int i1 = this.g;
    final Location localLocation = z();
    System.gc();
    aj();
    this.t.takePicture(null, null, new Camera.PictureCallback()
    {
      public void onPictureTaken(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
      {
        MainActivity.l(MainActivity.this);
        MainActivity.m(MainActivity.this);
        MainActivity.i(MainActivity.this);
        MainActivity.this.s();
        System.gc();
        new m(MainActivity.this, null).execute(new Object[] { Integer.valueOf(i1), localLocation, paramAnonymousArrayOfByte });
      }
    });
    c.a("Take Picture", c.j());
  }
  
  private void H()
  {
    n.a();
    this.w = true;
    this.I = new Handler(Looper.getMainLooper());
    this.an = true;
    com.venticake.retrica.engine.a.a.a(this);
    b = getResources().getBoolean(2131427336);
    c = getResources().getConfiguration().screenLayout & 0xF;
    if (this.ac == null) {
      this.ac = new OrientationEventListener(this)
      {
        @SuppressLint({"NewApi"})
        public void onOrientationChanged(int paramAnonymousInt)
        {
          int j = 0;
          if (paramAnonymousInt == -1) {
            return;
          }
          int i = j;
          switch ((i.c(MainActivity.this.getWindowManager().getDefaultDisplay().getRotation()) + paramAnonymousInt) % 360 / 45)
          {
          default: 
            i = j;
          }
          while (i != MainActivity.this.g)
          {
            MainActivity.this.g = i;
            MainActivity.n(MainActivity.this);
            return;
            i = 3;
            continue;
            i = 3;
            continue;
            i = 2;
            continue;
            i = 2;
            continue;
            i = 1;
            continue;
            i = 1;
          }
        }
      };
    }
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setContentView(2130903066);
    this.y = ((FrameLayout)findViewById(2131296350));
    this.B = ((TextView)findViewById(2131296352));
    this.C = ((TextView)findViewById(2131296353));
    this.D = ((TextView)findViewById(2131296354));
    this.E = ((ArcProgressView)findViewById(2131296355));
    this.F = findViewById(2131296351);
    this.G = ((ProgressBar)findViewById(2131296356));
    this.H = ((ProgressBar)findViewById(2131296357));
    this.aa = ((LinearLayout)findViewById(2131296379));
    this.ab = ((LinearLayout)findViewById(2131296389));
    this.W = ((SeekBar)findViewById(2131296391));
    this.X = ((SeekBar)findViewById(2131296393));
    this.af = new i(this);
    this.af.a(this);
    this.ag = new g(this);
    this.ag.a(this);
    this.ah = new f(this);
    this.al = new h(this);
    this.f = this.al.c();
    this.R = ((ImageButton)findViewById(2131296365));
    this.R.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.a(MainActivity.this, paramAnonymousView);
      }
    });
    this.J = ((ImageButton)findViewById(2131296373));
    this.J.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(MainActivity.a, SettingActivity.class);
        paramAnonymousView.putExtra("adjustedPreviewWidth", MainActivity.o(MainActivity.this));
        paramAnonymousView.putExtra("adjustedPreviewHeight", MainActivity.p(MainActivity.this));
        paramAnonymousView.putExtra("chosenPreviewWidth", MainActivity.this.h);
        paramAnonymousView.putExtra("chosenPreviewHeight", MainActivity.this.i);
        paramAnonymousView.putExtra("chosenPictureWidth", MainActivity.this.j);
        paramAnonymousView.putExtra("chosenPictureHeight", MainActivity.this.k);
        MainActivity.this.startActivity(paramAnonymousView);
      }
    });
    this.K = ((ImageButton)findViewById(2131296372));
    this.K.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.q(MainActivity.this);
      }
    });
    N();
    this.L = ((ImageButton)findViewById(2131296359));
    this.ah.a(this.L, this.f);
    this.L.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.c();
      }
    });
    this.M = ((ImageButton)findViewById(2131296360));
    this.M.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.d();
      }
    });
    this.N = ((ImageButton)findViewById(2131296361));
    this.N.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.e();
      }
    });
    this.O = ((ImageButton)findViewById(2131296362));
    this.O.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.f();
      }
    });
    this.P = ((ImageButton)findViewById(2131296363));
    this.P.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.i();
      }
    });
    this.Q = ((ImageButton)findViewById(2131296366));
    this.Q.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.l();
      }
    });
    this.T = ((ImageButton)findViewById(2131296368));
    this.T.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.o();
      }
    });
    this.V = ((TextView)findViewById(2131296369));
    this.S = ((ImageButton)findViewById(2131296370));
    this.S.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.m();
      }
    });
    this.U = ((TextView)findViewById(2131296371));
    this.e = ((LensSelector)findViewById(2131296394));
    this.e.setLensSelectorListener(this);
    this.Y = ((LinearLayout)findViewById(2131296358));
    this.Z = ((RetricaToolbarBodyLayout)findViewById(2131296364));
    this.Z.captureButton = this.R;
    this.Z.albumButton = this.Q;
    this.Z.randomFilterButton = this.S;
    this.Z.filterButton = this.T;
    this.Z.albumButtonTextView = ((TextView)findViewById(2131296367));
    this.Z.randomFilterButtonTextView = this.U;
    this.Z.filterButtonTextView = this.V;
    int i1 = com.venticake.retrica.setting.a.a().v();
    if (i1 > 0) {
      h(i1);
    }
    this.W.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        paramAnonymousInt /= 10;
        com.venticake.retrica.setting.a.a().f(paramAnonymousInt);
        if (paramAnonymousInt == 0) {}
        for (paramAnonymousSeekBar = "";; paramAnonymousSeekBar = String.format("%d", new Object[] { Integer.valueOf(paramAnonymousInt) }))
        {
          MainActivity.r(MainActivity.this).setText(paramAnonymousSeekBar);
          return;
        }
      }
      
      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        MainActivity.r(MainActivity.this).setText("");
        MainActivity.r(MainActivity.this).setTextSize(2, 200.0F);
        MainActivity.r(MainActivity.this).setVisibility(0);
        MainActivity.s(MainActivity.this);
      }
      
      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        MainActivity.r(MainActivity.this).setVisibility(4);
        MainActivity.s(MainActivity.this);
      }
    });
    this.X.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        paramAnonymousInt *= 20;
        com.venticake.retrica.setting.a.a().g(paramAnonymousInt);
        paramAnonymousSeekBar = String.format("%.2f secs", new Object[] { Float.valueOf(paramAnonymousInt / 1000.0F) });
        if (paramAnonymousInt == 0) {
          paramAnonymousSeekBar = "MANUAL";
        }
        MainActivity.r(MainActivity.this).setText(paramAnonymousSeekBar);
      }
      
      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        MainActivity.r(MainActivity.this).setText("");
        MainActivity.r(MainActivity.this).setTextSize(2, 80.0F);
        MainActivity.r(MainActivity.this).setVisibility(0);
        MainActivity.s(MainActivity.this);
      }
      
      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        MainActivity.r(MainActivity.this).setVisibility(4);
        MainActivity.s(MainActivity.this);
      }
    });
  }
  
  private void I()
  {
    if (!com.venticake.retrica.setting.a.a().u()) {
      this.I.postDelayed(new Runnable()
      {
        public void run()
        {
          switch (1)
          {
          }
          for (Object localObject = "google";; localObject = "amazon")
          {
            com.venticake.a.a.b.a = "version:" + CommonUtil.getAppVersion(MainActivity.a) + ",store:" + (String)localObject;
            com.venticake.a.a.b.b = com.venticake.retrica.setting.a.b;
            com.venticake.a.a.b.c = com.venticake.retrica.setting.a.c;
            com.venticake.a.a.c.a = com.venticake.retrica.setting.a.d;
            com.venticake.a.a.c.b = 2;
            localObject = com.venticake.a.a.a();
            ((com.venticake.a.a)localObject).b(1);
            ((com.venticake.a.a)localObject).a(new com.venticake.a.b()
            {
              public Location a()
              {
                return l.c();
              }
            });
            ((com.venticake.a.a)localObject).a(MainActivity.a, new com.venticake.a.c()
            {
              public void a()
              {
                Log.d("spad", "onUpdateComplete");
                if (com.venticake.a.a.a().a(7))
                {
                  com.venticake.a.a.c.a = com.venticake.retrica.setting.a.e;
                  Log.d("spad", "alt unitID set");
                }
                com.venticake.a.a.a().a((Activity)MainActivity.a);
              }
            });
            return;
          }
        }
      }, 1000L);
    }
  }
  
  @SuppressLint({"NewApi"})
  private void J()
  {
    if (com.venticake.retrica.setting.a.a().x() > 0L) {}
    for (;;)
    {
      return;
      long l1 = System.currentTimeMillis();
      com.venticake.retrica.setting.a.a().a(l1);
      this.ao = true;
      if (!com.venticake.retrica.setting.a.a().r()) {
        if (Build.VERSION.SDK_INT < 9)
        {
          if (new a(this).getCount() < 1)
          {
            com.venticake.retrica.setting.a.a().e(true);
            this.r = true;
          }
        }
        else {
          try
          {
            this.s = (l1 - getPackageManager().getPackageInfo(getPackageName(), 0).firstInstallTime);
            if (this.s < 86400000L)
            {
              com.venticake.retrica.setting.a.a().e(true);
              this.r = true;
              return;
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            localNameNotFoundException.printStackTrace();
          }
        }
      }
    }
  }
  
  private RotateAnimation K()
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(this.ae, this.ae, this.D.getWidth() / 2, this.D.getHeight() / 2);
    localRotateAnimation.setFillAfter(true);
    localRotateAnimation.setDuration(0L);
    return localRotateAnimation;
  }
  
  private void L()
  {
    this.D.startAnimation(K());
  }
  
  private void M()
  {
    this.D.clearAnimation();
    if ((this.C.getVisibility() == 0) || (this.B.getVisibility() == 0)) {
      this.D.setVisibility(4);
    }
    do
    {
      return;
      int i1 = com.venticake.retrica.setting.a.a().s();
      if (i1 <= 0) {
        break;
      }
      this.D.setText(String.format("%d", new Object[] { Integer.valueOf(i1) }));
      this.D.setVisibility(0);
    } while (this.ae == 0.0F);
    L();
    return;
    this.D.setVisibility(4);
  }
  
  @TargetApi(9)
  private void N()
  {
    if (this.ad == 0) {
      if (Build.VERSION.SDK_INT < 9) {
        break label39;
      }
    }
    label39:
    for (this.ad = Camera.getNumberOfCameras(); this.ad == 1; this.ad = -1)
    {
      this.K.setVisibility(4);
      return;
    }
    this.K.setVisibility(0);
  }
  
  private void O()
  {
    this.o = ((LocationManager)getSystemService("location"));
    Criteria localCriteria = new Criteria();
    localCriteria.setPowerRequirement(1);
    localCriteria.setAccuracy(2);
    localCriteria.setCostAllowed(false);
    this.p = this.o.getBestProvider(localCriteria, true);
    this.q = false;
    Log.d("location", "best providerName: " + this.p);
    this.q = false;
    if ((this.p != null) && (this.o.isProviderEnabled(this.p)))
    {
      this.o.requestLocationUpdates(this.p, 600000L, 10.0F, this.as);
      l.b(this.o.getLastKnownLocation(this.p));
      this.q = true;
      Log.d("location", "location Enabled: " + this.o);
    }
  }
  
  private void P()
  {
    this.o.removeUpdates(this.as);
    this.q = false;
  }
  
  private void Q()
  {
    try
    {
      com.venticake.retrica.engine.a.a locala = com.venticake.retrica.engine.a.a.b();
      if (this.n != null) {}
      for (com.venticake.retrica.engine.a.g localg = this.n.getCurrentLens();; localg = null)
      {
        locala.c(localg);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void R()
  {
    try
    {
      Log.d("retrica", "startCameraPreview");
      this.I.postDelayed(new Runnable()
      {
        public void run()
        {
          MainActivity.t(MainActivity.this);
        }
      }, 100L);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void S()
  {
    try
    {
      Y();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void T()
  {
    int i1;
    if (this.z == null)
    {
      this.z = new RetricaGLSurfaceView(this);
      this.z.setEventListner(this);
      this.z.setVisibility(4);
      if (this.aw <= 0) {
        break label99;
      }
      i1 = this.aw;
      if (this.ax <= 0) {
        break label107;
      }
    }
    label99:
    label107:
    for (int i2 = this.ax;; i2 = this.i)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i1, i2);
      localLayoutParams.gravity = 17;
      this.y.addView(this.z, 0, localLayoutParams);
      if (n.e()) {
        U();
      }
      return;
      i1 = this.h;
      break;
    }
  }
  
  private void U()
  {
    if (this.A == null)
    {
      this.A = new SurfaceView(this);
      SurfaceHolder localSurfaceHolder = this.A.getHolder();
      localSurfaceHolder.setType(3);
      localSurfaceHolder.addCallback(new SurfaceHolder.Callback()
      {
        public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          Log.d("retrica", "mDummySurfaceView surfaceChanged: " + paramAnonymousSurfaceHolder);
        }
        
        public void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          Log.d("retrica", "mDummySurfaceView surfaceCreated: " + paramAnonymousSurfaceHolder);
          try
          {
            if (MainActivity.k(MainActivity.this) != null) {
              MainActivity.k(MainActivity.this).setPreviewDisplay(paramAnonymousSurfaceHolder);
            }
            return;
          }
          catch (IOException paramAnonymousSurfaceHolder)
          {
            paramAnonymousSurfaceHolder.printStackTrace();
          }
        }
        
        public void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          Log.d("retrica", "mDummySurfaceView surfaceDestroyed: " + paramAnonymousSurfaceHolder);
          try
          {
            if (MainActivity.k(MainActivity.this) != null) {
              MainActivity.k(MainActivity.this).setPreviewDisplay(null);
            }
            return;
          }
          catch (IOException paramAnonymousSurfaceHolder)
          {
            paramAnonymousSurfaceHolder.printStackTrace();
          }
        }
      });
      this.y.addView(this.A, new FrameLayout.LayoutParams(1, 1));
      return;
    }
    this.A.setLayoutParams(new FrameLayout.LayoutParams(1, 1));
  }
  
  private void V()
  {
    String str2;
    Object localObject1;
    if (this.n == null)
    {
      str2 = com.venticake.retrica.setting.a.a().f();
      localObject1 = null;
      if (str2 == null) {}
    }
    label186:
    for (;;)
    {
      try
      {
        localObject1 = com.venticake.retrica.engine.a.a.b().a(str2);
        if (localObject1 != null) {
          break label186;
        }
        Object localObject2;
        StringBuilder localStringBuilder;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            localObject2 = com.venticake.retrica.engine.a.a.b().g();
            localObject1 = localObject2;
          }
          catch (Exception localException2)
          {
            String str1;
            continue;
          }
          try
          {
            b((com.venticake.retrica.engine.a.g)localObject1);
            localStringBuilder = new StringBuilder("saved lensID: ");
            if (str2 == null) {
              continue;
            }
            localObject2 = str2;
            Log.d("retrica", (String)localObject2);
            Log.d("retrica", "initialLens: " + ((com.venticake.retrica.engine.a.g)localObject1).toString());
            this.n = new RetricaEngine(this, (com.venticake.retrica.engine.a.g)localObject1);
            this.n.setLens((com.venticake.retrica.engine.a.g)localObject1);
            c((com.venticake.retrica.engine.a.g)localObject1);
            return;
          }
          catch (Exception localException3) {}
        }
        localException1 = localException1;
        localObject1 = null;
      }
      continue;
      str1 = "null";
      continue;
      localObject1 = this.n.getCurrentLens();
      b((com.venticake.retrica.engine.a.g)localObject1);
      this.n.setLens((com.venticake.retrica.engine.a.g)localObject1);
      c((com.venticake.retrica.engine.a.g)localObject1);
      return;
    }
  }
  
  /* Error */
  private void W()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 900
    //   5: ldc_w 985
    //   8: invokestatic 855	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   11: pop
    //   12: aload_0
    //   13: getfield 408	com/venticake/retrica/MainActivity:t	Landroid/hardware/Camera;
    //   16: ifnonnull +31 -> 47
    //   19: aload_0
    //   20: aload_0
    //   21: invokespecial 988	com/venticake/retrica/MainActivity:aa	()Landroid/hardware/Camera;
    //   24: putfield 408	com/venticake/retrica/MainActivity:t	Landroid/hardware/Camera;
    //   27: aload_0
    //   28: getfield 408	com/venticake/retrica/MainActivity:t	Landroid/hardware/Camera;
    //   31: ifnonnull +16 -> 47
    //   34: ldc_w 900
    //   37: ldc_w 990
    //   40: invokestatic 855	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   43: pop
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: invokespecial 992	com/venticake/retrica/MainActivity:V	()V
    //   51: aload_0
    //   52: invokespecial 994	com/venticake/retrica/MainActivity:T	()V
    //   55: aload_0
    //   56: invokespecial 996	com/venticake/retrica/MainActivity:X	()V
    //   59: aload_0
    //   60: getfield 339	com/venticake/retrica/MainActivity:n	Lcom/venticake/retrica/engine/RetricaEngine;
    //   63: aload_0
    //   64: getfield 910	com/venticake/retrica/MainActivity:z	Lcom/venticake/retrica/view/RetricaGLSurfaceView;
    //   67: invokevirtual 1000	com/venticake/retrica/engine/RetricaEngine:setGLSurfaceView	(Landroid/opengl/GLSurfaceView;)V
    //   70: aload_0
    //   71: getfield 339	com/venticake/retrica/MainActivity:n	Lcom/venticake/retrica/engine/RetricaEngine;
    //   74: aload_0
    //   75: getfield 408	com/venticake/retrica/MainActivity:t	Landroid/hardware/Camera;
    //   78: aload_0
    //   79: invokevirtual 401	com/venticake/retrica/MainActivity:p	()Z
    //   82: invokevirtual 1004	com/venticake/retrica/engine/RetricaEngine:setUpCamera	(Landroid/hardware/Camera;Z)V
    //   85: aload_0
    //   86: getfield 339	com/venticake/retrica/MainActivity:n	Lcom/venticake/retrica/engine/RetricaEngine;
    //   89: new 32	com/venticake/retrica/MainActivity$17
    //   92: dup
    //   93: aload_0
    //   94: invokespecial 1005	com/venticake/retrica/MainActivity$17:<init>	(Lcom/venticake/retrica/MainActivity;)V
    //   97: invokevirtual 1009	com/venticake/retrica/engine/RetricaEngine:runOnRendererThread	(Ljava/lang/Runnable;)V
    //   100: invokestatic 1014	com/venticake/retrica/util/b:a	()Lcom/venticake/retrica/util/b;
    //   103: aload_0
    //   104: aload_0
    //   105: invokevirtual 1016	com/venticake/retrica/MainActivity:y	()Landroid/location/Location;
    //   108: aload_0
    //   109: getfield 268	com/venticake/retrica/MainActivity:h	I
    //   112: aload_0
    //   113: getfield 270	com/venticake/retrica/MainActivity:i	I
    //   116: aload_0
    //   117: getfield 272	com/venticake/retrica/MainActivity:j	I
    //   120: aload_0
    //   121: getfield 270	com/venticake/retrica/MainActivity:i	I
    //   124: invokevirtual 1019	com/venticake/retrica/util/b:a	(Landroid/app/Activity;Landroid/location/Location;IIII)V
    //   127: aload_0
    //   128: getfield 282	com/venticake/retrica/MainActivity:ao	Z
    //   131: ifeq -87 -> 44
    //   134: invokestatic 1014	com/venticake/retrica/util/b:a	()Lcom/venticake/retrica/util/b;
    //   137: aload_0
    //   138: aload_0
    //   139: invokevirtual 1016	com/venticake/retrica/MainActivity:y	()Landroid/location/Location;
    //   142: aload_0
    //   143: getfield 268	com/venticake/retrica/MainActivity:h	I
    //   146: aload_0
    //   147: getfield 270	com/venticake/retrica/MainActivity:i	I
    //   150: aload_0
    //   151: getfield 272	com/venticake/retrica/MainActivity:j	I
    //   154: aload_0
    //   155: getfield 270	com/venticake/retrica/MainActivity:i	I
    //   158: invokevirtual 1021	com/venticake/retrica/util/b:b	(Landroid/app/Activity;Landroid/location/Location;IIII)V
    //   161: aload_0
    //   162: iconst_0
    //   163: putfield 282	com/venticake/retrica/MainActivity:ao	Z
    //   166: goto -122 -> 44
    //   169: astore_1
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_1
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	MainActivity
    //   169	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	44	169	finally
    //   47	166	169	finally
  }
  
  private void X()
  {
    if ((this.y.getMeasuredWidth() > 0) && (this.y.getMeasuredHeight() > 0))
    {
      al();
      return;
    }
    this.y.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      @SuppressLint({"NewApi"})
      public void onGlobalLayout()
      {
        ViewTreeObserver localViewTreeObserver = MainActivity.u(MainActivity.this).getViewTreeObserver();
        if (Build.VERSION.SDK_INT >= 16) {
          localViewTreeObserver.removeOnGlobalLayoutListener(this);
        }
        for (;;)
        {
          Log.d("retrica", "onGlobalLayout - " + MainActivity.u(MainActivity.this).getMeasuredWidth() + " x " + MainActivity.u(MainActivity.this).getMeasuredHeight());
          MainActivity.v(MainActivity.this);
          return;
          localViewTreeObserver.removeGlobalOnLayoutListener(this);
        }
      }
    });
  }
  
  /* Error */
  private void Y()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 408	com/venticake/retrica/MainActivity:t	Landroid/hardware/Camera;
    //   6: ifnull +63 -> 69
    //   9: aload_0
    //   10: getfield 258	com/venticake/retrica/MainActivity:A	Landroid/view/SurfaceView;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +34 -> 49
    //   18: aload_0
    //   19: getfield 408	com/venticake/retrica/MainActivity:t	Landroid/hardware/Camera;
    //   22: invokevirtual 1045	android/hardware/Camera:stopPreview	()V
    //   25: aload_0
    //   26: getfield 408	com/venticake/retrica/MainActivity:t	Landroid/hardware/Camera;
    //   29: aconst_null
    //   30: invokevirtual 1049	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   33: aload_0
    //   34: getfield 532	com/venticake/retrica/MainActivity:y	Landroid/widget/FrameLayout;
    //   37: aload_0
    //   38: getfield 258	com/venticake/retrica/MainActivity:A	Landroid/view/SurfaceView;
    //   41: invokevirtual 1053	android/widget/FrameLayout:removeView	(Landroid/view/View;)V
    //   44: aload_0
    //   45: aconst_null
    //   46: putfield 258	com/venticake/retrica/MainActivity:A	Landroid/view/SurfaceView;
    //   49: aload_0
    //   50: getfield 408	com/venticake/retrica/MainActivity:t	Landroid/hardware/Camera;
    //   53: aconst_null
    //   54: invokevirtual 1057	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   57: aload_0
    //   58: getfield 408	com/venticake/retrica/MainActivity:t	Landroid/hardware/Camera;
    //   61: invokevirtual 1060	android/hardware/Camera:release	()V
    //   64: aload_0
    //   65: aconst_null
    //   66: putfield 408	com/venticake/retrica/MainActivity:t	Landroid/hardware/Camera;
    //   69: aload_0
    //   70: getfield 339	com/venticake/retrica/MainActivity:n	Lcom/venticake/retrica/engine/RetricaEngine;
    //   73: ifnull +10 -> 83
    //   76: aload_0
    //   77: getfield 339	com/venticake/retrica/MainActivity:n	Lcom/venticake/retrica/engine/RetricaEngine;
    //   80: invokevirtual 1063	com/venticake/retrica/engine/RetricaEngine:clearDrawQueue	()V
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual 1064	java/io/IOException:printStackTrace	()V
    //   91: goto -58 -> 33
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	MainActivity
    //   13	2	1	localSurfaceView	SurfaceView
    //   86	2	1	localIOException	IOException
    //   94	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	33	86	java/io/IOException
    //   2	14	94	finally
    //   18	33	94	finally
    //   33	49	94	finally
    //   49	69	94	finally
    //   69	83	94	finally
    //   87	91	94	finally
  }
  
  /* Error */
  private void Z()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 408	com/venticake/retrica/MainActivity:t	Landroid/hardware/Camera;
    //   6: ifnonnull +10 -> 16
    //   9: aload_0
    //   10: invokespecial 458	com/venticake/retrica/MainActivity:R	()V
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 408	com/venticake/retrica/MainActivity:t	Landroid/hardware/Camera;
    //   20: invokevirtual 1067	android/hardware/Camera:startPreview	()V
    //   23: goto -10 -> 13
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	MainActivity
    //   26	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	26	finally
    //   16	23	26	finally
  }
  
  public static Camera a()
  {
    return f(0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Log.d("retrica", "choosePreviewSize: " + paramInt1 + ", " + paramInt2 + " (old: " + this.h + ", " + this.i + ")");
    if (this.aw == 0) {
      this.aw = paramInt1;
    }
    if (this.ax == 0) {
      this.ax = paramInt1;
    }
    if ((this.h == paramInt1) && (this.i == paramInt2))
    {
      aC();
      return;
    }
    this.h = paramInt1;
    this.i = paramInt2;
    aB();
  }
  
  private void a(long paramLong)
  {
    try
    {
      if (this.at != null) {
        this.I.removeCallbacks(this.at);
      }
      this.at = new Runnable()
      {
        public void run()
        {
          MainActivity localMainActivity = MainActivity.this;
          if (n.c() > 0) {}
          for (boolean bool = true;; bool = false)
          {
            MainActivity.c(localMainActivity, bool);
            MainActivity.a(MainActivity.this, null);
            return;
          }
        }
      };
      this.I.postDelayed(this.at, paramLong);
      return;
    }
    finally {}
  }
  
  private void a(Camera paramCamera, Camera.Parameters paramParameters)
  {
    if (Build.VERSION.SDK_INT < 8)
    {
      paramParameters.set("orientation", "portrait");
      return;
    }
    paramCamera.setDisplayOrientation(90);
  }
  
  private void a(View paramView)
  {
    if (this.am)
    {
      A();
      return;
    }
    if (this.R.isSelected())
    {
      if (this.ak)
      {
        this.ai.cancel();
        this.ak = false;
        this.aj = 0;
        M();
        this.R.setSelected(false);
        ak();
        ax();
        this.ah.a(this.L, this.f);
        return;
      }
      ac();
      return;
    }
    af();
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2)
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(paramFloat1, paramFloat2, paramView.getWidth() / 2, paramView.getHeight() / 2);
    localRotateAnimation.setFillAfter(true);
    localRotateAnimation.setDuration(250L);
    paramView.clearAnimation();
    paramView.startAnimation(localRotateAnimation);
  }
  
  @SuppressLint({"NewApi"})
  private void a(View paramView, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  @SuppressLint({"NewApi"})
  private void a(ImageButton paramImageButton, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramImageButton.setImageAlpha(paramInt);
      return;
    }
    paramImageButton.setAlpha(paramInt);
  }
  
  private void a(RetricaEngine paramRetricaEngine, com.venticake.retrica.engine.a.g paramg)
  {
    if ((this.y.getWidth() < 1) || (this.y.getHeight() < 1)) {
      return;
    }
    this.al.a(this.f, this.h, this.i);
    paramg.a(this.al.d());
    final int i1 = this.al.e();
    final int i2 = this.al.f();
    this.I.post(new Runnable()
    {
      public void run()
      {
        FrameLayout.LayoutParams localLayoutParams;
        int i;
        int j;
        float f2;
        if (MainActivity.c(MainActivity.this) != null)
        {
          localLayoutParams = (FrameLayout.LayoutParams)MainActivity.c(MainActivity.this).getLayoutParams();
          Log.d("retrica", "cropSize(layoutSize): " + i1 + ", " + i2);
          i = MainActivity.o(MainActivity.this);
          j = MainActivity.p(MainActivity.this);
          if ((i <= 0) || (j <= 0)) {
            break label251;
          }
          float f1 = i / j;
          f2 = i1 / i2;
          if (f1 <= f2) {
            break label228;
          }
          localLayoutParams.height = j;
          localLayoutParams.width = ((int)(localLayoutParams.height * f2));
        }
        for (;;)
        {
          localLayoutParams.gravity = 17;
          MainActivity.c(MainActivity.this).setLayoutParams(localLayoutParams);
          MainActivity.c(MainActivity.this).setVisibility(0);
          Log.d("retrica", "glSurfaceView resized: " + localLayoutParams.width + " x " + localLayoutParams.height + " (max: " + i + " x " + j + ")");
          return;
          label228:
          localLayoutParams.width = i;
          localLayoutParams.height = ((int)(localLayoutParams.width / f2));
          continue;
          label251:
          localLayoutParams.width = i1;
          localLayoutParams.height = i2;
        }
      }
    });
  }
  
  private void a(com.venticake.retrica.engine.a.g paramg, float paramFloat)
  {
    paramg.b(paramFloat);
  }
  
  private void a(com.venticake.retrica.engine.a.g paramg, float paramFloat1, float paramFloat2)
  {
    paramg.a(paramFloat1, paramFloat2);
  }
  
  private int[] a(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    int i4 = 0;
    int i3 = 0;
    int i1;
    if (paramInt1 > paramInt2) {
      i1 = paramInt2;
    }
    for (int i2 = paramInt1;; i2 = paramInt2)
    {
      f1 = i2 / i1;
      Log.d("retrica", "prefer Max: " + paramInt1 + ", " + paramInt2);
      Log.d("retrica", "resolutionRatio: " + 1.333333F + " - (" + i2 + ", " + i1 + ")");
      if ((paramList != null) && (paramList.size() >= 1)) {
        break;
      }
      return new int[2];
      i1 = paramInt1;
    }
    Object localObject = paramList.iterator();
    float f1 = 0.0F;
    paramInt2 = i4;
    paramInt1 = i3;
    if (!((Iterator)localObject).hasNext()) {
      if (paramInt2 != 0)
      {
        i2 = paramInt1;
        i1 = paramInt2;
        if (paramInt1 != 0) {}
      }
      else
      {
        paramList = paramList.iterator();
      }
    }
    for (;;)
    {
      if (!paramList.hasNext())
      {
        i1 = paramInt2;
        i2 = paramInt1;
        return new int[] { i2, i1 };
        Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
        if ((localSize.width > n.b()) || (localSize.height > n.b())) {
          break;
        }
        label279:
        float f3;
        StringBuilder localStringBuilder;
        if (localSize.width > localSize.height)
        {
          i2 = localSize.width;
          i1 = localSize.height;
          f3 = i2 / i1;
          Log.d("retrica", "possibleResolutionRatio: " + f3);
          localStringBuilder = new StringBuilder("possibleSize: ").append(localSize.width).append(", ").append(localSize.height).append("(").append(f3).append(")").append(" - chosen: ").append(paramInt2).append(", ").append(paramInt1).append("(");
          if (paramInt1 <= 0) {
            break label524;
          }
        }
        label524:
        for (float f2 = paramInt2 / paramInt1;; f2 = 0.0F)
        {
          Log.d("retrica", f2 + ")");
          if ((Math.abs(f3 - 1.333333F) >= 0.1D) || ((localSize.width <= paramInt2) && (localSize.height <= paramInt1)) || ((f1 > 0.0F) && (Math.abs(f1 - 1.333333F) < Math.abs(f3 - 1.333333F)))) {
            break;
          }
          paramInt2 = localSize.width;
          paramInt1 = localSize.height;
          f1 = f3;
          break;
          i2 = localSize.height;
          i1 = localSize.width;
          break label279;
        }
      }
      localObject = (Camera.Size)paramList.next();
      if ((paramInt2 < ((Camera.Size)localObject).width) || (paramInt1 < ((Camera.Size)localObject).height))
      {
        paramInt2 = ((Camera.Size)localObject).width;
        paramInt1 = ((Camera.Size)localObject).height;
      }
    }
  }
  
  private int aA()
  {
    if (this.av > 0) {
      return this.av;
    }
    return x();
  }
  
  private void aB()
  {
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i1 = ((DisplayMetrics)localObject).widthPixels;
    int i7 = ((DisplayMetrics)localObject).heightPixels;
    Log.d("retrica", "adjustBTH - full size: " + i1 + " x " + i7);
    Log.d("retrica", "adjustBTH - preview size: " + this.h + " x " + this.i);
    int i2 = this.i * i1 / this.h;
    int i3 = this.Y.getHeight();
    int i4 = i3 * 4;
    int i5 = this.Z.getMinHeightInPx();
    int i6 = Math.min(i4, Math.max(i7 - i2 - i3, i5));
    i7 = i7 - i6 - i3;
    Log.d("retrica", "adjustBTH - toolbarHeadHeight: " + i3);
    Log.d("retrica", "adjustBTH - maximumBodyHeight: " + i4);
    Log.d("retrica", "adjustBTH - minimumBodyHeight: " + i5);
    Log.d("retrica", "adjustBTH - realMaxHeight: " + i7);
    Log.d("retrica", "adjustBTH - adjusted size: " + i1 + " x " + i2 + " (toolbarBodyHeight: " + i6 + ", initiaBodylHeight: " + (aA() - i3) + ")");
    localObject = UserInterfaceUtil.getFitSize(this.h, this.i, i1, i7);
    this.aw = localObject[0];
    this.ax = localObject[1];
    Log.d("retrica", "adjustBTH - adjustedPreviewSize: " + this.aw + ", " + this.ax);
    Log.d("retrica", "adjustBTH - toolbarBodyHeight: " + i6);
    com.venticake.retrica.setting.a.a().h(i6);
    h(i6);
  }
  
  private void aC()
  {
    if (this.Z.getVisibility() == 0) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.Y.setVisibility(0);
      this.Z.setVisibility(0);
      return;
    }
    this.I.post(new Runnable()
    {
      public void run()
      {
        MainActivity.S(MainActivity.this).setVisibility(0);
        MainActivity.R(MainActivity.this).setVisibility(0);
      }
    });
  }
  
  private Camera aa()
  {
    try
    {
      Object localObject1 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      int i1 = ((DisplayMetrics)localObject1).widthPixels;
      int i2 = ((DisplayMetrics)localObject1).heightPixels - aA();
      Log.d("retrica", "initial bottomToolbarHeight: " + aA());
      Log.d("retrica", "getting camera instance for availableSize: " + i1 + ", " + i2);
      localObject1 = a(i1, i2, this);
      return (Camera)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  @SuppressLint({"InlinedApi"})
  private void ab()
  {
    if (!q()) {
      return;
    }
    S();
    if (com.venticake.retrica.setting.a.a().m() == 0) {
      com.venticake.retrica.setting.a.a().c(1);
    }
    for (;;)
    {
      W();
      return;
      com.venticake.retrica.setting.a.a().c(0);
    }
  }
  
  private void ac()
  {
    aq();
    ax();
  }
  
  private int ad()
  {
    if (com.venticake.retrica.setting.a.a().w()) {
      if (this.m != null) {}
    }
    while (this.l == null)
    {
      return 0;
      return this.m.size();
    }
    return this.l.size();
  }
  
  private int ae()
  {
    return f.b(this.f);
  }
  
  private void af()
  {
    ay();
    long l1;
    if (com.venticake.retrica.setting.a.a().s() > 0)
    {
      aw();
      this.R.setSelected(true);
      l1 = com.venticake.retrica.setting.a.a().s() * 1000;
      if (l1 >= 1L) {
        break label142;
      }
      if (!ag()) {
        break label67;
      }
      B();
    }
    for (;;)
    {
      this.ak = false;
      return;
      av();
      break;
      label67:
      if (com.venticake.retrica.setting.a.a().w())
      {
        if ((this.m != null) && (this.m.size() > 0)) {
          F();
        } else {
          ar();
        }
      }
      else if ((this.l != null) && (this.l.size() > 0)) {
        C();
      } else {
        ar();
      }
    }
    label142:
    this.ai = new CountDownTimer(l1, 250L)
    {
      public void onFinish()
      {
        Log.d("timer", "onFinish: ");
        MainActivity.y(MainActivity.this).clearAnimation();
        MainActivity.y(MainActivity.this).setVisibility(4);
        if (MainActivity.z(MainActivity.this)) {
          MainActivity.A(MainActivity.this);
        }
        for (;;)
        {
          MainActivity.b(MainActivity.this, false);
          return;
          if (com.venticake.retrica.setting.a.a().w())
          {
            if ((MainActivity.this.m != null) && (MainActivity.this.m.size() > 0)) {
              MainActivity.x(MainActivity.this);
            } else {
              MainActivity.B(MainActivity.this);
            }
          }
          else if ((MainActivity.this.l != null) && (MainActivity.this.l.size() > 0)) {
            MainActivity.f(MainActivity.this);
          } else {
            MainActivity.B(MainActivity.this);
          }
        }
      }
      
      public void onTick(long paramAnonymousLong)
      {
        Log.d("timer", "onTick: " + paramAnonymousLong);
        int i = (int)(1L + paramAnonymousLong / 1000L);
        MainActivity.a(MainActivity.this, i);
      }
    };
    Log.d("timer", "start: " + l1);
    g((int)(l1 / 1000L));
    this.ai.start();
    this.ak = true;
  }
  
  private boolean ag()
  {
    switch (this.f)
    {
    default: 
      return false;
    }
    return true;
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  private void ah()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 260	com/venticake/retrica/MainActivity:e	Lcom/venticake/retrica/view/LensSelector;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 260	com/venticake/retrica/MainActivity:e	Lcom/venticake/retrica/view/LensSelector;
    //   13: getfield 1383	com/venticake/retrica/view/LensSelector:lensIntensityControlView	Lcom/venticake/retrica/view/LensIntensityControlView;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnonnull +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 295	com/venticake/retrica/MainActivity:at	Ljava/lang/Runnable;
    //   28: ifnull +19 -> 47
    //   31: aload_0
    //   32: getfield 476	com/venticake/retrica/MainActivity:I	Landroid/os/Handler;
    //   35: aload_0
    //   36: getfield 295	com/venticake/retrica/MainActivity:at	Ljava/lang/Runnable;
    //   39: invokevirtual 1087	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 295	com/venticake/retrica/MainActivity:at	Ljava/lang/Runnable;
    //   47: aload_0
    //   48: getfield 297	com/venticake/retrica/MainActivity:au	Ljava/lang/Runnable;
    //   51: ifnull +14 -> 65
    //   54: aload_0
    //   55: getfield 476	com/venticake/retrica/MainActivity:I	Landroid/os/Handler;
    //   58: aload_0
    //   59: getfield 297	com/venticake/retrica/MainActivity:au	Ljava/lang/Runnable;
    //   62: invokevirtual 1087	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   65: aload_0
    //   66: getfield 330	com/venticake/retrica/MainActivity:B	Landroid/widget/TextView;
    //   69: invokevirtual 782	android/widget/TextView:clearAnimation	()V
    //   72: aload_0
    //   73: getfield 260	com/venticake/retrica/MainActivity:e	Lcom/venticake/retrica/view/LensSelector;
    //   76: getfield 1383	com/venticake/retrica/view/LensSelector:lensIntensityControlView	Lcom/venticake/retrica/view/LensIntensityControlView;
    //   79: invokevirtual 1389	com/venticake/retrica/view/LensIntensityControlView:getIntensity	()F
    //   82: fstore_1
    //   83: aload_0
    //   84: getfield 330	com/venticake/retrica/MainActivity:B	Landroid/widget/TextView;
    //   87: invokestatic 1393	com/venticake/retrica/util/UserInterfaceUtil:updateTextViewForLensIntensity	(Landroid/widget/TextView;)V
    //   90: aload_0
    //   91: getfield 330	com/venticake/retrica/MainActivity:B	Landroid/widget/TextView;
    //   94: ldc_w 1395
    //   97: iconst_1
    //   98: anewarray 794	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: fload_1
    //   104: ldc_w 1396
    //   107: fmul
    //   108: invokestatic 1401	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   111: aastore
    //   112: invokestatic 806	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   115: invokevirtual 810	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   118: aload_0
    //   119: getfield 330	com/venticake/retrica/MainActivity:B	Landroid/widget/TextView;
    //   122: iconst_0
    //   123: invokevirtual 788	android/widget/TextView:setVisibility	(I)V
    //   126: aload_0
    //   127: getfield 330	com/venticake/retrica/MainActivity:B	Landroid/widget/TextView;
    //   130: fconst_1
    //   131: invokestatic 1404	com/venticake/retrica/util/UserInterfaceUtil:setAlpha	(Landroid/view/View;F)V
    //   134: aload_0
    //   135: invokespecial 1118	com/venticake/retrica/MainActivity:M	()V
    //   138: goto -117 -> 21
    //   141: astore_2
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_2
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	MainActivity
    //   82	22	1	f1	float
    //   16	2	2	localLensIntensityControlView	LensIntensityControlView
    //   141	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	141	finally
    //   24	47	141	finally
    //   47	65	141	finally
    //   65	138	141	finally
  }
  
  private void ai()
  {
    this.I.post(new Runnable()
    {
      public void run()
      {
        MainActivity.a(MainActivity.this, MainActivity.D(MainActivity.this), MainActivity.this.getResources().getDrawable(2131230766));
        MainActivity.D(MainActivity.this).setVisibility(0);
        MainActivity.h(MainActivity.this).postDelayed(new Runnable()
        {
          public void run()
          {
            MainActivity.D(MainActivity.this).setVisibility(4);
          }
        }, 100L);
      }
    });
  }
  
  private void aj()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(this.F, getResources().getDrawable(2131230766));
      this.F.setVisibility(0);
      return;
    }
    this.I.post(new Runnable()
    {
      public void run()
      {
        MainActivity.a(MainActivity.this, MainActivity.D(MainActivity.this), MainActivity.this.getResources().getDrawable(2131230766));
        MainActivity.D(MainActivity.this).setVisibility(0);
      }
    });
  }
  
  private void ak()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.F.setVisibility(4);
      return;
    }
    this.I.post(new Runnable()
    {
      public void run()
      {
        MainActivity.D(MainActivity.this).setVisibility(4);
      }
    });
  }
  
  private void al()
  {
    if (this.n == null) {
      return;
    }
    a(this.n, this.n.getCurrentLens());
  }
  
  private boolean am()
  {
    return com.venticake.retrica.setting.a.a().h();
  }
  
  private boolean an()
  {
    return com.venticake.retrica.setting.a.a().i();
  }
  
  private boolean ao()
  {
    return com.venticake.retrica.setting.a.a().k() != 0;
  }
  
  private boolean ap()
  {
    if (com.venticake.retrica.setting.a.a().s() > 0) {}
    do
    {
      return true;
      if (f.b(this.f) <= 1) {
        break;
      }
    } while (com.venticake.retrica.setting.a.a().t() > 0);
    return false;
    return false;
  }
  
  private void aq()
  {
    this.ac.enable();
    v();
    this.ah.a(this.L, this.f);
    this.R.setSelected(false);
    ak();
  }
  
  private void ar()
  {
    boolean bool = true;
    this.ac.disable();
    aw();
    this.R.setSelected(true);
    if (com.venticake.retrica.setting.a.a().w())
    {
      this.m = new ArrayList(f.b(this.f));
      i locali = this.af;
      if ((!p()) || (com.venticake.retrica.setting.a.a().r())) {
        break label148;
      }
      label69:
      locali.a(bool);
      if (!f.c(this.f)) {
        break label153;
      }
      this.af.a(this.g);
    }
    for (;;)
    {
      a(this.F, getResources().getDrawable(2131230766));
      if (!com.venticake.retrica.setting.a.a().w()) {
        break label164;
      }
      F();
      return;
      this.l = new ArrayList(f.b(this.f));
      break;
      label148:
      bool = false;
      break label69;
      label153:
      this.af.a(0);
    }
    label164:
    C();
  }
  
  private void as()
  {
    if (com.venticake.retrica.setting.a.a().w())
    {
      final boolean bool2 = p();
      final boolean bool1;
      final int i1;
      label47:
      final Location localLocation;
      final int i3;
      final ArrayList localArrayList;
      int i2;
      if ((bool2) && (com.venticake.retrica.setting.a.a().r()))
      {
        bool1 = true;
        if (!f.e(this.f)) {
          break label137;
        }
        i1 = this.g;
        localLocation = z();
        i3 = this.f;
        localArrayList = new ArrayList(this.m.size());
        i2 = 0;
      }
      for (;;)
      {
        if (i2 >= this.m.size())
        {
          this.m.clear();
          s();
          this.I.post(new Runnable()
          {
            public void run()
            {
              Intent localIntent = new Intent(MainActivity.a, EditorActivity.class);
              localIntent.putStringArrayListExtra("URI_LIST", localArrayList);
              localIntent.putExtra("ORIENTATION", i1);
              localIntent.putExtra("IS_FRONT_CAMERA", bool2);
              localIntent.putExtra("SAVE_AS_PREVIEW", bool1);
              localIntent.putExtra("COLLAGE_STATUS", i3);
              localIntent.putExtra("LOCATION", localLocation);
              Log.d("collage", "pictureLocation: " + localLocation);
              MainActivity.this.startActivity(localIntent);
            }
          });
          return;
          bool1 = false;
          break;
          label137:
          i1 = 0;
          break label47;
        }
        localArrayList.add(((Uri)this.m.get(i2)).toString());
        i2 += 1;
      }
    }
    av();
    S();
    s();
    new Thread(new Runnable()
    {
      private k b = new k()
      {
        public void a(float paramAnonymous2Float)
        {
          MainActivity.this.e((int)(70.0F * paramAnonymous2Float) + 0);
        }
      };
      
      public void run()
      {
        if (com.venticake.retrica.setting.a.a().w()) {}
        for (Object localObject = MainActivity.j(MainActivity.this).a(MainActivity.this.f, MainActivity.this.m, this.b);; localObject = MainActivity.j(MainActivity.this).a(MainActivity.this.f, MainActivity.this.l, this.b))
        {
          MainActivity.this.v();
          MainActivity.this.e(70);
          localObject = MainActivity.d(MainActivity.this).a((Bitmap)localObject, -1, MainActivity.this.r(), false, false, MainActivity.this.z());
          MainActivity.this.e(100);
          if (localObject == null) {
            break;
          }
          Log.i("Retrica", "hjh MainActivity showQuickView(), Collage" + localObject);
          MainActivity.this.a((Uri)localObject);
          return;
        }
        MainActivity.this.u();
      }
    }).start();
    c.a("Take Picture", c.l());
  }
  
  private void at()
  {
    int i2 = 255;
    ImageButton localImageButton;
    if (com.venticake.retrica.setting.a.a().w())
    {
      a(this.M, 91);
      a(this.N, 91);
      localImageButton = this.O;
      if (!ao()) {
        break label135;
      }
      i1 = 255;
      label49:
      a(localImageButton, i1);
      localImageButton = this.P;
      if (!ap()) {
        break label141;
      }
    }
    label92:
    label129:
    label135:
    label141:
    for (int i1 = i2;; i1 = 91)
    {
      a(localImageButton, i1);
      return;
      localImageButton = this.M;
      if (am())
      {
        i1 = 255;
        a(localImageButton, i1);
        localImageButton = this.N;
        if (!an()) {
          break label129;
        }
      }
      for (i1 = 255;; i1 = 91)
      {
        a(localImageButton, i1);
        break;
        i1 = 91;
        break label92;
      }
      i1 = 91;
      break label49;
    }
  }
  
  private void au()
  {
    if (this.n == null) {}
    com.venticake.retrica.engine.a.g localg;
    do
    {
      return;
      localg = this.n.getCurrentLens();
    } while (localg == null);
    c(localg);
  }
  
  private void av()
  {
    e(false);
  }
  
  private void aw()
  {
    e(true);
  }
  
  private void ax()
  {
    if (com.venticake.retrica.setting.a.a().w())
    {
      w();
      return;
    }
    this.I.post(new Runnable()
    {
      public void run()
      {
        MainActivity.H(MainActivity.this).setEnabled(true);
        MainActivity.I(MainActivity.this).setEnabled(true);
        MainActivity.J(MainActivity.this).setEnabled(true);
        MainActivity.K(MainActivity.this).setEnabled(true);
        MainActivity.L(MainActivity.this).setEnabled(true);
        MainActivity.M(MainActivity.this).setEnabled(true);
        MainActivity.N(MainActivity.this).setEnabled(true);
        MainActivity.O(MainActivity.this).setEnabled(true);
        MainActivity.w(MainActivity.this).setEnabled(true);
        MainActivity.P(MainActivity.this).setEnabled(true);
        MainActivity.Q(MainActivity.this).setEnabled(true);
        MainActivity.P(MainActivity.this).setVisibility(0);
        MainActivity.Q(MainActivity.this).setVisibility(0);
        MainActivity.R(MainActivity.this).setHideFilterButton(false);
        MainActivity.R(MainActivity.this).setHideRandomFilterButton(false);
        MainActivity.R(MainActivity.this).updateTextViewVisibles();
      }
    });
  }
  
  private void ay()
  {
    this.al.b();
    g();
    j();
    a(false);
  }
  
  private void az()
  {
    float f2 = 0.0F;
    for (;;)
    {
      try
      {
        float f3 = this.ae;
        float f1 = f2;
        switch (this.g)
        {
        case 0: 
          this.ae = f1;
          a(this.J, f3, f1);
          if (this.ad == 1)
          {
            this.K.setVisibility(4);
            a(this.M, f3, f1);
            a(this.N, f3, f1);
            a(this.O, f3, f1);
            a(this.P, f3, f1);
            if (com.venticake.retrica.setting.a.a().s() > 0) {
              a(this.D, f3, f1);
            }
            return;
          }
        case 1: 
          f1 = 90.0F;
          break;
        case 3: 
          f1 = -90.0F;
          break;
        case 2: 
          f1 = 180.0F;
          continue;
          a(this.K, f3, f1);
          break;
        }
        f1 = f2;
      }
      finally {}
    }
  }
  
  public static Camera b()
  {
    return f(1);
  }
  
  /* Error */
  private void b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 310	com/venticake/retrica/setting/a:a	()Lcom/venticake/retrica/setting/a;
    //   5: invokevirtual 313	com/venticake/retrica/setting/a:w	()Z
    //   8: ifeq +21 -> 29
    //   11: aload_0
    //   12: getfield 330	com/venticake/retrica/MainActivity:B	Landroid/widget/TextView;
    //   15: invokevirtual 782	android/widget/TextView:clearAnimation	()V
    //   18: aload_0
    //   19: getfield 330	com/venticake/retrica/MainActivity:B	Landroid/widget/TextView;
    //   22: iconst_4
    //   23: invokevirtual 788	android/widget/TextView:setVisibility	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 297	com/venticake/retrica/MainActivity:au	Ljava/lang/Runnable;
    //   33: ifnull +14 -> 47
    //   36: aload_0
    //   37: getfield 476	com/venticake/retrica/MainActivity:I	Landroid/os/Handler;
    //   40: aload_0
    //   41: getfield 297	com/venticake/retrica/MainActivity:au	Ljava/lang/Runnable;
    //   44: invokevirtual 1087	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   47: aload_0
    //   48: new 60	com/venticake/retrica/MainActivity$29
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 1496	com/venticake/retrica/MainActivity$29:<init>	(Lcom/venticake/retrica/MainActivity;)V
    //   56: putfield 297	com/venticake/retrica/MainActivity:au	Ljava/lang/Runnable;
    //   59: aload_0
    //   60: getfield 476	com/venticake/retrica/MainActivity:I	Landroid/os/Handler;
    //   63: aload_0
    //   64: getfield 297	com/venticake/retrica/MainActivity:au	Ljava/lang/Runnable;
    //   67: lload_1
    //   68: invokevirtual 703	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   71: pop
    //   72: goto -46 -> 26
    //   75: astore_3
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_3
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	MainActivity
    //   0	80	1	paramLong	long
    //   75	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	75	finally
    //   29	47	75	finally
    //   47	72	75	finally
  }
  
  private void b(com.venticake.retrica.engine.a.g paramg)
  {
    if (paramg == null) {
      return;
    }
    paramg.a(com.venticake.retrica.setting.a.a().g());
    paramg.c(am());
    paramg.d(an());
    if (this.z != null)
    {
      a(paramg, this.z.eventDispatcher().getCenterX(), this.z.eventDispatcher().getCenterY());
      a(paramg, this.z.eventDispatcher().getRadius());
    }
    if (an()) {
      paramg.s();
    }
    paramg.a(this.al.d());
  }
  
  private void b(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.n;
        if (localObject1 == null) {
          return;
        }
        localObject1 = this.n.getCurrentLens();
        if (localObject1 == null) {
          continue;
        }
        if (com.venticake.retrica.setting.a.a().w())
        {
          this.B.clearAnimation();
          this.B.setVisibility(4);
          continue;
        }
        UserInterfaceUtil.updateTextViewForLensTitle(this.B);
      }
      finally {}
      this.B.setText(((com.venticake.retrica.engine.a.g)localObject2).x());
      this.B.clearAnimation();
      this.B.setVisibility(0);
      M();
      if (paramBoolean)
      {
        ScaleAnimation localScaleAnimation = new ScaleAnimation(2.0F, 1.0F, 2.0F, 1.0F, 2, 0.5F, 2, 0.5F);
        localScaleAnimation.setDuration(100L);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(100L);
        AnimationSet localAnimationSet = new AnimationSet(false);
        localAnimationSet.addAnimation(localScaleAnimation);
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.setAnimationListener(new Animation.AnimationListener()
        {
          public void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            MainActivity.C(MainActivity.this).setVisibility(0);
          }
          
          public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.B.startAnimation(localAnimationSet);
        b(1000L);
      }
      else
      {
        b(900L);
      }
    }
  }
  
  private void c(final com.venticake.retrica.engine.a.g paramg)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.I.post(new Runnable()
      {
        public void run()
        {
          MainActivity.a(MainActivity.this, paramg);
        }
      });
      return;
    }
    if (com.venticake.retrica.setting.a.a().w()) {
      this.am = false;
    }
    while (this.am)
    {
      int i1 = getResources().getIdentifier("ico_locker", "drawable", "com.venticake.retrica");
      this.R.setImageResource(i1);
      return;
      try
      {
        this.am = com.venticake.retrica.engine.a.a.b().b(paramg);
      }
      catch (Exception paramg)
      {
        paramg.printStackTrace();
      }
    }
    this.R.setImageResource(0);
  }
  
  /* Error */
  private void c(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 330	com/venticake/retrica/MainActivity:B	Landroid/widget/TextView;
    //   6: invokevirtual 782	android/widget/TextView:clearAnimation	()V
    //   9: iload_1
    //   10: ifeq +98 -> 108
    //   13: new 1531	android/view/animation/ScaleAnimation
    //   16: dup
    //   17: fconst_1
    //   18: ldc_w 1579
    //   21: fconst_1
    //   22: ldc_w 1579
    //   25: iconst_2
    //   26: ldc_w 1532
    //   29: iconst_2
    //   30: ldc_w 1532
    //   33: invokespecial 1535	android/view/animation/ScaleAnimation:<init>	(FFFFIFIF)V
    //   36: astore_2
    //   37: aload_2
    //   38: ldc2_w 904
    //   41: invokevirtual 1536	android/view/animation/ScaleAnimation:setDuration	(J)V
    //   44: new 1538	android/view/animation/AlphaAnimation
    //   47: dup
    //   48: fconst_1
    //   49: fconst_0
    //   50: invokespecial 1540	android/view/animation/AlphaAnimation:<init>	(FF)V
    //   53: astore_3
    //   54: aload_3
    //   55: ldc2_w 904
    //   58: invokevirtual 1541	android/view/animation/AlphaAnimation:setDuration	(J)V
    //   61: new 1543	android/view/animation/AnimationSet
    //   64: dup
    //   65: iconst_0
    //   66: invokespecial 1545	android/view/animation/AnimationSet:<init>	(Z)V
    //   69: astore 4
    //   71: aload 4
    //   73: aload_2
    //   74: invokevirtual 1548	android/view/animation/AnimationSet:addAnimation	(Landroid/view/animation/Animation;)V
    //   77: aload 4
    //   79: aload_3
    //   80: invokevirtual 1548	android/view/animation/AnimationSet:addAnimation	(Landroid/view/animation/Animation;)V
    //   83: aload 4
    //   85: new 64	com/venticake/retrica/MainActivity$30
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 1580	com/venticake/retrica/MainActivity$30:<init>	(Lcom/venticake/retrica/MainActivity;)V
    //   93: invokevirtual 1553	android/view/animation/AnimationSet:setAnimationListener	(Landroid/view/animation/Animation$AnimationListener;)V
    //   96: aload_0
    //   97: getfield 330	com/venticake/retrica/MainActivity:B	Landroid/widget/TextView;
    //   100: aload 4
    //   102: invokevirtual 779	android/widget/TextView:startAnimation	(Landroid/view/animation/Animation;)V
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: aload_0
    //   109: getfield 330	com/venticake/retrica/MainActivity:B	Landroid/widget/TextView;
    //   112: iconst_4
    //   113: invokevirtual 788	android/widget/TextView:setVisibility	(I)V
    //   116: aload_0
    //   117: invokespecial 1118	com/venticake/retrica/MainActivity:M	()V
    //   120: goto -15 -> 105
    //   123: astore_2
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_2
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	MainActivity
    //   0	128	1	paramBoolean	boolean
    //   36	38	2	localScaleAnimation	ScaleAnimation
    //   123	4	2	localObject	Object
    //   53	27	3	localAlphaAnimation	AlphaAnimation
    //   69	32	4	localAnimationSet	AnimationSet
    // Exception table:
    //   from	to	target	type
    //   2	9	123	finally
    //   13	105	123	finally
    //   108	120	123	finally
  }
  
  /* Error */
  private void d(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 260	com/venticake/retrica/MainActivity:e	Lcom/venticake/retrica/view/LensSelector;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 260	com/venticake/retrica/MainActivity:e	Lcom/venticake/retrica/view/LensSelector;
    //   13: getfield 1383	com/venticake/retrica/view/LensSelector:lensIntensityControlView	Lcom/venticake/retrica/view/LensIntensityControlView;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnonnull +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 330	com/venticake/retrica/MainActivity:B	Landroid/widget/TextView;
    //   28: invokevirtual 782	android/widget/TextView:clearAnimation	()V
    //   31: aload_0
    //   32: getfield 260	com/venticake/retrica/MainActivity:e	Lcom/venticake/retrica/view/LensSelector;
    //   35: getfield 1383	com/venticake/retrica/view/LensSelector:lensIntensityControlView	Lcom/venticake/retrica/view/LensIntensityControlView;
    //   38: invokevirtual 1389	com/venticake/retrica/view/LensIntensityControlView:getIntensity	()F
    //   41: fstore_2
    //   42: aload_0
    //   43: getfield 330	com/venticake/retrica/MainActivity:B	Landroid/widget/TextView;
    //   46: ldc_w 1395
    //   49: iconst_1
    //   50: anewarray 794	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: fload_2
    //   56: ldc_w 1396
    //   59: fmul
    //   60: invokestatic 1401	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   63: aastore
    //   64: invokestatic 806	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   67: invokevirtual 810	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   70: aload_0
    //   71: getfield 330	com/venticake/retrica/MainActivity:B	Landroid/widget/TextView;
    //   74: fconst_0
    //   75: iload_1
    //   76: new 66	com/venticake/retrica/MainActivity$31
    //   79: dup
    //   80: aload_0
    //   81: invokespecial 1583	com/venticake/retrica/MainActivity$31:<init>	(Lcom/venticake/retrica/MainActivity;)V
    //   84: invokestatic 1586	com/venticake/retrica/util/UserInterfaceUtil:setAlpha	(Landroid/view/View;FZLandroid/view/animation/Animation$AnimationListener;)V
    //   87: goto -66 -> 21
    //   90: astore_3
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_3
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	MainActivity
    //   0	95	1	paramBoolean	boolean
    //   41	15	2	f1	float
    //   16	2	3	localLensIntensityControlView	LensIntensityControlView
    //   90	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	90	finally
    //   24	87	90	finally
  }
  
  private void e(final boolean paramBoolean)
  {
    this.I.post(new Runnable()
    {
      public void run()
      {
        MainActivity.H(MainActivity.this).setEnabled(false);
        MainActivity.I(MainActivity.this).setEnabled(false);
        MainActivity.J(MainActivity.this).setEnabled(false);
        MainActivity.K(MainActivity.this).setEnabled(false);
        MainActivity.L(MainActivity.this).setEnabled(false);
        MainActivity.M(MainActivity.this).setEnabled(false);
        MainActivity.N(MainActivity.this).setEnabled(false);
        MainActivity.O(MainActivity.this).setEnabled(false);
        MainActivity.w(MainActivity.this).setEnabled(paramBoolean);
        MainActivity.P(MainActivity.this).setEnabled(false);
        MainActivity.Q(MainActivity.this).setEnabled(false);
      }
    });
  }
  
  @TargetApi(9)
  private static Camera f(int paramInt)
  {
    int i2 = Camera.getNumberOfCameras();
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        return null;
      }
      Camera.getCameraInfo(i1, localCameraInfo);
      if (localCameraInfo.facing == paramInt) {
        return Camera.open(i1);
      }
      i1 += 1;
    }
  }
  
  /* Error */
  private void g(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 276	com/venticake/retrica/MainActivity:aj	I
    //   6: istore_2
    //   7: iload_1
    //   8: iload_2
    //   9: if_icmpne +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: iload_1
    //   17: putfield 276	com/venticake/retrica/MainActivity:aj	I
    //   20: ldc_w 1370
    //   23: new 421	java/lang/StringBuilder
    //   26: dup
    //   27: ldc_w 1605
    //   30: invokespecial 426	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 276	com/venticake/retrica/MainActivity:aj	I
    //   37: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: invokevirtual 434	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 855	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   46: pop
    //   47: aload_0
    //   48: getfield 541	com/venticake/retrica/MainActivity:D	Landroid/widget/TextView;
    //   51: invokevirtual 782	android/widget/TextView:clearAnimation	()V
    //   54: aload_0
    //   55: getfield 541	com/venticake/retrica/MainActivity:D	Landroid/widget/TextView;
    //   58: ldc_w 792
    //   61: iconst_1
    //   62: anewarray 794	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_0
    //   68: getfield 276	com/venticake/retrica/MainActivity:aj	I
    //   71: invokestatic 800	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokestatic 806	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   78: invokevirtual 810	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   81: aload_0
    //   82: getfield 541	com/venticake/retrica/MainActivity:D	Landroid/widget/TextView;
    //   85: iconst_0
    //   86: invokevirtual 788	android/widget/TextView:setVisibility	(I)V
    //   89: new 1543	android/view/animation/AnimationSet
    //   92: dup
    //   93: iconst_1
    //   94: invokespecial 1545	android/view/animation/AnimationSet:<init>	(Z)V
    //   97: astore_3
    //   98: aload_3
    //   99: iconst_1
    //   100: invokevirtual 1608	android/view/animation/AnimationSet:setFillBefore	(Z)V
    //   103: aload_3
    //   104: iconst_1
    //   105: invokevirtual 1609	android/view/animation/AnimationSet:setFillAfter	(Z)V
    //   108: aload_0
    //   109: getfield 266	com/venticake/retrica/MainActivity:ae	F
    //   112: fconst_0
    //   113: fcmpl
    //   114: ifeq +21 -> 135
    //   117: aload_0
    //   118: invokespecial 775	com/venticake/retrica/MainActivity:K	()Landroid/view/animation/RotateAnimation;
    //   121: astore 4
    //   123: aload 4
    //   125: iconst_1
    //   126: invokevirtual 1612	android/view/animation/RotateAnimation:setFillEnabled	(Z)V
    //   129: aload_3
    //   130: aload 4
    //   132: invokevirtual 1548	android/view/animation/AnimationSet:addAnimation	(Landroid/view/animation/Animation;)V
    //   135: new 1531	android/view/animation/ScaleAnimation
    //   138: dup
    //   139: fconst_2
    //   140: fconst_1
    //   141: fconst_2
    //   142: fconst_1
    //   143: iconst_2
    //   144: ldc_w 1532
    //   147: iconst_2
    //   148: ldc_w 1532
    //   151: invokespecial 1535	android/view/animation/ScaleAnimation:<init>	(FFFFIFIF)V
    //   154: astore 4
    //   156: aload 4
    //   158: ldc2_w 904
    //   161: invokevirtual 1536	android/view/animation/ScaleAnimation:setDuration	(J)V
    //   164: new 1538	android/view/animation/AlphaAnimation
    //   167: dup
    //   168: fconst_0
    //   169: fconst_1
    //   170: invokespecial 1540	android/view/animation/AlphaAnimation:<init>	(FF)V
    //   173: astore 5
    //   175: aload 5
    //   177: ldc2_w 904
    //   180: invokevirtual 1541	android/view/animation/AlphaAnimation:setDuration	(J)V
    //   183: aload_3
    //   184: aload 4
    //   186: invokevirtual 1548	android/view/animation/AnimationSet:addAnimation	(Landroid/view/animation/Animation;)V
    //   189: aload_3
    //   190: aload 5
    //   192: invokevirtual 1548	android/view/animation/AnimationSet:addAnimation	(Landroid/view/animation/Animation;)V
    //   195: aload_0
    //   196: getfield 541	com/venticake/retrica/MainActivity:D	Landroid/widget/TextView;
    //   199: aload_3
    //   200: invokevirtual 779	android/widget/TextView:startAnimation	(Landroid/view/animation/Animation;)V
    //   203: goto -191 -> 12
    //   206: astore_3
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_3
    //   210: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	MainActivity
    //   0	211	1	paramInt	int
    //   6	4	2	i1	int
    //   97	103	3	localAnimationSet	AnimationSet
    //   206	4	3	localObject1	Object
    //   121	64	4	localObject2	Object
    //   173	18	5	localAlphaAnimation	AlphaAnimation
    // Exception table:
    //   from	to	target	type
    //   2	7	206	finally
    //   15	135	206	finally
    //   135	203	206	finally
  }
  
  private void h(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Z.getLayoutParams();
      localLayoutParams.height = paramInt;
      this.Z.setLayoutParams(localLayoutParams);
      this.Z.updateCaptureButtonSize(paramInt);
      aC();
      this.e.setPreferredHeightInPixel(this.Y.getHeight() + paramInt);
      return;
    }
    this.I.post(new Runnable()
    {
      public void run()
      {
        MainActivity.b(MainActivity.this, paramInt);
      }
    });
  }
  
  public void A()
  {
    Intent localIntent;
    switch (1)
    {
    case 2: 
    case 4: 
    default: 
      localIntent = new Intent(this, PurchaseActivity.class);
    }
    for (;;)
    {
      startActivity(localIntent);
      return;
      localIntent = new Intent(this, PurchaseActivityForAmazon.class);
      continue;
      localIntent = new Intent(this, PurchaseActivity.class);
    }
  }
  
  @TargetApi(14)
  public Camera a(int paramInt1, int paramInt2, Activity paramActivity)
  {
    int i2 = 1;
    if (Build.VERSION.SDK_INT >= 9) {}
    for (int i1 = Camera.getNumberOfCameras();; i1 = 1)
    {
      this.v = a.getPackageManager().hasSystemFeature("android.hardware.camera.front");
      for (;;)
      {
        try
        {
          if (Build.VERSION.SDK_INT == 8) {
            paramActivity = Camera.open();
          }
        }
        catch (Exception localException2)
        {
          Camera.Parameters localParameters;
          Object localObject1;
          Object localObject2;
          paramActivity = null;
          continue;
          i1 = 0;
          continue;
        }
        try
        {
          localParameters = paramActivity.getParameters();
          localObject1 = localParameters.getSupportedFocusModes();
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localObject1 = ((List)localObject1).iterator();
            if (((Iterator)localObject1).hasNext()) {}
          }
          else
          {
            if (Build.VERSION.SDK_INT >= 14)
            {
              Log.d("retrica", "isAutoExposureLockSupported: " + localParameters.isAutoExposureLockSupported());
              if (localParameters.isAutoExposureLockSupported()) {
                localParameters.setAutoExposureLock(false);
              }
            }
            i1 = Build.VERSION.SDK_INT;
            if (i1 < 14) {}
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          try
          {
            localObject1 = Camera.open();
            paramActivity = (Activity)localObject1;
            localObject2 = new Camera.CameraInfo();
            paramActivity = (Activity)localObject1;
            com.venticake.retrica.setting.a.a().c(((Camera.CameraInfo)localObject2).facing);
            return (Camera)localObject1;
          }
          catch (Exception localException3)
          {
            localException1.printStackTrace();
            try
            {
              Camera localCamera1 = Camera.open(0);
              paramActivity = localCamera1;
              com.venticake.retrica.setting.a.a().c(0);
              return localCamera1;
            }
            catch (Exception localException4)
            {
              localException1.printStackTrace();
              try
              {
                Camera localCamera2 = Camera.open(1);
                paramActivity = localCamera2;
                com.venticake.retrica.setting.a.a().c(1);
                return localCamera2;
              }
              catch (Exception localException5)
              {
                localException1.printStackTrace();
                UserInterfaceUtil.displayError(this, getResources().getString(2131165290));
                finish();
                return paramActivity;
              }
            }
          }
          localObject2 = (Camera.Area)localException5.next();
          Log.d("retrica", "possibleMeteringArea: " + localObject2);
          continue;
        }
        try
        {
          localObject1 = localParameters.getMeteringAreas();
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localObject1 = ((List)localObject1).iterator();
            boolean bool = ((Iterator)localObject1).hasNext();
            if (bool) {
              continue;
            }
          }
        }
        catch (Exception localException6)
        {
          localException6.printStackTrace();
          continue;
          RetricaEngine.setPreviewFormat(17);
          continue;
        }
        localParameters.setPictureFormat(256);
        Log.d("retrica", "skipYUV: " + RetricaEngine.skipYUV());
        if (!RetricaEngine.skipYUV()) {
          continue;
        }
        RetricaEngine.setPreviewFormat(17);
        localParameters.setPreviewFormat(RetricaEngine.getPreviewFormat());
        Log.d("retrica", "chosen Format: " + RetricaEngine.getPreviewFormat());
        localObject1 = a(localParameters.getSupportedPreviewSizes(), paramInt1, paramInt2);
        a(localObject1[0], localObject1[1]);
        localObject1 = a(localParameters.getSupportedPictureSizes(), paramInt1, paramInt2);
        this.j = localObject1[0];
        this.k = localObject1[1];
        if ((this.h > 0) && (this.i > 0)) {
          localParameters.setPreviewSize(this.i, this.h);
        }
        if ((this.j > 0) && (this.k > 0)) {
          localParameters.setPictureSize(this.k, this.j);
        }
        a(paramActivity, localParameters);
        Log.d("retrica", "chosen Preview size: " + this.i + ", " + this.h);
        Log.d("retrica", "chosen Picture size: " + this.k + ", " + this.j);
        Log.d("retrica", "maxPictureWidth: " + n.b());
        paramActivity.setParameters(localParameters);
        return paramActivity;
        if ((Build.VERSION.SDK_INT >= 9) && (i1 == 1))
        {
          this.u = true;
          paramActivity = new Camera.CameraInfo();
          com.venticake.retrica.setting.a.a().c(paramActivity.facing);
          paramActivity = Camera.open(paramActivity.facing);
        }
        else
        {
          try
          {
            if (com.venticake.retrica.setting.a.a().m() != 1) {
              continue;
            }
            i1 = i2;
            if (i1 != 0)
            {
              paramActivity = b();
              continue;
            }
            paramActivity = a();
          }
          catch (Exception paramActivity)
          {
            paramActivity.printStackTrace();
            paramActivity = Camera.open();
          }
          continue;
          localObject2 = (String)((Iterator)localObject1).next();
          if (((String)localObject2).equals("auto"))
          {
            localParameters.setFocusMode("auto");
            Log.d("retrica", "% SET Focus Mode: " + (String)localObject2);
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    ak();
    if ((!this.R.isSelected()) && (com.venticake.retrica.setting.a.a().t() > 0)) {
      return;
    }
    if (paramInt < ae())
    {
      paramInt = com.venticake.retrica.setting.a.a().t();
      if (paramInt > 0)
      {
        this.E.playProgress(paramInt);
        this.af.a(new Runnable()
        {
          public void run()
          {
            if (!MainActivity.w(MainActivity.this).isSelected()) {
              return;
            }
            if (com.venticake.retrica.setting.a.a().w())
            {
              MainActivity.x(MainActivity.this);
              return;
            }
            MainActivity.f(MainActivity.this);
          }
        }, paramInt);
        return;
      }
      this.R.setSelected(false);
      this.R.setEnabled(true);
      return;
    }
    as();
  }
  
  public void a(Uri paramUri)
  {
    a(paramUri, null);
  }
  
  public void a(Uri paramUri, String paramString)
  {
    S();
    Log.i("Retrica", "hjh : showQuickView() Uri" + paramUri);
    if ("android.media.action.IMAGE_CAPTURE".equals(this.x))
    {
      paramUri = new Intent();
      paramUri.putExtra("output", this.d);
      if (Build.VERSION.SDK_INT >= 14) {
        paramUri.putExtra("android.hardware.action.NEW_PICTURE", this.d);
      }
      paramUri.putExtra("com.android.camera.NEW_PICTURE", this.d);
      setResult(-1, paramUri);
      finish();
    }
    for (;;)
    {
      logEventPhotoTaken(y());
      return;
      Intent localIntent = new Intent(a, QuickViewActivity.class);
      localIntent.putExtra("From", "QuickView after capture");
      localIntent.putExtra("DisplayAd", true);
      localIntent.putExtra("URI", paramUri.toString());
      if (paramString != null) {
        localIntent.putExtra("DebugText", paramString);
      }
      startActivity(localIntent);
    }
  }
  
  public void a(com.venticake.retrica.engine.a.g paramg)
  {
    try
    {
      b(paramg);
      this.n.setLens(paramg);
      c(paramg);
      a(100L);
      com.venticake.retrica.setting.a.a().a(paramg.v());
      return;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.e.hide();
    if (paramBoolean) {
      c.b("Filter Selection View Dismissed");
    }
  }
  
  void b(int paramInt)
  {
    Button localButton1 = (Button)findViewById(2131296382);
    Button localButton2 = (Button)findViewById(2131296383);
    Button localButton3 = (Button)findViewById(2131296384);
    localButton1.setTextColor(-1);
    localButton1.setBackgroundColor(0);
    localButton2.setTextColor(-1);
    UserInterfaceUtil.setBackground(localButton2, getResources().getDrawable(2130837983));
    localButton3.setTextColor(-1);
    localButton3.setBackgroundColor(0);
    com.venticake.retrica.setting.a.a().a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      localButton1.setTextColor(Color.argb(128, 0, 0, 0));
      UserInterfaceUtil.setBackground(localButton1, getResources().getDrawable(2130837933));
      return;
    case 1: 
      localButton2.setTextColor(Color.argb(128, 0, 0, 0));
      localButton2.setBackgroundColor(-1);
      return;
    }
    localButton3.setTextColor(Color.argb(128, 0, 0, 0));
    UserInterfaceUtil.setBackground(localButton3, getResources().getDrawable(2130837975));
  }
  
  public boolean blurGestureEventEnabled()
  {
    return an();
  }
  
  public void blurTouchViewTouchDown() {}
  
  public void blurTouchViewTouchUp()
  {
    if (this.t != null) {}
    try
    {
      this.t.autoFocus(null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void c()
  {
    if (!this.al.a()) {
      ay();
    }
    this.al.a(this.O);
  }
  
  void c(int paramInt)
  {
    Button localButton1 = (Button)findViewById(2131296388);
    Button localButton2 = (Button)findViewById(2131296387);
    localButton1.setTextColor(-1);
    localButton1.setBackgroundColor(0);
    localButton2.setTextColor(-1);
    localButton2.setBackgroundColor(0);
    com.venticake.retrica.setting.a.a().b(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      localButton2.setTextColor(Color.argb(128, 0, 0, 0));
      UserInterfaceUtil.setBackground(localButton2, getResources().getDrawable(2130837933));
      return;
    }
    localButton1.setTextColor(Color.argb(128, 0, 0, 0));
    UserInterfaceUtil.setBackground(localButton1, getResources().getDrawable(2130837975));
  }
  
  public void centerChanged(float paramFloat1, float paramFloat2)
  {
    if (!an()) {
      return;
    }
    a(this.n.getCurrentLens(), paramFloat1, paramFloat2);
  }
  
  protected void d()
  {
    com.venticake.retrica.engine.a.g localg = this.n.getCurrentLens();
    if (localg.y()) {}
    for (boolean bool = false;; bool = true)
    {
      localg.c(bool);
      localg.q();
      com.venticake.retrica.setting.a.a().a(bool);
      at();
      return;
    }
  }
  
  public void d(int paramInt)
  {
    this.f = paramInt;
    al();
    at();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 66)
    {
      af();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void e()
  {
    com.venticake.retrica.engine.a.g localg = this.n.getCurrentLens();
    if (localg.z()) {}
    for (boolean bool = false;; bool = true)
    {
      localg.d(bool);
      localg.s();
      localg.q();
      com.venticake.retrica.setting.a.a().b(bool);
      at();
      return;
    }
  }
  
  public void e(final int paramInt)
  {
    try
    {
      this.I.post(new Runnable()
      {
        public void run()
        {
          MainActivity.a(MainActivity.this).setProgress(paramInt);
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void f()
  {
    if (this.aa.getVisibility() != 0)
    {
      ay();
      h();
    }
    for (;;)
    {
      at();
      return;
      g();
    }
  }
  
  protected void g()
  {
    this.aa.setVisibility(4);
    this.F.setVisibility(4);
    this.O.setSelected(false);
  }
  
  public void gestureEventFinished()
  {
    if (!an()) {
      return;
    }
    this.n.getCurrentLens().B();
  }
  
  public void gestureEventStarted()
  {
    if (!an()) {
      return;
    }
    this.n.getCurrentLens().A();
  }
  
  protected void h()
  {
    b(com.venticake.retrica.setting.a.a().k());
    Object localObject1 = (Button)findViewById(2131296382);
    Button localButton1 = (Button)findViewById(2131296383);
    Button localButton2 = (Button)findViewById(2131296384);
    if (b)
    {
      Object localObject4 = (LinearLayout)findViewById(2131296380);
      Object localObject3 = (LinearLayout)findViewById(2131296381);
      Object localObject2 = (LinearLayout)findViewById(2131296385);
      LinearLayout localLinearLayout = (LinearLayout)findViewById(2131296386);
      i1 = UserInterfaceUtil.dp2px(55.0F, (View)localObject2);
      int i2 = UserInterfaceUtil.dp2px(45.0F, localLinearLayout);
      ViewGroup.LayoutParams localLayoutParams = ((LinearLayout)localObject4).getLayoutParams();
      localLayoutParams.height = i1;
      ((LinearLayout)localObject4).setLayoutParams(localLayoutParams);
      localObject4 = ((LinearLayout)localObject4).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject4).height = i2;
      ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject3 = ((LinearLayout)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).height = i1;
      ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject2 = localLinearLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = i2;
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    ((Button)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.b(0);
      }
    });
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.b(1);
      }
    });
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.b(2);
      }
    });
    c(com.venticake.retrica.setting.a.a().l());
    localObject1 = (Button)findViewById(2131296388);
    localButton1 = (Button)findViewById(2131296387);
    ((Button)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.c(1);
      }
    });
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.c(0);
      }
    });
    int i1 = x();
    localObject1 = (FrameLayout.LayoutParams)this.aa.getLayoutParams();
    if (b) {
      ((FrameLayout.LayoutParams)localObject1).height = UserInterfaceUtil.dp2px(115.0F, this.F);
    }
    ((FrameLayout.LayoutParams)localObject1).setMargins(0, 0, 0, i1);
    this.aa.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.aa.setVisibility(0);
    a(this.F, getResources().getDrawable(2131230767));
    this.F.setVisibility(0);
    this.O.setSelected(true);
  }
  
  protected void i()
  {
    if (this.ab.getVisibility() != 0)
    {
      ay();
      k();
    }
    for (;;)
    {
      at();
      return;
      j();
    }
  }
  
  protected void j()
  {
    this.ab.setVisibility(4);
    this.F.setVisibility(4);
    this.P.setSelected(false);
  }
  
  protected void k()
  {
    this.W.setProgress(com.venticake.retrica.setting.a.a().s() * 10);
    this.X.setProgress(com.venticake.retrica.setting.a.a().t() / 20);
    int i1 = x();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ab.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, i1);
    if (b)
    {
      localLayoutParams.height = UserInterfaceUtil.dp2px(115.0F, this.F);
      Object localObject = (LinearLayout)findViewById(2131296390);
      LinearLayout localLinearLayout = (LinearLayout)findViewById(2131296392);
      i1 = UserInterfaceUtil.dp2px(52.5F, (View)localObject);
      ViewGroup.LayoutParams localLayoutParams1 = ((LinearLayout)localObject).getLayoutParams();
      localLayoutParams1.height = i1;
      ((LinearLayout)localObject).setLayoutParams(localLayoutParams1);
      localObject = localLinearLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i1;
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.ab.setLayoutParams(localLayoutParams);
    this.ab.setVisibility(0);
    a(this.F, getResources().getDrawable(2131230767));
    this.F.setVisibility(0);
    this.P.setSelected(true);
  }
  
  protected void l()
  {
    startActivity(new Intent(a, AlbumActivity.class));
    c.b("Show Album");
  }
  
  public com.venticake.retrica.engine.a.g lensSelectorSelectedLens()
  {
    if (this.n == null) {
      return null;
    }
    return this.n.getCurrentLens();
  }
  
  protected void m()
  {
    ay();
    n();
    try
    {
      a(com.venticake.retrica.engine.a.a.b().f());
      at();
      c.b("Random Lens");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void n()
  {
    Random localRandom = new Random();
    com.venticake.retrica.setting.a.a().a(localRandom.nextBoolean());
  }
  
  protected void o()
  {
    ay();
    this.e.show();
  }
  
  public void onBackPressed()
  {
    if (this.e.getVisibility() == 0)
    {
      this.e.onBackPressed();
      return;
    }
    if (this.al.a())
    {
      this.al.b();
      return;
    }
    if (this.O.isSelected())
    {
      g();
      return;
    }
    if (this.P.isSelected())
    {
      j();
      return;
    }
    super.onBackPressed();
  }
  
  public void onCloseButtonTouched()
  {
    a(true);
  }
  
  @SuppressLint({"NewApi"})
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (CommonUtil.isNotSupportOpenGLES2(this)) {
      finish();
    }
    a = this;
    H();
    I();
    J();
    this.ar = null;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Log.d("retrica", "MainActivity.onDestroy");
  }
  
  public void onHidden(LensSelector paramLensSelector)
  {
    UserInterfaceUtil.setAlpha(this.Y, 1.0F);
    UserInterfaceUtil.setAlpha(this.Z, 1.0F);
  }
  
  public void onIntensityEditModeChanged(LensIntensityControlView paramLensIntensityControlView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ah();
      return;
    }
    d(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("Value", c.a(paramLensIntensityControlView.getIntensity()));
    c.a("Lens Intensity Edited", localHashMap);
  }
  
  public void onIntensityValueChanged(LensIntensityControlView paramLensIntensityControlView, final float paramFloat)
  {
    ah();
    this.n.runOnRendererThread(new Runnable()
    {
      public void run()
      {
        MainActivity.this.n.getCurrentLens().a(paramFloat);
      }
    });
  }
  
  public void onLowMemory()
  {
    Log.d("retrica", "LOW MEMORY");
    if (Build.VERSION.SDK_INT < 14) {
      Q();
    }
    super.onLowMemory();
  }
  
  protected void onPause()
  {
    super.onPause();
    Log.d("retrica", "MainActivity.onPause");
    com.venticake.retrica.b.a.a();
    S();
    this.ac.disable();
    if (this.e.getVisibility() == 0) {
      a(false);
    }
    if (this.aa.getVisibility() == 0) {
      g();
    }
    P();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle.containsKey("cameraImageUri")) {
      this.d = Uri.parse(paramBundle.getString("cameraImageUri"));
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    Log.d("retrica", "MainActivity.onResume");
    this.x = getIntent().getAction();
    this.d = null;
    if ("android.media.action.IMAGE_CAPTURE".equals(this.x))
    {
      Bundle localBundle = getIntent().getExtras();
      if (localBundle != null)
      {
        this.d = ((Uri)localBundle.getParcelable("output"));
        Log.d("retrica", "save to: " + this.d);
      }
    }
    com.venticake.retrica.b.a.a(this);
    O();
    au();
    at();
    aq();
    M();
    ax();
    if (!this.w) {
      R();
    }
    this.ac.enable();
    if (this.G.getVisibility() == 0) {
      t();
    }
    if (com.venticake.retrica.setting.a.a().w()) {
      this.I.post(new Runnable()
      {
        public void run()
        {
          Toast localToast = Toast.makeText(MainActivity.this.getApplicationContext(), MainActivity.this.getResources().getString(2131165295), 1);
          localToast.setGravity(17, 0, 0);
          localToast.show();
        }
      });
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.d != null) {
      paramBundle.putString("cameraImageUri", this.d.toString());
    }
  }
  
  public void onSelectLens(com.venticake.retrica.engine.a.g paramg, LensSelector paramLensSelector)
  {
    if (paramg != null)
    {
      a(paramg);
      paramg = paramg.w();
      paramLensSelector = new HashMap();
      paramLensSelector.put("Name", paramg);
      c.a("Lens Selected", paramLensSelector);
    }
  }
  
  public void onShown(LensSelector paramLensSelector)
  {
    UserInterfaceUtil.setAlpha(this.Y, 0.5F);
    UserInterfaceUtil.setAlpha(this.Z, 0.5F);
  }
  
  protected void onStart()
  {
    super.onStart();
    Log.d("retrica", "MainActivity.onStart");
  }
  
  protected void onStop()
  {
    super.onStop();
    if (isFinishing()) {
      com.venticake.retrica.util.b.a().a(this);
    }
    Log.d("retrica", "MainActivity.onStop");
  }
  
  @TargetApi(14)
  public void onTrimMemory(int paramInt)
  {
    Log.d("retrica", "TRIM MEMORY: " + paramInt);
    Q();
    super.onTrimMemory(paramInt);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      Log.d("retrica", "MainActivity.onWindowFocusChanged EARN fous - previewFrameSize: " + this.y.getMeasuredWidth() + ", " + this.y.getMeasuredHeight());
      if (this.w)
      {
        this.w = false;
        R();
      }
      a(100L);
      return;
    }
    Log.d("retrica", "MainActivity.onWindowFocusChanged LOST focus - previewFrameSize: " + this.y.getMeasuredWidth() + ", " + this.y.getMeasuredHeight());
  }
  
  public boolean p()
  {
    if ((this.u) && (this.v)) {}
    do
    {
      return true;
      if (!q()) {
        return false;
      }
    } while (com.venticake.retrica.setting.a.a().m() == 1);
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public boolean q()
  {
    if ((this.u) && (this.v)) {
      return true;
    }
    if ((Build.VERSION.SDK_INT < 9) || (Camera.getNumberOfCameras() < 2)) {
      return false;
    }
    int i1 = Camera.getNumberOfCameras();
    Camera.CameraInfo localCameraInfo;
    do
    {
      if (i1 <= 0) {
        return false;
      }
      localCameraInfo = new Camera.CameraInfo();
      i1 -= 1;
      Camera.getCameraInfo(i1, localCameraInfo);
    } while (localCameraInfo.facing != 1);
    return true;
  }
  
  public boolean r()
  {
    return (this.f == 0) || (this.f == 20) || (this.f == 10);
  }
  
  public void radiusChanged(float paramFloat)
  {
    if (!an()) {
      return;
    }
    a(this.n.getCurrentLens(), paramFloat);
  }
  
  public void s()
  {
    try
    {
      this.I.post(new Runnable()
      {
        public void run()
        {
          MainActivity.a(MainActivity.this).setProgress(0);
          MainActivity.a(MainActivity.this).setVisibility(0);
          MainActivity.E(MainActivity.this).setVisibility(0);
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void swipedToLeft()
  {
    if (!this.e.selectNextLens()) {
      return;
    }
    c.b("Filter Swiped to Left");
  }
  
  public void swipedToRight()
  {
    if (!this.e.selectPreviousLens()) {
      return;
    }
    c.b("Filter Swiped to Right");
  }
  
  public void t()
  {
    this.I.post(new Runnable()
    {
      public void run()
      {
        MainActivity.a(MainActivity.this).setVisibility(4);
        MainActivity.E(MainActivity.this).setVisibility(4);
      }
    });
  }
  
  public void u()
  {
    UserInterfaceUtil.displayError(this, getResources().getString(2131165289));
    this.I.post(new Runnable()
    {
      public void run()
      {
        MainActivity.F(MainActivity.this);
        MainActivity.this.t();
        MainActivity.G(MainActivity.this);
        MainActivity.g(MainActivity.this);
      }
    });
  }
  
  protected void v()
  {
    int i2 = 0;
    int i1;
    if (this.l != null)
    {
      i1 = 0;
      if (i1 >= this.l.size()) {
        this.l = null;
      }
    }
    else if (this.m != null)
    {
      i1 = i2;
    }
    for (;;)
    {
      if (i1 >= this.m.size())
      {
        this.m = null;
        return;
        ((Bitmap)this.l.get(i1)).recycle();
        i1 += 1;
        break;
      }
      Uri localUri = (Uri)this.m.get(i1);
      boolean bool = g.a(this, localUri.toString());
      Log.d("retrica", "collage image file removed: " + bool + " - " + localUri);
      i1 += 1;
    }
  }
  
  protected void w()
  {
    this.I.post(new Runnable()
    {
      public void run()
      {
        MainActivity.H(MainActivity.this).setEnabled(true);
        MainActivity.I(MainActivity.this).setEnabled(true);
        MainActivity.J(MainActivity.this).setEnabled(true);
        MainActivity.K(MainActivity.this).setEnabled(false);
        MainActivity.L(MainActivity.this).setEnabled(false);
        MainActivity.M(MainActivity.this).setEnabled(true);
        MainActivity.N(MainActivity.this).setEnabled(true);
        MainActivity.O(MainActivity.this).setEnabled(true);
        MainActivity.w(MainActivity.this).setEnabled(true);
        MainActivity.P(MainActivity.this).setEnabled(false);
        MainActivity.Q(MainActivity.this).setEnabled(false);
        MainActivity.P(MainActivity.this).setVisibility(4);
        MainActivity.Q(MainActivity.this).setVisibility(4);
        MainActivity.R(MainActivity.this).setHideFilterButton(true);
        MainActivity.R(MainActivity.this).setHideRandomFilterButton(true);
        MainActivity.R(MainActivity.this).updateTextViewVisibles();
      }
    });
  }
  
  public int x()
  {
    int i1 = this.Y.getHeight() + this.Z.getHeight();
    if (this.av == 0) {
      this.av = i1;
    }
    return i1;
  }
  
  public Location y()
  {
    if (!this.q) {
      return null;
    }
    try
    {
      Location localLocation = this.o.getLastKnownLocation(this.p);
      return localLocation;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public Location z()
  {
    if (com.venticake.retrica.setting.a.a().o()) {
      return y();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
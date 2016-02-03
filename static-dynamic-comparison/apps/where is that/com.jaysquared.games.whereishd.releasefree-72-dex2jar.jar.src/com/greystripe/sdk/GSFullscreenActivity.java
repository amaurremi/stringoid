package com.greystripe.sdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.List;
import java.util.Timer;

public final class GSFullscreenActivity
  extends Activity
  implements Camera.PictureCallback
{
  private ay a;
  private FrameLayout b;
  private GSFullscreenAd c;
  private at d;
  private int e = -1;
  private Camera f;
  private Camera.Parameters g;
  private CameraPreview h;
  private boolean i;
  private Timer j;
  
  private void b(int paramInt)
  {
    if (this.f == null)
    {
      bd.b("camera was null", new Object[0]);
      return;
    }
    this.g = this.f.getParameters();
    if (Integer.parseInt(Build.VERSION.SDK) >= 8) {
      this.f.setDisplayOrientation(90);
    }
    for (;;)
    {
      this.f.setParameters(this.g);
      return;
      if (paramInt == 1)
      {
        bd.b("cam rotating to portrait", new Object[0]);
        this.g.set("orientation", "portrait");
      }
      if (paramInt == 2)
      {
        bd.b("cam rotating to landscape", new Object[0]);
        this.g.set("orientation", "landscape");
      }
    }
  }
  
  private void c()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.c.j().setLayerType(0, null);
      getWindow().setFlags(16777216, 16777216);
    }
    this.b.addView(this.a);
    this.d.setRootLayout(this.b);
  }
  
  private Camera d()
  {
    Object localObject1 = null;
    if (Integer.parseInt(Build.VERSION.SDK) >= 9)
    {
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      int m = Camera.getNumberOfCameras();
      int k = 0;
      for (;;)
      {
        if (k >= m) {
          break label97;
        }
        Camera.getCameraInfo(k, localCameraInfo);
        Object localObject2 = localObject1;
        if (localCameraInfo.facing == 1) {}
        try
        {
          localObject2 = Camera.open(k);
          localObject1 = localObject2;
          this.i = true;
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            bd.b("Front camera failed to open", new Object[0]);
            localRuntimeException.printStackTrace();
            localObject3 = localObject1;
          }
        }
        k += 1;
        localObject1 = localObject2;
      }
      label97:
      Object localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = e();
      }
      return (Camera)localObject3;
    }
    return e();
  }
  
  private Camera e()
  {
    this.i = false;
    try
    {
      Camera localCamera = Camera.open();
      return localCamera;
    }
    catch (RuntimeException localRuntimeException)
    {
      bd.b("Back camera failed to open", new Object[0]);
      localRuntimeException.printStackTrace();
    }
    return null;
  }
  
  private Camera f()
  {
    try
    {
      Camera localCamera = d();
      return localCamera;
    }
    catch (Exception localException)
    {
      bd.b("Camera does not exist.", new Object[0]);
      localException.printStackTrace();
    }
    return null;
  }
  
  private void g()
  {
    if (this.c == null) {}
    int k;
    do
    {
      return;
      k = this.c.m();
    } while (k == this.e);
    bd.b("cam orientation changed!", new Object[0]);
    this.c.j().b("EventHandler.broadcastEvent('orientationchange', " + this.c.m() + ");");
    this.e = k;
  }
  
  final int a()
  {
    return getResources().getConfiguration().orientation;
  }
  
  final void a(int paramInt)
  {
    bd.b("fullscreenactivity#setOrientation(" + paramInt + ")", new Object[0]);
    setRequestedOrientation(paramInt);
    g();
  }
  
  protected final void b()
  {
    bd.b("FullscreenActivity#lockOrientation()", new Object[0]);
    switch (a())
    {
    default: 
      return;
    case 2: 
      a(0);
      return;
    case 1: 
      a(1);
      return;
    case 3: 
      a(1);
      return;
    }
    a(1);
  }
  
  public final void onBackPressed()
  {
    bd.b("onBackPressed", new Object[0]);
    if (this.j != null)
    {
      this.j.cancel();
      this.j.purge();
    }
    this.d.a();
    this.c.k();
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    g();
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    setTheme(16973841);
    super.onCreate(paramBundle);
    if (GSFullscreenAd.c == null)
    {
      finish();
      return;
    }
    this.c = GSFullscreenAd.c;
    this.d = this.c.d;
    this.c.a(this);
    this.d.setActivity(this);
    this.a = new ay(this, this.c);
    this.b = new FrameLayout(this);
    g();
    RelativeLayout localRelativeLayout;
    int k;
    int m;
    int n;
    long l;
    List localList;
    int i1;
    label229:
    Camera.Size localSize;
    int i2;
    int i3;
    int i4;
    if (this.c.b)
    {
      this.i = false;
      this.f = f();
      if (this.f != null) {
        if (this.i)
        {
          b(-1);
          this.h = new CameraPreview(this, this.f);
          this.g = this.f.getParameters();
          localRelativeLayout = new RelativeLayout(this);
          paramBundle = getResources().getDisplayMetrics();
          k = paramBundle.widthPixels;
          m = paramBundle.heightPixels;
          n = m;
          if (k < m) {
            n = k;
          }
          l = (Runtime.getRuntime().maxMemory() * 0.1D);
          localList = this.g.getSupportedPictureSizes();
          k = 0;
          m = 0;
          paramBundle = null;
          i1 = 0;
          if (i1 >= localList.size()) {
            break label352;
          }
          localSize = (Camera.Size)localList.get(i1);
          i2 = localSize.width;
          i3 = localSize.height;
          if (i2 >= i3) {
            break label666;
          }
          i4 = i3;
          i3 = i2;
        }
      }
    }
    for (;;)
    {
      if ((i4 * i3 <= l) && (i4 > k) && (i3 > m))
      {
        m = localSize.width;
        k = localSize.height;
        paramBundle = localSize;
      }
      for (;;)
      {
        i2 = i1 + 1;
        i1 = m;
        m = k;
        k = i1;
        i1 = i2;
        break label229;
        b(1);
        break;
        label352:
        if (paramBundle == null) {
          localList.get(0);
        }
        bd.b("picture size: w:" + k + ", h: " + m, new Object[0]);
        this.g.setPictureSize(k, m);
        this.f.setParameters(this.g);
        if (m > n) {
          k = (int)(k / m * n);
        }
        for (;;)
        {
          k = (int)TypedValue.applyDimension(1, k, getResources().getDisplayMetrics());
          m = (int)TypedValue.applyDimension(1, n, getResources().getDisplayMetrics());
          if (k > m)
          {
            n = m;
            m = k;
          }
          for (;;)
          {
            bd.b("dipw: " + n + ", diph: " + m, new Object[0]);
            if (Build.VERSION.SDK_INT >= 11) {
              this.c.j().setLayerType(1, null);
            }
            paramBundle = new RelativeLayout.LayoutParams(n, m);
            paramBundle.addRule(13);
            localRelativeLayout.addView(this.h, paramBundle);
            paramBundle = new RelativeLayout.LayoutParams(-1, -1);
            localRelativeLayout.addView(this.a, paramBundle);
            this.b.addView(localRelativeLayout);
            this.j = new Timer();
            this.j.scheduleAtFixedRate(new az(this), 500L, 2000L);
            for (;;)
            {
              setContentView(this.b);
              return;
              c();
              continue;
              c();
            }
            n = k;
          }
          n = m;
        }
        i2 = k;
        k = m;
        m = i2;
      }
      label666:
      i4 = i2;
    }
  }
  
  public final void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    try
    {
      paramCamera.startPreview();
      paramCamera = (ActivityManager)getSystemService("activity");
      bd.b("pic memory: " + paramCamera.getMemoryClass(), new Object[0]);
      bd.b("pic runtime memory: " + Runtime.getRuntime().maxMemory(), new Object[0]);
      bd.b("pic byte memory: " + paramArrayOfByte.length, new Object[0]);
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      bd.b("allocated decodedPicture", new Object[0]);
      paramCamera = new Matrix();
      if (this.i)
      {
        paramCamera.preScale(-1.0F, 1.0F);
        if (paramArrayOfByte.getWidth() > paramArrayOfByte.getHeight())
        {
          bd.b("rotating 270 degrees", new Object[0]);
          paramCamera.preRotate(270.0F);
        }
        paramArrayOfByte = Bitmap.createBitmap(paramArrayOfByte, 0, 0, paramArrayOfByte.getWidth(), paramArrayOfByte.getHeight(), paramCamera, false);
        bd.b("allocated picture", new Object[0]);
        bd.b("decoded picture w " + paramArrayOfByte.getWidth() + " h " + paramArrayOfByte.getHeight(), new Object[0]);
        bm.a(new ba(this, paramArrayOfByte));
        return;
      }
    }
    catch (Exception paramCamera)
    {
      for (;;)
      {
        paramCamera.printStackTrace();
        onBackPressed();
        continue;
        paramCamera.preRotate(90.0F);
      }
    }
  }
  
  protected final void onStop()
  {
    super.onStop();
    if (!this.c.l())
    {
      bd.b("ad didn't have interaction", new Object[0]);
      this.c.k();
    }
    bd.b("closeActivity()", new Object[0]);
    if (this.j != null)
    {
      this.j.cancel();
      this.j.purge();
    }
    this.a.a();
    this.d.clearReferences();
    this.c.n();
    this.c.d();
    GSFullscreenAd.c = null;
    finish();
  }
  
  public final void takeScreenshot()
  {
    if (this.f != null) {
      this.f.takePicture(null, null, this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/GSFullscreenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
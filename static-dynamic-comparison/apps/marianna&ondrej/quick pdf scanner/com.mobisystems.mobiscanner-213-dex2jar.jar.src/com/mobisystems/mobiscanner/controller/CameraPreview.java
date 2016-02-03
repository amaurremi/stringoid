package com.mobisystems.mobiscanner.controller;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.AutoFocusMoveCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import com.mobisystems.mobiscanner.common.CameraPreferences;
import com.mobisystems.mobiscanner.common.CameraPreferences.b;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.common.d.a;
import com.mobisystems.mobiscanner.view.CameraFocusView;
import com.mobisystems.mobiscanner.view.CameraGridView;
import com.mobisystems.mobiscanner.view.CameraShutterView;
import java.util.Iterator;
import java.util.List;

public class CameraPreview
  extends FrameLayout
  implements Camera.AutoFocusCallback, SensorEventListener, SurfaceHolder.Callback
{
  private static float azq = 0.7F;
  private int ayA;
  private boolean ayH = false;
  private d.a ayI;
  private SurfaceView ayW;
  private CameraFocusView ayX;
  private CameraGridView ayY;
  private CameraShutterView ayZ;
  private Camera aye;
  private f ayo;
  private SurfaceHolder aza;
  private Camera.Size azb;
  private Camera.Size azc;
  private List<Camera.Size> azd;
  private Camera.Size aze;
  private String azf = "";
  private int azg;
  private boolean azh = false;
  private boolean azi = false;
  private boolean azj = false;
  private boolean azk = false;
  private boolean azl = false;
  private boolean azm = false;
  private float azn;
  private float azo;
  private float azp;
  private d azr;
  private final c mLog = new c(this);
  
  public CameraPreview(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public CameraPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  @TargetApi(15)
  private void EQ() {}
  
  @TargetApi(17)
  private void ER()
  {
    if (com.mobisystems.mobiscanner.common.d.DA()) {
      setSystemUiVisibility(257);
    }
  }
  
  private void EX()
  {
    if (("auto".equals(this.azf)) || ("macro".equals(this.azf))) {}
    try
    {
      if (!this.azi)
      {
        this.azk = false;
        this.aye.autoFocus(this);
        this.azi = true;
        this.ayX.EX();
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      this.mLog.g("Runtime exception while starting autofocus", localRuntimeException);
    }
  }
  
  private Camera.Size a(List<Camera.Size> paramList, Camera.Size paramSize, int paramInt1, int paramInt2, int paramInt3)
  {
    int j;
    int i;
    if (paramInt3 != 90)
    {
      j = paramInt1;
      i = paramInt2;
      if (paramInt3 != 270) {}
    }
    else
    {
      i = paramInt1;
      j = paramInt2;
    }
    this.mLog.dl("Oriented view size: w=" + j + ", h=" + i);
    double d2 = paramSize.width / paramSize.height;
    this.mLog.dl("Selected picture size: w=" + paramSize.width + ", h=" + paramSize.height + ", aspect ratio=" + d2);
    if (paramList == null) {
      return null;
    }
    paramSize = null;
    double d1 = Double.MAX_VALUE;
    Iterator localIterator = paramList.iterator();
    Camera.Size localSize;
    while (localIterator.hasNext())
    {
      localSize = (Camera.Size)localIterator.next();
      this.mLog.dl("Supported preview size: w=" + localSize.width + ", h=" + localSize.height);
      if (Math.abs(localSize.width / localSize.height - d2) <= 0.1D)
      {
        if (Math.abs(localSize.height - i) >= d1) {
          break label410;
        }
        d1 = Math.abs(localSize.height - i);
        paramSize = localSize;
      }
    }
    label405:
    label410:
    for (;;)
    {
      break;
      localSize = paramSize;
      if (paramSize == null)
      {
        localIterator = paramList.iterator();
        d1 = Double.MAX_VALUE;
        localSize = paramSize;
        if (localIterator.hasNext())
        {
          paramList = (Camera.Size)localIterator.next();
          if (Math.abs(paramList.height - i) >= d1) {
            break label405;
          }
          d1 = Math.abs(paramList.height - i);
        }
      }
      for (;;)
      {
        paramSize = paramList;
        break;
        this.mLog.dl("Optimal preview size: w=" + localSize.width + ", h=" + localSize.height);
        return localSize;
        paramList = paramSize;
      }
    }
  }
  
  @TargetApi(16)
  private void a(Camera.AutoFocusMoveCallback paramAutoFocusMoveCallback)
  {
    if (com.mobisystems.mobiscanner.common.d.Dz()) {}
    try
    {
      this.aye.setAutoFocusMoveCallback(paramAutoFocusMoveCallback);
      return;
    }
    catch (RuntimeException paramAutoFocusMoveCallback)
    {
      this.mLog.g("Error setting auto focus move callback", paramAutoFocusMoveCallback);
    }
  }
  
  private void setFocusMode(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (!this.azf.equals(str))
    {
      this.azf = str;
      this.mLog.dl("setFocusMode, focusMode=" + this.azf);
      if ((!"auto".equals(this.azf)) && (!"macro".equals(this.azf))) {
        break label126;
      }
      EX();
    }
    for (;;)
    {
      if (com.mobisystems.mobiscanner.common.d.Dz())
      {
        if ((!"continuous-picture".equals(this.azf)) && (!"continuous-video".equals(this.azf))) {
          break;
        }
        a(new a(null));
      }
      return;
      label126:
      if (this.azi)
      {
        this.aye.cancelAutoFocus();
        this.azi = false;
      }
      this.ayX.Jz();
    }
    a(null);
  }
  
  private void startPreview()
  {
    this.mLog.dl("startPreview");
    try
    {
      Camera.Parameters localParameters = this.aye.getParameters();
      localParameters.setPreviewSize(this.azb.width, this.azb.height);
      requestLayout();
      this.aye.setPreviewDisplay(this.aza);
      this.aye.setParameters(localParameters);
      this.aye.startPreview();
      this.azh = true;
      this.azf = "";
      setFocusMode(localParameters.getFocusMode());
      return;
    }
    catch (Exception localException)
    {
      this.mLog.g("Error starting camera preview: ", localException);
    }
  }
  
  private void stopPreview()
  {
    this.mLog.dl("stopPreview");
    if (this.azi)
    {
      this.aye.cancelAutoFocus();
      this.azi = false;
    }
    setFocusMode("");
    if (this.azh)
    {
      this.aye.stopPreview();
      this.azh = false;
    }
  }
  
  public void ES()
  {
    this.ayY.bt(((CameraPreferences.b)CameraPreferences.apb.CW()).Da());
  }
  
  public void ET()
  {
    if ((this.azf.equals("auto")) || (this.azf.equals("macro")))
    {
      this.mLog.dl("doFocus, focus needed, mAutoFocusStarted=" + this.azi);
      this.azl = true;
      EX();
    }
  }
  
  public void EU()
  {
    this.azl = false;
  }
  
  public void EV()
  {
    this.azj = true;
  }
  
  public void EW()
  {
    this.ayZ.EW();
  }
  
  public void EY()
  {
    setFocusMode("");
  }
  
  public void EZ()
  {
    setFocusMode(this.aye.getParameters().getFocusMode());
  }
  
  public void Ey()
  {
    stopPreview();
    Camera.Parameters localParameters = CameraPreferences.a(this.aye.getParameters());
    this.aye.setParameters(localParameters);
    startPreview();
    b(localParameters);
  }
  
  public void a(Camera paramCamera, int paramInt)
  {
    if (this.aye != null)
    {
      stopPreview();
      if (this.ayo != null)
      {
        this.ayo.release();
        this.ayo = null;
      }
    }
    this.aye = paramCamera;
    this.azg = paramInt;
    this.azj = true;
    this.azk = false;
    this.azl = false;
    if (this.aye != null)
    {
      this.ayo = new f(getContext());
      paramCamera = this.aye.getParameters();
      this.azd = paramCamera.getSupportedPreviewSizes();
      this.aze = paramCamera.getPictureSize();
      ES();
      requestLayout();
      EQ();
      if (this.azb != null) {
        startPreview();
      }
    }
  }
  
  public void a(d.a parama, int paramInt, boolean paramBoolean)
  {
    this.ayI = parama;
    this.ayA = paramInt;
    this.ayH = paramBoolean;
    if (this.ayI.awD > 0) {
      ER();
    }
  }
  
  public void a(d paramd)
  {
    this.azj = false;
    if ((this.azf.equals("auto")) || (this.azf.equals("macro")))
    {
      if (this.azl) {
        if (this.azi)
        {
          this.mLog.dl("takePicture, focus locked and not finished, wait to finish");
          this.azr = paramd;
        }
      }
      do
      {
        return;
        if (this.azk)
        {
          this.mLog.dl("takePicture, focus locked and succeeded, take the picture");
          paramd.En();
          return;
        }
        this.mLog.dl("takePicture, focus locked and failed, try again");
        paramd.Eo();
        return;
        this.azr = paramd;
      } while (this.azi);
      EX();
      return;
    }
    this.mLog.dl("takePicture, no focus needed");
    paramd.En();
  }
  
  public void b(Camera.Parameters paramParameters)
  {
    setFocusMode(paramParameters.getFocusMode());
    paramParameters = paramParameters.getPictureSize();
    if (!paramParameters.equals(this.aze))
    {
      this.mLog.dl("onChangeCameraParameters, new picture size, width=" + paramParameters.width + ", height=" + paramParameters.height);
      this.aze = paramParameters;
      requestLayout();
    }
    ES();
  }
  
  public void init(Context paramContext)
  {
    this.ayW = new SurfaceView(paramContext);
    addView(this.ayW);
    this.ayX = new CameraFocusView(paramContext);
    addView(this.ayX);
    this.ayY = new CameraGridView(paramContext);
    addView(this.ayY);
    this.ayZ = new CameraShutterView(paramContext);
    addView(this.ayZ);
    this.aza = this.ayW.getHolder();
    this.aza.addCallback(this);
    this.aza.setType(3);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.mLog.dl("Auto focus finish, success=" + paramBoolean);
    this.azi = false;
    this.azk = paramBoolean;
    this.ayX.bs(paramBoolean);
    if (paramBoolean)
    {
      this.ayo.Ff();
      if (this.azr != null) {
        this.azr.En();
      }
    }
    for (;;)
    {
      this.azr = null;
      return;
      if (this.azr != null) {
        this.azr.Eo();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 0;
    this.mLog.dl("OnLayout, changed=" + paramBoolean);
    if ((this.azc != null) && ((paramBoolean) || (!this.azc.equals(this.azb))) && (getChildCount() > 0))
    {
      int i = paramInt3 - paramInt1;
      paramInt3 = paramInt4 - paramInt2;
      this.azb = this.azc;
      int k;
      if ((this.azg == 90) || (this.azg == 270))
      {
        paramInt2 = this.azb.height;
        paramInt1 = this.azb.width;
        k = getChildCount();
        paramInt4 = this.ayI.awD + paramInt3;
        if (i * paramInt1 <= paramInt4 * paramInt2) {
          break label305;
        }
        paramInt2 = paramInt2 * paramInt4 / paramInt1;
        if (!this.ayH) {
          break label288;
        }
        paramInt1 = 0;
        label162:
        i = paramInt3;
        paramInt3 = 0;
        paramInt4 = paramInt1;
        paramInt1 = i;
      }
      for (;;)
      {
        this.mLog.dl("OnLayout, layout children: l=" + paramInt4 + ", t=" + paramInt3 + ", r=" + paramInt2 + ", b=" + paramInt1);
        i = j;
        while (i < k)
        {
          getChildAt(i).layout(paramInt4, paramInt3, paramInt2, paramInt1);
          i += 1;
        }
        paramInt2 = this.azb.width;
        paramInt1 = this.azb.height;
        break;
        label288:
        paramInt1 = (i - paramInt2) / 2;
        paramInt2 = (paramInt2 + i) / 2;
        break label162;
        label305:
        paramInt2 = paramInt1 * i / paramInt2;
        paramInt1 = paramInt2;
        if (paramInt2 > paramInt3) {
          paramInt1 = paramInt3;
        }
        if (this.ayH)
        {
          paramInt2 = i;
          paramInt3 = 0;
          paramInt4 = 0;
        }
        else
        {
          paramInt2 = (paramInt3 - paramInt1) / 2;
          paramInt1 = (paramInt1 + paramInt3) / 2;
          paramInt3 = paramInt2;
          paramInt2 = i;
          paramInt4 = 0;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = resolveSize(getSuggestedMinimumWidth(), paramInt1);
    paramInt2 = resolveSize(getSuggestedMinimumHeight(), paramInt2);
    this.mLog.dl("onMeasure, measured dimensions: width=" + paramInt1 + ", height=" + paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
    if (this.azd != null) {
      this.azc = a(this.azd, this.aze, paramInt1, paramInt2, this.azg);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((!this.azi) && (this.azj) && (!this.azl) && (this.aye != null))
    {
      float f1 = paramSensorEvent.values[0];
      float f2 = paramSensorEvent.values[1];
      float f3 = paramSensorEvent.values[2];
      if (!this.azm)
      {
        this.azn = f1;
        this.azo = f2;
        this.azp = f3;
        this.azm = true;
      }
      float f4 = Math.abs(this.azn - f1);
      float f5 = Math.abs(this.azo - f2);
      float f6 = Math.abs(this.azp - f3);
      if ((f4 > azq) || (f5 > azq) || (f6 > azq)) {
        EX();
      }
      this.azn = f1;
      this.azo = f2;
      this.azp = f3;
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mLog.dl("Surface changed, format=" + paramInt1 + ", w=" + paramInt2 + ", h=" + paramInt3);
    if (this.aye != null)
    {
      stopPreview();
      startPreview();
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.mLog.dl("Surface created");
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.mLog.dl("Surface destroyed");
    if (this.aye != null) {
      stopPreview();
    }
  }
  
  @TargetApi(16)
  private class a
    implements Camera.AutoFocusMoveCallback
  {
    private a() {}
    
    public void onAutoFocusMoving(boolean paramBoolean, Camera paramCamera)
    {
      CameraPreview.a(CameraPreview.this).dl("onAutoFocusMoving, start=" + paramBoolean);
      if (paramBoolean)
      {
        CameraPreview.b(CameraPreview.this).EX();
        return;
      }
      CameraPreview.b(CameraPreview.this).bs(true);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/CameraPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
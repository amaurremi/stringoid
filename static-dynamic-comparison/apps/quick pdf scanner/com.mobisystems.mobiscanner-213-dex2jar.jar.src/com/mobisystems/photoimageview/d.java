package com.mobisystems.photoimageview;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.util.FloatMath;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.ViewConfiguration;

public class d
  extends ScaleGestureDetector
{
  private float aNA;
  private float aNB;
  private boolean aNC;
  private float aND;
  private float aNE;
  private float aNF;
  private float aNG;
  private float aNH;
  private float aNI;
  private float aNJ;
  private boolean aNK;
  private int aNL;
  private int aNM;
  private float aNN;
  private float aNO;
  private float aNP;
  private int aNQ;
  private long aNR;
  private int aNS;
  private MotionEvent aNT;
  private int aNU = 0;
  private GestureDetector aNV;
  private boolean aNW;
  private final ScaleGestureDetector.OnScaleGestureListener aNz;
  private long aoe;
  private long aof;
  private final Context mContext;
  private final Handler mHandler;
  
  public d(Context paramContext, ScaleGestureDetector.OnScaleGestureListener paramOnScaleGestureListener)
  {
    this(paramContext, paramOnScaleGestureListener, null);
  }
  
  public d(Context paramContext, ScaleGestureDetector.OnScaleGestureListener paramOnScaleGestureListener, Handler paramHandler)
  {
    super(paramContext, null);
    this.mContext = paramContext;
    this.aNz = paramOnScaleGestureListener;
    this.aNL = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
    paramOnScaleGestureListener = paramContext.getResources();
    this.aNS = paramOnScaleGestureListener.getDimensionPixelSize(c.a.config_minScalingTouchMajor);
    this.aNM = paramOnScaleGestureListener.getDimensionPixelSize(c.a.config_minScalingSpan);
    this.mHandler = paramHandler;
    if (paramContext.getApplicationInfo().targetSdkVersion > 18) {
      setQuickScaleEnabled(true);
    }
  }
  
  private void KE()
  {
    this.aNN = NaN.0F;
    this.aNO = NaN.0F;
    this.aNP = NaN.0F;
    this.aNQ = 0;
    this.aNR = 0L;
  }
  
  private boolean KF()
  {
    return this.aNU == 1;
  }
  
  private void p(MotionEvent paramMotionEvent)
  {
    long l = SystemClock.uptimeMillis();
    int i1 = paramMotionEvent.getPointerCount();
    int i;
    float f1;
    int k;
    int j;
    label36:
    int m;
    label56:
    int i2;
    int n;
    label71:
    float f2;
    if (l - this.aNR >= 128L)
    {
      i = 1;
      f1 = 0.0F;
      k = 0;
      j = 0;
      if (k >= i1) {
        break label296;
      }
      if (Float.isNaN(this.aNP)) {
        break label255;
      }
      m = 1;
      int i3 = paramMotionEvent.getHistorySize();
      i2 = i3 + 1;
      n = 0;
      if (n >= i2) {
        break label280;
      }
      if (n >= i3) {
        break label261;
      }
      f2 = paramMotionEvent.getHistoricalTouchMajor(k, n);
      label94:
      float f3 = f2;
      if (f2 < this.aNS) {
        f3 = this.aNS;
      }
      f1 += f3;
      if ((Float.isNaN(this.aNN)) || (f3 > this.aNN)) {
        this.aNN = f3;
      }
      if ((Float.isNaN(this.aNO)) || (f3 < this.aNO)) {
        this.aNO = f3;
      }
      if (m == 0) {
        break label365;
      }
      int i4 = (int)Math.signum(f3 - this.aNP);
      if ((i4 == this.aNQ) && ((i4 != 0) || (this.aNQ != 0))) {
        break label365;
      }
      this.aNQ = i4;
      if (n >= i3) {
        break label271;
      }
      l = paramMotionEvent.getHistoricalEventTime(n);
      label231:
      this.aNR = l;
      i = 0;
    }
    label255:
    label261:
    label271:
    label280:
    label296:
    label365:
    for (;;)
    {
      n += 1;
      break label71;
      i = 0;
      break;
      m = 0;
      break label56;
      f2 = paramMotionEvent.getTouchMajor(k);
      break label94;
      l = paramMotionEvent.getEventTime();
      break label231;
      k += 1;
      j += i2;
      break label36;
      f1 /= j;
      if (i != 0)
      {
        f1 = (f1 + (this.aNN + this.aNO)) / 3.0F;
        this.aNN = ((this.aNN + f1) / 2.0F);
        this.aNO = ((this.aNO + f1) / 2.0F);
        this.aNP = f1;
        this.aNQ = 0;
        this.aNR = paramMotionEvent.getEventTime();
      }
      return;
    }
  }
  
  public float getCurrentSpan()
  {
    return this.aND;
  }
  
  public float getCurrentSpanX()
  {
    return this.aNG;
  }
  
  public float getCurrentSpanY()
  {
    return this.aNH;
  }
  
  public long getEventTime()
  {
    return this.aof;
  }
  
  public float getFocusX()
  {
    return this.aNA;
  }
  
  public float getFocusY()
  {
    return this.aNB;
  }
  
  public float getPreviousSpan()
  {
    return this.aNE;
  }
  
  public float getPreviousSpanX()
  {
    return this.aNI;
  }
  
  public float getPreviousSpanY()
  {
    return this.aNJ;
  }
  
  public float getScaleFactor()
  {
    float f = 1.0F;
    if (KF())
    {
      if (((this.aNW) && (this.aND < this.aNE)) || ((!this.aNW) && (this.aND > this.aNE))) {}
      for (int i = 1;; i = 0)
      {
        f = Math.abs(1.0F - this.aND / this.aNE) * 0.5F;
        if (this.aNE > 0.0F) {
          break;
        }
        return 1.0F;
      }
      if (i != 0) {
        return 1.0F + f;
      }
      return 1.0F - f;
    }
    if (this.aNE > 0.0F) {
      f = this.aND / this.aNE;
    }
    return f;
  }
  
  public long getTimeDelta()
  {
    return this.aof - this.aoe;
  }
  
  public boolean isInProgress()
  {
    return this.aNK;
  }
  
  public boolean isQuickScaleEnabled()
  {
    return this.aNC;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.aof = paramMotionEvent.getEventTime();
    int i1 = paramMotionEvent.getActionMasked();
    if (this.aNC) {
      this.aNV.onTouchEvent(paramMotionEvent);
    }
    if ((i1 == 1) || (i1 == 3))
    {
      i = 1;
      if ((i1 != 0) && (i == 0)) {
        break label134;
      }
      if (!this.aNK) {
        break label104;
      }
      this.aNz.onScaleEnd(this);
      this.aNK = false;
      this.aNF = 0.0F;
    }
    for (this.aNU = 0;; this.aNU = 0)
    {
      label104:
      do
      {
        if (i == 0) {
          break label134;
        }
        KE();
        return true;
        i = 0;
        break;
      } while ((!KF()) || (i == 0));
      this.aNK = false;
      this.aNF = 0.0F;
    }
    label134:
    int k;
    label165:
    int j;
    label176:
    int n;
    label193:
    float f2;
    float f1;
    label230:
    float f3;
    int m;
    if ((i1 == 0) || (i1 == 6) || (i1 == 5))
    {
      i = 1;
      if (i1 != 6) {
        break label273;
      }
      k = 1;
      if (k == 0) {
        break label279;
      }
      j = paramMotionEvent.getActionIndex();
      n = paramMotionEvent.getPointerCount();
      if (k == 0) {
        break label285;
      }
      k = n - 1;
      if (!KF()) {
        break label300;
      }
      f2 = this.aNT.getX();
      f1 = this.aNT.getY();
      if (paramMotionEvent.getY() >= f1) {
        break label292;
      }
      this.aNW = true;
      p(paramMotionEvent);
      f3 = 0.0F;
      f4 = 0.0F;
      m = 0;
      label244:
      if (m >= n) {
        break label415;
      }
      if (j != m) {
        break label366;
      }
    }
    for (;;)
    {
      m += 1;
      break label244;
      i = 0;
      break;
      label273:
      k = 0;
      break label165;
      label279:
      j = -1;
      break label176;
      label285:
      k = n;
      break label193;
      label292:
      this.aNW = false;
      break label230;
      label300:
      f1 = 0.0F;
      f2 = 0.0F;
      m = 0;
      if (m < n)
      {
        if (j == m) {}
        for (;;)
        {
          m += 1;
          break;
          f2 += paramMotionEvent.getX(m);
          f1 += paramMotionEvent.getY(m);
        }
      }
      f2 /= k;
      f1 /= k;
      break label230;
      label366:
      f5 = this.aNP / 2.0F;
      f4 += Math.abs(paramMotionEvent.getX(m) - f2) + f5;
      f3 += f5 + Math.abs(paramMotionEvent.getY(m) - f1);
    }
    label415:
    f4 /= k;
    f3 /= k;
    float f5 = f4 * 2.0F;
    float f4 = f3 * 2.0F;
    boolean bool;
    if (KF())
    {
      f3 = f4;
      bool = this.aNK;
      this.aNA = f2;
      this.aNB = f1;
      if ((!KF()) && (this.aNK) && ((f3 < this.aNM) || (i != 0)))
      {
        this.aNz.onScaleEnd(this);
        this.aNK = false;
        this.aNF = f3;
        this.aNU = 0;
      }
      if (i != 0)
      {
        this.aNG = f5;
        this.aNI = f5;
        this.aNH = f4;
        this.aNJ = f4;
        this.aND = f3;
        this.aNE = f3;
        this.aNF = f3;
      }
      if (!KF()) {
        break label788;
      }
    }
    label788:
    for (int i = this.aNL;; i = this.aNM)
    {
      if ((!this.aNK) && (f3 >= i) && ((bool) || (Math.abs(f3 - this.aNF) > this.aNL)))
      {
        this.aNG = f5;
        this.aNI = f5;
        this.aNH = f4;
        this.aNJ = f4;
        this.aND = f3;
        this.aNE = f3;
        this.aoe = this.aof;
        this.aNK = this.aNz.onScaleBegin(this);
      }
      if (i1 == 2)
      {
        this.aNG = f5;
        this.aNH = f4;
        this.aND = f3;
        bool = true;
        if (this.aNK) {
          bool = this.aNz.onScale(this);
        }
        if (bool)
        {
          this.aNI = this.aNG;
          this.aNJ = this.aNH;
          this.aNE = this.aND;
          this.aoe = this.aof;
        }
      }
      return true;
      f3 = FloatMath.sqrt(f5 * f5 + f4 * f4);
      break;
    }
  }
  
  public void setQuickScaleEnabled(boolean paramBoolean)
  {
    this.aNC = paramBoolean;
    if ((this.aNC) && (this.aNV == null))
    {
      GestureDetector.SimpleOnGestureListener local1 = new GestureDetector.SimpleOnGestureListener()
      {
        public boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
        {
          d.a(d.this, paramAnonymousMotionEvent);
          d.a(d.this, 1);
          return true;
        }
      };
      this.aNV = new GestureDetector(this.mContext, local1, this.mHandler);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/photoimageview/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
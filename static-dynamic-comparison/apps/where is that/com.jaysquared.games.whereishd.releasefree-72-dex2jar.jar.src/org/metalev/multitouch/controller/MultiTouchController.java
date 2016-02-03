package org.metalev.multitouch.controller;

import android.util.Log;
import android.view.MotionEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MultiTouchController<T>
{
  private static int ACTION_POINTER_INDEX_SHIFT = 0;
  private static int ACTION_POINTER_UP = 6;
  public static final boolean DEBUG = false;
  private static final long EVENT_SETTLE_TIME_INTERVAL = 20L;
  private static final float MAX_MULTITOUCH_DIM_JUMP_SIZE = 40.0F;
  private static final float MAX_MULTITOUCH_POS_JUMP_SIZE = 30.0F;
  public static final int MAX_TOUCH_POINTS = 20;
  private static final float MIN_MULTITOUCH_SEPARATION = 30.0F;
  private static final int MODE_DRAG = 1;
  private static final int MODE_NOTHING = 0;
  private static final int MODE_PINCH = 2;
  private static Method m_getHistoricalPressure;
  private static Method m_getHistoricalX;
  private static Method m_getHistoricalY;
  private static Method m_getPointerCount;
  private static Method m_getPointerId;
  private static Method m_getPressure;
  private static Method m_getX;
  private static Method m_getY;
  public static final boolean multiTouchSupported;
  private static final int[] pointerIds;
  private static final float[] pressureVals;
  private static final float[] xVals;
  private static final float[] yVals;
  private boolean handleSingleTouchEvents;
  private PointInfo mCurrPt = new PointInfo();
  private float mCurrPtAng;
  private float mCurrPtDiam;
  private float mCurrPtHeight;
  private float mCurrPtWidth;
  private float mCurrPtX;
  private float mCurrPtY;
  private final PositionAndScale mCurrXform = new PositionAndScale();
  private int mMode = 0;
  private PointInfo mPrevPt = new PointInfo();
  private long mSettleEndTime;
  private long mSettleStartTime;
  MultiTouchObjectCanvas<T> objectCanvas;
  private T selectedObject = null;
  private float startAngleMinusPinchAngle;
  private float startPosX;
  private float startPosY;
  private float startScaleOverPinchDiam;
  private float startScaleXOverPinchWidth;
  private float startScaleYOverPinchHeight;
  
  static
  {
    ACTION_POINTER_INDEX_SHIFT = 8;
    boolean bool = false;
    try
    {
      m_getPointerCount = MotionEvent.class.getMethod("getPointerCount", new Class[0]);
      m_getPointerId = MotionEvent.class.getMethod("getPointerId", new Class[] { Integer.TYPE });
      m_getPressure = MotionEvent.class.getMethod("getPressure", new Class[] { Integer.TYPE });
      m_getHistoricalX = MotionEvent.class.getMethod("getHistoricalX", new Class[] { Integer.TYPE, Integer.TYPE });
      m_getHistoricalY = MotionEvent.class.getMethod("getHistoricalY", new Class[] { Integer.TYPE, Integer.TYPE });
      m_getHistoricalPressure = MotionEvent.class.getMethod("getHistoricalPressure", new Class[] { Integer.TYPE, Integer.TYPE });
      m_getX = MotionEvent.class.getMethod("getX", new Class[] { Integer.TYPE });
      m_getY = MotionEvent.class.getMethod("getY", new Class[] { Integer.TYPE });
      bool = true;
    }
    catch (Exception localException1)
    {
      try
      {
        ACTION_POINTER_UP = MotionEvent.class.getField("ACTION_POINTER_UP").getInt(null);
        ACTION_POINTER_INDEX_SHIFT = MotionEvent.class.getField("ACTION_POINTER_INDEX_SHIFT").getInt(null);
        xVals = new float[20];
        yVals = new float[20];
        pressureVals = new float[20];
        pointerIds = new int[20];
        return;
        localException1 = localException1;
        Log.e("MultiTouchController", "static initializer failed", localException1);
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
    multiTouchSupported = bool;
    if (!multiTouchSupported) {}
  }
  
  public MultiTouchController(MultiTouchObjectCanvas<T> paramMultiTouchObjectCanvas)
  {
    this(paramMultiTouchObjectCanvas, true);
  }
  
  public MultiTouchController(MultiTouchObjectCanvas<T> paramMultiTouchObjectCanvas, boolean paramBoolean)
  {
    this.handleSingleTouchEvents = paramBoolean;
    this.objectCanvas = paramMultiTouchObjectCanvas;
  }
  
  private void anchorAtThisPositionAndScale()
  {
    if (this.selectedObject == null) {
      return;
    }
    this.objectCanvas.getPositionAndScale(this.selectedObject, this.mCurrXform);
    float f;
    if (!this.mCurrXform.updateScale) {
      f = 1.0F;
    }
    for (;;)
    {
      f = 1.0F / f;
      extractCurrPtInfo();
      this.startPosX = ((this.mCurrPtX - this.mCurrXform.xOff) * f);
      this.startPosY = ((this.mCurrPtY - this.mCurrXform.yOff) * f);
      this.startScaleOverPinchDiam = (this.mCurrXform.scale / this.mCurrPtDiam);
      this.startScaleXOverPinchWidth = (this.mCurrXform.scaleX / this.mCurrPtWidth);
      this.startScaleYOverPinchHeight = (this.mCurrXform.scaleY / this.mCurrPtHeight);
      this.startAngleMinusPinchAngle = (this.mCurrXform.angle - this.mCurrPtAng);
      return;
      if (this.mCurrXform.scale == 0.0F) {
        f = 1.0F;
      } else {
        f = this.mCurrXform.scale;
      }
    }
  }
  
  private void decodeTouchEvent(int paramInt1, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, int[] paramArrayOfInt, int paramInt2, boolean paramBoolean, long paramLong)
  {
    PointInfo localPointInfo = this.mPrevPt;
    this.mPrevPt = this.mCurrPt;
    this.mCurrPt = localPointInfo;
    this.mCurrPt.set(paramInt1, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3, paramArrayOfInt, paramInt2, paramBoolean, paramLong);
    multiTouchController();
  }
  
  private void extractCurrPtInfo()
  {
    float f2 = 0.0F;
    this.mCurrPtX = this.mCurrPt.getX();
    this.mCurrPtY = this.mCurrPt.getY();
    if (!this.mCurrXform.updateScale)
    {
      f1 = 0.0F;
      this.mCurrPtDiam = Math.max(21.3F, f1);
      if (this.mCurrXform.updateScaleXY) {
        break label120;
      }
      f1 = 0.0F;
      label59:
      this.mCurrPtWidth = Math.max(30.0F, f1);
      if (this.mCurrXform.updateScaleXY) {
        break label131;
      }
      f1 = 0.0F;
      label81:
      this.mCurrPtHeight = Math.max(30.0F, f1);
      if (this.mCurrXform.updateAngle) {
        break label142;
      }
    }
    label120:
    label131:
    label142:
    for (float f1 = f2;; f1 = this.mCurrPt.getMultiTouchAngle())
    {
      this.mCurrPtAng = f1;
      return;
      f1 = this.mCurrPt.getMultiTouchDiameter();
      break;
      f1 = this.mCurrPt.getMultiTouchWidth();
      break label59;
      f1 = this.mCurrPt.getMultiTouchHeight();
      break label81;
    }
  }
  
  private void multiTouchController()
  {
    MultiTouchObjectCanvas localMultiTouchObjectCanvas;
    switch (this.mMode)
    {
    default: 
    case 0: 
      do
      {
        do
        {
          return;
        } while (!this.mCurrPt.isDown());
        this.selectedObject = this.objectCanvas.getDraggableObjectAtPoint(this.mCurrPt);
      } while (this.selectedObject == null);
      this.mMode = 1;
      this.objectCanvas.selectObject(this.selectedObject, this.mCurrPt);
      anchorAtThisPositionAndScale();
      long l = this.mCurrPt.getEventTime();
      this.mSettleEndTime = l;
      this.mSettleStartTime = l;
      return;
    case 1: 
      if (!this.mCurrPt.isDown())
      {
        this.mMode = 0;
        localMultiTouchObjectCanvas = this.objectCanvas;
        this.selectedObject = null;
        localMultiTouchObjectCanvas.selectObject(null, this.mCurrPt);
        return;
      }
      if (this.mCurrPt.isMultiTouch())
      {
        this.mMode = 2;
        anchorAtThisPositionAndScale();
        this.mSettleStartTime = this.mCurrPt.getEventTime();
        this.mSettleEndTime = (this.mSettleStartTime + 20L);
        return;
      }
      if (this.mCurrPt.getEventTime() < this.mSettleEndTime)
      {
        anchorAtThisPositionAndScale();
        return;
      }
      performDragOrPinch();
      return;
    }
    if ((!this.mCurrPt.isMultiTouch()) || (!this.mCurrPt.isDown()))
    {
      if (!this.mCurrPt.isDown())
      {
        this.mMode = 0;
        localMultiTouchObjectCanvas = this.objectCanvas;
        this.selectedObject = null;
        localMultiTouchObjectCanvas.selectObject(null, this.mCurrPt);
        return;
      }
      this.mMode = 1;
      anchorAtThisPositionAndScale();
      this.mSettleStartTime = this.mCurrPt.getEventTime();
      this.mSettleEndTime = (this.mSettleStartTime + 20L);
      return;
    }
    if ((Math.abs(this.mCurrPt.getX() - this.mPrevPt.getX()) > 30.0F) || (Math.abs(this.mCurrPt.getY() - this.mPrevPt.getY()) > 30.0F) || (Math.abs(this.mCurrPt.getMultiTouchWidth() - this.mPrevPt.getMultiTouchWidth()) * 0.5F > 40.0F) || (Math.abs(this.mCurrPt.getMultiTouchHeight() - this.mPrevPt.getMultiTouchHeight()) * 0.5F > 40.0F))
    {
      anchorAtThisPositionAndScale();
      this.mSettleStartTime = this.mCurrPt.getEventTime();
      this.mSettleEndTime = (this.mSettleStartTime + 20L);
      return;
    }
    if (this.mCurrPt.eventTime < this.mSettleEndTime)
    {
      anchorAtThisPositionAndScale();
      return;
    }
    performDragOrPinch();
  }
  
  private void performDragOrPinch()
  {
    float f1 = 1.0F;
    if (this.selectedObject == null) {
      return;
    }
    if (!this.mCurrXform.updateScale) {}
    for (;;)
    {
      extractCurrPtInfo();
      float f2 = this.mCurrPtX;
      float f3 = this.startPosX;
      float f4 = this.mCurrPtY;
      float f5 = this.startPosY;
      float f6 = this.startScaleOverPinchDiam;
      float f7 = this.mCurrPtDiam;
      float f8 = this.startScaleXOverPinchWidth;
      float f9 = this.mCurrPtWidth;
      float f10 = this.startScaleYOverPinchHeight;
      float f11 = this.mCurrPtHeight;
      float f12 = this.startAngleMinusPinchAngle;
      float f13 = this.mCurrPtAng;
      this.mCurrXform.set(f2 - f3 * f1, f4 - f5 * f1, f6 * f7, f8 * f9, f10 * f11, f12 + f13);
      if (this.objectCanvas.setPositionAndScale(this.selectedObject, this.mCurrXform, this.mCurrPt)) {
        break;
      }
      return;
      if (this.mCurrXform.scale != 0.0F) {
        f1 = this.mCurrXform.scale;
      }
    }
  }
  
  protected boolean getHandleSingleTouchEvents()
  {
    return this.handleSingleTouchEvents;
  }
  
  public boolean isPinching()
  {
    return this.mMode == 2;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    int n;
    int i1;
    int j;
    label65:
    Object localObject;
    int k;
    float f;
    label93:
    label115:
    label140:
    int m;
    try
    {
      if (!multiTouchSupported) {
        break label593;
      }
      i = ((Integer)m_getPointerCount.invoke(paramMotionEvent, new Object[0])).intValue();
      if ((this.mMode == 0) && (!this.handleSingleTouchEvents) && (i == 1)) {
        return false;
      }
      n = paramMotionEvent.getAction();
      i1 = paramMotionEvent.getHistorySize() / i;
      j = 0;
    }
    catch (Exception paramMotionEvent)
    {
      float[] arrayOfFloat1;
      float[] arrayOfFloat2;
      int[] arrayOfInt;
      label171:
      label184:
      label220:
      label228:
      label247:
      label328:
      label383:
      label463:
      label487:
      label511:
      Log.e("MultiTouchController", "onTouchEvent() failed", paramMotionEvent);
      return false;
    }
    if ((!multiTouchSupported) || (i == 1))
    {
      localObject = xVals;
      if (k != 0)
      {
        f = paramMotionEvent.getHistoricalX(j);
        localObject[0] = f;
        localObject = yVals;
        if (k == 0) {
          break label220;
        }
        f = paramMotionEvent.getHistoricalY(j);
        localObject[0] = f;
        localObject = pressureVals;
        if (k == 0) {
          break label228;
        }
        f = paramMotionEvent.getHistoricalPressure(j);
        break label618;
        localObject = xVals;
        arrayOfFloat1 = yVals;
        arrayOfFloat2 = pressureVals;
        arrayOfInt = pointerIds;
        if (k == 0) {
          break label643;
        }
        m = 2;
        break label626;
      }
    }
    for (;;)
    {
      long l;
      if (k != 0)
      {
        l = paramMotionEvent.getHistoricalEventTime(j);
        decodeTouchEvent(i, (float[])localObject, arrayOfFloat1, arrayOfFloat2, arrayOfInt, m, bool, l);
        j += 1;
        break label598;
        f = paramMotionEvent.getX();
        break label93;
        f = paramMotionEvent.getY();
        break label115;
        f = paramMotionEvent.getPressure();
        break label618;
        int i2 = Math.min(i, 20);
        m = 0;
        if (m < i2)
        {
          int i3 = ((Integer)m_getPointerId.invoke(paramMotionEvent, new Object[] { Integer.valueOf(m) })).intValue();
          pointerIds[m] = i3;
          arrayOfFloat1 = xVals;
          if (k == 0) {
            break label463;
          }
          localObject = m_getHistoricalX.invoke(paramMotionEvent, new Object[] { Integer.valueOf(m), Integer.valueOf(j) });
          arrayOfFloat1[m] = ((Float)(Float)localObject).floatValue();
          arrayOfFloat1 = yVals;
          if (k == 0) {
            break label487;
          }
          localObject = m_getHistoricalY.invoke(paramMotionEvent, new Object[] { Integer.valueOf(m), Integer.valueOf(j) });
          arrayOfFloat1[m] = ((Float)(Float)localObject).floatValue();
          arrayOfFloat1 = pressureVals;
          if (k == 0) {
            break label511;
          }
        }
        for (localObject = m_getHistoricalPressure.invoke(paramMotionEvent, new Object[] { Integer.valueOf(m), Integer.valueOf(j) });; localObject = m_getPressure.invoke(paramMotionEvent, new Object[] { Integer.valueOf(m) }))
        {
          arrayOfFloat1[m] = ((Float)(Float)localObject).floatValue();
          m += 1;
          break label247;
          break;
          localObject = m_getX.invoke(paramMotionEvent, new Object[] { Integer.valueOf(m) });
          break label328;
          localObject = m_getY.invoke(paramMotionEvent, new Object[] { Integer.valueOf(m) });
          break label383;
        }
      }
      label593:
      label598:
      label618:
      label626:
      label643:
      label648:
      for (;;)
      {
        if ((n == 1) || (((1 << ACTION_POINTER_INDEX_SHIFT) - 1 & n) == ACTION_POINTER_UP) || (n == 3)) {
          break label650;
        }
        bool = true;
        break label171;
        l = paramMotionEvent.getEventTime();
        break label184;
        do
        {
          return true;
          i = 1;
          break;
        } while (j > i1);
        if (j < i1)
        {
          k = 1;
          break label65;
          localObject[0] = f;
          break label140;
        }
        for (;;)
        {
          if (k == 0) {
            break label648;
          }
          bool = true;
          break label171;
          k = 0;
          break;
          m = n;
        }
      }
      label650:
      boolean bool = false;
    }
  }
  
  protected void setHandleSingleTouchEvents(boolean paramBoolean)
  {
    this.handleSingleTouchEvents = paramBoolean;
  }
  
  public static abstract interface MultiTouchObjectCanvas<T>
  {
    public abstract T getDraggableObjectAtPoint(MultiTouchController.PointInfo paramPointInfo);
    
    public abstract void getPositionAndScale(T paramT, MultiTouchController.PositionAndScale paramPositionAndScale);
    
    public abstract void selectObject(T paramT, MultiTouchController.PointInfo paramPointInfo);
    
    public abstract boolean setPositionAndScale(T paramT, MultiTouchController.PositionAndScale paramPositionAndScale, MultiTouchController.PointInfo paramPointInfo);
  }
  
  public static class PointInfo
  {
    private int action;
    private float angle;
    private boolean angleIsCalculated;
    private float diameter;
    private boolean diameterIsCalculated;
    private float diameterSq;
    private boolean diameterSqIsCalculated;
    private float dx;
    private float dy;
    private long eventTime;
    private boolean isDown;
    private boolean isMultiTouch;
    private int numPoints;
    private final int[] pointerIds = new int[20];
    private float pressureMid;
    private final float[] pressures = new float[20];
    private float xMid;
    private final float[] xs = new float[20];
    private float yMid;
    private final float[] ys = new float[20];
    
    private int julery_isqrt(int paramInt)
    {
      int m = 0;
      int j = 32768;
      int k = 15;
      int i = paramInt;
      paramInt = k;
      for (;;)
      {
        int i1 = (m << 1) + j << paramInt;
        int n = m;
        k = i;
        if (i >= i1)
        {
          n = m + j;
          k = i - i1;
        }
        j >>= 1;
        if (j <= 0) {
          return n;
        }
        paramInt -= 1;
        m = n;
        i = k;
      }
    }
    
    private void set(int paramInt1, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, int[] paramArrayOfInt, int paramInt2, boolean paramBoolean, long paramLong)
    {
      this.eventTime = paramLong;
      this.action = paramInt2;
      this.numPoints = paramInt1;
      paramInt2 = 0;
      while (paramInt2 < paramInt1)
      {
        this.xs[paramInt2] = paramArrayOfFloat1[paramInt2];
        this.ys[paramInt2] = paramArrayOfFloat2[paramInt2];
        this.pressures[paramInt2] = paramArrayOfFloat3[paramInt2];
        this.pointerIds[paramInt2] = paramArrayOfInt[paramInt2];
        paramInt2 += 1;
      }
      this.isDown = paramBoolean;
      if (paramInt1 >= 2)
      {
        paramBoolean = true;
        this.isMultiTouch = paramBoolean;
        if (!this.isMultiTouch) {
          break label202;
        }
        this.xMid = ((paramArrayOfFloat1[0] + paramArrayOfFloat1[1]) * 0.5F);
        this.yMid = ((paramArrayOfFloat2[0] + paramArrayOfFloat2[1]) * 0.5F);
        this.pressureMid = ((paramArrayOfFloat3[0] + paramArrayOfFloat3[1]) * 0.5F);
        this.dx = Math.abs(paramArrayOfFloat1[1] - paramArrayOfFloat1[0]);
        this.dy = Math.abs(paramArrayOfFloat2[1] - paramArrayOfFloat2[0]);
      }
      for (;;)
      {
        this.angleIsCalculated = false;
        this.diameterIsCalculated = false;
        this.diameterSqIsCalculated = false;
        return;
        paramBoolean = false;
        break;
        label202:
        this.xMid = paramArrayOfFloat1[0];
        this.yMid = paramArrayOfFloat2[0];
        this.pressureMid = paramArrayOfFloat3[0];
        this.dy = 0.0F;
        this.dx = 0.0F;
      }
    }
    
    public int getAction()
    {
      return this.action;
    }
    
    public long getEventTime()
    {
      return this.eventTime;
    }
    
    public float getMultiTouchAngle()
    {
      if (!this.angleIsCalculated) {
        if (this.isMultiTouch) {
          break label29;
        }
      }
      label29:
      for (this.angle = 0.0F;; this.angle = ((float)Math.atan2(this.ys[1] - this.ys[0], this.xs[1] - this.xs[0])))
      {
        this.angleIsCalculated = true;
        return this.angle;
      }
    }
    
    public float getMultiTouchDiameter()
    {
      float f1 = 0.0F;
      if (!this.diameterIsCalculated)
      {
        if (!this.isMultiTouch)
        {
          this.diameter = 0.0F;
          this.diameterIsCalculated = true;
        }
      }
      else {
        return this.diameter;
      }
      float f2 = getMultiTouchDiameterSq();
      if (f2 == 0.0F) {}
      for (;;)
      {
        this.diameter = f1;
        if (this.diameter < this.dx) {
          this.diameter = this.dx;
        }
        if (this.diameter >= this.dy) {
          break;
        }
        this.diameter = this.dy;
        break;
        f1 = julery_isqrt((int)(256.0F * f2)) / 16.0F;
      }
    }
    
    public float getMultiTouchDiameterSq()
    {
      if (!this.diameterSqIsCalculated) {
        if (!this.isMultiTouch) {
          break label49;
        }
      }
      label49:
      for (float f = this.dx * this.dx + this.dy * this.dy;; f = 0.0F)
      {
        this.diameterSq = f;
        this.diameterSqIsCalculated = true;
        return this.diameterSq;
      }
    }
    
    public float getMultiTouchHeight()
    {
      if (this.isMultiTouch) {
        return this.dy;
      }
      return 0.0F;
    }
    
    public float getMultiTouchWidth()
    {
      if (this.isMultiTouch) {
        return this.dx;
      }
      return 0.0F;
    }
    
    public int getNumTouchPoints()
    {
      return this.numPoints;
    }
    
    public int[] getPointerIds()
    {
      return this.pointerIds;
    }
    
    public float getPressure()
    {
      return this.pressureMid;
    }
    
    public float[] getPressures()
    {
      return this.pressures;
    }
    
    public float getX()
    {
      return this.xMid;
    }
    
    public float[] getXs()
    {
      return this.xs;
    }
    
    public float getY()
    {
      return this.yMid;
    }
    
    public float[] getYs()
    {
      return this.ys;
    }
    
    public boolean isDown()
    {
      return this.isDown;
    }
    
    public boolean isMultiTouch()
    {
      return this.isMultiTouch;
    }
    
    public void set(PointInfo paramPointInfo)
    {
      this.numPoints = paramPointInfo.numPoints;
      int i = 0;
      while (i < this.numPoints)
      {
        this.xs[i] = paramPointInfo.xs[i];
        this.ys[i] = paramPointInfo.ys[i];
        this.pressures[i] = paramPointInfo.pressures[i];
        this.pointerIds[i] = paramPointInfo.pointerIds[i];
        i += 1;
      }
      this.xMid = paramPointInfo.xMid;
      this.yMid = paramPointInfo.yMid;
      this.pressureMid = paramPointInfo.pressureMid;
      this.dx = paramPointInfo.dx;
      this.dy = paramPointInfo.dy;
      this.diameter = paramPointInfo.diameter;
      this.diameterSq = paramPointInfo.diameterSq;
      this.angle = paramPointInfo.angle;
      this.isDown = paramPointInfo.isDown;
      this.action = paramPointInfo.action;
      this.isMultiTouch = paramPointInfo.isMultiTouch;
      this.diameterIsCalculated = paramPointInfo.diameterIsCalculated;
      this.diameterSqIsCalculated = paramPointInfo.diameterSqIsCalculated;
      this.angleIsCalculated = paramPointInfo.angleIsCalculated;
      this.eventTime = paramPointInfo.eventTime;
    }
  }
  
  public static class PositionAndScale
  {
    private float angle;
    private float scale;
    private float scaleX;
    private float scaleY;
    private boolean updateAngle;
    private boolean updateScale;
    private boolean updateScaleXY;
    private float xOff;
    private float yOff;
    
    public float getAngle()
    {
      if (!this.updateAngle) {
        return 0.0F;
      }
      return this.angle;
    }
    
    public float getScale()
    {
      if (!this.updateScale) {
        return 1.0F;
      }
      return this.scale;
    }
    
    public float getScaleX()
    {
      if (!this.updateScaleXY) {
        return 1.0F;
      }
      return this.scaleX;
    }
    
    public float getScaleY()
    {
      if (!this.updateScaleXY) {
        return 1.0F;
      }
      return this.scaleY;
    }
    
    public float getXOff()
    {
      return this.xOff;
    }
    
    public float getYOff()
    {
      return this.yOff;
    }
    
    protected void set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      float f = 1.0F;
      this.xOff = paramFloat1;
      this.yOff = paramFloat2;
      paramFloat1 = paramFloat3;
      if (paramFloat3 == 0.0F) {
        paramFloat1 = 1.0F;
      }
      this.scale = paramFloat1;
      paramFloat1 = paramFloat4;
      if (paramFloat4 == 0.0F) {
        paramFloat1 = 1.0F;
      }
      this.scaleX = paramFloat1;
      if (paramFloat5 == 0.0F) {}
      for (paramFloat1 = f;; paramFloat1 = paramFloat5)
      {
        this.scaleY = paramFloat1;
        this.angle = paramFloat6;
        return;
      }
    }
    
    public void set(float paramFloat1, float paramFloat2, boolean paramBoolean1, float paramFloat3, boolean paramBoolean2, float paramFloat4, float paramFloat5, boolean paramBoolean3, float paramFloat6)
    {
      float f = 1.0F;
      this.xOff = paramFloat1;
      this.yOff = paramFloat2;
      this.updateScale = paramBoolean1;
      paramFloat1 = paramFloat3;
      if (paramFloat3 == 0.0F) {
        paramFloat1 = 1.0F;
      }
      this.scale = paramFloat1;
      this.updateScaleXY = paramBoolean2;
      paramFloat1 = paramFloat4;
      if (paramFloat4 == 0.0F) {
        paramFloat1 = 1.0F;
      }
      this.scaleX = paramFloat1;
      if (paramFloat5 == 0.0F) {}
      for (paramFloat1 = f;; paramFloat1 = paramFloat5)
      {
        this.scaleY = paramFloat1;
        this.updateAngle = paramBoolean3;
        this.angle = paramFloat6;
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/metalev/multitouch/controller/MultiTouchController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
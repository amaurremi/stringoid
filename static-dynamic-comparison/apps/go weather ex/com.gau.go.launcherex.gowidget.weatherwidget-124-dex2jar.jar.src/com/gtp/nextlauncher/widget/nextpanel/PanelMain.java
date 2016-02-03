package com.gtp.nextlauncher.widget.nextpanel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.p;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.view.GLRelativeLayout;
import com.go.gl.view.GLRelativeLayout.LayoutParams;
import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnLongClickListener;
import com.go.gowidget.core.FullScreenNextWidgetCallback;
import com.go.gowidget.core.IFullScreenNextWidget;
import com.go.gowidget.core.WidgetCallback;
import java.util.ArrayList;
import java.util.Iterator;

public class PanelMain
  extends GLRelativeLayout
  implements GLView.OnLongClickListener, IFullScreenNextWidget, com.gtp.nextlauncher.widget.weatherwidget.h
{
  private static final long CHANGE_CITY_ANIMATION_DURATION = 500L;
  static Rect sClickRect = new Rect();
  private final float DEFAULT_ALPHA = 0.5F;
  private ArrayList mBgs = new ArrayList();
  private float mBottomAlpha = 0.5F;
  private long mChangeCityAnimationStartTime;
  int mCityCount = 0;
  private ArrayList mCityViewList = new ArrayList();
  private float[] mCorner = new float[3];
  private int mCur = 0;
  private com.gtp.nextlauncher.widget.weatherwidget.e mDataHandler;
  private GLDrawable mDayBg;
  private GLDrawable mDownDrawable;
  private float mDownX = -1.0F;
  private float mDownY = -1.0F;
  private Floor mFloor;
  private FullScreenNextWidgetCallback mFullScreenNextWidgetCallback;
  private boolean mHasMove = false;
  private boolean mIsInCityAnimation = false;
  private boolean mIsLive = false;
  private float mLeftAlpha = 0.5F;
  private GLDrawable mLeftDrawable;
  private Rect mLeftRect = new Rect();
  private GLDrawable mNA;
  private float mNextBgAlpha = 0.0F;
  private GLDrawable mNightBg;
  private float mOffX = 0.0F;
  private GLDrawable mRainyBg;
  private float mRightAlpha = 0.5F;
  private GLDrawable mRightDrawable;
  private Rect mRightRect = new Rect();
  private float mStartForeD = 50.0F;
  private boolean mToNextCity = true;
  private GLDrawable mUpDrawable;
  private Rect mUpRect = new Rect();
  private int mWidgetID = -1;
  private int mXmax = 10;
  private int mXmin = -1;
  
  public PanelMain(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PanelMain(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void checkFoucus(int paramInt1, int paramInt2)
  {
    if (this.mLeftRect.contains(paramInt1, paramInt2))
    {
      if (this.mLeftAlpha != 1.0F)
      {
        this.mLeftAlpha = 1.0F;
        invalidate();
      }
      if (this.mRightAlpha == 1.0F) {
        this.mRightAlpha = 0.5F;
      }
      if (this.mBottomAlpha == 1.0F) {
        this.mBottomAlpha = 0.5F;
      }
    }
    do
    {
      do
      {
        return;
        if (!this.mRightRect.contains(paramInt1, paramInt2)) {
          break;
        }
        if (this.mRightAlpha != 1.0F)
        {
          this.mRightAlpha = 1.0F;
          invalidate();
        }
        if (this.mLeftAlpha == 1.0F) {
          this.mLeftAlpha = 0.5F;
        }
      } while (this.mBottomAlpha != 1.0F);
      this.mBottomAlpha = 0.5F;
      return;
      if (!this.mUpRect.contains(paramInt1, paramInt2)) {
        break;
      }
      if (this.mBottomAlpha != 1.0F)
      {
        this.mBottomAlpha = 1.0F;
        invalidate();
      }
      if (this.mRightAlpha == 1.0F) {
        this.mRightAlpha = 0.5F;
      }
    } while (this.mLeftAlpha != 1.0F);
    this.mLeftAlpha = 0.5F;
    return;
    clearFoucus();
  }
  
  private void clearFoucus()
  {
    this.mLeftAlpha = 0.5F;
    this.mBottomAlpha = 0.5F;
    this.mRightAlpha = 0.5F;
    invalidate();
  }
  
  private void drawBg(GLCanvas paramGLCanvas)
  {
    int i = paramGLCanvas.getAlpha();
    if ((this.mBgs != null) && (this.mBgs.size() > this.mCur) && (this.mCur > -1))
    {
      localGLDrawable = (GLDrawable)this.mBgs.get(this.mCur);
      if (localGLDrawable != null) {
        localGLDrawable.draw(paramGLCanvas);
      }
      if (this.mIsInCityAnimation) {
        if (!this.mToNextCity) {
          break label122;
        }
      }
    }
    label122:
    for (GLDrawable localGLDrawable = (GLDrawable)this.mBgs.get(getNextCityIndex());; localGLDrawable = (GLDrawable)this.mBgs.get(getPreCItyIndex()))
    {
      paramGLCanvas.setAlpha((int)(i * this.mNextBgAlpha));
      if (localGLDrawable != null) {
        localGLDrawable.draw(paramGLCanvas);
      }
      paramGLCanvas.setAlpha(i);
      return;
      localGLDrawable = this.mRainyBg;
      break;
    }
  }
  
  private void foreChangeCityEnd()
  {
    ((CityView)this.mCityViewList.get(this.mCur)).clearWall();
    if (this.mToNextCity) {}
    for (this.mCur = this.mDataHandler.g();; this.mCur = this.mDataHandler.h())
    {
      this.mOffX = 0.0F;
      this.mNextBgAlpha = 0.0F;
      invalidate();
      return;
    }
  }
  
  private GLDrawable getBgDrawable(int paramInt)
  {
    if ((paramInt == 3) || (paramInt == 2) || (paramInt == 4)) {
      return this.mDayBg;
    }
    if ((paramInt == 9) || (paramInt == 10)) {
      return this.mNightBg;
    }
    return this.mRainyBg;
  }
  
  private int getNextCityIndex()
  {
    return (this.mCur + 1) % this.mCityCount;
  }
  
  private int getPreCItyIndex()
  {
    return (this.mCur - 1 + this.mCityCount) % this.mCityCount;
  }
  
  private float getYfX(float paramFloat)
  {
    return -(float)Math.pow(2.0D, -paramFloat);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    setOnLongClickListener(this);
    setOnClickListener(new h(this));
    this.mNA = e.a().M(paramContext);
    this.mLeftDrawable = e.a().a(this.mContext);
    this.mRightDrawable = e.a().b(this.mContext);
    this.mUpDrawable = e.a().c(this.mContext);
    this.mDownDrawable = e.a().d(this.mContext);
    this.mFloor = new Floor(this.mContext);
    addView(this.mFloor, new GLRelativeLayout.LayoutParams(-1, -1));
    this.mNightBg = e.a().k(this.mContext);
    this.mDayBg = e.a().t(this.mContext);
    this.mRainyBg = e.a().g(this.mContext);
    this.mBgs.add(this.mRainyBg);
  }
  
  private void initBg(int paramInt1, int paramInt2)
  {
    this.mNightBg.setBounds(0, 0, paramInt1, paramInt2);
    this.mDayBg.setBounds(0, 0, paramInt1, paramInt2);
    this.mRainyBg.setBounds(0, 0, paramInt1, paramInt2);
  }
  
  private void initBgs()
  {
    this.mBgs.clear();
    int i = 0;
    GLDrawable localGLDrawable;
    while (i < this.mCityViewList.size())
    {
      localGLDrawable = getBgDrawable(((CityView)this.mCityViewList.get(i)).getWeatherType());
      this.mBgs.add(localGLDrawable);
      i += 1;
    }
    if (this.mCityViewList.size() < 1)
    {
      localGLDrawable = this.mDayBg;
      this.mBgs.add(localGLDrawable);
    }
  }
  
  private boolean isShowForecast()
  {
    if (this.mCityViewList != null)
    {
      CityView localCityView = (CityView)this.mCityViewList.get(this.mCur);
      if (localCityView != null) {
        return localCityView.getIsFore();
      }
    }
    return false;
  }
  
  private void onChangeCity(float paramFloat)
  {
    if (paramFloat != 1.0F) {}
    for (float f = getInterpor(paramFloat);; f = paramFloat)
    {
      if (this.mToNextCity) {}
      for (this.mOffX = (-f * this.mWidth * 3.0F);; this.mOffX = (f * (this.mWidth * 3)))
      {
        this.mNextBgAlpha = paramFloat;
        if (paramFloat == 1.0F) {
          onChangeCityEnd();
        }
        invalidate();
        return;
      }
    }
  }
  
  private void onChangeCityEnd()
  {
    this.mIsInCityAnimation = false;
    ((CityView)this.mCityViewList.get(this.mCur)).clearWall();
    if (this.mToNextCity) {}
    for (this.mCur = this.mDataHandler.g();; this.mCur = this.mDataHandler.h())
    {
      ((CityView)this.mCityViewList.get(this.mCur)).initWall();
      ((CityView)this.mCityViewList.get(this.mCur)).showWeatherDesp();
      this.mOffX = 0.0F;
      this.mNextBgAlpha = 0.0F;
      invalidate();
      return;
    }
  }
  
  private void startChangeCity(boolean paramBoolean)
  {
    if (this.mIsInCityAnimation) {
      foreChangeCityEnd();
    }
    if (this.mCityViewList.size() < 2) {
      return;
    }
    this.mIsInCityAnimation = true;
    this.mChangeCityAnimationStartTime = -1L;
    this.mToNextCity = paramBoolean;
    initBgs();
    invalidate();
  }
  
  private void startShowForecast()
  {
    if ((this.mIsInCityAnimation) || (this.mCityViewList.size() < 1)) {
      return;
    }
    ((CityView)this.mCityViewList.get(this.mCur)).startForecast();
  }
  
  private void startWeatherActivity()
  {
    Object localObject = "";
    if (this.mDataHandler.i() > 0) {
      localObject = this.mDataHandler.k();
    }
    for (int i = this.mDataHandler.l();; i = -1)
    {
      localObject = p.a(getContext(), (String)localObject, true, 18, "", -1);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("gowidget_Id", this.mWidgetID);
      ((Intent)localObject).putExtra("isMyLocation", i);
      getContext().startActivity((Intent)localObject);
      return;
    }
  }
  
  public void cleanup()
  {
    this.mIsLive = false;
    super.cleanup();
  }
  
  public void closeFullScreenAnimation(int paramInt)
  {
    if ((this.mCityViewList != null) && (this.mCityViewList.size() > 0))
    {
      CityView localCityView = (CityView)this.mCityViewList.get(this.mCur);
      if (localCityView != null) {
        localCityView.forceClosePreviewAnimation();
      }
    }
  }
  
  protected void dispatchDraw(GLCanvas paramGLCanvas)
  {
    if (this.mChangeCityAnimationStartTime == -1L) {
      this.mChangeCityAnimationStartTime = getDrawingTime();
    }
    float f = Math.max(0.0F, Math.min((float)(getDrawingTime() - this.mChangeCityAnimationStartTime) / 500.0F, 1.0F));
    if (this.mIsInCityAnimation) {
      onChangeCity(f);
    }
    int i = paramGLCanvas.save();
    paramGLCanvas.clipRect(sClickRect);
    drawBg(paramGLCanvas);
    this.mFloor.draw(paramGLCanvas);
    paramGLCanvas.restoreToCount(i);
    if ((!this.mIsLive) || (this.mCityViewList.size() < 1))
    {
      this.mNA.draw(paramGLCanvas);
      return;
    }
    i = paramGLCanvas.save();
    paramGLCanvas.translate(this.mOffX, 0.0F);
    if (this.mCur == -1) {
      this.mCur = 0;
    }
    ((CityView)this.mCityViewList.get(this.mCur)).setOffSet(this.mOffX);
    ((CityView)this.mCityViewList.get(this.mCur)).draw(paramGLCanvas);
    paramGLCanvas.restoreToCount(i);
    i = paramGLCanvas.save();
    CityView localCityView;
    if (this.mIsInCityAnimation)
    {
      if (this.mToNextCity)
      {
        paramGLCanvas.translate(this.mOffX + this.mWidth * 3, 0.0F);
        localCityView = (CityView)this.mCityViewList.get(getNextCityIndex());
        localCityView.setOffSet(this.mOffX + this.mWidth * 3);
        localCityView.draw(paramGLCanvas);
      }
    }
    else
    {
      paramGLCanvas.restoreToCount(i);
      i = paramGLCanvas.getAlpha();
      if (this.mCityCount > 1)
      {
        paramGLCanvas.setAlpha((int)(i * this.mLeftAlpha));
        this.mLeftDrawable.draw(paramGLCanvas);
        paramGLCanvas.setAlpha((int)(i * this.mRightAlpha));
        this.mRightDrawable.draw(paramGLCanvas);
      }
      paramGLCanvas.setAlpha((int)(i * this.mBottomAlpha));
      if (!isShowForecast()) {
        break label408;
      }
      this.mUpDrawable.draw(paramGLCanvas);
    }
    for (;;)
    {
      paramGLCanvas.setAlpha(i);
      return;
      paramGLCanvas.translate(this.mOffX - this.mWidth * 3, 0.0F);
      localCityView = (CityView)this.mCityViewList.get(getPreCItyIndex());
      localCityView.setOffSet(this.mOffX - this.mWidth * 3);
      localCityView.draw(paramGLCanvas);
      break;
      label408:
      this.mDownDrawable.draw(paramGLCanvas);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      super.dispatchTouchEvent(paramMotionEvent);
      return true;
      this.mDownX = f1;
      this.mDownY = f2;
      checkFoucus((int)this.mDownX, (int)this.mDownY);
      this.mHasMove = false;
      continue;
      if (Math.abs(this.mDownY - f2) > this.mStartForeD) {
        if (this.mCur != 0) {
          break label143;
        }
      }
      label143:
      for (this.mDownY = f2;; this.mDownY = f2)
      {
        this.mHasMove = true;
        if (Math.abs(this.mDownX - f1) <= this.mStartForeD) {
          break;
        }
        this.mHasMove = true;
        break;
      }
      clearFoucus();
      if ((this.mLeftRect.contains((int)f1, (int)f2)) && (this.mLeftRect.contains((int)this.mDownX, (int)this.mDownY)) && (!this.mHasMove))
      {
        startChangeCity(false);
        return false;
      }
      if ((this.mRightRect.contains((int)f1, (int)f2)) && (this.mRightRect.contains((int)this.mDownX, (int)this.mDownY)) && (!this.mHasMove))
      {
        startChangeCity(true);
        return false;
      }
      if ((this.mUpRect.contains((int)f1, (int)f2)) && (this.mUpRect.contains((int)this.mDownX, (int)this.mDownY)) && (!this.mHasMove))
      {
        startShowForecast();
        return false;
        clearFoucus();
      }
    }
  }
  
  public void endRefresh() {}
  
  public void fullScreenFloatAnimation(GLCanvas paramGLCanvas)
  {
    if ((this.mCityViewList != null) && (this.mCityViewList.size() > 0))
    {
      CityView localCityView = (CityView)this.mCityViewList.get(this.mCur);
      if (localCityView != null) {
        localCityView.drawFlyingFrame(paramGLCanvas);
      }
    }
  }
  
  public GLView getContentView()
  {
    return this;
  }
  
  public float getInterpor(float paramFloat)
  {
    paramFloat = getYfX((this.mXmax - this.mXmin) * paramFloat + this.mXmin);
    float f1 = getYfX(this.mXmax);
    float f2 = getYfX(this.mXmin);
    return (paramFloat - f2) / (f1 - f2);
  }
  
  public float getPanelVersion()
  {
    return 2.0F;
  }
  
  public int getVersion()
  {
    return 0;
  }
  
  public boolean onActivate(boolean paramBoolean, Bundle paramBundle)
  {
    return false;
  }
  
  public boolean onApplyTheme(Bundle paramBundle)
  {
    return false;
  }
  
  public void onAutoLocateFail(String paramString)
  {
    int i = 0;
    while (i < this.mCityViewList.size())
    {
      ((CityView)this.mCityViewList.get(i)).showWeatherDesp();
      ((CityView)this.mCityViewList.get(i)).invalidate();
      i += 1;
    }
  }
  
  public void onClearMemory() {}
  
  public void onDateStyleChange(int paramInt) {}
  
  public boolean onDeactivate(boolean paramBoolean, Bundle paramBundle)
  {
    return false;
  }
  
  public void onDelete()
  {
    this.mDataHandler.a(this.mWidgetID);
  }
  
  public void onEnter() {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onLeave() {}
  
  public void onLoadFinish()
  {
    this.mCityCount = this.mDataHandler.i();
    if (this.mCityViewList != null) {}
    CityView localCityView;
    for (int i = this.mCityViewList.size(); i < this.mCityCount; i = 0) {
      while (i < this.mCityCount)
      {
        localCityView = new CityView(this.mContext);
        addView(localCityView, new GLRelativeLayout.LayoutParams(-1, -1));
        this.mCityViewList.add(localCityView);
        i += 1;
      }
    }
    if (i > this.mCityCount)
    {
      i -= 1;
      while (i >= this.mCityCount)
      {
        removeView((CityView)this.mCityViewList.remove(i));
        i -= 1;
      }
    }
    this.mCur = this.mDataHandler.j();
    if (this.mCur == -1) {
      this.mCur = 0;
    }
    i = 0;
    while (i < this.mCityCount)
    {
      int j = this.mDataHandler.b(i).k.d();
      ((CityView)this.mCityViewList.get(i)).setDateHandler(this.mDataHandler, i, j);
      i += 1;
    }
    if (this.mCityCount < 1)
    {
      localCityView = new CityView(this.mContext);
      addView(localCityView, new GLRelativeLayout.LayoutParams(-1, -1));
      this.mCityViewList.add(localCityView);
      ((CityView)this.mCityViewList.get(0)).setDateHandler(this.mDataHandler, 0, 6);
      this.mCur = 0;
    }
    if ((this.mCityViewList != null) && (this.mCityViewList.size() > 0))
    {
      localCityView = (CityView)this.mCityViewList.get(this.mCur);
      if (localCityView != null) {
        localCityView.initWall();
      }
    }
    initBgs();
    this.mCur = Math.min(this.mCur, this.mCityViewList.size());
  }
  
  public boolean onLongClick(GLView paramGLView)
  {
    performLongClick();
    return false;
  }
  
  public void onRemove()
  {
    this.mDataHandler.e();
    e.a().b();
  }
  
  public void onScreenChange(String paramString) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = this.mLeftDrawable.getIntrinsicWidth();
    paramInt4 = this.mLeftDrawable.getIntrinsicHeight();
    paramInt3 = (paramInt2 - paramInt4) / 2;
    paramInt4 += paramInt3;
    this.mLeftDrawable.setBounds(0, paramInt3, i, paramInt4);
    this.mLeftRect.set(0, paramInt3, i * 2, paramInt4);
    i = this.mRightDrawable.getIntrinsicWidth();
    this.mRightDrawable.getIntrinsicHeight();
    int j = paramInt1 - i;
    this.mRightDrawable.setBounds(j, paramInt3, paramInt1, paramInt4);
    this.mRightRect.set(j - i, paramInt3, paramInt1, paramInt4);
    paramInt3 = this.mUpDrawable.getIntrinsicWidth();
    paramInt4 = this.mUpDrawable.getIntrinsicHeight();
    i = (paramInt1 - paramInt3) / 2;
    j = i + paramInt3;
    int k = paramInt2 - paramInt4 - 20;
    int m = paramInt2 - 20;
    this.mUpDrawable.setBounds(i, k, j, m);
    this.mUpRect.set(i - paramInt3, k - paramInt4, paramInt3 + j, m);
    this.mDownDrawable.setBounds(i, k, j, m);
    initBg(paramInt1, paramInt2);
    sClickRect.set(0, 0, paramInt1, paramInt2);
    paramInt3 = this.mNA.getIntrinsicWidth();
    paramInt4 = this.mNA.getIntrinsicHeight();
    paramInt1 = (paramInt1 - paramInt3) / 2;
    paramInt2 = (paramInt2 - paramInt4) / 2;
    this.mNA.setBounds(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
  }
  
  public void onStart(Bundle paramBundle)
  {
    this.mWidgetID = paramBundle.getInt("gowidget_Id");
    if (this.mDataHandler == null)
    {
      this.mDataHandler = new com.gtp.nextlauncher.widget.weatherwidget.e(this.mContext, this.mWidgetID, this, true);
      this.mDataHandler.a(this);
    }
    this.mIsLive = true;
  }
  
  public void onStop() {}
  
  public void onTemperatureUnitChange(int paramInt)
  {
    Iterator localIterator = this.mCityViewList.iterator();
    while (localIterator.hasNext())
    {
      CityView localCityView = (CityView)localIterator.next();
      if (localCityView != null) {
        localCityView.updateTemp();
      }
    }
  }
  
  public void onTimeChange(int paramInt1, int paramInt2)
  {
    if ((this.mCityViewList != null) && (this.mCityViewList.size() > 0))
    {
      CityView localCityView = (CityView)this.mCityViewList.get(this.mCur);
      if (localCityView != null) {
        localCityView.onTimeChange();
      }
    }
    initBgs();
  }
  
  public void setDrawingCacheEnabled(boolean paramBoolean)
  {
    super.setDrawingCacheEnabled(paramBoolean);
  }
  
  public void setWidgetCallback(WidgetCallback paramWidgetCallback) {}
  
  public void startFullScreenAnimation(int paramInt, Bundle paramBundle) {}
  
  public void startFullScreenAnimation(int paramInt, Bundle paramBundle, FullScreenNextWidgetCallback paramFullScreenNextWidgetCallback)
  {
    float f = 0.0F;
    this.mFullScreenNextWidgetCallback = paramFullScreenNextWidgetCallback;
    if (paramBundle != null)
    {
      f = paramBundle.getFloat("scene_angle");
      this.mCorner = paramBundle.getFloatArray("upper_left_corner");
    }
    if ((this.mCityViewList != null) && (this.mCityViewList.size() > 0))
    {
      paramBundle = (CityView)this.mCityViewList.get(this.mCur);
      if (paramBundle != null)
      {
        if (paramInt != 0) {
          break label100;
        }
        paramBundle.startRiseAnimation(f, this.mCorner, paramFullScreenNextWidgetCallback);
        if (this.mFullScreenNextWidgetCallback != null) {
          this.mFullScreenNextWidgetCallback.onFullAnimationStart();
        }
      }
    }
    label100:
    while (paramInt != 1) {
      return;
    }
    paramBundle.startWeatherAnimation();
  }
  
  public void startRefresh() {}
  
  public void switchToModel(int paramInt)
  {
    if (paramInt == 0) {
      if ((this.mCityViewList != null) && (this.mCityViewList.size() > 0))
      {
        localCityView = (CityView)this.mCityViewList.get(this.mCur);
        if (localCityView != null)
        {
          localCityView.forceClosePreviewAnimation();
          localCityView.onEnterPreview();
        }
      }
    }
    while (1 != paramInt)
    {
      CityView localCityView;
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/PanelMain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
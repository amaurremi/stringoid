package com.venticake.retrica.view.album;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.opengl.GLUtils;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.venticake.retrica.view.RetricaGLSurfaceView;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11Ext;

public final class RenderView
  extends RetricaGLSurfaceView
  implements SensorEventListener, GLSurfaceView.Renderer
{
  private static final int EVENT_FOCUS = 3;
  private static final int EVENT_KEY = 2;
  private static final int EVENT_NONE = 0;
  private static final int EVENT_TOUCH = 1;
  private static final int MAX_LOADING_COUNT = 8;
  private static final int NUM_TEXTURE_LOAD_THREADS = 4;
  private static final String TAG = "RenderView";
  private static RenderView.TextureLoadThread sCachedTextureLoadThread;
  private static final RenderView.Lists sLists = new RenderView.Lists();
  private static final Deque<Texture> sLoadInputQueue = new Deque();
  private static final Deque<Texture> sLoadInputQueueCached = new Deque();
  private static final Deque<Texture> sLoadInputQueueVideo = new Deque();
  private static final Deque<Texture> sLoadOutputQueue = new Deque();
  private static final RenderView.TextureLoadThread[] sTextureLoadThreads = new RenderView.TextureLoadThread[4];
  private static RenderView.TextureLoadThread sVideoTextureLoadThread;
  static final int[] textureId = new int[1];
  private final DirectLinkedList<RenderView.TextureReference> mActiveTextureList = new DirectLinkedList();
  private float mAlpha;
  private Texture mBoundTexture;
  private int mCurrentEventType = 0;
  private KeyEvent mCurrentKeyEvent = null;
  private boolean mCurrentKeyEventResult = false;
  private boolean mFirstDraw;
  private float mFrameInterval = 0.0F;
  private long mFrameTime = 0L;
  private GL11 mGL = null;
  private boolean mListsDirty = false;
  private int mLoadingCount = 0;
  private long mLoadingExpensiveTexturesStartTime = 0L;
  private volatile boolean mPendingSensorEvent = false;
  private RootLayer mRootLayer = null;
  private SensorManager mSensorManager;
  private final Deque<MotionEvent> mTouchEventQueue = new Deque();
  private Layer mTouchEventTarget = null;
  private final ReferenceQueue mUnreferencedTextureQueue = new ReferenceQueue();
  private int mViewHeight = 0;
  private int mViewWidth = 0;
  private final SparseArray<ResourceTexture> sCacheScaled = new SparseArray();
  private final SparseArray<ResourceTexture> sCacheUnscaled = new SparseArray();
  
  static
  {
    sCachedTextureLoadThread = null;
    sVideoTextureLoadThread = null;
  }
  
  public RenderView(Context paramContext)
  {
    super(paramContext);
    setBackgroundDrawable(null);
    setFocusable(true);
    setEGLConfigChooser(true);
    setRenderer(this);
    this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    int i;
    if (sCachedTextureLoadThread == null) {
      i = 0;
    }
    for (;;)
    {
      if (i == 4) {
        return;
      }
      paramContext = new RenderView.TextureLoadThread(this);
      if (i == 0) {
        sCachedTextureLoadThread = paramContext;
      }
      if (i == 1) {
        sVideoTextureLoadThread = paramContext;
      }
      sTextureLoadThreads[i] = paramContext;
      paramContext.start();
      i += 1;
    }
  }
  
  private void clearTextureArray(SparseArray<ResourceTexture> paramSparseArray)
  {
    paramSparseArray.clear();
  }
  
  private ResourceTexture getResourceInternal(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (SparseArray localSparseArray = this.sCacheScaled;; localSparseArray = this.sCacheUnscaled)
    {
      ResourceTexture localResourceTexture2 = (ResourceTexture)localSparseArray.get(paramInt);
      ResourceTexture localResourceTexture1 = localResourceTexture2;
      if (localResourceTexture2 == null)
      {
        localResourceTexture1 = localResourceTexture2;
        if (paramInt != 0)
        {
          localResourceTexture1 = new ResourceTexture(paramInt, paramBoolean);
          localSparseArray.put(paramInt, localResourceTexture1);
        }
      }
      return localResourceTexture1;
    }
  }
  
  private Layer hitTest(float paramFloat1, float paramFloat2)
  {
    ArrayList localArrayList = sLists.hitTestList;
    int i = localArrayList.size() - 1;
    for (;;)
    {
      Object localObject;
      if (i < 0) {
        localObject = null;
      }
      Layer localLayer;
      do
      {
        return (Layer)localObject;
        localLayer = (Layer)localArrayList.get(i);
        if ((localLayer == null) || (localLayer.mHidden)) {
          break;
        }
        float f1 = localLayer.mX;
        float f2 = localLayer.mY;
        if ((paramFloat1 < f1) || (paramFloat2 < f2) || (paramFloat1 >= f1 + localLayer.mWidth) || (paramFloat2 >= localLayer.mHeight + f2)) {
          break;
        }
        localObject = localLayer;
      } while (localLayer.containsPoint(paramFloat1, paramFloat2));
      i -= 1;
    }
  }
  
  private void loadTextureAsync(Texture paramTexture)
  {
    try
    {
      Bitmap localBitmap = paramTexture.load(this);
      Object localObject = localBitmap;
      if (localBitmap != null)
      {
        localBitmap = Utils.resizeBitmap(localBitmap, 1024);
        int i = localBitmap.getWidth();
        int j = localBitmap.getHeight();
        paramTexture.mWidth = i;
        paramTexture.mHeight = j;
        if ((Shared.isPowerOf2(i)) && (Shared.isPowerOf2(j))) {
          break label169;
        }
        int k = Shared.nextPowerOf2(i);
        int m = Shared.nextPowerOf2(j);
        Bitmap.Config localConfig = localBitmap.getConfig();
        localObject = localConfig;
        if (localConfig == null) {
          localObject = Bitmap.Config.RGB_565;
        }
        if (i * j >= 262144) {
          localObject = Bitmap.Config.RGB_565;
        }
        localObject = Bitmap.createBitmap(k, m, (Bitmap.Config)localObject);
        new Canvas((Bitmap)localObject).drawBitmap(localBitmap, 0.0F, 0.0F, null);
        localBitmap.recycle();
        paramTexture.mNormalizedWidth = (i / k);
        paramTexture.mNormalizedHeight = (j / m);
      }
      for (;;)
      {
        paramTexture.mBitmap = ((Bitmap)localObject);
        return;
        label169:
        paramTexture.mNormalizedWidth = 1.0F;
        paramTexture.mNormalizedHeight = 1.0F;
        localObject = localBitmap;
      }
      return;
    }
    catch (Exception localException)
    {
      paramTexture.mBitmap = null;
      return;
    }
    catch (OutOfMemoryError paramTexture)
    {
      Log.i("RenderView", "Bitmap power of 2 creation fail, outofmemory");
      handleLowMemory();
    }
  }
  
  private void processCurrentEvent()
  {
    switch (this.mCurrentEventType)
    {
    }
    for (;;)
    {
      try
      {
        this.mCurrentEventType = 0;
        notify();
        return;
      }
      finally {}
      processKeyEvent();
      continue;
      processFocusEvent();
    }
  }
  
  private void processFocusEvent() {}
  
  private void processKeyEvent()
  {
    KeyEvent localKeyEvent = this.mCurrentKeyEvent;
    boolean bool = false;
    this.mCurrentKeyEvent = null;
    if (this.mRootLayer != null) {
      if (localKeyEvent.getAction() != 0) {
        break label45;
      }
    }
    label45:
    for (bool = this.mRootLayer.onKeyDown(localKeyEvent.getKeyCode(), localKeyEvent);; bool = this.mRootLayer.onKeyUp(localKeyEvent.getKeyCode(), localKeyEvent))
    {
      this.mCurrentKeyEventResult = bool;
      return;
    }
  }
  
  private void processTextures(boolean paramBoolean)
  {
    ??? = this.mGL;
    for (;;)
    {
      Object localObject2 = (RenderView.TextureReference)this.mUnreferencedTextureQueue.poll();
      if (localObject2 == null) {}
      synchronized (sLoadOutputQueue)
      {
        do
        {
          localObject2 = (Texture)((Deque)???).pollFirst();
          if (localObject2 == null) {
            break;
          }
          uploadTexture((Texture)localObject2, textureId);
          this.mLoadingCount -= 1;
        } while (paramBoolean);
        return;
        textureId[0] = ((RenderView.TextureReference)localObject2).textureId;
        if (((RenderView.TextureReference)localObject2).gl == ???) {
          ((GL11)???).glDeleteTextures(1, textureId, 0);
        }
        this.mActiveTextureList.remove(((RenderView.TextureReference)localObject2).activeListEntry);
      }
    }
  }
  
  private void processTouchEvent()
  {
    int k = this.mTouchEventQueue.size();
    int i = 0;
    synchronized (this.mTouchEventQueue)
    {
      MotionEvent localMotionEvent1 = (MotionEvent)this.mTouchEventQueue.pollFirst();
      if (localMotionEvent1 == null) {
        return;
      }
    }
    int j = localMotionEvent2.getAction();
    if (j == 0)
    {
      ??? = hitTest(localMotionEvent2.getX(), localMotionEvent2.getY());
      this.mTouchEventTarget = ((Layer)???);
    }
    for (;;)
    {
      if (??? != null) {
        ((Layer)???).onTouchEvent(localMotionEvent2);
      }
      if ((j == 1) || (j == 3)) {
        this.mTouchEventTarget = null;
      }
      localMotionEvent2.recycle();
      j = i + 1;
      if (localMotionEvent2 != null)
      {
        i = j;
        if (j < k) {
          break;
        }
      }
      try
      {
        notify();
        return;
      }
      finally {}
      Layer localLayer = this.mTouchEventTarget;
    }
  }
  
  private void queueLoad(Texture paramTexture, boolean paramBoolean)
  {
    if (!paramTexture.shouldQueue()) {
      return;
    }
    paramTexture.mState = 2;
    if (paramTexture.isUncachedVideo())
    {
      localDeque = sLoadInputQueueVideo;
      if (!paramBoolean) {
        break label73;
      }
    }
    for (;;)
    {
      label73:
      try
      {
        localDeque.addFirst(paramTexture);
        localDeque.notify();
        this.mLoadingCount += 1;
        return;
      }
      finally {}
      if (paramTexture.isCached())
      {
        localDeque = sLoadInputQueueCached;
        break;
      }
      localDeque = sLoadInputQueue;
      break;
      localDeque.addLast(paramTexture);
    }
  }
  
  private void updateLists()
  {
    if (this.mRootLayer != null) {
      synchronized (sLists)
      {
        sLists.clear();
        this.mRootLayer.generate(this, sLists);
        return;
      }
    }
  }
  
  private void uploadTexture(Texture paramTexture, int[] paramArrayOfInt)
  {
    Bitmap localBitmap = paramTexture.mBitmap;
    GL11 localGL11 = this.mGL;
    if (localBitmap != null)
    {
      int i = paramTexture.mWidth;
      int j = paramTexture.mHeight;
      int[] arrayOfInt = new int[4];
      arrayOfInt[1] = j;
      arrayOfInt[2] = i;
      arrayOfInt[3] = (-j);
      localGL11.glGenTextures(1, paramArrayOfInt, 0);
      localGL11.glBindTexture(3553, paramArrayOfInt[0]);
      localGL11.glTexParameteriv(3553, 35741, arrayOfInt, 0);
      localGL11.glTexParameteri(3553, 10242, 33071);
      localGL11.glTexParameteri(3553, 10243, 33071);
      localGL11.glTexParameterf(3553, 10241, 9729.0F);
      localGL11.glTexParameterf(3553, 10240, 9729.0F);
      GLUtils.texImage2D(3553, 0, localBitmap, 0);
      i = localGL11.glGetError();
      localBitmap.recycle();
      if (i == 1285) {
        handleLowMemory();
      }
      if (i != 0)
      {
        Log.i("RenderView", "Texture creation fail, glError " + i);
        paramTexture.mId = 0;
        paramTexture.mBitmap = null;
        paramTexture.mState = 0;
        return;
      }
      paramTexture.mBitmap = null;
      paramTexture.mId = paramArrayOfInt[0];
      paramTexture.mState = 3;
      paramTexture = new RenderView.TextureReference(paramTexture, localGL11, this.mUnreferencedTextureQueue, paramArrayOfInt[0]);
      this.mActiveTextureList.add(paramTexture.activeListEntry);
      requestRender();
      return;
    }
    paramTexture.mState = 4;
  }
  
  public boolean bind(Texture paramTexture)
  {
    if (paramTexture != null) {
      if (paramTexture == this.mBoundTexture) {
        return true;
      }
    }
    switch (paramTexture.mState)
    {
    case 1: 
    case 2: 
    default: 
    case 0: 
      for (;;)
      {
        return false;
        if (paramTexture.getClass().equals(ResourceTexture.class))
        {
          loadTexture(paramTexture);
          return false;
        }
        if (this.mLoadingCount < 8) {
          queueLoad(paramTexture, false);
        }
      }
    }
    this.mGL.glBindTexture(3553, paramTexture.mId);
    this.mBoundTexture = paramTexture;
    return true;
  }
  
  public boolean bindMixed(Texture paramTexture1, Texture paramTexture2, float paramFloat)
  {
    GL11 localGL11 = this.mGL;
    boolean bool = bind(paramTexture1);
    localGL11.glActiveTexture(33985);
    this.mBoundTexture = null;
    if (!(bool & true & bind(paramTexture2))) {
      return false;
    }
    localGL11.glEnable(3553);
    localGL11.glTexEnvf(8960, 8704, 34160.0F);
    localGL11.glTexEnvf(8960, 34161, 34165.0F);
    localGL11.glTexEnvf(8960, 34162, 34165.0F);
    localGL11.glTexEnvfv(8960, 8705, new float[] { 1.0F, 1.0F, 1.0F, paramFloat }, 0);
    localGL11.glTexEnvf(8960, 34178, 34166.0F);
    localGL11.glTexEnvf(8960, 34194, 770.0F);
    localGL11.glTexEnvf(8960, 34186, 34166.0F);
    localGL11.glTexEnvf(8960, 34202, 770.0F);
    return true;
  }
  
  public void clearCache()
  {
    clearTextureArray(this.sCacheScaled);
    clearTextureArray(this.sCacheUnscaled);
  }
  
  public void draw2D(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    ((GL11Ext)this.mGL).glDrawTexfOES(paramFloat1, this.mViewHeight - paramFloat2 - paramFloat5, paramFloat3, paramFloat4, paramFloat5);
  }
  
  public void draw2D(Texture paramTexture, float paramFloat1, float paramFloat2)
  {
    if (bind(paramTexture))
    {
      float f1 = paramTexture.getWidth();
      float f2 = paramTexture.getHeight();
      ((GL11Ext)this.mGL).glDrawTexfOES(paramFloat1, this.mViewHeight - paramFloat2 - f2, 0.0F, f1, f2);
    }
  }
  
  public void draw2D(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (bind(paramTexture)) {
      ((GL11Ext)this.mGL).glDrawTexfOES(paramFloat1, this.mViewHeight - paramFloat2 - paramFloat4, 0.0F, paramFloat3, paramFloat4);
    }
  }
  
  public void draw2D(Texture paramTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (bind(paramTexture)) {
      ((GL11Ext)this.mGL).glDrawTexiOES(paramInt1, this.mViewHeight - paramInt2 - paramInt4, 0, paramInt3, paramInt4);
    }
  }
  
  public void drawMixed2D(Texture paramTexture1, Texture paramTexture2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    GL11 localGL11 = this.mGL;
    if (bind(paramTexture1))
    {
      localGL11.glActiveTexture(33985);
      this.mBoundTexture = null;
      if (bind(paramTexture2))
      {
        localGL11.glEnable(3553);
        localGL11.glTexEnvf(8960, 8704, 34160.0F);
        localGL11.glTexEnvf(8960, 34161, 34165.0F);
        localGL11.glTexEnvf(8960, 34162, 34165.0F);
        localGL11.glTexEnvfv(8960, 8705, new float[] { 1.0F, 1.0F, 1.0F, paramFloat1 }, 0);
        localGL11.glTexEnvf(8960, 34178, 34166.0F);
        localGL11.glTexEnvf(8960, 34194, 770.0F);
        localGL11.glTexEnvf(8960, 34186, 34166.0F);
        localGL11.glTexEnvf(8960, 34202, 770.0F);
        ((GL11Ext)localGL11).glDrawTexfOES(paramFloat2, this.mViewHeight - paramFloat3 - paramFloat6, paramFloat4, paramFloat5, paramFloat6);
        localGL11.glDisable(3553);
      }
      localGL11.glActiveTexture(33984);
      this.mBoundTexture = null;
    }
  }
  
  public long elapsedLoadingExpensiveTextures()
  {
    long l = this.mLoadingExpensiveTexturesStartTime;
    if (l != 0L) {
      return SystemClock.uptimeMillis() - l;
    }
    return -1L;
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public float getFrameInterval()
  {
    return this.mFrameInterval;
  }
  
  public long getFrameTime()
  {
    return this.mFrameTime;
  }
  
  public RenderView.Lists getLists()
  {
    return sLists;
  }
  
  public ResourceTexture getResource(int paramInt)
  {
    return getResourceInternal(paramInt, true);
  }
  
  public ResourceTexture getResource(int paramInt, boolean paramBoolean)
  {
    return getResourceInternal(paramInt, paramBoolean);
  }
  
  public void handleLowMemory()
  {
    Log.i("RenderView", "Handling low memory condition");
    if (this.mRootLayer != null) {
      this.mRootLayer.handleLowMemory();
    }
  }
  
  public boolean isLoadingExpensiveTextures()
  {
    return this.mLoadingExpensiveTexturesStartTime != 0L;
  }
  
  public void loadTexture(Texture paramTexture)
  {
    if (paramTexture != null) {}
    switch (paramTexture.mState)
    {
    default: 
      return;
    }
    int[] arrayOfInt = new int[1];
    paramTexture.mState = 2;
    loadTextureAsync(paramTexture);
    uploadTexture(paramTexture, arrayOfInt);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onDrawFrame(GL10 arg1)
  {
    boolean bool3 = true;
    GL11 localGL11 = (GL11)???;
    if (!this.mFirstDraw) {
      Log.i("RenderView", "First Draw");
    }
    this.mFirstDraw = true;
    if (this.mListsDirty) {
      updateLists();
    }
    boolean bool4 = isLoadingExpensiveTextures();
    int j = sTextureLoadThreads.length;
    int i = 2;
    boolean bool2;
    label62:
    long l;
    if (i >= j)
    {
      bool2 = false;
      if (bool2 != bool4)
      {
        if (!bool2) {
          break label297;
        }
        l = SystemClock.uptimeMillis();
        label79:
        this.mLoadingExpensiveTexturesStartTime = l;
      }
      processTextures(false);
      l = SystemClock.uptimeMillis();
      this.mFrameInterval = (0.001F * (float)Math.min(50L, l - this.mFrameTime));
      this.mFrameTime = l;
      processCurrentEvent();
      processTouchEvent();
    }
    for (;;)
    {
      synchronized (sLists)
      {
        ArrayList localArrayList = ???.updateList;
        int k = localArrayList.size();
        i = 0;
        j = 0;
        if (i == k)
        {
          if (j != 0) {
            requestRender();
          }
          localGL11.glClear(256);
          localGL11.glEnable(3089);
          localGL11.glScissor(0, 0, getWidth(), getHeight());
          localGL11.glDisable(3042);
          localArrayList = ???.opaqueList;
          i = localArrayList.size() - 1;
          if (i >= 0) {
            continue;
          }
          localGL11.glEnable(3042);
          localArrayList = ???.blendedList;
          j = localArrayList.size();
          i = 0;
          if (i != j) {
            continue;
          }
          localGL11.glDisable(3042);
          return;
          bool2 = bool3;
          if (sTextureLoadThreads[i].mIsLoading) {
            break label62;
          }
          i += 1;
          break;
          label297:
          l = 0L;
          break label79;
        }
        boolean bool1;
        j |= ((Layer)localArrayList.get(i)).update(this, this.mFrameInterval);
        i += 1;
        continue;
        Layer localLayer = (Layer)localArrayList.get(i);
        if (!localLayer.mHidden)
        {
          localLayer.renderOpaque(this, localGL11);
          break label397;
          localLayer = (Layer)localArrayList.get(i);
          if (localLayer.mHidden) {
            break label404;
          }
          localLayer.renderBlended(this, localGL11);
        }
      }
      label397:
      i -= 1;
      continue;
      label404:
      i += 1;
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    requestRender();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mGL == null) {
      return false;
    }
    for (;;)
    {
      try {}catch (InterruptedException localInterruptedException)
      {
        long l;
        continue;
        boolean bool = true;
        continue;
      }
      try
      {
        this.mCurrentKeyEvent = paramKeyEvent;
        this.mCurrentEventType = 2;
        requestRender();
        l = SystemClock.uptimeMillis();
        wait(50L);
        if ((this.mCurrentEventType != 0) && (SystemClock.uptimeMillis() < l + 50L)) {
          continue;
        }
        if (!this.mCurrentKeyEventResult)
        {
          bool = super.onKeyDown(paramInt, paramKeyEvent);
          requestRender();
          return bool;
        }
      }
      finally {}
    }
  }
  
  public void onPause()
  {
    super.onPause();
    Log.i("RenderView", "OnPause RenderView " + this);
    this.mSensorManager.unregisterListener(this);
  }
  
  public void onResume()
  {
    super.onResume();
    Sensor localSensor1 = this.mSensorManager.getDefaultSensor(1);
    Sensor localSensor2 = this.mSensorManager.getDefaultSensor(1);
    if (localSensor1 != null) {
      this.mSensorManager.registerListener(this, localSensor1, 2);
    }
    if (localSensor2 != null) {
      this.mSensorManager.registerListener(this, localSensor2, 2);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i = paramSensorEvent.sensor.getType();
    if (((!this.mPendingSensorEvent) && (i == 1)) || (i == 3))
    {
      if (this.mRootLayer != null) {
        this.mRootLayer.onSensorChanged(this, paramSensorEvent);
      }
      if (i == 3) {
        requestRender();
      }
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    paramGL10 = (GL11)paramGL10;
    this.mFirstDraw = false;
    this.mViewWidth = paramInt1;
    this.mViewHeight = paramInt2;
    if (this.mRootLayer != null) {
      this.mRootLayer.setSize(paramInt1, paramInt2);
    }
    paramGL10.glViewport(0, 0, paramInt1, paramInt2);
    paramGL10.glMatrixMode(5889);
    paramGL10.glLoadIdentity();
    GLU.gluPerspective(paramGL10, 45.0F, paramInt1 / paramInt2, 0.1F, 100.0F);
    if (this.mRootLayer != null) {
      this.mRootLayer.onSurfaceChanged(this, paramInt1, paramInt2);
    }
    paramGL10.glMatrixMode(5888);
  }
  
  public void onSurfaceCreated(GL10 arg1, EGLConfig paramEGLConfig)
  {
    clearCache();
    paramEGLConfig = (GL11)???;
    if (this.mGL == null) {
      this.mGL = paramEGLConfig;
    }
    for (;;)
    {
      setRenderMode(0);
      Process.setThreadPriority(-4);
      paramEGLConfig.glEnable(3024);
      paramEGLConfig.glDisable(2896);
      paramEGLConfig.glEnable(3553);
      paramEGLConfig.glTexEnvf(8960, 8704, 7681.0F);
      paramEGLConfig.glEnableClientState(32884);
      paramEGLConfig.glEnableClientState(32888);
      paramEGLConfig.glClientActiveTexture(33985);
      paramEGLConfig.glEnableClientState(32888);
      paramEGLConfig.glClientActiveTexture(33984);
      paramEGLConfig.glEnable(2929);
      paramEGLConfig.glDepthFunc(515);
      paramEGLConfig.glBlendFunc(1, 771);
      paramEGLConfig.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      paramEGLConfig.glClear(16384);
      if (!this.mActiveTextureList.isEmpty())
      {
        ??? = this.mActiveTextureList.getHead();
        label183:
        if (??? != null) {}
      }
      else
      {
        this.mActiveTextureList.clear();
        if (this.mRootLayer != null) {
          this.mRootLayer.onSurfaceCreated(this, paramEGLConfig);
        }
      }
      synchronized (sLists)
      {
        Object localObject = sLists.systemList;
        int i = ((ArrayList)localObject).size() - 1;
        if (i < 0)
        {
          return;
          Log.i("RenderView", "GLObject has changed from " + this.mGL + " to " + paramEGLConfig);
          this.mGL = paramEGLConfig;
          continue;
          localObject = (Texture)((RenderView.TextureReference)???.value).get();
          if (localObject != null) {
            ((Texture)localObject).mState = 0;
          }
          ??? = ???.next;
          break label183;
        }
        ((Layer)((ArrayList)localObject).get(i)).onSurfaceCreated(this, paramEGLConfig);
        i -= 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (this.mGL == null) {
      bool = false;
    }
    while ((this.mTouchEventQueue.size() > 8) && (paramMotionEvent.getAction() == 2)) {
      return bool;
    }
    synchronized (this.mTouchEventQueue)
    {
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      this.mTouchEventQueue.addLast(paramMotionEvent);
      requestRender();
      return true;
    }
  }
  
  public void prime(Texture paramTexture, boolean paramBoolean)
  {
    if ((paramTexture != null) && (paramTexture.mState == 0) && ((paramBoolean) || (this.mLoadingCount < 8))) {
      queueLoad(paramTexture, paramBoolean);
    }
  }
  
  public void processAllTextures()
  {
    processTextures(true);
  }
  
  public void resetColor()
  {
    GL11 localGL11 = this.mGL;
    localGL11.glTexEnvf(8960, 8704, 7681.0F);
    localGL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
  }
  
  public void setAlpha(float paramFloat)
  {
    GL11 localGL11 = this.mGL;
    localGL11.glTexEnvf(8960, 8704, 8448.0F);
    localGL11.glColor4f(paramFloat, paramFloat, paramFloat, paramFloat);
    this.mAlpha = paramFloat;
  }
  
  public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    GL11 localGL11 = this.mGL;
    localGL11.glTexEnvf(8960, 8704, 8448.0F);
    localGL11.glColor4f(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.mAlpha = paramFloat4;
  }
  
  public void setFov(float paramFloat)
  {
    GL11 localGL11 = this.mGL;
    localGL11.glMatrixMode(5889);
    localGL11.glLoadIdentity();
    GLU.gluPerspective(localGL11, paramFloat, getWidth() / getHeight(), 0.1F, 100.0F);
    localGL11.glMatrixMode(5888);
  }
  
  public void setRootLayer(RootLayer paramRootLayer)
  {
    if (this.mRootLayer != paramRootLayer)
    {
      this.mRootLayer = paramRootLayer;
      this.mListsDirty = true;
      if (paramRootLayer != null) {
        this.mRootLayer.setSize(this.mViewWidth, this.mViewHeight);
      }
    }
  }
  
  public void shutdown()
  {
    this.mRootLayer = null;
    synchronized (sLists)
    {
      sLists.clear();
      return;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
  }
  
  public void unbindMixed()
  {
    GL11 localGL11 = this.mGL;
    localGL11.glDisable(3553);
    localGL11.glActiveTexture(33984);
    this.mBoundTexture = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/RenderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
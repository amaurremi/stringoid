package com.venticake.retrica.engine;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.venticake.retrica.engine.a.g;
import java.io.File;
import java.util.Queue;

public class RetricaEngine
{
  private static int __glMaxTextureSize = 0;
  private static int gPreviewFormat = 17;
  private RetricaEngine.BitmapApplyProgressCallback mBitmapApplyProgressCallback = null;
  private final Context mContext;
  private Bitmap mCurrentBitmap;
  private GLSurfaceView mGlSurfaceView;
  private g mLens;
  private RetricaRenderer mRenderer;
  private RetricaEngine.ScaleType mScaleType = RetricaEngine.ScaleType.CENTER_CROP;
  private boolean skipYUV;
  
  public RetricaEngine(Context paramContext)
  {
    this(paramContext, new g(paramContext), true);
  }
  
  public RetricaEngine(Context paramContext, g paramg)
  {
    this(paramContext, paramg, skipYUV());
  }
  
  public RetricaEngine(Context paramContext, g paramg, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mLens = paramg;
    this.skipYUV = paramBoolean;
    if (this.skipYUV)
    {
      this.mRenderer = new RetricaRGBRenderer(this.mLens);
      return;
    }
    this.mRenderer = new RetricaRenderer(this.mLens);
  }
  
  private void bitmapApplyProcess(float paramFloat)
  {
    if (this.mBitmapApplyProgressCallback == null) {
      return;
    }
    this.mBitmapApplyProgressCallback.onProcess(paramFloat);
  }
  
  public static int getGlMaxTextureSize()
  {
    if (__glMaxTextureSize > 0) {
      return __glMaxTextureSize;
    }
    int[] arrayOfInt = new int[1];
    GLES20.glGetIntegerv(3379, arrayOfInt, 0);
    if ((arrayOfInt != null) && (arrayOfInt.length > 0)) {
      __glMaxTextureSize = arrayOfInt[0];
    }
    return __glMaxTextureSize;
  }
  
  private int getOutputHeight()
  {
    if ((this.mRenderer != null) && (this.mRenderer.getFrameHeight() != 0)) {
      return this.mRenderer.getFrameHeight();
    }
    if (this.mCurrentBitmap != null) {
      return this.mCurrentBitmap.getHeight();
    }
    return ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
  }
  
  private int getOutputWidth()
  {
    if ((this.mRenderer != null) && (this.mRenderer.getFrameWidth() != 0)) {
      return this.mRenderer.getFrameWidth();
    }
    if (this.mCurrentBitmap != null) {
      return this.mCurrentBitmap.getWidth();
    }
    return ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  private String getPath(Uri paramUri)
  {
    Object localObject = null;
    Cursor localCursor = this.mContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
    int i = localCursor.getColumnIndexOrThrow("_data");
    paramUri = (Uri)localObject;
    if (localCursor.moveToFirst()) {
      paramUri = localCursor.getString(i);
    }
    localCursor.close();
    return paramUri;
  }
  
  public static int getPreviewFormat()
  {
    return gPreviewFormat;
  }
  
  private void setImage(Bitmap paramBitmap, boolean paramBoolean)
  {
    this.mRenderer.setImageBitmap(paramBitmap, paramBoolean);
    requestRender();
  }
  
  public static void setPreviewFormat(int paramInt)
  {
    gPreviewFormat = paramInt;
  }
  
  @TargetApi(11)
  private void setUpCameraAfterGingerbread(Camera paramCamera)
  {
    this.mRenderer.setUpSurfaceTexture(paramCamera);
  }
  
  private void setUpCameraGingerbread(final Camera paramCamera)
  {
    this.mRenderer.runOnDraw(new Runnable()
    {
      public void run()
      {
        try
        {
          paramCamera.setPreviewCallback(RetricaEngine.this.mRenderer);
          Log.d("retrica", "camera setPreviewCallback(<11): " + paramCamera + ", renderer: " + RetricaEngine.this.mRenderer);
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
    });
  }
  
  public static boolean skipYUV()
  {
    return true;
  }
  
  public void clearDrawQueue()
  {
    if (this.mRenderer == null) {
      return;
    }
    this.mRenderer.getDrawQueue().clear();
  }
  
  public void deleteImage()
  {
    this.mRenderer.deleteImage();
    this.mRenderer.deleteBuffer();
    this.mCurrentBitmap = null;
    requestRender();
  }
  
  public Bitmap getBitmapWithFilterApplied(Bitmap paramBitmap)
  {
    return getBitmapWithFilterApplied(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
  }
  
  public Bitmap getBitmapWithFilterApplied(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return getBitmapWithFilterApplied(paramBitmap, paramInt1, paramInt2, false);
  }
  
  public Bitmap getBitmapWithFilterApplied(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.mGlSurfaceView != null)
    {
      this.mRenderer.deleteImage();
      this.mRenderer.deleteBuffer();
    }
    for (;;)
    {
      Object localObject;
      try
      {
        requestRender();
        System.gc();
        bitmapApplyProcess(0.1F);
        PixelBuffer localPixelBuffer;
        if (this.skipYUV)
        {
          localObject = this.mRenderer;
          bitmapApplyProcess(0.2F);
          localPixelBuffer = new PixelBuffer(paramInt1, paramInt2);
          localPixelBuffer.setRenderer((GLSurfaceView.Renderer)localObject);
          ((RetricaRenderer)localObject).setImageBitmap(paramBitmap, paramBoolean);
          bitmapApplyProcess(0.4F);
          paramBitmap = localPixelBuffer.getBitmap();
          bitmapApplyProcess(0.6F);
        }
        localObject = new RetricaRGBRenderer(this.mLens);
      }
      finally
      {
        try
        {
          this.mLens.h();
          ((RetricaRenderer)localObject).deleteImage();
          ((RetricaRenderer)localObject).deleteBuffer();
          bitmapApplyProcess(0.7F);
          localPixelBuffer.destroy();
          System.gc();
          bitmapApplyProcess(0.8F);
          bitmapApplyProcess(0.9F);
          bitmapApplyProcess(1.0F);
          return paramBitmap;
        }
        finally {}
        paramBitmap = finally;
      }
      ((RetricaRenderer)localObject).setRotation(this.mRenderer.getRotation(), this.mRenderer.isFlippedHorizontally(), this.mRenderer.isFlippedVertically());
      ((RetricaRenderer)localObject).setScaleType(this.mScaleType);
    }
  }
  
  public Bitmap getBitmapWithFilterApplied(Bitmap paramBitmap, boolean paramBoolean)
  {
    return getBitmapWithFilterApplied(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight(), paramBoolean);
  }
  
  public void getCurrentBuffer(BufferPictureCallback paramBufferPictureCallback)
  {
    this.mRenderer.renderedBufferPictureCallback = paramBufferPictureCallback;
  }
  
  public void getCurrentBuffer(RenderedBufferListner paramRenderedBufferListner)
  {
    this.mRenderer.renderedBufferListner = paramRenderedBufferListner;
  }
  
  public g getCurrentLens()
  {
    return this.mLens;
  }
  
  public RetricaRenderer getRenderer()
  {
    return this.mRenderer;
  }
  
  public void pause()
  {
    this.mRenderer.pause = true;
  }
  
  public void release()
  {
    this.mRenderer.cleanLens();
    this.mRenderer = null;
    this.mGlSurfaceView = null;
    this.mLens = null;
  }
  
  public void releaseCamera(Camera paramCamera) {}
  
  public void requestRender()
  {
    if (this.mGlSurfaceView != null) {
      this.mGlSurfaceView.requestRender();
    }
  }
  
  public void resume()
  {
    this.mRenderer.pause = false;
  }
  
  public void runOnRendererThread(Runnable paramRunnable)
  {
    if (this.mRenderer == null)
    {
      paramRunnable.run();
      return;
    }
    this.mRenderer.runOnDraw(paramRunnable);
  }
  
  public void saveToPictures(Bitmap paramBitmap, String paramString1, String paramString2, RetricaEngine.OnPictureSavedListener paramOnPictureSavedListener)
  {
    new RetricaEngine.SaveTask(this, paramBitmap, paramString1, paramString2, paramOnPictureSavedListener).execute(new Void[0]);
  }
  
  public void saveToPictures(String paramString1, String paramString2, RetricaEngine.OnPictureSavedListener paramOnPictureSavedListener)
  {
    saveToPictures(this.mCurrentBitmap, paramString1, paramString2, paramOnPictureSavedListener);
  }
  
  public void setBitmapApplyProgressCallback(RetricaEngine.BitmapApplyProgressCallback paramBitmapApplyProgressCallback)
  {
    this.mBitmapApplyProgressCallback = paramBitmapApplyProgressCallback;
  }
  
  public void setGLSurfaceView(GLSurfaceView paramGLSurfaceView)
  {
    if (this.mGlSurfaceView == paramGLSurfaceView) {
      return;
    }
    if (paramGLSurfaceView == null)
    {
      this.mGlSurfaceView = null;
      return;
    }
    this.mGlSurfaceView = paramGLSurfaceView;
    this.mGlSurfaceView.setEGLContextClientVersion(2);
    this.mGlSurfaceView.setRenderer(this.mRenderer);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    setImage(paramBitmap, false);
    this.mCurrentBitmap = paramBitmap;
  }
  
  public void setImage(Uri paramUri)
  {
    new RetricaEngine.LoadImageUriTask(this, this, paramUri).execute(new Void[0]);
  }
  
  public void setImage(File paramFile)
  {
    new RetricaEngine.LoadImageFileTask(this, this, paramFile).execute(new Void[0]);
  }
  
  public void setLens(g paramg)
  {
    this.mLens = paramg;
    this.mLens.a(skipYUV());
    this.mRenderer.setLens(this.mLens);
    requestRender();
  }
  
  public void setOrientation(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    RetricaRenderer localRetricaRenderer;
    Rotation localRotation;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (paramBoolean1)
      {
        this.mRenderer.setRotation(Rotation.NORMAL, true, paramBoolean2);
        return;
      }
      this.mRenderer.setRotation(Rotation.NORMAL, false, true);
      return;
    case 1: 
      if (paramBoolean1)
      {
        localRetricaRenderer = this.mRenderer;
        localRotation = Rotation.NORMAL;
        paramBoolean1 = bool1;
        if (paramBoolean2) {
          paramBoolean1 = false;
        }
        localRetricaRenderer.setRotation(localRotation, paramBoolean1, false);
        return;
      }
      this.mRenderer.setRotation(Rotation.ROTATION_180, false, true);
      return;
    case 2: 
      if (paramBoolean1)
      {
        this.mRenderer.setRotation(Rotation.NORMAL, true, paramBoolean2);
        return;
      }
      this.mRenderer.setRotation(Rotation.NORMAL, false, true);
      return;
    }
    if (paramBoolean1)
    {
      localRetricaRenderer = this.mRenderer;
      localRotation = Rotation.NORMAL;
      paramBoolean1 = bool2;
      if (paramBoolean2) {
        paramBoolean1 = false;
      }
      localRetricaRenderer.setRotation(localRotation, paramBoolean1, false);
      return;
    }
    this.mRenderer.setRotation(Rotation.ROTATION_180, false, true);
  }
  
  public void setScaleType(RetricaEngine.ScaleType paramScaleType)
  {
    this.mScaleType = paramScaleType;
    this.mRenderer.setScaleType(paramScaleType);
    this.mRenderer.deleteImage();
    this.mRenderer.deleteBuffer();
    this.mCurrentBitmap = null;
    requestRender();
  }
  
  public void setUpCamera(Camera paramCamera)
  {
    setUpCamera(paramCamera, 0, false, false);
  }
  
  public void setUpCamera(Camera paramCamera, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Rotation localRotation = Rotation.NORMAL;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.mRenderer.setRotationCamera(localRotation, paramBoolean1, paramBoolean2);
      if (Build.VERSION.SDK_INT <= 10) {
        break;
      }
      this.mGlSurfaceView.setRenderMode(1);
      setUpCameraAfterGingerbread(paramCamera);
      return;
      localRotation = Rotation.ROTATION_90;
      continue;
      localRotation = Rotation.ROTATION_180;
      continue;
      localRotation = Rotation.ROTATION_270;
    }
    this.mGlSurfaceView.setRenderMode(1);
    setUpCameraGingerbread(paramCamera);
  }
  
  public void setUpCamera(Camera paramCamera, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setUpCamera(paramCamera, 90, false, true);
      return;
    }
    setUpCamera(paramCamera, 90, false, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/RetricaEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.venticake.retrica.engine;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.util.Log;
import com.venticake.retrica.b.b;
import com.venticake.retrica.engine.a.g;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(11)
public class RetricaRenderer
  implements Camera.PreviewCallback, GLSurfaceView.Renderer
{
  public static final float[] CUBE = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final int NO_IMAGE = -1;
  protected int mAddedPadding;
  protected boolean mFlipHorizontal;
  protected boolean mFlipVertical;
  protected final FloatBuffer mGLCubeBuffer;
  protected final FloatBuffer mGLTextureBuffer;
  private int mGLTextureUVId = -1;
  private int mGLTextureYId = -1;
  protected int mImageHeight;
  protected int mImageWidth;
  protected g mLens;
  protected int mOutputHeight;
  protected int mOutputWidth;
  protected Rotation mRotation;
  protected final Queue<Runnable> mRunOnDraw;
  protected RetricaEngine.ScaleType mScaleType = RetricaEngine.ScaleType.CENTER_CROP;
  public final Object mSurfaceChangedWaiter = new Object();
  protected SurfaceTexture mSurfaceTexture = null;
  private ByteBuffer mUVBuffer;
  private ByteBuffer mYBuffer;
  public boolean pause = false;
  protected long prevDrawTime = 0L;
  public RenderedBufferListner renderedBufferListner;
  public BufferPictureCallback renderedBufferPictureCallback;
  
  public RetricaRenderer(g paramg)
  {
    this.mLens = paramg;
    this.mRunOnDraw = new LinkedList();
    this.mGLCubeBuffer = ByteBuffer.allocateDirect(CUBE.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mGLCubeBuffer.put(CUBE).position(0);
    this.mGLTextureBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.TEXTURE_NO_ROTATION.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    setRotation(Rotation.NORMAL, false, false);
  }
  
  private float addDistance(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == 0.0F) {
      return paramFloat2;
    }
    return 1.0F - paramFloat2;
  }
  
  private void initializeBuffer(Camera.Size paramSize)
  {
    int i;
    if (this.mYBuffer == null)
    {
      i = paramSize.width * paramSize.height;
      if (i > 0)
      {
        this.mYBuffer = ByteBuffer.allocateDirect(i);
        Log.d("retrica", "Y buffer (alloc: " + i + ")  - previewSize: " + paramSize.width + ", " + paramSize.height);
      }
    }
    if (this.mUVBuffer == null)
    {
      i = paramSize.width * paramSize.height / 2;
      if (i > 0)
      {
        this.mUVBuffer = ByteBuffer.allocateDirect(i);
        Log.d("retrica", "UV buffer (alloc: " + i + ")  - previewSize: " + paramSize.width + ", " + paramSize.height);
      }
    }
  }
  
  protected void adjustImageScaling()
  {
    adjustTextureBuffer();
  }
  
  protected void adjustTextureBuffer()
  {
    float[] arrayOfFloat = TextureRotationUtil.getRotation(this.mRotation, this.mFlipHorizontal, this.mFlipVertical);
    this.mGLTextureBuffer.put(arrayOfFloat).position(0);
  }
  
  public void cleanLens()
  {
    if (this.mLens == null) {
      return;
    }
    this.mLens.h();
    this.mLens = null;
  }
  
  public void deleteBuffer()
  {
    runOnDraw(new Runnable()
    {
      public void run()
      {
        RetricaRenderer.this.deleteBufferDirectly();
      }
    });
  }
  
  protected void deleteBufferDirectly()
  {
    this.mYBuffer = null;
    this.mUVBuffer = null;
  }
  
  public void deleteImage()
  {
    runOnDraw(new Runnable()
    {
      public void run()
      {
        RetricaRenderer.this.deleteImageDirectly();
      }
    });
  }
  
  protected void deleteImageDirectly()
  {
    if (this.mGLTextureYId != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.mGLTextureYId }, 0);
      this.mGLTextureYId = -1;
    }
    if (this.mGLTextureUVId != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.mGLTextureUVId }, 0);
      this.mGLTextureUVId = -1;
    }
  }
  
  public Queue<Runnable> getDrawQueue()
  {
    return this.mRunOnDraw;
  }
  
  protected int getFrameHeight()
  {
    return this.mOutputHeight;
  }
  
  protected int getFrameWidth()
  {
    return this.mOutputWidth;
  }
  
  public Rotation getRotation()
  {
    return this.mRotation;
  }
  
  public boolean isFlippedHorizontally()
  {
    return this.mFlipHorizontal;
  }
  
  public boolean isFlippedVertically()
  {
    return this.mFlipVertical;
  }
  
  @SuppressLint({"WrongCall"})
  public void onDrawFrame(GL10 arg1)
  {
    if (this.pause) {
      synchronized (this.mRunOnDraw)
      {
        this.mRunOnDraw.clear();
        return;
      }
    }
    for (;;)
    {
      synchronized (this.mRunOnDraw)
      {
        if (this.mRunOnDraw.isEmpty())
        {
          if (this.mLens == null) {
            return;
          }
          this.mLens.a(this.mGLTextureYId, this.mGLTextureUVId, this.mGLCubeBuffer, this.mGLTextureBuffer);
          if ((this.mSurfaceTexture != null) && (Build.VERSION.SDK_INT > 10)) {
            this.mSurfaceTexture.updateTexImage();
          }
          if (this.renderedBufferListner != null)
          {
            this.renderedBufferListner.response(this.mLens.u());
            this.renderedBufferListner = null;
          }
          if (this.renderedBufferPictureCallback == null) {}
        }
      }
      try
      {
        this.renderedBufferPictureCallback.callback(this.mLens.u(), this.mLens.m(), this.mLens.n());
        this.renderedBufferPictureCallback = null;
        RetricaEngine.getGlMaxTextureSize();
        return;
        Runnable localRunnable = (Runnable)this.mRunOnDraw.poll();
        if (localRunnable != null)
        {
          localRunnable.run();
          continue;
          localObject2 = finally;
          throw ((Throwable)localObject2);
        }
      }
      catch (Exception ???)
      {
        for (;;)
        {
          ???.printStackTrace();
        }
      }
    }
  }
  
  public void onPreviewFrame(final byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.pause) {}
    do
    {
      do
      {
        return;
      } while ((!this.mRunOnDraw.isEmpty()) || (paramCamera == null));
      paramCamera = paramCamera.getParameters();
    } while (paramCamera == null);
    runOnDraw(new Runnable()
    {
      public void run()
      {
        if ((RetricaRenderer.this.mImageWidth > 0) && (RetricaRenderer.this.mImageHeight > 0) && ((RetricaRenderer.this.mImageHeight != this.val$previewSize.width) || (RetricaRenderer.this.mImageWidth != this.val$previewSize.height)))
        {
          RetricaRenderer.this.deleteImageDirectly();
          RetricaRenderer.this.deleteBufferDirectly();
        }
        RetricaRenderer.this.initializeBuffer(this.val$previewSize);
        RetricaRenderer.this.mYBuffer.put(paramArrayOfByte, 0, this.val$previewSize.width * this.val$previewSize.height);
        RetricaRenderer.this.mUVBuffer.put(paramArrayOfByte, this.val$previewSize.width * this.val$previewSize.height, this.val$previewSize.width * this.val$previewSize.height / 2);
        int[] arrayOfInt = OpenGlUtils.loadTextureNV21(RetricaRenderer.this.mYBuffer, RetricaRenderer.this.mUVBuffer, this.val$previewSize, RetricaRenderer.this.mGLTextureYId, RetricaRenderer.this.mGLTextureUVId);
        if ((arrayOfInt != null) && (arrayOfInt.length > 0)) {
          RetricaRenderer.this.mGLTextureYId = arrayOfInt[0];
        }
        if ((arrayOfInt != null) && (arrayOfInt.length > 1)) {
          RetricaRenderer.this.mGLTextureUVId = arrayOfInt[1];
        }
        if ((RetricaRenderer.this.mImageHeight != this.val$previewSize.width) || (RetricaRenderer.this.mImageWidth != this.val$previewSize.height))
        {
          RetricaRenderer.this.mImageHeight = this.val$previewSize.width;
          RetricaRenderer.this.mImageWidth = this.val$previewSize.height;
          RetricaRenderer.this.mLens.c(RetricaRenderer.this.mImageWidth, RetricaRenderer.this.mImageHeight);
        }
      }
    });
  }
  
  public void onSurfaceChanged(GL10 arg1, int paramInt1, int paramInt2)
  {
    Log.d("retrica", "onSurfaceChanged: " + paramInt1 + ", " + paramInt2 + " (input: " + this.mImageWidth + ", " + this.mImageHeight + ")");
    this.mOutputWidth = paramInt1;
    this.mOutputHeight = paramInt2;
    b.a(0, 0, paramInt1, paramInt2);
    this.mLens.p();
    this.mLens.c(this.mImageWidth, this.mImageHeight);
    this.mLens.a(this.mOutputWidth, this.mOutputHeight);
    synchronized (this.mSurfaceChangedWaiter)
    {
      this.mSurfaceChangedWaiter.notifyAll();
      return;
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.mLens.f();
  }
  
  protected void runOnDraw(Runnable paramRunnable)
  {
    synchronized (this.mRunOnDraw)
    {
      this.mRunOnDraw.add(paramRunnable);
      return;
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    setImageBitmap(paramBitmap, true);
  }
  
  public void setImageBitmap(final Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return;
    }
    runOnDraw(new Runnable()
    {
      public void run()
      {
        Bitmap localBitmap;
        if (paramBitmap.getWidth() % 2 == 1)
        {
          localBitmap = Bitmap.createBitmap(paramBitmap.getWidth() + 1, paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(localBitmap);
          localCanvas.drawARGB(0, 0, 0, 0);
          localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
          RetricaRenderer.this.mAddedPadding = 1;
        }
        for (;;)
        {
          Log.d("Implement HERE", "TODO: ERRORROROROORRR");
          if (localBitmap != null) {
            localBitmap.recycle();
          }
          RetricaRenderer.this.mImageWidth = paramBitmap.getWidth();
          RetricaRenderer.this.mImageHeight = paramBitmap.getHeight();
          RetricaRenderer.this.adjustImageScaling();
          return;
          RetricaRenderer.this.mAddedPadding = 0;
          localBitmap = null;
        }
      }
    });
  }
  
  public void setImageSize(int paramInt1, int paramInt2)
  {
    this.mImageWidth = paramInt1;
    this.mImageHeight = paramInt2;
    Log.d("retrica", "setImageSize: " + paramInt1 + ", " + paramInt2);
  }
  
  public void setLens(final g paramg)
  {
    runOnDraw(new Runnable()
    {
      public void run()
      {
        g localg = RetricaRenderer.this.mLens;
        if (localg != null) {
          localg.h();
        }
        RetricaRenderer.this.mLens = paramg;
        if (RetricaRenderer.this.mLens != null)
        {
          RetricaRenderer.this.mLens.f();
          RetricaRenderer.this.mLens.p();
          RetricaRenderer.this.mLens.c(RetricaRenderer.this.mImageWidth, RetricaRenderer.this.mImageHeight);
          RetricaRenderer.this.mLens.a(RetricaRenderer.this.mOutputWidth, RetricaRenderer.this.mOutputHeight);
        }
      }
    });
  }
  
  public void setRotation(Rotation paramRotation, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mRotation = paramRotation;
    this.mFlipHorizontal = paramBoolean1;
    this.mFlipVertical = paramBoolean2;
    adjustTextureBuffer();
  }
  
  public void setRotationCamera(Rotation paramRotation, boolean paramBoolean1, boolean paramBoolean2)
  {
    setRotation(paramRotation, paramBoolean2, paramBoolean1);
  }
  
  public void setScaleType(RetricaEngine.ScaleType paramScaleType)
  {
    this.mScaleType = paramScaleType;
  }
  
  public void setUpSurfaceTexture(final Camera paramCamera)
  {
    runOnDraw(new Runnable()
    {
      public void run()
      {
        int[] arrayOfInt = new int[1];
        GLES20.glGenTextures(1, arrayOfInt, 0);
        RetricaRenderer.this.mSurfaceTexture = new SurfaceTexture(arrayOfInt[0]);
        try
        {
          paramCamera.setPreviewTexture(RetricaRenderer.this.mSurfaceTexture);
          paramCamera.setPreviewCallback(RetricaRenderer.this);
          Log.d("retrica", "camera setPreviewCallback: " + paramCamera + ", renderer: " + RetricaRenderer.this);
          return;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/RetricaRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
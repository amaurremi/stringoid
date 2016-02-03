package com.venticake.retrica.engine;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import com.venticake.retrica.engine.a.g;
import java.nio.IntBuffer;
import java.util.Queue;
import javax.microedition.khronos.opengles.GL10;

public class RetricaRGBRenderer
  extends RetricaRenderer
{
  private IntBuffer mGLRGBBuffer;
  private int mGLTextureId = -1;
  
  public RetricaRGBRenderer(g paramg)
  {
    super(paramg);
  }
  
  protected void deleteBufferDirectly()
  {
    this.mGLRGBBuffer = null;
  }
  
  protected void deleteImageDirectly()
  {
    if (this.mGLTextureId != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.mGLTextureId }, 0);
      this.mGLTextureId = -1;
    }
  }
  
  @SuppressLint({"WrongCall"})
  @TargetApi(11)
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
          this.mLens.a(this.mGLTextureId, this.mGLCubeBuffer, this.mGLTextureBuffer);
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
        if ((RetricaRGBRenderer.this.mImageWidth > 0) && (RetricaRGBRenderer.this.mImageHeight > 0) && ((RetricaRGBRenderer.this.mImageHeight != this.val$previewSize.width) || (RetricaRGBRenderer.this.mImageWidth != this.val$previewSize.height)))
        {
          RetricaRGBRenderer.this.deleteImageDirectly();
          RetricaRGBRenderer.this.deleteBufferDirectly();
        }
        if (RetricaRGBRenderer.this.mGLRGBBuffer == null) {
          RetricaRGBRenderer.this.mGLRGBBuffer = IntBuffer.allocate(this.val$previewSize.width * this.val$previewSize.height);
        }
        RetricaNativeLibrary.YUVtoRBGA(paramArrayOfByte, this.val$previewSize.width, this.val$previewSize.height, RetricaRGBRenderer.this.mGLRGBBuffer.array());
        RetricaRGBRenderer.this.mGLTextureId = OpenGlUtils.loadTexture(RetricaRGBRenderer.this.mGLRGBBuffer, this.val$previewSize, RetricaRGBRenderer.this.mGLTextureId);
        if ((RetricaRGBRenderer.this.mImageHeight != this.val$previewSize.width) || (RetricaRGBRenderer.this.mImageWidth != this.val$previewSize.height))
        {
          RetricaRGBRenderer.this.mImageHeight = this.val$previewSize.width;
          RetricaRGBRenderer.this.mImageWidth = this.val$previewSize.height;
          RetricaRGBRenderer.this.mLens.c(RetricaRGBRenderer.this.mImageWidth, RetricaRGBRenderer.this.mImageHeight);
        }
      }
    });
  }
  
  public void setImageBitmap(final Bitmap paramBitmap, final boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return;
    }
    runOnDraw(new Runnable()
    {
      public void run()
      {
        Bitmap localBitmap;
        RetricaRGBRenderer localRetricaRGBRenderer;
        if (paramBitmap.getWidth() % 2 == 1)
        {
          localBitmap = Bitmap.createBitmap(paramBitmap.getWidth() + 1, paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
          localObject = new Canvas(localBitmap);
          ((Canvas)localObject).drawARGB(0, 0, 0, 0);
          ((Canvas)localObject).drawBitmap(paramBitmap, 0.0F, 0.0F, null);
          RetricaRGBRenderer.this.mAddedPadding = 1;
          localRetricaRGBRenderer = RetricaRGBRenderer.this;
          if (localBitmap == null) {
            break label159;
          }
        }
        label159:
        for (Object localObject = localBitmap;; localObject = paramBitmap)
        {
          localRetricaRGBRenderer.mGLTextureId = OpenGlUtils.loadTexture((Bitmap)localObject, RetricaRGBRenderer.this.mGLTextureId, paramBoolean);
          if (localBitmap != null) {
            localBitmap.recycle();
          }
          RetricaRGBRenderer.this.mImageWidth = paramBitmap.getWidth();
          RetricaRGBRenderer.this.mImageHeight = paramBitmap.getHeight();
          RetricaRGBRenderer.this.adjustImageScaling();
          return;
          RetricaRGBRenderer.this.mAddedPadding = 0;
          localBitmap = null;
          break;
        }
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/RetricaRGBRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.venticake.retrica.engine;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class PixelBuffer
{
  static final boolean LIST_CONFIGS = false;
  static final String TAG = "PixelBuffer";
  Bitmap mBitmap;
  EGL10 mEGL;
  EGLConfig mEGLConfig;
  EGLConfig[] mEGLConfigs;
  EGLContext mEGLContext;
  EGLDisplay mEGLDisplay;
  EGLSurface mEGLSurface;
  GL10 mGL;
  int mHeight;
  GLSurfaceView.Renderer mRenderer;
  String mThreadOwner;
  int mWidth;
  
  public PixelBuffer(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    int[] arrayOfInt = new int[2];
    paramInt1 = this.mWidth;
    paramInt2 = this.mHeight;
    this.mEGL = ((EGL10)EGLContext.getEGL());
    this.mEGLDisplay = this.mEGL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    this.mEGL.eglInitialize(this.mEGLDisplay, arrayOfInt);
    this.mEGLConfig = chooseConfig();
    this.mEGLContext = this.mEGL.eglCreateContext(this.mEGLDisplay, this.mEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    this.mEGLSurface = this.mEGL.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 });
    this.mEGL.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext);
    this.mGL = ((GL10)this.mEGLContext.getGL());
    this.mThreadOwner = Thread.currentThread().getName();
  }
  
  private EGLConfig chooseConfig()
  {
    int[] arrayOfInt1 = new int[15];
    arrayOfInt1[0] = 12325;
    arrayOfInt1[2] = 12326;
    arrayOfInt1[4] = 12324;
    arrayOfInt1[5] = 8;
    arrayOfInt1[6] = 12323;
    arrayOfInt1[7] = 8;
    arrayOfInt1[8] = 12322;
    arrayOfInt1[9] = 8;
    arrayOfInt1[10] = 12321;
    arrayOfInt1[11] = 8;
    arrayOfInt1[12] = 12352;
    arrayOfInt1[13] = 4;
    arrayOfInt1[14] = 12344;
    int[] arrayOfInt2 = new int[1];
    this.mEGL.eglChooseConfig(this.mEGLDisplay, arrayOfInt1, null, 0, arrayOfInt2);
    int i = arrayOfInt2[0];
    this.mEGLConfigs = new EGLConfig[i];
    this.mEGL.eglChooseConfig(this.mEGLDisplay, arrayOfInt1, this.mEGLConfigs, i, arrayOfInt2);
    return this.mEGLConfigs[0];
  }
  
  private void convertToBitmap()
  {
    System.gc();
    IntBuffer localIntBuffer = IntBuffer.allocate(this.mWidth * this.mHeight);
    this.mGL.glReadPixels(0, 0, this.mWidth, this.mHeight, 6408, 5121, localIntBuffer);
    System.gc();
    this.mBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
    this.mBitmap.copyPixelsFromBuffer(localIntBuffer);
    System.gc();
  }
  
  private int getConfigAttrib(EGLConfig paramEGLConfig, int paramInt)
  {
    int i = 0;
    int[] arrayOfInt = new int[1];
    if (this.mEGL.eglGetConfigAttrib(this.mEGLDisplay, paramEGLConfig, paramInt, arrayOfInt)) {
      i = arrayOfInt[0];
    }
    return i;
  }
  
  private void listConfig()
  {
    Log.i("PixelBuffer", "Config List {");
    EGLConfig[] arrayOfEGLConfig = this.mEGLConfigs;
    int j = arrayOfEGLConfig.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        Log.i("PixelBuffer", "}");
        return;
      }
      EGLConfig localEGLConfig = arrayOfEGLConfig[i];
      int k = getConfigAttrib(localEGLConfig, 12325);
      int m = getConfigAttrib(localEGLConfig, 12326);
      int n = getConfigAttrib(localEGLConfig, 12324);
      int i1 = getConfigAttrib(localEGLConfig, 12323);
      int i2 = getConfigAttrib(localEGLConfig, 12322);
      int i3 = getConfigAttrib(localEGLConfig, 12321);
      Log.i("PixelBuffer", "    <d,s,r,g,b,a> = <" + k + "," + m + "," + n + "," + i1 + "," + i2 + "," + i3 + ">");
      i += 1;
    }
  }
  
  public void destroy()
  {
    this.mEGL.eglMakeCurrent(this.mEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
    this.mEGL.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
    this.mEGL.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
    this.mEGL.eglTerminate(this.mEGLDisplay);
  }
  
  public Bitmap getBitmap()
  {
    if (this.mRenderer == null)
    {
      Log.e("PixelBuffer", "getBitmap: Renderer was not set.");
      return null;
    }
    if (!Thread.currentThread().getName().equals(this.mThreadOwner))
    {
      Log.e("PixelBuffer", "getBitmap: This thread does not own the OpenGL context.");
      return null;
    }
    this.mRenderer.onDrawFrame(this.mGL);
    convertToBitmap();
    return this.mBitmap;
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    this.mRenderer = paramRenderer;
    if (!Thread.currentThread().getName().equals(this.mThreadOwner))
    {
      Log.e("PixelBuffer", "setRenderer: This thread does not own the OpenGL context.");
      return;
    }
    this.mRenderer.onSurfaceCreated(this.mGL, this.mEGLConfig);
    this.mRenderer.onSurfaceChanged(this.mGL, this.mWidth, this.mHeight);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/PixelBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
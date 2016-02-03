package com.venticake.retrica.view;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class CameraPreview
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private final String TAG = "retrica";
  private Camera mCamera;
  private SurfaceHolder mHolder;
  private boolean previewing;
  
  public CameraPreview(Context paramContext)
  {
    super(paramContext);
    setup();
  }
  
  public CameraPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setup();
  }
  
  public CameraPreview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setup();
  }
  
  private void setup()
  {
    this.previewing = false;
    this.mHolder = getHolder();
    this.mHolder.addCallback(this);
    this.mHolder.setType(3);
  }
  
  public void setCamera(Camera paramCamera)
  {
    if (paramCamera != null)
    {
      this.mCamera = paramCamera;
      startPreview();
      return;
    }
    stopPreview();
    this.mCamera = null;
  }
  
  public void startPreview()
  {
    if (this.previewing) {
      return;
    }
    Log.d("retrica", "CameraPreview.startPreview");
    try
    {
      this.mCamera.setPreviewDisplay(this.mHolder);
      this.mCamera.startPreview();
      this.previewing = true;
      Log.d("retrica", "CameraPreview.startPreview DONE");
      return;
    }
    catch (Exception localException)
    {
      Log.d("retrica", "Error starting camera preview: " + localException.getMessage());
    }
  }
  
  public void stopPreview()
  {
    Log.d("retrica", "CameraPreview.stopPreview");
    try
    {
      getHolder().removeCallback(this);
      if (this.mCamera != null)
      {
        this.mCamera.stopPreview();
        this.mCamera.release();
        this.mCamera = null;
        this.previewing = false;
      }
      Log.d("retrica", "CameraPreview.stopPreview DONE");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("retrica", "Error stopping camera preview: " + localException.getMessage());
      }
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mHolder.getSurface() == null) {
      return;
    }
    stopPreview();
    startPreview();
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    startPreview();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    stopPreview();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/CameraPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
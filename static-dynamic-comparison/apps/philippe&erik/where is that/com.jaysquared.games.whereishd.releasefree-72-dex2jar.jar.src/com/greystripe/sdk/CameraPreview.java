package com.greystripe.sdk;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import java.io.IOException;
import java.util.List;

public class CameraPreview
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private SurfaceHolder a;
  private Camera b;
  
  public CameraPreview(Context paramContext, Camera paramCamera)
  {
    super(paramContext);
    this.b = paramCamera;
    this.a = getHolder();
    this.a.addCallback(this);
    this.a.setType(3);
  }
  
  final void a()
  {
    if (this.b != null) {}
    try
    {
      this.b.autoFocus(new ar(this));
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      bd.b("Camera released already", new Object[0]);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.getSurface() == null) {
      return;
    }
    try
    {
      this.b.stopPreview();
      try
      {
        this.b.setPreviewDisplay(this.a);
        this.b.startPreview();
        return;
      }
      catch (Exception paramSurfaceHolder)
      {
        bd.b("greystripe", new Object[] { "Error starting camera preview: " + paramSurfaceHolder.getMessage() });
        return;
      }
    }
    catch (Exception paramSurfaceHolder)
    {
      for (;;)
      {
        paramSurfaceHolder.printStackTrace();
      }
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      this.b.setPreviewDisplay(paramSurfaceHolder);
      paramSurfaceHolder = this.b.getParameters();
      if (paramSurfaceHolder.getSupportedFocusModes().contains("auto"))
      {
        bd.b("contains auto focus", new Object[0]);
        paramSurfaceHolder.setFocusMode("auto");
      }
      for (;;)
      {
        this.b.setParameters(paramSurfaceHolder);
        this.b.startPreview();
        return;
        bd.b("doesn't contain auto focus", new Object[0]);
      }
      return;
    }
    catch (IOException paramSurfaceHolder)
    {
      bd.b("greystripe", new Object[] { "Error setting camera preview: " + paramSurfaceHolder.getMessage() });
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    bd.b("stop preview and free camera", new Object[0]);
    if (this.b != null)
    {
      this.b.stopPreview();
      this.b.release();
      this.b = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/CameraPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
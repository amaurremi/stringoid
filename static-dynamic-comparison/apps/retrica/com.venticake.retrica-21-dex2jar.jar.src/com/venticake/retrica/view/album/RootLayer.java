package com.venticake.retrica.view.album;

import android.hardware.SensorEvent;
import android.view.KeyEvent;
import javax.microedition.khronos.opengles.GL11;

public abstract class RootLayer
  extends Layer
{
  public void handleLowMemory() {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onOrientationChanged(int paramInt) {}
  
  public void onSensorChanged(RenderView paramRenderView, SensorEvent paramSensorEvent) {}
  
  public void onSurfaceChanged(RenderView paramRenderView, int paramInt1, int paramInt2) {}
  
  public void onSurfaceCreated(RenderView paramRenderView, GL11 paramGL11) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/RootLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
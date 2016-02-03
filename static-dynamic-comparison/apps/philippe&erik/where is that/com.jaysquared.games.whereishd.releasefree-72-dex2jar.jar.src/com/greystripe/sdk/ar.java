package com.greystripe.sdk;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;

final class ar
  implements Camera.AutoFocusCallback
{
  ar(CameraPreview paramCameraPreview) {}
  
  public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    bd.b("autofocus: " + paramBoolean, new Object[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
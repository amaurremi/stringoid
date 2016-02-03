package com.venticake.retrica.view;

import com.venticake.retrica.engine.a.g;

public abstract interface LensSelector$LensSelectorListner
{
  public abstract g lensSelectorSelectedLens();
  
  public abstract void onCloseButtonTouched();
  
  public abstract void onHidden(LensSelector paramLensSelector);
  
  public abstract void onIntensityEditModeChanged(LensIntensityControlView paramLensIntensityControlView, boolean paramBoolean);
  
  public abstract void onIntensityValueChanged(LensIntensityControlView paramLensIntensityControlView, float paramFloat);
  
  public abstract void onSelectLens(g paramg, LensSelector paramLensSelector);
  
  public abstract void onShown(LensSelector paramLensSelector);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/LensSelector$LensSelectorListner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
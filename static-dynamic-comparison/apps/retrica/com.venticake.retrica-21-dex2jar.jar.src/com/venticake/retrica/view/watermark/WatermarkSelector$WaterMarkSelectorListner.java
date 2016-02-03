package com.venticake.retrica.view.watermark;

import com.venticake.retrica.engine.a.g;

public abstract interface WatermarkSelector$WaterMarkSelectorListner
{
  public abstract g lensSelectorSelectedLens();
  
  public abstract void onHidden(WatermarkSelector paramWatermarkSelector);
  
  public abstract void onSelectLens(g paramg, WatermarkSelector paramWatermarkSelector);
  
  public abstract void onShown(WatermarkSelector paramWatermarkSelector);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/watermark/WatermarkSelector$WaterMarkSelectorListner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
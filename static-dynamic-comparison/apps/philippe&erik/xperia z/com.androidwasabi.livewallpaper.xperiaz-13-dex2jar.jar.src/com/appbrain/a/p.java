package com.appbrain.a;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;

final class p
  extends ShapeDrawable.ShaderFactory
{
  p(j paramj, int paramInt) {}
  
  public final Shader resize(int paramInt1, int paramInt2)
  {
    float f1 = (paramInt2 - this.a * 2) / paramInt2;
    float f2 = paramInt2;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    return new LinearGradient(0.0F, 0.0F, 0.0F, f2, new int[] { 16777215, 16777215, Integer.MAX_VALUE }, new float[] { 0.0F, f1, 1.0F }, localTileMode);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
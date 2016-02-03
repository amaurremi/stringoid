package com.appbrain.a;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;

final class q
  extends ShapeDrawable.ShaderFactory
{
  q(j paramj, int[] paramArrayOfInt) {}
  
  public final Shader resize(int paramInt1, int paramInt2)
  {
    return new LinearGradient(0.0F, 0.0F, 0.0F, paramInt2, this.a, null, Shader.TileMode.CLAMP);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
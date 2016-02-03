package com.appbrain.a;

import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;

final class cc
  extends ShapeDrawable.ShaderFactory
{
  cc(bu parambu, int paramInt) {}
  
  public final Shader resize(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1 / 2.0F;
    float f2 = this.a / f1;
    float f3 = paramInt1 / 2;
    float f4 = paramInt2 / 2;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    return new RadialGradient(f3, f4, f1, new int[] { -1879048192, -1879048192, 0 }, new float[] { 0.0F, 1.0F - f2, 1.0F }, localTileMode);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
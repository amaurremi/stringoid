package com.appbrain.a;

import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;

final class cb
  extends ShapeDrawable.ShaderFactory
{
  cb(bu parambu) {}
  
  public final Shader resize(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1 / 2.0F;
    float f2 = paramInt1 / 2;
    float f3 = paramInt2 / 2;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    return new RadialGradient(f2, f3, f1, new int[] { -1593835521, 1358954495, 687865855, 150994943, 16777215 }, new float[] { 0.0F, 0.3F, 0.56F, 0.82F, 1.0F }, localTileMode);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
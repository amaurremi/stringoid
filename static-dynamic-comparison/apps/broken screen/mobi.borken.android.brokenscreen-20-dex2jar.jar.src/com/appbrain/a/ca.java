package com.appbrain.a;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;

final class ca
  extends ShapeDrawable.ShaderFactory
{
  ca(bu parambu, int[] paramArrayOfInt) {}
  
  public final Shader resize(int paramInt1, int paramInt2)
  {
    return new LinearGradient(0.0F, 0.0F, 0.0F, paramInt2, this.a, null, Shader.TileMode.CLAMP);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
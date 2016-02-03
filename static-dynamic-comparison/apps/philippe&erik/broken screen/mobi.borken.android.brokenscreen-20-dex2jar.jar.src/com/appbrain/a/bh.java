package com.appbrain.a;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;

final class bh
  extends ShapeDrawable.ShaderFactory
{
  bh(at.k paramk, at.d paramd) {}
  
  public final Shader resize(int paramInt1, int paramInt2)
  {
    float f = this.a.d;
    paramInt1 = this.a.c.d;
    paramInt2 = this.a.c.e;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    return new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { paramInt1, paramInt2 }, null, localTileMode);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
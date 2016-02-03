package com.appbrain.a;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import cmn.q;

final class bk
  extends ShapeDrawable.ShaderFactory
{
  bk(at.n paramn, at.a parama) {}
  
  public final Shader resize(int paramInt1, int paramInt2)
  {
    float f = q.b(50.0F);
    paramInt1 = this.a.e.d;
    paramInt2 = this.a.e.e;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    return new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { paramInt1, paramInt2 }, null, localTileMode);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
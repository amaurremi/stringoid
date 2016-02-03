package com.appbrain.a;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import cmn.q;

final class bd
  extends ShapeDrawable.ShaderFactory
{
  bd(at.f paramf) {}
  
  public final Shader resize(int paramInt1, int paramInt2)
  {
    float f = q.b(50.0F);
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    return new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { -14408668, -10000280, -12763586, -12763586, -14408668 }, new float[] { 0.0F, 0.02F, 0.04F, 0.8F, 1.0F }, localTileMode);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
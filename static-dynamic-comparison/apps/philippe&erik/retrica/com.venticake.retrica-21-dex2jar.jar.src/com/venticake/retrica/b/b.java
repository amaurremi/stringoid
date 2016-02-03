package com.venticake.retrica.b;

import android.opengl.GLES20;

public class b
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt3;
    if (paramInt3 < 0) {
      i = 1;
    }
    paramInt3 = paramInt4;
    if (paramInt4 <= 0) {
      paramInt3 = 1;
    }
    GLES20.glViewport(paramInt1, paramInt2, i, paramInt3);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
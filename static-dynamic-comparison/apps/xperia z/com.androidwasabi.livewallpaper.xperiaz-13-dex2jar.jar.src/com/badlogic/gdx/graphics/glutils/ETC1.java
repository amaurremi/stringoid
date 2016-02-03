package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.k;
import com.badlogic.gdx.graphics.m;
import com.badlogic.gdx.utils.f;
import java.nio.ByteBuffer;

public class ETC1
{
  public static int a = 16;
  public static int b = 36196;
  
  private static int a(m paramm)
  {
    if (paramm == m.d) {
      return 2;
    }
    if (paramm == m.f) {
      return 3;
    }
    throw new f("Can only handle RGB565 or RGB888 images");
  }
  
  public static k a(a parama, m paramm)
  {
    int i;
    int j;
    int k;
    if (parama.a())
    {
      i = 16;
      j = getWidthPKM(parama.c, 0);
      k = getHeightPKM(parama.c, 0);
    }
    for (;;)
    {
      int m = a(paramm);
      paramm = new k(j, k, paramm);
      decodeImage(parama.c, i, paramm.h(), 0, j, k, m);
      return paramm;
      j = parama.a;
      k = parama.b;
      i = 0;
    }
  }
  
  private static native void decodeImage(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  static native int getHeightPKM(ByteBuffer paramByteBuffer, int paramInt);
  
  static native int getWidthPKM(ByteBuffer paramByteBuffer, int paramInt);
  
  static native boolean isValidPKM(ByteBuffer paramByteBuffer, int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/glutils/ETC1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.badlogic.gdx.utils;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class BufferUtils
{
  static a<ByteBuffer> a = new a();
  static int b = 0;
  
  public static FloatBuffer a(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    return localByteBuffer.asFloatBuffer();
  }
  
  public static void a(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.capacity();
    synchronized (a)
    {
      if (!a.b(paramByteBuffer, true)) {
        throw new IllegalArgumentException("buffer not allocated with newUnsafeByteBuffer or already disposed");
      }
    }
    b -= i;
    freeMemory(paramByteBuffer);
  }
  
  public static void a(float[] paramArrayOfFloat, Buffer paramBuffer, int paramInt1, int paramInt2)
  {
    copyJni(paramArrayOfFloat, paramBuffer, paramInt1, paramInt2);
    paramBuffer.position(0);
    if ((paramBuffer instanceof ByteBuffer)) {
      paramBuffer.limit(paramInt1 << 2);
    }
    while (!(paramBuffer instanceof FloatBuffer)) {
      return;
    }
    paramBuffer.limit(paramInt1);
  }
  
  public static ByteBuffer b(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt);
    localByteBuffer.order(ByteOrder.nativeOrder());
    return localByteBuffer;
  }
  
  public static IntBuffer c(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    return localByteBuffer.asIntBuffer();
  }
  
  private static native void copyJni(float[] paramArrayOfFloat, Buffer paramBuffer, int paramInt1, int paramInt2);
  
  public static ByteBuffer d(int paramInt)
  {
    ByteBuffer localByteBuffer = newDisposableByteBuffer(paramInt);
    localByteBuffer.order(ByteOrder.nativeOrder());
    b += paramInt;
    synchronized (a)
    {
      a.a(localByteBuffer);
      return localByteBuffer;
    }
  }
  
  private static native void freeMemory(ByteBuffer paramByteBuffer);
  
  private static native ByteBuffer newDisposableByteBuffer(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/BufferUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
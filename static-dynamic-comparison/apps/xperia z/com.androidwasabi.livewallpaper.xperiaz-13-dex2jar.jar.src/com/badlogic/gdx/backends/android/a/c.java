package com.badlogic.gdx.backends.android.a;

import java.nio.Buffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;

class c
  implements com.badlogic.gdx.graphics.c
{
  final GL10 a;
  
  public c(GL10 paramGL10)
  {
    this.a = paramGL10;
  }
  
  public final void a(int paramInt)
  {
    this.a.glClientActiveTexture(paramInt);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    this.a.glColorPointer(paramInt1, paramInt2, paramInt3, paramBuffer);
  }
  
  public final void a(int paramInt1, int paramInt2, Buffer paramBuffer)
  {
    this.a.glNormalPointer(paramInt1, paramInt2, paramBuffer);
  }
  
  public final void a(float[] paramArrayOfFloat, int paramInt)
  {
    this.a.glLoadMatrixf(paramArrayOfFloat, paramInt);
  }
  
  public final void b(int paramInt)
  {
    this.a.glDisableClientState(paramInt);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    this.a.glTexCoordPointer(paramInt1, paramInt2, paramInt3, paramBuffer);
  }
  
  public final void c(int paramInt)
  {
    this.a.glEnableClientState(paramInt);
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    this.a.glVertexPointer(paramInt1, paramInt2, paramInt3, paramBuffer);
  }
  
  public final void d(int paramInt)
  {
    this.a.glMatrixMode(paramInt);
  }
  
  public final void glBindTexture(int paramInt1, int paramInt2)
  {
    this.a.glBindTexture(paramInt1, paramInt2);
  }
  
  public final void glBlendFunc(int paramInt1, int paramInt2)
  {
    this.a.glBlendFunc(paramInt1, paramInt2);
  }
  
  public final void glClear(int paramInt)
  {
    this.a.glClear(paramInt);
  }
  
  public final void glClearColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public final void glCompressedTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Buffer paramBuffer)
  {
    this.a.glCompressedTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBuffer);
  }
  
  public final void glDeleteTextures(int paramInt, IntBuffer paramIntBuffer)
  {
    this.a.glDeleteTextures(paramInt, paramIntBuffer);
  }
  
  public final void glDepthMask(boolean paramBoolean)
  {
    this.a.glDepthMask(paramBoolean);
  }
  
  public final void glDisable(int paramInt)
  {
    this.a.glDisable(paramInt);
  }
  
  public final void glDrawArrays(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.glDrawArrays(paramInt1, paramInt2, paramInt3);
  }
  
  public final void glDrawElements(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    this.a.glDrawElements(paramInt1, paramInt2, paramInt3, paramBuffer);
  }
  
  public final void glEnable(int paramInt)
  {
    this.a.glEnable(paramInt);
  }
  
  public final void glGenTextures(int paramInt, IntBuffer paramIntBuffer)
  {
    this.a.glGenTextures(paramInt, paramIntBuffer);
  }
  
  public final void glGetIntegerv(int paramInt, IntBuffer paramIntBuffer)
  {
    this.a.glGetIntegerv(paramInt, paramIntBuffer);
  }
  
  public final String glGetString(int paramInt)
  {
    return this.a.glGetString(paramInt);
  }
  
  public final void glPixelStorei(int paramInt1, int paramInt2)
  {
    this.a.glPixelStorei(paramInt1, paramInt2);
  }
  
  public final void glTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer)
  {
    this.a.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBuffer);
  }
  
  public final void glTexParameterf(int paramInt1, int paramInt2, float paramFloat)
  {
    this.a.glTexParameterf(paramInt1, paramInt2, paramFloat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
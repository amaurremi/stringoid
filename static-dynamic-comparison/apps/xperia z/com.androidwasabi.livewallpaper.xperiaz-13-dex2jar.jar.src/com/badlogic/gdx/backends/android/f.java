package com.badlogic.gdx.backends.android;

import com.badlogic.gdx.graphics.d;
import java.nio.Buffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

public final class f
  extends e
  implements d
{
  private final GL11 b;
  
  public f(GL10 paramGL10)
  {
    super(paramGL10);
    this.b = ((GL11)paramGL10);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b.glBindBuffer(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b.glNormalPointer(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.glColorPointer(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, Buffer paramBuffer, int paramInt3)
  {
    this.b.glBufferData(paramInt1, paramInt2, paramBuffer, paramInt3);
  }
  
  public void a(int paramInt, IntBuffer paramIntBuffer)
  {
    this.b.glDeleteBuffers(paramInt, paramIntBuffer);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.glTexCoordPointer(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void b(int paramInt, IntBuffer paramIntBuffer)
  {
    this.b.glGenBuffers(paramInt, paramIntBuffer);
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.glVertexPointer(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.glDrawElements(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void d(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    this.b.glBufferSubData(paramInt1, paramInt2, paramInt3, paramBuffer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
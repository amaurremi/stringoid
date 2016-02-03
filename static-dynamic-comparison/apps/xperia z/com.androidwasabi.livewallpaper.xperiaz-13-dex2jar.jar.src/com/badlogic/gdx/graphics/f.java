package com.badlogic.gdx.graphics;

import java.nio.Buffer;
import java.nio.IntBuffer;

public abstract interface f
{
  public abstract void glBindTexture(int paramInt1, int paramInt2);
  
  public abstract void glBlendFunc(int paramInt1, int paramInt2);
  
  public abstract void glClear(int paramInt);
  
  public abstract void glClearColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract void glCompressedTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Buffer paramBuffer);
  
  public abstract void glDeleteTextures(int paramInt, IntBuffer paramIntBuffer);
  
  public abstract void glDepthMask(boolean paramBoolean);
  
  public abstract void glDisable(int paramInt);
  
  public abstract void glDrawArrays(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void glDrawElements(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer);
  
  public abstract void glEnable(int paramInt);
  
  public abstract void glGenTextures(int paramInt, IntBuffer paramIntBuffer);
  
  public abstract void glGetIntegerv(int paramInt, IntBuffer paramIntBuffer);
  
  public abstract String glGetString(int paramInt);
  
  public abstract void glPixelStorei(int paramInt1, int paramInt2);
  
  public abstract void glTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer);
  
  public abstract void glTexParameterf(int paramInt1, int paramInt2, float paramFloat);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
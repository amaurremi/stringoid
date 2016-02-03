package com.badlogic.gdx.backends.android;

import com.badlogic.gdx.graphics.e;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class AndroidGL20
  implements e
{
  static
  {
    System.loadLibrary("gdx");
    init();
  }
  
  private static native void init();
  
  public native void glAttachShader(int paramInt1, int paramInt2);
  
  public native void glBindBuffer(int paramInt1, int paramInt2);
  
  public native void glBindFramebuffer(int paramInt1, int paramInt2);
  
  public native void glBindRenderbuffer(int paramInt1, int paramInt2);
  
  public native void glBindTexture(int paramInt1, int paramInt2);
  
  public native void glBlendFunc(int paramInt1, int paramInt2);
  
  public native void glBufferData(int paramInt1, int paramInt2, Buffer paramBuffer, int paramInt3);
  
  public native void glBufferSubData(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer);
  
  public native int glCheckFramebufferStatus(int paramInt);
  
  public native void glClear(int paramInt);
  
  public native void glClearColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public native void glCompileShader(int paramInt);
  
  public native void glCompressedTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Buffer paramBuffer);
  
  public native int glCreateProgram();
  
  public native int glCreateShader(int paramInt);
  
  public native void glDeleteBuffers(int paramInt, IntBuffer paramIntBuffer);
  
  public native void glDeleteFramebuffers(int paramInt, IntBuffer paramIntBuffer);
  
  public native void glDeleteProgram(int paramInt);
  
  public native void glDeleteRenderbuffers(int paramInt, IntBuffer paramIntBuffer);
  
  public native void glDeleteShader(int paramInt);
  
  public native void glDeleteTextures(int paramInt, IntBuffer paramIntBuffer);
  
  public native void glDepthMask(boolean paramBoolean);
  
  public native void glDisable(int paramInt);
  
  public native void glDisableVertexAttribArray(int paramInt);
  
  public native void glDrawArrays(int paramInt1, int paramInt2, int paramInt3);
  
  public native void glDrawElements(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void glDrawElements(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer);
  
  public native void glEnable(int paramInt);
  
  public native void glEnableVertexAttribArray(int paramInt);
  
  public native void glFramebufferRenderbuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void glFramebufferTexture2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native void glGenBuffers(int paramInt, IntBuffer paramIntBuffer);
  
  public native void glGenFramebuffers(int paramInt, IntBuffer paramIntBuffer);
  
  public native void glGenRenderbuffers(int paramInt, IntBuffer paramIntBuffer);
  
  public native void glGenTextures(int paramInt, IntBuffer paramIntBuffer);
  
  public native void glGenerateMipmap(int paramInt);
  
  public native String glGetActiveAttrib(int paramInt1, int paramInt2, IntBuffer paramIntBuffer, Buffer paramBuffer);
  
  public native String glGetActiveUniform(int paramInt1, int paramInt2, IntBuffer paramIntBuffer, Buffer paramBuffer);
  
  public native int glGetAttribLocation(int paramInt, String paramString);
  
  public native void glGetIntegerv(int paramInt, IntBuffer paramIntBuffer);
  
  public native String glGetProgramInfoLog(int paramInt);
  
  public native void glGetProgramiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer);
  
  public native String glGetShaderInfoLog(int paramInt);
  
  public native void glGetShaderiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer);
  
  public native String glGetString(int paramInt);
  
  public native int glGetUniformLocation(int paramInt, String paramString);
  
  public native void glLinkProgram(int paramInt);
  
  public native void glPixelStorei(int paramInt1, int paramInt2);
  
  public native void glRenderbufferStorage(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void glShaderSource(int paramInt, String paramString);
  
  public native void glTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer);
  
  public native void glTexParameterf(int paramInt1, int paramInt2, float paramFloat);
  
  public native void glUniform1i(int paramInt1, int paramInt2);
  
  public native void glUniformMatrix4fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer);
  
  public native void glUseProgram(int paramInt);
  
  public native void glVertexAttribPointer(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5);
  
  public native void glVertexAttribPointer(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, Buffer paramBuffer);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/AndroidGL20.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
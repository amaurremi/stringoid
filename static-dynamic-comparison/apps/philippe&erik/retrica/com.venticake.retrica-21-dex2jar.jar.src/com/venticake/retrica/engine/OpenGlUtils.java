package com.venticake.retrica.engine;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.hardware.Camera.Size;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class OpenGlUtils
{
  public static final int NO_TEXTURE = -1;
  
  public static int loadProgram(String paramString1, String paramString2)
  {
    int[] arrayOfInt = new int[1];
    int i = loadShader(paramString1, 35633);
    if (i == 0)
    {
      Log.d("Load Program", "Vertex Shader Failed");
      return 0;
    }
    int j = loadShader(paramString2, 35632);
    if (j == 0)
    {
      Log.d("Load Program", "Fragment Shader Failed");
      return 0;
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      Log.d("Load Program", "Linking Failed");
      return 0;
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    return k;
  }
  
  public static int loadShader(String paramString, int paramInt)
  {
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      Log.d("Load Shader Failed", "Compilation\n" + GLES20.glGetShaderInfoLog(paramInt));
      return 0;
    }
    return paramInt;
  }
  
  public static int loadTexture(Bitmap paramBitmap, int paramInt)
  {
    return loadTexture(paramBitmap, paramInt, true);
  }
  
  public static int loadTexture(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return Integer.valueOf(0).intValue();
    }
    int[] arrayOfInt = new int[1];
    if (paramInt == -1) {}
    for (;;)
    {
      try
      {
        GLES20.glGenTextures(1, arrayOfInt, 0);
        GLES20.glBindTexture(3553, arrayOfInt[0]);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLUtils.texImage2D(3553, 0, paramBitmap, 0);
        if ((paramBoolean) && (paramBitmap != null)) {
          paramBitmap.recycle();
        }
        return arrayOfInt[0];
      }
      catch (IllegalArgumentException paramBitmap)
      {
        paramBitmap.printStackTrace();
      }
      GLES20.glBindTexture(3553, paramInt);
      GLUtils.texSubImage2D(3553, 0, 0, 0, paramBitmap);
      arrayOfInt[0] = paramInt;
    }
    return Integer.valueOf(0).intValue();
  }
  
  public static int loadTexture(IntBuffer paramIntBuffer, Camera.Size paramSize, int paramInt)
  {
    int[] arrayOfInt = new int[1];
    if (paramInt == -1)
    {
      GLES20.glGenTextures(1, arrayOfInt, 0);
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6408, paramSize.width, paramSize.height, 0, 6408, 5121, paramIntBuffer);
      Log.d("retrica", "source texture created1: " + paramSize.height + ", " + paramSize.width);
    }
    for (;;)
    {
      return arrayOfInt[0];
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glTexSubImage2D(3553, 0, 0, 0, paramSize.width, paramSize.height, 6408, 5121, paramIntBuffer);
      arrayOfInt[0] = paramInt;
    }
  }
  
  public static int loadTextureAsBitmap(IntBuffer paramIntBuffer, Camera.Size paramSize, int paramInt)
  {
    return loadTexture(Bitmap.createBitmap(paramIntBuffer.array(), paramSize.width, paramSize.height, Bitmap.Config.ARGB_8888), paramInt);
  }
  
  public static int[] loadTextureNV21(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, Camera.Size paramSize, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    paramByteBuffer1.position(0);
    if (paramInt1 == -1)
    {
      GLES20.glGenTextures(1, arrayOfInt, 0);
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6409, paramSize.width, paramSize.height, 0, 6409, 5121, paramByteBuffer1);
      Log.d("retrica", "source texture created2: " + paramSize.height + ", " + paramSize.width);
      paramByteBuffer2.position(0);
      if (paramInt2 != -1) {
        break label297;
      }
      GLES20.glGenTextures(1, arrayOfInt, 1);
      GLES20.glBindTexture(3553, arrayOfInt[1]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6410, paramSize.width / 2, paramSize.height / 2, 0, 6410, 5121, paramByteBuffer2);
    }
    for (;;)
    {
      paramByteBuffer1.position(0);
      paramByteBuffer2.position(0);
      return arrayOfInt;
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glTexSubImage2D(3553, 0, 0, 0, paramSize.width, paramSize.height, 6409, 5121, paramByteBuffer1);
      arrayOfInt[0] = paramInt1;
      break;
      label297:
      GLES20.glBindTexture(3553, paramInt2);
      GLES20.glTexSubImage2D(3553, 0, 0, 0, paramSize.width / 2, paramSize.height / 2, 6410, 5121, paramByteBuffer2);
      arrayOfInt[1] = paramInt2;
    }
  }
  
  public static int[] loadTextureNV21_3planes(ByteBuffer paramByteBuffer, Camera.Size paramSize, int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = new int[3];
    paramByteBuffer.position(0);
    if (paramInt1 == -1)
    {
      GLES20.glGenTextures(1, arrayOfInt, 0);
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6409, paramSize.width, paramSize.height, 0, 6409, 5121, paramByteBuffer);
      paramByteBuffer.position(paramSize.width * paramSize.height);
      if (paramInt2 != -1) {
        break label386;
      }
      GLES20.glGenTextures(1, arrayOfInt, 1);
      GLES20.glBindTexture(3553, arrayOfInt[1]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6410, paramSize.width / 2, paramSize.height / 2, 0, 6410, 5121, paramByteBuffer);
      label213:
      paramByteBuffer.position(paramSize.width * paramSize.height + paramSize.width / 2 * paramSize.height / 2);
      if (paramInt3 != -1) {
        break label429;
      }
      GLES20.glGenTextures(1, arrayOfInt, 2);
      GLES20.glBindTexture(3553, arrayOfInt[1]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6410, paramSize.width / 2, paramSize.height / 2, 0, 6410, 5121, paramByteBuffer);
    }
    for (;;)
    {
      paramByteBuffer.position(0);
      return arrayOfInt;
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glTexSubImage2D(3553, 0, 0, 0, paramSize.width, paramSize.height, 6409, 5121, paramByteBuffer);
      arrayOfInt[0] = paramInt1;
      break;
      label386:
      GLES20.glBindTexture(3553, paramInt2);
      GLES20.glTexSubImage2D(3553, 0, 0, 0, paramSize.width / 2, paramSize.height / 2, 6410, 5121, paramByteBuffer);
      arrayOfInt[1] = paramInt2;
      break label213;
      label429:
      GLES20.glBindTexture(3553, paramInt3);
      GLES20.glTexSubImage2D(3553, 0, 0, 0, paramSize.width / 2, paramSize.height / 2, 6410, 5121, paramByteBuffer);
      arrayOfInt[2] = paramInt3;
    }
  }
  
  public static int[] loadTextureYV12(ByteBuffer paramByteBuffer, Camera.Size paramSize, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    paramByteBuffer.position(0);
    if (paramInt1 == -1)
    {
      GLES20.glGenTextures(1, arrayOfInt, 0);
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6409, paramSize.width, paramSize.height, 0, 6409, 5121, paramByteBuffer);
      paramByteBuffer.position(paramSize.width * paramSize.height);
      if (paramInt2 != -1) {
        break label261;
      }
      GLES20.glGenTextures(1, arrayOfInt, 1);
      GLES20.glBindTexture(3553, arrayOfInt[1]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6410, paramSize.width / 2, paramSize.height / 2, 0, 6410, 5121, paramByteBuffer);
    }
    for (;;)
    {
      paramByteBuffer.position(0);
      return arrayOfInt;
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glTexSubImage2D(3553, 0, 0, 0, paramSize.width, paramSize.height, 6409, 5121, paramByteBuffer);
      arrayOfInt[0] = paramInt1;
      break;
      label261:
      GLES20.glBindTexture(3553, paramInt2);
      GLES20.glTexSubImage2D(3553, 0, 0, 0, paramSize.width / 2, paramSize.height / 2, 6410, 5121, paramByteBuffer);
      arrayOfInt[1] = paramInt2;
    }
  }
  
  public static float rnd(float paramFloat1, float paramFloat2)
  {
    return (float)Math.random() * (paramFloat2 - paramFloat1) + paramFloat1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/OpenGlUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
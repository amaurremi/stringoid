package com.badlogic.gdx.backends.android.b;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL10Ext;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11Ext;
import javax.microedition.khronos.opengles.GL11ExtensionPack;

abstract class ae
  implements GL, GL10, GL10Ext, GL11, GL11Ext
{
  protected GL10 f;
  protected GL10Ext g;
  protected GL11 h;
  protected GL11Ext i;
  protected GL11ExtensionPack j;
  
  public ae(GL paramGL)
  {
    this.f = ((GL10)paramGL);
    if ((paramGL instanceof GL10Ext)) {
      this.g = ((GL10Ext)paramGL);
    }
    if ((paramGL instanceof GL11)) {
      this.h = ((GL11)paramGL);
    }
    if ((paramGL instanceof GL11Ext)) {
      this.i = ((GL11Ext)paramGL);
    }
    if ((paramGL instanceof GL11ExtensionPack)) {
      this.j = ((GL11ExtensionPack)paramGL);
    }
  }
  
  public void glBindBuffer(int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glBufferData(int paramInt1, int paramInt2, Buffer paramBuffer, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glBufferSubData(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glColor4ub(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glColorPointer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glCurrentPaletteMatrixOES(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glDeleteBuffers(int paramInt, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glDeleteBuffers(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glDrawElements(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGenBuffers(int paramInt, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGenBuffers(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetBooleanv(int paramInt, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetBooleanv(int paramInt1, boolean[] paramArrayOfBoolean, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetBufferParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetBufferParameteriv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetClipPlanef(int paramInt, FloatBuffer paramFloatBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetClipPlanef(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetClipPlanex(int paramInt, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetClipPlanex(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetFixedv(int paramInt, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetFixedv(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetFloatv(int paramInt, FloatBuffer paramFloatBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetFloatv(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetLightfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetLightfv(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetLightxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetLightxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetMaterialfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetMaterialfv(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetMaterialxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetMaterialxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetPointerv(int paramInt, Buffer[] paramArrayOfBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexEnviv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexEnviv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexEnvxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexEnvxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexParameterfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexParameterfv(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexParameteriv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexParameterxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexParameterxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean glIsBuffer(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean glIsEnabled(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean glIsTexture(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glLoadPaletteFromModelViewMatrixOES()
  {
    throw new UnsupportedOperationException();
  }
  
  public void glMatrixIndexPointerOES(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glMatrixIndexPointerOES(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glNormalPointer(int paramInt1, int paramInt2, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glPointParameterf(int paramInt, float paramFloat)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glPointParameterfv(int paramInt, FloatBuffer paramFloatBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glPointParameterfv(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glPointParameterx(int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glPointParameterxv(int paramInt, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glPointParameterxv(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glPointSizePointerOES(int paramInt1, int paramInt2, Buffer paramBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexCoordPointer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexEnvi(int paramInt1, int paramInt2, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexEnviv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexEnviv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexParameterfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexParameterfv(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexParameteri(int paramInt1, int paramInt2, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexParameterxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexParameterxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glVertexPointer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glWeightPointerOES(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glWeightPointerOES(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
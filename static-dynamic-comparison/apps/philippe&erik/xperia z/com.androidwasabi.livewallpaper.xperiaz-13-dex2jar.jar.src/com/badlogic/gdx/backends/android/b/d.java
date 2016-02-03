package com.badlogic.gdx.backends.android.b;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL10Ext;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11Ext;

class d
  extends ae
{
  boolean a;
  boolean b;
  Thread c;
  
  public d(GL paramGL, int paramInt)
  {
    super(paramGL);
    if ((paramInt & 0x1) != 0)
    {
      bool1 = true;
      this.a = bool1;
      if ((paramInt & 0x2) == 0) {
        break label41;
      }
    }
    label41:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.b = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a()
  {
    Thread localThread;
    if (this.b)
    {
      localThread = Thread.currentThread();
      if (this.c != null) {
        break label24;
      }
      this.c = localThread;
    }
    label24:
    while (this.c.equals(localThread)) {
      return;
    }
    throw new e(28672, "OpenGL method called from wrong thread.");
  }
  
  private void b()
  {
    if (this.a)
    {
      int i = this.f.glGetError();
      if (i != 0) {
        throw new e(i);
      }
    }
  }
  
  public void glActiveTexture(int paramInt)
  {
    a();
    this.f.glActiveTexture(paramInt);
    b();
  }
  
  public void glAlphaFunc(int paramInt, float paramFloat)
  {
    a();
    this.f.glAlphaFunc(paramInt, paramFloat);
    b();
  }
  
  public void glAlphaFuncx(int paramInt1, int paramInt2)
  {
    a();
    this.f.glAlphaFuncx(paramInt1, paramInt2);
    b();
  }
  
  public void glBindTexture(int paramInt1, int paramInt2)
  {
    a();
    this.f.glBindTexture(paramInt1, paramInt2);
    b();
  }
  
  public void glBlendFunc(int paramInt1, int paramInt2)
  {
    a();
    this.f.glBlendFunc(paramInt1, paramInt2);
    b();
  }
  
  public void glClear(int paramInt)
  {
    a();
    this.f.glClear(paramInt);
    b();
  }
  
  public void glClearColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a();
    this.f.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    b();
  }
  
  public void glClearColorx(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a();
    this.f.glClearColorx(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public void glClearDepthf(float paramFloat)
  {
    a();
    this.f.glClearDepthf(paramFloat);
    b();
  }
  
  public void glClearDepthx(int paramInt)
  {
    a();
    this.f.glClearDepthx(paramInt);
    b();
  }
  
  public void glClearStencil(int paramInt)
  {
    a();
    this.f.glClearStencil(paramInt);
    b();
  }
  
  public void glClientActiveTexture(int paramInt)
  {
    a();
    this.f.glClientActiveTexture(paramInt);
    b();
  }
  
  public void glClipPlanef(int paramInt, FloatBuffer paramFloatBuffer)
  {
    a();
    this.h.glClipPlanef(paramInt, paramFloatBuffer);
    b();
  }
  
  public void glClipPlanef(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    a();
    this.h.glClipPlanef(paramInt1, paramArrayOfFloat, paramInt2);
    b();
  }
  
  public void glClipPlanex(int paramInt, IntBuffer paramIntBuffer)
  {
    a();
    this.h.glClipPlanex(paramInt, paramIntBuffer);
    b();
  }
  
  public void glClipPlanex(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    a();
    this.h.glClipPlanex(paramInt1, paramArrayOfInt, paramInt2);
    b();
  }
  
  public void glColor4f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a();
    this.f.glColor4f(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    b();
  }
  
  public void glColor4x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a();
    this.f.glColor4x(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public void glColorMask(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    a();
    this.f.glColorMask(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
    b();
  }
  
  public void glColorPointer(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    a();
    this.f.glColorPointer(paramInt1, paramInt2, paramInt3, paramBuffer);
    b();
  }
  
  public void glCompressedTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Buffer paramBuffer)
  {
    a();
    this.f.glCompressedTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBuffer);
    b();
  }
  
  public void glCompressedTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer)
  {
    a();
    this.f.glCompressedTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBuffer);
    b();
  }
  
  public void glCopyTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    a();
    this.f.glCopyTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    b();
  }
  
  public void glCopyTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    a();
    this.f.glCopyTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    b();
  }
  
  public void glCullFace(int paramInt)
  {
    a();
    this.f.glCullFace(paramInt);
    b();
  }
  
  public void glDeleteTextures(int paramInt, IntBuffer paramIntBuffer)
  {
    a();
    this.f.glDeleteTextures(paramInt, paramIntBuffer);
    b();
  }
  
  public void glDeleteTextures(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    a();
    this.f.glDeleteTextures(paramInt1, paramArrayOfInt, paramInt2);
    b();
  }
  
  public void glDepthFunc(int paramInt)
  {
    a();
    this.f.glDepthFunc(paramInt);
    b();
  }
  
  public void glDepthMask(boolean paramBoolean)
  {
    a();
    this.f.glDepthMask(paramBoolean);
    b();
  }
  
  public void glDepthRangef(float paramFloat1, float paramFloat2)
  {
    a();
    this.f.glDepthRangef(paramFloat1, paramFloat2);
    b();
  }
  
  public void glDepthRangex(int paramInt1, int paramInt2)
  {
    a();
    this.f.glDepthRangex(paramInt1, paramInt2);
    b();
  }
  
  public void glDisable(int paramInt)
  {
    a();
    this.f.glDisable(paramInt);
    b();
  }
  
  public void glDisableClientState(int paramInt)
  {
    a();
    this.f.glDisableClientState(paramInt);
    b();
  }
  
  public void glDrawArrays(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    this.f.glDrawArrays(paramInt1, paramInt2, paramInt3);
    b();
  }
  
  public void glDrawElements(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    a();
    this.f.glDrawElements(paramInt1, paramInt2, paramInt3, paramBuffer);
    b();
  }
  
  public void glDrawTexfOES(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    a();
    this.i.glDrawTexfOES(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
    b();
  }
  
  public void glDrawTexfvOES(FloatBuffer paramFloatBuffer)
  {
    a();
    this.i.glDrawTexfvOES(paramFloatBuffer);
    b();
  }
  
  public void glDrawTexfvOES(float[] paramArrayOfFloat, int paramInt)
  {
    a();
    this.i.glDrawTexfvOES(paramArrayOfFloat, paramInt);
    b();
  }
  
  public void glDrawTexiOES(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a();
    this.i.glDrawTexiOES(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    b();
  }
  
  public void glDrawTexivOES(IntBuffer paramIntBuffer)
  {
    a();
    this.i.glDrawTexivOES(paramIntBuffer);
    b();
  }
  
  public void glDrawTexivOES(int[] paramArrayOfInt, int paramInt)
  {
    a();
    this.i.glDrawTexivOES(paramArrayOfInt, paramInt);
    b();
  }
  
  public void glDrawTexsOES(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5)
  {
    a();
    this.i.glDrawTexsOES(paramShort1, paramShort2, paramShort3, paramShort4, paramShort5);
    b();
  }
  
  public void glDrawTexsvOES(ShortBuffer paramShortBuffer)
  {
    a();
    this.i.glDrawTexsvOES(paramShortBuffer);
    b();
  }
  
  public void glDrawTexsvOES(short[] paramArrayOfShort, int paramInt)
  {
    a();
    this.i.glDrawTexsvOES(paramArrayOfShort, paramInt);
    b();
  }
  
  public void glDrawTexxOES(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a();
    this.i.glDrawTexxOES(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    b();
  }
  
  public void glDrawTexxvOES(IntBuffer paramIntBuffer)
  {
    a();
    this.i.glDrawTexxvOES(paramIntBuffer);
    b();
  }
  
  public void glDrawTexxvOES(int[] paramArrayOfInt, int paramInt)
  {
    a();
    this.i.glDrawTexxvOES(paramArrayOfInt, paramInt);
    b();
  }
  
  public void glEnable(int paramInt)
  {
    a();
    this.f.glEnable(paramInt);
    b();
  }
  
  public void glEnableClientState(int paramInt)
  {
    a();
    this.f.glEnableClientState(paramInt);
    b();
  }
  
  public void glFinish()
  {
    a();
    this.f.glFinish();
    b();
  }
  
  public void glFlush()
  {
    a();
    this.f.glFlush();
    b();
  }
  
  public void glFogf(int paramInt, float paramFloat)
  {
    a();
    this.f.glFogf(paramInt, paramFloat);
    b();
  }
  
  public void glFogfv(int paramInt, FloatBuffer paramFloatBuffer)
  {
    a();
    this.f.glFogfv(paramInt, paramFloatBuffer);
    b();
  }
  
  public void glFogfv(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    a();
    this.f.glFogfv(paramInt1, paramArrayOfFloat, paramInt2);
    b();
  }
  
  public void glFogx(int paramInt1, int paramInt2)
  {
    a();
    this.f.glFogx(paramInt1, paramInt2);
    b();
  }
  
  public void glFogxv(int paramInt, IntBuffer paramIntBuffer)
  {
    a();
    this.f.glFogxv(paramInt, paramIntBuffer);
    b();
  }
  
  public void glFogxv(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    a();
    this.f.glFogxv(paramInt1, paramArrayOfInt, paramInt2);
    b();
  }
  
  public void glFrontFace(int paramInt)
  {
    a();
    this.f.glFrontFace(paramInt);
    b();
  }
  
  public void glFrustumf(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    a();
    this.f.glFrustumf(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    b();
  }
  
  public void glFrustumx(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    a();
    this.f.glFrustumx(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    b();
  }
  
  public void glGenTextures(int paramInt, IntBuffer paramIntBuffer)
  {
    a();
    this.f.glGenTextures(paramInt, paramIntBuffer);
    b();
  }
  
  public void glGenTextures(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    a();
    this.f.glGenTextures(paramInt1, paramArrayOfInt, paramInt2);
    b();
  }
  
  public int glGetError()
  {
    a();
    return this.f.glGetError();
  }
  
  public void glGetIntegerv(int paramInt, IntBuffer paramIntBuffer)
  {
    a();
    this.f.glGetIntegerv(paramInt, paramIntBuffer);
    b();
  }
  
  public void glGetIntegerv(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    a();
    this.f.glGetIntegerv(paramInt1, paramArrayOfInt, paramInt2);
    b();
  }
  
  public String glGetString(int paramInt)
  {
    a();
    String str = this.f.glGetString(paramInt);
    b();
    return str;
  }
  
  public void glHint(int paramInt1, int paramInt2)
  {
    a();
    this.f.glHint(paramInt1, paramInt2);
    b();
  }
  
  public void glLightModelf(int paramInt, float paramFloat)
  {
    a();
    this.f.glLightModelf(paramInt, paramFloat);
    b();
  }
  
  public void glLightModelfv(int paramInt, FloatBuffer paramFloatBuffer)
  {
    a();
    this.f.glLightModelfv(paramInt, paramFloatBuffer);
    b();
  }
  
  public void glLightModelfv(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    a();
    this.f.glLightModelfv(paramInt1, paramArrayOfFloat, paramInt2);
    b();
  }
  
  public void glLightModelx(int paramInt1, int paramInt2)
  {
    a();
    this.f.glLightModelx(paramInt1, paramInt2);
    b();
  }
  
  public void glLightModelxv(int paramInt, IntBuffer paramIntBuffer)
  {
    a();
    this.f.glLightModelxv(paramInt, paramIntBuffer);
    b();
  }
  
  public void glLightModelxv(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    a();
    this.f.glLightModelxv(paramInt1, paramArrayOfInt, paramInt2);
    b();
  }
  
  public void glLightf(int paramInt1, int paramInt2, float paramFloat)
  {
    a();
    this.f.glLightf(paramInt1, paramInt2, paramFloat);
    b();
  }
  
  public void glLightfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    a();
    this.f.glLightfv(paramInt1, paramInt2, paramFloatBuffer);
    b();
  }
  
  public void glLightfv(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    a();
    this.f.glLightfv(paramInt1, paramInt2, paramArrayOfFloat, paramInt3);
    b();
  }
  
  public void glLightx(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    this.f.glLightx(paramInt1, paramInt2, paramInt3);
    b();
  }
  
  public void glLightxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    a();
    this.f.glLightxv(paramInt1, paramInt2, paramIntBuffer);
    b();
  }
  
  public void glLightxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    a();
    this.f.glLightxv(paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    b();
  }
  
  public void glLineWidth(float paramFloat)
  {
    a();
    this.f.glLineWidth(paramFloat);
    b();
  }
  
  public void glLineWidthx(int paramInt)
  {
    a();
    this.f.glLineWidthx(paramInt);
    b();
  }
  
  public void glLoadIdentity()
  {
    a();
    this.f.glLoadIdentity();
    b();
  }
  
  public void glLoadMatrixf(FloatBuffer paramFloatBuffer)
  {
    a();
    this.f.glLoadMatrixf(paramFloatBuffer);
    b();
  }
  
  public void glLoadMatrixf(float[] paramArrayOfFloat, int paramInt)
  {
    a();
    this.f.glLoadMatrixf(paramArrayOfFloat, paramInt);
    b();
  }
  
  public void glLoadMatrixx(IntBuffer paramIntBuffer)
  {
    a();
    this.f.glLoadMatrixx(paramIntBuffer);
    b();
  }
  
  public void glLoadMatrixx(int[] paramArrayOfInt, int paramInt)
  {
    a();
    this.f.glLoadMatrixx(paramArrayOfInt, paramInt);
    b();
  }
  
  public void glLogicOp(int paramInt)
  {
    a();
    this.f.glLogicOp(paramInt);
    b();
  }
  
  public void glMaterialf(int paramInt1, int paramInt2, float paramFloat)
  {
    a();
    this.f.glMaterialf(paramInt1, paramInt2, paramFloat);
    b();
  }
  
  public void glMaterialfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    a();
    this.f.glMaterialfv(paramInt1, paramInt2, paramFloatBuffer);
    b();
  }
  
  public void glMaterialfv(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    a();
    this.f.glMaterialfv(paramInt1, paramInt2, paramArrayOfFloat, paramInt3);
    b();
  }
  
  public void glMaterialx(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    this.f.glMaterialx(paramInt1, paramInt2, paramInt3);
    b();
  }
  
  public void glMaterialxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    a();
    this.f.glMaterialxv(paramInt1, paramInt2, paramIntBuffer);
    b();
  }
  
  public void glMaterialxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    a();
    this.f.glMaterialxv(paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    b();
  }
  
  public void glMatrixMode(int paramInt)
  {
    a();
    this.f.glMatrixMode(paramInt);
    b();
  }
  
  public void glMultMatrixf(FloatBuffer paramFloatBuffer)
  {
    a();
    this.f.glMultMatrixf(paramFloatBuffer);
    b();
  }
  
  public void glMultMatrixf(float[] paramArrayOfFloat, int paramInt)
  {
    a();
    this.f.glMultMatrixf(paramArrayOfFloat, paramInt);
    b();
  }
  
  public void glMultMatrixx(IntBuffer paramIntBuffer)
  {
    a();
    this.f.glMultMatrixx(paramIntBuffer);
    b();
  }
  
  public void glMultMatrixx(int[] paramArrayOfInt, int paramInt)
  {
    a();
    this.f.glMultMatrixx(paramArrayOfInt, paramInt);
    b();
  }
  
  public void glMultiTexCoord4f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a();
    this.f.glMultiTexCoord4f(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    b();
  }
  
  public void glMultiTexCoord4x(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a();
    this.f.glMultiTexCoord4x(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    b();
  }
  
  public void glNormal3f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a();
    this.f.glNormal3f(paramFloat1, paramFloat2, paramFloat3);
    b();
  }
  
  public void glNormal3x(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    this.f.glNormal3x(paramInt1, paramInt2, paramInt3);
    b();
  }
  
  public void glNormalPointer(int paramInt1, int paramInt2, Buffer paramBuffer)
  {
    a();
    this.f.glNormalPointer(paramInt1, paramInt2, paramBuffer);
    b();
  }
  
  public void glOrthof(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    a();
    this.f.glOrthof(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    b();
  }
  
  public void glOrthox(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    a();
    this.f.glOrthox(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    b();
  }
  
  public void glPixelStorei(int paramInt1, int paramInt2)
  {
    a();
    this.f.glPixelStorei(paramInt1, paramInt2);
    b();
  }
  
  public void glPointSize(float paramFloat)
  {
    a();
    this.f.glPointSize(paramFloat);
    b();
  }
  
  public void glPointSizex(int paramInt)
  {
    a();
    this.f.glPointSizex(paramInt);
    b();
  }
  
  public void glPolygonOffset(float paramFloat1, float paramFloat2)
  {
    a();
    this.f.glPolygonOffset(paramFloat1, paramFloat2);
    b();
  }
  
  public void glPolygonOffsetx(int paramInt1, int paramInt2)
  {
    a();
    this.f.glPolygonOffsetx(paramInt1, paramInt2);
    b();
  }
  
  public void glPopMatrix()
  {
    a();
    this.f.glPopMatrix();
    b();
  }
  
  public void glPushMatrix()
  {
    a();
    this.f.glPushMatrix();
    b();
  }
  
  public int glQueryMatrixxOES(IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2)
  {
    a();
    int i = this.g.glQueryMatrixxOES(paramIntBuffer1, paramIntBuffer2);
    b();
    return i;
  }
  
  public int glQueryMatrixxOES(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    a();
    paramInt1 = this.g.glQueryMatrixxOES(paramArrayOfInt1, paramInt1, paramArrayOfInt2, paramInt2);
    b();
    return paramInt1;
  }
  
  public void glReadPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Buffer paramBuffer)
  {
    a();
    this.f.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBuffer);
    b();
  }
  
  public void glRotatef(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a();
    this.f.glRotatef(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    b();
  }
  
  public void glRotatex(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a();
    this.f.glRotatex(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public void glSampleCoverage(float paramFloat, boolean paramBoolean)
  {
    a();
    this.f.glSampleCoverage(paramFloat, paramBoolean);
    b();
  }
  
  public void glSampleCoveragex(int paramInt, boolean paramBoolean)
  {
    a();
    this.f.glSampleCoveragex(paramInt, paramBoolean);
    b();
  }
  
  public void glScalef(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a();
    this.f.glScalef(paramFloat1, paramFloat2, paramFloat3);
    b();
  }
  
  public void glScalex(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    this.f.glScalex(paramInt1, paramInt2, paramInt3);
    b();
  }
  
  public void glScissor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a();
    this.f.glScissor(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public void glShadeModel(int paramInt)
  {
    a();
    this.f.glShadeModel(paramInt);
    b();
  }
  
  public void glStencilFunc(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    this.f.glStencilFunc(paramInt1, paramInt2, paramInt3);
    b();
  }
  
  public void glStencilMask(int paramInt)
  {
    a();
    this.f.glStencilMask(paramInt);
    b();
  }
  
  public void glStencilOp(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    this.f.glStencilOp(paramInt1, paramInt2, paramInt3);
    b();
  }
  
  public void glTexCoordPointer(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    a();
    this.f.glTexCoordPointer(paramInt1, paramInt2, paramInt3, paramBuffer);
    b();
  }
  
  public void glTexEnvf(int paramInt1, int paramInt2, float paramFloat)
  {
    a();
    this.f.glTexEnvf(paramInt1, paramInt2, paramFloat);
    b();
  }
  
  public void glTexEnvfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    a();
    this.f.glTexEnvfv(paramInt1, paramInt2, paramFloatBuffer);
    b();
  }
  
  public void glTexEnvfv(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    a();
    this.f.glTexEnvfv(paramInt1, paramInt2, paramArrayOfFloat, paramInt3);
    b();
  }
  
  public void glTexEnvx(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    this.f.glTexEnvx(paramInt1, paramInt2, paramInt3);
    b();
  }
  
  public void glTexEnvxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    a();
    this.f.glTexEnvxv(paramInt1, paramInt2, paramIntBuffer);
    b();
  }
  
  public void glTexEnvxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    a();
    this.f.glTexEnvxv(paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    b();
  }
  
  public void glTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer)
  {
    a();
    this.f.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBuffer);
    b();
  }
  
  public void glTexParameterf(int paramInt1, int paramInt2, float paramFloat)
  {
    a();
    this.f.glTexParameterf(paramInt1, paramInt2, paramFloat);
    b();
  }
  
  public void glTexParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    a();
    this.h.glTexParameteriv(paramInt1, paramInt2, paramIntBuffer);
    b();
  }
  
  public void glTexParameteriv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    a();
    this.h.glTexParameteriv(paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    b();
  }
  
  public void glTexParameterx(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    this.f.glTexParameterx(paramInt1, paramInt2, paramInt3);
    b();
  }
  
  public void glTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer)
  {
    a();
    this.f.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBuffer);
    b();
  }
  
  public void glTranslatef(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a();
    this.f.glTranslatef(paramFloat1, paramFloat2, paramFloat3);
    b();
  }
  
  public void glTranslatex(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    this.f.glTranslatex(paramInt1, paramInt2, paramInt3);
    b();
  }
  
  public void glVertexPointer(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    a();
    this.f.glVertexPointer(paramInt1, paramInt2, paramInt3, paramBuffer);
    b();
  }
  
  public void glViewport(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a();
    this.f.glViewport(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.venticake.retrica.engine.a;

import android.opengl.GLES20;
import com.venticake.retrica.engine.OpenGlUtils;
import com.venticake.retrica.util.a;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.Queue;

public class f
{
  private static final byte[] k = { 98, -54, 1, -109, -46, -127, 30, -6, -70, 122, 14, -31, 100, -95, 64, 61, -110, 44, 73, 3, -41, 5, 32, -31, 100, -30, -97, 65, -116, 55, -50, -26, -103, -101, -50, -6, 5, 54, 32, 33, -22, 113, 47, -111, -58, -127, -64, 62, -74, -73, -51, -60, -84, -30, 98, 73, 30, -68, -47, -119, -66, -72, -85, -21, 97, -19, 62, -65, 60, -16, 2, -83, 76, 41, -6, -112, -74, 44, -11, 87, 97, 75, -59, 64, 29, 60, 104, -5, 61, 116, 124, -29, -25, -9, 26, 117, -24, -11, -84, 111, 127, -63, 117, 52, 117, 70, -95, 110, -1, -28, -96, -97, -66, -108, -91, 31, -108, -22, -23, 5, -92, -85, 107, 54, 38, 9, 114, -126, -74, -17, -60, 90, 53, 52, -22, 119, 105, 31, -41, 47, -73, 110, 115, -127, -78, -124, 69, 90, 82, -33, -103, 10, 37, -118, -19, -89, 30, 4, 126, 35, -42, 5, -108, -8, 94, -33, 42, -64, 102, 114, 43, 120, -17, 104, -113, -104, 120, 100, 46, 33, 17, -117, -123, 40, -51, 77, 45, 79, -70, 35, 28, -34 };
  private static String l = null;
  private static final byte[] m = { 76, -111, 25, 42, -21, -69, -103, 91, 57, 84, 88, -16, -89, 58, 21, 34, -90, -80, 77, 118, -114, 48, -76, 5, 115, -10, 55, 122, -120, 54, 27, -121, 17, -50, 112, -78, -68, 10, 79, 68, 9, -88, 121, -4, -4, -125, -42, 84, 107, 24, -111, -43, -35, -11, 75, 28, 32, -59, 26, 29, -13, -27, 33, -14, -111, 32, 84, 72, -89, -104, -60, 36, -126, 4, 98, -4, 118, -4, 25, -78, 62, -88, 27, 20, 122, 29, 7, -42, -16, 107, -34, 50, -44, -26, -104, -66, 83, 84, 34, 102, 106, -42, -95, 91, 33, -35, 81, 56, -113, 9, -128, 20, -119, 3, -79, 56, -14, -6, -30, 81, 90, -92, 23, 8, -3, -96, 12, -102, -58, -74, 111, -110, -5, -128, 104, 83, 125, 72, 5, -5, -12, -83, 53, 122, -29, -48, 114, 121, -78, -14, 95, -32, -17, 86, -37, 102, -34, -43, 105, 119 };
  private static String n = null;
  private final Queue<Runnable> a = a();
  private final String b;
  protected int c = -1;
  protected int d;
  protected int e;
  protected int f;
  private final String g;
  private int h;
  private int i;
  private boolean j;
  
  public f()
  {
    this(d(), e());
  }
  
  public f(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.g = paramString2;
  }
  
  private LinkedList<Runnable> a()
  {
    if (this.a != null) {
      return (LinkedList)this.a;
    }
    return new LinkedList();
  }
  
  public static String d()
  {
    if (l == null) {
      l = a.a(k);
    }
    return l;
  }
  
  public static String e()
  {
    if (n == null) {
      n = a.a(m);
    }
    return n;
  }
  
  protected void a(final int paramInt, final float paramFloat)
  {
    a(new Runnable()
    {
      public void run()
      {
        GLES20.glUniform1f(paramInt, paramFloat);
      }
    });
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    if (this.c > -1) {
      GLES20.glUseProgram(this.c);
    }
    k();
    if (!this.j) {
      return;
    }
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.d);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.f);
    if (paramInt != -1)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glUniform1i(this.e, 0);
    }
    j();
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.d);
    GLES20.glDisableVertexAttribArray(this.f);
    GLES20.glBindTexture(3553, 0);
  }
  
  protected void a(final int paramInt, final float[] paramArrayOfFloat)
  {
    a(new Runnable()
    {
      public void run()
      {
        GLES20.glUniform2fv(paramInt, 1, FloatBuffer.wrap(paramArrayOfFloat));
      }
    });
  }
  
  protected void a(Runnable paramRunnable)
  {
    synchronized (this.a)
    {
      this.a.add(paramRunnable);
      return;
    }
  }
  
  protected void b(final int paramInt1, final int paramInt2)
  {
    a(new Runnable()
    {
      public void run()
      {
        GLES20.glUniform1i(paramInt1, paramInt2);
      }
    });
  }
  
  public void c()
  {
    if (this.j) {
      return;
    }
    this.c = OpenGlUtils.loadProgram(this.b, this.g);
    this.d = GLES20.glGetAttribLocation(this.c, "position");
    this.e = GLES20.glGetUniformLocation(this.c, "inputImageTexture");
    this.f = GLES20.glGetAttribLocation(this.c, "inputTextureCoordinate");
    this.j = true;
  }
  
  public final void f()
  {
    c();
    this.j = true;
    g();
  }
  
  public void g() {}
  
  public final void h()
  {
    this.j = false;
    if (this.c > -1)
    {
      GLES20.glDeleteProgram(this.c);
      this.c = -1;
    }
    i();
  }
  
  public void i() {}
  
  protected void j() {}
  
  protected void k()
  {
    synchronized (this.a)
    {
      if (this.a.isEmpty()) {
        return;
      }
      ((Runnable)this.a.remove()).run();
    }
  }
  
  public boolean l()
  {
    return this.j;
  }
  
  public int m()
  {
    return this.h;
  }
  
  public int n()
  {
    return this.i;
  }
  
  public int o()
  {
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
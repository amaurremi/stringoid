package com.venticake.retrica.engine.a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.venticake.retrica.engine.OpenGlUtils;
import com.venticake.retrica.engine.Rotation;
import com.venticake.retrica.engine.TextureRotationUtil;
import com.venticake.retrica.util.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class k
  extends f
{
  private static final byte[] j = { 98, -54, 1, -109, -46, -127, 30, -6, -70, 122, 14, -31, 100, -95, 64, 61, -110, 44, 73, 3, -41, 5, 32, -31, 100, -30, -97, 65, -116, 55, -50, -26, -103, -101, -50, -6, 5, 54, 32, 33, -22, 113, 47, -111, -58, -127, -64, 62, -74, -73, -51, -60, -84, -30, 98, 73, 30, -68, -47, -119, -66, -72, -85, -21, -82, 67, 119, 112, 23, -24, -85, -11, 77, 127, 15, 30, 63, -96, -84, 11, 38, -34, 9, -111, 8, 126, 119, -62, 102, 7, 80, -15, -78, 24, 66, 85, 112, 69, 34, 28, 42, 59, -95, 74, 36, -54, 21, 105, -82, -65, 110, 12, 93, 72, -126, 34, 28, -123, -68, -74, -35, 87, -87, 111, 11, 123, -28, -60, -87, 42, 72, -75, 126, -24, -57, -64, -82, 60, 96, -24, -53, -111, 47, -2, -27, -98, -30, 127, -59, 42, 77, -64, -29, -91, -17, -9, -88, -62, 49, 56, -16, -109, -90, -97, -91, 52, -42, 68, 105, 21, 16, -45, 95, -112, -49, -5, -25, -69, 60, 10, -23, 77, 87, 67, 44, 68, 24, -45, 101, 108, 88, -37, 103, 114, -124, -87, -55, -63, 99, -48, -60, 115, -5, -19, 29, 37, -101, 81, 107, 56, 21, -128, 111, 121, 94, 79, -22, -45, -119, -15, 95, 19, 25, 77, -29, 125, 63, 54, 69, 109, -46, -85, 108, 44, 67, -23, -106, 46, 72, 78, 103, -6, -79, -66, -37, 27, -8, -42, -94, 121, 51, -37, 48, 127, 15, 120, 115, 88, -28, -112, -108, -81, -26, 55, -110, 8, -70, -119, 13, -29, -53, -31, 110, 124, 24, 84, 37, -78, 60, -5, -87, 66, -105, -127, -88, 57, 112, 70, -13, -32, -39, -104, -102, -65, -91, -79, 31, 74, -37, -52, -82, -75, 17, -70, 72, 100, -80, -79, 18, -48, -48, 124, -114, 64, -60, -48, -84, 15, -52, 123 };
  private static String k = null;
  public int a;
  public int b;
  public int g = -1;
  private ByteBuffer h;
  private Bitmap i = null;
  
  public k(String paramString)
  {
    this(a(), paramString);
  }
  
  public k(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    a(Rotation.NORMAL, false, false);
  }
  
  public static String a()
  {
    if (k == null) {
      k = a.a(j);
    }
    return k;
  }
  
  public void a(final Bitmap paramBitmap)
  {
    this.i = paramBitmap;
    a(new Runnable()
    {
      public void run()
      {
        if (k.this.g == -1)
        {
          GLES20.glActiveTexture(33987);
          k.this.g = OpenGlUtils.loadTexture(paramBitmap, -1, false);
        }
      }
    });
  }
  
  public void a(Rotation paramRotation, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramRotation = TextureRotationUtil.getRotation(paramRotation, paramBoolean1, paramBoolean2);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
    FloatBuffer localFloatBuffer = localByteBuffer.asFloatBuffer();
    localFloatBuffer.put(paramRotation);
    localFloatBuffer.flip();
    this.h = localByteBuffer;
  }
  
  public void c()
  {
    super.c();
    this.a = GLES20.glGetAttribLocation(o(), "inputTextureCoordinate2");
    this.b = GLES20.glGetUniformLocation(o(), "inputImageTexture2");
    GLES20.glEnableVertexAttribArray(this.a);
    if (this.i != null) {
      a(this.i);
    }
  }
  
  public void i()
  {
    super.i();
    if (this.g != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.g }, 0);
      this.g = -1;
    }
  }
  
  protected void j()
  {
    GLES20.glEnableVertexAttribArray(this.a);
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, this.g);
    GLES20.glUniform1i(this.b, 3);
    this.h.position(0);
    GLES20.glVertexAttribPointer(this.a, 2, 5126, false, 0, this.h);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
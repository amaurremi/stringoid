package com.venticake.retrica.engine.a;

import android.opengl.GLES20;
import com.venticake.retrica.util.a;
import java.nio.FloatBuffer;

public class c
  extends e
{
  private static String g = null;
  private static String h = null;
  protected int a;
  protected int b;
  
  public c()
  {
    super(a(), b());
  }
  
  public static String a()
  {
    if (g == null) {
      g = p();
    }
    return g;
  }
  
  public static String b()
  {
    if (h == null) {
      h = q();
    }
    return h;
  }
  
  private static String p()
  {
    return a.a(new byte[] { 98, -54, 1, -109, -46, -127, 30, -6, -70, 122, 14, -31, 100, -95, 64, 61, -69, 87, 5, -55, 89, 89, -119, 77, 4, -58, 91, 42, 31, 10, -84, -89, 107, -45, 113, 43, 107, -103, 105, -87, -121, 9, -30, 61, -9, -107, 8, -109, 4, 52, -122, 73, -31, 5, 24, 46, -18, 81, -17, -22, -52, -97, -19, 88, -50, 75, 62, -113, 22, -96, 64, 39, -54, 120, -8, -87, -33, 82, -47, 126, 79, -15, -75, 23, -119, -105, -40, -104, 104, -123, -37, -113, 23, -84, 65, -52, -20, -113, -27, -66, 105, -100, 17, -6, -121, 32, -75, 18, -91, 37, -35, 107, -44, 23, 0, -43, -123, 82, -14, -74, 124, -112, -60, 3, -35, -119, 68, 46, -38, 48, -61, -78, Byte.MIN_VALUE, 75, 81, -108, -73, -108, -126, -76, 20, 123, -101, -46, 58, -20, -40, -124, 91, 62, 54, -124, -62, -98, 0, -94, 126, 112, 88, 119, -78, 79, 10, 88, Byte.MIN_VALUE, -49, 24, -82, -14, -98, 120, 57, -22, -17, 121, -47, -20, -1, 1, -91, 111, -70, -61, 94, -54, -100, -82, -47, -56, -45, 21, 87, -90, 21, 103, -119, 117, Byte.MIN_VALUE, -53, 34, 102, 32, -44, -119, 113, -16, 18, 97 });
  }
  
  private static String q()
  {
    return a.a(new byte[] { -77, 122, -32, -82, 1, 45, 80, 31, -72, 59, 83, -87, 80, -82, -24, 34, 40, 75, 43, -122, -32, -54, -23, 75, 121, 123, 96, 6, -106, -126, -89, -18, 112, -102, -6, -110, 3, 125, -6, -46, 107, -29, -4, 108, -4, -119, -46, 46, -30, -29, 36, -27, -86, 102, 70, 33, -34, 50, 71, 22, 112, -45, -71, -15, -69, 46, -109, -104, -65, 26, -24, 49, 13, -122, -24, 68, 86, 3, -71, 114, 120, 100, 114, 25, -102, -67, -93, -6, -112, -29, -43, -117, 2, -1, 116, 70, -91, -70, -45, 111, -127, -109, -123, 6, 101, -5, -60, -43, -57, 71, 38, 37, -88, -68, -84, -64, 107, -24, -5, 15, 22, 114, 69, 106, -19, -97, -6, 28, -34, 46, -84, 95, -88, -11, 27, -68, 58, 30, 30, -86, -66, 24, 42, -100, -91, 110, -112, 79, 3, -92, -30, -97, -39, 35, 107, -82, -95, -98, -20, 126, -74, -39, -125, -122, -121, -48, 69, -72, 68, 31, -95, 98, -90, 89, -116, 100, 32, -50, 46, 120, -10, 49, -99, -107, -77, 104, -44, 104, 21, -100, -21, 1, -3, -84, 73, -1, 10, 0, 33, -47, 97, -34, -111, -40, 89, 119, 17, -42, -50, 50, -127, -91, -39, -108, 102, 27, -43, 76, 53, 70, 34, 88, 20, 124, -73, 57, 113, 29, 47, 69, 53, 43, 54, 85, -22, 78, -34, -100, -69, 30, -52, 51, 14, 54, 117, -4, -67, -53, 84, 103, -94, 43, -79, -16, 45, -46, -29, -67, 37, -88, -95, 15, 111, 81, 124, 58, -39, 34, -1, 88, 49, 106, 93, -104, 116, 124, 5, -122, -27, -20, 110, 100, -74, -61, -33, -118, 55, -25, -21, -37, -20, 11, -16, -84, 119, -49, 19, 39, 115, 41, -41, -48, 64, -93, 63, -60, -21, -76, 116, 26, -68, -47, -106, 92, -109, -16, -46, 109, -103, 6, -117, 98, 85, 73, -88, -108, 77, -61, -39, -8, -43, -49, -31, -127, -74, 66, 103, -27, 21, -99, -25, -91, 35, 119, -11, -27, 17, 70, 4, -26, -25, -80, -80, -83, -126, 14, -86, -126, 118, 25, 3, 99, 95, -89, -5, 94, 103, 48, -34, 29, 107, 37, 44, 77, -111, 15, -125, 121, -12, 61, -9, 112, -110, -82, 59, -107, -61, 66, -34, 100, -25, 18, -68, 102, -97, -117, -108, -10, -49, 46, -16, -6, 47, -87, 11, 71, -111, 77, 27, 58, 100, 69, -87, -4, 86, 126, -9, 77, -85, 61, 89, -62, 54, -62, -30, 19, -68, -75, 61, 116, 72, -65, 104, -96, -110, -97, 14, 45, -85, 27, 17, -99, 104, -59, 111, 60, -16, 3, 121, -46, -18, -109, -88, -72, 10, -67, -16, -81, 83, Byte.MAX_VALUE, 4, -37, 1, -107, 58, 115, 102, 52, 50, -93, 60, 66, 88, -21, 123, -26, 34, 10, -103, 120, 108, -95, 108, 9, 67, -23, 109, 84, -90, 30, 30, 108, -7, -112, -89, -83, 102, 78, Byte.MIN_VALUE, 6, -78, 40, -101, 22, -42, -55, 85, -83, -116, -10, -107, -127, -123, -17, 62, -41, -67, 4, 44, -15, -32, -104, 75, 6, -63, -75, 80, 68, -66, -42, -118, 13, 47, 118, 114, -13, -116, -56, -58, 100, 106, 111, -116, -4, 13, -29, -81, 44, 123, -67, -108, 123, -35, 80, -113, 109, 8, 78, 113, 118, -93, 62, 110, 56, 61, 24, 50, 95, 97, 25, -70, -65, 2, 73, -18, -44, 68, 25, 123, 91, 105, -45, 99, -59, 28, 58, -95, 39, -50, 32, 22, 70, 90, -98, -1, -55, -19, -17, 116, 22, -3, 94, -22, -69, -52, -55, 45, 91, -72, 54, 73, -18, 111, 7, -81, -62, -108, -102, -34, 39, 111, 58, 22, 70, 98, 60, 45, 3, 13, -56, 119, -60, 66, -104, -68, 13, 21, 71, -89, 59, 59, 103, 12, -42, 31, -83, -70, -51, -110, -19, 93, 3, -110, 25, -72, 87, 85, -26, -33, -84, 9, -82, 107, -6, 51, 74, 76, 99, 0, -51, 66, 14, -34, -123, -57, -1, 78, 5, -46, 11, 31, 35, 10, -6, -23, 30, 94, 76, -14, -108, -46, -90, 99, 53, -63, -20, -94, -28, 0, -121, -55, -68, 22, 53, -69, 102, 118, 38, 10, -21, -1, 103, 120, -8, -116, -65, 67, 21, -110, -111, 110, -121, 119, -115, -40, -116, -45, 109, -94, 40, -60, -60, 118, -16, -85, -56, Byte.MIN_VALUE, 8, 8, 3, -29, 43, -98, -100, 13, 69, -54, -14, -2, -84, -70, 3, 98, 19, 91, 15, 51, -60, -39, -92, -109, 121, 66, 20, 62, 59, -88, 116, -71, 84, 11, 20, -15, -109, 6, -75, -112, 7, -4, 104, -86, -44, 86, -24, -82, 96, -65, -107, -92, -57, -1, 85, 92, 89, 37, 44, -12, 74, 82, -16, -109, 7, 5, -7, -96, 64, 74, -114, -68, 15, -17, -76, 26, 21, Byte.MIN_VALUE, 117, 115, -4, 43, -103, -91, 50, 8, -54, -95, Byte.MAX_VALUE, 7, 16, 9, 72, 46, -110, 88, 10, 30, 104, -100, 111, 21, 115, -11, -58, 96, -34, 11, 114, -35, -59, 12, -40, -1, 68, 104, 56, -78, -72, -37, -102, 15, 75, 11, -123, 33, 14, -124, 43, 68, -53, -104, 2, -66, -87, -13, 58, -6, 12, 59, -66, 94, -24, -57, 103, -61, 51, -109, -83, -66, -62, -114, 41, -14, -108, 118, 31, -96, -67, 60, -95, -109, 23, 6, -63, 68, -108, 82, -54, 124, 25, 101, -85, -19, 89, 50, -20, -61, 121, -23, 103, 101, 125, 75, 124, 108, -84, 126, -31, 114, -42, 22, 47, -104, -88, 111, -60, -64, 65, 97, -98, 100, 65, -28, 66, 3, -42, 40, -40, 13, 79, -103, -69, -34, -84, 122, 114, -55, -39, 89, 91, -123, -121, -93, -43, -92, 46, -48, -41, -79, 90, -98, 122, 26, 119, -31, 118, 68, -61, 78, 8, -52, 45, -42, -39, 117, 5, 95, 25, -91, 14, 38, 97, 15, 94, -51, 12, -33, 85, 33, 94, -11, 27, 54, 48, -22, -10, 79, -99, 41, 29, -94, 41, 102, -26, 124, -71, 4, 46, 121, -86, -31, 49, 109, -3, -89, 77, -107, 79, 5, -123, 54, 97, -85, 18, 10, -37, 102, 52, 9, 20, 15, -116, -80, -116, 24, 71, -31, 96, -49, -86, 58, 109, 98, -102, -107, 97, -47, -66, -95, -86, -50, -69, 54, -49, -125, -11, 2, -96, -96, -96, -25, 95, 39, Byte.MAX_VALUE, -80, -26, -115, -54, 24, -6, -56, 113, -26, -8, -91, 5, 125, -11, 34, -121, -28, -74, 41, 26, -46, 65, -124, -7, -111, -119, 18, -96, -115, -17, -50, 54, 39, 64, 26, 26, 116, -121, 82, 12, 89, -89, 26, Byte.MIN_VALUE, -108, -38, -47, -87 });
  }
  
  public void a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    GLES20.glUseProgram(this.c);
    k();
    if (!l()) {
      return;
    }
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.d);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 0, a(paramFloatBuffer2));
    GLES20.glEnableVertexAttribArray(this.f);
    if (paramInt1 != -1)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glUniform1i(this.a, 0);
    }
    if (paramInt2 != -1)
    {
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, paramInt2);
      GLES20.glUniform1i(this.b, 1);
    }
    j();
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.d);
    GLES20.glDisableVertexAttribArray(this.f);
    GLES20.glBindTexture(3553, 0);
  }
  
  public void c()
  {
    super.c();
    this.a = GLES20.glGetUniformLocation(this.c, "inputImageTexture0");
    this.b = GLES20.glGetUniformLocation(this.c, "inputImageTexture1");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
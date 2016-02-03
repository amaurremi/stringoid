package com.venticake.retrica.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.venticake.retrica.b.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class TextureLookupFilterWithBytes
{
  private Bitmap lookupTableBitmap;
  private ByteBuffer lookupTableByteBuffer;
  private ByteBuffer mBuffer;
  private final int mBytesPerFloat = 4;
  private int mHeight;
  private final int mPositionDataSize = 3;
  private int mPositionHandle;
  private int mProgramHandle;
  private final FloatBuffer mScreenPosition;
  private final int mTexCoordinateDataSize = 2;
  private int mTexCoordinateHandle;
  private int mTexCoordinateHandle2;
  private int mTexture0Id;
  private int mTexture1Id;
  private int mTexture2Id;
  private final FloatBuffer mTextureCoordinate;
  private int mTextureUniformHandle0;
  private int mTextureUniformHandle1;
  private int mTextureUniformHandle2;
  private int mWidth;
  
  public TextureLookupFilterWithBytes(Context paramContext)
  {
    Object localObject = new float[18];
    Object tmp27_25 = localObject;
    tmp27_25[0] = -1.0F;
    Object tmp32_27 = tmp27_25;
    tmp32_27[1] = 1.0F;
    Object tmp36_32 = tmp32_27;
    tmp36_32[2] = 0.0F;
    Object tmp40_36 = tmp36_32;
    tmp40_36[3] = -1.0F;
    Object tmp45_40 = tmp40_36;
    tmp45_40[4] = -1.0F;
    Object tmp50_45 = tmp45_40;
    tmp50_45[5] = 0.0F;
    Object tmp54_50 = tmp50_45;
    tmp54_50[6] = 1.0F;
    Object tmp59_54 = tmp54_50;
    tmp59_54[7] = 1.0F;
    Object tmp64_59 = tmp59_54;
    tmp64_59[8] = 0.0F;
    Object tmp69_64 = tmp64_59;
    tmp69_64[9] = -1.0F;
    Object tmp75_69 = tmp69_64;
    tmp75_69[10] = -1.0F;
    Object tmp81_75 = tmp75_69;
    tmp81_75[11] = 0.0F;
    Object tmp86_81 = tmp81_75;
    tmp86_81[12] = 1.0F;
    Object tmp91_86 = tmp86_81;
    tmp91_86[13] = -1.0F;
    Object tmp97_91 = tmp91_86;
    tmp97_91[14] = 0.0F;
    Object tmp102_97 = tmp97_91;
    tmp102_97[15] = 1.0F;
    Object tmp107_102 = tmp102_97;
    tmp107_102[16] = 1.0F;
    Object tmp112_107 = tmp107_102;
    tmp112_107[17] = 0.0F;
    tmp112_107;
    float[] arrayOfFloat = new float[12];
    float[] tmp126_124 = arrayOfFloat;
    tmp126_124[0] = 0.0F;
    float[] tmp130_126 = tmp126_124;
    tmp130_126[1] = 0.0F;
    float[] tmp134_130 = tmp130_126;
    tmp134_130[2] = 0.0F;
    float[] tmp138_134 = tmp134_130;
    tmp138_134[3] = 1.0F;
    float[] tmp142_138 = tmp138_134;
    tmp142_138[4] = 1.0F;
    float[] tmp146_142 = tmp142_138;
    tmp146_142[5] = 0.0F;
    float[] tmp150_146 = tmp146_142;
    tmp150_146[6] = 0.0F;
    float[] tmp155_150 = tmp150_146;
    tmp155_150[7] = 1.0F;
    float[] tmp160_155 = tmp155_150;
    tmp160_155[8] = 1.0F;
    float[] tmp165_160 = tmp160_155;
    tmp165_160[9] = 1.0F;
    float[] tmp170_165 = tmp165_160;
    tmp170_165[10] = 1.0F;
    float[] tmp175_170 = tmp170_165;
    tmp175_170[11] = 0.0F;
    tmp175_170;
    this.mScreenPosition = ByteBuffer.allocateDirect(localObject.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mTextureCoordinate = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mScreenPosition.put((float[])localObject).position(0);
    this.mTextureCoordinate.put(arrayOfFloat).position(0);
    localObject = paramContext.getAssets();
    paramContext = null;
    try
    {
      localObject = ((AssetManager)localObject).open("lookup_amatorka.png");
      paramContext = (Context)localObject;
    }
    catch (IOException localIOException)
    {
      try
      {
        paramContext.close();
        GLES20.glClearColor(0.5F, 0.5F, 0.5F, 0.5F);
        i = GLES20.glCreateShader(35633);
        if (i == 0) {
          break label915;
        }
        GLES20.glShaderSource(i, vertex_shader());
        GLES20.glCompileShader(i);
        paramContext = new int[1];
        GLES20.glGetShaderiv(i, 35713, paramContext, 0);
        if (paramContext[0] != 0) {
          break label915;
        }
        GLES20.glDeleteShader(i);
        i = 0;
        if (i != 0) {
          break label415;
        }
        throw new RuntimeException("Error creating vertex shader.");
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
        k = GLES20.glCreateShader(35632);
        j = k;
        if (k == 0) {
          break label472;
        }
        GLES20.glShaderSource(k, fragment_shader());
        GLES20.glCompileShader(k);
        paramContext = new int[1];
        GLES20.glGetShaderiv(k, 35713, paramContext, 0);
        j = k;
        if (paramContext[0] != 0) {
          break label472;
        }
        GLES20.glDeleteShader(k);
        j = 0;
        if (j != 0) {
          break label486;
        }
        throw new RuntimeException("Error creating fragment shader.");
        this.mProgramHandle = GLES20.glCreateProgram();
        if (this.mProgramHandle == 0) {
          break label566;
        }
        GLES20.glAttachShader(this.mProgramHandle, i);
        GLES20.glAttachShader(this.mProgramHandle, j);
        GLES20.glBindAttribLocation(this.mProgramHandle, 0, "a_Position");
        GLES20.glLinkProgram(this.mProgramHandle);
        paramContext = new int[1];
        GLES20.glGetProgramiv(this.mProgramHandle, 35714, paramContext, 0);
        if (paramContext[0] != 0) {
          break label566;
        }
        GLES20.glDeleteProgram(this.mProgramHandle);
        this.mProgramHandle = 0;
        if (this.mProgramHandle != 0) {
          break label583;
        }
        throw new RuntimeException("Error creating program.");
        this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgramHandle, "a_Position");
        this.mTexCoordinateHandle = GLES20.glGetAttribLocation(this.mProgramHandle, "a_TexCoordinate");
        this.mTexCoordinateHandle2 = GLES20.glGetAttribLocation(this.mProgramHandle, "a_TexCoordinate2");
        this.mTextureUniformHandle0 = GLES20.glGetUniformLocation(this.mProgramHandle, "u_Texture0");
        this.mTextureUniformHandle1 = GLES20.glGetUniformLocation(this.mProgramHandle, "u_Texture1");
        this.mTextureUniformHandle2 = GLES20.glGetUniformLocation(this.mProgramHandle, "u_Texture2");
        paramContext = new int[1];
        GLES20.glGenTextures(1, paramContext, 0);
        if (paramContext[0] == 0) {
          break label885;
        }
        this.mTexture0Id = paramContext[0];
        GLES20.glBindTexture(3553, this.mTexture0Id);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glGenTextures(1, paramContext, 0);
        if (paramContext[0] == 0) {
          break label895;
        }
        this.mTexture1Id = paramContext[0];
        GLES20.glBindTexture(3553, this.mTexture1Id);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glGenTextures(1, paramContext, 0);
        if (paramContext[0] == 0) {
          break label905;
        }
        this.mTexture2Id = paramContext[0];
        GLES20.glBindTexture(3553, this.mTexture2Id);
        GLES20.glTexParameterf(3553, 10241, 9728.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        return;
        throw new RuntimeException("Error loading texture.");
      }
    }
    this.lookupTableBitmap = null;
    if (paramContext != null)
    {
      this.lookupTableBitmap = BitmapFactory.decodeStream(paramContext);
      this.lookupTableByteBuffer = ByteBuffer.allocate(this.lookupTableBitmap.getWidth() * this.lookupTableBitmap.getHeight() * 4);
      this.lookupTableBitmap.copyPixelsToBuffer(this.lookupTableByteBuffer);
    }
    label415:
    label472:
    label486:
    label566:
    label583:
    label885:
    label895:
    label905:
    label915:
    for (;;)
    {
      int i;
      int k;
      int j;
      throw new RuntimeException("Error loading texture.");
      throw new RuntimeException("error");
    }
  }
  
  private static String fragment_shader()
  {
    return a.a(new byte[] { -77, 122, -32, -82, 1, 45, 80, 31, -72, 59, 83, -87, 80, -82, -24, 34, -8, -60, 23, 14, -53, 18, -86, -85, -4, -89, 81, 74, 119, -123, 105, 68, -79, -88, -119, 96, -104, -126, 81, -84, 69, -27, -4, -61, 16, -25, -2, -112, -54, -70, 88, 32, 18, -18, 111, 81, -62, -121, 103, 0, 89, -90, -3, -123, 42, 54, 98, 3, 47, -47, 53, -4, 83, 64, 77, -42, 106, 98, -108, -25, 88, -110, 9, 89, 118, -44, -90, -87, 45, 10, -64, 98, -68, -56, -110, 126, -114, 13, -70, 58, 64, 77, -35, 26, -96, 35, -113, Byte.MIN_VALUE, -1, -42, -72, -65, -112, -23, -7, -119, 114, 74, 89, -127, 48, 101, 34, 103, -3, -80, 80, 18, 116, 116, -47, -28, 87, -41, -49, 125, 99, -24, 88, -100, 120, -14, -40, 21, 36, 98, 50, 13, 26, -33, 5, -78, -121, 108, -54, -50, -118, 81, 38, -4, -1, 85, -82, -13, 58, -6, -13, -55, 64, 55, 107, 46, 13, 74, 56, -71, 36, 121, -28, -125, 114, 103, -58, 18, -93, -46, 4, -108, 51, -85, -82, -27, 56, -72, 68, -64, -100, -52, 96, 92, -84, 50, -102, -58, 77, 42, -72, -22, -121, -108, -52, 81, Byte.MIN_VALUE, -93, -125, 80, -92, 41, -127, -118, -17, -7, -70, -22, -109, 100, -31, 73, -57, 39, -75, 87, 115, -77, -59, 75, 82, 42, 83, -28, -36, -97, -121, 39, 75, -38, -116, 94, 38, -33, -45, 57, 111, -91, 117, -87, 5, 62, 74, 89, 34, -2, -20, -6, 124, 36, -31, 81, 110, -34, 86, -70, 24, Byte.MIN_VALUE, 106, -64, 7, 16, 47, 111, 8, -87, -81, 8, 71, Byte.MAX_VALUE, 67, -27, 98, -44, -46, -96, 96, 84, 68, -65, -124, 5, -61, 40, 40, -79, -24, -122, 34, -45, 46, 27, 124, 101, 40, -10, 50, 16, -22, 6, 83, -94, -27, 67, 47, -108, -115, -64, 39, 64, -113, -12, 12, -117, 88, 110, 115, 61, 96, 66, -8, -18, -90, 109, 67, -16, 94, 45, 63, 72, -94, -97, 60, 125, 49, 125, -80, 98, -4, Byte.MAX_VALUE, -97, -118, 13, -120, -59, 121, 72, -18, -80, -88, 24, -121, 87, 106, -57, 32, -28, -83, -58, 14, 89, 29, 28, -62, -43, 99, 55, -106, 49, 103, 119, -40, -67, 22, 99, -74, -34, -54, 70, 29, -11, -110, -11, -6, 50, -73, 113, 78, -114, -37, -122, 122, 44, -5, -29, 85, -9, 124, 51, -39, 72, 99, Byte.MIN_VALUE, 65, -102, 112, -26, 39, -124, 89, 26, -47, 22, 102, 96, -53, 17, 8, -64, -55, -4, 31, -35, -86, 78, 90, 93, -74, 92, -108, 59, -95, 63, -20, -15, -100, -49, 79, -77, -73, -63, 78, 97, 17, -69, -87, 50, -39, 107, 105, -112, -94, 4, 126, 120, -85, 107, 119, -20, -66, 71, -112, -90, -122, 117, -57, -114, -55, 7, -94, -43, 43, 50, -99, -66, -68, -63, 48, -79, -12, 62, 5, 25, 35, 89, 46, -90, 36, 31, -26, -19, -18, -126, 73, 2, 124, -18, -107, 47, 40, -2, 85, 66, -71, 45, -52, -11, 34, -103, 37, -25, -89, 33, -19, -53, 31, 70, -14, 27, 77, 91, -54, -107, 55, 88, -116, -30, -109, -124, 44, 90, 108, -58, 62, -43, -98, -119, 82, -120, 15, Byte.MIN_VALUE, -52, -46, 28, -59, 35, 50, 55, -88, 43, 51, -15, -105, -29, Byte.MIN_VALUE, 15, 59, -115, 62, 67, 9, -27, 8, 36, -34, 10, 54, 31, -88, 29, -108, -5, -97, 91, 114, -25, -110, 68, 99, 98, -30, 41, -40, -114, 13, -50, -119, -82, 10, 53, 8, 40, 67, -106, -125, -5, -51, -70, -2, -57, -8, -108, 9, -63, -16, 61, -46, 111, -116, -72, 61, 5, -47, -78, -82, 66, 6, -118, -2, 78, -21, 24, 102, -24, 46, 98, 99, 91, -58, -115, 46, -46, -76, 80, -100, 80, -4, -111, 53, -8, -5, -120, -2, 21, 9, -88, 70, -58, 45, 46, 21, -42, 59, 113, -30, -41, -40, 83, -117, -14, 26, -86, 44, 29, 25, -122, 49, 6, -91, -91, -6, -9, 44, 5, 7, -67, 92, 36, -78, 34, 92, -96, -55, -89, Byte.MIN_VALUE, -49, 100, 53, -11, -95, 17, -103, 24, -86, 108, -61, -89, -74, Byte.MAX_VALUE, -9, -59, -80, -82, -54, 27, -54, -59, -6, 35, -29, -12, 14, 39, -7, -80, 116, -37, -90, -35, 40, 116, 105, -17, 88, -126, -36, -93, -76, -123, -18, 26, 20, -89, 42, 26, -53, 36, -42, -75, -117, 75, -89, -17, 101, -97, -8, -115, 26, 118, 28, -29, 94, 39, -64, 6, -106, -106, -87, 88, -3, -126, -102, 67, -120, -84, 81, 33, -35, -74, 88, -111, -55, 38, 23, 26, -116, -1, -118, -28, Byte.MAX_VALUE, 83, -32, 4, 121, -20, 60, -22, 68, 40, -10, 91, 15, 26, -12, 67, 39, -71, -21, -95, -85, -100, 52, 111, -116, -125, -104, -31, -54, -55, 44, -56, 52, 88, 67, 29, -119, 115, -82, -126, 64, 67, 26, -127, -75, -25, -65, 61, 46, 55, -92, 9, -83, 40, 17, 90, -104, 92, 46, 65, -125, 23, 6, -5, -54, 65, -2, 1, -6, 61, -126, 42, 31, 16, 48, -58, -104, 32, 56, 40, 102, 98, -64, -117, 90, -88, -33, -51, 26, -112, 125, 103, 12, 54, -90, 47, -60, -100, 59, 107, 5, -18, 103, -17, -97, -110, -80, -34, -75, -16, -39, 91, 68, 40, 68, -46, -37, 73, -15, 70, -31, 117, 14, 124, 71, 92, 111, 34, -28, -104, 78, 106, 68, 38, 54, 69, -115, -10, -19, -23, -54, -77, Byte.MAX_VALUE, 68, -49, 41, -116, 96, 108, -112, -7, -28, -47, 35, 41, 75, 24, -11, -118, -26, -41, 84, -118, -48, -38, 35, -98, 108, 13, 66, 20, -71, -5, -77, -125, -30, 12, 65, 108, -62, 16, -125, -120, -37, 69, 63, -80, 82, -72, -44, -98, 102, 116, Byte.MIN_VALUE, 80, 17, -27, -77, 90, 98, -32, 42, 41, 48, 26, -93, 121, 75, 0, -115, -89, -21, 14, -51, 10, -71, -40, -68, -35, -20, 116, -103, 76, -14, 29, 8, -121, 53, -100, -62, -16, -109, 95, -89, -45, -83, Byte.MIN_VALUE, 36, 1, -50, 53, 116, 116, -59, 107, -66, Byte.MAX_VALUE, -55, -88, -8, 83, 107, -66, 54, -37, 44, Byte.MIN_VALUE, -112, -117, -89, -93, -43, 1, 81, -3, -47, 103, 88, 115, 45, 113, -29, 110, -62, -80, -29, Byte.MIN_VALUE, 18, 75, -4, -46, 65, -4, 50, 68, 88, 108, 109, 61, 113, -20, 122, 98, -77, 108, 54, -32, 59, -100, -127, 87, 87, -11, -82, -106, -123, 120, 52, Byte.MIN_VALUE, 113, -62, 81, -97, 88, -24, -64, 12, -90, 100, -120, -119, 75, 39, 116, -103, -51, Byte.MAX_VALUE, 106, -63, -118, -18, -4, 110, -84, 84, -57, 20, -65, -2, -117, -51, -11, -103, 19, -93, -49, 14, -122, -116, -51, 100, -101, 71, 74, -85, -45, 75, 37, -31, 53, 22, -113, 46, 106, -42, 58, 119, -61, -2, -66, -46, 119, -45, 108, 22, 102, -16, 70, 78, -23, -49, 104, -2, -90, -110, 90, 92, -125, 105, 48, 6, 110, -104, 123, -2, -41, 103, -29, 114, -107, 51, 41, -125, -97, -68, 20, 100, 45, -92, 2, 45, 79, -29, -118, 40, -46, -72, -106, -9, 45, -99, 14, 31, 78, 49, -37, -50, -35, 55, 122, -17, 37, -126, 35, -24, 66, -92, -94, -108, 106, 38, 83, -105, 107, -51, -98, -83, 58, -126, 4, -59, -15, -92, 125, 124, -127, -98, 53, -8, 47, 99, 37, 14, -41, 120, -46, 100, -88, 95, 56, 46, -98, -75, 124, 116, 87, -4, 3, -69, 83, 49, 90, -3, 6, 74, -110, -4, -25, -23, 10, 119, -8, -122, -36, -60, 6, 15, 55, -30, 44, -87, -108, 108, -97, -116, -125, 122, -23, -60, -90, -61, -103, -124, 64, -104, -95, 89, 95, 2, 20, -124, 26, 126, 41, 108, -7, 64, 27, 64, 89, 86, -7, 24, 108, 28, -24, 107, 107, 118, -48, 52, 112, 30, -104, 105, 85, -1, 110, -21, Byte.MAX_VALUE, -32, -33, 3, -92, 49, 12, -100, 13, -78, 81, 13, 21, -40, -67, -20, 21, -54, 5, -15, -50, 53, 86, -23, 29, -28, -91, 108, -90, 21, 5, -115, 93, -111, Byte.MAX_VALUE, -81, -42, 22, 94, -29, -66, -89, -59, -10, -30, -114, 9, -39, 82, 49, 68, 122, -62, -118, 116, 34, -11, 51, 86, 26, -42, -77, -66, 82, -29, 106, 71, -13, 25, 17, -93, -20, -43, 17, -54, 92, 3, -125, 94, -102, 2, 1, -113, 55, -13, -3, -33, 66, 78, 99, -15, -37, 49, -10, 38, 79, 41, -64, -119, -71, 49, -26, -62, -69, 21, 20, -123, 78, -104, 30, -33, -101, 94, 69, 92, 49, 103, -106, 33, 69, -86, 40, -123, 126, -3, 78, 117, 5, -54, -21, 9, 41, -47, -36, 104, -119, -104, 23, -121, 68, -77, -48, 1, -90, 0, Byte.MAX_VALUE, 97, 94, -50, 90, -115, -119, -109, -17, -33, -120, 71, -47, -40, 50, 118, -41, 16, 62, -94, 15, 97, 126, 19, 117, -23, 118, 44, -61, 109, -1, 97, 121, -93, 84, 118, -57, 89, 90, 102, -118, -125, 92, 91, -92, -14, 14, -3, 107, 88, 117, 72, 60, -66, 117, 88, 21, 87, -99, -31, -9, 119, -116, -102, -5, -37, 70, -9, -115, 120, 111, 106, -121, 88, -82, 33, 100, 41, 33, 63, -19, 76, -15, 106, 36, -3, 123, 7, 41, 115, 74, 38, 114, -39, 73, -30, -114, 26, -83, -16, -107, 69, -54, -51, 118, 62, -52, -94, 3, -99, -2, 24, 102, 50, 85, -28, 97, -32, 40, -25, -83, -83, -114, -103, -3, -125, 51, 121, 47, -21, -107, 69, -9, -84, -30, -42, 6, 60, 22, 26, -13, 100, -39, -96, -12, -19, 10, 10, 39, -86, -36, -18, -44, 86, 43, 111, 5, -28, -114, -8, 32, -7, -55, 87, -58, -62, 124, 76, 34, 41, -110, 58, 121, 34, -51, 105, 72, 121, 72, 84, -25, 48, -31, 48, 71, -68, -72, -80, 3, -69, 53, 16, -103, -98, -10, -72, 96, 102, 53, -74, 8, -27, -62, -1, -117, -64, 53, -113, -78, 83, 70, -10, 45, 119, -55, -26, 93, 40, -62, 120, 98, 12, 29, -72, 31, -74, -84, -104, 104, 67, -93, -20, 125, 38, 31, -9, -127, -30, -8, -80, -100, 37, 91, 71, -56, 58, 43, 37, -113, -113, 33, -126, -96, -21, -27, -41, -58, 112, -49, -97, 19, -83, 66, -126, 8, 54, 111, 11, -36, -109, 98, 115, -73, 97, 40, 95, 45, -38, -56, 46, 88, 101, -51, 99, 74, 74, 85, -91, 14, -77, -62, 94, 70, -110, -49, -71, 5, 101, 43, -8, 50, 33, -85, -75, -93, -53, 43, -87, 52, 63, 96, -11, 3, -32, -126, -40, 37, -111, 126, -103, -32, -71, -119, -103, -86, 114, 8, -84, 1, -34, -74, -98, -24, -115, -109, -17, 123, 64, -104, 102, 122, 96, 123, 6, -124, 105, 82, 64, -108, 58, -83, -23, -116, -107, 65, -44, -19, 13, -60, 62, -84, -35, 57, Byte.MIN_VALUE, 103, 47, -75, -75, 45, -2, 80, 93, -29, 118, 65, 101, -75, 113, -35, -97, -61, 76, 112, -103, 27, 70, -127, 124, -85, Byte.MIN_VALUE, -44, 87, -110, -36, -6, 102, 84, 24, 15, 63, 114, 64, 30, -70, -2, 102, -119, 92, -109, -97, 65, 40, 14, -52, 93, -123, 25, 101, 34, 20, -28, 6, -39, -113, 101, -104, -53, 111, -17, -32, -85, -36, -32, 2, 125, 60, -23, 98, -124, 45, -99, -50, 22, -81, -16, -31, -86, -87, 111, -49, 40, 12, 31, -89, 123, 108, 0, -74, 95, 25, 77, 11, 80, 76, -17, 123, -105, 116, -57, 7, 111, 54, -22, -20, 81, -25, -53, 8, -115, 5, 4, -103, 55, 39, 63, -110, -65, -20, 8, 5, -69, 96, 75, -59, 25, 68, 63, -119, 33, -97, -85, 9, 104, 51, -90, -124, Byte.MAX_VALUE, 45, -119, 19, 12, -13, 124, -87, 36, -87, -8, -119, -108, -121, -36, 28, -84, -57, 120, 73, 77, -92, -36, -91, 79, -121, 11, 92, 85, -104, 36, 63, -40, -123, 63, -127, 27, 39, 31, -64, -101, -12, -119, -109, 87, 116, -10, -14, -70, 119, 115, -23, -67, 0, -101, -3, -52, 59, -89, 13, 106, 112, -117, -76, 89, -72, -96, 103, 76, -60, -67, -41, -81, 98, -52, 122, -41, -29, 111, 63, 101, -83, -58, -91, 100, -90, 112, 27, -60, 117, 72, 113, 84, 85, 77, 63, 80, -111, 110, -20, 116, 109, -54, 78, 41, 38, 110, 58, 61, 70, 63, 71, 72, -16, -111, -44, -4, -35, 35, 113, 99, -104, 6, 32, -78, 69, 94, 66, 39, 43, 113, -55, -63, 60, 2, -9, 36, 67, 82, -53, -12, 50, -46, -55, -65, 24, -63, 57, 48, 69, -73, -17, 126, -116, -96, -16, -49, -87, 10, -85, 72, -92, 34, 100, 8, 123, -83, 67, 77, -117, 124, -21, 121, -83, -81, -46, -71, -94, 35, -41, 54, -8, -64, -98, 100, -24, 38, 86, 64, -104, -59, 73, -8, -100, -68, 49, 10, 82, 110, -113, 110, -33, 125, -70, -2, 55, -33, -54, 15, -70, 49, 70, 34, 39, 76, 24, 86, 115, -96, 115, 85, 96, 38, 16, -65, -77, -36, -29, 100, -45, Byte.MIN_VALUE, 108, 10, 48, 48, 9, -81, -39, -19, -25, 20, 109, 1, 16, -79, 2, -30, 74, 61, 82, 98, -88, -37, 18, -119, 21, -122, 73, -24, -125, -71, -92, -104, -57, -13, -99, -26, 100, -4, 85, 83, 97, 64, 53, 93, -112, -112, -14, -107, 93, -59, 45, 52, -127, 64, 81, -55, -84, -59, 13, 30, 95, -115, 18, -34, -111, -41, -124, 13, -20, -34, 65, 7, -76, -3, -14, -127, 83, 112, 90, -108, 82, 3, 91, 110, 96, -44, 126, -41, -53, -96, 65, 44, -9, 23, 81, -95, -121, 21, -99, -54, 115, 83, 103, -28, -50, 66, 83, -96, -85, 69, -5, -76, 24, -62, -127, 32, -35, -95, 20, 107, -45, -79, 51, -94, -39, -84, 23, 119, -43, 16, 60, -91, 120, -81, -50, -8, -47, -45, -66, -98, 97, 82, 10, 22, 87, 109, 53, 75, 8, 91, 55, 25, -47, -78, 64, -57, -113, 2, 85, -8, -39, -123, -2, -113, -84, 11, -64, 17, 102, -17, 95, 120, 12, 11, -39, 111, -14, 59, -57, 21, 78, 16, 49, -47, 60, -64, 115, 87, -83, 18, 48, -43, -126, 72, -15, -62, 22, -121, 71, 45, -109, -17, -8, 3, 50, 84, -40, 114, -7, -78, -30, 2, 7, -113, 93, 94, 7, 41, -117, 6, 13, -107, -53, -75, 21, -57, 5, 17, -71, 56, 115, 67, Byte.MIN_VALUE, 18, 0, -68, 61, -28 });
  }
  
  private ByteBuffer getBuffer()
  {
    try
    {
      ByteBuffer localByteBuffer = this.mBuffer;
      return localByteBuffer;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void loadAndDrawTextureFromBuffer()
  {
    ByteBuffer localByteBuffer = getBuffer();
    if (localByteBuffer != null)
    {
      GLES20.glActiveTexture(33984);
      localByteBuffer.position(0);
      GLES20.glBindTexture(3553, this.mTexture0Id);
      GLES20.glTexImage2D(3553, 0, 6409, this.mWidth, this.mHeight, 0, 6409, 5121, localByteBuffer);
      GLES20.glUniform1i(this.mTextureUniformHandle0, 0);
      GLES20.glActiveTexture(33985);
      localByteBuffer.position(this.mWidth * this.mHeight);
      GLES20.glBindTexture(3553, this.mTexture1Id);
      GLES20.glTexImage2D(3553, 0, 6410, this.mWidth / 2, this.mHeight / 2, 0, 6410, 5121, localByteBuffer);
      localByteBuffer.position(0);
      GLES20.glUniform1i(this.mTextureUniformHandle1, 1);
      this.lookupTableByteBuffer.position(0);
      GLES20.glActiveTexture(33986);
      GLES20.glBindTexture(3553, this.mTexture2Id);
      GLUtils.texImage2D(3553, 0, this.lookupTableBitmap, 0);
      GLES20.glUniform1i(this.mTextureUniformHandle2, 2);
    }
  }
  
  private static String vertex_shader()
  {
    return a.a(new byte[] { -7, 31, -89, 97, -24, 69, 56, 19, 79, -39, -127, -24, -90, -45, 43, 78, -92, 109, 25, -8, -6, -15, 42, 109, -100, -111, -46, -39, 89, 24, 35, -110, 118, 55, 64, -125, -74, 116, -94, -93, 117, 99, 111, 31, 43, 63, 2, 23, -93, 111, 89, 110, -39, -1, 104, -56, 33, 16, Byte.MIN_VALUE, -19, -40, -34, -127, -32, 26, 70, 116, 98, 102, -32, -110, 95, -101, 12, 31, -76, -59, 19, 119, 75, -48, -47, Byte.MIN_VALUE, 120, -105, 70, -111, -27, -30, 43, -50, -119, -35, -90, 31, 97, 111, 39, -122, 66, -19, -21, 117, 73, -86, 45, -109, -107, -32, 35, 49, 9, -122, -100, 122, 70, -111, 124, -48, 70, -47, -118, 108, 49, -2, -44, -109, 9, -119, 18, 35, 13, -123, 113, -20, 103, -6, 106, 14, -64, 42, -63, 102, 105, -43, -36, -39, 59, -54, 48, -48, 125, 104, -126, -100, 103, 122, -27, 33, 55, -41, -45, 77, 89, 81, -18, -19, 90, -40, -90, -91, -38, 29, 17, -106, 65, -1, 18, -78, 65, 67, -99, 24, 3, 28, -20, -97, -113, 74, 87, -112, -60, 92, 34, 1, 102, -71, 3, 57, -34, -87, -84, -107, 76, -34, 116, 23, -111, 111, -24, -111, -21, -13, -31, Byte.MAX_VALUE, -3, -39, 24, 116, 42, -96, 123, 87, 46, -30, -91, -93, -62, 82, 48, -31, 106, 1, -64, 64, 90, 106, 89, 84, 103, 96, -24, 3, 16, -28, 38, -106, -10, 118, -22, -50, 61, 33, -73, 81, -96, -112, -126, -19, -127, 96, -51, 100, -44, -99, 5, 20, 118, -125, 30, -93, 28, -55, 97, -106, 30, 20, 65, 94, -115, -67, -61, -127, -9, -109, 47, -99, 31, 44, 38, -12, -81, -94, 67, 93, 72, -114, -95, 27, 95, 69, 115, -101, 119, 110, -28, -50, -96, -3, 123, 39, 44, -18, -116, -105, -124, -67, 10, 57, -92, 28, -10, 20, -27, 5, 8, 15, 45, 60, 31, -9, -11, -34, -85, 47, -14, 54, -54, 15, -112, -97, -48, -103, -81, -123, 78, 25, -67, 19, 84, -98, 15, -50, 2, 107, Byte.MIN_VALUE, 39, 40, 107, -105, 77, -22, 11, -116, 114, -53, -42, 28, -103, -33, 84, -90, -126, -44, -29, -19, 126, -83, 106, 125, 73, -69, 113, -84, -13, -84, 117, -67, 119, 1, -28, -22, 110, 49, 56, 55, 30, -75, 1, -31, -75, 36, -66, -59, -93, -10, -80, 75, 83, 47, -45, 63, 80, -109, -29, -65, 27, 77, -2, -26, -83, 75, -107, -70, 116, 56, -32, 109, 46, -58, -90, 116, 96, -119, -119, -116, 42, -120, 65, -18, 54, 91, -100, -6, 98, 67, 108, -57, 32, 78, 62, -8, 5, -28, 38, 41, -22, -11, 6, 74, -47, 73, 10, -67, 115, -65, 56, 39, -111, -32, -104, -65, 54, 7, 126, 103, -87, -6, -76, 93, -121, -72, -9, -60, 93, 14, -109, -8, -5, -80, -16, -42, -43, -39, 66, -91, -72, 102, 115, -12, 80, 30, -58, -51, -77, 37, -79, -86, 99, 112, 73, -10, -114, 102, -114, -27, -46, -105, -67, 119, 22, -24, 65, -57, 32, 122, -46, 97, 75, 118, 89, Byte.MAX_VALUE, -77, -37, Byte.MAX_VALUE, -18, -47, -30, 79, -31, -51, 12, 92, -109, 33, 91, 107, 82, -102, -78, 29, 30, 10, 105, -65, 87, -22, 54, -98, -19 });
  }
  
  public ByteBuffer drawFrame(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    try
    {
      b.a(0, 0, paramInt1, paramInt2);
      if (this.mBuffer == null) {
        this.mBuffer = ByteBuffer.allocateDirect(paramArrayOfByte.length);
      }
      this.mBuffer.clear();
      this.mBuffer.put(paramArrayOfByte);
      this.mBuffer.position(0);
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      GLES20.glClear(16640);
      GLES20.glUseProgram(this.mProgramHandle);
      this.mScreenPosition.position(0);
      GLES20.glVertexAttribPointer(this.mPositionHandle, 3, 5126, false, 0, this.mScreenPosition);
      GLES20.glEnableVertexAttribArray(this.mPositionHandle);
      this.mTextureCoordinate.position(0);
      GLES20.glVertexAttribPointer(this.mTexCoordinateHandle, 2, 5126, false, 0, this.mTextureCoordinate);
      GLES20.glEnableVertexAttribArray(this.mTexCoordinateHandle);
      this.mTextureCoordinate.position(0);
      GLES20.glVertexAttribPointer(this.mTexCoordinateHandle2, 2, 5126, false, 0, this.mTextureCoordinate);
      GLES20.glEnableVertexAttribArray(this.mTexCoordinateHandle2);
      loadAndDrawTextureFromBuffer();
      paramArrayOfByte = ByteBuffer.allocate(paramInt1 * paramInt2 * 4);
      GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, paramArrayOfByte);
      return paramArrayOfByte;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/util/TextureLookupFilterWithBytes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
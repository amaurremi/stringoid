package com.mobisystems.mobiscanner.common.util;

import android.graphics.Bitmap;

public class BitmapNative
{
  static
  {
    System.loadLibrary("jpeg-turbo");
  }
  
  public static native double[] LineSegmentDetection(Bitmap paramBitmap, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, int paramInt);
  
  public static native int[] calcHistogram(Bitmap paramBitmap, int[] paramArrayOfInt);
  
  public static native void createCompress(int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public static native void createJPEGFile();
  
  public static native void finishCompress();
  
  public static native boolean sendBitmap(Bitmap[] paramArrayOfBitmap);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/util/BitmapNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
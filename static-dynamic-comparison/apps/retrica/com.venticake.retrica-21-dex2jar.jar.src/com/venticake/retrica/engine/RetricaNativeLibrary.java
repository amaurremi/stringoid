package com.venticake.retrica.engine;

public class RetricaNativeLibrary
{
  static
  {
    System.loadLibrary("retrica-library");
  }
  
  public static native void TEST(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  public static native void YUVtoARBG(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  public static native void YUVtoRBGA(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int[] paramArrayOfInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/RetricaNativeLibrary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
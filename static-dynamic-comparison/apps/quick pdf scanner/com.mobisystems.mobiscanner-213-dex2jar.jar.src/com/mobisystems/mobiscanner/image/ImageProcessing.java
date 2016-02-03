package com.mobisystems.mobiscanner.image;

import android.graphics.Matrix;
import java.lang.reflect.Array;

public class ImageProcessing
{
  static ImageOrientation[][] aIh = (ImageOrientation[][])Array.newInstance(ImageOrientation.class, new int[] { ImageOrientation.values().length, ImageOperation.values().length });
  
  static
  {
    aIh[ImageOrientation.aHV.ordinal()][ImageOperation.aIi.ordinal()] = ImageOrientation.aHV;
    aIh[ImageOrientation.aHV.ordinal()][ImageOperation.aIj.ordinal()] = ImageOrientation.aHV;
    aIh[ImageOrientation.aHV.ordinal()][ImageOperation.aIk.ordinal()] = ImageOrientation.aHV;
    aIh[ImageOrientation.aHV.ordinal()][ImageOperation.aIl.ordinal()] = ImageOrientation.aHV;
    aIh[ImageOrientation.aHW.ordinal()][ImageOperation.aIi.ordinal()] = ImageOrientation.aHW;
    aIh[ImageOrientation.aHW.ordinal()][ImageOperation.aIj.ordinal()] = ImageOrientation.aIb;
    aIh[ImageOrientation.aHW.ordinal()][ImageOperation.aIk.ordinal()] = ImageOrientation.aHY;
    aIh[ImageOrientation.aHW.ordinal()][ImageOperation.aIl.ordinal()] = ImageOrientation.aId;
    aIh[ImageOrientation.aIb.ordinal()][ImageOperation.aIi.ordinal()] = ImageOrientation.aIb;
    aIh[ImageOrientation.aIb.ordinal()][ImageOperation.aIj.ordinal()] = ImageOrientation.aHY;
    aIh[ImageOrientation.aIb.ordinal()][ImageOperation.aIk.ordinal()] = ImageOrientation.aId;
    aIh[ImageOrientation.aIb.ordinal()][ImageOperation.aIl.ordinal()] = ImageOrientation.aHW;
    aIh[ImageOrientation.aHY.ordinal()][ImageOperation.aIi.ordinal()] = ImageOrientation.aHY;
    aIh[ImageOrientation.aHY.ordinal()][ImageOperation.aIj.ordinal()] = ImageOrientation.aId;
    aIh[ImageOrientation.aHY.ordinal()][ImageOperation.aIk.ordinal()] = ImageOrientation.aHW;
    aIh[ImageOrientation.aHY.ordinal()][ImageOperation.aIl.ordinal()] = ImageOrientation.aIb;
    aIh[ImageOrientation.aId.ordinal()][ImageOperation.aIi.ordinal()] = ImageOrientation.aId;
    aIh[ImageOrientation.aId.ordinal()][ImageOperation.aIj.ordinal()] = ImageOrientation.aHW;
    aIh[ImageOrientation.aId.ordinal()][ImageOperation.aIk.ordinal()] = ImageOrientation.aIb;
    aIh[ImageOrientation.aId.ordinal()][ImageOperation.aIl.ordinal()] = ImageOrientation.aHY;
    aIh[ImageOrientation.aHX.ordinal()][ImageOperation.aIi.ordinal()] = ImageOrientation.aHX;
    aIh[ImageOrientation.aHX.ordinal()][ImageOperation.aIj.ordinal()] = ImageOrientation.aHX;
    aIh[ImageOrientation.aHX.ordinal()][ImageOperation.aIk.ordinal()] = ImageOrientation.aHX;
    aIh[ImageOrientation.aHX.ordinal()][ImageOperation.aIl.ordinal()] = ImageOrientation.aHX;
    aIh[ImageOrientation.aHZ.ordinal()][ImageOperation.aIi.ordinal()] = ImageOrientation.aHZ;
    aIh[ImageOrientation.aHZ.ordinal()][ImageOperation.aIj.ordinal()] = ImageOrientation.aHZ;
    aIh[ImageOrientation.aHZ.ordinal()][ImageOperation.aIk.ordinal()] = ImageOrientation.aHZ;
    aIh[ImageOrientation.aHZ.ordinal()][ImageOperation.aIl.ordinal()] = ImageOrientation.aHZ;
    aIh[ImageOrientation.aIa.ordinal()][ImageOperation.aIi.ordinal()] = ImageOrientation.aIa;
    aIh[ImageOrientation.aIa.ordinal()][ImageOperation.aIj.ordinal()] = ImageOrientation.aIa;
    aIh[ImageOrientation.aIa.ordinal()][ImageOperation.aIk.ordinal()] = ImageOrientation.aIa;
    aIh[ImageOrientation.aIa.ordinal()][ImageOperation.aIl.ordinal()] = ImageOrientation.aIa;
    aIh[ImageOrientation.aIc.ordinal()][ImageOperation.aIi.ordinal()] = ImageOrientation.aIc;
    aIh[ImageOrientation.aIc.ordinal()][ImageOperation.aIj.ordinal()] = ImageOrientation.aIc;
    aIh[ImageOrientation.aIc.ordinal()][ImageOperation.aIk.ordinal()] = ImageOrientation.aIc;
    aIh[ImageOrientation.aIc.ordinal()][ImageOperation.aIl.ordinal()] = ImageOrientation.aIc;
  }
  
  public static ImageOrientation a(ImageOrientation paramImageOrientation, ImageOperation paramImageOperation)
  {
    return aIh[paramImageOrientation.ordinal()][paramImageOperation.ordinal()];
  }
  
  public static void a(Matrix paramMatrix, ImageOrientation paramImageOrientation)
  {
    switch (1.aDw[paramImageOrientation.ordinal()])
    {
    case 1: 
    case 2: 
    default: 
      return;
    case 3: 
      paramMatrix.postScale(-1.0F, 1.0F);
      return;
    case 4: 
      paramMatrix.postRotate(180.0F);
      return;
    case 5: 
      paramMatrix.postRotate(180.0F);
      paramMatrix.postScale(-1.0F, 1.0F);
      return;
    case 6: 
      paramMatrix.postRotate(90.0F);
      paramMatrix.postScale(1.0F, -1.0F);
      return;
    case 7: 
      paramMatrix.postRotate(90.0F);
      return;
    case 8: 
      paramMatrix.postRotate(270.0F);
      paramMatrix.postScale(1.0F, -1.0F);
      return;
    }
    paramMatrix.postRotate(270.0F);
  }
  
  public static Matrix c(ImageOrientation paramImageOrientation)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    a(localMatrix, paramImageOrientation);
    return localMatrix;
  }
  
  public static enum ImageOperation
  {
    private ImageOperation() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/image/ImageProcessing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
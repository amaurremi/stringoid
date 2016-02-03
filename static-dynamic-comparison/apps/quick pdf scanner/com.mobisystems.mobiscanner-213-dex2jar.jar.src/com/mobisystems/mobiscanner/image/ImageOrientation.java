package com.mobisystems.mobiscanner.image;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import com.mobisystems.office.pdfExport.PdfGraphicsContext.ImageOrientation;

public enum ImageOrientation
{
  private static SparseArray<ImageOrientation> aIe;
  private static SparseArray<ImageOrientation> aIf;
  private static SparseArray<ImageOrientation> aqf;
  private int mExifOrientation;
  private PdfGraphicsContext.ImageOrientation mPDFOrientation;
  private int mPersistentValue;
  private final int mResId;
  
  private ImageOrientation(int paramInt1, int paramInt2, PdfGraphicsContext.ImageOrientation paramImageOrientation)
  {
    this.mResId = paramInt1;
    this.mExifOrientation = paramInt2;
    this.mPDFOrientation = paramImageOrientation;
  }
  
  public static ImageOrientation gt(int paramInt)
  {
    return (ImageOrientation)aqf.get(paramInt);
  }
  
  public static ImageOrientation gu(int paramInt)
  {
    return (ImageOrientation)aIe.get(paramInt);
  }
  
  public static void init(Context paramContext)
  {
    aqf = new SparseArray();
    aIe = new SparseArray();
    aIf = new SparseArray();
    paramContext = paramContext.getResources();
    int j = values().length;
    int i = 0;
    while (i < j)
    {
      values()[i].mPersistentValue = Integer.parseInt(paramContext.getString(values()[i].mResId));
      aqf.put(values()[i].mPersistentValue, values()[i]);
      aIe.put(values()[i].mExifOrientation, values()[i]);
      aIf.put(values()[i].mPDFOrientation.ordinal(), values()[i]);
      i += 1;
    }
  }
  
  public int Dp()
  {
    return this.mPersistentValue;
  }
  
  public int Ik()
  {
    return this.mExifOrientation;
  }
  
  public PdfGraphicsContext.ImageOrientation Il()
  {
    return this.mPDFOrientation;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/image/ImageOrientation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
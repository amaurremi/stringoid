package com.mobisystems.pdf;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.mobisystems.pdf.annotation.Annotation;

public class PDFPage
{
  PDFDocument _document;
  long _handle;
  
  public PDFPage(PDFDocument paramPDFDocument)
  {
    this._document = paramPDFDocument;
    PDFError.throwError(init());
  }
  
  private native Annotation addAnnotation(Class<? extends Annotation> paramClass, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int[] paramArrayOfInt);
  
  private native int cropBox(PDFPoint paramPDFPoint1, PDFPoint paramPDFPoint2);
  
  private native void destroy();
  
  private native int getContentSize(PDFSize paramPDFSize);
  
  private native int init();
  
  private native int loadAnnotationContent(Annotation paramAnnotation, PDFMatrix paramPDFMatrix, int[] paramArrayOfInt, int paramInt);
  
  private native int makeTransformMappingContentToRect(PDFMatrix paramPDFMatrix, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  private native int open(long paramLong, int paramInt);
  
  private native int removeAnnotationNative(Annotation paramAnnotation);
  
  public Annotation addAnnotation(Class<? extends Annotation> paramClass, PDFPoint paramPDFPoint1, PDFPoint paramPDFPoint2)
  {
    int[] arrayOfInt = new int[1];
    paramClass = addAnnotation(paramClass, paramPDFPoint1.x, paramPDFPoint1.y, paramPDFPoint2.x, paramPDFPoint2.y, arrayOfInt);
    PDFError.throwError(arrayOfInt[0]);
    return paramClass;
  }
  
  public native void close();
  
  protected void finalize()
  {
    destroy();
    super.finalize();
  }
  
  public native Annotation getAnnotation(int paramInt);
  
  public native Annotation getAnnotationByPt(float paramFloat1, float paramFloat2);
  
  public native int getAnnotationsCount();
  
  public PDFSize getContentSize()
  {
    PDFSize localPDFSize = new PDFSize();
    PDFError.throwError(getContentSize(localPDFSize));
    return localPDFSize;
  }
  
  public void getCropBox(PDFPoint paramPDFPoint1, PDFPoint paramPDFPoint2)
  {
    PDFError.throwError(cropBox(paramPDFPoint1, paramPDFPoint2));
  }
  
  public PDFDocument getDocument()
  {
    return this._document;
  }
  
  public native float getUserUnit();
  
  public Bitmap loadAnnotationBitmap(Annotation paramAnnotation, PDFMatrix paramPDFMatrix, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[paramInt1 * paramInt2];
    PDFError.throwError(loadAnnotationContent(paramAnnotation, paramPDFMatrix, arrayOfInt, paramInt1));
    return Bitmap.createBitmap(arrayOfInt, paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
  }
  
  public Bitmap loadBitmap(PDFMatrix paramPDFMatrix, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[paramInt1 * paramInt2];
    PDFError.throwError(loadContent(paramPDFMatrix, arrayOfInt, paramInt1, null));
    return Bitmap.createBitmap(arrayOfInt, paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
  }
  
  public native int loadContent(PDFMatrix paramPDFMatrix, int[] paramArrayOfInt, int paramInt, PDFText paramPDFText);
  
  public native void lockAnnotation(Annotation paramAnnotation);
  
  public PDFMatrix makeTransformMappingContentToRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    PDFMatrix localPDFMatrix = new PDFMatrix();
    PDFError.throwError(makeTransformMappingContentToRect(localPDFMatrix, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
    return localPDFMatrix;
  }
  
  public boolean onWarning(int paramInt)
  {
    return false;
  }
  
  public void open(int paramInt)
  {
    PDFError.throwError(open(this._document._handle, paramInt));
  }
  
  public void removeAnnotation(Annotation paramAnnotation)
  {
    PDFError.throwError(removeAnnotationNative(paramAnnotation));
  }
  
  public native void unlockAnnotation(Annotation paramAnnotation);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/PDFPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
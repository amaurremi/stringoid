package com.mobisystems.pdf.annotation;

import com.mobisystems.pdf.PDFError;

public class TextMarkupAnnotation
  extends MarkupAnnotation
{
  private native int addQuadrilateralNative(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8);
  
  public void addQuadrilateral(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    PDFError.throwError(addQuadrilateralNative(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8));
  }
  
  public native void clearQuadrilaterals();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/annotation/TextMarkupAnnotation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
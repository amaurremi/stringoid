package com.mobisystems.pdf.annotation;

import com.mobisystems.pdf.PDFError;

public class InkAnnotation
  extends MarkupAnnotation
{
  private native int addPointNative(float paramFloat1, float paramFloat2);
  
  private native int moveToNative(float paramFloat1, float paramFloat2);
  
  public void addPoint(float paramFloat1, float paramFloat2)
  {
    PDFError.throwError(addPointNative(paramFloat1, paramFloat2));
  }
  
  public void moveTo(float paramFloat1, float paramFloat2)
  {
    PDFError.throwError(moveToNative(paramFloat1, paramFloat2));
  }
  
  public native void resetPaths();
  
  public void setColor(Integer paramInteger)
  {
    if (paramInteger != null)
    {
      super.setColor(paramInteger);
      return;
    }
    super.setColor(16711680);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/annotation/InkAnnotation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
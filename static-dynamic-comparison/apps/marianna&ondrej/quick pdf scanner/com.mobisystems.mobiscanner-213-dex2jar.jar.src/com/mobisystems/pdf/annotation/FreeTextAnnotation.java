package com.mobisystems.pdf.annotation;

import android.graphics.Color;
import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.PDFPoint;
import com.mobisystems.pdf.PDFRect;
import com.mobisystems.pdf.PDFSize;

public class FreeTextAnnotation
  extends Annotation
{
  private native int getTextDimensionsNative(float[] paramArrayOfFloat);
  
  private native int setFontColorNative(int paramInt1, int paramInt2, int paramInt3);
  
  public int getColorRGB()
  {
    return getFontColorRGB();
  }
  
  public native int getFontColorRGB();
  
  public PDFSize getTextDimensions()
  {
    float[] arrayOfFloat = new float[2];
    PDFError.throwError(getTextDimensionsNative(arrayOfFloat));
    PDFSize localPDFSize = new PDFSize();
    localPDFSize.width = arrayOfFloat[0];
    localPDFSize.height = arrayOfFloat[1];
    return localPDFSize;
  }
  
  public void setColor(int paramInt1, int paramInt2, int paramInt3)
  {
    PDFError.throwError(setFontColorNative(paramInt1, paramInt2, paramInt3));
  }
  
  public void setContentsAndResize(String paramString, float paramFloat)
  {
    PDFRect localPDFRect = getBoundingBox();
    setBoundingBox(new PDFPoint(localPDFRect.left(), localPDFRect.bottom()), new PDFPoint(paramFloat, localPDFRect.top()));
    setContents(paramString);
    paramString = getTextDimensions();
    PDFPoint localPDFPoint = new PDFPoint(localPDFRect.left(), localPDFRect.top() - paramString.height);
    paramFloat = localPDFRect.left();
    setBoundingBox(localPDFPoint, new PDFPoint(paramString.width + paramFloat, localPDFRect.top()));
  }
  
  public void setFontColor(int paramInt)
  {
    PDFError.throwError(setFontColorNative(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt)));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/annotation/FreeTextAnnotation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
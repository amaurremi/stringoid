package com.mobisystems.pdf.annotation;

import android.graphics.Color;
import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.PDFPoint;
import com.mobisystems.pdf.PDFRect;

public class Annotation
{
  private long _handle;
  private PDFRect boundingBox = new PDFRect(0.0F, 0.0F, 0.0F, 0.0F);
  
  private native void getBoundingBox(PDFRect paramPDFRect);
  
  private native int serializeNative();
  
  private native int setColorNative(int paramInt1, int paramInt2, int paramInt3);
  
  private native int setContentsNative(String paramString);
  
  private native int setRectNative(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Annotation)) {
      return this._handle == ((Annotation)paramObject)._handle;
    }
    return super.equals(paramObject);
  }
  
  public native float getBorderWidth();
  
  public PDFRect getBoundingBox()
  {
    getBoundingBox(this.boundingBox);
    return this.boundingBox;
  }
  
  public native int getColorRGB();
  
  public native String getContents();
  
  public native String getModificationDate();
  
  public native int getPage();
  
  public int hashCode()
  {
    return (int)this._handle;
  }
  
  public void serialize()
  {
    PDFError.throwError(serializeNative());
  }
  
  public native void setBorderWidth(float paramFloat);
  
  public void setBorderWidth(Float paramFloat)
  {
    if (paramFloat != null)
    {
      setBorderWidth(paramFloat.intValue());
      return;
    }
    setBorderWidth(1.0F);
  }
  
  public void setBoundingBox(PDFPoint paramPDFPoint1, PDFPoint paramPDFPoint2)
  {
    PDFError.throwError(setRectNative(paramPDFPoint1.x, paramPDFPoint1.y, paramPDFPoint2.x, paramPDFPoint2.y));
  }
  
  public void setColor(int paramInt)
  {
    setColor(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt));
  }
  
  public void setColor(int paramInt1, int paramInt2, int paramInt3)
  {
    PDFError.throwError(setColorNative(paramInt1, paramInt2, paramInt3));
  }
  
  public void setColor(Integer paramInteger)
  {
    if (paramInteger != null)
    {
      setColor(paramInteger.intValue());
      return;
    }
    setColor(16776960);
  }
  
  public void setContents(String paramString)
  {
    PDFError.throwError(setContentsNative(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/annotation/Annotation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
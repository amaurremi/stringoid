package com.mobisystems.pdf.annotation;

public class MarkupAnnotation
  extends Annotation
{
  public native int getOpacity();
  
  public native String getSubject();
  
  public native String getTitle();
  
  public native void setOpacity(int paramInt);
  
  public void setOpacity(Integer paramInteger)
  {
    if (paramInteger != null)
    {
      setOpacity(paramInteger.intValue());
      return;
    }
    setOpacity(255);
  }
  
  public native void setSubject(String paramString);
  
  public native void setTitle(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/annotation/MarkupAnnotation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
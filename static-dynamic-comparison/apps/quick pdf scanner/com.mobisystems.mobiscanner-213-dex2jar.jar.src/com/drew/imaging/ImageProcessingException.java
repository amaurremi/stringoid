package com.drew.imaging;

import com.drew.lang.CompoundException;

public class ImageProcessingException
  extends CompoundException
{
  private static final long serialVersionUID = -9115669182209912676L;
  
  public ImageProcessingException(String paramString)
  {
    super(paramString);
  }
  
  public ImageProcessingException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/imaging/ImageProcessingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
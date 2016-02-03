package com.mobisystems.pdf;

public class PDFSize
{
  public float height;
  public float width;
  
  public PDFSize() {}
  
  public PDFSize(float paramFloat1, float paramFloat2)
  {
    this.width = paramFloat1;
    this.height = paramFloat2;
  }
  
  public PDFSize(PDFSize paramPDFSize)
  {
    this.width = paramPDFSize.width;
    this.height = paramPDFSize.height;
  }
  
  public String toString()
  {
    return "PDFSize [" + this.width + ", " + this.height + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/PDFSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
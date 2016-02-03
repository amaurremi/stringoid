package com.mobisystems.pdf;

public class PDFPoint
{
  public float x;
  public float y;
  
  public PDFPoint() {}
  
  public PDFPoint(float paramFloat1, float paramFloat2)
  {
    set(paramFloat1, paramFloat2);
  }
  
  public PDFPoint(PDFPoint paramPDFPoint)
  {
    set(paramPDFPoint.x, paramPDFPoint.y);
  }
  
  public void convert(PDFMatrix paramPDFMatrix)
  {
    float f1 = paramPDFMatrix.a;
    float f2 = this.x;
    float f3 = paramPDFMatrix.c;
    float f4 = this.y;
    float f5 = paramPDFMatrix.e;
    float f6 = paramPDFMatrix.b;
    float f7 = this.x;
    float f8 = paramPDFMatrix.d;
    float f9 = this.y;
    float f10 = paramPDFMatrix.f;
    this.x = (f1 * f2 + f3 * f4 + f5);
    this.y = (f6 * f7 + f8 * f9 + f10);
  }
  
  public void set(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public String toString()
  {
    return "PDFPoint(" + this.x + "," + this.y + ")";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/PDFPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
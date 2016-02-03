package com.mobisystems.pdf;

public class PDFQuadrilateral
{
  public float x1;
  public float x2;
  public float x3;
  public float x4;
  public float y1;
  public float y2;
  public float y3;
  public float y4;
  
  public PDFRect getBoundingBox()
  {
    float f1 = Math.min(Math.min(this.x1, this.x2), Math.min(this.x3, this.x4));
    float f2 = Math.max(Math.max(this.x1, this.x2), Math.max(this.x3, this.x4));
    return new PDFRect(f1, Math.min(Math.min(this.y1, this.y2), Math.min(this.y3, this.y4)), f2, Math.max(Math.max(this.y1, this.y2), Math.max(this.y3, this.y4)));
  }
  
  public native boolean getYProjection(PDFPoint paramPDFPoint1, PDFPoint paramPDFPoint2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/PDFQuadrilateral.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
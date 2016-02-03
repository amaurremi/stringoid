package com.mobisystems.pdf;

public class PDFMatrix
{
  public float a;
  public float b;
  public float c;
  public float d;
  public float e;
  public float f;
  
  public PDFMatrix()
  {
    this.a = 1.0F;
    this.b = 0.0F;
    this.c = 0.0F;
    this.d = 1.0F;
    this.e = 0.0F;
    this.f = 0.0F;
  }
  
  public PDFMatrix(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.e = paramFloat5;
    this.f = paramFloat6;
  }
  
  public boolean invert()
  {
    float f6 = this.a * this.d - this.b * this.c;
    if (f6 == 0.0F) {
      return false;
    }
    float f1 = this.d / f6;
    float f2 = -this.b / f6;
    float f3 = -this.c / f6;
    float f4 = this.a / f6;
    float f5 = (this.c * this.f - this.d * this.e) / f6;
    f6 = (this.b * this.e - this.a * this.f) / f6;
    this.a = f1;
    this.b = f2;
    this.c = f3;
    this.d = f4;
    this.e = f5;
    this.f = f6;
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/PDFMatrix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.mobisystems.pdf;

public class PDFRect
{
  protected float bottom;
  protected float left;
  protected float right;
  protected float top;
  
  public PDFRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public PDFRect(PDFPoint paramPDFPoint1, PDFPoint paramPDFPoint2)
  {
    set(paramPDFPoint1.x, paramPDFPoint1.y, paramPDFPoint2.x, paramPDFPoint2.y);
  }
  
  public float bottom()
  {
    return this.bottom;
  }
  
  public float height()
  {
    return this.top - this.bottom;
  }
  
  public float left()
  {
    return this.left;
  }
  
  public float right()
  {
    return this.right;
  }
  
  protected void set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat1 < paramFloat3) {
      this.left = paramFloat1;
    }
    for (this.right = paramFloat3; paramFloat2 < paramFloat4; this.right = paramFloat1)
    {
      this.bottom = paramFloat2;
      this.top = paramFloat4;
      return;
      this.left = paramFloat3;
    }
    this.bottom = paramFloat4;
    this.top = paramFloat2;
  }
  
  public float top()
  {
    return this.top;
  }
  
  public float width()
  {
    return this.right - this.left;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/PDFRect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
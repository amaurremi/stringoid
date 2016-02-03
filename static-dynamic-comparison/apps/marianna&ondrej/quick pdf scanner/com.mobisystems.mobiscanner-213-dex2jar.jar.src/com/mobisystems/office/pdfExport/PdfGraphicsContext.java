package com.mobisystems.office.pdfExport;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.io.InputStream;

public class PdfGraphicsContext
{
  private PdfWriter aMl;
  private Matrix aMm = new Matrix();
  private float[] aMn = new float[9];
  
  static
  {
    if (!PdfGraphicsContext.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public PdfGraphicsContext(PdfWriter paramPdfWriter)
  {
    this.aMl = paramPdfWriter;
  }
  
  private void a(Matrix paramMatrix)
  {
    float[] arrayOfFloat = this.aMn;
    paramMatrix.getValues(arrayOfFloat);
    this.aMl.s(arrayOfFloat[0]);
    this.aMl.s(arrayOfFloat[3]);
    this.aMl.s(arrayOfFloat[1]);
    this.aMl.s(arrayOfFloat[4]);
    this.aMl.s(arrayOfFloat[2]);
    this.aMl.s(arrayOfFloat[5]);
    this.aMl.c("cm");
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, Paint paramPaint, String paramString)
  {
    paramBitmap = this.aMl.KB().a(paramBitmap, paramInt, paramString);
    this.aMl.Kx();
    this.aMl.s(paramFloat3);
    this.aMl.eK(0);
    this.aMl.eK(0);
    this.aMl.s(-paramFloat4);
    this.aMl.s(paramFloat1);
    this.aMl.s(paramFloat2 + paramFloat4);
    this.aMl.c("cm");
    this.aMl.KA().a(this.aMl, paramBitmap);
    this.aMl.c("Do");
    this.aMl.Ky();
  }
  
  public void a(InputStream paramInputStream, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, ImageOrientation paramImageOrientation, String paramString)
  {
    paramInputStream = this.aMl.KB().a(paramInputStream, paramInt1, paramInt2, paramString);
    this.aMl.Kx();
    this.aMl.s(paramFloat3);
    this.aMl.eK(0);
    this.aMl.eK(0);
    this.aMl.s(-paramFloat4);
    this.aMl.s(paramFloat1);
    this.aMl.s(paramFloat2 + paramFloat4);
    this.aMl.c("cm");
    switch (1.aMr[paramImageOrientation.ordinal()])
    {
    }
    for (;;)
    {
      this.aMl.KA().a(this.aMl, paramInputStream);
      this.aMl.c("Do");
      this.aMl.Ky();
      return;
      scale(-1.0F, 1.0F, 0.5F, 0.5F);
      continue;
      rotate(180.0F, 0.5F, 0.5F);
      continue;
      scale(1.0F, -1.0F, 0.5F, 0.5F);
      continue;
      rotate(90.0F, 0.5F, 0.5F);
      scale(-1.0F, 1.0F, 0.5F, 0.5F);
      continue;
      rotate(270.0F, 0.5F, 0.5F);
      continue;
      rotate(90.0F, 0.5F, 0.5F);
      scale(1.0F, -1.0F, 0.5F, 0.5F);
      continue;
      rotate(90.0F, 0.5F, 0.5F);
    }
  }
  
  public void rotate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.aMm.setRotate(paramFloat1, paramFloat2, paramFloat3);
    a(this.aMm);
  }
  
  public void scale(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.aMm.setScale(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    a(this.aMm);
  }
  
  public static enum ImageOrientation
  {
    private ImageOrientation() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/office/pdfExport/PdfGraphicsContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
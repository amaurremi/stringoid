package com.mobisystems.mobiscanner.a;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.mobisystems.mobiscanner.common.CommonPreferences.MeasurementUnits;
import com.mobisystems.mobiscanner.common.CommonPreferences.PDFImageDensity;
import com.mobisystems.mobiscanner.common.CommonPreferences.PDFImageQuality;
import com.mobisystems.mobiscanner.common.CommonPreferences.PageOrientation;
import com.mobisystems.mobiscanner.common.CommonPreferences.PageSize;
import com.mobisystems.mobiscanner.image.Image.a;
import com.mobisystems.mobiscanner.image.ImageProcessing;
import com.mobisystems.mobiscanner.model.b;
import com.mobisystems.mobiscanner.model.c;

public class a
{
  private static final float aJW = CommonPreferences.MeasurementUnits.b(1.0F, CommonPreferences.MeasurementUnits.aqe);
  public float aJP = 72.0F;
  public CommonPreferences.PageOrientation aJQ;
  public float aJR;
  public float aJS;
  public float aJT;
  public float aJU;
  public int aJV;
  public float pageHeight;
  public float pageWidth;
  public int quality;
  
  public a(c paramc, Image.a parama)
  {
    Object localObject = paramc.IV();
    int i;
    if (localObject != CommonPreferences.PageSize.auh)
    {
      this.aJQ = paramc.IW();
      this.aJR = S(paramc.IX());
      this.aJS = S(paramc.IZ());
      this.aJT = S(paramc.IY());
      this.aJU = S(paramc.Ja());
      this.quality = paramc.IJ().getValue();
      this.aJV = paramc.IK().getValue();
      if (localObject == CommonPreferences.PageSize.aui)
      {
        this.pageWidth = (parama.width() * this.aJP / this.aJV + this.aJR + this.aJT);
        this.pageHeight = (parama.height() * this.aJP / this.aJV + this.aJS + this.aJU);
        paramc = (c)localObject;
        localObject = new RectF(0.0F, 0.0F, this.pageWidth, this.pageHeight);
        ImageProcessing.c(parama.Ic()).mapRect((RectF)localObject);
        this.pageWidth = ((RectF)localObject).width();
        this.pageHeight = ((RectF)localObject).height();
        if (paramc != CommonPreferences.PageSize.aui)
        {
          paramc = new RectF(0.0F, 0.0F, parama.width(), parama.height());
          ImageProcessing.c(parama.Ic()).mapRect(paramc);
          i = 0;
          switch (1.aJX[this.aJQ.ordinal()])
          {
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        float f = this.pageWidth;
        this.pageWidth = this.pageHeight;
        this.pageHeight = f;
        if ((this.aJR + this.aJT >= this.pageWidth) || (this.aJS + this.aJU >= this.pageHeight))
        {
          f = this.aJS;
          this.aJS = this.aJR;
          this.aJR = this.aJU;
          this.aJU = this.aJT;
          this.aJT = f;
        }
      }
      return;
      if (localObject == CommonPreferences.PageSize.auj)
      {
        this.pageWidth = S(paramc.getWidth());
        this.pageHeight = S(paramc.getHeight());
        paramc = (c)localObject;
        break;
      }
      this.pageWidth = S(((CommonPreferences.PageSize)localObject).getWidth());
      this.pageHeight = S(((CommonPreferences.PageSize)localObject).getHeight());
      paramc = (c)localObject;
      break;
      localObject = paramc.IS();
      paramc = ((b)localObject).IB();
      this.aJQ = ((b)localObject).IE();
      this.aJR = S(((b)localObject).IF());
      this.aJS = S(((b)localObject).IH());
      this.aJT = S(((b)localObject).IG());
      this.aJU = S(((b)localObject).II());
      this.quality = ((b)localObject).IJ().getValue();
      this.aJV = ((b)localObject).IK().getValue();
      if (paramc == CommonPreferences.PageSize.aui)
      {
        this.pageWidth = (parama.width() * this.aJP / this.aJV + this.aJR + this.aJT);
        this.pageHeight = (parama.height() * this.aJP / this.aJV + this.aJS + this.aJU);
        break;
      }
      if (paramc == CommonPreferences.PageSize.auj)
      {
        this.pageWidth = S(((b)localObject).IC());
        this.pageHeight = S(((b)localObject).ID());
        break;
      }
      this.pageWidth = S(paramc.getWidth());
      this.pageHeight = S(paramc.getHeight());
      break;
      if ((paramc.width() - paramc.height()) * (this.pageWidth - this.pageHeight) < 0.0F)
      {
        i = 1;
        continue;
        if (this.pageHeight < this.pageWidth)
        {
          i = 1;
          continue;
          if (this.pageHeight > this.pageWidth) {
            i = 1;
          }
        }
      }
    }
  }
  
  private static float S(float paramFloat)
  {
    return (float)Math.floor(72.0F * paramFloat / aJW);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
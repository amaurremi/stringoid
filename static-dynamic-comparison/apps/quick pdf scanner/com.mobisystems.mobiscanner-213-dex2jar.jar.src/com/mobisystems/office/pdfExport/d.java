package com.mobisystems.office.pdfExport;

import android.graphics.Bitmap;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

public class d
  extends i.a
{
  private WeakReference<f> aMc;
  private Bitmap aMd;
  private int aMe;
  private boolean aMf = false;
  
  public d(String paramString, Bitmap paramBitmap, int paramInt)
  {
    super(paramString);
    this.aMd = paramBitmap;
    this.aMe = paramInt;
  }
  
  private void Kc()
  {
    this.aMd = null;
  }
  
  private void f(PdfWriter paramPdfWriter)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    Object localObject1 = localObject4;
    int m;
    int i;
    int j;
    for (;;)
    {
      try
      {
        k = this.aMd.getWidth();
        localObject2 = localObject3;
        localObject1 = localObject4;
        m = this.aMd.getHeight();
        localObject2 = localObject3;
        localObject1 = localObject4;
        paramPdfWriter = paramPdfWriter.R(k, m);
        i = 0;
      }
      catch (IOException paramPdfWriter)
      {
        int k;
        localObject1 = localObject2;
        throw new PdfWriter.WriteException(paramPdfWriter);
      }
      finally
      {
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((OutputStream)localObject1).close();
          throw paramPdfWriter;
        }
        catch (IOException paramPdfWriter)
        {
          throw new PdfWriter.WriteException(paramPdfWriter);
        }
      }
      if (j >= k) {
        break label174;
      }
      localObject2 = paramPdfWriter;
      localObject1 = paramPdfWriter;
      paramPdfWriter.write(this.aMd.getPixel(j, i) >>> 24);
      j += 1;
    }
    label174:
    label179:
    for (;;)
    {
      localObject2 = paramPdfWriter;
      localObject1 = paramPdfWriter;
      Kc();
      if (paramPdfWriter != null) {}
      try
      {
        paramPdfWriter.close();
        return;
      }
      catch (IOException paramPdfWriter)
      {
        throw new PdfWriter.WriteException(paramPdfWriter);
      }
      for (;;)
      {
        if (i >= m) {
          break label179;
        }
        j = 0;
        break;
        i += 1;
      }
    }
  }
  
  protected void d(PdfWriter paramPdfWriter)
  {
    try
    {
      if (this.aMc != null) {
        break label67;
      }
      localObject1 = null;
    }
    catch (IOException localIOException2)
    {
      paramPdfWriter = null;
      localObject1 = paramPdfWriter;
      try
      {
        localIOException2.printStackTrace();
        localObject1 = paramPdfWriter;
        throw new PdfWriter.WriteException(localIOException2);
      }
      finally {}
      if (0 == 0) {
        break label57;
      }
    }
    catch (Exception localException1) {}finally
    {
      for (;;)
      {
        Object localObject1;
        label57:
        label67:
        Object localObject2;
        PdfWriter localPdfWriter = null;
      }
    }
    if (this.aMd == null) {
      throw new IOException();
    }
  }
  
  protected void e(PdfWriter paramPdfWriter)
  {
    if ((this.aMd != null) && (!this.aMd.hasAlpha())) {}
  }
  
  public class a
    extends f
  {
    protected void d(PdfWriter paramPdfWriter)
    {
      d.a(this.aMg, paramPdfWriter);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/office/pdfExport/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.mobisystems.mobiscanner.image;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.common.d;
import com.mobisystems.pdf.PDFDocument;
import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.PDFPage;

public class f
  extends e
{
  private final Image.RestrictMemory aIn;
  private final PDFDocument mDocument;
  private final c mLog = new c(this);
  
  public f(Context paramContext, FragmentManager paramFragmentManager, PDFDocument paramPDFDocument)
  {
    super(paramContext);
    this.mDocument = paramPDFDocument;
    paramPDFDocument = new d.a(paramContext, "page_thumbnails");
    paramPDFDocument.D(0.15F);
    b(paramFragmentManager, "page_thumbnails", paramPDFDocument);
    this.aIn = az(paramContext);
  }
  
  private Image.RestrictMemory az(Context paramContext)
  {
    return Image.RestrictMemory.aHx;
  }
  
  private int dQ(String paramString)
  {
    return Integer.parseInt(paramString.substring(0, paramString.indexOf('_')));
  }
  
  private String h(int paramInt, long paramLong)
  {
    return String.valueOf(paramInt) + "_" + "tmp";
  }
  
  public void a(int paramInt, long paramLong, View paramView)
  {
    a(h(paramInt, paramLong), paramView);
  }
  
  protected BitmapDrawable h(String paramString, int paramInt1, int paramInt2)
  {
    BitmapDrawable localBitmapDrawable = null;
    this.mLog.dl("loadBitmap called for image: " + paramString + " ; reqWidth = " + paramInt1 + "; reqHeight = " + paramInt2);
    paramInt1 = d.c(this.mContext, 100);
    paramInt2 = d.c(this.mContext, 100);
    int i;
    if ((this.aHM == null) || (0 == 0)) {
      i = dQ(paramString);
    }
    for (;;)
    {
      try
      {
        paramString = new PDFPage(this.mDocument);
        paramString.open(i);
        paramString = paramString.loadBitmap(paramString.makeTransformMappingContentToRect(0.0F, 0.0F, paramInt1, paramInt2), paramInt1, paramInt2);
        if (paramString != null)
        {
          localBitmapDrawable = e(paramString);
          if (this.aHM == null) {}
        }
        return localBitmapDrawable;
      }
      catch (PDFError paramString)
      {
        paramString.printStackTrace();
      }
      paramString = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/image/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
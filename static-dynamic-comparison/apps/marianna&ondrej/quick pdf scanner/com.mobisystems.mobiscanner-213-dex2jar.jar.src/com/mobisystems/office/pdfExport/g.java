package com.mobisystems.office.pdfExport;

import com.mobisystems.list.IntArrayList;

public class g
  extends f
{
  private IntArrayList aMk = new IntArrayList();
  
  protected void d(PdfWriter paramPdfWriter)
  {
    paramPdfWriter.Ki();
    paramPdfWriter.dU("Pages");
    paramPdfWriter.b("Kids");
    paramPdfWriter.beginArray();
    int i = 0;
    int j = this.aMk.size();
    while (i < j)
    {
      paramPdfWriter.gH(this.aMk.get(i));
      i += 1;
    }
    paramPdfWriter.endArray();
    paramPdfWriter.b("Count");
    paramPdfWriter.eK(this.aMk.size());
    paramPdfWriter.Kj();
  }
  
  void gC(int paramInt)
  {
    this.aMk.fN(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/office/pdfExport/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
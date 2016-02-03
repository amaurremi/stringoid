package com.mobisystems.office.pdfExport;

public class a
  extends j
{
  private int aLZ;
  private int aMa;
  
  protected int Ka()
  {
    return this.aLZ ^ this.aMa;
  }
  
  protected void a(PdfWriter paramPdfWriter)
  {
    paramPdfWriter.s(this.aLZ / this.aMa);
  }
  
  protected boolean aA(Object paramObject)
  {
    paramObject = (a)paramObject;
    return (this.aLZ == ((a)paramObject).aLZ) && (this.aMa == ((a)paramObject).aMa);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/office/pdfExport/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
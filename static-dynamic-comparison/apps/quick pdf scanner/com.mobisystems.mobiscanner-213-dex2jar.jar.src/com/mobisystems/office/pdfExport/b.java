package com.mobisystems.office.pdfExport;

public abstract class b
  implements Cloneable
{
  public b Kb()
  {
    try
    {
      b localb = (b)super.clone();
      return localb;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public void b(PdfWriter paramPdfWriter)
  {
    paramPdfWriter.Ki();
    c(paramPdfWriter);
    paramPdfWriter.Kj();
  }
  
  protected abstract void c(PdfWriter paramPdfWriter);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/office/pdfExport/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
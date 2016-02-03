package com.mobisystems.office.pdfExport;

public abstract class j
  extends b
{
  private String aNl;
  
  protected abstract int Ka();
  
  protected abstract void a(PdfWriter paramPdfWriter);
  
  protected abstract boolean aA(Object paramObject);
  
  protected void c(PdfWriter paramPdfWriter)
  {
    paramPdfWriter.b(this.aNl);
    a(paramPdfWriter);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!getClass().equals(paramObject.getClass())) {
      return false;
    }
    j localj = (j)paramObject;
    if (!this.aNl.equals(localj.aNl)) {
      return false;
    }
    return aA(paramObject);
  }
  
  public int hashCode()
  {
    return this.aNl.hashCode() ^ Ka();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/office/pdfExport/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.mobisystems.office.pdfExport;

public class f
{
  private int aMi = -1;
  private int aMj = -1;
  
  static
  {
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public final int Kd()
  {
    return this.aMi;
  }
  
  public final boolean Ke()
  {
    return this.aMi == -1;
  }
  
  final void a(int paramInt, PdfWriter paramPdfWriter)
  {
    assert (paramInt >= 0);
    this.aMi = paramInt;
    d(paramPdfWriter);
  }
  
  public final void cancel()
  {
    if (this.aMi >= 0) {
      throw new IllegalStateException();
    }
    this.aMi = -2;
  }
  
  protected void d(PdfWriter paramPdfWriter) {}
  
  public final int getId()
  {
    return this.aMj;
  }
  
  public final boolean isCanceled()
  {
    return this.aMi == -2;
  }
  
  final void setId(int paramInt)
  {
    this.aMj = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/office/pdfExport/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.mobisystems.pdf;

import com.mobisystems.pdf.actions.PDFAction;

public class PDFOutline
{
  PDFDocument _document;
  long _handle;
  
  public PDFOutline(PDFDocument paramPDFDocument)
  {
    this._document = paramPDFDocument;
    PDFError.throwError(init(paramPDFDocument._handle));
  }
  
  private native void destroy();
  
  private native int init(long paramLong);
  
  public native int count();
  
  protected void finalize()
  {
    destroy();
    super.finalize();
  }
  
  public native Item get(int paramInt);
  
  public static class Item
  {
    private long _handle = 0L;
    
    public native PDFAction action();
    
    public native boolean isBold();
    
    public native boolean isExpandable();
    
    public native boolean isExpanded();
    
    public native boolean isItalic();
    
    public native int nestingLevel();
    
    public native void setExpanded(boolean paramBoolean);
    
    public native String text();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/PDFOutline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
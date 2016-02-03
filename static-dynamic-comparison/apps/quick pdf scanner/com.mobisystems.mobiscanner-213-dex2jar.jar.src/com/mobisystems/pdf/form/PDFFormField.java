package com.mobisystems.pdf.form;

import com.mobisystems.pdf.PDFError;

public class PDFFormField
{
  private long _handle = 0L;
  
  public PDFFormField() {}
  
  public PDFFormField(long paramLong)
  {
    PDFError.throwError(init(paramLong));
  }
  
  private native void destroy();
  
  protected void finalize()
  {
    destroy();
    super.finalize();
  }
  
  public long getHandle()
  {
    return this._handle;
  }
  
  public native int init(long paramLong);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/form/PDFFormField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
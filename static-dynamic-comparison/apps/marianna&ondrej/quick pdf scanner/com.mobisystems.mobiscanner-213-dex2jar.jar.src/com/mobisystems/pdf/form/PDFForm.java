package com.mobisystems.pdf.form;

import com.mobisystems.pdf.PDFDocument;
import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.signatures.PDFSignatureFormField;

public class PDFForm
{
  private long _handle = 0L;
  
  public PDFForm(PDFDocument paramPDFDocument)
  {
    PDFError.throwError(init(paramPDFDocument.getHandle()));
  }
  
  private native int addInvisibleSignatureFieldNative(PDFSignatureFormField paramPDFSignatureFormField);
  
  private native void destroy();
  
  private native int init(long paramLong);
  
  public PDFSignatureFormField addInvisibleSignatureField()
  {
    PDFSignatureFormField localPDFSignatureFormField = new PDFSignatureFormField();
    PDFError.throwError(addInvisibleSignatureFieldNative(localPDFSignatureFormField));
    return localPDFSignatureFormField;
  }
  
  protected void finalize()
  {
    destroy();
    super.finalize();
  }
  
  public long getHandle()
  {
    return this._handle;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/form/PDFForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
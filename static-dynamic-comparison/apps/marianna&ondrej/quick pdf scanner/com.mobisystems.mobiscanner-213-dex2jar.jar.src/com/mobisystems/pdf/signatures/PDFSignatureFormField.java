package com.mobisystems.pdf.signatures;

import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.form.PDFFormField;

public class PDFSignatureFormField
  extends PDFFormField
{
  public PDFSignatureFormField() {}
  
  public PDFSignatureFormField(long paramLong)
  {
    super(paramLong);
  }
  
  private native int signNative(long paramLong1, long paramLong2, String paramString);
  
  public void sign(PDFPrivateKeyImpl paramPDFPrivateKeyImpl, PDFSigningInfo paramPDFSigningInfo, String paramString)
  {
    if (paramPDFPrivateKeyImpl != null) {}
    for (long l = paramPDFPrivateKeyImpl.getHandle();; l = 0L)
    {
      PDFError.throwError(signNative(l, paramPDFSigningInfo.getHandle(), paramString));
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/signatures/PDFSignatureFormField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
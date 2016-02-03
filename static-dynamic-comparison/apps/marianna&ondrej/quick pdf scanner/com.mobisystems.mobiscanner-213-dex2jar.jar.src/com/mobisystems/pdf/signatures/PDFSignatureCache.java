package com.mobisystems.pdf.signatures;

import com.mobisystems.pdf.PDFDocument;
import com.mobisystems.pdf.PDFError;

public class PDFSignatureCache
{
  private long _handle = 0L;
  
  public PDFSignatureCache(PDFDocument paramPDFDocument)
  {
    PDFError.throwError(init(paramPDFDocument.getHandle()));
  }
  
  private native void destroy();
  
  private native long findNext(long paramLong);
  
  private native long findPrev(long paramLong);
  
  private native int init(long paramLong);
  
  private native int verifyAllSignaturesNative(boolean paramBoolean);
  
  protected void finalize()
  {
    destroy();
    super.finalize();
  }
  
  public PDFSignature findNext(PDFSignature paramPDFSignature)
  {
    if (paramPDFSignature != null) {}
    for (long l = paramPDFSignature.getHandle();; l = 0L)
    {
      l = findNext(l);
      if (l == 0L) {
        break;
      }
      return new PDFSignature(l);
    }
    return null;
  }
  
  public PDFSignature findPrev(PDFSignature paramPDFSignature)
  {
    if (paramPDFSignature != null) {}
    for (long l = paramPDFSignature.getHandle();; l = 0L)
    {
      l = findNext(l);
      if (l == 0L) {
        break;
      }
      return new PDFSignature(l);
    }
    return null;
  }
  
  public long getHandle()
  {
    return this._handle;
  }
  
  public void verifyAllSignatures(boolean paramBoolean)
  {
    PDFError.throwError(verifyAllSignaturesNative(paramBoolean));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/signatures/PDFSignatureCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.mobisystems.pdf.ui;

import com.mobisystems.pdf.PDFDocument;

public abstract interface SignatureActivity
{
  public abstract PDFDocument getDocument();
  
  public static abstract interface Observer
  {
    public abstract void onDocumentChanged(PDFDocument paramPDFDocument);
    
    public abstract void signInvisible();
    
    public abstract void timeStampInvisible();
    
    public abstract void verifyAllSignatures();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/SignatureActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
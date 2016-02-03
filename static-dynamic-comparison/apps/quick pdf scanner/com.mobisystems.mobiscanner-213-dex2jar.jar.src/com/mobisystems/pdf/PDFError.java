package com.mobisystems.pdf;

public class PDFError
  extends Exception
{
  public static final int PDF_ERR_ACCESS_DENIED = -993;
  public static final int PDF_ERR_CORRUPTED = -995;
  public static final int PDF_ERR_HTTP_REQUEST = -987;
  public static final int PDF_ERR_INVALID_ARGUMENT = -996;
  public static final int PDF_ERR_INVALID_CERTIFICATE = -986;
  public static final int PDF_ERR_INVALID_TIMESTAMP = -985;
  public static final int PDF_ERR_IN_USE = -994;
  public static final int PDF_ERR_NONE = 0;
  public static final int PDF_ERR_NOT_FOUND = -998;
  public static final int PDF_ERR_NOT_IMPLEMENTED = -997;
  public static final int PDF_ERR_NO_MEMORY = -1000;
  public static final int PDF_ERR_STACK_OVERFLOW = -992;
  public static final int PDF_ERR_STACK_UNDERFLOW = -991;
  public static final int PDF_ERR_STORAGE_FULL = -988;
  public static final int PDF_ERR_UNEXPECTED = -999;
  public static final int PDF_ERR_UNSUPPORTED = -989;
  public static final int PDF_ERR_UNSUPPORTED_ENCRYPTION_METHOD = -990;
  private static final long serialVersionUID = -8395288981277885156L;
  int _errorCode;
  
  public PDFError(int paramInt)
  {
    super(getDescription(paramInt));
    this._errorCode = paramInt;
  }
  
  public PDFError(int paramInt, Throwable paramThrowable)
  {
    super(getDescription(paramInt), paramThrowable);
    this._errorCode = paramInt;
  }
  
  public static String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Unknown error: " + paramInt;
    case 0: 
      return "No error";
    case -1000: 
      return "No enough memory";
    case -997: 
      return "Not implemented";
    case -999: 
    case -998: 
    case -996: 
    case -995: 
    case -992: 
    case -991: 
      return "File is corrupted";
    case -994: 
      return "In use";
    case -993: 
      return "Access denied";
    case -990: 
      return "Used encription method is not supported.";
    case -989: 
      return "Document contains unsupported objects.";
    case -988: 
      return "Storage is full";
    case -987: 
      return "HTTP request error";
    case -986: 
      return "Invalid certificate";
    }
    return "Invalid timestamp";
  }
  
  public static void throwError(int paramInt)
  {
    if (paramInt != 0) {
      throw new PDFError(paramInt);
    }
  }
  
  public static void throwError(int paramInt, Throwable paramThrowable)
  {
    if (paramInt != 0) {
      throw new PDFError(paramInt, paramThrowable);
    }
  }
  
  public int errorCode()
  {
    return this._errorCode;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/PDFError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
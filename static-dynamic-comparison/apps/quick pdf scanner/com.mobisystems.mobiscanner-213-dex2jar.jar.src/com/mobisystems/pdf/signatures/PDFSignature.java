package com.mobisystems.pdf.signatures;

import com.mobisystems.pdf.PDFError;

public class PDFSignature
{
  private long _handle = 0L;
  
  public PDFSignature(long paramLong)
  {
    PDFError.throwError(init(paramLong));
  }
  
  private native void destroy();
  
  private native int init(long paramLong);
  
  protected void finalize()
  {
    destroy();
    super.finalize();
  }
  
  public long getHandle()
  {
    return this._handle;
  }
  
  public native int getModStatus();
  
  public native String getSignerContactInfo();
  
  public native String getSignerName();
  
  public native String getSigningLocation();
  
  public native String getSigningReason();
  
  public native String getSigningTime();
  
  public native int getStatus();
  
  public native int getType();
  
  public class ModStatus
  {
    public static final int FAILURE = 2;
    public static final int INVALID_REVISION = 4;
    public static final int OK = 1;
    public static final int UNEXPECTED = 3;
    public static final int UNKNOWN = 0;
    
    public ModStatus() {}
  }
  
  public class Status
  {
    public static final int INVALID = 3;
    public static final int NOT_SIGNED = 1;
    public static final int UNKNOWN = 0;
    public static final int VERIFIED = 2;
    
    public Status() {}
  }
  
  public class Type
  {
    public static final int APPROVAL = 2;
    public static final int CERTIFICATION = 1;
    public static final int TIME_STAMP = 4;
    public static final int UNKNOWN = 0;
    public static final int USAGE_RIGHTS = 3;
    
    public Type() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/signatures/PDFSignature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
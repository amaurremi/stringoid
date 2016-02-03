package com.mobisystems.pdf.signatures;

import com.mobisystems.pdf.PDFError;

public class PDFSigningInfo
{
  private long _handle = 0L;
  
  public PDFSigningInfo()
  {
    PDFError.throwError(init());
  }
  
  private native int addLockFieldNative(String paramString);
  
  private native void destroy();
  
  private native int init();
  
  private native int setAddRevInfoNative(boolean paramBoolean);
  
  private native int setContactInfoNative(String paramString);
  
  private native int setCreateTimestampNative(boolean paramBoolean);
  
  private native int setDigestAlgorithmNative(int paramInt);
  
  private native int setEncryptAlgorithmNative(int paramInt);
  
  private native int setFilterNative(int paramInt);
  
  private native int setLegalAttestationNative(String paramString);
  
  private native int setLocationNative(String paramString);
  
  private native int setLockActionNative(int paramInt);
  
  private native int setMdpPermissionsNative(int paramInt);
  
  private native int setNameNative(String paramString);
  
  private native int setReasonNative(String paramString);
  
  private native int setSubFilterNative(int paramInt);
  
  private native int setTimeNative(String paramString);
  
  private native int setTimeStampServerURLNative(String paramString);
  
  private native int setTypeNative(int paramInt);
  
  public void addLockField(String paramString)
  {
    PDFError.throwError(addLockFieldNative(paramString));
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
  
  public void setAddRevInfo(boolean paramBoolean)
  {
    PDFError.throwError(setAddRevInfoNative(paramBoolean));
  }
  
  public void setContactInfo(String paramString)
  {
    PDFError.throwError(setContactInfoNative(paramString));
  }
  
  public void setCreateTimestamp(boolean paramBoolean)
  {
    PDFError.throwError(setCreateTimestampNative(paramBoolean));
  }
  
  public void setDigestAlgorithm(int paramInt)
  {
    PDFError.throwError(setDigestAlgorithmNative(paramInt));
  }
  
  public void setEncryptAlgorithm(int paramInt)
  {
    PDFError.throwError(setEncryptAlgorithmNative(paramInt));
  }
  
  public void setFilter(int paramInt)
  {
    PDFError.throwError(setFilterNative(paramInt));
  }
  
  public void setLegalAttestation(String paramString)
  {
    PDFError.throwError(setLegalAttestationNative(paramString));
  }
  
  public void setLocation(String paramString)
  {
    PDFError.throwError(setLocationNative(paramString));
  }
  
  public void setLockAction(int paramInt)
  {
    PDFError.throwError(setLockActionNative(paramInt));
  }
  
  public void setMdpPermissions(int paramInt)
  {
    PDFError.throwError(setMdpPermissionsNative(paramInt));
  }
  
  public void setName(String paramString)
  {
    PDFError.throwError(setNameNative(paramString));
  }
  
  public void setReason(String paramString)
  {
    PDFError.throwError(setReasonNative(paramString));
  }
  
  public void setSubFilter(int paramInt)
  {
    PDFError.throwError(setSubFilterNative(paramInt));
  }
  
  public void setTime(String paramString)
  {
    PDFError.throwError(setTimeNative(paramString));
  }
  
  public void setTimeStampServerURL(String paramString)
  {
    PDFError.throwError(setTimeStampServerURLNative(paramString));
  }
  
  public void setType(int paramInt)
  {
    PDFError.throwError(setTypeNative(paramInt));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/signatures/PDFSigningInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
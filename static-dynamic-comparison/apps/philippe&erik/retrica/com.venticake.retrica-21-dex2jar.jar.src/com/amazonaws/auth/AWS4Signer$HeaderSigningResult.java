package com.amazonaws.auth;

public class AWS4Signer$HeaderSigningResult
{
  private String dateTime;
  private byte[] kSigning;
  private String scope;
  private byte[] signature;
  
  public AWS4Signer$HeaderSigningResult(String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.dateTime = paramString1;
    this.scope = paramString2;
    this.kSigning = paramArrayOfByte1;
    this.signature = paramArrayOfByte2;
  }
  
  public byte[] getSignature()
  {
    byte[] arrayOfByte = new byte[this.signature.length];
    System.arraycopy(this.signature, 0, arrayOfByte, 0, this.signature.length);
    return arrayOfByte;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/AWS4Signer$HeaderSigningResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
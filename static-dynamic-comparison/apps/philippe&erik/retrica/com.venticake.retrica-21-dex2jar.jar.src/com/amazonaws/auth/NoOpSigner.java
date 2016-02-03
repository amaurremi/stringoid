package com.amazonaws.auth;

import com.amazonaws.Request;

public class NoOpSigner
  implements Signer
{
  public void sign(Request<?> paramRequest, AWSCredentials paramAWSCredentials) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/NoOpSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
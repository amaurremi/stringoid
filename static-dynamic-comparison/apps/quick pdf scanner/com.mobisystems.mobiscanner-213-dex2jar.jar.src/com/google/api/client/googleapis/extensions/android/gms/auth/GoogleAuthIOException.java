package com.google.api.client.googleapis.extensions.android.gms.auth;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.api.client.util.x;
import java.io.IOException;

public class GoogleAuthIOException
  extends IOException
{
  private static final long serialVersionUID = 1L;
  
  GoogleAuthIOException(GoogleAuthException paramGoogleAuthException)
  {
    initCause((Throwable)x.ad(paramGoogleAuthException));
  }
  
  public GoogleAuthException wL()
  {
    return (GoogleAuthException)super.getCause();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/googleapis/extensions/android/gms/auth/GoogleAuthIOException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
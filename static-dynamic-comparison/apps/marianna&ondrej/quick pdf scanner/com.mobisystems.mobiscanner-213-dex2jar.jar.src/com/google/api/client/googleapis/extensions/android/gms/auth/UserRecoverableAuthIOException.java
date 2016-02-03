package com.google.api.client.googleapis.extensions.android.gms.auth;

import android.content.Intent;
import com.google.android.gms.auth.UserRecoverableAuthException;

public class UserRecoverableAuthIOException
  extends GoogleAuthIOException
{
  private static final long serialVersionUID = 1L;
  
  UserRecoverableAuthIOException(UserRecoverableAuthException paramUserRecoverableAuthException)
  {
    super(paramUserRecoverableAuthException);
  }
  
  public final Intent getIntent()
  {
    return wN().getIntent();
  }
  
  public UserRecoverableAuthException wN()
  {
    return (UserRecoverableAuthException)super.wL();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/googleapis/extensions/android/gms/auth/UserRecoverableAuthIOException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package mobi.beyondpod.sync.trackers.bp;

import java.util.Date;

public class AuthenticationResult
{
  public static int AUTH_RESULT_ACCOUNT_CREATED;
  public static int AUTH_RESULT_AUTHENTICATED = 0;
  public static int AUTH_RESULT_AUTHENTICATION_FAILED = 1;
  public static int AUTH_RESULT_EMAIL_VERIFICATION_PENDING;
  public static int AUTH_RESULT_INVALID_EMAIL;
  public static int AUTH_RESULT_PASSWORD_TOO_LONG;
  public static int AUTH_RESULT_SERVER_ERROR = 500;
  public static int AUTH_RESULT_TOO_MANY_USERS;
  public static int AUTH_RESULT_USER_ALREADY_EXISTS;
  private String encryptedPassword;
  Date serverDate;
  private String token;
  private Date tokenExpires;
  private boolean waitingForEmailVerification;
  
  static
  {
    AUTH_RESULT_ACCOUNT_CREATED = 2;
    AUTH_RESULT_USER_ALREADY_EXISTS = 10;
    AUTH_RESULT_INVALID_EMAIL = 20;
    AUTH_RESULT_PASSWORD_TOO_LONG = 21;
    AUTH_RESULT_EMAIL_VERIFICATION_PENDING = 30;
    AUTH_RESULT_TOO_MANY_USERS = 100;
  }
  
  public String getEncryptedPassword()
  {
    return this.encryptedPassword;
  }
  
  public Date getServerDate()
  {
    return this.serverDate;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public Date getTokenExpires()
  {
    return this.tokenExpires;
  }
  
  public boolean isWaitingForEmailVerification()
  {
    return this.waitingForEmailVerification;
  }
  
  public void setEncryptedPassword(String paramString)
  {
    this.encryptedPassword = paramString;
  }
  
  public void setServerDate(Date paramDate)
  {
    this.serverDate = paramDate;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public void setTokenExpires(Date paramDate)
  {
    this.tokenExpires = paramDate;
  }
  
  public void setWaitingForEmailVerification(boolean paramBoolean)
  {
    this.waitingForEmailVerification = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/sync/trackers/bp/AuthenticationResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
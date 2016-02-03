package com.parse;

public class ParseException
  extends Exception
{
  public static final int ACCOUNT_ALREADY_LINKED = 208;
  public static final int CACHE_MISS = 120;
  public static final int COMMAND_UNAVAILABLE = 108;
  public static final int CONNECTION_FAILED = 100;
  public static final int DUPLICATE_VALUE = 137;
  public static final int EMAIL_MISSING = 204;
  public static final int EMAIL_NOT_FOUND = 205;
  public static final int EMAIL_TAKEN = 203;
  public static final int EXCEEDED_QUOTA = 140;
  public static final int FILE_DELETE_ERROR = 153;
  public static final int INCORRECT_TYPE = 111;
  public static final int INTERNAL_SERVER_ERROR = 1;
  public static final int INVALID_ACL = 123;
  public static final int INVALID_CHANNEL_NAME = 112;
  public static final int INVALID_CLASS_NAME = 103;
  public static final int INVALID_EMAIL_ADDRESS = 125;
  public static final int INVALID_FILE_NAME = 122;
  public static final int INVALID_JSON = 107;
  public static final int INVALID_KEY_NAME = 105;
  public static final int INVALID_LINKED_SESSION = 251;
  public static final int INVALID_NESTED_KEY = 121;
  public static final int INVALID_POINTER = 106;
  public static final int INVALID_QUERY = 102;
  public static final int INVALID_ROLE_NAME = 139;
  public static final int LINKED_ID_MISSING = 250;
  public static final int MISSING_OBJECT_ID = 104;
  public static final int MUST_CREATE_USER_THROUGH_SIGNUP = 207;
  public static final int NOT_INITIALIZED = 109;
  public static final int OBJECT_NOT_FOUND = 101;
  public static final int OBJECT_TOO_LARGE = 116;
  public static final int OPERATION_FORBIDDEN = 119;
  public static final int OTHER_CAUSE = -1;
  public static final int PASSWORD_MISSING = 201;
  public static final int PUSH_MISCONFIGURED = 115;
  public static final int SCRIPT_ERROR = 141;
  public static final int SESSION_MISSING = 206;
  public static final int TIMEOUT = 124;
  public static final int UNSUPPORTED_SERVICE = 252;
  public static final int USERNAME_MISSING = 200;
  public static final int USERNAME_TAKEN = 202;
  public static final int VALIDATION_ERROR = 142;
  private static final long serialVersionUID = 1L;
  private int code;
  
  public ParseException(int paramInt, String paramString)
  {
    super(paramString);
    this.code = paramInt;
  }
  
  public ParseException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.code = -1;
  }
  
  public ParseException(Throwable paramThrowable)
  {
    super(paramThrowable);
    this.code = -1;
  }
  
  public int getCode()
  {
    return this.code;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
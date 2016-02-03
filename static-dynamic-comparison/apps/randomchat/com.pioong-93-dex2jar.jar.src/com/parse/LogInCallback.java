package com.parse;

public abstract class LogInCallback
  extends ParseCallback<ParseUser>
{
  public abstract void done(ParseUser paramParseUser, ParseException paramParseException);
  
  void internalDone(ParseUser paramParseUser, ParseException paramParseException)
  {
    done(paramParseUser, paramParseException);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/LogInCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
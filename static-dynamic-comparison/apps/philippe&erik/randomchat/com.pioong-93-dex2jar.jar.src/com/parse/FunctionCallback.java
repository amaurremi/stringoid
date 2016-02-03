package com.parse;

public abstract class FunctionCallback<T>
  extends ParseCallback<T>
{
  public abstract void done(T paramT, ParseException paramParseException);
  
  final void internalDone(T paramT, ParseException paramParseException)
  {
    done(paramT, paramParseException);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/FunctionCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
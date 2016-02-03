package com.parse;

public abstract class ProgressCallback
  extends ParseCallback<Integer>
{
  Integer maxProgressSoFar = Integer.valueOf(0);
  
  public abstract void done(Integer paramInteger);
  
  final void internalDone(Integer paramInteger, ParseException paramParseException)
  {
    if (paramInteger.intValue() > this.maxProgressSoFar.intValue())
    {
      this.maxProgressSoFar = paramInteger;
      done(paramInteger);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ProgressCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
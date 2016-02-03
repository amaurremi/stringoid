package com.parse;

import java.util.List;

public abstract class FindCallback<T extends ParseObject>
  extends ParseCallback<List<T>>
{
  public abstract void done(List<T> paramList, ParseException paramParseException);
  
  final void internalDone(List<T> paramList, ParseException paramParseException)
  {
    done(paramList, paramParseException);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/FindCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
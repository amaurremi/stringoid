package com.parse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class ParseMulticastDelegate<T>
{
  private final List<ParseCallback<T>> callbacks = new LinkedList();
  
  public void clear()
  {
    this.callbacks.clear();
  }
  
  public void invoke(T paramT, ParseException paramParseException)
  {
    Iterator localIterator = new ArrayList(this.callbacks).iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((ParseCallback)localIterator.next()).internalDone(paramT, paramParseException);
    }
  }
  
  public void subscribe(ParseCallback<T> paramParseCallback)
  {
    this.callbacks.add(paramParseCallback);
  }
  
  public void unsubscribe(ParseCallback<T> paramParseCallback)
  {
    this.callbacks.remove(paramParseCallback);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseMulticastDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
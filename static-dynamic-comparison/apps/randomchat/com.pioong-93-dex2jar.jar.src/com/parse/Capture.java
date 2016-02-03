package com.parse;

class Capture<T>
{
  private T value;
  
  public Capture() {}
  
  public Capture(T paramT)
  {
    this.value = paramT;
  }
  
  public T get()
  {
    return (T)this.value;
  }
  
  public void set(T paramT)
  {
    this.value = paramT;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/Capture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
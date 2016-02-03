package com.venticake.retrica.view.album;

public abstract interface Cancelable<T>
{
  public abstract void await();
  
  public abstract T get();
  
  public abstract boolean requestCancel();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/Cancelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
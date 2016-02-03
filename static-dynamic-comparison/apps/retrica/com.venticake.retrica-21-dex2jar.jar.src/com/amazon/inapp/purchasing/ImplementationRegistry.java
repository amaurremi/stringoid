package com.amazon.inapp.purchasing;

abstract interface ImplementationRegistry
{
  public abstract <T> Class<T> getImplementation(Class<T> paramClass);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/ImplementationRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
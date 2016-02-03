package com.fasterxml.jackson.annotation;

abstract class ObjectIdGenerators$Base<T>
  extends ObjectIdGenerator<T>
{
  protected final Class<?> _scope;
  
  protected ObjectIdGenerators$Base(Class<?> paramClass)
  {
    this._scope = paramClass;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/annotation/ObjectIdGenerators$Base.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
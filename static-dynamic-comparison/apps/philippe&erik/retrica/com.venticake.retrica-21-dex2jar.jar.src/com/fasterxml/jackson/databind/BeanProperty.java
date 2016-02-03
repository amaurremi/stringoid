package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;

public abstract interface BeanProperty
{
  public abstract AnnotatedMember getMember();
  
  public abstract JavaType getType();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/BeanProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
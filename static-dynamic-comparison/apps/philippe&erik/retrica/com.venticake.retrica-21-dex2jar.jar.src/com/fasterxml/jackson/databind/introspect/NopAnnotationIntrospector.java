package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import java.io.Serializable;

public abstract class NopAnnotationIntrospector
  extends AnnotationIntrospector
  implements Serializable
{
  public static final NopAnnotationIntrospector instance = new NopAnnotationIntrospector() {};
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/introspect/NopAnnotationIntrospector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
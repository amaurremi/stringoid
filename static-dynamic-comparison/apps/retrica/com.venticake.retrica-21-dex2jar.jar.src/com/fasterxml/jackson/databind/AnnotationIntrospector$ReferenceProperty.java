package com.fasterxml.jackson.databind;

public class AnnotationIntrospector$ReferenceProperty
{
  private final String _name;
  private final AnnotationIntrospector.ReferenceProperty.Type _type;
  
  public AnnotationIntrospector$ReferenceProperty(AnnotationIntrospector.ReferenceProperty.Type paramType, String paramString)
  {
    this._type = paramType;
    this._name = paramString;
  }
  
  public static ReferenceProperty back(String paramString)
  {
    return new ReferenceProperty(AnnotationIntrospector.ReferenceProperty.Type.BACK_REFERENCE, paramString);
  }
  
  public static ReferenceProperty managed(String paramString)
  {
    return new ReferenceProperty(AnnotationIntrospector.ReferenceProperty.Type.MANAGED_REFERENCE, paramString);
  }
  
  public String getName()
  {
    return this._name;
  }
  
  public boolean isBackReference()
  {
    return this._type == AnnotationIntrospector.ReferenceProperty.Type.BACK_REFERENCE;
  }
  
  public boolean isManagedReference()
  {
    return this._type == AnnotationIntrospector.ReferenceProperty.Type.MANAGED_REFERENCE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/AnnotationIntrospector$ReferenceProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
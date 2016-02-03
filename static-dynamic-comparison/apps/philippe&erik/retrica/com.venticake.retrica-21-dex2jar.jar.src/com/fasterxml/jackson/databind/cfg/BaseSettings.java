package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class BaseSettings
  implements Serializable
{
  protected final AnnotationIntrospector _annotationIntrospector;
  protected final ClassIntrospector _classIntrospector;
  protected final DateFormat _dateFormat;
  protected final Base64Variant _defaultBase64;
  protected final HandlerInstantiator _handlerInstantiator;
  protected final Locale _locale;
  protected final PropertyNamingStrategy _propertyNamingStrategy;
  protected final TimeZone _timeZone;
  protected final TypeFactory _typeFactory;
  protected final TypeResolverBuilder<?> _typeResolverBuilder;
  protected final VisibilityChecker<?> _visibilityChecker;
  
  public BaseSettings(ClassIntrospector paramClassIntrospector, AnnotationIntrospector paramAnnotationIntrospector, VisibilityChecker<?> paramVisibilityChecker, PropertyNamingStrategy paramPropertyNamingStrategy, TypeFactory paramTypeFactory, TypeResolverBuilder<?> paramTypeResolverBuilder, DateFormat paramDateFormat, HandlerInstantiator paramHandlerInstantiator, Locale paramLocale, TimeZone paramTimeZone, Base64Variant paramBase64Variant)
  {
    this._classIntrospector = paramClassIntrospector;
    this._annotationIntrospector = paramAnnotationIntrospector;
    this._visibilityChecker = paramVisibilityChecker;
    this._propertyNamingStrategy = paramPropertyNamingStrategy;
    this._typeFactory = paramTypeFactory;
    this._typeResolverBuilder = paramTypeResolverBuilder;
    this._dateFormat = paramDateFormat;
    this._handlerInstantiator = paramHandlerInstantiator;
    this._locale = paramLocale;
    this._timeZone = paramTimeZone;
    this._defaultBase64 = paramBase64Variant;
  }
  
  public AnnotationIntrospector getAnnotationIntrospector()
  {
    return this._annotationIntrospector;
  }
  
  public Base64Variant getBase64Variant()
  {
    return this._defaultBase64;
  }
  
  public ClassIntrospector getClassIntrospector()
  {
    return this._classIntrospector;
  }
  
  public DateFormat getDateFormat()
  {
    return this._dateFormat;
  }
  
  public HandlerInstantiator getHandlerInstantiator()
  {
    return this._handlerInstantiator;
  }
  
  public Locale getLocale()
  {
    return this._locale;
  }
  
  public PropertyNamingStrategy getPropertyNamingStrategy()
  {
    return this._propertyNamingStrategy;
  }
  
  public TimeZone getTimeZone()
  {
    return this._timeZone;
  }
  
  public TypeFactory getTypeFactory()
  {
    return this._typeFactory;
  }
  
  public TypeResolverBuilder<?> getTypeResolverBuilder()
  {
    return this._typeResolverBuilder;
  }
  
  public VisibilityChecker<?> getVisibilityChecker()
  {
    return this._visibilityChecker;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/cfg/BaseSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
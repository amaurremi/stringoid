package org.codehaus.jackson.map;

import java.text.DateFormat;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.type.TypeFactory;

public class MapperConfig$Base
{
  protected final AnnotationIntrospector _annotationIntrospector;
  protected final ClassIntrospector _classIntrospector;
  protected final DateFormat _dateFormat;
  protected final HandlerInstantiator _handlerInstantiator;
  protected final PropertyNamingStrategy _propertyNamingStrategy;
  protected final TypeFactory _typeFactory;
  protected final TypeResolverBuilder _typeResolverBuilder;
  protected final VisibilityChecker _visibilityChecker;
  
  public MapperConfig$Base(ClassIntrospector paramClassIntrospector, AnnotationIntrospector paramAnnotationIntrospector, VisibilityChecker paramVisibilityChecker, PropertyNamingStrategy paramPropertyNamingStrategy, TypeFactory paramTypeFactory, TypeResolverBuilder paramTypeResolverBuilder, DateFormat paramDateFormat, HandlerInstantiator paramHandlerInstantiator)
  {
    this._classIntrospector = paramClassIntrospector;
    this._annotationIntrospector = paramAnnotationIntrospector;
    this._visibilityChecker = paramVisibilityChecker;
    this._propertyNamingStrategy = paramPropertyNamingStrategy;
    this._typeFactory = paramTypeFactory;
    this._typeResolverBuilder = paramTypeResolverBuilder;
    this._dateFormat = paramDateFormat;
    this._handlerInstantiator = paramHandlerInstantiator;
  }
  
  public AnnotationIntrospector getAnnotationIntrospector()
  {
    return this._annotationIntrospector;
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
  
  public PropertyNamingStrategy getPropertyNamingStrategy()
  {
    return this._propertyNamingStrategy;
  }
  
  public TypeFactory getTypeFactory()
  {
    return this._typeFactory;
  }
  
  public TypeResolverBuilder getTypeResolverBuilder()
  {
    return this._typeResolverBuilder;
  }
  
  public VisibilityChecker getVisibilityChecker()
  {
    return this._visibilityChecker;
  }
  
  public Base withAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    return new Base(this._classIntrospector, paramAnnotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator);
  }
  
  public Base withAppendedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    return withAnnotationIntrospector(AnnotationIntrospector.Pair.create(this._annotationIntrospector, paramAnnotationIntrospector));
  }
  
  public Base withClassIntrospector(ClassIntrospector paramClassIntrospector)
  {
    return new Base(paramClassIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator);
  }
  
  public Base withDateFormat(DateFormat paramDateFormat)
  {
    return new Base(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, paramDateFormat, this._handlerInstantiator);
  }
  
  public Base withHandlerInstantiator(HandlerInstantiator paramHandlerInstantiator)
  {
    return new Base(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, paramHandlerInstantiator);
  }
  
  public Base withInsertedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    return withAnnotationIntrospector(AnnotationIntrospector.Pair.create(paramAnnotationIntrospector, this._annotationIntrospector));
  }
  
  public Base withPropertyNamingStrategy(PropertyNamingStrategy paramPropertyNamingStrategy)
  {
    return new Base(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, paramPropertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator);
  }
  
  public Base withTypeFactory(TypeFactory paramTypeFactory)
  {
    return new Base(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, paramTypeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator);
  }
  
  public Base withTypeResolverBuilder(TypeResolverBuilder paramTypeResolverBuilder)
  {
    return new Base(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, paramTypeResolverBuilder, this._dateFormat, this._handlerInstantiator);
  }
  
  public Base withVisibility(JsonMethod paramJsonMethod, JsonAutoDetect.Visibility paramVisibility)
  {
    return new Base(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker.withVisibility(paramJsonMethod, paramVisibility), this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator);
  }
  
  public Base withVisibilityChecker(VisibilityChecker paramVisibilityChecker)
  {
    return new Base(this._classIntrospector, this._annotationIntrospector, paramVisibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/MapperConfig$Base.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public abstract class AnnotatedWithParams
  extends AnnotatedMember
{
  protected final AnnotationMap[] _paramAnnotations;
  
  protected AnnotatedWithParams(AnnotationMap paramAnnotationMap, AnnotationMap[] paramArrayOfAnnotationMap)
  {
    super(paramAnnotationMap);
    this._paramAnnotations = paramArrayOfAnnotationMap;
  }
  
  public final void addOrOverrideParam(int paramInt, Annotation paramAnnotation)
  {
    AnnotationMap localAnnotationMap2 = this._paramAnnotations[paramInt];
    AnnotationMap localAnnotationMap1 = localAnnotationMap2;
    if (localAnnotationMap2 == null)
    {
      localAnnotationMap1 = new AnnotationMap();
      this._paramAnnotations[paramInt] = localAnnotationMap1;
    }
    localAnnotationMap1.add(paramAnnotation);
  }
  
  public abstract Object call();
  
  public abstract Object call(Object[] paramArrayOfObject);
  
  public abstract Object call1(Object paramObject);
  
  public final <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    return this._annotations.get(paramClass);
  }
  
  public abstract Type getGenericParameterType(int paramInt);
  
  public final AnnotatedParameter getParameter(int paramInt)
  {
    return new AnnotatedParameter(this, getGenericParameterType(paramInt), getParameterAnnotations(paramInt), paramInt);
  }
  
  public final AnnotationMap getParameterAnnotations(int paramInt)
  {
    if ((this._paramAnnotations != null) && (paramInt >= 0) && (paramInt <= this._paramAnnotations.length)) {
      return this._paramAnnotations[paramInt];
    }
    return null;
  }
  
  protected JavaType getType(TypeBindings paramTypeBindings, TypeVariable<?>[] paramArrayOfTypeVariable)
  {
    Object localObject = paramTypeBindings;
    if (paramArrayOfTypeVariable != null)
    {
      localObject = paramTypeBindings;
      if (paramArrayOfTypeVariable.length > 0)
      {
        TypeBindings localTypeBindings = paramTypeBindings.childInstance();
        int j = paramArrayOfTypeVariable.length;
        int i = 0;
        localObject = localTypeBindings;
        if (i < j)
        {
          localObject = paramArrayOfTypeVariable[i];
          localTypeBindings._addPlaceholder(((TypeVariable)localObject).getName());
          paramTypeBindings = localObject.getBounds()[0];
          if (paramTypeBindings == null) {}
          for (paramTypeBindings = TypeFactory.unknownType();; paramTypeBindings = localTypeBindings.resolveType(paramTypeBindings))
          {
            localTypeBindings.addBinding(((TypeVariable)localObject).getName(), paramTypeBindings);
            i += 1;
            break;
          }
        }
      }
    }
    return ((TypeBindings)localObject).resolveType(getGenericType());
  }
  
  protected AnnotatedParameter replaceParameterAnnotations(int paramInt, AnnotationMap paramAnnotationMap)
  {
    this._paramAnnotations[paramInt] = paramAnnotationMap;
    return getParameter(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/introspect/AnnotatedWithParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
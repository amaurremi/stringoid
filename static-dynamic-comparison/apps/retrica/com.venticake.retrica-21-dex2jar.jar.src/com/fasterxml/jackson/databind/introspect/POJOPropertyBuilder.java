package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;

public class POJOPropertyBuilder
  extends BeanPropertyDefinition
  implements Comparable<POJOPropertyBuilder>
{
  protected final AnnotationIntrospector _annotationIntrospector;
  protected POJOPropertyBuilder.Linked<AnnotatedParameter> _ctorParameters;
  protected POJOPropertyBuilder.Linked<AnnotatedField> _fields;
  protected final boolean _forSerialization;
  protected POJOPropertyBuilder.Linked<AnnotatedMethod> _getters;
  protected final String _internalName;
  protected final String _name;
  protected POJOPropertyBuilder.Linked<AnnotatedMethod> _setters;
  
  public POJOPropertyBuilder(POJOPropertyBuilder paramPOJOPropertyBuilder, String paramString)
  {
    this._internalName = paramPOJOPropertyBuilder._internalName;
    this._name = paramString;
    this._annotationIntrospector = paramPOJOPropertyBuilder._annotationIntrospector;
    this._fields = paramPOJOPropertyBuilder._fields;
    this._ctorParameters = paramPOJOPropertyBuilder._ctorParameters;
    this._getters = paramPOJOPropertyBuilder._getters;
    this._setters = paramPOJOPropertyBuilder._setters;
    this._forSerialization = paramPOJOPropertyBuilder._forSerialization;
  }
  
  public POJOPropertyBuilder(String paramString, AnnotationIntrospector paramAnnotationIntrospector, boolean paramBoolean)
  {
    this._internalName = paramString;
    this._name = paramString;
    this._annotationIntrospector = paramAnnotationIntrospector;
    this._forSerialization = paramBoolean;
  }
  
  private <T> boolean _anyExplicitNames(POJOPropertyBuilder.Linked<T> paramLinked)
  {
    while (paramLinked != null)
    {
      if ((paramLinked.explicitName != null) && (paramLinked.explicitName.length() > 0)) {
        return true;
      }
      paramLinked = paramLinked.next;
    }
    return false;
  }
  
  private <T> boolean _anyIgnorals(POJOPropertyBuilder.Linked<T> paramLinked)
  {
    while (paramLinked != null)
    {
      if (paramLinked.isMarkedIgnored) {
        return true;
      }
      paramLinked = paramLinked.next;
    }
    return false;
  }
  
  private <T> boolean _anyVisible(POJOPropertyBuilder.Linked<T> paramLinked)
  {
    while (paramLinked != null)
    {
      if (paramLinked.isVisible) {
        return true;
      }
      paramLinked = paramLinked.next;
    }
    return false;
  }
  
  private AnnotationMap _mergeAnnotations(int paramInt, POJOPropertyBuilder.Linked<? extends AnnotatedMember>... paramVarArgs)
  {
    AnnotationMap localAnnotationMap = ((AnnotatedMember)paramVarArgs[paramInt].value).getAllAnnotations();
    paramInt += 1;
    while (paramInt < paramVarArgs.length)
    {
      if (paramVarArgs[paramInt] != null) {
        return AnnotationMap.merge(localAnnotationMap, _mergeAnnotations(paramInt, paramVarArgs));
      }
      paramInt += 1;
    }
    return localAnnotationMap;
  }
  
  private <T> POJOPropertyBuilder.Linked<T> _removeIgnored(POJOPropertyBuilder.Linked<T> paramLinked)
  {
    if (paramLinked == null) {
      return paramLinked;
    }
    return paramLinked.withoutIgnored();
  }
  
  private <T> POJOPropertyBuilder.Linked<T> _removeNonVisible(POJOPropertyBuilder.Linked<T> paramLinked)
  {
    if (paramLinked == null) {
      return paramLinked;
    }
    return paramLinked.withoutNonVisible();
  }
  
  private <T> POJOPropertyBuilder.Linked<T> _trimByVisibility(POJOPropertyBuilder.Linked<T> paramLinked)
  {
    if (paramLinked == null) {
      return paramLinked;
    }
    return paramLinked.trimByVisibility();
  }
  
  private POJOPropertyBuilder.Linked<? extends AnnotatedMember> findRenamed(POJOPropertyBuilder.Linked<? extends AnnotatedMember> paramLinked1, POJOPropertyBuilder.Linked<? extends AnnotatedMember> paramLinked2)
  {
    if (paramLinked1 != null)
    {
      String str = paramLinked1.explicitName;
      POJOPropertyBuilder.Linked<? extends AnnotatedMember> localLinked;
      if (str == null) {
        localLinked = paramLinked2;
      }
      label50:
      do
      {
        for (;;)
        {
          paramLinked1 = paramLinked1.next;
          paramLinked2 = localLinked;
          break;
          localLinked = paramLinked2;
          if (!str.equals(this._name))
          {
            if (paramLinked2 != null) {
              break label50;
            }
            localLinked = paramLinked1;
          }
        }
        localLinked = paramLinked2;
      } while (str.equals(paramLinked2.explicitName));
      throw new IllegalStateException("Conflicting property name definitions: '" + paramLinked2.explicitName + "' (for " + paramLinked2.value + ") vs '" + paramLinked1.explicitName + "' (for " + paramLinked1.value + ")");
    }
    return paramLinked2;
  }
  
  private static <T> POJOPropertyBuilder.Linked<T> merge(POJOPropertyBuilder.Linked<T> paramLinked1, POJOPropertyBuilder.Linked<T> paramLinked2)
  {
    if (paramLinked1 == null) {
      return paramLinked2;
    }
    if (paramLinked2 == null) {
      return paramLinked1;
    }
    return POJOPropertyBuilder.Linked.access$000(paramLinked1, paramLinked2);
  }
  
  public void addAll(POJOPropertyBuilder paramPOJOPropertyBuilder)
  {
    this._fields = merge(this._fields, paramPOJOPropertyBuilder._fields);
    this._ctorParameters = merge(this._ctorParameters, paramPOJOPropertyBuilder._ctorParameters);
    this._getters = merge(this._getters, paramPOJOPropertyBuilder._getters);
    this._setters = merge(this._setters, paramPOJOPropertyBuilder._setters);
  }
  
  public void addCtor(AnnotatedParameter paramAnnotatedParameter, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this._ctorParameters = new POJOPropertyBuilder.Linked(paramAnnotatedParameter, this._ctorParameters, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void addField(AnnotatedField paramAnnotatedField, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this._fields = new POJOPropertyBuilder.Linked(paramAnnotatedField, this._fields, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void addGetter(AnnotatedMethod paramAnnotatedMethod, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this._getters = new POJOPropertyBuilder.Linked(paramAnnotatedMethod, this._getters, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void addSetter(AnnotatedMethod paramAnnotatedMethod, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this._setters = new POJOPropertyBuilder.Linked(paramAnnotatedMethod, this._setters, paramString, paramBoolean1, paramBoolean2);
  }
  
  public boolean anyIgnorals()
  {
    return (_anyIgnorals(this._fields)) || (_anyIgnorals(this._getters)) || (_anyIgnorals(this._setters)) || (_anyIgnorals(this._ctorParameters));
  }
  
  public boolean anyVisible()
  {
    return (_anyVisible(this._fields)) || (_anyVisible(this._getters)) || (_anyVisible(this._setters)) || (_anyVisible(this._ctorParameters));
  }
  
  public int compareTo(POJOPropertyBuilder paramPOJOPropertyBuilder)
  {
    if (this._ctorParameters != null)
    {
      if (paramPOJOPropertyBuilder._ctorParameters == null) {
        return -1;
      }
    }
    else if (paramPOJOPropertyBuilder._ctorParameters != null) {
      return 1;
    }
    return getName().compareTo(paramPOJOPropertyBuilder.getName());
  }
  
  public String findNewName()
  {
    POJOPropertyBuilder.Linked localLinked = findRenamed(this._fields, null);
    localLinked = findRenamed(this._getters, localLinked);
    localLinked = findRenamed(this._setters, localLinked);
    localLinked = findRenamed(this._ctorParameters, localLinked);
    if (localLinked == null) {
      return null;
    }
    return localLinked.explicitName;
  }
  
  public AnnotationIntrospector.ReferenceProperty findReferenceType()
  {
    (AnnotationIntrospector.ReferenceProperty)fromMemberAnnotations(new POJOPropertyBuilder.WithMember()
    {
      public AnnotationIntrospector.ReferenceProperty withMember(AnnotatedMember paramAnonymousAnnotatedMember)
      {
        return POJOPropertyBuilder.this._annotationIntrospector.findReferenceType(paramAnonymousAnnotatedMember);
      }
    });
  }
  
  public Class<?>[] findViews()
  {
    (Class[])fromMemberAnnotations(new POJOPropertyBuilder.WithMember()
    {
      public Class<?>[] withMember(AnnotatedMember paramAnonymousAnnotatedMember)
      {
        return POJOPropertyBuilder.this._annotationIntrospector.findViews(paramAnonymousAnnotatedMember);
      }
    });
  }
  
  protected <T> T fromMemberAnnotations(POJOPropertyBuilder.WithMember<T> paramWithMember)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    if (this._annotationIntrospector != null)
    {
      if (!this._forSerialization) {
        break label79;
      }
      if (this._getters != null) {
        localObject1 = paramWithMember.withMember((AnnotatedMember)this._getters.value);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (this._fields != null) {
          localObject2 = paramWithMember.withMember((AnnotatedMember)this._fields.value);
        }
      }
      return (T)localObject2;
      label79:
      localObject2 = localObject3;
      if (this._ctorParameters != null) {
        localObject2 = paramWithMember.withMember((AnnotatedMember)this._ctorParameters.value);
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this._setters != null) {
          localObject1 = paramWithMember.withMember((AnnotatedMember)this._setters.value);
        }
      }
    }
  }
  
  public AnnotatedMember getAccessor()
  {
    AnnotatedMethod localAnnotatedMethod = getGetter();
    Object localObject = localAnnotatedMethod;
    if (localAnnotatedMethod == null) {
      localObject = getField();
    }
    return (AnnotatedMember)localObject;
  }
  
  public AnnotatedParameter getConstructorParameter()
  {
    if (this._ctorParameters == null) {
      return null;
    }
    POJOPropertyBuilder.Linked localLinked = this._ctorParameters;
    for (;;)
    {
      if ((((AnnotatedParameter)localLinked.value).getOwner() instanceof AnnotatedConstructor)) {
        return (AnnotatedParameter)localLinked.value;
      }
      localLinked = localLinked.next;
      if (localLinked == null) {
        return (AnnotatedParameter)this._ctorParameters.value;
      }
    }
  }
  
  public AnnotatedField getField()
  {
    if (this._fields == null) {
      localObject2 = null;
    }
    Object localObject1;
    POJOPropertyBuilder.Linked localLinked;
    do
    {
      return (AnnotatedField)localObject2;
      localObject1 = (AnnotatedField)this._fields.value;
      localLinked = this._fields.next;
      localObject2 = localObject1;
    } while (localLinked == null);
    Object localObject2 = (AnnotatedField)localLinked.value;
    Class localClass1 = ((AnnotatedField)localObject1).getDeclaringClass();
    Class localClass2 = ((AnnotatedField)localObject2).getDeclaringClass();
    if (localClass1 != localClass2)
    {
      if (localClass1.isAssignableFrom(localClass2)) {
        localObject1 = localObject2;
      }
      while (localClass2.isAssignableFrom(localClass1))
      {
        localLinked = localLinked.next;
        break;
      }
    }
    throw new IllegalArgumentException("Multiple fields representing property \"" + getName() + "\": " + ((AnnotatedField)localObject1).getFullName() + " vs " + ((AnnotatedField)localObject2).getFullName());
  }
  
  public AnnotatedMethod getGetter()
  {
    if (this._getters == null) {
      localObject2 = null;
    }
    Object localObject1;
    POJOPropertyBuilder.Linked localLinked;
    do
    {
      return (AnnotatedMethod)localObject2;
      localObject1 = (AnnotatedMethod)this._getters.value;
      localLinked = this._getters.next;
      localObject2 = localObject1;
    } while (localLinked == null);
    Object localObject2 = (AnnotatedMethod)localLinked.value;
    Class localClass1 = ((AnnotatedMethod)localObject1).getDeclaringClass();
    Class localClass2 = ((AnnotatedMethod)localObject2).getDeclaringClass();
    if (localClass1 != localClass2)
    {
      if (localClass1.isAssignableFrom(localClass2)) {
        localObject1 = localObject2;
      }
      while (localClass2.isAssignableFrom(localClass1))
      {
        localLinked = localLinked.next;
        break;
      }
    }
    throw new IllegalArgumentException("Conflicting getter definitions for property \"" + getName() + "\": " + ((AnnotatedMethod)localObject1).getFullName() + " vs " + ((AnnotatedMethod)localObject2).getFullName());
  }
  
  public String getInternalName()
  {
    return this._internalName;
  }
  
  public AnnotatedMember getMutator()
  {
    Object localObject2 = getConstructorParameter();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = getSetter();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = getField();
      }
    }
    return (AnnotatedMember)localObject1;
  }
  
  public String getName()
  {
    return this._name;
  }
  
  public AnnotatedMember getPrimaryMember()
  {
    if (this._forSerialization) {
      return getAccessor();
    }
    return getMutator();
  }
  
  public AnnotatedMethod getSetter()
  {
    if (this._setters == null) {
      localObject2 = null;
    }
    Object localObject1;
    POJOPropertyBuilder.Linked localLinked;
    do
    {
      return (AnnotatedMethod)localObject2;
      localObject1 = (AnnotatedMethod)this._setters.value;
      localLinked = this._setters.next;
      localObject2 = localObject1;
    } while (localLinked == null);
    Object localObject2 = (AnnotatedMethod)localLinked.value;
    Class localClass1 = ((AnnotatedMethod)localObject1).getDeclaringClass();
    Class localClass2 = ((AnnotatedMethod)localObject2).getDeclaringClass();
    if (localClass1 != localClass2)
    {
      if (localClass1.isAssignableFrom(localClass2)) {
        localObject1 = localObject2;
      }
      while (localClass2.isAssignableFrom(localClass1))
      {
        localLinked = localLinked.next;
        break;
      }
    }
    throw new IllegalArgumentException("Conflicting setter definitions for property \"" + getName() + "\": " + ((AnnotatedMethod)localObject1).getFullName() + " vs " + ((AnnotatedMethod)localObject2).getFullName());
  }
  
  public boolean hasConstructorParameter()
  {
    return this._ctorParameters != null;
  }
  
  public boolean hasField()
  {
    return this._fields != null;
  }
  
  public boolean hasGetter()
  {
    return this._getters != null;
  }
  
  public boolean hasSetter()
  {
    return this._setters != null;
  }
  
  public boolean isExplicitlyIncluded()
  {
    return (_anyExplicitNames(this._fields)) || (_anyExplicitNames(this._getters)) || (_anyExplicitNames(this._setters)) || (_anyExplicitNames(this._ctorParameters));
  }
  
  public boolean isTypeId()
  {
    Boolean localBoolean = (Boolean)fromMemberAnnotations(new POJOPropertyBuilder.WithMember()
    {
      public Boolean withMember(AnnotatedMember paramAnonymousAnnotatedMember)
      {
        return POJOPropertyBuilder.this._annotationIntrospector.isTypeId(paramAnonymousAnnotatedMember);
      }
    });
    return (localBoolean != null) && (localBoolean.booleanValue());
  }
  
  public void mergeAnnotations(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this._getters != null)
      {
        localAnnotationMap = _mergeAnnotations(0, new POJOPropertyBuilder.Linked[] { this._getters, this._fields, this._ctorParameters, this._setters });
        this._getters = this._getters.withValue(((AnnotatedMethod)this._getters.value).withAnnotations(localAnnotationMap));
      }
    }
    do
    {
      do
      {
        return;
      } while (this._fields == null);
      localAnnotationMap = _mergeAnnotations(0, new POJOPropertyBuilder.Linked[] { this._fields, this._ctorParameters, this._setters });
      this._fields = this._fields.withValue(((AnnotatedField)this._fields.value).withAnnotations(localAnnotationMap));
      return;
      if (this._ctorParameters != null)
      {
        localAnnotationMap = _mergeAnnotations(0, new POJOPropertyBuilder.Linked[] { this._ctorParameters, this._setters, this._fields, this._getters });
        this._ctorParameters = this._ctorParameters.withValue(((AnnotatedParameter)this._ctorParameters.value).withAnnotations(localAnnotationMap));
        return;
      }
      if (this._setters != null)
      {
        localAnnotationMap = _mergeAnnotations(0, new POJOPropertyBuilder.Linked[] { this._setters, this._fields, this._getters });
        this._setters = this._setters.withValue(((AnnotatedMethod)this._setters.value).withAnnotations(localAnnotationMap));
        return;
      }
    } while (this._fields == null);
    AnnotationMap localAnnotationMap = _mergeAnnotations(0, new POJOPropertyBuilder.Linked[] { this._fields, this._getters });
    this._fields = this._fields.withValue(((AnnotatedField)this._fields.value).withAnnotations(localAnnotationMap));
  }
  
  public void removeIgnored()
  {
    this._fields = _removeIgnored(this._fields);
    this._getters = _removeIgnored(this._getters);
    this._setters = _removeIgnored(this._setters);
    this._ctorParameters = _removeIgnored(this._ctorParameters);
  }
  
  public void removeNonVisible()
  {
    this._getters = _removeNonVisible(this._getters);
    this._ctorParameters = _removeNonVisible(this._ctorParameters);
    if (this._getters == null)
    {
      this._fields = _removeNonVisible(this._fields);
      this._setters = _removeNonVisible(this._setters);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Property '").append(this._name).append("'; ctors: ").append(this._ctorParameters).append(", field(s): ").append(this._fields).append(", getter(s): ").append(this._getters).append(", setter(s): ").append(this._setters);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void trimByVisibility()
  {
    this._fields = _trimByVisibility(this._fields);
    this._getters = _trimByVisibility(this._getters);
    this._setters = _trimByVisibility(this._setters);
    this._ctorParameters = _trimByVisibility(this._ctorParameters);
  }
  
  public POJOPropertyBuilder withName(String paramString)
  {
    return new POJOPropertyBuilder(this, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/introspect/POJOPropertyBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
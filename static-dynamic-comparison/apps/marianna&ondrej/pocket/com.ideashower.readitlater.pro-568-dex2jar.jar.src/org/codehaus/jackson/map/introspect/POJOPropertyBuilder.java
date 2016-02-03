package org.codehaus.jackson.map.introspect;

import org.codehaus.jackson.map.BeanPropertyDefinition;

public class POJOPropertyBuilder
  extends BeanPropertyDefinition
  implements Comparable
{
  protected POJOPropertyBuilder.Node _ctorParameters;
  protected POJOPropertyBuilder.Node _fields;
  protected POJOPropertyBuilder.Node _getters;
  protected final String _internalName;
  protected final String _name;
  protected POJOPropertyBuilder.Node _setters;
  
  public POJOPropertyBuilder(String paramString)
  {
    this._internalName = paramString;
    this._name = paramString;
  }
  
  public POJOPropertyBuilder(POJOPropertyBuilder paramPOJOPropertyBuilder, String paramString)
  {
    this._internalName = paramPOJOPropertyBuilder._internalName;
    this._name = paramString;
    this._fields = paramPOJOPropertyBuilder._fields;
    this._ctorParameters = paramPOJOPropertyBuilder._ctorParameters;
    this._getters = paramPOJOPropertyBuilder._getters;
    this._setters = paramPOJOPropertyBuilder._setters;
  }
  
  private boolean _anyExplicitNames(POJOPropertyBuilder.Node paramNode)
  {
    while (paramNode != null)
    {
      if ((paramNode.explicitName != null) && (paramNode.explicitName.length() > 0)) {
        return true;
      }
      paramNode = paramNode.next;
    }
    return false;
  }
  
  private boolean _anyIgnorals(POJOPropertyBuilder.Node paramNode)
  {
    while (paramNode != null)
    {
      if (paramNode.isMarkedIgnored) {
        return true;
      }
      paramNode = paramNode.next;
    }
    return false;
  }
  
  private boolean _anyVisible(POJOPropertyBuilder.Node paramNode)
  {
    while (paramNode != null)
    {
      if (paramNode.isVisible) {
        return true;
      }
      paramNode = paramNode.next;
    }
    return false;
  }
  
  private AnnotationMap _mergeAnnotations(int paramInt, POJOPropertyBuilder.Node... paramVarArgs)
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
  
  private POJOPropertyBuilder.Node _removeIgnored(POJOPropertyBuilder.Node paramNode)
  {
    if (paramNode == null) {
      return paramNode;
    }
    return paramNode.withoutIgnored();
  }
  
  private POJOPropertyBuilder.Node _removeNonVisible(POJOPropertyBuilder.Node paramNode)
  {
    if (paramNode == null) {
      return paramNode;
    }
    return paramNode.withoutNonVisible();
  }
  
  private POJOPropertyBuilder.Node _trimByVisibility(POJOPropertyBuilder.Node paramNode)
  {
    if (paramNode == null) {
      return paramNode;
    }
    return paramNode.trimByVisibility();
  }
  
  private POJOPropertyBuilder.Node findRenamed(POJOPropertyBuilder.Node paramNode1, POJOPropertyBuilder.Node paramNode2)
  {
    if (paramNode1 != null)
    {
      String str = paramNode1.explicitName;
      POJOPropertyBuilder.Node localNode;
      if (str == null) {
        localNode = paramNode2;
      }
      label50:
      do
      {
        for (;;)
        {
          paramNode1 = paramNode1.next;
          paramNode2 = localNode;
          break;
          localNode = paramNode2;
          if (!str.equals(this._name))
          {
            if (paramNode2 != null) {
              break label50;
            }
            localNode = paramNode1;
          }
        }
        localNode = paramNode2;
      } while (str.equals(paramNode2.explicitName));
      throw new IllegalStateException("Conflicting property name definitions: '" + paramNode2.explicitName + "' (for " + paramNode2.value + ") vs '" + paramNode1.explicitName + "' (for " + paramNode1.value + ")");
    }
    return paramNode2;
  }
  
  private static POJOPropertyBuilder.Node merge(POJOPropertyBuilder.Node paramNode1, POJOPropertyBuilder.Node paramNode2)
  {
    if (paramNode1 == null) {
      return paramNode2;
    }
    if (paramNode2 == null) {
      return paramNode1;
    }
    return POJOPropertyBuilder.Node.access$000(paramNode1, paramNode2);
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
    this._ctorParameters = new POJOPropertyBuilder.Node(paramAnnotatedParameter, this._ctorParameters, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void addField(AnnotatedField paramAnnotatedField, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this._fields = new POJOPropertyBuilder.Node(paramAnnotatedField, this._fields, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void addGetter(AnnotatedMethod paramAnnotatedMethod, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this._getters = new POJOPropertyBuilder.Node(paramAnnotatedMethod, this._getters, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void addSetter(AnnotatedMethod paramAnnotatedMethod, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this._setters = new POJOPropertyBuilder.Node(paramAnnotatedMethod, this._setters, paramString, paramBoolean1, paramBoolean2);
  }
  
  public boolean anyDeserializeIgnorals()
  {
    return (_anyIgnorals(this._fields)) || (_anyIgnorals(this._setters)) || (_anyIgnorals(this._ctorParameters));
  }
  
  public boolean anyExplicitNames()
  {
    return (_anyExplicitNames(this._fields)) || (_anyExplicitNames(this._getters)) || (_anyExplicitNames(this._setters)) || (_anyExplicitNames(this._ctorParameters));
  }
  
  public boolean anyIgnorals()
  {
    return (_anyIgnorals(this._fields)) || (_anyIgnorals(this._getters)) || (_anyIgnorals(this._setters)) || (_anyIgnorals(this._ctorParameters));
  }
  
  public boolean anySerializeIgnorals()
  {
    return (_anyIgnorals(this._fields)) || (_anyIgnorals(this._getters));
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
  
  public boolean couldSerialize()
  {
    return (this._getters != null) || (this._fields != null);
  }
  
  public String findNewName()
  {
    POJOPropertyBuilder.Node localNode = findRenamed(this._fields, null);
    localNode = findRenamed(this._getters, localNode);
    localNode = findRenamed(this._setters, localNode);
    localNode = findRenamed(this._ctorParameters, localNode);
    if (localNode == null) {
      return null;
    }
    return localNode.explicitName;
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
    POJOPropertyBuilder.Node localNode = this._ctorParameters;
    for (;;)
    {
      if ((((AnnotatedParameter)localNode.value).getOwner() instanceof AnnotatedConstructor)) {
        return (AnnotatedParameter)localNode.value;
      }
      localNode = localNode.next;
      if (localNode == null) {
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
    POJOPropertyBuilder.Node localNode;
    do
    {
      return (AnnotatedField)localObject2;
      localObject1 = (AnnotatedField)this._fields.value;
      localNode = this._fields.next;
      localObject2 = localObject1;
    } while (localNode == null);
    Object localObject2 = (AnnotatedField)localNode.value;
    Class localClass1 = ((AnnotatedField)localObject1).getDeclaringClass();
    Class localClass2 = ((AnnotatedField)localObject2).getDeclaringClass();
    if (localClass1 != localClass2)
    {
      if (localClass1.isAssignableFrom(localClass2)) {
        localObject1 = localObject2;
      }
      while (localClass2.isAssignableFrom(localClass1))
      {
        localNode = localNode.next;
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
    POJOPropertyBuilder.Node localNode;
    do
    {
      return (AnnotatedMethod)localObject2;
      localObject1 = (AnnotatedMethod)this._getters.value;
      localNode = this._getters.next;
      localObject2 = localObject1;
    } while (localNode == null);
    Object localObject2 = (AnnotatedMethod)localNode.value;
    Class localClass1 = ((AnnotatedMethod)localObject1).getDeclaringClass();
    Class localClass2 = ((AnnotatedMethod)localObject2).getDeclaringClass();
    if (localClass1 != localClass2)
    {
      if (localClass1.isAssignableFrom(localClass2)) {
        localObject1 = localObject2;
      }
      while (localClass2.isAssignableFrom(localClass1))
      {
        localNode = localNode.next;
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
  
  public AnnotatedMethod getSetter()
  {
    if (this._setters == null) {
      localObject2 = null;
    }
    Object localObject1;
    POJOPropertyBuilder.Node localNode;
    do
    {
      return (AnnotatedMethod)localObject2;
      localObject1 = (AnnotatedMethod)this._setters.value;
      localNode = this._setters.next;
      localObject2 = localObject1;
    } while (localNode == null);
    Object localObject2 = (AnnotatedMethod)localNode.value;
    Class localClass1 = ((AnnotatedMethod)localObject1).getDeclaringClass();
    Class localClass2 = ((AnnotatedMethod)localObject2).getDeclaringClass();
    if (localClass1 != localClass2)
    {
      if (localClass1.isAssignableFrom(localClass2)) {
        localObject1 = localObject2;
      }
      while (localClass2.isAssignableFrom(localClass1))
      {
        localNode = localNode.next;
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
  
  public void mergeAnnotations(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this._getters != null)
      {
        localAnnotationMap = _mergeAnnotations(0, new POJOPropertyBuilder.Node[] { this._getters, this._fields, this._ctorParameters, this._setters });
        this._getters = this._getters.withValue(((AnnotatedMethod)this._getters.value).withAnnotations(localAnnotationMap));
      }
    }
    do
    {
      do
      {
        return;
      } while (this._fields == null);
      localAnnotationMap = _mergeAnnotations(0, new POJOPropertyBuilder.Node[] { this._fields, this._ctorParameters, this._setters });
      this._fields = this._fields.withValue(((AnnotatedField)this._fields.value).withAnnotations(localAnnotationMap));
      return;
      if (this._ctorParameters != null)
      {
        localAnnotationMap = _mergeAnnotations(0, new POJOPropertyBuilder.Node[] { this._ctorParameters, this._setters, this._fields, this._getters });
        this._ctorParameters = this._ctorParameters.withValue(((AnnotatedParameter)this._ctorParameters.value).withAnnotations(localAnnotationMap));
        return;
      }
      if (this._setters != null)
      {
        localAnnotationMap = _mergeAnnotations(0, new POJOPropertyBuilder.Node[] { this._setters, this._fields, this._getters });
        this._setters = this._setters.withValue(((AnnotatedMethod)this._setters.value).withAnnotations(localAnnotationMap));
        return;
      }
    } while (this._fields == null);
    AnnotationMap localAnnotationMap = _mergeAnnotations(0, new POJOPropertyBuilder.Node[] { this._fields, this._getters });
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/introspect/POJOPropertyBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
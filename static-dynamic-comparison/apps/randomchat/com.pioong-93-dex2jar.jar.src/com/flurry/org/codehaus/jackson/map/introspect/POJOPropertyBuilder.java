package com.flurry.org.codehaus.jackson.map.introspect;

import com.flurry.org.codehaus.jackson.map.BeanPropertyDefinition;

public class POJOPropertyBuilder
  extends BeanPropertyDefinition
  implements Comparable<POJOPropertyBuilder>
{
  protected Node<AnnotatedParameter> _ctorParameters;
  protected Node<AnnotatedField> _fields;
  protected Node<AnnotatedMethod> _getters;
  protected final String _internalName;
  protected final String _name;
  protected Node<AnnotatedMethod> _setters;
  
  public POJOPropertyBuilder(POJOPropertyBuilder paramPOJOPropertyBuilder, String paramString)
  {
    this._internalName = paramPOJOPropertyBuilder._internalName;
    this._name = paramString;
    this._fields = paramPOJOPropertyBuilder._fields;
    this._ctorParameters = paramPOJOPropertyBuilder._ctorParameters;
    this._getters = paramPOJOPropertyBuilder._getters;
    this._setters = paramPOJOPropertyBuilder._setters;
  }
  
  public POJOPropertyBuilder(String paramString)
  {
    this._internalName = paramString;
    this._name = paramString;
  }
  
  private <T> boolean _anyExplicitNames(Node<T> paramNode)
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
  
  private <T> boolean _anyIgnorals(Node<T> paramNode)
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
  
  private <T> boolean _anyVisible(Node<T> paramNode)
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
  
  private AnnotationMap _mergeAnnotations(int paramInt, Node<? extends AnnotatedMember>... paramVarArgs)
  {
    AnnotationMap localAnnotationMap2 = ((AnnotatedMember)paramVarArgs[paramInt].value).getAllAnnotations();
    paramInt += 1;
    for (;;)
    {
      AnnotationMap localAnnotationMap1 = localAnnotationMap2;
      if (paramInt < paramVarArgs.length)
      {
        if (paramVarArgs[paramInt] != null) {
          localAnnotationMap1 = AnnotationMap.merge(localAnnotationMap2, _mergeAnnotations(paramInt, paramVarArgs));
        }
      }
      else {
        return localAnnotationMap1;
      }
      paramInt += 1;
    }
  }
  
  private <T> Node<T> _removeIgnored(Node<T> paramNode)
  {
    if (paramNode == null) {
      return paramNode;
    }
    return paramNode.withoutIgnored();
  }
  
  private <T> Node<T> _removeNonVisible(Node<T> paramNode)
  {
    if (paramNode == null) {
      return paramNode;
    }
    return paramNode.withoutNonVisible();
  }
  
  private <T> Node<T> _trimByVisibility(Node<T> paramNode)
  {
    if (paramNode == null) {
      return paramNode;
    }
    return paramNode.trimByVisibility();
  }
  
  private Node<? extends AnnotatedMember> findRenamed(Node<? extends AnnotatedMember> paramNode1, Node<? extends AnnotatedMember> paramNode2)
  {
    if (paramNode1 != null)
    {
      String str = paramNode1.explicitName;
      Node<? extends AnnotatedMember> localNode;
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
  
  private static <T> Node<T> merge(Node<T> paramNode1, Node<T> paramNode2)
  {
    if (paramNode1 == null) {
      return paramNode2;
    }
    if (paramNode2 == null) {
      return paramNode1;
    }
    return paramNode1.append(paramNode2);
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
    this._ctorParameters = new Node(paramAnnotatedParameter, this._ctorParameters, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void addField(AnnotatedField paramAnnotatedField, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this._fields = new Node(paramAnnotatedField, this._fields, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void addGetter(AnnotatedMethod paramAnnotatedMethod, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this._getters = new Node(paramAnnotatedMethod, this._getters, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void addSetter(AnnotatedMethod paramAnnotatedMethod, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this._setters = new Node(paramAnnotatedMethod, this._setters, paramString, paramBoolean1, paramBoolean2);
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
    Node localNode = findRenamed(this._fields, null);
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
    Object localObject = this._ctorParameters;
    Node localNode;
    do
    {
      if ((((AnnotatedParameter)((Node)localObject).value).getOwner() instanceof AnnotatedConstructor)) {
        return (AnnotatedParameter)((Node)localObject).value;
      }
      localNode = ((Node)localObject).next;
      localObject = localNode;
    } while (localNode != null);
    return (AnnotatedParameter)this._ctorParameters.value;
  }
  
  public AnnotatedField getField()
  {
    Object localObject2;
    if (this._fields == null) {
      localObject2 = null;
    }
    Object localObject1;
    Node localNode;
    do
    {
      return (AnnotatedField)localObject2;
      localObject1 = (AnnotatedField)this._fields.value;
      localNode = this._fields.next;
      localObject2 = localObject1;
    } while (localNode == null);
    AnnotatedField localAnnotatedField = (AnnotatedField)localNode.value;
    Class localClass1 = ((AnnotatedField)localObject1).getDeclaringClass();
    Class localClass2 = localAnnotatedField.getDeclaringClass();
    if (localClass1 != localClass2)
    {
      if (localClass1.isAssignableFrom(localClass2)) {
        localObject2 = localAnnotatedField;
      }
      do
      {
        localNode = localNode.next;
        localObject1 = localObject2;
        break;
        localObject2 = localObject1;
      } while (localClass2.isAssignableFrom(localClass1));
    }
    throw new IllegalArgumentException("Multiple fields representing property \"" + getName() + "\": " + ((AnnotatedField)localObject1).getFullName() + " vs " + localAnnotatedField.getFullName());
  }
  
  public AnnotatedMethod getGetter()
  {
    Object localObject2;
    if (this._getters == null) {
      localObject2 = null;
    }
    Object localObject1;
    Node localNode;
    do
    {
      return (AnnotatedMethod)localObject2;
      localObject1 = (AnnotatedMethod)this._getters.value;
      localNode = this._getters.next;
      localObject2 = localObject1;
    } while (localNode == null);
    AnnotatedMethod localAnnotatedMethod = (AnnotatedMethod)localNode.value;
    Class localClass1 = ((AnnotatedMethod)localObject1).getDeclaringClass();
    Class localClass2 = localAnnotatedMethod.getDeclaringClass();
    if (localClass1 != localClass2)
    {
      if (localClass1.isAssignableFrom(localClass2)) {
        localObject2 = localAnnotatedMethod;
      }
      do
      {
        localNode = localNode.next;
        localObject1 = localObject2;
        break;
        localObject2 = localObject1;
      } while (localClass2.isAssignableFrom(localClass1));
    }
    throw new IllegalArgumentException("Conflicting getter definitions for property \"" + getName() + "\": " + ((AnnotatedMethod)localObject1).getFullName() + " vs " + localAnnotatedMethod.getFullName());
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
    Object localObject2;
    if (this._setters == null) {
      localObject2 = null;
    }
    Object localObject1;
    Node localNode;
    do
    {
      return (AnnotatedMethod)localObject2;
      localObject1 = (AnnotatedMethod)this._setters.value;
      localNode = this._setters.next;
      localObject2 = localObject1;
    } while (localNode == null);
    AnnotatedMethod localAnnotatedMethod = (AnnotatedMethod)localNode.value;
    Class localClass1 = ((AnnotatedMethod)localObject1).getDeclaringClass();
    Class localClass2 = localAnnotatedMethod.getDeclaringClass();
    if (localClass1 != localClass2)
    {
      if (localClass1.isAssignableFrom(localClass2)) {
        localObject2 = localAnnotatedMethod;
      }
      do
      {
        localNode = localNode.next;
        localObject1 = localObject2;
        break;
        localObject2 = localObject1;
      } while (localClass2.isAssignableFrom(localClass1));
    }
    throw new IllegalArgumentException("Conflicting setter definitions for property \"" + getName() + "\": " + ((AnnotatedMethod)localObject1).getFullName() + " vs " + localAnnotatedMethod.getFullName());
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
        localAnnotationMap = _mergeAnnotations(0, new Node[] { this._getters, this._fields, this._ctorParameters, this._setters });
        this._getters = this._getters.withValue(((AnnotatedMethod)this._getters.value).withAnnotations(localAnnotationMap));
      }
    }
    do
    {
      do
      {
        return;
      } while (this._fields == null);
      localAnnotationMap = _mergeAnnotations(0, new Node[] { this._fields, this._ctorParameters, this._setters });
      this._fields = this._fields.withValue(((AnnotatedField)this._fields.value).withAnnotations(localAnnotationMap));
      return;
      if (this._ctorParameters != null)
      {
        localAnnotationMap = _mergeAnnotations(0, new Node[] { this._ctorParameters, this._setters, this._fields, this._getters });
        this._ctorParameters = this._ctorParameters.withValue(((AnnotatedParameter)this._ctorParameters.value).withAnnotations(localAnnotationMap));
        return;
      }
      if (this._setters != null)
      {
        localAnnotationMap = _mergeAnnotations(0, new Node[] { this._setters, this._fields, this._getters });
        this._setters = this._setters.withValue(((AnnotatedMethod)this._setters.value).withAnnotations(localAnnotationMap));
        return;
      }
    } while (this._fields == null);
    AnnotationMap localAnnotationMap = _mergeAnnotations(0, new Node[] { this._fields, this._getters });
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
  
  private static final class Node<T>
  {
    public final String explicitName;
    public final boolean isMarkedIgnored;
    public final boolean isVisible;
    public final Node<T> next;
    public final T value;
    
    public Node(T paramT, Node<T> paramNode, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.value = paramT;
      this.next = paramNode;
      if (paramString == null) {}
      for (this.explicitName = null;; this.explicitName = paramT)
      {
        this.isVisible = paramBoolean1;
        this.isMarkedIgnored = paramBoolean2;
        return;
        paramT = paramString;
        if (paramString.length() == 0) {
          paramT = null;
        }
      }
    }
    
    private Node<T> append(Node<T> paramNode)
    {
      if (this.next == null) {
        return withNext(paramNode);
      }
      return withNext(this.next.append(paramNode));
    }
    
    public String toString()
    {
      String str2 = this.value.toString() + "[visible=" + this.isVisible + "]";
      String str1 = str2;
      if (this.next != null) {
        str1 = str2 + ", " + this.next.toString();
      }
      return str1;
    }
    
    public Node<T> trimByVisibility()
    {
      Object localObject;
      if (this.next == null) {
        localObject = this;
      }
      do
      {
        Node localNode;
        do
        {
          return (Node<T>)localObject;
          localNode = this.next.trimByVisibility();
          if (this.explicitName != null)
          {
            if (localNode.explicitName == null) {
              return withNext(null);
            }
            return withNext(localNode);
          }
          localObject = localNode;
        } while (localNode.explicitName != null);
        if (this.isVisible == localNode.isVisible) {
          return withNext(localNode);
        }
        localObject = localNode;
      } while (!this.isVisible);
      return withNext(null);
    }
    
    public Node<T> withNext(Node<T> paramNode)
    {
      if (paramNode == this.next) {
        return this;
      }
      return new Node(this.value, paramNode, this.explicitName, this.isVisible, this.isMarkedIgnored);
    }
    
    public Node<T> withValue(T paramT)
    {
      if (paramT == this.value) {
        return this;
      }
      return new Node(paramT, this.next, this.explicitName, this.isVisible, this.isMarkedIgnored);
    }
    
    public Node<T> withoutIgnored()
    {
      if (this.isMarkedIgnored)
      {
        if (this.next == null) {
          return null;
        }
        return this.next.withoutIgnored();
      }
      if (this.next != null)
      {
        Node localNode = this.next.withoutIgnored();
        if (localNode != this.next) {
          return withNext(localNode);
        }
      }
      return this;
    }
    
    public Node<T> withoutNonVisible()
    {
      if (this.next == null) {}
      for (Node localNode1 = null;; localNode1 = this.next.withoutNonVisible())
      {
        Node localNode2 = localNode1;
        if (this.isVisible) {
          localNode2 = withNext(localNode1);
        }
        return localNode2;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/introspect/POJOPropertyBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
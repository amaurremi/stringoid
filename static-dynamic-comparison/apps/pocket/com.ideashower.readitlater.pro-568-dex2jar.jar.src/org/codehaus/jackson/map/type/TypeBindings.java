package org.codehaus.jackson.map.type;

import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.codehaus.jackson.type.JavaType;

public class TypeBindings
{
  private static final JavaType[] NO_TYPES = new JavaType[0];
  public static final JavaType UNBOUND = new SimpleType(Object.class);
  protected Map _bindings;
  protected final Class _contextClass;
  protected final JavaType _contextType;
  private final TypeBindings _parentBindings;
  protected HashSet _placeholders;
  protected final TypeFactory _typeFactory;
  
  public TypeBindings(TypeFactory paramTypeFactory, Class paramClass)
  {
    this(paramTypeFactory, null, paramClass, null);
  }
  
  private TypeBindings(TypeFactory paramTypeFactory, TypeBindings paramTypeBindings, Class paramClass, JavaType paramJavaType)
  {
    this._typeFactory = paramTypeFactory;
    this._parentBindings = paramTypeBindings;
    this._contextClass = paramClass;
    this._contextType = paramJavaType;
  }
  
  public TypeBindings(TypeFactory paramTypeFactory, JavaType paramJavaType)
  {
    this(paramTypeFactory, null, paramJavaType.getRawClass(), paramJavaType);
  }
  
  public void _addPlaceholder(String paramString)
  {
    if (this._placeholders == null) {
      this._placeholders = new HashSet();
    }
    this._placeholders.add(paramString);
  }
  
  protected void _resolve()
  {
    _resolveBindings(this._contextClass);
    if (this._contextType != null)
    {
      int j = this._contextType.containedTypeCount();
      if (j > 0)
      {
        if (this._bindings == null) {
          this._bindings = new LinkedHashMap();
        }
        int i = 0;
        while (i < j)
        {
          String str = this._contextType.containedTypeName(i);
          JavaType localJavaType = this._contextType.containedType(i);
          this._bindings.put(str, localJavaType);
          i += 1;
        }
      }
    }
    if (this._bindings == null) {
      this._bindings = Collections.emptyMap();
    }
  }
  
  protected void _resolveBindings(Type paramType)
  {
    if (paramType == null) {
      return;
    }
    Object localObject1;
    Object localObject3;
    Object localObject2;
    int j;
    int i;
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      localObject1 = paramType.getActualTypeArguments();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject3 = (Class)paramType.getRawType();
        localObject2 = ((Class)localObject3).getTypeParameters();
        if (localObject2.length != localObject1.length) {
          throw new IllegalArgumentException("Strange parametrized type (in class " + ((Class)localObject3).getName() + "): number of type arguments != number of type parameters (" + localObject1.length + " vs " + localObject2.length + ")");
        }
        j = localObject1.length;
        i = 0;
        if (i < j)
        {
          localObject3 = localObject2[i].getName();
          if (this._bindings == null)
          {
            this._bindings = new LinkedHashMap();
            label161:
            _addPlaceholder((String)localObject3);
            this._bindings.put(localObject3, this._typeFactory._constructType(localObject1[i], this));
          }
          for (;;)
          {
            i += 1;
            break;
            if (!this._bindings.containsKey(localObject3)) {
              break label161;
            }
          }
        }
      }
      paramType = (Class)paramType.getRawType();
    }
    for (;;)
    {
      _resolveBindings(paramType.getGenericSuperclass());
      paramType = paramType.getGenericInterfaces();
      j = paramType.length;
      i = 0;
      while (i < j)
      {
        _resolveBindings(paramType[i]);
        i += 1;
      }
      break;
      if (!(paramType instanceof Class)) {
        break;
      }
      paramType = (Class)paramType;
      _resolveBindings(paramType.getDeclaringClass());
      localObject1 = paramType.getTypeParameters();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        j = localObject1.length;
        i = 0;
        if (i < j)
        {
          localObject3 = localObject1[i];
          localObject2 = ((TypeVariable)localObject3).getName();
          localObject3 = localObject3.getBounds()[0];
          if (localObject3 != null)
          {
            if (this._bindings != null) {
              break label394;
            }
            this._bindings = new LinkedHashMap();
            label359:
            _addPlaceholder((String)localObject2);
            this._bindings.put(localObject2, this._typeFactory._constructType((Type)localObject3, this));
          }
          for (;;)
          {
            i += 1;
            break;
            label394:
            if (!this._bindings.containsKey(localObject2)) {
              break label359;
            }
          }
        }
      }
    }
  }
  
  public void addBinding(String paramString, JavaType paramJavaType)
  {
    if ((this._bindings == null) || (this._bindings.size() == 0)) {
      this._bindings = new LinkedHashMap();
    }
    this._bindings.put(paramString, paramJavaType);
  }
  
  public TypeBindings childInstance()
  {
    return new TypeBindings(this._typeFactory, this, this._contextClass, this._contextType);
  }
  
  public JavaType findType(String paramString)
  {
    if (this._bindings == null) {
      _resolve();
    }
    Object localObject = (JavaType)this._bindings.get(paramString);
    if (localObject != null) {
      return (JavaType)localObject;
    }
    if ((this._placeholders != null) && (this._placeholders.contains(paramString))) {
      return UNBOUND;
    }
    if (this._parentBindings != null) {
      return this._parentBindings.findType(paramString);
    }
    if ((this._contextClass != null) && (this._contextClass.getEnclosingClass() != null) && (!Modifier.isStatic(this._contextClass.getModifiers()))) {
      return UNBOUND;
    }
    if (this._contextClass != null) {
      localObject = this._contextClass.getName();
    }
    for (;;)
    {
      throw new IllegalArgumentException("Type variable '" + paramString + "' can not be resolved (with context of class " + (String)localObject + ")");
      if (this._contextType != null) {
        localObject = this._contextType.toString();
      } else {
        localObject = "UNKNOWN";
      }
    }
  }
  
  public int getBindingCount()
  {
    if (this._bindings == null) {
      _resolve();
    }
    return this._bindings.size();
  }
  
  public JavaType resolveType(Class paramClass)
  {
    return this._typeFactory._constructType(paramClass, this);
  }
  
  public JavaType resolveType(Type paramType)
  {
    return this._typeFactory._constructType(paramType, this);
  }
  
  public String toString()
  {
    if (this._bindings == null) {
      _resolve();
    }
    StringBuilder localStringBuilder = new StringBuilder("[TypeBindings for ");
    if (this._contextType != null) {
      localStringBuilder.append(this._contextType.toString());
    }
    for (;;)
    {
      localStringBuilder.append(": ").append(this._bindings).append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(this._contextClass.getName());
    }
  }
  
  public JavaType[] typesAsArray()
  {
    if (this._bindings == null) {
      _resolve();
    }
    if (this._bindings.size() == 0) {
      return NO_TYPES;
    }
    return (JavaType[])this._bindings.values().toArray(new JavaType[this._bindings.size()]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/type/TypeBindings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
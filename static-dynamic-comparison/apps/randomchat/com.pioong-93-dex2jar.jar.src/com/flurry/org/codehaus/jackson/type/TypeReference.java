package com.flurry.org.codehaus.jackson.type;

import java.lang.reflect.Type;

public abstract class TypeReference<T>
  implements Comparable<TypeReference<T>>
{
  final Type _type;
  
  protected TypeReference()
  {
    Type localType = getClass().getGenericSuperclass();
    if ((localType instanceof Class)) {
      throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
    }
    this._type = ((java.lang.reflect.ParameterizedType)localType).getActualTypeArguments()[0];
  }
  
  public int compareTo(TypeReference<T> paramTypeReference)
  {
    return 0;
  }
  
  public Type getType()
  {
    return this._type;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/type/TypeReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
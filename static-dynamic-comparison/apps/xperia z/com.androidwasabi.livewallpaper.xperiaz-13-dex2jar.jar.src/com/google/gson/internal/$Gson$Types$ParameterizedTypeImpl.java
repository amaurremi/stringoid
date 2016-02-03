package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class $Gson$Types$ParameterizedTypeImpl
  implements Serializable, ParameterizedType
{
  private static final long serialVersionUID = 0L;
  private final Type ownerType;
  private final Type rawType;
  private final Type[] typeArguments;
  
  public $Gson$Types$ParameterizedTypeImpl(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    boolean bool1;
    if ((paramType2 instanceof Class))
    {
      Class localClass = (Class)paramType2;
      if ((paramType1 != null) || (localClass.getEnclosingClass() == null))
      {
        bool1 = true;
        .Gson.Preconditions.checkArgument(bool1);
        bool1 = bool2;
        if (paramType1 != null)
        {
          if (localClass.getEnclosingClass() == null) {
            break label161;
          }
          bool1 = bool2;
        }
        label63:
        .Gson.Preconditions.checkArgument(bool1);
      }
    }
    else
    {
      if (paramType1 != null) {
        break label167;
      }
    }
    label161:
    label167:
    for (paramType1 = null;; paramType1 = .Gson.Types.canonicalize(paramType1))
    {
      this.ownerType = paramType1;
      this.rawType = .Gson.Types.canonicalize(paramType2);
      this.typeArguments = ((Type[])paramVarArgs.clone());
      while (i < this.typeArguments.length)
      {
        .Gson.Preconditions.checkNotNull(this.typeArguments[i]);
        .Gson.Types.access$000(this.typeArguments[i]);
        this.typeArguments[i] = .Gson.Types.canonicalize(this.typeArguments[i]);
        i += 1;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label63;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ParameterizedType)) && (.Gson.Types.equals(this, (ParameterizedType)paramObject));
  }
  
  public Type[] getActualTypeArguments()
  {
    return (Type[])this.typeArguments.clone();
  }
  
  public Type getOwnerType()
  {
    return this.ownerType;
  }
  
  public Type getRawType()
  {
    return this.rawType;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ .Gson.Types.access$100(this.ownerType);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder((this.typeArguments.length + 1) * 30);
    localStringBuilder.append(.Gson.Types.typeToString(this.rawType));
    if (this.typeArguments.length == 0) {
      return localStringBuilder.toString();
    }
    localStringBuilder.append("<").append(.Gson.Types.typeToString(this.typeArguments[0]));
    int i = 1;
    while (i < this.typeArguments.length)
    {
      localStringBuilder.append(", ").append(.Gson.Types.typeToString(this.typeArguments[i]));
      i += 1;
    }
    return ">";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/$Gson$Types$ParameterizedTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class MinimalClassNameIdResolver
  extends ClassNameIdResolver
{
  protected final String _basePackageName;
  protected final String _basePackagePrefix;
  
  protected MinimalClassNameIdResolver(JavaType paramJavaType, TypeFactory paramTypeFactory)
  {
    super(paramJavaType, paramTypeFactory);
    paramJavaType = paramJavaType.getRawClass().getName();
    int i = paramJavaType.lastIndexOf('.');
    if (i < 0)
    {
      this._basePackageName = "";
      this._basePackagePrefix = ".";
      return;
    }
    this._basePackagePrefix = paramJavaType.substring(0, i + 1);
    this._basePackageName = paramJavaType.substring(0, i);
  }
  
  public JavaType typeFromId(String paramString)
  {
    Object localObject = paramString;
    if (paramString.startsWith("."))
    {
      localObject = new StringBuilder(paramString.length() + this._basePackageName.length());
      if (this._basePackageName.length() != 0) {
        break label62;
      }
      ((StringBuilder)localObject).append(paramString.substring(1));
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      return super.typeFromId((String)localObject);
      label62:
      ((StringBuilder)localObject).append(this._basePackageName).append(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/jsontype/impl/MinimalClassNameIdResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
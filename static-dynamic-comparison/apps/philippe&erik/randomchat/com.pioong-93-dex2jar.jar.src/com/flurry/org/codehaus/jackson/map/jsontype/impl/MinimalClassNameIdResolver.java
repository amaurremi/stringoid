package com.flurry.org.codehaus.jackson.map.jsontype.impl;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import com.flurry.org.codehaus.jackson.map.type.TypeFactory;
import com.flurry.org.codehaus.jackson.type.JavaType;

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
  
  public JsonTypeInfo.Id getMechanism()
  {
    return JsonTypeInfo.Id.MINIMAL_CLASS;
  }
  
  public String idFromValue(Object paramObject)
  {
    String str = paramObject.getClass().getName();
    paramObject = str;
    if (str.startsWith(this._basePackagePrefix)) {
      paramObject = str.substring(this._basePackagePrefix.length() - 1);
    }
    return (String)paramObject;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/jsontype/impl/MinimalClassNameIdResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
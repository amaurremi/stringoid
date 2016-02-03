package org.codehaus.jackson.map.type;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.type.JavaType;

public class TypeParser
{
  final TypeFactory _factory;
  
  public TypeParser(TypeFactory paramTypeFactory)
  {
    this._factory = paramTypeFactory;
  }
  
  protected IllegalArgumentException _problem(TypeParser.MyTokenizer paramMyTokenizer, String paramString)
  {
    return new IllegalArgumentException("Failed to parse type '" + paramMyTokenizer.getAllInput() + "' (remaining: '" + paramMyTokenizer.getRemainingInput() + "'): " + paramString);
  }
  
  protected Class findClass(String paramString, TypeParser.MyTokenizer paramMyTokenizer)
  {
    try
    {
      Class localClass = Class.forName(paramString, true, Thread.currentThread().getContextClassLoader());
      return localClass;
    }
    catch (Exception localException)
    {
      if ((localException instanceof RuntimeException)) {
        throw ((RuntimeException)localException);
      }
      throw _problem(paramMyTokenizer, "Can not locate class '" + paramString + "', problem: " + localException.getMessage());
    }
  }
  
  public JavaType parse(String paramString)
  {
    paramString = new TypeParser.MyTokenizer(paramString.trim());
    JavaType localJavaType = parseType(paramString);
    if (paramString.hasMoreTokens()) {
      throw _problem(paramString, "Unexpected tokens after complete type");
    }
    return localJavaType;
  }
  
  protected JavaType parseType(TypeParser.MyTokenizer paramMyTokenizer)
  {
    if (!paramMyTokenizer.hasMoreTokens()) {
      throw _problem(paramMyTokenizer, "Unexpected end-of-string");
    }
    Class localClass = findClass(paramMyTokenizer.nextToken(), paramMyTokenizer);
    if (paramMyTokenizer.hasMoreTokens())
    {
      String str = paramMyTokenizer.nextToken();
      if ("<".equals(str)) {
        return this._factory._fromParameterizedClass(localClass, parseTypes(paramMyTokenizer));
      }
      paramMyTokenizer.pushBack(str);
    }
    return this._factory._fromClass(localClass, null);
  }
  
  protected List parseTypes(TypeParser.MyTokenizer paramMyTokenizer)
  {
    ArrayList localArrayList = new ArrayList();
    String str;
    do
    {
      if (paramMyTokenizer.hasMoreTokens())
      {
        localArrayList.add(parseType(paramMyTokenizer));
        if (paramMyTokenizer.hasMoreTokens()) {}
      }
      else
      {
        throw _problem(paramMyTokenizer, "Unexpected end-of-string");
      }
      str = paramMyTokenizer.nextToken();
      if (">".equals(str)) {
        return localArrayList;
      }
    } while (",".equals(str));
    throw _problem(paramMyTokenizer, "Unexpected token '" + str + "', expected ',' or '>')");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/type/TypeParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
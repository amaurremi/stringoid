package com.flurry.org.codehaus.jackson.map.type;

import com.flurry.org.codehaus.jackson.type.JavaType;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TypeParser
{
  final TypeFactory _factory;
  
  public TypeParser(TypeFactory paramTypeFactory)
  {
    this._factory = paramTypeFactory;
  }
  
  protected IllegalArgumentException _problem(MyTokenizer paramMyTokenizer, String paramString)
  {
    return new IllegalArgumentException("Failed to parse type '" + paramMyTokenizer.getAllInput() + "' (remaining: '" + paramMyTokenizer.getRemainingInput() + "'): " + paramString);
  }
  
  protected Class<?> findClass(String paramString, MyTokenizer paramMyTokenizer)
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
    throws IllegalArgumentException
  {
    paramString = new MyTokenizer(paramString.trim());
    JavaType localJavaType = parseType(paramString);
    if (paramString.hasMoreTokens()) {
      throw _problem(paramString, "Unexpected tokens after complete type");
    }
    return localJavaType;
  }
  
  protected JavaType parseType(MyTokenizer paramMyTokenizer)
    throws IllegalArgumentException
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
  
  protected List<JavaType> parseTypes(MyTokenizer paramMyTokenizer)
    throws IllegalArgumentException
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
  
  static final class MyTokenizer
    extends StringTokenizer
  {
    protected int _index;
    protected final String _input;
    protected String _pushbackToken;
    
    public MyTokenizer(String paramString)
    {
      super("<,>", true);
      this._input = paramString;
    }
    
    public String getAllInput()
    {
      return this._input;
    }
    
    public String getRemainingInput()
    {
      return this._input.substring(this._index);
    }
    
    public String getUsedInput()
    {
      return this._input.substring(0, this._index);
    }
    
    public boolean hasMoreTokens()
    {
      return (this._pushbackToken != null) || (super.hasMoreTokens());
    }
    
    public String nextToken()
    {
      String str;
      if (this._pushbackToken != null)
      {
        str = this._pushbackToken;
        this._pushbackToken = null;
      }
      for (;;)
      {
        this._index += str.length();
        return str;
        str = super.nextToken();
      }
    }
    
    public void pushBack(String paramString)
    {
      this._pushbackToken = paramString;
      this._index -= paramString.length();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/type/TypeParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
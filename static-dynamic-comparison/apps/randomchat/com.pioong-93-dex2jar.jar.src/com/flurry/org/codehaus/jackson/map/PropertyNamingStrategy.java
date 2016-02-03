package com.flurry.org.codehaus.jackson.map;

import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedField;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMethod;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedParameter;

public abstract class PropertyNamingStrategy
{
  public static final PropertyNamingStrategy CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES = new LowerCaseWithUnderscoresStrategy();
  
  public String nameForConstructorParameter(MapperConfig<?> paramMapperConfig, AnnotatedParameter paramAnnotatedParameter, String paramString)
  {
    return paramString;
  }
  
  public String nameForField(MapperConfig<?> paramMapperConfig, AnnotatedField paramAnnotatedField, String paramString)
  {
    return paramString;
  }
  
  public String nameForGetterMethod(MapperConfig<?> paramMapperConfig, AnnotatedMethod paramAnnotatedMethod, String paramString)
  {
    return paramString;
  }
  
  public String nameForSetterMethod(MapperConfig<?> paramMapperConfig, AnnotatedMethod paramAnnotatedMethod, String paramString)
  {
    return paramString;
  }
  
  public static class LowerCaseWithUnderscoresStrategy
    extends PropertyNamingStrategy.PropertyNamingStrategyBase
  {
    public String translate(String paramString)
    {
      if (paramString == null) {}
      StringBuilder localStringBuilder;
      int i;
      label155:
      do
      {
        return paramString;
        int i1 = paramString.length();
        localStringBuilder = new StringBuilder(i1 * 2);
        i = 0;
        int m = 0;
        int k = 0;
        if (k < i1)
        {
          char c = paramString.charAt(k);
          int n;
          int j;
          if (k <= 0)
          {
            n = i;
            j = m;
            if (c == '_') {}
          }
          else
          {
            if (!Character.isUpperCase(c)) {
              break label155;
            }
            j = i;
            if (m == 0)
            {
              j = i;
              if (i > 0)
              {
                j = i;
                if (localStringBuilder.charAt(i - 1) != '_')
                {
                  localStringBuilder.append('_');
                  j = i + 1;
                }
              }
            }
            c = Character.toLowerCase(c);
          }
          for (i = 1;; i = m)
          {
            localStringBuilder.append(c);
            n = j + 1;
            j = i;
            k += 1;
            i = n;
            m = j;
            break;
            m = 0;
            j = i;
          }
        }
      } while (i <= 0);
      return localStringBuilder.toString();
    }
  }
  
  public static abstract class PropertyNamingStrategyBase
    extends PropertyNamingStrategy
  {
    public String nameForConstructorParameter(MapperConfig<?> paramMapperConfig, AnnotatedParameter paramAnnotatedParameter, String paramString)
    {
      return translate(paramString);
    }
    
    public String nameForField(MapperConfig<?> paramMapperConfig, AnnotatedField paramAnnotatedField, String paramString)
    {
      return translate(paramString);
    }
    
    public String nameForGetterMethod(MapperConfig<?> paramMapperConfig, AnnotatedMethod paramAnnotatedMethod, String paramString)
    {
      return translate(paramString);
    }
    
    public String nameForSetterMethod(MapperConfig<?> paramMapperConfig, AnnotatedMethod paramAnnotatedMethod, String paramString)
    {
      return translate(paramString);
    }
    
    public abstract String translate(String paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/PropertyNamingStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
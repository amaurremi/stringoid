package org.codehaus.jackson.map;

import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.AnnotatedParameter;

public abstract class PropertyNamingStrategy
{
  public static final PropertyNamingStrategy CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES = new PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy();
  
  public String nameForConstructorParameter(MapperConfig paramMapperConfig, AnnotatedParameter paramAnnotatedParameter, String paramString)
  {
    return paramString;
  }
  
  public String nameForField(MapperConfig paramMapperConfig, AnnotatedField paramAnnotatedField, String paramString)
  {
    return paramString;
  }
  
  public String nameForGetterMethod(MapperConfig paramMapperConfig, AnnotatedMethod paramAnnotatedMethod, String paramString)
  {
    return paramString;
  }
  
  public String nameForSetterMethod(MapperConfig paramMapperConfig, AnnotatedMethod paramAnnotatedMethod, String paramString)
  {
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/PropertyNamingStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
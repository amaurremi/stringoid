package org.codehaus.jackson.map.annotate;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.codehaus.jackson.annotate.JacksonAnnotation;
import org.codehaus.jackson.map.JsonSerializer.None;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.PARAMETER})
@JacksonAnnotation
public @interface JsonSerialize
{
  Class as() default NoClass.class;
  
  Class contentAs() default NoClass.class;
  
  Class contentUsing() default JsonSerializer.None.class;
  
  JsonSerialize.Inclusion include() default JsonSerialize.Inclusion.ALWAYS;
  
  Class keyAs() default NoClass.class;
  
  Class keyUsing() default JsonSerializer.None.class;
  
  JsonSerialize.Typing typing() default JsonSerialize.Typing.DYNAMIC;
  
  Class using() default JsonSerializer.None.class;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/annotate/JsonSerialize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
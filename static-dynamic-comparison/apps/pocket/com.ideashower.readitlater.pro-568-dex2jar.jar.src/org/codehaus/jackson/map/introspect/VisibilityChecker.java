package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;

public abstract interface VisibilityChecker
{
  public abstract boolean isCreatorVisible(Member paramMember);
  
  public abstract boolean isCreatorVisible(AnnotatedMember paramAnnotatedMember);
  
  public abstract boolean isFieldVisible(Field paramField);
  
  public abstract boolean isFieldVisible(AnnotatedField paramAnnotatedField);
  
  public abstract boolean isGetterVisible(Method paramMethod);
  
  public abstract boolean isGetterVisible(AnnotatedMethod paramAnnotatedMethod);
  
  public abstract boolean isIsGetterVisible(Method paramMethod);
  
  public abstract boolean isIsGetterVisible(AnnotatedMethod paramAnnotatedMethod);
  
  public abstract boolean isSetterVisible(Method paramMethod);
  
  public abstract boolean isSetterVisible(AnnotatedMethod paramAnnotatedMethod);
  
  public abstract VisibilityChecker with(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract VisibilityChecker with(JsonAutoDetect paramJsonAutoDetect);
  
  public abstract VisibilityChecker withCreatorVisibility(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract VisibilityChecker withFieldVisibility(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract VisibilityChecker withGetterVisibility(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract VisibilityChecker withIsGetterVisibility(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract VisibilityChecker withSetterVisibility(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract VisibilityChecker withVisibility(JsonMethod paramJsonMethod, JsonAutoDetect.Visibility paramVisibility);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/introspect/VisibilityChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
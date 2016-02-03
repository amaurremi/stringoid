package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

@JsonAutoDetect(creatorVisibility=JsonAutoDetect.Visibility.ANY, fieldVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY, getterVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY, isGetterVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY, setterVisibility=JsonAutoDetect.Visibility.ANY)
public class VisibilityChecker$Std
  implements VisibilityChecker<Std>, Serializable
{
  protected static final Std DEFAULT = new Std((JsonAutoDetect)Std.class.getAnnotation(JsonAutoDetect.class));
  protected final JsonAutoDetect.Visibility _creatorMinLevel;
  protected final JsonAutoDetect.Visibility _fieldMinLevel;
  protected final JsonAutoDetect.Visibility _getterMinLevel;
  protected final JsonAutoDetect.Visibility _isGetterMinLevel;
  protected final JsonAutoDetect.Visibility _setterMinLevel;
  
  public VisibilityChecker$Std(JsonAutoDetect.Visibility paramVisibility1, JsonAutoDetect.Visibility paramVisibility2, JsonAutoDetect.Visibility paramVisibility3, JsonAutoDetect.Visibility paramVisibility4, JsonAutoDetect.Visibility paramVisibility5)
  {
    this._getterMinLevel = paramVisibility1;
    this._isGetterMinLevel = paramVisibility2;
    this._setterMinLevel = paramVisibility3;
    this._creatorMinLevel = paramVisibility4;
    this._fieldMinLevel = paramVisibility5;
  }
  
  public VisibilityChecker$Std(JsonAutoDetect paramJsonAutoDetect)
  {
    this._getterMinLevel = paramJsonAutoDetect.getterVisibility();
    this._isGetterMinLevel = paramJsonAutoDetect.isGetterVisibility();
    this._setterMinLevel = paramJsonAutoDetect.setterVisibility();
    this._creatorMinLevel = paramJsonAutoDetect.creatorVisibility();
    this._fieldMinLevel = paramJsonAutoDetect.fieldVisibility();
  }
  
  public static Std defaultInstance()
  {
    return DEFAULT;
  }
  
  public boolean isCreatorVisible(AnnotatedMember paramAnnotatedMember)
  {
    return isCreatorVisible(paramAnnotatedMember.getMember());
  }
  
  public boolean isCreatorVisible(Member paramMember)
  {
    return this._creatorMinLevel.isVisible(paramMember);
  }
  
  public boolean isFieldVisible(AnnotatedField paramAnnotatedField)
  {
    return isFieldVisible(paramAnnotatedField.getAnnotated());
  }
  
  public boolean isFieldVisible(Field paramField)
  {
    return this._fieldMinLevel.isVisible(paramField);
  }
  
  public boolean isGetterVisible(AnnotatedMethod paramAnnotatedMethod)
  {
    return isGetterVisible(paramAnnotatedMethod.getAnnotated());
  }
  
  public boolean isGetterVisible(Method paramMethod)
  {
    return this._getterMinLevel.isVisible(paramMethod);
  }
  
  public boolean isIsGetterVisible(AnnotatedMethod paramAnnotatedMethod)
  {
    return isIsGetterVisible(paramAnnotatedMethod.getAnnotated());
  }
  
  public boolean isIsGetterVisible(Method paramMethod)
  {
    return this._isGetterMinLevel.isVisible(paramMethod);
  }
  
  public boolean isSetterVisible(AnnotatedMethod paramAnnotatedMethod)
  {
    return isSetterVisible(paramAnnotatedMethod.getAnnotated());
  }
  
  public boolean isSetterVisible(Method paramMethod)
  {
    return this._setterMinLevel.isVisible(paramMethod);
  }
  
  public String toString()
  {
    return "[Visibility:" + " getter: " + this._getterMinLevel + ", isGetter: " + this._isGetterMinLevel + ", setter: " + this._setterMinLevel + ", creator: " + this._creatorMinLevel + ", field: " + this._fieldMinLevel + "]";
  }
  
  public Std with(JsonAutoDetect paramJsonAutoDetect)
  {
    Std localStd = this;
    if (paramJsonAutoDetect != null) {
      localStd = withGetterVisibility(paramJsonAutoDetect.getterVisibility()).withIsGetterVisibility(paramJsonAutoDetect.isGetterVisibility()).withSetterVisibility(paramJsonAutoDetect.setterVisibility()).withCreatorVisibility(paramJsonAutoDetect.creatorVisibility()).withFieldVisibility(paramJsonAutoDetect.fieldVisibility());
    }
    return localStd;
  }
  
  public Std withCreatorVisibility(JsonAutoDetect.Visibility paramVisibility)
  {
    if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
      paramVisibility = DEFAULT._creatorMinLevel;
    }
    for (;;)
    {
      if (this._creatorMinLevel == paramVisibility) {
        return this;
      }
      return new Std(this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, paramVisibility, this._fieldMinLevel);
    }
  }
  
  public Std withFieldVisibility(JsonAutoDetect.Visibility paramVisibility)
  {
    if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
      paramVisibility = DEFAULT._fieldMinLevel;
    }
    for (;;)
    {
      if (this._fieldMinLevel == paramVisibility) {
        return this;
      }
      return new Std(this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, paramVisibility);
    }
  }
  
  public Std withGetterVisibility(JsonAutoDetect.Visibility paramVisibility)
  {
    if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
      paramVisibility = DEFAULT._getterMinLevel;
    }
    for (;;)
    {
      if (this._getterMinLevel == paramVisibility) {
        return this;
      }
      return new Std(paramVisibility, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel);
    }
  }
  
  public Std withIsGetterVisibility(JsonAutoDetect.Visibility paramVisibility)
  {
    if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
      paramVisibility = DEFAULT._isGetterMinLevel;
    }
    for (;;)
    {
      if (this._isGetterMinLevel == paramVisibility) {
        return this;
      }
      return new Std(this._getterMinLevel, paramVisibility, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel);
    }
  }
  
  public Std withSetterVisibility(JsonAutoDetect.Visibility paramVisibility)
  {
    if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
      paramVisibility = DEFAULT._setterMinLevel;
    }
    for (;;)
    {
      if (this._setterMinLevel == paramVisibility) {
        return this;
      }
      return new Std(this._getterMinLevel, this._isGetterMinLevel, paramVisibility, this._creatorMinLevel, this._fieldMinLevel);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/introspect/VisibilityChecker$Std.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
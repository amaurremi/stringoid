package com.flurry.org.codehaus.jackson.map.introspect;

import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect;
import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import com.flurry.org.codehaus.jackson.annotate.JsonMethod;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public abstract interface VisibilityChecker<T extends VisibilityChecker<T>>
{
  public abstract boolean isCreatorVisible(AnnotatedMember paramAnnotatedMember);
  
  public abstract boolean isCreatorVisible(Member paramMember);
  
  public abstract boolean isFieldVisible(AnnotatedField paramAnnotatedField);
  
  public abstract boolean isFieldVisible(Field paramField);
  
  public abstract boolean isGetterVisible(AnnotatedMethod paramAnnotatedMethod);
  
  public abstract boolean isGetterVisible(Method paramMethod);
  
  public abstract boolean isIsGetterVisible(AnnotatedMethod paramAnnotatedMethod);
  
  public abstract boolean isIsGetterVisible(Method paramMethod);
  
  public abstract boolean isSetterVisible(AnnotatedMethod paramAnnotatedMethod);
  
  public abstract boolean isSetterVisible(Method paramMethod);
  
  public abstract T with(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract T with(JsonAutoDetect paramJsonAutoDetect);
  
  public abstract T withCreatorVisibility(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract T withFieldVisibility(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract T withGetterVisibility(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract T withIsGetterVisibility(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract T withSetterVisibility(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract T withVisibility(JsonMethod paramJsonMethod, JsonAutoDetect.Visibility paramVisibility);
  
  @JsonAutoDetect(creatorVisibility=JsonAutoDetect.Visibility.ANY, fieldVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY, getterVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY, isGetterVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY, setterVisibility=JsonAutoDetect.Visibility.ANY)
  public static class Std
    implements VisibilityChecker<Std>
  {
    protected static final Std DEFAULT = new Std((JsonAutoDetect)Std.class.getAnnotation(JsonAutoDetect.class));
    protected final JsonAutoDetect.Visibility _creatorMinLevel;
    protected final JsonAutoDetect.Visibility _fieldMinLevel;
    protected final JsonAutoDetect.Visibility _getterMinLevel;
    protected final JsonAutoDetect.Visibility _isGetterMinLevel;
    protected final JsonAutoDetect.Visibility _setterMinLevel;
    
    public Std(JsonAutoDetect.Visibility paramVisibility)
    {
      if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT)
      {
        this._getterMinLevel = DEFAULT._getterMinLevel;
        this._isGetterMinLevel = DEFAULT._isGetterMinLevel;
        this._setterMinLevel = DEFAULT._setterMinLevel;
        this._creatorMinLevel = DEFAULT._creatorMinLevel;
        this._fieldMinLevel = DEFAULT._fieldMinLevel;
        return;
      }
      this._getterMinLevel = paramVisibility;
      this._isGetterMinLevel = paramVisibility;
      this._setterMinLevel = paramVisibility;
      this._creatorMinLevel = paramVisibility;
      this._fieldMinLevel = paramVisibility;
    }
    
    public Std(JsonAutoDetect.Visibility paramVisibility1, JsonAutoDetect.Visibility paramVisibility2, JsonAutoDetect.Visibility paramVisibility3, JsonAutoDetect.Visibility paramVisibility4, JsonAutoDetect.Visibility paramVisibility5)
    {
      this._getterMinLevel = paramVisibility1;
      this._isGetterMinLevel = paramVisibility2;
      this._setterMinLevel = paramVisibility3;
      this._creatorMinLevel = paramVisibility4;
      this._fieldMinLevel = paramVisibility5;
    }
    
    public Std(JsonAutoDetect paramJsonAutoDetect)
    {
      JsonMethod[] arrayOfJsonMethod = paramJsonAutoDetect.value();
      JsonAutoDetect.Visibility localVisibility;
      if (hasMethod(arrayOfJsonMethod, JsonMethod.GETTER))
      {
        localVisibility = paramJsonAutoDetect.getterVisibility();
        this._getterMinLevel = localVisibility;
        if (!hasMethod(arrayOfJsonMethod, JsonMethod.IS_GETTER)) {
          break label129;
        }
        localVisibility = paramJsonAutoDetect.isGetterVisibility();
        label50:
        this._isGetterMinLevel = localVisibility;
        if (!hasMethod(arrayOfJsonMethod, JsonMethod.SETTER)) {
          break label136;
        }
        localVisibility = paramJsonAutoDetect.setterVisibility();
        label72:
        this._setterMinLevel = localVisibility;
        if (!hasMethod(arrayOfJsonMethod, JsonMethod.CREATOR)) {
          break label143;
        }
        localVisibility = paramJsonAutoDetect.creatorVisibility();
        label94:
        this._creatorMinLevel = localVisibility;
        if (!hasMethod(arrayOfJsonMethod, JsonMethod.FIELD)) {
          break label150;
        }
      }
      label129:
      label136:
      label143:
      label150:
      for (paramJsonAutoDetect = paramJsonAutoDetect.fieldVisibility();; paramJsonAutoDetect = JsonAutoDetect.Visibility.NONE)
      {
        this._fieldMinLevel = paramJsonAutoDetect;
        return;
        localVisibility = JsonAutoDetect.Visibility.NONE;
        break;
        localVisibility = JsonAutoDetect.Visibility.NONE;
        break label50;
        localVisibility = JsonAutoDetect.Visibility.NONE;
        break label72;
        localVisibility = JsonAutoDetect.Visibility.NONE;
        break label94;
      }
    }
    
    public static Std defaultInstance()
    {
      return DEFAULT;
    }
    
    private static boolean hasMethod(JsonMethod[] paramArrayOfJsonMethod, JsonMethod paramJsonMethod)
    {
      int j = paramArrayOfJsonMethod.length;
      int i = 0;
      while (i < j)
      {
        JsonMethod localJsonMethod = paramArrayOfJsonMethod[i];
        if ((localJsonMethod == paramJsonMethod) || (localJsonMethod == JsonMethod.ALL)) {
          return true;
        }
        i += 1;
      }
      return false;
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
    
    public Std with(JsonAutoDetect.Visibility paramVisibility)
    {
      if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
        return DEFAULT;
      }
      return new Std(paramVisibility);
    }
    
    public Std with(JsonAutoDetect paramJsonAutoDetect)
    {
      if (paramJsonAutoDetect == null) {
        return this;
      }
      JsonMethod[] arrayOfJsonMethod = paramJsonAutoDetect.value();
      Object localObject;
      if (hasMethod(arrayOfJsonMethod, JsonMethod.GETTER))
      {
        localObject = paramJsonAutoDetect.getterVisibility();
        Std localStd = withGetterVisibility((JsonAutoDetect.Visibility)localObject);
        if (!hasMethod(arrayOfJsonMethod, JsonMethod.IS_GETTER)) {
          break label141;
        }
        localObject = paramJsonAutoDetect.isGetterVisibility();
        label54:
        localStd = localStd.withIsGetterVisibility((JsonAutoDetect.Visibility)localObject);
        if (!hasMethod(arrayOfJsonMethod, JsonMethod.SETTER)) {
          break label148;
        }
        localObject = paramJsonAutoDetect.setterVisibility();
        label79:
        localStd = localStd.withSetterVisibility((JsonAutoDetect.Visibility)localObject);
        if (!hasMethod(arrayOfJsonMethod, JsonMethod.CREATOR)) {
          break label155;
        }
        localObject = paramJsonAutoDetect.creatorVisibility();
        label104:
        localObject = localStd.withCreatorVisibility((JsonAutoDetect.Visibility)localObject);
        if (!hasMethod(arrayOfJsonMethod, JsonMethod.FIELD)) {
          break label162;
        }
      }
      label141:
      label148:
      label155:
      label162:
      for (paramJsonAutoDetect = paramJsonAutoDetect.fieldVisibility();; paramJsonAutoDetect = JsonAutoDetect.Visibility.NONE)
      {
        return ((Std)localObject).withFieldVisibility(paramJsonAutoDetect);
        localObject = JsonAutoDetect.Visibility.NONE;
        break;
        localObject = JsonAutoDetect.Visibility.NONE;
        break label54;
        localObject = JsonAutoDetect.Visibility.NONE;
        break label79;
        localObject = JsonAutoDetect.Visibility.NONE;
        break label104;
      }
    }
    
    public Std withCreatorVisibility(JsonAutoDetect.Visibility paramVisibility)
    {
      JsonAutoDetect.Visibility localVisibility = paramVisibility;
      if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
        localVisibility = DEFAULT._creatorMinLevel;
      }
      if (this._creatorMinLevel == localVisibility) {
        return this;
      }
      return new Std(this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, localVisibility, this._fieldMinLevel);
    }
    
    public Std withFieldVisibility(JsonAutoDetect.Visibility paramVisibility)
    {
      JsonAutoDetect.Visibility localVisibility = paramVisibility;
      if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
        localVisibility = DEFAULT._fieldMinLevel;
      }
      if (this._fieldMinLevel == localVisibility) {
        return this;
      }
      return new Std(this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, localVisibility);
    }
    
    public Std withGetterVisibility(JsonAutoDetect.Visibility paramVisibility)
    {
      JsonAutoDetect.Visibility localVisibility = paramVisibility;
      if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
        localVisibility = DEFAULT._getterMinLevel;
      }
      if (this._getterMinLevel == localVisibility) {
        return this;
      }
      return new Std(localVisibility, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel);
    }
    
    public Std withIsGetterVisibility(JsonAutoDetect.Visibility paramVisibility)
    {
      JsonAutoDetect.Visibility localVisibility = paramVisibility;
      if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
        localVisibility = DEFAULT._isGetterMinLevel;
      }
      if (this._isGetterMinLevel == localVisibility) {
        return this;
      }
      return new Std(this._getterMinLevel, localVisibility, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel);
    }
    
    public Std withSetterVisibility(JsonAutoDetect.Visibility paramVisibility)
    {
      JsonAutoDetect.Visibility localVisibility = paramVisibility;
      if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
        localVisibility = DEFAULT._setterMinLevel;
      }
      if (this._setterMinLevel == localVisibility) {
        return this;
      }
      return new Std(this._getterMinLevel, this._isGetterMinLevel, localVisibility, this._creatorMinLevel, this._fieldMinLevel);
    }
    
    public Std withVisibility(JsonMethod paramJsonMethod, JsonAutoDetect.Visibility paramVisibility)
    {
      switch (VisibilityChecker.1.$SwitchMap$org$codehaus$jackson$annotate$JsonMethod[paramJsonMethod.ordinal()])
      {
      default: 
        return this;
      case 1: 
        return withGetterVisibility(paramVisibility);
      case 2: 
        return withSetterVisibility(paramVisibility);
      case 3: 
        return withCreatorVisibility(paramVisibility);
      case 4: 
        return withFieldVisibility(paramVisibility);
      case 5: 
        return withIsGetterVisibility(paramVisibility);
      }
      return with(paramVisibility);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/introspect/VisibilityChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
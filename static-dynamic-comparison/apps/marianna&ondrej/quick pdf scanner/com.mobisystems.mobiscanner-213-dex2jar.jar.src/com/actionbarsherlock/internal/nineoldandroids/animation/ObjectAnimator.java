package com.actionbarsherlock.internal.nineoldandroids.animation;

import java.util.HashMap;

public final class ObjectAnimator
  extends ValueAnimator
{
  private static final boolean DBG = false;
  private String mPropertyName;
  private Object mTarget;
  
  public ObjectAnimator() {}
  
  private ObjectAnimator(Object paramObject, String paramString)
  {
    this.mTarget = paramObject;
    setPropertyName(paramString);
  }
  
  public static ObjectAnimator ofFloat(Object paramObject, String paramString, float... paramVarArgs)
  {
    paramObject = new ObjectAnimator(paramObject, paramString);
    ((ObjectAnimator)paramObject).setFloatValues(paramVarArgs);
    return (ObjectAnimator)paramObject;
  }
  
  public static ObjectAnimator ofInt(Object paramObject, String paramString, int... paramVarArgs)
  {
    paramObject = new ObjectAnimator(paramObject, paramString);
    ((ObjectAnimator)paramObject).setIntValues(paramVarArgs);
    return (ObjectAnimator)paramObject;
  }
  
  public static ObjectAnimator ofObject(Object paramObject, String paramString, TypeEvaluator paramTypeEvaluator, Object... paramVarArgs)
  {
    paramObject = new ObjectAnimator(paramObject, paramString);
    ((ObjectAnimator)paramObject).setObjectValues(paramVarArgs);
    ((ObjectAnimator)paramObject).setEvaluator(paramTypeEvaluator);
    return (ObjectAnimator)paramObject;
  }
  
  public static ObjectAnimator ofPropertyValuesHolder(Object paramObject, PropertyValuesHolder... paramVarArgs)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    localObjectAnimator.mTarget = paramObject;
    localObjectAnimator.setValues(paramVarArgs);
    return localObjectAnimator;
  }
  
  void animateValue(float paramFloat)
  {
    super.animateValue(paramFloat);
    int j = this.mValues.length;
    int i = 0;
    while (i < j)
    {
      this.mValues[i].setAnimatedValue(this.mTarget);
      i += 1;
    }
  }
  
  public ObjectAnimator clone()
  {
    return (ObjectAnimator)super.clone();
  }
  
  public String getPropertyName()
  {
    return this.mPropertyName;
  }
  
  public Object getTarget()
  {
    return this.mTarget;
  }
  
  void initAnimation()
  {
    if (!this.mInitialized)
    {
      int j = this.mValues.length;
      int i = 0;
      while (i < j)
      {
        this.mValues[i].setupSetterAndGetter(this.mTarget);
        i += 1;
      }
      super.initAnimation();
    }
  }
  
  public ObjectAnimator setDuration(long paramLong)
  {
    super.setDuration(paramLong);
    return this;
  }
  
  public void setFloatValues(float... paramVarArgs)
  {
    if ((this.mValues == null) || (this.mValues.length == 0))
    {
      setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(this.mPropertyName, paramVarArgs) });
      return;
    }
    super.setFloatValues(paramVarArgs);
  }
  
  public void setIntValues(int... paramVarArgs)
  {
    if ((this.mValues == null) || (this.mValues.length == 0))
    {
      setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.mPropertyName, paramVarArgs) });
      return;
    }
    super.setIntValues(paramVarArgs);
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    if ((this.mValues == null) || (this.mValues.length == 0))
    {
      setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofObject(this.mPropertyName, (TypeEvaluator)null, paramVarArgs) });
      return;
    }
    super.setObjectValues(paramVarArgs);
  }
  
  public void setPropertyName(String paramString)
  {
    if (this.mValues != null)
    {
      PropertyValuesHolder localPropertyValuesHolder = this.mValues[0];
      String str = localPropertyValuesHolder.getPropertyName();
      localPropertyValuesHolder.setPropertyName(paramString);
      this.mValuesMap.remove(str);
      this.mValuesMap.put(paramString, localPropertyValuesHolder);
    }
    this.mPropertyName = paramString;
    this.mInitialized = false;
  }
  
  public void setTarget(Object paramObject)
  {
    if (this.mTarget != paramObject)
    {
      Object localObject = this.mTarget;
      this.mTarget = paramObject;
      if ((localObject == null) || (paramObject == null) || (localObject.getClass() != paramObject.getClass())) {}
    }
    else
    {
      return;
    }
    this.mInitialized = false;
  }
  
  public void setupEndValues()
  {
    initAnimation();
    int j = this.mValues.length;
    int i = 0;
    while (i < j)
    {
      this.mValues[i].setupEndValue(this.mTarget);
      i += 1;
    }
  }
  
  public void setupStartValues()
  {
    initAnimation();
    int j = this.mValues.length;
    int i = 0;
    while (i < j)
    {
      this.mValues[i].setupStartValue(this.mTarget);
      i += 1;
    }
  }
  
  public void start()
  {
    super.start();
  }
  
  public String toString()
  {
    String str1 = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.mTarget;
    String str2 = str1;
    if (this.mValues != null)
    {
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= this.mValues.length) {
          break;
        }
        str1 = str1 + "\n    " + this.mValues[i].toString();
        i += 1;
      }
    }
    return str2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/nineoldandroids/animation/ObjectAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
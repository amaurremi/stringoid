package com.google.tagmanager;

import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

abstract class Predicate
  extends FunctionCallImplementation
{
  private static final String ARG0 = Key.ARG0.toString();
  private static final String ARG1 = Key.ARG1.toString();
  
  public Predicate(String paramString)
  {
    super(paramString, new String[] { ARG0, ARG1 });
  }
  
  public static String getArg0Key()
  {
    return ARG0;
  }
  
  public static String getArg1Key()
  {
    return ARG1;
  }
  
  public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> paramMap)
  {
    boolean bool2 = false;
    Object localObject = paramMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((TypeSystem.Value)((Iterator)localObject).next() == Types.getDefaultValue()) {
        return Types.objectToValue(Boolean.valueOf(false));
      }
    }
    localObject = (TypeSystem.Value)paramMap.get(ARG0);
    TypeSystem.Value localValue = (TypeSystem.Value)paramMap.get(ARG1);
    boolean bool1 = bool2;
    if (localObject != null) {
      if (localValue != null) {
        break label99;
      }
    }
    label99:
    for (bool1 = bool2;; bool1 = evaluateNoDefaultValues((TypeSystem.Value)localObject, localValue, paramMap)) {
      return Types.objectToValue(Boolean.valueOf(bool1));
    }
  }
  
  protected abstract boolean evaluateNoDefaultValues(TypeSystem.Value paramValue1, TypeSystem.Value paramValue2, Map<String, TypeSystem.Value> paramMap);
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/Predicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
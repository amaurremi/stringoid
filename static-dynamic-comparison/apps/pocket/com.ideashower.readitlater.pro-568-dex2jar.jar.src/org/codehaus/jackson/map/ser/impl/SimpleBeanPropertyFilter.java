package org.codehaus.jackson.map.ser.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.codehaus.jackson.map.ser.BeanPropertyFilter;

public abstract class SimpleBeanPropertyFilter
  implements BeanPropertyFilter
{
  public static SimpleBeanPropertyFilter filterOutAllExcept(Set paramSet)
  {
    return new SimpleBeanPropertyFilter.FilterExceptFilter(paramSet);
  }
  
  public static SimpleBeanPropertyFilter filterOutAllExcept(String... paramVarArgs)
  {
    HashSet localHashSet = new HashSet(paramVarArgs.length);
    Collections.addAll(localHashSet, paramVarArgs);
    return new SimpleBeanPropertyFilter.FilterExceptFilter(localHashSet);
  }
  
  public static SimpleBeanPropertyFilter serializeAllExcept(Set paramSet)
  {
    return new SimpleBeanPropertyFilter.SerializeExceptFilter(paramSet);
  }
  
  public static SimpleBeanPropertyFilter serializeAllExcept(String... paramVarArgs)
  {
    HashSet localHashSet = new HashSet(paramVarArgs.length);
    Collections.addAll(localHashSet, paramVarArgs);
    return new SimpleBeanPropertyFilter.SerializeExceptFilter(localHashSet);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/impl/SimpleBeanPropertyFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class RegexGroupMacro
  extends FunctionCallImplementation
{
  private static final String GROUP = Key.GROUP.toString();
  private static final String ID = FunctionType.REGEX_GROUP.toString();
  private static final String IGNORE_CASE;
  private static final String REGEX;
  private static final String TO_MATCH = Key.ARG0.toString();
  
  static
  {
    REGEX = Key.ARG1.toString();
    IGNORE_CASE = Key.IGNORE_CASE.toString();
  }
  
  public RegexGroupMacro()
  {
    super(ID, new String[] { TO_MATCH, REGEX });
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> paramMap)
  {
    Object localObject = (TypeSystem.Value)paramMap.get(TO_MATCH);
    TypeSystem.Value localValue = (TypeSystem.Value)paramMap.get(REGEX);
    if ((localObject == null) || (localObject == Types.getDefaultValue()) || (localValue == null) || (localValue == Types.getDefaultValue())) {
      return Types.getDefaultValue();
    }
    int i = 64;
    if (Types.valueToBoolean((TypeSystem.Value)paramMap.get(IGNORE_CASE)).booleanValue()) {
      i = 0x40 | 0x2;
    }
    int j = 1;
    paramMap = (TypeSystem.Value)paramMap.get(GROUP);
    if (paramMap != null)
    {
      paramMap = Types.valueToInt64(paramMap);
      if (paramMap == Types.getDefaultInt64()) {
        return Types.getDefaultValue();
      }
      int k = paramMap.intValue();
      j = k;
      if (k < 0) {
        return Types.getDefaultValue();
      }
    }
    try
    {
      paramMap = Types.valueToString((TypeSystem.Value)localObject);
      localObject = Types.valueToString(localValue);
      localValue = null;
      localObject = Pattern.compile((String)localObject, i).matcher(paramMap);
      paramMap = localValue;
      if (((Matcher)localObject).find())
      {
        paramMap = localValue;
        if (((Matcher)localObject).groupCount() >= j) {
          paramMap = ((Matcher)localObject).group(j);
        }
      }
      if (paramMap == null) {
        return Types.getDefaultValue();
      }
      paramMap = Types.objectToValue(paramMap);
      return paramMap;
    }
    catch (PatternSyntaxException paramMap) {}
    return Types.getDefaultValue();
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/RegexGroupMacro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
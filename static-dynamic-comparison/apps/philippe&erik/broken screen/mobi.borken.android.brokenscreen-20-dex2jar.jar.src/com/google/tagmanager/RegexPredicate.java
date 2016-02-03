package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class RegexPredicate
  extends StringPredicate
{
  private static final String ID = FunctionType.REGEX.toString();
  private static final String IGNORE_CASE = Key.IGNORE_CASE.toString();
  
  public RegexPredicate()
  {
    super(ID);
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  public static String getIgnoreCaseKey()
  {
    return IGNORE_CASE;
  }
  
  protected boolean evaluateString(String paramString1, String paramString2, Map<String, TypeSystem.Value> paramMap)
  {
    int i = 64;
    if (Types.valueToBoolean((TypeSystem.Value)paramMap.get(IGNORE_CASE)).booleanValue()) {
      i = 0x40 | 0x2;
    }
    try
    {
      boolean bool = Pattern.compile(paramString2, i).matcher(paramString1).find();
      return bool;
    }
    catch (PatternSyntaxException paramString1) {}
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/RegexPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
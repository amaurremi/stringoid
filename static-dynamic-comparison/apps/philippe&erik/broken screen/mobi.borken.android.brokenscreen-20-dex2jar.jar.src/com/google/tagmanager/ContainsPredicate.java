package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class ContainsPredicate
  extends StringPredicate
{
  private static final String ID = FunctionType.CONTAINS.toString();
  
  public ContainsPredicate()
  {
    super(ID);
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  protected boolean evaluateString(String paramString1, String paramString2, Map<String, TypeSystem.Value> paramMap)
  {
    return paramString1.contains(paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/ContainsPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
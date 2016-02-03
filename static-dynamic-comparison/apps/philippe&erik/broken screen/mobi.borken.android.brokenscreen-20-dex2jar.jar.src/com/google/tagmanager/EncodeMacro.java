package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class EncodeMacro
  extends FunctionCallImplementation
{
  private static final String ARG0;
  private static final String DEFAULT_INPUT_FORMAT = "text";
  private static final String DEFAULT_OUTPUT_FORMAT = "base16";
  private static final String ID = FunctionType.ENCODE.toString();
  private static final String INPUT_FORMAT = Key.INPUT_FORMAT.toString();
  private static final String NO_PADDING;
  private static final String OUTPUT_FORMAT = Key.OUTPUT_FORMAT.toString();
  
  static
  {
    ARG0 = Key.ARG0.toString();
    NO_PADDING = Key.NO_PADDING.toString();
  }
  
  public EncodeMacro()
  {
    super(ID, new String[] { ARG0 });
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> paramMap)
  {
    Object localObject = (TypeSystem.Value)paramMap.get(ARG0);
    if ((localObject == null) || (localObject == Types.getDefaultValue())) {
      return Types.getDefaultValue();
    }
    String str2 = Types.valueToString((TypeSystem.Value)localObject);
    localObject = (TypeSystem.Value)paramMap.get(INPUT_FORMAT);
    String str1;
    label84:
    int i;
    if (localObject == null)
    {
      str1 = "text";
      localObject = (TypeSystem.Value)paramMap.get(OUTPUT_FORMAT);
      if (localObject != null) {
        break label181;
      }
      localObject = "base16";
      TypeSystem.Value localValue = (TypeSystem.Value)paramMap.get(INPUT_FORMAT);
      int j = 0;
      paramMap = (TypeSystem.Value)paramMap.get(NO_PADDING);
      i = j;
      if (paramMap != null)
      {
        i = j;
        if (Types.valueToBoolean(paramMap).booleanValue()) {
          i = 0x0 | 0x1;
        }
      }
    }
    for (;;)
    {
      try
      {
        if ("text".equals(str1))
        {
          paramMap = str2.getBytes();
          if (!"base16".equals(localObject)) {
            break label291;
          }
          paramMap = Base16.encode(paramMap);
          return Types.objectToValue(paramMap);
          str1 = Types.valueToString((TypeSystem.Value)localObject);
          break;
          label181:
          localObject = Types.valueToString((TypeSystem.Value)localObject);
          break label84;
        }
        if ("base16".equals(str1))
        {
          paramMap = Base16.decode(str2);
          continue;
        }
        if ("base64".equals(str1))
        {
          paramMap = Base64Encoder.decode(str2, i);
          continue;
        }
        if ("base64url".equals(str1))
        {
          paramMap = Base64Encoder.decode(str2, i | 0x2);
          continue;
        }
        Log.e("Encode: unknown input format: " + str1);
        paramMap = Types.getDefaultValue();
        return paramMap;
      }
      catch (IllegalArgumentException paramMap)
      {
        Log.e("Encode: invalid input:");
        return Types.getDefaultValue();
      }
      label291:
      if ("base64".equals(localObject))
      {
        paramMap = Base64Encoder.encodeToString(paramMap, i);
      }
      else
      {
        if (!"base64url".equals(localObject)) {
          break label331;
        }
        paramMap = Base64Encoder.encodeToString(paramMap, i | 0x2);
      }
    }
    label331:
    Log.e("Encode: unknown output format: " + (String)localObject);
    return Types.getDefaultValue();
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/EncodeMacro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
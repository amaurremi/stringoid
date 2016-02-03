package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class HashMacro
  extends FunctionCallImplementation
{
  private static final String ALGORITHM = Key.ALGORITHM.toString();
  private static final String ARG0;
  private static final String DEFAULT_ALGORITHM = "MD5";
  private static final String DEFAULT_INPUT_FORMAT = "text";
  private static final String ID = FunctionType.HASH.toString();
  private static final String INPUT_FORMAT = Key.INPUT_FORMAT.toString();
  
  static
  {
    ARG0 = Key.ARG0.toString();
  }
  
  public HashMacro()
  {
    super(ID, new String[] { ARG0 });
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  private byte[] hash(String paramString, byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    paramString = MessageDigest.getInstance(paramString);
    paramString.update(paramArrayOfByte);
    return paramString.digest();
  }
  
  public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> paramMap)
  {
    Object localObject = (TypeSystem.Value)paramMap.get(ARG0);
    if ((localObject == null) || (localObject == Types.getDefaultValue())) {
      return Types.getDefaultValue();
    }
    String str = Types.valueToString((TypeSystem.Value)localObject);
    localObject = (TypeSystem.Value)paramMap.get(ALGORITHM);
    if (localObject == null)
    {
      localObject = "MD5";
      paramMap = (TypeSystem.Value)paramMap.get(INPUT_FORMAT);
      if (paramMap != null) {
        break label110;
      }
      paramMap = "text";
      label73:
      if (!"text".equals(paramMap)) {
        break label118;
      }
      paramMap = str.getBytes();
    }
    for (;;)
    {
      try
      {
        paramMap = Types.objectToValue(Base16.encode(hash((String)localObject, paramMap)));
        return paramMap;
      }
      catch (NoSuchAlgorithmException paramMap)
      {
        label110:
        label118:
        Log.e("Hash: unknown algorithm: " + (String)localObject);
      }
      localObject = Types.valueToString((TypeSystem.Value)localObject);
      break;
      paramMap = Types.valueToString(paramMap);
      break label73;
      if ("base16".equals(paramMap))
      {
        paramMap = Base16.decode(str);
      }
      else
      {
        Log.e("Hash: unknown input format: " + paramMap);
        return Types.getDefaultValue();
      }
    }
    return Types.getDefaultValue();
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/HashMacro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
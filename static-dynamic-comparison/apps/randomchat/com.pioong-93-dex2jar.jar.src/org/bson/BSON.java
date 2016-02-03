package org.bson;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;
import org.bson.util.ClassMap;

public class BSON
{
  public static final byte ARRAY = 4;
  public static final byte BINARY = 5;
  public static final byte BOOLEAN = 8;
  public static final byte B_BINARY = 2;
  public static final byte B_FUNC = 1;
  public static final byte B_GENERAL = 0;
  public static final byte B_UUID = 3;
  public static final byte CODE = 13;
  public static final byte CODE_W_SCOPE = 15;
  public static final byte DATE = 9;
  public static final byte EOO = 0;
  private static final int GLOBAL_FLAG = 256;
  static final Logger LOGGER = Logger.getLogger("org.bson.BSON");
  public static final byte MAXKEY = 127;
  public static final byte MINKEY = -1;
  public static final byte NULL = 10;
  public static final byte NUMBER = 1;
  public static final byte NUMBER_INT = 16;
  public static final byte NUMBER_LONG = 18;
  public static final byte OBJECT = 3;
  public static final byte OID = 7;
  public static final byte REF = 12;
  public static final byte REGEX = 11;
  public static final byte STRING = 2;
  public static final byte SYMBOL = 14;
  public static final byte TIMESTAMP = 17;
  public static final byte UNDEFINED = 6;
  private static boolean _decodeHooks;
  static ClassMap<List<Transformer>> _decodingHooks;
  private static boolean _encodeHooks = false;
  static ClassMap<List<Transformer>> _encodingHooks;
  static ThreadLocal<BSONDecoder> _staticDecoder = new ThreadLocal()
  {
    protected BSONDecoder initialValue()
    {
      return new BasicBSONDecoder();
    }
  };
  static ThreadLocal<BSONEncoder> _staticEncoder;
  protected static Charset _utf8;
  
  static
  {
    _decodeHooks = false;
    _encodingHooks = new ClassMap();
    _decodingHooks = new ClassMap();
    _utf8 = Charset.forName("UTF-8");
    _staticEncoder = new ThreadLocal()
    {
      protected BSONEncoder initialValue()
      {
        return new BasicBSONEncoder();
      }
    };
  }
  
  private static boolean _anyHooks()
  {
    return (_encodeHooks) || (_decodeHooks);
  }
  
  private static void _warnUnsupportedRegex(String paramString)
  {
    LOGGER.info("flag " + paramString + " not supported by db.");
  }
  
  public static void addDecodingHook(Class paramClass, Transformer paramTransformer)
  {
    _decodeHooks = true;
    List localList = (List)_decodingHooks.get(paramClass);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new CopyOnWriteArrayList();
      _decodingHooks.put(paramClass, localObject);
    }
    ((List)localObject).add(paramTransformer);
  }
  
  public static void addEncodingHook(Class paramClass, Transformer paramTransformer)
  {
    _encodeHooks = true;
    List localList = (List)_encodingHooks.get(paramClass);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new CopyOnWriteArrayList();
      _encodingHooks.put(paramClass, localObject);
    }
    ((List)localObject).add(paramTransformer);
  }
  
  public static Object applyDecodingHooks(Object paramObject)
  {
    Object localObject1 = paramObject;
    if (_anyHooks())
    {
      if (paramObject != null) {
        break label16;
      }
      localObject1 = paramObject;
    }
    label16:
    do
    {
      return localObject1;
      localObject2 = (List)_decodingHooks.get(paramObject.getClass());
      localObject1 = paramObject;
    } while (localObject2 == null);
    Object localObject2 = ((List)localObject2).iterator();
    for (;;)
    {
      localObject1 = paramObject;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      paramObject = ((Transformer)((Iterator)localObject2).next()).transform(paramObject);
    }
  }
  
  public static Object applyEncodingHooks(Object paramObject)
  {
    Object localObject1;
    if (!_anyHooks()) {
      localObject1 = paramObject;
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = paramObject;
        } while (_encodingHooks.size() == 0);
        localObject1 = paramObject;
      } while (paramObject == null);
      localObject2 = (List)_encodingHooks.get(paramObject.getClass());
      localObject1 = paramObject;
    } while (localObject2 == null);
    Object localObject2 = ((List)localObject2).iterator();
    for (;;)
    {
      localObject1 = paramObject;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      paramObject = ((Transformer)((Iterator)localObject2).next()).transform(paramObject);
    }
  }
  
  public static void clearAllHooks()
  {
    clearEncodingHooks();
    clearDecodingHooks();
  }
  
  public static void clearDecodingHooks()
  {
    _decodeHooks = false;
    _decodingHooks.clear();
  }
  
  public static void clearEncodingHooks()
  {
    _encodeHooks = false;
    _encodingHooks.clear();
  }
  
  public static BSONObject decode(byte[] paramArrayOfByte)
  {
    return ((BSONDecoder)_staticDecoder.get()).readObject(paramArrayOfByte);
  }
  
  public static byte[] encode(BSONObject paramBSONObject)
  {
    BSONEncoder localBSONEncoder = (BSONEncoder)_staticEncoder.get();
    try
    {
      paramBSONObject = localBSONEncoder.encode(paramBSONObject);
      return paramBSONObject;
    }
    finally
    {
      localBSONEncoder.done();
    }
  }
  
  public static List<Transformer> getDecodingHooks(Class paramClass)
  {
    return (List)_decodingHooks.get(paramClass);
  }
  
  public static List<Transformer> getEncodingHooks(Class paramClass)
  {
    return (List)_encodingHooks.get(paramClass);
  }
  
  public static boolean hasDecodeHooks()
  {
    return _decodeHooks;
  }
  
  public static int regexFlag(char paramChar)
  {
    RegexFlag localRegexFlag = RegexFlag.getByCharacter(paramChar);
    if (localRegexFlag == null) {
      throw new IllegalArgumentException("unrecognized flag [" + paramChar + "]");
    }
    if (localRegexFlag.unsupported != null)
    {
      _warnUnsupportedRegex(localRegexFlag.unsupported);
      return 0;
    }
    return localRegexFlag.javaFlag;
  }
  
  public static int regexFlags(String paramString)
  {
    int j = 0;
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0;
    }
    paramString = paramString.toLowerCase();
    int i = 0;
    while (i < paramString.length())
    {
      RegexFlag localRegexFlag = RegexFlag.getByCharacter(paramString.charAt(i));
      if (localRegexFlag != null)
      {
        j |= localRegexFlag.javaFlag;
        if (localRegexFlag.unsupported != null) {
          _warnUnsupportedRegex(localRegexFlag.unsupported);
        }
        i += 1;
      }
      else
      {
        throw new IllegalArgumentException("unrecognized flag [" + paramString.charAt(i) + "] " + paramString.charAt(i));
      }
    }
    return j;
  }
  
  public static String regexFlags(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    RegexFlag[] arrayOfRegexFlag = RegexFlag.values();
    int k = arrayOfRegexFlag.length;
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      RegexFlag localRegexFlag = arrayOfRegexFlag[paramInt];
      j = i;
      if ((localRegexFlag.javaFlag & i) > 0)
      {
        localStringBuilder.append(localRegexFlag.flagChar);
        j = i - localRegexFlag.javaFlag;
      }
      paramInt += 1;
      i = j;
    }
    if (i > 0) {
      throw new IllegalArgumentException("some flags could not be recognized.");
    }
    return localStringBuilder.toString();
  }
  
  public static void removeDecodingHook(Class paramClass, Transformer paramTransformer)
  {
    getDecodingHooks(paramClass).remove(paramTransformer);
  }
  
  public static void removeDecodingHooks(Class paramClass)
  {
    _decodingHooks.remove(paramClass);
  }
  
  public static void removeEncodingHook(Class paramClass, Transformer paramTransformer)
  {
    getEncodingHooks(paramClass).remove(paramTransformer);
  }
  
  public static void removeEncodingHooks(Class paramClass)
  {
    _encodingHooks.remove(paramClass);
  }
  
  public static int toInt(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("can't be null");
    }
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).intValue();
    }
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue()) {
        return 1;
      }
      return 0;
    }
    throw new IllegalArgumentException("can't convert: " + paramObject.getClass().getName() + " to int");
  }
  
  private static enum RegexFlag
  {
    private static final Map<Character, RegexFlag> byCharacter;
    public final char flagChar;
    public final int javaFlag;
    public final String unsupported;
    
    static
    {
      GLOBAL = new RegexFlag("GLOBAL", 2, 256, 'g', null);
      CASE_INSENSITIVE = new RegexFlag("CASE_INSENSITIVE", 3, 2, 'i', null);
      MULTILINE = new RegexFlag("MULTILINE", 4, 8, 'm', null);
      DOTALL = new RegexFlag("DOTALL", 5, 32, 's', "Pattern.DOTALL");
      LITERAL = new RegexFlag("LITERAL", 6, 16, 't', "Pattern.LITERAL");
      UNICODE_CASE = new RegexFlag("UNICODE_CASE", 7, 64, 'u', "Pattern.UNICODE_CASE");
      COMMENTS = new RegexFlag("COMMENTS", 8, 4, 'x', null);
      $VALUES = new RegexFlag[] { CANON_EQ, UNIX_LINES, GLOBAL, CASE_INSENSITIVE, MULTILINE, DOTALL, LITERAL, UNICODE_CASE, COMMENTS };
      byCharacter = new HashMap();
      RegexFlag[] arrayOfRegexFlag = values();
      int j = arrayOfRegexFlag.length;
      int i = 0;
      while (i < j)
      {
        RegexFlag localRegexFlag = arrayOfRegexFlag[i];
        byCharacter.put(Character.valueOf(localRegexFlag.flagChar), localRegexFlag);
        i += 1;
      }
    }
    
    private RegexFlag(int paramInt, char paramChar, String paramString)
    {
      this.javaFlag = paramInt;
      this.flagChar = paramChar;
      this.unsupported = paramString;
    }
    
    public static RegexFlag getByCharacter(char paramChar)
    {
      return (RegexFlag)byCharacter.get(Character.valueOf(paramChar));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/BSON.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
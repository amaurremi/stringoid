package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.util.URI;
import com.amazonaws.javax.xml.stream.xerces.util.URI.MalformedURIException;
import com.amazonaws.javax.xml.stream.xerces.util.XMLResourceIdentifierImpl;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import java.io.File;
import java.util.Hashtable;

public class XMLEntityStorage
{
  private static char[] gAfterEscaping1;
  private static char[] gAfterEscaping2;
  private static String gEscapedUserDir;
  private static char[] gHexChs;
  private static boolean[] gNeedEscaping;
  private static String gUserDir;
  protected Entity.ScannedEntity fCurrentEntity;
  protected Hashtable fEntities = new Hashtable();
  private XMLEntityManager fEntityManager;
  protected XMLErrorReporter fErrorReporter;
  protected boolean fWarnDuplicateEntityDef;
  
  static
  {
    int j = 0;
    gNeedEscaping = new boolean[''];
    gAfterEscaping1 = new char[''];
    gAfterEscaping2 = new char[''];
    gHexChs = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
    int i = 0;
    while (i <= 31)
    {
      gNeedEscaping[i] = true;
      gAfterEscaping1[i] = gHexChs[(i >> 4)];
      gAfterEscaping2[i] = gHexChs[(i & 0xF)];
      i += 1;
    }
    gNeedEscaping[127] = true;
    gAfterEscaping1[127] = '7';
    gAfterEscaping2[127] = 'F';
    char[] arrayOfChar = new char[15];
    char[] tmp198_197 = arrayOfChar;
    tmp198_197[0] = 32;
    char[] tmp203_198 = tmp198_197;
    tmp203_198[1] = 60;
    char[] tmp208_203 = tmp203_198;
    tmp208_203[2] = 62;
    char[] tmp213_208 = tmp208_203;
    tmp213_208[3] = 35;
    char[] tmp218_213 = tmp213_208;
    tmp218_213[4] = 37;
    char[] tmp223_218 = tmp218_213;
    tmp223_218[5] = 34;
    char[] tmp228_223 = tmp223_218;
    tmp228_223[6] = 123;
    char[] tmp234_228 = tmp228_223;
    tmp234_228[7] = 125;
    char[] tmp240_234 = tmp234_228;
    tmp240_234[8] = 124;
    char[] tmp246_240 = tmp240_234;
    tmp246_240[9] = 92;
    char[] tmp252_246 = tmp246_240;
    tmp252_246[10] = 94;
    char[] tmp258_252 = tmp252_246;
    tmp258_252[11] = 126;
    char[] tmp264_258 = tmp258_252;
    tmp264_258[12] = 91;
    char[] tmp270_264 = tmp264_258;
    tmp270_264[13] = 93;
    char[] tmp276_270 = tmp270_264;
    tmp276_270[14] = 96;
    tmp276_270;
    int k = arrayOfChar.length;
    i = j;
    while (i < k)
    {
      j = arrayOfChar[i];
      gNeedEscaping[j] = true;
      gAfterEscaping1[j] = gHexChs[(j >> 4)];
      gAfterEscaping2[j] = gHexChs[(j & 0xF)];
      i += 1;
    }
  }
  
  public XMLEntityStorage(XMLEntityManager paramXMLEntityManager)
  {
    this.fEntityManager = paramXMLEntityManager;
  }
  
  public static String expandSystemId(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (;;)
    {
      return paramString1;
      try
      {
        localURI = new URI(paramString1);
        if (localURI != null) {}
      }
      catch (URI.MalformedURIException localMalformedURIException2)
      {
        URI localURI;
        String str2;
        for (;;) {}
      }
    }
    str2 = fixURI(paramString1);
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        if ((paramString2.length() != 0) && (!paramString2.equals(paramString1))) {
          continue;
        }
        paramString2 = new URI("file", "", getUserDir(), null, null);
        paramString2 = new URI(paramString2, str2);
      }
      catch (Exception paramString2)
      {
        paramString2 = null;
        continue;
      }
      if (paramString2 == null) {
        break;
      }
      return paramString2.toString();
      try
      {
        localURI = new URI(fixURI(paramString2));
        paramString2 = localURI;
      }
      catch (URI.MalformedURIException localMalformedURIException1)
      {
        if (paramString2.indexOf(':') != -1)
        {
          paramString2 = new URI("file", "", fixURI(paramString2), null, null);
        }
        else
        {
          String str1 = getUserDir();
          paramString2 = new URI("file", "", str1 + fixURI(paramString2), null, null);
        }
      }
    }
  }
  
  protected static String fixURI(String paramString)
  {
    String str = paramString.replace(File.separatorChar, '/');
    paramString = str;
    int i;
    if (str.length() >= 2)
    {
      i = str.charAt(1);
      if (i != 58) {
        break label79;
      }
      i = Character.toUpperCase(str.charAt(0));
      paramString = str;
      if (i >= 65)
      {
        paramString = str;
        if (i <= 90) {
          paramString = "/" + str;
        }
      }
    }
    label79:
    do
    {
      do
      {
        return paramString;
        paramString = str;
      } while (i != 47);
      paramString = str;
    } while (str.charAt(0) != '/');
    return "file:" + str;
  }
  
  /* Error */
  private static String getUserDir()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 105
    //   7: astore 4
    //   9: ldc -96
    //   11: invokestatic 165	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore 5
    //   16: aload 5
    //   18: astore 4
    //   20: aload 4
    //   22: invokevirtual 88	java/lang/String:length	()I
    //   25: ifne +13 -> 38
    //   28: ldc 105
    //   30: astore 4
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload 4
    //   37: areturn
    //   38: aload 4
    //   40: getstatic 167	com/amazonaws/javax/xml/stream/XMLEntityStorage:gUserDir	Ljava/lang/String;
    //   43: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifeq +11 -> 57
    //   49: getstatic 169	com/amazonaws/javax/xml/stream/XMLEntityStorage:gEscapedUserDir	Ljava/lang/String;
    //   52: astore 4
    //   54: goto -22 -> 32
    //   57: aload 4
    //   59: putstatic 167	com/amazonaws/javax/xml/stream/XMLEntityStorage:gUserDir	Ljava/lang/String;
    //   62: aload 4
    //   64: getstatic 136	java/io/File:separatorChar	C
    //   67: bipush 47
    //   69: invokevirtual 140	java/lang/String:replace	(CC)Ljava/lang/String;
    //   72: astore 4
    //   74: aload 4
    //   76: invokevirtual 88	java/lang/String:length	()I
    //   79: istore_2
    //   80: new 124	java/lang/StringBuffer
    //   83: dup
    //   84: iload_2
    //   85: iconst_3
    //   86: imul
    //   87: invokespecial 172	java/lang/StringBuffer:<init>	(I)V
    //   90: astore 5
    //   92: iload_2
    //   93: iconst_2
    //   94: if_icmplt +304 -> 398
    //   97: aload 4
    //   99: iconst_1
    //   100: invokevirtual 144	java/lang/String:charAt	(I)C
    //   103: bipush 58
    //   105: if_icmpne +293 -> 398
    //   108: aload 4
    //   110: iconst_0
    //   111: invokevirtual 144	java/lang/String:charAt	(I)C
    //   114: invokestatic 150	java/lang/Character:toUpperCase	(C)C
    //   117: istore_0
    //   118: iload_0
    //   119: bipush 65
    //   121: if_icmplt +277 -> 398
    //   124: iload_0
    //   125: bipush 90
    //   127: if_icmpgt +271 -> 398
    //   130: aload 5
    //   132: bipush 47
    //   134: invokevirtual 175	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   137: pop
    //   138: goto +260 -> 398
    //   141: iload_0
    //   142: iload_2
    //   143: if_icmpge +17 -> 160
    //   146: aload 4
    //   148: iload_0
    //   149: invokevirtual 144	java/lang/String:charAt	(I)C
    //   152: istore_3
    //   153: iload_3
    //   154: sipush 128
    //   157: if_icmplt +85 -> 242
    //   160: iload_0
    //   161: iload_2
    //   162: if_icmpge +192 -> 354
    //   165: aload 4
    //   167: iload_0
    //   168: invokevirtual 179	java/lang/String:substring	(I)Ljava/lang/String;
    //   171: ldc -75
    //   173: invokevirtual 185	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   176: astore 6
    //   178: aload 6
    //   180: arraylength
    //   181: istore_2
    //   182: iload_1
    //   183: istore_0
    //   184: iload_0
    //   185: iload_2
    //   186: if_icmpge +168 -> 354
    //   189: aload 6
    //   191: iload_0
    //   192: baload
    //   193: istore_1
    //   194: iload_1
    //   195: ifge +107 -> 302
    //   198: iload_1
    //   199: sipush 256
    //   202: iadd
    //   203: istore_1
    //   204: aload 5
    //   206: bipush 37
    //   208: invokevirtual 175	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   211: pop
    //   212: aload 5
    //   214: getstatic 49	com/amazonaws/javax/xml/stream/XMLEntityStorage:gHexChs	[C
    //   217: iload_1
    //   218: iconst_4
    //   219: ishr
    //   220: caload
    //   221: invokevirtual 175	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   224: pop
    //   225: aload 5
    //   227: getstatic 49	com/amazonaws/javax/xml/stream/XMLEntityStorage:gHexChs	[C
    //   230: iload_1
    //   231: bipush 15
    //   233: iand
    //   234: caload
    //   235: invokevirtual 175	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   238: pop
    //   239: goto +164 -> 403
    //   242: getstatic 27	com/amazonaws/javax/xml/stream/XMLEntityStorage:gNeedEscaping	[Z
    //   245: iload_3
    //   246: baload
    //   247: ifeq +36 -> 283
    //   250: aload 5
    //   252: bipush 37
    //   254: invokevirtual 175	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   257: pop
    //   258: aload 5
    //   260: getstatic 29	com/amazonaws/javax/xml/stream/XMLEntityStorage:gAfterEscaping1	[C
    //   263: iload_3
    //   264: caload
    //   265: invokevirtual 175	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   268: pop
    //   269: aload 5
    //   271: getstatic 31	com/amazonaws/javax/xml/stream/XMLEntityStorage:gAfterEscaping2	[C
    //   274: iload_3
    //   275: caload
    //   276: invokevirtual 175	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   279: pop
    //   280: goto +130 -> 410
    //   283: aload 5
    //   285: iload_3
    //   286: i2c
    //   287: invokevirtual 175	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   290: pop
    //   291: goto +119 -> 410
    //   294: astore 4
    //   296: ldc 2
    //   298: monitorexit
    //   299: aload 4
    //   301: athrow
    //   302: getstatic 27	com/amazonaws/javax/xml/stream/XMLEntityStorage:gNeedEscaping	[Z
    //   305: iload_1
    //   306: baload
    //   307: ifeq +36 -> 343
    //   310: aload 5
    //   312: bipush 37
    //   314: invokevirtual 175	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   317: pop
    //   318: aload 5
    //   320: getstatic 29	com/amazonaws/javax/xml/stream/XMLEntityStorage:gAfterEscaping1	[C
    //   323: iload_1
    //   324: caload
    //   325: invokevirtual 175	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   328: pop
    //   329: aload 5
    //   331: getstatic 31	com/amazonaws/javax/xml/stream/XMLEntityStorage:gAfterEscaping2	[C
    //   334: iload_1
    //   335: caload
    //   336: invokevirtual 175	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   339: pop
    //   340: goto +63 -> 403
    //   343: aload 5
    //   345: iload_1
    //   346: i2c
    //   347: invokevirtual 175	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   350: pop
    //   351: goto +52 -> 403
    //   354: aload 4
    //   356: ldc -104
    //   358: invokevirtual 189	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   361: ifne +11 -> 372
    //   364: aload 5
    //   366: bipush 47
    //   368: invokevirtual 175	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   371: pop
    //   372: aload 5
    //   374: invokevirtual 130	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   377: putstatic 169	com/amazonaws/javax/xml/stream/XMLEntityStorage:gEscapedUserDir	Ljava/lang/String;
    //   380: getstatic 169	com/amazonaws/javax/xml/stream/XMLEntityStorage:gEscapedUserDir	Ljava/lang/String;
    //   383: astore 4
    //   385: goto -353 -> 32
    //   388: astore 5
    //   390: goto -358 -> 32
    //   393: astore 5
    //   395: goto -375 -> 20
    //   398: iconst_0
    //   399: istore_0
    //   400: goto -259 -> 141
    //   403: iload_0
    //   404: iconst_1
    //   405: iadd
    //   406: istore_0
    //   407: goto -223 -> 184
    //   410: iload_0
    //   411: iconst_1
    //   412: iadd
    //   413: istore_0
    //   414: goto -273 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   117	297	0	i	int
    //   1	345	1	j	int
    //   79	108	2	k	int
    //   152	134	3	m	int
    //   7	159	4	localObject1	Object
    //   294	61	4	localObject2	Object
    //   383	1	4	str	String
    //   14	359	5	localObject3	Object
    //   388	1	5	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   393	1	5	localSecurityException	SecurityException
    //   176	14	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   9	16	294	finally
    //   20	28	294	finally
    //   38	54	294	finally
    //   57	92	294	finally
    //   97	118	294	finally
    //   130	138	294	finally
    //   146	153	294	finally
    //   165	178	294	finally
    //   178	182	294	finally
    //   204	239	294	finally
    //   242	280	294	finally
    //   283	291	294	finally
    //   302	340	294	finally
    //   343	351	294	finally
    //   354	372	294	finally
    //   372	385	294	finally
    //   165	178	388	java/io/UnsupportedEncodingException
    //   9	16	393	java/lang/SecurityException
  }
  
  public void addExternalEntity(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!this.fEntities.containsKey(paramString1))
    {
      str = paramString4;
      if (paramString4 == null)
      {
        str = paramString4;
        if (this.fCurrentEntity != null)
        {
          str = paramString4;
          if (this.fCurrentEntity.entityLocation != null) {
            str = this.fCurrentEntity.entityLocation.getExpandedSystemId();
          }
        }
      }
      this.fCurrentEntity = this.fEntityManager.getCurrentEntity();
      paramString2 = new Entity.ExternalEntity(paramString1, new XMLResourceIdentifierImpl(paramString2, paramString3, str, expandSystemId(paramString3, str)), null, true);
      this.fEntities.put(paramString1, paramString2);
    }
    while (!this.fWarnDuplicateEntityDef)
    {
      String str;
      return;
    }
    this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "MSG_DUPLICATE_ENTITY_DEFINITION", new Object[] { paramString1 }, (short)0);
  }
  
  public void addInternalEntity(String paramString1, String paramString2)
  {
    if (!this.fEntities.containsKey(paramString1))
    {
      this.fCurrentEntity = this.fEntityManager.getCurrentEntity();
      paramString2 = new Entity.InternalEntity(paramString1, paramString2, false);
      this.fEntities.put(paramString1, paramString2);
    }
    while (!this.fWarnDuplicateEntityDef) {
      return;
    }
    this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "MSG_DUPLICATE_ENTITY_DEFINITION", new Object[] { paramString1 }, (short)0);
  }
  
  public void addUnparsedEntity(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.fCurrentEntity = this.fEntityManager.getCurrentEntity();
    if (!this.fEntities.containsKey(paramString1))
    {
      paramString2 = new Entity.ExternalEntity(paramString1, new XMLResourceIdentifierImpl(paramString2, paramString3, paramString4, null), paramString5, false);
      this.fEntities.put(paramString1, paramString2);
    }
    while (!this.fWarnDuplicateEntityDef) {
      return;
    }
    this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "MSG_DUPLICATE_ENTITY_DEFINITION", new Object[] { paramString1 }, (short)0);
  }
  
  public Hashtable getDeclaredEntities()
  {
    return this.fEntities;
  }
  
  public boolean isDeclaredEntity(String paramString)
  {
    return (Entity)this.fEntities.get(paramString) != null;
  }
  
  public boolean isEntityDeclInExternalSubset(String paramString)
  {
    paramString = (Entity)this.fEntities.get(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.isEntityDeclInExternalSubset();
  }
  
  public boolean isExternalEntity(String paramString)
  {
    paramString = (Entity)this.fEntities.get(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.isExternal();
  }
  
  public boolean isUnparsedEntity(String paramString)
  {
    paramString = (Entity)this.fEntities.get(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.isUnparsed();
  }
  
  public void reset()
  {
    this.fEntities.clear();
    this.fCurrentEntity = null;
  }
  
  public void reset(PropertyManager paramPropertyManager)
  {
    this.fErrorReporter = ((XMLErrorReporter)paramPropertyManager.getProperty("http://apache.org/xml/properties/internal/error-reporter"));
    this.fEntities.clear();
    this.fCurrentEntity = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLEntityStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
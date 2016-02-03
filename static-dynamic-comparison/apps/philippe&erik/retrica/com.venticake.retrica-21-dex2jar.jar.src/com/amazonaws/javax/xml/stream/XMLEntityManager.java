package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.impl.io.ASCIIReader;
import com.amazonaws.javax.xml.stream.xerces.impl.io.UCSReader;
import com.amazonaws.javax.xml.stream.xerces.impl.io.UTF8Reader;
import com.amazonaws.javax.xml.stream.xerces.util.EncodingMap;
import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.URI;
import com.amazonaws.javax.xml.stream.xerces.util.URI.MalformedURIException;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLResourceIdentifierImpl;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLConfigurationException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Stack;
import java.util.Vector;

public class XMLEntityManager
{
  private static final String DTDEntity;
  private static final Boolean[] FEATURE_DEFAULTS;
  private static final Object[] PROPERTY_DEFAULTS;
  private static final String[] RECOGNIZED_FEATURES;
  private static final String[] RECOGNIZED_PROPERTIES;
  private static final String XMLEntity;
  private static char[] gAfterEscaping1;
  private static char[] gAfterEscaping2;
  private static String gEscapedUserDir;
  private static char[] gHexChs;
  private static boolean[] gNeedEscaping;
  private static String gUserDir;
  protected final Object[] defaultEncoding = { "UTF-8", null };
  protected boolean fAllowJavaEncodings = true;
  protected int fBufferSize = 8192;
  protected Entity.ScannedEntity fCurrentEntity = null;
  protected Hashtable fEntities = new Hashtable();
  protected XMLEntityHandler fEntityHandler;
  protected XMLEntityReaderImpl fEntityReader = new XMLEntityReaderImpl(this);
  protected Stack fEntityStack = new Stack();
  protected XMLEntityStorage fEntityStorage = new XMLEntityStorage(this);
  protected XMLErrorReporter fErrorReporter;
  protected boolean fExternalGeneralEntities;
  protected boolean fExternalParameterEntities;
  protected boolean fInExternalSubset = false;
  protected Vector fOwnReaders = new Vector();
  private final XMLResourceIdentifierImpl fResourceIdentifier = new XMLResourceIdentifierImpl();
  protected boolean fStandalone;
  protected StaxEntityResolverWrapper fStaxEntityResolver;
  protected SymbolTable fSymbolTable;
  protected boolean fValidation;
  
  static
  {
    int j = 0;
    RECOGNIZED_FEATURES = new String[] { "http://xml.org/sax/features/validation", "http://xml.org/sax/features/external-general-entities", "http://xml.org/sax/features/external-parameter-entities", "http://apache.org/xml/features/allow-java-encodings", "http://apache.org/xml/features/warn-on-duplicate-entitydef" };
    FEATURE_DEFAULTS = new Boolean[] { null, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE };
    RECOGNIZED_PROPERTIES = new String[] { "http://apache.org/xml/properties/internal/symbol-table", "http://apache.org/xml/properties/internal/error-reporter", "http://apache.org/xml/properties/internal/entity-resolver", "http://apache.org/xml/properties/internal/validation-manager", "http://apache.org/xml/properties/input-buffer-size" };
    PROPERTY_DEFAULTS = new Object[] { null, null, null, null, new Integer(8192) };
    XMLEntity = "[xml]".intern();
    DTDEntity = "[dtd]".intern();
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
    char[] tmp349_348 = arrayOfChar;
    tmp349_348[0] = 32;
    char[] tmp354_349 = tmp349_348;
    tmp354_349[1] = 60;
    char[] tmp359_354 = tmp354_349;
    tmp359_354[2] = 62;
    char[] tmp364_359 = tmp359_354;
    tmp364_359[3] = 35;
    char[] tmp369_364 = tmp364_359;
    tmp369_364[4] = 37;
    char[] tmp374_369 = tmp369_364;
    tmp374_369[5] = 34;
    char[] tmp379_374 = tmp374_369;
    tmp379_374[6] = 123;
    char[] tmp385_379 = tmp379_374;
    tmp385_379[7] = 125;
    char[] tmp391_385 = tmp385_379;
    tmp391_385[8] = 124;
    char[] tmp397_391 = tmp391_385;
    tmp397_391[9] = 92;
    char[] tmp403_397 = tmp397_391;
    tmp403_397[10] = 94;
    char[] tmp409_403 = tmp403_397;
    tmp409_403[11] = 126;
    char[] tmp415_409 = tmp409_403;
    tmp415_409[12] = 91;
    char[] tmp421_415 = tmp415_409;
    tmp421_415[13] = 93;
    char[] tmp427_421 = tmp421_415;
    tmp427_421[14] = 96;
    tmp427_421;
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
        break label80;
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
    label80:
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
    //   5: ldc -30
    //   7: astore 4
    //   9: ldc_w 280
    //   12: invokestatic 285	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 5
    //   17: aload 5
    //   19: astore 4
    //   21: aload 4
    //   23: invokevirtual 209	java/lang/String:length	()I
    //   26: ifne +13 -> 39
    //   29: ldc -30
    //   31: astore 4
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload 4
    //   38: areturn
    //   39: aload 4
    //   41: getstatic 287	com/amazonaws/javax/xml/stream/XMLEntityManager:gUserDir	Ljava/lang/String;
    //   44: invokevirtual 222	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   47: ifeq +11 -> 58
    //   50: getstatic 289	com/amazonaws/javax/xml/stream/XMLEntityManager:gEscapedUserDir	Ljava/lang/String;
    //   53: astore 4
    //   55: goto -22 -> 33
    //   58: aload 4
    //   60: putstatic 287	com/amazonaws/javax/xml/stream/XMLEntityManager:gUserDir	Ljava/lang/String;
    //   63: aload 4
    //   65: getstatic 256	java/io/File:separatorChar	C
    //   68: bipush 47
    //   70: invokevirtual 260	java/lang/String:replace	(CC)Ljava/lang/String;
    //   73: astore 4
    //   75: aload 4
    //   77: invokevirtual 209	java/lang/String:length	()I
    //   80: istore_2
    //   81: new 244	java/lang/StringBuffer
    //   84: dup
    //   85: iload_2
    //   86: iconst_3
    //   87: imul
    //   88: invokespecial 290	java/lang/StringBuffer:<init>	(I)V
    //   91: astore 5
    //   93: iload_2
    //   94: iconst_2
    //   95: if_icmplt +305 -> 400
    //   98: aload 4
    //   100: iconst_1
    //   101: invokevirtual 264	java/lang/String:charAt	(I)C
    //   104: bipush 58
    //   106: if_icmpne +294 -> 400
    //   109: aload 4
    //   111: iconst_0
    //   112: invokevirtual 264	java/lang/String:charAt	(I)C
    //   115: invokestatic 270	java/lang/Character:toUpperCase	(C)C
    //   118: istore_0
    //   119: iload_0
    //   120: bipush 65
    //   122: if_icmplt +278 -> 400
    //   125: iload_0
    //   126: bipush 90
    //   128: if_icmpgt +272 -> 400
    //   131: aload 5
    //   133: bipush 47
    //   135: invokevirtual 293	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   138: pop
    //   139: goto +261 -> 400
    //   142: iload_0
    //   143: iload_2
    //   144: if_icmpge +17 -> 161
    //   147: aload 4
    //   149: iload_0
    //   150: invokevirtual 264	java/lang/String:charAt	(I)C
    //   153: istore_3
    //   154: iload_3
    //   155: sipush 128
    //   158: if_icmplt +85 -> 243
    //   161: iload_0
    //   162: iload_2
    //   163: if_icmpge +192 -> 355
    //   166: aload 4
    //   168: iload_0
    //   169: invokevirtual 297	java/lang/String:substring	(I)Ljava/lang/String;
    //   172: ldc -81
    //   174: invokevirtual 301	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   177: astore 6
    //   179: aload 6
    //   181: arraylength
    //   182: istore_2
    //   183: iload_1
    //   184: istore_0
    //   185: iload_0
    //   186: iload_2
    //   187: if_icmpge +168 -> 355
    //   190: aload 6
    //   192: iload_0
    //   193: baload
    //   194: istore_1
    //   195: iload_1
    //   196: ifge +107 -> 303
    //   199: iload_1
    //   200: sipush 256
    //   203: iadd
    //   204: istore_1
    //   205: aload 5
    //   207: bipush 37
    //   209: invokevirtual 293	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   212: pop
    //   213: aload 5
    //   215: getstatic 137	com/amazonaws/javax/xml/stream/XMLEntityManager:gHexChs	[C
    //   218: iload_1
    //   219: iconst_4
    //   220: ishr
    //   221: caload
    //   222: invokevirtual 293	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   225: pop
    //   226: aload 5
    //   228: getstatic 137	com/amazonaws/javax/xml/stream/XMLEntityManager:gHexChs	[C
    //   231: iload_1
    //   232: bipush 15
    //   234: iand
    //   235: caload
    //   236: invokevirtual 293	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   239: pop
    //   240: goto +165 -> 405
    //   243: getstatic 115	com/amazonaws/javax/xml/stream/XMLEntityManager:gNeedEscaping	[Z
    //   246: iload_3
    //   247: baload
    //   248: ifeq +36 -> 284
    //   251: aload 5
    //   253: bipush 37
    //   255: invokevirtual 293	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   258: pop
    //   259: aload 5
    //   261: getstatic 117	com/amazonaws/javax/xml/stream/XMLEntityManager:gAfterEscaping1	[C
    //   264: iload_3
    //   265: caload
    //   266: invokevirtual 293	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   269: pop
    //   270: aload 5
    //   272: getstatic 119	com/amazonaws/javax/xml/stream/XMLEntityManager:gAfterEscaping2	[C
    //   275: iload_3
    //   276: caload
    //   277: invokevirtual 293	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   280: pop
    //   281: goto +131 -> 412
    //   284: aload 5
    //   286: iload_3
    //   287: i2c
    //   288: invokevirtual 293	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   291: pop
    //   292: goto +120 -> 412
    //   295: astore 4
    //   297: ldc 2
    //   299: monitorexit
    //   300: aload 4
    //   302: athrow
    //   303: getstatic 115	com/amazonaws/javax/xml/stream/XMLEntityManager:gNeedEscaping	[Z
    //   306: iload_1
    //   307: baload
    //   308: ifeq +36 -> 344
    //   311: aload 5
    //   313: bipush 37
    //   315: invokevirtual 293	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   318: pop
    //   319: aload 5
    //   321: getstatic 117	com/amazonaws/javax/xml/stream/XMLEntityManager:gAfterEscaping1	[C
    //   324: iload_1
    //   325: caload
    //   326: invokevirtual 293	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   329: pop
    //   330: aload 5
    //   332: getstatic 119	com/amazonaws/javax/xml/stream/XMLEntityManager:gAfterEscaping2	[C
    //   335: iload_1
    //   336: caload
    //   337: invokevirtual 293	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   340: pop
    //   341: goto +64 -> 405
    //   344: aload 5
    //   346: iload_1
    //   347: i2c
    //   348: invokevirtual 293	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   351: pop
    //   352: goto +53 -> 405
    //   355: aload 4
    //   357: ldc_w 272
    //   360: invokevirtual 305	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   363: ifne +11 -> 374
    //   366: aload 5
    //   368: bipush 47
    //   370: invokevirtual 293	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   373: pop
    //   374: aload 5
    //   376: invokevirtual 250	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   379: putstatic 289	com/amazonaws/javax/xml/stream/XMLEntityManager:gEscapedUserDir	Ljava/lang/String;
    //   382: getstatic 289	com/amazonaws/javax/xml/stream/XMLEntityManager:gEscapedUserDir	Ljava/lang/String;
    //   385: astore 4
    //   387: goto -354 -> 33
    //   390: astore 5
    //   392: goto -359 -> 33
    //   395: astore 5
    //   397: goto -376 -> 21
    //   400: iconst_0
    //   401: istore_0
    //   402: goto -260 -> 142
    //   405: iload_0
    //   406: iconst_1
    //   407: iadd
    //   408: istore_0
    //   409: goto -224 -> 185
    //   412: iload_0
    //   413: iconst_1
    //   414: iadd
    //   415: istore_0
    //   416: goto -274 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   118	298	0	i	int
    //   1	346	1	j	int
    //   80	108	2	k	int
    //   153	134	3	m	int
    //   7	160	4	localObject1	Object
    //   295	61	4	localObject2	Object
    //   385	1	4	str	String
    //   15	360	5	localObject3	Object
    //   390	1	5	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   395	1	5	localSecurityException	SecurityException
    //   177	14	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   9	17	295	finally
    //   21	29	295	finally
    //   39	55	295	finally
    //   58	93	295	finally
    //   98	119	295	finally
    //   131	139	295	finally
    //   147	154	295	finally
    //   166	179	295	finally
    //   179	183	295	finally
    //   205	240	295	finally
    //   243	281	295	finally
    //   284	292	295	finally
    //   303	341	295	finally
    //   344	352	295	finally
    //   355	374	295	finally
    //   374	387	295	finally
    //   166	179	390	java/io/UnsupportedEncodingException
    //   9	17	395	java/lang/SecurityException
  }
  
  protected Reader createReader(InputStream paramInputStream, String paramString, Boolean paramBoolean)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "UTF-8";
    }
    String str2 = str1.toUpperCase(Locale.ENGLISH);
    if (str2.equals("UTF-8")) {
      return new UTF8Reader(paramInputStream, this.fBufferSize, this.fErrorReporter.getMessageFormatter("http://www.w3.org/TR/1998/REC-xml-19980210"), this.fErrorReporter.getLocale());
    }
    if (str2.equals("US-ASCII")) {
      return new ASCIIReader(paramInputStream, this.fBufferSize, this.fErrorReporter.getMessageFormatter("http://www.w3.org/TR/1998/REC-xml-19980210"), this.fErrorReporter.getLocale());
    }
    if (str2.equals("ISO-10646-UCS-4"))
    {
      if (paramBoolean != null)
      {
        if (paramBoolean.booleanValue()) {
          return new UCSReader(paramInputStream, (short)8);
        }
        return new UCSReader(paramInputStream, (short)4);
      }
      this.fErrorReporter.reportError(getEntityReader(), "http://www.w3.org/TR/1998/REC-xml-19980210", "EncodingByteOrderUnsupported", new Object[] { str1 }, (short)2);
    }
    if (str2.equals("ISO-10646-UCS-2"))
    {
      if (paramBoolean != null)
      {
        if (paramBoolean.booleanValue()) {
          return new UCSReader(paramInputStream, (short)2);
        }
        return new UCSReader(paramInputStream, (short)1);
      }
      this.fErrorReporter.reportError(getEntityReader(), "http://www.w3.org/TR/1998/REC-xml-19980210", "EncodingByteOrderUnsupported", new Object[] { str1 }, (short)2);
    }
    boolean bool1 = XMLChar.isValidIANAEncoding(str1);
    boolean bool2 = XMLChar.isValidJavaEncoding(str1);
    if (bool1)
    {
      paramString = str1;
      if (this.fAllowJavaEncodings)
      {
        paramString = str1;
        if (bool2) {}
      }
    }
    else
    {
      this.fErrorReporter.reportError(getEntityReader(), "http://www.w3.org/TR/1998/REC-xml-19980210", "EncodingDeclInvalid", new Object[] { str1 }, (short)2);
      paramString = "ISO-8859-1";
    }
    paramBoolean = EncodingMap.getIANA2JavaMapping(str2);
    if (paramBoolean == null) {
      if (!this.fAllowJavaEncodings) {}
    }
    for (;;)
    {
      return new BufferedReader(new InputStreamReader(paramInputStream, paramString));
      this.fErrorReporter.reportError(getEntityReader(), "http://www.w3.org/TR/1998/REC-xml-19980210", "EncodingDeclInvalid", new Object[] { paramString }, (short)2);
      paramString = "ISO8859_1";
      continue;
      paramString = paramBoolean;
    }
  }
  
  public void endEntity()
  {
    if (this.fEntityHandler != null) {
      this.fEntityHandler.endEntity(this.fCurrentEntity.name);
    }
    if (this.fCurrentEntity != null) {}
    for (;;)
    {
      try
      {
        this.fCurrentEntity.close();
        if (this.fEntityStack.size() > 0)
        {
          Entity.ScannedEntity localScannedEntity = (Entity.ScannedEntity)this.fEntityStack.pop();
          this.fCurrentEntity = localScannedEntity;
          this.fEntityReader.setCurrentEntity(this.fCurrentEntity);
          return;
        }
      }
      catch (IOException localIOException)
      {
        throw new XNIException(localIOException);
      }
      Object localObject = null;
    }
  }
  
  public void endExternalSubset()
  {
    this.fInExternalSubset = false;
  }
  
  public Entity.ScannedEntity getCurrentEntity()
  {
    return this.fCurrentEntity;
  }
  
  protected Object[] getEncodingName(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt < 2) {
      return this.defaultEncoding;
    }
    int i = paramArrayOfByte[0] & 0xFF;
    int j = paramArrayOfByte[1] & 0xFF;
    if ((i == 254) && (j == 255)) {
      return new Object[] { "UTF-16BE", new Boolean(true) };
    }
    if ((i == 255) && (j == 254)) {
      return new Object[] { "UTF-16LE", new Boolean(false) };
    }
    if (paramInt < 3) {
      return this.defaultEncoding;
    }
    int k = paramArrayOfByte[2] & 0xFF;
    if ((i == 239) && (j == 187) && (k == 191)) {
      return this.defaultEncoding;
    }
    if (paramInt < 4) {
      return this.defaultEncoding;
    }
    paramInt = paramArrayOfByte[3] & 0xFF;
    if ((i == 0) && (j == 0) && (k == 0) && (paramInt == 60)) {
      return new Object[] { "ISO-10646-UCS-4", new Boolean(true) };
    }
    if ((i == 60) && (j == 0) && (k == 0) && (paramInt == 0)) {
      return new Object[] { "ISO-10646-UCS-4", new Boolean(false) };
    }
    if ((i == 0) && (j == 0) && (k == 60) && (paramInt == 0)) {
      return new Object[] { "ISO-10646-UCS-4", null };
    }
    if ((i == 0) && (j == 60) && (k == 0) && (paramInt == 0)) {
      return new Object[] { "ISO-10646-UCS-4", null };
    }
    if ((i == 0) && (j == 60) && (k == 0) && (paramInt == 63)) {
      return new Object[] { "UTF-16BE", new Boolean(true) };
    }
    if ((i == 60) && (j == 0) && (k == 63) && (paramInt == 0)) {
      return new Object[] { "UTF-16LE", new Boolean(false) };
    }
    if ((i == 76) && (j == 111) && (k == 167) && (paramInt == 148)) {
      return new Object[] { "CP037", null };
    }
    return this.defaultEncoding;
  }
  
  public XMLEntityReader getEntityReader()
  {
    return this.fEntityReader;
  }
  
  public XMLEntityStorage getEntityStore()
  {
    return this.fEntityStorage;
  }
  
  public void reset(PropertyManager paramPropertyManager)
  {
    this.fEntityStorage.reset(paramPropertyManager);
    this.fEntityReader.reset(paramPropertyManager);
    this.fSymbolTable = ((SymbolTable)paramPropertyManager.getProperty("http://apache.org/xml/properties/internal/symbol-table"));
    this.fErrorReporter = ((XMLErrorReporter)paramPropertyManager.getProperty("http://apache.org/xml/properties/internal/error-reporter"));
    try
    {
      this.fStaxEntityResolver = ((StaxEntityResolverWrapper)paramPropertyManager.getProperty("http://apache.org/xml/properties/internal/stax-entity-resolver"));
      this.fEntities.clear();
      this.fEntityStack.removeAllElements();
      this.fCurrentEntity = null;
      this.fValidation = false;
      this.fExternalGeneralEntities = true;
      this.fExternalParameterEntities = true;
      this.fAllowJavaEncodings = true;
      return;
    }
    catch (XMLConfigurationException paramPropertyManager)
    {
      for (;;)
      {
        this.fStaxEntityResolver = null;
      }
    }
  }
  
  public StaxXMLInputSource resolveEntityAsPerStax(XMLResourceIdentifier paramXMLResourceIdentifier)
  {
    int j = 1;
    Object localObject1;
    if (paramXMLResourceIdentifier == null)
    {
      localObject1 = null;
      return (StaxXMLInputSource)localObject1;
    }
    String str2 = paramXMLResourceIdentifier.getPublicId();
    String str3 = paramXMLResourceIdentifier.getLiteralSystemId();
    Object localObject2 = paramXMLResourceIdentifier.getBaseSystemId();
    String str1 = paramXMLResourceIdentifier.getExpandedSystemId();
    int i;
    if (str1 == null)
    {
      i = 1;
      label51:
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label233;
      }
      localObject1 = localObject2;
      if (this.fCurrentEntity == null) {
        break label233;
      }
      localObject1 = localObject2;
      if (this.fCurrentEntity.entityLocation == null) {
        break label233;
      }
      localObject2 = this.fCurrentEntity.entityLocation.getExpandedSystemId();
      localObject1 = localObject2;
      if (localObject2 == null) {
        break label233;
      }
      localObject1 = localObject2;
      i = j;
    }
    label150:
    label233:
    for (;;)
    {
      localObject2 = str1;
      if (i != 0) {
        localObject2 = expandSystemId(str3, (String)localObject1);
      }
      if (this.fStaxEntityResolver != null) {
        if ((paramXMLResourceIdentifier instanceof XMLResourceIdentifierImpl))
        {
          paramXMLResourceIdentifier = (XMLResourceIdentifierImpl)paramXMLResourceIdentifier;
          paramXMLResourceIdentifier.setValues(str2, str3, (String)localObject1, (String)localObject2);
        }
      }
      for (paramXMLResourceIdentifier = this.fStaxEntityResolver.resolveEntity(paramXMLResourceIdentifier);; paramXMLResourceIdentifier = null)
      {
        if (paramXMLResourceIdentifier == null)
        {
          return new StaxXMLInputSource(new XMLInputSource(str2, str3, (String)localObject1));
          i = 0;
          break label51;
          this.fResourceIdentifier.clear();
          paramXMLResourceIdentifier = this.fResourceIdentifier;
          break label150;
        }
        localObject1 = paramXMLResourceIdentifier;
        if (!paramXMLResourceIdentifier.hasXMLStreamOrXMLEventReader()) {
          break;
        }
        return paramXMLResourceIdentifier;
      }
    }
  }
  
  public void setEntityHandler(XMLEntityHandler paramXMLEntityHandler)
  {
    this.fEntityHandler = paramXMLEntityHandler;
  }
  
  public void setStandalone(boolean paramBoolean)
  {
    this.fStandalone = paramBoolean;
  }
  
  public void startDTDEntity(XMLInputSource paramXMLInputSource)
  {
    startEntity(DTDEntity, paramXMLInputSource, false, true);
  }
  
  public void startDocumentEntity(XMLInputSource paramXMLInputSource)
  {
    startEntity(XMLEntity, paramXMLInputSource, false, true);
  }
  
  public void startEntity(String paramString, XMLInputSource paramXMLInputSource, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str3 = paramXMLInputSource.getPublicId();
    String str4 = paramXMLInputSource.getSystemId();
    Object localObject1 = paramXMLInputSource.getBaseSystemId();
    String str1 = paramXMLInputSource.getEncoding();
    Object localObject2 = null;
    Object localObject3 = paramXMLInputSource.getCharacterStream();
    String str2 = expandSystemId(str4, (String)localObject1);
    if (localObject1 == null) {
      localObject1 = str2;
    }
    for (;;)
    {
      if (localObject3 == null)
      {
        localObject2 = paramXMLInputSource.getByteStream();
        paramXMLInputSource = (XMLInputSource)localObject2;
        if (localObject2 == null) {
          paramXMLInputSource = new BufferedInputStream(new URL(str2).openStream());
        }
        localObject2 = new XMLEntityManager.RewindableInputStream(this, paramXMLInputSource);
        if (str1 == null)
        {
          paramXMLInputSource = new byte[4];
          int i = 0;
          while (i < 4)
          {
            paramXMLInputSource[i] = ((byte)((InputStream)localObject2).read());
            i += 1;
          }
          if (i == 4)
          {
            localObject3 = getEncodingName(paramXMLInputSource, i);
            str1 = (String)localObject3[0];
            localObject3 = (Boolean)localObject3[1];
            ((InputStream)localObject2).reset();
            if ((i > 2) && (str1.equals("UTF-8")))
            {
              i = paramXMLInputSource[0];
              int j = paramXMLInputSource[1];
              int k = paramXMLInputSource[2];
              if (((i & 0xFF) == 239) && ((j & 0xFF) == 187) && ((k & 0xFF) == 191)) {
                ((InputStream)localObject2).skip(3L);
              }
            }
            paramXMLInputSource = createReader((InputStream)localObject2, str1, (Boolean)localObject3);
          }
        }
      }
      for (;;)
      {
        if (this.fCurrentEntity != null) {
          this.fEntityStack.push(this.fCurrentEntity);
        }
        this.fCurrentEntity = new Entity.ScannedEntity(paramString, new XMLResourceIdentifierImpl(str3, str4, (String)localObject1, str2), (InputStream)localObject2, paramXMLInputSource, str1, paramBoolean1, false, paramBoolean2);
        this.fEntityReader.setCurrentEntity(this.fCurrentEntity);
        this.fResourceIdentifier.setValues(str3, str4, (String)localObject1, str2);
        if (this.fEntityHandler != null) {
          this.fEntityHandler.startEntity(paramString, this.fResourceIdentifier, str1);
        }
        return;
        paramXMLInputSource = createReader((InputStream)localObject2, str1, null);
        continue;
        paramXMLInputSource = createReader((InputStream)localObject2, str1, null);
        continue;
        paramXMLInputSource = (XMLInputSource)localObject3;
      }
    }
  }
  
  public void startEntity(String paramString, boolean paramBoolean)
  {
    Object localObject2 = (Entity)this.fEntityStorage.getDeclaredEntities().get(paramString);
    if (localObject2 == null) {
      if (this.fEntityHandler != null)
      {
        this.fResourceIdentifier.clear();
        this.fEntityHandler.startEntity(paramString, this.fResourceIdentifier, null);
        this.fEntityHandler.endEntity(paramString);
      }
    }
    boolean bool1;
    do
    {
      return;
      bool1 = ((Entity)localObject2).isExternal();
      if (!bool1) {
        break label282;
      }
      boolean bool2 = ((Entity)localObject2).isUnparsed();
      boolean bool3 = paramString.startsWith("%");
      if (bool3) {
        break;
      }
      i = 1;
      if ((!bool2) && ((i == 0) || (this.fExternalGeneralEntities)) && ((!bool3) || (this.fExternalParameterEntities))) {
        break label282;
      }
    } while (this.fEntityHandler == null);
    this.fResourceIdentifier.clear();
    Object localObject3 = (Entity.ExternalEntity)localObject2;
    label165:
    label185:
    String str;
    XMLResourceIdentifierImpl localXMLResourceIdentifierImpl;
    if (((Entity.ExternalEntity)localObject3).entityLocation != null)
    {
      localObject1 = ((Entity.ExternalEntity)localObject3).entityLocation.getLiteralSystemId();
      if (((Entity.ExternalEntity)localObject3).entityLocation == null) {
        break label270;
      }
      localObject2 = ((Entity.ExternalEntity)localObject3).entityLocation.getBaseSystemId();
      str = expandSystemId((String)localObject1, (String)localObject2);
      localXMLResourceIdentifierImpl = this.fResourceIdentifier;
      if (((Entity.ExternalEntity)localObject3).entityLocation == null) {
        break label276;
      }
    }
    label270:
    label276:
    for (localObject3 = ((Entity.ExternalEntity)localObject3).entityLocation.getPublicId();; localObject3 = null)
    {
      localXMLResourceIdentifierImpl.setValues((String)localObject3, (String)localObject1, (String)localObject2, str);
      this.fEntityHandler.startEntity(paramString, this.fResourceIdentifier, null);
      this.fEntityHandler.endEntity(paramString);
      return;
      i = 0;
      break;
      localObject1 = null;
      break label165;
      localObject2 = null;
      break label185;
    }
    label282:
    int j = this.fEntityStack.size();
    int i = j;
    for (;;)
    {
      if (i < 0) {
        break label655;
      }
      if (i == j) {
        localObject1 = this.fCurrentEntity;
      }
      for (;;)
      {
        if (((Entity)localObject1).name == paramString)
        {
          i += 1;
          localObject1 = paramString;
          for (;;)
          {
            if (i < j)
            {
              localObject3 = (Entity)this.fEntityStack.elementAt(i);
              localObject1 = (String)localObject1 + " -> " + ((Entity)localObject3).name;
              i += 1;
              continue;
              localObject1 = (Entity)this.fEntityStack.elementAt(i);
              break;
            }
          }
          localObject1 = (String)localObject1 + " -> " + this.fCurrentEntity.name;
          localObject1 = (String)localObject1 + " -> " + paramString;
          this.fErrorReporter.reportError(getEntityReader(), "http://www.w3.org/TR/1998/REC-xml-19980210", "RecursiveReference", new Object[] { paramString, localObject1 }, (short)2);
          if (this.fEntityHandler == null) {
            break;
          }
          this.fResourceIdentifier.clear();
          if (bool1)
          {
            localObject3 = (Entity.ExternalEntity)localObject2;
            if (((Entity.ExternalEntity)localObject3).entityLocation == null) {
              break label630;
            }
            localObject1 = ((Entity.ExternalEntity)localObject3).entityLocation.getLiteralSystemId();
            if (((Entity.ExternalEntity)localObject3).entityLocation == null) {
              break label636;
            }
            localObject2 = ((Entity.ExternalEntity)localObject3).entityLocation.getBaseSystemId();
            label556:
            str = expandSystemId((String)localObject1, (String)localObject2);
            localXMLResourceIdentifierImpl = this.fResourceIdentifier;
            if (((Entity.ExternalEntity)localObject3).entityLocation == null) {
              break label642;
            }
          }
          label630:
          label636:
          label642:
          for (localObject3 = ((Entity.ExternalEntity)localObject3).entityLocation.getPublicId();; localObject3 = null)
          {
            localXMLResourceIdentifierImpl.setValues((String)localObject3, (String)localObject1, (String)localObject2, str);
            this.fEntityHandler.startEntity(paramString, this.fResourceIdentifier, null);
            this.fEntityHandler.endEntity(paramString);
            return;
            localObject1 = null;
            break;
            localObject2 = null;
            break label556;
          }
        }
      }
      i -= 1;
    }
    label655:
    if (bool1) {}
    for (Object localObject1 = resolveEntityAsPerStax(((Entity.ExternalEntity)localObject2).entityLocation).getXMLInputSource();; localObject1 = new XMLInputSource(null, null, null, new StringReader(((Entity.InternalEntity)localObject2).text), null))
    {
      startEntity(paramString, (XMLInputSource)localObject1, paramBoolean, bool1);
      return;
    }
  }
  
  public void startExternalSubset()
  {
    this.fInExternalSubset = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLEntityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
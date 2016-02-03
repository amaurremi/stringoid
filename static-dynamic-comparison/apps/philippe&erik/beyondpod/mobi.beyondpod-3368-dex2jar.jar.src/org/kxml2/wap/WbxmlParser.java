package org.kxml2.wap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class WbxmlParser
  implements XmlPullParser
{
  static final String HEX_DIGITS = "0123456789abcdef";
  private static final String ILLEGAL_TYPE = "Wrong event type";
  private static final String UNEXPECTED_EOF = "Unexpected EOF";
  public static final int WAP_EXTENSION = 64;
  private int ATTR_START_TABLE = 1;
  private int ATTR_VALUE_TABLE = 2;
  private int TAG_TABLE = 0;
  private String[] attrStartTable;
  private String[] attrValueTable;
  private int attributeCount;
  private String[] attributes = new String[16];
  private Hashtable cacheStringTable = null;
  private boolean degenerated;
  private int depth;
  private String[] elementStack = new String[16];
  private String encoding;
  private InputStream in;
  private boolean isWhitespace;
  private String name;
  private String namespace;
  private int nextId = -2;
  private int[] nspCounts = new int[4];
  private String[] nspStack = new String[8];
  private String prefix;
  private boolean processNsp;
  private int publicIdentifierId;
  private byte[] stringTable;
  private Vector tables = new Vector();
  private String[] tagTable;
  private String text;
  private int type;
  private int version;
  private int wapCode;
  private Object wapExtensionData;
  
  private final boolean adjustNsp()
    throws XmlPullParserException
  {
    int i = 0;
    boolean bool1 = false;
    String str;
    int j;
    Object localObject2;
    Object localObject1;
    if (i < this.attributeCount << 2)
    {
      str = this.attributes[(i + 2)];
      j = str.indexOf(':');
      label57:
      boolean bool2;
      if (j != -1)
      {
        localObject2 = str.substring(0, j);
        localObject1 = str.substring(j + 1);
        if (((String)localObject2).equals("xmlns")) {
          break label109;
        }
        bool2 = true;
        j = i;
      }
      for (;;)
      {
        i = j + 4;
        bool1 = bool2;
        break;
        j = i;
        bool2 = bool1;
        if (str.equals("xmlns"))
        {
          localObject1 = null;
          localObject2 = str;
          break label57;
          label109:
          localObject2 = this.nspCounts;
          j = this.depth;
          int k = localObject2[j];
          localObject2[j] = (k + 1);
          j = k << 1;
          this.nspStack = ensureCapacity(this.nspStack, j + 2);
          this.nspStack[j] = localObject1;
          this.nspStack[(j + 1)] = this.attributes[(i + 3)];
          if ((localObject1 != null) && (this.attributes[(i + 3)].equals(""))) {
            exception("illegal empty namespace");
          }
          localObject1 = this.attributes;
          localObject2 = this.attributes;
          j = this.attributeCount - 1;
          this.attributeCount = j;
          System.arraycopy(localObject1, i + 4, localObject2, i, (j << 2) - i);
          j = i - 4;
          bool2 = bool1;
        }
      }
    }
    if (bool1)
    {
      i = (this.attributeCount << 2) - 4;
      while (i >= 0)
      {
        localObject2 = this.attributes[(i + 2)];
        j = ((String)localObject2).indexOf(':');
        if (j == 0) {
          throw new RuntimeException("illegal attribute name: " + (String)localObject2 + " at " + this);
        }
        if (j != -1)
        {
          localObject1 = ((String)localObject2).substring(0, j);
          localObject2 = ((String)localObject2).substring(j + 1);
          str = getNamespace((String)localObject1);
          if (str == null) {
            throw new RuntimeException("Undefined Prefix: " + (String)localObject1 + " in " + this);
          }
          this.attributes[i] = str;
          this.attributes[(i + 1)] = localObject1;
          this.attributes[(i + 2)] = localObject2;
          j = (this.attributeCount << 2) - 4;
          while (j > i)
          {
            if ((((String)localObject2).equals(this.attributes[(j + 2)])) && (str.equals(this.attributes[j]))) {
              exception("Duplicate Attribute: {" + str + "}" + (String)localObject2);
            }
            j -= 4;
          }
        }
        i -= 4;
      }
    }
    i = this.name.indexOf(':');
    if (i == 0) {
      exception("illegal tag name: " + this.name);
    }
    for (;;)
    {
      this.namespace = getNamespace(this.prefix);
      if (this.namespace == null)
      {
        if (this.prefix != null) {
          exception("undefined prefix: " + this.prefix);
        }
        this.namespace = "";
      }
      return bool1;
      if (i != -1)
      {
        this.prefix = this.name.substring(0, i);
        this.name = this.name.substring(i + 1);
      }
    }
  }
  
  private final String[] ensureCapacity(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString.length >= paramInt) {
      return paramArrayOfString;
    }
    String[] arrayOfString = new String[paramInt + 16];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    return arrayOfString;
  }
  
  private final void exception(String paramString)
    throws XmlPullParserException
  {
    throw new XmlPullParserException(paramString, this, null);
  }
  
  private final void nextImpl()
    throws IOException, XmlPullParserException
  {
    if (this.type == 3) {
      this.depth -= 1;
    }
    if (this.degenerated)
    {
      this.type = 3;
      this.degenerated = false;
      return;
    }
    this.text = null;
    this.prefix = null;
    this.name = null;
    for (int i = peekId(); i == 0; i = peekId())
    {
      this.nextId = -2;
      selectPage(readByte(), true);
    }
    this.nextId = -2;
    switch (i)
    {
    default: 
      parseElement(i);
      return;
    case -1: 
      this.type = 1;
      return;
    case 1: 
      i = this.depth - 1 << 2;
      this.type = 3;
      this.namespace = this.elementStack[i];
      this.prefix = this.elementStack[(i + 1)];
      this.name = this.elementStack[(i + 2)];
      return;
    case 2: 
      this.type = 6;
      char c = (char)readInt();
      this.text = ("" + c);
      this.name = ("#" + c);
      return;
    case 3: 
      this.type = 4;
      this.text = readStrI();
      return;
    case 64: 
    case 65: 
    case 66: 
    case 128: 
    case 129: 
    case 130: 
    case 192: 
    case 193: 
    case 194: 
    case 195: 
      this.type = 64;
      this.wapCode = i;
      this.wapExtensionData = parseWapExtension(i);
      return;
    case 67: 
      throw new RuntimeException("PI curr. not supp.");
    }
    this.type = 4;
    this.text = readStrT();
  }
  
  private int peekId()
    throws IOException
  {
    if (this.nextId == -2) {
      this.nextId = this.in.read();
    }
    return this.nextId;
  }
  
  private void selectPage(int paramInt, boolean paramBoolean)
    throws XmlPullParserException
  {
    if ((this.tables.size() == 0) && (paramInt == 0)) {
      return;
    }
    if (paramInt * 3 > this.tables.size()) {
      exception("Code Page " + paramInt + " undefined!");
    }
    if (paramBoolean)
    {
      this.tagTable = ((String[])this.tables.elementAt(paramInt * 3 + this.TAG_TABLE));
      return;
    }
    this.attrStartTable = ((String[])this.tables.elementAt(paramInt * 3 + this.ATTR_START_TABLE));
    this.attrValueTable = ((String[])this.tables.elementAt(paramInt * 3 + this.ATTR_VALUE_TABLE));
  }
  
  private final void setTable(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if (this.stringTable != null) {
      throw new RuntimeException("setXxxTable must be called before setInput!");
    }
    while (this.tables.size() < paramInt1 * 3 + 3) {
      this.tables.addElement(null);
    }
    this.tables.setElementAt(paramArrayOfString, paramInt1 * 3 + paramInt2);
  }
  
  public void defineEntityReplacementText(String paramString1, String paramString2)
    throws XmlPullParserException
  {}
  
  public int getAttributeCount()
  {
    return this.attributeCount;
  }
  
  public String getAttributeName(int paramInt)
  {
    if (paramInt >= this.attributeCount) {
      throw new IndexOutOfBoundsException();
    }
    return this.attributes[((paramInt << 2) + 2)];
  }
  
  public String getAttributeNamespace(int paramInt)
  {
    if (paramInt >= this.attributeCount) {
      throw new IndexOutOfBoundsException();
    }
    return this.attributes[(paramInt << 2)];
  }
  
  public String getAttributePrefix(int paramInt)
  {
    if (paramInt >= this.attributeCount) {
      throw new IndexOutOfBoundsException();
    }
    return this.attributes[((paramInt << 2) + 1)];
  }
  
  public String getAttributeType(int paramInt)
  {
    return "CDATA";
  }
  
  public String getAttributeValue(int paramInt)
  {
    if (paramInt >= this.attributeCount) {
      throw new IndexOutOfBoundsException();
    }
    return this.attributes[((paramInt << 2) + 3)];
  }
  
  public String getAttributeValue(String paramString1, String paramString2)
  {
    int i = (this.attributeCount << 2) - 4;
    while (i >= 0)
    {
      if ((this.attributes[(i + 2)].equals(paramString2)) && ((paramString1 == null) || (this.attributes[i].equals(paramString1)))) {
        return this.attributes[(i + 3)];
      }
      i -= 4;
    }
    return null;
  }
  
  public int getColumnNumber()
  {
    return -1;
  }
  
  public int getDepth()
  {
    return this.depth;
  }
  
  public int getEventType()
    throws XmlPullParserException
  {
    return this.type;
  }
  
  public boolean getFeature(String paramString)
  {
    if ("http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(paramString)) {
      return this.processNsp;
    }
    return false;
  }
  
  public String getInputEncoding()
  {
    return this.encoding;
  }
  
  public int getLineNumber()
  {
    return -1;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNamespace()
  {
    return this.namespace;
  }
  
  public String getNamespace(String paramString)
  {
    if ("xml".equals(paramString)) {
      return "http://www.w3.org/XML/1998/namespace";
    }
    if ("xmlns".equals(paramString)) {
      return "http://www.w3.org/2000/xmlns/";
    }
    int i = (getNamespaceCount(this.depth) << 1) - 2;
    while (i >= 0)
    {
      if (paramString == null)
      {
        if (this.nspStack[i] == null) {
          return this.nspStack[(i + 1)];
        }
      }
      else if (paramString.equals(this.nspStack[i])) {
        return this.nspStack[(i + 1)];
      }
      i -= 2;
    }
    return null;
  }
  
  public int getNamespaceCount(int paramInt)
  {
    if (paramInt > this.depth) {
      throw new IndexOutOfBoundsException();
    }
    return this.nspCounts[paramInt];
  }
  
  public String getNamespacePrefix(int paramInt)
  {
    return this.nspStack[(paramInt << 1)];
  }
  
  public String getNamespaceUri(int paramInt)
  {
    return this.nspStack[((paramInt << 1) + 1)];
  }
  
  public String getPositionDescription()
  {
    if (this.type < XmlPullParser.TYPES.length) {}
    StringBuffer localStringBuffer;
    for (Object localObject = XmlPullParser.TYPES[this.type];; localObject = "unknown")
    {
      localStringBuffer = new StringBuffer((String)localObject);
      localStringBuffer.append(' ');
      if ((this.type != 2) && (this.type != 3)) {
        break label322;
      }
      if (this.degenerated) {
        localStringBuffer.append("(empty) ");
      }
      localStringBuffer.append('<');
      if (this.type == 3) {
        localStringBuffer.append('/');
      }
      if (this.prefix != null) {
        localStringBuffer.append("{" + this.namespace + "}" + this.prefix + ":");
      }
      localStringBuffer.append(this.name);
      int j = this.attributeCount;
      int i = 0;
      while (i < j << 2)
      {
        localStringBuffer.append(' ');
        if (this.attributes[(i + 1)] != null) {
          localStringBuffer.append("{" + this.attributes[i] + "}" + this.attributes[(i + 1)] + ":");
        }
        localStringBuffer.append(this.attributes[(i + 2)] + "='" + this.attributes[(i + 3)] + "'");
        i += 4;
      }
    }
    localStringBuffer.append('>');
    for (;;)
    {
      return localStringBuffer.toString();
      label322:
      if (this.type != 7) {
        if (this.type != 4)
        {
          localStringBuffer.append(getText());
        }
        else if (this.isWhitespace)
        {
          localStringBuffer.append("(whitespace)");
        }
        else
        {
          String str = getText();
          localObject = str;
          if (str.length() > 16) {
            localObject = str.substring(0, 16) + "...";
          }
          localStringBuffer.append((String)localObject);
        }
      }
    }
  }
  
  public String getPrefix()
  {
    return this.prefix;
  }
  
  public Object getProperty(String paramString)
  {
    return null;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public char[] getTextCharacters(int[] paramArrayOfInt)
  {
    if (this.type >= 4)
    {
      paramArrayOfInt[0] = 0;
      paramArrayOfInt[1] = this.text.length();
      paramArrayOfInt = new char[this.text.length()];
      this.text.getChars(0, this.text.length(), paramArrayOfInt, 0);
      return paramArrayOfInt;
    }
    paramArrayOfInt[0] = -1;
    paramArrayOfInt[1] = -1;
    return null;
  }
  
  public int getWapCode()
  {
    return this.wapCode;
  }
  
  public Object getWapExtensionData()
  {
    return this.wapExtensionData;
  }
  
  public boolean isAttributeDefault(int paramInt)
  {
    return false;
  }
  
  public boolean isEmptyElementTag()
    throws XmlPullParserException
  {
    if (this.type != 2) {
      exception("Wrong event type");
    }
    return this.degenerated;
  }
  
  public boolean isWhitespace()
    throws XmlPullParserException
  {
    if ((this.type != 4) && (this.type != 7) && (this.type != 5)) {
      exception("Wrong event type");
    }
    return this.isWhitespace;
  }
  
  public int next()
    throws XmlPullParserException, IOException
  {
    this.isWhitespace = true;
    int i = 9999;
    String str;
    int j;
    do
    {
      str = this.text;
      nextImpl();
      j = i;
      if (this.type < i) {
        j = this.type;
      }
      i = j;
    } while (j > 5);
    if (j >= 4) {
      if (str != null) {
        if (this.text != null) {
          break label155;
        }
      }
    }
    for (;;)
    {
      this.text = str;
      i = j;
      switch (peekId())
      {
      }
      this.type = j;
      if (this.type > 4) {
        this.type = 4;
      }
      return this.type;
      label155:
      str = str + this.text;
    }
  }
  
  public int nextTag()
    throws XmlPullParserException, IOException
  {
    next();
    if ((this.type == 4) && (this.isWhitespace)) {
      next();
    }
    if ((this.type != 3) && (this.type != 2)) {
      exception("unexpected type");
    }
    return this.type;
  }
  
  public String nextText()
    throws XmlPullParserException, IOException
  {
    if (this.type != 2) {
      exception("precondition: START_TAG");
    }
    next();
    String str;
    if (this.type == 4)
    {
      str = getText();
      next();
    }
    for (;;)
    {
      if (this.type != 3) {
        exception("END_TAG expected");
      }
      return str;
      str = "";
    }
  }
  
  public int nextToken()
    throws XmlPullParserException, IOException
  {
    this.isWhitespace = true;
    nextImpl();
    return this.type;
  }
  
  void parseElement(int paramInt)
    throws IOException, XmlPullParserException
  {
    this.type = 2;
    this.name = resolveId(this.tagTable, paramInt & 0x3F);
    this.attributeCount = 0;
    if ((paramInt & 0x80) != 0) {
      readAttr();
    }
    boolean bool;
    int j;
    if ((paramInt & 0x40) == 0)
    {
      bool = true;
      this.degenerated = bool;
      paramInt = this.depth;
      this.depth = (paramInt + 1);
      j = paramInt << 2;
      this.elementStack = ensureCapacity(this.elementStack, j + 4);
      this.elementStack[(j + 3)] = this.name;
      if (this.depth >= this.nspCounts.length)
      {
        int[] arrayOfInt = new int[this.depth + 4];
        System.arraycopy(this.nspCounts, 0, arrayOfInt, 0, this.nspCounts.length);
        this.nspCounts = arrayOfInt;
      }
      this.nspCounts[this.depth] = this.nspCounts[(this.depth - 1)];
      paramInt = this.attributeCount - 1;
    }
    for (;;)
    {
      if (paramInt <= 0) {
        break label243;
      }
      int i = 0;
      for (;;)
      {
        if (i < paramInt)
        {
          if (getAttributeName(paramInt).equals(getAttributeName(i))) {
            exception("Duplicate Attribute: " + getAttributeName(paramInt));
          }
          i += 1;
          continue;
          bool = false;
          break;
        }
      }
      paramInt -= 1;
    }
    label243:
    if (this.processNsp) {
      adjustNsp();
    }
    for (;;)
    {
      this.elementStack[j] = this.namespace;
      this.elementStack[(j + 1)] = this.prefix;
      this.elementStack[(j + 2)] = this.name;
      return;
      this.namespace = "";
    }
  }
  
  public Object parseWapExtension(int paramInt)
    throws IOException, XmlPullParserException
  {
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte1 = arrayOfByte2;
    switch (paramInt)
    {
    default: 
      exception("illegal id: " + paramInt);
      arrayOfByte1 = arrayOfByte2;
    case 192: 
    case 193: 
    case 194: 
      return arrayOfByte1;
    case 64: 
    case 65: 
    case 66: 
      return readStrI();
    case 128: 
    case 129: 
    case 130: 
      return new Integer(readInt());
    }
    paramInt = readInt();
    arrayOfByte2 = new byte[paramInt];
    for (;;)
    {
      arrayOfByte1 = arrayOfByte2;
      if (paramInt <= 0) {
        break;
      }
      paramInt -= this.in.read(arrayOfByte2, arrayOfByte2.length - paramInt, paramInt);
    }
  }
  
  public void readAttr()
    throws IOException, XmlPullParserException
  {
    int i = readByte();
    label71:
    label371:
    int k;
    for (int j = 0; i != 1; j = k + 1)
    {
      while (i == 0)
      {
        selectPage(readByte(), false);
        i = readByte();
      }
      String str = resolveId(this.attrStartTable, i);
      i = str.indexOf('=');
      StringBuffer localStringBuffer;
      if (i == -1)
      {
        localStringBuffer = new StringBuffer();
        i = readByte();
        if ((i <= 128) && (i != 0) && (i != 2) && (i != 3) && (i != 131) && ((i < 64) || (i > 66)) && ((i < 128) || (i > 130))) {
          break label371;
        }
        switch (i)
        {
        default: 
          localStringBuffer.append(resolveId(this.attrValueTable, i));
        }
      }
      for (;;)
      {
        i = readByte();
        break label71;
        localStringBuffer = new StringBuffer(str.substring(i + 1));
        str = str.substring(0, i);
        break;
        selectPage(readByte(), false);
        continue;
        localStringBuffer.append((char)readInt());
        continue;
        localStringBuffer.append(readStrI());
        continue;
        localStringBuffer.append(resolveWapExtension(i, parseWapExtension(i)));
        continue;
        localStringBuffer.append(readStrT());
      }
      this.attributes = ensureCapacity(this.attributes, j + 4);
      String[] arrayOfString = this.attributes;
      k = j + 1;
      arrayOfString[j] = "";
      arrayOfString = this.attributes;
      j = k + 1;
      arrayOfString[k] = null;
      arrayOfString = this.attributes;
      k = j + 1;
      arrayOfString[j] = str;
      this.attributes[k] = localStringBuffer.toString();
      this.attributeCount += 1;
    }
  }
  
  int readByte()
    throws IOException
  {
    int i = this.in.read();
    if (i == -1) {
      throw new IOException("Unexpected EOF");
    }
    return i;
  }
  
  int readInt()
    throws IOException
  {
    int i = 0;
    int k;
    int j;
    do
    {
      k = readByte();
      j = i << 7 | k & 0x7F;
      i = j;
    } while ((k & 0x80) != 0);
    return j;
  }
  
  String readStrI()
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    boolean bool = true;
    for (;;)
    {
      int i = this.in.read();
      if (i == 0)
      {
        this.isWhitespace = bool;
        String str = new String(localByteArrayOutputStream.toByteArray(), this.encoding);
        localByteArrayOutputStream.close();
        return str;
      }
      if (i == -1) {
        throw new IOException("Unexpected EOF");
      }
      if (i > 32) {
        bool = false;
      }
      localByteArrayOutputStream.write(i);
    }
  }
  
  String readStrT()
    throws IOException
  {
    int j = readInt();
    if (this.cacheStringTable == null) {
      this.cacheStringTable = new Hashtable();
    }
    String str2 = (String)this.cacheStringTable.get(new Integer(j));
    String str1 = str2;
    if (str2 == null)
    {
      int i = j;
      while ((i < this.stringTable.length) && (this.stringTable[i] != 0)) {
        i += 1;
      }
      str1 = new String(this.stringTable, j, i - j, this.encoding);
      this.cacheStringTable.put(new Integer(j), str1);
    }
    return str1;
  }
  
  public void require(int paramInt, String paramString1, String paramString2)
    throws XmlPullParserException, IOException
  {
    StringBuffer localStringBuffer;
    if ((paramInt != this.type) || ((paramString1 != null) && (!paramString1.equals(getNamespace()))) || ((paramString2 != null) && (!paramString2.equals(getName()))))
    {
      localStringBuffer = new StringBuffer().append("expected: ");
      if (paramInt != 64) {
        break label77;
      }
    }
    label77:
    for (paramString1 = "WAP Ext.";; paramString1 = XmlPullParser.TYPES[paramInt] + " {" + paramString1 + "}" + paramString2)
    {
      exception(paramString1);
      return;
    }
  }
  
  String resolveId(String[] paramArrayOfString, int paramInt)
    throws IOException
  {
    int i = (paramInt & 0x7F) - 5;
    if (i == -1)
    {
      this.wapCode = -1;
      return readStrT();
    }
    if ((i < 0) || (paramArrayOfString == null) || (i >= paramArrayOfString.length) || (paramArrayOfString[i] == null)) {
      throw new IOException("id " + paramInt + " undef.");
    }
    this.wapCode = (i + 5);
    return paramArrayOfString[i];
  }
  
  protected String resolveWapExtension(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof byte[]))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      paramObject = (byte[])paramObject;
      paramInt = 0;
      while (paramInt < paramObject.length)
      {
        localStringBuffer.append("0123456789abcdef".charAt(paramObject[paramInt] >> 4 & 0xF));
        localStringBuffer.append("0123456789abcdef".charAt(paramObject[paramInt] & 0xF));
        paramInt += 1;
      }
      return localStringBuffer.toString();
    }
    return "$(" + paramObject + ")";
  }
  
  public void setAttrStartTable(int paramInt, String[] paramArrayOfString)
  {
    setTable(paramInt, this.ATTR_START_TABLE, paramArrayOfString);
  }
  
  public void setAttrValueTable(int paramInt, String[] paramArrayOfString)
  {
    setTable(paramInt, this.ATTR_VALUE_TABLE, paramArrayOfString);
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
    throws XmlPullParserException
  {
    if ("http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(paramString))
    {
      this.processNsp = paramBoolean;
      return;
    }
    exception("unsupported feature: " + paramString);
  }
  
  public void setInput(InputStream paramInputStream, String paramString)
    throws XmlPullParserException
  {
    int i = 0;
    this.in = paramInputStream;
    for (;;)
    {
      try
      {
        this.version = readByte();
        this.publicIdentifierId = readInt();
        if (this.publicIdentifierId == 0) {
          readInt();
        }
        j = readInt();
        if (paramString != null) {
          break label179;
        }
        switch (j)
        {
        case 4: 
          throw new UnsupportedEncodingException("" + j);
        }
      }
      catch (IOException paramInputStream)
      {
        exception("Illegal input format");
        return;
      }
      this.encoding = "ISO-8859-1";
      int j = readInt();
      this.stringTable = new byte[j];
      for (;;)
      {
        int k;
        if (i < j)
        {
          k = paramInputStream.read(this.stringTable, i, j - i);
          if (k > 0) {}
        }
        else
        {
          selectPage(0, true);
          selectPage(0, false);
          return;
          this.encoding = "UTF-8";
          break;
          label179:
          this.encoding = paramString;
          break;
        }
        i += k;
      }
    }
  }
  
  public void setInput(Reader paramReader)
    throws XmlPullParserException
  {
    exception("InputStream required");
  }
  
  public void setProperty(String paramString, Object paramObject)
    throws XmlPullParserException
  {
    throw new XmlPullParserException("unsupported property: " + paramString);
  }
  
  public void setTagTable(int paramInt, String[] paramArrayOfString)
  {
    setTable(paramInt, this.TAG_TABLE, paramArrayOfString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/org/kxml2/wap/WbxmlParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
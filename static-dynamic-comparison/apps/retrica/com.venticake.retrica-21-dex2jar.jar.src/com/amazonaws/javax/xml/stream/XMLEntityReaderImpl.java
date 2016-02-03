package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.impl.io.ASCIIReader;
import com.amazonaws.javax.xml.stream.xerces.impl.io.UCSReader;
import com.amazonaws.javax.xml.stream.xerces.impl.io.UTF8Reader;
import com.amazonaws.javax.xml.stream.xerces.util.EncodingMap;
import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import com.amazonaws.javax.xml.stream.xerces.xni.QName;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Locale;
import java.util.Vector;

public class XMLEntityReaderImpl
  extends XMLEntityReader
{
  public static final boolean[] validContent = new boolean[127];
  public static final boolean[] validNames = new boolean[127];
  protected boolean fAllowJavaEncodings;
  protected Entity.ScannedEntity fCurrentEntity = null;
  protected XMLEntityManager fEntityManager;
  protected XMLErrorReporter fErrorReporter = null;
  protected PropertyManager fPropertyManager = null;
  protected SymbolTable fSymbolTable = null;
  boolean isExternal = false;
  private Vector listeners = new Vector();
  char[] scannedName = null;
  boolean whiteSpaceInfoNeeded = true;
  int whiteSpaceLen = 0;
  int[] whiteSpaceLookup = new int[100];
  
  static
  {
    for (int i = 32; i < 127; i = (char)(i + 1)) {
      validContent[i] = true;
    }
    validContent[9] = true;
    validContent[38] = false;
    validContent[60] = false;
    validContent[93] = false;
    i = 65;
    while (i <= 90)
    {
      validNames[i] = true;
      i += 1;
    }
    i = 97;
    while (i <= 122)
    {
      validNames[i] = true;
      i += 1;
    }
    i = 48;
    while (i <= 57)
    {
      validNames[i] = true;
      i += 1;
    }
    validNames[45] = true;
    validNames[46] = true;
    validNames[58] = true;
    validNames[95] = true;
  }
  
  public XMLEntityReaderImpl(XMLEntityManager paramXMLEntityManager)
  {
    this.fEntityManager = paramXMLEntityManager;
  }
  
  private void invokeListeners(int paramInt)
  {
    int i = 0;
    while (i < this.listeners.size())
    {
      ((XMLBufferListener)this.listeners.get(i)).refresh(paramInt);
      i += 1;
    }
  }
  
  public boolean arrangeCapacity(int paramInt, boolean paramBoolean)
  {
    if (this.fCurrentEntity.count - this.fCurrentEntity.position >= paramInt) {}
    do
    {
      return true;
      boolean bool;
      do
      {
        do
        {
          if (this.fCurrentEntity.count - this.fCurrentEntity.position >= paramInt) {
            break;
          }
          if (this.fCurrentEntity.ch.length - this.fCurrentEntity.position < paramInt)
          {
            invokeListeners(0);
            System.arraycopy(this.fCurrentEntity.ch, this.fCurrentEntity.position, this.fCurrentEntity.ch, 0, this.fCurrentEntity.count - this.fCurrentEntity.position);
            Entity.ScannedEntity localScannedEntity = this.fCurrentEntity;
            localScannedEntity.count -= this.fCurrentEntity.position;
            this.fCurrentEntity.position = 0;
          }
        } while (this.fCurrentEntity.count - this.fCurrentEntity.position >= paramInt);
        int i = this.fCurrentEntity.position;
        invokeListeners(i);
        bool = load(this.fCurrentEntity.count, paramBoolean);
        this.fCurrentEntity.position = i;
      } while (!bool);
    } while (this.fCurrentEntity.count - this.fCurrentEntity.position >= paramInt);
    return false;
  }
  
  protected Reader createReader(InputStream paramInputStream, String paramString, Boolean paramBoolean)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "UTF-8";
    }
    String str2 = str1.toUpperCase(Locale.ENGLISH);
    if (str2.equals("UTF-8")) {
      return new UTF8Reader(paramInputStream, this.fCurrentEntity.fBufferSize, this.fErrorReporter.getMessageFormatter("http://www.w3.org/TR/1998/REC-xml-19980210"), this.fErrorReporter.getLocale());
    }
    if (str2.equals("US-ASCII")) {
      return new ASCIIReader(paramInputStream, this.fCurrentEntity.fBufferSize, this.fErrorReporter.getMessageFormatter("http://www.w3.org/TR/1998/REC-xml-19980210"), this.fErrorReporter.getLocale());
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
      this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "EncodingByteOrderUnsupported", new Object[] { str1 }, (short)2);
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
      this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "EncodingByteOrderUnsupported", new Object[] { str1 }, (short)2);
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
      this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "EncodingDeclInvalid", new Object[] { str1 }, (short)2);
      paramString = "ISO-8859-1";
    }
    paramBoolean = EncodingMap.getIANA2JavaMapping(str2);
    if (paramBoolean == null) {
      if (!this.fAllowJavaEncodings) {}
    }
    for (;;)
    {
      return new InputStreamReader(paramInputStream, paramString);
      this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "EncodingDeclInvalid", new Object[] { paramString }, (short)2);
      paramString = "ISO8859_1";
      continue;
      paramString = paramBoolean;
    }
  }
  
  public String getBaseSystemId()
  {
    if ((this.fCurrentEntity != null) && (this.fCurrentEntity.entityLocation != null)) {
      return this.fCurrentEntity.entityLocation.getExpandedSystemId();
    }
    return null;
  }
  
  public int getChar(int paramInt)
  {
    if (arrangeCapacity(paramInt + 1, false)) {
      return this.fCurrentEntity.ch[(this.fCurrentEntity.position + paramInt)];
    }
    return -1;
  }
  
  public int getCharacterOffset()
  {
    if (this.fCurrentEntity != null) {
      return this.fCurrentEntity.fTotalCountTillLastLoad + this.fCurrentEntity.position;
    }
    return -1;
  }
  
  public int getColumnNumber()
  {
    if (this.fCurrentEntity != null) {
      return this.fCurrentEntity.columnNumber;
    }
    return -1;
  }
  
  public Entity.ScannedEntity getCurrentEntity()
  {
    return this.fCurrentEntity;
  }
  
  public String getEncoding()
  {
    return this.fCurrentEntity.encoding;
  }
  
  public String getExpandedSystemId()
  {
    if ((this.fCurrentEntity != null) && (this.fCurrentEntity.entityLocation != null)) {
      return this.fCurrentEntity.entityLocation.getExpandedSystemId();
    }
    return null;
  }
  
  public int getLineNumber()
  {
    if (this.fCurrentEntity != null) {
      return this.fCurrentEntity.lineNumber;
    }
    return -1;
  }
  
  public String getLiteralSystemId()
  {
    if ((this.fCurrentEntity != null) && (this.fCurrentEntity.entityLocation != null)) {
      return this.fCurrentEntity.entityLocation.getLiteralSystemId();
    }
    return null;
  }
  
  public String getPublicId()
  {
    if ((this.fCurrentEntity != null) && (this.fCurrentEntity.entityLocation != null)) {
      return this.fCurrentEntity.entityLocation.getPublicId();
    }
    return null;
  }
  
  public String getVersion()
  {
    return this.fCurrentEntity.version;
  }
  
  public boolean isExternal()
  {
    return this.fCurrentEntity.isExternal();
  }
  
  final boolean load(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    this.fCurrentEntity.fTotalCountTillLastLoad += this.fCurrentEntity.fLastCount;
    int i;
    if (this.fCurrentEntity.mayReadChunks)
    {
      i = this.fCurrentEntity.ch.length - paramInt;
      i = this.fCurrentEntity.reader.read(this.fCurrentEntity.ch, paramInt, i);
      if (i == -1) {
        break label117;
      }
      if (i == 0) {
        break label183;
      }
      this.fCurrentEntity.fLastCount = i;
      this.fCurrentEntity.count = (i + paramInt);
      this.fCurrentEntity.position = paramInt;
      paramBoolean = false;
    }
    for (;;)
    {
      return paramBoolean;
      Entity.ScannedEntity localScannedEntity = this.fCurrentEntity;
      i = 64;
      break;
      label117:
      this.fCurrentEntity.count = paramInt;
      this.fCurrentEntity.position = paramInt;
      if (paramBoolean)
      {
        this.fEntityManager.endEntity();
        paramBoolean = bool;
        if (this.fCurrentEntity == null) {
          continue;
        }
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
          load(0, true);
        }
      }
      paramBoolean = true;
      continue;
      label183:
      paramBoolean = false;
    }
  }
  
  public int peekChar()
  {
    if (this.fCurrentEntity.position == this.fCurrentEntity.count)
    {
      invokeListeners(0);
      load(0, true);
    }
    int i = this.fCurrentEntity.ch[this.fCurrentEntity.position];
    if ((!this.isExternal) || (i != 13)) {
      return i;
    }
    return 10;
  }
  
  public void registerListener(XMLBufferListener paramXMLBufferListener)
  {
    if (!this.listeners.contains(paramXMLBufferListener)) {
      this.listeners.add(paramXMLBufferListener);
    }
  }
  
  public void reset(PropertyManager paramPropertyManager)
  {
    this.fSymbolTable = ((SymbolTable)paramPropertyManager.getProperty("http://apache.org/xml/properties/internal/symbol-table"));
    this.fErrorReporter = ((XMLErrorReporter)paramPropertyManager.getProperty("http://apache.org/xml/properties/internal/error-reporter"));
    this.fCurrentEntity = null;
    this.whiteSpaceLen = 0;
    this.whiteSpaceInfoNeeded = true;
    this.scannedName = null;
    this.listeners.clear();
  }
  
  public int scanChar()
  {
    if (this.fCurrentEntity.position == this.fCurrentEntity.count)
    {
      invokeListeners(0);
      load(0, true);
    }
    Object localObject = this.fCurrentEntity.ch;
    Entity.ScannedEntity localScannedEntity = this.fCurrentEntity;
    int i = localScannedEntity.position;
    localScannedEntity.position = (i + 1);
    int j = localObject[i];
    if (j != 10)
    {
      i = j;
      if (j == 13)
      {
        i = j;
        if (!this.isExternal) {}
      }
    }
    else
    {
      localObject = this.fCurrentEntity;
      ((Entity.ScannedEntity)localObject).lineNumber += 1;
      this.fCurrentEntity.columnNumber = 1;
      if (this.fCurrentEntity.position == this.fCurrentEntity.count)
      {
        invokeListeners(1);
        this.fCurrentEntity.ch[0] = ((char)j);
        load(1, false);
      }
      i = j;
      if (j == 13)
      {
        i = j;
        if (this.isExternal)
        {
          localObject = this.fCurrentEntity.ch;
          localScannedEntity = this.fCurrentEntity;
          i = localScannedEntity.position;
          localScannedEntity.position = (i + 1);
          if (localObject[i] != '\n')
          {
            localObject = this.fCurrentEntity;
            ((Entity.ScannedEntity)localObject).position -= 1;
          }
          i = 10;
        }
      }
    }
    localObject = this.fCurrentEntity;
    ((Entity.ScannedEntity)localObject).columnNumber += 1;
    return i;
  }
  
  public int scanContent(XMLString paramXMLString)
  {
    int m = 0;
    int n = 0;
    int j;
    Object localObject;
    Entity.ScannedEntity localScannedEntity;
    if (this.fCurrentEntity.position == this.fCurrentEntity.count)
    {
      invokeListeners(0);
      load(0, true);
      k = this.fCurrentEntity.position;
      int i1 = this.fCurrentEntity.ch[k];
      if (i1 != 10)
      {
        j = k;
        i = m;
        if (i1 != 13) {
          break label571;
        }
        j = k;
        i = m;
        if (!this.isExternal) {
          break label571;
        }
      }
      m = 0;
      localObject = this.fCurrentEntity.ch;
      localScannedEntity = this.fCurrentEntity;
      i = localScannedEntity.position;
      localScannedEntity.position = (i + 1);
      i = localObject[i];
      if ((i != 13) || (!this.isExternal)) {
        break label398;
      }
      i = m + 1;
      localObject = this.fCurrentEntity;
      ((Entity.ScannedEntity)localObject).lineNumber += 1;
      this.fCurrentEntity.columnNumber = 1;
      j = k;
      if (this.fCurrentEntity.position != this.fCurrentEntity.count) {
        break label321;
      }
      invokeListeners(i);
      this.fCurrentEntity.position = i;
      if (!load(i, false)) {
        break label319;
      }
      j = n;
    }
    for (;;)
    {
      label215:
      k = j;
      while (k < this.fCurrentEntity.position)
      {
        this.fCurrentEntity.ch[k] = '\n';
        k += 1;
      }
      if (this.fCurrentEntity.position != this.fCurrentEntity.count - 1) {
        break;
      }
      invokeListeners(0);
      this.fCurrentEntity.ch[0] = this.fCurrentEntity.ch[(this.fCurrentEntity.count - 1)];
      load(1, false);
      this.fCurrentEntity.position = 0;
      break;
      label319:
      j = 0;
      label321:
      if (this.fCurrentEntity.ch[this.fCurrentEntity.position] == '\n')
      {
        localObject = this.fCurrentEntity;
        ((Entity.ScannedEntity)localObject).position += 1;
        j += 1;
      }
      for (;;)
      {
        m = i;
        k = j;
        if (this.fCurrentEntity.position < this.fCurrentEntity.count - 1) {
          break;
        }
        break label215;
        i += 1;
        continue;
        label398:
        if (i != 10) {
          break label498;
        }
        m += 1;
        localObject = this.fCurrentEntity;
        ((Entity.ScannedEntity)localObject).lineNumber += 1;
        this.fCurrentEntity.columnNumber = 1;
        i = m;
        j = k;
        if (this.fCurrentEntity.position == this.fCurrentEntity.count)
        {
          invokeListeners(m);
          this.fCurrentEntity.position = m;
          i = m;
          j = n;
          if (load(m, false)) {
            break label215;
          }
          j = 0;
          i = m;
        }
      }
      label498:
      localObject = this.fCurrentEntity;
      ((Entity.ScannedEntity)localObject).position -= 1;
      j = k;
      i = m;
    }
    int k = this.fCurrentEntity.position;
    if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1)
    {
      paramXMLString.setValues(this.fCurrentEntity.ch, j, k - j);
      return -1;
    }
    label571:
    if (this.fCurrentEntity.position < this.fCurrentEntity.count)
    {
      localObject = this.fCurrentEntity.ch;
      localScannedEntity = this.fCurrentEntity;
      k = localScannedEntity.position;
      localScannedEntity.position = (k + 1);
      k = localObject[k];
      if (k < 127)
      {
        int i2 = validContent[k];
        label641:
        if (i2 != 0) {
          break label773;
        }
        localObject = this.fCurrentEntity;
        ((Entity.ScannedEntity)localObject).position -= 1;
      }
    }
    else
    {
      k = this.fCurrentEntity.position - j;
      localObject = this.fCurrentEntity;
      ((Entity.ScannedEntity)localObject).columnNumber = (k - i + ((Entity.ScannedEntity)localObject).columnNumber);
      paramXMLString.setValues(this.fCurrentEntity.ch, j, k);
      if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
        break label775;
      }
      j = this.fCurrentEntity.ch[this.fCurrentEntity.position];
      i = j;
      if (j == 13)
      {
        i = j;
        if (!this.isExternal) {}
      }
    }
    label773:
    label775:
    for (int i = 10;; i = -1)
    {
      return i;
      boolean bool = XMLChar.isContent(k);
      break label641;
      break;
    }
  }
  
  public boolean scanData(String paramString, XMLStringBuffer paramXMLStringBuffer)
  {
    int n = 0;
    int i3 = paramString.length();
    int i4 = paramString.charAt(0);
    if (this.fCurrentEntity.position == this.fCurrentEntity.count)
    {
      invokeListeners(0);
      load(0, true);
    }
    int j;
    while (this.fCurrentEntity.position >= this.fCurrentEntity.count - i3)
    {
      invokeListeners(0);
      i = this.fCurrentEntity.count;
      j = this.fCurrentEntity.position;
      paramXMLStringBuffer.append(this.fCurrentEntity.ch, this.fCurrentEntity.position, i - j);
      paramString = this.fCurrentEntity;
      paramString.columnNumber += this.fCurrentEntity.count;
      this.fCurrentEntity.position = this.fCurrentEntity.count;
      load(0, true);
      return false;
      if (this.fCurrentEntity.position >= this.fCurrentEntity.count - i3)
      {
        invokeListeners(this.fCurrentEntity.count - this.fCurrentEntity.position);
        System.arraycopy(this.fCurrentEntity.ch, this.fCurrentEntity.position, this.fCurrentEntity.ch, 0, this.fCurrentEntity.count - this.fCurrentEntity.position);
        load(this.fCurrentEntity.count - this.fCurrentEntity.position, false);
        this.fCurrentEntity.position = 0;
      }
    }
    int i = this.fCurrentEntity.position;
    int i5 = this.fCurrentEntity.ch[i];
    int i2 = 0;
    int i1 = 0;
    int m = i1;
    int k = i;
    Object localObject;
    Entity.ScannedEntity localScannedEntity;
    if (i5 != 10)
    {
      k = i2;
      j = i;
      if (i5 == 13)
      {
        k = i2;
        j = i;
        if (this.isExternal)
        {
          k = i;
          m = i1;
        }
      }
    }
    else
    {
      localObject = this.fCurrentEntity.ch;
      localScannedEntity = this.fCurrentEntity;
      i = localScannedEntity.position;
      localScannedEntity.position = (i + 1);
      i = localObject[i];
      if ((i == 13) && (this.isExternal))
      {
        j = m + 1;
        localObject = this.fCurrentEntity;
        ((Entity.ScannedEntity)localObject).lineNumber += 1;
        this.fCurrentEntity.columnNumber = 1;
        i = k;
        if (this.fCurrentEntity.position == this.fCurrentEntity.count)
        {
          i = 0;
          k = 0;
          invokeListeners(j);
          this.fCurrentEntity.position = j;
          if (load(j, false)) {
            i = k;
          }
        }
      }
      for (;;)
      {
        label470:
        k = i;
        while (k < this.fCurrentEntity.position)
        {
          this.fCurrentEntity.ch[k] = '\n';
          k += 1;
        }
        if (this.fCurrentEntity.ch[this.fCurrentEntity.position] == '\n')
        {
          localObject = this.fCurrentEntity;
          ((Entity.ScannedEntity)localObject).position += 1;
          i += 1;
        }
        do
        {
          do
          {
            for (;;)
            {
              m = j;
              k = i;
              if (this.fCurrentEntity.position < this.fCurrentEntity.count - 1) {
                break;
              }
              break label470;
              j += 1;
            }
            if (i != 10) {
              break label701;
            }
            m += 1;
            localObject = this.fCurrentEntity;
            ((Entity.ScannedEntity)localObject).lineNumber += 1;
            this.fCurrentEntity.columnNumber = 1;
            j = m;
            i = k;
          } while (this.fCurrentEntity.position != this.fCurrentEntity.count);
          i = 0;
          k = 0;
          invokeListeners(m);
          this.fCurrentEntity.position = m;
          this.fCurrentEntity.count = m;
          j = m;
        } while (!load(m, false));
        j = m;
        i = k;
        continue;
        label701:
        localObject = this.fCurrentEntity;
        ((Entity.ScannedEntity)localObject).position -= 1;
        j = m;
        i = k;
      }
      m = this.fCurrentEntity.position;
      k = j;
      j = i;
      if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1)
      {
        paramXMLStringBuffer.append(this.fCurrentEntity.ch, i, m - i);
        return true;
      }
    }
    label782:
    i = n;
    if (this.fCurrentEntity.position < this.fCurrentEntity.count)
    {
      localObject = this.fCurrentEntity.ch;
      localScannedEntity = this.fCurrentEntity;
      i = localScannedEntity.position;
      localScannedEntity.position = (i + 1);
      i = localObject[i];
      if (i != i4) {
        break label1065;
      }
      m = this.fCurrentEntity.position;
      i = 1;
      label853:
      if (i >= i3) {
        break label1036;
      }
      if (this.fCurrentEntity.position == this.fCurrentEntity.count)
      {
        localObject = this.fCurrentEntity;
        ((Entity.ScannedEntity)localObject).position -= i;
        i = n;
      }
    }
    else
    {
      label897:
      m = this.fCurrentEntity.position - j;
      localObject = this.fCurrentEntity;
      ((Entity.ScannedEntity)localObject).columnNumber = (m - k + ((Entity.ScannedEntity)localObject).columnNumber);
      if (i == 0) {
        break label1177;
      }
    }
    label1036:
    label1065:
    label1177:
    for (k = m - i3;; k = m)
    {
      paramXMLStringBuffer.append(this.fCurrentEntity.ch, j, k);
      n = i;
      if (i == 0) {
        break;
      }
      if (i == 0)
      {
        return true;
        localObject = this.fCurrentEntity.ch;
        localScannedEntity = this.fCurrentEntity;
        i1 = localScannedEntity.position;
        localScannedEntity.position = (i1 + 1);
        i1 = localObject[i1];
        if (paramString.charAt(i) != i1)
        {
          localObject = this.fCurrentEntity;
          ((Entity.ScannedEntity)localObject).position -= i;
          if (this.fCurrentEntity.position != m - 1 + i3) {
            break label782;
          }
          i = 1;
          break label897;
        }
        i += 1;
        break label853;
        if ((i == 10) || ((this.isExternal) && (i == 13)))
        {
          localObject = this.fCurrentEntity;
          ((Entity.ScannedEntity)localObject).position -= 1;
          i = n;
          break label897;
        }
        if (!XMLChar.isInvalid(i)) {
          break label782;
        }
        paramString = this.fCurrentEntity;
        paramString.position -= 1;
        i = this.fCurrentEntity.position - j;
        paramString = this.fCurrentEntity;
        paramString.columnNumber = (i - k + paramString.columnNumber);
        paramXMLStringBuffer.append(this.fCurrentEntity.ch, j, i);
        return true;
      }
      return false;
    }
  }
  
  public int scanLiteral(int paramInt, XMLString paramXMLString)
  {
    int i;
    Object localObject;
    Entity.ScannedEntity localScannedEntity;
    int j;
    if (this.fCurrentEntity.position == this.fCurrentEntity.count)
    {
      invokeListeners(0);
      load(0, true);
      k = this.fCurrentEntity.position;
      i = this.fCurrentEntity.ch[k];
      if (this.whiteSpaceInfoNeeded) {
        this.whiteSpaceLen = 0;
      }
      if ((i != 10) && ((i != 13) || (!this.isExternal))) {
        break label990;
      }
      m = 0;
      localObject = this.fCurrentEntity.ch;
      localScannedEntity = this.fCurrentEntity;
      i = localScannedEntity.position;
      localScannedEntity.position = (i + 1);
      i = localObject[i];
      if ((i != 13) || (!this.isExternal)) {
        break label422;
      }
      j = m + 1;
      localObject = this.fCurrentEntity;
      ((Entity.ScannedEntity)localObject).lineNumber += 1;
      this.fCurrentEntity.columnNumber = 1;
      i = k;
      if (this.fCurrentEntity.position != this.fCurrentEntity.count) {
        break label342;
      }
      invokeListeners(j);
      this.fCurrentEntity.position = j;
      if (!load(j, false)) {
        break label340;
      }
      i = 0;
    }
    for (;;)
    {
      label209:
      k = i;
      while (k < this.fCurrentEntity.position)
      {
        this.fCurrentEntity.ch[k] = '\n';
        localObject = this.whiteSpaceLookup;
        m = this.whiteSpaceLen;
        this.whiteSpaceLen = (m + 1);
        localObject[m] = k;
        k += 1;
      }
      if (this.fCurrentEntity.position != this.fCurrentEntity.count - 1) {
        break;
      }
      invokeListeners(0);
      this.fCurrentEntity.ch[0] = this.fCurrentEntity.ch[(this.fCurrentEntity.count - 1)];
      load(1, false);
      this.fCurrentEntity.position = 0;
      break;
      label340:
      i = 0;
      label342:
      if (this.fCurrentEntity.ch[this.fCurrentEntity.position] == '\n')
      {
        localObject = this.fCurrentEntity;
        ((Entity.ScannedEntity)localObject).position += 1;
        i += 1;
      }
      label422:
      do
      {
        for (;;)
        {
          m = j;
          k = i;
          if (this.fCurrentEntity.position < this.fCurrentEntity.count - 1) {
            break;
          }
          break label209;
          j += 1;
        }
        if (i != 10) {
          break label518;
        }
        m += 1;
        localObject = this.fCurrentEntity;
        ((Entity.ScannedEntity)localObject).lineNumber += 1;
        this.fCurrentEntity.columnNumber = 1;
        j = m;
        i = k;
      } while (this.fCurrentEntity.position != this.fCurrentEntity.count);
      invokeListeners(m);
      this.fCurrentEntity.position = m;
      if (!load(m, false)) {
        break label981;
      }
      i = 0;
      j = m;
      continue;
      label518:
      localObject = this.fCurrentEntity;
      ((Entity.ScannedEntity)localObject).position -= 1;
      j = m;
      i = k;
    }
    int m = this.fCurrentEntity.position;
    int k = i;
    if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1)
    {
      paramXMLString.setValues(this.fCurrentEntity.ch, i, m - i);
      return -1;
      if ((this.whiteSpaceInfoNeeded) && ((i == 32) || (i == 9)))
      {
        if (this.whiteSpaceLen >= this.whiteSpaceLookup.length) {
          break label908;
        }
        localObject = this.whiteSpaceLookup;
        i = this.whiteSpaceLen;
        this.whiteSpaceLen = (i + 1);
        localObject[i] = (this.fCurrentEntity.position - 1);
      }
    }
    for (;;)
    {
      label657:
      if (this.fCurrentEntity.position < this.fCurrentEntity.count)
      {
        localObject = this.fCurrentEntity.ch;
        localScannedEntity = this.fCurrentEntity;
        i = localScannedEntity.position;
        localScannedEntity.position = (i + 1);
        i = localObject[i];
        if (((i == paramInt) && ((!this.fCurrentEntity.literal) || (this.isExternal))) || (i == 37))
        {
          localObject = this.fCurrentEntity;
          ((Entity.ScannedEntity)localObject).position -= 1;
        }
      }
      else
      {
        i = this.fCurrentEntity.position - k;
        localObject = this.fCurrentEntity;
        ((Entity.ScannedEntity)localObject).columnNumber = (i - j + ((Entity.ScannedEntity)localObject).columnNumber);
        paramXMLString.setValues(this.fCurrentEntity.ch, k, i);
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
          break label976;
        }
        j = this.fCurrentEntity.ch[this.fCurrentEntity.position];
        i = j;
        if (j == paramInt)
        {
          i = j;
          if (!this.fCurrentEntity.literal) {}
        }
      }
      label906:
      label908:
      label976:
      for (i = -1;; i = -1)
      {
        return i;
        if (i < 127) {}
        boolean bool;
        for (int n = validContent[i];; bool = XMLChar.isContent(i))
        {
          if (n != 0) {
            break label906;
          }
          localObject = this.fCurrentEntity;
          ((Entity.ScannedEntity)localObject).position -= 1;
          break;
        }
        break;
        localObject = new int[this.whiteSpaceLookup.length + 20];
        System.arraycopy(this.whiteSpaceLookup, 0, localObject, 0, this.whiteSpaceLookup.length);
        this.whiteSpaceLookup = ((int[])localObject);
        localObject = this.whiteSpaceLookup;
        i = this.whiteSpaceLen;
        this.whiteSpaceLen = (i + 1);
        localObject[i] = (this.fCurrentEntity.position - 1);
        break label657;
      }
      label981:
      i = 0;
      j = m;
      break;
      label990:
      j = 0;
    }
  }
  
  public String scanName()
  {
    if (this.fCurrentEntity.position == this.fCurrentEntity.count)
    {
      invokeListeners(0);
      load(0, true);
    }
    int j = this.fCurrentEntity.position;
    int i = j;
    Object localObject;
    if (XMLChar.isNameStart(this.fCurrentEntity.ch[j]))
    {
      localObject = this.fCurrentEntity;
      int k = ((Entity.ScannedEntity)localObject).position + 1;
      ((Entity.ScannedEntity)localObject).position = k;
      i = j;
      if (k == this.fCurrentEntity.count)
      {
        invokeListeners(1);
        this.fCurrentEntity.ch[0] = this.fCurrentEntity.ch[j];
        if (load(1, false))
        {
          localObject = this.fCurrentEntity;
          ((Entity.ScannedEntity)localObject).columnNumber += 1;
          localObject = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, 0, 1);
          this.scannedName = this.fSymbolTable.getCharArray();
          return (String)localObject;
        }
      }
    }
    label425:
    for (;;)
    {
      i = 0;
      do
      {
        j = this.fCurrentEntity.ch[this.fCurrentEntity.position];
        if (j < 127) {}
        boolean bool;
        for (int m = validNames[j]; m == 0; bool = XMLChar.isName(j))
        {
          j = this.fCurrentEntity.position - i;
          localObject = this.fCurrentEntity;
          ((Entity.ScannedEntity)localObject).columnNumber += j;
          if (j <= 0) {
            break label427;
          }
          localObject = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, i, j);
          this.scannedName = this.fSymbolTable.getCharArray();
          return (String)localObject;
        }
        localObject = this.fCurrentEntity;
        j = ((Entity.ScannedEntity)localObject).position + 1;
        ((Entity.ScannedEntity)localObject).position = j;
      } while (j != this.fCurrentEntity.count);
      j = this.fCurrentEntity.position - i;
      invokeListeners(j);
      if (j == this.fCurrentEntity.fBufferSize)
      {
        localObject = new char[this.fCurrentEntity.fBufferSize * 2];
        System.arraycopy(this.fCurrentEntity.ch, i, localObject, 0, j);
        this.fCurrentEntity.ch = ((char[])localObject);
        localObject = this.fCurrentEntity;
        ((Entity.ScannedEntity)localObject).fBufferSize *= 2;
      }
      for (;;)
      {
        if (!load(j, false)) {
          break label425;
        }
        i = 0;
        break;
        System.arraycopy(this.fCurrentEntity.ch, i, this.fCurrentEntity.ch, 0, j);
      }
    }
    label427:
    return null;
  }
  
  public String scanNmtoken()
  {
    if (this.fCurrentEntity.position == this.fCurrentEntity.count)
    {
      invokeListeners(0);
      load(0, true);
    }
    int i = this.fCurrentEntity.position;
    for (;;)
    {
      int j = this.fCurrentEntity.ch[this.fCurrentEntity.position];
      if (j < 127) {}
      boolean bool;
      for (int k = validNames[j]; k == 0; bool = XMLChar.isName(j))
      {
        j = this.fCurrentEntity.position - i;
        localObject = this.fCurrentEntity;
        ((Entity.ScannedEntity)localObject).columnNumber += j;
        if (j <= 0) {
          break label280;
        }
        return this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, i, j);
      }
      Object localObject = this.fCurrentEntity;
      j = ((Entity.ScannedEntity)localObject).position + 1;
      ((Entity.ScannedEntity)localObject).position = j;
      if (j == this.fCurrentEntity.count)
      {
        j = this.fCurrentEntity.position - i;
        invokeListeners(j);
        if (j == this.fCurrentEntity.fBufferSize)
        {
          localObject = new char[this.fCurrentEntity.fBufferSize * 2];
          System.arraycopy(this.fCurrentEntity.ch, i, localObject, 0, j);
          this.fCurrentEntity.ch = ((char[])localObject);
          localObject = this.fCurrentEntity;
          ((Entity.ScannedEntity)localObject).fBufferSize *= 2;
        }
        for (;;)
        {
          if (!load(j, false)) {
            break label275;
          }
          i = 0;
          break;
          System.arraycopy(this.fCurrentEntity.ch, i, this.fCurrentEntity.ch, 0, j);
        }
        label275:
        i = 0;
      }
    }
    label280:
    return null;
  }
  
  public boolean scanQName(QName paramQName)
  {
    int i1 = 0;
    if (this.fCurrentEntity.position == this.fCurrentEntity.count)
    {
      invokeListeners(0);
      load(0, true);
    }
    int j = this.fCurrentEntity.position;
    boolean bool1 = i1;
    Object localObject;
    if (XMLChar.isNameStart(this.fCurrentEntity.ch[j]))
    {
      localObject = this.fCurrentEntity;
      k = ((Entity.ScannedEntity)localObject).position + 1;
      ((Entity.ScannedEntity)localObject).position = k;
      i = j;
      if (k != this.fCurrentEntity.count) {
        break label192;
      }
      invokeListeners(1);
      this.fCurrentEntity.ch[0] = this.fCurrentEntity.ch[j];
      if (load(1, false))
      {
        localObject = this.fCurrentEntity;
        ((Entity.ScannedEntity)localObject).columnNumber += 1;
        localObject = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, 0, 1);
        paramQName.setValues(null, (String)localObject, (String)localObject, null);
        paramQName.characters = this.fSymbolTable.getCharArray();
        bool1 = true;
      }
    }
    else
    {
      return bool1;
    }
    int i = 0;
    label192:
    int k = -1;
    j = i;
    i = k;
    for (;;)
    {
      int m = this.fCurrentEntity.ch[this.fCurrentEntity.position];
      label232:
      label243:
      String str2;
      String str1;
      if (m < 127)
      {
        int n = validNames[m];
        if (n != 0) {
          break label389;
        }
        m = j;
        k = i;
        i = this.fCurrentEntity.position - m;
        localObject = this.fCurrentEntity;
        ((Entity.ScannedEntity)localObject).columnNumber += i;
        n = i1;
        if (i <= 0) {
          break;
        }
        str2 = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, m, i);
        paramQName.characters = this.fSymbolTable.getCharArray();
        if (k == -1) {
          break label598;
        }
        j = k - m;
        str1 = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, m, j);
        localObject = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, k + 1, i - j - 1);
      }
      for (;;)
      {
        paramQName.setValues(str1, (String)localObject, str2, null);
        return true;
        boolean bool2 = XMLChar.isName(m);
        break label232;
        label389:
        k = i;
        if (m == 58)
        {
          k = i;
          m = j;
          if (i != -1) {
            break label243;
          }
          k = this.fCurrentEntity.position;
        }
        localObject = this.fCurrentEntity;
        m = ((Entity.ScannedEntity)localObject).position + 1;
        ((Entity.ScannedEntity)localObject).position = m;
        i = k;
        if (m != this.fCurrentEntity.count) {
          break;
        }
        m = this.fCurrentEntity.position - j;
        invokeListeners(m);
        if (m == this.fCurrentEntity.fBufferSize)
        {
          localObject = new char[this.fCurrentEntity.fBufferSize * 2];
          System.arraycopy(this.fCurrentEntity.ch, j, localObject, 0, m);
          this.fCurrentEntity.ch = ((char[])localObject);
          localObject = this.fCurrentEntity;
          ((Entity.ScannedEntity)localObject).fBufferSize *= 2;
        }
        for (;;)
        {
          i = k;
          if (k != -1) {
            i = k - j;
          }
          if (!load(m, false)) {
            break label608;
          }
          m = 0;
          k = i;
          break;
          System.arraycopy(this.fCurrentEntity.ch, j, this.fCurrentEntity.ch, 0, m);
        }
        label598:
        localObject = str2;
        str1 = null;
      }
      label608:
      j = 0;
    }
  }
  
  public void setCurrentEntity(Entity.ScannedEntity paramScannedEntity)
  {
    this.fCurrentEntity = paramScannedEntity;
    if (this.fCurrentEntity != null) {
      this.isExternal = this.fCurrentEntity.isExternal();
    }
  }
  
  public void setEncoding(String paramString)
  {
    String str;
    if ((this.fCurrentEntity.stream != null) && ((this.fCurrentEntity.encoding == null) || (!this.fCurrentEntity.encoding.equals(paramString))))
    {
      if ((this.fCurrentEntity.encoding == null) || (!this.fCurrentEntity.encoding.startsWith("UTF-16"))) {
        break label222;
      }
      str = paramString.toUpperCase(Locale.ENGLISH);
      if (!str.equals("UTF-16")) {}
    }
    else
    {
      return;
    }
    if (str.equals("ISO-10646-UCS-4"))
    {
      if (this.fCurrentEntity.encoding.equals("UTF-16BE"))
      {
        this.fCurrentEntity.reader = new UCSReader(this.fCurrentEntity.stream, (short)8);
        return;
      }
      this.fCurrentEntity.reader = new UCSReader(this.fCurrentEntity.stream, (short)4);
      return;
    }
    if (str.equals("ISO-10646-UCS-2"))
    {
      if (this.fCurrentEntity.encoding.equals("UTF-16BE"))
      {
        this.fCurrentEntity.reader = new UCSReader(this.fCurrentEntity.stream, (short)2);
        return;
      }
      this.fCurrentEntity.reader = new UCSReader(this.fCurrentEntity.stream, (short)1);
      return;
    }
    label222:
    this.fCurrentEntity.reader = createReader(this.fCurrentEntity.stream, paramString, null);
    this.fCurrentEntity.encoding = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.fCurrentEntity.version = paramString;
  }
  
  public boolean skipChar(int paramInt)
  {
    if (this.fCurrentEntity.position == this.fCurrentEntity.count)
    {
      invokeListeners(0);
      load(0, true);
    }
    int i = this.fCurrentEntity.ch[this.fCurrentEntity.position];
    Entity.ScannedEntity localScannedEntity;
    if (i == paramInt)
    {
      localScannedEntity = this.fCurrentEntity;
      localScannedEntity.position += 1;
      if (paramInt == 10)
      {
        localScannedEntity = this.fCurrentEntity;
        localScannedEntity.lineNumber += 1;
        this.fCurrentEntity.columnNumber = 1;
        return true;
      }
      localScannedEntity = this.fCurrentEntity;
      localScannedEntity.columnNumber += 1;
      return true;
    }
    if ((paramInt == 10) && (i == 13) && (this.isExternal))
    {
      if (this.fCurrentEntity.position == this.fCurrentEntity.count)
      {
        invokeListeners(1);
        this.fCurrentEntity.ch[0] = ((char)i);
        load(1, false);
      }
      localScannedEntity = this.fCurrentEntity;
      localScannedEntity.position += 1;
      if (this.fCurrentEntity.ch[this.fCurrentEntity.position] == '\n')
      {
        localScannedEntity = this.fCurrentEntity;
        localScannedEntity.position += 1;
      }
      localScannedEntity = this.fCurrentEntity;
      localScannedEntity.lineNumber += 1;
      this.fCurrentEntity.columnNumber = 1;
      return true;
    }
    return false;
  }
  
  public boolean skipSpaces()
  {
    if (this.fCurrentEntity.position == this.fCurrentEntity.count)
    {
      invokeListeners(0);
      load(0, true);
    }
    if (this.fCurrentEntity == null) {}
    int i;
    do
    {
      return false;
      i = this.fCurrentEntity.ch[this.fCurrentEntity.position];
    } while (!XMLChar.isSpace(i));
    Object localObject;
    boolean bool1;
    if ((i == 10) || ((this.isExternal) && (i == 13)))
    {
      localObject = this.fCurrentEntity;
      ((Entity.ScannedEntity)localObject).lineNumber += 1;
      this.fCurrentEntity.columnNumber = 1;
      if (this.fCurrentEntity.position != this.fCurrentEntity.count - 1) {
        break label362;
      }
      invokeListeners(0);
      this.fCurrentEntity.ch[0] = ((char)i);
      bool1 = load(1, true);
      if (!bool1) {
        this.fCurrentEntity.position = 0;
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (i == 13)
      {
        bool2 = bool1;
        if (this.isExternal)
        {
          localObject = this.fCurrentEntity.ch;
          Entity.ScannedEntity localScannedEntity = this.fCurrentEntity;
          i = localScannedEntity.position + 1;
          localScannedEntity.position = i;
          bool2 = bool1;
          if (localObject[i] != '\n')
          {
            localObject = this.fCurrentEntity;
            ((Entity.ScannedEntity)localObject).position -= 1;
          }
        }
      }
      for (bool2 = bool1;; bool2 = false)
      {
        if (!bool2)
        {
          localObject = this.fCurrentEntity;
          ((Entity.ScannedEntity)localObject).position += 1;
        }
        if (this.fCurrentEntity.position != this.fCurrentEntity.count) {
          break label335;
        }
        invokeListeners(0);
        load(0, true);
        if (this.fCurrentEntity != null) {
          break label335;
        }
        return true;
        if (this.fCurrentEntity != null) {
          break;
        }
        return true;
        localObject = this.fCurrentEntity;
        ((Entity.ScannedEntity)localObject).columnNumber += 1;
      }
      label335:
      int j = this.fCurrentEntity.ch[this.fCurrentEntity.position];
      i = j;
      if (XMLChar.isSpace(j)) {
        break;
      }
      return true;
      label362:
      bool1 = false;
    }
  }
  
  public boolean skipString(String paramString)
  {
    int k = paramString.length();
    int m;
    int j;
    int i;
    if (arrangeCapacity(k, false))
    {
      m = this.fCurrentEntity.position;
      j = this.fCurrentEntity.position;
      i = k - 1;
      j = j + k - 1;
    }
    for (;;)
    {
      if (paramString.charAt(i) == this.fCurrentEntity.ch[j])
      {
        if (j == m)
        {
          this.fCurrentEntity.position += k;
          paramString = this.fCurrentEntity;
          paramString.columnNumber += k;
          return true;
        }
      }
      else {
        return false;
      }
      j -= 1;
      i -= 1;
    }
  }
  
  public boolean skipString(char[] paramArrayOfChar)
  {
    int k = paramArrayOfChar.length;
    int i;
    int j;
    if (arrangeCapacity(k, false))
    {
      i = this.fCurrentEntity.position;
      j = this.fCurrentEntity.position;
      j = 0;
    }
    while (j < k)
    {
      if (this.fCurrentEntity.ch[i] != paramArrayOfChar[j]) {
        return false;
      }
      j += 1;
      i += 1;
    }
    this.fCurrentEntity.position += k;
    paramArrayOfChar = this.fCurrentEntity;
    paramArrayOfChar.columnNumber += k;
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLEntityReaderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
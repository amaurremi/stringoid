package com.amazonaws.javax.xml.stream.dtd.nonvalidating;

import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.XMLSymbols;
import com.amazonaws.javax.xml.stream.xerces.xni.Augmentations;
import com.amazonaws.javax.xml.stream.xerces.xni.QName;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLLocator;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLDTDContentModelSource;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLDTDSource;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class DTDGrammar
{
  protected XMLAttributeDecl fAttributeDecl = new XMLAttributeDecl();
  private int fAttributeDeclCount = 0;
  private short[][] fAttributeDeclDefaultType = new short[4][];
  private String[][] fAttributeDeclDefaultValue = new String[4][];
  private String[][][] fAttributeDeclEnumeration = new String[4][][];
  private QName[][] fAttributeDeclName = new QName[4][];
  private int[][] fAttributeDeclNextAttributeDeclIndex = new int[4][];
  private String[][] fAttributeDeclNonNormalizedDefaultValue = new String[4][];
  private short[][] fAttributeDeclType = new short[4][];
  protected int fCurrentAttributeIndex;
  protected int fCurrentElementIndex;
  protected XMLDTDContentModelSource fDTDContentModelSource = null;
  protected XMLDTDSource fDTDSource = null;
  private int fDepth = 0;
  private XMLElementDecl fElementDecl = new XMLElementDecl();
  private int fElementDeclCount = 0;
  private int[][] fElementDeclFirstAttributeDeclIndex = new int[4][];
  private int[][] fElementDeclLastAttributeDeclIndex = new int[4][];
  private QName[][] fElementDeclName = new QName[4][];
  Hashtable fElementDeclTab = new Hashtable();
  private short[][] fElementDeclType = new short[4][];
  private DTDGrammar.QNameHashtable fElementIndexMap = new DTDGrammar.QNameHashtable();
  private int fEpsilonIndex = -1;
  private boolean fIsImmutable = false;
  private int fLeafCount = 0;
  private int[] fNodeIndexStack = null;
  private short[] fOpStack = null;
  private int[] fPrevNodeIndexStack = null;
  private QName fQName = new QName();
  private QName fQName2 = new QName();
  protected boolean fReadingExternalDTD = false;
  private XMLSimpleType fSimpleType = new XMLSimpleType();
  private SymbolTable fSymbolTable;
  int nodeIndex = -1;
  private ArrayList notationDecls = new ArrayList();
  int prevNodeIndex = -1;
  int valueIndex = -1;
  
  public DTDGrammar(SymbolTable paramSymbolTable)
  {
    this.fSymbolTable = paramSymbolTable;
  }
  
  private void ensureAttributeDeclCapacity(int paramInt)
  {
    if (paramInt >= this.fAttributeDeclName.length)
    {
      this.fAttributeDeclName = resize(this.fAttributeDeclName, this.fAttributeDeclName.length * 2);
      this.fAttributeDeclType = resize(this.fAttributeDeclType, this.fAttributeDeclType.length * 2);
      this.fAttributeDeclEnumeration = resize(this.fAttributeDeclEnumeration, this.fAttributeDeclEnumeration.length * 2);
      this.fAttributeDeclDefaultType = resize(this.fAttributeDeclDefaultType, this.fAttributeDeclDefaultType.length * 2);
      this.fAttributeDeclDefaultValue = resize(this.fAttributeDeclDefaultValue, this.fAttributeDeclDefaultValue.length * 2);
      this.fAttributeDeclNonNormalizedDefaultValue = resize(this.fAttributeDeclNonNormalizedDefaultValue, this.fAttributeDeclNonNormalizedDefaultValue.length * 2);
      this.fAttributeDeclNextAttributeDeclIndex = resize(this.fAttributeDeclNextAttributeDeclIndex, this.fAttributeDeclNextAttributeDeclIndex.length * 2);
    }
    while (this.fAttributeDeclName[paramInt] == null)
    {
      this.fAttributeDeclName[paramInt] = new QName['Ā'];
      this.fAttributeDeclType[paramInt] = new short['Ā'];
      this.fAttributeDeclEnumeration[paramInt] = new String['Ā'][];
      this.fAttributeDeclDefaultType[paramInt] = new short['Ā'];
      this.fAttributeDeclDefaultValue[paramInt] = new String['Ā'];
      this.fAttributeDeclNonNormalizedDefaultValue[paramInt] = new String['Ā'];
      this.fAttributeDeclNextAttributeDeclIndex[paramInt] = new int['Ā'];
      return;
    }
  }
  
  private void ensureElementDeclCapacity(int paramInt)
  {
    if (paramInt >= this.fElementDeclName.length)
    {
      this.fElementDeclName = resize(this.fElementDeclName, this.fElementDeclName.length * 2);
      this.fElementDeclType = resize(this.fElementDeclType, this.fElementDeclType.length * 2);
      this.fElementDeclFirstAttributeDeclIndex = resize(this.fElementDeclFirstAttributeDeclIndex, this.fElementDeclFirstAttributeDeclIndex.length * 2);
      this.fElementDeclLastAttributeDeclIndex = resize(this.fElementDeclLastAttributeDeclIndex, this.fElementDeclLastAttributeDeclIndex.length * 2);
    }
    while (this.fElementDeclName[paramInt] == null)
    {
      this.fElementDeclName[paramInt] = new QName['Ā'];
      this.fElementDeclType[paramInt] = new short['Ā'];
      this.fElementDeclFirstAttributeDeclIndex[paramInt] = new int['Ā'];
      this.fElementDeclLastAttributeDeclIndex[paramInt] = new int['Ā'];
      return;
    }
  }
  
  private boolean normalizeDefaultAttrValue(XMLString paramXMLString)
  {
    int i = paramXMLString.length;
    i = paramXMLString.offset;
    int n = paramXMLString.offset + paramXMLString.length;
    int k = paramXMLString.offset;
    int j = 1;
    if (k < n) {
      if (paramXMLString.ch[k] == ' ')
      {
        if (j != 0) {
          break label144;
        }
        char[] arrayOfChar = paramXMLString.ch;
        int m = i + 1;
        arrayOfChar[i] = ' ';
        j = 1;
        i = m;
      }
    }
    label144:
    for (;;)
    {
      k += 1;
      break;
      if (i != k) {
        paramXMLString.ch[i] = paramXMLString.ch[k];
      }
      i += 1;
      j = 0;
      continue;
      if (i != n)
      {
        k = i;
        if (j != 0) {
          k = i - 1;
        }
        paramXMLString.length = (k - paramXMLString.offset);
        return true;
      }
      return false;
    }
  }
  
  private static int[][] resize(int[][] paramArrayOfInt, int paramInt)
  {
    int[][] arrayOfInt = new int[paramInt][];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramArrayOfInt.length);
    return arrayOfInt;
  }
  
  private static QName[][] resize(QName[][] paramArrayOfQName, int paramInt)
  {
    QName[][] arrayOfQName = new QName[paramInt][];
    System.arraycopy(paramArrayOfQName, 0, arrayOfQName, 0, paramArrayOfQName.length);
    return arrayOfQName;
  }
  
  private static String[][] resize(String[][] paramArrayOfString, int paramInt)
  {
    String[][] arrayOfString = new String[paramInt][];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    return arrayOfString;
  }
  
  private static short[][] resize(short[][] paramArrayOfShort, int paramInt)
  {
    short[][] arrayOfShort = new short[paramInt][];
    System.arraycopy(paramArrayOfShort, 0, arrayOfShort, 0, paramArrayOfShort.length);
    return arrayOfShort;
  }
  
  private static String[][][] resize(String[][][] paramArrayOfString, int paramInt)
  {
    String[][][] arrayOfString = new String[paramInt][][];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    return arrayOfString;
  }
  
  public void attributeDecl(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, String paramString4, XMLString paramXMLString1, XMLString paramXMLString2, Augmentations paramAugmentations)
  {
    if ((paramString3 != XMLSymbols.fCDATASymbol) && (paramXMLString1 != null)) {
      normalizeDefaultAttrValue(paramXMLString1);
    }
    if (this.fElementDeclTab.containsKey(paramString1)) {}
    int i;
    for (;;)
    {
      i = getElementDeclIndex(paramString1);
      if (getAttributeDeclIndex(i, paramString2) == -1) {
        break;
      }
      return;
      this.fCurrentElementIndex = createElementDecl();
      paramAugmentations = new XMLElementDecl();
      paramAugmentations.name.setValues(null, paramString1, paramString1, null);
      paramAugmentations.scope = -1;
      this.fElementDeclTab.put(paramString1, paramAugmentations);
      setElementDecl(this.fCurrentElementIndex, paramAugmentations);
    }
    this.fCurrentAttributeIndex = createAttributeDecl();
    this.fSimpleType.clear();
    if (paramString4 != null)
    {
      if (paramString4.equals("#FIXED"))
      {
        paramString1 = this.fSimpleType;
        paramString4 = this.fSimpleType;
        paramString1.defaultType = 1;
      }
    }
    else
    {
      paramString4 = this.fSimpleType;
      if (paramXMLString1 == null) {
        break label351;
      }
      paramString1 = paramXMLString1.toString();
      label172:
      paramString4.defaultValue = paramString1;
      paramString4 = this.fSimpleType;
      if (paramXMLString2 == null) {
        break label356;
      }
      paramString1 = paramXMLString2.toString();
      label195:
      paramString4.nonNormalizedDefaultValue = paramString1;
      this.fSimpleType.enumeration = paramArrayOfString;
      if (!paramString3.equals("CDATA")) {
        break label361;
      }
      this.fSimpleType.type = 0;
    }
    for (;;)
    {
      this.fQName.setValues(null, paramString2, paramString2, null);
      this.fAttributeDecl.setValues(this.fQName, this.fSimpleType, false);
      setAttributeDecl(i, this.fCurrentAttributeIndex, this.fAttributeDecl);
      i = this.fCurrentAttributeIndex;
      int j = this.fCurrentAttributeIndex;
      ensureAttributeDeclCapacity(i >> 8);
      return;
      if (paramString4.equals("#IMPLIED"))
      {
        paramString1 = this.fSimpleType;
        paramString4 = this.fSimpleType;
        paramString1.defaultType = 0;
        break;
      }
      if (!paramString4.equals("#REQUIRED")) {
        break;
      }
      paramString1 = this.fSimpleType;
      paramString4 = this.fSimpleType;
      paramString1.defaultType = 2;
      break;
      label351:
      paramString1 = null;
      break label172;
      label356:
      paramString1 = null;
      break label195;
      label361:
      if (paramString3.equals("ID"))
      {
        this.fSimpleType.type = 3;
      }
      else if (paramString3.startsWith("IDREF"))
      {
        this.fSimpleType.type = 4;
        if (paramString3.indexOf("S") > 0) {
          this.fSimpleType.list = true;
        }
      }
      else if (paramString3.equals("ENTITIES"))
      {
        this.fSimpleType.type = 1;
        this.fSimpleType.list = true;
      }
      else if (paramString3.equals("ENTITY"))
      {
        this.fSimpleType.type = 1;
      }
      else if (paramString3.equals("NMTOKENS"))
      {
        this.fSimpleType.type = 5;
        this.fSimpleType.list = true;
      }
      else if (paramString3.equals("NMTOKEN"))
      {
        this.fSimpleType.type = 5;
      }
      else if (paramString3.startsWith("NOTATION"))
      {
        this.fSimpleType.type = 6;
      }
      else if (paramString3.startsWith("ENUMERATION"))
      {
        this.fSimpleType.type = 2;
      }
      else
      {
        System.err.println("!!! unknown attribute type " + paramString3);
      }
    }
  }
  
  protected int createAttributeDecl()
  {
    int i = this.fAttributeDeclCount >> 8;
    int j = this.fAttributeDeclCount & 0xFF;
    ensureAttributeDeclCapacity(i);
    this.fAttributeDeclName[i][j] = new QName();
    this.fAttributeDeclType[i][j] = -1;
    this.fAttributeDeclEnumeration[i][j] = null;
    this.fAttributeDeclDefaultType[i][j] = 0;
    this.fAttributeDeclDefaultValue[i][j] = null;
    this.fAttributeDeclNonNormalizedDefaultValue[i][j] = null;
    this.fAttributeDeclNextAttributeDeclIndex[i][j] = -1;
    i = this.fAttributeDeclCount;
    this.fAttributeDeclCount = (i + 1);
    return i;
  }
  
  protected int createElementDecl()
  {
    int i = this.fElementDeclCount >> 8;
    int j = this.fElementDeclCount & 0xFF;
    ensureElementDeclCapacity(i);
    this.fElementDeclName[i][j] = new QName();
    this.fElementDeclType[i][j] = -1;
    this.fElementDeclFirstAttributeDeclIndex[i][j] = -1;
    this.fElementDeclLastAttributeDeclIndex[i][j] = -1;
    i = this.fElementDeclCount;
    this.fElementDeclCount = (i + 1);
    return i;
  }
  
  public void elementDecl(String paramString1, String paramString2, Augmentations paramAugmentations)
  {
    paramAugmentations = (XMLElementDecl)this.fElementDeclTab.get(paramString1);
    if (paramAugmentations != null) {
      if (paramAugmentations.type == -1)
      {
        this.fCurrentElementIndex = getElementDeclIndex(paramString1);
        paramAugmentations = new XMLElementDecl();
        QName localQName = new QName(null, paramString1, paramString1, null);
        paramAugmentations.name.setValues(localQName);
        paramAugmentations.scope = -1;
        if (!paramString2.equals("EMPTY")) {
          break label143;
        }
        paramAugmentations.type = 1;
      }
    }
    for (;;)
    {
      this.fElementDeclTab.put(paramString1, paramAugmentations);
      this.fElementDecl = paramAugmentations;
      setElementDecl(this.fCurrentElementIndex, this.fElementDecl);
      int i = this.fCurrentElementIndex;
      int j = this.fCurrentElementIndex;
      ensureElementDeclCapacity(i >> 8);
      return;
      this.fCurrentElementIndex = createElementDecl();
      break;
      label143:
      if (paramString2.equals("ANY")) {
        paramAugmentations.type = 0;
      } else if (paramString2.startsWith("(")) {
        if (paramString2.indexOf("#PCDATA") > 0) {
          paramAugmentations.type = 2;
        } else {
          paramAugmentations.type = 3;
        }
      }
    }
  }
  
  public void endDTD(Augmentations paramAugmentations) {}
  
  public boolean getAttributeDecl(int paramInt, XMLAttributeDecl paramXMLAttributeDecl)
  {
    short s = -1;
    boolean bool = false;
    if ((paramInt < 0) || (paramInt >= this.fAttributeDeclCount)) {
      return false;
    }
    int i = paramInt >> 8;
    paramInt &= 0xFF;
    paramXMLAttributeDecl.name.setValues(this.fAttributeDeclName[i][paramInt]);
    if (this.fAttributeDeclType[i][paramInt] == -1) {
      bool = false;
    }
    for (;;)
    {
      paramXMLAttributeDecl.simpleType.setValues(s, this.fAttributeDeclName[i][paramInt].localpart, this.fAttributeDeclEnumeration[i][paramInt], bool, this.fAttributeDeclDefaultType[i][paramInt], this.fAttributeDeclDefaultValue[i][paramInt], this.fAttributeDeclNonNormalizedDefaultValue[i][paramInt]);
      return true;
      s = (short)(this.fAttributeDeclType[i][paramInt] & 0xFF7F);
      if ((this.fAttributeDeclType[i][paramInt] & 0x80) != 0) {
        bool = true;
      }
    }
  }
  
  public int getAttributeDeclIndex(int paramInt, String paramString)
  {
    if (paramInt == -1) {}
    for (;;)
    {
      return -1;
      for (paramInt = getFirstAttributeDeclIndex(paramInt); paramInt != -1; paramInt = getNextAttributeDeclIndex(paramInt))
      {
        getAttributeDecl(paramInt, this.fAttributeDecl);
        if ((this.fAttributeDecl.name.rawname == paramString) || (paramString.equals(this.fAttributeDecl.name.rawname))) {
          return paramInt;
        }
      }
    }
  }
  
  public short getContentSpecType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.fElementDeclCount)) {}
    int i;
    do
    {
      return -1;
      i = paramInt >> 8;
      paramInt &= 0xFF;
    } while (this.fElementDeclType[i][paramInt] == -1);
    return (short)(this.fElementDeclType[i][paramInt] & 0xFF7F);
  }
  
  public int getElementDeclIndex(QName paramQName)
  {
    return getElementDeclIndex(paramQName.rawname);
  }
  
  public int getElementDeclIndex(String paramString)
  {
    return this.fElementIndexMap.get(paramString);
  }
  
  public int getFirstAttributeDeclIndex(int paramInt)
  {
    return this.fElementDeclFirstAttributeDeclIndex[(paramInt >> 8)][(paramInt & 0xFF)];
  }
  
  public int getNextAttributeDeclIndex(int paramInt)
  {
    return this.fAttributeDeclNextAttributeDeclIndex[(paramInt >> 8)][(paramInt & 0xFF)];
  }
  
  public List getNotationDecls()
  {
    return this.notationDecls;
  }
  
  public void notationDecl(String paramString, XMLResourceIdentifier paramXMLResourceIdentifier, Augmentations paramAugmentations)
  {
    paramAugmentations = new XMLNotationDecl();
    paramAugmentations.setValues(paramString, paramXMLResourceIdentifier.getPublicId(), paramXMLResourceIdentifier.getLiteralSystemId(), paramXMLResourceIdentifier.getBaseSystemId());
    this.notationDecls.add(paramAugmentations);
  }
  
  protected void setAttributeDecl(int paramInt1, int paramInt2, XMLAttributeDecl paramXMLAttributeDecl)
  {
    int i = paramInt2 >> 8;
    int j = paramInt2 & 0xFF;
    this.fAttributeDeclName[i][j].setValues(paramXMLAttributeDecl.name);
    this.fAttributeDeclType[i][j] = paramXMLAttributeDecl.simpleType.type;
    if (paramXMLAttributeDecl.simpleType.list)
    {
      short[] arrayOfShort = this.fAttributeDeclType[i];
      arrayOfShort[j] = ((short)(arrayOfShort[j] | 0x80));
    }
    this.fAttributeDeclEnumeration[i][j] = paramXMLAttributeDecl.simpleType.enumeration;
    this.fAttributeDeclDefaultType[i][j] = paramXMLAttributeDecl.simpleType.defaultType;
    this.fAttributeDeclDefaultValue[i][j] = paramXMLAttributeDecl.simpleType.defaultValue;
    this.fAttributeDeclNonNormalizedDefaultValue[i][j] = paramXMLAttributeDecl.simpleType.nonNormalizedDefaultValue;
    i = paramInt1 >> 8;
    j = paramInt1 & 0xFF;
    paramInt1 = this.fElementDeclFirstAttributeDeclIndex[i][j];
    if ((paramInt1 == -1) || (paramInt1 == paramInt2)) {
      if (paramInt1 == -1)
      {
        if (this.fElementDeclFirstAttributeDeclIndex[i][j] != -1) {
          break label244;
        }
        this.fElementDeclFirstAttributeDeclIndex[i][j] = paramInt2;
      }
    }
    for (;;)
    {
      this.fElementDeclLastAttributeDeclIndex[i][j] = paramInt2;
      return;
      paramInt1 = this.fAttributeDeclNextAttributeDeclIndex[(paramInt1 >> 8)][(paramInt1 & 0xFF)];
      break;
      label244:
      paramInt1 = this.fElementDeclLastAttributeDeclIndex[i][j];
      this.fAttributeDeclNextAttributeDeclIndex[(paramInt1 >> 8)][(paramInt1 & 0xFF)] = paramInt2;
    }
  }
  
  protected void setElementDecl(int paramInt, XMLElementDecl paramXMLElementDecl)
  {
    if ((paramInt < 0) || (paramInt >= this.fElementDeclCount)) {
      return;
    }
    int i = paramInt >> 8;
    int j = paramInt & 0xFF;
    int k = paramXMLElementDecl.scope;
    this.fElementDeclName[i][j].setValues(paramXMLElementDecl.name);
    this.fElementDeclType[i][j] = paramXMLElementDecl.type;
    if (paramXMLElementDecl.simpleType.list == true)
    {
      short[] arrayOfShort = this.fElementDeclType[i];
      arrayOfShort[j] = ((short)(arrayOfShort[j] | 0x80));
    }
    this.fElementIndexMap.put(paramXMLElementDecl.name.rawname, paramInt);
  }
  
  public void startDTD(XMLLocator paramXMLLocator, Augmentations paramAugmentations)
  {
    this.fOpStack = null;
    this.fNodeIndexStack = null;
    this.fPrevNodeIndexStack = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/dtd/nonvalidating/DTDGrammar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
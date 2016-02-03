package com.amazonaws.javax.xml.stream.dtd;

import com.amazonaws.javax.xml.stream.dtd.nonvalidating.DTDGrammar;
import com.amazonaws.javax.xml.stream.dtd.nonvalidating.XMLAttributeDecl;
import com.amazonaws.javax.xml.stream.dtd.nonvalidating.XMLSimpleType;
import com.amazonaws.javax.xml.stream.xerces.util.NamespaceSupport;
import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLSymbols;
import com.amazonaws.javax.xml.stream.xerces.xni.NamespaceContext;
import com.amazonaws.javax.xml.stream.xerces.xni.QName;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLAttributes;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;

public class DTDGrammarUtil
{
  private StringBuffer fBuffer = new StringBuffer();
  private int fCurrentContentSpecType = -1;
  private int fCurrentElementIndex = -1;
  protected DTDGrammar fDTDGrammar = null;
  private boolean[] fElementContentState = new boolean[8];
  private int fElementDepth = -1;
  private boolean fInCDATASection = false;
  private boolean fInElementContent = false;
  private NamespaceContext fNamespaceContext = null;
  protected boolean fNamespaces;
  protected SymbolTable fSymbolTable = null;
  private XMLAttributeDecl fTempAttDecl = new XMLAttributeDecl();
  private QName fTempQName = new QName();
  
  public DTDGrammarUtil(DTDGrammar paramDTDGrammar, SymbolTable paramSymbolTable, NamespaceContext paramNamespaceContext)
  {
    this.fDTDGrammar = paramDTDGrammar;
    this.fSymbolTable = paramSymbolTable;
    this.fNamespaceContext = paramNamespaceContext;
  }
  
  private void ensureStackCapacity(int paramInt)
  {
    if (paramInt == this.fElementContentState.length)
    {
      boolean[] arrayOfBoolean = new boolean[paramInt * 2];
      System.arraycopy(this.fElementContentState, 0, arrayOfBoolean, 0, paramInt);
      this.fElementContentState = arrayOfBoolean;
    }
  }
  
  private String getAttributeTypeName(XMLAttributeDecl paramXMLAttributeDecl)
  {
    switch (paramXMLAttributeDecl.simpleType.type)
    {
    default: 
      return XMLSymbols.fCDATASymbol;
    case 1: 
      if (paramXMLAttributeDecl.simpleType.list) {
        return XMLSymbols.fENTITIESSymbol;
      }
      return XMLSymbols.fENTITYSymbol;
    case 2: 
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append('(');
      int i = 0;
      while (i < paramXMLAttributeDecl.simpleType.enumeration.length)
      {
        if (i > 0) {
          localStringBuffer.append("|");
        }
        localStringBuffer.append(paramXMLAttributeDecl.simpleType.enumeration[i]);
        i += 1;
      }
      localStringBuffer.append(')');
      return this.fSymbolTable.addSymbol(localStringBuffer.toString());
    case 3: 
      return XMLSymbols.fIDSymbol;
    case 4: 
      if (paramXMLAttributeDecl.simpleType.list) {
        return XMLSymbols.fIDREFSSymbol;
      }
      return XMLSymbols.fIDREFSymbol;
    case 5: 
      if (paramXMLAttributeDecl.simpleType.list) {
        return XMLSymbols.fNMTOKENSSymbol;
      }
      return XMLSymbols.fNMTOKENSymbol;
    }
    return XMLSymbols.fNOTATIONSymbol;
  }
  
  private boolean normalizeAttrValue(XMLAttributes paramXMLAttributes, int paramInt)
  {
    String str = paramXMLAttributes.getValue(paramInt);
    Object localObject = new char[str.length()];
    this.fBuffer.setLength(0);
    str.getChars(0, str.length(), (char[])localObject, 0);
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int m = 0;
    int i = 0;
    int i1 = 1;
    if (i2 < localObject.length)
    {
      int j;
      int n;
      int k;
      int i6;
      int i5;
      if (localObject[i2] == ' ')
      {
        j = m;
        n = i;
        if (m != 0)
        {
          j = 0;
          n = 1;
        }
        if ((n != 0) && (i1 == 0))
        {
          this.fBuffer.append(localObject[i2]);
          k = i4 + 1;
          i = 0;
          i6 = i1;
          m = j;
          i5 = i3;
        }
      }
      for (;;)
      {
        i2 += 1;
        i3 = i5;
        i4 = k;
        i1 = i6;
        break;
        if (i1 == 0)
        {
          i5 = i3;
          k = i4;
          m = j;
          i = n;
          i6 = i1;
          if (n != 0) {}
        }
        else
        {
          i5 = i3 + 1;
          k = i4;
          m = j;
          i = n;
          i6 = i1;
          continue;
          this.fBuffer.append(localObject[i2]);
          k = i4 + 1;
          m = 1;
          i = 0;
          i6 = 0;
          i5 = i3;
        }
      }
    }
    if ((i4 > 0) && (this.fBuffer.charAt(i4 - 1) == ' ')) {
      this.fBuffer.setLength(i4 - 1);
    }
    localObject = this.fBuffer.toString();
    paramXMLAttributes.setValue(paramInt, (String)localObject);
    return !str.equals(localObject);
  }
  
  public void addDTDDefaultAttrs(QName paramQName, XMLAttributes paramXMLAttributes)
  {
    int n = this.fDTDGrammar.getElementDeclIndex(paramQName);
    if ((n == -1) || (this.fDTDGrammar == null)) {
      return;
    }
    int j = this.fDTDGrammar.getFirstAttributeDeclIndex(n);
    label35:
    String str2;
    String str4;
    String str3;
    String str5;
    int i;
    if (j != -1)
    {
      this.fDTDGrammar.getAttributeDecl(j, this.fTempAttDecl);
      str2 = this.fTempAttDecl.name.prefix;
      str4 = this.fTempAttDecl.name.localpart;
      str3 = this.fTempAttDecl.name.rawname;
      str5 = getAttributeTypeName(this.fTempAttDecl);
      i = this.fTempAttDecl.simpleType.defaultType;
      if (this.fTempAttDecl.simpleType.defaultValue == null) {
        break label602;
      }
    }
    label143:
    label154:
    label206:
    label372:
    label378:
    label385:
    label435:
    label463:
    label516:
    label530:
    label590:
    label597:
    label602:
    for (paramQName = this.fTempAttDecl.simpleType.defaultValue;; paramQName = null)
    {
      int k;
      String str1;
      if (i == 2)
      {
        i = 1;
        if (str5 != XMLSymbols.fCDATASymbol) {
          break label372;
        }
        k = 1;
        if ((k != 0) && (i == 0) && (paramQName == null)) {
          break label597;
        }
        if ((this.fNamespaceContext == null) || (!str3.startsWith("xmlns"))) {
          break label385;
        }
        i = str3.indexOf(':');
        if (i == -1) {
          break label378;
        }
        str1 = str3.substring(0, i);
        str1 = this.fSymbolTable.addSymbol(str1);
        if (!((NamespaceSupport)this.fNamespaceContext).containsPrefixInCurrentContext(str1)) {
          this.fNamespaceContext.declarePrefix(str1, paramQName);
        }
        i = 1;
      }
      for (;;)
      {
        if ((i == 0) && (paramQName != null))
        {
          if (!this.fNamespaces) {
            break label590;
          }
          i = str3.indexOf(':');
          if (i == -1) {
            break label590;
          }
          str1 = str3.substring(0, i);
          str2 = this.fSymbolTable.addSymbol(str1);
          str1 = str3.substring(i + 1);
        }
        for (str1 = this.fSymbolTable.addSymbol(str1);; str1 = str4)
        {
          this.fTempQName.setValues(str2, str1, str3, this.fTempAttDecl.name.uri);
          paramXMLAttributes.addAttribute(this.fTempQName, str5, paramQName);
          j = this.fDTDGrammar.getNextAttributeDeclIndex(j);
          break label35;
          i = 0;
          break label143;
          k = 0;
          break label154;
          str1 = str3;
          break label206;
          k = paramXMLAttributes.getLength();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label597;
            }
            if (paramXMLAttributes.getQName(i) == str3)
            {
              i = 1;
              break;
            }
            i += 1;
          }
          int i1 = paramXMLAttributes.getLength();
          i = 0;
          if (i < i1)
          {
            paramQName = paramXMLAttributes.getQName(i);
            int m = 0;
            j = this.fDTDGrammar.getFirstAttributeDeclIndex(n);
            k = m;
            if (j != -1)
            {
              this.fDTDGrammar.getAttributeDecl(j, this.fTempAttDecl);
              if (this.fTempAttDecl.name.rawname != paramQName) {
                break label516;
              }
              k = 1;
            }
            if (k != 0) {
              break label530;
            }
          }
          for (;;)
          {
            i += 1;
            break label435;
            break;
            j = this.fDTDGrammar.getNextAttributeDeclIndex(j);
            break label463;
            paramQName = getAttributeTypeName(this.fTempAttDecl);
            paramXMLAttributes.setType(i, paramQName);
            paramXMLAttributes.getValue(i);
            if ((paramXMLAttributes.isSpecified(i)) && (paramQName != XMLSymbols.fCDATASymbol))
            {
              normalizeAttrValue(paramXMLAttributes, i);
              paramXMLAttributes.getValue(i);
            }
          }
        }
        i = 0;
      }
    }
  }
  
  public void endElement(QName paramQName)
  {
    handleEndElement(paramQName);
  }
  
  protected void handleEndElement(QName paramQName)
  {
    this.fElementDepth -= 1;
    if (this.fElementDepth < -1) {
      throw new RuntimeException("FWK008 Element stack underflow");
    }
    if (this.fElementDepth < 0)
    {
      this.fCurrentElementIndex = -1;
      this.fCurrentContentSpecType = -1;
      this.fInElementContent = false;
      return;
    }
    this.fInElementContent = this.fElementContentState[this.fElementDepth];
  }
  
  protected void handleStartElement(QName paramQName, XMLAttributes paramXMLAttributes)
  {
    boolean bool = false;
    if (this.fDTDGrammar == null)
    {
      this.fCurrentElementIndex = -1;
      this.fCurrentContentSpecType = -1;
      this.fInElementContent = false;
      return;
    }
    this.fCurrentElementIndex = this.fDTDGrammar.getElementDeclIndex(paramQName);
    this.fCurrentContentSpecType = this.fDTDGrammar.getContentSpecType(this.fCurrentElementIndex);
    addDTDDefaultAttrs(paramQName, paramXMLAttributes);
    if (this.fCurrentContentSpecType == 3) {
      bool = true;
    }
    this.fInElementContent = bool;
    this.fElementDepth += 1;
    ensureStackCapacity(this.fElementDepth);
    this.fElementContentState[this.fElementDepth] = this.fInElementContent;
  }
  
  public boolean isIgnorableWhiteSpace(XMLString paramXMLString)
  {
    if (isInElementContent())
    {
      int i = paramXMLString.offset;
      while (i < paramXMLString.offset + paramXMLString.length)
      {
        if (!XMLChar.isSpace(paramXMLString.ch[i])) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public boolean isInElementContent()
  {
    return this.fInElementContent;
  }
  
  public void startElement(QName paramQName, XMLAttributes paramXMLAttributes)
  {
    handleStartElement(paramQName, paramXMLAttributes);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/dtd/DTDGrammarUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
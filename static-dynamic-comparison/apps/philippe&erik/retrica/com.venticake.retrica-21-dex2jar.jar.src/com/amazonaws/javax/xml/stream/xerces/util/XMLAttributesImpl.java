package com.amazonaws.javax.xml.stream.xerces.util;

import com.amazonaws.javax.xml.stream.XMLBufferListener;
import com.amazonaws.javax.xml.stream.xerces.xni.Augmentations;
import com.amazonaws.javax.xml.stream.xerces.xni.QName;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLAttributes;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;

public class XMLAttributesImpl
  implements XMLBufferListener, XMLAttributes
{
  protected XMLAttributesImpl.Attribute[] fAttributeTableView;
  protected int[] fAttributeTableViewChainState;
  protected XMLAttributesImpl.Attribute[] fAttributes = new XMLAttributesImpl.Attribute[4];
  protected boolean fIsTableViewConsistent;
  protected int fLargeCount = 1;
  protected int fLength;
  protected boolean fNamespaces = true;
  protected int fTableViewBuckets;
  
  public XMLAttributesImpl()
  {
    this(101);
  }
  
  public XMLAttributesImpl(int paramInt)
  {
    this.fTableViewBuckets = paramInt;
    paramInt = 0;
    while (paramInt < this.fAttributes.length)
    {
      this.fAttributes[paramInt] = new XMLAttributesImpl.Attribute();
      paramInt += 1;
    }
  }
  
  public int addAttribute(QName paramQName, String paramString1, String paramString2)
  {
    return addAttribute(paramQName, paramString1, paramString2, null);
  }
  
  public int addAttribute(QName paramQName, String paramString1, String paramString2, XMLString paramXMLString)
  {
    int j;
    int i;
    Object localObject;
    if (this.fLength < 20)
    {
      if ((paramQName.uri != null) && (!paramQName.uri.equals(""))) {}
      for (j = getIndexFast(paramQName.uri, paramQName.localpart);; j = getIndexFast(paramQName.rawname))
      {
        i = j;
        if (j != -1) {
          break label165;
        }
        i = this.fLength;
        j = this.fLength;
        this.fLength = (j + 1);
        if (j != this.fAttributes.length) {
          break label663;
        }
        localObject = new XMLAttributesImpl.Attribute[this.fAttributes.length + 4];
        System.arraycopy(this.fAttributes, 0, localObject, 0, this.fAttributes.length);
        j = this.fAttributes.length;
        while (j < localObject.length)
        {
          localObject[j] = new XMLAttributesImpl.Attribute();
          j += 1;
        }
      }
      this.fAttributes = ((XMLAttributesImpl.Attribute[])localObject);
    }
    label165:
    label612:
    label650:
    label663:
    for (;;)
    {
      localObject = this.fAttributes[i];
      ((XMLAttributesImpl.Attribute)localObject).name.setValues(paramQName);
      ((XMLAttributesImpl.Attribute)localObject).type = paramString1;
      ((XMLAttributesImpl.Attribute)localObject).value = paramString2;
      ((XMLAttributesImpl.Attribute)localObject).xmlValue = paramXMLString;
      ((XMLAttributesImpl.Attribute)localObject).nonNormalizedValue = paramString2;
      ((XMLAttributesImpl.Attribute)localObject).specified = false;
      if (((XMLAttributesImpl.Attribute)localObject).augs != null) {
        ((XMLAttributesImpl.Attribute)localObject).augs.removeAllItems();
      }
      return i;
      if ((paramQName.uri != null) && (paramQName.uri.length() != 0))
      {
        j = getIndexFast(paramQName.uri, paramQName.localpart);
        i = j;
        if (j != -1) {}
      }
      else
      {
        if ((!this.fIsTableViewConsistent) || (this.fLength == 20))
        {
          prepareAndPopulateTableView();
          this.fIsTableViewConsistent = true;
        }
        int k = getTableViewBucket(paramQName.rawname);
        if (this.fAttributeTableViewChainState[k] != this.fLargeCount)
        {
          j = this.fLength;
          i = this.fLength;
          this.fLength = (i + 1);
          if (i == this.fAttributes.length)
          {
            localObject = new XMLAttributesImpl.Attribute[this.fAttributes.length << 1];
            System.arraycopy(this.fAttributes, 0, localObject, 0, this.fAttributes.length);
            i = this.fAttributes.length;
            while (i < localObject.length)
            {
              localObject[i] = new XMLAttributesImpl.Attribute();
              i += 1;
            }
            this.fAttributes = ((XMLAttributesImpl.Attribute[])localObject);
          }
          this.fAttributeTableViewChainState[k] = this.fLargeCount;
          this.fAttributes[j].next = null;
          this.fAttributeTableView[k] = this.fAttributes[j];
          i = j;
        }
        else
        {
          for (localObject = this.fAttributeTableView[k];; localObject = ((XMLAttributesImpl.Attribute)localObject).next) {
            if ((localObject == null) || (((XMLAttributesImpl.Attribute)localObject).name.rawname == paramQName.rawname))
            {
              if (localObject != null) {
                break label650;
              }
              j = this.fLength;
              i = this.fLength;
              this.fLength = (i + 1);
              if (i != this.fAttributes.length) {
                break label612;
              }
              localObject = new XMLAttributesImpl.Attribute[this.fAttributes.length << 1];
              System.arraycopy(this.fAttributes, 0, localObject, 0, this.fAttributes.length);
              i = this.fAttributes.length;
              while (i < localObject.length)
              {
                localObject[i] = new XMLAttributesImpl.Attribute();
                i += 1;
              }
            }
          }
          this.fAttributes = ((XMLAttributesImpl.Attribute[])localObject);
          this.fAttributes[j].next = this.fAttributeTableView[k];
          this.fAttributeTableView[k] = this.fAttributes[j];
          i = j;
          continue;
          i = getIndexFast(paramQName.rawname);
        }
      }
    }
  }
  
  public void addAttributeNS(QName paramQName, String paramString1, String paramString2)
  {
    int j = this.fLength;
    int i = this.fLength;
    this.fLength = (i + 1);
    if (i == this.fAttributes.length)
    {
      if (this.fLength < 20) {}
      for (localObject = new XMLAttributesImpl.Attribute[this.fAttributes.length + 4];; localObject = new XMLAttributesImpl.Attribute[this.fAttributes.length << 1])
      {
        System.arraycopy(this.fAttributes, 0, localObject, 0, this.fAttributes.length);
        i = this.fAttributes.length;
        while (i < localObject.length)
        {
          localObject[i] = new XMLAttributesImpl.Attribute();
          i += 1;
        }
      }
      this.fAttributes = ((XMLAttributesImpl.Attribute[])localObject);
    }
    Object localObject = this.fAttributes[j];
    ((XMLAttributesImpl.Attribute)localObject).name.setValues(paramQName);
    ((XMLAttributesImpl.Attribute)localObject).type = paramString1;
    ((XMLAttributesImpl.Attribute)localObject).value = paramString2;
    ((XMLAttributesImpl.Attribute)localObject).nonNormalizedValue = paramString2;
    ((XMLAttributesImpl.Attribute)localObject).specified = false;
    if (((XMLAttributesImpl.Attribute)localObject).augs != null) {
      ((XMLAttributesImpl.Attribute)localObject).augs.removeAllItems();
    }
  }
  
  public QName checkDuplicatesNS()
  {
    int i = 0;
    XMLAttributesImpl.Attribute localAttribute1;
    int j;
    XMLAttributesImpl.Attribute localAttribute2;
    if (this.fLength <= 20) {
      while (i < this.fLength - 1)
      {
        localAttribute1 = this.fAttributes[i];
        j = i + 1;
        while (j < this.fLength)
        {
          localAttribute2 = this.fAttributes[j];
          if ((localAttribute1.name.localpart == localAttribute2.name.localpart) && (localAttribute1.name.uri == localAttribute2.name.uri)) {
            return localAttribute2.name;
          }
          j += 1;
        }
        i += 1;
      }
    }
    this.fIsTableViewConsistent = false;
    prepareTableView();
    i = this.fLength - 1;
    if (i >= 0)
    {
      localAttribute2 = this.fAttributes[i];
      j = getTableViewBucket(localAttribute2.name.localpart, localAttribute2.name.uri);
      if (this.fAttributeTableViewChainState[j] != this.fLargeCount)
      {
        this.fAttributeTableViewChainState[j] = this.fLargeCount;
        localAttribute2.next = null;
        this.fAttributeTableView[j] = localAttribute2;
      }
      for (;;)
      {
        i -= 1;
        break;
        for (localAttribute1 = this.fAttributeTableView[j]; localAttribute1 != null; localAttribute1 = localAttribute1.next) {
          if ((localAttribute1.name.localpart == localAttribute2.name.localpart) && (localAttribute1.name.uri == localAttribute2.name.uri)) {
            return localAttribute2.name;
          }
        }
        localAttribute2.next = this.fAttributeTableView[j];
        this.fAttributeTableView[j] = localAttribute2;
      }
    }
    return null;
  }
  
  protected void cleanTableView()
  {
    int i = this.fLargeCount + 1;
    this.fLargeCount = i;
    if (i < 0)
    {
      if (this.fAttributeTableViewChainState != null)
      {
        i = this.fTableViewBuckets - 1;
        while (i >= 0)
        {
          this.fAttributeTableViewChainState[i] = 0;
          i -= 1;
        }
      }
      this.fLargeCount = 1;
    }
  }
  
  public int getIndexFast(String paramString)
  {
    int i = 0;
    while (i < this.fLength)
    {
      if (this.fAttributes[i].name.rawname == paramString) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int getIndexFast(String paramString1, String paramString2)
  {
    int i = 0;
    while (i < this.fLength)
    {
      XMLAttributesImpl.Attribute localAttribute = this.fAttributes[i];
      if ((localAttribute.name.localpart == paramString2) && (localAttribute.name.uri == paramString1)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int getLength()
  {
    return this.fLength;
  }
  
  public void getName(int paramInt, QName paramQName)
  {
    paramQName.setValues(this.fAttributes[paramInt].name);
  }
  
  public String getQName(int paramInt)
  {
    Object localObject;
    if ((paramInt < 0) || (paramInt >= this.fLength)) {
      localObject = null;
    }
    String str;
    do
    {
      return (String)localObject;
      str = this.fAttributes[paramInt].name.rawname;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public QName getQualifiedName(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.fLength)) {
      return null;
    }
    return this.fAttributes[paramInt].name;
  }
  
  protected String getReportableType(String paramString)
  {
    String str = paramString;
    if (paramString.indexOf('(') == 0)
    {
      str = paramString;
      if (paramString.lastIndexOf(')') == paramString.length() - 1) {
        str = "NMTOKEN";
      }
    }
    return str;
  }
  
  protected int getTableViewBucket(String paramString)
  {
    return (paramString.hashCode() & 0x7FFFFFFF) % this.fTableViewBuckets;
  }
  
  protected int getTableViewBucket(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return (paramString1.hashCode() & 0x7FFFFFFF) % this.fTableViewBuckets;
    }
    return (paramString1.hashCode() + paramString2.hashCode() & 0x7FFFFFFF) % this.fTableViewBuckets;
  }
  
  public String getType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.fLength)) {
      return null;
    }
    return getReportableType(this.fAttributes[paramInt].type);
  }
  
  public String getValue(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.fLength)) {
      return null;
    }
    if ((this.fAttributes[paramInt].value == null) && (this.fAttributes[paramInt].xmlValue != null)) {
      this.fAttributes[paramInt].value = this.fAttributes[paramInt].xmlValue.toString();
    }
    return this.fAttributes[paramInt].value;
  }
  
  public boolean isSpecified(int paramInt)
  {
    return this.fAttributes[paramInt].specified;
  }
  
  protected void prepareAndPopulateTableView()
  {
    prepareTableView();
    int i = 0;
    if (i < this.fLength)
    {
      XMLAttributesImpl.Attribute localAttribute = this.fAttributes[i];
      int j = getTableViewBucket(localAttribute.name.rawname);
      if (this.fAttributeTableViewChainState[j] != this.fLargeCount)
      {
        this.fAttributeTableViewChainState[j] = this.fLargeCount;
        localAttribute.next = null;
        this.fAttributeTableView[j] = localAttribute;
      }
      for (;;)
      {
        i += 1;
        break;
        localAttribute.next = this.fAttributeTableView[j];
        this.fAttributeTableView[j] = localAttribute;
      }
    }
  }
  
  protected void prepareTableView()
  {
    if (this.fAttributeTableView == null)
    {
      this.fAttributeTableView = new XMLAttributesImpl.Attribute[this.fTableViewBuckets];
      this.fAttributeTableViewChainState = new int[this.fTableViewBuckets];
      return;
    }
    cleanTableView();
  }
  
  public void refresh()
  {
    if (this.fLength > 0)
    {
      int i = 0;
      while (i < this.fLength)
      {
        getValue(i);
        i += 1;
      }
    }
  }
  
  public void refresh(int paramInt) {}
  
  public void removeAllAttributes()
  {
    this.fLength = 0;
  }
  
  public void removeAttributeAt(int paramInt)
  {
    this.fIsTableViewConsistent = false;
    if (paramInt < this.fLength - 1)
    {
      XMLAttributesImpl.Attribute localAttribute = this.fAttributes[paramInt];
      System.arraycopy(this.fAttributes, paramInt + 1, this.fAttributes, paramInt, this.fLength - paramInt - 1);
      this.fAttributes[(this.fLength - 1)] = localAttribute;
    }
    this.fLength -= 1;
  }
  
  public void setSpecified(int paramInt, boolean paramBoolean)
  {
    this.fAttributes[paramInt].specified = paramBoolean;
  }
  
  public void setType(int paramInt, String paramString)
  {
    this.fAttributes[paramInt].type = paramString;
  }
  
  public void setURI(int paramInt, String paramString)
  {
    this.fAttributes[paramInt].name.uri = paramString;
  }
  
  public void setValue(int paramInt, String paramString)
  {
    setValue(paramInt, paramString, null);
  }
  
  public void setValue(int paramInt, String paramString, XMLString paramXMLString)
  {
    XMLAttributesImpl.Attribute localAttribute = this.fAttributes[paramInt];
    localAttribute.value = paramString;
    localAttribute.nonNormalizedValue = paramString;
    localAttribute.xmlValue = paramXMLString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/util/XMLAttributesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
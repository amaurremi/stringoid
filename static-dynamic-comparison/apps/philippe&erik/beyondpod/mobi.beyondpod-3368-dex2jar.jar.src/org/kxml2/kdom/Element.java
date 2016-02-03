package org.kxml2.kdom;

import java.io.IOException;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class Element
  extends Node
{
  protected Vector attributes;
  protected String name;
  protected String namespace;
  protected Node parent;
  protected Vector prefixes;
  
  public void clear()
  {
    this.attributes = null;
    this.children = null;
  }
  
  public Element createElement(String paramString1, String paramString2)
  {
    if (this.parent == null) {
      return super.createElement(paramString1, paramString2);
    }
    return this.parent.createElement(paramString1, paramString2);
  }
  
  public int getAttributeCount()
  {
    if (this.attributes == null) {
      return 0;
    }
    return this.attributes.size();
  }
  
  public String getAttributeName(int paramInt)
  {
    return ((String[])(String[])this.attributes.elementAt(paramInt))[1];
  }
  
  public String getAttributeNamespace(int paramInt)
  {
    return ((String[])(String[])this.attributes.elementAt(paramInt))[0];
  }
  
  public String getAttributeValue(int paramInt)
  {
    return ((String[])(String[])this.attributes.elementAt(paramInt))[2];
  }
  
  public String getAttributeValue(String paramString1, String paramString2)
  {
    int i = 0;
    while (i < getAttributeCount())
    {
      if ((paramString2.equals(getAttributeName(i))) && ((paramString1 == null) || (paramString1.equals(getAttributeNamespace(i))))) {
        return getAttributeValue(i);
      }
      i += 1;
    }
    return null;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNamespace()
  {
    return this.namespace;
  }
  
  public int getNamespaceCount()
  {
    if (this.prefixes == null) {
      return 0;
    }
    return this.prefixes.size();
  }
  
  public String getNamespacePrefix(int paramInt)
  {
    return ((String[])(String[])this.prefixes.elementAt(paramInt))[0];
  }
  
  public String getNamespaceUri(int paramInt)
  {
    return ((String[])(String[])this.prefixes.elementAt(paramInt))[1];
  }
  
  public String getNamespaceUri(String paramString)
  {
    int j = getNamespaceCount();
    int i = 0;
    while (i < j)
    {
      if ((paramString == getNamespacePrefix(i)) || ((paramString != null) && (paramString.equals(getNamespacePrefix(i))))) {
        return getNamespaceUri(i);
      }
      i += 1;
    }
    if ((this.parent instanceof Element)) {
      return ((Element)this.parent).getNamespaceUri(paramString);
    }
    return null;
  }
  
  public Node getParent()
  {
    return this.parent;
  }
  
  public Node getRoot()
  {
    for (Element localElement = this;; localElement = (Element)localElement.parent)
    {
      Object localObject = localElement;
      if (localElement.parent != null)
      {
        if (!(localElement.parent instanceof Element)) {
          localObject = localElement.parent;
        }
      }
      else {
        return (Node)localObject;
      }
    }
  }
  
  public void init() {}
  
  public void parse(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    int i = paramXmlPullParser.getNamespaceCount(paramXmlPullParser.getDepth() - 1);
    while (i < paramXmlPullParser.getNamespaceCount(paramXmlPullParser.getDepth()))
    {
      setPrefix(paramXmlPullParser.getNamespacePrefix(i), paramXmlPullParser.getNamespaceUri(i));
      i += 1;
    }
    i = 0;
    while (i < paramXmlPullParser.getAttributeCount())
    {
      setAttribute(paramXmlPullParser.getAttributeNamespace(i), paramXmlPullParser.getAttributeName(i), paramXmlPullParser.getAttributeValue(i));
      i += 1;
    }
    init();
    if (paramXmlPullParser.isEmptyElementTag()) {
      paramXmlPullParser.nextToken();
    }
    for (;;)
    {
      paramXmlPullParser.require(3, getNamespace(), getName());
      paramXmlPullParser.nextToken();
      return;
      paramXmlPullParser.nextToken();
      super.parse(paramXmlPullParser);
      if (getChildCount() == 0) {
        addChild(7, "");
      }
    }
  }
  
  public void setAttribute(String paramString1, String paramString2, String paramString3)
  {
    if (this.attributes == null) {
      this.attributes = new Vector();
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    int i = this.attributes.size() - 1;
    while (i >= 0)
    {
      paramString1 = (String[])this.attributes.elementAt(i);
      if ((paramString1[0].equals(str)) && (paramString1[1].equals(paramString2)))
      {
        if (paramString3 == null)
        {
          this.attributes.removeElementAt(i);
          return;
        }
        paramString1[2] = paramString3;
        return;
      }
      i -= 1;
    }
    this.attributes.addElement(new String[] { str, paramString2, paramString3 });
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setNamespace(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("Use \"\" for empty namespace");
    }
    this.namespace = paramString;
  }
  
  protected void setParent(Node paramNode)
  {
    this.parent = paramNode;
  }
  
  public void setPrefix(String paramString1, String paramString2)
  {
    if (this.prefixes == null) {
      this.prefixes = new Vector();
    }
    this.prefixes.addElement(new String[] { paramString1, paramString2 });
  }
  
  public void write(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    int j = 0;
    if (this.prefixes != null)
    {
      i = 0;
      while (i < this.prefixes.size())
      {
        paramXmlSerializer.setPrefix(getNamespacePrefix(i), getNamespaceUri(i));
        i += 1;
      }
    }
    paramXmlSerializer.startTag(getNamespace(), getName());
    int k = getAttributeCount();
    int i = j;
    while (i < k)
    {
      paramXmlSerializer.attribute(getAttributeNamespace(i), getAttributeName(i), getAttributeValue(i));
      i += 1;
    }
    writeChildren(paramXmlSerializer);
    paramXmlSerializer.endTag(getNamespace(), getName());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/org/kxml2/kdom/Element.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
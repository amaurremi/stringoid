package org.kxml2.kdom;

import java.io.IOException;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class Node
{
  public static final int CDSECT = 5;
  public static final int COMMENT = 9;
  public static final int DOCDECL = 10;
  public static final int DOCUMENT = 0;
  public static final int ELEMENT = 2;
  public static final int ENTITY_REF = 6;
  public static final int IGNORABLE_WHITESPACE = 7;
  public static final int PROCESSING_INSTRUCTION = 8;
  public static final int TEXT = 4;
  protected Vector children;
  protected StringBuffer types;
  
  public void addChild(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    if (this.children == null)
    {
      this.children = new Vector();
      this.types = new StringBuffer();
    }
    if (paramInt2 == 2)
    {
      if (!(paramObject instanceof Element)) {
        throw new RuntimeException("Element obj expected)");
      }
      ((Element)paramObject).setParent(this);
    }
    while ((paramObject instanceof String))
    {
      this.children.insertElementAt(paramObject, paramInt1);
      this.types.insert(paramInt1, (char)paramInt2);
      return;
    }
    throw new RuntimeException("String expected");
  }
  
  public void addChild(int paramInt, Object paramObject)
  {
    addChild(getChildCount(), paramInt, paramObject);
  }
  
  public Element createElement(String paramString1, String paramString2)
  {
    Element localElement = new Element();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localElement.namespace = str;
    localElement.name = paramString2;
    return localElement;
  }
  
  public Object getChild(int paramInt)
  {
    return this.children.elementAt(paramInt);
  }
  
  public int getChildCount()
  {
    if (this.children == null) {
      return 0;
    }
    return this.children.size();
  }
  
  public Element getElement(int paramInt)
  {
    Object localObject = getChild(paramInt);
    if ((localObject instanceof Element)) {
      return (Element)localObject;
    }
    return null;
  }
  
  public Element getElement(String paramString1, String paramString2)
  {
    int i = indexOf(paramString1, paramString2, 0);
    int j = indexOf(paramString1, paramString2, i + 1);
    if ((i == -1) || (j != -1))
    {
      paramString2 = new StringBuffer().append("Element {").append(paramString1).append("}").append(paramString2);
      if (i == -1) {}
      for (paramString1 = " not found in ";; paramString1 = " more than once in ") {
        throw new RuntimeException(paramString1 + this);
      }
    }
    return getElement(i);
  }
  
  public String getText(int paramInt)
  {
    if (isText(paramInt)) {
      return (String)getChild(paramInt);
    }
    return null;
  }
  
  public int getType(int paramInt)
  {
    return this.types.charAt(paramInt);
  }
  
  public int indexOf(String paramString1, String paramString2, int paramInt)
  {
    int i = getChildCount();
    while (paramInt < i)
    {
      Element localElement = getElement(paramInt);
      if ((localElement != null) && (paramString2.equals(localElement.getName())) && ((paramString1 == null) || (paramString1.equals(localElement.getNamespace())))) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  public boolean isText(int paramInt)
  {
    paramInt = getType(paramInt);
    return (paramInt == 4) || (paramInt == 7) || (paramInt == 5);
  }
  
  public void parse(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    int i = 0;
    int k = paramXmlPullParser.getEventType();
    int j;
    switch (k)
    {
    default: 
      if (paramXmlPullParser.getText() != null)
      {
        j = k;
        if (k == 6) {
          j = 4;
        }
        addChild(j, paramXmlPullParser.getText());
      }
      break;
    }
    for (;;)
    {
      paramXmlPullParser.nextToken();
      j = i;
      for (;;)
      {
        i = j;
        if (j == 0) {
          break;
        }
        return;
        Element localElement = createElement(paramXmlPullParser.getNamespace(), paramXmlPullParser.getName());
        addChild(2, localElement);
        localElement.parse(paramXmlPullParser);
        j = i;
        continue;
        j = 1;
      }
      if ((k == 6) && (paramXmlPullParser.getName() != null)) {
        addChild(6, paramXmlPullParser.getName());
      }
    }
  }
  
  public void removeChild(int paramInt)
  {
    this.children.removeElementAt(paramInt);
    int i = this.types.length() - 1;
    while (paramInt < i)
    {
      this.types.setCharAt(paramInt, this.types.charAt(paramInt + 1));
      paramInt += 1;
    }
    this.types.setLength(i);
  }
  
  public void write(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    writeChildren(paramXmlSerializer);
    paramXmlSerializer.flush();
  }
  
  public void writeChildren(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    if (this.children == null) {}
    int j;
    int i;
    do
    {
      return;
      j = this.children.size();
      i = 0;
    } while (i >= j);
    int k = getType(i);
    Object localObject = this.children.elementAt(i);
    switch (k)
    {
    case 3: 
    default: 
      throw new RuntimeException("Illegal type: " + k);
    case 2: 
      ((Element)localObject).write(paramXmlSerializer);
    }
    for (;;)
    {
      i += 1;
      break;
      paramXmlSerializer.text((String)localObject);
      continue;
      paramXmlSerializer.ignorableWhitespace((String)localObject);
      continue;
      paramXmlSerializer.cdsect((String)localObject);
      continue;
      paramXmlSerializer.comment((String)localObject);
      continue;
      paramXmlSerializer.entityRef((String)localObject);
      continue;
      paramXmlSerializer.processingInstruction((String)localObject);
      continue;
      paramXmlSerializer.docdecl((String)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/org/kxml2/kdom/Node.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
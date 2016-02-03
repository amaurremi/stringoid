package org.jsoup.nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jsoup.helper.Validate;

public class Attributes
  implements Cloneable, Iterable
{
  protected static final String dataPrefix = "data-";
  private LinkedHashMap attributes = null;
  
  private static String dataKey(String paramString)
  {
    return "data-" + paramString;
  }
  
  public void addAll(Attributes paramAttributes)
  {
    if (paramAttributes.size() == 0) {
      return;
    }
    if (this.attributes == null) {
      this.attributes = new LinkedHashMap(paramAttributes.size());
    }
    this.attributes.putAll(paramAttributes.attributes);
  }
  
  public List asList()
  {
    if (this.attributes == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(this.attributes.size());
    Iterator localIterator = this.attributes.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  /* Error */
  public Attributes clone()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	org/jsoup/nodes/Attributes:attributes	Ljava/util/LinkedHashMap;
    //   4: ifnonnull +13 -> 17
    //   7: new 2	org/jsoup/nodes/Attributes
    //   10: dup
    //   11: invokespecial 111	org/jsoup/nodes/Attributes:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: invokespecial 113	java/lang/Object:clone	()Ljava/lang/Object;
    //   21: checkcast 2	org/jsoup/nodes/Attributes
    //   24: astore_2
    //   25: aload_2
    //   26: new 51	java/util/LinkedHashMap
    //   29: dup
    //   30: aload_0
    //   31: getfield 22	org/jsoup/nodes/Attributes:attributes	Ljava/util/LinkedHashMap;
    //   34: invokevirtual 68	java/util/LinkedHashMap:size	()I
    //   37: invokespecial 54	java/util/LinkedHashMap:<init>	(I)V
    //   40: putfield 22	org/jsoup/nodes/Attributes:attributes	Ljava/util/LinkedHashMap;
    //   43: aload_0
    //   44: invokevirtual 114	org/jsoup/nodes/Attributes:iterator	()Ljava/util/Iterator;
    //   47: astore_3
    //   48: aload_2
    //   49: astore_1
    //   50: aload_3
    //   51: invokeinterface 85 1 0
    //   56: ifeq -41 -> 15
    //   59: aload_3
    //   60: invokeinterface 89 1 0
    //   65: checkcast 116	org/jsoup/nodes/Attribute
    //   68: astore_1
    //   69: aload_2
    //   70: getfield 22	org/jsoup/nodes/Attributes:attributes	Ljava/util/LinkedHashMap;
    //   73: aload_1
    //   74: invokevirtual 119	org/jsoup/nodes/Attribute:getKey	()Ljava/lang/String;
    //   77: aload_1
    //   78: invokevirtual 122	org/jsoup/nodes/Attribute:clone	()Lorg/jsoup/nodes/Attribute;
    //   81: invokevirtual 126	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   84: pop
    //   85: goto -37 -> 48
    //   88: astore_1
    //   89: new 128	java/lang/RuntimeException
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 131	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	Attributes
    //   14	64	1	localObject	Object
    //   88	6	1	localCloneNotSupportedException	CloneNotSupportedException
    //   24	46	2	localAttributes	Attributes
    //   47	13	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   17	25	88	java/lang/CloneNotSupportedException
  }
  
  public Map dataset()
  {
    return new Attributes.Dataset(this, null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Attributes)) {
        return false;
      }
      paramObject = (Attributes)paramObject;
      if (this.attributes == null) {
        break;
      }
    } while (this.attributes.equals(((Attributes)paramObject).attributes));
    for (;;)
    {
      return false;
      if (((Attributes)paramObject).attributes == null) {
        break;
      }
    }
  }
  
  public String get(String paramString)
  {
    Validate.notEmpty(paramString);
    if (this.attributes == null) {
      return "";
    }
    paramString = (Attribute)this.attributes.get(paramString.toLowerCase());
    if (paramString != null) {
      return paramString.getValue();
    }
    return "";
  }
  
  public boolean hasKey(String paramString)
  {
    return (this.attributes != null) && (this.attributes.containsKey(paramString.toLowerCase()));
  }
  
  public int hashCode()
  {
    if (this.attributes != null) {
      return this.attributes.hashCode();
    }
    return 0;
  }
  
  public String html()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    html(localStringBuilder, new Document("").outputSettings());
    return localStringBuilder.toString();
  }
  
  void html(StringBuilder paramStringBuilder, Document.OutputSettings paramOutputSettings)
  {
    if (this.attributes == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.attributes.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Attribute localAttribute = (Attribute)((Map.Entry)localIterator.next()).getValue();
        paramStringBuilder.append(" ");
        localAttribute.html(paramStringBuilder, paramOutputSettings);
      }
    }
  }
  
  public Iterator iterator()
  {
    return asList().iterator();
  }
  
  public void put(String paramString1, String paramString2)
  {
    put(new Attribute(paramString1, paramString2));
  }
  
  public void put(Attribute paramAttribute)
  {
    Validate.notNull(paramAttribute);
    if (this.attributes == null) {
      this.attributes = new LinkedHashMap(2);
    }
    this.attributes.put(paramAttribute.getKey(), paramAttribute);
  }
  
  public void remove(String paramString)
  {
    Validate.notEmpty(paramString);
    if (this.attributes == null) {
      return;
    }
    this.attributes.remove(paramString.toLowerCase());
  }
  
  public int size()
  {
    if (this.attributes == null) {
      return 0;
    }
    return this.attributes.size();
  }
  
  public String toString()
  {
    return html();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/nodes/Attributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
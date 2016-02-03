package org.jsoup.nodes;

public class DataNode
  extends Node
{
  private static final String DATA_KEY = "data";
  
  public DataNode(String paramString1, String paramString2)
  {
    super(paramString2);
    this.attributes.put("data", paramString1);
  }
  
  public static DataNode createFromEncoded(String paramString1, String paramString2)
  {
    return new DataNode(Entities.unescape(paramString1), paramString2);
  }
  
  public String getWholeData()
  {
    return this.attributes.get("data");
  }
  
  public String nodeName()
  {
    return "#data";
  }
  
  void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    paramStringBuilder.append(getWholeData());
  }
  
  void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {}
  
  public DataNode setWholeData(String paramString)
  {
    this.attributes.put("data", paramString);
    return this;
  }
  
  public String toString()
  {
    return outerHtml();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/nodes/DataNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
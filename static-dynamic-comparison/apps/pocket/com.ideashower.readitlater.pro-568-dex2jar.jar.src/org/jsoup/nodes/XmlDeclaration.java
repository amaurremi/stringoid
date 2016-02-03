package org.jsoup.nodes;

public class XmlDeclaration
  extends Node
{
  private static final String DECL_KEY = "declaration";
  private final boolean isProcessingInstruction;
  
  public XmlDeclaration(String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramString2);
    this.attributes.put("declaration", paramString1);
    this.isProcessingInstruction = paramBoolean;
  }
  
  public String getWholeDeclaration()
  {
    return this.attributes.get("declaration");
  }
  
  public String nodeName()
  {
    return "#declaration";
  }
  
  void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    paramOutputSettings = paramStringBuilder.append("<");
    if (this.isProcessingInstruction) {}
    for (paramStringBuilder = "!";; paramStringBuilder = "?")
    {
      paramOutputSettings.append(paramStringBuilder).append(getWholeDeclaration()).append(">");
      return;
    }
  }
  
  void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {}
  
  public String toString()
  {
    return outerHtml();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/nodes/XmlDeclaration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
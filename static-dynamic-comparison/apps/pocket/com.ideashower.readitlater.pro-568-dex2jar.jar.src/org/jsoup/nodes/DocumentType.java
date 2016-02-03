package org.jsoup.nodes;

import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;

public class DocumentType
  extends Node
{
  public DocumentType(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramString4);
    Validate.notEmpty(paramString1);
    attr("name", paramString1);
    attr("publicId", paramString2);
    attr("systemId", paramString3);
  }
  
  public String nodeName()
  {
    return "#doctype";
  }
  
  void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    paramStringBuilder.append("<!DOCTYPE ").append(attr("name"));
    if (!StringUtil.isBlank(attr("publicId"))) {
      paramStringBuilder.append(" PUBLIC \"").append(attr("publicId")).append("\"");
    }
    if (!StringUtil.isBlank(attr("systemId"))) {
      paramStringBuilder.append(" \"").append(attr("systemId")).append("\"");
    }
    paramStringBuilder.append('>');
  }
  
  void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/nodes/DocumentType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
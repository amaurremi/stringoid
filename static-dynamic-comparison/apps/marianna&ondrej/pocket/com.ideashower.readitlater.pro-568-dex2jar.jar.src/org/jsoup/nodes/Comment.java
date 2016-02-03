package org.jsoup.nodes;

public class Comment
  extends Node
{
  private static final String COMMENT_KEY = "comment";
  
  public Comment(String paramString1, String paramString2)
  {
    super(paramString2);
    this.attributes.put("comment", paramString1);
  }
  
  public String getData()
  {
    return this.attributes.get("comment");
  }
  
  public String nodeName()
  {
    return "#comment";
  }
  
  void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    if (paramOutputSettings.prettyPrint()) {
      indent(paramStringBuilder, paramInt, paramOutputSettings);
    }
    paramStringBuilder.append("<!--").append(getData()).append("-->");
  }
  
  void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {}
  
  public String toString()
  {
    return outerHtml();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/nodes/Comment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
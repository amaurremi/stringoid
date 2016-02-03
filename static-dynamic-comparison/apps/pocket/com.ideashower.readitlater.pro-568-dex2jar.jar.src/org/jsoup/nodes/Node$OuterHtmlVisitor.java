package org.jsoup.nodes;

import org.jsoup.select.NodeVisitor;

class Node$OuterHtmlVisitor
  implements NodeVisitor
{
  private StringBuilder accum;
  private Document.OutputSettings out;
  
  Node$OuterHtmlVisitor(StringBuilder paramStringBuilder, Document.OutputSettings paramOutputSettings)
  {
    this.accum = paramStringBuilder;
    this.out = paramOutputSettings;
  }
  
  public void head(Node paramNode, int paramInt)
  {
    paramNode.outerHtmlHead(this.accum, paramInt, this.out);
  }
  
  public void tail(Node paramNode, int paramInt)
  {
    if (!paramNode.nodeName().equals("#text")) {
      paramNode.outerHtmlTail(this.accum, paramInt, this.out);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/nodes/Node$OuterHtmlVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
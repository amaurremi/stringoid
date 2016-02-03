package org.jsoup.safety;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeVisitor;

final class Cleaner$CleaningVisitor
  implements NodeVisitor
{
  private Element destination;
  private int numDiscarded = 0;
  private final Element root;
  
  private Cleaner$CleaningVisitor(Cleaner paramCleaner, Element paramElement1, Element paramElement2)
  {
    this.root = paramElement1;
    this.destination = paramElement2;
  }
  
  public void head(Node paramNode, int paramInt)
  {
    if ((paramNode instanceof Element))
    {
      Element localElement = (Element)paramNode;
      if (Cleaner.access$000(this.this$0).isSafeTag(localElement.tagName()))
      {
        paramNode = Cleaner.access$100(this.this$0, localElement);
        localElement = paramNode.el;
        this.destination.appendChild(localElement);
        paramInt = this.numDiscarded;
        this.numDiscarded = (paramNode.numAttribsDiscarded + paramInt);
        this.destination = localElement;
      }
      while (paramNode == this.root) {
        return;
      }
      this.numDiscarded += 1;
      return;
    }
    if ((paramNode instanceof TextNode))
    {
      paramNode = new TextNode(((TextNode)paramNode).getWholeText(), paramNode.baseUri());
      this.destination.appendChild(paramNode);
      return;
    }
    this.numDiscarded += 1;
  }
  
  public void tail(Node paramNode, int paramInt)
  {
    if (((paramNode instanceof Element)) && (Cleaner.access$000(this.this$0).isSafeTag(paramNode.nodeName()))) {
      this.destination = this.destination.parent();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/safety/Cleaner$CleaningVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
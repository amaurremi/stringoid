package org.jsoup.select;

import org.jsoup.nodes.Node;

public class NodeTraversor
{
  private NodeVisitor visitor;
  
  public NodeTraversor(NodeVisitor paramNodeVisitor)
  {
    this.visitor = paramNodeVisitor;
  }
  
  public void traverse(Node paramNode)
  {
    int i = 0;
    Node localNode1 = paramNode;
    for (;;)
    {
      int j;
      Node localNode2;
      if (localNode1 != null)
      {
        this.visitor.head(localNode1, i);
        j = i;
        localNode2 = localNode1;
        if (localNode1.childNodeSize() > 0)
        {
          localNode1 = localNode1.childNode(0);
          i += 1;
          continue;
        }
        while ((localNode2.nextSibling() == null) && (j > 0))
        {
          this.visitor.tail(localNode2, j);
          localNode2 = localNode2.parent();
          j -= 1;
        }
        this.visitor.tail(localNode2, j);
        if (localNode2 != paramNode) {}
      }
      else
      {
        return;
      }
      localNode1 = localNode2.nextSibling();
      i = j;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/NodeTraversor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
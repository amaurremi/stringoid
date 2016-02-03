package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

class Collector$Accumulator
  implements NodeVisitor
{
  private final Elements elements;
  private final Evaluator eval;
  private final Element root;
  
  Collector$Accumulator(Element paramElement, Elements paramElements, Evaluator paramEvaluator)
  {
    this.root = paramElement;
    this.elements = paramElements;
    this.eval = paramEvaluator;
  }
  
  public void head(Node paramNode, int paramInt)
  {
    if ((paramNode instanceof Element))
    {
      paramNode = (Element)paramNode;
      if (this.eval.matches(this.root, paramNode)) {
        this.elements.add(paramNode);
      }
    }
  }
  
  public void tail(Node paramNode, int paramInt) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Collector$Accumulator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
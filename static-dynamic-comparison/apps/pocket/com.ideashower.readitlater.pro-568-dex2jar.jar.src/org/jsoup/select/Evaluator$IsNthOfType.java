package org.jsoup.select;

import org.jsoup.nodes.Element;

public class Evaluator$IsNthOfType
  extends Evaluator.CssNthEvaluator
{
  public Evaluator$IsNthOfType(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected int calculatePosition(Element paramElement1, Element paramElement2)
  {
    int k = 0;
    paramElement1 = paramElement2.parent().children();
    int j;
    for (int i = 0;; i = j)
    {
      j = i;
      if (k < paramElement1.size())
      {
        j = i;
        if (paramElement1.get(k).tag() == paramElement2.tag()) {
          j = i + 1;
        }
        if (paramElement1.get(k) != paramElement2) {}
      }
      else
      {
        return j;
      }
      k += 1;
    }
  }
  
  protected String getPseudoClass()
  {
    return "nth-of-type";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$IsNthOfType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
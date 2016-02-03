package org.jsoup.select;

import java.util.Collection;
import java.util.List;
import org.jsoup.nodes.Element;

final class CombiningEvaluator$Or
  extends CombiningEvaluator
{
  CombiningEvaluator$Or() {}
  
  CombiningEvaluator$Or(Collection paramCollection)
  {
    if (paramCollection.size() > 1)
    {
      this.evaluators.add(new CombiningEvaluator.And(paramCollection));
      return;
    }
    this.evaluators.addAll(paramCollection);
  }
  
  public void add(Evaluator paramEvaluator)
  {
    this.evaluators.add(paramEvaluator);
  }
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.evaluators.size())
      {
        if (((Evaluator)this.evaluators.get(i)).matches(paramElement1, paramElement2)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public String toString()
  {
    return String.format(":or%s", new Object[] { this.evaluators });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/CombiningEvaluator$Or.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
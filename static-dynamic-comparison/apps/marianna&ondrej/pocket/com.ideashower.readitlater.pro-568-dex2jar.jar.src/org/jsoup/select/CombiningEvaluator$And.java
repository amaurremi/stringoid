package org.jsoup.select;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;

final class CombiningEvaluator$And
  extends CombiningEvaluator
{
  CombiningEvaluator$And(Collection paramCollection)
  {
    super(paramCollection);
  }
  
  CombiningEvaluator$And(Evaluator... paramVarArgs)
  {
    this(Arrays.asList(paramVarArgs));
  }
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    int i = 0;
    while (i < this.evaluators.size())
    {
      if (!((Evaluator)this.evaluators.get(i)).matches(paramElement1, paramElement2)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public String toString()
  {
    return StringUtil.join(this.evaluators, " ");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/CombiningEvaluator$And.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
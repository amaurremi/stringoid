package org.jsoup.select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

abstract class CombiningEvaluator
  extends Evaluator
{
  final List evaluators = new ArrayList();
  
  CombiningEvaluator() {}
  
  CombiningEvaluator(Collection paramCollection)
  {
    this();
    this.evaluators.addAll(paramCollection);
  }
  
  void replaceRightMostEvaluator(Evaluator paramEvaluator)
  {
    this.evaluators.set(this.evaluators.size() - 1, paramEvaluator);
  }
  
  Evaluator rightMostEvaluator()
  {
    if (this.evaluators.size() > 0) {
      return (Evaluator)this.evaluators.get(this.evaluators.size() - 1);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/CombiningEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package org.jsoup.select;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;

public class Selector
{
  private final Evaluator evaluator;
  private final Element root;
  
  private Selector(String paramString, Element paramElement)
  {
    Validate.notNull(paramString);
    paramString = paramString.trim();
    Validate.notEmpty(paramString);
    Validate.notNull(paramElement);
    this.evaluator = QueryParser.parse(paramString);
    this.root = paramElement;
  }
  
  static Elements filterOut(Collection paramCollection1, Collection paramCollection2)
  {
    Elements localElements = new Elements();
    paramCollection1 = paramCollection1.iterator();
    label92:
    for (;;)
    {
      Element localElement;
      if (paramCollection1.hasNext())
      {
        localElement = (Element)paramCollection1.next();
        Iterator localIterator = paramCollection2.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!localElement.equals((Element)localIterator.next()));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label92;
        }
        localElements.add(localElement);
        break;
        return localElements;
      }
    }
  }
  
  private Elements select()
  {
    return Collector.collect(this.evaluator, this.root);
  }
  
  public static Elements select(String paramString, Iterable paramIterable)
  {
    Validate.notEmpty(paramString);
    Validate.notNull(paramIterable);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localLinkedHashSet.addAll(select(paramString, (Element)paramIterable.next()));
    }
    return new Elements(localLinkedHashSet);
  }
  
  public static Elements select(String paramString, Element paramElement)
  {
    return new Selector(paramString, paramElement).select();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Selector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package org.jsoup.select;

import org.jsoup.nodes.Element;

public final class Evaluator$ContainsText
  extends Evaluator
{
  private String searchText;
  
  public Evaluator$ContainsText(String paramString)
  {
    this.searchText = paramString.toLowerCase();
  }
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    return paramElement2.text().toLowerCase().contains(this.searchText);
  }
  
  public String toString()
  {
    return String.format(":contains(%s", new Object[] { this.searchText });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$ContainsText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
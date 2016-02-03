package org.jsoup.select;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Element;

public final class Evaluator$MatchesOwn
  extends Evaluator
{
  private Pattern pattern;
  
  public Evaluator$MatchesOwn(Pattern paramPattern)
  {
    this.pattern = paramPattern;
  }
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    return this.pattern.matcher(paramElement2.ownText()).find();
  }
  
  public String toString()
  {
    return String.format(":matchesOwn(%s", new Object[] { this.pattern });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$MatchesOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
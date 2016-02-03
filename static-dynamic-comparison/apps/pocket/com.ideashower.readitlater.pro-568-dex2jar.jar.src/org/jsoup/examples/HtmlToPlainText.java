package org.jsoup.examples;

import java.io.PrintStream;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.select.NodeTraversor;

public class HtmlToPlainText
{
  public static void main(String... paramVarArgs)
  {
    boolean bool = true;
    if (paramVarArgs.length == 1) {}
    for (;;)
    {
      Validate.isTrue(bool, "usage: supply url to fetch");
      paramVarArgs = Jsoup.connect(paramVarArgs[0]).get();
      paramVarArgs = new HtmlToPlainText().getPlainText(paramVarArgs);
      System.out.println(paramVarArgs);
      return;
      bool = false;
    }
  }
  
  public String getPlainText(Element paramElement)
  {
    HtmlToPlainText.FormattingVisitor localFormattingVisitor = new HtmlToPlainText.FormattingVisitor(this, null);
    new NodeTraversor(localFormattingVisitor).traverse(paramElement);
    return localFormattingVisitor.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/examples/HtmlToPlainText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
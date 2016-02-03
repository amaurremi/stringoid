package org.jsoup.examples;

import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeVisitor;

class HtmlToPlainText$FormattingVisitor
  implements NodeVisitor
{
  private static final int maxWidth = 80;
  private StringBuilder accum = new StringBuilder();
  private int width = 0;
  
  private HtmlToPlainText$FormattingVisitor(HtmlToPlainText paramHtmlToPlainText) {}
  
  private void append(String paramString)
  {
    if (paramString.startsWith("\n")) {
      this.width = 0;
    }
    if (paramString.equals(" ")) {
      if (this.accum.length() != 0)
      {
        if (!StringUtil.in(this.accum.substring(this.accum.length() - 1), new String[] { " ", "\n" })) {}
      }
      else {
        return;
      }
    }
    if (paramString.length() + this.width > 80)
    {
      String[] arrayOfString = paramString.split("\\s+");
      int i = 0;
      label94:
      int j;
      if (i < arrayOfString.length)
      {
        String str = arrayOfString[i];
        if (i != arrayOfString.length - 1) {
          break label189;
        }
        j = 1;
        label118:
        paramString = str;
        if (j == 0) {
          paramString = str + " ";
        }
        if (paramString.length() + this.width <= 80) {
          break label194;
        }
        this.accum.append("\n").append(paramString);
      }
      for (this.width = paramString.length();; this.width = (paramString.length() + j))
      {
        i += 1;
        break label94;
        break;
        label189:
        j = 0;
        break label118;
        label194:
        this.accum.append(paramString);
        j = this.width;
      }
    }
    this.accum.append(paramString);
    this.width += paramString.length();
  }
  
  public void head(Node paramNode, int paramInt)
  {
    String str = paramNode.nodeName();
    if ((paramNode instanceof TextNode)) {
      append(((TextNode)paramNode).text());
    }
    while (!str.equals("li")) {
      return;
    }
    append("\n * ");
  }
  
  public void tail(Node paramNode, int paramInt)
  {
    String str = paramNode.nodeName();
    if (str.equals("br")) {
      append("\n");
    }
    do
    {
      return;
      if (StringUtil.in(str, new String[] { "p", "h1", "h2", "h3", "h4", "h5" }))
      {
        append("\n\n");
        return;
      }
    } while (!str.equals("a"));
    append(String.format(" <%s>", new Object[] { paramNode.absUrl("href") }));
  }
  
  public String toString()
  {
    return this.accum.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/examples/HtmlToPlainText$FormattingVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
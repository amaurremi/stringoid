package org.jsoup.nodes;

import java.util.List;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;

public class TextNode
  extends Node
{
  private static final String TEXT_KEY = "text";
  String text;
  
  public TextNode(String paramString1, String paramString2)
  {
    this.baseUri = paramString2;
    this.text = paramString1;
  }
  
  public static TextNode createFromEncoded(String paramString1, String paramString2)
  {
    return new TextNode(Entities.unescape(paramString1), paramString2);
  }
  
  private void ensureAttributes()
  {
    if (this.attributes == null)
    {
      this.attributes = new Attributes();
      this.attributes.put("text", this.text);
    }
  }
  
  static boolean lastCharIsWhitespace(StringBuilder paramStringBuilder)
  {
    return (paramStringBuilder.length() != 0) && (paramStringBuilder.charAt(paramStringBuilder.length() - 1) == ' ');
  }
  
  static String normaliseWhitespace(String paramString)
  {
    return StringUtil.normaliseWhitespace(paramString);
  }
  
  static String stripLeadingWhitespace(String paramString)
  {
    return paramString.replaceFirst("^\\s+", "");
  }
  
  public String absUrl(String paramString)
  {
    ensureAttributes();
    return super.absUrl(paramString);
  }
  
  public String attr(String paramString)
  {
    ensureAttributes();
    return super.attr(paramString);
  }
  
  public Node attr(String paramString1, String paramString2)
  {
    ensureAttributes();
    return super.attr(paramString1, paramString2);
  }
  
  public Attributes attributes()
  {
    ensureAttributes();
    return super.attributes();
  }
  
  public String getWholeText()
  {
    if (this.attributes == null) {
      return this.text;
    }
    return this.attributes.get("text");
  }
  
  public boolean hasAttr(String paramString)
  {
    ensureAttributes();
    return super.hasAttr(paramString);
  }
  
  public boolean isBlank()
  {
    return StringUtil.isBlank(getWholeText());
  }
  
  public String nodeName()
  {
    return "#text";
  }
  
  void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    String str2 = Entities.escape(getWholeText(), paramOutputSettings);
    String str1 = str2;
    if (paramOutputSettings.prettyPrint())
    {
      str1 = str2;
      if ((parent() instanceof Element))
      {
        str1 = str2;
        if (!Element.preserveWhitespace((Element)parent())) {
          str1 = normaliseWhitespace(str2);
        }
      }
    }
    if ((paramOutputSettings.prettyPrint()) && (((siblingIndex() == 0) && ((this.parentNode instanceof Element)) && (((Element)this.parentNode).tag().formatAsBlock()) && (!isBlank())) || ((paramOutputSettings.outline()) && (siblingNodes().size() > 0) && (!isBlank())))) {
      indent(paramStringBuilder, paramInt, paramOutputSettings);
    }
    paramStringBuilder.append(str1);
  }
  
  void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {}
  
  public Node removeAttr(String paramString)
  {
    ensureAttributes();
    return super.removeAttr(paramString);
  }
  
  public TextNode splitText(int paramInt)
  {
    if (paramInt >= 0)
    {
      bool = true;
      Validate.isTrue(bool, "Split offset must be not be negative");
      if (paramInt >= this.text.length()) {
        break label106;
      }
    }
    label106:
    for (boolean bool = true;; bool = false)
    {
      Validate.isTrue(bool, "Split offset must not be greater than current text length");
      Object localObject = getWholeText().substring(0, paramInt);
      String str = getWholeText().substring(paramInt);
      text((String)localObject);
      localObject = new TextNode(str, baseUri());
      if (parent() != null) {
        parent().addChildren(siblingIndex() + 1, new Node[] { localObject });
      }
      return (TextNode)localObject;
      bool = false;
      break;
    }
  }
  
  public String text()
  {
    return normaliseWhitespace(getWholeText());
  }
  
  public TextNode text(String paramString)
  {
    this.text = paramString;
    if (this.attributes != null) {
      this.attributes.put("text", paramString);
    }
    return this;
  }
  
  public String toString()
  {
    return outerHtml();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/nodes/TextNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
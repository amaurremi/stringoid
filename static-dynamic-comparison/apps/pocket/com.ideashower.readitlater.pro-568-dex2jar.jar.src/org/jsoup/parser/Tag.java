package org.jsoup.parser;

import java.util.HashMap;
import java.util.Map;
import org.jsoup.helper.Validate;

public class Tag
{
  private static final String[] blockTags;
  private static final String[] emptyTags;
  private static final String[] formatAsInlineTags;
  private static final String[] inlineTags;
  private static final String[] preserveWhitespaceTags;
  private static final Map tags;
  private boolean canContainBlock = true;
  private boolean canContainInline = true;
  private boolean empty = false;
  private boolean formatAsBlock = true;
  private boolean isBlock = true;
  private boolean preserveWhitespace = false;
  private boolean selfClosing = false;
  private String tagName;
  
  static
  {
    int j = 0;
    tags = new HashMap();
    blockTags = new String[] { "html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "s", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext" };
    inlineTags = new String[] { "object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device" };
    emptyTags = new String[] { "meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device" };
    formatAsInlineTags = new String[] { "title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s" };
    preserveWhitespaceTags = new String[] { "pre", "plaintext", "title", "textarea" };
    String[] arrayOfString = blockTags;
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      register(new Tag(arrayOfString[i]));
      i += 1;
    }
    arrayOfString = inlineTags;
    k = arrayOfString.length;
    i = 0;
    Object localObject;
    while (i < k)
    {
      localObject = new Tag(arrayOfString[i]);
      ((Tag)localObject).isBlock = false;
      ((Tag)localObject).canContainBlock = false;
      ((Tag)localObject).formatAsBlock = false;
      register((Tag)localObject);
      i += 1;
    }
    arrayOfString = emptyTags;
    k = arrayOfString.length;
    i = 0;
    while (i < k)
    {
      localObject = arrayOfString[i];
      localObject = (Tag)tags.get(localObject);
      Validate.notNull(localObject);
      ((Tag)localObject).canContainBlock = false;
      ((Tag)localObject).canContainInline = false;
      ((Tag)localObject).empty = true;
      i += 1;
    }
    arrayOfString = formatAsInlineTags;
    k = arrayOfString.length;
    i = 0;
    while (i < k)
    {
      localObject = arrayOfString[i];
      localObject = (Tag)tags.get(localObject);
      Validate.notNull(localObject);
      ((Tag)localObject).formatAsBlock = false;
      i += 1;
    }
    arrayOfString = preserveWhitespaceTags;
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      localObject = arrayOfString[i];
      localObject = (Tag)tags.get(localObject);
      Validate.notNull(localObject);
      ((Tag)localObject).preserveWhitespace = true;
      i += 1;
    }
  }
  
  private Tag(String paramString)
  {
    this.tagName = paramString.toLowerCase();
  }
  
  public static boolean isKnownTag(String paramString)
  {
    return tags.containsKey(paramString);
  }
  
  private static void register(Tag paramTag)
  {
    tags.put(paramTag.tagName, paramTag);
  }
  
  public static Tag valueOf(String paramString)
  {
    Validate.notNull(paramString);
    Object localObject2 = (Tag)tags.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = paramString.trim().toLowerCase();
      Validate.notEmpty((String)localObject2);
      paramString = (Tag)tags.get(localObject2);
      localObject1 = paramString;
      if (paramString == null)
      {
        localObject1 = new Tag((String)localObject2);
        ((Tag)localObject1).isBlock = false;
        ((Tag)localObject1).canContainBlock = true;
      }
    }
    return (Tag)localObject1;
  }
  
  public boolean canContainBlock()
  {
    return this.canContainBlock;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Tag)) {
        return false;
      }
      paramObject = (Tag)paramObject;
      if (this.canContainBlock != ((Tag)paramObject).canContainBlock) {
        return false;
      }
      if (this.canContainInline != ((Tag)paramObject).canContainInline) {
        return false;
      }
      if (this.empty != ((Tag)paramObject).empty) {
        return false;
      }
      if (this.formatAsBlock != ((Tag)paramObject).formatAsBlock) {
        return false;
      }
      if (this.isBlock != ((Tag)paramObject).isBlock) {
        return false;
      }
      if (this.preserveWhitespace != ((Tag)paramObject).preserveWhitespace) {
        return false;
      }
      if (this.selfClosing != ((Tag)paramObject).selfClosing) {
        return false;
      }
    } while (this.tagName.equals(((Tag)paramObject).tagName));
    return false;
  }
  
  public boolean formatAsBlock()
  {
    return this.formatAsBlock;
  }
  
  public String getName()
  {
    return this.tagName;
  }
  
  public int hashCode()
  {
    int i2 = 1;
    int i3 = this.tagName.hashCode();
    int i;
    int j;
    label30:
    int k;
    label39:
    int m;
    label49:
    int n;
    label59:
    int i1;
    if (this.isBlock)
    {
      i = 1;
      if (!this.formatAsBlock) {
        break label123;
      }
      j = 1;
      if (!this.canContainBlock) {
        break label128;
      }
      k = 1;
      if (!this.canContainInline) {
        break label133;
      }
      m = 1;
      if (!this.empty) {
        break label139;
      }
      n = 1;
      if (!this.selfClosing) {
        break label145;
      }
      i1 = 1;
      label69:
      if (!this.preserveWhitespace) {
        break label151;
      }
    }
    for (;;)
    {
      return (i1 + (n + (m + (k + (j + (i + i3 * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
      i = 0;
      break;
      label123:
      j = 0;
      break label30;
      label128:
      k = 0;
      break label39;
      label133:
      m = 0;
      break label49;
      label139:
      n = 0;
      break label59;
      label145:
      i1 = 0;
      break label69;
      label151:
      i2 = 0;
    }
  }
  
  public boolean isBlock()
  {
    return this.isBlock;
  }
  
  public boolean isData()
  {
    return (!this.canContainInline) && (!isEmpty());
  }
  
  public boolean isEmpty()
  {
    return this.empty;
  }
  
  public boolean isInline()
  {
    return !this.isBlock;
  }
  
  public boolean isKnownTag()
  {
    return tags.containsKey(this.tagName);
  }
  
  public boolean isSelfClosing()
  {
    return (this.empty) || (this.selfClosing);
  }
  
  public boolean preserveWhitespace()
  {
    return this.preserveWhitespace;
  }
  
  Tag setSelfClosing()
  {
    this.selfClosing = true;
    return this;
  }
  
  public String toString()
  {
    return this.tagName;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/parser/Tag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
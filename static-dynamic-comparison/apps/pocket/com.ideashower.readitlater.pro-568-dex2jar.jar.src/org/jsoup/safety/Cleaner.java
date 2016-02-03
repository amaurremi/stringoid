package org.jsoup.safety;

import java.util.Iterator;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.NodeTraversor;

public class Cleaner
{
  private Whitelist whitelist;
  
  public Cleaner(Whitelist paramWhitelist)
  {
    Validate.notNull(paramWhitelist);
    this.whitelist = paramWhitelist;
  }
  
  private int copySafeNodes(Element paramElement1, Element paramElement2)
  {
    paramElement2 = new Cleaner.CleaningVisitor(this, paramElement1, paramElement2, null);
    new NodeTraversor(paramElement2).traverse(paramElement1);
    return Cleaner.CleaningVisitor.access$300(paramElement2);
  }
  
  private Cleaner.ElementMeta createSafeElement(Element paramElement)
  {
    String str = paramElement.tagName();
    Attributes localAttributes = new Attributes();
    Element localElement = new Element(Tag.valueOf(str), paramElement.baseUri(), localAttributes);
    Iterator localIterator = paramElement.attributes().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Attribute localAttribute = (Attribute)localIterator.next();
      if (this.whitelist.isSafeAttribute(str, paramElement, localAttribute)) {
        localAttributes.put(localAttribute);
      }
      for (;;)
      {
        break;
        i += 1;
      }
    }
    localAttributes.addAll(this.whitelist.getEnforcedAttributes(str));
    return new Cleaner.ElementMeta(localElement, i);
  }
  
  public Document clean(Document paramDocument)
  {
    Validate.notNull(paramDocument);
    Document localDocument = Document.createShell(paramDocument.baseUri());
    if (paramDocument.body() != null) {
      copySafeNodes(paramDocument.body(), localDocument.body());
    }
    return localDocument;
  }
  
  public boolean isValid(Document paramDocument)
  {
    Validate.notNull(paramDocument);
    Document localDocument = Document.createShell(paramDocument.baseUri());
    return copySafeNodes(paramDocument.body(), localDocument.body()) == 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/safety/Cleaner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
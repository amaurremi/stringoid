package org.jsoup.nodes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

public class Document
  extends Element
{
  private Document.OutputSettings outputSettings = new Document.OutputSettings();
  private Document.QuirksMode quirksMode = Document.QuirksMode.noQuirks;
  
  public Document(String paramString)
  {
    super(Tag.valueOf("#root"), paramString);
  }
  
  public static Document createShell(String paramString)
  {
    Validate.notNull(paramString);
    paramString = new Document(paramString);
    Element localElement = paramString.appendElement("html");
    localElement.appendElement("head");
    localElement.appendElement("body");
    return paramString;
  }
  
  private Element findFirstElementByTagName(String paramString, Node paramNode)
  {
    if (paramNode.nodeName().equals(paramString)) {
      return (Element)paramNode;
    }
    paramNode = paramNode.childNodes.iterator();
    while (paramNode.hasNext())
    {
      Element localElement = findFirstElementByTagName(paramString, (Node)paramNode.next());
      if (localElement != null) {
        return localElement;
      }
    }
    return null;
  }
  
  private void normaliseStructure(String paramString, Element paramElement)
  {
    Object localObject = getElementsByTag(paramString);
    paramString = ((Elements)localObject).first();
    if (((Elements)localObject).size() > 1)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 1;
      while (i < ((Elements)localObject).size())
      {
        Element localElement = ((Elements)localObject).get(i);
        Iterator localIterator = localElement.childNodes.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((Node)localIterator.next());
        }
        localElement.remove();
        i += 1;
      }
      localObject = localArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.appendChild((Node)((Iterator)localObject).next());
      }
    }
    if (!paramString.parent().equals(paramElement)) {
      paramElement.appendChild(paramString);
    }
  }
  
  private void normaliseTextNodes(Element paramElement)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramElement.childNodes.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Node)((Iterator)localObject1).next();
      if ((localObject2 instanceof TextNode))
      {
        localObject2 = (TextNode)localObject2;
        if (!((TextNode)localObject2).isBlank()) {
          localArrayList.add(localObject2);
        }
      }
    }
    int i = localArrayList.size() - 1;
    while (i >= 0)
    {
      localObject1 = (Node)localArrayList.get(i);
      paramElement.removeChild((Node)localObject1);
      body().prependChild(new TextNode(" ", ""));
      body().prependChild((Node)localObject1);
      i -= 1;
    }
  }
  
  public Element body()
  {
    return findFirstElementByTagName("body", this);
  }
  
  public Document clone()
  {
    Document localDocument = (Document)super.clone();
    localDocument.outputSettings = this.outputSettings.clone();
    return localDocument;
  }
  
  public Element createElement(String paramString)
  {
    return new Element(Tag.valueOf(paramString), baseUri());
  }
  
  public Element head()
  {
    return findFirstElementByTagName("head", this);
  }
  
  public String nodeName()
  {
    return "#document";
  }
  
  public Document normalise()
  {
    Element localElement2 = findFirstElementByTagName("html", this);
    Element localElement1 = localElement2;
    if (localElement2 == null) {
      localElement1 = appendElement("html");
    }
    if (head() == null) {
      localElement1.prependElement("head");
    }
    if (body() == null) {
      localElement1.appendElement("body");
    }
    normaliseTextNodes(head());
    normaliseTextNodes(localElement1);
    normaliseTextNodes(this);
    normaliseStructure("head", localElement1);
    normaliseStructure("body", localElement1);
    return this;
  }
  
  public String outerHtml()
  {
    return super.html();
  }
  
  public Document.OutputSettings outputSettings()
  {
    return this.outputSettings;
  }
  
  public Document outputSettings(Document.OutputSettings paramOutputSettings)
  {
    Validate.notNull(paramOutputSettings);
    this.outputSettings = paramOutputSettings;
    return this;
  }
  
  public Document.QuirksMode quirksMode()
  {
    return this.quirksMode;
  }
  
  public Document quirksMode(Document.QuirksMode paramQuirksMode)
  {
    this.quirksMode = paramQuirksMode;
    return this;
  }
  
  public Element text(String paramString)
  {
    body().text(paramString);
    return this;
  }
  
  public String title()
  {
    Element localElement = getElementsByTag("title").first();
    if (localElement != null) {
      return StringUtil.normaliseWhitespace(localElement.text()).trim();
    }
    return "";
  }
  
  public void title(String paramString)
  {
    Validate.notNull(paramString);
    Element localElement = getElementsByTag("title").first();
    if (localElement == null)
    {
      head().appendElement("title").text(paramString);
      return;
    }
    localElement.text(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/nodes/Document.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
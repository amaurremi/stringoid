package org.jsoup.parser;

import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class Parser
{
  private static final int DEFAULT_MAX_ERRORS = 0;
  private ParseErrorList errors;
  private int maxErrors = 0;
  private TreeBuilder treeBuilder;
  
  public Parser(TreeBuilder paramTreeBuilder)
  {
    this.treeBuilder = paramTreeBuilder;
  }
  
  public static Parser htmlParser()
  {
    return new Parser(new HtmlTreeBuilder());
  }
  
  public static Document parse(String paramString1, String paramString2)
  {
    return new HtmlTreeBuilder().parse(paramString1, paramString2, ParseErrorList.noTracking());
  }
  
  public static Document parseBodyFragment(String paramString1, String paramString2)
  {
    Document localDocument = Document.createShell(paramString2);
    Element localElement = localDocument.body();
    paramString1 = parseFragment(paramString1, localElement, paramString2);
    paramString1 = (Node[])paramString1.toArray(new Node[paramString1.size()]);
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      localElement.appendChild(paramString1[i]);
      i += 1;
    }
    return localDocument;
  }
  
  public static Document parseBodyFragmentRelaxed(String paramString1, String paramString2)
  {
    return parse(paramString1, paramString2);
  }
  
  public static List parseFragment(String paramString1, Element paramElement, String paramString2)
  {
    return new HtmlTreeBuilder().parseFragment(paramString1, paramElement, paramString2, ParseErrorList.noTracking());
  }
  
  public static List parseXmlFragment(String paramString1, String paramString2)
  {
    return new XmlTreeBuilder().parseFragment(paramString1, paramString2, ParseErrorList.noTracking());
  }
  
  public static String unescapeEntities(String paramString, boolean paramBoolean)
  {
    return new Tokeniser(new CharacterReader(paramString), ParseErrorList.noTracking()).unescapeEntities(paramBoolean);
  }
  
  public static Parser xmlParser()
  {
    return new Parser(new XmlTreeBuilder());
  }
  
  public List getErrors()
  {
    return this.errors;
  }
  
  public TreeBuilder getTreeBuilder()
  {
    return this.treeBuilder;
  }
  
  public boolean isTrackErrors()
  {
    return this.maxErrors > 0;
  }
  
  public Document parseInput(String paramString1, String paramString2)
  {
    if (isTrackErrors()) {}
    for (ParseErrorList localParseErrorList = ParseErrorList.tracking(this.maxErrors);; localParseErrorList = ParseErrorList.noTracking())
    {
      this.errors = localParseErrorList;
      return this.treeBuilder.parse(paramString1, paramString2, this.errors);
    }
  }
  
  public Parser setTrackErrors(int paramInt)
  {
    this.maxErrors = paramInt;
    return this;
  }
  
  public Parser setTreeBuilder(TreeBuilder paramTreeBuilder)
  {
    this.treeBuilder = paramTreeBuilder;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/parser/Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
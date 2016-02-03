package com.amazonaws.regions;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RegionMetadataParser
{
  private static void addRegionEndpoint(Region paramRegion, Element paramElement, boolean paramBoolean)
  {
    String str1 = getChildElementValue("ServiceName", paramElement);
    String str2 = getChildElementValue("Hostname", paramElement);
    String str3 = getChildElementValue("Http", paramElement);
    paramElement = getChildElementValue("Https", paramElement);
    if ((paramBoolean) && (!verifyLegacyEndpoint(str2))) {
      throw new IllegalStateException("Invalid service endpoint (" + str2 + ") is detected.");
    }
    paramRegion.getServiceEndpoints().put(str1, str2);
    paramRegion.getHttpSupport().put(str1, Boolean.valueOf("true".equals(str3)));
    paramRegion.getHttpsSupport().put(str1, Boolean.valueOf("true".equals(paramElement)));
  }
  
  private static String getChildElementValue(String paramString, Element paramElement)
  {
    paramString = paramElement.getElementsByTagName(paramString).item(0);
    if (paramString == null) {
      return null;
    }
    return paramString.getChildNodes().item(0).getNodeValue();
  }
  
  /* Error */
  private static List<Region> internalParse(InputStream paramInputStream, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 114	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: invokevirtual 118	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   6: aload_0
    //   7: invokevirtual 124	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   10: astore_3
    //   11: aload_0
    //   12: invokevirtual 129	java/io/InputStream:close	()V
    //   15: aload_3
    //   16: ldc -125
    //   18: invokeinterface 134 2 0
    //   23: astore_0
    //   24: new 136	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 137	java/util/ArrayList:<init>	()V
    //   31: astore_3
    //   32: iconst_0
    //   33: istore_2
    //   34: iload_2
    //   35: aload_0
    //   36: invokeinterface 141 1 0
    //   41: if_icmpge +96 -> 137
    //   44: aload_0
    //   45: iload_2
    //   46: invokeinterface 93 2 0
    //   51: astore 4
    //   53: aload 4
    //   55: invokeinterface 145 1 0
    //   60: iconst_1
    //   61: if_icmpne +19 -> 80
    //   64: aload_3
    //   65: aload 4
    //   67: checkcast 83	org/w3c/dom/Element
    //   70: iload_1
    //   71: invokestatic 149	com/amazonaws/regions/RegionMetadataParser:parseRegionElement	(Lorg/w3c/dom/Element;Z)Lcom/amazonaws/regions/Region;
    //   74: invokeinterface 154 2 0
    //   79: pop
    //   80: iload_2
    //   81: iconst_1
    //   82: iadd
    //   83: istore_2
    //   84: goto -50 -> 34
    //   87: astore_3
    //   88: aload_3
    //   89: athrow
    //   90: astore_3
    //   91: aload_0
    //   92: invokevirtual 129	java/io/InputStream:close	()V
    //   95: aload_3
    //   96: athrow
    //   97: astore_3
    //   98: new 106	java/io/IOException
    //   101: dup
    //   102: new 33	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   109: ldc -100
    //   111: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_3
    //   115: invokevirtual 159	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   118: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: aload_3
    //   125: invokespecial 162	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: athrow
    //   129: astore_0
    //   130: goto -115 -> 15
    //   133: astore_0
    //   134: goto -39 -> 95
    //   137: aload_3
    //   138: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramInputStream	InputStream
    //   0	139	1	paramBoolean	boolean
    //   33	51	2	i	int
    //   10	55	3	localObject1	Object
    //   87	2	3	localIOException	java.io.IOException
    //   90	6	3	localObject2	Object
    //   97	41	3	localException	Exception
    //   51	15	4	localNode	Node
    // Exception table:
    //   from	to	target	type
    //   0	11	87	java/io/IOException
    //   0	11	90	finally
    //   88	90	90	finally
    //   98	129	90	finally
    //   0	11	97	java/lang/Exception
    //   11	15	129	java/io/IOException
    //   91	95	133	java/io/IOException
  }
  
  private static Region parseRegionElement(Element paramElement, boolean paramBoolean)
  {
    Region localRegion = new Region(getChildElementValue("Name", paramElement), getChildElementValue("Domain", paramElement));
    paramElement = paramElement.getElementsByTagName("Endpoint");
    int i = 0;
    while (i < paramElement.getLength())
    {
      addRegionEndpoint(localRegion, (Element)paramElement.item(i), paramBoolean);
      i += 1;
    }
    return localRegion;
  }
  
  private static boolean verifyLegacyEndpoint(String paramString)
  {
    return paramString.endsWith(".amazonaws.com");
  }
  
  @Deprecated
  public List<Region> parseRegionMetadata(InputStream paramInputStream, boolean paramBoolean)
  {
    return internalParse(paramInputStream, paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/regions/RegionMetadataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
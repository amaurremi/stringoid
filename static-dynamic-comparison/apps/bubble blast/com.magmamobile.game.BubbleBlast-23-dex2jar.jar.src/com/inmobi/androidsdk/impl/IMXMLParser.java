package com.inmobi.androidsdk.impl;

import com.inmobi.commons.internal.IMLog;
import java.io.IOException;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class IMXMLParser
{
  private static String a = "Ad";
  
  public static IMAdUnit buildAdUnitFromResponseData(Reader paramReader)
    throws IOException, IMAdException
  {
    IMAdUnit localIMAdUnit = new IMAdUnit();
    Object localObject1;
    XmlPullParser localXmlPullParser;
    int m;
    int k;
    int i;
    try
    {
      localObject1 = XmlPullParserFactory.newInstance();
      ((XmlPullParserFactory)localObject1).setNamespaceAware(true);
      localXmlPullParser = ((XmlPullParserFactory)localObject1).newPullParser();
      localXmlPullParser.setInput(paramReader);
      m = localXmlPullParser.getEventType();
      localObject1 = null;
      k = 0;
      i = 0;
      paramReader = null;
      if (m == 1)
      {
        if (i != 0) {
          break label342;
        }
        throw new IMAdException("App Id may be Invalid or Inactive", 800);
      }
    }
    catch (XmlPullParserException paramReader)
    {
      throw new IMAdException("Exception constructing Ad", paramReader, 200);
    }
    int j = i;
    Object localObject2 = localObject1;
    if (m != 0) {
      if (m == 2)
      {
        localObject1 = localXmlPullParser.getName();
        if (localObject1 != null) {
          i = 1;
        }
        j = i;
        localObject2 = localObject1;
        if (localObject1 == null) {
          break label493;
        }
        j = i;
        localObject2 = localObject1;
        if (!((String)localObject1).equalsIgnoreCase(a)) {
          break label493;
        }
        localIMAdUnit.setWidth(Integer.parseInt(localXmlPullParser.getAttributeValue(null, "width")));
        localIMAdUnit.setHeight(Integer.parseInt(localXmlPullParser.getAttributeValue(null, "height")));
        localIMAdUnit.setAdActionName(IMAdUnit.adActionNamefromString(localXmlPullParser.getAttributeValue(null, "actionName")));
        localIMAdUnit.setAdType(IMAdUnit.adTypefromString(localXmlPullParser.getAttributeValue(null, "type")));
        paramReader = localXmlPullParser.getAttributeValue(null, "errorcode");
        k = 1;
      }
    }
    for (;;)
    {
      m = localXmlPullParser.nextToken();
      break;
      label342:
      do
      {
        if (m == 5)
        {
          localIMAdUnit.setCDATABlock(localXmlPullParser.getText());
          break;
        }
        j = i;
        localObject2 = localObject1;
        if (m != 4) {
          break label493;
        }
        j = i;
        localObject2 = localObject1;
        if (localObject1 == null) {
          break label493;
        }
        j = i;
        localObject2 = localObject1;
        if (!((String)localObject1).equalsIgnoreCase("AdURL")) {
          break label493;
        }
        localIMAdUnit.setTargetUrl(localXmlPullParser.getText());
        localIMAdUnit.setDefaultTargetUrl(localXmlPullParser.getText());
        j = i;
        localObject2 = localObject1;
        break label493;
        if (k == 0) {
          throw new IMAdException("No Ads present", 100);
        }
        if (paramReader != null)
        {
          if (paramReader.equals("OOF"))
          {
            IMLog.debug("InMobiAndroidSDK_3.6.1", "IP Address not found in CCID File");
            throw new IMAdException("IP Address not found in CCID File", 400);
          }
          if (paramReader.equals("BADIP"))
          {
            IMLog.debug("InMobiAndroidSDK_3.6.1", "Invalid IP Address");
            throw new IMAdException("Invalid IP Address", 500);
          }
          if (paramReader.equals("UAND"))
          {
            IMLog.debug("InMobiAndroidSDK_3.6.1", "User Agent not detected through using wurfl");
            throw new IMAdException("User Agent not detected through using wurfl", 600);
          }
          if (paramReader.equals("-UA"))
          {
            IMLog.debug("InMobiAndroidSDK_3.6.1", "No User Agent found");
            throw new IMAdException("No User Agent found", 700);
          }
        }
        return localIMAdUnit;
      } while (m != 3);
      localObject1 = null;
      continue;
      label493:
      i = j;
      localObject1 = localObject2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/impl/IMXMLParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
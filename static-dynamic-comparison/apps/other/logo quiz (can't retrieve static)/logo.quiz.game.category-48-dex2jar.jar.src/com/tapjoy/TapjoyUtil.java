package com.tapjoy;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TapjoyUtil
{
  private static final String TAG = "TapjoyUtil";
  private static String mraidJs = null;
  
  public static String SHA1(String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    return hashAlgorithm("SHA-1", paramString);
  }
  
  public static String SHA256(String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    return hashAlgorithm("SHA-256", paramString);
  }
  
  public static Document buildDocument(String paramString)
  {
    try
    {
      DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
      paramString = new ByteArrayInputStream(paramString.getBytes("UTF-8"));
      paramString = localDocumentBuilderFactory.newDocumentBuilder().parse(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      TapjoyLog.e("TapjoyUtil", "buildDocument exception: " + paramString.toString());
    }
    return null;
  }
  
  private static String convertToHex(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int k;
    int j;
    if (i < paramArrayOfByte.length)
    {
      k = paramArrayOfByte[i] >>> 4 & 0xF;
      j = 0;
    }
    for (;;)
    {
      if ((k >= 0) && (k <= 9)) {
        localStringBuffer.append((char)(k + 48));
      }
      for (;;)
      {
        k = paramArrayOfByte[i] & 0xF;
        if (j < 1) {
          break label91;
        }
        i += 1;
        break;
        localStringBuffer.append((char)(k - 10 + 97));
      }
      return localStringBuffer.toString();
      label91:
      j += 1;
    }
  }
  
  public static String convertURLParams(Map<String, String> paramMap, boolean paramBoolean)
  {
    Object localObject = "";
    Iterator localIterator = paramMap.entrySet().iterator();
    paramMap = (Map<String, String>)localObject;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localObject = paramMap;
      if (paramMap.length() > 0) {
        localObject = paramMap + "&";
      }
      if (paramBoolean) {
        paramMap = (String)localObject + Uri.encode((String)localEntry.getKey()) + "=" + Uri.encode((String)localEntry.getValue());
      } else {
        paramMap = (String)localObject + (String)localEntry.getKey() + "=" + (String)localEntry.getValue();
      }
    }
    return paramMap;
  }
  
  public static Map<String, String> convertURLParams(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    int j = 0;
    int k = 0;
    Object localObject1 = "";
    Object localObject3 = "";
    if ((j < paramString.length()) && (j != -1))
    {
      char c = paramString.charAt(j);
      int i;
      label69:
      Object localObject2;
      Object localObject4;
      if (k == 0) {
        if (c == '=')
        {
          i = 1;
          if (paramBoolean)
          {
            localObject1 = Uri.decode((String)localObject1);
            localObject2 = "";
            localObject4 = localObject1;
          }
        }
      }
      for (;;)
      {
        j += 1;
        localObject3 = localObject4;
        k = i;
        localObject1 = localObject2;
        break;
        break label69;
        localObject2 = (String)localObject1 + c;
        localObject4 = localObject3;
        i = k;
        continue;
        localObject4 = localObject3;
        i = k;
        localObject2 = localObject1;
        if (k == 1)
        {
          if (c == '&')
          {
            i = 0;
            if (paramBoolean) {
              localObject1 = Uri.decode((String)localObject1);
            }
            for (;;)
            {
              localObject2 = "";
              localHashMap.put(localObject3, localObject1);
              localObject4 = localObject3;
              break;
            }
          }
          localObject2 = (String)localObject1 + c;
          localObject4 = localObject3;
          i = k;
        }
      }
    }
    if ((k == 1) && (((String)localObject1).length() > 0)) {
      if (!paramBoolean) {
        break label262;
      }
    }
    label262:
    for (paramString = Uri.decode((String)localObject1);; paramString = (String)localObject1)
    {
      localHashMap.put(localObject3, paramString);
      return localHashMap;
    }
  }
  
  public static Bitmap createBitmapFromView(View paramView)
  {
    Canvas localCanvas = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramView != null)
    {
      localObject2 = localObject1;
      if (paramView.getLayoutParams().width > 0)
      {
        localObject2 = localObject1;
        if (paramView.getLayoutParams().height > 0) {
          localObject1 = localCanvas;
        }
      }
    }
    try
    {
      localObject2 = Bitmap.createBitmap(paramView.getLayoutParams().width, paramView.getLayoutParams().height, Bitmap.Config.ARGB_8888);
      localObject1 = localObject2;
      localCanvas = new Canvas((Bitmap)localObject2);
      localObject1 = localObject2;
      paramView.layout(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      localObject1 = localObject2;
      paramView.draw(localCanvas);
      return (Bitmap)localObject2;
    }
    catch (Exception paramView)
    {
      TapjoyLog.i("TapjoyUtil", "error creating bitmap: " + paramView.toString());
    }
    return (Bitmap)localObject1;
  }
  
  public static void deleteFileOrDirectory(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        deleteFileOrDirectory(arrayOfFile[i]);
        i += 1;
      }
    }
    TapjoyLog.i("TapjoyUtil", "****************************************");
    TapjoyLog.i("TapjoyUtil", "deleteFileOrDirectory: " + paramFile.getAbsolutePath());
    TapjoyLog.i("TapjoyUtil", "****************************************");
    paramFile.delete();
  }
  
  public static String getMraidJsString()
  {
    return mraidJs;
  }
  
  public static String getNodeTrimValue(NodeList paramNodeList)
  {
    Object localObject2 = null;
    Object localObject3 = (Element)paramNodeList.item(0);
    paramNodeList = "";
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((Element)localObject3).getChildNodes();
      int j = ((NodeList)localObject3).getLength();
      int i = 0;
      while (i < j)
      {
        Node localNode = ((NodeList)localObject3).item(i);
        localObject1 = paramNodeList;
        if (localNode != null) {
          localObject1 = paramNodeList + localNode.getNodeValue();
        }
        i += 1;
        paramNodeList = (NodeList)localObject1;
      }
      localObject1 = localObject2;
      if (paramNodeList != null)
      {
        localObject1 = localObject2;
        if (!paramNodeList.equals("")) {
          localObject1 = paramNodeList.trim();
        }
      }
    }
    return (String)localObject1;
  }
  
  private static String hashAlgorithm(String paramString1, String paramString2)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    byte[] arrayOfByte = new byte[40];
    paramString1 = MessageDigest.getInstance(paramString1);
    paramString1.update(paramString2.getBytes("iso-8859-1"), 0, paramString2.length());
    return convertToHex(paramString1.digest());
  }
  
  public static void safePut(Map<String, String> paramMap, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramString2 != null) && (paramString2.length() > 0))
    {
      if (paramBoolean) {
        paramMap.put(Uri.encode(paramString1), Uri.encode(paramString2));
      }
    }
    else {
      return;
    }
    paramMap.put(paramString1, paramString2);
  }
  
  public static View scaleDisplayAd(View paramView, int paramInt)
  {
    int i = paramView.getLayoutParams().width;
    int j = paramView.getLayoutParams().height;
    TapjoyLog.i("TapjoyUtil", "wxh: " + i + "x" + j);
    if (i > paramInt)
    {
      int k = Double.valueOf(Double.valueOf(Double.valueOf(paramInt).doubleValue() / Double.valueOf(i).doubleValue()).doubleValue() * 100.0D).intValue();
      ((WebView)paramView).getSettings().setSupportZoom(true);
      ((WebView)paramView).setPadding(0, 0, 0, 0);
      ((WebView)paramView).setVerticalScrollBarEnabled(false);
      ((WebView)paramView).setHorizontalScrollBarEnabled(false);
      ((WebView)paramView).setInitialScale(k);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(paramInt, paramInt * j / i));
    }
    return paramView;
  }
  
  public static void setMraidJsString(String paramString)
  {
    mraidJs = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TapjoyUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
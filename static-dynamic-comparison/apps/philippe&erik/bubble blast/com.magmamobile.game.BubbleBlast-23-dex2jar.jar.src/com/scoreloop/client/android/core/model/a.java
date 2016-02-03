package com.scoreloop.client.android.core.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.scoreloop.client.android.core.utils.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.util.EncodingUtils;

final class a
{
  private static final String a = "en.lproj" + File.separator + "Localizable.strings";
  private static final Object b = "amount";
  private static final Object c = "currency";
  private Context d;
  private Pattern e;
  
  a(Context paramContext)
  {
    this.d = paramContext;
  }
  
  private Bitmap a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = BitmapFactory.decodeStream(b(paramString1, paramString2));
      return paramString1;
    }
    catch (IOException paramString1) {}
    return null;
  }
  
  private Award a(AwardList paramAwardList, Map<String, Object> paramMap)
  {
    String str = PlistParser.c(paramMap.get("identifier"));
    Range localRange = b(PlistParser.c(paramMap.get("counterRange")));
    Integer localInteger = PlistParser.d(paramMap.get("importance"));
    paramMap = a(PlistParser.a(paramMap.get("rewardMoney")));
    return new Award(paramAwardList, str, localRange, localInteger.intValue(), paramMap);
  }
  
  private Money a(Map<String, Object> paramMap)
  {
    Integer localInteger = PlistParser.d(paramMap.get(b));
    return new Money(PlistParser.c(paramMap.get(c)), new BigDecimal(localInteger.intValue()));
  }
  
  private Range b(String paramString)
  {
    if (this.e == null) {
      this.e = Pattern.compile("\\s*\\{\\s*(\\d+)\\s*,\\s*(\\d+)\\s*\\}\\s*");
    }
    paramString = this.e.matcher(paramString);
    if (!paramString.matches()) {
      throw new IllegalStateException("wrong counterRange value in plist");
    }
    return new Range(Integer.parseInt(paramString.group(1)), Integer.parseInt(paramString.group(2)));
  }
  
  private InputStream b(String paramString1, String paramString2)
    throws IOException
  {
    return this.d.getAssets().open(paramString1 + File.separator + paramString2);
  }
  
  private String c(String paramString)
  {
    paramString = paramString + File.separator + "SLAwards.bundle";
    if (d(paramString)) {}
    do
    {
      return paramString;
      paramString = "SLAwards.bundle";
    } while (d("SLAwards.bundle"));
    return null;
  }
  
  private boolean d(String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = this.d.getAssets().list(paramString);
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < paramString.length)
        {
          bool1 = paramString[i].equalsIgnoreCase("Info.plist");
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (IOException paramString) {}
  }
  
  private void e(String paramString)
    throws IOException, NoSuchAlgorithmException
  {
    byte[] arrayOfByte1 = f(new BufferedReader(new InputStreamReader(b(paramString, "Info.plist.checksum"))).readLine());
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
    paramString = b(paramString, "Info.plist");
    byte[] arrayOfByte2 = new byte['Ѐ'];
    for (int i = paramString.read(arrayOfByte2); i > 0; i = paramString.read(arrayOfByte2)) {
      localMessageDigest.update(arrayOfByte2, 0, i);
    }
    if (!MessageDigest.isEqual(arrayOfByte1, localMessageDigest.digest(EncodingUtils.getBytes("f02e3c85572dc9ad7cb77c2a638e3", "UTF-8")))) {
      throw new IllegalStateException("invalid plist - checksums do not match");
    }
  }
  
  private static byte[] f(String paramString)
  {
    int j = 0;
    int k = paramString.length();
    if (k != 40) {
      throw new IllegalStateException("checksum must be 40 characters long");
    }
    byte[] arrayOfByte = new byte[20];
    int i = 0;
    while (j < k)
    {
      arrayOfByte[i] = ((byte)Integer.parseInt(paramString.substring(j, j + 2), 16));
      j += 2;
      i += 1;
    }
    return arrayOfByte;
  }
  
  AwardList a(String paramString)
  {
    String str = c(paramString);
    if (str == null) {
      return null;
    }
    AwardList localAwardList;
    try
    {
      localAwardList = new AwardList();
      e(str);
      paramString = PlistParser.a(new PlistParser().a(b(str, "Info.plist")));
      localAwardList.b(PlistParser.c(paramString.get("SLAchievableListIdentifier")));
      paramString = PlistParser.b(paramString.get("SLAwards")).iterator();
      while (paramString.hasNext()) {
        localAwardList.a(a(localAwardList, PlistParser.a(paramString.next())));
      }
      localObject1 = a(str, "Award.default.achieved.png");
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      Logger.b("error reading awards from bundle" + paramString);
      return null;
    }
    Object localObject1;
    Object localObject2 = a(str, "Award.default.unachieved.png");
    Iterator localIterator = localAwardList.b().iterator();
    Award localAward;
    if (localIterator.hasNext())
    {
      localAward = (Award)localIterator.next();
      paramString = a(str, localAward.f());
      if (paramString == null) {
        break label339;
      }
      label218:
      localAward.a(paramString);
      paramString = a(str, localAward.g());
      if (paramString == null) {
        break label344;
      }
    }
    for (;;)
    {
      localAward.b(paramString);
      break;
      paramString = new StringsParser().a(b(str, a));
      localObject1 = localAwardList.b().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Award)((Iterator)localObject1).next();
        ((Award)localObject2).a((String)paramString.get(((Award)localObject2).h()));
        ((Award)localObject2).b((String)paramString.get(((Award)localObject2).i()));
      }
      return localAwardList;
      label339:
      paramString = (String)localObject1;
      break label218;
      label344:
      paramString = (String)localObject2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
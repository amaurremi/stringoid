package com.magmamobile.mmusia.parser.parsers;

import android.content.Context;
import android.os.SystemClock;
import com.magmamobile.mmusia.MCommon;
import com.magmamobile.mmusia.MMUSIA;
import com.magmamobile.mmusia.parser.JSonParser;
import com.magmamobile.mmusia.parser.JsonUtils;
import com.magmamobile.mmusia.parser.data.ApiBase;
import com.magmamobile.mmusia.parser.data.ItemAppUpdate;
import com.magmamobile.mmusia.parser.data.ItemMoreGames;
import com.magmamobile.mmusia.parser.data.ItemNews;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSonNews
  extends JSonParser
{
  public static ApiBase loadItems(Context paramContext, String paramString, List<NameValuePair> paramList, boolean paramBoolean)
    throws JSONException
  {
    j = 1;
    i = 0;
    float f = (float)SystemClock.currentThreadTimeMillis();
    localApiBase = new ApiBase();
    Object localObject2 = new ItemNews[0];
    Object localObject3 = new ItemAppUpdate[0];
    arrayOfItemMoreGames = new ItemMoreGames[0];
    try
    {
      paramList = sendJSonRequestPost(paramString, paramList);
      MCommon.Log_d("rawJSON from api : " + paramList);
      if (paramBoolean) {
        return localApiBase;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramList = "";
      }
      paramString = paramList;
      if (paramList.equals(""))
      {
        paramString = readRawJson(paramContext, "mmusia.json");
        MCommon.Log_d("rawJSON from cache : " + paramString);
        j = 0;
        i = 1;
      }
      localObject1 = arrayOfItemMoreGames;
      if (paramString.equals("")) {
        break label671;
      }
    }
    MCommon.Log_d(paramString);
    try
    {
      localObject1 = new JSONObject(paramString);
      paramList = paramString;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ItemNews[] arrayOfItemNews;
        ItemAppUpdate[] arrayOfItemAppUpdate;
        j = 0;
        i = 1;
        MCommon.Log_d("try to load from cache : " + paramString);
        paramList = readRawJson(paramContext, "mmusia.json");
        localObject1 = new JSONObject(paramList);
        localJSONException.printStackTrace();
        continue;
        localApiBase.HasNewNews = 0;
        localApiBase.HasNewUpdates = 0;
        localApiBase.HasNewVersionAvailable = 0;
        localApiBase.promoId = 0;
        localApiBase.promoTitle = "";
        localApiBase.promoDesc = "";
        localApiBase.promoUrl = "";
        localApiBase.promoIconUrl = "";
        localApiBase.promoPName = "";
        localApiBase.promoId2 = 0;
        localApiBase.promoTitle2 = "";
        localApiBase.promoDesc2 = "";
        localApiBase.promoUrl2 = "";
        localApiBase.promoIconUrl2 = "";
        localApiBase.promoPName2 = "";
        localApiBase.promoId3 = 0;
        localApiBase.promoTitle3 = "";
        localApiBase.promoDesc3 = "";
        localApiBase.promoUrl3 = "";
        localApiBase.promoIconUrl3 = "";
        localApiBase.promoPName3 = "";
        continue;
        localJSONObject = paramString.getJSONObject(i);
        arrayOfItemNews[i] = new ItemNews();
        arrayOfItemNews[i].NewsID = localJSONObject.getInt("NewsID");
        arrayOfItemNews[i].NewsTitle = localJSONObject.getString("NewsTitle");
        arrayOfItemNews[i].NewsLanguage = localJSONObject.getString("NewsLanguage");
        arrayOfItemNews[i].NewsDesc = localJSONObject.getString("NewsDesc");
        arrayOfItemNews[i].NewsDate = JsonUtils.getJSDate(localJSONObject, "NewsDate");
        arrayOfItemNews[i].NewsUrlLink = localJSONObject.getString("NewsUrlLink");
        arrayOfItemNews[i].NewsUrlMarket = (localJSONObject.getString("NewsUrlMarket") + "-" + MMUSIA.RefererComplement);
        arrayOfItemNews[i].imgUrl = localJSONObject.getString("NewsImgUrl");
        MCommon.Log_d(arrayOfItemNews[i].NewsUrlMarket);
        i += 1;
        continue;
        localJSONObject = paramString.getJSONObject(i);
        arrayOfItemAppUpdate[i] = new ItemAppUpdate();
        arrayOfItemAppUpdate[i].Name = localJSONObject.getString("Name");
        arrayOfItemAppUpdate[i].ChangeLog = localJSONObject.getString("ChangeLog");
        arrayOfItemAppUpdate[i].MarketLink = localJSONObject.getString("MarketLink");
        arrayOfItemAppUpdate[i].PackageName = localJSONObject.getString("PackageName");
        arrayOfItemAppUpdate[i].UpdateDate = JsonUtils.getJSDate(localJSONObject, "UpdateDate");
        arrayOfItemAppUpdate[i].Version = localJSONObject.getString("Version");
        arrayOfItemAppUpdate[i].VersionName = localJSONObject.getString("VersionName");
        i += 1;
        continue;
        paramString = arrayOfItemMoreGames;
        localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
        paramString = arrayOfItemMoreGames;
        arrayOfItemMoreGames[i] = new ItemMoreGames();
        paramString = arrayOfItemMoreGames;
        arrayOfItemMoreGames[i].title = localJSONObject.getString("title");
        paramString = arrayOfItemMoreGames;
        arrayOfItemMoreGames[i].pname = localJSONObject.getString("pname");
        paramString = arrayOfItemMoreGames;
        arrayOfItemMoreGames[i].urlImg = localJSONObject.getString("urlImg");
        paramString = arrayOfItemMoreGames;
        arrayOfItemMoreGames[i].urlMarket = (localJSONObject.getString("urlMarket") + "-" + MMUSIA.RefererComplement);
        paramString = arrayOfItemMoreGames;
        arrayOfItemMoreGames[i].free = localJSONObject.getInt("free");
        i += 1;
      }
    }
    if (i == 0)
    {
      localApiBase.HasNewNews = ((JSONObject)localObject1).getInt("HasNewNews");
      localApiBase.HasNewUpdates = ((JSONObject)localObject1).getInt("HasNewUpdates");
      localApiBase.HasNewVersionAvailable = ((JSONObject)localObject1).getInt("newVersionAvailable");
      localApiBase.promoId = ((JSONObject)localObject1).getInt("promoId");
      localApiBase.promoTitle = ((JSONObject)localObject1).getString("promoTitle");
      localApiBase.promoDesc = ((JSONObject)localObject1).getString("promoDesc");
      localApiBase.promoUrl = (((JSONObject)localObject1).getString("promoUrl") + "-" + MMUSIA.RefererComplement);
      localApiBase.promoIconUrl = ((JSONObject)localObject1).getString("promoIconUrl");
      localApiBase.promoPName = ((JSONObject)localObject1).getString("promoPName");
      localApiBase.promoId2 = ((JSONObject)localObject1).getInt("promoId2");
      localApiBase.promoTitle2 = ((JSONObject)localObject1).getString("promoTitle2");
      localApiBase.promoDesc2 = ((JSONObject)localObject1).getString("promoDesc2");
      localApiBase.promoUrl2 = (((JSONObject)localObject1).getString("promoUrl2") + "-" + MMUSIA.RefererComplement);
      localApiBase.promoIconUrl2 = ((JSONObject)localObject1).getString("promoIconUrl2");
      localApiBase.promoPName2 = ((JSONObject)localObject1).getString("promoPName2");
      localApiBase.promoId3 = ((JSONObject)localObject1).getInt("promoId3");
      localApiBase.promoTitle3 = ((JSONObject)localObject1).getString("promoTitle3");
      localApiBase.promoDesc3 = ((JSONObject)localObject1).getString("promoDesc3");
      localApiBase.promoUrl3 = (((JSONObject)localObject1).getString("promoUrl3") + "-" + MMUSIA.RefererComplement);
      localApiBase.promoIconUrl3 = ((JSONObject)localObject1).getString("promoIconUrl3");
      localApiBase.promoPName3 = ((JSONObject)localObject1).getString("promoPName3");
      localApiBase.appodayId = ((JSONObject)localObject1).getInt("appodayId");
      localApiBase.appodayName = ((JSONObject)localObject1).getString("appodayName");
      localApiBase.appodayUrl = ((JSONObject)localObject1).getString("appodayUrl");
      localApiBase.appodayIconUrl = ((JSONObject)localObject1).getString("appodayIconUrl");
      paramString = ((JSONObject)localObject1).getJSONArray("news");
      arrayOfItemNews = new ItemNews[paramString.length()];
      i = 0;
      if (i < paramString.length()) {
        break label924;
      }
      paramString = ((JSONObject)localObject1).getJSONArray("updates");
      arrayOfItemAppUpdate = new ItemAppUpdate[paramString.length()];
      i = 0;
      if (i < paramString.length()) {
        break label1114;
      }
      paramString = arrayOfItemMoreGames;
    }
    try
    {
      localObject1 = ((JSONObject)localObject1).getJSONArray("moregames");
      paramString = arrayOfItemMoreGames;
      arrayOfItemMoreGames = new ItemMoreGames[((JSONArray)localObject1).length()];
      i = 0;
      paramString = arrayOfItemMoreGames;
      int k = ((JSONArray)localObject1).length();
      if (i < k) {
        break label1255;
      }
      paramString = arrayOfItemMoreGames;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        MCommon.Log_e("MMUSIA MORE GAMES LIST Error : " + localException.getMessage());
        localException.printStackTrace();
      }
    }
    localObject1 = paramString;
    localObject2 = arrayOfItemNews;
    localObject3 = arrayOfItemAppUpdate;
    if (j != 0)
    {
      saveRawJSon(paramContext, "mmusia.json", paramList);
      localObject3 = arrayOfItemAppUpdate;
      localObject2 = arrayOfItemNews;
      localObject1 = paramString;
    }
    label671:
    MCommon.Log_w("JSON Parse time : " + ((float)SystemClock.currentThreadTimeMillis() - f) / 1000.0F + " sec");
    localApiBase.news = ((ItemNews[])localObject2);
    localApiBase.updates = ((ItemAppUpdate[])localObject3);
    localApiBase.moregames = ((ItemMoreGames[])localObject1);
    return localApiBase;
  }
  
  /* Error */
  public static String readRawJson(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 351	java/io/File
    //   3: dup
    //   4: new 36	java/lang/StringBuilder
    //   7: dup
    //   8: aload_0
    //   9: invokevirtual 357	android/content/Context:getFilesDir	()Ljava/io/File;
    //   12: invokevirtual 360	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   15: invokestatic 117	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: ldc_w 362
    //   24: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 367	java/io/File:exists	()Z
    //   42: ifne +12 -> 54
    //   45: ldc_w 369
    //   48: invokestatic 54	com/magmamobile/mmusia/MCommon:Log_d	(Ljava/lang/String;)V
    //   51: ldc 59
    //   53: areturn
    //   54: new 36	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   61: astore_0
    //   62: new 372	java/io/BufferedReader
    //   65: dup
    //   66: new 374	java/io/FileReader
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 377	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   74: invokespecial 380	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   77: astore_1
    //   78: aload_1
    //   79: invokevirtual 383	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   82: astore_2
    //   83: aload_2
    //   84: ifnonnull +12 -> 96
    //   87: aload_1
    //   88: invokevirtual 386	java/io/BufferedReader:close	()V
    //   91: aload_0
    //   92: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: areturn
    //   96: aload_0
    //   97: aload_2
    //   98: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_0
    //   103: bipush 10
    //   105: invokevirtual 389	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: goto -31 -> 78
    //   112: astore_0
    //   113: ldc 59
    //   115: areturn
    //   116: astore_0
    //   117: ldc 59
    //   119: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   0	120	1	paramString	String
    //   82	16	2	str	String
    // Exception table:
    //   from	to	target	type
    //   62	78	112	java/io/IOException
    //   78	83	112	java/io/IOException
    //   87	96	112	java/io/IOException
    //   96	109	112	java/io/IOException
    //   38	51	116	java/lang/Exception
    //   54	62	116	java/lang/Exception
    //   62	78	116	java/lang/Exception
    //   78	83	116	java/lang/Exception
    //   87	96	116	java/lang/Exception
    //   96	109	116	java/lang/Exception
  }
  
  /* Error */
  private static void saveRawJSon(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: ldc 59
    //   8: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifne -7 -> 4
    //   14: aload_2
    //   15: monitorenter
    //   16: new 351	java/io/File
    //   19: dup
    //   20: new 36	java/lang/StringBuilder
    //   23: dup
    //   24: aload_0
    //   25: invokevirtual 357	android/content/Context:getFilesDir	()Ljava/io/File;
    //   28: invokevirtual 360	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   31: invokestatic 117	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: ldc_w 362
    //   40: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore_0
    //   54: new 391	java/io/FileOutputStream
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 392	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: astore_1
    //   63: new 394	java/io/OutputStreamWriter
    //   66: dup
    //   67: aload_1
    //   68: invokespecial 397	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   71: astore_3
    //   72: aload_3
    //   73: aload_2
    //   74: invokevirtual 400	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   77: aload_3
    //   78: invokevirtual 401	java/io/OutputStreamWriter:close	()V
    //   81: aload_1
    //   82: invokevirtual 402	java/io/FileOutputStream:close	()V
    //   85: new 36	java/lang/StringBuilder
    //   88: dup
    //   89: ldc_w 404
    //   92: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload_0
    //   96: invokevirtual 360	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   99: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 54	com/magmamobile/mmusia/MCommon:Log_d	(Ljava/lang/String;)V
    //   108: aload_2
    //   109: monitorexit
    //   110: return
    //   111: astore_0
    //   112: aload_2
    //   113: monitorexit
    //   114: aload_0
    //   115: athrow
    //   116: astore_0
    //   117: new 36	java/lang/StringBuilder
    //   120: dup
    //   121: ldc_w 406
    //   124: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: aload_0
    //   128: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   131: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 344	com/magmamobile/mmusia/MCommon:Log_e	(Ljava/lang/String;)V
    //   140: aload_0
    //   141: invokevirtual 57	java/lang/Exception:printStackTrace	()V
    //   144: goto -36 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramContext	Context
    //   0	147	1	paramString1	String
    //   0	147	2	paramString2	String
    //   71	7	3	localOutputStreamWriter	java.io.OutputStreamWriter
    // Exception table:
    //   from	to	target	type
    //   16	54	111	finally
    //   54	108	111	finally
    //   108	110	111	finally
    //   112	114	111	finally
    //   117	144	111	finally
    //   54	108	116	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/parser/parsers/JSonNews.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.ideashower.readitlater.reader.twitter;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.ideashower.readitlater.e.y;
import com.ideashower.readitlater.util.e;
import com.pocket.oauth.k;
import com.pocket.oauth.n;
import com.pocket.oauth.q;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static String a(String paramString, JSONArray paramJSONArray)
  {
    Object localObject = paramString;
    if (paramJSONArray != null)
    {
      int i = 0;
      for (;;)
      {
        localObject = paramString;
        if (i >= paramJSONArray.length()) {
          break;
        }
        try
        {
          JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
          localObject = paramString;
          if (localJSONObject != null)
          {
            localObject = paramString;
            if (localJSONObject.has("text"))
            {
              localObject = paramString;
              if (localJSONObject.has("display_url"))
              {
                localObject = paramString;
                if (localJSONObject.has("url"))
                {
                  localObject = new StringBuffer();
                  ((StringBuffer)localObject).append("<a href=\"");
                  ((StringBuffer)localObject).append(localJSONObject.optString("url"));
                  ((StringBuffer)localObject).append("\" >");
                  ((StringBuffer)localObject).append(localJSONObject.optString("display_url"));
                  ((StringBuffer)localObject).append("</a>");
                  localObject = paramString.replace(localJSONObject.optString("text"), ((StringBuffer)localObject).toString());
                }
              }
            }
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            e.a(localJSONException);
            str = paramString;
          }
        }
        i += 1;
        paramString = (String)localObject;
      }
    }
    String str;
    return str;
  }
  
  public static void a(Context paramContext, long paramLong, String paramString)
  {
    paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://twitter.com/intent/tweet?in_reply_to=" + paramLong + "&text=@" + paramString + " ")));
  }
  
  public static void a(Context paramContext, y paramy)
  {
    long l = paramy.b();
    paramy = paramy.f();
    paramy = "https://twitter.com/" + paramy + "/status/" + l;
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramy));
    paramContext.startActivity(localIntent);
  }
  
  private static void a(final Context paramContext, final y paramy, final int paramInt)
  {
    String str1;
    if (paramInt == 0) {
      str1 = paramContext.getString(2131493112);
    }
    for (final String str2 = paramContext.getString(2131493752);; str2 = paramContext.getString(2131493751))
    {
      q localq = new q(paramContext);
      new AlertDialog.Builder(paramContext).setMessage(str1).setPositiveButton(2131492924, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.dismiss();
          a.this.b();
          a.this.a(new n()
          {
            public void a(k paramAnonymous2k, boolean paramAnonymous2Boolean)
            {
              if (paramAnonymous2Boolean)
              {
                q.c = false;
                if (a.3.this.b == 0)
                {
                  q.b(a.3.this.c);
                  a.c(a.3.this.c, a.3.this.d);
                  return;
                }
                q.b(a.3.this.c);
                a.b(a.3.this.d, a.3.this.c);
                return;
              }
              Toast.makeText(a.3.this.c, a.3.this.e, 0).show();
            }
          });
        }
      }).setNegativeButton(2131492871, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.dismiss();
        }
      }).show();
      return;
      str1 = paramContext.getString(2131493111);
    }
  }
  
  public static void a(Context paramContext, final y paramy, final String paramString)
  {
    ListView localListView = new ListView(paramContext);
    ArrayAdapter localArrayAdapter = new ArrayAdapter(paramContext, 17367043, new String[] { paramContext.getString(2131493474), paramContext.getString(2131493467) });
    final AlertDialog localAlertDialog = new AlertDialog.Builder(paramContext).setView(localListView).create();
    localListView.setAdapter(localArrayAdapter);
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          localAlertDialog.dismiss();
          return;
          a.b(a.this, paramy);
          continue;
          a.a(a.this, paramString);
        }
      }
    });
    localAlertDialog.show();
  }
  
  public static void a(y paramy, Context paramContext)
  {
    boolean bool = true;
    if (q.c)
    {
      a(paramContext, paramy, 1);
      if (paramy.k()) {
        break label35;
      }
    }
    for (;;)
    {
      paramy.b(bool);
      return;
      c(paramy, paramContext);
      break;
      label35:
      bool = false;
    }
  }
  
  public static String b(String paramString, JSONArray paramJSONArray)
  {
    Object localObject = paramString;
    if (paramJSONArray != null)
    {
      int i = 0;
      for (;;)
      {
        localObject = paramString;
        if (i >= paramJSONArray.length()) {
          break;
        }
        new JSONObject();
        try
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          localObject = paramString;
          if (localJSONObject != null)
          {
            localObject = paramString;
            if (localJSONObject.has("text"))
            {
              localObject = new StringBuffer();
              ((StringBuffer)localObject).append("<a href=\"");
              ((StringBuffer)localObject).append("https://twitter.com/search?q=%23" + localJSONObject.optString("text"));
              ((StringBuffer)localObject).append("\" >");
              ((StringBuffer)localObject).append("#" + localJSONObject.optString("text"));
              ((StringBuffer)localObject).append("</a>");
              localObject = paramString.replace("#" + localJSONObject.optString("text"), (CharSequence)localObject);
            }
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            e.a(localJSONException);
            str = paramString;
          }
        }
        i += 1;
        paramString = (String)localObject;
      }
    }
    String str;
    return str;
  }
  
  public static void b(Context paramContext, y paramy)
  {
    if (q.c)
    {
      a(paramContext, paramy, 0);
      return;
    }
    new c(paramContext, paramy.m()).h();
  }
  
  private static void b(Context paramContext, String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "utf-8");
      paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://twitter.com/intent/tweet?text=" + paramString + " ")));
      return;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      e.a(paramContext);
    }
  }
  
  public static String c(String paramString, JSONArray paramJSONArray)
  {
    Object localObject = paramString;
    if (paramJSONArray != null)
    {
      int i = 0;
      for (;;)
      {
        localObject = paramString;
        if (i >= paramJSONArray.length()) {
          break;
        }
        new JSONObject();
        try
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          localObject = paramString;
          if (localJSONObject != null)
          {
            localObject = paramString;
            if (localJSONObject.has("text"))
            {
              localObject = new StringBuffer();
              ((StringBuffer)localObject).append("<a href=\"");
              ((StringBuffer)localObject).append("http://twitter.com/intent/user?screen_name=" + localJSONObject.optString("text"));
              ((StringBuffer)localObject).append("\" >");
              ((StringBuffer)localObject).append("@" + localJSONObject.optString("text"));
              ((StringBuffer)localObject).append("</a>");
              localObject = paramString.replace("@" + localJSONObject.optString("text"), ((StringBuffer)localObject).toString());
            }
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            e.a(localJSONException);
            str = paramString;
          }
        }
        i += 1;
        paramString = (String)localObject;
      }
    }
    String str;
    return str;
  }
  
  private static void c(y paramy, Context paramContext)
  {
    new b(paramContext, paramy.m(), paramy.k()).h();
  }
  
  public static String d(String paramString, JSONArray paramJSONArray)
  {
    Object localObject = paramString;
    if (paramJSONArray != null)
    {
      int i = 0;
      for (;;)
      {
        localObject = paramString;
        if (i >= paramJSONArray.length()) {
          break;
        }
        new JSONObject();
        try
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          localObject = paramString;
          if (localJSONObject != null)
          {
            localObject = paramString;
            if (localJSONObject.has("text"))
            {
              localObject = paramString;
              if (localJSONObject.has("display_url"))
              {
                localObject = paramString;
                if (localJSONObject.has("expanded_url"))
                {
                  localObject = new StringBuffer();
                  ((StringBuffer)localObject).append("<a href=\"");
                  ((StringBuffer)localObject).append(localJSONObject.optString("expanded_url"));
                  ((StringBuffer)localObject).append("\" >");
                  ((StringBuffer)localObject).append(localJSONObject.optString("display_url"));
                  ((StringBuffer)localObject).append("</a>");
                  localObject = paramString.replace(localJSONObject.optString("text"), ((StringBuffer)localObject).toString());
                }
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            e.a(localException);
            str = paramString;
          }
        }
        i += 1;
        paramString = (String)localObject;
      }
    }
    String str;
    return str;
  }
  
  private static void d(Context paramContext, y paramy)
  {
    new c(paramContext, paramy.b()).h();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/twitter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
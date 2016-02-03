package com.ideashower.readitlater.views;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.g.m;
import com.pocket.p.i;
import com.pocket.p.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.a.c.k;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.safety.Whitelist;

class af
  extends al
{
  protected final ResolveInfo a;
  private int c = 0;
  
  public af(ad paramad, ResolveInfo paramResolveInfo)
  {
    super(paramad, null);
    this.a = paramResolveInfo;
    this.e = paramResolveInfo.loadLabel(ad.g(paramad)).toString();
    this.f = ad.b(paramResolveInfo.activityInfo.name);
    b();
  }
  
  public boolean a()
  {
    return g() == 5;
  }
  
  public Drawable b()
  {
    if ((this.d == null) && (this.a != null)) {
      this.d = this.a.loadIcon(ad.g(this.b));
    }
    return this.d;
  }
  
  public boolean c()
  {
    switch (g())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void d()
  {
    ad.a(this.a.activityInfo.name);
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.putExtra("android.intent.extra.TITLE", ad.c(this.b).a());
    localIntent.putExtra("android.intent.extra.SUBJECT", ad.c(this.b).a());
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.TEXT", ad.e(this.b));
    Object localObject1 = g.a(2131493794);
    switch (g())
    {
    case 3: 
    case 4: 
    default: 
      localIntent.setComponent(new ComponentName(this.a.activityInfo.applicationInfo.packageName, this.a.activityInfo.name));
      localIntent.addFlags(524288);
      this.b.getContext().startActivity(localIntent);
      return;
    case 5: 
      new m()
      {
        Intent a;
        String b = ad.h(af.this.b) + "<p>Original Page: <a href='" + ad.c(af.this.b).b() + "'>" + ad.c(af.this.b).b() + "</a></p>";
        String c;
        
        protected void a()
        {
          Object localObject1 = Whitelist.none().addTags(new String[] { "a", "abbr", "acronym", "address", "area", "b", "bdo", "big", "blockquote", "br", "caption", "center", "cite", "code", "col", "colgroup", "dd", "del", "dfn", "div", "dl", "dt", "em", "font", "h1", "h2", "h3", "h4", "h5", "h6", "hr", "i", "img", "ins", "kbd", "li", "map", "ol", "p", "pre", "q", "s", "samp", "small", "span", "strike", "strong", "sub", "sup", "table", "tbody", "td", "tfoot", "th", "thead", "title", "tr", "tt", "u", "ul", "var", "xmp" }).addAttributes("a", new String[] { "href" }).addProtocols("a", "href", new String[] { "http", "https" });
          Object localObject2 = new Document.OutputSettings();
          ((Document.OutputSettings)localObject2).escapeMode(Entities.EscapeMode.xhtml);
          ((Document.OutputSettings)localObject2).charset("ASCII");
          this.b = Jsoup.clean(this.b, "", (Whitelist)localObject1, (Document.OutputSettings)localObject2);
          this.c = ad.h(af.this.b);
          localObject1 = new ArrayList();
          localObject2 = ad.i(af.this.b).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            j localj = (j)((Iterator)localObject2).next();
            ((ArrayList)localObject1).add(Uri.fromFile(localj.b));
            this.b = this.b.replaceFirst("IMG_" + localj.a, "<p><en-media type='image/" + localj.c + "' hash='" + localj.a + "'/></p>");
            this.c = this.c.replaceFirst("IMG_" + localj.a, "");
          }
          this.a = i.a(ad.c(af.this.b).a(), this.b, (ArrayList)localObject1, af.this.b.getContext());
        }
        
        protected void a(boolean paramAnonymousBoolean, Throwable paramAnonymousThrowable)
        {
          if (this.a != null)
          {
            af.this.b.getContext().startActivity(this.a);
            return;
          }
          new AlertDialog.Builder(af.this.b.getContext()).setTitle(2131493092).setMessage(2131493091).setPositiveButton(2131492924, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              paramAnonymous2DialogInterface = new Intent("android.intent.action.SEND");
              paramAnonymous2DialogInterface.setPackage("com.evernote");
              paramAnonymous2DialogInterface.putExtra("android.intent.extra.TITLE", ad.c(af.this.b).a());
              paramAnonymous2DialogInterface.putExtra("android.intent.extra.SUBJECT", ad.c(af.this.b).a());
              paramAnonymous2DialogInterface.setType("text/plain");
              paramAnonymous2DialogInterface.putExtra("android.intent.extra.TEXT", ad.c(af.1.this.c + "<p>" + af.this.b.getContext().getString(2131493305) + " <a href='" + ad.c(af.this.b).b() + "'>" + ad.c(af.this.b).b() + "</a></p>")).toString();
              af.this.b.getContext().startActivity(paramAnonymous2DialogInterface);
            }
          }).create().show();
        }
      }.h();
      return;
    case 1: 
      Object localObject2 = ad.e(this.b);
      label237:
      StringBuilder localStringBuilder;
      if (!ad.c(this.b).a().equals(ad.c(this.b).b()))
      {
        str = ad.c(this.b).a();
        if ((localObject2 == ad.c(this.b).b()) || (!h())) {
          break label362;
        }
        localStringBuilder = new StringBuilder();
        if (str == null) {
          break label356;
        }
      }
      label356:
      for (str = str + "<br /><br />";; str = "")
      {
        localIntent.putExtra("android.intent.extra.TEXT", Html.fromHtml(str + "<a href='" + (String)localObject2 + "'>" + ad.c(this.b).b() + "</a><br /><br />" + (String)localObject1));
        break;
        str = null;
        break label237;
      }
      label362:
      localObject2 = new StringBuilder();
      if (str != null) {}
      for (str = str + "\n\n";; str = "")
      {
        localIntent.putExtra("android.intent.extra.TEXT", str + ad.e(this.b) + (String)localObject1);
        break;
      }
    }
    localIntent.putExtra("android.intent.extra.TITLE", "");
    localIntent.putExtra("android.intent.extra.SUBJECT", "");
    localObject1 = new StringBuilder();
    if (!ad.c(this.b).a().equals(ad.c(this.b).b())) {}
    for (String str = ad.c(this.b).a() + " ";; str = "")
    {
      localIntent.putExtra("android.intent.extra.TEXT", str + ad.e(this.b));
      break;
    }
  }
  
  public String e()
  {
    return j();
  }
  
  public boolean f()
  {
    return g() == 5;
  }
  
  public int g()
  {
    if (this.c > 0) {
      return this.c;
    }
    String str1 = k.a(this.a.activityInfo.packageName, "com.", "").toLowerCase();
    String str2 = k.a(this.a.activityInfo.name, "com.", "").toLowerCase();
    String str3 = this.e.toLowerCase();
    if (str1.startsWith("evernote")) {
      this.c = 5;
    }
    for (;;)
    {
      return this.c;
      if ((str1.startsWith("twitter")) || (str2.startsWith("tweetdeck")) || (str1.startsWith("handmark.tweetcaster")) || (str2.startsWith("twidroid.activity.SendTweet")) || (str1.startsWith("levelup.touiteur")) || (str1.startsWith("jv.falcon")) || (str1.startsWith("seesmic"))) {
        this.c = 2;
      } else if (str1.startsWith("facebook")) {
        this.c = 3;
      } else if (str1.startsWith("google.android.apps.plus")) {
        this.c = 4;
      } else if (str1.startsWith("whatsapp")) {
        this.c = 7;
      } else if ((str1.startsWith("google.android.gm")) || (str3.contains("mail"))) {
        this.c = 1;
      } else {
        this.c = 6;
      }
    }
  }
  
  public boolean h()
  {
    Object localObject = new Intent("android.intent.action.SEND");
    ((Intent)localObject).setType("text/html");
    localObject = ad.g(this.b).queryIntentActivities((Intent)localObject, 65536).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
      if (k.a(this.a.activityInfo.name, localResolveInfo.activityInfo.name)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
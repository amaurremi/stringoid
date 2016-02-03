package com.ideashower.readitlater.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.ideashower.readitlater.activity.a.o;
import com.ideashower.readitlater.activity.a.p;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.LabelEditText;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.am;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

public class be
  extends k
{
  private String as;
  private com.ideashower.readitlater.a.a.e at;
  private final Object au = new Object();
  private bh av;
  private final boolean aw = false;
  private am ax;
  
  private int a(com.ideashower.readitlater.a.a.e parame, ArrayList paramArrayList, bh parambh)
  {
    try
    {
      int i = b(parame, paramArrayList, parambh);
      return i;
    }
    catch (UnsupportedEncodingException parame)
    {
      com.ideashower.readitlater.util.e.a(parame);
      return -3;
    }
    catch (URISyntaxException parame)
    {
      com.ideashower.readitlater.util.e.a(parame);
      return -3;
    }
    catch (com.ideashower.readitlater.b.d parame)
    {
      com.ideashower.readitlater.util.e.a(parame);
      return -2;
    }
    catch (Throwable parame)
    {
      com.ideashower.readitlater.util.e.a(parame);
    }
    return -4;
  }
  
  public static be a(String paramString)
  {
    be localbe = new be();
    Bundle localBundle = new Bundle();
    localBundle.putString("host", paramString);
    localbe.g(localBundle);
    return localbe;
  }
  
  private ArrayList a(com.ideashower.readitlater.a.a.e parame)
  {
    Object localObject1 = parame.i();
    parame = parame.j();
    if ((localObject1 == null) || (parame == null)) {
      return null;
    }
    localObject1 = com.ideashower.readitlater.f.a.a(new com.ideashower.readitlater.f.d((String)localObject1, 0), false, true);
    if (localObject1 == null) {
      throw new com.ideashower.readitlater.b.d("Missing Markup");
    }
    localObject1 = ((com.ideashower.readitlater.f.b)localObject1).a();
    if (localObject1 == null) {
      throw new com.ideashower.readitlater.b.d("Missing Markup");
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = parame.getFields();
    parame = null;
    String str;
    if (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = Pattern.compile(((JsonNode)((Map.Entry)localObject2).getValue()).getTextValue(), 2).matcher((CharSequence)localObject1);
      if (!((Matcher)localObject2).find()) {
        break label188;
      }
      parame = ((Matcher)localObject2).group(1);
    }
    label188:
    for (;;)
    {
      if ((str != null) && (parame != null))
      {
        localArrayList.add(new BasicNameValuePair(str, parame));
        break;
        return localArrayList;
      }
      break;
    }
  }
  
  private ArrayList a(com.ideashower.readitlater.a.a.e parame, URI paramURI, ArrayList paramArrayList, bh parambh)
  {
    String str1 = parame.p();
    String str2 = parame.q();
    String str3 = parame.r();
    String str4 = parame.b();
    String str5 = parame.s();
    parame = URLEncodedUtils.parse(paramURI, "UTF-8");
    if (parame == null) {}
    for (parame = new ArrayList();; parame = new ArrayList(parame))
    {
      parame.add(new BasicNameValuePair(str1, parambh.a()));
      parame.add(new BasicNameValuePair(str2, parambh.b()));
      if (str3 != null) {
        parame.add(new BasicNameValuePair(str3, "http://".concat(str4)));
      }
      if (str5 != null) {
        URLEncodedUtils.parse(parame, new Scanner(str5), "UTF-8");
      }
      if (paramArrayList != null) {
        parame.addAll(paramArrayList);
      }
      return parame;
    }
  }
  
  private HttpUriRequest a(URI paramURI, String paramString, ArrayList paramArrayList)
  {
    if (paramString.equals("GET")) {
      return new HttpGet(URIUtils.createURI(paramURI.getScheme(), paramURI.getHost(), paramURI.getPort(), paramURI.getPath(), URLEncodedUtils.format(paramArrayList, "UTF-8"), paramURI.getFragment()));
    }
    paramURI = new HttpPost(paramURI);
    ((HttpPost)paramURI).setEntity(new UrlEncodedFormEntity(paramArrayList, "UTF-8"));
    return paramURI;
  }
  
  public static void a(android.support.v4.app.f paramf, String paramString)
  {
    if (ah() == com.pocket.p.l.a)
    {
      com.pocket.p.k.a(a(paramString), paramf);
      return;
    }
    SubscriptionLoginActivity.b(paramf, paramString);
  }
  
  private void a(bh parambh, int paramInt)
  {
    if (!a(parambh)) {}
    while (parambh.a(-1) > 0) {
      return;
    }
    b(parambh);
  }
  
  private boolean a(bh parambh)
  {
    for (;;)
    {
      synchronized (this.au)
      {
        if ((this.av != null) && (this.av.equals(parambh)))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public static com.pocket.p.l ah()
  {
    if (j.g()) {
      return com.pocket.p.l.a;
    }
    return com.pocket.p.l.b;
  }
  
  private void ai()
  {
    synchronized (this.au)
    {
      this.av = null;
      return;
    }
  }
  
  private boolean aj()
  {
    for (;;)
    {
      synchronized (this.au)
      {
        if (this.av != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private void ak()
  {
    ad();
    ai();
  }
  
  private int b(com.ideashower.readitlater.a.a.e parame, ArrayList paramArrayList, bh parambh)
  {
    boolean bool2 = false;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    boolean bool1;
    if (parame.e() != null)
    {
      this.ax.setTemplate(parame);
      bool2 = this.ax.a(parambh.a(), parambh.b());
      if (bool2) {
        return 2;
      }
    }
    else
    {
      localObject1 = new URI(parame.c());
      paramArrayList = a(parame, (URI)localObject1, paramArrayList, parambh);
      localObject3 = com.ideashower.readitlater.f.a.a(new com.ideashower.readitlater.f.d(a((URI)localObject1, parame.l(), paramArrayList), 0), true, true);
      if (localObject3 == null) {
        return -2;
      }
      localObject2 = parame.m();
      parambh = parame.n();
      localObject1 = parame.o();
      paramArrayList = ((com.ideashower.readitlater.f.b)localObject3).c();
      if (localObject2 != null)
      {
        parambh = ((com.ideashower.readitlater.f.b)localObject3).a();
        if (parambh == null) {
          bool1 = false;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (parame.t()) {
        break;
      }
      com.ideashower.readitlater.a.l.a(parame.c(), paramArrayList);
      bool2 = bool1;
      break;
      bool1 = Pattern.compile((String)localObject2).matcher(parambh).find();
      continue;
      if (parambh != null)
      {
        if (paramArrayList == null)
        {
          bool1 = false;
        }
        else
        {
          localObject2 = paramArrayList.iterator();
          do
          {
            bool1 = bool2;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject3 = (HttpCookie)((Iterator)localObject2).next();
          } while ((!((HttpCookie)localObject3).getName().equals(parambh)) || (!((HttpCookie)localObject3).getValue().matches((String)localObject1)));
          bool1 = true;
        }
      }
      else if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        bool1 = true;
        continue;
        return -1;
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  private void b(bh parambh)
  {
    if ((m() == null) || (m().isFinishing())) {}
    while (!a(parambh)) {
      return;
    }
    ad();
    if (parambh.c())
    {
      Toast.makeText(m(), String.format(m().getString(2131493771), new Object[] { this.as }), 1).show();
      com.ideashower.readitlater.a.a.a.b(this.as);
      P();
    }
    for (;;)
    {
      ai();
      parambh.e();
      return;
      if (parambh.f() == -2) {
        com.ideashower.readitlater.activity.a.b.b(2131493164, 2131493122).a((a)m());
      } else {
        com.ideashower.readitlater.activity.a.b.b(2131493164, 2131493163).a((a)m());
      }
    }
  }
  
  public String K()
  {
    return "subscription_login";
  }
  
  protected void Y()
  {
    this.Z.setTitle(a(2131493721) + " " + this.as);
    this.Y.a(true, false);
    this.ad.setHint("");
    this.ad.setLabel(this.at.d().toUpperCase());
    this.ae.setLabel(d(2131493308));
    this.ae.setHint("");
    this.ag.setVisibility(8);
    this.ab.setText(2131492953);
    this.ab.setVisibility(0);
    this.ab.setIsBrightStyle(true);
    this.ai.setVisibility(0);
    this.ai.setText(String.format(d(2131492885), new Object[] { this.as }));
    this.ai.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        com.ideashower.readitlater.a.g.a(be.this.m(), "http://".concat(be.a(be.this)));
      }
    });
  }
  
  protected void a(com.pocket.c.f paramf) {}
  
  protected boolean a(int paramInt, com.pocket.c.g paramg)
  {
    return false;
  }
  
  protected int ab()
  {
    return 0;
  }
  
  protected int ac()
  {
    return 2131493162;
  }
  
  protected void af()
  {
    synchronized (this.au)
    {
      if (aj()) {
        return;
      }
      if (this.ar != null) {
        return;
      }
    }
    ae();
    this.ar = com.ideashower.readitlater.activity.a.l.a(ac(), null, true);
    this.ar.a((a)m());
    this.ar.a(new p()
    {
      public void a(o paramAnonymouso) {}
      
      public void b(o paramAnonymouso)
      {
        be.b(be.this);
      }
    });
    this.av = new bh(this, this.am, this.an);
    new bg(this, this.av).h();
  }
  
  public void d(Bundle paramBundle)
  {
    this.as = l().getString("host");
    if (this.as == null)
    {
      P();
      return;
    }
    this.at = com.ideashower.readitlater.a.a.a.c().a(this.as);
    if (this.at == null)
    {
      P();
      return;
    }
    super.d(paramBundle);
  }
  
  public void w()
  {
    super.w();
  }
  
  public void x()
  {
    super.x();
    ak();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
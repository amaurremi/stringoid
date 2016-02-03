package com.flurry.android.monolithic.sdk.impl;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v6.AdSpaceLayout;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressLint({"SetJavaScriptEnabled"})
public class o
  extends ac
  implements DialogInterface.OnKeyListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, ci
{
  private AlertDialog A;
  private List<AdFrame> B;
  private boolean C;
  private Map<String, AdUnit> D;
  private Map<String, m> E;
  private FlurryAdModule F;
  private ExecutorService G;
  private List<String> H;
  String a = null;
  private final String f = getClass().getSimpleName();
  private final String g = "mraid.js";
  private ProgressDialog h;
  private cf i;
  private n j;
  private boolean k;
  private WebView l;
  private boolean m;
  private WebViewClient n;
  private WebChromeClient o;
  private View p;
  private int q;
  private WebChromeClient.CustomViewCallback r;
  private Dialog s;
  private FrameLayout t;
  private int u;
  private Dialog v;
  private FrameLayout w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  public o(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit, int paramInt)
  {
    super(paramContext, paramFlurryAdModule, paramm);
    setClickable(true);
    this.d = paramAdUnit;
    this.e = paramInt;
    this.c = paramm;
    this.G = Executors.newSingleThreadExecutor();
    if (this.d != null)
    {
      this.B = this.d.d();
      if (this.d.e().intValue() == 1) {}
      for (;;)
      {
        this.C = bool;
        if (this.C)
        {
          this.E = new HashMap();
          this.D = new HashMap();
          this.E.put(paramm.b(), paramm);
          this.D.put(((AdFrame)paramAdUnit.d().get(0)).g().toString(), paramAdUnit);
        }
        this.F = paramFlurryAdModule;
        setAdUnit(this.d);
        setAdLog(this.c);
        this.H = new LinkedList();
        return;
        bool = false;
      }
    }
    ja.a(3, this.f, "adunit is Null");
  }
  
  private String a(List<AdUnit> paramList, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("'{\"adComponents\":[");
    paramString = this.l.getUrl();
    String str1 = cp.a(paramString);
    String str2 = cp.a(str1, paramString);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramString = ((AdFrame)((AdUnit)localIterator.next()).d().get(0)).d().toString();
      paramList = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        paramList = paramString;
        if (!TextUtils.isEmpty(str2))
        {
          paramList = paramString;
          if (str2 != str1) {
            paramList = paramString.replace(str1, str2);
          }
        }
      }
      localStringBuilder.append(je.e(paramList));
      if (localIterator.hasNext()) {
        localStringBuilder.append(",");
      }
    }
    localStringBuilder.append("]}'");
    return localStringBuilder.toString();
  }
  
  private List<AdUnit> a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = this.F.b().a(this.d.b().toString(), paramInt1, paramInt2);
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext())
    {
      AdUnit localAdUnit = (AdUnit)localIterator.next();
      if (localAdUnit.d().size() > 0) {
        this.D.put(((AdFrame)localAdUnit.d().get(0)).g().toString(), localAdUnit);
      }
    }
    return paramString;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (!(getContext() instanceof Activity)) {
      ja.a(3, this.f, "no activity present");
    }
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)getContext();
    } while (this.v != null);
    ja.a(3, this.f, "expand(" + paramInt1 + "," + paramInt2 + ")");
    if ((this.l != null) && (-1 != indexOfChild(this.l))) {
      removeView(this.l);
    }
    this.u = localActivity.getRequestedOrientation();
    if (this.w == null)
    {
      this.w = new FrameLayout(localActivity);
      this.w.setBackgroundColor(-16777216);
      if ((this.l != null) && (this.l.getParent() == null)) {
        this.w.addView(this.l, new FrameLayout.LayoutParams(-1, -1, 17));
      }
    }
    if (this.v == null)
    {
      this.v = new Dialog(localActivity, 16973834);
      cq.a(this.v.getWindow());
      this.v.setContentView(this.w, new ViewGroup.LayoutParams(-1, -1));
      this.v.setOnDismissListener(new v(this));
      this.v.setCancelable(true);
      this.v.show();
    }
    j.a(localActivity, j.a(), true);
    this.b.a(localActivity, this.d.b().toString());
  }
  
  private void a(i parami)
  {
    if ((this.H.contains(parami.c.a)) && (this.l != null))
    {
      this.l.loadUrl("javascript:flurryadapter.callComplete('" + parami.c.a + "');");
      this.H.remove(parami.c.a);
    }
  }
  
  private void a(i parami, int paramInt)
  {
    Object localObject;
    if (!this.C) {
      if ((paramInt != this.e) && (paramInt < this.B.size()))
      {
        localObject = (AdFrame)this.d.d().get(paramInt);
        parami = getCurrentFormat();
        localObject = ((AdFrame)localObject).e().e().toString();
        if (((String)localObject).equals(parami)) {
          break label154;
        }
        if (((String)localObject).equals("takeover"))
        {
          this.F.b(this.c);
          this.F.a(this.d);
          parami = new Intent(ia.a().b(), FlurryFullscreenTakeoverActivity.class);
          parami.putExtra("frameIndex", paramInt);
          this.F.a().a(getContext(), parami, this.d.b().toString());
        }
      }
    }
    label154:
    do
    {
      return;
      this.e = paramInt;
      initLayout();
      return;
      localObject = (String)parami.c.b.get("guid");
    } while (localObject == null);
    this.d = c((String)localObject);
    this.B = this.d.d();
    this.c = parami.c.e;
    if (d())
    {
      this.F.a(this.d);
      this.F.b(this.c);
    }
    this.e = paramInt;
    this.C = false;
    initLayout();
  }
  
  private void a(String paramString)
  {
    paramString = new p(this, paramString);
    this.G.submit(paramString);
  }
  
  private m b(String paramString)
  {
    if (this.E == null) {
      localObject = null;
    }
    m localm;
    do
    {
      return (m)localObject;
      localm = (m)this.E.get(paramString);
      localObject = localm;
    } while (localm != null);
    Object localObject = ab.a(this.F, paramString);
    this.E.put(paramString, localObject);
    return (m)localObject;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (!(getContext() instanceof Activity)) {
      ja.a(3, this.f, "no activity present");
    }
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)getContext();
    } while (this.v == null);
    ja.a(3, this.f, "collapse(" + paramInt1 + "," + paramInt2 + ")");
    if ((this.v != null) && (this.v.isShowing()))
    {
      this.v.hide();
      this.v.setOnDismissListener(null);
      this.v.dismiss();
    }
    this.v = null;
    j.a(localActivity, this.u);
    if (this.w != null)
    {
      if ((this.l != null) && (-1 != this.w.indexOfChild(this.l))) {
        this.w.removeView(this.l);
      }
      this.w = null;
    }
    if ((this.l != null) && (this.l.getParent() == null)) {
      addView(this.l);
    }
    this.b.b(localActivity, this.d.b().toString());
  }
  
  private AdUnit c(String paramString)
  {
    if (this.D == null) {
      return null;
    }
    return (AdUnit)this.D.get(paramString);
  }
  
  private boolean f()
  {
    try
    {
      boolean bool = this.m;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void g()
  {
    try
    {
      if (!f())
      {
        i();
        setFlurryJsEnvInitialized(true);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void h()
  {
    try
    {
      setFlurryJsEnvInitialized(false);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void i()
  {
    ja.a(3, this.f, "initializeFlurryJsEnv");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:(function() {");
    localStringBuilder.append("var Hogan={};(function(Hogan,useArrayBuffer){Hogan.Template=function(renderFunc,text,compiler,options){this.r=renderFunc||this.r;this.c=compiler;this.options=options;this.text=text||\"\";this.buf=useArrayBuffer?[]:\"\"};Hogan.Template.prototype={r:function(context,partials,indent){return\"\"},v:hoganEscape,t:coerceToString,render:function render(context,partials,indent){return this.ri([context],partials||{},indent)},ri:function(context,partials,indent){return this.r(context,partials,indent)},rp:function(name,context,partials,indent){var partial=partials[name];if(!partial)return\"\";if(this.c&&typeof partial==\"string\")partial=this.c.compile(partial,this.options);return partial.ri(context,partials,indent)},rs:function(context,partials,section){var tail=context[context.length-1];if(!isArray(tail)){section(context,partials,this);return}for(var i=0;i<tail.length;i++){context.push(tail[i]);section(context,partials,this);context.pop()}},s:function(val,ctx,partials,inverted,start,end,tags){var pass;if(isArray(val)&&val.length===0)return false;if(typeof val==\"function\")val=this.ls(val,ctx,partials,inverted,start,end,tags);pass=val===\"\"||!!val;if(!inverted&&pass&&ctx)ctx.push(typeof val==\"object\"?val:ctx[ctx.length-1]);return pass},d:function(key,ctx,partials,returnFound){var names=key.split(\".\"),val=this.f(names[0],ctx,partials,returnFound),cx=null;if(key===\".\"&&isArray(ctx[ctx.length-2]))return ctx[ctx.length-1];for(var i=1;i<names.length;i++)if(val&&typeof val==\"object\"&&names[i]in val){cx=val;val=val[names[i]]}else val=\"\";if(returnFound&&!val)return false;if(!returnFound&&typeof val==\"function\"){ctx.push(cx);val=this.lv(val,ctx,partials);ctx.pop()}return val},f:function(key,ctx,partials,returnFound){var val=false,v=null,found=false;for(var i=ctx.length-1;i>=0;i--){v=ctx[i];if(v&&typeof v==\"object\"&&key in v){val=v[key];found=true;break}}if(!found)return returnFound?false:\"\";if(!returnFound&&typeof val==\"function\")val=this.lv(val,ctx,partials);return val},ho:function(val,cx,partials,text,tags){var compiler=this.c;var options=this.options;options.delimiters=tags;var t=val.call(cx,text,function(t){return compiler.compile(t,options).render(cx,partials)});this.b(compiler.compile(t.toString(),options).render(cx,partials));return false},b:useArrayBuffer?function(s){this.buf.push(s)}:function(s){this.buf+=s},fl:useArrayBuffer?function(){var r=this.buf.join(\"\");this.buf=[];return r}:function(){var r=this.buf;this.buf=\"\";return r},ls:function(val,ctx,partials,inverted,start,end,tags){var cx=ctx[ctx.length-1],t=null;if(!inverted&&this.c&&val.length>0)return this.ho(val,cx,partials,this.text.substring(start,end),tags);t=val.call(cx);if(typeof t==\"function\")if(inverted)return true;else if(this.c)return this.ho(t,cx,partials,this.text.substring(start,end),tags);return t},lv:function(val,ctx,partials){var cx=ctx[ctx.length-1];var result=val.call(cx);if(typeof result==\"function\")result=result.call(cx);result=coerceToString(result);if(this.c&&~result.indexOf(\"{{\"))return this.c.compile(result,this.options).render(cx,partials);return result}};var rAmp=/&/g,rLt=/</g,rGt=/>/g,rApos=/\\'/g,rQuot=/\\\"/g,hChars=/[&<>\\\"\\']/;function coerceToString(val){return String(val===null||val===undefined?\"\":val)}function hoganEscape(str){str=coerceToString(str);return hChars.test(str)?str.replace(rAmp,\"&amp;\").replace(rLt,\"&lt;\").replace(rGt,\"&gt;\").replace(rApos,\"&#39;\").replace(rQuot,\"&quot;\"):str}var isArray=Array.isArray||function(a){return Object.prototype.toString.call(a)===\"[object Array]\"}})(typeof exports!==\"undefined\"?exports:Hogan);(function(Hogan){var rIsWhitespace=/\\S/,rQuot=/\\\"/g,rNewline=/\\n/g,rCr=/\\r/g,rSlash=/\\\\/g,tagTypes={\"#\":1,\"^\":2,\"/\":3,\"!\":4,\">\":5,\"<\":6,\"=\":7,\"_v\":8,\"{\":9,\"&\":10};Hogan.scan=function scan(text,delimiters){var len=text.length,IN_TEXT=0,IN_TAG_TYPE=1,IN_TAG=2,state=IN_TEXT,tagType=null,tag=null,buf=\"\",tokens=[],seenTag=false,i=0,lineStart=0,otag=\"{{\",ctag=\"}}\";function addBuf(){if(buf.length>0){tokens.push(new String(buf));buf=\"\"}}function lineIsWhitespace(){var isAllWhitespace=true;for(var j=lineStart;j<tokens.length;j++){isAllWhitespace=tokens[j].tag&&tagTypes[tokens[j].tag]<tagTypes[\"_v\"]||!tokens[j].tag&&tokens[j].match(rIsWhitespace)===null;if(!isAllWhitespace)return false}return isAllWhitespace}function filterLine(haveSeenTag,noNewLine){addBuf();if(haveSeenTag&&lineIsWhitespace())for(var j=lineStart,next;j<tokens.length;j++){if(!tokens[j].tag){if((next=tokens[j+1])&&next.tag==\">\")next.indent=tokens[j].toString();tokens.splice(j,1)}}else if(!noNewLine)tokens.push({tag:\"\\n\"});seenTag=false;lineStart=tokens.length}function changeDelimiters(text,index){var close=\"=\"+ctag,closeIndex=text.indexOf(close,index),delimiters=trim(text.substring(text.indexOf(\"=\",index)+1,closeIndex)).split(\" \");otag=delimiters[0];ctag=delimiters[1];return closeIndex+close.length-1}if(delimiters){delimiters=delimiters.split(\" \");otag=delimiters[0];ctag=delimiters[1]}for(i=0;i<len;i++)if(state==IN_TEXT)if(tagChange(otag,text,i)){--i;addBuf();state=IN_TAG_TYPE}else if(text.charAt(i)==\"\\n\")filterLine(seenTag);else buf+=text.charAt(i);else if(state==IN_TAG_TYPE){i+=otag.length-1;tag=tagTypes[text.charAt(i+1)];tagType=tag?text.charAt(i+1):\"_v\";if(tagType==\"=\"){i=changeDelimiters(text,i);state=IN_TEXT}else{if(tag)i++;state=IN_TAG}seenTag=i}else if(tagChange(ctag,text,i)){tokens.push({tag:tagType,n:trim(buf),otag:otag,ctag:ctag,i:tagType==\"/\"?seenTag-ctag.length:i+otag.length});buf=\"\";i+=ctag.length-1;state=IN_TEXT;if(tagType==\"{\")if(ctag==\"}}\")i++;else cleanTripleStache(tokens[tokens.length-1])}else buf+=text.charAt(i);filterLine(seenTag,true);return tokens};function cleanTripleStache(token){if(token.n.substr(token.n.length-1)===\"}\")token.n=token.n.substring(0,token.n.length-1)}function trim(s){if(s.trim)return s.trim();return s.replace(/^\\s*|\\s*$/g,\"\")}function tagChange(tag,text,index){if(text.charAt(index)!=tag.charAt(0))return false;for(var i=1,l=tag.length;i<l;i++)if(text.charAt(index+i)!=tag.charAt(i))return false;return true}function buildTree(tokens,kind,stack,customTags){var instructions=[],opener=null,token=null;while(tokens.length>0){token=tokens.shift();if(token.tag==\"#\"||token.tag==\"^\"||isOpener(token,customTags)){stack.push(token);token.nodes=buildTree(tokens,token.tag,stack,customTags);instructions.push(token)}else if(token.tag==\"/\"){if(stack.length===0)throw new Error(\"Closing tag without opener: /\"+token.n);opener=stack.pop();if(token.n!=opener.n&&!isCloser(token.n,opener.n,customTags))throw new Error(\"Nesting error: \"+opener.n+\" vs. \"+token.n);opener.end=token.i;return instructions}else instructions.push(token)}if(stack.length>0)throw new Error(\"missing closing tag: \"+stack.pop().n);return instructions}function isOpener(token,tags){for(var i=0,l=tags.length;i<l;i++)if(tags[i].o==token.n){token.tag=\"#\";return true}}function isCloser(close,open,tags){for(var i=0,l=tags.length;i<l;i++)if(tags[i].c==close&&tags[i].o==open)return true}function writeCode(tree){return'var _=this;_.b(i=i||\"\");'+walk(tree)+\"return _.fl();\"}Hogan.generate=function(code,text,options){if(options.asString)return\"function(c,p,i){\"+code+\";}\";return new Hogan.Template(new Function(\"c\",\"p\",\"i\",code),text,Hogan,options)};function esc(s){return s.replace(rSlash,\"\\\\\\\\\").replace(rQuot,'\\\\\"').replace(rNewline,\"\\\\n\").replace(rCr,\"\\\\r\")}function chooseMethod(s){return~s.indexOf(\".\")?\"d\":\"f\"}function walk(tree){var code=\"\";for(var i=0,l=tree.length;i<l;i++){var tag=tree[i].tag;if(tag==\"#\")code+=section(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n),tree[i].i,tree[i].end,tree[i].otag+\" \"+tree[i].ctag);else if(tag==\"^\")code+=invertedSection(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n));else if(tag==\"<\"||tag==\">\")code+=partial(tree[i]);else if(tag==\"{\"||tag==\"&\")code+=tripleStache(tree[i].n,chooseMethod(tree[i].n));else if(tag==\"\\n\")code+=text('\"\\\\n\"'+(tree.length-1==i?\"\":\" + i\"));else if(tag==\"_v\")code+=variable(tree[i].n,chooseMethod(tree[i].n));else if(tag===undefined)code+=text('\"'+esc(tree[i])+'\"')}return code}function section(nodes,id,method,start,end,tags){return\"if(_.s(_.\"+method+'(\"'+esc(id)+'\",c,p,1),'+\"c,p,0,\"+start+\",\"+end+',\"'+tags+'\")){'+\"_.rs(c,p,\"+\"function(c,p,_){\"+walk(nodes)+\"});c.pop();}\"}function invertedSection(nodes,id,method){return\"if(!_.s(_.\"+method+'(\"'+esc(id)+'\",c,p,1),c,p,1,0,0,\"\")){'+walk(nodes)+\"};\"}function partial(tok){return'_.b(_.rp(\"'+esc(tok.n)+'\",c,p,\"'+(tok.indent||\"\")+'\"));'}function tripleStache(id,method){return\"_.b(_.t(_.\"+method+'(\"'+esc(id)+'\",c,p,0)));'}function variable(id,method){return\"_.b(_.v(_.\"+method+'(\"'+esc(id)+'\",c,p,0)));'}function text(id){return\"_.b(\"+id+\");\"}Hogan.parse=function(tokens,text,options){options=options||{};return buildTree(tokens,\"\",[],options.sectionTags||[])},Hogan.cache={};Hogan.compile=function(text,options){options=options||{};var key=text+\"||\"+!!options.asString;var t=this.cache[key];if(t)return t;t=this.generate(writeCode(this.parse(this.scan(text,options.delimiters),text,options)),text,options);return this.cache[key]=t}})(typeof exports!==\"undefined\"?exports:Hogan);");
    localStringBuilder.append("var flurryBridgeCtor=function(w){var flurryadapter={};flurryadapter.flurryCallQueue=[];flurryadapter.flurryCallInProgress=false;flurryadapter.callComplete=function(cmd){if(this.flurryCallQueue.length==0){this.flurryCallInProgress=false;return}var adapterCall=this.flurryCallQueue.splice(0,1)[0];this.executeNativeCall(adapterCall);return\"OK\"};flurryadapter.executeCall=function(command){var adapterCall=\"flurry://flurrycall?event=\"+command;var value;for(var i=1;i<arguments.length;i+=2){value=arguments[i+1];if(value==null)continue;adapterCall+=\"&\"+arguments[i]+\"=\"+escape(value)}if(this.flurryCallInProgress)this.flurryCallQueue.push(adapterCall);else this.executeNativeCall(adapterCall)};flurryadapter.executeNativeCall=function(adapterCall){if(adapterCall.length==0)return;this.flurryCallInProgress=true;w.location=adapterCall};return flurryadapter};");
    localStringBuilder.append("window.Hogan=Hogan;window.flurryadapter=flurryBridgeCtor(window);");
    localStringBuilder.append("window.flurryAdapterAvailable=true;if(typeof window.FlurryAdapterReady === 'function'){window.FlurryAdapterReady();}");
    localStringBuilder.append("})();");
    if (this.l != null) {
      this.l.loadUrl(localStringBuilder.toString());
    }
  }
  
  private void j()
  {
    ja.a(3, this.f, "activateFlurryJsEnv");
    Object localObject2 = getCurrentContent();
    if ((!this.C) && (localObject2 != null) && (((String)localObject2).length() > 0) && (!((String)localObject2).equals("{}")))
    {
      Object localObject1 = this.l.getUrl();
      String str1 = cp.a((String)localObject1);
      String str2 = cp.a(str1, (String)localObject1);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str2))
      {
        localObject1 = localObject2;
        if (str2 != str1)
        {
          ja.a(3, this.f, "content before {{mustached}} tags replacement = '" + (String)localObject2 + "'");
          localObject1 = ((String)localObject2).replace(str1, str2);
          ja.a(3, this.f, "content after {{mustached}} tags replacement = '" + (String)localObject1 + "'");
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("javascript:");
      ((StringBuilder)localObject2).append("(function(){");
      ((StringBuilder)localObject2).append("if(!window.Hogan){var Hogan={};(function(Hogan,useArrayBuffer){Hogan.Template=function(renderFunc,text,compiler,options){this.r=renderFunc||this.r;this.c=compiler;this.options=options;this.text=text||\"\";this.buf=useArrayBuffer?[]:\"\"};Hogan.Template.prototype={r:function(context,partials,indent){return\"\"},v:hoganEscape,t:coerceToString,render:function render(context,partials,indent){return this.ri([context],partials||{},indent)},ri:function(context,partials,indent){return this.r(context,partials,indent)},rp:function(name,context,partials,indent){var partial=partials[name];if(!partial)return\"\";if(this.c&&typeof partial==\"string\")partial=this.c.compile(partial,this.options);return partial.ri(context,partials,indent)},rs:function(context,partials,section){var tail=context[context.length-1];if(!isArray(tail)){section(context,partials,this);return}for(var i=0;i<tail.length;i++){context.push(tail[i]);section(context,partials,this);context.pop()}},s:function(val,ctx,partials,inverted,start,end,tags){var pass;if(isArray(val)&&val.length===0)return false;if(typeof val==\"function\")val=this.ls(val,ctx,partials,inverted,start,end,tags);pass=val===\"\"||!!val;if(!inverted&&pass&&ctx)ctx.push(typeof val==\"object\"?val:ctx[ctx.length-1]);return pass},d:function(key,ctx,partials,returnFound){var names=key.split(\".\"),val=this.f(names[0],ctx,partials,returnFound),cx=null;if(key===\".\"&&isArray(ctx[ctx.length-2]))return ctx[ctx.length-1];for(var i=1;i<names.length;i++)if(val&&typeof val==\"object\"&&names[i]in val){cx=val;val=val[names[i]]}else val=\"\";if(returnFound&&!val)return false;if(!returnFound&&typeof val==\"function\"){ctx.push(cx);val=this.lv(val,ctx,partials);ctx.pop()}return val},f:function(key,ctx,partials,returnFound){var val=false,v=null,found=false;for(var i=ctx.length-1;i>=0;i--){v=ctx[i];if(v&&typeof v==\"object\"&&key in v){val=v[key];found=true;break}}if(!found)return returnFound?false:\"\";if(!returnFound&&typeof val==\"function\")val=this.lv(val,ctx,partials);return val},ho:function(val,cx,partials,text,tags){var compiler=this.c;var options=this.options;options.delimiters=tags;var t=val.call(cx,text,function(t){return compiler.compile(t,options).render(cx,partials)});this.b(compiler.compile(t.toString(),options).render(cx,partials));return false},b:useArrayBuffer?function(s){this.buf.push(s)}:function(s){this.buf+=s},fl:useArrayBuffer?function(){var r=this.buf.join(\"\");this.buf=[];return r}:function(){var r=this.buf;this.buf=\"\";return r},ls:function(val,ctx,partials,inverted,start,end,tags){var cx=ctx[ctx.length-1],t=null;if(!inverted&&this.c&&val.length>0)return this.ho(val,cx,partials,this.text.substring(start,end),tags);t=val.call(cx);if(typeof t==\"function\")if(inverted)return true;else if(this.c)return this.ho(t,cx,partials,this.text.substring(start,end),tags);return t},lv:function(val,ctx,partials){var cx=ctx[ctx.length-1];var result=val.call(cx);if(typeof result==\"function\")result=result.call(cx);result=coerceToString(result);if(this.c&&~result.indexOf(\"{{\"))return this.c.compile(result,this.options).render(cx,partials);return result}};var rAmp=/&/g,rLt=/</g,rGt=/>/g,rApos=/\\'/g,rQuot=/\\\"/g,hChars=/[&<>\\\"\\']/;function coerceToString(val){return String(val===null||val===undefined?\"\":val)}function hoganEscape(str){str=coerceToString(str);return hChars.test(str)?str.replace(rAmp,\"&amp;\").replace(rLt,\"&lt;\").replace(rGt,\"&gt;\").replace(rApos,\"&#39;\").replace(rQuot,\"&quot;\"):str}var isArray=Array.isArray||function(a){return Object.prototype.toString.call(a)===\"[object Array]\"}})(typeof exports!==\"undefined\"?exports:Hogan);(function(Hogan){var rIsWhitespace=/\\S/,rQuot=/\\\"/g,rNewline=/\\n/g,rCr=/\\r/g,rSlash=/\\\\/g,tagTypes={\"#\":1,\"^\":2,\"/\":3,\"!\":4,\">\":5,\"<\":6,\"=\":7,\"_v\":8,\"{\":9,\"&\":10};Hogan.scan=function scan(text,delimiters){var len=text.length,IN_TEXT=0,IN_TAG_TYPE=1,IN_TAG=2,state=IN_TEXT,tagType=null,tag=null,buf=\"\",tokens=[],seenTag=false,i=0,lineStart=0,otag=\"{{\",ctag=\"}}\";function addBuf(){if(buf.length>0){tokens.push(new String(buf));buf=\"\"}}function lineIsWhitespace(){var isAllWhitespace=true;for(var j=lineStart;j<tokens.length;j++){isAllWhitespace=tokens[j].tag&&tagTypes[tokens[j].tag]<tagTypes[\"_v\"]||!tokens[j].tag&&tokens[j].match(rIsWhitespace)===null;if(!isAllWhitespace)return false}return isAllWhitespace}function filterLine(haveSeenTag,noNewLine){addBuf();if(haveSeenTag&&lineIsWhitespace())for(var j=lineStart,next;j<tokens.length;j++){if(!tokens[j].tag){if((next=tokens[j+1])&&next.tag==\">\")next.indent=tokens[j].toString();tokens.splice(j,1)}}else if(!noNewLine)tokens.push({tag:\"\\n\"});seenTag=false;lineStart=tokens.length}function changeDelimiters(text,index){var close=\"=\"+ctag,closeIndex=text.indexOf(close,index),delimiters=trim(text.substring(text.indexOf(\"=\",index)+1,closeIndex)).split(\" \");otag=delimiters[0];ctag=delimiters[1];return closeIndex+close.length-1}if(delimiters){delimiters=delimiters.split(\" \");otag=delimiters[0];ctag=delimiters[1]}for(i=0;i<len;i++)if(state==IN_TEXT)if(tagChange(otag,text,i)){--i;addBuf();state=IN_TAG_TYPE}else if(text.charAt(i)==\"\\n\")filterLine(seenTag);else buf+=text.charAt(i);else if(state==IN_TAG_TYPE){i+=otag.length-1;tag=tagTypes[text.charAt(i+1)];tagType=tag?text.charAt(i+1):\"_v\";if(tagType==\"=\"){i=changeDelimiters(text,i);state=IN_TEXT}else{if(tag)i++;state=IN_TAG}seenTag=i}else if(tagChange(ctag,text,i)){tokens.push({tag:tagType,n:trim(buf),otag:otag,ctag:ctag,i:tagType==\"/\"?seenTag-ctag.length:i+otag.length});buf=\"\";i+=ctag.length-1;state=IN_TEXT;if(tagType==\"{\")if(ctag==\"}}\")i++;else cleanTripleStache(tokens[tokens.length-1])}else buf+=text.charAt(i);filterLine(seenTag,true);return tokens};function cleanTripleStache(token){if(token.n.substr(token.n.length-1)===\"}\")token.n=token.n.substring(0,token.n.length-1)}function trim(s){if(s.trim)return s.trim();return s.replace(/^\\s*|\\s*$/g,\"\")}function tagChange(tag,text,index){if(text.charAt(index)!=tag.charAt(0))return false;for(var i=1,l=tag.length;i<l;i++)if(text.charAt(index+i)!=tag.charAt(i))return false;return true}function buildTree(tokens,kind,stack,customTags){var instructions=[],opener=null,token=null;while(tokens.length>0){token=tokens.shift();if(token.tag==\"#\"||token.tag==\"^\"||isOpener(token,customTags)){stack.push(token);token.nodes=buildTree(tokens,token.tag,stack,customTags);instructions.push(token)}else if(token.tag==\"/\"){if(stack.length===0)throw new Error(\"Closing tag without opener: /\"+token.n);opener=stack.pop();if(token.n!=opener.n&&!isCloser(token.n,opener.n,customTags))throw new Error(\"Nesting error: \"+opener.n+\" vs. \"+token.n);opener.end=token.i;return instructions}else instructions.push(token)}if(stack.length>0)throw new Error(\"missing closing tag: \"+stack.pop().n);return instructions}function isOpener(token,tags){for(var i=0,l=tags.length;i<l;i++)if(tags[i].o==token.n){token.tag=\"#\";return true}}function isCloser(close,open,tags){for(var i=0,l=tags.length;i<l;i++)if(tags[i].c==close&&tags[i].o==open)return true}function writeCode(tree){return'var _=this;_.b(i=i||\"\");'+walk(tree)+\"return _.fl();\"}Hogan.generate=function(code,text,options){if(options.asString)return\"function(c,p,i){\"+code+\";}\";return new Hogan.Template(new Function(\"c\",\"p\",\"i\",code),text,Hogan,options)};function esc(s){return s.replace(rSlash,\"\\\\\\\\\").replace(rQuot,'\\\\\"').replace(rNewline,\"\\\\n\").replace(rCr,\"\\\\r\")}function chooseMethod(s){return~s.indexOf(\".\")?\"d\":\"f\"}function walk(tree){var code=\"\";for(var i=0,l=tree.length;i<l;i++){var tag=tree[i].tag;if(tag==\"#\")code+=section(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n),tree[i].i,tree[i].end,tree[i].otag+\" \"+tree[i].ctag);else if(tag==\"^\")code+=invertedSection(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n));else if(tag==\"<\"||tag==\">\")code+=partial(tree[i]);else if(tag==\"{\"||tag==\"&\")code+=tripleStache(tree[i].n,chooseMethod(tree[i].n));else if(tag==\"\\n\")code+=text('\"\\\\n\"'+(tree.length-1==i?\"\":\" + i\"));else if(tag==\"_v\")code+=variable(tree[i].n,chooseMethod(tree[i].n));else if(tag===undefined)code+=text('\"'+esc(tree[i])+'\"')}return code}function section(nodes,id,method,start,end,tags){return\"if(_.s(_.\"+method+'(\"'+esc(id)+'\",c,p,1),'+\"c,p,0,\"+start+\",\"+end+',\"'+tags+'\")){'+\"_.rs(c,p,\"+\"function(c,p,_){\"+walk(nodes)+\"});c.pop();}\"}function invertedSection(nodes,id,method){return\"if(!_.s(_.\"+method+'(\"'+esc(id)+'\",c,p,1),c,p,1,0,0,\"\")){'+walk(nodes)+\"};\"}function partial(tok){return'_.b(_.rp(\"'+esc(tok.n)+'\",c,p,\"'+(tok.indent||\"\")+'\"));'}function tripleStache(id,method){return\"_.b(_.t(_.\"+method+'(\"'+esc(id)+'\",c,p,0)));'}function variable(id,method){return\"_.b(_.v(_.\"+method+'(\"'+esc(id)+'\",c,p,0)));'}function text(id){return\"_.b(\"+id+\");\"}Hogan.parse=function(tokens,text,options){options=options||{};return buildTree(tokens,\"\",[],options.sectionTags||[])},Hogan.cache={};Hogan.compile=function(text,options){options=options||{};var key=text+\"||\"+!!options.asString;var t=this.cache[key];if(t)return t;t=this.generate(writeCode(this.parse(this.scan(text,options.delimiters),text,options)),text,options);return this.cache[key]=t}})(typeof exports!==\"undefined\"?exports:Hogan);window.Hogan=Hogan;}");
      ((StringBuilder)localObject2).append("if(!window.flurryadapter){var flurryBridgeCtor=function(w){var flurryadapter={};flurryadapter.flurryCallQueue=[];flurryadapter.flurryCallInProgress=false;flurryadapter.callComplete=function(cmd){if(this.flurryCallQueue.length==0){this.flurryCallInProgress=false;return}var adapterCall=this.flurryCallQueue.splice(0,1)[0];this.executeNativeCall(adapterCall);return\"OK\"};flurryadapter.executeCall=function(command){var adapterCall=\"flurry://flurrycall?event=\"+command;var value;for(var i=1;i<arguments.length;i+=2){value=arguments[i+1];if(value==null)continue;adapterCall+=\"&\"+arguments[i]+\"=\"+escape(value)}if(this.flurryCallInProgress)this.flurryCallQueue.push(adapterCall);else this.executeNativeCall(adapterCall)};flurryadapter.executeNativeCall=function(adapterCall){if(adapterCall.length==0)return;this.flurryCallInProgress=true;w.location=adapterCall};return flurryadapter};window.flurryadapter=flurryBridgeCtor(window);}");
      ((StringBuilder)localObject2).append("if(!window.flurryAdapterAvailable){window.flurryAdapterAvailable=true;if(typeof window.FlurryAdapterReady === 'function'){window.FlurryAdapterReady();} }");
      localObject1 = je.e((String)localObject1);
      ((StringBuilder)localObject2).append("var content='");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("';var compiled=window.Hogan.compile(document.body.innerHTML);var rendered=compiled.render(JSON.parse(content));document.body.innerHTML=rendered;");
      ((StringBuilder)localObject2).append("})();");
      if (this.l != null) {
        this.l.loadUrl(((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private boolean k()
  {
    try
    {
      boolean bool = this.z;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void l()
  {
    try
    {
      if (!k())
      {
        n();
        setMraidJsEnvInitialized(true);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void m()
  {
    try
    {
      setMraidJsEnvInitialized(false);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void n()
  {
    ja.a(3, this.f, "initializeMraid");
    if (d()) {}
    for (String str = "interstitial";; str = "inline")
    {
      str = "{useCustomClose:" + false + ",isModal:" + false + ",width:undefined,height:undefined,placementType:\"" + str + "\"}";
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:(function() {");
      localStringBuilder.append("var mraidCtor=function(flurryBridge,initState){var mraid={};var STATES=mraid.STATES={LOADING:\"loading\",UNKNOWN:\"unknown\",DEFAULT:\"default\",EXPANDED:\"expanded\",HIDDEN:\"hidden\"};var EVENTS=mraid.EVENTS={ASSETREADY:\"assetReady\",ASSETREMOVED:\"assetRemoved\",ASSETRETIRED:\"assetRetired\",INFO:\"info\",ERROR:\"error\",ORIENTATIONCHANGE:\"orientationChange\",READY:\"ready\",STATECHANGE:\"stateChange\",VIEWABLECHANGE:\"viewableChange\"};var listeners={};var currentState=STATES.LOADING;var expandProperties={width:initState.width,height:initState.height,isModal:initState.isModal,useCustomClose:false};var collapseProperties={};var placementType=initState.placementType;var disable=false;var closeId=\"flurry-mraid-default-close\";var imgUrl=\"http://flurry.cachefly.net/adSpaceStyles/images/bttn-close-bw.png\";var safeClose=function(){try{if(window.mraid)window.mraid.close();else if(window.flurryadapter)flurryadapter.executeCall(\"adWillClose\");else console.log(\"unable to close\")}catch(error){console.log(\"unable to close: \"+error)}};var makeDefaultClose=function(){var img=document.createElement(\"img\");img.src=imgUrl;img.id=closeId;img.style.position=\"absolute\";img.style.top=\"10px\";img.style.right=\"10px\";img.style.width=\"50px\";img.style.height=\"50px\";img.style.zIndex=1E4;return img};var updateDefaultClose=function(){if(!expandProperties.useCustomClose&&(placementType===\"interstitial\"||currentState===STATES.EXPANDED))addDefaultClose();else removeDefaultClose()};var addDefaultClose=function(){var closeButton=document.getElementById(closeId);if(!closeButton){closeButton=makeDefaultClose();document.body.appendChild(closeButton)}};var removeDefaultClose=function(){var closeButton=document.getElementById(closeId);if(closeButton)document.body.removeChild(closeButton)};var setupDefaultCloseHandler=function(){document.body.addEventListener(\"click\",function(e){e=e||window.event;var target=e.target||e.srcElement;if(target.id===closeId)safeClose()})};var contains=function(value,obj){for(var i in obj)if(obj[i]===value)return true;return false};var stringify=function(obj){if(typeof obj==\"object\")if(obj.push){var out=[];for(var p in obj)if(obj.hasOwnProperty(p))out.push(obj[p]);return\"[\"+out.join(\",\")+\"]\"}else{var out=[];for(var p in obj)if(obj.hasOwnProperty(p))out.push(\"'\"+p+\"':\"+obj[p]);return\"{\"+out.join(\",\")+\"}\"}else return new String(obj)};var broadcastEvent=function(){var args=new Array(arguments.length);for(var i=0;i<arguments.length;i++)args[i]=arguments[i];var event=args.shift();try{if(listeners[event])for(var j=0;j<listeners[event].length;j++)if(typeof listeners[event][j]===\"function\")listeners[event][j].apply(undefined,args);else if(typeof listeners[event][j]===\"string\"&&typeof window[listeners[event][j]]===\"function\")window[listeners[event][j]].apply(undefined,args)}catch(e){console.log(e)}};mraid.disable=function(){removeDefaultClose();disable=true};mraid.addEventListener=function(event,listener){if(disable)return;if(!event||!listener)broadcastEvent(EVENTS.ERROR,\"Both event and listener are required.\",\"addEventListener\");else if(!contains(event,EVENTS))broadcastEvent(EVENTS.ERROR,\"Unknown event: \"+event,\"addEventListener\");else if(!listeners[event])listeners[event]=[listener];else listeners[event].push(listener);flurryBridge.executeCall(\"eventListenerAdded\")};mraid.stateChange=function(newState){if(disable)return;if(currentState===newState)return;broadcastEvent(EVENTS.INFO,\"setting state to \"+stringify(newState));var oldState=currentState;currentState=newState;if(oldState===STATES.LOADING&&newState===STATES.DEFAULT){setupDefaultCloseHandler();updateDefaultClose();broadcastEvent(EVENTS.READY)}else if(oldState===STATES.HIDDEN||newState===STATES.HIDDEN)broadcastEvent(EVENTS.VIEWABLECHANGE);else if(oldState===STATES.DEFAULT&&newState===STATES.EXPANDED)updateDefaultClose();else if(newState===STATES.DEFAULT&&oldState===STATES.EXPANDED)updateDefaultClose();broadcastEvent(EVENTS.STATECHANGE,currentState)};mraid.close=function(){if(disable)return;var state=mraid.getState();if(state===STATES.DEFAULT){mraid.stateChange(STATES.HIDDEN);flurryBridge.executeCall(\"adWillClose\")}else if(state===STATES.EXPANDED){mraid.stateChange(STATES.DEFAULT);flurryBridge.executeCall(\"collapse\")}else console.log(\"close() called in state \"+state)};mraid.expand=function(url){if(disable)return;var state=mraid.getState();if(state!==STATES.DEFAULT){console.log(\"expand() called in state \"+state);return}if(placementType===\"interstitial\"){console.log(\"expand() called for placement type \"+placementType);return}if(url)flurryBridge.executeCall(\"expand\",\"width\",expandProperties.width,\"height\",expandProperties.height,\"url\",url);else flurryBridge.executeCall(\"expand\",\"width\",expandProperties.width,\"height\",expandProperties.height);mraid.stateChange(STATES.EXPANDED)};mraid.setExpandProperties=function(properties){if(disable)return;if(typeof properties.width===\"number\"&&!isNaN(properties.width))expandProperties.width=properties.width;if(typeof properties.height===\"number\"&&!isNaN(properties.height))expandProperties.height=properties.height;if(typeof properties.useCustomClose===\"boolean\"){expandProperties.useCustomClose=properties.useCustomClose;updateDefaultClose()}};mraid.getExpandProperties=function(properties){if(disable)return;var ret={};ret.width=expandProperties.width;ret.height=expandProperties.height;ret.isModal=expandProperties.isModal;ret.useCustomClose=expandProperties.useCustomClose;return ret};mraid.getPlacementType=function(){return placementType};mraid.getVersion=function(){if(disable)return\"\";return\"1.0\"};mraid.getState=function(){if(disable)return\"\";return currentState};mraid.isViewable=function(){if(disable)return false;if(mraid.getState()===\"hidden\")return false;else return true};mraid.open=function(url){if(disable)return;try{flurryBridge.executeCall(\"open\",\"url\",url)}catch(e){console.log(e)}};mraid.removeEventListener=function(event,listener){if(disable)return;if(!event)broadcastEvent(\"error\",\"Must specify an event.\",\"removeEventListener\");else if(listener&&listeners[event])for(var i=0;i<listeners[event].length;i++){if(listeners[event][i]===listener)listeners[event].splice(i,1)}else if(listeners[event])listeners[event]=[]};mraid.useCustomClose=function(use){if(disable)return;if(typeof use===\"boolean\"){expandProperties.useCustomClose=use;updateDefaultClose()}};return mraid};");
      localStringBuilder.append("window.mraid=mraidCtor(window.flurryadapter," + str + ");");
      localStringBuilder.append("})();");
      if (this.l != null) {
        this.l.loadUrl(localStringBuilder.toString());
      }
      return;
    }
  }
  
  private void o()
  {
    ja.a(3, this.f, "activateMraid");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:");
    localStringBuilder.append("if(window.mraid){window.mraid.stateChange(window.mraid.STATES.DEFAULT);}");
    if (this.l != null) {
      this.l.loadUrl(localStringBuilder.toString());
    }
  }
  
  private void p()
  {
    if (!(getContext() instanceof Activity)) {
      ja.a(3, this.f, "no activity present");
    }
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)getContext();
    } while (!d());
    j.a(localActivity, j.a(), true);
  }
  
  private boolean q()
  {
    return this.s != null;
  }
  
  private void r()
  {
    ja.a(3, this.f, "closing ad");
    if (d())
    {
      if (!(getContext() instanceof Activity)) {
        ja.a(3, this.f, "no activity present");
      }
    }
    else {
      return;
    }
    ((Activity)getContext()).finish();
  }
  
  private boolean s()
  {
    return this.v != null;
  }
  
  private void setFlurryJsEnvInitialized(boolean paramBoolean)
  {
    try
    {
      this.m = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void setMraidJsEnvInitialized(boolean paramBoolean)
  {
    try
    {
      this.z = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a()
  {
    a("adWillClose", Collections.emptyMap(), this.d, this.c, this.e, 0);
  }
  
  public void a(i parami, cj paramcj, int paramInt)
  {
    Object localObject1 = parami.a;
    bh localbh = parami.c;
    Object localObject2 = parami.b;
    if (paramInt > 10)
    {
      ja.a(5, this.f, "Maximum depth for event/action loop exceeded when performing action:" + (String)localObject1 + "," + localObject2 + ",triggered by:" + localbh.a);
      return;
    }
    Object localObject3;
    if (localbh.a.equals("clicked"))
    {
      localObject3 = (String)localbh.b.get("noop");
      if ((localObject3 != null) && (((String)localObject3).equals("true")))
      {
        ja.a(4, this.f, "'clicked' event is a noop");
        return;
      }
    }
    ja.a(3, this.f, "performAction(action=" + (String)localObject1 + ",params=" + parami.b + ",triggering event=" + localbh.a + ")");
    int i1;
    if (((String)localObject1).equals("nextFrame"))
    {
      i1 = this.e;
      paramcj = (String)((Map)localObject2).get("offset");
      if (paramcj != null) {
        if (paramcj.equals("next"))
        {
          paramInt = this.e + 1;
          label253:
          a(parami, paramInt);
        }
      }
    }
    for (;;)
    {
      a(parami);
      return;
      if (paramcj.equals("current")) {
        break;
      }
      try
      {
        paramInt = Integer.parseInt(paramcj);
      }
      catch (NumberFormatException paramcj)
      {
        ja.a(6, this.f, "caught: " + paramcj.getMessage());
      }
      paramInt = i1 + 1;
      break label253;
      if (((String)localObject1).equals("closeAd"))
      {
        r();
      }
      else
      {
        if (((String)localObject1).equals("notifyUser"))
        {
          localObject3 = new AlertDialog.Builder(getContext());
          if ((((Map)localObject2).containsKey("message")) && (((Map)localObject2).containsKey("confirmDisplay")) && (((Map)localObject2).containsKey("cancelDisplay")))
          {
            paramcj = (String)((Map)localObject2).get("message");
            localObject1 = (String)((Map)localObject2).get("confirmDisplay");
          }
          for (localObject2 = (String)((Map)localObject2).get("cancelDisplay");; localObject2 = "OK")
          {
            ((AlertDialog.Builder)localObject3).setMessage(paramcj).setCancelable(false).setPositiveButton((CharSequence)localObject2, new u(this, localbh, paramInt)).setNegativeButton((CharSequence)localObject1, new t(this, localbh, paramInt));
            this.A = ((AlertDialog.Builder)localObject3).create();
            if ((this.j != null) && (getCurrentBinding() == 3)) {
              this.j.pause();
            }
            this.A.show();
            break;
            paramcj = "Are you sure?";
            localObject1 = "Cancel";
          }
        }
        if (!((String)localObject1).equals("loadAdComponents")) {
          break label908;
        }
        int i2 = 1;
        int i3 = 3;
        paramInt = i3;
        i1 = i2;
        if (((Map)localObject2).containsKey("min"))
        {
          paramInt = i3;
          i1 = i2;
          if (!((Map)localObject2).containsKey("max")) {}
        }
        try
        {
          i1 = Integer.parseInt((String)((Map)localObject2).get("min"));
          paramInt = Integer.parseInt((String)((Map)localObject2).get("max"));
          paramcj = a(this.d.b().toString(), i1, paramInt);
          if (paramcj.size() <= 0) {
            break label882;
          }
          localObject1 = a(paramcj, this.d.b().toString());
          if (this.l != null)
          {
            this.l.loadUrl("javascript:(function() {var multiadwraps=document.getElementsByClassName('multiAdWrap');if(multiadwraps.length>0){var template=document.getElementsByClassName('multiAdWrap')[0];var compiled=Hogan.compile(template.innerHTML);template.innerHTML='';template.innerHTML=compiled.render(JSON.parse(" + (String)localObject1 + "));}})();");
            this.l.loadUrl("javascript:flurryadapter.callComplete();");
          }
          paramcj = paramcj.iterator();
          while (paramcj.hasNext())
          {
            localObject1 = (AdUnit)paramcj.next();
            localObject2 = new HashMap();
            ((Map)localObject2).put("guid", ((AdFrame)((AdUnit)localObject1).d().get(0)).g().toString());
            a("rendered", (Map)localObject2, (AdUnit)localObject1, b(((AdFrame)((AdUnit)localObject1).d().get(0)).g().toString()), 0, 0);
          }
        }
        catch (NumberFormatException paramcj)
        {
          for (;;)
          {
            i1 = 1;
            paramInt = 3;
          }
        }
        if ((this.l != null) && (!a(this.l)))
        {
          addView(this.l);
          continue;
          label882:
          a("renderFailed", Collections.emptyMap(), this.d, this.c, this.e, 0);
        }
      }
    }
    label908:
    if (((String)localObject1).equals("doExpand"))
    {
      i1 = je.b();
      paramInt = je.c();
      if ((!parami.c.b.containsKey("width")) || (!parami.c.b.containsKey("height"))) {
        break label1321;
      }
    }
    label1321:
    for (;;)
    {
      try
      {
        i1 = je.b(Integer.parseInt((String)parami.c.b.get("width")));
        paramInt = je.b(Integer.parseInt((String)parami.c.b.get("height")));
        ja.a(3, this.f, "expand to width = " + i1 + " height = " + paramInt);
        if (getHolder() != null)
        {
          a("clicked", Collections.emptyMap(), this.d, this.c, this.e, 0);
          a(i1, paramInt);
        }
        if (!parami.c.b.containsKey("url")) {
          break;
        }
        this.a = ((String)parami.c.b.get("url"));
        initLayout();
      }
      catch (NumberFormatException paramcj)
      {
        ja.a(6, this.f, paramcj.getMessage());
        i1 = je.b();
        paramInt = je.c();
        continue;
      }
      if (((String)localObject1).equals("doCollapse"))
      {
        i1 = getCurrentAdFrame().e().b().intValue();
        paramInt = getCurrentAdFrame().e().c().intValue();
        i1 = je.b(i1);
        paramInt = je.b(paramInt);
        if (this.a != null)
        {
          this.a = null;
          initLayout();
        }
        if (getHolder() == null) {
          break;
        }
        b(i1, paramInt);
        break;
      }
      if (((String)localObject1).equals("directOpen"))
      {
        localObject1 = new HashMap();
        ((Map)localObject1).put("noop", "true");
        a("clicked", (Map)localObject1, this.d, this.c, this.e, 0);
      }
      this.b.a().a(parami, paramcj, paramInt);
      break;
    }
  }
  
  public void a(String paramString, Map<String, String> paramMap, AdUnit paramAdUnit, m paramm, int paramInt1, int paramInt2)
  {
    ja.a(3, this.f, "fireEvent(event=" + paramString + ",params=" + paramMap + ")");
    this.b.a(new bh(paramString, paramMap, getContext(), paramAdUnit, paramm, paramInt1), this, paramInt2);
  }
  
  boolean a(View paramView)
  {
    paramView = paramView.getParent();
    return (paramView != null) && (paramView == this);
  }
  
  @TargetApi(11)
  public void b()
  {
    this.k = true;
    if ((this.l != null) && (Build.VERSION.SDK_INT >= 11)) {
      this.l.onResume();
    }
    if ((this.j != null) && (getCurrentBinding() == 3) && (this.i != null)) {
      this.i.show(0);
    }
  }
  
  @TargetApi(11)
  public void c()
  {
    if ((this.l != null) && (Build.VERSION.SDK_INT >= 11)) {
      this.l.onPause();
    }
    if ((this.j != null) && (getCurrentBinding() == 3)) {
      this.j.pause();
    }
    this.k = false;
  }
  
  boolean d()
  {
    return getCurrentFormat().equals("takeover");
  }
  
  boolean e()
  {
    boolean bool = jc.a().c();
    if (!bool) {
      ja.a(5, this.f, "There is no network connectivity (ad will not rotate)");
    }
    return (!s()) && (!q()) && (bool);
  }
  
  AdFrame getCurrentAdFrame()
  {
    return (AdFrame)this.B.get(this.e);
  }
  
  int getCurrentBinding()
  {
    return getCurrentAdFrame().b().intValue();
  }
  
  String getCurrentContent()
  {
    return getCurrentAdFrame().d().toString();
  }
  
  String getCurrentDisplay()
  {
    return getCurrentAdFrame().c().toString();
  }
  
  String getCurrentFormat()
  {
    return getCurrentAdFrame().e().e().toString();
  }
  
  an getHolder()
  {
    try
    {
      Object localObject = getParent();
      if (localObject != null)
      {
        localObject = (an)localObject;
        return (an)localObject;
      }
      return null;
    }
    catch (ClassCastException localClassCastException)
    {
      ja.a(5, this.f, "AdUnityView parent not a BannerHolder:" + localClassCastException.getMessage());
    }
    return null;
  }
  
  public void initLayout()
  {
    ja.a(3, this.f, "initLayout: ad creative layout: {width = " + getCurrentAdFrame().e().b() + ", height = " + getCurrentAdFrame().e().c() + "}");
    Context localContext = getContext();
    removeAllViews();
    setFocusable(true);
    setFocusableInTouchMode(true);
    switch (getCurrentBinding())
    {
    default: 
      a("renderFailed", Collections.emptyMap(), this.d, this.c, this.e, 0);
      return;
    case 3: 
      if (this.j == null)
      {
        this.j = new n(localContext);
        this.j.setOnPreparedListener(this);
        this.j.setOnCompletionListener(this);
        this.j.setOnErrorListener(this);
        this.i = new cf(localContext, this.j, this);
        this.j.setMediaController(this.i);
      }
      this.j.setVideoURI(Uri.parse(getCurrentDisplay()));
      ja.a(3, this.f, "URI: " + Uri.parse(getCurrentDisplay()).toString());
      this.j.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      addView(this.j);
      ((RelativeLayout)this.j.getParent()).setGravity(17);
      this.h = new ProgressDialog(localContext);
      this.h.setProgressStyle(0);
      this.h.setMessage("Loading...");
      this.h.setCancelable(true);
      this.h.setOnKeyListener(this);
      this.h.show();
      return;
    }
    if (this.l == null)
    {
      this.l = new WebView(localContext);
      this.l.getSettings().setJavaScriptEnabled(true);
      this.l.setVerticalScrollBarEnabled(false);
      this.l.setHorizontalScrollBarEnabled(false);
      this.l.setBackgroundColor(0);
      this.l.clearCache(false);
      this.o = new w(this, null);
      this.l.setWebChromeClient(this.o);
      this.n = new aa(this, null);
      this.l.setWebViewClient(this.n);
    }
    if (getCurrentBinding() == 1) {
      if (this.a != null) {
        a(this.a);
      }
    }
    for (;;)
    {
      this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      if (!d()) {
        break;
      }
      this.h = new ProgressDialog(localContext);
      this.h.setProgressStyle(0);
      this.h.setMessage("Loading...");
      this.h.setCancelable(true);
      this.h.setOnKeyListener(this);
      this.h.show();
      return;
      a(getCurrentDisplay());
      continue;
      if (getCurrentBinding() == 2)
      {
        this.l.loadDataWithBaseURL("base://url/", getCurrentDisplay(), "text/html", "utf-8", "base://url/");
        a("rendered", Collections.emptyMap(), this.d, this.c, this.e, 0);
      }
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    a("videoCompleted", Collections.emptyMap(), this.d, this.c, this.e, 0);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((this.h != null) && (this.h.isShowing())) {
      this.h.dismiss();
    }
    a("renderFailed", Collections.emptyMap(), this.d, this.c, this.e, 0);
    removeView(this.j);
    return false;
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    ja.a(3, "listeners", "onkey,keycode=" + paramInt + ",event=" + paramKeyEvent.getAction());
    if ((paramDialogInterface == this.h) && (paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      a();
      paramDialogInterface.dismiss();
      return true;
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (getCurrentBinding() == 3)
    {
      if (this.h.isShowing()) {
        this.h.dismiss();
      }
      if (((this.A == null) || (!this.A.isShowing())) && (this.j != null) && (this.k)) {
        this.j.start();
      }
      a("rendered", Collections.emptyMap(), this.d, this.c, this.e, 0);
      a("videoStart", Collections.emptyMap(), this.d, this.c, this.e, 0);
    }
  }
  
  @TargetApi(11)
  public void stop()
  {
    ja.a(3, this.f, "stop");
    if (getCurrentBinding() == 3)
    {
      if ((this.h != null) && (this.h.isShowing())) {
        this.h.dismiss();
      }
      if ((this.j != null) && (this.j.isPlaying())) {
        this.j.stopPlayback();
      }
    }
    if (this.l != null)
    {
      if ((this.p != null) && (this.o != null)) {
        this.o.onHideCustomView();
      }
      if (this.v != null) {
        b(0, 0);
      }
      removeView(this.l);
      this.l.stopLoading();
      if (Build.VERSION.SDK_INT >= 11) {
        this.l.onPause();
      }
      this.l.destroy();
      this.l = null;
    }
    if (d()) {
      a("adClosed", Collections.emptyMap(), this.d, this.c, this.e, 0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
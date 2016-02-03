package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
class fy
        extends FrameLayout {
    private static final String d = fy.class.getSimpleName();
    private static HashMap<String, fy> e;
    protected boolean a = false;
    protected double b;
    protected bv c;
    private ev f;
    private fl g;
    private WebViewClient h;
    private WebChromeClient i;
    private boolean j;
    private final gl k;
    private gb l;
    private boolean m = false;
    private int n = 8;
    private boolean o = false;
    private int p;
    private int q;
    private Context r;
    private WebView s;

    public fy(bv parambv, int paramInt1, int paramInt2, double paramDouble, Context paramContext, WebView paramWebView) {
        this(parambv, paramInt1, paramInt2, paramDouble, paramContext, paramWebView, fz.a, gd.c, gl.a);
    }

    fy(bv parambv, int paramInt1, int paramInt2, double paramDouble, Context paramContext, WebView paramWebView, fz paramfz, gd paramgd, gl paramgl) {
        super(paramContext);
        this.c = parambv;
        this.k = paramgl;
        this.q = paramInt2;
        this.p = paramInt1;
        this.b = paramDouble;
        this.r = paramContext;
        this.s = paramWebView;
        c();
        addView(this.s);
        if ((Build.VERSION.SDK_INT >= 11) && (l())) {
            b();
        }
        a(paramfz, paramgd);
    }

    public static fy e(String paramString) {
        return (fy) w().remove(paramString);
    }

    static HashMap<String, fy> w() {
        if (e == null) {
            e = new HashMap();
        }
        return e;
    }

    private void y() {
        bw localbw = new bw(this.c, this.r);
        localbw.a("mraid", i());
        localbw.a("amazonmobile", this.c.o());
        this.h = localbw;
        a(this.h);
    }

    private void z() {
        if (gb.a(this.l) != null) {
            gb.a(this.l).a(this);
        }
    }

    public WebView a() {
        return this.s;
    }

    protected void a(int paramInt1, int paramInt2) {
        this.s.setLayoutParams(new FrameLayout.LayoutParams(paramInt1, paramInt2));
    }

    protected void a(WebViewClient paramWebViewClient) {
        this.s.setWebViewClient(paramWebViewClient);
    }

    protected void a(ft paramft) {
        paramft = "{" + paramft.toString() + "}";
        c("window.mraidbridge.fireChangeEvent(" + paramft + ");");
        dv.a(d, "Fire change: %s", new Object[]{paramft});
    }

    protected void a(fz paramfz, gd paramgd) {
        boolean bool = true;
        this.f = new ev(this);
        this.g = new fl(this, paramfz, paramgd);
        this.s.setScrollContainer(false);
        this.s.setBackgroundColor(0);
        this.s.setVerticalScrollBarEnabled(false);
        this.s.setHorizontalScrollBarEnabled(false);
        if (!ig.a(true, this.s, d)) {
        }
        for (; ; ) {
            this.a = bool;
            y();
            this.i = new gc(this);
            this.s.setWebChromeClient(this.i);
            this.l = new gb();
            return;
            bool = false;
        }
    }

    public void a(gf paramgf) {
        gb.a(this.l, paramgf);
    }

    public void a(gg paramgg) {
        gb.a(this.l, paramgg);
    }

    public void a(gj paramgj) {
        gb.a(this.l, paramgj);
    }

    public void a(gk paramgk) {
        gb.a(this.l, paramgk);
    }

    protected void a(ArrayList<ft> paramArrayList) {
        paramArrayList = paramArrayList.toString();
        if (paramArrayList.length() < 2) {
            return;
        }
        paramArrayList = "{" + paramArrayList.substring(1, paramArrayList.length() - 1) + "}";
        c("window.mraidbridge.fireChangeEvent(" + paramArrayList + ");");
        dv.a(d, "Fire changes: %s", new Object[]{paramArrayList});
    }

    public boolean a(String paramString) {
        return a(null, paramString);
    }

    public boolean a(String paramString1, String paramString2) {
        String str = paramString2;
        if (paramString2.indexOf("<html>") == -1) {
            str = "<html><meta name=\"viewport\" content=\"width=" + this.p + ", height=" + this.q + ", initial-scale=" + bs.a(this.b) + ", minimum-scale=" + this.b + ", maximum-scale=" + this.b + "\"/>" + "<head></head><body style='margin:0;padding:0;'>" + paramString2 + "</body></html>";
        }
        paramString2 = str.replace("<head>", "<head><script type='text/javascript'>(function(){var mraidbridge=window.mraidbridge={};var listeners={};var nativeCallQueue=[];var nativeCallInFlight=false;mraidbridge.fireReadyEvent=function(){mraidbridge.fireEvent('ready')};mraidbridge.fireChangeEvent=function(properties){mraidbridge.fireEvent('change',properties)};mraidbridge.fireErrorEvent=function(message,action){mraidbridge.fireEvent('error',message,action)};mraidbridge.fireEvent=function(type){var ls=listeners[type];if(ls){var args=Array.prototype.slice.call(arguments);args.shift();var l=ls.length;for(var i=0;i<l;i++){ls[i].apply(null,args)}}};mraidbridge.nativeCallComplete=function(command){if(nativeCallQueue.length===0){nativeCallInFlight=false;return}var nextCall=nativeCallQueue.pop();window.location=nextCall};mraidbridge.executeNativeCall=function(command){var call='mraid://'+command;var key,value;var isFirstArgument=true;for(var i=1;i<arguments.length;i+=2){key=arguments[i];value=arguments[i+1];if(value===null)continue;if(isFirstArgument){call+='?';isFirstArgument=false}else{call+='&'}call+=key+'='+escape(value)}if(nativeCallInFlight){nativeCallQueue.push(call)}else{nativeCallInFlight=true;window.location=call}};mraidbridge.addEventListener=function(event,listener){var eventListeners;listeners[event]=listeners[event]||[];eventListeners=listeners[event];for(var l in eventListeners){if(listener===l)return}eventListeners.push(listener)};mraidbridge.removeEventListener=function(event,listener){if(listeners.hasOwnProperty(event)){var eventListeners=listeners[event];if(eventListeners){var idx=eventListeners.indexOf(listener);if(idx!==-1){eventListeners.splice(idx,1)}}}}}());(function(){var mraid=window.mraid={};var bridge=window.mraidbridge;var VERSION=mraid.VERSION='1.0';var STATES=mraid.STATES={LOADING:'loading',DEFAULT:'default',EXPANDED:'expanded',HIDDEN:'hidden',};var EVENTS=mraid.EVENTS={ERROR:'error',INFO:'info',READY:'ready',STATECHANGE:'stateChange',VIEWABLECHANGE:'viewableChange'};var PLACEMENT_TYPES=mraid.PLACEMENT_TYPES={UNKNOWN:'unknown',INLINE:'inline',INTERSTITIAL:'interstitial'};var LOG_LEVELS=mraid.LOG_LEVELS={INFO:4,DEBUG:3,VERBOSE:2,WARNING:5,ERROR:6};var expandProperties={width:-1,height:-1,useCustomClose:false,isModal:true,lockOrientation:true};var hasSetCustomSize=false;var hasSetCustomClose=false;var listeners={};var state=STATES.LOADING;var isViewable=false;var screenSize={width:-1,height:-1};var placementType=PLACEMENT_TYPES.UNKNOWN;var EventListeners=function(event){this.event=event;this.count=0;var listeners={};this.add=function(func){var id=String(func);if(!listeners[id]){listeners[id]=func;this.count++}};this.remove=function(func){var id=String(func);if(listeners[id]){listeners[id]=null;delete listeners[id];this.count--;return true}else{return false}};this.removeAll=function(){for(var id in listeners){if(listeners.hasOwnProperty(id))this.remove(listeners[id])}};this.broadcast=function(args){for(var id in listeners){if(listeners.hasOwnProperty(id))listeners[id].apply({},args)}};this.toString=function(){var out=[event,':'];for(var id in listeners){if(listeners.hasOwnProperty(id))out.push('|',id,'|')}return out.join('')}};var broadcastEvent=function(){var args=new Array(arguments.length);var l=arguments.length;for(var i=0;i<l;i++)args[i]=arguments[i];var event=args.shift();if(listeners[event])listeners[event].broadcast(args)};var contains=function(value,array){for(var i in array){if(array[i]===value)return true}return false};var clone=function(obj){if(obj===null)return null;var f=function(){};f.prototype=obj;return new f()};var stringify=function(obj){if(typeof obj==='object'){var out=[];if(obj.push){for(var p in obj)out.push(obj[p]);return'['+out.join(',')+']'}else{for(var p in obj)out.push(\"'\"+p+\"': \"+obj[p]);return'{'+out.join(',')+'}'}}else return String(obj)};var trim=function(str){return str.replace(/^\\s+|\\s+$/g,'')};var changeHandlers={state:function(val){if(state===STATES.LOADING){broadcastEvent(EVENTS.INFO,'Native SDK initialized.')}state=val;broadcastEvent(EVENTS.INFO,'Set state to '+stringify(val));broadcastEvent(EVENTS.STATECHANGE,state)},viewable:function(val){isViewable=val;broadcastEvent(EVENTS.INFO,'Set isViewable to '+stringify(val));broadcastEvent(EVENTS.VIEWABLECHANGE,isViewable)},placementType:function(val){broadcastEvent(EVENTS.INFO,'Set placementType to '+stringify(val));placementType=val},screenSize:function(val){broadcastEvent(EVENTS.INFO,'Set screenSize to '+stringify(val));for(var key in val){if(val.hasOwnProperty(key))screenSize[key]=val[key]}if(!hasSetCustomSize){expandProperties['width']=screenSize['width'];expandProperties['height']=screenSize['height']}},expandProperties:function(val){broadcastEvent(EVENTS.INFO,'Merging expandProperties with '+stringify(val));for(var key in val){if(val.hasOwnProperty(key))expandProperties[key]=val[key]}}};var validate=function(obj,validators,action,merge){if(!merge){if(obj===null){broadcastEvent(EVENTS.ERROR,'Required object not provided.',action);return false}else{for(var i in validators){if(validators.hasOwnProperty(i)&&obj[i]===undefined){broadcastEvent(EVENTS.ERROR,'Object is missing required property: '+i+'.',action);return false}}}}for(var prop in obj){var validator=validators[prop];var value=obj[prop];if(validator&&!validator(value)){broadcastEvent(EVENTS.ERROR,'Value of property '+prop+' is invalid.',action);return false}}return true};var expandPropertyValidators={width:function(v){return!isNaN(v)&&v>=0},height:function(v){return!isNaN(v)&&v>=0},useCustomClose:function(v){return(typeof v==='boolean')},lockOrientation:function(v){return(typeof v==='boolean')}};bridge.addEventListener('change',function(properties){for(var p in properties){if(properties.hasOwnProperty(p)){var handler=changeHandlers[p];handler(properties[p])}}});bridge.addEventListener('error',function(message,action){broadcastEvent(EVENTS.ERROR,message,action)});bridge.addEventListener('ready',function(){broadcastEvent(EVENTS.READY)});mraid.addEventListener=function(event,listener){if(!event||!listener){broadcastEvent(EVENTS.ERROR,'Both event and listener are required.','addEventListener')}else if(!contains(event,EVENTS)){broadcastEvent(EVENTS.ERROR,'Unknown MRAID event: '+event,'addEventListener')}else{if(!listeners[event])listeners[event]=new EventListeners(event);listeners[event].add(listener)}};mraid.close=function(){if(state===STATES.HIDDEN){broadcastEvent(EVENTS.ERROR,'Ad cannot be closed when it is already hidden.','close')}else bridge.executeNativeCall('close')};mraid.playVideo=function(URL,properties){if(state==STATES.DEFAULT||state==STATES.EXPANDED){var args=['playVideo'];if(URL){args=args.concat(['url',URL])}var audioMuted=false,autoPlay=true,controls=true,loop=false,position=[-1,-1,-1,-1],startStyle='normal',stopStyle='normal';if(properties){if((typeof properties.audio!=\"undefined\")&&(properties.audio!=null)){audioMuted=properties.audio}if((typeof properties.autoplay!=\"undefined\")&&(properties.autoplay!=null)){autoPlay=properties.autoplay}if((typeof properties.controls!=\"undefined\")&&(properties.controls!=null)){controls=properties.controls}if((typeof properties.loop!=\"undefined\")&&(properties.loop!=null)){loop=properties.loop}if((typeof properties.position!=\"undefined\")&&(properties.position!=null)){inline=new Array(4);inline[0]=properties.position.top;inline[1]=properties.position.left;if((typeof properties.position.width!=\"undefined\")&&(properties.position.width!=null)){inline[2]=properties.position.width}if((typeof properties.position.height!=\"undefined\")&&(properties.position.height!=null)){inline[3]=properties.position.height}position=inline}if((typeof properties.startStyle!=\"undefined\")&&(properties.startStyle!=null)){startStyle=properties.startStyle}if((typeof properties.stopStyle!=\"undefined\")&&(properties.stopStyle!=null)){stopStyle=properties.stopStyle}if(loop){stopStyle='normal';controls=true}if(!autoPlay){controls=true}if(!controls){stopStyle='exit'}if(position[0]==-1||position[1]==-1){startStyle='fullscreen';autoPlay=true}args=args.concat(['audioMuted',audioMuted]);args=args.concat(['autoPlay',autoPlay]);args=args.concat(['controls',controls]);args=args.concat(['loop',loop]);args=args.concat(['position',position]);args=args.concat(['startStyle',startStyle]);args=args.concat(['stopStyle',stopStyle])}bridge.executeNativeCall.apply(this,args)}};mraid.log=function(level,log){var args=['log','level',level,'log',log];bridge.executeNativeCall.apply(this,args)};mraid.expand=function(URL){if(state!==STATES.DEFAULT){broadcastEvent(EVENTS.ERROR,'Ad can only be expanded from the default state.','expand')}else{var args=['expand'];if(hasSetCustomClose){args=args.concat(['shouldUseCustomClose',expandProperties.useCustomClose?'true':'false'])}if(hasSetCustomSize){if(expandProperties.width>=0&&expandProperties.height>=0){args=args.concat(['w',expandProperties.width,'h',expandProperties.height])}}if(typeof expandProperties.lockOrientation!=='undefined'){args=args.concat(['lockOrientation',expandProperties.lockOrientation])}if(URL){args=args.concat(['url',URL])}bridge.executeNativeCall.apply(this,args)}};mraid.getExpandProperties=function(){var properties={width:expandProperties.width,height:expandProperties.height,useCustomClose:expandProperties.useCustomClose,isModal:expandProperties.isModal};return properties};mraid.getPlacementType=function(){return placementType};mraid.getState=function(){return state};mraid.getVersion=function(){return mraid.VERSION};mraid.isViewable=function(){return isViewable};mraid.open=function(URL){if(!URL)broadcastEvent(EVENTS.ERROR,'URL is required.','open');else bridge.executeNativeCall('open','url',URL)};mraid.removeEventListener=function(event,listener){if(!event)broadcastEvent(EVENTS.ERROR,'Event is required.','removeEventListener');else{if(listener&&(!listeners[event]||!listeners[event].remove(listener))){broadcastEvent(EVENTS.ERROR,'Listener not currently registered for event.','removeEventListener');return}else if(listeners[event])listeners[event].removeAll();if(listeners[event]&&listeners[event].count===0){listeners[event]=null;delete listeners[event]}}};mraid.setExpandProperties=function(properties){if(validate(properties,expandPropertyValidators,'setExpandProperties',true)){if(properties.hasOwnProperty('width')||properties.hasOwnProperty('height')){hasSetCustomSize=true}if(properties.hasOwnProperty('useCustomClose'))hasSetCustomClose=true;var desiredProperties=['width','height','useCustomClose','lockOrientation'];var length=desiredProperties.length;for(var i=0;i<length;i++){var propname=desiredProperties[i];if(properties.hasOwnProperty(propname))expandProperties[propname]=properties[propname]}}};mraid.useCustomClose=function(shouldUseCustomClose){expandProperties.useCustomClose=shouldUseCustomClose;hasSetCustomClose=true;bridge.executeNativeCall('usecustomclose','shouldUseCustomClose',shouldUseCustomClose)}}());</script>");
        this.s.loadDataWithBaseURL(paramString1, paramString2, "text/html", "UTF-8", null);
        return true;
    }

    protected void b() {
        cf.a(this);
    }

    public void b(String paramString) {
        hy localhy = hy.c();
        localhy.d(paramString);
        try {
            paramString = localhy.e();
            a(paramString.a());
            return;
        } catch (ic paramString) {
            z();
        }
    }

    protected void b(String paramString1, String paramString2) {
        c("window.mraidbridge.fireErrorEvent('" + paramString1 + "', '" + paramString2 + "');");
    }

    protected void c() {
        int i1 = (int) (this.c.n() * this.b * dn.i().b().s());
        if (i1 > 0) {
            a(-1, i1);
        }
    }

    protected void c(String paramString) {
        if (paramString != null) {
            this.s.loadUrl("javascript:" + paramString);
        }
    }

    protected int d() {
        return this.p;
    }

    protected void d(String paramString) {
        c("window.mraidbridge.nativeCallComplete('" + paramString + "');");
    }

    protected int e() {
        return this.q;
    }

    protected double f() {
        return this.b;
    }

    protected bv g() {
        return this.c;
    }

    public boolean h() {
        return this.a;
    }

    protected ga i() {
        return new ga(this);
    }

    public void j() {
        this.o = true;
        if (this.g != null) {
            this.g.l();
        }
    }

    public void k() {
        this.g.g();
        removeView(this.s);
        this.s.destroy();
    }

    public boolean l() {
        return this.c.h();
    }

    protected ev m() {
        return this.f;
    }

    protected fl n() {
        return this.g;
    }

    public gg o() {
        return gb.b(this.l);
    }

    protected void onAttachedToWindow() {
        if (this.o) {
        }
        do {
            return;
            super.onAttachedToWindow();
            this.m = true;
        } while (this.g == null);
        this.g.b();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m = false;
        if (this.g != null) {
            this.g.c();
        }
    }

    protected void onWindowVisibilityChanged(int paramInt) {
        if ((this.m) && (this.n != paramInt) && (paramInt != 0) && (this.g != null)) {
            this.g.c();
        }
    }

    public gf p() {
        return gb.c(this.l);
    }

    public gj q() {
        return gb.d(this.l);
    }

    public ge r() {
        return gb.e(this.l);
    }

    public gi s() {
        return gb.f(this.l);
    }

    public gk t() {
        return gb.g(this.l);
    }

    protected void u() {
        c("window.mraidbridge.fireReadyEvent();");
    }

    protected void v() {
        if (!this.j) {
            this.g.h();
            a(fs.a(this.k));
            u();
            if (q() != null) {
                q().a(this);
            }
            this.j = true;
            this.g.e();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/fy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
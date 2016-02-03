package com.appflood.mraid;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appflood.AFListActivity.1;
import com.appflood.b.b.a;
import com.appflood.c.f;
import com.appflood.e.j;
import com.appflood.e.k;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFBannerWebView
  extends WebView
{
  int a = 0;
  private c b;
  private p c;
  private n d;
  private final q e;
  private boolean f;
  private String g;
  private HashMap<String, Object> h;
  private com.appflood.c.b i;
  private boolean j = false;
  private com.appflood.d.a k;
  private String l;
  private boolean m = false;
  
  public AFBannerWebView(Context paramContext, m paramm, r paramr, o paramo, q paramq)
  {
    super(paramContext);
    this.e = paramq;
    setWebViewClient(new b((byte)0));
    setWebChromeClient(new a((byte)0));
    addJavascriptInterface(new LogJs(), "appflood");
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    this.d = new n();
    this.b = new c(this);
    this.c = new p(this, paramm, paramr, paramo);
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        j.a();
        k.c((String)AFBannerWebView.a(AFBannerWebView.this).get("click_cb_url"));
      }
    });
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        new StringBuilder("rrrrrrrrrrrrrr ").append(paramAnonymousMotionEvent.getAction()).append(" clickable ").append(AFBannerWebView.this.isClickable()).toString();
        j.a();
        if (!AFBannerWebView.this.isClickable()) {}
        do
        {
          return true;
          if (paramAnonymousMotionEvent.getAction() != 2) {
            break;
          }
          new StringBuilder("xxxxxxxxx ").append(AFBannerWebView.this.a).toString();
          j.a();
        } while (AFBannerWebView.this.a >= 10);
        paramAnonymousView = AFBannerWebView.this;
        paramAnonymousView.a += 1;
        return true;
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          if (AFBannerWebView.this.a <= 4) {
            k.c((String)AFBannerWebView.a(AFBannerWebView.this).get("click_cb_url"));
          }
          AFBannerWebView.this.a = 0;
          return false;
        }
        AFBannerWebView.this.a = 0;
        return false;
      }
    });
    paramContext = getSettings();
    paramContext.setUseWideViewPort(true);
    if (com.appflood.e.c.j >= 7) {
      paramContext.setLoadWithOverviewMode(true);
    }
    paramContext.setJavaScriptEnabled(true);
    paramContext.setBuiltInZoomControls(true);
    paramContext.setSupportZoom(true);
    paramContext.setSupportMultipleWindows(true);
  }
  
  public AFBannerWebView(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    this(paramContext, m.a, r.a, o.c, q.a);
    this.h = paramHashMap;
    this.l = ((String)this.h.get("type"));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.i != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("result", Boolean.valueOf(paramBoolean));
      int n = ((Integer)this.h.get("width")).intValue();
      int i1 = ((Integer)this.h.get("height")).intValue();
      localHashMap.put("w", Integer.valueOf(n));
      localHashMap.put("h", Integer.valueOf(i1));
      localHashMap.put("type", this.l);
      if (!b()) {
        this.i.onFinish(localHashMap);
      }
      k.c((String)this.h.get("show_cb_url"));
    }
  }
  
  private boolean a(URI paramURI)
  {
    String str = paramURI.getHost();
    Object localObject = URLEncodedUtils.parse(paramURI, "UTF-8");
    paramURI = new HashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      NameValuePair localNameValuePair = (NameValuePair)((Iterator)localObject).next();
      paramURI.put(localNameValuePair.getName(), localNameValuePair.getValue());
    }
    localObject = i.a(str, paramURI, this);
    new StringBuilder("pair list ").append(paramURI).append("  ").append(localObject).toString();
    j.a();
    if (localObject == null)
    {
      c(str);
      return false;
    }
    ((d)localObject).a();
    c(str);
    return true;
  }
  
  private void c(String paramString)
  {
    b("window.mraidbridge.nativeCallComplete('" + paramString + "');");
  }
  
  public final com.appflood.c.b a()
  {
    return this.i;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      b("window.mraidbridge.maxSize=" + localJSONObject.toString() + ";");
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  public final void a(com.appflood.c.b paramb)
  {
    this.i = paramb;
    paramb = (String)this.h.get("html_content");
    new StringBuilder(" html data ").append(paramb).toString();
    j.a();
    if (j.a(paramb))
    {
      a(false);
      return;
    }
    if (k.b(paramb))
    {
      a(paramb);
      return;
    }
    paramb = new com.appflood.b.b(paramb);
    paramb.a(new b.a()
    {
      public final void a(com.appflood.b.b paramAnonymousb)
      {
        String str = paramAnonymousb.c();
        new StringBuilder(" is a url url = ").append(paramAnonymousb.a()).append("   ").append(str).toString();
        j.a();
        AFBannerWebView.this.a(str);
      }
      
      public final void a(com.appflood.b.b paramAnonymousb, int paramAnonymousInt)
      {
        AFBannerWebView.a(AFBannerWebView.this, false);
      }
    });
    paramb.f();
  }
  
  public final void a(p.a parama)
  {
    this.d.a = parama;
  }
  
  public final void a(s params)
  {
    b("window.mraidbridge.fireVideoEvent('" + params.toString().toLowerCase() + "');");
  }
  
  public final void a(w paramw)
  {
    String str = "{" + paramw.toString() + "}";
    b("window.mraidbridge.fireChangeEvent(" + str + ");");
    new StringBuilder("Fire change: ").append(str).toString();
    j.a();
    if ((paramw instanceof z)) {
      m();
    }
  }
  
  public final void a(final String paramString)
  {
    if (j.a(paramString)) {
      return;
    }
    String str = paramString.replace("http://data.appflood.com/", com.appflood.c.d.g);
    this.g = str;
    new StringBuilder("html data = ").append(this.g).toString();
    j.a();
    this.m = false;
    new StringBuilder(" contains ").append(str.contains("<script src=\"mraid.js\"></script>")).toString();
    j.a();
    paramString = "";
    if (str.contains("<script src=\"mraid.js\"></script>"))
    {
      paramString = "<script src=\"mraid.js\"></script>";
      if (j.a(paramString)) {
        break label183;
      }
      this.m = true;
    }
    label183:
    for (paramString = str.replace(paramString, "<script>;(function() {\n    console = {};\n    console.log = function(log) {\n      if(typeof log!=='string')log=log.toString();\n      window.appflood.log(log);\n\n    };\n    console.debug = console.info = console.warn = console.error = console.log;\n}());\n\n;(function() {\n  // Establish the root mraidbridge object.\n  var mraidbridge = window.mraidbridge = {};\n  // Listeners for bridge events.\n  var listeners = {};\n\n  // Queue to track pending calls to the native SDK.\n  var nativeCallQueue = [];\n\n  // Whether a native call is currently in progress.\n  var nativeCallInFlight = false;\n\n  //////////////////////////////////////////////////////////////////////////////////////////////////\n\n  mraidbridge.fireReadyEvent = function() {\n    mraidbridge.fireEvent('ready');\n  };\n\n  mraidbridge.fireChangeEvent = function(properties) {\n    mraidbridge.fireEvent('change', properties);\n  };\n\n  mraidbridge.fireErrorEvent = function(message, action) {\n    mraidbridge.fireEvent('error', message, action);\n  };\n  mraidbridge.fireVideoEvent = function(properties){\n    mraidbridge.fireEvent('video', properties);\n  };\n\n  mraidbridge.fireEvent = function(type) {\n    var ls = listeners[type];\n    if (ls) {\n      var args = Array.prototype.slice.call(arguments);\n      args.shift();\n      var l = ls.length;\n      for (var i = 0; i < l; i++) {\n        ls[i].apply(null, args);\n      }\n    }\n  };\n\n  mraidbridge.nativeCallComplete = function(command) {\n    if (nativeCallQueue.length === 0) {\n      nativeCallInFlight = false;\n      return;\n    }\n\n    var nextCall = nativeCallQueue.pop();\n    //window.location = nextCall;\n    window.appflood.command(nextCall);\n  };\n\n  mraidbridge.executeNativeCall = function(command) {\n    var call = 'mraid://' + command;\n\n    var key, value;\n    var isFirstArgument = true;\n\n    for (var i = 1; i < arguments.length; i += 2) {\n      key = arguments[i];\n      value = arguments[i + 1];\n\n      if (value === null) continue;\n\n      if (isFirstArgument) {\n        call += '?';\n        isFirstArgument = false;\n      } else {\n        call += '&';\n      }\n\n      call += encodeURIComponent(key) + '=' + encodeURIComponent(value);\n    }\n\n    if (nativeCallInFlight) {\n      nativeCallQueue.push(call);\n    } else {\n      nativeCallInFlight = true;\n      //window.location = call;\n      window.appflood.command(call);\n    }\n\n  };\n\n  mraidbridge.showVideoPlayer = function(data){\n      if(typeof(data)!='string')return false;\n      window.appflood.showVideoPlayer(data);\n  };\n\n  //////////////////////////////////////////////////////////////////////////////////////////////////\n\n  mraidbridge.addEventListener = function(event, listener) {\n    var eventListeners;\n    listeners[event] = listeners[event] || [];\n    eventListeners = listeners[event];\n\n    for (var l in eventListeners) {\n      // Listener already registered, so no need to add it.\n      if (listener === l) return;\n    }\n\n    eventListeners.push(listener);\n  };\n\n  mraidbridge.removeEventListener = function(event, listener) {\n    if (listeners.hasOwnProperty(event)) {\n      var eventListeners = listeners[event];\n      if (eventListeners) {\n        var idx = eventListeners.indexOf(listener);\n        if (idx !== -1) {\n          eventListeners.splice(idx, 1);\n        }\n      }\n    }\n  };\n}());\n\n(function() {\n\n  window.mraidbridge.maxSize = {width: -1, height:-1};\n  window.mraidbridge.supports = {sms: false,tel: false,calendar: false,storePicture: false,inlineVideo: false};\n  window.mraidbridge.defaultProperties={x:-1,y:-1, width:-1, height:-1};\n  window.mraidbridge.currentProperties={x:-1,y:-1, width:-1, height:-1};\n\n  var mraid = window.mraid = {};\n  var bridge = window.mraidbridge;\n\n  // Constants. ////////////////////////////////////////////////////////////////////////////////////\n\n  var VERSION = mraid.VERSION = '2.0';\n\n  var STATES = mraid.STATES = {\n    LOADING: 'loading',     // Initial state.\n    DEFAULT: 'default',\n    EXPANDED: 'expanded',\n    HIDDEN: 'hidden',\n    RESIZED:'resized'\n  };\n\n  var EVENTS = mraid.EVENTS = {\n    ERROR: 'error',\n    INFO: 'info',\n    READY: 'ready',\n    STATECHANGE: 'stateChange',\n    VIEWABLECHANGE: 'viewableChange',\n    SIZECHANGE:'sizeChange',\n    VIDEO:'video'\n  };\n\n  var PLACEMENT_TYPES = mraid.PLACEMENT_TYPES = {\n    UNKNOWN: 'unknown',\n    INLINE: 'inline',\n    INTERSTITIAL: 'interstitial'\n  };\n\n  // External MRAID state: may be directly or indirectly modified by the ad JS. ////////////////////\n\n  // Properties which define the behavior of an expandable ad.\n  var expandProperties = {\n    width: -1,\n    height: -1,\n    useCustomClose: false,\n    isModal: true,\n    lockOrientation: false\n  };\n//new mraid v2 ////////////////////////\n  \n\n  var hasSetCustomSize = false;\n\n  var hasSetCustomClose = false;\n\n  var listeners = {};\n\n  // Internal MRAID state. Modified by the native SDK. /////////////////////////////////////////////\n\n  var state = STATES.LOADING;\n\n  var isViewable = false;\n\n  var screenSize = { width: -1, height: -1 };\n\n  \n\n  var placementType = PLACEMENT_TYPES.UNKNOWN;\n\n  var hasSetScreenSize=false;\n  var hasSetPosition=false;\n\n\n\n  var expandPropertyValidators = {\n    width: function(v) { return !isNaN(v) && v >= 0; },\n    height: function(v) { return !isNaN(v) && v >= 0; },\n    useCustomClose: function(v) { return (typeof v === 'boolean'); },\n    lockOrientation: function(v) { return (typeof v === 'boolean'); }\n  };\n\n  var resizeProperties = {\n    width: -1,\n    height: -1,\n    offsetX: -1,\n    offsetY: -1,\n    customClosePosition: 'top-right',\n    allowOffscreen: true\n  };\n\n  var orientationProperty={\n    allowOrientationChange:true,\n    forceOrientation:'none'\n  }\n\n\n\n  var orientationPropertyValidators = {\n    allowOrientationChange:function(v) { return (typeof v === 'string')},\n    forceOrientation:function(v) {return (typeof v === 'string')}\n  }\n\n  var resizePropertyValidators = {\n    width: function(v) { return !isNaN(v) && v >= 0; },\n    height: function(v) { return !isNaN(v) && v >= 0; },\n    offsetX: function(v) { return !isNaN(v) && v >= 0; },\n    offsetY: function(v) { return !isNaN(v) && v >= 0; },\n    customClosePosition: function(v) { return (typeof v === 'string')},\n    allowOffscreen: function(v) { return (typeof v === 'boolean')}\n  };\n  \n\n\n  //////////////////////////////////////////////////////////////////////////////////////////////////\n\n  var EventListeners = function(event) {\n    this.event = event;\n    this.count = 0;\n    var listeners = {};\n\n    this.add = function(func) {\n      var id = String(func);\n      if (!listeners[id]) {\n        listeners[id] = func;\n        this.count++;\n      }\n    };\n\n    this.remove = function(func) {\n      var id = String(func);\n      if (listeners[id]) {\n        listeners[id] = null;\n        delete listeners[id];\n        this.count--;\n        return true;\n      } else {\n        return false;\n      }\n    };\n\n    this.removeAll = function() {\n      for (var id in listeners) {\n        if (listeners.hasOwnProperty(id)) this.remove(listeners[id]);\n      }\n    };\n\n    this.broadcast = function(args) {\n      for (var id in listeners) {\n        if (listeners.hasOwnProperty(id)) listeners[id].apply({}, args);\n      }\n    };\n\n    this.toString = function() {\n      var out = [event, ':'];\n      for (var id in listeners) {\n        if (listeners.hasOwnProperty(id)) out.push('|', id, '|');\n      }\n      return out.join('');\n    };\n  };\n\n  var broadcastEvent = function() {\n    var args = new Array(arguments.length);\n    var l = arguments.length;\n    for (var i = 0; i < l; i++) args[i] = arguments[i];\n    var event = args.shift();\n    if (listeners[event]) listeners[event].broadcast(args);\n  };\n\n  var contains = function(value, array) {\n    for (var i in array) {\n      if (array[i] === value) return true;\n    }\n    return false;\n  };\n\n  var clone = function(obj) {\n    if (obj === null) return null;\n    var f = function() {};\n    f.prototype = obj;\n    return new f();\n  };\n\n  var stringify = function(obj) {\n    if (typeof obj === 'object') {\n      var out = [];\n      if (obj.push) {\n        // Array.\n        for (var p in obj) out.push(obj[p]);\n        return '[' + out.join(',') + ']';\n      } else {\n        // Other object.\n        for (var p in obj) out.push(\"'\" + p + \"': \" + obj[p]);\n        return '{' + out.join(',') + '}';\n      }\n    } else return String(obj);\n  };\n\n  var trim = function(str) {\n    return str.replace(/^\\s+|\\s+$/g, '');\n  };\n\n  // Functions that will be invoked by the native SDK whenever a \"change\" event occurs.\n  var changeHandlers = {\n    state: function(val) {\n      if (state === STATES.LOADING) {\n        broadcastEvent(EVENTS.INFO, 'Native SDK initialized.');\n      }\n      state = val;\n      broadcastEvent(EVENTS.INFO, 'Set state to ' + stringify(val));\n      broadcastEvent(EVENTS.STATECHANGE, state);\n    },\n\n    sizeChange: function(val) {\n      if (state === STATES.LOADING) {\n        broadcastEvent(EVENTS.INFO, 'Native SDK initialized.');\n      }\n      broadcastEvent(EVENTS.INFO, 'Set sizeChange to ' + stringify(val));\n      broadcastEvent(EVENTS.SIZECHANGE, val.width,val.height);\n    },\n\n    viewable: function(val) {\n      isViewable = val;\n      broadcastEvent(EVENTS.INFO, 'Set isViewable to ' + stringify(val));\n      broadcastEvent(EVENTS.VIEWABLECHANGE, isViewable);\n    },\n\n    placementType: function(val) {\n      broadcastEvent(EVENTS.INFO, 'Set placementType to ' + stringify(val));\n      placementType = val;\n    },\n\n    screenSize: function(val) {\n      broadcastEvent(EVENTS.INFO, 'Set screenSize to ' + stringify(val));\n      for (var key in val) {\n        if (val.hasOwnProperty(key)) screenSize[key] = val[key];\n      }\n\n      if (!hasSetCustomSize) {\n        expandProperties['width'] = screenSize['width'];\n        expandProperties['height'] = screenSize['height'];\n      }\n      \n    },\n\n    // maxSize: function(val){\n    //   broadcastEvent(EVENTS.INFO, 'Set maxSize to ' + stringify(val));\n    //   for (var key in val) {\n    //     if (val.hasOwnProperty(key)) maxSize[key] = val[key];\n    //   }\n    // },\n\n    currentProperties: function(val){\n      broadcastEvent(EVENTS.INFO, 'Merging currentProperties with ' + stringify(val));\n      for (var key in val) {\n        if (val.hasOwnProperty(key)) bridge.currentProperties[key] = val[key];\n      }\n    },\n\n    expandProperties: function(val) {\n      broadcastEvent(EVENTS.INFO, 'Merging expandProperties with ' + stringify(val));\n      for (var key in val) {\n        if (val.hasOwnProperty(key)) expandProperties[key] = val[key];\n      }\n    },\n\n    resizeProperties: function(val) {\n      broadcastEvent(EVENTS.INFO, 'Merging resizeProperties with ' + stringify(val));\n      for (var key in val) {\n        if (val.hasOwnProperty(key)) resizeProperties[key] = val[key];\n      }\n    }\n  };\n\n  var validate = function(obj, validators, action, merge) {\n    if (!merge) {\n      // Check to see if any required properties are missing.\n      if (obj === null) {\n        broadcastEvent(EVENTS.ERROR, 'Required object not provided.', action);\n        return false;\n      } else {\n        for (var i in validators) {\n          if (validators.hasOwnProperty(i) && obj[i] === undefined) {\n            broadcastEvent(EVENTS.ERROR, 'Object is missing required property: ' + i + '.', action);\n            return false;\n          }\n        }\n      }\n    }\n\n    for (var prop in obj) {\n      var validator = validators[prop];\n      var value = obj[prop];\n      if (validator && !validator(value)) {\n        // Failed validation.\n        broadcastEvent(EVENTS.ERROR, 'Value of property ' + prop + ' is invalid.',\n          action);\n        return false;\n      }\n    }\n    return true;\n  };\n\n\n\n  //////////////////////////////////////////////////////////////////////////////////////////////////\n\n  bridge.addEventListener('change', function(properties) {\n    for (var p in properties) {\n      if (properties.hasOwnProperty(p)) {\n        var handler = changeHandlers[p];\n        handler(properties[p]);\n      }\n    }\n    //alert(stringify(properties))\n  });\n\n  bridge.addEventListener('error', function(message, action) {\n    broadcastEvent(EVENTS.ERROR, message, action);\n  });\n\n  bridge.addEventListener('ready', function() {\n    broadcastEvent(EVENTS.READY);\n  });\n\n  bridge.addEventListener('video', function(properties) {\n    broadcastEvent(EVENTS.VIDEO,properties);\n    //alert(stringify(properties))\n  });\n\n  //////////////////////////////////////////////////////////////////////////////////////////////////\n\n  mraid.addEventListener = function(event, listener) {\n    if (!event || !listener) {\n      broadcastEvent(EVENTS.ERROR, 'Both event and listener are required.', 'addEventListener');\n    } else if (!contains(event, EVENTS)) {\n      broadcastEvent(EVENTS.ERROR, 'Unknown MRAID event: ' + event, 'addEventListener');\n    } else {\n      if (!listeners[event]) listeners[event] = new EventListeners(event);\n      listeners[event].add(listener);\n    }\n  };\n\n  mraid.close = function() {\n    if (state === STATES.HIDDEN) {\n      broadcastEvent(EVENTS.ERROR, 'Ad cannot be closed when it is already hidden.',\n        'close');\n    } else bridge.executeNativeCall('close');\n  };\n\n  mraid.expand = function(URL) {\n    if (this.getState() !== STATES.DEFAULT && this.getState() !== STATES.RESIZED) {\n      broadcastEvent(EVENTS.ERROR, 'Ad can only be expanded from the default state.', 'expand');\n    } else {\n      var args = ['expand'];\n\n      if (this.getHasSetCustomClose()) {\n        args = args.concat(['shouldUseCustomClose', expandProperties.useCustomClose ? 'true' : 'false']);\n      }\n\n      if (this.getHasSetCustomSize()) {\n        if (expandProperties.width >= 0 && expandProperties.height >= 0) {\n          args = args.concat(['w', expandProperties.width, 'h', expandProperties.height]);\n        }\n      }\n\n      if (typeof expandProperties.lockOrientation !== 'undefined') {\n        args = args.concat(['lockOrientation', expandProperties.lockOrientation]);\n      }\n\n      if (URL) {\n        args = args.concat(['url', URL]);\n      }\n\n      bridge.executeNativeCall.apply(this, args);\n    }\n  };\n\n  mraid.getHasSetCustomClose = function() {\n      return hasSetCustomClose;\n  };\n\n  mraid.getHasSetCustomSize = function() {\n      return hasSetCustomSize;\n  };\n\n  mraid.getExpandProperties = function() {\n    var properties = {\n      width: expandProperties.width,\n      height: expandProperties.height,\n      useCustomClose: expandProperties.useCustomClose,\n      isModal: expandProperties.isModal\n    };\n    return properties;\n  };\n\n  mraid.getPlacementType = function() {\n    return placementType;\n  };\n\n  mraid.getState = function() {\n    return state;\n  };\n\n  mraid.getVersion = function() {\n    return mraid.VERSION;\n  };\n\n  mraid.isViewable = function() {\n    return isViewable;\n  };\n\n  mraid.open = function(URL) {\n    if (!URL) broadcastEvent(EVENTS.ERROR, 'URL is required.', 'open');\n    else bridge.executeNativeCall('open', 'url', URL);\n  };\n\n  mraid.removeEventListener = function(event, listener) {\n    if (!event) broadcastEvent(EVENTS.ERROR, 'Event is required.', 'removeEventListener');\n    else {\n      if (listener && (!listeners[event] || !listeners[event].remove(listener))) {\n        broadcastEvent(EVENTS.ERROR, 'Listener not currently registered for event.',\n          'removeEventListener');\n        return;\n      } else if (listeners[event]) listeners[event].removeAll();\n\n      if (listeners[event] && listeners[event].count === 0) {\n        listeners[event] = null;\n        delete listeners[event];\n      }\n    }\n  };\n\n  mraid.setExpandProperties = function(properties) {\n    if (validate(properties, expandPropertyValidators, 'setExpandProperties', true)) {\n      if (properties.hasOwnProperty('width') || properties.hasOwnProperty('height')) {\n        hasSetCustomSize = true;\n      }\n\n      if (properties.hasOwnProperty('useCustomClose')) hasSetCustomClose = true;\n\n      var desiredProperties = ['width', 'height', 'useCustomClose', 'lockOrientation'];\n      var length = desiredProperties.length;\n      for (var i = 0; i < length; i++) {\n        var propname = desiredProperties[i];\n        if (properties.hasOwnProperty(propname)) expandProperties[propname] = properties[propname];\n      }\n    }\n  };\n\n  mraid.setOrientationProperties = function(properties) {\n    if (validate(properties, orientationProperties, 'setOrientationProperties', true)) {\n      if (properties.hasOwnProperty('allowOrientationChange')) {\n        hasSetCustomSize = true;\n      }\n\n      if (properties.hasOwnProperty('useCustomClose')) hasSetCustomClose = true;\n\n      var desiredProperties = ['width', 'height', 'useCustomClose', 'lockOrientation'];\n      var length = desiredProperties.length;\n      for (var i = 0; i < length; i++) {\n        var propname = desiredProperties[i];\n        if (properties.hasOwnProperty(propname)) expandProperties[propname] = properties[propname];\n      }\n    }\n  };\n\n  mraid.setOrientationProperties = function(){\n    return orientationProperty;\n  }\n\n  mraid.useCustomClose = function(shouldUseCustomClose) {\n    expandProperties.useCustomClose = shouldUseCustomClose;\n    hasSetCustomClose = true;\n    bridge.executeNativeCall('usecustomclose', 'shouldUseCustomClose', shouldUseCustomClose);\n  };\n\n  // MRAID 2.0 APIs ////////////////////////////////////////////////////////////////////////////////\n\n  mraid.createCalendarEvent = function(parameters) {\n    CalendarEventParser.initialize(parameters);\n    if (CalendarEventParser.parse()) {\n      bridge.executeNativeCall.apply(this, CalendarEventParser.arguments);\n    } else {\n      broadcastEvent(EVENTS.ERROR, CalendarEventParser.errors[0], 'createCalendarEvent');\n    }\n  };\n\n  mraid.supports = function(feature) {\n    return bridge.supports[feature];\n  };\n\n  mraid.playVideo = function(uri) {\n    if (!mraid.isViewable()) {\n      broadcastEvent(EVENTS.ERROR, 'playVideo cannot be called until the ad is viewable', 'playVideo');\n      return;\n    }\n\n    if (!uri) {\n      broadcastEvent(EVENTS.ERROR, 'playVideo must be called with a valid URI', 'playVideo');\n    } else {\n      bridge.executeNativeCall.apply(this, ['playVideo', 'uri', uri]);\n    }\n  };\n\n  mraid.storePicture = function(uri) {\n    if (!mraid.isViewable()) {\n      broadcastEvent(EVENTS.ERROR, 'storePicture cannot be called until the ad is viewable', 'storePicture');\n      return;\n    }\n\n    if (!uri) {\n      broadcastEvent(EVENTS.ERROR, 'storePicture must be called with a valid URI', 'storePicture');\n    } else {\n      bridge.executeNativeCall.apply(this, ['storePicture', 'uri', uri]);\n    }\n  };\n\n  \n\n  mraid.getHasSetScreenSize = function(){\n    return hasSetScreenSize;\n  }\n  mraid.getHasSetPosition = function(){\n    return hasSetPosition;\n  }\n\n  mraid.resize = function() {\n    if(this.getState() === STATES.EXPANDED){\n      broadcastEvent(EVENTS.ERROR, 'State remains expanded.', 'resize');\n    }\n    else {\n      var args = ['resize'];\n\n      if (this.getHasSetScreenSize()) {\n        if (resizeProperties.width >= 0 && resizeProperties.height >= 0) {\n          args = args.concat(['w', resizeProperties.width, 'h', resizeProperties.height]);\n        }\n      }\n\n      if (this.getHasSetPosition()){\n        args = args.concat(['x', resizeProperties.offsetX, 'y', resizeProperties.offsetY]);\n      }\n\n      if (typeof resizeProperties.customClosePosition !== 'undefined') {\n        args = args.concat(['customClosePosition', resizeProperties.customClosePosition]);\n      }\n\n      if (typeof resizeProperties.allowOffscreen !== 'undefined') {\n        args = args.concat(['allowOffscreen', resizeProperties.allowOffscreen ? 'true' : 'false']);\n      }\n      bridge.executeNativeCall.apply(this, args);\n    }\n  };\n\n  mraid.getResizeProperties = function() {\n    return resizeProperties;\n  };\n\n  mraid.setResizeProperties = function(properties) {\n    if (validate(properties, resizePropertyValidators, 'setResizeProperties', true)) {\n      if (properties.hasOwnProperty('width') || properties.hasOwnProperty('height')) {\n        if(properties.hasOwnProperty('width')){\n          resizeProperties.width=properties.width;\n        }\n        if(properties.hasOwnProperty('height')){\n          resizeProperties.height=properties.height;\n        }\n        hasSetScreenSize = true;\n      }\n\n      if (properties.hasOwnProperty('offsetX') || properties.hasOwnProperty('offsetY')) {\n        if(properties.hasOwnProperty('offsetX')){\n          resizeProperties.offsetX=properties.offsetX;\n        }\n        if(properties.hasOwnProperty('offsetY')){\n          resizeProperties.offsetY=properties.offsetY;\n        }\n        hasSetPosition = true;\n      }\n\n      if (properties.hasOwnProperty('allowOffscreen')){\n        hasSetAllowOffscreen=true;\n        resizeProperties.allowOffscreen=properties.allowOffscreen;\n      }\n\n      var desiredProperties = ['width', 'height', 'offsetX', 'offsetY', 'customClosePosition', 'allowOffscreen'];\n      var length = desiredProperties.length;\n      for (var i = 0; i < length; i++) {\n        var propname = desiredProperties[i];\n        if (properties.hasOwnProperty(propname)) properties[propname] = properties[propname];\n      }\n    }\n\n\n    bridge.executeNativeCall('setResizeProperties', 'resizeProperties', resizeProperties);\n  };\n\n  mraid.getCurrentPosition = function() {\n    return bridge.currentProperties;\n  };\n\n  mraid.getDefaultPosition = function() {\n    return bridge.defaultProperties;\n    \n  };\n\n  mraid.getMaxSize = function() {\n    return bridge.maxSize;\n  };\n\n  mraid.getScreenSize = function() {\n    return screenSize;\n  };\n\n  mraid.showVideoPlayer = function(data){\n    if(!data || typeof(data)!='object')return false;\n    data=JSON.stringify(data);\n    bridge.showVideoPlayer(data);\n  };\n\n  var CalendarEventParser = {\n    initialize: function(parameters) {\n      this.parameters = parameters;\n      this.errors = [];\n      this.arguments = ['createCalendarEvent'];\n    },\n\n    parse: function() {\n      if (!this.parameters) {\n        this.errors.push('The object passed to createCalendarEvent cannot be null.');\n      } else {\n        this.parseDescription();\n        this.parseLocation();\n        this.parseSummary();\n        this.parseStartAndEndDates();\n        this.parseReminder();\n        this.parseRecurrence();\n        this.parseTransparency();\n      }\n\n      var errorCount = this.errors.length;\n      if (errorCount) {\n        this.arguments.length = 0;\n      }\n\n      return (errorCount === 0);\n    },\n\n    parseDescription: function() {\n      this._processStringValue('description');\n    },\n\n    parseLocation: function() {\n      this._processStringValue('location');\n    },\n\n    parseSummary: function() {\n      this._processStringValue('summary');\n    },\n\n    parseStartAndEndDates: function() {\n      this._processDateValue('start');\n      this._processDateValue('end');\n    },\n\n    parseReminder: function() {\n      var reminder = this._getParameter('reminder');\n      if (!reminder) {\n        return;\n      }\n\n      if (reminder < 0) {\n        this.arguments.push('relativeReminder');\n        this.arguments.push(parseInt(reminder) / 1000);\n      } else {\n        this.arguments.push('absoluteReminder');\n        this.arguments.push(reminder);\n      }\n    },\n\n    parseRecurrence: function() {\n      var recurrenceDict = this._getParameter('recurrence');\n      if (!recurrenceDict) {\n        return;\n      }\n\n      this.parseRecurrenceInterval(recurrenceDict);\n      this.parseRecurrenceFrequency(recurrenceDict);\n      this.parseRecurrenceEndDate(recurrenceDict);\n      this.parseRecurrenceArrayValue(recurrenceDict, 'daysInWeek');\n      this.parseRecurrenceArrayValue(recurrenceDict, 'daysInMonth');\n      this.parseRecurrenceArrayValue(recurrenceDict, 'daysInYear');\n      this.parseRecurrenceArrayValue(recurrenceDict, 'monthsInYear');\n    },\n\n    parseTransparency: function() {\n      var validValues = ['opaque', 'transparent'];\n\n      if (this.parameters.hasOwnProperty('transparency')) {\n        var transparency = this.parameters['transparency'];\n        if (contains(transparency, validValues)) {\n          this.arguments.push('transparency');\n          this.arguments.push(transparency);\n        } else {\n          this.errors.push('transparency must be opaque or transparent');\n        }\n      }\n    },\n\n    parseRecurrenceArrayValue: function(recurrenceDict, kind) {\n      if (recurrenceDict.hasOwnProperty(kind)) {\n        var array = recurrenceDict[kind];\n        if (!array || !(array instanceof Array)) {\n          this.errors.push(kind + ' must be an array.');\n        } else {\n          var arrayStr = array.join(',');\n          this.arguments.push(kind);\n          this.arguments.push(arrayStr);\n        }\n      }\n    },\n\n    parseRecurrenceInterval: function(recurrenceDict) {\n      if (recurrenceDict.hasOwnProperty('interval')) {\n        var interval = recurrenceDict['interval'];\n        if (!interval) {\n          this.errors.push('Recurrence interval cannot be null.');\n        } else {\n          this.arguments.push('interval');\n          this.arguments.push(interval);\n        }\n      } else {\n        // If a recurrence rule was specified without an interval, use a default value of 1.\n        this.arguments.push('interval');\n        this.arguments.push(1);\n      }\n    },\n\n    parseRecurrenceFrequency: function(recurrenceDict) {\n      if (recurrenceDict.hasOwnProperty('frequency')) {\n        var frequency = recurrenceDict['frequency'];\n        var validFrequencies = ['daily', 'weekly', 'monthly', 'yearly'];\n        if (contains(frequency, validFrequencies)) {\n          this.arguments.push('frequency');\n          this.arguments.push(frequency);\n        } else {\n          this.errors.push('Recurrence frequency must be one of: \"daily\", \"weekly\", \"monthly\", \"yearly\".');\n        }\n      }\n    },\n\n    parseRecurrenceEndDate: function(recurrenceDict) {\n      var expires = recurrenceDict['expires'];\n\n      if (!expires) {\n        return;\n      }\n\n      this.arguments.push('expires');\n      this.arguments.push(expires);\n    },\n\n    _getParameter: function(key) {\n      if (this.parameters.hasOwnProperty(key)) {\n        return this.parameters[key];\n      }\n\n      return null;\n    },\n\n    _processStringValue: function(kind) {\n      if (this.parameters.hasOwnProperty(kind)) {\n        var value = this.parameters[kind];\n        this.arguments.push(kind);\n        this.arguments.push(value);\n      }\n    },\n\n    _processDateValue: function(kind) {\n      if (this.parameters.hasOwnProperty(kind)) {\n        var dateString = this._getParameter(kind);\n        this.arguments.push(kind);\n        this.arguments.push(dateString);\n      }\n    },\n  };\n}());</script>");; paramString = str)
    {
      f.a(new Runnable()
      {
        public final void run()
        {
          try
          {
            if (!AFBannerWebView.b(AFBannerWebView.this)) {
              AFBannerWebView.this.loadDataWithBaseURL(null, paramString, "text/html", "UTF-8", null);
            }
            return;
          }
          catch (Exception localException)
          {
            j.b(localException, "load url error");
          }
        }
      });
      return;
      if (str.contains("<script src=\"mraid.js\" />"))
      {
        paramString = "<script src=\"mraid.js\" />";
        break;
      }
      if (str.contains("<script type=\"text/javascript\" src=\"mraid.js\"></script>"))
      {
        paramString = "<script type=\"text/javascript\" src=\"mraid.js\"></script>";
        break;
      }
      if (!str.contains("<script type=\"text/javascript\" src=\"mraid.js\" />")) {
        break;
      }
      paramString = "<script type=\"text/javascript\" src=\"mraid.js\" />";
      break;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    b("window.mraidbridge.fireErrorEvent('" + paramString1 + "', '" + paramString2 + "');");
  }
  
  public final void a(ArrayList<w> paramArrayList)
  {
    paramArrayList = paramArrayList.toString();
    if (paramArrayList.length() < 2) {
      return;
    }
    paramArrayList = "{" + paramArrayList.substring(1, paramArrayList.length() - 1) + "}";
    b("window.mraidbridge.fireChangeEvent(" + paramArrayList + ");");
    new StringBuilder("Fire changes: ").append(paramArrayList).toString();
    j.a();
  }
  
  public final void b(w paramw)
  {
    paramw = "{" + paramw.toString() + "}";
    b("window.mraidbridge.fireChangeEvent(" + paramw + ");");
    new StringBuilder("Fire change: ").append(paramw).toString();
    j.a();
  }
  
  public final void b(String paramString)
  {
    new StringBuilder("injectJavaScript = ").append(paramString).toString();
    j.a();
    try
    {
      if ((!this.j) && (this.m) && (paramString != null)) {
        super.loadUrl("javascript:" + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      j.b(paramString, "inject js error");
    }
  }
  
  public final boolean b()
  {
    return (this.l.equals("video")) || ((this.k != null) && (this.k.getParent() != null));
  }
  
  public final c c()
  {
    return this.b;
  }
  
  public final p d()
  {
    return this.c;
  }
  
  public final void destroy()
  {
    if (!this.j)
    {
      this.j = true;
      if (this.k != null)
      {
        ViewGroup localViewGroup = (ViewGroup)this.k.getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(this.k);
        }
        this.k.a();
      }
      super.destroy();
      this.c.b();
    }
  }
  
  public final b.a e()
  {
    n localn = this.d;
    return null;
  }
  
  public final p.a f()
  {
    return this.d.a;
  }
  
  public final b.a g()
  {
    n localn = this.d;
    return null;
  }
  
  public final b.a h()
  {
    n localn = this.d;
    return null;
  }
  
  public final b.a i()
  {
    n localn = this.d;
    return null;
  }
  
  public final void j()
  {
    b("window.mraidbridge.fireReadyEvent();");
  }
  
  public final void k()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("sms", true);
      localJSONObject.put("tel", com.appflood.e.c.t);
      localJSONObject.put("calendar", true);
      localJSONObject.put("storePicture", true);
      localJSONObject.put("inlineVideo", true);
      b("window.mraidbridge.supports=" + localJSONObject.toString() + ";");
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  public final void l()
  {
    f.a(new Runnable()
    {
      public final void run()
      {
        if (AFBannerWebView.this.getWidth() <= 0)
        {
          f.a(this, 500L);
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          DisplayMetrics localDisplayMetrics = new DisplayMetrics();
          ((WindowManager)AFBannerWebView.this.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
          localJSONObject.put("width", (int)(AFBannerWebView.this.getWidth() * (160.0D / localDisplayMetrics.densityDpi)));
          localJSONObject.put("height", (int)(AFBannerWebView.this.getHeight() * (160.0D / localDisplayMetrics.densityDpi)));
          int[] arrayOfInt = new int[2];
          AFBannerWebView.this.getLocationOnScreen(arrayOfInt);
          new StringBuilder("location x ").append(arrayOfInt[0]).append(" y = ").append(arrayOfInt[1]).toString();
          j.a();
          localJSONObject.put("x", (int)(arrayOfInt[0] * (160.0D / localDisplayMetrics.densityDpi)));
          localJSONObject.put("y", (int)((arrayOfInt[1] - AFListActivity.1.a(AFBannerWebView.this.getContext())) * (160.0D / localDisplayMetrics.densityDpi)));
          AFBannerWebView.this.b("window.mraidbridge.defaultProperties=" + localJSONObject.toString() + ";");
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;) {}
        }
      }
    }, 500L);
  }
  
  public final void m()
  {
    f.a(new Runnable()
    {
      public final void run()
      {
        if (AFBannerWebView.this.getWidth() <= 0)
        {
          f.a(this, 500L);
          return;
        }
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)AFBannerWebView.this.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        int[] arrayOfInt = new int[2];
        AFBannerWebView.this.getLocationOnScreen(arrayOfInt);
        new StringBuilder("location x ").append(arrayOfInt[0]).append(" y = ").append(arrayOfInt[1]).append(" getWidth() ").append(AFBannerWebView.this.getWidth()).append(" getHeight() ").append(AFBannerWebView.this.getHeight()).toString();
        j.a();
        AFBannerWebView localAFBannerWebView = AFBannerWebView.this;
        int i = (int)(AFBannerWebView.this.getWidth() * (160.0D / localDisplayMetrics.densityDpi));
        int j = (int)(AFBannerWebView.this.getHeight() * (160.0D / localDisplayMetrics.densityDpi));
        int k = (int)(arrayOfInt[0] * (160.0D / localDisplayMetrics.densityDpi));
        double d = arrayOfInt[1] - AFListActivity.1.a(AFBannerWebView.this.getContext());
        localAFBannerWebView.a(new a(i, j, k, (int)(160.0D / localDisplayMetrics.densityDpi * d)));
      }
    }, 0L);
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    j.a();
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    j.a();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public final void reload()
  {
    a(this.g);
  }
  
  public class LogJs
  {
    public LogJs() {}
    
    public void command(final String paramString)
    {
      new StringBuilder(" command url = ").append(paramString).append(" trrrr ").append(URLDecoder.decode(paramString)).toString();
      j.a();
      if (Uri.parse(paramString).getScheme().equals("mraid")) {
        f.a(new Runnable()
        {
          public final void run()
          {
            AFBannerWebView.a(AFBannerWebView.this, URI.create(paramString));
          }
        });
      }
    }
    
    public void log(String paramString)
    {
      j.d("from web page : " + paramString);
    }
    
    public void showVideoPlayer(final String paramString)
    {
      paramString = j.e(paramString);
      new StringBuilder("showVideoPlayer j =  ").append(paramString).toString();
      j.a();
      if ((paramString == null) || (paramString.length() <= 0))
      {
        AFBannerWebView.a(AFBannerWebView.this, false);
        return;
      }
      f.a(new Runnable()
      {
        public final void run()
        {
          AFBannerWebView.d(AFBannerWebView.this).a(false);
          AFBannerWebView.d(AFBannerWebView.this).a(false, t.b);
          if (AFBannerWebView.i(AFBannerWebView.this) == null) {}
          try
          {
            paramString.put("show_type", AFBannerWebView.a(AFBannerWebView.this).get("show_type"));
            AFBannerWebView.a(AFBannerWebView.this, new com.appflood.d.a(AFBannerWebView.this.getContext(), AFBannerWebView.this, paramString));
            AFBannerWebView.i(AFBannerWebView.this).a(new com.appflood.c.b()
            {
              public final void onClick() {}
              
              public final void onClose()
              {
                
                if (AFBannerWebView.h(AFBannerWebView.this) != null) {
                  AFBannerWebView.h(AFBannerWebView.this).onClose();
                }
              }
              
              public final void onComplete()
              {
                
                if (AFBannerWebView.h(AFBannerWebView.this) != null) {
                  AFBannerWebView.h(AFBannerWebView.this).onComplete();
                }
              }
              
              public final void onFinish(HashMap<String, Object> paramAnonymous2HashMap)
              {
                
                if (AFBannerWebView.h(AFBannerWebView.this) != null)
                {
                  paramAnonymous2HashMap.put("type", AFBannerWebView.j(AFBannerWebView.this));
                  paramAnonymous2HashMap.put("resize", Boolean.valueOf(true));
                  AFBannerWebView.h(AFBannerWebView.this).onFinish(paramAnonymous2HashMap);
                }
              }
            });
            AFBannerWebView.this.addView(AFBannerWebView.i(AFBannerWebView.this), new ViewGroup.LayoutParams(-1, -1));
            AFBannerWebView.this.setClickable(false);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;) {}
          }
        }
      });
    }
  }
  
  final class a
    extends WebChromeClient
  {
    private a() {}
    
    public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      new StringBuilder("jsAlert url ").append(paramString1).append(" message ").append(paramString2).toString();
      j.a();
      return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
    }
    
    public final void onProgressChanged(WebView paramWebView, int paramInt)
    {
      new StringBuilder("AF webview page onProgressChanged ").append(paramInt).toString();
      j.a();
      if (paramInt == 100)
      {
        AFBannerWebView.a(AFBannerWebView.this, true);
        if (!AFBannerWebView.c(AFBannerWebView.this))
        {
          AFBannerWebView.d(AFBannerWebView.this).c();
          AFBannerWebView.this.k();
          AFBannerWebView.this.a(new u(AFBannerWebView.e(AFBannerWebView.this)));
          AFBannerWebView.this.j();
          AFBannerWebView.this.g();
          AFBannerWebView.f(AFBannerWebView.this);
        }
      }
    }
  }
  
  final class b
    extends WebViewClient
  {
    private b() {}
    
    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      new StringBuilder("AF webview page Finished url= ").append(paramString).toString();
      j.a();
    }
    
    public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      new StringBuilder("AF webview page Started url= ").append(paramString).toString();
      j.a();
    }
    
    public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      j.a(null, "AF webview page Finished code=  " + paramInt + " desc " + paramString1);
      if (AFBannerWebView.h(AFBannerWebView.this) != null)
      {
        paramWebView = new HashMap();
        paramWebView.put("result", Boolean.valueOf(false));
        paramWebView.put("w", Integer.valueOf(0));
        paramWebView.put("h", Integer.valueOf(0));
        AFBannerWebView.h(AFBannerWebView.this).onFinish(paramWebView);
      }
    }
    
    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      new StringBuilder("AF webview shouldOverrideUrlLoading url= ").append(paramString).toString();
      j.a();
      if (AFBannerWebView.b(AFBannerWebView.this)) {
        return true;
      }
      paramWebView = Uri.parse(paramString);
      paramWebView.getHost();
      String str2 = paramWebView.getScheme();
      if ("tel".equals(str2))
      {
        paramWebView = paramString.substring(str2.length() + 1, paramString.length());
        AFListActivity.1.a(AFBannerWebView.this.getContext(), paramWebView);
        AFBannerWebView.g(AFBannerWebView.this);
        return true;
      }
      if ("sms".equals(str2))
      {
        String str1 = URLDecoder.decode(paramString);
        paramWebView = "";
        paramString = str1;
        if (str1.contains("?body="))
        {
          paramWebView = str1.split("body=");
          paramString = paramWebView[0].substring(0, paramWebView[0].length() - 1);
          paramWebView = paramWebView[1];
        }
        paramString = paramString.substring(str2.length() + 1, paramString.length());
        AFListActivity.1.a(AFBannerWebView.this.getContext(), paramString, paramWebView);
        AFBannerWebView.g(AFBannerWebView.this);
        return true;
      }
      if ("mraid".equals(str2))
      {
        AFBannerWebView.a(AFBannerWebView.this, URI.create(paramString));
        return true;
      }
      paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      AFListActivity.1.a(AFBannerWebView.this.getContext(), paramWebView);
      AFBannerWebView.g(AFBannerWebView.this);
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/mraid/AFBannerWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
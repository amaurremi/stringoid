package com.inneractive.api.ads.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;

import java.io.IOException;
import java.net.URI;

class IAbaseWebView
        extends WebView
        implements l.a {
    static String playerState = "IDLE";
    boolean mClicked;
    Context mContext;
    private BroadcastReceiver mScreenStateReceiver;
    IAbaseWebView.a mWebChromeClient;

    IAbaseWebView(Context paramContext) {
        super(paramContext);
        blockZoomAndScroll();
        WebSettings localWebSettings = getSettings();
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setLoadsImagesAutomatically(true);
        localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        this.mContext = paramContext;
        enablePlugins(true);
        setFocusable(true);
        setBackgroundColor(0);
        setChromeClient(this);
        try {
            if (IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.h)) {
                new IAreflectionHandler.a(this, "setWebContentsDebuggingEnabled").a(Boolean.TYPE, Boolean.valueOf(true)).a();
            }
            registerScreenMode();
            return;
        } catch (Exception paramContext) {
            for (; ; ) {
                InneractiveAdView.Log.d("Inneractive_debug", "Could not set web contents debugging flag");
            }
        }
    }

    private void blockZoomAndScroll() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
    }

    private void registerScreenMode() {
        this.mScreenStateReceiver = new IAbaseWebView .3 (this);
        IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        localIntentFilter.addAction("android.intent.action.USER_PRESENT");
        this.mContext.registerReceiver(this.mScreenStateReceiver, localIntentFilter);
    }

    static void setPlayerState(String paramString) {
        playerState = paramString;
    }

    private void unregisterScreenMode() {
        try {
            this.mContext.unregisterReceiver(this.mScreenStateReceiver);
            return;
        } catch (Exception localException) {
            InneractiveAdView.Log.d("Inneractive_debug", "Broadcast receiver was not registered and therfore won't be released.");
        }
    }

    public void destroy() {
        unregisterScreenMode();
        c.a(this);
        super.destroy();
    }

    protected void enablePlugins(boolean paramBoolean) {
        if (IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.g)) {
            return;
        }
        IAdefines.ApiLevel localApiLevel = IAdefines.ApiLevel.a();
        Object localObject2 = IAdefines.ApiLevel.a;
        int i;
        if (localApiLevel.i < ((IAdefines.ApiLevel) localObject2).i) {
            i = 1;
            if (i == 0) {
                break label118;
            }
            try {
                new IAreflectionHandler.a(getSettings(), "setPluginsEnabled").a(Boolean.TYPE, Boolean.valueOf(paramBoolean)).a();
                return;
            } catch (Exception localException1) {
                localObject2 = new StringBuilder("Failed to ");
                if (!paramBoolean) {
                }
            }
        }
        for (Object localObject1 = "enable"; ; localObject1 = "disable") {
            InneractiveAdView.Log.d("Inneractive_debug", (String) localObject1 + "WebSettings plugins for IAbaseWebView.");
            return;
            i = 0;
            break;
        }
        for (; ; ) {
            try {
                label118:
                localObject2 = new IAreflectionHandler.a(getSettings(), "setPluginState");
                if (paramBoolean) {
                    localObject1 = WebSettings.PluginState.ON;
                    ((IAreflectionHandler.a) localObject2).a(WebSettings.PluginState.class, localObject1).a();
                    return;
                }
            } catch (Exception localException2) {
                InneractiveAdView.Log.d("Inneractive_debug", "Failed to modify WebView plugin state.");
                return;
            }
            WebSettings.PluginState localPluginState = WebSettings.PluginState.OFF;
        }
    }

    public V getListener() {
        return null;
    }

    String getResponseFromLocalFile(String paramString) {
        InneractiveAdView.Log.d("Inneractive_debug", "Try to read response from file: " + paramString);
        AssetManager localAssetManager = this.mContext.getAssets();
        try {
            paramString = c.a(localAssetManager.open(paramString));
            return paramString;
        } catch (IOException paramString) {
            InneractiveAdView.Log.d("Inneractive_debug", "Could not read response from file");
            InneractiveAdView.Log.v("Inneractive_verbose", c.a(paramString));
        }
        return "";
    }

    void invokeJS(String paramString) {
        if (IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.h)) {
            InneractiveAdView.Log.v("Inneractive_verbose", "Javascript to invoke (KitKat): " + paramString.substring(11));
            try {
                IAbaseWebView .1 local1 = new IAbaseWebView .1 (this);
                new IAreflectionHandler.a(this, "evaluateJavascript").a(String.class, paramString).a(ValueCallback.class, local1).a();
                return;
            } catch (Exception paramString) {
                InneractiveAdView.Log.d("Inneractive_verbose", "Failed to invoke Javascript (KITKAT)");
                return;
            }
        }
        InneractiveAdView.Log.d("Inneractive_debug", "Javascript to invoke: " + paramString);
        super.loadUrl(paramString);
    }

    void loadHtmlData(String paramString1, String paramString2) {
        paramString2 = "<html><head><script> window.iaPreCachedAd = true; </script>" + "<script>var prevWindowOnError = window.onerror; window.onerror = function(err) {if (typeof prevWindowOnError === 'function') {prevWindowOnError.apply();} console.log('WINDOW.ONERROR Javascript Error: ' + err);};</script>" + "</head><style>body {text-align:center} #iaClose {display:none}</style><body id=\"iaBody\" margin:0;padding:0;><script>" + "  (function() {\n    var isIOS = (/iphone|ipad|ipod/i).test(window.navigator.userAgent.toLowerCase());\n    if (isIOS) {\n      console = {};\n      console.log = function(log) {\n        var iframe = document.createElement('iframe');\n        iframe.setAttribute('src', 'ios-log: ' + log);\n        document.documentElement.appendChild(iframe);\n        iframe.parentNode.removeChild(iframe);\n        iframe = null;\n      };\n      console.debug = console.info = console.warn = console.error = console.log;\n    }\n  }());\n  (function() {\n  // Establish the root mraidbridge object.\n  var mraidbridge = window.mraidbridge = {};\n  // Listeners for bridge events.\n  var listeners = {};\n  // Queue to track pending calls to the native SDK.\n  var nativeCallQueue = [];\n  // Whether a native call is currently in progress.\n  var nativeCallInFlight = false;\n  //////////////////////////////////////////////////////////////////////////////////////////////////\n  mraidbridge.fireReadyEvent = function() {\n    mraidbridge.fireEvent('ready');\n  };\n  mraidbridge.fireChangeEvent = function(properties) {\n    mraidbridge.fireEvent('change', properties);\n  };\n  mraidbridge.fireErrorEvent = function(message, action) {\n    mraidbridge.fireEvent('error', message, action);\n  };\n  mraidbridge.fireEvent = function(type) {\n    var ls = listeners[type];\n    if (ls) {\n      var args = Array.prototype.slice.call(arguments);\n      args.shift();\n      var l = ls.length;\n      for (var i = 0; i < l; i++) {\n        ls[i].apply(null, args);\n      }\n    }\n  };\n  mraidbridge.nativeCallComplete = function(command) {\n    if (nativeCallQueue.length === 0) {\n      nativeCallInFlight = false;\n      return;\n    }\n    var nextCall = nativeCallQueue.pop();\n    window.location = nextCall;\n  };\n  mraidbridge.executeNativeCall = function(command) {\n    var call = 'mraid://' + command;\n    var key, value;\n    var isFirstArgument = true;\n    for (var i = 1; i < arguments.length; i += 2) {\n      key = arguments[i];\n      value = arguments[i + 1];\n      if (value === null) continue;\n      if (isFirstArgument) {\n        call += '?';\n        isFirstArgument = false;\n      } else {\n        call += '&';\n      }\n      call += encodeURIComponent(key) + '=' + encodeURIComponent(value);\n    }\n    if (nativeCallInFlight) {\n      nativeCallQueue.push(call);\n    } else {\n      nativeCallInFlight = true;\n      window.location = call;\n    }\n  };\n  //////////////////////////////////////////////////////////////////////////////////////////////////\n  mraidbridge.addEventListener = function(event, listener) {\n    var eventListeners;\n    listeners[event] = listeners[event] || [];\n    eventListeners = listeners[event];\n    for (var l in eventListeners) {\n      // Listener already registered, so no need to add it.\n      if (listener === l) return;\n    }\n    eventListeners.push(listener);\n  };\n  mraidbridge.removeEventListener = function(event, listener) {\n    if (listeners.hasOwnProperty(event)) {\n      var eventListeners = listeners[event];\n      if (eventListeners) {\n        var idx = eventListeners.indexOf(listener);\n        if (idx !== -1) {\n          eventListeners.splice(idx, 1);\n        }\n      }\n    }\n  };\n  }());\n  (function() {\n  var mraid = window.mraid = {};\n  var bridge = window.mraidbridge;\n              // Constants. ////////////////////////////////////////////////////////////////////////////////////\n              var VERSION = mraid.VERSION = '2.0';\n              var STATES = mraid.STATES = {\n    LOADING: 'loading',     // Initial state.\n    DEFAULT: 'default',\n    EXPANDED: 'expanded',\n    HIDDEN: 'hidden',\n    RESIZED: 'resized'\n  };\n              var EVENTS = mraid.EVENTS = {\n    ERROR: 'error',\n    INFO: 'info',\n    READY: 'ready',\n    STATECHANGE: 'stateChange',\n    VIEWABLECHANGE: 'viewableChange',\n    SIZECHANGE: 'sizeChange'  \n  };\n              var PLACEMENT_TYPES = mraid.PLACEMENT_TYPES = {\n    UNKNOWN: 'unknown',\n    INLINE: 'inline',\n    INTERSTITIAL: 'interstitial'\n  };\n              // External MRAID state: may be directly or indirectly modified by the ad JS. ////////////////////\n              // Properties which define the behavior of an expandable ad.\n  var expandProperties = {\n    width: -1,\n    height: -1,\n    useCustomClose: false,\n    isModal: true,\n    lockOrientation: false\n  };\n  var hasSetCustomSize = false;\n  var hasSetCreativeSize = false;\n  var hasSetCreativeOffset = false;\n  var hasSetCustomClose = false;\n  var listeners = {};\n  // Internal MRAID state. Modified by the native SDK. /////////////////////////////////////////////\n  var state = STATES.LOADING;\n  var isViewable = false;\n  var screenSize = { width: -1, height: -1 };\n  var maxSize = { width: -1, height: -1 };\n  var adSize = { width: -1, height: -1 };\n  // Properties which define the behavior of an resized ad.\n   var resizeProperties = {  \n       width:-1,  \n       height:-1,  \n       customClosePosition:'top-right',  \n       offsetX:0,  \n       offsetY:0,  \n       allowOffscreen:true  \n   };  \n  var orientationProperties = {\n    allowOrientationChange:true,\n    forceOrientation:'none'\n  };\n  var placementType = PLACEMENT_TYPES.UNKNOWN;\n  var supports = {\n    sms: false,\n    tel: false,\n    calendar: false,\n    storePicture: false,\n    inlineVideo: false\n  };\n              //////////////////////////////////////////////////////////////////////////////////////////////////\n  var EventListeners = function(event) {\n    this.event = event;\n    this.count = 0;\n    var listeners = {};\n    this.add = function(func) {\n      var id = String(func);\n      if (!listeners[id]) {\n        listeners[id] = func;\n        this.count++;\n      }\n    };\n    this.remove = function(func) {\n      var id = String(func);\n      if (listeners[id]) {\n        listeners[id] = null;\n        delete listeners[id];\n        this.count--;\n        return true;\n      } else {\n        return false;\n      }\n    };\n    this.removeAll = function() {\n      for (var id in listeners) {\n        if (listeners.hasOwnProperty(id)) this.remove(listeners[id]);\n      }\n    };\n    this.broadcast = function(args) {\n      for (var id in listeners) {\n        if (listeners.hasOwnProperty(id)) listeners[id].apply({}, args);\n      }\n    };\n    this.toString = function() {\n      var out = [event, ':'];\n      for (var id in listeners) {\n        if (listeners.hasOwnProperty(id)) out.push('|', id, '|');\n      }\n      return out.join('');\n    };\n  };\n  var broadcastEvent = function() {\n    var args = new Array(arguments.length);\n    var l = arguments.length;\n    for (var i = 0; i < l; i++) args[i] = arguments[i];\n    var event = args.shift();\n    if (listeners[event]) listeners[event].broadcast(args);\n  };\n  var contains = function(value, array) {\n    for (var i in array) {\n      if (array[i] === value) return true;\n    }\n    return false;\n  };\n  var clone = function(obj) {\n    if (obj === null) return null;\n    var f = function() {};\n    f.prototype = obj;\n    return new f();\n  };\n  var stringify = function(obj) {\n    if (typeof obj === 'object') {\n      var out = [];\n      if (obj.push) {\n        // Array.\n        for (var p in obj) out.push(obj[p]);\n        return '[' + out.join(',') + ']';\n      } else {\n        // Other object.\n        for (var p in obj) out.push(\"'\" + p + \"': \" + obj[p]);\n        return '{' + out.join(',') + '}';\n      }\n    } else return String(obj);\n  };\n  // Functions that will be invoked by the native SDK whenever a 'change' event occurs.\n  var changeHandlers = {\n    state: function(val) {\n      if (state === STATES.LOADING) {\n        broadcastEvent(EVENTS.INFO, 'Native SDK initialized.');\n      }\n      state = val;\n      broadcastEvent(EVENTS.INFO, 'Set state to ' + stringify(val));\n      broadcastEvent(EVENTS.STATECHANGE, state);\n    },\n    viewable: function(val) {\n      isViewable = val;\n      broadcastEvent(EVENTS.INFO, 'Set isViewable to ' + stringify(val));\n      broadcastEvent(EVENTS.VIEWABLECHANGE, isViewable);\n    },\n    placementType: function(val) {\n      broadcastEvent(EVENTS.INFO, 'Set placementType to ' + stringify(val));\n      placementType = val;\n    },\n    adSize: function(val) {\n      for (var key in val) {\n        if (val.hasOwnProperty(key)) adSize[key] = val[key];\n      }\n      if (!hasSetCustomSize) {\n        broadcastEvent(EVENTS.SIZECHANGE, adSize['width'], adSize['height']);\n      }\n    },\n    screenSize: function(val) {\n      broadcastEvent(EVENTS.INFO, 'Set screenSize to ' + stringify(val));\n      for (var key in val) {\n        if (val.hasOwnProperty(key)) screenSize[key] = val[key];\n      }\n      if (!hasSetCustomSize) {\n        expandProperties['width'] = screenSize['width'];\n        expandProperties['height'] = screenSize['height'];\n      }\n    },\n    maxSize: function(val) {\n      broadcastEvent(EVENTS.INFO, 'Set maxSize to ' + stringify(val));\n      for (var key in val) {\n        if (val.hasOwnProperty(key)) maxSize[key] = val[key];\n      }\n    },\n    expandProperties: function(val) {\n      broadcastEvent(EVENTS.INFO, 'Merging expandProperties with ' + stringify(val));\n      for (var key in val) {\n        if (val.hasOwnProperty(key)) expandProperties[key] = val[key];\n      }\n    },\n    resizeProperties: function(val) {\n      broadcastEvent(EVENTS.INFO, 'Merging resizeProperties with ' + stringify(val));\n      for (var key in val) {\n        if (val.hasOwnProperty(key)) resizeProperties[key] = val[key];\n      }\n    },\n    orientationProperties: function(val) {\n      broadcastEvent(EVENTS.INFO, 'Merging orientationProperties with ' + stringify(val));\n      for (var key in val) {\n        if (val.hasOwnProperty(key)) orientationProperties[key] = val[key];\n      }\n    },\n    supports: function(val) {\n      broadcastEvent(EVENTS.INFO, 'Set supports to ' + stringify(val));\n        supports = val;\n    }\n  };\n  var validate = function(obj, validators, action, merge) {\n    if (!merge) {\n      // Check to see if any required properties are missing.\n      if (obj === null) {\n        broadcastEvent(EVENTS.ERROR, 'Required object not provided.', action);\n        return false;\n      } else {\n        for (var i in validators) {\n          if (validators.hasOwnProperty(i) && obj[i] === undefined) {\n            broadcastEvent(EVENTS.ERROR, 'Object is missing required property: ' + i + '.', action);\n            return false;\n          }\n        }\n      }\n    }\n    for (var prop in obj) {\n      var validator = validators[prop];\n      var value = obj[prop];\n      if (validator && !validator(value)) {\n        // Failed validation.\n        broadcastEvent(EVENTS.ERROR, 'Value of property ' + prop + ' is invalid.',\n          action);\n        return false;\n      }\n    }\n    return true;\n  };\n  var expandPropertyValidators = {\n    width: function(v) { return !isNaN(v) && v >= 0; },\n    height: function(v) { return !isNaN(v) && v >= 0; },\n    useCustomClose: function(v) { return (typeof v === 'boolean'); },\n    lockOrientation: function(v) { return (typeof v === 'boolean'); }\n  };\n  var resizePropertyValidators = {\n    width: function(v) { return !isNaN(v) && v >= 0; },\n    height: function(v) { return !isNaN(v) && v >= 0; },\n    offsetX: function(v) { return !isNaN(v); },\n    offsetY: function(v) { return !isNaN(v); },\n    allowOffscreen: function(v) { return (typeof v === 'boolean'); }\n  };\n  var orientationPropertyValidators = {\n    allowOrientationChange: function(v) { return (typeof v === 'boolean'); },\n    forceOrientation: function(v) { return !isNaN(v)}\n  };\n              //////////////////////////////////////////////////////////////////////////////////////////////////\n  bridge.addEventListener('change', function(properties) {\n    for (var p in properties) {\n      if (properties.hasOwnProperty(p)) {\n        var handler = changeHandlers[p];\n        handler(properties[p]);\n      }\n    }\n  });\n  bridge.addEventListener('error', function(message, action) {\n    broadcastEvent(EVENTS.ERROR, message, action);\n  });\n  bridge.addEventListener('ready', function() {\n    broadcastEvent(EVENTS.READY);\n  });\n              //////////////////////////////////////////////////////////////////////////////////////////////////\n  mraid.addEventListener = function(event, listener) {\n   if (!event || !listener) {\n      broadcastEvent(EVENTS.ERROR, 'Both event and listener are required.', 'addEventListener');\n    } else if (!contains(event, EVENTS)) {\n      broadcastEvent(EVENTS.ERROR, 'Unknown MRAID event: ' + event, 'addEventListener');\n    } else {\n      if (!listeners[event]) listeners[event] = new EventListeners(event);\n      listeners[event].add(listener);\n    }\n  };\n  mraid.close = function() {\n    if (state === STATES.HIDDEN) {\n      broadcastEvent(EVENTS.ERROR, 'Ad cannot be closed when it is already hidden.',\n        'close');\n    } else bridge.executeNativeCall('close');\n  };\n  mraid.expand = function(URL) {\n    if (state !== STATES.DEFAULT) {\n      broadcastEvent(EVENTS.ERROR, 'Ad can only be expanded from the default state.', 'expand');\n    } else {\n      var args = ['expand'];\n                  if (mraid.getHasSetCustomClose()) {\n        args = args.concat(['shouldUseCustomClose', expandProperties.useCustomClose ? 'true' : 'false']);\n      }\n                  if (mraid.getHasSetCustomSize()) {\n        if (expandProperties.width >= 0 && expandProperties.height >= 0) {\n          args = args.concat(['w', expandProperties.width, 'h', expandProperties.height]);\n        }\n      }\n                  if (typeof expandProperties.lockOrientation !== 'undefined') {\n        args = args.concat(['lockOrientation', expandProperties.lockOrientation]);\n      }\n                  if (URL) {\n        args = args.concat(['url', URL]);\n      }\n                  bridge.executeNativeCall.apply(this, args);\n    }\n  };\n  mraid.getHasSetCustomClose = function() {\n      return hasSetCustomClose;\n  };\n  mraid.getHasSetCustomSize = function() {\n      return hasSetCustomSize;\n  };\n  mraid.getExpandProperties = function() {\n    var properties = {\n      width: expandProperties.width,\n      height: expandProperties.height,\n      useCustomClose: expandProperties.useCustomClose,\n      isModal: expandProperties.isModal\n    };\n    return properties;\n  };\n  mraid.getPlacementType = function() {\n    return placementType;\n  };\n  mraid.getState = function() {\n    return state;\n  };\n  mraid.getVersion = function() {\n    return mraid.VERSION;\n  };\n  mraid.isViewable = function() {\n    return isViewable;\n  };\n  mraid.open = function(URL) {\n    if (!URL) broadcastEvent(EVENTS.ERROR, 'URL is required.', 'open');\n    else bridge.executeNativeCall('open', 'url', URL);\n  };\n  mraid.removeEventListener = function(event, listener) {\n    if (!event) broadcastEvent(EVENTS.ERROR, 'Event is required.', 'removeEventListener');\n    else {\n      if (listener && (!listeners[event] || !listeners[event].remove(listener))) {\n        broadcastEvent(EVENTS.ERROR, 'Listener not currently registered for event.',\n          'removeEventListener');\n        return;\n      } else if (listeners[event]) listeners[event].removeAll();\n                  if (listeners[event] && listeners[event].count === 0) {\n        listeners[event] = null;\n        delete listeners[event];\n      }\n    }\n  };\n  mraid.setExpandProperties = function(properties) {\n    if (validate(properties, expandPropertyValidators, 'setExpandProperties', true)) {\n      if (properties.hasOwnProperty('width') || properties.hasOwnProperty('height')) {\n        hasSetCustomSize = true;\n      }\n                  if (properties.hasOwnProperty('useCustomClose')) hasSetCustomClose = true;\n                  var desiredProperties = ['width', 'height', 'useCustomClose', 'lockOrientation'];\n      var length = desiredProperties.length;\n      for (var i = 0; i < length; i++) {\n        var propname = desiredProperties[i];\n        if (properties.hasOwnProperty(propname)) expandProperties[propname] = properties[propname];\n      }\n    }\n  };\n  mraid.useCustomClose = function(shouldUseCustomClose) {\n    expandProperties.useCustomClose = shouldUseCustomClose;\n    hasSetCustomClose = true;\n    //bridge.executeNativeCall('usecustomclose', 'shouldUseCustomClose', shouldUseCustomClose);\n  };\n              // MRAID 2.0 APIs ////////////////////////////////////////////////////////////////////////////////\n  \n  mraid.createCalendarEvent = function(parameters) {\n    CalendarEventParser.initialize(parameters);\n    if (CalendarEventParser.parse()) {\n      bridge.executeNativeCall.apply(this, CalendarEventParser.arguments);\n    } else {\n      broadcastEvent(EVENTS.ERROR, CalendarEventParser.errors[0], 'createCalendarEvent');\n    }\n  };\n  mraid.supports = function(feature) {\n    return supports[feature];\n  };\n  mraid.playVideo = function(uri) {\n    if (!mraid.isViewable()) {\n      broadcastEvent(EVENTS.ERROR, 'playVideo cannot be called until the ad is viewable', 'playVideo');\n      return;\n    }\n                if (!uri) {\n      broadcastEvent(EVENTS.ERROR, 'playVideo must be called with a valid URI', 'playVideo');\n    } else {\n      bridge.executeNativeCall.apply(this, ['playVideo', 'uri', uri]);\n    }\n  };\n  mraid.storePicture = function(uri) {\n    if (!mraid.isViewable()) {\n      broadcastEvent(EVENTS.ERROR, 'storePicture cannot be called until the ad is viewable', 'storePicture');\n      return;\n    }\n    if (!uri) {\n      broadcastEvent(EVENTS.ERROR, 'storePicture must be called with a valid URI', 'storePicture');\n    } else {\n      bridge.executeNativeCall.apply(this, ['storePicture', 'uri', uri]);\n    }\n  };\n  mraid.resize = function() {\n    if (state !== STATES.DEFAULT) {\n      broadcastEvent(EVENTS.ERROR, 'Ad can only be expanded from the default state.', 'resize');\n    } else {\n      var args = ['resize'];\n      if (mraid.getHasSetCreativeSize()) {\n        if (resizeProperties.width >= 0 && resizeProperties.height >= 0) {\n          args = args.concat(['w', resizeProperties.width, 'h', resizeProperties.height]);\n        }\n      }\n      if (mraid.getHasSetCreativeOffset()) {\n        args = args.concat(['offsetX', resizeProperties.offsetX, 'offsetY', resizeProperties.offsetY]);\n      }\n      if (typeof resizeProperties.allowOffscreen !== 'undefined') {\n        args = args.concat(['allowOffscreen', resizeProperties.allowOffscreen]);\n      }\n      if (typeof resizeProperties.customClosePosition !== 'undefined') {\n        args = args.concat(['customClosePosition', resizeProperties.customClosePosition]);\n      }\n                  bridge.executeNativeCall.apply(this, args);\n    }\n  };\n  mraid.getResizeProperties = function() {\n    var properties = {\n      width: resizeProperties.width,\n      height: resizeProperties.height,\n      customClosePosition: resizeProperties.customClosePosition,\n      offsetX: resizeProperties.offsetX,\n      offsetY: resizeProperties.offsetY,\n      allowOffscreen: resizeProperties.allowOffscreen\n    };\n    return properties;\n  };\n  mraid.setResizeProperties = function(properties) {\n    if (validate(properties, resizePropertyValidators, 'setResizeProperties', true)) {\n      if (properties.hasOwnProperty('width') || properties.hasOwnProperty('height')) {\n        hasSetCreativeSize = true;\n      }\n      if (properties.hasOwnProperty('offsetX') || properties.hasOwnProperty('offsetY')) {\n        hasSetCreativeOffset = true;\n      }\n      if (properties.hasOwnProperty('useCustomClose')) hasSetCustomClose = true;\n      var desiredProperties = ['width', 'height', 'offsetX', 'offsetY', 'customClosePosition', 'allowOffscreen'];\n      var length = desiredProperties.length;\n      for (var i = 0; i < length; i++) {\n        var propname = desiredProperties[i];\n        if (properties.hasOwnProperty(propname)) resizeProperties[propname] = properties[propname];\n      }\n    }\n  };\n  \n  mraid.setOrientationProperties = function (properties) {\n    var args = ['setOrientationProperties'];\n    if (validate(properties, orientationPropertyValidators, 'setOrientationProperties', true)) {\n      var desiredProperties = ['allowOrientationChange', 'forceOrientation'];\n      var length = desiredProperties.length;\n      for (var i = 0; i < length; i++) {\n        var propname = desiredProperties[i];\n        if (properties.hasOwnProperty(propname)) orientationProperties[propname] = properties[propname];\n        args = args.concat([propname, orientationProperties[propname]]);\n      }\n    }\n  \n    bridge.executeNativeCall.apply(this, args);\n  };\n  \n  mraid.getHasSetCreativeSize = function() {\n      return hasSetCreativeSize;\n  };\n  \n  mraid.getHasSetCreativeOffset = function() {\n      return hasSetCreativeOffset;\n  };\n  \n  mraid.getOrientationProperties = function () {\n      return clone(orientationProperties);\n  };\n  \n  mraid.getCurrentPosition = function() {\n    bridge.executeNativeCall('getCurrentPosition');\n  };\n  \n  mraid.getDefaultPosition = function() {\n    bridge.executeNativeCall('getDefaultPosition');\n  };\n  \n  mraid.getMaxSize = function() {\n    bridge.executeNativeCall('getMaxSize');\n      return maxSize;\n  };\n  \n  mraid.getScreenSize = function() {\n    bridge.executeNativeCall('getScreenSize');\n      return screenSize;\n  };\n  \n  var CalendarEventParser = {\n    initialize: function(parameters) {\n      this.parameters = parameters;\n      this.errors = [];\n      this.arguments = ['createCalendarEvent'];\n    },\n    parse: function() {\n      if (!this.parameters) {\n        this.errors.push('The object passed to createCalendarEvent cannot be null.');\n      } else {\n        this.parseDescription();\n        this.parseLocation();\n        this.parseSummary();\n        this.parseStartAndEndDates();\n        this.parseReminder();\n        this.parseRecurrence();\n        this.parseTransparency();\n      }\n      var errorCount = this.errors.length;\n      if (errorCount) {\n        this.arguments.length = 0;\n      }\n      return (errorCount === 0);\n    },\n    parseDescription: function() {\n      this._processStringValue('description');\n    },\n    parseLocation: function() {\n      this._processStringValue('location');\n    },\n    parseSummary: function() {\n      this._processStringValue('summary');\n    },\n    parseStartAndEndDates: function() {\n      this._processDateValue('start');\n      this._processDateValue('end');\n    },\n    parseReminder: function() {\n      var reminder = this._getParameter('reminder');\n      if (!reminder) {\n        return;\n      }\n      if (reminder < 0) {\n        this.arguments.push('relativeReminder');\n        this.arguments.push(parseInt(reminder) / 1000);\n      } else {\n        this.arguments.push('absoluteReminder');\n        this.arguments.push(reminder);\n      }\n    },\n    parseRecurrence: function() {\n      var recurrenceDict = this._getParameter('recurrence');\n      if (!recurrenceDict) {\n        return;\n      }\n      this.parseRecurrenceInterval(recurrenceDict);\n      this.parseRecurrenceFrequency(recurrenceDict);\n      this.parseRecurrenceEndDate(recurrenceDict);\n      this.parseRecurrenceArrayValue(recurrenceDict, 'daysInWeek');\n      this.parseRecurrenceArrayValue(recurrenceDict, 'daysInMonth');\n      this.parseRecurrenceArrayValue(recurrenceDict, 'daysInYear');\n      this.parseRecurrenceArrayValue(recurrenceDict, 'monthsInYear');\n    },\n    parseTransparency: function() {\n      var validValues = ['opaque', 'transparent'];\n                  if (this.parameters.hasOwnProperty('transparency')) {\n        var transparency = this.parameters['transparency'];\n        if (contains(transparency, validValues)) {\n          this.arguments.push('transparency');\n          this.arguments.push(transparency);\n        } else {\n          this.errors.push('transparency must be opaque or transparent');\n        }\n      }\n    },\n    parseRecurrenceArrayValue: function(recurrenceDict, kind) {\n      if (recurrenceDict.hasOwnProperty(kind)) {\n        var array = recurrenceDict[kind];\n        if (!array || !(array instanceof Array)) {\n          this.errors.push(kind + ' must be an array.');\n        } else {\n          var arrayStr = array.join(',');\n          this.arguments.push(kind);\n          this.arguments.push(arrayStr);\n        }\n      }\n    },\n    parseRecurrenceInterval: function(recurrenceDict) {\n      if (recurrenceDict.hasOwnProperty('interval')) {\n        var interval = recurrenceDict['interval'];\n        if (!interval) {\n          this.errors.push('Recurrence interval cannot be null.');\n        } else {\n          this.arguments.push('interval');\n          this.arguments.push(interval);\n        }\n      } else {\n        // If a recurrence rule was specified without an interval, use a default value of 1.\n        this.arguments.push('interval');\n        this.arguments.push(1);\n      }\n    },\n    parseRecurrenceFrequency: function(recurrenceDict) {\n      if (recurrenceDict.hasOwnProperty('frequency')) {\n        var frequency = recurrenceDict['frequency'];\n        var validFrequencies = ['daily', 'weekly', 'monthly', 'yearly'];\n        if (contains(frequency, validFrequencies)) {\n          this.arguments.push('frequency');\n          this.arguments.push(frequency);\n        } else {\n          this.errors.push(\"Recurrence frequency must be one of: 'daily, 'weekly', 'monthly', 'yearly'.\");\n        }\n      }\n    },\n    parseRecurrenceEndDate: function(recurrenceDict) {\n      var expires = recurrenceDict['expires'];\n                  if (!expires) {\n        return;\n      }\n                  this.arguments.push('expires');\n      this.arguments.push(expires);\n    },\n    _getParameter: function(key) {\n      if (this.parameters.hasOwnProperty(key)) {\n        return this.parameters[key];\n      }\n                  return null;\n    },\n    _processStringValue: function(kind) {\n      if (this.parameters.hasOwnProperty(kind)) {\n        var value = this.parameters[kind];\n        this.arguments.push(kind);\n        this.arguments.push(value);\n      }\n    },\n    _processDateValue: function(kind) {\n      if (this.parameters.hasOwnProperty(kind)) {\n        var dateString = this._getParameter(kind);\n        this.arguments.push(kind);\n        this.arguments.push(dateString);\n      }\n    }\n  };\n  }());\n</script>" + paramString2 + "</body></html>";
        if (!c.b(paramString1)) {
        }
        for (paramString1 = "http://" + paramString1; ; paramString1 = "http://wv.inner-active.mobi/") {
            loadDataWithBaseURL(paramString1, paramString2, "text/html", "utf-8", null);
            return;
        }
    }

    public void loadUrl(String paramString) {
        if (paramString == null) {
            return;
        }
        if (paramString.startsWith("javascript:")) {
            invokeJS(paramString);
            return;
        }
        super.loadUrl(paramString);
    }

    void onAdReadyDOM() {
    }

    void onAdReadyWindowOnLoad() {
    }

    public void onClickOccurs() {
        this.mClicked = true;
    }

    public void onResetClick() {
        this.mClicked = false;
    }

    protected void onWindowVisibilityChanged(int paramInt) {
    }

    void performVastAutoclick() {
        if ((playerState != null) && (("PAUSED".equals(playerState)) || ("IDLE".equals(playerState)))) {
            InneractiveAdView.Log.v("Inneractive_verbose", "Player state is: " + playerState + ". Simulating manual click.");
            post(new IAbaseWebView .2 (this));
            if (IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.a)) {
                InneractiveAdView.Log.v("Inneractive_verbose", "Player state is: " + playerState + ". Android Version is higher or equal to: GINGERBREAD. Simulating javascript click.");
                loadUrl("javascript:(function(){ \n   var playerstate = iaVideoPlayer.getState(); \n   window.console.log('PLAYERSTATE = ' + playerstate); \n\tvar iaVastTimeEventListener = function(time) { \nif(playerstate === 'IDLE'){        window.console.log('IDLE case. need to setPlayPause and then play.'); \n\t\tiaVideoPlayer.setPlayPause(); \n\t\twindow.console.log('--> setPlayPause'); \n\t\tiaVideoPlayer.setPlay(); \n\t\twindow.console.log('--> setPlay'); \n       window.console.log('time= ' + time); \n\t\tiaVideoPlayer.removeListener('time', iaVastTimeEventListener); \n\t\twindow.console.log('iaVastTimeEventListener IS REMOVED'); \n\t}};\tiaVideoPlayer.addListener('time', iaVastTimeEventListener); \n})();");
            }
        }
    }

    void setChromeClient(WebView paramWebView) {
        this.mWebChromeClient = new IAbaseWebView.a(this);
        paramWebView.setWebChromeClient(this.mWebChromeClient);
    }

    public void setListener(V paramV) {
    }

    boolean tryCommand(URI paramURI) {
        return false;
    }

    public boolean wasClicked() {
        return this.mClicked;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAbaseWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
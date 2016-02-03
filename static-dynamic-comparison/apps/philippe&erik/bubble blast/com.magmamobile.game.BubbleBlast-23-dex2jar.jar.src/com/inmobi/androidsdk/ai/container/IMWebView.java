package com.inmobi.androidsdk.ai.container;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.androidsdk.ai.controller.JSController.Dimensions;
import com.inmobi.androidsdk.ai.controller.JSController.ExpandProperties;
import com.inmobi.androidsdk.ai.controller.JSController.PlayerProperties;
import com.inmobi.androidsdk.ai.controller.JSUtilityController;
import com.inmobi.androidsdk.ai.controller.util.IMAVPlayer;
import com.inmobi.androidsdk.ai.controller.util.IMAVPlayer.playerState;
import com.inmobi.androidsdk.ai.controller.util.IMAVPlayerListener;
import com.inmobi.commons.internal.IMLog;
import com.inmobi.commons.internal.InternalSDKUtil;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class IMWebView
  extends WebView
  implements Serializable
{
  protected static final int IMWEBVIEW_INTERSTITIAL_ID = 117;
  protected static final int INT_BACKGROUND_ID = 224;
  protected static final int INT_CLOSE_BUTTON = 225;
  protected static final int PLACEHOLDER_ID = 437;
  protected static final int RELATIVELAYOUT_ID = 438;
  private static int[] a = { 16843039, 16843040 };
  public static AtomicBoolean isInterstitialDisplayed = new AtomicBoolean();
  private static final long serialVersionUID = 7098506283154473782L;
  public static boolean userInitiatedClose = false;
  private Hashtable<String, IMAVPlayer> A = new Hashtable();
  private Hashtable<String, IMAVPlayer> B = new Hashtable();
  private int C;
  private int D;
  private ArrayList<String> E = new ArrayList();
  private AtomicBoolean F = new AtomicBoolean();
  private a G = new a(this);
  private Display H;
  private ViewGroup I;
  private WebViewClient J = new WebViewClient()
  {
    public void onLoadResource(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> onLoadResource:" + paramAnonymousString);
      if (IMWebView.a(IMWebView.this) != null) {
        IMWebView.a(IMWebView.this).onLoadResource(paramAnonymousWebView, paramAnonymousString);
      }
      if ((!IMWebView.e(IMWebView.this)) && (paramAnonymousString.contains("mraid.js")))
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> onLoadResource:Hippy, Mraid ad alert!...injecting mraid and mraidview object");
        IMWebView.a(IMWebView.this, true);
        paramAnonymousWebView = IMWebView.this.getUrl();
        if (!IMWebView.f(IMWebView.this).contains(paramAnonymousWebView)) {
          IMWebView.f(IMWebView.this).add(paramAnonymousWebView);
        }
        IMWebView.this.injectJavaScript("(function(){var c=window.mraidview={},f={},g=[],l=!1;c.fireReadyEvent=function(){var b=f.ready;if(null!=b)for(var a=0;a<b.length;a++)b[a]();return\"OK\"};c.fireStateChangeEvent=function(b){var a=f.stateChange;if(null!=a)for(var c=0;c<a.length;c++)a[c](b);return\"OK\"};c.fireViewableChangeEvent=function(b){var a=f.viewableChange;if(null!=a)for(var c=0;c<a.length;c++)a[c](b);return\"OK\"};c.fireErrorEvent=function(b,a){var c=f.error;if(null!=c)for(var e=0;e<c.length;e++)c[e](b,a);return\"OK\"};c.fireOrientationChangeEvent=function(b){var a=f.orientationChange;if(null!=a)for(var c=0;c<a.length;c++)a[c](b);return\"OK\"};c.fireMediaTrackingEvent=function(b,a){var c={};c.name=b;var e=\"inmobi_media_\"+b;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(e=e+\"_\"+a);e=f[e];if(null!=e)for(var h=0;h<e.length;h++)e[h](c);return\"OK\"};c.fireMediaErrorEvent=function(b,a){var c={name:\"error\"};c.code=a;var e=\"inmobi_media_\"+c.name;\"undefined\"!=typeof b&&(null!=b&&\"\"!=b)&&(e=e+\"_\"+b);e=f[e];if(null!=e)for(var h=0;h<e.length;h++)e[h](c);return\"OK\"};c.fireMediaTimeUpdateEvent=function(b,a,c){var e={name:\"timeupdate\",target:{}};e.target.currentTime=a;e.target.duration=c;a=\"inmobi_media_\"+e.name;\"undefined\"!=typeof b&&(null!=b&&\"\"!=b)&&(a=a+\"_\"+b);b=f[a];if(null!=b)for(a=0;a<b.length;a++)b[a](e);return\"OK\"};c.fireMediaCloseEvent=function(b,a,c){var e={name:\"close\"};e.viaUserInteraction=a;e.target={};e.target.currentTime=c;a=\"inmobi_media_\"+e.name;\"undefined\"!=typeof b&&(null!=b&&\"\"!=b)&&(a=a+\"_\"+b);b=f[a];if(null!=b)for(a=0;a<b.length;a++)b[a](e);return\"OK\"};c.fireMediaVolumeChangeEvent=function(b,a,c){var e={name:\"volumechange\",target:{}};e.target.volume=a;e.target.muted=c;a=\"inmobi_media_\"+e.name;\"undefined\"!=typeof b&&(null!=b&&\"\"!=b)&&(a=a+\"_\"+b);b=f[a];if(null!=b)for(a=0;a<b.length;a++)b[a](e);return\"OK\"};c.showAlert=function(b){utilityController.showAlert(b)};c.zeroPad=function(b){var a=\"\";10>b&&(a+=\"0\");return a+b};c.addEventListener=function(b,a){var c=f[b];null==c&&(f[b]=[],c=f[b]);for(var e in c)if(a==e)return;c.push(a)};c.removeEventListener=function(b){try{var a=f[b];null!=a&&delete a}catch(d){c.log(d)}};c.useCustomClose=function(b){try{displayController.useCustomClose(b)}catch(a){c.showAlert(\"use CustomClose: \"+a)}};c.close=function(){try{displayController.close()}catch(b){c.showAlert(\"close: \"+b)}};c.stackCommands=function(b,a){l?g.push(b):(eval(b),a&&(l=!0))};c.executeStack=function(){for(l=!1;0<g.length;){var b=g.shift();eval(b)}};c.emptyStack=function(){for(;0<g.length;)g.shift()};c.expand=function(b){try{displayController.expand(b)}catch(a){c.showAlert(\"executeNativeExpand: \"+a+\", URL = \"+b)}};c.setExpandProperties=function(b){try{b?this.props=b:b=null,displayController.setExpandProperties(c.stringify(b))}catch(a){c.showAlert(\"executeNativesetExpandProperties: \"+a+\", props = \"+b)}};c.acceptAction=function(b){try{displayController.acceptAction(c.stringify(b))}catch(a){c.showAlert(\"acceptAction: \"+a+\", params = \"+b)}};c.rejectAction=function(b){try{displayController.rejectAction(c.stringify(b))}catch(a){c.showAlert(\"rejectAction: \"+a+\", params = \"+b)}};c.open=function(b){try{displayController.open(b)}catch(a){c.showAlert(\"open: \"+a)}};c.openExternal=function(b){try{utilityController.openExternal(b)}catch(a){c.showAlert(\"openExternal: \"+a)}};c.getScreenSize=function(){try{return eval(\"(\"+utilityController.getScreenSize()+\")\")}catch(b){c.showAlert(\"getScreenSize: \"+b)}};c.getCurrentPosition=function(){try{return eval(\"(\"+utilityController.getCurrentPosition()+\")\")}catch(b){c.showAlert(\"getCurrentPosition: \"+b)}};c.resize=function(b,a){try{displayController.resize(b,a)}catch(d){c.showAlert(\"resize: \"+d)}};c.getState=function(){try{return String(displayController.getState())}catch(b){c.showAlert(\"getState: \"+b)}};c.getOrientation=function(){try{return String(displayController.getOrientation())}catch(b){c.showAlert(\"getOrientation: \"+b)}};c.isViewable=function(){try{return displayController.isViewable()}catch(b){c.showAlert(\"isViewable: \"+b)}};c.log=function(b){try{utilityController.log(b)}catch(a){c.showAlert(\"log: \"+a)}};c.getPlacementType=function(){return displayController.getPlacementType()};c.asyncPing=function(b){try{utilityController.asyncPing(b)}catch(a){c.showAlert(\"asyncPing: \"+a)}};c.close=function(){try{displayController.close()}catch(b){c.showAlert(\"close: \"+b)}};c.makeCall=function(b){try{utilityController.makeCall(b)}catch(a){c.showAlert(\"makeCall: \"+a)}};c.sendMail=function(b,a,d){try{utilityController.sendMail(b,a,d)}catch(e){c.showAlert(\"sendMail: \"+e)}};c.sendSMS=function(b,a){try{utilityController.sendSMS(b,a)}catch(d){c.showAlert(\"sendSMS: \"+d)}};c.pauseAudio=function(b){try{var a=getPID(b);utilityController.pauseAudio(a)}catch(d){c.showAlert(\"pauseAudio: \"+d)}};c.muteAudio=function(b){try{var a=getPID(b);utilityController.muteAudio(a)}catch(d){c.showAlert(\"muteAudio: \"+d)}};c.unMuteAudio=function(b){try{var a=getPID(b);utilityController.unMuteAudio(a)}catch(d){c.showAlert(\"unMuteAudio: \"+d)}};c.isAudioMuted=function(b){try{var a=getPID(b);return utilityController.isAudioMuted(a)}catch(d){c.showAlert(\"isAudioMuted: \"+d)}};c.setAudioVolume=function(b,a){try{var d=getPID(b);utilityController.setAudioVolume(d,a)}catch(e){c.showAlert(\"setAudioVolume: \"+e)}};c.getAudioVolume=function(b){try{var a=getPID(b);return utilityController.getAudioVolume(a)}catch(d){c.showAlert(\"getAudioVolume: \"+d)}};c.seekAudio=function(b,a){try{var d=getPID(b);utilityController.seekAudio(d,a)}catch(e){c.showAlert(\"seekAudio: \"+e)}};c.playAudio=function(b,a){var d=!0,e=!1,h=\"normal\",f=\"normal\",g=!0,j=\"\",n=getPID(a);null!=b&&(j=b);null!=a&&(\"undefined\"!=typeof a.autoplay&&!1===a.autoplay&&(d=!1),\"undefined\"!=typeof a.loop&&!0===a.loop&&(e=!0),\"undefined\"!=typeof a.startStyle&&null!=a.startStyle&&(h=a.startStyle),\"undefined\"!=typeof a.stopStyle&&null!=a.stopStyle&&(f=a.stopStyle),\"fullscreen\"==h&&(g=!0));try{utilityController.playAudio(j,d,g,e,h,f,n)}catch(o){c.showAlert(\"playAudio: \"+o)}};c.pauseVideo=function(b){try{var a=getPID(b);utilityController.pauseVideo(a)}catch(d){c.showAlert(\"pauseVideo: \"+d)}};c.closeVideo=function(b){try{var a=getPID(b);utilityController.closeVideo(a)}catch(d){c.showAlert(\"closeVideo: \"+d)}};c.hideVideo=function(b){try{var a=getPID(b);utilityController.hideVideo(a)}catch(d){c.showAlert(\"hideVideo: \"+d)}};c.showVideo=function(b){try{var a=getPID(b);utilityController.showVideo(a)}catch(d){c.showAlert(\"showVideo: \"+d)}};c.muteVideo=function(b){try{var a=getPID(b);utilityController.muteVideo(a)}catch(d){c.showAlert(\"muteVideo: \"+d)}};c.unMuteVideo=function(b){try{var a=getPID(b);utilityController.unMuteVideo(a)}catch(d){c.showAlert(\"unMuteVideo: \"+d)}};c.seekVideo=function(b,a){try{var d=getPID(b);utilityController.seekVideo(d,a)}catch(e){c.showAlert(\"seekVideo: \"+e)}};c.isVideoMuted=function(b){try{var a=getPID(b);return utilityController.isVideoMuted(a)}catch(d){c.showAlert(\"isVideoMuted: \"+d)}};c.setVideoVolume=function(b,a){try{var d=getPID(b);utilityController.setVideoVolume(d,a)}catch(e){c.showAlert(\"setVideoVolume: \"+e)}};c.getVideoVolume=function(b){try{var a=getPID(b);return utilityController.getVideoVolume(a)}catch(d){c.showAlert(\"getVideoVolume: \"+d)}};c.playVideo=function(b,a){var d=!1,e=!0,f=!0,g=!1,j=-99999,l=-99999,n=-99999,o=-99999,k=\"normal\",m=\"exit\",p=\"\",q=getPID(a);null!=b&&(p=b);if(null!=a){\"undefined\"!=typeof a.audio&&\"muted\"==a.audio&&(d=!0);\"undefined\"!=typeof a.autoplay&&!1===a.autoplay&&(e=!1);\"undefined\"!=typeof a.controls&&!1===a.controls&&(f=!1);\"undefined\"!=typeof a.loop&&!0===a.loop&&(g=!0);if(\"undefined\"!=typeof a.inline&&null!=a.inline&&(j=a.inline.left,l=a.inline.top,\"undefined\"!=typeof a.width&&null!=a.width&&(n=a.width),\"undefined\"!=typeof a.height&&null!=a.height))o=a.height;\"undefined\"!=typeof a.startStyle&&null!=a.startStyle&&(k=a.startStyle);\"undefined\"!=typeof a.stopStyle&&null!=a.stopStyle&&(m=a.stopStyle);\"fullscreen\"==k&&(f=!0)}try{utilityController.playVideo(p,d,e,f,g,j,l,n,o,k,m,q)}catch(r){c.showAlert(\"playVideo: \"+r)}};c.updateToPassbook=function(){c.fireErrorEvent(\"Method not supported\",\"updateToPassbook\");c.log(\"Method not supported\")};c.stringify=function(b){if(\"undefined\"===typeof JSON){var a=\"\",d;if(\"undefined\"==typeof b.length)return c.stringifyArg(b);for(d=0;d<b.length;d++)0<d&&(a+=\",\"),a+=c.stringifyArg(b[d]);return a+\"]\"}return JSON.stringify(b)};c.stringifyArg=function(b){var a,d,e;d=typeof b;a=\"\";if(\"number\"===d||\"boolean\"===d)a+=args;else if(b instanceof Array)a=a+\"[\"+b+\"]\";else if(b instanceof Object){d=!0;a+=\"{\";for(e in b)null!==b[e]&&(d||(a+=\",\"),a=a+'\"'+e+'\":',d=typeof b[e],a=\"number\"===d||\"boolean\"===d?a+b[e]:\"function\"===typeof b[e]?a+'\"\"':b[e]instanceof Object?a+this.stringify(args[i][e]):a+'\"'+b[e]+'\"',d=!1);a+=\"}\"}else b=b.replace(/\\\\/g,\"\\\\\\\\\"),b=b.replace(/\"/g,'\\\\\"'),a=a+'\"'+b+'\"';c.showAlert(\"json:\"+a);return a};getPID=function(b){var a=\"\";null!=b&&(\"undefined\"!=typeof b.id&&null!=b.id)&&(a=b.id);return a};var k,j=function(){window.orientation!==k&&(k=window.orientation,displayController.onOrientationChange())};c.registerOrientationListener=function(){k=window.orientation;window.addEventListener(\"resize\",j,!1);window.addEventListener(\"orientationchange\",j,!1)};c.unRegisterOrientationListener=function(){window.removeEventListener(\"resize\",j,!1);window.removeEventListener(\"orientationchange\",j,!1)}})();");
        IMWebView.this.injectJavaScript("(function(){var c=window.mraid={};c.STATES={LOADING:\"loading\",DEFAULT:\"default\",RESIZED:\"resized\",EXPANDED:\"expanded\",HIDDEN:\"hidden\"};var d=c.EVENTS={READY:\"ready\",ERROR:\"error\",STATECHANGE:\"stateChange\",VIEWABLECHANGE:\"viewableChange\",ORIENTATIONCHANGE:\"orientationChange\",PASSBOOKCHANGE:\"passbookChange\"},i={width:0,height:0},g={width:0,height:0},f={},h={width:0,height:0,useCustomClose:!1,isModal:!0,lockOrientation:!1,orientation:\"\"},l=function(a){this.event=a;this.count=0;var b={};this.add=function(a){var c=String(a);b[c]||(b[c]=a,this.count++)};this.remove=function(a){a=String(a);return b[a]?(b[a]=null,delete b[a],this.count--,!0):!1};this.removeAll=function(){for(var a in b)this.remove(b[a])};this.broadcast=function(a){for(var c in b)b[c].apply({},a)};this.toString=function(){var c=[a,\":\"],d;for(d in b)c.push(\"|\",d,\"|\");return c.join(\"\")}};mraidview.addEventListener(d.READY,function(){e(d.READY)});mraidview.addEventListener(d.STATECHANGE,function(a){e(d.STATECHANGE,a)});mraidview.addEventListener(d.VIEWABLECHANGE,function(a){e(d.VIEWABLECHANGE,a)});mraidview.addEventListener(\"error\",function(a,b){e(d.ERROR,a,b)});mraidview.addEventListener(d.ORIENTATIONCHANGE,function(a){e(d.ORIENTATIONCHANGE,a)});var k=function(a){var b=function(){};b.prototype=a;return new b},e=function(){for(var a=Array(arguments.length),b=0;b<arguments.length;b++)a[b]=arguments[b];b=a.shift();try{f[b]&&f[b].broadcast(a)}catch(c){}},j=function(a){for(var b=0,c=a.length-1;b<a.length&&\" \"==a[b];)b++;for(;c>b&&\" \"==a[c];)c-=1;return a.substring(b,c+1)};c.addEventListener=function(a,b){try{!a||!b?e(d.ERROR,\"Both event and listener are required.\",\"addEventListener\"):d.ERROR==a||d.READY==a||d.STATECHANGE==a||d.VIEWABLECHANGE==a||d.ORIENTATIONCHANGE==a?(f[a]||(f[a]=new l(a)),f[a].add(b)):mraidview.addEventListener(a,b)}catch(c){mraidview.log(c)}};c.useCustomClose=function(a){h.useCustomClose=a;mraidview.useCustomClose(a)};c.close=function(){mraidview.close()};c.getExpandProperties=function(){return h};c.setExpandProperties=function(a){h=a;h.isModal=!0;mraidview.setExpandProperties(h)};c.expand=function(a){mraidview.expand(a)};c.getMaxSize=function(){return k(g)};c.getSize=function(){return k(i)};c.getState=function(){return mraidview.getState()};c.getOrientation=function(){return mraidview.getOrientation()};c.isViewable=function(){return mraidview.isViewable()};c.open=function(a){a?mraidview.open(a):e(d.ERROR,\"URL is required.\",\"open\")};c.removeEventListener=function(a,b){try{if(a){if(b)if(f[a])f[a].remove(b);else{mraidview.removeEventListener(a,b);return}else f[a]&&f[a].removeAll();f[a]&&0==f[a].count&&(f[a]=null,delete f[a])}else e(d.ERROR,\"Must specify an event.\",\"removeEventListener\")}catch(c){mraidview.log(\"removeEventListener\"+c)}};c.resize=function(a,b){null==a||null==b||isNaN(a)||isNaN(b)||0>a||0>b?e(d.ERROR,\"Requested size must be numeric values between 0 and maxSize.\",\"resize\"):a>g.width||b>g.height?e(d.ERROR,\"Request (\"+a+\" x \"+b+\") exceeds maximum allowable size of (\"+g.width+\" x \"+g.height+\")\",\"resize\"):a==i.width&&b==i.height?e(d.ERROR,\"Requested size equals current size.\",\"resize\"):mraidview.resize(a,b)};c.log=function(a){null == a || \"undefined\" == a?e(d.ERROR,\"message is required.\",\"log\"):mraidview.log(a)};c.getVersion=function(){return\"1.0\"};c.getInMobiAIVersion=function(){return 1.2};c.getPlacementType=function(){return mraidview.getPlacementType()};c.asyncPing=function(a){a?mraidview.asyncPing(a):e(d.ERROR,\"URL is required.\",\"asyncPing\")};c.makeCall=function(a){!a||\"string\"!=typeof a||0==j(a).length?e(d.ERROR,\"Request must provide a number to call.\",\"makeCall\"):mraidview.makeCall(a)};c.sendMail=function(a,b,c){!a||\"string\"!=typeof a||0==j(a).length?e(d.ERROR,\"Request must specify a recipient.\",\"sendMail\"):mraidview.sendMail(a,b,c)};c.sendSMS=function(a,b){!a||\"string\"!=typeof a||0==j(a).length?e(d.ERROR,\"Request must specify a recipient.\",\"sendSMS\"):mraidview.sendSMS(a,b)};c.playAudio=function(a,b){\"undefined\"==typeof b||null==b?\"string\"==typeof a?mraidview.playAudio(a,null):\"object\"==typeof a?mraidview.playAudio(null,a):mraidview.playAudio(null,null):mraidview.playAudio(a,b)};c.playVideo=function(a,b){\"undefined\"==typeof b||null==b?\"string\"==typeof a?mraidview.playVideo(a,null):\"object\"==typeof a?mraidview.playVideo(null,a):mraidview.playVideo(null,null):mraidview.playVideo(a,b)};c.pauseAudio=function(a){mraidview.pauseAudio(a)};c.muteAudio=function(a){mraidview.muteAudio(a)};c.unMuteAudio=function(a){mraidview.unMuteAudio(a)};c.isAudioMuted=function(a){return mraidview.isAudioMuted(a)};c.setAudioVolume=function(a){var b=a.volume;\"undefined\"==typeof b||null==b?e(d.ERROR,\"Request must specify a valid volume\",\"setAudioVolume\"):0>b||100<b?e(d.ERROR,\"Request must specify a valid volume value in the range 0..100\",\"setAudioVolume\"):mraidview.setAudioVolume(a,b)};c.getAudioVolume=function(a){return mraidview.getAudioVolume(a)};c.pauseVideo=function(a){mraidview.pauseVideo(a)};c.closeVideo=function(a){mraidview.closeVideo(a)};c.hideVideo=function(a){mraidview.hideVideo(a)};c.showVideo=function(a){mraidview.showVideo(a)};c.muteVideo=function(a){mraidview.muteVideo(a)};c.unMuteVideo=function(a){mraidview.unMuteVideo(a)};c.isVideoMuted=function(a){return mraidview.isVideoMuted(a)};c.setVideoVolume=function(a){var b=a.volume;\"undefined\"==typeof b||null==b?e(d.ERROR,\"Request must specify a valid volume\",\"setVideoVolume\"):0>b||100<b?e(d.ERROR,\"Request must specify a valid volume value in the range 0..100\",\"setVideoVolume\"):mraidview.setVideoVolume(a,b)};c.getVideoVolume=function(a){return mraidview.getVideoVolume(a)};c.seekAudio=function(a){var b=a.time;\"undefined\"==typeof b||null==b?e(d.ERROR,\"Request must specify a valid time\",\"seekAudio\"):0!=b?e(d.ERROR,\"Cannot seek audio other than 0\",\"seekAudio\"):mraidview.seekAudio(a,b)};c.seekVideo=function(a){var b=a.time;\"undefined\"==typeof b||null==b?e(d.ERROR,\"Request must specify a valid time\",\"seekVideo\"):0!=b?e(d.ERROR,\"Cannot seek video other than 0\",\"seekVideo\"):mraidview.seekVideo(a,b)};c.openExternal=function(a){mraidview.openExternal(a)};c.updateToPassbook=function(a){mraidview.updateToPassbook(a)};c.getScreenSize=function(){return mraidview.getScreenSize()};c.getCurrentPosition=function(){return mraidview.getCurrentPosition()};c.acceptAction=function(a){mraidview.acceptAction(a)};c.rejectAction=function(a){mraidview.rejectAction(a)}})();");
      }
    }
    
    public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> onPageFinished, url: " + paramAnonymousString);
      if (IMWebView.a(IMWebView.this) != null) {
        IMWebView.a(IMWebView.this).onPageFinished(paramAnonymousWebView, paramAnonymousString);
      }
      try
      {
        if ((!IMWebView.e(IMWebView.this)) && (IMWebView.f(IMWebView.this).contains(paramAnonymousString)))
        {
          IMWebView.a(IMWebView.this, true);
          IMWebView.this.injectJavaScript("(function(){var c=window.mraidview={},f={},g=[],l=!1;c.fireReadyEvent=function(){var b=f.ready;if(null!=b)for(var a=0;a<b.length;a++)b[a]();return\"OK\"};c.fireStateChangeEvent=function(b){var a=f.stateChange;if(null!=a)for(var c=0;c<a.length;c++)a[c](b);return\"OK\"};c.fireViewableChangeEvent=function(b){var a=f.viewableChange;if(null!=a)for(var c=0;c<a.length;c++)a[c](b);return\"OK\"};c.fireErrorEvent=function(b,a){var c=f.error;if(null!=c)for(var e=0;e<c.length;e++)c[e](b,a);return\"OK\"};c.fireOrientationChangeEvent=function(b){var a=f.orientationChange;if(null!=a)for(var c=0;c<a.length;c++)a[c](b);return\"OK\"};c.fireMediaTrackingEvent=function(b,a){var c={};c.name=b;var e=\"inmobi_media_\"+b;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(e=e+\"_\"+a);e=f[e];if(null!=e)for(var h=0;h<e.length;h++)e[h](c);return\"OK\"};c.fireMediaErrorEvent=function(b,a){var c={name:\"error\"};c.code=a;var e=\"inmobi_media_\"+c.name;\"undefined\"!=typeof b&&(null!=b&&\"\"!=b)&&(e=e+\"_\"+b);e=f[e];if(null!=e)for(var h=0;h<e.length;h++)e[h](c);return\"OK\"};c.fireMediaTimeUpdateEvent=function(b,a,c){var e={name:\"timeupdate\",target:{}};e.target.currentTime=a;e.target.duration=c;a=\"inmobi_media_\"+e.name;\"undefined\"!=typeof b&&(null!=b&&\"\"!=b)&&(a=a+\"_\"+b);b=f[a];if(null!=b)for(a=0;a<b.length;a++)b[a](e);return\"OK\"};c.fireMediaCloseEvent=function(b,a,c){var e={name:\"close\"};e.viaUserInteraction=a;e.target={};e.target.currentTime=c;a=\"inmobi_media_\"+e.name;\"undefined\"!=typeof b&&(null!=b&&\"\"!=b)&&(a=a+\"_\"+b);b=f[a];if(null!=b)for(a=0;a<b.length;a++)b[a](e);return\"OK\"};c.fireMediaVolumeChangeEvent=function(b,a,c){var e={name:\"volumechange\",target:{}};e.target.volume=a;e.target.muted=c;a=\"inmobi_media_\"+e.name;\"undefined\"!=typeof b&&(null!=b&&\"\"!=b)&&(a=a+\"_\"+b);b=f[a];if(null!=b)for(a=0;a<b.length;a++)b[a](e);return\"OK\"};c.showAlert=function(b){utilityController.showAlert(b)};c.zeroPad=function(b){var a=\"\";10>b&&(a+=\"0\");return a+b};c.addEventListener=function(b,a){var c=f[b];null==c&&(f[b]=[],c=f[b]);for(var e in c)if(a==e)return;c.push(a)};c.removeEventListener=function(b){try{var a=f[b];null!=a&&delete a}catch(d){c.log(d)}};c.useCustomClose=function(b){try{displayController.useCustomClose(b)}catch(a){c.showAlert(\"use CustomClose: \"+a)}};c.close=function(){try{displayController.close()}catch(b){c.showAlert(\"close: \"+b)}};c.stackCommands=function(b,a){l?g.push(b):(eval(b),a&&(l=!0))};c.executeStack=function(){for(l=!1;0<g.length;){var b=g.shift();eval(b)}};c.emptyStack=function(){for(;0<g.length;)g.shift()};c.expand=function(b){try{displayController.expand(b)}catch(a){c.showAlert(\"executeNativeExpand: \"+a+\", URL = \"+b)}};c.setExpandProperties=function(b){try{b?this.props=b:b=null,displayController.setExpandProperties(c.stringify(b))}catch(a){c.showAlert(\"executeNativesetExpandProperties: \"+a+\", props = \"+b)}};c.acceptAction=function(b){try{displayController.acceptAction(c.stringify(b))}catch(a){c.showAlert(\"acceptAction: \"+a+\", params = \"+b)}};c.rejectAction=function(b){try{displayController.rejectAction(c.stringify(b))}catch(a){c.showAlert(\"rejectAction: \"+a+\", params = \"+b)}};c.open=function(b){try{displayController.open(b)}catch(a){c.showAlert(\"open: \"+a)}};c.openExternal=function(b){try{utilityController.openExternal(b)}catch(a){c.showAlert(\"openExternal: \"+a)}};c.getScreenSize=function(){try{return eval(\"(\"+utilityController.getScreenSize()+\")\")}catch(b){c.showAlert(\"getScreenSize: \"+b)}};c.getCurrentPosition=function(){try{return eval(\"(\"+utilityController.getCurrentPosition()+\")\")}catch(b){c.showAlert(\"getCurrentPosition: \"+b)}};c.resize=function(b,a){try{displayController.resize(b,a)}catch(d){c.showAlert(\"resize: \"+d)}};c.getState=function(){try{return String(displayController.getState())}catch(b){c.showAlert(\"getState: \"+b)}};c.getOrientation=function(){try{return String(displayController.getOrientation())}catch(b){c.showAlert(\"getOrientation: \"+b)}};c.isViewable=function(){try{return displayController.isViewable()}catch(b){c.showAlert(\"isViewable: \"+b)}};c.log=function(b){try{utilityController.log(b)}catch(a){c.showAlert(\"log: \"+a)}};c.getPlacementType=function(){return displayController.getPlacementType()};c.asyncPing=function(b){try{utilityController.asyncPing(b)}catch(a){c.showAlert(\"asyncPing: \"+a)}};c.close=function(){try{displayController.close()}catch(b){c.showAlert(\"close: \"+b)}};c.makeCall=function(b){try{utilityController.makeCall(b)}catch(a){c.showAlert(\"makeCall: \"+a)}};c.sendMail=function(b,a,d){try{utilityController.sendMail(b,a,d)}catch(e){c.showAlert(\"sendMail: \"+e)}};c.sendSMS=function(b,a){try{utilityController.sendSMS(b,a)}catch(d){c.showAlert(\"sendSMS: \"+d)}};c.pauseAudio=function(b){try{var a=getPID(b);utilityController.pauseAudio(a)}catch(d){c.showAlert(\"pauseAudio: \"+d)}};c.muteAudio=function(b){try{var a=getPID(b);utilityController.muteAudio(a)}catch(d){c.showAlert(\"muteAudio: \"+d)}};c.unMuteAudio=function(b){try{var a=getPID(b);utilityController.unMuteAudio(a)}catch(d){c.showAlert(\"unMuteAudio: \"+d)}};c.isAudioMuted=function(b){try{var a=getPID(b);return utilityController.isAudioMuted(a)}catch(d){c.showAlert(\"isAudioMuted: \"+d)}};c.setAudioVolume=function(b,a){try{var d=getPID(b);utilityController.setAudioVolume(d,a)}catch(e){c.showAlert(\"setAudioVolume: \"+e)}};c.getAudioVolume=function(b){try{var a=getPID(b);return utilityController.getAudioVolume(a)}catch(d){c.showAlert(\"getAudioVolume: \"+d)}};c.seekAudio=function(b,a){try{var d=getPID(b);utilityController.seekAudio(d,a)}catch(e){c.showAlert(\"seekAudio: \"+e)}};c.playAudio=function(b,a){var d=!0,e=!1,h=\"normal\",f=\"normal\",g=!0,j=\"\",n=getPID(a);null!=b&&(j=b);null!=a&&(\"undefined\"!=typeof a.autoplay&&!1===a.autoplay&&(d=!1),\"undefined\"!=typeof a.loop&&!0===a.loop&&(e=!0),\"undefined\"!=typeof a.startStyle&&null!=a.startStyle&&(h=a.startStyle),\"undefined\"!=typeof a.stopStyle&&null!=a.stopStyle&&(f=a.stopStyle),\"fullscreen\"==h&&(g=!0));try{utilityController.playAudio(j,d,g,e,h,f,n)}catch(o){c.showAlert(\"playAudio: \"+o)}};c.pauseVideo=function(b){try{var a=getPID(b);utilityController.pauseVideo(a)}catch(d){c.showAlert(\"pauseVideo: \"+d)}};c.closeVideo=function(b){try{var a=getPID(b);utilityController.closeVideo(a)}catch(d){c.showAlert(\"closeVideo: \"+d)}};c.hideVideo=function(b){try{var a=getPID(b);utilityController.hideVideo(a)}catch(d){c.showAlert(\"hideVideo: \"+d)}};c.showVideo=function(b){try{var a=getPID(b);utilityController.showVideo(a)}catch(d){c.showAlert(\"showVideo: \"+d)}};c.muteVideo=function(b){try{var a=getPID(b);utilityController.muteVideo(a)}catch(d){c.showAlert(\"muteVideo: \"+d)}};c.unMuteVideo=function(b){try{var a=getPID(b);utilityController.unMuteVideo(a)}catch(d){c.showAlert(\"unMuteVideo: \"+d)}};c.seekVideo=function(b,a){try{var d=getPID(b);utilityController.seekVideo(d,a)}catch(e){c.showAlert(\"seekVideo: \"+e)}};c.isVideoMuted=function(b){try{var a=getPID(b);return utilityController.isVideoMuted(a)}catch(d){c.showAlert(\"isVideoMuted: \"+d)}};c.setVideoVolume=function(b,a){try{var d=getPID(b);utilityController.setVideoVolume(d,a)}catch(e){c.showAlert(\"setVideoVolume: \"+e)}};c.getVideoVolume=function(b){try{var a=getPID(b);return utilityController.getVideoVolume(a)}catch(d){c.showAlert(\"getVideoVolume: \"+d)}};c.playVideo=function(b,a){var d=!1,e=!0,f=!0,g=!1,j=-99999,l=-99999,n=-99999,o=-99999,k=\"normal\",m=\"exit\",p=\"\",q=getPID(a);null!=b&&(p=b);if(null!=a){\"undefined\"!=typeof a.audio&&\"muted\"==a.audio&&(d=!0);\"undefined\"!=typeof a.autoplay&&!1===a.autoplay&&(e=!1);\"undefined\"!=typeof a.controls&&!1===a.controls&&(f=!1);\"undefined\"!=typeof a.loop&&!0===a.loop&&(g=!0);if(\"undefined\"!=typeof a.inline&&null!=a.inline&&(j=a.inline.left,l=a.inline.top,\"undefined\"!=typeof a.width&&null!=a.width&&(n=a.width),\"undefined\"!=typeof a.height&&null!=a.height))o=a.height;\"undefined\"!=typeof a.startStyle&&null!=a.startStyle&&(k=a.startStyle);\"undefined\"!=typeof a.stopStyle&&null!=a.stopStyle&&(m=a.stopStyle);\"fullscreen\"==k&&(f=!0)}try{utilityController.playVideo(p,d,e,f,g,j,l,n,o,k,m,q)}catch(r){c.showAlert(\"playVideo: \"+r)}};c.updateToPassbook=function(){c.fireErrorEvent(\"Method not supported\",\"updateToPassbook\");c.log(\"Method not supported\")};c.stringify=function(b){if(\"undefined\"===typeof JSON){var a=\"\",d;if(\"undefined\"==typeof b.length)return c.stringifyArg(b);for(d=0;d<b.length;d++)0<d&&(a+=\",\"),a+=c.stringifyArg(b[d]);return a+\"]\"}return JSON.stringify(b)};c.stringifyArg=function(b){var a,d,e;d=typeof b;a=\"\";if(\"number\"===d||\"boolean\"===d)a+=args;else if(b instanceof Array)a=a+\"[\"+b+\"]\";else if(b instanceof Object){d=!0;a+=\"{\";for(e in b)null!==b[e]&&(d||(a+=\",\"),a=a+'\"'+e+'\":',d=typeof b[e],a=\"number\"===d||\"boolean\"===d?a+b[e]:\"function\"===typeof b[e]?a+'\"\"':b[e]instanceof Object?a+this.stringify(args[i][e]):a+'\"'+b[e]+'\"',d=!1);a+=\"}\"}else b=b.replace(/\\\\/g,\"\\\\\\\\\"),b=b.replace(/\"/g,'\\\\\"'),a=a+'\"'+b+'\"';c.showAlert(\"json:\"+a);return a};getPID=function(b){var a=\"\";null!=b&&(\"undefined\"!=typeof b.id&&null!=b.id)&&(a=b.id);return a};var k,j=function(){window.orientation!==k&&(k=window.orientation,displayController.onOrientationChange())};c.registerOrientationListener=function(){k=window.orientation;window.addEventListener(\"resize\",j,!1);window.addEventListener(\"orientationchange\",j,!1)};c.unRegisterOrientationListener=function(){window.removeEventListener(\"resize\",j,!1);window.removeEventListener(\"orientationchange\",j,!1)}})();");
          IMWebView.this.injectJavaScript("(function(){var c=window.mraid={};c.STATES={LOADING:\"loading\",DEFAULT:\"default\",RESIZED:\"resized\",EXPANDED:\"expanded\",HIDDEN:\"hidden\"};var d=c.EVENTS={READY:\"ready\",ERROR:\"error\",STATECHANGE:\"stateChange\",VIEWABLECHANGE:\"viewableChange\",ORIENTATIONCHANGE:\"orientationChange\",PASSBOOKCHANGE:\"passbookChange\"},i={width:0,height:0},g={width:0,height:0},f={},h={width:0,height:0,useCustomClose:!1,isModal:!0,lockOrientation:!1,orientation:\"\"},l=function(a){this.event=a;this.count=0;var b={};this.add=function(a){var c=String(a);b[c]||(b[c]=a,this.count++)};this.remove=function(a){a=String(a);return b[a]?(b[a]=null,delete b[a],this.count--,!0):!1};this.removeAll=function(){for(var a in b)this.remove(b[a])};this.broadcast=function(a){for(var c in b)b[c].apply({},a)};this.toString=function(){var c=[a,\":\"],d;for(d in b)c.push(\"|\",d,\"|\");return c.join(\"\")}};mraidview.addEventListener(d.READY,function(){e(d.READY)});mraidview.addEventListener(d.STATECHANGE,function(a){e(d.STATECHANGE,a)});mraidview.addEventListener(d.VIEWABLECHANGE,function(a){e(d.VIEWABLECHANGE,a)});mraidview.addEventListener(\"error\",function(a,b){e(d.ERROR,a,b)});mraidview.addEventListener(d.ORIENTATIONCHANGE,function(a){e(d.ORIENTATIONCHANGE,a)});var k=function(a){var b=function(){};b.prototype=a;return new b},e=function(){for(var a=Array(arguments.length),b=0;b<arguments.length;b++)a[b]=arguments[b];b=a.shift();try{f[b]&&f[b].broadcast(a)}catch(c){}},j=function(a){for(var b=0,c=a.length-1;b<a.length&&\" \"==a[b];)b++;for(;c>b&&\" \"==a[c];)c-=1;return a.substring(b,c+1)};c.addEventListener=function(a,b){try{!a||!b?e(d.ERROR,\"Both event and listener are required.\",\"addEventListener\"):d.ERROR==a||d.READY==a||d.STATECHANGE==a||d.VIEWABLECHANGE==a||d.ORIENTATIONCHANGE==a?(f[a]||(f[a]=new l(a)),f[a].add(b)):mraidview.addEventListener(a,b)}catch(c){mraidview.log(c)}};c.useCustomClose=function(a){h.useCustomClose=a;mraidview.useCustomClose(a)};c.close=function(){mraidview.close()};c.getExpandProperties=function(){return h};c.setExpandProperties=function(a){h=a;h.isModal=!0;mraidview.setExpandProperties(h)};c.expand=function(a){mraidview.expand(a)};c.getMaxSize=function(){return k(g)};c.getSize=function(){return k(i)};c.getState=function(){return mraidview.getState()};c.getOrientation=function(){return mraidview.getOrientation()};c.isViewable=function(){return mraidview.isViewable()};c.open=function(a){a?mraidview.open(a):e(d.ERROR,\"URL is required.\",\"open\")};c.removeEventListener=function(a,b){try{if(a){if(b)if(f[a])f[a].remove(b);else{mraidview.removeEventListener(a,b);return}else f[a]&&f[a].removeAll();f[a]&&0==f[a].count&&(f[a]=null,delete f[a])}else e(d.ERROR,\"Must specify an event.\",\"removeEventListener\")}catch(c){mraidview.log(\"removeEventListener\"+c)}};c.resize=function(a,b){null==a||null==b||isNaN(a)||isNaN(b)||0>a||0>b?e(d.ERROR,\"Requested size must be numeric values between 0 and maxSize.\",\"resize\"):a>g.width||b>g.height?e(d.ERROR,\"Request (\"+a+\" x \"+b+\") exceeds maximum allowable size of (\"+g.width+\" x \"+g.height+\")\",\"resize\"):a==i.width&&b==i.height?e(d.ERROR,\"Requested size equals current size.\",\"resize\"):mraidview.resize(a,b)};c.log=function(a){null == a || \"undefined\" == a?e(d.ERROR,\"message is required.\",\"log\"):mraidview.log(a)};c.getVersion=function(){return\"1.0\"};c.getInMobiAIVersion=function(){return 1.2};c.getPlacementType=function(){return mraidview.getPlacementType()};c.asyncPing=function(a){a?mraidview.asyncPing(a):e(d.ERROR,\"URL is required.\",\"asyncPing\")};c.makeCall=function(a){!a||\"string\"!=typeof a||0==j(a).length?e(d.ERROR,\"Request must provide a number to call.\",\"makeCall\"):mraidview.makeCall(a)};c.sendMail=function(a,b,c){!a||\"string\"!=typeof a||0==j(a).length?e(d.ERROR,\"Request must specify a recipient.\",\"sendMail\"):mraidview.sendMail(a,b,c)};c.sendSMS=function(a,b){!a||\"string\"!=typeof a||0==j(a).length?e(d.ERROR,\"Request must specify a recipient.\",\"sendSMS\"):mraidview.sendSMS(a,b)};c.playAudio=function(a,b){\"undefined\"==typeof b||null==b?\"string\"==typeof a?mraidview.playAudio(a,null):\"object\"==typeof a?mraidview.playAudio(null,a):mraidview.playAudio(null,null):mraidview.playAudio(a,b)};c.playVideo=function(a,b){\"undefined\"==typeof b||null==b?\"string\"==typeof a?mraidview.playVideo(a,null):\"object\"==typeof a?mraidview.playVideo(null,a):mraidview.playVideo(null,null):mraidview.playVideo(a,b)};c.pauseAudio=function(a){mraidview.pauseAudio(a)};c.muteAudio=function(a){mraidview.muteAudio(a)};c.unMuteAudio=function(a){mraidview.unMuteAudio(a)};c.isAudioMuted=function(a){return mraidview.isAudioMuted(a)};c.setAudioVolume=function(a){var b=a.volume;\"undefined\"==typeof b||null==b?e(d.ERROR,\"Request must specify a valid volume\",\"setAudioVolume\"):0>b||100<b?e(d.ERROR,\"Request must specify a valid volume value in the range 0..100\",\"setAudioVolume\"):mraidview.setAudioVolume(a,b)};c.getAudioVolume=function(a){return mraidview.getAudioVolume(a)};c.pauseVideo=function(a){mraidview.pauseVideo(a)};c.closeVideo=function(a){mraidview.closeVideo(a)};c.hideVideo=function(a){mraidview.hideVideo(a)};c.showVideo=function(a){mraidview.showVideo(a)};c.muteVideo=function(a){mraidview.muteVideo(a)};c.unMuteVideo=function(a){mraidview.unMuteVideo(a)};c.isVideoMuted=function(a){return mraidview.isVideoMuted(a)};c.setVideoVolume=function(a){var b=a.volume;\"undefined\"==typeof b||null==b?e(d.ERROR,\"Request must specify a valid volume\",\"setVideoVolume\"):0>b||100<b?e(d.ERROR,\"Request must specify a valid volume value in the range 0..100\",\"setVideoVolume\"):mraidview.setVideoVolume(a,b)};c.getVideoVolume=function(a){return mraidview.getVideoVolume(a)};c.seekAudio=function(a){var b=a.time;\"undefined\"==typeof b||null==b?e(d.ERROR,\"Request must specify a valid time\",\"seekAudio\"):0!=b?e(d.ERROR,\"Cannot seek audio other than 0\",\"seekAudio\"):mraidview.seekAudio(a,b)};c.seekVideo=function(a){var b=a.time;\"undefined\"==typeof b||null==b?e(d.ERROR,\"Request must specify a valid time\",\"seekVideo\"):0!=b?e(d.ERROR,\"Cannot seek video other than 0\",\"seekVideo\"):mraidview.seekVideo(a,b)};c.openExternal=function(a){mraidview.openExternal(a)};c.updateToPassbook=function(a){mraidview.updateToPassbook(a)};c.getScreenSize=function(){return mraidview.getScreenSize()};c.getCurrentPosition=function(){return mraidview.getCurrentPosition()};c.acceptAction=function(a){mraidview.acceptAction(a)};c.rejectAction=function(a){mraidview.rejectAction(a)}})();");
        }
        IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> Current State:" + IMWebView.b(IMWebView.this));
        if (IMWebView.b(IMWebView.this) == IMWebView.ViewState.LOADING)
        {
          if (IMWebView.g(IMWebView.this)) {
            IMWebView.a(IMWebView.this, IMWebView.ViewState.EXPANDED);
          }
          for (;;)
          {
            IMWebView.this.injectJavaScript("window.mraidview.fireReadyEvent();");
            if ((!IMWebView.this.mIsInterstitialAd) || (IMWebView.h(IMWebView.this)))
            {
              IMWebView.b(IMWebView.this, true);
              if (IMWebView.this.getVisibility() == 4) {
                IMWebView.this.setVisibility(0);
              }
            }
            if ((IMWebView.i(IMWebView.this) != null) && (!IMWebView.d(IMWebView.this).get())) {
              IMWebView.i(IMWebView.this).sendToTarget();
            }
            if (IMWebView.j(IMWebView.this) == null) {
              break;
            }
            IMWebView.j(IMWebView.this).sendToTarget();
            return;
            IMWebView.a(IMWebView.this, IMWebView.ViewState.DEFAULT);
          }
        }
        return;
      }
      catch (Exception paramAnonymousWebView)
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception in onPageFinished ", paramAnonymousWebView);
      }
    }
    
    public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> onPageStarted url: " + paramAnonymousString);
      if (IMWebView.a(IMWebView.this) != null) {
        IMWebView.a(IMWebView.this).onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
      }
      IMWebView.a(IMWebView.this, false);
    }
    
    public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> error: " + paramAnonymousString1);
      if (IMWebView.a(IMWebView.this) != null) {
        IMWebView.a(IMWebView.this).onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
      }
      try
      {
        if ((IMWebView.b(IMWebView.this) == IMWebView.ViewState.LOADING) && (IMWebView.c(IMWebView.this) != null) && (!IMWebView.d(IMWebView.this).get())) {
          IMWebView.c(IMWebView.this).onError();
        }
        IMWebView.a(IMWebView.this, null);
        return;
      }
      catch (Exception paramAnonymousWebView)
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception in webview loading ", paramAnonymousWebView);
      }
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> shouldOverrideUrlLoading, url:" + paramAnonymousString + "webview id" + paramAnonymousWebView);
      if (IMWebView.k(IMWebView.this))
      {
        IMWebView.a(IMWebView.this, paramAnonymousWebView, paramAnonymousString);
        return true;
      }
      paramAnonymousWebView = Uri.parse(paramAnonymousString);
      try
      {
        if (paramAnonymousString.startsWith("tel:"))
        {
          Intent localIntent1 = new Intent("android.intent.action.DIAL", Uri.parse(paramAnonymousString));
          localIntent1.addFlags(268435456);
          IMWebView.l(IMWebView.this).startActivity(localIntent1);
          IMWebView.this.fireOnLeaveApplication();
          return true;
        }
      }
      catch (Exception localException)
      {
        try
        {
          if ((!paramAnonymousString.startsWith("http://")) || (paramAnonymousString.contains("play.google.com")) || (paramAnonymousString.contains("market.android.com")) || (paramAnonymousString.contains("market%3A%2F%2F"))) {
            break label551;
          }
          IMWebView.this.doHidePlayers();
          if (IMWebView.h(IMWebView.this)) {
            break label549;
          }
          paramAnonymousWebView = new Intent(IMWebView.l(IMWebView.this), IMBrowserActivity.class);
          IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> open:" + paramAnonymousString);
          paramAnonymousWebView.putExtra("extra_url", paramAnonymousString);
          if ((IMWebView.this.getStateVariable() == IMWebView.ViewState.DEFAULT) && (!IMWebView.this.mIsInterstitialAd)) {
            paramAnonymousWebView.putExtra("FIRST_INSTANCE", true);
          }
          IMBrowserActivity.setWebViewListener(IMWebView.c(IMWebView.this));
          IMWebView.l(IMWebView.this).startActivity(paramAnonymousWebView);
          IMWebView.m(IMWebView.this);
          return true;
        }
        catch (Exception paramAnonymousWebView)
        {
          return false;
        }
        if (paramAnonymousString.startsWith("mailto:"))
        {
          localIntent2 = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
          localIntent2.addFlags(268435456);
          IMWebView.l(IMWebView.this).startActivity(localIntent2);
          IMWebView.this.fireOnLeaveApplication();
          return true;
        }
        if (paramAnonymousString.startsWith("about:blank")) {
          return false;
        }
        if ((paramAnonymousString.startsWith("http://")) && (!paramAnonymousString.contains("play.google.com")) && (!paramAnonymousString.contains("market.android.com")) && (!paramAnonymousString.contains("market%3A%2F%2F")))
        {
          IMWebView.this.doHidePlayers();
          if (IMWebView.h(IMWebView.this)) {
            break label600;
          }
          localIntent2 = new Intent(IMWebView.l(IMWebView.this), IMBrowserActivity.class);
          IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> shouldoverride:" + paramAnonymousString);
          localIntent2.putExtra("extra_url", paramAnonymousString);
          if ((IMWebView.this.getStateVariable() == IMWebView.ViewState.DEFAULT) && (!IMWebView.this.mIsInterstitialAd)) {
            localIntent2.putExtra("FIRST_INSTANCE", true);
          }
          IMBrowserActivity.setWebViewListener(IMWebView.c(IMWebView.this));
          IMWebView.l(IMWebView.this).startActivity(localIntent2);
          IMWebView.m(IMWebView.this);
          return true;
        }
        Intent localIntent2 = new Intent();
        localIntent2.setAction("android.intent.action.VIEW");
        localIntent2.setData(paramAnonymousWebView);
        localIntent2.addFlags(268435456);
        IMWebView.l(IMWebView.this).startActivity(localIntent2);
        IMWebView.this.fireOnLeaveApplication();
        return true;
      }
      label549:
      return false;
      label551:
      paramAnonymousString = new Intent();
      paramAnonymousString.setAction("android.intent.action.VIEW");
      paramAnonymousString.setData(paramAnonymousWebView);
      paramAnonymousString.addFlags(268435456);
      IMWebView.l(IMWebView.this).startActivity(paramAnonymousString);
      IMWebView.this.fireOnLeaveApplication();
      return true;
      label600:
      return false;
    }
  };
  private VideoView K;
  private ViewGroup L;
  private FrameLayout M;
  private WebChromeClient.CustomViewCallback N;
  private WebChromeClient O = new WebChromeClient()
  {
    public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, final JsResult paramAnonymousJsResult)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> onJsAlert, " + paramAnonymousString2);
      try
      {
        new AlertDialog.Builder(paramAnonymousWebView.getContext()).setTitle(paramAnonymousString1).setMessage(paramAnonymousString2).setPositiveButton(17039370, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymousJsResult.confirm();
          }
        }).setCancelable(false).create().show();
        return true;
      }
      catch (Exception paramAnonymousWebView)
      {
        for (;;) {}
      }
    }
    
    public void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "onShowCustomView ******************************");
      try
      {
        if ((paramAnonymousView instanceof FrameLayout))
        {
          IMWebView.a(IMWebView.this, (FrameLayout)paramAnonymousView);
          IMWebView.a(IMWebView.this, paramAnonymousCustomViewCallback);
          paramAnonymousView = (FrameLayout)IMWebView.l(IMWebView.this).findViewById(16908290);
          IMWebView.a(IMWebView.this, (ViewGroup)paramAnonymousView.getChildAt(0));
          if ((IMWebView.n(IMWebView.this).getFocusedChild() instanceof VideoView))
          {
            IMWebView.a(IMWebView.this, (VideoView)IMWebView.n(IMWebView.this).getFocusedChild());
            IMWebView.o(IMWebView.this).setVisibility(8);
            IMWebView.n(IMWebView.this).setVisibility(0);
            IMWebView.l(IMWebView.this).setContentView(IMWebView.n(IMWebView.this));
            IMWebView.p(IMWebView.this).setOnCompletionListener(IMWebView.q(IMWebView.this));
            IMWebView.p(IMWebView.this).setOnKeyListener(new View.OnKeyListener()
            {
              public boolean onKey(View paramAnonymous2View, int paramAnonymous2Int, KeyEvent paramAnonymous2KeyEvent)
              {
                if ((4 == paramAnonymous2KeyEvent.getKeyCode()) && (paramAnonymous2KeyEvent.getAction() == 0))
                {
                  IMLog.debug("InMobiAndroidSDK_3.6.1", "Back Button pressed when html5 video is playing");
                  IMWebView.p(IMWebView.this).stopPlayback();
                  IMWebView.n(IMWebView.this).setVisibility(8);
                  IMWebView.r(IMWebView.this);
                  IMWebView.l(IMWebView.this).setContentView(IMWebView.o(IMWebView.this));
                  return true;
                }
                return false;
              }
            });
            IMWebView.p(IMWebView.this).start();
          }
        }
        return;
      }
      catch (Exception paramAnonymousView) {}
    }
  };
  private MediaPlayer.OnCompletionListener P = new MediaPlayer.OnCompletionListener()
  {
    public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      paramAnonymousMediaPlayer.stop();
      IMWebView.n(IMWebView.this).setVisibility(8);
      IMWebView.r(IMWebView.this);
      IMWebView.l(IMWebView.this).setContentView(IMWebView.o(IMWebView.this));
    }
  };
  private boolean Q;
  private boolean R = true;
  private Message S;
  private Message T;
  private Message U;
  private Activity V;
  private Activity W;
  private Message X;
  private int Y = -5;
  private int Z = -5;
  private WebViewClient aa;
  private boolean b;
  private JSUtilityController c;
  private float d;
  private int e;
  private int f;
  private int g;
  private ViewState h = ViewState.LOADING;
  private IMWebViewListener i;
  public boolean isTablet = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l;
  private String m;
  public boolean mIsInterstitialAd = false;
  public Message mMsgOnInterstitialShown;
  public IMWebView mOriginalWebviewForExpandUrl = null;
  private int n;
  private boolean o = false;
  private IMWebView p;
  public int publisherOrientation;
  private boolean q;
  private boolean r = false;
  private boolean s = true;
  private JSController.ExpandProperties t;
  private boolean u = false;
  public boolean useLockOrient;
  private String v;
  private IMAVPlayer w;
  public String webviewUserAgent;
  private IMAVPlayer x;
  private Object y = new Object();
  private AtomicBoolean z = new AtomicBoolean(false);
  
  public IMWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
    getContext().obtainStyledAttributes(paramAttributeSet, a).recycle();
  }
  
  public IMWebView(Context paramContext, IMWebViewListener paramIMWebViewListener)
  {
    super(paramContext);
    this.i = paramIMWebViewListener;
    f();
  }
  
  public IMWebView(Context paramContext, IMWebViewListener paramIMWebViewListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    this.V = ((Activity)paramContext);
    this.mIsInterstitialAd = paramBoolean1;
    this.q = paramBoolean2;
    if (this.mIsInterstitialAd) {
      setId(117);
    }
    this.i = paramIMWebViewListener;
    f();
  }
  
  private int a(Activity paramActivity)
  {
    Iterator localIterator = paramActivity.getPackageManager().queryIntentActivities(new Intent(paramActivity, paramActivity.getClass()), 65536).iterator();
    if (!localIterator.hasNext()) {}
    ResolveInfo localResolveInfo;
    for (paramActivity = null;; paramActivity = localResolveInfo)
    {
      return paramActivity.activityInfo.configChanges;
      localResolveInfo = (ResolveInfo)localIterator.next();
      if (!localResolveInfo.activityInfo.name.contentEquals(paramActivity.getClass().getName())) {
        break;
      }
    }
  }
  
  private FrameLayout a(JSController.ExpandProperties paramExpandProperties)
  {
    FrameLayout localFrameLayout1 = (FrameLayout)getRootView().findViewById(16908290);
    c();
    FrameLayout localFrameLayout2 = new FrameLayout(getContext());
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(IMWrapperFunctions.getParamFillParent(), IMWrapperFunctions.getParamFillParent());
    localFrameLayout2.setId(435);
    localFrameLayout2.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    localFrameLayout2.setPadding(paramExpandProperties.x, paramExpandProperties.y, 0, 0);
    FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(paramExpandProperties.width, paramExpandProperties.height);
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setId(438);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramExpandProperties.width, paramExpandProperties.height);
    if (this.o) {
      localRelativeLayout.addView(this.p, localLayoutParams);
    }
    for (;;)
    {
      a(localRelativeLayout, paramExpandProperties.useCustomClose);
      localFrameLayout2.addView(localRelativeLayout, localLayoutParams2);
      localFrameLayout1.addView(localFrameLayout2, localLayoutParams1);
      setFocusable(true);
      setFocusableInTouchMode(true);
      requestFocus();
      return localFrameLayout2;
      localRelativeLayout.addView(this, localLayoutParams);
    }
  }
  
  private String a(String paramString)
  {
    try
    {
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
      Object localObject2 = new BasicHttpContext();
      Object localObject1 = paramString;
      if (localDefaultHttpClient.execute(new HttpGet(paramString), (HttpContext)localObject2).getStatusLine().getStatusCode() != 200) {
        return localObject1;
      }
      localObject1 = (HttpUriRequest)((HttpContext)localObject2).getAttribute("http.request");
      localObject2 = (HttpHost)((HttpContext)localObject2).getAttribute("http.target_host");
      if (((HttpUriRequest)localObject1).getURI().isAbsolute())
      {
        localObject1 = ((HttpUriRequest)localObject1).getURI().toString();
        paramString = (String)localObject1;
      }
      else
      {
        localObject1 = ((HttpHost)localObject2).toURI() + ((HttpUriRequest)localObject1).getURI();
        paramString = (String)localObject1;
      }
    }
    catch (Exception localException)
    {
      IMLog.internal("InMobiAndroidSDK_3.6.1", "Exception getting final redirect url", localException);
      return paramString;
    }
    String str = paramString;
    return str;
  }
  
  private void a(int paramInt)
  {
    String str = "window.mraidview.fireOrientationChangeEvent(" + getCurrentRotation(paramInt) + ");";
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSDisplayController-> " + str);
    injectJavaScript(str);
    if (this.o) {
      this.p.injectJavaScript(str);
    }
  }
  
  private void a(Bundle arg1)
  {
    try
    {
      str = ???.getString("expand_url");
      if (URLUtil.isValidUrl(str))
      {
        this.o = true;
        this.p = new IMWebView(getContext(), this.i, false, false);
        this.p.o = true;
        this.p.publisherOrientation = this.publisherOrientation;
        this.p.s = this.s;
        this.p.t = new JSController.ExpandProperties();
        this.p.t.x = this.t.x;
        this.p.t.y = this.t.y;
        this.p.t.currentX = this.t.currentX;
        this.p.t.currentY = this.t.currentY;
        this.p.useLockOrient = this.useLockOrient;
        this.p.mOriginalWebviewForExpandUrl = this;
        setExpandedActivity(this.V);
        if (!this.t.lockOrientation)
        {
          this.Y = -5;
          this.Z = -5;
          injectJavaScript("window.mraidview.registerOrientationListener()");
        }
        a(this.t).setBackgroundColor(0);
        this.n = this.t.width;
        if (this.p != null) {
          this.p.n = this.t.width;
        }
        a(ViewState.EXPANDED);
      }
    }
    catch (Exception ???)
    {
      synchronized (this.y)
      {
        for (;;)
        {
          String str;
          this.z.set(false);
          this.y.notifyAll();
          if (this.o) {
            this.p.loadUrl(str);
          }
          if (this.i == null) {
            break;
          }
          this.i.onExpand();
          return;
          this.o = false;
        }
        ??? = ???;
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception in doexpand ", ???);
        this.h = ViewState.DEFAULT;
        synchronized (this.y)
        {
          this.z.set(false);
          this.y.notifyAll();
          return;
        }
      }
    }
  }
  
  private void a(Bundle paramBundle, Activity paramActivity)
  {
    final JSController.PlayerProperties localPlayerProperties = (JSController.PlayerProperties)paramBundle.getParcelable("player_properties");
    Object localObject = paramBundle.getString("expand_url");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    if (!a(localPlayerProperties.id, paramBundle, paramActivity)) {}
    do
    {
      return;
      if (((paramBundle.length() != 0) && (!URLUtil.isValidUrl(paramBundle))) || ((paramBundle.length() == 0) && (!this.B.containsKey(localPlayerProperties.id))))
      {
        raiseError("Request must specify a valid URL", "playAudio");
        return;
      }
    } while (this.x == null);
    if (paramBundle.length() != 0) {
      this.x.setPlayData(localPlayerProperties, paramBundle);
    }
    this.B.put(localPlayerProperties.id, this.x);
    paramBundle = (FrameLayout)paramActivity.findViewById(16908290);
    if (localPlayerProperties.isFullScreen())
    {
      localObject = new RelativeLayout.LayoutParams(IMWrapperFunctions.getParamFillParent(), IMWrapperFunctions.getParamFillParent());
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      this.x.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramActivity = new RelativeLayout(paramActivity);
      paramActivity.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      paramActivity.setBackgroundColor(-16777216);
      paramBundle.addView(paramActivity, new RelativeLayout.LayoutParams(IMWrapperFunctions.getParamFillParent(), IMWrapperFunctions.getParamFillParent()));
      paramActivity.addView(this.x);
      this.x.setBackGroundLayout(paramActivity);
      this.x.requestFocus();
      this.x.setOnKeyListener(new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((4 == paramAnonymousKeyEvent.getKeyCode()) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            IMLog.debug("InMobiAndroidSDK_3.6.1", "Back button pressed while fullscreen audio was playing");
            IMWebView.B(IMWebView.this).releasePlayer(true);
            return true;
          }
          return false;
        }
      });
    }
    for (;;)
    {
      this.x.setListener(new IMAVPlayerListener()
      {
        public void onComplete(IMAVPlayer paramAnonymousIMAVPlayer)
        {
          try
          {
            ViewGroup localViewGroup;
            if (localPlayerProperties.isFullScreen())
            {
              localViewGroup = (ViewGroup)paramAnonymousIMAVPlayer.getBackGroundLayout().getParent();
              if (localViewGroup != null) {
                localViewGroup.removeView(paramAnonymousIMAVPlayer.getBackGroundLayout());
              }
            }
            else
            {
              localViewGroup = (ViewGroup)paramAnonymousIMAVPlayer.getParent();
              if (localViewGroup != null)
              {
                localViewGroup.removeView(paramAnonymousIMAVPlayer);
                return;
              }
            }
          }
          catch (Exception paramAnonymousIMAVPlayer)
          {
            IMLog.debug("InMobiAndroidSDK_3.6.1", "Problem removing the audio relativelayout", paramAnonymousIMAVPlayer);
          }
        }
        
        public void onError(IMAVPlayer paramAnonymousIMAVPlayer)
        {
          onComplete(paramAnonymousIMAVPlayer);
        }
        
        public void onPrepared(IMAVPlayer paramAnonymousIMAVPlayer) {}
      });
      this.x.play();
      return;
      this.x.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
      paramBundle.addView(this.x);
    }
  }
  
  private void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.d * 50.0F), (int)(this.d * 50.0F));
    localLayoutParams.addRule(11);
    if (paramBoolean) {}
    for (IMCustomView localIMCustomView = new IMCustomView(getContext(), this.d, IMCustomView.SwitchIconType.CLOSE_TRANSPARENT);; localIMCustomView = new IMCustomView(getContext(), this.d, IMCustomView.SwitchIconType.CLOSE_BUTTON))
    {
      paramViewGroup.addView(localIMCustomView, localLayoutParams);
      localIMCustomView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          IMWebView.userInitiatedClose = true;
          IMWebView.this.close();
        }
      });
      return;
    }
  }
  
  private void a(WebView paramWebView, String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> Search query requested:" + paramString);
    try
    {
      paramWebView.stopLoading();
      int i1 = paramString.indexOf("?");
      if (i1 > 0)
      {
        paramWebView = paramString.substring(i1);
        if ((paramWebView != null) && (this.m != null))
        {
          paramString = this.m;
          System.out.println(paramString + paramWebView);
          Bundle localBundle = new Bundle();
          localBundle.putString("finaltargeturl", paramString + paramWebView);
          this.X.setData(localBundle);
          this.X.sendToTarget();
        }
      }
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  private void a(ViewState paramViewState)
  {
    this.h = paramViewState;
    if (paramViewState != ViewState.EXPANDING) {
      injectJavaScript("window.mraidview.fireStateChangeEvent('" + getState() + "');");
    }
  }
  
  private void a(JSController.Dimensions paramDimensions)
  {
    paramDimensions.width = ((int)(paramDimensions.width * this.d));
    paramDimensions.height = ((int)(paramDimensions.height * this.d));
    paramDimensions.x = ((int)(paramDimensions.x * this.d));
    paramDimensions.y = ((int)(paramDimensions.y * this.d));
    int i2 = (int)(this.d * 50.0F);
    int i3 = this.n - (int)(this.d * 50.0F);
    int i1 = 0;
    if ((paramDimensions.width <= 0) || (paramDimensions.height <= 0))
    {
      paramDimensions.width = 1;
      paramDimensions.height = 1;
      i1 = 1;
    }
    int i4 = getContext().getResources().getDisplayMetrics().widthPixels;
    int i5 = getContext().getResources().getDisplayMetrics().heightPixels;
    if (paramDimensions.width > i4) {
      paramDimensions.width = IMWrapperFunctions.getParamFillParent();
    }
    if (paramDimensions.height > i5) {
      paramDimensions.height = IMWrapperFunctions.getParamFillParent();
    }
    if ((i1 == 0) && (paramDimensions.x + paramDimensions.width > i3) && (paramDimensions.x < i3) && (paramDimensions.y < i2) && (paramDimensions.y + paramDimensions.height > i2)) {
      paramDimensions.y = i2;
    }
  }
  
  private void a(IMAVPlayer paramIMAVPlayer, JSController.Dimensions paramDimensions)
  {
    int i1 = (int)(-99999.0F * this.d);
    if ((paramIMAVPlayer.isInlineVideo()) && (paramDimensions.x != i1) && (paramDimensions.y != i1))
    {
      paramIMAVPlayer.setLayoutParams(new FrameLayout.LayoutParams(paramDimensions.width, paramDimensions.height));
      paramIMAVPlayer = (FrameLayout)paramIMAVPlayer.getBackGroundLayout();
      if (this.t == null) {
        paramIMAVPlayer.setPadding(paramDimensions.x, paramDimensions.y, 0, 0);
      }
    }
    else
    {
      return;
    }
    paramIMAVPlayer.setPadding(paramDimensions.x + this.t.currentX, paramDimensions.y + this.t.currentY, 0, 0);
  }
  
  private void a(boolean paramBoolean)
  {
    this.R = paramBoolean;
    injectJavaScript("window.mraidview.fireViewableChangeEvent(" + isViewable() + ");");
  }
  
  private boolean a(String paramString1, String paramString2, Activity paramActivity)
  {
    if (!this.B.isEmpty())
    {
      this.x = ((IMAVPlayer)this.B.get(paramString1));
      if (this.x == null)
      {
        if (this.B.size() > 4)
        {
          raiseError("Too many audio players", "playAudio");
          return false;
        }
        this.x = new IMAVPlayer(paramActivity, this);
      }
    }
    for (;;)
    {
      return true;
      if ((this.x.getMediaURL().equals(paramString2)) || (paramString2.length() == 0))
      {
        if (this.x.getState() == IMAVPlayer.playerState.PLAYING) {
          return false;
        }
        if (this.x.getState() == IMAVPlayer.playerState.PAUSED)
        {
          this.x.start();
          return false;
        }
        paramString2 = this.x.getProperties();
        String str = this.x.getMediaURL();
        this.x.releasePlayer(false);
        this.B.remove(paramString1);
        this.x = new IMAVPlayer(paramActivity, this);
        this.x.setPlayData(paramString2, str);
      }
      else
      {
        this.x.releasePlayer(false);
        this.B.remove(paramString1);
        this.x = new IMAVPlayer(paramActivity, this);
        continue;
        this.x = new IMAVPlayer(paramActivity, this);
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2, Activity paramActivity, JSController.Dimensions paramDimensions)
  {
    boolean bool = false;
    if ((this.w == null) || (!paramString1.equalsIgnoreCase(this.w.getPropertyID()))) {
      bool = b(paramString1, paramString2, paramActivity);
    }
    do
    {
      return bool;
      IMAVPlayer.playerState localplayerState = this.w.getState();
      if (!paramString1.equalsIgnoreCase(this.w.getPropertyID())) {
        break label219;
      }
      paramString1 = this.w.getMediaURL();
      if ((paramString2.length() != 0) && (!paramString2.equalsIgnoreCase(paramString1))) {
        break;
      }
      switch (a()[localplayerState.ordinal()])
      {
      case 4: 
      case 5: 
      default: 
        return false;
      case 2: 
        a(this.w, paramDimensions);
        return false;
      case 3: 
        this.w.start();
        a(this.w, paramDimensions);
        return false;
      }
    } while (this.w.getProperties().doLoop());
    this.w.start();
    return false;
    if (!URLUtil.isValidUrl(paramString2))
    {
      raiseError("Request must specify a valid URL", "playVideo");
      return false;
    }
    this.w.releasePlayer(false);
    this.w = new IMAVPlayer(paramActivity, this);
    label219:
    return true;
  }
  
  private void b()
  {
    if (this.h == ViewState.EXPANDED) {
      h();
    }
    invalidate();
    this.c.deleteOldAds();
    this.c.stopAllListeners();
    l();
  }
  
  private void b(Bundle paramBundle, Activity paramActivity)
  {
    JSController.PlayerProperties localPlayerProperties = (JSController.PlayerProperties)paramBundle.getParcelable("player_properties");
    Object localObject = (JSController.Dimensions)paramBundle.getParcelable("expand_dimensions");
    IMLog.debug("InMobiAndroidSDK_3.6.1", "Final dimensions: " + localObject);
    paramBundle = paramBundle.getString("expand_url");
    if (!a(localPlayerProperties.id, paramBundle, paramActivity, (JSController.Dimensions)localObject)) {
      return;
    }
    this.k = true;
    if (paramBundle.length() == 0)
    {
      localPlayerProperties = this.w.getProperties();
      paramBundle = this.w.getPlayDimensions();
      this.w.getMediaURL();
    }
    for (;;)
    {
      localObject = (FrameLayout)paramActivity.findViewById(16908290);
      if (!localPlayerProperties.isFullScreen()) {
        break;
      }
      paramBundle = new RelativeLayout.LayoutParams(IMWrapperFunctions.getParamFillParent(), IMWrapperFunctions.getParamFillParent());
      paramBundle.addRule(13);
      this.w.setLayoutParams(paramBundle);
      paramBundle = new RelativeLayout(paramActivity);
      paramBundle.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      paramBundle.setBackgroundColor(-16777216);
      ((FrameLayout)localObject).addView(paramBundle, new FrameLayout.LayoutParams(IMWrapperFunctions.getParamFillParent(), IMWrapperFunctions.getParamFillParent()));
      paramBundle.addView(this.w);
      this.w.setBackGroundLayout(paramBundle);
      this.w.requestFocus();
      this.w.setOnKeyListener(new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((4 == paramAnonymousKeyEvent.getKeyCode()) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            IMLog.debug("InMobiAndroidSDK_3.6.1", "Back pressed while fullscreen video is playing");
            IMWebView.w(IMWebView.this).releasePlayer(true);
            return true;
          }
          return false;
        }
      });
      this.w.setListener(new IMAVPlayerListener()
      {
        public void onComplete(IMAVPlayer paramAnonymousIMAVPlayer)
        {
          IMWebView.d(IMWebView.this, false);
          try
          {
            ViewGroup localViewGroup = (ViewGroup)paramAnonymousIMAVPlayer.getBackGroundLayout().getParent();
            if (localViewGroup != null) {
              localViewGroup.removeView(paramAnonymousIMAVPlayer.getBackGroundLayout());
            }
            paramAnonymousIMAVPlayer.setBackGroundLayout(null);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              try
              {
                if ((IMWebView.w(IMWebView.this) != null) && (paramAnonymousIMAVPlayer.getPropertyID().equalsIgnoreCase(IMWebView.w(IMWebView.this).getPropertyID()))) {
                  IMWebView.a(IMWebView.this, null);
                }
                return;
              }
              finally {}
              localException = localException;
              IMLog.debug("InMobiAndroidSDK_3.6.1", "Problem removing the video framelayout or relativelayout depending on video startstyle", localException);
            }
          }
        }
        
        public void onError(IMAVPlayer paramAnonymousIMAVPlayer)
        {
          onComplete(paramAnonymousIMAVPlayer);
        }
        
        public void onPrepared(IMAVPlayer paramAnonymousIMAVPlayer) {}
      });
      this.w.play();
      return;
      this.w.setPlayData(localPlayerProperties, paramBundle);
      this.w.setPlayDimensions((JSController.Dimensions)localObject);
      paramBundle = (Bundle)localObject;
    }
    this.w.setLayoutParams(new FrameLayout.LayoutParams(paramBundle.width, paramBundle.height));
    paramActivity = new FrameLayout(paramActivity);
    if (this.t == null) {
      paramActivity.setPadding(paramBundle.x, paramBundle.y, 0, 0);
    }
    for (;;)
    {
      ((FrameLayout)localObject).addView(paramActivity, new FrameLayout.LayoutParams(IMWrapperFunctions.getParamFillParent(), IMWrapperFunctions.getParamFillParent()));
      this.w.setBackGroundLayout(paramActivity);
      paramActivity.addView(this.w);
      break;
      paramActivity.setPadding(paramBundle.x + this.t.currentX, paramBundle.y + this.t.currentY, 0, 0);
    }
  }
  
  private void b(final String paramString)
  {
    try
    {
      if ((paramString.startsWith("http://")) && (!paramString.contains("play.google.com")) && (!paramString.contains("market.android.com")) && (!paramString.contains("market%3A%2F%2F")))
      {
        if (!URLUtil.isValidUrl(paramString))
        {
          raiseError("Invalid url", "open");
          return;
        }
        Intent localIntent = new Intent(this.W, IMBrowserActivity.class);
        IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> open:" + paramString);
        localIntent.putExtra("extra_url", paramString);
        if ((getStateVariable() == ViewState.DEFAULT) && (!this.mIsInterstitialAd) && (!this.q)) {
          localIntent.putExtra("FIRST_INSTANCE", true);
        }
        IMBrowserActivity.setWebViewListener(this.i);
        this.W.startActivity(localIntent);
        if (this.q) {
          return;
        }
        r();
      }
    }
    catch (ActivityNotFoundException paramString)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Failed to perform mraid Open");
      return;
      new Thread(new Runnable()
      {
        public void run()
        {
          String str = IMWebView.c(IMWebView.this, paramString);
          if (str != null)
          {
            Intent localIntent = new Intent();
            localIntent.setAction("android.intent.action.VIEW");
            localIntent.setData(Uri.parse(str));
            localIntent.addFlags(268435456);
            IMWebView.l(IMWebView.this).startActivity(localIntent);
            if (IMWebView.c(IMWebView.this) != null) {
              IMWebView.c(IMWebView.this).onLeaveApplication();
            }
          }
        }
      }).start();
      return;
    }
    catch (Exception paramString)
    {
      raiseError("Invalid url", "open");
    }
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 2);
  }
  
  private boolean b(Activity paramActivity)
  {
    int i2 = Build.VERSION.SDK_INT;
    int i3 = a(paramActivity);
    if (((i3 & 0x10) == 0) || ((i3 & 0x20) == 0) || ((i3 & 0x80) == 0)) {}
    for (int i1 = 0;; i1 = 1)
    {
      if ((i2 >= 13) && (((i3 & 0x400) == 0) || ((i3 & 0x800) == 0))) {}
      for (i2 = 0;; i2 = 1) {
        return (i1 != 0) && (i2 != 0);
      }
    }
  }
  
  private boolean b(String paramString1, String paramString2, Activity paramActivity)
  {
    if (((paramString2.length() != 0) && (!URLUtil.isValidUrl(paramString2))) || ((paramString2.length() == 0) && (!this.A.containsKey(paramString1))))
    {
      raiseError("Request must specify a valid URL", "playVideo");
      return false;
    }
    if (this.w != null) {
      this.w.releasePlayer(false);
    }
    IMAVPlayer localIMAVPlayer = d(paramString1);
    if (localIMAVPlayer == null) {}
    for (this.w = new IMAVPlayer(paramActivity, this);; this.w = localIMAVPlayer)
    {
      if (paramString2.length() == 0)
      {
        this.w.setPlayData(localIMAVPlayer.getProperties(), localIMAVPlayer.getMediaURL());
        this.w.setPlayDimensions(localIMAVPlayer.getPlayDimensions());
      }
      this.A.remove(paramString1);
      return true;
    }
  }
  
  /* Error */
  private IMAVPlayer c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: getfield 274	com/inmobi/androidsdk/ai/container/IMWebView:x	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;
    //   8: ifnull +26 -> 34
    //   11: aload_0
    //   12: getfield 274	com/inmobi/androidsdk/ai/container/IMWebView:x	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;
    //   15: invokevirtual 880	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:getPropertyID	()Ljava/lang/String;
    //   18: aload_1
    //   19: invokevirtual 883	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   22: ifeq +12 -> 34
    //   25: aload_0
    //   26: getfield 274	com/inmobi/androidsdk/ai/container/IMWebView:x	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: areturn
    //   34: aload_3
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 208	com/inmobi/androidsdk/ai/container/IMWebView:B	Ljava/util/Hashtable;
    //   40: invokevirtual 833	java/util/Hashtable:isEmpty	()Z
    //   43: ifne -13 -> 30
    //   46: aload_3
    //   47: astore_2
    //   48: aload_0
    //   49: getfield 208	com/inmobi/androidsdk/ai/container/IMWebView:B	Ljava/util/Hashtable;
    //   52: aload_1
    //   53: invokevirtual 621	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   56: ifeq -26 -> 30
    //   59: aload_0
    //   60: getfield 208	com/inmobi/androidsdk/ai/container/IMWebView:B	Ljava/util/Hashtable;
    //   63: aload_1
    //   64: invokevirtual 837	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast 630	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer
    //   70: astore_2
    //   71: goto -41 -> 30
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	IMWebView
    //   0	79	1	paramString	String
    //   29	42	2	localObject1	Object
    //   3	44	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	30	74	finally
    //   36	46	74	finally
    //   48	71	74	finally
  }
  
  private void c()
  {
    for (;;)
    {
      int i2;
      int i1;
      try
      {
        localViewGroup = (ViewGroup)getParent();
        i2 = localViewGroup.getChildCount();
        i1 = 0;
      }
      catch (Exception localException)
      {
        ViewGroup localViewGroup;
        Object localObject;
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception in replaceByPlaceHolder ", localException);
        return;
      }
      this.g = i1;
      localObject = new FrameLayout(getContext());
      ((FrameLayout)localObject).setId(437);
      localViewGroup.addView((View)localObject, i1, new ViewGroup.LayoutParams(getWidth(), getHeight()));
      localViewGroup.removeView(this);
      this.I = localViewGroup;
      return;
      localObject = localViewGroup.getChildAt(i1);
      if (localObject != this)
      {
        i1 += 1;
        if (i1 < i2) {}
      }
    }
  }
  
  private boolean c(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 3) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private IMAVPlayer d(String paramString)
  {
    if (!this.A.isEmpty()) {
      return (IMAVPlayer)this.A.get(paramString);
    }
    return null;
  }
  
  private void d()
  {
    int i4 = 0;
    this.Y = InternalSDKUtil.getDisplayRotation(this.H);
    if ((this.Y != -5) && (this.Y != this.Z)) {
      for (;;)
      {
        int i2;
        int i1;
        Object localObject3;
        int i3;
        JSController.Dimensions localDimensions;
        try
        {
          IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> SensorEventListener, It came inside the listener" + this.Y);
          this.Z = this.Y;
          i2 = this.V.getResources().getDisplayMetrics().widthPixels;
          i1 = this.V.getResources().getDisplayMetrics().heightPixels;
          if (this.isTablet)
          {
            this.Y += 1;
            if (this.Y > 3) {
              this.Y = 0;
            }
            IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> SensorEventListener, It is a tablet" + this.Y);
          }
          if (!this.mIsInterstitialAd)
          {
            if ((this.Y != 0) && (this.Y != 2)) {
              continue;
            }
            this.t.actualWidthRequested = this.t.portraitWidthRequested;
            this.t.actualHeightRequested = this.t.portraitHeightRequested;
            if (i2 <= i1) {
              break label1400;
            }
            if (this.t.zeroWidthHeight)
            {
              this.t.actualWidthRequested = i1;
              this.t.actualHeightRequested = i2;
            }
            i2 -= this.t.topStuff;
            if (!this.o) {
              continue;
            }
            localObject1 = (FrameLayout)this.p.getRootView().findViewById(16908290);
            if (localObject1 == null) {
              break label1391;
            }
            localObject3 = (FrameLayout)((FrameLayout)localObject1).findViewById(435);
            localObject1 = (RelativeLayout)((FrameLayout)localObject3).findViewById(438);
            if ((this.Y != 0) && (this.Y != 2)) {
              break label883;
            }
            IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> SensorEventListener, It is the case from landscape to portrait");
            this.t.width = Math.min(i1, this.t.actualWidthRequested);
            i3 = this.t.y;
            this.t.height = Math.min(this.t.actualHeightRequested, i2 - i3);
            i1 -= this.t.x + this.t.width;
            if (i1 >= 0) {
              continue;
            }
            i1 += this.t.x;
            if (i1 >= 0) {
              break label1388;
            }
            this.t.width = (i1 + this.t.width);
            i1 = i4;
            if (localObject3 != null)
            {
              ((FrameLayout)localObject3).setPadding(i1, this.t.y, 0, 0);
              this.t.currentX = i1;
              this.t.currentY = this.t.y;
              localObject3 = this.w;
              if (this.o)
              {
                this.p.t.currentX = this.t.currentX;
                this.p.t.currentY = this.t.currentY;
                localObject3 = this.p.w;
              }
              if ((localObject3 != null) && (((IMAVPlayer)localObject3).isInlineVideo()))
              {
                localDimensions = ((IMAVPlayer)localObject3).getPlayDimensions();
                if ((localDimensions != null) && (localDimensions.x >= 0) && (localDimensions.y >= 0))
                {
                  localObject3 = (FrameLayout)((IMAVPlayer)localObject3).getBackGroundLayout();
                  i2 = localDimensions.x;
                  i3 = this.t.y;
                  ((FrameLayout)localObject3).setPadding(i2 + i1, localDimensions.y + i3, 0, 0);
                }
              }
              ((RelativeLayout)localObject1).setLayoutParams(new FrameLayout.LayoutParams(this.t.width, this.t.height));
              if (!this.o) {
                continue;
              }
              this.p.setLayoutParams(new RelativeLayout.LayoutParams(this.t.width, this.t.height));
              this.p.n = this.t.width;
              IMLog.debug("InMobiAndroidSDK_3.6.1", "Dimensions: {" + i1 + " ," + this.t.y + " ," + this.t.width + " ," + this.t.height + "}");
            }
          }
          a(this.Y);
          return;
          this.t.actualWidthRequested = this.t.portraitHeightRequested;
          this.t.actualHeightRequested = this.t.portraitWidthRequested;
          if (i2 >= i1) {
            break label1400;
          }
          continue;
          Object localObject1 = (FrameLayout)getRootView().findViewById(16908290);
          continue;
          i1 = this.t.x;
          continue;
          setLayoutParams(new RelativeLayout.LayoutParams(this.t.width, this.t.height));
          this.n = this.t.width;
          continue;
          if (this.Y == 1) {
            break label899;
          }
        }
        catch (Exception localException)
        {
          IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception while changing the container coordinates or width while orientation change ", localException);
          return;
        }
        label883:
        if (this.Y == 3)
        {
          label899:
          IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> SensorEventListener, It is the case from portrait to landscape");
          this.t.height = Math.min(i2, this.t.actualHeightRequested);
          i3 = this.t.x;
          this.t.width = Math.min(this.t.actualWidthRequested, i1 - i3);
          i1 = i2 - (this.t.y + this.t.height);
          if (i1 < 0)
          {
            i1 += this.t.y;
            if (i1 >= 0) {
              break label1385;
            }
            this.t.height = (i1 + this.t.height);
            i1 = 0;
          }
          label1008:
          label1385:
          for (;;)
          {
            if (localObject3 == null) {
              break label1386;
            }
            ((FrameLayout)localObject3).setPadding(this.t.x, i1, 0, 0);
            this.t.currentX = this.t.x;
            this.t.currentY = i1;
            localObject3 = this.w;
            if (this.o)
            {
              this.p.t.currentX = this.t.currentX;
              this.p.t.currentY = this.t.currentY;
              localObject3 = this.p.w;
            }
            if ((localObject3 != null) && (((IMAVPlayer)localObject3).isInlineVideo()))
            {
              localDimensions = ((IMAVPlayer)localObject3).getPlayDimensions();
              if ((localDimensions != null) && (localDimensions.x >= 0) && (localDimensions.y >= 0)) {
                ((FrameLayout)((IMAVPlayer)localObject3).getBackGroundLayout()).setPadding(this.t.x + localDimensions.x, localDimensions.y + i1, 0, 0);
              }
            }
            localException.setLayoutParams(new FrameLayout.LayoutParams(this.t.width, this.t.height));
            if (this.o) {
              this.p.setLayoutParams(new RelativeLayout.LayoutParams(this.t.width, this.t.height));
            }
            for (this.p.n = this.t.width;; this.n = this.t.width)
            {
              IMLog.debug("InMobiAndroidSDK_3.6.1", "Dimensions: {" + this.t.x + " ," + i1 + " ," + this.t.width + " ," + this.t.height + "}");
              break;
              i1 = this.t.y;
              break label1008;
              setLayoutParams(new RelativeLayout.LayoutParams(this.t.width, this.t.height));
            }
          }
          label1386:
          continue;
          label1388:
          continue;
          label1391:
          Object localObject2 = null;
          localObject3 = null;
          continue;
          label1400:
          i3 = i2;
          i2 = i1;
          i1 = i3;
        }
      }
    }
  }
  
  /* Error */
  private IMAVPlayer e(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: getfield 787	com/inmobi/androidsdk/ai/container/IMWebView:w	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;
    //   8: ifnull +26 -> 34
    //   11: aload_0
    //   12: getfield 787	com/inmobi/androidsdk/ai/container/IMWebView:w	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;
    //   15: invokevirtual 880	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:getPropertyID	()Ljava/lang/String;
    //   18: aload_1
    //   19: invokevirtual 883	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   22: ifeq +12 -> 34
    //   25: aload_0
    //   26: getfield 787	com/inmobi/androidsdk/ai/container/IMWebView:w	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: areturn
    //   34: aload_3
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 206	com/inmobi/androidsdk/ai/container/IMWebView:A	Ljava/util/Hashtable;
    //   40: invokevirtual 833	java/util/Hashtable:isEmpty	()Z
    //   43: ifne -13 -> 30
    //   46: aload_3
    //   47: astore_2
    //   48: aload_0
    //   49: getfield 206	com/inmobi/androidsdk/ai/container/IMWebView:A	Ljava/util/Hashtable;
    //   52: aload_1
    //   53: invokevirtual 621	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   56: ifeq -26 -> 30
    //   59: aload_0
    //   60: getfield 206	com/inmobi/androidsdk/ai/container/IMWebView:A	Ljava/util/Hashtable;
    //   63: aload_1
    //   64: invokevirtual 837	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast 630	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer
    //   70: astore_2
    //   71: goto -41 -> 30
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	IMWebView
    //   0	79	1	paramString	String
    //   29	42	2	localObject1	Object
    //   3	44	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	30	74	finally
    //   36	46	74	finally
    //   48	71	74	finally
  }
  
  private void e()
  {
    try
    {
      if (this.K == null) {
        return;
      }
      this.K.setVisibility(8);
      this.M.removeView(this.K);
      this.K = null;
      this.M.setVisibility(8);
      this.N.onCustomViewHidden();
      this.L.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Error removing html5 video");
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void f()
  {
    this.W = this.V;
    userInitiatedClose = false;
    setScrollContainer(false);
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    this.webviewUserAgent = getSettings().getUserAgentString();
    setBackgroundColor(0);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.d = this.V.getResources().getDisplayMetrics().density;
    this.b = false;
    getSettings().setJavaScriptEnabled(true);
    this.c = new JSUtilityController(this, getContext());
    addJavascriptInterface(this.c, "utilityController");
    setWebViewClient(this.J);
    setWebChromeClient(this.O);
    this.H = ((WindowManager)this.V.getSystemService("window")).getDefaultDisplay();
    this.n = this.V.getResources().getDisplayMetrics().widthPixels;
    if (Build.VERSION.SDK_INT >= 14) {
      IMWrapperFunctions.disableHardwareAccl(this);
    }
  }
  
  private void g()
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> initStates");
    this.h = ViewState.LOADING;
    this.F.set(false);
    this.R = false;
  }
  
  private void h()
  {
    if (this.h.compareTo(ViewState.DEFAULT) == 0) {
      return;
    }
    synchronized (this.y)
    {
      this.z.set(false);
      this.y.notifyAll();
      if ((!this.s) && (this.publisherOrientation == -1)) {
        this.s = true;
      }
      k();
      releaseAllPlayers();
      this.E.clear();
      this.G.sendEmptyMessage(1005);
      setVisibility(0);
      this.o = false;
      if (this.useLockOrient) {
        this.V.setRequestedOrientation(this.D);
      }
      injectJavaScript("window.mraidview.unRegisterOrientationListener()");
      a(ViewState.DEFAULT);
      return;
    }
  }
  
  private void i()
  {
    IMCustomView localIMCustomView = (IMCustomView)this.W.findViewById(225);
    if (localIMCustomView != null)
    {
      if (this.r)
      {
        localIMCustomView.setSwitchInt(IMCustomView.SwitchIconType.CLOSE_TRANSPARENT);
        localIMCustomView.invalidate();
      }
    }
    else {
      return;
    }
    localIMCustomView.setSwitchInt(IMCustomView.SwitchIconType.CLOSE_BUTTON);
    localIMCustomView.invalidate();
  }
  
  private boolean j()
  {
    return this.r;
  }
  
  private void k()
  {
    try
    {
      FrameLayout localFrameLayout1;
      Object localObject;
      FrameLayout localFrameLayout2;
      if (this.o)
      {
        localFrameLayout1 = (FrameLayout)this.p.getRootView().findViewById(16908290);
        localObject = (FrameLayout)this.V.findViewById(437);
        localFrameLayout2 = (FrameLayout)localFrameLayout1.findViewById(435);
        IMLog.debug("InMobiAndroidSDK_3.6.1", "PlaceHolder ID: " + localObject + " Bg ID: " + localFrameLayout2);
        if (this.o) {
          this.p.releaseAllPlayers();
        }
        if (localFrameLayout2 != null)
        {
          if (!this.o) {
            break label185;
          }
          ((ViewGroup)localFrameLayout2.getChildAt(0)).removeView(this.p);
          this.p = null;
        }
      }
      for (;;)
      {
        localFrameLayout1.removeView(localFrameLayout2);
        l();
        if (localObject != null) {
          this.I.removeView((View)localObject);
        }
        this.I.addView(this, this.g);
        this.I.invalidate();
        return;
        localFrameLayout1 = (FrameLayout)getRootView().findViewById(16908290);
        break;
        label185:
        ((ViewGroup)localFrameLayout2.getChildAt(0)).removeView(this);
      }
      try
      {
        localObject = (ViewGroup)getParent();
        ((ViewGroup)localObject).removeAllViews();
        ((ViewGroup)((ViewGroup)localObject).getParent()).removeAllViews();
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception while closing the expanded Ad", localException1);
        return;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
    catch (Exception localException1) {}
  }
  
  private void l()
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (this.Q)
    {
      localLayoutParams.height = this.e;
      localLayoutParams.width = this.f;
    }
    setVisibility(0);
    requestLayout();
  }
  
  private void m()
  {
    userInitiatedClose = true;
    isInterstitialDisplayed.set(false);
    close();
  }
  
  private void n()
  {
    if (this.u)
    {
      int i1 = getIntegerCurrentRotation();
      if (this.v.equalsIgnoreCase("portrait")) {
        if (b(i1)) {
          this.V.setRequestedOrientation(IMWrapperFunctions.getParamPortraitOrientation(i1));
        }
      }
      do
      {
        do
        {
          return;
        } while (!b(this.V));
        if ((this.w != null) && (this.w.isInlineVideo()) && (!this.w.getState().equals(IMAVPlayer.playerState.RELEASED))) {
          this.w.releasePlayer(false);
        }
        this.V.setRequestedOrientation(IMWrapperFunctions.getParamPortraitOrientation(i1));
        return;
        if (c(i1))
        {
          this.V.setRequestedOrientation(IMWrapperFunctions.getParamLandscapeOrientation(i1));
          return;
        }
      } while (!b(this.V));
      if ((this.w != null) && (this.w.isInlineVideo()) && (!this.w.getState().equals(IMAVPlayer.playerState.RELEASED))) {
        this.w.releasePlayer(false);
      }
      this.V.setRequestedOrientation(IMWrapperFunctions.getParamLandscapeOrientation(i1));
      return;
    }
    this.Y = -5;
    this.Z = -5;
    injectJavaScript("window.mraidview.registerOrientationListener()");
  }
  
  private void o()
  {
    try
    {
      int i1 = getIntegerCurrentRotation();
      if (this.u)
      {
        if (this.v.equals("portrait"))
        {
          this.V.setRequestedOrientation(IMWrapperFunctions.getParamPortraitOrientation(i1));
          return;
        }
        if (this.v.equals("landscape"))
        {
          this.V.setRequestedOrientation(IMWrapperFunctions.getParamLandscapeOrientation(i1));
          return;
        }
      }
    }
    catch (Exception localException) {}
  }
  
  private void p()
  {
    try
    {
      this.mIsInterstitialAd = false;
      this.V.setRequestedOrientation(this.C);
      releaseAllPlayers();
      FrameLayout localFrameLayout = (FrameLayout)this.V.findViewById(16908290);
      RelativeLayout localRelativeLayout = (RelativeLayout)localFrameLayout.findViewById(224);
      if (localRelativeLayout != null)
      {
        localRelativeLayout.removeView(this);
        localFrameLayout.removeView(localRelativeLayout);
      }
      if (this.U != null)
      {
        this.U.sendToTarget();
        this.U = null;
      }
      injectJavaScript("window.mraidview.unRegisterOrientationListener()");
      a(ViewState.HIDDEN);
      return;
    }
    catch (Exception localException)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Failed to close the interstitial ad", localException);
    }
  }
  
  private void q()
  {
    if ((this.w != null) && (this.w.getState() != IMAVPlayer.playerState.RELEASED))
    {
      this.A.put(this.w.getPropertyID(), this.w);
      this.w.hide();
      this.w.releasePlayer(false);
    }
    Iterator localIterator = this.B.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      IMAVPlayer localIMAVPlayer = (IMAVPlayer)localEntry.getValue();
      switch (a()[localIMAVPlayer.getState().ordinal()])
      {
      default: 
        break;
      case 1: 
        localIMAVPlayer.releasePlayer(false);
        this.B.remove(localEntry.getKey());
        break;
      case 2: 
        localIMAVPlayer.pause();
      }
    }
  }
  
  private void r()
  {
    if ((this.i != null) && (getStateVariable() == ViewState.DEFAULT) && (!this.mIsInterstitialAd))
    {
      IMBrowserActivity.requestOnAdDismiss(this.G.obtainMessage(1028));
      this.i.onShowAdScreen();
    }
  }
  
  public void acceptAction(String paramString) {}
  
  public void addJavascriptObject(Object paramObject, String paramString)
  {
    addJavascriptInterface(paramObject, paramString);
  }
  
  public void cancelLoad()
  {
    this.F.set(true);
  }
  
  public void changeContentAreaForInterstitials(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.C = this.V.getRequestedOrientation();
        n();
        FrameLayout localFrameLayout = (FrameLayout)this.V.findViewById(16908290);
        RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
        Object localObject = new RelativeLayout.LayoutParams(IMWrapperFunctions.getParamFillParent(), IMWrapperFunctions.getParamFillParent());
        ((RelativeLayout.LayoutParams)localObject).addRule(10);
        setFocusable(true);
        setFocusableInTouchMode(true);
        localRelativeLayout.addView(this, (ViewGroup.LayoutParams)localObject);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.d * 50.0F), (int)(this.d * 50.0F));
        if (!j())
        {
          localObject = new IMCustomView(getContext(), this.d, IMCustomView.SwitchIconType.CLOSE_BUTTON);
          localLayoutParams.addRule(11);
          ((IMCustomView)localObject).setId(225);
          localRelativeLayout.addView((View)localObject, localLayoutParams);
          ((IMCustomView)localObject).setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              IMWebView.C(IMWebView.this);
            }
          });
          localObject = new RelativeLayout.LayoutParams(IMWrapperFunctions.getParamFillParent(), IMWrapperFunctions.getParamFillParent());
          localRelativeLayout.setId(224);
          if (paramBoolean)
          {
            i1 = 0;
            localRelativeLayout.setBackgroundColor(i1);
            localFrameLayout.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
            if (!paramBoolean) {
              break label322;
            }
            i1 = 0;
            setBackgroundColor(i1);
            requestFocus();
            setOnKeyListener(new View.OnKeyListener()
            {
              public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
              {
                if ((4 == paramAnonymousKeyEvent.getKeyCode()) && (paramAnonymousKeyEvent.getAction() == 0))
                {
                  IMLog.debug("InMobiAndroidSDK_3.6.1", "Back Button pressed while Interstitial ad is in active state ");
                  IMWebView.C(IMWebView.this);
                  return true;
                }
                return false;
              }
            });
            setOnTouchListener(new View.OnTouchListener()
            {
              public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                switch (paramAnonymousMotionEvent.getAction())
                {
                }
                for (;;)
                {
                  return false;
                  paramAnonymousView.requestFocus();
                  continue;
                  paramAnonymousView.requestFocus();
                }
              }
            });
            isInterstitialDisplayed.set(true);
            if (this.mMsgOnInterstitialShown != null)
            {
              this.mMsgOnInterstitialShown.sendToTarget();
              this.mMsgOnInterstitialShown = null;
            }
            a(true);
          }
        }
        else
        {
          localObject = new IMCustomView(getContext(), this.d, IMCustomView.SwitchIconType.CLOSE_TRANSPARENT);
          continue;
        }
        i1 = -16777216;
      }
      catch (Exception localException)
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Failed showing interstitial ad", localException);
        return;
      }
      continue;
      label322:
      int i1 = -16777216;
    }
  }
  
  public void clearView()
  {
    b();
    super.clearView();
  }
  
  public void close()
  {
    if (!this.G.hasMessages(1001)) {
      this.G.sendEmptyMessage(1001);
    }
  }
  
  protected void closeOpened(View paramView)
  {
    ((ViewGroup)((Activity)getContext()).getWindow().getDecorView()).removeView(paramView);
    requestLayout();
  }
  
  public void closeVideo(String paramString)
  {
    IMAVPlayer localIMAVPlayer = e(paramString);
    if (localIMAVPlayer == null)
    {
      raiseError("Invalid property ID", "closeVideo");
      return;
    }
    if (localIMAVPlayer.getState() == IMAVPlayer.playerState.RELEASED)
    {
      raiseError("Invalid player state", "closeVideo");
      return;
    }
    this.A.remove(paramString);
    paramString = this.G.obtainMessage(1012);
    paramString.obj = localIMAVPlayer;
    this.G.sendMessage(paramString);
  }
  
  public void deinit()
  {
    if ((getStateVariable() == ViewState.EXPANDED) || (getStateVariable() == ViewState.EXPANDING)) {
      close();
    }
  }
  
  public void doHidePlayers()
  {
    this.G.sendEmptyMessage(1023);
  }
  
  public void expand(String paramString, JSController.ExpandProperties paramExpandProperties)
  {
    a(ViewState.EXPANDING);
    this.o = false;
    this.z.set(true);
    Message localMessage = this.G.obtainMessage(1004);
    Bundle localBundle = new Bundle();
    localBundle.putString("expand_url", paramString);
    localMessage.setData(localBundle);
    this.t = paramExpandProperties;
    IMLog.debug("InMobiAndroidSDK_3.6.1", "Dimensions: {" + this.t.x + " ," + this.t.y + " ," + this.t.width + " ," + this.t.height + "}");
    this.s = this.t.lockOrientation;
    this.G.sendMessage(localMessage);
  }
  
  public void fireOnLeaveApplication()
  {
    doHidePlayers();
    if (this.i != null) {
      this.i.onLeaveApplication();
    }
  }
  
  public int getAudioVolume(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "getAudioVolume");
      return -1;
    }
    return paramString.getVolume();
  }
  
  public String getCurrentRotation(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "-1";
    case 0: 
      return "0";
    case 1: 
      return "90";
    case 2: 
      return "180";
    }
    return "270";
  }
  
  public Activity getExpandedActivity()
  {
    return this.W;
  }
  
  public int getIntegerCurrentRotation()
  {
    int i2 = InternalSDKUtil.getDisplayRotation(((WindowManager)this.W.getSystemService("window")).getDefaultDisplay());
    int i1 = i2;
    if (InternalSDKUtil.getWhetherTablet(i2, this.W.getResources().getDisplayMetrics().widthPixels, this.W.getResources().getDisplayMetrics().heightPixels))
    {
      i2 += 1;
      i1 = i2;
      if (i2 > 3) {
        i1 = 0;
      }
      this.isTablet = true;
    }
    return i1;
  }
  
  public String getPlacementType()
  {
    if (this.mIsInterstitialAd) {
      return "interstitial";
    }
    return "inline";
  }
  
  public String getSize()
  {
    return "{ width: " + (int)(getWidth() / this.d) + ", " + "height: " + (int)(getHeight() / this.d) + "}";
  }
  
  public String getState()
  {
    return this.h.toString().toLowerCase();
  }
  
  public ViewState getStateVariable()
  {
    return this.h;
  }
  
  public int getVideoVolume(String paramString)
  {
    paramString = e(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "getVideoVolume");
      return -1;
    }
    return paramString.getVolume();
  }
  
  public void hide()
  {
    this.G.sendEmptyMessage(1002);
  }
  
  public void hideVideo(String paramString)
  {
    Message localMessage = this.G.obtainMessage(1013);
    Bundle localBundle = new Bundle();
    localBundle.putString("pid", paramString);
    localMessage.setData(localBundle);
    this.G.sendMessage(localMessage);
  }
  
  public void injectJavaScript(String paramString)
  {
    if ((paramString != null) && (this.j))
    {
      if (paramString.length() < 400) {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Injecting JavaScript: " + paramString);
      }
      super.loadUrl("javascript:" + paramString);
    }
  }
  
  public boolean isAudioMuted(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "isAudioMuted");
      return false;
    }
    return paramString.isMediaMuted();
  }
  
  public boolean isBusy()
  {
    return this.k;
  }
  
  public boolean isExpanded()
  {
    return this.h == ViewState.EXPANDED;
  }
  
  public boolean isPageFinished()
  {
    return this.b;
  }
  
  public boolean isVideoMuted(String paramString)
  {
    paramString = e(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "isVideoMuted");
      return false;
    }
    return paramString.isMediaMuted();
  }
  
  public boolean isViewable()
  {
    return this.R;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    super.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    g();
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    g();
    super.loadUrl(paramString);
  }
  
  public void lockExpandOrientation(JSController.ExpandProperties paramExpandProperties)
  {
    try
    {
      this.D = this.V.getRequestedOrientation();
      if (paramExpandProperties.lockOrientation)
      {
        this.useLockOrient = true;
        int i1 = getIntegerCurrentRotation();
        if (paramExpandProperties.orientation.equalsIgnoreCase("portrait"))
        {
          if ((b(this.V)) || (b(i1))) {
            this.V.setRequestedOrientation(IMWrapperFunctions.getParamPortraitOrientation(i1));
          }
        }
        else if ((b(this.V)) || (c(i1)))
        {
          this.V.setRequestedOrientation(IMWrapperFunctions.getParamLandscapeOrientation(i1));
          return;
        }
      }
    }
    catch (Exception paramExpandProperties)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception handling the orientation ", paramExpandProperties);
    }
  }
  
  public void muteAudio(String paramString)
  {
    Object localObject = c(paramString);
    if (localObject == null)
    {
      raiseError("Invalid property ID", "muteAudio");
      return;
    }
    if (((IMAVPlayer)localObject).getState() == IMAVPlayer.playerState.RELEASED)
    {
      raiseError("Invalid player state", "muteAudio");
      return;
    }
    localObject = this.G.obtainMessage(1019);
    Bundle localBundle = new Bundle();
    localBundle.putString("aplayerref", paramString);
    ((Message)localObject).setData(localBundle);
    ((Message)localObject).sendToTarget();
  }
  
  public void muteVideo(String paramString)
  {
    paramString = e(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "muteVideo");
      return;
    }
    if ((paramString.getState() == IMAVPlayer.playerState.RELEASED) || (paramString.getState() == IMAVPlayer.playerState.INIT))
    {
      raiseError("Invalid player state", "muteVideo");
      return;
    }
    Message localMessage = this.G.obtainMessage(1015);
    localMessage.obj = paramString;
    this.G.sendMessage(localMessage);
  }
  
  protected void onAttachedToWindow()
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> onAttachedToWindow");
    if (!this.Q)
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      this.e = localLayoutParams.height;
      this.f = localLayoutParams.width;
      this.Q = true;
    }
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView-> onDetatchedFromWindow");
    this.c.stopAllListeners();
    this.E.clear();
    if ((this.mIsInterstitialAd) && (!this.q)) {
      m();
    }
    super.onDetachedFromWindow();
  }
  
  public void onOrientationEventChange()
  {
    this.G.sendEmptyMessage(1027);
  }
  
  public void openURL(String paramString)
  {
    if (!isViewable())
    {
      raiseError("Cannot open URL.Ad is not viewable yet", "openURL");
      return;
    }
    doHidePlayers();
    Message localMessage = this.G.obtainMessage(1024);
    Bundle localBundle = new Bundle();
    localBundle.putString("expand_url", paramString);
    localMessage.setData(localBundle);
    this.G.sendMessage(localMessage);
  }
  
  public void pageFinishedCallbackForAdCreativeTesting(Message paramMessage)
  {
    this.T = paramMessage;
  }
  
  public void pauseAudio(String paramString)
  {
    Object localObject = c(paramString);
    if (localObject == null) {
      raiseError("Invalid property ID", "pauseAudio");
    }
    do
    {
      return;
      if (((IMAVPlayer)localObject).getState() != IMAVPlayer.playerState.PLAYING)
      {
        raiseError("Invalid player state", "pauseAudio");
        return;
      }
    } while (!((IMAVPlayer)localObject).isPlaying());
    localObject = this.G.obtainMessage(1010);
    Bundle localBundle = new Bundle();
    localBundle.putString("aplayerref", paramString);
    ((Message)localObject).setData(localBundle);
    ((Message)localObject).sendToTarget();
  }
  
  public void pauseVideo(String paramString)
  {
    Message localMessage = this.G.obtainMessage(1011);
    Bundle localBundle = new Bundle();
    localBundle.putString("pid", paramString);
    localMessage.setData(localBundle);
    this.G.sendMessage(localMessage);
  }
  
  public void playAudio(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4)
  {
    synchronized (this.y)
    {
      boolean bool = this.z.get();
      if (bool) {}
      try
      {
        this.y.wait();
        if ((!this.mIsInterstitialAd) && (this.h != ViewState.EXPANDED))
        {
          raiseError("Cannot play audio.Ad is not in an expanded state", "playAudio");
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          IMLog.debug("InMobiAndroidSDK_3.6.1", "mutex failed ", localInterruptedException);
        }
      }
    }
    if (!isViewable())
    {
      raiseError("Cannot play audio.Ad is not viewable yet", "playAudio");
      return;
    }
    ??? = new JSController.PlayerProperties();
    ((JSController.PlayerProperties)???).setProperties(false, paramBoolean1, paramBoolean2, paramBoolean3, paramString2, paramString3, paramString4);
    paramString2 = new Bundle();
    paramString2.putString("expand_url", paramString1);
    paramString2.putParcelable("player_properties", (Parcelable)???);
    paramString1 = this.G.obtainMessage(1007);
    paramString1.setData(paramString2);
    this.G.sendMessage(paramString1);
  }
  
  public void playVideo(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, JSController.Dimensions paramDimensions, String paramString2, String paramString3, String paramString4)
  {
    synchronized (this.y)
    {
      boolean bool = this.z.get();
      if (bool) {}
      try
      {
        this.y.wait();
        if ((!this.mIsInterstitialAd) && (this.h != ViewState.EXPANDED))
        {
          raiseError("Cannot play video.Ad is not in an expanded state", "playVideo");
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          IMLog.debug("InMobiAndroidSDK_3.6.1", "mutex failed ", localInterruptedException);
        }
      }
    }
    if (!isViewable())
    {
      raiseError("Cannot play video.Ad is not viewable yet", "playVideo");
      return;
    }
    if ((!this.A.isEmpty()) && (this.A.size() == 5) && (!this.A.containsKey(paramString4)))
    {
      raiseError("Player Error. Exceeding permissible limit for saved play instances", "playVideo");
      return;
    }
    ??? = this.G.obtainMessage(1006);
    JSController.PlayerProperties localPlayerProperties = new JSController.PlayerProperties();
    localPlayerProperties.setProperties(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramString2, paramString3, paramString4);
    paramString2 = new Bundle();
    paramString2.putString("expand_url", paramString1);
    paramString2.putParcelable("player_properties", localPlayerProperties);
    IMLog.debug("InMobiAndroidSDK_3.6.1", "Before validation dimension: (" + paramDimensions.x + ", " + paramDimensions.y + ", " + paramDimensions.width + ", " + paramDimensions.height + ")");
    a(paramDimensions);
    IMLog.debug("InMobiAndroidSDK_3.6.1", "After validation dimension: (" + paramDimensions.x + ", " + paramDimensions.y + ", " + paramDimensions.width + ", " + paramDimensions.height + ")");
    paramString2.putParcelable("expand_dimensions", paramDimensions);
    ((Message)???).setData(paramString2);
    this.G.sendMessage((Message)???);
  }
  
  public void postInjectJavaScript(String paramString)
  {
    if ((paramString != null) && (this.j))
    {
      if (paramString.length() < 400) {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Injecting JavaScript: " + paramString);
      }
      Message localMessage = this.G.obtainMessage(1025);
      Bundle localBundle = new Bundle();
      localBundle.putString("injectMessage", paramString);
      localMessage.setData(localBundle);
      localMessage.sendToTarget();
    }
  }
  
  public void raiseError(String paramString1, String paramString2)
  {
    Message localMessage = this.G.obtainMessage(1008);
    Bundle localBundle = new Bundle();
    localBundle.putString("message", paramString1);
    localBundle.putString("action", paramString2);
    localMessage.setData(localBundle);
    this.G.sendMessage(localMessage);
  }
  
  public void reinitializeExpandProperties()
  {
    this.c.reinitializeExpandProperties();
  }
  
  public void rejectAction(String paramString) {}
  
  public void releaseAllPlayers()
  {
    if (this.w != null) {
      this.A.put(this.w.getPropertyID(), this.w);
    }
    for (;;)
    {
      try
      {
        localIterator = this.A.entrySet().iterator();
        bool = localIterator.hasNext();
        if (bool) {
          continue;
        }
      }
      catch (Exception localException1)
      {
        Iterator localIterator;
        boolean bool;
        continue;
        ((IMAVPlayer)((Map.Entry)localException1.next()).getValue()).releasePlayer(userInitiatedClose);
        continue;
      }
      this.A.clear();
      this.w = null;
      try
      {
        localIterator = this.B.entrySet().iterator();
        bool = localIterator.hasNext();
        if (bool) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        continue;
      }
      userInitiatedClose = false;
      this.B.clear();
      this.x = null;
      return;
      ((IMAVPlayer)((Map.Entry)localIterator.next()).getValue()).releasePlayer(userInitiatedClose);
    }
  }
  
  public void requestOnInterstitialClosed(Message paramMessage)
  {
    this.U = paramMessage;
  }
  
  public void requestOnInterstitialShown(Message paramMessage)
  {
    this.mMsgOnInterstitialShown = paramMessage;
  }
  
  public void requestOnPageFinishedCallback(Message paramMessage)
  {
    this.S = paramMessage;
  }
  
  public void requestOnSearchAdClicked(Message paramMessage)
  {
    this.X = paramMessage;
  }
  
  public void seekAudio(String paramString, int paramInt)
  {
    paramString = c(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "seekAudio");
      return;
    }
    if (paramString.getState() == IMAVPlayer.playerState.RELEASED)
    {
      raiseError("Invalid player state", "seekAudio");
      return;
    }
    Message localMessage = this.G.obtainMessage(1022);
    Bundle localBundle = new Bundle();
    localBundle.putInt("seekaudio", paramInt);
    localMessage.setData(localBundle);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void seekVideo(String paramString, int paramInt)
  {
    paramString = e(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "seekVideo");
      return;
    }
    if ((paramString.getState() == IMAVPlayer.playerState.RELEASED) || (paramString.getState() == IMAVPlayer.playerState.INIT))
    {
      raiseError("Invalid player state", "seekVideo");
      return;
    }
    Message localMessage = this.G.obtainMessage(1018);
    Bundle localBundle = new Bundle();
    localBundle.putInt("seek", paramInt);
    localMessage.setData(localBundle);
    localMessage.obj = paramString;
    this.G.sendMessage(localMessage);
  }
  
  public void sendasyncPing(String paramString)
  {
    this.c.asyncPing(paramString);
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.V = paramActivity;
  }
  
  public void setAdUnitData(boolean paramBoolean, String paramString)
  {
    this.l = paramBoolean;
    this.m = paramString;
  }
  
  public void setAudioVolume(String paramString, int paramInt)
  {
    if (c(paramString) == null)
    {
      raiseError("Invalid property ID", "setAudioVolume");
      return;
    }
    Message localMessage = this.G.obtainMessage(1021);
    Bundle localBundle = new Bundle();
    localBundle.putInt("vol", paramInt);
    localBundle.putString("aplayerref", paramString);
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  public void setCustomClose(boolean paramBoolean)
  {
    this.r = paramBoolean;
    if (this.mIsInterstitialAd)
    {
      Message localMessage = this.G.obtainMessage(1009);
      this.G.sendMessage(localMessage);
    }
  }
  
  public void setExpandPropertiesForInterstitial(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    setCustomClose(paramBoolean1);
    this.v = paramString;
    this.u = paramBoolean2;
    if (this.q) {
      o();
    }
    if ((isViewable()) && (this.mIsInterstitialAd)) {
      this.G.sendEmptyMessage(1026);
    }
  }
  
  public void setExpandedActivity(Activity paramActivity)
  {
    this.W = paramActivity;
  }
  
  public void setExternalWebViewClient(WebViewClient paramWebViewClient)
  {
    this.aa = paramWebViewClient;
  }
  
  public void setVideoVolume(String paramString, int paramInt)
  {
    paramString = e(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "setVideoVolume");
      return;
    }
    if (paramString.getState() == IMAVPlayer.playerState.RELEASED)
    {
      raiseError("Invalid player state", "setVideoVolume");
      return;
    }
    Message localMessage = this.G.obtainMessage(1017);
    Bundle localBundle = new Bundle();
    localBundle.putInt("volume", paramInt);
    localMessage.setData(localBundle);
    localMessage.obj = paramString;
    this.G.sendMessage(localMessage);
  }
  
  public void show()
  {
    this.G.sendEmptyMessage(1003);
  }
  
  public void showVideo(String paramString)
  {
    Message localMessage = this.G.obtainMessage(1014);
    Bundle localBundle = new Bundle();
    localBundle.putString("pid", paramString);
    localMessage.setData(localBundle);
    this.G.sendMessage(localMessage);
  }
  
  public void unMuteAudio(String paramString)
  {
    Object localObject = c(paramString);
    if (localObject == null)
    {
      raiseError("Invalid property ID", "unmuteAudio");
      return;
    }
    if (((IMAVPlayer)localObject).getState() == IMAVPlayer.playerState.RELEASED)
    {
      raiseError("Invalid player state", "unmuteAudio");
      return;
    }
    localObject = this.G.obtainMessage(1020);
    Bundle localBundle = new Bundle();
    localBundle.putString("aplayerref", paramString);
    ((Message)localObject).setData(localBundle);
    ((Message)localObject).sendToTarget();
  }
  
  public void unMuteVideo(String paramString)
  {
    paramString = e(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "unMuteVideo");
      return;
    }
    if ((paramString.getState() == IMAVPlayer.playerState.RELEASED) || (paramString.getState() == IMAVPlayer.playerState.INIT))
    {
      raiseError("Invalid player state", "unMuteVideo");
      return;
    }
    Message localMessage = this.G.obtainMessage(1016);
    localMessage.obj = paramString;
    this.G.sendMessage(localMessage);
  }
  
  public static abstract interface IMWebViewListener
  {
    public abstract void onDismissAdScreen();
    
    public abstract void onError();
    
    public abstract void onExpand();
    
    public abstract void onExpandClose();
    
    public abstract void onLeaveApplication();
    
    public abstract void onShowAdScreen();
  }
  
  public static enum ViewState
  {
    static
    {
      DEFAULT = new ViewState("DEFAULT", 1);
      RESIZED = new ViewState("RESIZED", 2);
    }
  }
  
  static class a
    extends Handler
  {
    private final WeakReference<IMWebView> a;
    
    public a(IMWebView paramIMWebView)
    {
      this.a = new WeakReference(paramIMWebView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      Object localObject2 = (IMWebView)this.a.get();
      Bundle localBundle;
      if (localObject2 != null)
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "IMWebView->handleMessage: msg: " + paramMessage);
        localBundle = paramMessage.getData();
        switch (paramMessage.what)
        {
        }
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        if (IMWebView.c((IMWebView)localObject2) != null)
        {
          IMWebView.c((IMWebView)localObject2).onExpandClose();
          continue;
          switch (a()[IMWebView.b(localObject2).ordinal()])
          {
          case 3: 
          default: 
            break;
          case 2: 
            if (((IMWebView)localObject2).mIsInterstitialAd) {
              IMWebView.t((IMWebView)localObject2);
            }
            break;
          case 4: 
          case 5: 
            IMWebView.s((IMWebView)localObject2);
            IMWebView.c((IMWebView)localObject2, false);
            break;
          case 6: 
            ((IMWebView)localObject2).injectJavaScript("window.mraidview.fireErrorEvent(\"Current state is not expanded or default\", \"close\")");
            continue;
            ((IMWebView)localObject2).hide();
            continue;
            ((IMWebView)localObject2).setVisibility(4);
            IMWebView.a((IMWebView)localObject2, IMWebView.ViewState.HIDDEN);
            continue;
            ((IMWebView)localObject2).injectJavaScript("window.mraidview.fireChangeEvent({ state: 'default' });");
            ((IMWebView)localObject2).setVisibility(0);
            continue;
            if (IMWebView.b((IMWebView)localObject2) == IMWebView.ViewState.EXPANDING)
            {
              IMWebView.a((IMWebView)localObject2, localBundle);
              continue;
              try
              {
                IMWebView.a((IMWebView)localObject2, localBundle, IMWebView.l((IMWebView)localObject2));
              }
              catch (Exception localException1)
              {
                IMLog.debug("InMobiAndroidSDK_3.6.1", "Play audio failed ", localException1);
              }
              continue;
              try
              {
                IMWebView.b((IMWebView)localObject2, localException1, IMWebView.l((IMWebView)localObject2));
              }
              catch (Exception localException2)
              {
                IMLog.debug("InMobiAndroidSDK_3.6.1", "Play video failed ", localException2);
              }
              continue;
              Object localObject1 = (IMAVPlayer)IMWebView.u((IMWebView)localObject2).get(localException2.getString("aplayerref"));
              if (localObject1 != null)
              {
                ((IMAVPlayer)localObject1).pause();
                continue;
                localObject1 = (IMAVPlayer)IMWebView.u((IMWebView)localObject2).get(((Bundle)localObject1).getString("aplayerref"));
                if (localObject1 != null)
                {
                  ((IMAVPlayer)localObject1).mute();
                  continue;
                  localObject1 = (IMAVPlayer)IMWebView.u((IMWebView)localObject2).get(((Bundle)localObject1).getString("aplayerref"));
                  if (localObject1 != null)
                  {
                    ((IMAVPlayer)localObject1).unMute();
                    continue;
                    localObject2 = (IMAVPlayer)IMWebView.u((IMWebView)localObject2).get(((Bundle)localObject1).getString("aplayerref"));
                    if (localObject2 != null)
                    {
                      ((IMAVPlayer)localObject2).setVolume(((Bundle)localObject1).getInt("vol"));
                      continue;
                      ((IMAVPlayer)paramMessage.obj).seekPlayer(((Bundle)localObject1).getInt("seekaudio") * 1000);
                      continue;
                      localObject1 = IMWebView.a((IMWebView)localObject2, ((Bundle)localObject1).getString("pid"));
                      if (localObject1 == null) {}
                      for (localObject1 = "window.mraidview.fireErrorEvent(\"Invalid property ID\", \"pauseVideo\")";; localObject1 = "window.mraidview.fireErrorEvent(\"Invalid player state\", \"pauseVideo\")")
                      {
                        ((IMWebView)localObject2).injectJavaScript((String)localObject1);
                        break;
                        if (((IMAVPlayer)localObject1).getState() == IMAVPlayer.playerState.PLAYING) {
                          break label567;
                        }
                      }
                      label567:
                      ((IMAVPlayer)localObject1).pause();
                      return;
                      ((IMAVPlayer)paramMessage.obj).releasePlayer(false);
                      continue;
                      localObject1 = ((Bundle)localObject1).getString("pid");
                      Object localObject3 = IMWebView.a((IMWebView)localObject2, (String)localObject1);
                      if (localObject3 == null) {}
                      for (localObject1 = "window.mraidview.fireErrorEvent(\"Invalid property ID\", \"hideVideo\")";; localObject1 = "window.mraidview.fireErrorEvent(\"Invalid player state\", \"hideVideo\")")
                      {
                        ((IMWebView)localObject2).injectJavaScript((String)localObject1);
                        break;
                        if (((IMAVPlayer)localObject3).getState() != IMAVPlayer.playerState.RELEASED) {
                          break label633;
                        }
                      }
                      label633:
                      IMWebView.v((IMWebView)localObject2).put(localObject1, localObject3);
                      ((IMAVPlayer)localObject3).hide();
                      ((IMAVPlayer)localObject3).releasePlayer(false);
                      return;
                      localObject3 = ((Bundle)localObject1).getString("pid");
                      localObject1 = IMWebView.a((IMWebView)localObject2, (String)localObject3);
                      if (localObject1 == null) {
                        localObject1 = "window.mraidview.fireErrorEvent(\"Invalid property ID\", \"showVideo\")";
                      }
                      for (;;)
                      {
                        ((IMWebView)localObject2).injectJavaScript((String)localObject1);
                        break;
                        if (((IMAVPlayer)localObject1).getState() != IMAVPlayer.playerState.RELEASED)
                        {
                          localObject1 = "window.mraidview.fireErrorEvent(\"Invalid player state\", \"showVideo\")";
                        }
                        else
                        {
                          if ((IMWebView.w((IMWebView)localObject2) == null) || (IMWebView.w((IMWebView)localObject2).getPropertyID().equalsIgnoreCase((String)localObject3))) {
                            break label731;
                          }
                          localObject1 = "window.mraidview.fireErrorEvent(\"Show failed. There is already a video playing\", \"showVideo\")";
                        }
                      }
                      label731:
                      IMWebView.v((IMWebView)localObject2).remove(localObject3);
                      paramMessage = new Bundle();
                      paramMessage.putString("expand_url", ((IMAVPlayer)localObject1).getMediaURL());
                      paramMessage.putParcelable("expand_dimensions", ((IMAVPlayer)localObject1).getPlayDimensions());
                      paramMessage.putParcelable("player_properties", ((IMAVPlayer)localObject1).getProperties());
                      IMWebView.b((IMWebView)localObject2, paramMessage, IMWebView.l((IMWebView)localObject2));
                      return;
                      ((IMAVPlayer)paramMessage.obj).mute();
                      continue;
                      ((IMAVPlayer)paramMessage.obj).unMute();
                      continue;
                      ((IMAVPlayer)paramMessage.obj).seekPlayer(((Bundle)localObject1).getInt("seek") * 1000);
                      continue;
                      ((IMAVPlayer)paramMessage.obj).setVolume(((Bundle)localObject1).getInt("volume"));
                      continue;
                      localObject3 = ((Bundle)localObject1).getString("message");
                      localObject1 = ((Bundle)localObject1).getString("action");
                      ((IMWebView)localObject2).injectJavaScript("window.mraidview.fireErrorEvent(\"" + (String)localObject3 + "\", \"" + (String)localObject1 + "\")");
                      continue;
                      IMWebView.x((IMWebView)localObject2);
                      continue;
                      IMWebView.y((IMWebView)localObject2);
                      continue;
                      IMWebView.b((IMWebView)localObject2, ((Bundle)localObject1).getString("expand_url"));
                      continue;
                      localObject1 = ((Bundle)localObject1).getString("injectMessage");
                      if (localObject1 != null)
                      {
                        ((IMWebView)localObject2).loadUrl("javascript:" + (String)localObject1);
                        continue;
                        IMWebView.z((IMWebView)localObject2);
                        continue;
                        IMWebView.A((IMWebView)localObject2);
                        continue;
                        if (IMWebView.c((IMWebView)localObject2) != null) {
                          IMWebView.c((IMWebView)localObject2).onDismissAdScreen();
                        }
                      }
                    }
                  }
                }
              }
            }
            break;
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/ai/container/IMWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
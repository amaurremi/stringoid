package com.adfonic.android.ormma.js;

import com.adfonic.android.ormma.ExpandProperties;
import com.adfonic.android.ormma.OrmmaBridge;
import com.adfonic.android.ormma.OrmmaView;
import java.util.HashMap;
import java.util.Map;

public class JsOrmmaBridge
  implements OrmmaBridge
{
  private static final String CURRENT_CERTIFIED_VERSION = "1.1.0";
  private static Map<String, Boolean> SUPPORTED_METHODS = new HashMap();
  private StateMachine stateMachine;
  private OrmmaView view;
  
  static
  {
    SUPPORTED_METHODS.put("screen", Boolean.valueOf(true));
    SUPPORTED_METHODS.put("orientation", Boolean.valueOf(false));
    SUPPORTED_METHODS.put("heading", Boolean.valueOf(false));
    SUPPORTED_METHODS.put("location", Boolean.valueOf(false));
    SUPPORTED_METHODS.put("shake", Boolean.valueOf(false));
    SUPPORTED_METHODS.put("tilt", Boolean.valueOf(false));
    SUPPORTED_METHODS.put("network", Boolean.valueOf(false));
    SUPPORTED_METHODS.put("sms", Boolean.valueOf(false));
    SUPPORTED_METHODS.put("phone", Boolean.valueOf(false));
    SUPPORTED_METHODS.put("email", Boolean.valueOf(false));
    SUPPORTED_METHODS.put("calendar", Boolean.valueOf(false));
    SUPPORTED_METHODS.put("camera", Boolean.valueOf(false));
    SUPPORTED_METHODS.put("level-1", Boolean.valueOf(true));
    SUPPORTED_METHODS.put("level-2", Boolean.valueOf(false));
  }
  
  public JsOrmmaBridge(OrmmaView paramOrmmaView)
  {
    this.view = paramOrmmaView;
    injectJsFiles();
    this.stateMachine = new StateMachine();
    this.stateMachine.setStateChangeListener(new StateMachine.StateChangeListener()
    {
      public void onStateChanged(StateMachine.State paramAnonymousState1, StateMachine.State paramAnonymousState2)
      {
        JsOrmmaBridge.this.fireStateChangeEvent(paramAnonymousState2);
        if ((paramAnonymousState1.isExpanded()) && (paramAnonymousState2.isDefault())) {
          JsOrmmaBridge.this.view.showDefaultSize();
        }
      }
    });
  }
  
  private void fireSizeChangeEvent()
  {
    int i = this.view.getHeight();
    fireSizeChangeEvent(this.view.getWidth(), i);
  }
  
  private void fireSizeChangeEvent(int paramInt1, int paramInt2)
  {
    this.view.injectJavaScript("window.ormma.fireSizeChangeEvent('" + paramInt1 + "','" + paramInt2 + "')");
  }
  
  private void fireStateChangeEvent(StateMachine.State paramState)
  {
    this.view.injectJavaScript("window.ormma.fireStateChangeEvent('" + paramState.getJavascriptName() + "')");
  }
  
  private void injectJsFiles()
  {
    this.view.injectJavaScript("(function() {var ormma = window.ormma = {};var listeners = {};ormma.fireErrorEvent = function(message, action) {  var handlers = listeners['error'];  if (handlers != null) {    for ( var i = 0; i < handlers.length; i++) {      handlers[i](message, action);    }  }  return;};ormma.fireKeyboardChangeEvent = function(open) {\tvar handlers = listeners['keyboardChange'];\tif (handlers != null) {\t\tfor ( var i = 0; i < handlers.length; i++) {\t\t\thandlers[i](open);\t\t}\t}\treturn;};ormma.fireReadyEvent = function() {  var handlers = listeners['ready'];  if (handlers != null) {    for ( var i = 0; i < handlers.length; i++) {      handlers[i]();    }  }  return;};ormma.fireStateChangeEvent = function(state) {  var handlers = listeners['stateChange'];  if (handlers != null) {    for ( var i = 0; i < handlers.length; i++) {      handlers[i](state);    }  }  return;};ormma.fireSizeChangeEvent = function(width, height) {  var handlers = listeners['sizeChange'];  if (handlers != null) {    for ( var i = 0; i < handlers.length; i++) {      handlers[i](width, height);    }  }  return;};ormma.fireViewableChangeEvent = function(onscreen) {  var handlers = listeners['viewableChange'];  if (handlers != null) {    for ( var i = 0; i < handlers.length; i++) {      handlers[i](onscreen);    }  }  return;};ormma.addEventListener = function(event, listener) {  var handlers = listeners[event];  if (handlers == null) {    listeners[event] = [];    handlers = listeners[event];  }  for ( var handler in handlers) {    if (listener == handler) {      return;    }  }  handlers.push(listener);};ormma.removeEventListener = function(event, listener) {  var handlers = listeners[event];  if (handlers != null) {    handlers.remove(listener);  }};ormma.removeEventListener = function(event, listener) {  var handlers = listeners[event];  if (handlers == null) {    return;  }  if(listener == null) {    handlers.splice(0, handlers.length);    return;  }  var index = 0;  while (index < handlers.length) {    if(listener == handlers[index]) {      handlers.splice(index, 1);    }    index++;  }};ormma.close = function() {  window.AdfonicOrmmaBridge.close();};ormma.getState = function() {  return window.AdfonicOrmmaBridge.getState();};ormma.supports = function(feature) {  return window.AdfonicOrmmaBridge.supports(feature);};ormma.getVersion = function() {  return window.AdfonicOrmmaBridge.getVersion();};ormma.isViewable = function() {  return window.AdfonicOrmmaBridge.isViewable();};ormma.hide = function() {  window.AdfonicOrmmaBridge.hide();};ormma.open = function(url) {  window.AdfonicOrmmaBridge.open(url);};ormma.getPlacementType = function() {  return window.AdfonicOrmmaBridge.getPlacementType();};ormma.getSize = function() {  return window.AdfonicOrmmaBridge.getSize();};ormma.getDefaultPosition = function() {  return window.AdfonicOrmmaBridge.getDefaultPosition();};ormma.getMaxSize = function() {  return window.AdfonicOrmmaBridge.getMaxSize();};ormma.useCustomClose = function(useCustomClose) {  window.AdfonicOrmmaBridge.useCustomClose(useCustomClose);};ormma.ready = function() {  window.AdfonicOrmmaBridge.ready();};ormma.resize = function(width, height) {  window.AdfonicOrmmaBridge.resize(width, height);};ormma.expand = function(url) {  window.AdfonicOrmmaBridge.expand(url);};ormma.show = function() {  window.AdfonicOrmmaBridge.show();};ormma.getExpandProperties = function() {  return window.AdfonicOrmmaBridge.getExpandProperties();};ormma.setExpandProperties = function(json) {  window.AdfonicOrmmaBridge.setExpandProperties(json);};ormma.ORMMAReady = function() {};ormma.getViewable = function() {};})();");
    this.view.injectJavaScript("(function() {var mraid = window.mraid = {};mraid.addEventListener = function(event, listener) {\tormma.addEventListener(event, listener);};mraid.removeEventListener = function(event, listener) {\tormma.removeEventListener(event, listener);};mraid.close = function() {\tormma.close();};mraid.getState = function() {\treturn ormma.getState();};mraid.getVersion = function() {\treturn ormma.getVersion();};mraid.isViewable = function() {\treturn ormma.isViewable();};mraid.open = function(url) {\tormma.open(url);};mraid.expand = function(url) {\tormma.expand(url);};mraid.getPlacementType = function() {\treturn ormma.getPlacementType();};mraid.useCustomClose = function() {\tormma.useCustomClose();};mraid.getExpandProperties = function() {\treturn ormma.getExpandProperties();};mraid.setExpandProperties = function(json) {\treturn ormma.getExpandProperties(json);};})();");
  }
  
  public void close()
  {
    this.stateMachine.close();
    fireSizeChangeEvent();
  }
  
  public void error(String paramString1, String paramString2)
  {
    paramString1 = "window.ormma.fireErrorEvent('" + paramString1 + "', '" + paramString2 + "')";
    this.view.injectJavaScript(paramString1);
  }
  
  public void expand(String paramString)
  {
    this.view.expand(paramString);
    this.stateMachine.expand();
    fireSizeChangeEvent();
  }
  
  public String getDefaultPosition()
  {
    return "{" + this.view.getDefaultX() + "," + this.view.getDefaultY() + "," + this.view.getDefaultWidth() + "," + this.view.getDefaultHeight() + "}";
  }
  
  public String getExpandProperties()
  {
    return this.view.getExpandProperties().toJson();
  }
  
  public String getMaxSize()
  {
    return "{" + this.view.getMaxWidth() + "," + this.view.getMaxHeight() + "}";
  }
  
  public String getPlacementType()
  {
    return this.view.getPlacementType();
  }
  
  public String getSize()
  {
    return "{" + this.view.getWidth() + "," + this.view.getHeight() + "}";
  }
  
  public String getState()
  {
    return this.stateMachine.getState().getJavascriptName();
  }
  
  public String getVersion()
  {
    return "1.1.0";
  }
  
  public void hide()
  {
    close();
  }
  
  public boolean isViewable()
  {
    return this.view.isViewable();
  }
  
  public void onKeyboardChange(boolean paramBoolean)
  {
    String str = "window.ormma.fireKeyboardChangeEvent('" + paramBoolean + "')";
    this.view.injectJavaScript(str);
  }
  
  public void onSizeChange(int paramInt1, int paramInt2)
  {
    fireSizeChangeEvent();
  }
  
  public void open(String paramString)
  {
    this.view.open(paramString);
  }
  
  public void ready()
  {
    this.stateMachine.ready();
    this.view.injectJavaScript("window.ormma.fireReadyEvent()");
  }
  
  public void reset()
  {
    if ((this.stateMachine.getState().isDefault()) || (this.stateMachine.getState().isLoading())) {
      return;
    }
    close();
  }
  
  public void resize(int paramInt1, int paramInt2)
  {
    this.stateMachine.resize();
    fireSizeChangeEvent();
  }
  
  public void setExpandProperties(String paramString)
  {
    this.view.setExpandProperties(new ExpandProperties(paramString));
  }
  
  public void show()
  {
    this.stateMachine.show();
    fireSizeChangeEvent();
  }
  
  public boolean supports(String paramString)
  {
    if (!SUPPORTED_METHODS.containsKey(paramString)) {
      return false;
    }
    return ((Boolean)SUPPORTED_METHODS.get(paramString)).booleanValue();
  }
  
  public void useCustomClose(boolean paramBoolean)
  {
    ExpandProperties localExpandProperties = this.view.getExpandProperties();
    localExpandProperties.setUseCustomClose(paramBoolean);
    this.view.setExpandProperties(localExpandProperties);
  }
  
  public void viewableChange(boolean paramBoolean)
  {
    String str = "window.ormma.fireViewableChangeEvent('" + paramBoolean + "')";
    this.view.injectJavaScript(str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/ormma/js/JsOrmmaBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
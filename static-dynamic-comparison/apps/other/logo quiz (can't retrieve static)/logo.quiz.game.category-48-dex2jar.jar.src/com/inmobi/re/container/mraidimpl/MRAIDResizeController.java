package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.CustomView;
import com.inmobi.re.container.CustomView.SwitchIconType;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.IMWebView.ViewState;
import com.inmobi.re.container.WrapperFunctions;
import com.inmobi.re.controller.JSController.ResizeProperties;
import java.util.concurrent.atomic.AtomicBoolean;

public class MRAIDResizeController
{
  protected static final int PLACEHOLDER_ID = 437;
  protected static final int RELATIVELAYOUT_ID = 438;
  private IMWebView a;
  private ResizeDimensions b = null;
  public JSController.ResizeProperties resizeProperties;
  
  public MRAIDResizeController(IMWebView paramIMWebView, Activity paramActivity)
  {
    this.a = paramIMWebView;
  }
  
  private FrameLayout a(JSController.ResizeProperties paramResizeProperties)
  {
    FrameLayout localFrameLayout1 = (FrameLayout)((ViewGroup)this.a.getOriginalParent()).getRootView().findViewById(16908290);
    a();
    FrameLayout localFrameLayout2 = new FrameLayout(this.a.getContext());
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
    localFrameLayout2.setId(435);
    FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(paramResizeProperties.width, paramResizeProperties.height);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.a.getContext());
    localRelativeLayout.setId(438);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramResizeProperties.width, paramResizeProperties.height);
    localRelativeLayout.addView(this.a, localLayoutParams);
    a(localRelativeLayout, paramResizeProperties.customClosePosition);
    localFrameLayout2.addView(localRelativeLayout, localLayoutParams2);
    a(localFrameLayout1, localFrameLayout2, this.a, paramResizeProperties);
    localFrameLayout1.addView(localFrameLayout2, localLayoutParams1);
    this.a.setFocusable(true);
    this.a.setFocusableInTouchMode(true);
    this.a.requestFocus();
    return localFrameLayout2;
  }
  
  private RelativeLayout.LayoutParams a(String paramString)
  {
    paramString = b(paramString);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.a.getDensity() * 50.0F), (int)(this.a.getDensity() * 50.0F));
    if ((paramString.equals("top-right")) || (paramString.equals("bottom-right"))) {
      localLayoutParams.addRule(11);
    }
    if ((paramString.equals("bottom-right")) || (paramString.equals("bottom-left")) || (paramString.equals("bottom-center")))
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(4);
    }
    if ((paramString.equals("bottom-center")) || (paramString.equals("top-center")) || (paramString.equals("center"))) {
      localLayoutParams.addRule(13);
    }
    if (paramString.equals("top-center")) {
      localLayoutParams.addRule(10);
    }
    return localLayoutParams;
  }
  
  private void a()
  {
    try
    {
      FrameLayout localFrameLayout = new FrameLayout(this.a.getContext());
      localFrameLayout.setId(437);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(this.a.getWidth(), this.a.getHeight());
      ((ViewGroup)this.a.getOriginalParent()).addView(localFrameLayout, this.a.getOriginalIndex(), localLayoutParams);
      ((ViewGroup)this.a.getParent()).removeView(this.a);
      return;
    }
    catch (Exception localException)
    {
      Log.debug("IMRE_3.7.1", "Exception in replaceByPlaceHolder ", localException);
    }
  }
  
  private void a(ViewGroup paramViewGroup, String paramString)
  {
    paramString = a(paramString);
    CustomView localCustomView = new CustomView(this.a.getContext(), this.a.getDensity(), CustomView.SwitchIconType.CLOSE_TRANSPARENT);
    paramViewGroup.addView(localCustomView, paramString);
    localCustomView.setOnClickListener(new b());
  }
  
  private void a(FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2, IMWebView paramIMWebView, JSController.ResizeProperties paramResizeProperties)
  {
    paramFrameLayout2 = new int[2];
    int[] arrayOfInt = new int[2];
    ((View)paramIMWebView.getOriginalParent()).getLocationOnScreen(paramFrameLayout2);
    paramFrameLayout1.getLocationOnScreen(arrayOfInt);
    paramFrameLayout2[1] -= arrayOfInt[1];
    paramFrameLayout2[0] -= arrayOfInt[0];
    paramFrameLayout2[0] += paramResizeProperties.offsetX;
    paramFrameLayout2[1] += paramResizeProperties.offsetY;
    if (!paramResizeProperties.allowOffscreen)
    {
      if (paramResizeProperties.width > paramFrameLayout1.getWidth() - paramFrameLayout2[0]) {
        paramFrameLayout2[0] = (paramFrameLayout1.getWidth() - paramResizeProperties.width);
      }
      if (paramResizeProperties.height > paramFrameLayout1.getHeight() - paramFrameLayout2[1]) {
        paramFrameLayout2[1] = (paramFrameLayout1.getHeight() - paramResizeProperties.height);
      }
      if (paramFrameLayout2[0] < 0) {
        paramFrameLayout2[0] = 0;
      }
      if (paramFrameLayout2[1] < 0) {
        paramFrameLayout2[1] = 0;
      }
    }
    this.b = new ResizeDimensions(paramFrameLayout2[0], paramFrameLayout2[1], paramResizeProperties.width, paramResizeProperties.height);
    paramFrameLayout1 = new FrameLayout.LayoutParams(paramResizeProperties.width, paramResizeProperties.height);
    paramFrameLayout1.leftMargin = paramFrameLayout2[0];
    paramFrameLayout1.topMargin = paramFrameLayout2[1];
    paramFrameLayout1.gravity = 3;
    ((View)paramIMWebView.getParent()).setLayoutParams(paramFrameLayout1);
  }
  
  private String b(String paramString)
  {
    String str = paramString;
    if (!paramString.equals("top-left"))
    {
      str = paramString;
      if (!paramString.equals("top-right"))
      {
        str = paramString;
        if (!paramString.equals("bottom-left"))
        {
          str = paramString;
          if (!paramString.equals("bottom-right"))
          {
            str = paramString;
            if (!paramString.equals("top-center"))
            {
              str = paramString;
              if (!paramString.equals("bottom-center"))
              {
                str = paramString;
                if (!paramString.equals("center")) {
                  str = "top-right";
                }
              }
            }
          }
        }
      }
    }
    return str;
  }
  
  private void b()
  {
    ((ViewGroup)this.a.getParent().getParent().getParent()).removeView((View)this.a.getParent().getParent());
    ((ViewGroup)this.a.getParent()).removeView(this.a);
    View localView = ((View)this.a.getOriginalParent()).findViewById(437);
    ((ViewGroup)localView.getParent()).removeView(localView);
    ((ViewGroup)this.a.getOriginalParent()).addView(this.a, this.a.getOriginalIndex());
    this.a.resetLayout();
  }
  
  public void closeResized()
  {
    if (this.a.getViewState().compareTo(IMWebView.ViewState.DEFAULT) == 0) {
      return;
    }
    synchronized (this.a.mutex)
    {
      this.a.isMutexAquired.set(false);
      this.a.mutex.notifyAll();
      this.a.doNotFireVisibilityChanged.set(true);
      b();
      this.a.closeResized();
      this.a.setVisibility(0);
      this.a.setState(IMWebView.ViewState.DEFAULT);
      this.a.doNotFireVisibilityChanged.set(false);
      return;
    }
  }
  
  /* Error */
  public void doResize(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   4: getfield 285	com/inmobi/re/container/IMWebView:doNotFireVisibilityChanged	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   7: iconst_1
    //   8: invokevirtual 279	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   11: aload_0
    //   12: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   15: invokevirtual 38	com/inmobi/re/container/IMWebView:getOriginalParent	()Landroid/view/ViewParent;
    //   18: ifnonnull +10 -> 28
    //   21: aload_0
    //   22: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   25: invokevirtual 301	com/inmobi/re/container/IMWebView:saveOriginalViewParent	()V
    //   28: aload_0
    //   29: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   32: invokevirtual 169	com/inmobi/re/container/IMWebView:getParent	()Landroid/view/ViewParent;
    //   35: invokeinterface 244 1 0
    //   40: checkcast 53	android/widget/FrameLayout
    //   43: invokevirtual 304	android/widget/FrameLayout:getId	()I
    //   46: sipush 435
    //   49: if_icmpne +167 -> 216
    //   52: aload_0
    //   53: aload_0
    //   54: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   57: invokevirtual 169	com/inmobi/re/container/IMWebView:getParent	()Landroid/view/ViewParent;
    //   60: invokeinterface 244 1 0
    //   65: invokeinterface 244 1 0
    //   70: checkcast 53	android/widget/FrameLayout
    //   73: aload_0
    //   74: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   77: invokevirtual 169	com/inmobi/re/container/IMWebView:getParent	()Landroid/view/ViewParent;
    //   80: invokeinterface 244 1 0
    //   85: checkcast 53	android/widget/FrameLayout
    //   88: aload_0
    //   89: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   92: aload_0
    //   93: getfield 306	com/inmobi/re/container/mraidimpl/MRAIDResizeController:resizeProperties	Lcom/inmobi/re/controller/JSController$ResizeProperties;
    //   96: invokespecial 107	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	(Landroid/widget/FrameLayout;Landroid/widget/FrameLayout;Lcom/inmobi/re/container/IMWebView;Lcom/inmobi/re/controller/JSController$ResizeProperties;)V
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 306	com/inmobi/re/container/mraidimpl/MRAIDResizeController:resizeProperties	Lcom/inmobi/re/controller/JSController$ResizeProperties;
    //   104: getfield 100	com/inmobi/re/controller/JSController$ResizeProperties:customClosePosition	Ljava/lang/String;
    //   107: invokespecial 185	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	(Ljava/lang/String;)Landroid/widget/RelativeLayout$LayoutParams;
    //   110: astore_2
    //   111: new 91	android/widget/RelativeLayout$LayoutParams
    //   114: dup
    //   115: aload_0
    //   116: getfield 306	com/inmobi/re/container/mraidimpl/MRAIDResizeController:resizeProperties	Lcom/inmobi/re/controller/JSController$ResizeProperties;
    //   119: getfield 82	com/inmobi/re/controller/JSController$ResizeProperties:width	I
    //   122: aload_0
    //   123: getfield 306	com/inmobi/re/container/mraidimpl/MRAIDResizeController:resizeProperties	Lcom/inmobi/re/controller/JSController$ResizeProperties;
    //   126: getfield 85	com/inmobi/re/controller/JSController$ResizeProperties:height	I
    //   129: invokespecial 92	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   132: astore_3
    //   133: aload_0
    //   134: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   137: aload_3
    //   138: invokevirtual 307	com/inmobi/re/container/IMWebView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   141: aload_0
    //   142: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   145: invokevirtual 169	com/inmobi/re/container/IMWebView:getParent	()Landroid/view/ViewParent;
    //   148: checkcast 40	android/view/ViewGroup
    //   151: iconst_1
    //   152: invokevirtual 310	android/view/ViewGroup:getChildAt	(I)Landroid/view/View;
    //   155: aload_2
    //   156: invokevirtual 238	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   159: aload_1
    //   160: ifnull +13 -> 173
    //   163: aload_0
    //   164: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   167: getstatic 313	com/inmobi/re/container/IMWebView$ViewState:RESIZED	Lcom/inmobi/re/container/IMWebView$ViewState;
    //   170: invokevirtual 296	com/inmobi/re/container/IMWebView:setState	(Lcom/inmobi/re/container/IMWebView$ViewState;)V
    //   173: aload_0
    //   174: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   177: invokevirtual 316	com/inmobi/re/container/IMWebView:requestLayout	()V
    //   180: aload_0
    //   181: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   184: invokevirtual 319	com/inmobi/re/container/IMWebView:invalidate	()V
    //   187: aload_0
    //   188: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   191: new 10	com/inmobi/re/container/mraidimpl/MRAIDResizeController$c
    //   194: dup
    //   195: aload_0
    //   196: invokespecial 320	com/inmobi/re/container/mraidimpl/MRAIDResizeController$c:<init>	(Lcom/inmobi/re/container/mraidimpl/MRAIDResizeController;)V
    //   199: invokevirtual 324	com/inmobi/re/container/IMWebView:post	(Ljava/lang/Runnable;)Z
    //   202: pop
    //   203: aload_0
    //   204: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   207: getfield 285	com/inmobi/re/container/IMWebView:doNotFireVisibilityChanged	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   210: iconst_0
    //   211: invokevirtual 279	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   214: return
    //   215: astore_2
    //   216: aload_0
    //   217: aload_0
    //   218: getfield 306	com/inmobi/re/container/mraidimpl/MRAIDResizeController:resizeProperties	Lcom/inmobi/re/controller/JSController$ResizeProperties;
    //   221: invokespecial 326	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	(Lcom/inmobi/re/controller/JSController$ResizeProperties;)Landroid/widget/FrameLayout;
    //   224: iconst_0
    //   225: invokevirtual 329	android/widget/FrameLayout:setBackgroundColor	(I)V
    //   228: aload_0
    //   229: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   232: getfield 333	com/inmobi/re/container/IMWebView:mAudioVideoController	Lcom/inmobi/re/container/mraidimpl/MRAIDAudioVideoController;
    //   235: aload_0
    //   236: getfield 306	com/inmobi/re/container/mraidimpl/MRAIDResizeController:resizeProperties	Lcom/inmobi/re/controller/JSController$ResizeProperties;
    //   239: getfield 82	com/inmobi/re/controller/JSController$ResizeProperties:width	I
    //   242: putfield 338	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoValidateWidth	I
    //   245: aload_1
    //   246: ifnull +13 -> 259
    //   249: aload_0
    //   250: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   253: getstatic 313	com/inmobi/re/container/IMWebView$ViewState:RESIZED	Lcom/inmobi/re/container/IMWebView$ViewState;
    //   256: invokevirtual 296	com/inmobi/re/container/IMWebView:setState	(Lcom/inmobi/re/container/IMWebView$ViewState;)V
    //   259: aload_0
    //   260: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   263: getfield 270	com/inmobi/re/container/IMWebView:mutex	Ljava/lang/Object;
    //   266: astore_1
    //   267: aload_1
    //   268: monitorenter
    //   269: aload_0
    //   270: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   273: getfield 274	com/inmobi/re/container/IMWebView:isMutexAquired	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   276: iconst_0
    //   277: invokevirtual 279	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   280: aload_0
    //   281: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   284: getfield 270	com/inmobi/re/container/IMWebView:mutex	Ljava/lang/Object;
    //   287: invokevirtual 282	java/lang/Object:notifyAll	()V
    //   290: aload_1
    //   291: monitorexit
    //   292: aload_0
    //   293: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   296: invokevirtual 316	com/inmobi/re/container/IMWebView:requestLayout	()V
    //   299: aload_0
    //   300: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   303: invokevirtual 319	com/inmobi/re/container/IMWebView:invalidate	()V
    //   306: aload_0
    //   307: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   310: new 6	com/inmobi/re/container/mraidimpl/MRAIDResizeController$a
    //   313: dup
    //   314: aload_0
    //   315: invokespecial 339	com/inmobi/re/container/mraidimpl/MRAIDResizeController$a:<init>	(Lcom/inmobi/re/container/mraidimpl/MRAIDResizeController;)V
    //   318: invokevirtual 324	com/inmobi/re/container/IMWebView:post	(Ljava/lang/Runnable;)Z
    //   321: pop
    //   322: aload_0
    //   323: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   326: getfield 285	com/inmobi/re/container/IMWebView:doNotFireVisibilityChanged	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   329: iconst_0
    //   330: invokevirtual 279	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   333: return
    //   334: astore_2
    //   335: aload_1
    //   336: monitorexit
    //   337: aload_2
    //   338: athrow
    //   339: astore_1
    //   340: ldc -81
    //   342: ldc_w 341
    //   345: aload_1
    //   346: invokestatic 183	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   349: aload_0
    //   350: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   353: getstatic 262	com/inmobi/re/container/IMWebView$ViewState:DEFAULT	Lcom/inmobi/re/container/IMWebView$ViewState;
    //   356: invokevirtual 296	com/inmobi/re/container/IMWebView:setState	(Lcom/inmobi/re/container/IMWebView$ViewState;)V
    //   359: aload_0
    //   360: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   363: getfield 270	com/inmobi/re/container/IMWebView:mutex	Ljava/lang/Object;
    //   366: astore_1
    //   367: aload_1
    //   368: monitorenter
    //   369: aload_0
    //   370: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   373: getfield 274	com/inmobi/re/container/IMWebView:isMutexAquired	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   376: iconst_0
    //   377: invokevirtual 279	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   380: aload_0
    //   381: getfield 30	com/inmobi/re/container/mraidimpl/MRAIDResizeController:a	Lcom/inmobi/re/container/IMWebView;
    //   384: getfield 270	com/inmobi/re/container/IMWebView:mutex	Ljava/lang/Object;
    //   387: invokevirtual 282	java/lang/Object:notifyAll	()V
    //   390: aload_1
    //   391: monitorexit
    //   392: goto -70 -> 322
    //   395: astore_2
    //   396: aload_1
    //   397: monitorexit
    //   398: aload_2
    //   399: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	MRAIDResizeController
    //   110	46	2	localLayoutParams1	RelativeLayout.LayoutParams
    //   215	1	2	localException	Exception
    //   334	4	2	localObject1	Object
    //   395	4	2	localObject2	Object
    //   132	6	3	localLayoutParams2	RelativeLayout.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   11	28	215	java/lang/Exception
    //   28	159	215	java/lang/Exception
    //   163	173	215	java/lang/Exception
    //   173	214	215	java/lang/Exception
    //   269	292	334	finally
    //   335	337	334	finally
    //   216	245	339	java/lang/Exception
    //   249	259	339	java/lang/Exception
    //   259	269	339	java/lang/Exception
    //   292	322	339	java/lang/Exception
    //   337	339	339	java/lang/Exception
    //   369	392	395	finally
    //   396	398	395	finally
  }
  
  public void onOrientationChange()
  {
    if ((this.a.getStateVariable() == IMWebView.ViewState.RESIZED) && (!this.resizeProperties.allowOffscreen)) {
      doResize(null);
    }
  }
  
  public void reset()
  {
    this.resizeProperties = new JSController.ResizeProperties();
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      if (MRAIDResizeController.a(MRAIDResizeController.this).mListener != null) {
        MRAIDResizeController.a(MRAIDResizeController.this).mListener.onResize(MRAIDResizeController.b(MRAIDResizeController.this));
      }
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      IMWebView.userInitiatedClose = true;
      MRAIDResizeController.a(MRAIDResizeController.this).close();
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      if (MRAIDResizeController.a(MRAIDResizeController.this).mListener != null) {
        MRAIDResizeController.a(MRAIDResizeController.this).mListener.onResize(MRAIDResizeController.b(MRAIDResizeController.this));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDResizeController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
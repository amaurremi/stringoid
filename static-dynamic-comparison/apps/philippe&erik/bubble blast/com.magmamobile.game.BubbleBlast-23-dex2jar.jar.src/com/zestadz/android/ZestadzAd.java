package com.zestadz.android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class ZestadzAd
  extends RelativeLayout
{
  private static String mAdText;
  private static Timer t;
  private final String MY_DEBUG_TAG = "ZestadzAD";
  private Handler handler;
  private boolean mAdVisibility;
  private String userAgent;
  
  public ZestadzAd(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ZestadzAd(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ZestadzAd(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setAdVisibility(true);
    if (CheckAdVisibility())
    {
      displayAd(paramContext);
      return;
    }
    if (t != null) {
      t.cancel();
    }
    paramAttributeSet = new RelativeLayout(paramContext);
    setAdText("AD cannot be Displayed");
    paramContext = new TextView(paramContext);
    paramContext.setText(getAdText());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    paramContext.setLayoutParams(localLayoutParams);
    paramAttributeSet.addView(paramContext);
  }
  
  public static String getAdText()
  {
    return mAdText;
  }
  
  public static void stopAdpull()
  {
    t.cancel();
  }
  
  public boolean CheckAdVisibility()
  {
    return this.mAdVisibility;
  }
  
  Drawable ImageOperations(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = Drawable.createFromStream((InputStream)fetch(paramString1), "src");
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      Log.e("IMAGE OPERATION", paramContext.getMessage());
      paramContext.printStackTrace();
      return null;
    }
    catch (IOException paramContext)
    {
      Log.e("IMAGE OPERATION", paramContext.getMessage());
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public void displayAd(final Context paramContext)
  {
    final RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    this.handler = new Handler();
    try
    {
      this.userAgent = AdManager.getUserAgent(paramContext);
      final Object localObject = AdManager.getAdclientId(paramContext);
      localObject = new URL("http://a.zestadz.com/multiple_ad?ua=" + this.userAgent + "&ip=&cid=" + (String)localObject + "&meta=game&keyword=All&response_type=xml&recs=5");
      final SAXParser localSAXParser = SAXParserFactory.newInstance().newSAXParser();
      final ImageView localImageView = new ImageView(paramContext);
      final TextView localTextView = new TextView(paramContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      localImageView.setLayoutParams(localLayoutParams);
      localTextView.setLayoutParams(localLayoutParams);
      t = new Timer();
      t.scheduleAtFixedRate(new TimerTask()
      {
        public void run()
        {
          new Thread()
          {
            public void run()
            {
              for (;;)
              {
                final Object localObject2;
                List localList1;
                try
                {
                  if (ZestadzAd.this.userAgent.equalsIgnoreCase("Mozilla/5.0 (Linux; U; Android 1.5; en-us; google_sdk Build/CUPCAKE) AppleWebKit/525.10+ (KHTML, like Gecko) Version/3.0.4 Mobile Safari/523.12.2")) {
                    break label525;
                  }
                  Object localObject1 = this.val$sp.getXMLReader();
                  ((XMLReader)localObject1).setContentHandler(new ExampleHandler());
                  localObject2 = this.val$url.openConnection();
                  ((URLConnection)localObject2).setConnectTimeout(5000);
                  ((URLConnection)localObject2).setReadTimeout(10000);
                  ((XMLReader)localObject1).parse(new InputSource(((URLConnection)localObject2).getInputStream()));
                  localObject1 = ParsedExampleDataSet.getExtractedPicture();
                  localObject2 = ParsedExampleDataSet.getExtractedURL();
                  localList1 = ParsedExampleDataSet.getExtractedText();
                  List localList2 = ParsedExampleDataSet.getExtractedError();
                  List localList3 = ParsedExampleDataSet.getExtractedAdType();
                  i = 0;
                  if (i >= ((List)localObject1).size()) {
                    return;
                  }
                  if ((!((String)localList3.get(i)).equals("NA")) && (!((String)localList3.get(i)).equals("text")))
                  {
                    final Drawable localDrawable = ZestadzAd.this.ImageOperations(this.val$context, ((String)((List)localObject1).get(i)).toString(), "image.jpg");
                    final String str = ((String)((List)localObject2).get(i)).toString();
                    ZestadzAd.this.handler.post(new Runnable()
                    {
                      public void run()
                      {
                        this.val$imgView.setImageDrawable(localDrawable);
                        this.val$imgView.setAdjustViewBounds(ZestadzAd.this.mAdVisibility);
                        ZestadzAd.this.setAdVisibility(true);
                        this.val$imgView.setVisibility(0);
                        this.val$imgView.setAdjustViewBounds(true);
                        this.val$imgView.setScaleType(ImageView.ScaleType.FIT_XY);
                        this.val$imgView.setOnClickListener(new View.OnClickListener()
                        {
                          public void onClick(View paramAnonymous4View)
                          {
                            paramAnonymous4View = ProgressDialog.show(this.val$context, "Redirecting to Landing page", "Loading. Please wait...", true);
                            Intent localIntent = new Intent("android.intent.action.VIEW");
                            localIntent.setData(Uri.parse(this.val$mextURL));
                            ((Activity)this.val$context).startActivity(localIntent);
                            paramAnonymous4View.dismiss();
                          }
                        });
                        this.val$container.removeAllViews();
                        this.val$container.addView(this.val$imgView);
                      }
                    });
                    if (i >= ((List)localObject1).size() - 1) {
                      break label688;
                    }
                    sleep(60000 / ((List)localObject1).size());
                    break label688;
                  }
                  if (localList3.equals("NA"))
                  {
                    Log.i("Error has arised in response XML", ((String)localList2.get(i)).toString());
                    ZestadzAd.this.setAdText(((String)localList2.get(i)).toString());
                    ZestadzAd.this.handler.post(new Runnable()
                    {
                      public void run()
                      {
                        this.val$container.removeAllViews();
                        this.val$container.addView(this.val$mTextView);
                      }
                    });
                    continue;
                  }
                  if (!((String)localList1.get(i)).toString().equals("NA")) {
                    break label498;
                  }
                }
                catch (Exception localException)
                {
                  localException.printStackTrace();
                  ZestadzAd.this.setAdText(" ");
                  ZestadzAd.this.handler.post(new Runnable()
                  {
                    public void run()
                    {
                      this.val$mTextView.setText(ZestadzAd.getAdText());
                      this.val$container.removeAllViews();
                      this.val$container.addView(this.val$mTextView);
                    }
                  });
                  Log.e("PARSE XML", localException.toString());
                  return;
                }
                ZestadzAd.this.setAdText("");
                for (;;)
                {
                  Log.i("Text Ad is the Reponse", ((String)localList1.get(i)).toString());
                  ZestadzAd.this.handler.post(new Runnable()
                  {
                    public void run()
                    {
                      this.val$mTextView.setText(ZestadzAd.getAdText());
                      this.val$container.removeAllViews();
                      this.val$container.addView(this.val$mTextView);
                    }
                  });
                  break;
                  label498:
                  ZestadzAd.this.setAdText(((String)localList1.get(i)).toString());
                }
                label525:
                ArrayList localArrayList = new ArrayList();
                localArrayList.add("http://assets.zestadz.com/ad/ad_picture/4299/chart_300x50-xlarge-xlarge.gif");
                localArrayList.add("http://assets.zestadz.com/ad/ad_picture/4497/flirtThousandsV2-300x50-xlarge-xlarge.gif");
                localArrayList.add("http://assets.zestadz.com/ad/ad_picture/4285/cricket300x50v1-xlarge.gif");
                localArrayList.add("http://assets.zestadz.com/ad/ad_picture/4212/pacman-xlarge-xlarge.gif");
                localArrayList.add("http://assets.zestadz.com/ad/ad_picture/4183/300x50-xlarge-xlarge.gif");
                int i = 0;
                while (i < localArrayList.size())
                {
                  localObject2 = ZestadzAd.this.ImageOperations(this.val$context, ((String)localArrayList.get(i)).toString(), "image.jpg");
                  ZestadzAd.this.handler.post(new Runnable()
                  {
                    public void run()
                    {
                      this.val$imgView.setImageDrawable(localObject2);
                      this.val$imgView.setAdjustViewBounds(ZestadzAd.this.mAdVisibility);
                      ZestadzAd.this.setAdVisibility(true);
                      this.val$imgView.setVisibility(0);
                      this.val$imgView.setAdjustViewBounds(true);
                      this.val$imgView.setScaleType(ImageView.ScaleType.FIT_XY);
                      this.val$imgView.setOnClickListener(new View.OnClickListener()
                      {
                        public void onClick(View paramAnonymous4View)
                        {
                          paramAnonymous4View = ProgressDialog.show(this.val$context, "Redirecting to Landing page", "Loading. Please wait...", true);
                          Intent localIntent = new Intent("android.intent.action.VIEW");
                          localIntent.setData(Uri.parse("http://www.zestadz.com"));
                          ((Activity)this.val$context).startActivity(localIntent);
                          ((Activity)this.val$context).finish();
                          paramAnonymous4View.dismiss();
                        }
                      });
                      this.val$container.removeAllViews();
                      this.val$container.addView(this.val$imgView);
                    }
                  });
                  if (i < localArrayList.size() - 1) {
                    sleep(60000 / localArrayList.size());
                  }
                  i += 1;
                }
                return;
                label688:
                i += 1;
              }
            }
          }.start();
          ParsedExampleDataSet.extractedText.clear();
          ParsedExampleDataSet.extractedPicture.clear();
          ParsedExampleDataSet.extractedURL.clear();
          ParsedExampleDataSet.extractedAdType.clear();
          ParsedExampleDataSet.ExtractedError.clear();
        }
      }, 0L, 60000L);
      addView(localRelativeLayout);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        setAdText(" ");
        this.handler.post(new Runnable()
        {
          public void run()
          {
            TextView localTextView = new TextView(paramContext);
            localTextView.setText(ZestadzAd.getAdText());
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            localLayoutParams.addRule(12);
            localTextView.setLayoutParams(localLayoutParams);
            localRelativeLayout.removeAllViews();
            localRelativeLayout.addView(localTextView);
          }
        });
        Log.e("ZestadzAD", "Display ZestADZ Ad", localException);
      }
    }
  }
  
  public Object fetch(String paramString)
    throws MalformedURLException, IOException
  {
    try
    {
      paramString = new URL(paramString).getContent();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      Log.e("FETCH", paramString.toString());
    }
    return null;
  }
  
  public void setAdText(String paramString)
  {
    mAdText = paramString;
  }
  
  public void setAdVisibility(boolean paramBoolean)
  {
    this.mAdVisibility = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/zestadz/android/ZestadzAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
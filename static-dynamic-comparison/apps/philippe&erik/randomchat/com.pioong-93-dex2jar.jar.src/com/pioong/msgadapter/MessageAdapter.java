package com.pioong.msgadapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pioong.ChattingActivity;
import com.pioong.FullScreenImgActivity;
import com.pioong.imagecache.ImageLoaderThum;
import com.pioong.imagecache.MemoryCache;
import java.util.ArrayList;

public class MessageAdapter
  extends ArrayAdapter<ChatMessage>
{
  private ChattingActivity ca;
  private MemoryCache cache;
  private int dWidth;
  ImageLoaderThum imgLoader;
  private Context mContext;
  private LayoutInflater mInflater;
  private ArrayList<ChatMessage> mList;
  
  public MessageAdapter(Context paramContext, int paramInt1, ArrayList<ChatMessage> paramArrayList, int paramInt2)
  {
    super(paramContext, paramInt1, paramArrayList);
    this.mContext = paramContext;
    this.mList = paramArrayList;
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    this.ca = ((ChattingActivity)paramContext);
    this.dWidth = getDps(paramInt2);
    this.imgLoader = new ImageLoaderThum(paramContext);
    this.cache = new MemoryCache("myImg");
  }
  
  private int getDps(int paramInt)
  {
    float f = this.mContext.getResources().getDisplayMetrics().density;
    return (int)(paramInt / Float.valueOf(f).floatValue());
  }
  
  public void addComment(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    this.mList.add(new ChatMessage("S", paramString));
    this.ca.updateList();
  }
  
  public void clearCache()
  {
    this.imgLoader.clearCache();
    this.cache.clear();
  }
  
  public int dpToPx(int paramInt)
  {
    return (int)(paramInt * this.mContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public ChatMessage getSentMessage(String paramString)
  {
    int i = this.mList.size() - 1;
    for (;;)
    {
      Object localObject;
      if (i < 0) {
        localObject = null;
      }
      ChatMessage localChatMessage;
      do
      {
        return (ChatMessage)localObject;
        localChatMessage = (ChatMessage)this.mList.get(i);
        localObject = localChatMessage;
      } while (localChatMessage.getID() == paramString);
      i -= 1;
    }
  }
  
  public View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
  {
    Object localObject2 = paramView;
    Object localObject3 = localObject2;
    for (;;)
    {
      int j;
      try
      {
        final ChatMessage localChatMessage = (ChatMessage)this.mList.get(paramInt);
        localObject3 = localObject2;
        Object localObject1 = localChatMessage.getWho();
        localObject3 = localObject2;
        Object localObject4 = localChatMessage.getType();
        localObject3 = localObject2;
        if (((String)localObject1).equals("me"))
        {
          localObject3 = localObject2;
          if (((String)localObject4).equals("T"))
          {
            if (localObject2 == null)
            {
              localObject3 = localObject2;
              localObject1 = getView2(paramInt, paramView, paramViewGroup, 2130903044, "my_message");
              localObject3 = localObject1;
              paramView = (LinearLayout)((View)localObject1).findViewById(2131296274);
              if (paramInt != 0) {
                continue;
              }
              localObject3 = localObject1;
              paramView.setPadding(0, dpToPx(10), 0, 0);
              localObject3 = localObject1;
              paramView = ((View)localObject1).getTag().toString();
              localObject3 = localObject1;
              if (!paramView.equals("my_message"))
              {
                localObject3 = localObject1;
                if (!paramView.equals("your_message")) {
                  continue;
                }
              }
              localObject3 = localObject1;
              paramView = (TextView)((View)localObject1).findViewById(2131296283);
              localObject3 = localObject1;
              if (this.dWidth > 240) {
                continue;
              }
              localObject3 = localObject1;
              paramView.setMaxWidth(dpToPx(190));
              localObject3 = localObject1;
              paramViewGroup = localChatMessage.getText();
              localObject3 = localObject1;
              paramView.setText(paramViewGroup);
              localObject3 = localObject1;
              this.ca.registerForContextMenu(paramView);
              localObject3 = localObject1;
              paramView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener()
              {
                public void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
                {
                  MessageAdapter.this.ca.setClipboard(paramViewGroup);
                  paramAnonymousContextMenu.setHeaderTitle(MessageAdapter.this.ca.getString(2131034134));
                  paramAnonymousContextMenu.add(0, 1, 1, MessageAdapter.this.ca.getString(2131034135));
                  paramAnonymousContextMenu.add(0, 2, 2, MessageAdapter.this.ca.getString(2131034136));
                  paramAnonymousContextMenu.add(0, 3, 3, MessageAdapter.this.ca.getString(2131034137));
                }
              });
              localObject3 = localObject1;
              ((ImageView)((View)localObject1).findViewById(2131296282)).setVisibility(8);
              localObject3 = localObject1;
              ((TextView)((View)localObject1).findViewById(2131296277)).setVisibility(8);
              localObject3 = localObject1;
              ((TextView)((View)localObject1).findViewById(2131296281)).setVisibility(8);
              localObject3 = localObject1;
              paramView = localChatMessage.getTime();
              if (paramView != null)
              {
                localObject3 = localObject1;
                paramViewGroup = (TextView)((View)localObject1).findViewById(2131296281);
                localObject3 = localObject1;
                paramViewGroup.setText(paramView);
                localObject3 = localObject1;
                paramViewGroup.setVisibility(0);
                localObject3 = localObject1;
                if (Build.VERSION.SDK_INT < 14) {
                  continue;
                }
                localObject3 = localObject1;
                if (!localChatMessage.getWho().equals("me")) {
                  continue;
                }
                localObject3 = localObject1;
                paramViewGroup.setBackgroundResource(2130837507);
                localObject3 = localObject1;
                ((TextView)((View)localObject1).findViewById(2131296277)).setVisibility(0);
              }
              localObject3 = localObject1;
              if (!localChatMessage.getSType().equals("FAIL")) {
                continue;
              }
              localObject3 = localObject1;
              paramView = (ImageView)((View)localObject1).findViewById(2131296282);
              localObject3 = localObject1;
              paramView.setVisibility(0);
              localObject3 = localObject1;
              this.ca.registerForContextMenu(paramView);
              localObject3 = localObject1;
              paramView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener()
              {
                public void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
                {
                  MessageAdapter.this.ca.setFailedCM(localChatMessage);
                  paramAnonymousContextMenu.setHeaderTitle(MessageAdapter.this.ca.getString(2131034134));
                  paramAnonymousContextMenu.add(0, 4, 1, MessageAdapter.this.ca.getString(2131034138));
                  paramAnonymousContextMenu.add(0, 5, 2, MessageAdapter.this.ca.getString(2131034139));
                  paramAnonymousContextMenu.add(0, 6, 3, MessageAdapter.this.ca.getString(2131034140));
                }
              });
              localObject3 = localObject1;
              paramView.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymousView)
                {
                  MessageAdapter.this.ca.openContextMenu(paramView);
                }
              });
              localObject3 = localObject1;
              paramView.setLongClickable(false);
              return (View)localObject1;
            }
            localObject1 = localObject2;
            localObject3 = localObject2;
            if (((View)localObject2).getTag().toString().equals("my_message")) {
              continue;
            }
            localObject3 = localObject2;
            localObject1 = getView2(paramInt, paramView, paramViewGroup, 2130903044, "my_message");
            continue;
          }
        }
        localObject3 = localObject2;
        if (((String)localObject1).equals("me"))
        {
          localObject3 = localObject2;
          if (((String)localObject4).equals("I"))
          {
            if (localObject2 == null)
            {
              localObject3 = localObject2;
              localObject1 = getView2(paramInt, paramView, paramViewGroup, 2130903043, "my_image");
              continue;
            }
            localObject1 = localObject2;
            localObject3 = localObject2;
            if (((View)localObject2).getTag().toString().equals("my_image")) {
              continue;
            }
            localObject3 = localObject2;
            localObject1 = getView2(paramInt, paramView, paramViewGroup, 2130903043, "my_image");
            continue;
          }
        }
        localObject3 = localObject2;
        if (((String)localObject1).equals("you"))
        {
          localObject3 = localObject2;
          if (((String)localObject4).equals("T"))
          {
            localObject4 = localObject2;
            if (localObject2 == null)
            {
              localObject3 = localObject2;
              localObject4 = getView2(paramInt, paramView, paramViewGroup, 2130903048, "your_message");
            }
            localObject1 = localObject4;
            localObject3 = localObject4;
            if (((View)localObject4).getTag().toString().equals("your_message")) {
              continue;
            }
            localObject3 = localObject4;
            localObject1 = getView2(paramInt, paramView, paramViewGroup, 2130903048, "your_message");
            continue;
          }
        }
        localObject3 = localObject2;
        if (((String)localObject1).equals("you"))
        {
          localObject3 = localObject2;
          if (((String)localObject4).equals("I"))
          {
            localObject4 = localObject2;
            if (localObject2 == null)
            {
              localObject3 = localObject2;
              localObject4 = getView2(paramInt, paramView, paramViewGroup, 2130903047, "your_image");
            }
            localObject1 = localObject4;
            localObject3 = localObject4;
            if (((View)localObject4).getTag().toString().equals("your_image")) {
              continue;
            }
            localObject3 = localObject4;
            localObject1 = getView2(paramInt, paramView, paramViewGroup, 2130903047, "your_image");
            continue;
          }
        }
        localObject1 = localObject2;
        localObject3 = localObject2;
        if (!((String)localObject4).equals("S")) {
          continue;
        }
        localObject4 = localObject2;
        if (localObject2 == null)
        {
          localObject3 = localObject2;
          localObject4 = getView2(paramInt, paramView, paramViewGroup, 2130903046, "system");
        }
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((View)localObject4).getTag().toString().equals("system")) {
          continue;
        }
        localObject3 = localObject4;
        localObject1 = getView2(paramInt, paramView, paramViewGroup, 2130903046, "system");
        continue;
        localObject3 = localObject1;
        paramView.setPadding(0, 0, 0, 0);
        continue;
        localObject3 = localObject1;
        if (this.dWidth <= 320)
        {
          localObject3 = localObject1;
          paramView.setMaxWidth(dpToPx(230));
          continue;
        }
        localObject3 = localObject1;
        if (this.dWidth <= 480)
        {
          localObject3 = localObject1;
          paramView.setMaxWidth(dpToPx(260));
          continue;
        }
        localObject3 = localObject1;
        paramView.setMaxWidth(dpToPx(290));
        continue;
        localObject3 = localObject1;
        if (!paramView.equals("my_image"))
        {
          localObject3 = localObject1;
          if (!paramView.equals("your_image")) {}
        }
        else
        {
          localObject3 = localObject1;
          if (paramView.equals("my_image"))
          {
            localObject3 = localObject1;
            paramView = (ImageView)((View)localObject1).findViewById(2131296279);
            localObject3 = localObject1;
            paramViewGroup = (ProgressBar)((View)localObject1).findViewById(2131296268);
            localObject3 = localObject1;
            paramViewGroup.setVisibility(8);
            localObject3 = localObject1;
            localObject2 = this.cache.get(localChatMessage.getID());
            if (localObject2 != null)
            {
              localObject3 = localObject1;
              paramView.setImageBitmap((Bitmap)localObject2);
            }
            localObject3 = localObject1;
            if (localChatMessage.getTime() == null)
            {
              localObject3 = localObject1;
              if (!localChatMessage.getSType().equals("FAIL"))
              {
                localObject3 = localObject1;
                paramViewGroup.setVisibility(0);
                localObject3 = localObject1;
                ((ImageView)((View)localObject1).findViewById(2131296282)).setVisibility(8);
                localObject3 = localObject1;
                ((TextView)((View)localObject1).findViewById(2131296277)).setVisibility(8);
                localObject3 = localObject1;
                ((TextView)((View)localObject1).findViewById(2131296281)).setVisibility(8);
                continue;
              }
            }
            localObject3 = localObject1;
            paramViewGroup = localChatMessage.getPath();
            if (paramViewGroup == null) {
              continue;
            }
            localObject3 = localObject1;
            if (paramViewGroup.equals("")) {
              continue;
            }
            localObject3 = localObject1;
            paramView.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymousView)
              {
                paramAnonymousView = new Bundle();
                paramAnonymousView.putString("url", paramViewGroup);
                Intent localIntent = new Intent(MessageAdapter.this.ca, FullScreenImgActivity.class);
                localIntent.putExtras(paramAnonymousView);
                MessageAdapter.this.ca.startActivity(localIntent);
              }
            });
            continue;
          }
          localObject3 = localObject1;
          localObject2 = (FrameLayout)((View)localObject1).findViewById(2131296278);
          localObject3 = localObject1;
          ((FrameLayout)localObject2).removeAllViews();
          localObject3 = localObject1;
          i = localChatMessage.getImgWidth();
          localObject3 = localObject1;
          j = localChatMessage.getImgHeight();
          paramInt = i;
          if (i != 0) {
            break label1738;
          }
          paramInt = -2;
          break label1738;
          localObject3 = localObject1;
          paramView = new ImageView(this.ca);
          localObject3 = localObject1;
          paramView.setLayoutParams(new LinearLayout.LayoutParams(paramInt, i));
          localObject3 = localObject1;
          paramView.setScaleType(ImageView.ScaleType.FIT_START);
          localObject3 = localObject1;
          localObject4 = new LinearLayout(this.ca);
          localObject3 = localObject1;
          ((LinearLayout)localObject4).setLayoutParams(new LinearLayout.LayoutParams(paramInt, i));
          localObject3 = localObject1;
          ((LinearLayout)localObject4).setGravity(17);
          localObject3 = localObject1;
          paramViewGroup = new ProgressBar(this.ca, null, 16842873);
          localObject3 = localObject1;
          paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
          localObject3 = localObject1;
          paramViewGroup.setVisibility(8);
          localObject3 = localObject1;
          ((LinearLayout)localObject4).addView(paramViewGroup);
          localObject3 = localObject1;
          ((FrameLayout)localObject2).addView(paramView);
          localObject3 = localObject1;
          ((FrameLayout)localObject2).addView((View)localObject4);
          localObject3 = localObject1;
          localObject2 = localChatMessage.getText();
          localObject3 = localObject1;
          this.imgLoader.DisplayImage((String)localObject2, paramView, paramViewGroup);
          localObject3 = localObject1;
          paramViewGroup = localChatMessage.getPath();
          if (paramViewGroup == null) {
            continue;
          }
          localObject3 = localObject1;
          if (paramViewGroup.equals("")) {
            continue;
          }
          localObject3 = localObject1;
          paramView.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              paramAnonymousView = new Bundle();
              paramAnonymousView.putString("url", paramViewGroup);
              Intent localIntent = new Intent(MessageAdapter.this.ca, FullScreenImgActivity.class);
              localIntent.putExtras(paramAnonymousView);
              MessageAdapter.this.ca.startActivity(localIntent);
            }
          });
          continue;
        }
        localObject3 = localObject1;
        if (!paramView.equals("system")) {
          continue;
        }
        localObject3 = localObject1;
        ((TextView)((View)localObject1).findViewById(2131296285)).setText(localChatMessage.getText());
        continue;
        localObject3 = localObject1;
        paramViewGroup.setBackgroundResource(2130837510);
        continue;
        localObject3 = localObject1;
        if (localChatMessage.getWho().equals("me"))
        {
          localObject3 = localObject1;
          paramViewGroup.setBackgroundResource(2130837508);
          continue;
        }
        localObject3 = localObject1;
        paramViewGroup.setBackgroundResource(2130837511);
        continue;
        return (View)localObject1;
      }
      catch (Exception paramView)
      {
        return (View)localObject3;
      }
      label1738:
      int i = j;
      if (j == 0) {
        i = -2;
      }
    }
  }
  
  public View getView2(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2, String paramString)
  {
    paramView = this.mInflater.inflate(paramInt2, null);
    ((RelativeLayout)paramView.findViewById(2131296275)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MessageAdapter.this.ca.hideKeyboard(paramAnonymousView);
      }
    });
    paramView.setTag(paramString);
    return paramView;
  }
  
  public void put(String paramString, Bitmap paramBitmap)
  {
    this.cache.put(paramString, paramBitmap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/msgadapter/MessageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
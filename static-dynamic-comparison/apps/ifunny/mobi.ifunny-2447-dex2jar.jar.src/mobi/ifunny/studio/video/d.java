package mobi.ifunny.studio.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mobi.ifunny.k.m;
import mobi.ifunny.k.x;
import mobi.ifunny.rest.content.YoutubeVideo;
import mobi.ifunny.rest.content.YoutubeVideo.YoutubeThumbnail;
import mobi.ifunny.util.a.a;

class d
        extends BaseAdapter {
    private List<YoutubeVideo> a;
    private m<View, mobi.ifunny.view.drawable.f> b;
    private x c = new x();
    private LayoutInflater d;
    private int e;
    private int f;
    private int g;
    private String h;

    public d(Context paramContext) {
        this.d = LayoutInflater.from(paramContext);
        paramContext = paramContext.getResources();
        this.e = paramContext.getColor(2131361840);
        this.f = paramContext.getColor(2131361879);
        this.g = paramContext.getColor(2131361880);
        this.h = paramContext.getString(2131690146);
        this.a = new ArrayList();
        this.b = new m(4, 6000);
        this.b.a(new e(this));
    }

    public static String a(long paramLong) {
        String str2 = Long.toString(paramLong);
        String str1 = str2;
        if (paramLong < 10L) {
            str1 = "0" + str2;
        }
        return str1;
    }

    public YoutubeVideo a(int paramInt) {
        return (YoutubeVideo) this.a.get(paramInt);
    }

    public void a() {
        this.b.b();
    }

    public void a(List<YoutubeVideo> paramList) {
        this.a.addAll(paramList);
        notifyDataSetChanged();
    }

    public void b() {
        this.a.clear();
        notifyDataSetChanged();
    }

    public void c() {
        this.b.a();
    }

    public int getCount() {
        return this.a.size();
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        YoutubeVideo localYoutubeVideo = a(paramInt);
        String str = localYoutubeVideo.getThumbnail().getSqDefault();
        boolean bool;
        if (paramView == null) {
            paramView = this.d.inflate(2130903180, paramViewGroup, false);
            paramViewGroup = new f(this, str, (ImageView) paramView.findViewById(2131493347), (TextView) paramView.findViewById(2131493351), (TextView) paramView.findViewById(2131493350), (TextView) paramView.findViewById(2131493349), (TextView) paramView.findViewById(2131493348), null);
            paramView.setTag(paramViewGroup);
            localObject = null;
            bool = TextUtils.equals(str, (CharSequence) localObject);
            if (f.a(paramViewGroup).getDrawable() == null) {
                break label336;
            }
        }
        label336:
        for (paramInt = 1; ; paramInt = 0) {
            if ((!bool) || (paramInt == 0)) {
                break label341;
            }
            f.a(paramViewGroup).setDrawingCacheEnabled(true);
            f.c(paramViewGroup).setText(localYoutubeVideo.getTitle());
            f.d(paramViewGroup).setText(localYoutubeVideo.getViewCount() + " " + this.h);
            int i = localYoutubeVideo.getDuration();
            paramInt = i / 3600;
            i -= paramInt * 3600;
            int j = i / 60;
            localObject = new StringBuilder();
            if (paramInt > 0) {
                ((StringBuilder) localObject).append(a(paramInt));
                ((StringBuilder) localObject).append(":");
            }
            ((StringBuilder) localObject).append(a(j));
            ((StringBuilder) localObject).append(":");
            ((StringBuilder) localObject).append(a(i - j * 60));
            f.e(paramViewGroup).setText(((StringBuilder) localObject).toString());
            f.f(paramViewGroup).setText(localYoutubeVideo.getUploader());
            return paramView;
            paramViewGroup = (f) paramView.getTag();
            localObject = f.b(paramViewGroup);
            f.a(paramViewGroup, str);
            break;
        }
        label341:
        paramInt = 0;
        Object localObject = this.b.b(paramView);
        if (localObject != null) {
            if (!TextUtils.equals(str, ((mobi.ifunny.k.r) localObject).b.c())) {
                this.b.a(paramView);
            }
        }
        for (paramInt = 1; ; paramInt = 1) {
            if (paramInt != 0) {
                localObject = f.a(paramViewGroup).getLayoutParams();
                localObject = new Point(((ViewGroup.LayoutParams) localObject).width, ((ViewGroup.LayoutParams) localObject).height);
                this.b.a(paramView, new mobi.ifunny.k.r(this.c, new a(str, (Point) localObject, false)));
            }
            f.a(paramViewGroup).setImageDrawable(null);
            f.a(paramViewGroup).getBackground().setLevel(mobi.ifunny.util.r.b(1, 6));
            break;
        }
    }

    public void notifyDataSetChanged() {
        c();
        super.notifyDataSetChanged();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/video/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
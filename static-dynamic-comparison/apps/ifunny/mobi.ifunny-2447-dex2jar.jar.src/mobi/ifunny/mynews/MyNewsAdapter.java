package mobi.ifunny.mynews;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

import mobi.ifunny.gallery.a.e;
import mobi.ifunny.gallery.a.j;
import mobi.ifunny.gallery.h;
import mobi.ifunny.k.z;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.Counters;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.News;
import mobi.ifunny.rest.content.NewsFeed;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.util.ah;
import mobi.ifunny.util.r;

public class MyNewsAdapter
        extends mobi.ifunny.gallery.a.f<News, NewsFeed> {
    private static final String a = MyNewsAdapter.class.getSimpleName();
    private final mobi.ifunny.k.a b;
    private final SparseArray<String> c;
    private final List<String> e;
    private final String f;
    private final String g;
    private int h;
    private c i;

    public MyNewsAdapter(AbsListView paramAbsListView) {
        super(null, paramAbsListView, 2, 6000);
        Resources localResources = paramAbsListView.getContext().getResources();
        this.b = new mobi.ifunny.k.a(new e(paramAbsListView.getContext()), new mobi.ifunny.k.c(), 2, 6000);
        this.c = new SparseArray();
        a(localResources, 2131361796);
        a(localResources, 2131361835);
        a(localResources, 2131361799);
        a(localResources, 2131361899);
        a(localResources, 2131361857);
        a(localResources, 2131361861);
        a(localResources, 2131361883);
        a(localResources, 2131361845);
        this.f = localResources.getString(2131689760);
        this.g = localResources.getString(2131689761);
        this.e = Arrays.asList(new String[]{"comment_for_repub", "repub_of_repub", "smile_for_repub"});
    }

    private void a(Resources paramResources, int paramInt) {
        this.c.put(paramInt, mobi.ifunny.util.f.a(paramResources.getColor(paramInt)));
    }

    private String b(int paramInt) {
        if (paramInt <= 1) {
            return null;
        }
        if (paramInt == 2) {
            return String.format(this.f, new Object[]{Integer.valueOf(1)});
        }
        return String.format(this.g, new Object[]{r.d(paramInt - 1)});
    }

    protected mobi.ifunny.k.a a(AbsListView paramAbsListView, int paramInt1, int paramInt2) {
        Context localContext = paramAbsListView.getContext();
        return new mobi.ifunny.k.a(new mobi.ifunny.comments.f(paramAbsListView.getContext(), new mobi.ifunny.util.c(localContext)), new mobi.ifunny.k.g(), paramInt1, paramInt2);
    }

    public void a(int paramInt) {
        this.h = paramInt;
    }

    public void a(c paramc) {
        this.i = paramc;
    }

    public View c(int paramInt, h<News> paramh, View paramView, ViewGroup paramViewGroup) {
        News localNews = (News) paramh.a;
        paramh = paramViewGroup.getContext();
        Resources localResources = paramh.getResources();
        int j;
        MyNewsAdapter.ViewHolder localViewHolder;
        Object localObject1;
        View localView1;
        label52:
        String str4;
        String str1;
        Object localObject2;
        IFunny localIFunny;
        Comment localComment1;
        if (paramView != null) {
            j = 1;
            if (j == 0) {
                break label996;
            }
            localViewHolder = (MyNewsAdapter.ViewHolder) paramView.getTag();
            localObject1 = localViewHolder.b;
            localView1 = paramView;
            localViewHolder.b = localNews;
            str4 = localNews.type;
            str1 = TextUtils.htmlEncode(r.b(localNews.date * 1000L, paramh));
            localObject2 = localNews.user;
            paramh = null;
            if (localObject2 != null) {
                paramh = TextUtils.htmlEncode(((User) localObject2).nick);
            }
            localIFunny = localNews.content;
            localViewHolder.a.e = localIFunny;
            localComment1 = localNews.comment;
            if (localComment1 == null) {
                break label2403;
            }
        }
        label272:
        label342:
        label416:
        label523:
        label632:
        label692:
        label832:
        label915:
        label947:
        label996:
        label2391:
        label2403:
        for (String str2 = TextUtils.htmlEncode(localComment1.text); ; str2 = null) {
            Comment localComment2 = localNews.reply;
            if (localComment2 != null) {
            }
            for (String str3 = TextUtils.htmlEncode(localComment2.text); ; str3 = null) {
                ImageView localImageView = localViewHolder.userImage;
                View localView2 = localViewHolder.userImageBackground;
                View localView3 = localViewHolder.userImageLayout;
                if ((localObject1 != null) && (!TextUtils.equals(((News) localObject1).type, localNews.type))) {
                    localImageView.setImageDrawable(null);
                }
                localView3.setOnClickListener(null);
                j = -1;
                switch (str4.hashCode()) {
                    default:
                        switch (j) {
                            default:
                                a(new mobi.ifunny.comments.g(localImageView, localView2, ((User) localObject2).getPhotoThumbSmallUrl(), (User) localObject2), paramView);
                                localView3.setOnClickListener(new a(this, (User) localObject2));
                                localObject1 = localViewHolder.thumbLayout;
                                ((View) localObject1).setOnClickListener(null);
                                localObject2 = localViewHolder.a.g;
                                j = -1;
                                switch (str4.hashCode()) {
                                    default:
                                        switch (j) {
                                            default:
                                                ((View) localObject1).setVisibility(0);
                                                paramViewGroup = new z(localViewHolder.a.g, localViewHolder.a.f, localIFunny.getThumbUrl(ah.c(paramViewGroup.getContext())), localViewHolder.a);
                                                this.b.a(paramViewGroup, paramView);
                                                ((View) localObject1).setOnClickListener(new b(this, localIFunny));
                                                localObject1 = null;
                                                j = -1;
                                                switch (str4.hashCode()) {
                                                    default:
                                                        switch (j) {
                                                            default:
                                                                j = -1;
                                                                switch (str4.hashCode()) {
                                                                    default:
                                                                        switch (j) {
                                                                            default:
                                                                                paramViewGroup = null;
                                                                                paramView = null;
                                                                                paramh = null;
                                                                                localViewHolder.a(Html.fromHtml(paramh), paramView, (Drawable) localObject1, Html.fromHtml(paramViewGroup), localNews.content);
                                                                                if (paramInt == this.h) {
                                                                                    paramInt = 0;
                                                                                    localViewHolder.a(paramInt);
                                                                                    boolean bool = this.e.contains(str4);
                                                                                    paramh = localViewHolder.a.a;
                                                                                    if (!bool) {
                                                                                        break label2391;
                                                                                    }
                                                                                }
                                                                                break;
                                                                        }
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                for (paramInt = 0; ; paramInt = 8) {
                    paramh.setVisibility(paramInt);
                    return localView1;
                    j = 0;
                    break;
                    localView1 = LayoutInflater.from(paramh).inflate(2130903136, paramViewGroup, false);
                    localViewHolder = new MyNewsAdapter.ViewHolder(localView1);
                    localView1.setTag(localViewHolder);
                    localObject1 = null;
                    break label52;
                    if (!str4.equals("ban")) {
                        break label272;
                    }
                    j = 0;
                    break label272;
                    if (!str4.equals("unban")) {
                        break label272;
                    }
                    j = 1;
                    break label272;
                    if (!str4.equals("featured")) {
                        break label272;
                    }
                    j = 2;
                    break label272;
                    if (!str4.equals("special")) {
                        break label272;
                    }
                    j = 3;
                    break label272;
                    localImageView.setImageResource(2130837811);
                    localView2.setBackgroundDrawable(null);
                    i().a(localImageView);
                    break label342;
                    localImageView.setImageResource(2130837819);
                    localView2.setBackgroundDrawable(null);
                    i().a(localImageView);
                    break label342;
                    localImageView.setImageResource(2130837814);
                    localView2.setBackgroundDrawable(null);
                    i().a(localImageView);
                    break label342;
                    localImageView.setImageResource(2130837817);
                    localView2.setBackgroundDrawable(null);
                    i().a(localImageView);
                    break label342;
                    if (!str4.equals("ban")) {
                        break label416;
                    }
                    j = 0;
                    break label416;
                    if (!str4.equals("unban")) {
                        break label416;
                    }
                    j = 1;
                    break label416;
                    if (!str4.equals("subscribe")) {
                        break label416;
                    }
                    j = 2;
                    break label416;
                    if (!str4.equals("special")) {
                        break label416;
                    }
                    j = 3;
                    break label416;
                    ((View) localObject1).setVisibility(8);
                    this.b.a((ImageView) localObject2);
                    break label523;
                    if (!str4.equals("smile")) {
                        break label632;
                    }
                    j = 0;
                    break label632;
                    if (!str4.equals("smile_for_repub")) {
                        break label632;
                    }
                    j = 1;
                    break label632;
                    if (!str4.equals("smile_for_comment")) {
                        break label632;
                    }
                    j = 2;
                    break label632;
                    if (!str4.equals("smile_for_reply")) {
                        break label632;
                    }
                    j = 3;
                    break label632;
                    if (!str4.equals("repub")) {
                        break label632;
                    }
                    j = 4;
                    break label632;
                    if (!str4.equals("repub_of_repub")) {
                        break label632;
                    }
                    j = 5;
                    break label632;
                    if (!str4.equals("comment")) {
                        break label632;
                    }
                    j = 6;
                    break label632;
                    if (!str4.equals("comment_for_repub")) {
                        break label632;
                    }
                    j = 7;
                    break label632;
                    if (!str4.equals("reply_for_comment")) {
                        break label632;
                    }
                    j = 8;
                    break label632;
                    if (!str4.equals("subscribe")) {
                        break label632;
                    }
                    j = 9;
                    break label632;
                    if (!str4.equals("friend_registered")) {
                        break label632;
                    }
                    j = 10;
                    break label632;
                    localObject1 = localResources.getDrawable(2130837816);
                    break label692;
                    localObject1 = localResources.getDrawable(2130837813);
                    break label692;
                    localObject1 = localResources.getDrawable(2130837815);
                    break label692;
                    localObject1 = localResources.getDrawable(2130837812);
                    break label692;
                    localObject1 = localResources.getDrawable(2130837810);
                    break label692;
                    localObject1 = localResources.getDrawable(2130837818);
                    break label692;
                    localObject1 = localResources.getDrawable(2130837818);
                    break label692;
                    if (!str4.equals("smile")) {
                        break label832;
                    }
                    j = 0;
                    break label832;
                    if (!str4.equals("smile_for_repub")) {
                        break label832;
                    }
                    j = 1;
                    break label832;
                    if (!str4.equals("smile_for_comment")) {
                        break label832;
                    }
                    j = 2;
                    break label832;
                    if (!str4.equals("smile_for_reply")) {
                        break label832;
                    }
                    j = 3;
                    break label832;
                    if (!str4.equals("repub")) {
                        break label832;
                    }
                    j = 4;
                    break label832;
                    if (!str4.equals("repub_of_repub")) {
                        break label832;
                    }
                    j = 5;
                    break label832;
                    if (!str4.equals("comment")) {
                        break label832;
                    }
                    j = 6;
                    break label832;
                    if (!str4.equals("comment_for_repub")) {
                        break label832;
                    }
                    j = 7;
                    break label832;
                    if (!str4.equals("reply_for_comment")) {
                        break label832;
                    }
                    j = 8;
                    break label832;
                    if (!str4.equals("subscribe")) {
                        break label832;
                    }
                    j = 9;
                    break label832;
                    if (!str4.equals("friend_registered")) {
                        break label832;
                    }
                    j = 10;
                    break label832;
                    if (!str4.equals("featured")) {
                        break label832;
                    }
                    j = 11;
                    break label832;
                    if (!str4.equals("ban")) {
                        break label832;
                    }
                    j = 12;
                    break label832;
                    if (!str4.equals("unban")) {
                        break label832;
                    }
                    j = 13;
                    break label832;
                    if (!str4.equals("special")) {
                        break label832;
                    }
                    j = 14;
                    break label832;
                    paramView = b(localIFunny.num.smiles);
                    paramViewGroup = str1;
                    break label915;
                    paramView = b(localComment1.num_smiles);
                    paramViewGroup = String.format("\"%s\" %s", new Object[]{r.a(str2, 25), str1});
                    break label915;
                    paramView = b(localComment2.num_smiles);
                    paramViewGroup = String.format("\"%s\" %s", new Object[]{r.a(str3, 25), str1});
                    break label915;
                    paramView = b(localIFunny.num.republished);
                    paramViewGroup = str1;
                    break label915;
                    paramViewGroup = localResources.getString(2131689751, new Object[]{this.c.get(2131361883), str2, this.c.get(2131361835), str1});
                    paramView = null;
                    break label915;
                    paramViewGroup = localResources.getString(2131689751, new Object[]{this.c.get(2131361883), str3, this.c.get(2131361835), str1});
                    paramView = null;
                    break label915;
                    paramViewGroup = localResources.getString(2131689767, new Object[]{this.c.get(2131361835), str1});
                    paramView = null;
                    break label915;
                    paramViewGroup = localResources.getString(2131689759, new Object[]{this.c.get(2131361835), str1});
                    paramView = null;
                    break label915;
                    paramh = localResources.getString(2131689758, new Object[]{this.c.get(2131361857)});
                    paramViewGroup = localResources.getString(2131689757, new Object[]{this.c.get(2131361835), str1});
                    paramView = null;
                    break label915;
                    paramh = localResources.getString(2131689750, new Object[]{this.c.get(2131361861)});
                    paramViewGroup = localResources.getString(2131689749, new Object[]{this.c.get(2131361835), str1});
                    paramView = null;
                    break label915;
                    paramh = localResources.getString(2131689770, new Object[]{this.c.get(2131361845)});
                    paramViewGroup = localResources.getString(2131689769, new Object[]{this.c.get(2131361835), str1});
                    paramView = null;
                    break label915;
                    paramh = localResources.getString(2131689766, new Object[]{this.c.get(2131361857), localNews.text});
                    paramViewGroup = localResources.getString(2131689765, new Object[]{this.c.get(2131361835), str1});
                    paramView = null;
                    break label915;
                    paramInt = 8;
                    break label947;
                }
            }
        }
    }

    public void g() {
        super.g();
        this.b.b();
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public void h() {
        super.h();
        this.b.c();
    }

    public void onMovedToScrapHeap(View paramView) {
        super.onMovedToScrapHeap(paramView);
        this.b.a(paramView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/mynews/MyNewsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
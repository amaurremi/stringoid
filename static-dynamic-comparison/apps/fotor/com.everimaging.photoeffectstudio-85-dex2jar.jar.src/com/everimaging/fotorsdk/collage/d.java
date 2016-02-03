package com.everimaging.fotorsdk.collage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.net.Uri;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.collage.entity.Attachment;
import com.everimaging.fotorsdk.collage.entity.Template;
import com.everimaging.fotorsdk.collage.painter.ICollagePainter;
import com.everimaging.fotorsdk.collage.painter.b;
import com.everimaging.fotorsdk.collage.painter.c;
import com.everimaging.fotorsdk.collage.params.BackgroundParam;
import com.everimaging.fotorsdk.collage.params.CollageParam;
import com.everimaging.fotorsdk.collage.params.CollageSlotItemParam;
import com.everimaging.fotorsdk.collage.params.TemplateParam;
import com.everimaging.fotorsdk.collage.utils.e;
import com.everimaging.fotorsdk.filter.a.a;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.FeaturePack;
import com.everimaging.fotorsdk.plugins.h;
import com.everimaging.fotorsdk.plugins.h.a;
import com.everimaging.fotorsdk.provider.FotorContentProvider.ActionsColumns;
import com.everimaging.fotorsdk.provider.FotorContentProvider.ActionsColumns.Action;
import com.everimaging.fotorsdk.provider.FotorContentProvider.SessionColumns.Session;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class d
        implements a.a {
    private static final String a = FotorCollageController.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private Context c;
    private CollageParam d;
    private RenderScript e;
    private com.everimaging.fotorsdk.algorithms.filter.d f;
    private FotorContentProvider.SessionColumns.Session g;
    private TemplateParam h;
    private BackgroundParam i;
    private List<CollageSlotItemParam> j;
    private Bitmap k;
    private int l;
    private int m;
    private List<Path> n;
    private List<Path> o;
    private float p;
    private List<ICollagePainter> q;

    public d(Context paramContext, FotorContentProvider.SessionColumns.Session paramSession) {
        this.c = paramContext;
        this.g = paramSession;
        try {
            this.e = RenderScript.create(paramContext);
            this.f = new com.everimaging.fotorsdk.algorithms.filter.d(this.e);
            return;
        } catch (Throwable paramContext) {
            this.e = null;
            this.f = null;
            b.e(new Object[]{"create rs error:" + paramContext.getMessage()});
            com.everimaging.fotorsdk.a.b("CREATE_RS_ERROR", paramContext.getMessage());
        }
    }

    private void a(Canvas paramCanvas) {
        if ((this.q != null) && (this.q.size() > 0)) {
            Iterator localIterator = this.q.iterator();
            while (localIterator.hasNext()) {
                Object localObject = (ICollagePainter) localIterator.next();
                switch (1. b[localObject.e().ordinal()])
                {
                    default:
                        break;
                    case 1:
                        localObject = (com.everimaging.fotorsdk.collage.painter.a) localObject;
                        ((com.everimaging.fotorsdk.collage.painter.a) localObject).b();
                        ((com.everimaging.fotorsdk.collage.painter.a) localObject).a(paramCanvas, false);
                        ((com.everimaging.fotorsdk.collage.painter.a) localObject).c();
                        break;
                    case 2:
                        ((b) localObject).a(paramCanvas, this.l, this.m);
                        break;
                    case 3:
                        ((c) localObject).a(paramCanvas, this.p);
                }
            }
        }
    }

    private boolean b() {
        boolean bool2 = true;
        Object localObject1 = FotorContentProvider.ActionsColumns.getContentUri(this.c, this.g.session_id);
        localObject1 = this.c.getContentResolver().query((Uri) localObject1, null, null, null, null);
        boolean bool1 = bool2;
        Object localObject2;
        if (localObject1 != null) {
            bool1 = bool2;
            if (((Cursor) localObject1).moveToFirst()) {
                int i1 = ((Cursor) localObject1).getCount();
                b.c(new Object[]{"total actions: " + i1});
                i1 = 0;
                bool2 = false;
                i1 += 1;
                localObject2 = FotorContentProvider.ActionsColumns.Action.create((Cursor) localObject1);
                if (localObject2 == null) {
                    break label188;
                }
                localObject2 = new String(((FotorContentProvider.ActionsColumns.Action) localObject2).params);
                this.d = new CollageParam();
            }
        }
        for (; ; ) {
            try {
                this.d.parseFromJson((String) localObject2);
                bool1 = bool2;
                bool2 = bool1;
                if (((Cursor) localObject1).moveToNext()) {
                    break;
                }
                return bool1;
            } catch (Exception localException) {
                b.e(new Object[]{"parse collage param failed"});
                return true;
            }
            label188:
            b.e(new Object[]{"action is null"});
            bool1 = true;
        }
    }

    private void c() {
        Object localObject1 = this.h.getTemplate();
        int i1 = this.l;
        int i2 = this.m;
        int i3 = Math.min(i1, i2);
        float f1 = ((Template) localObject1).getBorderSpacing();
        float f3 = ((Template) localObject1).getBorderMargin();
        float f2 = i3;
        f3 = i3 * f3;
        float f4 = ((Template) localObject1).getRoundness();
        this.n = null;
        this.o = null;
        Object localObject2 = this.h.getFeaturePack();
        localObject2 = (h.a) h.a(this.c, (FeaturePack) localObject2);
        switch (1. a[localObject1.getType().ordinal()])
        {
        }
        for (; ; ) {
            this.o = new ArrayList();
            localObject1 = this.j.iterator();
            while (((Iterator) localObject1).hasNext()) {
                localObject2 = (CollageSlotItemParam) ((Iterator) localObject1).next();
                localObject2 = (Path) this.n.get(((CollageSlotItemParam) localObject2).getSlotIndex());
                this.o.add(localObject2);
            }
            this.n = e.a((Template) localObject1, i1, i2, f3, f1 * f2, f4);
            continue;
            this.n = e.a((Template) localObject1, (h.a) localObject2, 1.0F);
            continue;
            this.n = e.a((Template) localObject1, (h.a) localObject2, i1, i2, f3);
        }
    }

    private void d() {
        this.q = new ArrayList();
        e();
        f();
        g();
        Collections.sort(this.q, new com.everimaging.fotorsdk.collage.utils.d());
    }

    private void e() {
        Object localObject = this.d.getTemplateParam().getTemplate();
        float f1 = ((Template) localObject).getShadowStrength() / this.p;
        int i1 = 1;
        localObject = ((Template) localObject).getType();
        switch (1. a[localObject.ordinal()])
        {
        }
        for (; ; ) {
            localObject = new b(this.c);
            ((b) localObject).a(this.i, this.h.getPreviewCanvasW(), this.h.getPreviewCanvasH());
            if (i1 != 0) {
                ((b) localObject).a(f1, this.o);
            }
            ((b) localObject).a(Integer.MIN_VALUE);
            this.q.add(localObject);
            return;
            i1 = 0;
        }
    }

    private void f() {
        if ((this.j != null) && (this.j.size() > 0)) {
            Iterator localIterator = this.j.iterator();
            while (localIterator.hasNext()) {
                CollageSlotItemParam localCollageSlotItemParam = (CollageSlotItemParam) localIterator.next();
                c localc = new c(this, localCollageSlotItemParam, (Path) this.n.get(localCollageSlotItemParam.getSlotIndex()), this.l, this.m);
                localc.a(localCollageSlotItemParam.getZIndex());
                this.q.add(localc);
            }
        }
    }

    private void g() {
        Object localObject2 = this.h.getTemplate();
        Object localObject1 = this.h.getFeaturePack();
        localObject1 = (h.a) h.a(this.c, (FeaturePack) localObject1);
        localObject2 = ((Template) localObject2).getAttachments();
        if ((localObject2 != null) && (((List) localObject2).size() > 0)) {
            localObject2 = ((List) localObject2).iterator();
            while (((Iterator) localObject2).hasNext()) {
                Attachment localAttachment = (Attachment) ((Iterator) localObject2).next();
                com.everimaging.fotorsdk.collage.painter.a locala = new com.everimaging.fotorsdk.collage.painter.a(this.c, localAttachment, (h.a) localObject1, 1.0F);
                locala.a(localAttachment.getzIndex());
                this.q.add(locala);
            }
        }
    }

    public boolean a()
            throws IllegalStateException {
        boolean bool = b();
        if (bool) {
            throw new IllegalStateException("query collage param failed");
        }
        this.h = this.d.getTemplateParam();
        this.i = this.d.getBackgroundParam();
        this.j = this.d.getSlotItemParams();
        Object localObject = this.h.getTemplate();
        this.l = ((Template) localObject).getOriginalWidth();
        this.m = ((Template) localObject).getOriginalHeight();
        float f1 = this.h.getPreviewCanvasW();
        float f2 = this.h.getPreviewCanvasH();
        this.p = Math.min(f1 / this.l, f2 / this.m);
        c();
        d();
        this.k = BitmapUtils.createBitmap(this.l, this.m, Bitmap.Config.ARGB_8888);
        localObject = new Canvas(this.k);
        ((Canvas) localObject).setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        a((Canvas) localObject);
        return bool;
    }

    public boolean a(String paramString) {
        try {
            boolean bool = Utils.saveBitmap2Path(paramString, this.k, 90);
            return bool;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
        return false;
    }

    public Context getContext() {
        return this.c;
    }

    public RenderScript getRenderScript() {
        return this.e;
    }

    public com.everimaging.fotorsdk.algorithms.filter.d getScript_BaseFilter() {
        return this.f;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
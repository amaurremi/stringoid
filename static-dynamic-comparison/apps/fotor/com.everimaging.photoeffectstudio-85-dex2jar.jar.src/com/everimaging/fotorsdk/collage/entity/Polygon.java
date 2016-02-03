package com.everimaging.fotorsdk.collage.entity;

import android.graphics.PointF;
import com.everimaging.fotorsdk.collage.utils.MagicPath;
import com.everimaging.fotorsdk.collage.utils.MagicPath.PathType;
import com.everimaging.fotorsdk.collage.utils.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Polygon {
    private ArrayList<Integer> vertexIndexes;

    public Polygon() {
        this.vertexIndexes = new ArrayList();
    }

    public Polygon(Polygon paramPolygon) {
        if (paramPolygon.vertexIndexes != null) {
            this.vertexIndexes = new ArrayList(paramPolygon.vertexIndexes);
        }
    }

    public MagicPath getMagicPath(ArrayList<PointF> paramArrayList, float paramFloat1, float paramFloat2) {
        MagicPath localMagicPath = new MagicPath();
        int i = 0;
        if (i < this.vertexIndexes.size()) {
            PointF localPointF = (PointF) paramArrayList.get(((Integer) this.vertexIndexes.get(i)).intValue());
            localPointF = new PointF(localPointF.x * paramFloat1, localPointF.y * paramFloat2);
            if (i == 0) {
                localMagicPath.a(MagicPath.PathType.MOVE_TO, localPointF);
            }
            for (; ; ) {
                i += 1;
                break;
                localMagicPath.a(MagicPath.PathType.LINE_TO, localPointF);
            }
        }
        localMagicPath.a(MagicPath.PathType.CLOSE, new PointF());
        return localMagicPath;
    }

    public ArrayList<Integer> getVertexIndexes() {
        return this.vertexIndexes;
    }

    public boolean isRect(List<PointF> paramList) {
        if (this.vertexIndexes.size() != 4) {
            return false;
        }
        if (paramList != null) {
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = this.vertexIndexes.iterator();
            while (localIterator.hasNext()) {
                localArrayList.add(paramList.get(((Integer) localIterator.next()).intValue()));
            }
            if (Float.compare(a.c((PointF) localArrayList.get(0), (PointF) localArrayList.get(2)), a.c((PointF) localArrayList.get(1), (PointF) localArrayList.get(3))) != 0) {
            }
        }
        for (boolean bool = true; ; bool = false) {
            return bool;
        }
    }

    public void setVertexIndexes(ArrayList<Integer> paramArrayList) {
        this.vertexIndexes = paramArrayList;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/entity/Polygon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.everimaging.fotorsdk.collage.entity;

import android.graphics.PointF;

import java.util.List;

public class FotorTemplateEntity {
    public static class TemplateCategory {
        public List<Template> classes;
        public String package_key;
        public String title;
        public String version;
    }

    public static class TemplateJObject {
        public String name;
        public String template_file;
    }

    public static class TemplateLine {
        public List<ItemRelative> bottomItems;
        public PointF from;
        public List<ItemRelative> leftItems;
        public String name;
        public List<ItemRelative> rightItems;
        public PointF to;
        public List<ItemRelative> topItems;

        public static class ItemRelative {
            public String name;
        }
    }

    public static class TemplatePicture {
        public float height;
        public String name;
        public float width;
        public float x;
        public float y;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/entity/FotorTemplateEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
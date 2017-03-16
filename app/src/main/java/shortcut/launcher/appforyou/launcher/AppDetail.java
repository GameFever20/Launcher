package shortcut.launcher.appforyou.launcher;

import android.graphics.drawable.Drawable;

/**
 * Created by gamef on 11-03-2017.
 */
public class AppDetail {

    CharSequence label;
    CharSequence name;
    Drawable icon;

    @Override
    public String toString() {
        return   name+""  ;
    }

    public AppDetail() {
    }

    public CharSequence getLabel() {

        return label;
    }

    public void setLabel(CharSequence label) {
        this.label = label;
    }

    public CharSequence getName() {
        return name;
    }

    public void setName(CharSequence name) {
        this.name = name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }


}

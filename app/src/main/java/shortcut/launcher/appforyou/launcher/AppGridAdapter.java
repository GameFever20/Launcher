package shortcut.launcher.appforyou.launcher;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gamef on 11-03-2017.
 */

public class AppGridAdapter extends BaseAdapter {
    private Context mContext;
    ArrayList<AppDetail> appDetailArrayList;

    public AppGridAdapter(Context mContext, ArrayList<AppDetail> appDetailArrayList) {
        this.mContext = mContext;
        this.appDetailArrayList = appDetailArrayList;
    }

    @Override
    public int getCount() {
        return appDetailArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

View view =View.inflate(mContext ,R.layout.app_gridview_layout , null);
        TextView textView =(TextView) view.findViewById(R.id.girdlayout_textview);

        textView.setText(appDetailArrayList.get(position).getLabel().toString());

        return view;
    }
}

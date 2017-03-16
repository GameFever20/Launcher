package shortcut.launcher.appforyou.launcher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PackageManager manager;
    private ArrayList<AppDetail> apps;
    private ArrayList<String> appsarrayList;

    ListView appListView;
    ArrayAdapter<String> mAdapter;

    GridView gridView ;
    AppGridAdapter mAppGridAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadApps();

       // mAdapter=new ArrayAdapter<String>(this ,android.R.layout.simple_list_item_1 ,
              //  appsarrayList );

        //appListView = (ListView)findViewById(R.id.listview);
        //appListView.setAdapter(mAdapter);

        gridView = (GridView)findViewById(R.id.gridView);

        mAppGridAdapter = new AppGridAdapter(this,apps);
        gridView.setAdapter(mAppGridAdapter);





    }



    private void loadApps() {
        manager = getPackageManager();

        apps = new ArrayList<AppDetail>();

        appsarrayList = new ArrayList<String>();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> availableActivities = manager.queryIntentActivities(i, 0);
        for ( ResolveInfo ri : availableActivities ) {
            AppDetail app = new AppDetail();
            app.label = ri.loadLabel(manager);
            app.name = ri.activityInfo.packageName;
            app.icon = ri.activityInfo.loadIcon(manager);
            apps.add(app);
            appsarrayList.add(app.label.toString());


        }


    }


    public void openApp(int pos){

        Intent i = manager.getLaunchIntentForPackage(apps.get(pos).name.toString());
        MainActivity.this.startActivity(i);
    }



}

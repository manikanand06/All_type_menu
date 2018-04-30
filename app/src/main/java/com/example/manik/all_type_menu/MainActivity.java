package com.example.manik.all_type_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ActionMode.Callback2;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    ImageView iv;
    ActionMode am;
    ActionMode.Callback amc;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        b = (Button)findViewById(R.id.but1);
        registerForContextMenu(iv);
        amc = new Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                getMenuInflater().inflate(R.menu.my_menu,menu);
                actionMode.setTitle("Demo of Contextual Action Mode");
                actionMode.setSubtitle("Subtitle");
                return true;
            }
            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return true;
            }
            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                Toast.makeText(MainActivity.this,""+menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                actionMode.finish();
                return false;
            }
            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
            }
        };
        b.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                am = startActionMode(amc);
                return  true;
            }
        });
    }
    public void dothis(View v)
    {
        PopupMenu pm = new PopupMenu(this,v);
        getMenuInflater().inflate(R.menu.my_menu,pm.getMenu());
        pm.show();
        pm.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int k =menuItem.getItemId();
                {
                    switch (k)
                    {

                    }
                }



                return true;
            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);

        MenuItem mi = menu.add(0,1,5,"About us");
        //  mi.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        SubMenu sb = menu.addSubMenu("Sub Menu");

        sb.add(0,2,0,"Sub Menu1");
        sb.add(0,3,0,"Sub Menu2");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int k = item.getItemId();
        switch (k)
        {
            case R.id.iv:
                Toast.makeText(this,""+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.but1:
                Toast.makeText(this,""+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this,""+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this,""+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this,""+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {

        menu.add(0,1,0,"Save As");
        menu.add(0,2,1,"Download");
        menu.add(0,3,2,"Open in new Tab");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int k =item.getItemId();
        switch (k) {
            case 1:
                Toast.makeText(this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
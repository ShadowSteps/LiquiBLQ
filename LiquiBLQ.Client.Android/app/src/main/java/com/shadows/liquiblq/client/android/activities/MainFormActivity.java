package com.shadows.liquiblq.client.android.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.shadows.liquiblq.client.android.R;
import com.shadows.liquiblq.client.android.activities.event_listeners.OnAlbumModelClickListener;
import com.shadows.liquiblq.client.android.activities.models.AlbumListItemModel;
import com.shadows.liquiblq.client.android.config.LoginSession;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetAlbumsUIHandler;
import com.shadows.liquiblq.client.android.core.managers.ActivityManager;
import com.shadows.liquiblq.client.android.core.managers.AlertManager;
import com.shadows.liquiblq.client.android.core.tasks.TasksManager;
import com.shadows.liquiblq.data.interfaces.dto.Album;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainFormActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DateFormat dateFormat = new SimpleDateFormat("dd.MMMM.yyyy");
    private ListView ObjectsList;
    private TextView UserHeader;
    private TextView TableHeader;
    private DrawerLayout drawer;
    private DrawerLayout albumDrawer;

    private GetAlbumsUIHandler albumsHandler;
    private TasksManager manager;

    private void InitializeControls() {
        setContentView(R.layout.activity_main_form);
        ObjectsList = (ListView)findViewById(R.id.objectList);
        UserHeader = (TextView)findViewById(R.id.userHeader);
        TableHeader = (TextView)findViewById(R.id.tableHeader);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        albumsHandler = new GetAlbumsUIHandler(this);
        manager = new TasksManager(getResources().getString(R.string.api_url));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActivityManager.OpenLoginActivity(this);
    }

    private void CheckPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (this.checkSelfPermission(Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{Manifest.permission.INTERNET}, 1);
            } else {
                InitializeControls();
            }
        } else {
            InitializeControls();
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    AlertManager.ShowErrorAlert(this, "Permissions not granted for internet and the app cannot conntact server!");
                    finish();
                } else {
                    InitializeControls();
                }
                return;
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                Boolean logged = data.getBooleanExtra("LOGIN_STATUS", false);
                if (!logged|| !LoginSession.IsLoggedIn())
                {
                    AlertManager.ShowErrorAlert(this,"Could not craete login session!");
                    finish();
                } else {
                    UserHeader.setText(UserHeader.getText().toString() + " " + LoginSession.Email);
                    if (!drawer.isDrawerOpen(GravityCompat.START)) {
                        drawer.openDrawer(GravityCompat.START);
                    }
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CheckPermissions();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_albums) {
            manager.StartGetAllAlbumsTask(albumsHandler,LoginSession.sessionKey,LoginSession.UserId);
        } else if (id == R.id.nav_artists) {

        } else if (id == R.id.nav_songs) {

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void LoadAlbums(List<Album> albums){
        List<AlbumListItemModel> albumModels = new ArrayList<>();
        ArrayAdapter<AlbumListItemModel> myarrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, albumModels);
        ObjectsList.setAdapter(myarrayAdapter);
        ObjectsList.setTextFilterEnabled(true);
        ObjectsList.setOnItemClickListener(new OnAlbumModelClickListener(this));
        for (Album a : albums){
            albumModels.add(new AlbumListItemModel(a.Name,a.Id,a.PublishDate));
        }
        myarrayAdapter.notifyDataSetChanged();
    }

    public void SetTableHeader(String text){
        this.TableHeader.setText(text);
    }

    public void SelectAlbum(int position){
        AlbumListItemModel model = (AlbumListItemModel)ObjectsList.getItemAtPosition(position);
        UUID AlbumId = model.Id;
        if (!drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.openDrawer(Gravity.RIGHT);
            TextView NameHolder = ((TextView)findViewById(R.id.album_info_name));
            TextView DateHolder = ((TextView)findViewById(R.id.album_info_date));
            NameHolder.setText("Name: "+model.Name);
            DateHolder.setText("Date: "+model.PublishDate);
        }
    }
}

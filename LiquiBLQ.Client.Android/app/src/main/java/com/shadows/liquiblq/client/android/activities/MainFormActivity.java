package com.shadows.liquiblq.client.android.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
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
import com.shadows.liquiblq.client.android.activities.event_listeners.OnAlbumGetArtistsClickListener;
import com.shadows.liquiblq.client.android.activities.event_listeners.OnAlbumGetSongsClickListener;
import com.shadows.liquiblq.client.android.activities.event_listeners.OnAlbumModelClickListener;
import com.shadows.liquiblq.client.android.activities.event_listeners.OnArtistGetAlbumsClickListener;
import com.shadows.liquiblq.client.android.activities.event_listeners.OnArtistModelClickListener;
import com.shadows.liquiblq.client.android.activities.event_listeners.OnSongGetAlbumsClickListener;
import com.shadows.liquiblq.client.android.activities.event_listeners.OnSongModelClickListener;
import com.shadows.liquiblq.client.android.activities.models.AlbumListItemModel;
import com.shadows.liquiblq.client.android.activities.models.ArtistListItemModel;
import com.shadows.liquiblq.client.android.activities.models.SongListItemModel;
import com.shadows.liquiblq.client.android.config.Formats;
import com.shadows.liquiblq.client.android.config.LoginSession;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetAlbumsOfArtistUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetAlbumsOfSongUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetAllAlbumsUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetAllArtistsUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetAllSongsUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetArtistsInAlbumUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetSongsInAlbumUIHandler;
import com.shadows.liquiblq.client.android.core.managers.ActivityManager;
import com.shadows.liquiblq.client.android.core.managers.AlertManager;
import com.shadows.liquiblq.client.android.core.managers.DrawerManager;
import com.shadows.liquiblq.client.android.core.tasks.TasksManager;
import com.shadows.liquiblq.client.core.SongsRequestsHandler;
import com.shadows.liquiblq.data.interfaces.dto.Album;
import com.shadows.liquiblq.data.interfaces.dto.Artist;
import com.shadows.liquiblq.data.interfaces.dto.Song;

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
    private Activity self;
    private GetAllAlbumsUIHandler albumsHandler;
    private GetAllArtistsUIHandler artistsHandler;
    private GetAllSongsUIHandler songsHandler;
    private GetAlbumsOfSongUIHandler albumsOfSongHandler = new GetAlbumsOfSongUIHandler(this);
    private GetAlbumsOfArtistUIHandler albumsOfArtistHandler = new GetAlbumsOfArtistUIHandler(this);
    private GetSongsInAlbumUIHandler songsInAlbumHandler = new GetSongsInAlbumUIHandler(this);
    private GetArtistsInAlbumUIHandler artistsInAlbumHandler = new GetArtistsInAlbumUIHandler(this);
    private TasksManager manager;

    private void InitializeControls() {
        setContentView(R.layout.activity_main_form);
        ObjectsList = (ListView)findViewById(R.id.objectList);
        UserHeader = (TextView)findViewById(R.id.userHeader);
        TableHeader = (TextView)findViewById(R.id.tableHeader);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        albumsHandler = new GetAllAlbumsUIHandler(this);
        artistsHandler = new GetAllArtistsUIHandler(this);
        songsHandler = new GetAllSongsUIHandler(this);
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

    private void CloseInfoPanel(){
        if (drawer.getChildCount() > 2){
            drawer.removeViewAt(2);
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
                    CheckPermissions();
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
        self = this;
        super.onCreate(savedInstanceState);
        CheckPermissions();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        }
        CloseInfoPanel();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_albums) {
            manager.StartGetAllAlbumsTask(albumsHandler,LoginSession.sessionKey,LoginSession.UserId);
        } else if (id == R.id.nav_artists) {
            manager.StartGetAllArtistsTask(artistsHandler, LoginSession.sessionKey,LoginSession.UserId);
        } else if (id == R.id.nav_songs) {
            manager.StartGetAllSongsTask(songsHandler, LoginSession.sessionKey, LoginSession.UserId);
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
        CloseInfoPanel();
    }

    public void SetTableHeader(String text){
        this.TableHeader.setText(text);
    }

    public void SelectAlbum(int position){
        NavigationView newNav = DrawerManager.ShowInfoPanel(this,R.layout.nav_header_album_info,R.menu.album_menu);
        AlbumListItemModel model = (AlbumListItemModel)ObjectsList.getItemAtPosition(position);
        UUID AlbumId = model.Id;
        if (!drawer.isDrawerOpen(Gravity.RIGHT)) {
            int children = drawer.getChildCount();
            if (children > 2){
                drawer.removeViewsInLayout(2, children - 2);
            }
            drawer.addView(newNav);
            TextView NameHolder = ((TextView)newNav.getHeaderView(0).findViewById(R.id.album_info_name));
            TextView DateHolder = ((TextView)newNav.getHeaderView(0).findViewById(R.id.album_info_date));
            MenuItem artistsButton = newNav.getMenu().findItem(R.id.nav_album_artists);
            MenuItem songsButton = newNav.getMenu().findItem(R.id.nav_album_songs);
            NameHolder.setText("Album name: " + model.Name);
            DateHolder.setText("Date published: "+ Formats.Date.format(model.PublishDate));
            artistsButton.setOnMenuItemClickListener(new OnAlbumGetArtistsClickListener(manager, AlbumId, this.artistsInAlbumHandler));
            songsButton.setOnMenuItemClickListener(new OnAlbumGetSongsClickListener(manager, AlbumId, this.songsInAlbumHandler));
        }
    }

    public void LoadArtists(List<Artist> artists) {
        List<ArtistListItemModel> albumModels = new ArrayList<>();
        ArrayAdapter<ArtistListItemModel> myarrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, albumModels);
        ObjectsList.setAdapter(myarrayAdapter);
        ObjectsList.setTextFilterEnabled(true);
        ObjectsList.setOnItemClickListener(new OnArtistModelClickListener(this));
        for (Artist a : artists){
            albumModels.add(new ArtistListItemModel(a.Name,a.Id,a.DateOfBirth,a.Nickname));
        }
        myarrayAdapter.notifyDataSetChanged();
        CloseInfoPanel();
    }

    public void SelectArtist(int position) {
        NavigationView newNav = DrawerManager.ShowInfoPanel(this,R.layout.nav_header_artist_info,R.menu.artist_menu);
        ArtistListItemModel model = (ArtistListItemModel)ObjectsList.getItemAtPosition(position);
        UUID ArtistId = model.Id;
        if (!drawer.isDrawerOpen(Gravity.RIGHT)) {
            int children = drawer.getChildCount();
            if (children > 2){
                drawer.removeViewsInLayout(3, children - 2);
            }
            drawer.addView(newNav);
            TextView NameHolder = ((TextView)newNav.getHeaderView(0).findViewById(R.id.artist_info_name));
            TextView NicknameHolder = ((TextView)newNav.getHeaderView(0).findViewById(R.id.artist_info_nickname));
            TextView DateHolder = ((TextView)newNav.getHeaderView(0).findViewById(R.id.artist_info_date));
            MenuItem albumsButton = newNav.getMenu().findItem(R.id.nav_artist_albums);
            NameHolder.setText("Artist name: "+model.Name);
            NicknameHolder.setText("Nickname: "+ model.Nickname);
            DateHolder.setText("Date of birth: "+ Formats.Date.format(model.DateOfBirth));
            albumsButton.setOnMenuItemClickListener(new OnArtistGetAlbumsClickListener(manager, ArtistId, albumsOfArtistHandler));
        }
    }

    public void LoadSongs(List<Song> songs) {
        List<SongListItemModel> albumModels = new ArrayList<>();
        ArrayAdapter<SongListItemModel> myarrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, albumModels);
        ObjectsList.setAdapter(myarrayAdapter);
        ObjectsList.setTextFilterEnabled(true);
        ObjectsList.setOnItemClickListener(new OnSongModelClickListener(this));
        for (Song s : songs){
            albumModels.add(new SongListItemModel(s.Name,s.Id,s.PublishDate,s.Genre));
        }
        myarrayAdapter.notifyDataSetChanged();
        CloseInfoPanel();
    }

    public void SelectSong(int position) {
        NavigationView newNav = DrawerManager.ShowInfoPanel(this,R.layout.nav_header_song_info,R.menu.song_menu);
        final SongListItemModel model = (SongListItemModel)ObjectsList.getItemAtPosition(position);
        final UUID SongId = model.Id;
        if (!drawer.isDrawerOpen(Gravity.RIGHT)) {
            int children = drawer.getChildCount();
            if (children > 2){
                drawer.removeViewsInLayout(3, children - 2);
            }
            drawer.addView(newNav);
            TextView NameHolder = ((TextView)newNav.getHeaderView(0).findViewById(R.id.song_info_name));
            TextView Genre = ((TextView)newNav.getHeaderView(0).findViewById(R.id.song_info_genre));
            TextView DateHolder = ((TextView)newNav.getHeaderView(0).findViewById(R.id.song_info_date));
            MenuItem albumsButton = newNav.getMenu().findItem(R.id.nav_song_albums);
            MenuItem playButton = newNav.getMenu().findItem(R.id.nav_song_play);
            NameHolder.setText("Song name: "+model.Name);
            Genre.setText("Genre: "+ model.Genre);
            DateHolder.setText("Date published: "+ Formats.Date.format(model.DatePublished));
            albumsButton.setOnMenuItemClickListener(new OnSongGetAlbumsClickListener(manager, SongId, albumsOfSongHandler));
            playButton.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    ActivityManager.OpenPlayActivity(self,model);
                    return true;
                }
            });
        }
    }
}

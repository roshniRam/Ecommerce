package com.example.dell.ecommerce;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.mikhaellopez.circularimageview.CircularImageView;

public class DrawerLayout extends AppCompatActivity {

    private ActionBarDrawerToggle toggleDrawer;
    private NavigationView navView;
    private android.support.v4.widget.DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggleDrawer = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggleDrawer);
        toggleDrawer.syncState();

        navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        int id = menuItem.getItemId();
                        switch (id)
                        {
                            case R.id.nav_camera:
                                Toast.makeText(DrawerLayout.this,"Nav_camera",Toast.LENGTH_LONG).show();
                            case R.id.nav_gallery:
                                Toast.makeText(DrawerLayout.this,"Nav_gallery",Toast.LENGTH_LONG).show();
                            case R.id.nav_slideshow:
                                Toast.makeText(DrawerLayout.this,"Nav_slideshow",Toast.LENGTH_LONG).show();
                            case R.id.nav_manage:
                                Toast.makeText(DrawerLayout.this,"Nav_manage",Toast.LENGTH_LONG).show();
                            default:
                                return true;
                        }
                    }
                }
        );

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(DrawerLayout.this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            Uri personPhoto = acct.getPhotoUrl();

            CircularImageView userDp = findViewById(R.id.user_image);
            TextView userName = findViewById(R.id.name_text_view);

//            userDp.setImageURI(null);
//            userDp.setImageURI(userDp);

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggleDrawer.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

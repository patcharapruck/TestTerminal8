package testwork.com.testterminal8.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraDevice;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import testwork.com.testterminal8.R;
import testwork.com.testterminal8.fragment.FragmentWords;
import testwork.com.testterminal8.fragment.FragmentWordset;
import testwork.com.testterminal8.manager.Contextor;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private CardView UseCamera;

    private EditText EdSearch;
    private ImageButton imagebutton_search,imagebutton_close;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_home);
        initInstances();
    }

    private void initInstances() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        UseCamera = (CardView)findViewById(R.id.card_use_camera);
        EdSearch = (EditText)findViewById(R.id.ed_search);
        imagebutton_search = (ImageButton)findViewById(R.id.imagebutton_search);
        imagebutton_close = (ImageButton)findViewById(R.id.imagebutton_close);
        text = (TextView)findViewById(R.id.text);

        EdSearch.setVisibility(View.INVISIBLE);
        imagebutton_close.setVisibility(View.INVISIBLE);

        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        setPager();

        UseCamera.setOnClickListener(this);
        imagebutton_search.setOnClickListener(this);
        imagebutton_close.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            finish();
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v == UseCamera){

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,999);

        }
        if(v == imagebutton_search){
            text.setVisibility(View.INVISIBLE);
            EdSearch.setVisibility(View.VISIBLE);

            imagebutton_search.setVisibility(View.INVISIBLE);
            imagebutton_close.setVisibility(View.VISIBLE);
        }
        if(v == imagebutton_close){
            text.setVisibility(View.VISIBLE);
            EdSearch.setVisibility(View.INVISIBLE);

            imagebutton_search.setVisibility(View.VISIBLE);
            imagebutton_close.setVisibility(View.INVISIBLE);
        }
    }

    private void req() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA)){

        }
        else{
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, 1);
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new FragmentWords();
                default:
                    return new FragmentWordset();
            }
        }
        @Override
        public int getCount() {
            return 2;
        }
    }

    private void setPager() {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) viewPager.findViewById(R.id.pager);
        viewPager.setAdapter(mSectionsPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}

package com.m_eldeeb.smartware;

import android.app.Service;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.m_eldeeb.smartware.interfaces.Communication;
import com.m_eldeeb.smartware.models.PortfolioModel;

public class Base extends AppCompatActivity implements Communication {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(int i) {
        Intent intent=new Intent(Base.this,CourseContent.class);
        switch (i){
            case 0:
                intent.putExtra("course","android");
                intent.putExtra("content",R.string.android_content);break;
            case 1:
                intent.putExtra("course","wb development (php)");
                intent.putExtra("content",R.string.php_content);break;
            case 2:
                intent.putExtra("course","graphic design");
                intent.putExtra("content",R.string.web_content);break;
            case 3:
                intent.putExtra("course","web development (asp.net)");
                intent.putExtra("content",R.string.web_content);break;
            case 4:
                intent.putExtra("course","web design");
                intent.putExtra("content",R.string.webdesign_content);break;
        }
        startActivity(intent);
    }

    @Override
    public void onClick(String i) {
        Intent intent=new Intent(Base.this,PortfolioDetails.class);

        intent.putExtra("content",i);
        startActivity(intent);
    }

    @Override
    public void onClick(PortfolioModel m) {
        Intent intent=new Intent(Base.this,PortfolioDetails.class);

        intent.putExtra("portfolio",m);
        startActivity(intent);
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            switch (position){
               case 0:Services f=new Services();
                    return f;
                case 1:Portfolio f1=new Portfolio();
                    return f1;
                case 2:Courses f2=new Courses();
                    return f2;
                case 3:Contact f3=new Contact();
                    return f3;
                default:return null;
            }
           //PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Services";
                case 1:
                    return "Portfolio";
                case 2:
                    return "Courses";
                case 3:
                    return "Contact";
            }
            return null;
        }
    }
}

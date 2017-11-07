package com.example.knowledge;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.mDrawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        setNavigationViewItemClickListener();
    }

//    public void FloatingActionButton(View view) {
//
//        //类似Toast效果，但是比Toast更加强大！
//        // 唯一不同的就是它的第一个参数不是传入Context而是传入它所依附的父视图
//        Snackbar.make(linearLayout, "衣服", Snackbar.LENGTH_LONG).show();
//
//    }

    private void setNavigationViewItemClickListener() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item_home:
                       // mToolbar.setTitle("首页");
                        mNavigationView.getMenu().getItem(0).setTitle("首页");
                        //switchFragment("MainFragment");
                        break;
                    case R.id.navigation_item_blog:
                       // mToolbar.setTitle("我的博客");
                        //switchFragment("BlogFragment");
                        break;
                    case R.id.navigation_item_about:
                        //mToolbar.setTitle("关于");
                        //switchFragment("AboutFragment");
                        break;
                    default:
                        break;
                }
                item.setChecked(true);
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                return false;
            }
        });
    }

}

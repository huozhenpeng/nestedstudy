package com.example.nesteddemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MaterialDesignTopBarActivity extends AppCompatActivity implements View.OnClickListener{
    private Fragment mFragmentA;
    private Fragment mFragmentB;
    private TextView tv_comic;
    private TextView tv_novel;
    private TextView title;
    private State oldState = State.EXPANDED;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, MaterialDesignTopBarActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);
        tv_comic= findViewById(R.id.tv_comic);
        tv_novel= findViewById(R.id.tv_novel);
        title = findViewById(R.id.title);
        AppBarLayout toolbarLayout = findViewById(R.id.app_bar);
        toolbarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {

                if( state == State.EXPANDED ) {

                    //展开状态
//                    Toast.makeText(MaterialDesignTopBarActivity.this,"展开",Toast.LENGTH_SHORT).show();
                    title.setText("替换为展开ui");

                }else if(state == State.COLLAPSED){
                    //折叠状态
//                    Toast.makeText(MaterialDesignTopBarActivity.this,"折叠",Toast.LENGTH_SHORT).show();
                    title.setText("替换为折叠ui");

                }else {
                    //中间状态
                    if (oldState != State.EXPANDED) {
                        title.setText("替换为展开ui");
                    }

                }
                oldState = state;
            }
        });
        tv_comic.setOnClickListener(this);
        tv_novel.setOnClickListener(this);
        mFragmentA = new FragmentA();
        mFragmentB = new FragmentB();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameLayout, mFragmentA).commit();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_novel) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frameLayout, mFragmentA).commit();
        } else if(v.getId() == R.id.tv_comic) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frameLayout, mFragmentB).commit();
        }
    }

    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }


    public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {

        private State mCurrentState = State.IDLE;

        @Override
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (i == 0) {
                if (mCurrentState != State.EXPANDED) {
                    onStateChanged(appBarLayout, State.EXPANDED);
                }
                mCurrentState = State.EXPANDED;
            } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
                if (mCurrentState != State.COLLAPSED) {
                    onStateChanged(appBarLayout, State.COLLAPSED);
                }
                mCurrentState = State.COLLAPSED;
            } else {
                if (mCurrentState != State.IDLE) {
                    onStateChanged(appBarLayout, State.IDLE);
                }
                mCurrentState = State.IDLE;
            }
        }

        public abstract void onStateChanged(AppBarLayout appBarLayout, State state);
    }
}

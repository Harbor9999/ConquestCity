package com.studyjams.s1.sj29.huzhou;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    /**
     * 碎片界面管理器
     */
    private FragmentManager fragmentManager;
    /**
     * 攻略布局视图
     */
    private View conquestView;
    /**
     * 切换城市布局视图
     */
    private View transferView;
    /**
     * 更多布局视图
     */
    private View moreView;
    /**
     * 攻略 图标
     */
    private ImageView conquestImageView;
    /**
     * 切换城市图标
     */
    private ImageView transferImageView;
    /**
     * 更多图标
     */
    private ImageView moreImageView;
    /**
     * conquestTextView菜单文本
     */
    private TextView conquestTextView;
    /**
     * transferTextView菜单文本
     */
    private TextView transferTextView;
    /**
     * moreTextView菜单文本
     */
    private TextView moreTextView;
    /**
     * 攻略界面
     */
    private ConquestFragment conquestFragment;
    /**
     * 城市界面
     */
    private TransferFragment transferFragment;
    /**
     * 我的更多界面
     */
    private MoreFragment moreFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        fragmentManager = getFragmentManager();
        selectTab(1);

    }

    /**
     * 初始化UI
     */
    private void initView() {
        conquestView = findViewById(R.id.conquest_layout);
        transferView = findViewById(R.id.transfer_layout);
        moreView = findViewById(R.id.more_layout);

        conquestImageView = (ImageView) findViewById(R.id.image_conquest);
        transferImageView = (ImageView) findViewById(R.id.image_transfer);
        moreImageView = (ImageView) findViewById(R.id.image_more);

        conquestTextView = (TextView) findViewById(R.id.tv_conquest);
        transferTextView = (TextView) findViewById(R.id.tv_transfer);
        moreTextView = (TextView) findViewById(R.id.tv_more);
        /*监听这三个视图*/
        conquestView.setOnClickListener(this);
        transferView.setOnClickListener(this);
        moreView.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.conquest_layout:
                selectTab(1);
                break;
            case R.id.transfer_layout:
                selectTab(2);
                break;
            case R.id.more_layout:
                selectTab(3);
                break;
            default:
                break;
        }

    }

    private void selectTab(int index) {
        /*清除先前选中的状态*/
        clearSelect();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        /*防止多个界面重叠显示，先隐藏*/
        hideFragment(fragmentTransaction);

        switch (index) {
            case 1:
                conquestImageView.setImageResource(R.drawable.main_tab_search_selected);
                conquestTextView.setTextColor(Color.BLUE);
                if (conquestFragment == null) {
                    conquestFragment = new ConquestFragment();
                    fragmentTransaction.add(R.id.content, conquestFragment);

                } else {
                    fragmentTransaction.show(conquestFragment);
                }
                break;
            case 2:
                transferImageView.setImageResource(R.drawable.main_tab_transfer_selected);
                transferTextView.setTextColor(Color.BLUE);
                if (transferFragment == null) {
                    transferFragment = new TransferFragment();

                    fragmentTransaction.add(R.id.content, transferFragment);

                } else {
                    fragmentTransaction.show(transferFragment);
                }
                break;
            case 3:
            default:
                moreImageView.setImageResource(R.drawable.main_tab_more_selected);
                moreTextView.setTextColor(Color.BLUE);
                if (moreFragment == null) {
                    moreFragment = new MoreFragment();
                    fragmentTransaction.add(R.id.content, moreFragment);

                } else {
                    fragmentTransaction.show(moreFragment);
                }
                break;

        }

        fragmentTransaction.commit();
    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {

        if (conquestFragment != null) {
            fragmentTransaction.hide(conquestFragment);
        }
        if (transferFragment != null) {
            fragmentTransaction.hide(transferFragment);
        }
        if (moreFragment != null) {
            fragmentTransaction.hide(moreFragment);
        }
    }

    private void clearSelect() {
        conquestImageView.setImageResource(R.drawable.main_tab_search_unselected);
        conquestTextView.setTextColor(Color.GRAY);
        transferImageView.setImageResource(R.drawable.main_tab_transfer_unselected);
        transferTextView.setTextColor(Color.GRAY);
        moreImageView.setImageResource(R.drawable.main_tab_more_unselected);
        moreTextView.setTextColor(Color.GRAY);
    }


}

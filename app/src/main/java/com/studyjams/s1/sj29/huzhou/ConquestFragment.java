package com.studyjams.s1.sj29.huzhou;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConquestFragment extends Fragment implements View.OnClickListener,ViewPager.OnPageChangeListener{

    private int pre_enable_pos = 0;
    private static final String TAG = "ConquestFragment";
    private TextView btn_cloth;
    private TextView btn_food;
    private TextView btn_company;
    private TextView btn_house;
    private TextView btn_travel;
    private ViewPager mViewPager;
    private TextView mTextView;
    private LinearLayout llPoint;
    private String[] imageDescription = {
            "笔架山公园",
            "市民中心夜景",
            "深圳东部华侨城",
            "深南大道",
            "深圳大梅沙"
    };
    private List<ImageView> imageViewList;

    private boolean isStop = false;

    public ConquestFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        initView();
        Thread mThread = new Thread(new Runnable() {

            @Override
            public void run() {

                while(!isStop)
                {
                    SystemClock.sleep(3000);
                    if (getActivity() != null) {
                        getActivity().runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                mViewPager.setCurrentItem(mViewPager
                                        .getCurrentItem() + 1);
                            }
                        });
                    }
                }
            }
        });

        mThread.start();
    }

    @Override
    public void onDestroy() {
        isStop = true;
        super.onDestroy();
    }


    private void initView() {
        //广告位
        mViewPager =  (ViewPager) getActivity().findViewById(R.id.banner);
        mTextView = (TextView) getActivity().findViewById(R.id.tv_description);
        llPoint =  (LinearLayout) getActivity().findViewById(R.id.ll_point);

        imageViewList = new ArrayList<ImageView>();
        int[] resIds = {
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
        };

        ImageView imageView; //图片
        View view; //点

        for (int id : resIds) {
            imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(id);
            imageViewList.add(imageView);

            view = new View(getActivity());
            view.setBackgroundResource(R.drawable.point_backgroud);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(5,5);
            params.leftMargin = 6;
            view.setEnabled(false);
            view.setLayoutParams(params);
            llPoint.addView(view);
        }
        mViewPager.setAdapter(new MyPagerAdapter());
        mViewPager.setOnPageChangeListener((ViewPager.OnPageChangeListener) this);
        int index = (Integer.MAX_VALUE / 2) - (Integer.MAX_VALUE / 2 % imageViewList.size());;
        mViewPager.setCurrentItem(index);

        //////////////////////////////五大按钮////////////////////////////////////////
        btn_cloth =   (TextView) getActivity().findViewById(R.id.bt_cloth);
        btn_cloth.setOnClickListener(this);

        btn_food = (TextView) getActivity().findViewById(R.id.bt_food);
        btn_food.setOnClickListener(this);

        btn_company =  (TextView) getActivity().findViewById(R.id.bt_company);
        btn_company.setOnClickListener(this);

        btn_house =  (TextView) getActivity().findViewById(R.id.bt_house);
        btn_house.setOnClickListener(this);

        btn_travel = (TextView) getActivity().findViewById(R.id.bt_travel);
        btn_travel.setOnClickListener(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conquest, container, false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_cloth:
                Log.i(TAG,"攻略*******衣服篇");
                Toast.makeText(getActivity(),"攻略*******衣服篇",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ClothActivity.class);
                startActivity(intent);;
//                getFragmentManager().beginTransaction().replace(R.layout.fragment_conquest,TransferFragment.class.getName()).commit();
                break;
            case R.id.bt_food:
                Log.i(TAG,"攻略*******美食篇");
                Intent intent1 = new Intent(getActivity(), FoodActivity.class);
                startActivity(intent1);;
                Toast.makeText(getActivity(),"攻略*******美食篇",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_company:
                Log.i(TAG,"攻略*******企业篇");
                Intent intent2 = new Intent(getActivity(), CompanyActivity.class);
                startActivity(intent2);;
                Toast.makeText(getActivity(),"攻略*******企业篇",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_house:
                Log.i(TAG,"攻略*******住房篇");
                Intent intent3 = new Intent(getActivity(), HouseActivity.class);
                startActivity(intent3);;
                Toast.makeText(getActivity(),"攻略*******住房篇",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_travel:
                Log.i(TAG,"攻略*******旅行篇");
                Intent intent4 = new Intent(getActivity(), TravelActivity.class);
                startActivity(intent4);;
                Toast.makeText(getActivity(),"攻略*******旅行篇",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int pos) {
        int new_pos = pos % imageViewList.size();
        mTextView.setText(imageDescription[new_pos]);
        llPoint.getChildAt(pre_enable_pos).setEnabled(false);//设置前一个为：未选中的状态
        llPoint.getChildAt(new_pos).setEnabled(true);//设置选中的改状态
        pre_enable_pos = new_pos;

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class MyPagerAdapter extends PagerAdapter {

         @Override
         public void destroyItem(ViewGroup container, int position, Object object) {
             container.removeView(imageViewList.get(position % imageViewList.size()));
         }


         @Override
         public Object instantiateItem(ViewGroup container, int position) {
             container.addView(imageViewList.get(position % imageViewList.size()));
             return imageViewList.get(position % imageViewList.size());
         }


         @Override
         public int getCount() {

             return Integer.MAX_VALUE;
         }


         @Override
         public boolean isViewFromObject(View arg0, Object arg1) {

             return arg0 == arg1;
         }
    }
}

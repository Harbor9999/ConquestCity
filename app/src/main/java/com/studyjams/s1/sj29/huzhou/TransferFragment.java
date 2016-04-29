package com.studyjams.s1.sj29.huzhou;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TransferFragment extends Fragment {
    private ListView listCityName;

    public TransferFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listCityName = (ListView) getActivity().findViewById(R.id.list_cityName);
        ArrayList<String> list = new ArrayList<String>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");
        list.add("东莞");
        list.add("中山");
        list.add("武汉");
        list.add("重庆");
        list.add("南京");
        list.add("杭州");
        list.add("长沙");
        list.add("拉萨");
        list.add("西藏");
        list.add("兰州");
        list.add("乌鲁木齐");
        list.add("包头");
        list.add("黑龙江");
        list.add("沈阳");
        list.add("佳木斯");
        list.add("济南");
        list.add("青岛");
        list.add("大连");
        list.add("苏州");
        list.add("南宁");
        list.add("香港");
        list.add("台湾");

        ArrayAdapter<String> cityNameAdapter = new ArrayAdapter<String>(getActivity(),R.layout.city_list_item , list);

        listCityName.setAdapter(cityNameAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transfer, container, false);
    }

}

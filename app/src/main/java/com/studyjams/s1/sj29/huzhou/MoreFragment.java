package com.studyjams.s1.sj29.huzhou;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment implements View.OnClickListener {


    private static final String TAG = "MoreFragment";
    private TextView tv_version;
    private EditText et_sugest;
    private Button bt_sugest;

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false);
    }


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {

        tv_version = (TextView) getActivity().findViewById(R.id.tc_app_version);
        tv_version.setText("V" + getAPPVersion(getActivity().getApplicationContext()));
        et_sugest = (EditText) getActivity().findViewById(R.id.et_sugest);
        bt_sugest = (Button) getActivity().findViewById(R.id.bt_sugest);
        bt_sugest.setOnClickListener(this);
    }


    private String getAPPVersion(Context c) {

        if (getPackageInfo(c) != null) {
            return getPackageInfo(c).versionName;
        }
        return null;
    }


    public PackageInfo getPackageInfo(Context context) {
        if (context != null) {
            PackageManager pm = context.getPackageManager();
            if (pm != null) {
                try {
                    PackageInfo packageInfo = pm.getPackageInfo(
                            context.getPackageName(), 0);
                    return packageInfo;
                } catch (PackageManager.NameNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_sugest:
                //提交反馈的信息
                String message = et_sugest.getText().toString();
                Log.i(TAG, "intent 发送邮件" + message);
                //发送邮件
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, "105013742@qq.com"); //邮件地址
                intent.putExtra(Intent.EXTRA_SUBJECT, "来着城市攻略的反馈："); //格式化主题
                intent.putExtra(Intent.EXTRA_TEXT,message);
                if ( intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(Intent.createChooser(intent, "chooser : "));
                    Log.i(TAG, "intent 发送邮件 ok ");
                }
                Toast.makeText(getActivity(),"分享内容",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }

    }
}

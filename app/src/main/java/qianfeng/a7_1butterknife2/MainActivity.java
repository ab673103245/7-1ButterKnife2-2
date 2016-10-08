package qianfeng.a7_1butterknife2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // 绑定控件
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;

    // 绑定颜色
    @BindColor(R.color.colorAccent)
    int textColor;

    //批量初始化控件
    @BindViews({R.id.btn1,R.id.btn2})
    List<Button> buttonList;

    @BindViews({R.id.tv3,R.id.tv4})
    TextView[] tvs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 这行代码是最重要的！没有它你写什么注解都没有用。表示所有绑定的View都是在这个Activity中初始化
        ButterKnife.bind(this);

        tv1.setText("123");

        tv2.setText("456");
        tv2.setTextColor(textColor);

        // 注意以下是批量绑定控件的示例代码
        buttonList.get(0).setText("按钮一");
        buttonList.get(1).setText("anniu2");

        tvs[0].setText("tv3");
        tvs[1].setText("tv4");

    }

    // 下面是绑定点击事件, 也可以绑定单个点击事件
    @OnClick({R.id.btn1,R.id.btn2})
    public void btnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn1:
                Toast.makeText(this,"123",Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn2:
                Toast.makeText(MainActivity.this, "456", Toast.LENGTH_SHORT).show();
                break;
        }
    }


}

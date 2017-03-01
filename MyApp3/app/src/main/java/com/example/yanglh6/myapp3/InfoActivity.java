package com.example.yanglh6.myapp3;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ListView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Info p = (Info) getIntent().getSerializableExtra("Info");

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Top);
        relativeLayout.setBackgroundColor(Color.parseColor(p.getBackground()));

        Button back = (Button) findViewById(R.id.Back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        TextView info1 = (TextView) findViewById(R.id.info1);
        info1.setText(p.getinfo1());

        TextView info2 = (TextView) findViewById(R.id.info2);
        info2.setText(p.getFrom());

        TextView name = (TextView) findViewById(R.id.Name);
        name.setText(p.getName());

        TextView tel = (TextView) findViewById(R.id.telephone);
        tel.setText(p.getTel());

        String[] operations1 = new String[]{"更多资料"};
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this, R.layout.more, operations1);
        ListView listView1 = (ListView) findViewById(R.id.more);
        listView1.setAdapter(arrayAdapter1);

        String[] operations2 = new String[]{"编辑联系人", "分享联系人", "加入黑名单", "删除联系人"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.more, operations2);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(arrayAdapter);

        /*  星星的切换 */
        final Button star = (Button) findViewById(R.id.star);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tag) {
                    star.setBackground(getDrawable(R.mipmap.full_star));
                    tag = true;
                } else {
                    star.setBackground(getDrawable(R.mipmap.empty_star));
                    tag = false;
                }
            }
        });
    }

    private boolean tag = false;
}

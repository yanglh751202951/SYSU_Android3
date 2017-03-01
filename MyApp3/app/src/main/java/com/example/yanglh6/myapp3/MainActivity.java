package com.example.yanglh6.myapp3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.os.Bundle;
import android.view.View;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Map<String, Object>> data = new ArrayList<>();

        /*  为每一项数据创建一个对象，并添加在List中  */
        final List<Info> Infos = new ArrayList<Info>() {{
            add(new Info("Aaron", "17715523654", "手机", "江苏苏州电信", "#BB4C3B"));
            add(new Info("Elvis", "18825653224", "手机", "广东揭阳移动", "#c48d30"));
            add(new Info("David", "15052116654", "手机", "江苏无锡移动", "#4469b0"));
            add(new Info("Edwin", "18854211875", "手机", "山东青岛移动", "#20A17B"));
            add(new Info("Frank", "13955188541", "手机", "安徽合肥移动", "#BB4C3B"));
            add(new Info("Joshua", "13621574410", "手机", "江苏苏州移动", "#c48d30"));
            add(new Info("Ivan", "15684122771", "手机", "山东烟台联通", "#4469b0"));
            add(new Info("Mark", "17765213579", "手机", "广东珠海电信", "#20A17B"));
            add(new Info("Joseph", "13315466578", "手机", "河北石家庄电信", "#BB4C3B"));
            add(new Info("Phoebe", "17895466428", "手机", "山东东营移动", "#c48d30"));
        }};

        char[] cycle = new char[Infos.size()];
        for (int i = 0; i < Infos.size(); i++) {
            char x = Infos.get(i).getcycle();
            cycle[i] = x;
        }
        String[] name = new String[Infos.size()];
        for (int i = 0; i < Infos.size(); i++) {
            String x = Infos.get(i).getName();
            name[i] = x;
        }
        for (int i = 0; i < Infos.size(); i++) {
            Map<String, Object> temp = new LinkedHashMap<>();
            temp.put("cycle", cycle[i]);
            temp.put("name", name[i]);
            data.add(temp);
        }

        /*  ListView单击事件  */
        ListView listView = (ListView) findViewById(R.id.Start);
        final SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.info,
                new String[]{"cycle", "name"}, new int[]{R.id.cycle, R.id.name});
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                Info temp = Infos.get(i);
                intent.putExtra("Info", temp);
                startActivity(intent);
            }
        });

        /*  ListView长按事件  */
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder message = new AlertDialog.Builder(MainActivity.this);
                message.setTitle("删除联系人");
                message.setMessage("确定删除联系人" + Infos.get(position).getName());
                message.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Infos.remove(position);
                        data.remove(position);
                        simpleAdapter.notifyDataSetChanged();
                    }
                });
                message.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                message.create().show();
                return true;
            }
        });
    }
}

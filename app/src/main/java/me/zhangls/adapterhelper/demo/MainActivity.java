package me.zhangls.adapterhelper.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.lv);
        QuickAdapter<Entity> adapter = new QuickAdapter<Entity>(this, R.layout.item) {

            @Override
            protected void convert(BaseAdapterHelper helper, Entity item) {
                helper.setText(R.id.title,item.name);
            }
        };
        adapter.addAll(getEntitys());
        lv.setAdapter(adapter);
    }

    public List<Entity> getEntitys() {
        List<Entity> entities = new ArrayList<Entity>();
        for (int i = 0; i < 10; i = i + 1) {
            Entity entity = new Entity();
            entity.name = "item" + i;
            entities.add(entity);
        }
        return entities;
    }
}

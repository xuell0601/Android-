package com.example.lianxiren;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private Lian iv;
    private ListView lv;
    private TextView tv;
    private Handler handler = new Handler();
    private ArrayList<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (Lian) findViewById(R.id.iv);
        lv = (ListView) findViewById(R.id.lv);
        tv = (TextView) findViewById(R.id.tv);
        iv.setOnLisner(new Lian.OnLisner() {
            @Override
            public void changeWord(String Words) {
                tv.setVisibility(View.VISIBLE);
                tv.setText(Words);
                upworldlist(Words);

                handler.removeCallbacksAndMessages(null);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tv.setVisibility(View.GONE);
                    }
                }, 3000);
            }
        });
        initData();

        MyAdapter myadpter = new MyAdapter();
        myadpter.notifyDataSetChanged();
        lv.setAdapter(myadpter);
    }

    private void upworldlist(String words) {
          for(int i=0;i<persons.size();i++){
                       String one=persons.get(i).getPingyin().substring(0,1);
               if(words.equals(one)){
                       lv.setSelection(i);
                   return;
               }

          }

    }


    class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return  persons.size();
        }

        @Override
        public Object getItem(int i) {
            return  persons.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if(convertView ==null){
                convertView = View.inflate(MainActivity.this,R.layout.item_main,null);
                viewHolder = new ViewHolder();
                viewHolder.tv_word = (TextView) convertView.findViewById(R.id.tv_word);
                viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }

            String name = persons.get(position).getName();//
            String word = persons.get(position).getPingyin().substring(0,1);//AFU->A
            viewHolder.tv_word.setText(word);
            viewHolder.tv_name.setText(name);
            if(position ==0){
                viewHolder.tv_word.setVisibility(View.VISIBLE);
            }else{
                //得到前一个位置对应的字母，如果当前的字母和上一个相同，隐藏；否则就显示
                String preWord = persons.get(position-1).getPingyin().substring(0,1);//A~Z
                if(word.equals(preWord)){
                    viewHolder.tv_word.setVisibility(View.GONE);
                }else{
                    viewHolder.tv_word.setVisibility(View.VISIBLE);
                }


            }


            return convertView;

        }
    }

    static class ViewHolder{
        TextView tv_word;
        TextView tv_name;
    }
    private void initData() {

        persons = new ArrayList<>();
        persons.add(new Person("张晓飞"));
        persons.add(new Person("玄芳华"));
        persons.add(new Person("胡继群"));
        persons.add(new Person("刘畅"));

        persons.add(new Person("钟泽兴"));
        persons.add(new Person("尹革新"));
        persons.add(new Person("安传鑫"));
        persons.add(new Person("张骞壬"));

        persons.add(new Person("温松"));
        persons.add(new Person("李凤秋"));
        persons.add(new Person("刘甫"));
        persons.add(new Person("娄全超"));
        persons.add(new Person("张猛"));
        persons.add(new Person("张猛"));
        persons.add(new Person("张猛"));
        persons.add(new Person("张猛"));
        persons.add(new Person("王名"));
        persons.add(new Person("王为"));
        persons.add(new Person("王生"));
        persons.add(new Person("王鸟"));
        persons.add(new Person("李振南"));
        persons.add(new Person("孙仁政"));
        persons.add(new Person("唐春雷"));
        persons.add(new Person("牛鹏伟"));
        persons.add(new Person("姜宇航"));

        persons.add(new Person("刘挺"));
        persons.add(new Person("张洪瑞"));
        persons.add(new Person("张建忠"));
        persons.add(new Person("侯亚帅"));
        persons.add(new Person("刘帅"));

        persons.add(new Person("乔竞飞"));
        persons.add(new Person("徐雨健"));
        persons.add(new Person("桥笑寒"));
        persons.add(new Person("王兆霖"));

        persons.add(new Person("阿三"));
        persons.add(new Person("李博俊"));

        //排序
       Collections.sort(persons, new Comparator<Person>() {
           @Override
           public int compare(Person person, Person t1) {
               return person.getPingyin().compareTo(t1.getPingyin());
           }
       });

    }


}

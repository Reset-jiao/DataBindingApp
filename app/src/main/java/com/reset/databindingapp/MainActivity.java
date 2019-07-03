package com.reset.databindingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.TextView;
import com.reset.databindingapp.databinding.ActivityMainBinding;
import com.reset.databindingapp.domain.Person;
import com.reset.databindingapp.domain.PersonExtra;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Person person;
    private PersonExtra personExtra = new PersonExtra();
    private List<Person> personList= new ArrayList<>();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 不再使用setContentView直接设置布局文件
        // 使用DataBindingUtil的setContentView方法设置布局文件，同时返回一个ViewDataBinding对象
        // ViewDataBinding对象是编译器自动帮我们生成的，类名是根据我们的布局文件名字命名的
        // 如 R.layout.activity_main，类名就是 ActivityMainBinding，应该很容易看懂

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        person = new Person();
        person.setName("jiao");
        person.setAge(33);

        binding.setPerson(person);

        // 我们不再使用 findViewById 来说去View了，编译器会自动帮我们生成 xml 布局中有id属性的View
        // View 的名字也是根据定义 id 属性的值来决定的
        // id="@+id/name_view"，View的名字叫做 nameView，很容易理解吧

        TextView tvName = binding.tvName;

        binding.setHandler(new NameHandler());

        // 赋值给xml定义的personExtra
        binding.setPersonExtra(personExtra);


    }

    public class NameHandler{

        public void onTextChanged(CharSequence charSequence, int start, int before, int count){

            person.setName(charSequence.toString());

            personExtra.address.set("河北省石家庄");

        }

    }
}

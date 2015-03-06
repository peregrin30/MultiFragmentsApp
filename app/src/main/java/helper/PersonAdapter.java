package helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


import hello.intec.be.multifragmentsapp.R;
import model.Person;

/**
 * Created by abdelhamide on 27/02/2015.
 */
public class PersonAdapter extends BaseAdapter {

    List<Person> persons;

    Context context;

    public PersonAdapter(Context context, List<Person> persons) {
        this.context = context;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Person getItem(int i) {
        return persons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater=LayoutInflater.from(context);

        if (view == null){

            view = inflater.inflate(R.layout.list_item,null);
        }

        TextView name =(TextView) view.findViewById(R.id.txtv_name);
        TextView age =(TextView) view.findViewById(R.id.txtv_age);

        name.setText(getItem(i).getName());
        age.setText(getItem(i).getAge()  + " ");


        return view;
    }
}

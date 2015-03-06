package hello.intec.be.multifragmentsapp.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hello.intec.be.multifragmentsapp.R;
import helper.PersonAdapter;
import model.Person;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPerson extends Fragment {

    private ListView mLvPersons;
    private PersonAdapter adapter;
    private List<Person> persons;
    private OnPersonSelectedListener listener;
    private Person person;

    public interface OnPersonSelectedListener{

        public void showPerson(String person);

    }

 public void onAttach(Activity activity){

     super.onAttach(activity);
     if (activity instanceof  OnPersonSelectedListener){
         listener =(OnPersonSelectedListener) activity;
     }else {
         throw new ClassCastException((activity.toString() + " must implenet  the fragment.pers listner"));
     }
 }


    public FragmentPerson() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_person,container,false);

        mLvPersons=(ListView)view.findViewById((R.id.listView));
        adapter = new PersonAdapter(getActivity(), persons);
        mLvPersons.setAdapter(adapter);
        mLvPersons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                person=(Person) adapterView.getItemAtPosition(i);
                listener.showPerson(person.toString());
            }
        });
        return view;
    }


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        persons=new ArrayList<>();
        persons.add(new Person(15,"Bert"));
        persons.add(new Person(15,"Karel"));
        persons.add(new Person(15,"Peter"));
        persons.add(new Person(15,"Sjonnie"));


    }


}

package hello.intec.be.multifragmentsapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import hello.intec.be.multifragmentsapp.fragments.FragmentDetail;
import hello.intec.be.multifragmentsapp.fragments.FragmentPerson;


public class MainActivity extends ActionBarActivity implements FragmentPerson.OnPersonSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    public void showPerson(String person) {

        FragmentDetail detail =(FragmentDetail) getFragmentManager().findFragmentById(R.id.fragment2);

        if (detail != null && detail.isInLayout()){
            detail.setText(person);
        }else {
            Intent intent = new Intent(this,DetailActivity.class);
            intent.putExtra("person",person);

            startActivity(intent);
        }
    }
}

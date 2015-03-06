package hello.intec.be.multifragmentsapp.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hello.intec.be.multifragmentsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetail extends Fragment {

    private TextView mTxtvDetail;

    public FragmentDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v=inflater.inflate(R.layout.fragment_detail,container,false);

        return v;
    }

    public void setText(String person){

        mTxtvDetail=(TextView) getView().findViewById(R.id.txtv_detail);
        mTxtvDetail.setText(person);
    }


}

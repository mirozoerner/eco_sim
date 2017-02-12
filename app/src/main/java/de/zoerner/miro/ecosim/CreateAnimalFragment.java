package de.zoerner.miro.ecosim;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CreateAnimalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CreateAnimalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateAnimalFragment extends DialogFragment {
    private OnFragmentInteractionListener mListener;
    private MapActivity map;

    public CreateAnimalFragment() {
    }

    public void setMap(MapActivity map) {
        this.map= map;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CreateAnimalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateAnimalFragment newInstance(String param1, String param2) {
        CreateAnimalFragment fragment = new CreateAnimalFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v= inflater.inflate(R.layout.fragment_create_animal, container, false);
        final DialogFragment This= this;

        final RadioButton  bunny= (RadioButton) v.findViewById(R.id.bunny);
        final RadioButton  fox= (RadioButton) v.findViewById(R.id.fox);
        bunny.setChecked(map.spawnBunny);
        fox.setChecked(map.spawnFox);
        Button ok= (Button) v.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.spawnBunny= bunny.isChecked();
                map.spawnFox= fox.isChecked();
                This.dismiss();
            }
        });

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

package com.example.langauge;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Numbers.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Numbers#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Numbers extends Fragment {
    //Add new variables
    private MediaPlayer mediaPlayer ;
    private AudioManager SoundManager;
    //private Handler handler = new Handler();
    AudioManager.OnAudioFocusChangeListener SoundChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {

                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Permanent loss of audio focus
                        // Pause playback immediately
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                      /*  mediaController.getTransportControls().pause();
                        // Wait 30 seconds before stopping playback
                        handler.postDelayed(delayedStopRunnable,
                                TimeUnit.SECONDS.toMillis(30));*/
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Pause playback
                        releaseMediaPlayer();

                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Lower the volume, keep playing
                        releaseMediaPlayer();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                        mediaPlayer.start();
                    }
                }
            };
    //making an object for the onOnCompletionListener
    private MediaPlayer.OnCompletionListener soundcompletionListener =new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer() ; }
    };
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Numbers() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Numbers.
     */
    // TODO: Rename and change types and number of parameters
    public static Numbers newInstance(String param1, String param2) {
        Numbers fragment = new Numbers();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        SoundManager=(AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE) ;

        final ArrayList<Words> word = new ArrayList<Words>();
        word.add(new Words("one", "lutti",R.drawable.number_one,R.raw.number_one));
        word.add(new Words("two", "otiiko",R.drawable.number_two,R.raw.number_two));
        word.add(new Words("three", "tolookosu",R.drawable.number_three,R.raw.number_three));
        word.add(new Words("four", "oyyisa",R.drawable.number_four,R.raw.number_four));
        word.add(new Words("five", "massokka",R.drawable.number_five,R.raw.number_five));
        word.add(new Words("six", "temmokka",R.drawable.number_six,R.raw.number_six));
        word.add(new Words("seven", "kenekaku",R.drawable.number_seven,R.raw.number_seven));
        word.add(new Words("eight", "kawinta",R.drawable.number_eight,R.raw.number_eight));
        word.add(new Words("nine", "wo’e",R.drawable.number_nine,R.raw.number_nine));
        word.add(new Words("ten", "na’aacha",R.drawable.number_ten,R.raw.number_ten));

        WordAdapter adapter =new WordAdapter(getActivity(),word,R.color.color_number);
        ListView listView =(ListView) rootView.findViewById(R.id.list) ;
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words tempword = word.get(position);
                releaseMediaPlayer();
                int result =SoundManager.requestAudioFocus(SoundChangeListener,
                        AudioManager.STREAM_MUSIC ,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT ) ;
                if (result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now
                    mediaPlayer = MediaPlayer.create(getActivity(), tempword.getSoundid());
                    mediaPlayer.start();
                    //Takes the object soundcompletionListener
                    mediaPlayer.setOnCompletionListener(soundcompletionListener);
                }
            }
        });

        return  rootView;

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
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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

    //Add new methods below

    private void  releaseMediaPlayer() {
        if (mediaPlayer!=null) {mediaPlayer.release();
            mediaPlayer=null;
            SoundManager.abandonAudioFocus(SoundChangeListener);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}

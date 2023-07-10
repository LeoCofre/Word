package cl.awakelab.word;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cl.awakelab.word.databinding.FragmentListBinding;


public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    private List<String> programmingLanguages = new ArrayList<>();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }


    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
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
        binding = FragmentListBinding.inflate(getActivity().getLayoutInflater(),container ,false);
        AdapterWords adapter = new AdapterWords();
        adapter.setData(getData());
        binding.listRv.setAdapter(adapter);
        binding.listRv.addItemDecoration(new DividerItemDecoration(binding.listRv.getContext(), DividerItemDecoration.VERTICAL));
        initListener();

        return binding.getRoot();
    }

    private void initListener() {
        binding.floatingActionButton.setOnClickListener(v -> {
        programmingLanguages.add(randomLanguages());
        binding.listRv.getAdapter().notifyItemInserted(programmingLanguages.size());
        binding.listRv.smoothScrollToPosition(programmingLanguages.size());
        });
    }

    private String randomLanguages(){
        List<String> languagesRandom = new ArrayList<>();
        languagesRandom.add("C#");
        languagesRandom.add("C");
        languagesRandom.add("Shell");
        languagesRandom.add("Rust");
        languagesRandom.add("Elixir");
        languagesRandom.add("Lua");
        languagesRandom.add("DM");
        languagesRandom.add("Clojure");
        languagesRandom.add("PowerShell");
        languagesRandom.add("CoffeeScript");
        languagesRandom.add("Haskell");
        languagesRandom.add("OCaml");
        languagesRandom.add("Emacs Lisp");
        languagesRandom.add("Vim script");
        languagesRandom.add("Jsonnet");
        languagesRandom.add("Erlang");
        languagesRandom.add("Puppet");
        languagesRandom.add("Smalltalk");

        int size = languagesRandom.size();
        Random random = new Random();
        int randomIndex =random.nextInt(size);

        return languagesRandom.get(randomIndex);
    }

    private List<String> getData() {
        programmingLanguages.add("Java");
        programmingLanguages.add("Kotlin");
        programmingLanguages.add("Phyton");
        programmingLanguages.add("Php");
        programmingLanguages.add("JavaScript");
        programmingLanguages.add("Go");
        programmingLanguages.add("C++");
        programmingLanguages.add("Ruby");
        programmingLanguages.add("TypeScript");
        programmingLanguages.add("Swift");
        programmingLanguages.add("Dart");
        programmingLanguages.add("Perl");
        programmingLanguages.add("Objetive-C");
        programmingLanguages.add("Groovy");
        programmingLanguages.add("R");
        programmingLanguages.add("Scala");

        return programmingLanguages;
    }
}
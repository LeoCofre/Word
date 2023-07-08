package cl.awakelab.word;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.awakelab.word.databinding.ItemBinding;

public class AdapterWords extends RecyclerView.Adapter<AdapterWords.ViewHolders> {


    private List<String> words;
    @NonNull
    //Creacion de viewHolder
    @Override
    public AdapterWords.ViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolders(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterWords.ViewHolders holder, int position) {
        String item = words.get(position);
        holder.showInformation(item);

    }

    @Override
    public int getItemCount() {
        return words.size();

    }

    public class ViewHolders extends RecyclerView.ViewHolder {

        private ItemBinding itemBinding;
        public ViewHolders(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;
        }
        public void showInformation(String words ){
        itemBinding.textView.setText(words);
        }
    }
}

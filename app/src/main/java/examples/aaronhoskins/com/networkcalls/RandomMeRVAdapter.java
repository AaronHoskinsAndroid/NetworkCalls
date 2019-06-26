package examples.aaronhoskins.com.networkcalls;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Locale;

import examples.aaronhoskins.com.networkcalls.model.randomme.Result;

public class RandomMeRVAdapter
        extends RecyclerView.Adapter<RandomMeRVAdapter.ViewHolder> {
    List<Result> listOfResults;

    public RandomMeRVAdapter(List<Result> listOfResults) {
        this.listOfResults = listOfResults;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.random_me_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Result itemResult = listOfResults.get(position);
        final String firstName = itemResult.getName().getFirst();
        final String lastName = itemResult.getName().getLast();
        final String name = String.format(Locale.US, "%s %s", firstName, lastName);
        final String email = itemResult.getEmail();
        final String gender = itemResult.getGender();
        final String imageURL = itemResult.getPicture().getThumbnail();
        holder.tvRandomUserName.setText(name);
        holder.tvRandomUserEmail.setText(email);
        holder.tvRandomUserGender.setText(gender);
        Glide
                .with(holder.imgRandomUserPic)
                .load(imageURL)
                .into(holder.imgRandomUserPic);
    }

    @Override
    public int getItemCount() {
        return listOfResults.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgRandomUserPic;
        TextView tvRandomUserName;
        TextView tvRandomUserEmail;
        TextView tvRandomUserGender;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRandomUserPic = itemView.findViewById(R.id.imgRandomUserImage);
            tvRandomUserName = itemView.findViewById(R.id.tvName);
            tvRandomUserEmail = itemView.findViewById(R.id.tvEmail);
            tvRandomUserGender = itemView.findViewById(R.id.tvGender);
        }
    }
}

package com.example.cakeshopip;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends FirebaseRecyclerAdapter<Cake,MyAdapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */

    public MyAdapter(@NonNull FirebaseRecyclerOptions<Cake> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyAdapter.myViewHolder holder, int position, @NonNull Cake model) {
        holder.name.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.detail.setText("");

        Glide.with(holder.image.getContext())
                .load(model.getImage())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.image);

    }

    @NonNull
    @Override
    public MyAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cakelist,parent,false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        CircleImageView image;
        TextView name,price;
        Button btnToDetail;
        TextView detail;

        public myViewHolder(@NonNull View itemView)  {
            super(itemView);
            image=(CircleImageView) itemView.findViewById(R.id.cakeImage);
            name=(TextView) itemView.findViewById(R.id.txtName);
            price=(TextView) itemView.findViewById(R.id.txtPrice);
            detail=(TextView)itemView.findViewById(R.id.txtDetail);

            btnToDetail=(Button)itemView.findViewById(R.id.btnToDetail);
            btnToDetail.setOnClickListener(this);
        }
        @Override
        public void onClick(View view){
            Cake cake=getItem(getAdapterPosition());

            Context context=view.getContext();

            Intent i=new Intent(context,DetailActivity.class);

            i.putExtra("name",cake.getName());
            i.putExtra("price",cake.getPrice());
            i.putExtra("image",cake.getImage());
            i.putExtra("detail",cake.getDetail());
            context.startActivity(i);

        }

    }

}

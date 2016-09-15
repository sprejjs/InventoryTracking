package com.spreys.inventorytracking.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spreys.inventorytracking.IViewHolderClickListener;
import com.spreys.inventorytracking.R;
import com.spreys.inventorytracking.data.MockDataProvider;
import com.spreys.inventorytracking.data.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProductsAdapter(MockDataProvider.GetMockData(), this));
    }

    class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> implements IViewHolderClickListener {
        private List<Product> products;
        private Context context;

        public ProductsAdapter(List<Product> products, Context context) {
            this.products = products;
            this.context = context;
        }

        @Override
        public ProductsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.product_item, parent, false), this);
        }

        @Override
        public void onBindViewHolder(ProductsAdapter.ViewHolder holder, int position) {
            Product product = products.get(position);

            holder.title.setText(product.getName());
            holder.quantity.setText(product.getQuantityDescription());
            holder.price.setText(product.getPriceDescription());
        }

        @Override
        public int getItemCount() {
            return products.size();
        }

        @Override
        public void onTrackSale(int itemPosition) {
            Product soldProduct = products.get(itemPosition);
            if (soldProduct.sellItem()) {
                notifyItemChanged(itemPosition);
            }
        }

        @Override
        public void onProductSelected(int itemPosition) {
            Intent intent = new Intent(context, DetailsActivity.class);
//            intent.putExtra
            startActivity(intent);
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            IViewHolderClickListener clickListener;

            @BindView(R.id.product_item_title)
            public TextView title;

            @BindView(R.id.product_item_price)
            public TextView price;

            @BindView(R.id.product_item_quantity)
            public TextView quantity;

            @OnClick(R.id.product_item_track_sale_button)
            public void sellItem() {
                clickListener.onTrackSale(getAdapterPosition());
            }

            @OnClick(R.id.product_item_frame)
            public void selectProduct() {
                clickListener.onProductSelected(getAdapterPosition());
            }

            public ViewHolder(View view, IViewHolderClickListener clickListener) {
                super(view);
                this.clickListener = clickListener;
                ButterKnife.bind(this, view);
            }
        }
    }
}

package com.ihaveu.bc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ihaveu.bc.R;
import com.ihaveu.bc.widget.DTextView;


/**
 * Created by bc on 16/10/27.
 * Describe
 */
public class ColorFragment extends Fragment{
  private RecyclerView mListRecycler;
  private LinearLayoutManager mLinearLayoutManager;
  private String[] s =new String[]{"品牌","男士","女士","家居","东方","男士","女士","家居","东方","男士","女士","家居","东方","男士","女士","家居","东方","男士","女士","家居","东方","男士","女士","家居","东方","男士","女士","家居","东方"};
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_color,null);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mListRecycler = (RecyclerView) view.findViewById(R.id.list);
    mLinearLayoutManager = new LinearLayoutManager(getActivity());
    mListRecycler.setLayoutManager(mLinearLayoutManager);
    mListRecycler.setAdapter(new BrandIndexAdapter());
  }
  public class BrandIndexAdapter extends RecyclerView.Adapter<BrandIndexAdapter.TextHolder>{

    @Override
    public TextHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_item,parent,false);
      return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(BrandIndexAdapter.TextHolder holder, int position) {
      holder.mInitialText.setText(s[position]);
    }

    @Override
    public int getItemCount() {
      return s.length;
    }

    public class TextHolder extends RecyclerView.ViewHolder{
      TextView mInitialText;
      public TextHolder(View itemView) {
        super(itemView);
        mInitialText = (TextView) itemView.findViewById(R.id.initialText);

      }
    }
  }
}

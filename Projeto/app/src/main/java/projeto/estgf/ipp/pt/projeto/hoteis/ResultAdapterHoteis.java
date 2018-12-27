package projeto.estgf.ipp.pt.projeto.hoteis;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import projeto.estgf.ipp.pt.projeto.R;


public class ResultAdapterHoteis extends RecyclerView.Adapter<ResultViewHolderHoteis>  {
    private Context context;
    private ArrayList<DatumHoteis> list;


    public ResultAdapterHoteis(Context context){
        this.context=context;
        list=new ArrayList<DatumHoteis>();
    }

    public synchronized void setList (ArrayList<DatumHoteis> list) {
        this.list=list;

    }

    @NonNull
    @Override
    public ResultViewHolderHoteis onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View resultView = inflater.inflate(R.layout.row_layout_search_hoteis, viewGroup, false);


        return new ResultViewHolderHoteis(resultView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolderHoteis resultViewHolder, int i){
        DatumHoteis temp = list.get(i);

        TextView textView = resultViewHolder.textView;
        TextView textView1 = resultViewHolder.textView1;
        TextView textView2 = resultViewHolder.textView2;

        textView.setText(temp.getType());
        textView1.setText(temp.getHotel().getName());
        textView2.setText(temp.getHotel().getChainCode());



    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public void addItems(List<DatumHoteis> x){
        list.addAll(x);
        notifyDataSetChanged();
    }


}
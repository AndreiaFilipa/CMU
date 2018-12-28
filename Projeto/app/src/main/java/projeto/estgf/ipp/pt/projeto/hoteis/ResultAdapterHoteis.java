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

<<<<<<< HEAD:Projeto/app/src/main/java/Hoteis/ResultAdapterHoteis.java
        View resultView = inflater.inflate(R.layout.row_layout_search_voos, viewGroup, false);
=======
        View resultView = inflater.inflate(R.layout.row_layout_search_hoteis, viewGroup, false);

>>>>>>> 44301a85cdecab2f0d7af0b9c71dc391dbd5a464:Projeto/app/src/main/java/projeto/estgf/ipp/pt/projeto/hoteis/ResultAdapterHoteis.java

        return new ResultViewHolderHoteis(resultView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolderHoteis resultViewHolder, int i){
        DatumHoteis temp = list.get(i);

        TextView tipo = resultViewHolder.textView;
        TextView nome = resultViewHolder.textView1;
        TextView chainCode = resultViewHolder.textView2;

        tipo.setText(temp.getHotel().getType());
        nome.setText(temp.getHotel().getName());
        chainCode.setText(temp.getHotel().getChainCode());



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

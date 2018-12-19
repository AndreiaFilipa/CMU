package projeto.estgf.ipp.pt.projeto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

public class ResultAdapter extends RecyclerView.Adapter<ResultViewHolder> {

    private Context context;
    private ArrayList<Datum> list;


    public ResultAdapter(Context context){
        this.context=context;
        list=new ArrayList<Datum>();

    }

    public synchronized void setList (ArrayList<Datum> list) {
        this.list=list;

    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View resultView = inflater.inflate(R.layout.row_layout_search_flight, viewGroup, false);

        return new ResultViewHolder(resultView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder resultViewHolder, int i){
        Datum temp = list.get(i);

        TextView textView = resultViewHolder.textView;

        textView.setText(temp.getId());
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public void addItems(List<Datum> x){
        list.addAll(x);
        notifyDataSetChanged();
    }



}

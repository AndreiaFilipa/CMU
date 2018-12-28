package projeto.estgf.ipp.pt.projeto;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultViewHolder> {

    private Context context;
    private boolean b;
    private ArrayList<Datum> list;
    private ArrayList<Service> services;
    private InformacoesVoo informacoesVoo;

    public ResultAdapter(Context context, boolean b){
        this.context=context;
        this.b = b;
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

        View resultView = inflater.inflate(R.layout.row_layout_search_voos, viewGroup, false);

        return new ResultViewHolder(resultView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder resultViewHolder, int i){
        Datum temp = list.get(i);
        OfferItem x = temp.getOfferItems().get(0);
        TextView preco = resultViewHolder.preco;
        TextView tipo = resultViewHolder.tipo;
        TextView idResultado = resultViewHolder.idResultado;


        preco.setText(x.getPrice().getTotal());
        tipo.setText(temp.getType());
        idResultado.setText(temp.getId());
        services = (ArrayList<Service>) x.getServices();
        informacoesVoo= new InformacoesVoo();
        informacoesVoo.id=temp.getId();
        informacoesVoo.preco=x.getPrice().getTotal();
        informacoesVoo.tipo=temp.getType();

        resultViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(context, Voo.class);

                intent.putExtra("prr",services);
<<<<<<< HEAD
                intent.putExtra("voo",informacoesVoo);

                //intent.putExtra("IdaVolta",true);
=======
                intent.putExtra("IdaVolta",b);
>>>>>>> fbd1b2959c8deb22ba0f233765192fa6e213c599
                context.startActivity(intent);
            }
        });
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

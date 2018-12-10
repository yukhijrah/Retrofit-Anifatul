package antanina.app.portalti2016.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import antanina.app.portalti2016.R;
import antanina.app.portalti2016.entity.Mahasiswa;
import antanina.app.portalti2016.holder.MahasiswaHolder;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaHolder> {

    private List<Mahasiswa> mahasiswas;
    private MahasiswaListener listener;

    public MahasiswaAdapter(List<Mahasiswa> mahasiswas, MahasiswaListener listener) {
        this.mahasiswas = mahasiswas;
        this.listener = listener;
    }

    public MahasiswaAdapter(List<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }

    public void setListener(MahasiswaListener listener) {
        this.listener = listener;
    }
    @NonNull
    @Override
    public MahasiswaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa,parent, false);
        final MahasiswaHolder mahasiswaHolder = new MahasiswaHolder(itemView);
        return mahasiswaHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaHolder holder, final int position) {
        holder.txtName.setText(mahasiswas.get(position).getName());
        holder.txtNim.setText(mahasiswas.get(position).getNim());
        //fungsi delete
        holder.btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listener.onDelete(mahasiswas.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mahasiswas.size();
    }
    public interface MahasiswaListener {
        void onDelete(int mhsId);
    }
}

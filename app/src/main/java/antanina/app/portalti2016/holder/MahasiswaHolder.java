package antanina.app.portalti2016.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import antanina.app.portalti2016.R;

public class MahasiswaHolder extends RecyclerView.ViewHolder {

    public TextView txtName;
    public TextView txtNim;
    public Button btnDelete;

    public MahasiswaHolder(@NonNull View itemView) {
        super(itemView);
        txtName = (TextView) itemView.findViewById(R.id.txt_nama);
        txtNim = (TextView) itemView.findViewById(R.id.txt_nim);
        btnDelete = (Button) itemView.findViewById(R.id.btn_delete);

    }
}

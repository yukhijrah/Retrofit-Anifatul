package antanina.app.portalti2016;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import antanina.app.portalti2016.adapter.MahasiswaAdapter;
import antanina.app.portalti2016.entity.DaftarMahasiswa;
import antanina.app.portalti2016.network.Network;
import antanina.app.portalti2016.network.Routes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView lstMahasiswa;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstMahasiswa = (RecyclerView) findViewById(R.id.lst_mahasiswa);

        lstMahasiswa.setLayoutManager(new LinearLayoutManager(this));
        requestDaftarMahasiswa();

    }

    @Override
    protected void onStart() {
        super.onStart();
        requestDaftarMahasiswa();
    }

    private void requestDaftarMahasiswa() {
        //1.  memanggil request() dari retrofit yang sudah dibuat
        Routes services = Network.request().create(Routes.class);
        // 2. melakukan request terhadap getMahasiswa()
        services.getMahasiswa().enqueue(new Callback<DaftarMahasiswa>() {
            @Override
            public void onResponse(Call<DaftarMahasiswa> call, Response<DaftarMahasiswa> response) {
               // mengecek request yg dilakukan berhasil atau tidak
               if(response.isSuccessful()) {
                   // casting data yang didapatkan menjadi DaftarMahasiswa
                   DaftarMahasiswa mahasiswas = response.body();
                    //get title
                   Log.d("TI16",mahasiswas.getTitle());

                   //tampilkan daftar mahasiswa di recycler view
                   MahasiswaAdapter adapter = new MahasiswaAdapter(mahasiswas.getData());
                   lstMahasiswa.setAdapter(adapter);

               }
            }

            @Override
            public void onFailure(Call<DaftarMahasiswa> call, Throwable t) {

            }
        });
    }
}

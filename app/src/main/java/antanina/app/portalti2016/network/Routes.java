package antanina.app.portalti2016.network;

import antanina.app.portalti2016.entity.DaftarMahasiswa;
import antanina.app.portalti2016.entity.Mahasiswa;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Routes {
    // untuk melakukan post data mahasiswa baru, jika dideskripsikan berarti di https://herokuapp.com/list.php
    @GET("dev/list_mahasiswa")
    Call<DaftarMahasiswa> getMahasiswa();
    // untuk melakukan post data mahasiswa baru, jika dideskripsikan berarti di https://herokuapp.com/add.php
    @POST("dev/insert_mahasiswa")
    @FormUrlEncoded
    Call<Mahasiswa> postMahasiswa(
            @Field("name") String name,
            @Field("nim") String nim
    );
    @DELETE ("mahasiswatest/{mhsId}")
    Call<Mahasiswa> deleteMahasiswa(
      @Path("mhsId") String mhsId //@path untuk mendinamiskan url yang ada di
    );
}

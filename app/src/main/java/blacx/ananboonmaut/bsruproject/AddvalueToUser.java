package blacx.ananboonmaut.bsruproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Process;
import android.speech.tts.Voice;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by Poyopoyo on 10/2/2560.
 */

public class AddValueToUser extends AsyncTask<String, Void, String> {
    //Explicit จะประกาศตัวแปร
    private Context context;
    private String nameString, userString, passString, imageString, avataString;
    private ProgressDialog progressDialog;
    public AddValueToUser(Context context,
                          String nameString,
                          String userString,
                          String passString,
                          String imageString,
                          String avataString) {
        this.context = context;
        this.nameString = nameString;
        this.userString = userString;
        this.passString = passString;
        this.imageString = imageString;
        this.avataString = avataString;


    }  // Constrator

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "Upload Value",
                "Please Wait Few Minis...");

    }

    @Override
    protected String doInBackground(String... strings) {

        try {


            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isadd", "true")
                    .add("Name", nameString)
                    .add("User", userString)
                    .add("Password", passString)
                    .add("Image", imageString)
                    .add("Avata", avataString)
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[0]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        } catch (Exception e) {
            Log.d("10febV2", "e doin ==>" + e.toString());
            return null;
        }



    }
}  //Main Class

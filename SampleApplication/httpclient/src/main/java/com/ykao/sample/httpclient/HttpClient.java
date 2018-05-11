package com.ykao.sample.httpclient;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpClient implements Callback {
    public void getWithUrlString(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(this);
    }

    @Override
    public void onFailure(Call call, IOException e) {
        System.out.println("onFailure");
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        System.out.println("Status code: " + response.code());
        System.out.println("Body: " + response.body().string().substring(0, 19) + "...");
    }

}

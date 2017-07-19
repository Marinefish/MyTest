package MyTest;

import okhttp3.*;

import java.io.InputStream;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/7/19
 * Time: 9:02
 */
public class TestFun {
    public static void main(String[] args) throws Exception{
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/octet-stream");
        RequestBody body = RequestBody.create(mediaType, "{\"collectionName\":\"crawler_content_parser\"}");
        Request request = new Request.Builder()
                .url("http://www.zakibook.com/wp-content/uploads/2017/06/19225415_1170436906418618_2006367296928668551_n.jpg")
                .get()
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "40978e1b-4d09-f07b-aa9c-daa4f9847701")
                .build();

        Response response = client.newCall(request).execute();
        InputStream inputStream =response.body().byteStream();
    }
}

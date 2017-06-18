package Nabd;

import com.squareup.okhttp.*;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/6/9
 * Time: 20:33
 */
public class Follow {
    public static void main(String[] args) throws Exception{
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        RequestBody body = RequestBody.create(mediaType, "{\"collectionName\":\"crawler_content_parser\"}");
        Request request = new Request.Builder()
            .url("https://3203498-appengine.com/app/android_follow_source.php?source_id=1002&hash=8fc3ff64441c3094423d846b563e22d4&user_id=16367529&app_version=5.6&device=1&sn=c85b7641ec3d2775&t=0&salt=5726ece35eeeba74ff06e27f74eea020&w=480&h=853&r=1497011433920&age=&gender=0&nationality=0&test=0&u_id=&token=fB40OCh3QwU%3AAPA91bF_Eq1LJ6GFbfZQk2DJqWp1ttfsDVD5KjaK3iUKWptXQ4FKsSzX8dlmOYkmxGPyWS_RK37v0uJpWJp19a8uK5lKDkSgV6o-Gkdq0moxQgFtwd5Oe2Go4Pegs3E0cRmTZoxmhzyK&os_v=4.4.2&brand=vivo&manufacturer=BBK&model=vivo%20S7i(t)&product=bbk72_t_jb3&andi=eb72021a-cd53-49a1-a84e-6d644ff81ae9&limit_ad=0&google=0&mobo=0&fbApp=0&tw=0&so=0&ta=0&ma=0&na=0&hc=0&sho3=0&night=0&ipk=com.android.vending&signature=pCFE1K6yfJVgjYLkUzSAZGbp4RQ%3D%0A")
            .get()
            .addHeader("content-type", "application/json;charset=UTF-8")
            .addHeader("cache-control", "no-cache")
            .addHeader("postman-token", "8b5438bb-6f18-5b43-6040-c837832d3631")
            .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}

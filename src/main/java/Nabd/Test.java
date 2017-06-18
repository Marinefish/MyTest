package Nabd;

import Nabd.domain.Article;
import com.google.gson.Gson;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/6/10
 * Time: 16:56
 */
public class Test {
    public static void main(String[] args) {
        String str = "{\"sourceId\":\"350\",\"sourceName\":\"البوابة العربية للأخبار التقنية\",\"sourceImageUrl\":\"https://pbs.twimg.com/profile_images/2555602645/g8cmwyt7j2qdm6ujizhs_bigger.jpeg\",\"hideSourceLogo\":\"0\",\"hideInsideSourceLogo\":\"0\",\"articleId\":\"42692538\",\"articleUrl\":\"http://nabdapp.com/original_story.php?aid=42692538\",\"articleTitle\":\"نصائح لتجنب التطبيقات الخبيثة على أندرويد \",\"articleSharingTitle\":\"نصائح لتجنب التطبيقات الخبيثة على أندرويد \",\"forceOpenAsArticle\":\"1\",\"articleBody\":\"في الكثير من الأحيان تسبب التطبيقات الخبيثة والوهمية على أندرويد الكثير من الأضرار لهواتفنا وتجعلها عديمة الفائدة.~وتتنوع أنواع هذه التطبيقات والطرق التي يتبعها أصحابها للإضرار بهواتف المستخدمين، سواءً تلك المطروحة على متجر جوجل بلاي أو خارجه.~لذا في هذا الموضوع نُقدم لكم 6 نصائح لتجنب التطبيقات الخبيثة على أندرويد:~لا تعتمد إطلاقاً في تنزيل التطبيقات على أي جهات خارجية أو تطبيقات طرف ثالث، والتي لا تتخذ نفس التدابير والإجراءات الأمنية الموجودة في جوجل بلاي.~لا يعني هذا أن متجر جوجل بلاي لا يتضمن أي تطبيقات خبيثة، لكن عبر اتباعك للنصائح الأخرى في هذا الموضوع سيكون من السهل عليك تمييز أغلب التطبيقات الخبيثة على جوجل بلاي.~الكثير من ناشري التطبيقات الخبيثة يعتمدون على استغلال أسماء التطبيقات والألعاب الشهيرة ونشرها في متجر جوجل بلاي، وبالتالي يقوم الكثير من المستخدمين بتنزيل هذه التطبيقات المقلدة ظناً منهم أنها التطبيقات الرسمية من المطور.~لذا من المهم جداً قبل تنزيل أي تطبيق.....~لقراءة المقال بالكامل، يرجى الضغط على زر \\\"إقرأ على الموقع الرسمي\\\" ادناه.\",\"articlePubDate\":\"2017-06-10 10:00:31\",\"articleDetailedDate\":\"السبت، ١٠ يونيو / حزيران ٢٠١٧\",\"articleBreaking\":\"0\",\"articleHits\":\"0\",\"articleVideoUrl\":[],\"articleImageUrl\":\"https://pbs.twimg.com/media/DB8QJt4UIAAgO92.jpg\",\"youtubeBaseURL\":\"http://www.youtube.com/watch?v=\",\"autoPlayVideo\":\"0\",\"favorited\":\"0\",\"articleComments\":\"0\",\"showComments\":\"0\",\"showViews\":\"0\",\"social\":\"1\",\"alignment\":\"right\",\"sharingScreen\":\"@NabdApp\",\"twitterSignature\":\"- عبر نبض\",\"sharingSignature\":\"- عبر تطبيق نبض\",\"whatsappSignature\":\"~~عبر تطبيق نبض~http://bit.ly/1e9lzDy\",\"moreSocialNetworksSignature\":\"~~تم نشر هذا الخبر من خلال تطبيق \\\"نبض\\\" للآندرويد والآيفون. اضغط لتحميل التطبيق مجاناً~http://bit.ly/1e9Bx0p\",\"shareWhatsAppInsideApp\":\"0\",\"tweetLength\":\"140\",\"tweetLinkLength\":\"30\",\"showCopyLink\":\"1\",\"srcNameWhenShare\":\"1\",\"promoted\":\"0\",\"canShare\":\"1\",\"canComment\":\"1\",\"canFavorite\":\"1\",\"sharingUrl\":\"http://nabdapp.com/t/42692538\",\"flag\":\"XYZ\",\"rtlMark\":\"0\",\"trackArticle\":\"1\",\"clickableSource\":\"1\",\"sourceArticlesUrl\":\"https://3203498-appengine.com/app/v1.3/articles_by_source.php?source_id=350&\",\"imageHeight\":\"140\",\"dim\":\"1\",\"moreFromThisSource\":\"1\",\"showBottomBar\":\"1\",\"commentMaxChars\":\"700\",\"promotedOpenInSafari\":\"0\",\"openInSFSafari\":\"0\",\"sfSafariOpenReaderView\":\"0\"}";
        Gson gson = new Gson();
        Article article = gson.fromJson(str,Article.class);
        System.out.println(gson.toJson(article));
    }

}

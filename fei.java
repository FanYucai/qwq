import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class fei {


//	static String url="http://www.cnblogs.com/zyw-205520/archive/2012/12/20/2826402.html";
	static String url="http://www.baidu.com";
	
	/**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
//    	article();
    	custom();
//    	blog();
    }

    

    /**
     * 获取指定HTML 文档指定的body
     * @throws IOException
     */
    private static void blogBody() throws IOException {
    	
        // 直接从字符串中输入 HTML 文档
        String html = "<html><head><title> 开源中国社区 </title></head>"
                + "<body><p> 这里是 jsoup 项目的相关文章 </p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc.body());
        
        
        // 从 URL 直接加载 HTML 文档
        Document doc2 = Jsoup.connect(url).get();
        String title = doc2.body().toString();
        System.out.println(title);
    }

    /**
     * 获取网页中超链接的标题和链接
     */
    public static void article() {
        Document doc;
        try {
            doc = Jsoup.connect("http://news.baidu.com/ns?ct=0&rn=20&ie=utf-8&bs=%E6%88%90%E5%93%81%E6%B2%B9%E4%BB%B7&rsv_bp=1&sr=0&cl=2&f=8&prevct=no&tn=newstitle&word=%E6%88%90%E5%93%81%E6%B2%B9%E4%BB%B7").get();
            Elements ListDiv = doc.getElementsByAttributeValue("class","c-title");
            
            for (Element element : ListDiv) {
//            	System.out.println(element.html());
            	System.out.println("----------------");
                Elements links = element.getElementsByTag("a");
                for (Element link : links) {
                    String linkHref = link.attr("href");
                    String linkText = link.text().trim(); //trim(): delete \\s　at the beginning and ending

                    System.out.println(linkHref);
                    System.out.println(linkText);

//                    System.out.println(link.html());
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    /**
     * 获取指定博客文章的内容
     */
    public static void blog() {
        Document doc;
        try {
        	doc = Jsoup.connect(url).get();
        	System.out.println(doc.html());
            Elements ListDiv = doc.getElementsByAttributeValue("target", "_blank");
            for (Element element :ListDiv) {
                System.out.println(element.html());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public static void custom() {
    	Document doc;
    	try {
    		doc = Jsoup.connect(url).get();
    		System.out.println(doc.html());
    		Elements elements = doc.getElementsByTag("title");
    		for(Element element : elements) {
    			System.out.println(element.html());
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

}
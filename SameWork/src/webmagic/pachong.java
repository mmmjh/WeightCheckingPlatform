package webmagic;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.hankcs.hanlp.HanLP;
import dao.ContImp;;
	public class pachong {
		public static void main(String[] args) throws Exception {
			String[] title=new String[] {"互联网+","三网融合","数字城市","电子政府","虚拟现实","增强现实" };
			for (int i=0;i<title.length;i++) {
			String oInfos=getWuMaoW(title[i]);
			System.out.println(title[i]+":"+oInfos);
			}
			
		}
	 
		// ȡhttps://baike.baidu.com/item
		public static String getWuMaoW(String word) {
			String url = "https://baike.baidu.com/item/"+word;
			Document doc = null;
			String ptext="";
			try {
				doc = Jsoup.connect(url).get();	
				Elements listDiv = doc.getElementsByAttributeValue("class", "lemma-summary");
					Element texts = listDiv.get(0).getElementsByTag("div").get(0);
					 ptext = texts.text();
					//System.out.println("标题" + ptext);
					System.out.println("---------------------------------------------");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ptext;
	
		}
	 
	}
package me.xiaosheng.word2vec;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.ansj.vec.domain.WordEntry;

import me.xiaosheng.util.Segment;
import dao.ContImp;
import model.Allcontent;
public class Test {
    public static void main(String[] args) throws Exception {
        Word2Vec vec = new Word2Vec();
        try {
            vec.loadGoogleModel("data/wiki_chinese_word2vec(Google).model");
        } catch (IOException e) {
            e.printStackTrace();
        }    
        ContImp contImp=new ContImp();       
    	List<Allcontent> cons=contImp.search1();   	
		for(int i=0;i<1;i++){
        //计算句子相似度
        System.out.println("第"+cons.get(i).getId());
        String s1 = cons.get(i).getContent();
        String s2 = cons.get(i).getBaidu();
        //System.out.println(cons.get(i).getContent()+"\n"+cons.get(i).getBaidu());
        //分割
        String [] resultju=new String[20];
        for(int r=0;r<resultju.length;r++)
        	resultju[r]="";
        String[] sourceStrArray1 = s1.split("。");
        String[] sourceStrArray2 = s2.split("。");
        for (int n1 = 0; n1 < sourceStrArray1.length; n1++) 
        {
        	for (int n2 = 0; n2 < sourceStrArray2.length; n2++)
        	{
        		//分词，获取词语列表
        		 System.out.println("分割句1：   "+sourceStrArray1[n1]);
                 System.out.println("分割句2：   "+sourceStrArray2[n2]);
                List<String> wordList1 = Segment.getWords(sourceStrArray1[n1]);
                List<String> wordList2 = Segment.getWords(sourceStrArray2[n2]);      
               // System.out.println("句子相似度(名词、动词权值设为1，其他设为0.8):");
                float[] weightArray1 = Segment.getPOSWeightArray(Segment.getPOS(sourceStrArray1[n1]));
                float[] weightArray2 = Segment.getPOSWeightArray(Segment.getPOS(sourceStrArray2[n2]));  
                System.out.println("s1|s2: " + vec.sentenceSimilarity(wordList1, wordList2, weightArray1, weightArray2)); 
                float f = (int)Math.round((vec.sentenceSimilarity(wordList1, wordList2, weightArray1, weightArray2))*1000)/1000f;
                //使相似度保留三位小数
                if(f>0.7)
                {
                	System.out.println("相似度高：  "+sourceStrArray1[n1]);
                	resultju[n1]=sourceStrArray1[n1];
                	break;
                } 
        	}
        }  
	 }
    System.out.println("完成");

  }
}

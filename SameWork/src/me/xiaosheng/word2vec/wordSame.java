package me.xiaosheng.word2vec;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.ansj.vec.domain.WordEntry;

import me.xiaosheng.util.Segment;

public class wordSame {

    public static void main(String[] args) throws Exception {
        Word2Vec vec = new Word2Vec();
        try {
            vec.loadGoogleModel("data/wiki_chinese_word2vec(Google).model");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //计算词语相似度
        System.out.println("-----词语相似度-----");
        System.out.println("狗|猫: " + vec.wordSimilarity("狗", "猫"));
        System.out.println("计算机|电脑: " + vec.wordSimilarity("计算机", "电脑"));
        System.out.println("计算机|人: " + vec.wordSimilarity("计算机", "人"));
        //计算句子相似度
        System.out.println("-----句子相似度-----");
        String s1 = "我爱中华人民，我爱我的祖国";
        String s2 = "我对我的祖国怀有深深的爱意。";
        String s3 = "我爱我的国家：中国";
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s3: " + s3);
        //分词，获取词语列表
        List<String> wordList1 = Segment.getWords(s1);
        List<String> wordList2 = Segment.getWords(s2);
        List<String> wordList3 = Segment.getWords(s3);
    	for(int i=0;i<wordList1.size();i++){
    		
    	}
        //快速句子相似度
       /* System.out.println("快速句子相似度:");
        System.out.println("s1|s1: " + vec.fastSentenceSimilarity(wordList1, wordList1));
        System.out.println("s1|s2: " + vec.fastSentenceSimilarity(wordList1, wordList2));
        System.out.println("s1|s3: " + vec.fastSentenceSimilarity(wordList1, wordList3));*/
       
    }
}

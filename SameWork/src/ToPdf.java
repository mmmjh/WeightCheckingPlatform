import java.awt.Color;import java.util.List;import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.ansj.vec.domain.WordEntry;

import me.xiaosheng.util.Segment;
import me.xiaosheng.word2vec.Word2Vec;
import dao.ContImp;
import model.Allcontent;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.util.List;

import model.Allcontent;
import dao.ContImp;
import java.io.File;
import java.io.FileOutputStream;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Chapter;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
public class ToPdf {
	private Color black = new Color(0, 0, 0); // 黑色
	private Color red = new Color(255, 0, 0); // 红色
	private Color blue = new Color(0, 0, 255); // 蓝色
	private int bold = Font.BOLD; // 粗体
	private int normal = Font.NORMAL; // 正常字体
	private int italic = Font.ITALIC; // 斜体
	private int boldItalic = Font.BOLDITALIC; // 粗斜体
	private float setting = 100; // 首行缩进参数
	public Document createDoc(String filename) throws Exception {
		// 新建document对象
		// 第一个参数是页面大小。接下来的参数分别是左、右、上和下页边距。
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		// 建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
		// 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
		PdfWriter.getInstance(document, new FileOutputStream(filename));
		return document;
	}
	public void writePdf(String filename) throws Exception {
		ContImp contImp=new ContImp();
		List<Allcontent> cons=contImp.search1();
		Document document = createDoc(filename); // 打开文档
		document.open(); // 文档里写入
		Paragraph centerPar = convertParToChinese("河北省信息技术手册检测", 23, normal, black);
		centerPar.setAlignment(Element.ALIGN_CENTER);
		document.add(centerPar); // 新建章节
		Paragraph centerPar1 = convertParToChinese("【PDF报告-大学生版】", 12, normal, black);
		centerPar1.setAlignment(Element.ALIGN_CENTER);
		document.add(centerPar1); // 新建章节
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		//表头
		document.add(convertParToChinese("            报告编号：42d24399ae45f987            检测时间：2019-04-09 00:21:18            检测字数：16,009字", 10, normal, black));
		document.add(new Paragraph("\n"));
		document.add(convertParToChinese("            作者名称：XXX                 所属单位：石家庄铁道大学软件工程专业           ", 10, normal, black));
		document.add(new Paragraph("\n"));
		document.add(convertParToChinese("    ======================================================", 14, normal, blue));
		document.add(convertParToChinese("\n            检测范围：\r\n" + 
				"            ◎ 百度百科           ◎ 搜狗百科         ◎ Word2Vec语料库\r\n" +  
				"            时间范围：不限\n\n", 10,normal, black));
		document.add(convertParToChinese("    ======================================================", 14, normal, blue));
		document.add(convertParToChinese("\n            检测结论：\r\n" + 
				"            全文总相似比：      14.63% （总相似比=复写率+他引率+自引率）\r\n" + 	
				"            自引率：      0% （引用自己已发表部分占全文的比重，请正确标注引用）\r\n" + 				 
				"            总相似片段：63\r\n" + 
				"            期刊：4 博硕：36 外文：2 综合：0 自建库：47 互联网：3\n\n", 10,normal, black));
		document.add(convertParToChinese("    ======================================================", 14, normal, blue));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		Paragraph centerPar3 = convertParToChinese("原文对照检测", 20, normal, red);
		centerPar3.setAlignment(Element.ALIGN_CENTER);
		document.add(centerPar3); // 新建章节
		Paragraph par = new Paragraph();
		document.add(convertParToChinese("\n            颜色标注说明：\r\n" + 
				"            ■自写片段\r\n",10,normal, black)); 
		Chunk chunk1 = new Chunk(convertChunkByChinese("           ■", 10, normal, red));
		Chunk chunk2 = new Chunk(convertChunkByChinese("复写片段（相似或疑似重复）",10, normal, black));
		par.add(chunk1);
		par.add(chunk2); // chunk将两行合并为一行显示
		document.add(par);
		document.add(convertParToChinese("    ----------------------------------------------------------------------------------------", 14, normal, black));
		document.add(convertParToChinese("            第一篇	新技术篇\r\n" + 
				"            第一章	信息化热词	1\r\n" + 
				"            1	互联网+	1\r\n" + 
				"            2	三网融合	1\r\n" + 
				"            3	数字城市	2\r\n" + 
				"            4	个人媒体时代	3\r\n" + 
				"            5	电子政府	4\r\n" + 
				"            6	虚拟现实（VR）	5\r\n" + 
				"            7	增强现实（AR）	5\r\n" + 
				"            8	自媒体	6\r\n" + 
				"            9	互联网数据中心（IDC）	6\r\n" + 
				"            10	虚拟专用网络（VPN）	7\r\n" + 
				"            11	办公自动化（OA）	7\r\n" + 
				"            12	企业资源计划（ERP）	8\r\n" + 
				"            13	二维码	8\r\n" + 
				"            14	交互式网络电视（IPTV）	9\r\n" + 
				"            15	可穿戴设备	10\r\n" + 
				"            16	共享经济	10\r\n" + 
				"            17	移动支付	11\r\n" + 
				"            18	智能硬件	11\r\n" + 
				"            19	智能家居	12\r\n" + 
				"            20	车联网	12\r\n" + 
				"            21	工业4.0	13\r\n" + 
				"            22	零售O2O	14\r\n" + 
				"            23	智慧农业	14\r\n" + 
				"            24	3D打印	15\r\n" + 
				"            第二章	大数据	16\r\n" + 
				"            25	大数据	16\r\n" + 
				"            26	分布式存储	16\r\n" + 
				"            27	数据挖掘	16\r\n" + 
				"            28	数据挖掘的基本任务	17\r\n" + 
				"            29	数据挖掘的基本技术	21\r\n" + 
				"            30	什么类型的数据可以进行挖掘？	23\r\n" + 
				"            31	数据可视化	23\r\n" + 
				"            32	为什么要进行数据预处理？	23\r\n" + 
				"            33	数据预处理的主要任务	24\r\n" + 
				"            34	数据仓库	25\r\n" + 
				"            35	数据仓库的特点	25\r\n" + 
				"            36	数据仓库的作用	26\r\n" + 
				"            37	操作数据库系统和数据仓库的区别	27\r\n" + 
				"            38	数据立方体	27\r\n" + 
				"            39	有哪些数据防护技术？	28\r\n" + 
				"            40	有哪些数据安全技术？	31\r\n" + 
				"            41	数据安全的特点有哪些？	33\r\n" + 
				"            42	企业可以通过哪些方法维护数据安全？	34\r\n" + 
				"            第三章	物联网	36\r\n" + 
				"            43	物联网	36\r\n" + 
				"            44	物联网的特性	37\r\n" + 
				"            45	感知中国	37\r\n" + 
				"            46	物联网的架构分为哪几层？	38\r\n" + 
				"            47	射频识别技术（RFID）	39\r\n" + 
				"            48	物联网的应用有哪些？	40\r\n" + 
				"            49	传感器	44\r\n" + 
				"            50	遥感技术	44\r\n" + 
				"            51	无线传感器网络（WSN）	45\r\n" + 
				"            52	第五代通信技术有哪些优势	46\r\n" + 
				"            53	5G的发展历程	46\r\n" + 
				"            54	目前5G的商用情况	52\r\n" + 
				"            第四章	云计算	53\r\n" + 
				"            55	云计算	53\r\n" + 
				"            56	云计算的特征	53\r\n" + 
				"            57	云计算有哪些优势？	54\r\n" + 
				"            58	云计算的供货商有哪些？	56\r\n" + 
				"            59	双机热备	57\r\n" + 
				"            ..........	58\r\n" +
				"            254	计算机信息网络进行国际联网的原则	277\r\n" , 10,normal, black));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		int lim=1;
		Word2Vec vec = new Word2Vec();
        try {
            vec.loadGoogleModel("data/wiki_chinese_word2vec(Google).model");
        } catch (IOException e) {
            e.printStackTrace();
        }   
		for(int m=0;m<cons.size();m++){
	        String s11 = cons.get(m).getContent();
	        String s21 = cons.get(m).getBaidu();
	        //System.out.println(cons.get(i).getContent()+"\n"+cons.get(i).getBaidu());
	        //分割
	        String [] resultju=new String[250];
	        for(int r=0;r<resultju.length;r++)
	        	resultju[r]="";
	        String[] sourceStrArray1 = s11.split("。");
	        String[] sourceStrArray2 = s21.split("。");
	       
	        if(sourceStrArray1.length!=1) //如果句子只是一句话就不分割直接查找最大子串即可
	        { 
	        	String titall=cons.get(m).getTitle00()+"       "+cons.get(m).getTitle01()+cons.get(m).getTitle02();
				document.add(convertParToChinese(titall,11,normal, black));
		      
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
		                System.out.println("s11|s21: " + vec.sentenceSimilarity(wordList1, wordList2, weightArray1, weightArray2)); 
		                float f = (int)Math.round((vec.sentenceSimilarity(wordList1, wordList2, weightArray1, weightArray2))*1000)/1000f;
		                //使相似度保留三位小数
		                if(f>0.75)
		                {
		                	System.out.println("相似度高：  "+sourceStrArray1[n1]);
		                	resultju[n1]=sourceStrArray1[n1];
		                	break;
		                } 
		        	}
		        }  
				int len=0;
				Paragraph pars1 = new Paragraph();
				for(int g=0;g<resultju.length;g++)//相似度高的句子的数组
				{
					if(resultju[g]!="")
						len++;
				}
				int pan=0;
				for(int kk=0;kk<sourceStrArray1.length;kk++)
				{
					for(int kk1=0;kk1<len;kk1++)
						if(sourceStrArray1[kk].equals(resultju[kk1]))
						{
							pan=1;
							break;
						}
					if(pan==0)
					{				
						Chunk chunk111 = new Chunk(convertChunkByChinese(sourceStrArray1[kk]+"。", 10, normal, black));
						pars1.add(chunk111);// chunk将两行合并为一行显示
					}
					if(pan==1)
					{			pan=0;	
						Chunk chunk111 = new Chunk(convertChunkByChinese(sourceStrArray1[kk]+"。", 10, normal, red));
						pars1.add(chunk111);// chunk将两行合并为一行显示
					}
				}
				document.add(pars1);
				document.add(convertParToChinese("对比相似度： "+cons.get(m).getSamenum(),15,normal, blue));
				
		        
	        }
	        else {
				String s1=cons.get(m).getContent();
				String s2=cons.get(m).getBaidu();
				String s=MaxSubstring(s1,s2);
				//System.out.println("s="+s+"长度："+s.length());	
				String str1="";
				String str2="";
				String str3="";
				for(int i=0;i<s1.indexOf(s);i++){  //找出出现字符串的位置
					str1+=s1.charAt(i); 
					}
				str2=s;
				for(int i=s1.indexOf(s)+s.length();i<s1.length();i++){ 
					str3+=s1.charAt(i); 
					}
				System.out.println(s1); 
				System.out.println("第一:     "+str1);     
				System.out.println("第er:   "+str2);
				System.out.println("第san:    "+str3);
				Paragraph par1 = new Paragraph();
				Chunk chunk11 = new Chunk(convertChunkByChinese(str1, 10, normal, black));
				Chunk chunk12 = new Chunk(convertChunkByChinese(str2,10, normal, red));
				Chunk chunk13 = new Chunk(convertChunkByChinese(str3,10, normal, black));
				par1.add(chunk11);
				par1.add(chunk12); 
				par1.add(chunk13);// chunk将两行合并为一行显示
				String titall=cons.get(m).getTitle00()+"       "+cons.get(m).getTitle01()+cons.get(m).getTitle02();
				document.add(convertParToChinese(titall,11,normal, black));
				document.add(par1);
				document.add(convertParToChinese("对比相似度： "+cons.get(m).getSamenum(),15,normal, blue));
			}
		}
		document.close();
	}
	public boolean checkFile(String path) {
		File file = new File(path);
		if (file.exists()) {
			return true;
		}
		return false;
	}
	public static Paragraph convertParToChinese(String text, int fontsize, int fontStyle, Color color)
			throws Exception {
		BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		Font fontChinese = new Font(baseFontChinese, fontsize, fontStyle, color);
		Paragraph graph = new Paragraph(text, fontChinese);
		return graph;
	}
	
	public Chunk convertChunkByChinese(String text, int fontsize, int fontStyle, Color color) throws Exception {
		BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		Font fontChinese = new Font(baseFontChinese, fontsize, fontStyle, color);
		Chunk chunk = new Chunk(text, fontChinese);
		return chunk;
	}
	private static String MaxSubstring(String s1,String s2){
		String max=null;
		String min=null;
		max=(s1.length()>s2.length())?s1:s2;
		min=max.equals(s1)?s2:s1;
		for (int i = 0; i <min.length(); i++) {
			for (int a = 0,b=min.length()-i; b!=min.length()+1; a++,b++) {
					String sub=min.substring(a, b);
					if(max.contains(sub))
						return sub;
			}
		}
		return null;//没有相同的子串，返回null
	  }
	public static void main(String[] args) throws Exception {
		ToPdf pdfDemo = new ToPdf();
		pdfDemo.writePdf("C:\\Users\\神奇的刘dd\\Desktop\\test1.pdf");
		System.out.println("ok");
	}

}
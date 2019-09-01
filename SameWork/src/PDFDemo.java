import java.awt.Color;
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
public class PDFDemo {
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
	public void writePdf(String filename, String imgPath) throws Exception {
		Document document = createDoc(filename); // 打开文档
		document.open(); // 文档里写入
		document.add(convertParToChinese("红色字体", 20, bold, red));
		document.add(new Paragraph("\n"));
		document.add(convertParToChinese("黑色", 18, boldItalic, black));
		document.add(new Paragraph("\n"));
		document.add(convertParToChinese("蓝色", 14, normal, blue));
		document.add(new Paragraph("\n"));
		// 文档写入图片
		if (checkFile(imgPath)) {
			Image image = writeImg(imgPath);
			document.add(image);
			document.add(new Paragraph("\n"));
		}
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n")); // 生成三列表格
		PdfPTable table = new PdfPTable(3); // 设置表格具体宽度
		table.setTotalWidth(90); // 设置每一列所占的长度
		table.setWidths(new float[] { 50f, 15f, 25f });
		PdfPCell cell1 = new PdfPCell();
		Paragraph para = new Paragraph("aaaaa");
		cell1.setPhrase(para);
		table.addCell(cell1);
		table.addCell(new PdfPCell(new Phrase("IText")));
		table.addCell(new PdfPCell(new Phrase("IText")));
		document.add(table);
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n")); // PDF同行显示
		Paragraph par = new Paragraph();
		Chunk chunk1 = new Chunk(convertChunkByChinese("考试分数：", 20, bold, black));
		Chunk chunk2 = new Chunk(convertChunkByChinese("93", 20, bold, red));
		par.add(chunk1);
		par.add(chunk2); // 设置整体缩进
		par.setFirstLineIndent(setting); // 居中
		Paragraph centerPar = convertParToChinese("剧中测试", 16, italic, black);
		centerPar.setAlignment(Element.ALIGN_CENTER);
		document.add(centerPar); // 新建章节
		// //节标题
		Paragraph chapterTitle = new Paragraph(convertParToChinese("章节标题", 18, boldItalic, blue));
		Chapter chapter1 = new Chapter(chapterTitle, 1);
		chapter1.setNumberDepth(0);
		for (int i = 0; i < 20; i++)
		{
			Paragraph p = new Paragraph((i + 1) + "test!!!!!");
			chapter1.add(p);
		}
		document.add(chapter1); // 5.关闭文档
		document.close();
	}
	public Image writeImg(String imgPath) throws Exception {
		Image img = Image.getInstance(imgPath); // 控制图片大小
		img.scaleAbsolute(100, 100);
		return img;
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
	public static void main(String[] args) throws Exception {
		PDFDemo pdfDemo = new PDFDemo();
		pdfDemo.writePdf("C:\\Users\\神奇的刘dd\\Desktop\\test.pdf",
				"C:\\Users\\神奇的刘dd\\Desktop\\ww.jpg");
		System.out.println("ok");
	}

}

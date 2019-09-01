

public class same {
 public static void main(String[] args) {
	// TODO 自动生成的方法存根
	String s1="算法（Algorithm）是指解决方案的准确而完整的描述，在计算机中表现为指令的有序序列，并且每条指令表示一个或多个操作。算法代表着用系统的方法描述解决问题的策略机制。简单来说，算法就是为了解决某个问题，而制定了一系列步骤。";
	String s2="算法（Algorithm）是指解题方案的准确而完整的描述，是一系列解决问题的清晰指令，算法代表着用系统的方法描述解决问题的策略机制。也就是说，能够对一定规范的输入，在有限时间内获得所要求的输出。如果一个算法有缺陷，或不适合于某个问题，执行这个算法将不会解决这个问题。不同的算法可能用不同的时间、空间或效率来完成同样的任务。一个算法的优劣可以用空间复杂度与时间复杂度来衡量。 算法中的指令描述的是一个计算，当其运行时能从一个初始状态和（可能为空的）初始输入开始，经过一系列有限而清晰定义的状态，最终产生输出并停止于一个终态。一个状态到另一个状态的转移不一定是确定的。随机化算法在内的一些算法，包含了一些随机输入。 形式化算法的概念部分源自尝试解决希尔伯特提出的判定问题，并在其后尝试定义有效计算性或者有效方法中成形。这些尝试包括库尔特·哥德尔、Jacques Herbrand和斯蒂芬·科尔·克莱尼分别于1930年、1934年和1935年提出的递归函数，阿隆佐·邱奇于1936年提出的λ演算，1936年Emil Leon Post的Formulation 1和艾伦·图灵1937年提出的图灵机。即使在当前，依然常有直觉想法难以定义为形式化算法的情况。";
	String s=MaxSubstring(s1,s2);
	System.out.println("s="+s+"长度："+s.length());	
	
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
}
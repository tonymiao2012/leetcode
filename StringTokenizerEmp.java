package leetcode;

import java.util.StringTokenizer;

public class CSVFileReader{
	public static String delimite = ",";
	static public void printStr(String str){
		StringTokenizer st = new StringTokenizer(str, delimite);
		StringBuilder sb = new StringBuilder();
		while(st.hasMoreTokens()){
			String cur = "";
			if(st.nextToken().startsWith("\"") && st.nextToken().endsWith("\"")){
				cur = st.nextToken().substring(1, st.nextToken().length() - 1);
			}else{
				cur = st.nextToken();
			}
			sb.append(cur + "|");
		}
		sb.deleteCharAt(sb.length() - 1);

		System.out.print(sb.toString());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "John,Smith,john.smith@gmail.com,Los Angeles,1"
				+ "Jane,Reberts,janer@msn.com,\"San Francisco, CA\",0"
				+ "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com, Miami,1"
				+ "one,two,,four,\"five\"";
		printStr(str);
	}
}
package leetcode;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.StringTokenizer;

public class CSVFileReader{
	public static String ReadIt(String s) throws IOException{
		if(s == null)	return null;
		StringReader sr = new StringReader(s);
		StringWriter sw = new StringWriter();
		char pre = 0;
		int len = s.length();
		int i = 0;
		while(i < len){
			char tmp = (char)sr.read();
			if(tmp == ','){
				tmp = '|';
			}
			if(tmp == '"' && pre != '"'){
				tmp = '\0';
				sw.append(tmp);
				pre = '"';
				i++;
				continue;
			}
			sw.append(tmp);
			pre = tmp;
			i++;
		}
		
		sr.close();
		sw.close();
		return sw.toString();
	}
	
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
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str = "John,Smith,john.smith@gmail.com,Los Angeles,1"
				+ "Jane,Reberts,janer@msn.com,\"San Francisco, CA\",0"
				+ "\"Alexandra \"\"Alex\"\",Menendez,alex.menendez@gmail.com, Miami,1"
				+ "one,two,,four,\"five\"";
		//printStr(str);
		System.out.println(ReadIt(str));
	}
}
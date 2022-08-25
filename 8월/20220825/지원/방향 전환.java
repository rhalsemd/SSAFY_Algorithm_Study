import java.io.*;
import java.util.*;
  
 
  
public class Solution {
   
    static int ans;
  
    public static void main(String[] args) throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         int TC=Integer.parseInt(br.readLine());
         for(int tc=1;tc<=TC;tc++) {
             StringTokenizer st=new StringTokenizer(br.readLine());
             int x1=Integer.parseInt(st.nextToken());
             int y1=Integer.parseInt(st.nextToken());
             int x2=Integer.parseInt(st.nextToken());
             int y2=Integer.parseInt(st.nextToken());
              
             //어차피 가로 세로 이동을 반복하므로 가야하는 높이*2 혹은 가야하는 너비*2
             int width=Math.abs(x1-x2);
             int height=Math.abs(y1-y2);
             int distance=Math.max(width, height)*2;
              
             //지그제그 이동이 짝이 맞는지 안맞는지...
             if((width+height)%2!=0) distance--;
             System.out.println("#"+tc+" "+distance);
         }
    }
      
      
      
}

package swexpert_20220822;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;
 
public class s2819 {
 
    static int N=4;
    static int T;
    static int [][] map;
    static int[] dr= {-1,0,1, 0};
    static int[] dc= { 0,1,0,-1};
    static TreeSet<String> ts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T=Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            map=new int[N][N];
            ts=new TreeSet<>();
            for (int i = 0; i < N; i++) {
            	st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }// 읽기 끝
            // 모든 지점에서 시작해 본다. 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    npir(i,j,0,new int[] {map[i][j],0,0,0,0,0,0});
                }
            }
            System.out.println("#"+t+" "+ts.size());
        }
    }
    private static void npir(int r, int c, int cnt, int[]nums) {
        if(cnt==6) {
            ts.add(Arrays.toString(nums));
            //System.out.println(Arrays.toString(nums));
            return ;
        }
        for (int d = 0; d < 4; d++) {
            int nr=r+dr[d];
            int nc=c+dc[d];
            if(!check(nr,nc)) continue;
            nums[cnt+1]=map[nr][nc];
            npir(nr,nc,cnt+1,nums);
            //nums[cnt+1]=0;
        }
    }
    private static boolean check(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }
}
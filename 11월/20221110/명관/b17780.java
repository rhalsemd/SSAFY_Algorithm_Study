package study20221110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b17780 {
	static class Horse{
	    int x,y,dir;
	    Horse(int x ,int y, int dir){
	        this.x=x;
	        this.y=y;
	        this.dir= dir;
	    }
	}
	static int n,k;
    static int dx[] = {10000,0,0,-1,1};
    static int dy[] = {10000,1,-1,0,0};
    static int map[][];
    static ArrayList<Integer>[][] map_horse_info;
    static Horse[] horse;
    static int ans = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new int[n+1][n+1];
        map_horse_info = new ArrayList[n+1][n+1];
        horse = new Horse[k+1];
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                map_horse_info[i][j] = new ArrayList<>();
            }
        }
        
        for(int i=1; i<=n; i++) {
        	st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<k; i++) {                
        	st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            horse[i+1] = new Horse(x,y,dir);
        }
        
        for(int i=1; i<=k; i++) {
            Horse tmp = horse[i];
            map_horse_info[tmp.x][tmp.y].add(i);
        }
        
        while(true) {
            if(ans>=1000) {
                System.out.println(-1);
                return ;
            }
            if(game_over()) {
                System.out.println(ans);
                break;
            }
            for(int i=1; i<=k; i++) {
                Horse move_horse = horse[i];
                if(isGoPossible(move_horse.x,move_horse.y,i)) {
                    go(i,move_horse.x,move_horse.y);
                }
            }
            ans++;
        }
    }
    public static boolean game_over() {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(map_horse_info[i][j].size()>=4) { //말이 4개쌓이는 순간 종료
                    return true;
                }
            }
        }
        return false;
    }

    public static void go(int num, int map_x, int map_y) {
        Horse go_horse = horse[num];
        int nx = go_horse.x+dx[go_horse.dir];
        int ny = go_horse.y+dy[go_horse.dir];
        if(!isRange(nx,ny) || map[nx][ny]==2) {//범위를 벗어나거나 파란 칸인경우
            // 1. 일단 방향을 바꾼다
            horse[num].dir = dir_change(go_horse.dir);
            go_horse.dir = horse[num].dir;
            // 2. 방향 바꾸고 새로 이동한 칸이 범위를 벗어나거나 블루 칸 인경우
            int blue_x = go_horse.x+dx[go_horse.dir];
            int blue_y = go_horse.y+dy[go_horse.dir];
            if(!isRange(blue_x,blue_y) || map[blue_x][blue_y]==2) {
                return ;
            }
            // 3. 방향 바꾸고 새로 이동한 칸이 블루 칸이 아닌경우
            if(map[blue_x][blue_y]==0) {
                white(blue_x,blue_y,map_x,map_y);
            }
            else {
                red(blue_x,blue_y,map_x,map_y);
            }
            
        }
        else if(map[nx][ny] ==0) {
            white(nx,ny,map_x,map_y);
        }
        else if(map[nx][ny]==1) {
            red(nx,ny,map_x,map_y);
        }
    }
    public static void blue(int nx, int ny, int map_x, int map_y) { 
    	//파란색인 경우에는 A번 말의 이동 방향을 반대로 하고 한 칸 이동한다. 방향을 반대로 한 후에 이동하려는 칸이 파란색인 경우에는 이동하지 않고 방향만 반대로 바꾼다.
        int size = map_horse_info[map_x][map_y].size();
        for(int i=0; i<size; i++) {
            int horse_num = map_horse_info[map_x][map_y].remove(0);
            map_horse_info[nx][ny].add(horse_num);
            horse[horse_num].x = nx;
            horse[horse_num].y= ny;
        }
    }
    public static void red(int nx, int ny, int map_x, int map_y) {
    	//빨간색인 경우에는 이동한 후에 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다
        ArrayList<Integer>tmp = new ArrayList<>();
        int size = map_horse_info[map_x][map_y].size()-1;
        for(int i=size; i>=0; i--) {
            int horse_num = map_horse_info[map_x][map_y].remove(i);
            tmp.add(horse_num);
        }
        for(int i=0; i<tmp.size(); i++) {
            int horse_num = tmp.get(i);
            horse[horse_num].x = nx;
            horse[horse_num].y= ny;
            map_horse_info[nx][ny].add(horse_num);
        }
    }
    public static void white(int nx, int ny, int map_x, int map_y) {  
    	//흰색인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다
        int size = map_horse_info[map_x][map_y].size();
        for(int i=0; i<size; i++) {
            int horse_num = map_horse_info[map_x][map_y].remove(0);
            map_horse_info[nx][ny].add(horse_num);
            horse[horse_num].x = nx;
            horse[horse_num].y= ny;
        }
    }
    public static boolean isRange(int x, int y) {
        if(x>=1 && y>=1 && x<=n && y<=n) {
            return true;
        }
        return false;
    }
    public static int dir_change(int dir) {
        if(dir ==1) {
            return 2;
        }
        if(dir==2) {
            return 1;
        }
        if(dir==3) {
            return 4;
        }
        if(dir==4) {
            return 3;
        }
        return 10000;
    }
    public static boolean isGoPossible(int x, int y, int num) { 
    	//첫번째로 움직일 수 있는 말인지 위에쌓여있으면 못간다.
        if(map_horse_info[x][y].get(0) == num) {
            return true;
        }
        return false;
    }
}
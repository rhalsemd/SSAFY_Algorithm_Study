package baekjoon_20220802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_3613 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int flag = 3;
        
        if(arr[0] < 'a' || arr[0] > 'z') {
            flag = 0;
        } else {            
            for(int i = 1; i < arr.length; i++) {
                char c = arr[i];
                if(c == '_') {
                    // _
                    if(flag == 1) {
                        flag = 0;
                        break;
                    } else {
                        if(i == arr.length - 1) {
                            flag = 0;
                            break;
                        }
                        else if(arr[i+1] == '_') {
                            flag = 0;
                            break;
                        } else {
                            flag = 2;
                        }
                    }
                } else if(c >= 'A' && c <= 'Z') {
                    if(flag == 2) {
                        flag = 0;
                        break;
                    } else {
                        flag = 1;
                    }
                }
            }
        }
        if(flag == 0) {
            System.out.println("Error!");
        } else if(flag == 1) {
            convertToC(arr);
        } else if(flag == 2) {
            convertToJava(arr);
        } else {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            System.out.println(sb.toString());
        }
        
        return;
    }
 
    private static void convertToJava(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(c == '_') {
                i++;
                sb.append((char)(arr[i] - 32));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        return;
    }
 
    private static void convertToC(char[] c_arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < c_arr.length; i++) {
            char c = c_arr[i];
            if(c >= 'A' && c <= 'Z') {
                sb.append('_');
                sb.append((char)(c + 32));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        return;
    }
}

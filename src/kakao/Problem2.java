package kakao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2 {
	static int m, n;
	static int[][] city_map;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());

		city_map = new int[m][n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		/* Enter Input */
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				city_map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}

}

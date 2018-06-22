package kakao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1 {
	static int m, n;
	static int[][] picture;

	public static void main(String[] args) throws Exception {
		int[] check = new int[m * n];
		int k = 0, count = 0, max = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		picture = new int[m][n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		/* Enter Input */
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				picture[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/* recursive flood_fill */
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				check[k] = flood_fill(i, j, picture[i][j]);
				k++;
			}
		}
		for (int i = 0; i < k; i++) {
			if (check[i] == 0)
				continue;
			else {
				if (max < check[i])
					max = check[i];
				count++;
			}
		}
		System.out.println(count + ", " + max);
	}

	public static int flood_fill(int i, int j, int color) {
		int sum = 0;
		if (color == 0) {
			return 0;
		}
		if (j > 0 && color == picture[i][j - 1]) { // check array's left
			picture[i][j] = 0;
			sum = sum + flood_fill(i, j - 1, color);
		}
		if (i < m - 1 && color == picture[i + 1][j]) { // check array's bottom
			picture[i][j] = 0;
			sum = sum + flood_fill(i + 1, j, color);
		}
		if (i > 0 && color == picture[i - 1][j]) { // check array's above
			picture[i][j] = 0;
			sum = sum + flood_fill(i - 1, j, color);
		}
		if (j < n - 1 && color == picture[i][j + 1]) { // check array's right
			picture[i][j] = 0;
			sum = sum + flood_fill(i, j + 1, color);
		}
		picture[i][j] = 0;
		return sum + 1;
	}
}

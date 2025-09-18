package daily.daily_0918;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();

		// 입력 및 집계
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				String word = st.nextToken();
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append("(Iterator 순회)\n");
		Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
		}

		sb.append("(Stream 정렬)\n");
		map.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEach(e -> sb.append(e.getKey()).append("=").append(e.getValue()).append("\n"));

		// 선택 심화: 최다 등장 단어
		Optional<Map.Entry<String, Integer>> maxEntry = map.entrySet().stream().max(Map.Entry.comparingByValue());
		sb.append("최다 등장 단어: ");
		if (maxEntry.isPresent()) {
			sb.append(maxEntry.get().getKey())
			  .append(" (")
			  .append(maxEntry.get().getValue())
			  .append("회)\n");
			
		}

		// 선택 심화: 단어 길이 평균
		double avgLen = map.keySet().stream().mapToInt(String::length).average().orElse(0.0);
		sb.append("단어 길이 평균: ").append(String.format("%.2f", avgLen)).append("\n");

		System.out.print(sb.toString());
	}
}

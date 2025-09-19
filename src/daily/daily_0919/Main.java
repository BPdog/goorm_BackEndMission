package daily.daily_0919;

import java.io.*;
import java.util.*;

public class Main {
	//심화 C
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Integer, String> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			String[] parts = line.split(" ");
			String cmd = parts[0];

			switch (cmd) {
			case "ADD":
				// "ADD "다음의 공백문자 위치
				int firstSpace = line.indexOf(' ', 4);
				int addId = Integer.parseInt(line.substring(4, firstSpace));
				String name = line.substring(firstSpace + 1);

				if (map.containsKey(addId)) {
					sb.append("이미 존재하는 회원입니다\n");
				} else {
					map.put(addId, name);
					sb.append("회원 등록 완료: ").append(addId).append(" - ").append(name).append('\n');
				}
				break;
			case "GET":
				int getId = Integer.parseInt(parts[1]);
				if (map.containsKey(getId)) {
					sb.append("조회 결과: ").append(map.get(getId)).append('\n');
				} else {
					sb.append("회원 없음\n");
				}
				break;
			case "DELETE":
				int delId = Integer.parseInt(parts[1]);
				if (map.containsKey(delId)) {
					map.remove(delId);
					sb.append("삭제 완료\n");
				} else {
					sb.append("삭제할 회원 없음\n");
				}
				break;
			case "LIST":
				sb.append("전체 회원:\n");
				for (Map.Entry<Integer, String> e : map.entrySet()) {
					sb.append(e.getKey()).append(" : ").append(e.getValue()).append('\n');
				}
				break;
			default:
				sb.append("알 수 없는 명령\n");
			}
		}
		System.out.print(sb);
	}
}

package daily.daily_0919;

import java.io.*;
import java.util.*;

public class Main2 {
	//심화 A, B
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Integer, Member> map = new HashMap<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			String[] parts = line.split(" ", 4);
			String cmd = parts[0];

			switch (cmd) {
			case "ADD":
				int addId = Integer.parseInt(parts[1]);
				String name = parts[2];
				String email = parts[3];
				if (map.containsKey(addId)) {
					sb.append("이미 존재하는 회원입니다\n");
				} else {
					map.put(addId, new Member(addId, name, email));
					sb.append("회원 등록 완료: ").append(addId).append(" - ").append(name).append(", ").append(email)
							.append('\n');
				}
				break;
			case "GET":
				int getId = Integer.parseInt(parts[1]);
				Member m = map.get(getId);
				if (m != null) {
					sb.append("조회 결과: ").append(m.name).append(", ").append(m.email).append('\n');
				} else {
					sb.append("회원 없음\n");
				}
				break;
			case "DELETE":
				int delId = Integer.parseInt(parts[1]);
				if (map.remove(delId) != null) {
					sb.append("삭제 완료\n");
				} else {
					sb.append("삭제할 회원 없음\n");
				}
				break;
			case "UPDATE":
				int updId = Integer.parseInt(parts[1]);
				String newName = parts[2];
				Member mm = map.get(updId);
				if (mm != null) {
					mm.name = newName;
					sb.append("수정 완료: ").append(updId).append(" - ").append(newName).append('\n');
				} else {
					sb.append("수정할 회원 없음\n");
				}
				break;
			case "LIST":
				sb.append("전체 회원:\n");
				for (Member member : map.values()) {
					sb.append(member.id).append(" : ").append(member.name).append(", ").append(member.email)
							.append('\n');
				}
				break;
			default:
				sb.append("알 수 없는 명령\n");
			}
		}
		System.out.print(sb);
	}
}
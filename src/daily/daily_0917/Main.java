package daily.daily_0917;

import java.util.*;

public class Main {
	static void test1() {
		List<String> members = new ArrayList<>();
		// 회원 추가
		members.add("홍길동");
		members.add("임꺽정");
		members.add("김철수");
		members.add("이영희");
		members.add("아무개");

		// 전체 회원 목록
		System.out.print("회원 추가: ");
		System.out.println(String.join(", ", members));
		System.out.println("전체 회원 목록: \n" + members);

		// 검색
		String searchName = "김철수";
		if (members.contains(searchName)) {
			System.out.println("검색: \"" + searchName + "\" → 존재합니다.");
		} else {
			System.out.println("검색: \"" + searchName + "\" → 존재하지 않습니다.");
		}

		// 삭제
		members.remove("임꺽정");
		System.out.println("삭제: \"임꺽정\"");
		System.out.println("전체 회원 목록: \n" + members);

		Collections.sort(members);
		System.out.println("오름차순 정렬: " + members);

	}

	static void test2() {
		// 회원 추가
		List<Member> members = new ArrayList<Member>();
		members.add(new Member("홍길동", 20, "hong@email.com"));
		members.add(new Member("임꺽정", 21, "lim@email.com"));
		members.add(new Member("김철수", 22, "kim@email.com"));
		members.add(new Member("이영희", 21, "lee@email.com"));
		members.add(new Member("아무개", 25, "ah@email.com"));

		System.out.println("전체 회원 목록: \n" + members);

		// 검색
		String searchName = "김철수";
		boolean found = false;
		for (Member m : members) {
			if (m.name.equals(searchName)) {
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("검색: \"" + searchName + "\" → " + "존재합니다.");
		} else {
			System.out.println("검색: \"" + searchName + "\" → " + "존재하지 않습니다.");
		}

		// 삭제
		members.removeIf(m -> m.name.equals("임꺽정"));
		System.out.println("삭제: \"임꺽정\"");
		System.out.println("전체 회원 목록: " + members);

		// 오름차순 정렬(이름 기준)
		members.sort(Comparator.comparing(member -> member.name));
		System.out.println("오름차순 정렬: " + members);
	}

	public static void main(String[] args) {
		test2();
	}
}

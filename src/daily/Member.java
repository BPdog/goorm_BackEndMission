package daily;

public class Member {
	private String name;
	private int age;

	public Member() {
	}

	public void registerMember(String name, int age) throws InvalidNameException, InvalidAgeException {
		System.out.printf("회원 등록: %s, 나이: %d →", name, age);
		this.name = name;
		this.age = age;
		
		if (name == null || name.trim().isEmpty()) {
			throw new InvalidNameException("이름은 비어 있을 수 없습니다.");
		}
		if (age < 0) {
			throw new InvalidAgeException("나이는 음수일 수 없습니다.");
		}
		if (age > 150) {
			throw new InvalidAgeException("나이가 비정상적으로 큽니다.");
		}

		System.out.println("정상 등록 완료");
		
	}
}

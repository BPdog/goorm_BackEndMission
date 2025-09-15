package daily.daily_0915;

public class Member {
	private String name;
	private int age;

	private static final int MIN_AGE = 0;
	private static final int MAX_AGE = 150;
	private static final String NAME_PATTERN = "^[가-힣a-zA-Z\\s]+$";

	public Member() {
	}
	void validateName(String name) throws InvalidNameException {
		if (name == null || name.trim().isEmpty()) {
			throw new InvalidNameException("이름은 비어 있을 수 없습니다.");
		}
		if (!name.matches(NAME_PATTERN)) {
			throw new InvalidNameException("이름은 한글 또는 영어 문자만 사용할 수 있습니다.");
		}
    }
	void validateAge(int age) throws InvalidNameException {
		if (age < MIN_AGE) {
			throw new InvalidAgeException("나이는 음수일 수 없습니다.");
		}
		if (age > MAX_AGE) {
			throw new InvalidAgeException("나이가 비정상적으로 큽니다.");
		}
    }
	
	public void registerMember(String name, int age) throws InvalidNameException, InvalidAgeException {
		System.out.printf("회원 등록: %s, 나이: %d →", name, age);
		validateName(name);
		validateAge(age);
		
		
		
		this.name = name;
		this.age = age;

		System.out.println("정상 등록 완료");

	}
}

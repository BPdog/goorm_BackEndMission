package daily.daily_0917;

public class Member {
	String name;
	int age;
	String email;

	public Member(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("%s(나이: %d, 이메일: %s)", name, age, email);

	}
}

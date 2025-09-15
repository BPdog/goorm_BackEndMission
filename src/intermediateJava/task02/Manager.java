package intermediateJava.task02;

public class Manager extends Employee {
	private String rank;

	public Manager(String name, int salary, String rank) {
		super(name, salary);
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "관리자: 이름=" + name + ", 급여=" + salary + ", 직책=" + rank;
	}
}

package intermediateJava.task02;

public class Employee {
	// 관리자 클래스에서 사용할 수 있게 protected
	protected String name;
	protected int salary;

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "직원: 이름=" + name + ", 급여=" + salary;
	}
}

package intermediateJava.task02;

public class Main {
	public static void main(String[] args) {
		Employee employee = new Employee("홍길동", 3000);
		Manager manager = new Manager("안영진", 5000, "팀장");
		System.out.println(employee);
		System.out.println(manager);
	}
}

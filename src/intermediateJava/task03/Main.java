package intermediateJava.task03;

public class Main {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[3];
		shapes[0] = new Circle(5);
		shapes[1] = new Rectangle(4, 5);
		shapes[2] = new Triangle(6, 5);

		String[] names = { "원", "사각형", "삼각형" };
		for (int i = 0; i < shapes.length; i++) {
			System.out.printf("%s=%.2f\n", names[i], shapes[i].getArea());
		}
	}
}

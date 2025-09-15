package daily;

public class MemberMain {
    public static void main(String[] args) {
        Member member = new Member();

        try {
            member.registerMember("홍길동", 25);
        } catch (InvalidNameException | InvalidAgeException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            member.registerMember("아무개", -5);
        } catch (InvalidNameException | InvalidAgeException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            member.registerMember("김철수", 200);
        } catch (InvalidNameException | InvalidAgeException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}

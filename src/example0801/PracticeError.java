package example0801;




public class PracticeError {

    /*

     에러(Error) 하드웨어 문제 , 예외(Exception) 잘못된 코딩

     예외
     1.일반 예외(컴파일 체크 예외) : 실행되기 전에 알수있음.
     2.실행 예외(런타입 예외) : 실행되기 전에 알수없음.

     일반 예외와 실행 예외 클래스를 구별하는 방법은 일반 예외는 Exception을 상속받지만
     RuntimeException을 상속받지 않는 클래스들입니다.

     실행 예외는 다음과 같이 일반예외와 같이 Exception을 상속받지만 Exception을 상속받은
     java.lang.RuntimeException의 상속받는 예외들을 실행 예외의 클래스들입니다.

     */
    public static void main(String[] args) {
        try{
            String menu = null;
            menu.substring(0,3);
            System.out.println("메뉴가 입력 되었습니다.");

        }catch (NullPointerException e){
            System.out.println("메뉴가 입력되지 않았습니다.");
        }
    }
}


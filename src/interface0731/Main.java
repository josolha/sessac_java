package interface0731;

public class Main{
    public static void main(String[] args) {

        //1.인터페이스 구현체를 사용해 출력
        UseInterFaceImpl useInterFaceImpl = new UseInterFaceImpl();
        System.out.println("++++++구현체사용++++++");
        useInterFaceImpl.printMessage();
        System.out.println();

        //2.구현체 사용하지 않고 인터페이스 직접 호출로 사용 (익명 객체)
        UseInterFace useInterFace = new UseInterFace() {
            @Override
            public void printMessage() {
                System.out.println("구현체를 사용하지 않고 오버라이드");
            }
        };
        System.out.println("++++++직접호출++++++");
        useInterFace.printMessage();
        System.out.println();


        //3. 2번 문제 람다식으로 변경
        System.out.println("++++++람다식으로하기++++++");
        UseInterFace useInterFace2 = () -> System.out.println("구현체를 사용하지 않고 오버라이드");
        useInterFace.printMessage();
        System.out.println();


        //4. 인터페이스 주입 (생성자, setter) -> 확장성과 재사용성을 위해 구현 클래스에 의존하는 대신 인터페이스에 의존하도록 코드를 작성

            //4-1.생성자 주입 -> 결합도를 낮춤으로 객체지향을 따른 제일 좋은 사용법

            System.out.println("++++++생성자 주입++++++");
            // UseInterFace 인터페이스의 구현체인 UseInterFaceImpl 객체를 생성하고 그 참조를 useInterFace3과 userInterFace4에 저장
            UseInterFace useInterFace3 = new UseInterFaceImpl();
            UseInterFace useInterFace4 = new UseInterFaceImpl2();


            //UseInterFaceInjection 객체를 생성하면서, 위에서 생성한 useInterFace3, userInterFace4 객체를 생성자를 통해 주입
            //이렇게하면 UseInterFaceInjection는 userInterFace 추상화에 의존하게 됨으로써 개방-폐쇠 원칙(OCP)을 지킴
            //UseInterFaceInjection uj = new UseInterFaceInjection(useInterFace3);
            UseInterFaceInjection uj = new UseInterFaceInjection(useInterFace4);

            // uj 객체에서 printMessage 메소드를 호출.
            // 이 메소드 내부에서는 useInterFace3 or userInterFace4 객체의 printMessage가 호출됨
            uj.printMessage();
            System.out.println();

            //4-2.setter 주입 -> 안좋음 걍 쓰지마셈

            /*
                문제점 :
                    1.불완전한 객체 생성 가능성
                    2.불변성 보장이 어려움 : 위에서 setter 를 통해 바꿔끼면 변하기 때문에

                따라서 생성자 주입만 쓰자!!
            */

            System.out.println("++++++setter 주입++++++");
            UseInterFace useInterFace5 = new UseInterFaceImpl();
            UseInterFace useInterFace6 = new UseInterFaceImpl2();

            UserInterFaceInjection2 uj2 = new UserInterFaceInjection2();
            // 아직 의존성이 주입되지 않았으므로, 이 시점에서 printMessage를 호출하면 문제가 발생한다.
            uj2.setUseInterFace(useInterFace5); // setter를 통해 의존성 주입
            uj2.printMessage();

            UserInterFaceInjection2 uj3 = new UserInterFaceInjection2();
            // 아직 의존성이 주입되지 않았으므로, 이 시점에서 printMessage를 호출하면 문제가 발생한다.
            uj3.setUseInterFace(useInterFace6); // setter를 통해 의존성 주입
            uj3.printMessage();

    }


}

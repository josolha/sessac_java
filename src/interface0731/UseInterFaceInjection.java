package interface0731;


public class UseInterFaceInjection implements UseInterFace{
    private final UseInterFace useInterFace;


    //생성자 주입
    public UseInterFaceInjection(UseInterFace useInterFace) {
        this.useInterFace = useInterFace;
    }

    @Override
    public void printMessage() {
        this.useInterFace.printMessage();
    }

}

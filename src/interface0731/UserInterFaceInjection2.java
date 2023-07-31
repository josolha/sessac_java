package interface0731;

public class UserInterFaceInjection2 implements UseInterFace {
    private UseInterFace useInterFace;

    public UserInterFaceInjection2() {
    }

    // Setter 주입
    public void setUseInterFace(UseInterFace useInterFace) {
        this.useInterFace = useInterFace;
    }

    @Override
    public void printMessage() {
        this.useInterFace.printMessage();
    }
}








package example0810.ott;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<String> showList;

    public static void main(String[] args) {

        OTTCenter ottCenter = new OTTCenter();

        System.out.println("유저생성");
        System.out.println("유저 ID를 입력해주세요");
        int userId = userinput();
        System.out.println("유저 이름을 입력해주세요");
        String userName = userinputString();
        User user = new User(userId, userName);


        while (true) {
            initShowList();
            printShowList();
            int listNumber = userinput();

            List<Contents> currentContentsList = null;
            switch (listNumber) {
                case 1:
                    currentContentsList = ottCenter.contentsRank();
                    break;
                case 2:
                    currentContentsList = ottCenter.showMovieList();
                    break;
                case 3:
                    currentContentsList = ottCenter.showSeriesList();
                    break;
                case 4:
                    currentContentsList = ottCenter.showWishList(user);
                    continue;
            }

            if (currentContentsList != null) {
                ottCenter.printContents(currentContentsList);
                int detailNumber = userinput();
                Map<String, Object> resultMap = ottCenter.printContentsDetails(detailNumber, currentContentsList);
                Contents selectedContent = (Contents) resultMap.get("contents");
                selectedContent.setOnWish(user);
                int playNumber = userinput();
                if (playNumber == 0) {
                    selectedContent.addWish();
                } else {
                    ottCenter.playMedia(playNumber, resultMap);
                }

            }
        }
    }

    private static int userinput(){
        return scanner.nextInt();
    }
    private static String userinputString(){
        return scanner.next();
    }

    private static void printShowList() {
        System.out.println("=========OTT==========");
        for (int i = 0; i < showList.size() ; i++) {
            System.out.println((i+1)+". "+showList.get(i));
        }
        System.out.println("======================");
    }

    private static void initShowList(){
        showList = new ArrayList<>();
        showList.add("컨텐츠 순위");
        showList.add("영화 컨텐츠");
        showList.add("시리즈 컨텐츠");
        showList.add("관심목록 컨텐츠");
    }

}

package example0814;

import java.util.Map;
import java.util.Scanner;

public class TestEMS {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        EmployeeMGR employeeMGR = new EmployeeMGR();

            while (true) {
                initPrint();
                int choice = sc.nextInt();
                if (choice == 1) {
                    registerMember(employeeMGR);
                } else if (choice == 2) {
                    listMember(employeeMGR);
                } else if (choice == 3) {
                    detailMember(employeeMGR);
                } else if (choice == 4) {
                    updateMember(employeeMGR);
                } else if (choice == 5) {
                    deleteMember(employeeMGR);
                }else if(choice == 6){
                    searchMemberByName(employeeMGR);
                }
                else if (choice == 7) {
                    System.out.println("종료 합니다.");
                    break;
                }
            }
    }

    private static void searchMemberByName(EmployeeMGR employeeMGR) {
        System.out.println("======찾으시려는 회원 이름을 입력해주세요=======");
        String searchName = sc.next();
        Map<Integer,Employee> searchedByName = employeeMGR.searchByName(searchName);
        if (searchedByName.size() == 0) {
            System.out.println("해당 검색과 일치하는 회원이 없습니다.");
        }else{
            for (Map.Entry<Integer, Employee> entry : searchedByName.entrySet()) {
                System.out.println("(" + entry.getKey() + ")" + entry.getValue().toStringForOne());
            }
        }
        System.out.println("==========================================\n");
    }

    private static void updateMember(EmployeeMGR employeeMGR) {
        try {
            System.out.println("======수정을 원하는 번호를 입력해주세요=======");
            int updateNumber = sc.nextInt();
            System.out.println("변경하실 휴대폰 번호를 입력해주세요");
            String changePhoneNum = sc.next();
            System.out.println("변경하실 주소를 입력해주세요");
            String changeAddr = sc.next();
            employeeMGR.update(updateNumber, changePhoneNum, changeAddr);
            System.out.println("변경이 완료되었습니다.");
            System.out.println("========================================\n");
        }catch (CustomException e){
            System.out.println(e.getMessage());
        }
    }

    private static void detailMember(EmployeeMGR employeeMGR)  {
        try {
            System.out.println("=======상세보기를 원하는 회원번호를 입력해주세요=======");
            int detailNumber = sc.nextInt();
            Map<Integer, Employee> oneEmployee = employeeMGR.selectOne(detailNumber);
            for (Map.Entry<Integer, Employee> entry : oneEmployee.entrySet()) {
                System.out.println("(" + entry.getKey() + ")" + entry.getValue().toStringForOne());
            }
            System.out.println("===============================================\n");
        }catch (CustomException e){
            System.out.println(e.getMessage());
        }
    }

    private static void deleteMember(EmployeeMGR employeeMGR) {
        try {
            System.out.println("========삭제할 회원번호를 입력해주세요=========");
            int deleteNumber = sc.nextInt();
            employeeMGR.delete(deleteNumber);
            System.out.println("================================\n");
        }catch (CustomException e){
            System.out.println(e.getMessage());
        }
    }

    private static void listMember(EmployeeMGR employeeMGR) {
        System.out.println("===========전체 회원 목록=============");
        Map<Integer, Employee> allEmployees = employeeMGR.selectAll();
        if (allEmployees.size() == 0) {
            System.out.println("보여 줄 회원 정보가 없습니다");
        } else {
            for (Map.Entry<Integer, Employee> entry : allEmployees.entrySet()) {
                System.out.println("(" + entry.getKey() + ")" + entry.getValue().toStringForTotal());
            }
        }
        System.out.println("================================\n");
    }

    private static void registerMember(EmployeeMGR employeeMGR) {
        System.out.println("===========회원 등록=============");
        System.out.print("이름을 입력해주세요 : ");
        String name = sc.next();
        try {
            System.out.print("사번을 입력해주세요 : ");
            int sabun = sc.nextInt();
            employeeMGR.validationSabun(sabun);
            System.out.print("핸드폰 번호를 입력해주세요 : ");
            String phone = sc.next();
            System.out.print("주소를 입력해주세요 : ");
            String addr = sc.next();
            employeeMGR.insert(name, sabun, phone, addr);
            System.out.println("================================\n");
        }catch (CustomException e){
            System.out.println(e.getMessage());
        }
    }
    private static void initPrint() {
        System.out.println("=========원하시는 기능을 선택해주세요=========\n" +
                "1 : 회원 등록 \n" +
                "2 : 회원 목록 \n" +
                "3 : 회원 상세 \n" +
                "4 : 회원 수정 \n" +
                "5 : 회원 삭제 \n" +
                "6 : 회원 검색 \n" +
                "7 : 종료 \n" +
                "==========================================");
    }
}

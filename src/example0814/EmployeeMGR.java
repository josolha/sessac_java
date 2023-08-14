package example0814;

import java.util.HashMap;
import java.util.Map;

public class EmployeeMGR {

    private Map<Integer,Employee> db = new HashMap<>();
    private int autoIncrement = 0;

    public void insert(String name, int sabun, String phone, String addr){
        autoIncrement++;
        db.put(autoIncrement,new Employee(name,sabun,phone,addr));
    };
    public Map<Integer,Employee> selectAll(){
        return db;
    }
    public void delete(int number) throws CustomException {
        Employee employee = db.get(number);
        if(employee == null){
            throw new CustomException("해당 번호와 일치하는 사원 번호가 없습니다.",103);
        }
        db.remove(number);
    };
    public Map<Integer,Employee> selectOne(int number) throws CustomException {
        Employee employee = db.get(number);
        if(employee == null){
            throw new CustomException("해당 번호와 일치하는 사원 번호가 없습니다.",103);
        }
        Map<Integer, Employee> selectedOne = new HashMap<>();
        selectedOne.put(number, db.get(number));
        return selectedOne;
    }
    public void update(int updateNumber, String changePhoneNum, String changeAddr) throws CustomException {
        Employee employee = db.get(updateNumber);
        if (employee != null) {
            Employee updatedEmployee = new Employee(
                    employee.getName(),
                    employee.getSabun(),
                    changePhoneNum,
                    changeAddr
            );
            db.put(updateNumber, updatedEmployee);
        }else{
            throw new CustomException("해당 번호와 일치하는 사원 번호가 없습니다.",103);
        }

    }
    public void validationSabun(int sabun) throws CustomException{
        for(Map.Entry<Integer,Employee> entry : db.entrySet()){
            if(entry.getValue().getSabun()==sabun){
                throw new CustomException("이미 존재하는 사원번호입니다. 다시 입력 바랍니다.",100);
            }
        }
    }
    public Map<Integer,Employee> searchByName(String searchName) {
        Map<Integer, Employee> searchByName = new HashMap<>();
        for(Map.Entry<Integer,Employee> entry : db.entrySet()) {
            if (entry.getValue().getName().equals(searchName)) {
                searchByName.put(entry.getKey(), entry.getValue());
            }
        }
        return searchByName;
    }
}

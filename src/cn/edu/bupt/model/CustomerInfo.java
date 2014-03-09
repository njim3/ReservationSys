package cn.edu.bupt.model;

public class CustomerInfo {
    private String id;
    private String name;
    private int sex;
    private String age;
    private String nation;
    private String address;
    private String portrait = "";
    
    public CustomerInfo(String aId, String aName, int aSex, String aAge,
            String aNation, String aAddress, String aPortrait) {
        this.id = aId;
        this.name = aName;
        this.sex = aSex;
        this.age = aAge;
        this.nation = aNation;
        this.address = aAddress;
        this.portrait = aPortrait;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSex() {
        return sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getNation() {
        return nation;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPortrait() {
        return portrait;
    }
    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
    
    
}

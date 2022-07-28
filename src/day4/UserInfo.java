package day4;

public class UserInfo {
    private String name;
    private int age;
    private String addr;

    private UserInfo(String name, int age, String addr){
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public static class UserInfoBuilder {
        private String name = "";
        private int age;
        private String addr = "";

        public UserInfoBuilder setName(String name){
            this.name = name;
            return this;
        }

        public UserInfoBuilder setAge(int age){
            this.age = age;
            return this;
        }

        public UserInfoBuilder setAddr(String addr){
            this.addr = addr;
            return this;
        }

        public UserInfo build(){
            return new UserInfo(name, age, addr);
        }
    }

    @Override
    public String toString(){
        return String.format("name: %s, age: %d, addr: %s", name, age, addr);
    }

    public int getNameCount() {
        return this.name.length();
    }
}
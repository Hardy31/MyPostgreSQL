package Lesson3_DAO.model;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;

    private String login;

    private String password;

    public void setRole( User.Role role) {
    this.role = role;
//            new Role(us.getRole().getId(), us.getRole().getName());
//            this.id = id;
//            this.name = name;
    }

    private Role role;

    public void setId( int id){
        this.id = id;
    }

    public void setLogin( String  login){
        this.login = login;
    }
    public void setPassword( String  password){
        this.password = password;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return login.equals(user.login) && password.equals(user.password) && role.equals(user.role);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    @Data
    @AllArgsConstructor
    public static class Role {

        private int id;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        private String name;

        public Role(int id, String name) {
            this.id = id;
            this.name = name;
        }
//        public void setRole(int id , String name) {
////            new Role(us.getRole().getId(), us.getRole().getName());
////            this.id = us.getRole().getId();
////            this.name = us.getRole().getName();
//            this.id = id;
//            this.name = name;
//        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Role)) return false;
            Role role = (Role) o;
            return name.equals(role.name);
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + name.hashCode();
            return result;
        }
    }
}

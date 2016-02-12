package Data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by محمد on 05/02/2016.
 */
@DatabaseTable
public class SignUpModel {
    @DatabaseField(id = true)
    private String email;

    @DatabaseField
    private String passw;

    @DatabaseField
    private String confirmpassword;

    @DatabaseField
    private String phone;

    @DatabaseField
    private String address;

   @DatabaseField
private String gender;
public void setEmail(String email){
this.email=email;
}

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassw() {
        return passw;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }
}


package com.sunquan.glf.beans;

import com.sunquan.glf.support.Support;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = -1012235566028305860L;

    private String userId;

    private String firstName;

    private String lastName;

    private String dataOfBirth;

    private String phoneNum;

    private int age;

    public static User createUserWithId(){
        User user = new User();
        user.userId = Support.generateUUID();
        return user;
    }


}

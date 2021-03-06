package com.xiaozhi.model;

import com.xiaozhi.staticData.MajorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by 小智 on 2017/4/18 0018.
 */
@Data
public class StudentVo implements Serializable{
    private String id;                 //学号
    private String name;               //姓名
    private String password;           //密码
    private Integer sex;               //性别
    private Integer education;         //学位
    private Integer academy;           //学院
    private Integer grade;             //班级
    /**
     * @see com.xiaozhi.staticData.AcademyEnum
     * @see MajorEnum
     * @see com.xiaozhi.staticData.StudentCommonEnum
     */
    private String phoneNumber;         //电话号
    private String peopleId;            //身份证号

    public boolean isIllegal(){
        if (id == null || "".equals(id)) {
            return true;
        } else {
            return false;
        }
    }
}

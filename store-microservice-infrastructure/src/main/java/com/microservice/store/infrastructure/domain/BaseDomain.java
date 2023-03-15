package com.microservice.store.infrastructure.domain;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class BaseDomain {
    //@AutoFill(addFlag = true, addMethod = "userID")
    @Column(nullable = false, unique = true, length = 20)
    private String createUser;

   // @AutoFill(addFlag = true, addMethod = "nowTime")
   @Column(nullable = false, unique = true, length = 20)
    private Date createDt;

   // @AutoFill(addFlag = true, addMethod = "userID", updateFlag = true, updateMethod = "userID")
   @Column(nullable = false, unique = true, length = 20)
    private String updateUser;

   // @AutoFill(addFlag = true, addMethod = "nowTime", updateFlag = true, updateMethod = "nowTime")
   @Column(nullable = false, unique = true, length = 20)
    private Date updateDt;
}

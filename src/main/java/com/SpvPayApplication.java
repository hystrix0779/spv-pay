package com;

import com.alibaba.fastjson.JSON;
import com.icbc.ICBCUserInfoService;
import com.icbc.pojo.dto.InfoAddDto;
import com.icbc.pojo.dto.InfoAddQryDto;
import com.icbc.pojo.vo.ICBCResponse;
import com.icbc.pojo.vo.InfoAdd;
import com.icbc.pojo.vo.InfoAddQry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tony.niu(hystrix0779 @ yeah.net)
 */
@SpringBootApplication
public class SpvPayApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpvPayApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Resource
    ICBCUserInfoService userInfoService;
    @Override
    public void run(String... args) throws Exception {
        List<InfoAddDto> dtoList =new ArrayList<>();
        InfoAddDto user=new InfoAddDto();
        user.setUserId("test");
        user.setUserName("test");
        user.setRoleType(1);
        user.setIdType(1);
        user.setIdNo("622726***********1");
        user.setMobile("12109330111");
        user.setAccNo("6212260*****8279622");
        user.setAccName("ceshihuming");
        user.setBankNo("zhaoshang");
        user.setBankName("zhaoshang");
        user.setAccLof(0);
        user.setAccPcf(2);
        user.setCurrType("001");
        user.setField1("test");
        user.setField2("test");
        user.setField3("test");
        dtoList.add(user);
        user.setRoleType(2);
        dtoList.add(user);
        ICBCResponse<InfoAdd> addResponse = userInfoService.userInfoAdd(dtoList);
        System.out.println(JSON.toJSONString(addResponse));
        InfoAddQryDto dto=new InfoAddQryDto();
        dto.setUserId("test");
        dto.setRoleType(1);
        ICBCResponse<InfoAddQry> qryResponse = userInfoService.userInfoQry(dto);
        System.out.println(JSON.toJSONString(qryResponse));
    }
}

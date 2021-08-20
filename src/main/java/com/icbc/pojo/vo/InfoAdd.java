package com.icbc.pojo.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>客户信息上传</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class InfoAdd {
    /**
     * 二级商户编号
     */
    private String subMerId;
    /**
     * 明细详情
     */
    private List<Detail> details;


    @Getter
    @Setter
    public static class Detail{
        /**
         * 用户编号
         */
        private String userId;
        /**
         * 新增用户 0-上传失败 1-上传成功
         */
        private String status;
        /**
         * 上传结果描述
         */
        private String memo;
    }
}

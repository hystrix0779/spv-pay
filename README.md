# SPV-PAY


------

***项目简介：***

> icbc财智e管接（icbc支付），我们是第一个客户，官方spvdemo使用jsp和eclipse和jdk1.8开发，代码陈旧，于是基于api_client-2.1.0.jar封装一套逻辑，使用jdk11加springBoot，能无痕嵌入到现有springBoot项目，使用Bean管理配置文件，实现快速接入


----------


***使用规范：***
> * 1、使用maven，需要把resources/lib下的api_client-2.1.0.jar发布到本地仓库或者nexus中
> * 2、resources下的icbc-config.yml是配置文件，采用多环境，单环境需要注意com.icbc.config.BeanCreate创建ICBCConfig的bean的时候有所更改
> * 3、测试请到SpvPayApplication的run方法编写


----------

***注意事项：***

**> 我们是第一批接入，肯能官方会有变更，一切以官方文档为准**


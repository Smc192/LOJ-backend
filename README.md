# LOJ（在线判题系统）

## 项目介绍

一个编程题目评测系统。能够根据管理员预设的题目用例对用户提交的代码进行执行和评测。

* 在系统前端，管理员可以创建、管理题目；用户可以自由搜索题目、阅读题目、编写并提交代码。
* 在系统后端，根据管理员设定的题目测试用例在代码沙箱中对代码进行编译、运行、判断输出是否正确。（其中，代码沙箱可以作为独立服务，提供给其他开发者使用）。

## 项目架构设计

该项目由前端 + 后端组成，在后端系统中，根据功能职责，将系统划分为三个关键模块：

* 核心业务后端、校验结果的判题服务、负责编译执行代码的可复用代码沙箱。
* 各模块相互独立，通过 Dubbo-go + Nacos RPC远程调用 技术实现高效协作。


1. 后端服务 (loj-backend) : 负责核心业务，数据库处理
2. 判题服务 (loj-judge-service) : 负责校验结果的
3. 代码沙箱 (loj-code-sandbox) : 负责编译执行代码的
4. 前端服务 (loj-frontend] : 负责提供用户操作界面

## 项目展示

### 题库 && 做题界面

![image](https://aidati-1311237642.cos.ap-shanghai.myqcloud.com/github/OJ_%E5%88%A4%E9%A2%98/LOJ%20%E5%88%A4%E9%A2%98%E7%B3%BB%E7%BB%9F%E4%B8%BB%E9%A1%B5.png)
![image](https://aidati-1311237642.cos.ap-shanghai.myqcloud.com/github/OJ_%E5%88%A4%E9%A2%98/LOJ%20%E5%88%A4%E9%A2%98%E7%B3%BB%E7%BB%9F%E5%81%9A%E9%A2%98%E7%95%8C%E9%9D%A2.png)

### 浏览题目提交 && 提交代码详情界面
![image](https://aidati-1311237642.cos.ap-shanghai.myqcloud.com/github/OJ_%E5%88%A4%E9%A2%98/%E6%B5%8F%E8%A7%88%E9%A2%98%E7%9B%AE%E6%8F%90%E4%BA%A4.png)

### 题目管理界面
![image](https://aidati-1311237642.cos.ap-shanghai.myqcloud.com/github/OJ_%E5%88%A4%E9%A2%98/%E7%AE%A1%E7%90%86%E9%A2%98%E7%9B%AE.png)
![image](https://aidati-1311237642.cos.ap-shanghai.myqcloud.com/github/OJ_%E5%88%A4%E9%A2%98/%E4%BF%AE%E6%94%B9%E9%A2%98%E7%9B%AE.png)

## 业务流程图

![image](https://aidati-1311237642.cos.ap-shanghai.myqcloud.com/github/OJ_%E5%88%A4%E9%A2%98/%E6%A0%B8%E5%BF%83%E4%B8%9A%E5%8A%A1%E6%B5%81%E7%A8%8B%E5%9B%BE.png)

![image](https://aidati-1311237642.cos.ap-shanghai.myqcloud.com/github/OJ_%E5%88%A4%E9%A2%98/%E5%88%A4%E9%A2%98%E6%A8%A1%E5%9D%97%E5%92%8C%E6%B2%99%E7%AE%B1%E6%A8%A1%E5%9D%97.png)

## 做题流程的时序图

![image](https://aidati-1311237642.cos.ap-shanghai.myqcloud.com/github/OJ_%E5%88%A4%E9%A2%98/%E6%97%B6%E5%BA%8F%E5%9B%BE.png)

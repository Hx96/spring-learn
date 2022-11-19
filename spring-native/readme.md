# 实现注解保存日志
* 业务代码：OrderService
* 注解：RecordOperate 注解第三个参数为入参顺序
* 测试类：测试SpringDemo
* 接口: convert 泛型业务DO
# 运行
运行主类输出如下：
```java
保存DO:, OperationLogDO(orderId=2222, localDateTime=2022-11-19T17:53:23.499, desc=保存订单)
保存DO:, OperationLogDO(orderId=33333, localDateTime=2022-11-19T17:53:23.499, desc=修改订单)
```
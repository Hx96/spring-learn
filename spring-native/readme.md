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
# 增加[biz-log](https://github.com/mouzt/mzt-biz-log)
测试输出如下：
```shell
2022-11-19 18:22:38.160  INFO 4030 --- [           main] c.m.l.s.i.DefaultLogRecordServiceImpl    : 【logRecord】log=LogRecord(id=null, tenant=com.hx, type=修改订单, subType=, bizNo=33333, operator=111, action=33333下了一个订单,购买商品「33333」,测试变量「33333」,下单结果:true, fail=false, createTime=Sat Nov 19 18:22:36 CST 2022, extra=, codeVariable={MethodName=updateOrder, ClassName=class com.hx.OrderService})
```
可调试观察堆栈，代理使用不同的代理。
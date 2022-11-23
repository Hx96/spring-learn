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

# 引入测试类
https://mp.weixin.qq.com/s/wQjFlXbK3MqKTUX2TfRR0g
单测方法的实现如果分层清晰，能让代码便于理解，一目了然，同时也能提高后续的CR的效率。
这里我们建议采用given-when-then的三段落结构。

```java
@Test
public void should_returnFalse_when_deleteContent_given_invokeFailed() {
    // given
    Result<Boolean> deleteDocResult = new Result<>();
    deleteDocResult.setEntity(Boolean.FALSE);
    when(docManageService.deleteContentDoc(anyLong())).thenReturn(deleteDocResult);
    when(docManageService.queryContentDoc(anyLong())).thenReturn(new DocEntity());

    // when
    Long contentId = 123L;
    Boolean result = contentService.deleteContent(contentId);

    // then
    verify(docManageService, times(1)).queryContentDoc(contentId);
    verify(docManageService, times(1)).deleteContentDoc(contentId);
    Assert.assertFalse(result);
}

```
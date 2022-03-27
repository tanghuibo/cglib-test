# cglib 使用教程

## 核心概念

### EnHancer

代理对象生成器

### callbacks

拦截回调，调用代理对象时触发

可以设置多个 `callback`，通过 `callbackFilter` 决定没个方法哪个具体 `callback`

callback支持如下类型:

#### MethodInterceptor

对代理方案进行拦截，通过:

proxy.invoke() 调用代理方法。

proxy.invokeSuper() 调用被代理方法。

```java
public Object intercept(Object obj, java.lang.reflect.Method method, Object[] args,
                               MethodProxy proxy) throws Throwable;
```

#### Dispatcher


```java
public Object loadObject() throws Exception;
```

#### FixedValue

代替方法返回

#### LazyLoader

和 `Dispatcher` 类似，`Dispatcher` 的 `loadObject` 执行多次，`LazyLoader` 只执行一次

#### InvocationHandler

和 jdk 动态代理一致

#### ProxyRefDispatcher

和 `Dispatcher` 类似， `loadObject` 多一个参数为代理对象


#### NoOp

无操作，直接调用被代理类的方法

## CglibCoreTest01

场景:

被代理类有无参构造器

步骤:

1. 设置代理类类型
2. 设置 `callback`
3. `enHancer.create` 生成代理对象

## CglibCoreTest01

场景:

当被代理类没有无参构造器时，直接调用 `enHancer.create` 方法会报错(enhancer 不知道如何去创建代理类)

步骤:

1. 提前设置好 `callbackTypes`
2. 生成代理对象
3. 将代理对象强转 `Factory` 方法再 `setCallbacks`


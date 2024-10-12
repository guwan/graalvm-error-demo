解决spring boot native 中使用awt的报错问题

解决方法：

运行jar包，使用native跟踪代理
```shell

&"$env:GRAALVM_HOME\bin\java.exe" -agentlib:native-image-agent=config-output-dir=D:\output\graalvm -jar ./build/libs/graalvm-0.0.1-SNAPSHOT.jar

```
生成 reachability-metadata.json 文件，放入META-INFO/native-image 目录，重新打包就可以了。

直接运行native包
```shell

 ./native/nativeCompile/graalvm.exe

```
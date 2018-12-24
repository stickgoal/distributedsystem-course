# Dockerfile
# 基础镜像
FROM openjdk:8-jdk-alpine

 # 设置工作目录
WORKDIR /tmp


 # 将jar文件拷贝到镜像中
ADD *.jar app.jar


 # 运行时设置JAVA环境参数
ENV JAVA_OPTS="-Duser.timezone=Asia/Shanghai"
ENV spring.profiles.active=docker

 # 端口暴露（推荐不暴露端口，在运行容器时才对端口进行绑定）
# EXPOSE 9702

 #ENTRYPOINT不支持环境变量展开
ENTRYPOINT ["java", "-Duser.timezone=Asia/Shanghai", "-jar", "/tmp/app.jar"]


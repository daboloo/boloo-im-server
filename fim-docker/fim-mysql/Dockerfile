FROM mysql:5.7.23

MAINTAINER gradyjiang "jiangzhongjin@hotmail.com"

ENV LANG C.UTF-8

# 当前父目录
ENV PARENT_DIR ./fim-docker/fim-mysql

# 容器内 mysql 工作目录
ENV CONTAINER_WORK_PATH /usr/local

# 被容器自动执行的目录
ENV AUTO_RUN_DIR /docker-entrypoint-initdb.d

# 初始化数据库的SQL
ENV DDL_SQL V1.0_DDL.sql
ENV DML_SQL V1.0_DML.sql

# 执行SQL的脚本
ENV INSTALL_DATA_SHELL install_data.sh

COPY $PARENT_DIR/$DDL_SQL $CONTAINER_WORK_PATH/

COPY $PARENT_DIR/$DML_SQL $CONTAINER_WORK_PATH/

COPY $PARENT_DIR/$INSTALL_DATA_SHELL $AUTO_RUN_DIR/

RUN chmod a+x $AUTO_RUN_DIR/$INSTALL_DATA_SHELL
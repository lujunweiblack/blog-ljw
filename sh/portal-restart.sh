#!/bin/bash

# 添加脚本中需要的环境变量，否则无效
source /etc/profile
export lsof=/usr/sbin/lsof
export nohup=/usr/bin/nohup

# 查询系统中9002的端口是否在使用
portal=`lsof -i:9002 | wc -l`
if [ "$portal" -gt "0" ];then
  echo "======= portal 存活 ======="
else
# 如果未占用说明已经服务已经关闭，重新启动
   cd /project/portal
   nohup java -jar blog-portal-1.0-SNAPSHOT.jar &
fi
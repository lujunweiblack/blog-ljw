# !/bin/bash

# 添加脚本中需要的环境变量，否则无效
source /etc/profile
export lsof=/usr/sbin/lsof
export nohup=/usr/bin/nohup

# 查询系统中9003的端口是否在使用
manage=`lsof -i:9003 | wc -l`
if [ "$manage" -gt "0" ];then
  echo "======= manage 存活 ======="
else
# 如果未占用说明已经服务已经关闭，重新启动
   cd /project/manage
   nohup java -jar blog-manage-1.0-SNAPSHOT.jar &
fi
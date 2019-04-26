package com.ljw.blog.manage.scheduler.JobTask;

import com.ljw.blog.common.model.SysUser;
import com.ljw.blog.common.tools.DataTools;
import com.ljw.blog.common.tools.SendMail;
import com.ljw.blog.common.vo.JDBCVo;
import com.ljw.blog.common.vo.MailInfo;
import com.ljw.blog.manage.api.UserApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: lujunwei
 * @time: 13:58 2019/4/25
 * @des:
 */
@Slf4j
@Component
public class DataBaseBackup {

    @Autowired
    private UserApi userApi;


    /**
     * Java代码实现MySQL数据库导出
     *
     * @param jdbcVo getIp       MySQL数据库所在服务器地址IP
     * @param jdbcVo getU   进入数据库所需要的用户名
     * @param jdbcVo getP   进入数据库所需要的密码
     * @param jdbcVo getPath   数据库导出文件保存路径
     * @param jdbcVo getFileName   数据库导出文件文件名
     * @param jdbcVo getDataBase 要导出的数据库名
     * @return 返回true表示导出成功，否则返回false。
     * @author GaoHuanjie
     */
    public static boolean exportDatabaseTool(JDBCVo jdbcVo) throws InterruptedException {
        String hostIP = jdbcVo.getIp();
        String userName = jdbcVo.getU();
        String password = jdbcVo.getP();
        String port = jdbcVo.getPort();
        String savePath = jdbcVo.getPath();
        String fileName = jdbcVo.getFileName();
        String databaseName = jdbcVo.getDataBase();
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }

        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));
            String cmd = "mysqldump -h" + hostIP + " -P" + port + " -u" + userName + " -p" + password + " --set-charset=UTF8 " + databaseName;
            Process process = Runtime.getRuntime().exec(cmd);
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            log.info("=============================== Start backing up the database :" + jdbcVo.getDataBase() + " ==============================");
            while ((line = bufferedReader.readLine()) != null) {
                printWriter.println(line);
                log.info(line);

            }
            log.info("=============================== End backup database :" + jdbcVo.getDataBase() + "==============================");
            printWriter.flush();
            if (process.waitFor() == 0) {//0 表示线程正常终止。
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println();
    }

    /**
     * @author: lujunwei
     * @param:
     * @return:
     * @time: 17:40 2019/4/25
     * @des: This is a function
     */
    public void startJob() {
        try {
            String sysDate = new SimpleDateFormat("yyyy-hh-dd").format(new Date());
            JDBCVo jdbcVo = new JDBCVo();
            jdbcVo.setIp("188.131.240.160");
            jdbcVo.setU("root");
            jdbcVo.setPort("33306");
            jdbcVo.setP("rbac_seurity");
            jdbcVo.setPath("/usr/share/nginx/html/backupDatabase/");
            jdbcVo.setFileName("rbac_seurity_" + sysDate + ".sql");
            jdbcVo.setDataBase("rbac_seurity");

            /**
             * rbac_seurity 备份
             *
             * */
            if (exportDatabaseTool(jdbcVo)) {
                log.info("=============== " + jdbcVo.getFileName() + " 数据库备份成功 ===============");
            } else {
                throw new InterruptedException();
            }
            /**
             * blog-sbljdeh 备份
             *
             * */
            jdbcVo.setFileName("blog-sbljdeh_" + sysDate + ".sql");
            jdbcVo.setDataBase("blog-sbljdeh");
            if (exportDatabaseTool(jdbcVo)) {
                log.info("=============== " + jdbcVo.getFileName() + " 数据库备份成功 ===============");
                List<SysUser> sendUsers = userApi.findUserByRoleId();
                MailInfo mailInfo = new MailInfo();
                DataTools.parsingInputFormat(sendUsers, mailInfo);
                mailInfo.setSubject("定时任务自动备份数据库邮件通知");
                mailInfo.setContent("系统管理员\n    您好！您的设定的 <定时任务自动备份数据库程序> 已经执行完毕，且已备份成功。\n 服务器备份路径: \n   /usr/share/nginx/html/backupDatabase/rbac_seurity_"+sysDate+".sql"+"\n   /usr/share/nginx/html/backupDatabase/blog-sbljdeh_"+sysDate+".sql");
                SendMail.send163(mailInfo);
            } else {
                throw new InterruptedException();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.info("=============== 数据库备份失败 ===============");
        }

    }


}

package com.heq.parameter.main;

import com.heq.parameter.dao.RoleDao;
import com.heq.parameter.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class MainApp {

    private static Logger logger = LogManager.getLogger(MainApp.class.getName());

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
            Map<String, String> paramsMap = new HashMap<>(2);
            paramsMap.put("roleName", "me");
            paramsMap.put("note", "te");
            roleDao.findRoleByMap(paramsMap).forEach(x -> {
                System.out.println(x.toString());
            });
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("执行成功!");
    }
}

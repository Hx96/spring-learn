package com.hx;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.IOException;
import java.sql.*;

/**
 * @Author: Sheng Wang
 * @Description:
 * @Date: Created in 2019/2/22
 * @Modified By:
 */
public class ImpalaJdbc {
    public static final String KRB5_CONF = "/Users/project/keytab/krb5.conf";
    public static final String PRINCIPAL = "impala/dev@xxx";
    public static final String KEYTAB = "/Users/project/keytab/impala.keytab";
    public static final String URL = "jdbc:hive2://localhost:21050/default;principal=impala/_HOST@xxx";

    private static String HIVE_DRIVER = "org.apache.hive.jdbc.HiveDriver";

    public static void main(String[] args) {
        System.setProperty("java.security.krb5.conf", KRB5_CONF);
        try {
            Configuration conf = new Configuration();
            conf.set("hadoop.security.authentication", "Kerberos");
            UserGroupInformation.setConfiguration(conf);
            UserGroupInformation.loginUserFromKeytab(PRINCIPAL, KEYTAB);
            System.out.println("Login from keytab " + KEYTAB + " successful");

            Class.forName(HIVE_DRIVER);
            Connection conn = DriverManager.getConnection(URL);
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("show databases;");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (IOException e) {
            System.out.println("Login from keytab " + KEYTAB + " failed.");
            e.printStackTrace();
        } catch (ClassNotFoundException ee) {
            System.out.println("Cannot find driver " + HIVE_DRIVER);
            ee.printStackTrace();
        } catch (SQLException eee) {
            System.out.println("SQL execute failed.");
            eee.printStackTrace();
        }
    }
}

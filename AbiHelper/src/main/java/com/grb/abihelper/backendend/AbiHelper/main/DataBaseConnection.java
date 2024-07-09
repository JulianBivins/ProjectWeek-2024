package com.grb.abihelper.backendend.AbiHelper.main;

/*
public class DataBaseConnection {

    public static int MYSQL_DB_NOT_FOUND = 1049;
    /*private void function() {
        var dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
//        dataSource.setUser(System.getenv("MYSQLUSER"));
//        dataSource.setPassword(System.getenv("MYSQLPASS"));


        try (Connection connection = dataSource.getConnection()) {
            System.out.println("connection.isValid(0) = " + connection.isValid(0));

            // CRUD

            // select

            PreparedStatement ps = connection.prepareStatement("select * from USERS where name = ?");
            ps.setString(1, "Marco");

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " - " + resultSet.getString("name"));
            }

            // inserts

            PreparedStatement insertPs = connection.prepareStatement("insert into USERS (name) values (?)");
            insertPs.setString(1, "John");
            int insertCount = insertPs.executeUpdate();
            System.out.println("insertCount = " + insertCount);

            // updates

            PreparedStatement updatePs = connection.prepareStatement("update USERS set name = ? where name = ?");
            updatePs.setString(1, "Johnny");
            updatePs.setString(2, "John");
            int updateCount = updatePs.executeUpdate();
            System.out.println("updateCount = " + updateCount);

            // deletes

            PreparedStatement deletePs = connection.prepareStatement("delete from USERS where name = ?");
            deletePs.setString(1, "Johnny");
            int deleteCount = deletePs.executeUpdate();
            System.out.println("deleteCount = " + deleteCount);


        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}

*/
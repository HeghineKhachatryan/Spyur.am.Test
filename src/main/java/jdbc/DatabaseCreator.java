package jdbc;

import core.JDBCDriverProvider;
import lombok.SneakyThrows;
import pages.SearchPage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabaseCreator {
    Connection connection = JDBCDriverProvider.getJdbcDriver().getConnection();

    public void createDatabase() {
        String creation =
                "create database if not exists searchingResults; use searchingResults; " +
                        "create table if not exists result_data (id bigint primary key unique auto_increment," +
                        "text varchar(255) not null DEFAULT 'NO_TEXT', link varchar(255) not null DEFAULT 'NO_LINK'";
    }

    @SneakyThrows
    public void insertInto(String text, String link) {
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO result_data (text, link) VALUES (?,?)");
        preparedStatement.setString(1, text);
        preparedStatement.setString(2, link);
        preparedStatement.executeUpdate();

    }

    @SneakyThrows
    public void insertIntoTableColumn(String column, String text) {
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO result_data (" + column + ") VALUES (?)");
        preparedStatement.setString(1, text);
        preparedStatement.executeUpdate();
    }

    @SneakyThrows
    public void insertTextById(int id, String text) {
        String url = "UPDATE result_data set text =? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(url);
        preparedStatement.setString(1,text);
        preparedStatement.setInt(2,id);
        preparedStatement.executeUpdate();
    }


}

package com.sda;

import com.sda.dao.CourseDao;
import com.sda.jdbc.JdbcConnectionFactory;
import com.sda.model.Course;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // tworzymy sobie połączenie (ładujemy z konfiguracji [properties])
            JdbcConnectionFactory jdbcConnectionFactory = new JdbcConnectionFactory();

            // pobieramy połączenie z jdbc connection factory
//            Connection connection = jdbcConnectionFactory.getConnection();

//            System.out.println("Closed: " + connection.isClosed());
            CourseDao courseDao = new CourseDao(jdbcConnectionFactory);
            Course course = new Course();

            course.setNazwa("JavaGDA17-2");
            course.setIloscGodzin(360);
            course.setCena(1000000);

            courseDao.insert(course);

            // wypisz
            List<Course> courseList = courseDao.select();
            courseList.forEach(System.out::println);

            courseDao.delete(course);

            // wypisz
            courseList = courseDao.select();
            courseList.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

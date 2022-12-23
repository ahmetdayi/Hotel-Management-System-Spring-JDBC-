package org.cs202.config;

import org.cs202.entity.concretes.HouseKeepingSchedules;
import org.cs202.entity.concretes.Room;
import org.cs202.entity.dto.converter.RoleConverter;
import org.cs202.entity.dto.converter.RoomTypeConverter;
import org.cs202.repository.concretes.BookRepository;
import org.cs202.repository.concretes.HouseKeepingSchedulesRepository;
import org.cs202.repository.concretes.RoomRepository;
import org.cs202.repository.concretes.UserRepository;
import org.cs202.service.BookingService;
import org.cs202.service.HouseKeepingSchedulesService;
import org.cs202.service.RoomService;
import org.cs202.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/hms");
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }
    @Bean
    public BookRepository getBookRepository(){
        return new BookRepository();
    }
    @Bean
    public HouseKeepingSchedulesRepository getHouseKeepingSchedules(){
        return new HouseKeepingSchedulesRepository();
    }
    @Bean
    public RoomRepository getRoomRepository(){
        return new RoomRepository();
    }
    @Bean
    public BookingService getBookingService(){
        return new BookingService();
    }
    @Bean
    public HouseKeepingSchedulesService getHouseKeepingSchedulesService(){
        return new HouseKeepingSchedulesService();
    }
    @Bean
    public RoomService getRoomService(){
        return new RoomService();
    }
    @Bean
    public RoleConverter converter(){
       return new RoleConverter();
    }

    @Bean
    public RoomTypeConverter roomTypeConverter(){
        return new RoomTypeConverter();
    }

    @Bean
    public UserService getUserService(){
        return new UserService();
    }
    @Bean
    public UserRepository getUserRepository(){
        return new UserRepository();
    }
}

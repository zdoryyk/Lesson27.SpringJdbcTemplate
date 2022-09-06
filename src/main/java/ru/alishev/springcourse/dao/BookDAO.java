package ru.alishev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.alishev.springcourse.models.Book;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("select * from Books",new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id){
        return jdbcTemplate.query("select * from Books where id=?",new Object[]{id},new BeanPropertyRowMapper<>(Book.class)).
                stream().findAny().orElse(null);
    }

    public void save(Book book){
        jdbcTemplate.update("insert into Books(name, author, age) VALUES(?,?,?)",book.getName(),book.getAuthor(),book.getAge());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Person SET name=?, author=?, age=? WHERE id=?", updatedBook.getName(),
                updatedBook.getAuthor(),updatedBook.getAge(),id);
    }

    public void delete(int id){
        jdbcTemplate.update("delete from Books where id=?",id);
    }
}